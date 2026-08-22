package com.ippulse.scanner.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logger {
    private static final String TAG = "IPPulseVPN";
    private static File logFile;

    public static void init(Context context) {
        if (logFile == null) {
            File dir = context.getExternalFilesDir(null);
            if (dir != null) {
                logFile = new File(dir, "vpn_log.txt");
            }
        }
    }

    public static void d(String message) {
        String line = "[" + getTime() + "] " + message;
        Log.d(TAG, line);
        appendToFile(line);
    }

    public static void e(String message, Throwable t) {
        String line = "[" + getTime() + "] ERROR: " + message;
        if (t != null) line += " - " + t.toString();
        Log.e(TAG, line, t);
        appendToFile(line);
    }

    private static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        return sdf.format(new Date());
    }

    private static void appendToFile(String line) {
        if (logFile == null) return;
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.append(line).append("\n");
        } catch (IOException e) {
            Log.e(TAG, "Cannot write log", e);
        }
    }
}
