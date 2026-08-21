package defpackage;

import android.util.Rational;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class o64 {
    public final int a;
    public final int b;
    public final Rational c;
    public final boolean d;

    public o64(kz kzVar, Rational rational) {
        this.a = kzVar.c();
        this.b = kzVar.i();
        this.c = rational;
        boolean z = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z = false;
        }
        this.d = z;
    }

    public final Size a(hy1 hy1Var) {
        int iF0 = hy1Var.f0(0);
        Size sizeL = hy1Var.L();
        if (sizeL != null) {
            int iB = r25.B(r25.T(iF0), this.a, 1 == this.b);
            if (iB == 90 || iB == 270) {
                return new Size(sizeL.getHeight(), sizeL.getWidth());
            }
        }
        return sizeL;
    }
}
