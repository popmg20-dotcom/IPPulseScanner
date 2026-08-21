package defpackage;

import android.graphics.Matrix;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zx0 {
    public final float[] a;
    public final float[] b;
    public final Matrix c;

    public zx0(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[2];
        this.a = fArr3;
        float[] fArr4 = new float[2];
        this.b = fArr4;
        System.arraycopy(fArr, 0, fArr3, 0, 2);
        System.arraycopy(fArr2, 0, fArr4, 0, 2);
        this.c = new Matrix();
    }

    public final void a(float f) {
        float[] fArr = this.b;
        float fAtan2 = (float) (Math.atan2(fArr[1], fArr[0]) + 1.5707963267948966d);
        float[] fArr2 = this.a;
        double d = f;
        double d2 = fAtan2;
        fArr2[0] = (float) ((Math.cos(d2) * d) + ((double) fArr2[0]));
        fArr2[1] = (float) ((Math.sin(d2) * d) + ((double) fArr2[1]));
    }

    public final void b() {
        Arrays.fill(this.a, 0.0f);
        float[] fArr = this.b;
        Arrays.fill(fArr, 0.0f);
        fArr[0] = 1.0f;
        this.c.reset();
    }

    public final void c(float f) {
        Matrix matrix = this.c;
        matrix.reset();
        matrix.setRotate(f);
        matrix.mapPoints(this.a);
        matrix.mapPoints(this.b);
    }

    public final void d(float f) {
        float[] fArr = this.a;
        fArr[0] = fArr[0] * 1.0f;
        fArr[1] = fArr[1] * f;
        float[] fArr2 = this.b;
        fArr2[0] = fArr2[0] * 1.0f;
        fArr2[1] = fArr2[1] * f;
    }

    public final void e(float f) {
        float[] fArr = this.a;
        fArr[0] = fArr[0] + f;
        fArr[1] = fArr[1] + 0.0f;
    }

    public zx0() {
        this.a = new float[2];
        this.b = new float[]{1.0f, 0.0f};
        this.c = new Matrix();
    }
}
