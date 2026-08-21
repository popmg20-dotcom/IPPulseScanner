package defpackage;

import android.os.Build;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class fq3 {
    public static final String a = ue2.i("Schedulers");

    public static void a(jx4 jx4Var, d84 d84Var, List list) {
        if (list.size() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jx4Var.e(jCurrentTimeMillis, ((gx4) it.next()).a);
            }
        }
    }

    public static void b(na0 na0Var, WorkDatabase workDatabase, List list) {
        List list2;
        if (list == null || list.size() == 0) {
            return;
        }
        jx4 jx4VarX = workDatabase.x();
        workDatabase.b();
        try {
            int i = 1;
            if (Build.VERSION.SDK_INT >= 24) {
                list2 = (List) ke0.r(jx4VarX.a, true, false, new q74(13));
                a(jx4VarX, na0Var.d, list2);
            } else {
                list2 = null;
            }
            List list3 = (List) ke0.r(jx4VarX.a, true, false, new i70(na0Var.f, i));
            a(jx4VarX, na0Var.d, list3);
            if (list2 != null) {
                list3.addAll(list2);
            }
            List list4 = (List) ke0.r(jx4VarX.a, true, false, new q74(16));
            workDatabase.q();
            workDatabase.m();
            if (list3.size() > 0) {
                gx4[] gx4VarArr = (gx4[]) list3.toArray(new gx4[list3.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    dq3 dq3Var = (dq3) it.next();
                    if (dq3Var.c()) {
                        dq3Var.e(gx4VarArr);
                    }
                }
            }
            if (list4.size() > 0) {
                gx4[] gx4VarArr2 = (gx4[]) list4.toArray(new gx4[list4.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    dq3 dq3Var2 = (dq3) it2.next();
                    if (!dq3Var2.c()) {
                        dq3Var2.e(gx4VarArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.m();
            throw th;
        }
    }
}
