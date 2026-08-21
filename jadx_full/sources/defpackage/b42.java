package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class b42 extends y32 {
    public final e42 X;
    public final c42 Y;
    public final h40 Z;
    public final Object y0;

    public b42(e42 e42Var, c42 c42Var, h40 h40Var, Object obj) {
        this.X = e42Var;
        this.Y = c42Var;
        this.Z = h40Var;
        this.y0 = obj;
    }

    @Override // defpackage.y32
    public final boolean l() {
        return false;
    }

    @Override // defpackage.y32
    public final void m(Throwable th) {
        h40 h40Var = this.Z;
        h40 h40VarV = e42.V(h40Var);
        e42 e42Var = this.X;
        c42 c42Var = this.Y;
        Object obj = this.y0;
        if (h40VarV == null || !e42Var.h0(c42Var, h40VarV, obj)) {
            c42Var.b.d(new vb2(2), 2);
            h40 h40VarV2 = e42.V(h40Var);
            if (h40VarV2 == null || !e42Var.h0(c42Var, h40VarV2, obj)) {
                e42Var.o(e42Var.z(c42Var, obj));
            }
        }
    }
}
