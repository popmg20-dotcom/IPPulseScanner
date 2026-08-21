package defpackage;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    */
    public static void h(int i, String str) throws InterruptedException, IOException {
        ArrayList arrayList;
        on2 on2Var;
        t53 t53Var;
        Object next;
        if (e) {
            return;
        }
        if (i == 512 && n12.c(str, ".nomedia")) {
            return;
        }
        int i2 = 8;
        if (str != null && i == 8 && new File(f(), str).length() == 0) {
            return;
        }
        d.i(Boolean.TRUE);
        int i3 = 2;
        String strU = fw.u("onEvent() called with: event = ", i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? i != 64 ? i != 128 ? i != 256 ? i != 512 ? i != 1024 ? i != 2048 ? "unknown" : "MOVE_SELF" : "DELETE_SELF" : "DELETE" : "CREATE" : "MOVED_TO" : "MOVED_FROM" : "OPEN" : "CLOSE_NOWRITE" : "CLOSE_WRITE" : "ATTRIB" : "MODIFY" : "ACCESS", ", path = ", str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strU);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileManager", strU, null);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strA = i73.a();
        bh3 bh3Var = new bh3();
        if (strA == null) {
            c.i(null);
            bh3Var.b = null;
        } else if (g(strA).exists()) {
            File fileG = g(strA);
            SystemClock.elapsedRealtime();
            HashMap map = c63.a;
            SystemClock.elapsedRealtime();
            FileInputStream fileInputStream = new FileInputStream(fileG);
            try {
                String strT = l72.T(new BufferedReader(new InputStreamReader(fileInputStream, y30.a), 8192));
                fileInputStream.close();
                List list = (List) b.d();
                if (list != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : list) {
                        if (obj instanceof t53) {
                            arrayList2.add(obj);
                        }
                    }
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (n12.c(((t53) next).b, strA)) {
                                break;
                            }
                        } else {
                            next = null;
                            break;
                        }
                    }
                    t53Var = (t53) next;
                } else {
                    t53Var = null;
                }
                f0 f0Var = new f0(18, bh3Var);
                HashMap map2 = c63.a;
                SystemClock.elapsedRealtime();
                if (t53Var == null || t53Var.f != strT.hashCode()) {
                    SystemClock.elapsedRealtime();
                    byte[] bytes = strT.getBytes(y30.a);
                    bytes.getClass();
                    Serializable serializableJ = c63.j(strA, new ByteArrayInputStream(bytes), k01.A, t60.Y, vd3.A, null);
                    Throwable thA = uk3.a(serializableJ);
                    if (thA == null) {
                        f0Var.g(((e03) serializableJ).b);
                    } else {
                        String strN = ha0.n("decode selectedProfileFailed: ", thA.getMessage());
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 4, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            a1.e("ProfileManager", strN, null);
                        }
                        c.i(null);
                        bh3Var.b = null;
                    }
                } else {
                    String strConcat = strA.concat(": content not changed, reuse the old one");
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("ProfileManager", strConcat, null);
                    }
                    f0Var.g(t53Var);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    ez4.l(fileInputStream, th);
                    throw th2;
                }
            }
        } else {
            String strO = ha0.o("selected profile ", strA, " is deleted");
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strO);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("ProfileManager", strO, null);
            }
            i73.b(null);
            c.i(null);
            bh3Var.b = null;
        }
        List listSynchronizedList = DesugarCollections.synchronizedList(new ArrayList());
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        File[] fileArrListFiles = f().listFiles(new c73(0));
        if (fileArrListFiles != null) {
            arrayList = new ArrayList(fileArrListFiles.length);
            for (File file : fileArrListFiles) {
                arrayList.add(new xn0(i3, file, bh3Var, listSynchronizedList));
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            executorServiceNewFixedThreadPool.invokeAll(arrayList);
        }
        executorServiceNewFixedThreadPool.shutdown();
        listSynchronizedList.getClass();
        h70.T(listSynchronizedList, a);
        ArrayList arrayList3 = new ArrayList(f70.Q(10, listSynchronizedList));
        Iterator it2 = listSynchronizedList.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((zk) it2.next()).getName());
        }
        for (String str2 : oj0.a.t().a()) {
            if (!arrayList3.contains(str2)) {
                ua3 ua3VarT = oj0.a.t();
                ua3VarT.getClass();
                str2.getClass();
                ke0.r(ua3VarT.a, false, true, new ko0(str2, i2));
            }
        }
        b.i(listSynchronizedList);
        File file2 = new File(ContextUtilsKt.getContext().getFilesDir(), "sft");
        if (file2.exists()) {
            ArrayList<t53> arrayList4 = new ArrayList();
            for (Object obj2 : listSynchronizedList) {
                if (obj2 instanceof t53) {
                    arrayList4.add(obj2);
                }
            }
            ArrayList arrayList5 = new ArrayList();
            for (t53 t53Var2 : arrayList4) {
                ArrayList arrayList6 = t53Var2.J0;
                ArrayList arrayList7 = new ArrayList();
                Iterator it3 = arrayList6.iterator();
                while (it3.hasNext()) {
                    d70.U(fx3.h((tn3) it3.next()), arrayList7);
                }
                Set setKeySet = t53Var2.F0.keySet();
                setKeySet.getClass();
                ArrayList arrayList8 = new ArrayList();
                Iterator it4 = setKeySet.iterator();
                while (it4.hasNext()) {
                    d70.U(((ss1) it4.next()).P(), arrayList8);
                }
                d70.U(d70.m0(arrayList7, arrayList8), arrayList5);
            }
            Set setC0 = d70.C0(arrayList5);
            File[] fileArrListFiles2 = file2.listFiles();
            if (fileArrListFiles2 != null) {
                for (File file3 : fileArrListFiles2) {
                    if (!setC0.contains(file3.getAbsolutePath())) {
                        file3.delete();
                    }
                }
            }
        }
        if (listSynchronizedList.isEmpty()) {
            i73.b(null);
            on2Var = c;
            if (on2Var.d() != null) {
                on2Var.i(null);
            }
        } else {
            Iterator it5 = listSynchronizedList.iterator();
            while (it5.hasNext()) {
                if (((zk) it5.next()) instanceof t53) {
                    if (bh3Var.b == null) {
                        for (Object obj3 : listSynchronizedList) {
                            if (((zk) obj3) instanceof t53) {
                                obj3.getClass();
                                t53 t53Var3 = (t53) obj3;
                                i73.b(t53Var3.b);
                                c.i(t53Var3);
                            }
                        }
                        e04.h("Collection contains no element matching the predicate.");
                        return;
                    }
                }
            }
            i73.b(null);
            on2Var = c;
            if (on2Var.d() != null) {
            }
        }
        String str3 = "decode all profile files spend " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms.";
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileManager", str3, null);
        }
        d.i(Boolean.FALSE);
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
