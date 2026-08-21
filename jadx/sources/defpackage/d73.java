package defpackage;

import android.os.Process;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class d73 {
    public static final e1 a = new e1(16);
    public static final on2 b = new on2(new ArrayList());
    public static final on2 c = new on2(null);
    public static final on2 d = new on2(Boolean.FALSE);
    public static boolean e;

    static {
        f().mkdirs();
        String strN = ha0.n("start watching ", f().getAbsolutePath());
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileManager", strN, null);
        }
        g73.a.startWatching();
        l();
    }

    public static Object a(am1 am1Var, v74 v74Var) {
        on2 on2Var = b;
        on2Var.getClass();
        ge0 ge0Var = null;
        Object objP = ye.p(p95.b(new uv(new hj(on2Var, ge0Var, 16), c41.b, -2, jp.b), -1), new ah0(am1Var, ge0Var, 3), v74Var);
        return objP == mf0.b ? objP : xl4.a;
    }

    public static Object b(String str, v74 v74Var) {
        String strConcat = "cloneProfile: ".concat(str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        ge0 ge0Var = null;
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileManager", strConcat, null);
        }
        gm0 gm0Var = qv0.a;
        return ji0.b0(pl0.z, new p81(str, ge0Var, 6), v74Var);
    }

    public static p12 c(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        return new p12(str, System.currentTimeMillis(), str2.hashCode(), xb5.h((String) d70.e0(p44.B0(str2))), str3);
    }

    public static Object d(String str, v74 v74Var) {
        String strConcat = "deleteProfile: ".concat(str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        ge0 ge0Var = null;
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileManager", strConcat, null);
        }
        gm0 gm0Var = qv0.a;
        Object objB0 = ji0.b0(pl0.z, new p81(str, ge0Var, 7), v74Var);
        return objB0 == mf0.b ? objB0 : xl4.a;
    }

    public static zk e(String str) {
        List list = (List) b.d();
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (n12.c(((zk) next).getName(), str)) {
                obj = next;
                break;
            }
        }
        return (zk) obj;
    }

    public static File f() {
        return new File(ContextUtilsKt.getContext().getFilesDir(), "profiles");
    }

    public static File g(String str) {
        str.getClass();
        return new File(f(), str.concat(".conf"));
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x042b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h(int r27, java.lang.String r28) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1151
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d73.h(int, java.lang.String):void");
    }

    public static Object i(String str, String str2, v74 v74Var) {
        String strU = fw.u("renameProfile: oldName = ", str, ", newName = ", str2);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strU);
        }
        ge0 ge0Var = null;
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileManager", strU, null);
        }
        gm0 gm0Var = qv0.a;
        Object objB0 = ji0.b0(pl0.z, new gd(str, str2, ge0Var, 13), v74Var);
        return objB0 == mf0.b ? objB0 : xl4.a;
    }

    public static Object j(e03[] e03VarArr, ie0 ie0Var) {
        gm0 gm0Var = qv0.a;
        Object objB0 = ji0.b0(pl0.z, new gt(e03VarArr, null, 9), ie0Var);
        return objB0 == mf0.b ? objB0 : xl4.a;
    }

    public static void k(boolean z) {
        String str = "stopListening = " + z;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileManager", str, null);
        }
        e = z;
        if (z) {
            return;
        }
        l();
    }

    public static void l() throws IOException {
        File file = new File(f(), ".nomedia");
        File parentFile = file.getParentFile();
        if ((parentFile != null && parentFile.exists()) || file.mkdirs()) {
            file.delete();
            file.createNewFile();
            return;
        }
        if (fy4.b) {
            Xlog.logWrite2(0L, 4, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "triggerLoading mkdirs failed");
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return;
        }
        a1.e("ProfileManager", "triggerLoading mkdirs failed", null);
    }
}
