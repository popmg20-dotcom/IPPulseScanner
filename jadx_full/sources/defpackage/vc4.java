package defpackage;

import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vc4 {
    public final int a;
    public final Paint.FontMetricsInt b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final f02 i;
    public final u01 j;
    public final Paint k;
    public final Paint l;
    public final Paint.FontMetricsInt m;

    public vc4(int i, Paint.FontMetricsInt fontMetricsInt, int i2, int i3, int i4, int i5, int i6, int i7, f02 f02Var, u01 u01Var, Paint paint, Paint paint2, Paint.FontMetricsInt fontMetricsInt2) {
        fontMetricsInt.getClass();
        f02Var.getClass();
        u01Var.getClass();
        paint.getClass();
        paint2.getClass();
        fontMetricsInt2.getClass();
        this.a = i;
        this.b = fontMetricsInt;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = i7;
        this.i = f02Var;
        this.j = u01Var;
        this.k = paint;
        this.l = paint2;
        this.m = fontMetricsInt2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vc4)) {
            return false;
        }
        vc4 vc4Var = (vc4) obj;
        return this.a == vc4Var.a && n12.c(this.b, vc4Var.b) && this.c == vc4Var.c && this.d == vc4Var.d && this.e == vc4Var.e && this.f == vc4Var.f && this.g == vc4Var.g && this.h == vc4Var.h && Float.compare(0.13f, 0.13f) == 0 && n12.c(this.i, vc4Var.i) && n12.c(this.j, vc4Var.j) && n12.c(this.k, vc4Var.k) && n12.c(this.l, vc4Var.l) && n12.c(this.m, vc4Var.m);
    }

    public final int hashCode() {
        return this.m.hashCode() + ((this.l.hashCode() + ((this.k.hashCode() + ((this.j.hashCode() + ((this.i.hashCode() + ((Float.floatToIntBits(0.13f) + ((((((((((((((this.b.hashCode() + (this.a * 31)) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 961) + this.g) * 31) + this.h) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TextRowParams(tabWidth=" + this.a + ", textMetrics=" + this.b + ", textTop=" + this.c + ", textBottom=" + this.d + ", textHeight=" + this.e + ", textBaseline=" + this.f + ", rowTop=0, rowBottom=" + this.g + ", rowHeight=" + this.h + ", roundTextBackgroundFactor=0.13, inlayHintRendererProvider=" + this.i + ", colorScheme=" + this.j + ", miscPaint=" + this.k + ", graphPaint=" + this.l + ", graphMetrics=" + this.m + ")";
    }
}
