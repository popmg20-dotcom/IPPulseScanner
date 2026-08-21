package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u31 {
    public int a = 1;
    public final zl2 b;
    public zl2 c;
    public zl2 d;
    public int e;
    public int f;

    public u31(zl2 zl2Var) {
        this.b = zl2Var;
        this.c = zl2Var;
    }

    public final void a() {
        this.a = 1;
        this.c = this.b;
        this.f = 0;
    }

    public final boolean b() {
        xl2 xl2VarB = this.c.b.b();
        int iA = xl2VarB.a(6);
        return !(iA == 0 || ((ByteBuffer) xl2VarB.A).get(iA + xl2VarB.b) == 0) || this.e == 65039;
    }
}
