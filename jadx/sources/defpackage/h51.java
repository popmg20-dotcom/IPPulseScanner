package defpackage;

import androidx.work.impl.WorkDatabase;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class h51 {
    public static final String a = ue2.i("EnqueueRunnable");

    public static void a(nw4 nw4Var) {
        boolean z;
        xw4 xw4Var = nw4Var.a;
        HashSet hashSet = new HashSet();
        hashSet.addAll(nw4Var.e);
        HashSet hashSetB = nw4.b(nw4Var);
        Iterator it = hashSet.iterator();
        while (true) {
            if (!it.hasNext()) {
                hashSet.removeAll(nw4Var.e);
                z = false;
                break;
            } else if (hashSetB.contains((String) it.next())) {
                z = true;
                break;
            }
        }
        if (z) {
            throw new IllegalStateException("WorkContinuation has cycles (" + nw4Var + ")");
        }
        WorkDatabase workDatabase = xw4Var.c;
        na0 na0Var = xw4Var.b;
        workDatabase.b();
        try {
            p95.f(workDatabase, na0Var, nw4Var);
            boolean zB = b(nw4Var);
            workDatabase.q();
            if (zB) {
                fq3.b(na0Var, xw4Var.c, xw4Var.e);
            }
        } finally {
            workDatabase.m();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(defpackage.nw4 r25) {
        /*
            Method dump skipped, instruction units count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h51.b(nw4):boolean");
    }
}
