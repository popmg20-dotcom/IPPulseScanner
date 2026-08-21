package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a2 {
    public h54 A;
    public b2[] b;
    public int f;
    public int z;

    public final b2 c() {
        b2 b2VarD;
        h54 h54Var;
        synchronized (this) {
            try {
                b2[] b2VarArrE = this.b;
                if (b2VarArrE == null) {
                    b2VarArrE = e();
                    this.b = b2VarArrE;
                } else if (this.f >= b2VarArrE.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(b2VarArrE, b2VarArrE.length * 2);
                    this.b = (b2[]) objArrCopyOf;
                    b2VarArrE = (b2[]) objArrCopyOf;
                }
                int i = this.z;
                do {
                    b2VarD = b2VarArrE[i];
                    if (b2VarD == null) {
                        b2VarD = d();
                        b2VarArrE[i] = b2VarD;
                    }
                    i++;
                    if (i >= b2VarArrE.length) {
                        i = 0;
                    }
                } while (!b2VarD.a(this));
                this.z = i;
                this.f++;
                h54Var = this.A;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (h54Var != null) {
            h54Var.v(1);
        }
        return b2VarD;
    }

    public abstract b2 d();

    public abstract b2[] e();

    public final void f(b2 b2Var) {
        h54 h54Var;
        int i;
        ge0[] ge0VarArrB;
        synchronized (this) {
            try {
                int i2 = this.f - 1;
                this.f = i2;
                h54Var = this.A;
                if (i2 == 0) {
                    this.z = 0;
                }
                b2Var.getClass();
                ge0VarArrB = b2Var.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (ge0 ge0Var : ge0VarArrB) {
            if (ge0Var != null) {
                ge0Var.d(xl4.a);
            }
        }
        if (h54Var != null) {
            h54Var.v(-1);
        }
    }
}
