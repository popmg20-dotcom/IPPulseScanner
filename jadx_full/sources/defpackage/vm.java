package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class vm extends sn3 {
    public final oh3 f;
    public final List g;
    public final List h;
    public final oh3 i;
    public final boolean j;
    public final boolean k;
    public final wn3[] l;
    public qh3 m;
    public qh3 n;

    public vm(wn3 wn3Var, String str, String str2, String str3, List list, String str4, List list2, sn snVar) {
        super(wn3Var, str, str2);
        this.f = new oh3(str3, wn3Var);
        this.g = list;
        this.h = list2;
        oh3 oh3Var = new oh3(str4, wn3.d);
        this.i = oh3Var;
        this.j = oh3Var.c;
        this.l = (wn3[]) snVar.f;
        this.k = snVar.b;
    }

    @Override // defpackage.sn3
    public final void a(xp1 xp1Var, qh3 qh3Var) {
        qh3Var.a(this.f);
    }

    @Override // defpackage.sn3
    public final n80 b(xp1 xp1Var, String str, boolean z, boolean z2) {
        qh3 qh3Var = this.m;
        if (qh3Var == null) {
            qh3Var = new qh3();
            this.m = qh3Var;
            for (wn3 wn3Var : this.l) {
                xp1Var.d(wn3Var).a(xp1Var, qh3Var);
            }
        }
        return qh3Var.b(z, z2);
    }
}
