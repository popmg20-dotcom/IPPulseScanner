package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class um extends sn3 {
    public final oh3 f;
    public final List g;
    public final oh3 h;
    public final List i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final wn3[] m;
    public qh3 n;

    public um(wn3 wn3Var, String str, String str2, String str3, List list, String str4, List list2, boolean z, sn snVar) {
        super(wn3Var, str, str2);
        this.f = new oh3(str3, wn3Var);
        this.g = list;
        oh3 oh3Var = new oh3(str4 == null ? "\uffff" : str4, wn3.c);
        this.h = oh3Var;
        this.j = oh3Var.c;
        this.i = list2;
        this.k = z;
        this.m = (wn3[]) snVar.f;
        this.l = snVar.b;
    }

    @Override // defpackage.sn3
    public final void a(xp1 xp1Var, qh3 qh3Var) {
        qh3Var.a(this.f);
    }

    @Override // defpackage.sn3
    public final n80 b(xp1 xp1Var, String str, boolean z, boolean z2) {
        oh3 oh3Var = this.h;
        wn3 wn3Var = oh3Var.b;
        qh3 qh3Var = this.n;
        boolean z3 = this.j;
        boolean z4 = this.k;
        if (qh3Var == null) {
            qh3Var = new qh3();
            for (wn3 wn3Var2 : this.m) {
                xp1Var.d(wn3Var2).a(xp1Var, qh3Var);
            }
            if (z4) {
                if (z3) {
                    oh3Var = new oh3(oh3Var.a, wn3Var);
                }
                qh3Var.a(oh3Var);
            } else {
                if (z3) {
                    oh3Var = new oh3(oh3Var.a, wn3Var);
                }
                qh3Var.a.add(0, oh3Var);
                if (!qh3Var.b) {
                    qh3Var.b = oh3Var.d != null;
                }
            }
            this.n = qh3Var;
        }
        if (z3 && str != null) {
            if (z4) {
                qh3Var.c(qh3Var.a.size() - 1, str);
            } else {
                qh3Var.c(0, str);
            }
        }
        return qh3Var.b(z, z2);
    }
}
