package defpackage;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ib4 extends ji0 {
    public final /* synthetic */ ke0 h;
    public final /* synthetic */ kb4 i;

    public ib4(kb4 kb4Var, ke0 ke0Var) {
        this.i = kb4Var;
        this.h = ke0Var;
    }

    @Override // defpackage.ji0
    public final void E(int i) {
        this.i.n = true;
        this.h.o(i);
    }

    @Override // defpackage.ji0
    public final void F(Typeface typeface) {
        kb4 kb4Var = this.i;
        Typeface typefaceCreate = Typeface.create(typeface, kb4Var.d);
        kb4Var.p = typefaceCreate;
        kb4Var.n = true;
        this.h.p(typefaceCreate, false);
    }
}
