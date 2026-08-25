package com.github.xfalcon.vhosts.util;

import android.content.Context;
import android.util.Log;

import com.ippulse.scanner.VpnEvidenceLogger;

public final class LogUtils {

    public static Context context;

    private static void evidence(String tag, String msg) {
        try {
            VpnEvidenceLogger.i(tag, msg);
        } catch (Throwable ignored) {
        }
    }

    public static void v(String tag, String msg) {
        Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        evidence(tag, msg);
        Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        evidence(tag, msg);
        Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        evidence(tag, msg);
        Log.e(tag, msg);
    }

    public static void v(String tag, String msg, Throwable t) {
        Log.v(tag, msg, t);
    }

    public static void d(String tag, String msg, Throwable t) {
        Log.d(tag, msg, t);
    }

    public static void i(String tag, String msg, Throwable t) {
        evidence(tag, msg);
        Log.i(tag, msg, t);
    }

    public static void w(String tag, String msg, Throwable t) {
        evidence(tag, msg);
        Log.w(tag, msg, t);
    }

    public static void e(String tag, String msg, Throwable t) {
        evidence(tag, msg);
        Log.e(tag, msg, t);
    }
}
