package defpackage;

import android.animation.ObjectAnimator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ld2 {
    public static final xk i = new xk(17, Float.class, "animationFraction");
    public static final st0 j = new st0(1);
    public int a;
    public float b;
    public float c;
    public ObjectAnimator d;
    public w04 e;
    public pd2 f;
    public md2 g;
    public nd2 h;

    public final void a(float f) {
        this.c = f;
        nd2 nd2Var = this.h;
        nd2Var.b = f;
        int i2 = this.a - 1;
        int[] iArr = this.f.d;
        int length = i2 % iArr.length;
        nd2Var.a = ud.a(tj4.l(f - i2, 0.0f, 1.0f), Integer.valueOf(iArr[length]), Integer.valueOf(iArr[(length + 1) % iArr.length])).intValue();
        md2 md2Var = this.g;
        if (md2Var != null) {
            md2Var.invalidateSelf();
        }
    }
}
