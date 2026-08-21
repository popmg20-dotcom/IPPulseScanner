package com.getsurfboard.xray;

import android.os.Process;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import defpackage.fy4;
import defpackage.le2;
import defpackage.t4;
import java.io.File;
import java.net.UnknownHostException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class XRay {
    public static final Companion d = new Companion();
    public static volatile XRay e;
    public final HashMap a = new HashMap();
    public volatile boolean b;
    public t4 c;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class Companion {
        public final void onSystemTimeError() throws NoSuchMethodException, UnknownHostException {
            t4 t4Var;
            XRay xRay = XRay.e;
            if (xRay == null || (t4Var = xRay.c) == null) {
                return;
            }
            t4Var.a();
        }
    }

    static {
        System.loadLibrary("xlog");
        System.loadLibrary("xray");
        File file = new File(ContextUtilsKt.getContext().getFilesDir(), "crash/xray_crash.log");
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        nativeInit(absolutePath);
    }

    private static final native void nativeInit(String str);

    private static final native String nativeStart(String str, String str2, boolean z);

    private static final native void nativeStop();

    public static final void onSystemTimeError() throws NoSuchMethodException, UnknownHostException {
        d.onSystemTimeError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0876  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x08e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(java.lang.String r36, java.util.LinkedHashSet r37, boolean r38, boolean r39, boolean r40, boolean r41, defpackage.t53 r42, java.util.HashMap r43) {
        /*
            Method dump skipped, instruction units count: 2501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.xray.XRay.a(java.lang.String, java.util.LinkedHashSet, boolean, boolean, boolean, boolean, t53, java.util.HashMap):java.lang.String");
    }

    public final void b() {
        if (this.b) {
            this.b = false;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "XRay", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "stop xray");
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("XRay", "stop xray", null);
            }
            nativeStop();
        }
        if (e == this) {
            e = null;
        }
    }
}
