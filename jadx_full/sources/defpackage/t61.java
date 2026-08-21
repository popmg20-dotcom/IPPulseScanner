package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t61 extends hi4 {
    public volatile hi4 a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ iq1 d;
    public final /* synthetic */ bk4 e;
    public final /* synthetic */ u61 f;

    public t61(u61 u61Var, boolean z, boolean z2, iq1 iq1Var, bk4 bk4Var) {
        this.f = u61Var;
        this.b = z;
        this.c = z2;
        this.d = iq1Var;
        this.e = bk4Var;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        if (this.b) {
            r62Var.t();
            return null;
        }
        hi4 hi4VarE = this.a;
        if (hi4VarE == null) {
            hi4VarE = this.d.e(this.f, this.e);
            this.a = hi4VarE;
        }
        return hi4VarE.b(r62Var);
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) {
        if (this.c) {
            v72Var.C();
            return;
        }
        hi4 hi4VarE = this.a;
        if (hi4VarE == null) {
            hi4VarE = this.d.e(this.f, this.e);
            this.a = hi4VarE;
        }
        hi4VarE.c(v72Var, obj);
    }
}
