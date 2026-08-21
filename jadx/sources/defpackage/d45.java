package defpackage;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d45 extends z45 {
    public final ie X;
    public final ie Y;
    public long Z;

    public d45(k85 k85Var) {
        super(k85Var);
        this.Y = new ie(0);
        this.X = new ie(0);
    }

    public final void W0(long j, String str) {
        k85 k85Var = (k85) this.f;
        if (str == null || str.length() == 0) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.a("Ad unit id must be a non-empty string");
        } else {
            f85 f85Var = k85Var.Z;
            k85.h(f85Var);
            f85Var.e1(new x05(this, str, j, 0));
        }
    }

    public final void X0(long j, String str) {
        k85 k85Var = (k85) this.f;
        if (str == null || str.length() == 0) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.a("Ad unit id must be a non-empty string");
        } else {
            f85 f85Var = k85Var.Z;
            k85.h(f85Var);
            f85Var.e1(new x05(this, str, j, 1));
        }
    }

    public final void Y0(long j) {
        yb5 yb5Var = ((k85) this.f).C0;
        k85.g(yb5Var);
        rb5 rb5VarB1 = yb5Var.b1(false);
        ie ieVar = this.X;
        for (String str : (fe) ieVar.keySet()) {
            a1(str, j - ((Long) ieVar.get(str)).longValue(), rb5VarB1);
        }
        if (!ieVar.isEmpty()) {
            Z0(j - this.Z, rb5VarB1);
        }
        b1(j);
    }

    public final void Z0(long j, rb5 rb5Var) {
        k85 k85Var = (k85) this.f;
        if (rb5Var == null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.H0.a("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.H0.b(Long.valueOf(j), "Not logging ad exposure. Less than 1000 ms. exposure");
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            qf5.O1(rb5Var, bundle, true);
            ib5 ib5Var = k85Var.D0;
            k85.g(ib5Var);
            ib5Var.c1("am", "_xa", bundle);
        }
    }

    public final void a1(String str, long j, rb5 rb5Var) {
        k85 k85Var = (k85) this.f;
        if (rb5Var == null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.H0.a("Not logging ad unit exposure. No active activity");
        } else {
            if (j < 1000) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                t65Var2.H0.b(Long.valueOf(j), "Not logging ad unit exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            qf5.O1(rb5Var, bundle, true);
            ib5 ib5Var = k85Var.D0;
            k85.g(ib5Var);
            ib5Var.c1("am", "_xu", bundle);
        }
    }

    public final void b1(long j) {
        ie ieVar = this.X;
        Iterator it = ((fe) ieVar.keySet()).iterator();
        while (it.hasNext()) {
            ieVar.put((String) it.next(), Long.valueOf(j));
        }
        if (ieVar.isEmpty()) {
            return;
        }
        this.Z = j;
    }
}
