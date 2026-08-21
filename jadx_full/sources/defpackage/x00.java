package defpackage;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x00 extends ke0 {
    public final Typeface e;
    public final cp1 f;
    public boolean g;

    public x00(cp1 cp1Var, Typeface typeface) {
        this.e = typeface;
        this.f = cp1Var;
    }

    @Override // defpackage.ke0
    public final void o(int i) {
        if (this.g) {
            return;
        }
        v60 v60Var = (v60) this.f.f;
        if (v60Var.l(this.e)) {
            v60Var.j(false);
        }
    }

    @Override // defpackage.ke0
    public final void p(Typeface typeface, boolean z) {
        if (this.g) {
            return;
        }
        v60 v60Var = (v60) this.f.f;
        if (v60Var.l(typeface)) {
            v60Var.j(false);
        }
    }
}
