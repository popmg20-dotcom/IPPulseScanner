package com.github.xfalcon.vhosts.util;

import android.util.Log;
import com.ippulse.scanner.VpnEvidenceLogger;

public class LogUtils {
    private static boolean DEBUG = true;

    public static void setDebug(boolean debug) {
        DEBUG = debug;
    }

    public static void v(String tag, String msg) {
        VpnEvidenceLogger.v(tag, msg);
        if (DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        VpnEvidenceLogger.d(tag, msg);
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        VpnEvidenceLogger.i(tag, msg);
        Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        VpnEvidenceLogger.w(tag, msg);
        Log.w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable tr) {
        VpnEvidenceLogger.w(tag, msg, tr);
        Log.w(tag, msg, tr);
    }

    public static void e(String tag, String msg) {
        VpnEvidenceLogger.e(tag, msg);
        Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable tr) {
        VpnEvidenceLogger.e(tag, msg, tr);
        Log.e(tag, msg, tr);
    }
}
