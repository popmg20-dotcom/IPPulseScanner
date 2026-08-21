package defpackage;

import java.io.Closeable;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class kk3 implements Closeable {
    public final int A;
    public final kk3 A0;
    public final kk3 B0;
    public final long C0;
    public final long D0;
    public final ue1 E0;
    public final fg4 F0;
    public ku G0;
    public final boolean H0;
    public final boolean I0;
    public final zq1 X;
    public final lr1 Y;
    public final ok3 Z;
    public final cm2 b;
    public final ba3 f;
    public final wy3 y0;
    public final String z;
    public final kk3 z0;

    public kk3(cm2 cm2Var, ba3 ba3Var, String str, int i, zq1 zq1Var, lr1 lr1Var, ok3 ok3Var, wy3 wy3Var, kk3 kk3Var, kk3 kk3Var2, kk3 kk3Var3, long j, long j2, ue1 ue1Var, fg4 fg4Var) {
        cm2Var.getClass();
        ba3Var.getClass();
        str.getClass();
        ok3Var.getClass();
        fg4Var.getClass();
        this.b = cm2Var;
        this.f = ba3Var;
        this.z = str;
        this.A = i;
        this.X = zq1Var;
        this.Y = lr1Var;
        this.Z = ok3Var;
        this.y0 = wy3Var;
        this.z0 = kk3Var;
        this.A0 = kk3Var2;
        this.B0 = kk3Var3;
        this.C0 = j;
        this.D0 = j2;
        this.E0 = ue1Var;
        this.F0 = fg4Var;
        boolean z = true;
        this.H0 = 200 <= i && i < 300;
        if (i != 307 && i != 308) {
            switch (i) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    z = false;
                    break;
            }
        }
        this.I0 = z;
    }

    public static String g(kk3 kk3Var, String str) {
        kk3Var.getClass();
        String strA = kk3Var.Y.a(str);
        if (strA == null) {
            return null;
        }
        return strA;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.Z.close();
    }

    public final jk3 n() {
        jk3 jk3Var = new jk3();
        jk3Var.c = -1;
        jk3Var.g = ok3.f;
        jk3Var.o = fg4.W;
        jk3Var.a = this.b;
        jk3Var.b = this.f;
        jk3Var.c = this.A;
        jk3Var.d = this.z;
        jk3Var.e = this.X;
        jk3Var.f = gb4.A(this.Y);
        jk3Var.g = this.Z;
        jk3Var.h = this.y0;
        jk3Var.i = this.z0;
        jk3Var.j = this.A0;
        jk3Var.k = this.B0;
        jk3Var.l = this.C0;
        jk3Var.m = this.D0;
        jk3Var.n = this.E0;
        jk3Var.o = this.F0;
        return jk3Var;
    }

    public final nk3 s() throws EOFException {
        ok3 ok3Var = this.Z;
        he3 he3VarPeek = ok3Var.x().peek();
        hp hpVar = new hp();
        he3VarPeek.request(10240L);
        long jMin = Math.min(10240L, he3VarPeek.f.f);
        while (jMin > 0) {
            long jT0 = he3VarPeek.t0(hpVar, jMin);
            if (jT0 == -1) {
                throw new EOFException();
            }
            jMin -= jT0;
        }
        nk3 nk3Var = ok3.f;
        return new nk3(ok3Var.s(), hpVar.f, hpVar);
    }

    public final String toString() {
        return "Response{protocol=" + this.f + ", code=" + this.A + ", message=" + this.z + ", url=" + ((ev1) this.b.f) + '}';
    }
}
