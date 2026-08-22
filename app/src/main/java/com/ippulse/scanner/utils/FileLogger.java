package com.ippulse.scanner.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileLogger {
    private static final String TAG = "IPPulseFileLog";
    private static File logFile;

    public static void init(Context context) {
        if (logFile == null) {
            logFile = new File(context.getFilesDir(), "vpn_log.txt");
        }
    }

    public static void d(String message) {
        String line = "[" + getTime() + "] D: " + message;
        Log.d(TAG, line);
        append(line);
    }

    public static void e(String message, Throwable t) {
        String line = "[" + getTime() + "] E: " + message;
        if (t != null) line += " - " + t.toString();
        Log.e(TAG, line, t);
        append(line);
        if (t != null) {
            appendStackTrace(t);
        }
    }

    private static void appendStackTrace(Throwable t) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {
            t.printStackTrace(writer);
            writer.append("\n");
        } catch (IOException ignored) {}
    }

    private static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        return sdf.format(new Date());
    }

    private static void append(String line) {
        if (logFile == null) return;
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.append(line).append("\n");
        } catch (IOException e) {
            Log.e(TAG, "Cannot write log", e);
        }
    }
}
