package defpackage;

import android.content.SharedPreferences;
import com.getsurfboard.base.ContextUtilsKt;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ko1 {
    public static final ko1 a = new ko1();
    public static final SharedPreferences b = ContextUtilsKt.getContext().getSharedPreferences("geoip_config", 0);
    public static final File c;
    public static final File d;
    public static final File e;
    public static final File f;

    static {
        File file = new File(ContextUtilsKt.getContext().getFilesDir(), "geoip");
        c = file;
        d = new File(file, "temp");
        e = new File(file, "database");
        f = new File(file, "embedded");
    }

    public static void a(InputStream inputStream) throws IOException {
        c.mkdirs();
        File file = d;
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            l72.h(inputStream, fileOutputStream);
            fileOutputStream.close();
            Collections.singletonList("en");
            String str = new ae3(new ip(file), file.getName()).f.d;
            int i = str.contains("GeoIP2-Anonymous-IP") ? pj0.ANONYMOUS_IP.b : 0;
            if (str.contains("GeoLite2-ASN")) {
                i |= pj0.ASN.b;
            }
            if (str.contains("City")) {
                i |= pj0.CITY.b | pj0.COUNTRY.b;
            }
            if (str.contains("GeoIP2-Connection-Type")) {
                i |= pj0.CONNECTION_TYPE.b;
            }
            if (str.contains("Country")) {
                i |= pj0.COUNTRY.b;
            }
            if (str.contains("GeoIP2-Domain")) {
                i |= pj0.DOMAIN.b;
            }
            if (str.contains("Enterprise")) {
                i |= pj0.ENTERPRISE.b | pj0.CITY.b | pj0.COUNTRY.b;
            }
            if (str.contains("GeoIP2-ISP")) {
                i |= pj0.ISP.b;
            }
            if (i != 0) {
                file.renameTo(e);
            } else {
                vp1.n("Invalid attempt to open an unknown database type: ".concat(str));
            }
        } finally {
        }
    }

    public static void b(String str) {
        SharedPreferences sharedPreferences = b;
        sharedPreferences.getClass();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.getClass();
        if (str != null) {
            editorEdit.putString("file_name", str);
            editorEdit.remove(RtspHeaders.Values.URL);
        } else {
            editorEdit.remove("file_name");
        }
        editorEdit.commit();
    }

    public static void c(String str) {
        SharedPreferences sharedPreferences = b;
        sharedPreferences.getClass();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.getClass();
        if (str != null) {
            editorEdit.putString(RtspHeaders.Values.URL, str);
            editorEdit.remove("file_name");
        } else {
            editorEdit.remove(RtspHeaders.Values.URL);
        }
        editorEdit.commit();
    }
}
