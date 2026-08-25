package com.ippulse.scanner;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class VpnEvidenceLogger {

    private static final Object LOCK = new Object();

    private static final String FILE_NAME =
            "IPPulseScanner_vpn_evidence.log";

    private static Context context;
    private static File legacyFile;
    private static Uri mediaUri;

    private static final String[] KEYWORDS = {
            "VPN RUNNING",
            "VPN START",
            "VPN STOP",
            "VPN START FAILED",

            "MTU=",
            "DNS=",
            "HOSTS=",
            "BLOCKS=",

            "TUN PACKET READER START",
            "TUN PACKET READER STOP",
            "TUN WRITER START",
            "TUN WRITER STOP",
            "TUN IPV6 DROPPED",
            "TUN WRITE OK",
            "TUN INVALID",
            "TUN PACKET TOO LARGE",

            "HOST ",

            "TCP SOCKET CREATED",
            "TCP PROTECT OK",
            "TCP PROTECT FAILED",
            "TCP CONNECT QUEUED",
            "TCP PHYSICAL CONNECT START",
            "TCP PHYSICAL CONNECT SUCCESS",
            "TCP PHYSICAL CONNECT FAILED",
            "TCP CONNECTED",
            "TCP SYN-ACK",
            "TCP NON-SYN WITHOUT TCB",
            "RST",

            "UDPOutput PACKET RECEIVED",
            "UDP SOCKET CREATED",
            "UDP CONNECT START",
            "UDP CONNECT SUCCESS",
            "UDP CONNECT FAILED",

            "DNS HOST",
            "DNS UPSTREAM",

            "ICMP ",
            "VPN TRACE:",
            "FALCON_DIAG:",
            "EVIDENCE:",
    };

    private VpnEvidenceLogger() {
    }

    public static void attachContext(Context c) {
        if (c != null) {
            context = c.getApplicationContext();
        }
    }

    public static void init(Context c) {
        synchronized (LOCK) {
            try {
                attachContext(c);

                mediaUri = null;
                legacyFile = null;

                if (android.os.Build.VERSION.SDK_INT >= 29) {

                    ContentResolver resolver =
                            context.getContentResolver();

                    Uri collection =
                            MediaStore.Downloads.getContentUri(
                                    MediaStore.VOLUME_EXTERNAL_PRIMARY
                            );

                    try {
                        resolver.delete(
                                collection,
                                MediaStore.Downloads.DISPLAY_NAME + "=?",
                                new String[]{FILE_NAME}
                        );
                    } catch (Throwable e) {
                        Log.e(
                                "IPV_EVIDENCE",
                                "delete previous evidence failed",
                                e
                        );
                    }

                    ContentValues values = new ContentValues();

                    values.put(
                            MediaStore.Downloads.DISPLAY_NAME,
                            FILE_NAME
                    );

                    values.put(
                            MediaStore.Downloads.MIME_TYPE,
                            "text/plain"
                    );

                    values.put(
                            MediaStore.Downloads.RELATIVE_PATH,
                            Environment.DIRECTORY_DOWNLOADS
                    );

                    values.put(
                            MediaStore.Downloads.IS_PENDING,
                            1
                    );

                    mediaUri = resolver.insert(
                            collection,
                            values
                    );

                    if (mediaUri == null) {
                        throw new IllegalStateException(
                                "MediaStore.Downloads.insert returned null"
                        );
                    }

                    Log.i(
                            "IPV_EVIDENCE",
                            "MediaStore evidence URI=" + mediaUri
                    );

                } else {

                    File download =
                            Environment.getExternalStoragePublicDirectory(
                                    Environment.DIRECTORY_DOWNLOADS
                            );

                    if (download != null) {
                        download.mkdirs();
                        legacyFile =
                                new File(download, FILE_NAME);
                    }
                }

                writeRaw(
                        "=== IPPulseScanner VPN EVIDENCE ===\n"
                                + "START="
                                + timestamp()
                                + "\n"
                );

                if (android.os.Build.VERSION.SDK_INT >= 29
                        && mediaUri != null
                        && context != null) {

                    ContentValues ready =
                            new ContentValues();

                    ready.put(
                            MediaStore.Downloads.IS_PENDING,
                            0
                    );

                    context.getContentResolver().update(
                            mediaUri,
                            ready,
                            null,
                            null
                    );
                }

            } catch (Throwable e) {

                Log.e(
                        "IPV_EVIDENCE",
                        "init failed; mediaUri="
                                + mediaUri
                        ,
                        e
                );
                Log.e("IPV_EVIDENCE", "init failed", e);
            }
        }
    }

    private static boolean wanted(String msg) {

        if (msg == null) {
            return false;
        }

        for (String keyword : KEYWORDS) {
            if (msg.contains(keyword)) {
                return true;
            }
        }

        return false;
    }

    public static void d(String tag, String msg) {
        write(tag, msg);
    }

    public static void i(String tag, String msg) {
        write(tag, msg);
    }

    public static void i(
            String tag,
            String msg,
            Throwable tr
    ) {
        write(
                tag,
                msg + " "
                        + throwableText(tr)
        );
    }

    public static void w(String tag, String msg) {
        write(tag, msg);
    }

    public static void w(
            String tag,
            String msg,
            Throwable tr
    ) {
        write(
                tag,
                msg + " "
                        + throwableText(tr)
        );
    }

    public static void e(String tag, String msg) {
        write(tag, msg);
    }

    public static void e(
            String tag,
            String msg,
            Throwable tr
    ) {
        write(
                tag,
                msg + " "
                        + throwableText(tr)
        );
    }

    private static void write(
            String tag,
            String msg
    ) {

        if (!wanted(msg)) {
            return;
        }

        String line =
                timestamp()
                        + " | "
                        + Thread.currentThread().getName()
                        + " | "
                        + msg
                        + "\n";

        synchronized (LOCK) {
            writeRaw(line);
        }
    }

    private static void writeRaw(
            String text
    ) {

        try {

            if (mediaUri != null && context != null) {

                ContentResolver resolver =
                        context.getContentResolver();

                try (
                        OutputStream out =
                                resolver.openOutputStream(
                                        mediaUri,
                                        "wa"
                                )
                ) {

                    if (out != null) {
                        out.write(
                                text.getBytes("UTF-8")
                        );
                        out.flush();
                        return;
                    }
                }
            }

            if (legacyFile != null) {

                try (
                        FileOutputStream out =
                                new FileOutputStream(
                                        legacyFile,
                                        true
                                )
                ) {

                    out.write(
                            text.getBytes("UTF-8")
                    );

                    out.flush();
                }
            }

        } catch (Throwable e) {
            Log.e(
                    "IPV_EVIDENCE",
                    "writeRaw failed: uri="
                            + mediaUri
                            + " legacy="
                            + legacyFile,
                    e
            );
        }
    }

    private static String throwableText(
            Throwable tr
    ) {

        if (tr == null) {
            return "";
        }

        String message =
                tr.getMessage();

        if (message == null) {
            message = "null";
        }

        return tr.getClass().getName()
                + ": "
                + message;
    }

    private static String timestamp() {

        return new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss.SSS",
                Locale.US
        ).format(new Date());
    }
}
