package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class lh2 extends sn3 {
    public final oh3 f;
    public final List g;
    public qh3 h;

    public lh2(wn3 wn3Var, String str, String str2, List list) {
        super(wn3Var, str, null);
        this.f = new oh3(str2, wn3Var);
        this.g = list;
    }

    @Override // defpackage.sn3
    public final void a(xp1 xp1Var, qh3 qh3Var) {
        qh3Var.a(this.f);
    }

    @Override // defpackage.sn3
    public final n80 b(xp1 xp1Var, String str, boolean z, boolean z2) {
        qh3 qh3Var = this.h;
        if (qh3Var == null) {
            qh3Var = new qh3();
            qh3Var.a(this.f);
            this.h = qh3Var;
        }
        return qh3Var.b(z, z2);
    }
}
