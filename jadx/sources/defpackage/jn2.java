package defpackage;

import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jn2 extends hg0 {
    public final void f(int i, v62 v62Var) {
        float[] fArr = this.a;
        float f = fArr[i];
        int i2 = i + 1;
        float f2 = fArr[i2];
        float[] fArr2 = (float[]) v62Var.f;
        fArr2[0] = f;
        fArr2[1] = f2;
        ((Matrix) v62Var.z).mapPoints(fArr2);
        long jA = qf1.a(fArr2[0], fArr2[1]);
        fArr[i] = Float.intBitsToFloat((int) (jA >> 32));
        fArr[i2] = Float.intBitsToFloat((int) (4294967295L & jA));
    }
}
