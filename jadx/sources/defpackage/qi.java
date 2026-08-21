package defpackage;

import android.net.ConnectivityManager;
import java.io.IOException;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qi implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ qi(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    private final Object c() {
        int i;
        long jA;
        mu1[] mu1VarArr;
        kt ktVar = (kt) this.f;
        gu3 gu3Var = (gu3) this.z;
        bh3 bh3Var = new bh3();
        fu1 fu1Var = (fu1) ktVar.z;
        synchronized (fu1Var.N0) {
            synchronized (fu1Var) {
                try {
                    gu3 gu3Var2 = fu1Var.I0;
                    gu3 gu3Var3 = new gu3();
                    gu3Var2.getClass();
                    for (int i2 = 0; i2 < 10; i2++) {
                        if (((1 << i2) & gu3Var2.a) != 0) {
                            gu3Var3.b(i2, gu3Var2.b[i2]);
                        }
                    }
                    for (int i3 = 0; i3 < 10; i3++) {
                        if (((1 << i3) & gu3Var.a) != 0) {
                            gu3Var3.b(i3, gu3Var.b[i3]);
                        }
                    }
                    bh3Var.b = gu3Var3;
                    jA = ((long) gu3Var3.a()) - ((long) gu3Var2.a());
                    mu1VarArr = (jA == 0 || fu1Var.f.isEmpty()) ? null : (mu1[]) fu1Var.f.values().toArray(new mu1[0]);
                    gu3 gu3Var4 = (gu3) bh3Var.b;
                    gu3Var4.getClass();
                    fu1Var.I0 = gu3Var4;
                    za4.c(fu1Var.A0, fu1Var.z + " onSettings", new qi(6, fu1Var, bh3Var));
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                fu1Var.N0.g((gu3) bh3Var.b);
            } catch (IOException e) {
                t51 t51Var = t51.PROTOCOL_ERROR;
                fu1Var.g(t51Var, t51Var, e);
            }
        }
        if (mu1VarArr != null) {
            for (mu1 mu1Var : mu1VarArr) {
                synchronized (mu1Var) {
                    mu1Var.X += jA;
                    if (jA > 0) {
                        mu1Var.notifyAll();
                    }
                }
            }
        }
        return xl4.a;
    }

    private final Object d() {
        gj gjVar = (gj) this.f;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.z;
        synchronized (kv3.b) {
            LinkedHashMap linkedHashMap = kv3.c;
            linkedHashMap.remove(gjVar);
            if (linkedHashMap.isEmpty()) {
                ue2.g().a(mw4.a, "NetworkRequestConstraintController unregister shared callback");
                connectivityManager.unregisterNetworkCallback(kv3.a);
                kv3.f = false;
                kv3.d = null;
                kv3.e = false;
            }
        }
        return xl4.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0114  */
    @Override // defpackage.pl1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a() {
        /*
            Method dump skipped, instruction units count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qi.a():java.lang.Object");
    }
}
