package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uc4 {
    public static final i60 o = new i60(11);
    public ud0 d;
    public bv0 e;
    public int f;
    public int g;
    public List h;
    public List i;
    public vc4 j;
    public c03 k;
    public t6 l;
    public final RectF a = new RectF();
    public final int[] b = new int[4];
    public final as2 c = as2.a(0, 0);
    public int m = -1;
    public int n = -1;

    public final void a(int i, int i2, int i3, int i4, boolean z, Canvas canvas, float f, float f2, pc4 pc4Var) {
        int i5 = i2 - i;
        if (i5 < 64 || this.l == null) {
            oc4 oc4Var = pc4Var.l;
            if (oc4Var != null) {
                oc4Var.a(canvas, this.d.b, i, i5, i3, i4 - i3, z, f, f2, this.j, pc4Var.m);
                return;
            } else {
                b(i, i2, i3, i4, z, canvas, f, f2);
                return;
            }
        }
        float fMax = Math.max(0.0f, pc4Var.b - f) - this.k.a;
        float fMin = Math.min(f2, pc4Var.c - f) + this.k.a;
        int iD = d(i, i2, i3, i4, z, fMax);
        int iD2 = d(i, i2, i3, i4, z, fMin);
        int iMin = Math.min(iD, iD2);
        int iMax = Math.max(iD, iD2);
        if (iMin < iMax) {
            char[] cArr = this.d.b;
            int i6 = iMin;
            while (true) {
                int i7 = i6 - 1;
                if (i7 < i3 || cArr[i7] == ' ' || iMax - i6 >= 256) {
                    break;
                } else {
                    i6--;
                }
            }
            int i8 = iMax;
            while (true) {
                int i9 = i8 + 1;
                if (i9 >= i4 || cArr[i8] == ' ' || i8 - i6 >= 256) {
                    break;
                } else {
                    i8 = i9;
                }
            }
            float fG = g(iMin, i, i2, i3, i4, z);
            float fG2 = g(iMax, i, i2, i3, i4, z);
            float fAbs = Math.abs(fG - fG2);
            float f3 = z ? (f + f2) - fG2 : f + fG;
            oc4 oc4Var2 = pc4Var.l;
            if (oc4Var2 != null) {
                oc4Var2.a(canvas, this.d.b, iMin, iMax - iMin, i3, i4 - i3, z, f3, fAbs, this.j, pc4Var.m);
            } else {
                b(iMin, iMax, i3, i4, z, canvas, f3, fAbs);
            }
        }
    }

    public final void b(int i, int i2, int i3, int i4, boolean z, Canvas canvas, float f, float f2) {
        char c;
        char[] cArr;
        Canvas canvas2;
        int i5 = i2;
        c03 c03Var = this.k;
        boolean z2 = c03Var.b;
        ud0 ud0Var = this.d;
        if (!z2) {
            canvas.drawTextRun(ud0Var.b, i, i2 - i, i3, i4 - i3, f, this.j.f, z, c03Var);
            return;
        }
        char[] cArr2 = ud0Var.b;
        float f3 = f + (z ? f2 : 0.0f);
        int i6 = i;
        int i7 = i6;
        float f4 = f3;
        while (i6 <= i5) {
            if (i6 != i5) {
                c = cArr2[i6];
                if (!ek0.s(c)) {
                    cArr = cArr2;
                }
                i6++;
                i5 = i2;
                cArr2 = cArr;
            } else {
                c = 0;
            }
            char c2 = c;
            int i8 = i6 - i7;
            if (i8 > 0) {
                if (z) {
                    this.k.setTextAlign(Paint.Align.RIGHT);
                }
                canvas.drawTextRun(cArr2, i7, i8, i3, i4 - i3, f4, this.j.f, z, this.k);
                canvas2 = canvas;
                cArr = cArr2;
                if (z) {
                    this.k.setTextAlign(Paint.Align.LEFT);
                }
            } else {
                canvas2 = canvas;
                cArr = cArr2;
            }
            if (i6 == i5) {
                return;
            }
            float fMeasureText = this.k.measureText(ek0.n(c2));
            float fG = g(i6, i, i5, i, i2, z);
            float f5 = z ? (f3 - fG) - fMeasureText : f3 + fG;
            vc4 vc4Var = this.j;
            Paint paint = vc4Var.l;
            Paint.FontMetricsInt fontMetricsInt = vc4Var.m;
            paint.setTextAlign(Paint.Align.CENTER);
            int i9 = fontMetricsInt.descent;
            int i10 = fontMetricsInt.ascent;
            float f6 = this.j.h / 2.0f;
            float f7 = (i9 - i10) / 2.0f;
            float f8 = f6 - f7;
            paint.setColor(this.k.getColor());
            float f9 = (fMeasureText / 2.0f) + f5;
            canvas2.drawText(ek0.n(c2), f9, f8 - i10, paint);
            paint.setTextAlign(Paint.Align.LEFT);
            float fMeasureText2 = paint.measureText(ek0.n(c2));
            RectF rectF = this.a;
            rectF.top = f8;
            rectF.bottom = f6 + f7;
            float f10 = fMeasureText2 / 2.0f;
            rectF.left = f9 - f10;
            rectF.right = f9 + f10;
            int color = this.k.getColor();
            this.k.setColor(this.j.j.e(52));
            this.k.setStyle(Paint.Style.STROKE);
            this.k.setStrokeWidth(this.j.h * 0.05f);
            float f11 = this.j.h * 0.13f;
            canvas2.drawRoundRect(rectF, f11, f11, this.k);
            this.k.setStyle(Paint.Style.FILL);
            this.k.setColor(color);
            float f12 = fG + fMeasureText;
            if (z) {
                f12 = -f12;
            }
            f4 = f3 + f12;
            i7 = i6;
            i6++;
            i5 = i2;
            cArr2 = cArr;
        }
    }

    public final long c(Canvas canvas, float f, float f2) {
        pc4 pc4Var = new pc4();
        pc4Var.b = f;
        pc4Var.c = f2;
        lc4 lc4Var = new lc4(this, canvas, pc4Var, f2);
        l(lc4Var, true);
        boolean z = lc4Var.b;
        return ez4.M(z ? 1 : 0, Float.floatToRawIntBits(lc4Var.a));
    }

    public final int d(int i, int i2, int i3, int i4, boolean z, float f) {
        c03 c03Var;
        char[] cArr;
        int i5;
        t6 t6Var = this.l;
        if (t6Var != null) {
            float fK = t6Var.k(0, i);
            int i6 = i;
            int i7 = i2;
            while (i6 <= i7) {
                int i8 = (i6 + i7) / 2;
                if (i8 >= i && i8 < i2) {
                    float fK2 = t6Var.k(0, i8) - fK;
                    if (fK2 > f) {
                        i7 = i8 - 1;
                    } else if (fK2 < f) {
                        i6 = i8 + 1;
                    }
                }
                i6 = i8;
                break;
            }
            if (t6Var.k(0, i6) - fK > f) {
                i6--;
            }
            return Math.max(i, Math.min(i2, i6));
        }
        c03 c03Var2 = this.k;
        ud0 ud0Var = this.d;
        if (!c03Var2.b) {
            return c03Var2.getOffsetForAdvance(ud0Var.b, i, i2, i3, i4, z, f);
        }
        char[] cArr2 = ud0Var.b;
        int i9 = i;
        int offsetForAdvance = i9;
        float f2 = 0.0f;
        while (offsetForAdvance < i2) {
            char c = cArr2[offsetForAdvance];
            if (ek0.s(c)) {
                if (i9 == offsetForAdvance) {
                    c03Var = c03Var2;
                    i5 = offsetForAdvance;
                } else {
                    c03Var = c03Var2;
                    i5 = offsetForAdvance;
                    offsetForAdvance = c03Var.getOffsetForAdvance(ud0Var.b, i9, offsetForAdvance, i3, i4, z, f - f2);
                }
                if (offsetForAdvance < i5) {
                    return offsetForAdvance;
                }
                cArr = cArr2;
                float fMeasureText = c03Var.measureText(ek0.n(c)) + f2 + c03Var.a(cArr, i9, i5 - i9, i3, i4 - i3, z, null, 0);
                if (fMeasureText >= f) {
                    return i5;
                }
                f2 = fMeasureText;
                i9 = i5 + 1;
            } else {
                c03Var = c03Var2;
                cArr = cArr2;
                i5 = offsetForAdvance;
            }
            offsetForAdvance = i5 + 1;
            c03Var2 = c03Var;
            cArr2 = cArr;
        }
        c03 c03Var3 = c03Var2;
        if (i9 >= i2) {
            return i2;
        }
        return c03Var3.getOffsetForAdvance(ud0Var.b, i9, i2, i3, i4, z, f - f2);
    }

    public final float e(int i) {
        pc4 pc4Var = new pc4();
        pc4Var.d = i;
        l(new kc4(this, pc4Var), true);
        return pc4Var.e;
    }

    public final int f(float f) {
        pc4 pc4Var = new pc4();
        pc4Var.f = f;
        pc4Var.c = f;
        l(new qc4(this, pc4Var), true);
        int i = pc4Var.g;
        return i == -1 ? this.f : i;
    }

    public final float g(int i, int i2, int i3, int i4, int i5, boolean z) {
        t6 t6Var = this.l;
        return t6Var != null ? t6Var.k(i2, i) : this.k.getRunAdvance(this.d.b, i2, i3, i4, i5, z, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r7 = r31;
     */
    /* JADX WARN: Removed duplicated region for block: B:146:0x014a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float h(ArrayList arrayList, boolean z, hm2 hm2Var, Canvas canvas, float f, pc4 pc4Var) {
        pc4 pc4Var2;
        int i;
        int size;
        int i2;
        boolean z2;
        pc4 pc4Var3;
        float fI;
        int i3;
        boolean z3;
        float f2;
        float f3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z4;
        int i8 = 1;
        float f4 = 0.0f;
        for (jm3 jm3Var : z ? new sh2(1, arrayList) : arrayList) {
            jm3Var.getClass();
            float f5 = f + f4;
            char[] cArr = this.d.b;
            boolean z5 = jm3Var.c;
            int i9 = z5 ? jm3Var.b : jm3Var.a;
            int i10 = z5 ? jm3Var.a - i8 : jm3Var.b;
            float f6 = this.j.a * this.k.a;
            int i11 = z5 ? jm3Var.b - i8 : jm3Var.a;
            float f7 = 0.0f;
            while (true) {
                if (z5) {
                    if (i11 < i10) {
                        break;
                    }
                    if (i11 != i10 || cArr[i11] == '\t') {
                        int i12 = !z5 ? i11 + 1 : i9;
                        if (!z5) {
                            i9 = i11;
                        }
                        float f8 = f5 + f7;
                        i = hm2Var.b;
                        int i13 = !z5 ? i9 - 1 : i12;
                        size = this.h.size();
                        while (true) {
                            i2 = i + 1;
                            if (i2 >= size || ((as2) this.h.get(i2)).a > i13) {
                                break;
                            }
                            i = i2;
                        }
                        if (z5) {
                            z2 = z5;
                            pc4Var3 = pc4Var;
                            int i14 = i;
                            fI = 0.0f;
                            while (i12 < i9) {
                                int i15 = i14 + 1;
                                if (i15 >= size) {
                                    i3 = this.g;
                                    z3 = false;
                                } else {
                                    i3 = ((as2) this.h.get(i15)).a;
                                    z3 = true;
                                }
                                int iMin = Math.min(i9, i3);
                                int i16 = i9;
                                int i17 = size;
                                pc4Var2 = pc4Var3;
                                z5 = z2;
                                fI += i(i12, iMin, z5, (as2) this.h.get(i14), canvas, f8 + fI, pc4Var2);
                                if (z3) {
                                    i14 = i15;
                                }
                                if (f8 + fI > pc4Var2.c) {
                                    break;
                                }
                                i12 = iMin;
                                z2 = z5;
                                pc4Var3 = pc4Var2;
                                size = i17;
                                i9 = i16;
                            }
                            pc4Var2 = pc4Var3;
                            z5 = z2;
                            f2 = f7 + fI;
                            f3 = f5 + f2;
                            if (f3 <= pc4Var2.c) {
                            }
                        } else {
                            int i18 = i;
                            fI = 0.0f;
                            while (i9 > i12) {
                                as2 as2Var = (as2) this.h.get(i18);
                                if (i18 == 0) {
                                    i7 = 0;
                                    z4 = false;
                                } else {
                                    i7 = as2Var.a;
                                    z4 = true;
                                }
                                int iMax = Math.max(i12, i7);
                                int i19 = i12;
                                float fI2 = i(iMax, i9, z5, as2Var, canvas, f8 + fI, pc4Var);
                                z2 = z5;
                                pc4Var3 = pc4Var;
                                fI += fI2;
                                if (z4) {
                                    i18--;
                                }
                                if (f8 + fI > pc4Var3.c) {
                                    pc4Var2 = pc4Var3;
                                    z5 = z2;
                                    break;
                                }
                                i9 = iMax;
                                z5 = z2;
                                i12 = i19;
                            }
                            pc4Var2 = pc4Var;
                            f2 = f7 + fI;
                            f3 = f5 + f2;
                            if (f3 <= pc4Var2.c) {
                                f7 = f2;
                                break;
                            }
                            if (i11 != i10) {
                                int i20 = pc4Var2.d;
                                if (i11 == i20 || ((i6 = i11 + 1) == i20 && i6 == this.g)) {
                                    float f9 = i11 == i20 ? 0.0f : f6;
                                    if (z5) {
                                        pc4Var2.e = (f2 + f6) - f9;
                                    } else {
                                        pc4Var2.e = f9 + f2;
                                    }
                                    pc4Var2.c = 0.0f;
                                }
                                float f10 = pc4Var2.f;
                                if (f10 != -1.0f) {
                                    float f11 = (f10 - f5) - f2;
                                    if (z5) {
                                        f11 = f6 - f11;
                                    }
                                    if (f11 > f6 / 2.0f) {
                                        pc4Var2.g = i11 + 1;
                                    } else {
                                        pc4Var2.g = i11;
                                    }
                                }
                                rc4 rc4Var = pc4Var2.j;
                                if (rc4Var != null && i11 >= pc4Var2.h && i11 < pc4Var2.i) {
                                    rc4Var.b(f3, f3 + f6);
                                }
                                t6 t6Var = pc4Var2.n;
                                if (t6Var != null) {
                                    ((float[][]) t6Var.z)[i11 / 262144][i11 % 262144] = f6;
                                }
                                i4 = i10;
                                oc4 oc4Var = pc4Var2.l;
                                if (oc4Var == null || i11 < pc4Var2.h || i11 >= pc4Var2.i) {
                                    i5 = i11;
                                } else {
                                    i5 = i11;
                                    oc4Var.a(canvas, cArr, i5, 1, i11, 1, z5, f3, f6, this.j, null);
                                }
                                f2 += f6;
                            } else {
                                i4 = i10;
                                i5 = i11;
                            }
                            int i21 = z5 ? i5 : i5 + 1;
                            if (f5 + f2 > pc4Var2.c) {
                                f7 = f2;
                                break;
                            }
                            i9 = i21;
                        }
                    } else {
                        i4 = i10;
                        f2 = f7;
                        i5 = i11;
                    }
                    i11 = i5 + (z5 ? -1 : 1);
                    f7 = f2;
                    i10 = i4;
                } else {
                    if (i11 > i10) {
                        break;
                    }
                    if (i11 != i10) {
                        if (!z5) {
                        }
                        if (!z5) {
                        }
                        float f82 = f5 + f7;
                        i = hm2Var.b;
                        if (!z5) {
                        }
                        size = this.h.size();
                        while (true) {
                            i2 = i + 1;
                            if (i2 >= size) {
                                break;
                            }
                            break;
                            break;
                            i = i2;
                        }
                        if (z5) {
                        }
                    }
                }
            }
            f4 += f7;
            if (f + f4 > pc4Var2.c) {
                return f4;
            }
            i8 = 1;
        }
        return f4;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float i(int i, int i2, boolean z, as2 as2Var, Canvas canvas, float f, pc4 pc4Var) {
        float f2;
        float f3;
        c03 c03Var;
        float f4;
        float fA;
        int iMax;
        int iMin;
        uc4 uc4Var;
        int i3;
        int i4;
        float fMax;
        c03 c03Var2;
        c03 c03Var3;
        float f5;
        float f6;
        Paint paint;
        uc4 uc4Var2;
        float f7;
        int i5;
        int i6;
        int i7;
        char c;
        char c2;
        float f8;
        int i8;
        int i9;
        int i10;
        c03 c03Var4;
        float f9;
        float f10;
        Paint paint2;
        int i11 = i;
        Canvas canvas2 = canvas;
        c03 c03Var5 = this.k;
        int i12 = 0;
        if ((canvas2 == null || pc4Var.l != null) && this.l != null) {
            f2 = 0.0f;
        } else {
            long j = as2Var.b;
            long j2 = j & 1924145348608L;
            if ((1924145348608L & j) != pc4Var.a) {
                c03Var5.setFakeBoldText((j & 274877906944L) != 0);
                if ((j & 549755813888L) != 0) {
                    c03Var5.setTextSkewX(-0.2f);
                    f2 = 0.0f;
                } else {
                    f2 = 0.0f;
                    c03Var5.setTextSkewX(0.0f);
                }
                pc4Var.a = j2;
            }
        }
        float[] fArrA = pc4Var.n != null ? hb4.a(i2 - i11) : null;
        int i13 = i2 - i11;
        if (this.l != null) {
            if (fArrA != null) {
                for (int i14 = 0; i14 < i13; i14++) {
                    int i15 = i11 + i14;
                    int i16 = i15 / 262144;
                    int i17 = i15 % 262144;
                    float[] fArr = ((float[][]) this.l.z)[i16];
                    fArrA[i14] = fArr[i17 + 1] - fArr[i17];
                }
            }
            fA = this.l.k(i11, i13 + i11);
            f3 = -0.2f;
            c03Var = c03Var5;
            f4 = f2;
        } else {
            f3 = -0.2f;
            c03Var = c03Var5;
            f4 = f2;
            fA = this.k.a(this.d.b, i, i13, i, i13, z, fArrA, 0);
            i11 = i;
        }
        float f11 = fA;
        if (pc4Var.n != null && fArrA != null) {
            for (int i18 = i11; i18 < i2; i18++) {
                ((float[][]) pc4Var.n.z)[i18 / 262144][i18 % 262144] = fArrA[i18 - i11];
            }
            hb4.b(fArrA);
        }
        int i19 = pc4Var.d;
        if (i19 >= i11 && (i19 < i2 || (i19 == i2 && i2 == this.g))) {
            pc4Var.c = f4;
            float fG = g(i19, i11, i2, i, i2, z);
            if (z) {
                pc4Var.e = (f + f11) - fG;
                return f11;
            }
            pc4Var.e = fG + f;
            return f11;
        }
        float f12 = pc4Var.f;
        float f13 = -1.0f;
        if (f12 != -1.0f) {
            float f14 = f12 - f;
            if (z) {
                f14 = f11 - f14;
            }
            float f15 = f14;
            if (f15 > f11) {
                pc4Var.g = i2;
            } else if (f15 <= f4) {
                pc4Var.g = i11;
            } else {
                pc4Var.g = d(i11, i2, i, i2, z, f15);
            }
        }
        if (!(pc4Var.j == null && pc4Var.l == null) && (iMax = Math.max(i11, pc4Var.h)) < (iMin = Math.min(i2, pc4Var.i))) {
            if (iMax == i11 && iMin == i2) {
                i4 = i2;
                f13 = f;
                i3 = i11;
                fMax = f + f11;
                uc4Var = this;
            } else {
                uc4Var = this;
                float fG2 = uc4Var.g(iMax, i11, i2, i, i2, z);
                i3 = i;
                i4 = i2;
                float fG3 = uc4Var.g(iMin, i3, i4, i, i2, z);
                if (z) {
                    fG2 = f11 - fG2;
                }
                if (z) {
                    fG3 = f11 - fG3;
                }
                float fMin = Math.min(fG2, fG3) + f;
                fMax = Math.max(fG2, fG3) + f;
                f13 = fMin;
            }
            rc4 rc4Var = pc4Var.j;
            if (rc4Var != null) {
                rc4Var.b(f13, fMax);
            }
        } else {
            uc4Var = this;
            i4 = i2;
            i3 = i11;
            fMax = -1.0f;
        }
        float f16 = f + f11;
        if (Math.max(f, pc4Var.b) < Math.min(f16, pc4Var.c) && canvas2 != null) {
            if (pc4Var.l == null) {
                int i20 = i3;
                int i21 = i4;
                pc4 pc4Var2 = pc4Var;
                float f17 = f11;
                Paint paint3 = uc4Var.j.k;
                as2Var.getClass();
                u01 u01Var = uc4Var.j.j;
                u01Var.getClass();
                int iE = u01Var.e((int) ((as2Var.b & 274877382656L) >> 19));
                if (iE == 0 || i20 == i21) {
                    c03Var2 = c03Var;
                } else {
                    uc4Var.j.getClass();
                    float f18 = uc4Var.j.g;
                    RectF rectF = uc4Var.a;
                    rectF.set(f, f4, f16, f18);
                    c03Var2 = c03Var;
                    c03Var2.setColor(iE);
                    float f19 = uc4Var.j.h * 0.13f;
                    canvas2.drawRoundRect(rectF, f19, f19, c03Var2);
                }
                u01 u01Var2 = uc4Var.j.j;
                u01Var2.getClass();
                int iE2 = u01Var2.e((int) (as2Var.b & 524287));
                int i22 = uc4Var.m;
                int i23 = uc4Var.n;
                if (i22 >= i23 || i22 >= uc4Var.g || i23 <= uc4Var.f || uc4Var.j.j.e(30) == 0) {
                    c03Var3 = c03Var2;
                    f5 = f16;
                    f6 = f4;
                    paint = paint3;
                    c03Var3.setColor(iE2);
                    uc4Var2 = this;
                    f7 = f17;
                    uc4Var2.a(i, i2, i, i2, z, canvas, f, f7, pc4Var);
                } else {
                    int iMax2 = Math.max(i20, Math.min(i21, uc4Var.m));
                    int iMax3 = Math.max(i20, Math.min(i21, uc4Var.n));
                    f6 = f4;
                    int[] iArr = uc4Var.b;
                    iArr[0] = i20;
                    iArr[1] = i21;
                    iArr[2] = iMax2;
                    iArr[3] = iMax3;
                    Arrays.sort(iArr);
                    float f20 = f6;
                    while (true) {
                        int i24 = i12 + 1;
                        if (i24 >= iArr.length) {
                            break;
                        }
                        int i25 = iArr[i12];
                        int i26 = iArr[i24];
                        if (i25 == i26) {
                            i7 = iMax2;
                            i10 = i24;
                            i9 = iMax3;
                            c03Var4 = c03Var2;
                            f8 = f16;
                            f9 = f17;
                            c2 = 30;
                            i8 = iE2;
                            paint2 = paint3;
                        } else {
                            if (i25 < iMax2 || i26 > iMax3) {
                                i5 = i25;
                                i6 = i26;
                                i7 = iMax2;
                                c = 30;
                                uc4Var.k.setColor(iE2);
                            } else {
                                i5 = i25;
                                i6 = i26;
                                i7 = iMax2;
                                c = 30;
                                uc4Var.k.setColor(uc4Var.j.j.e(30));
                            }
                            int i27 = iE2;
                            int i28 = i6;
                            c2 = c;
                            f8 = f16;
                            int i29 = i5;
                            i8 = i27;
                            i9 = iMax3;
                            int i30 = i6;
                            i10 = i24;
                            float fG4 = uc4Var.g(i30, i29, i28, i, i2, z);
                            if (z) {
                                Canvas canvas3 = canvas2;
                                f9 = f17;
                                paint2 = paint3;
                                c03Var4 = c03Var2;
                                f10 = fG4;
                                a(i29, i30, i, i2, true, canvas3, (f8 - f20) - fG4, f10, pc4Var2);
                            } else {
                                c03Var4 = c03Var2;
                                f9 = f17;
                                f10 = fG4;
                                paint2 = paint3;
                                a(i29, i30, i, i2, false, canvas, f + f20, f10, pc4Var);
                            }
                            f20 += f10;
                        }
                        uc4Var = this;
                        pc4Var2 = pc4Var;
                        iE2 = i8;
                        c03Var2 = c03Var4;
                        paint3 = paint2;
                        f16 = f8;
                        iMax3 = i9;
                        i12 = i10;
                        iMax2 = i7;
                        f17 = f9;
                        canvas2 = canvas;
                    }
                    c03Var3 = c03Var2;
                    f5 = f16;
                    float f21 = f17;
                    paint = paint3;
                    uc4Var2 = this;
                    f7 = f21;
                }
                if ((as2Var.b & 1099511627776L) != 0) {
                    int iE3 = uc4Var2.j.j.e(57);
                    if (iE3 == 0) {
                        iE3 = c03Var3.getColor();
                    }
                    paint.setColor(iE3);
                    uc4Var2.j.getClass();
                    int i31 = uc4Var2.j.h;
                    canvas.drawLine(f, (i31 / 2.0f) + f6, f5, (i31 / 2.0f) + f6, paint);
                }
                return f7;
            }
            if (Math.max(i3, pc4Var.h) < Math.min(i4, pc4Var.i)) {
                if (pc4Var.k) {
                    canvas2.save();
                    float f22 = fMax - f13;
                    if ((as2Var.b & 549755813888L) != 0) {
                        Path path = new Path();
                        float f23 = uc4Var.j.d;
                        path.moveTo(f13, f23);
                        float f24 = f23 * f3;
                        path.lineTo(f13 - f24, f4);
                        float f25 = f13 + f22;
                        path.lineTo(f25 - f24, f4);
                        path.lineTo(f25, f23);
                        path.close();
                        canvas2.clipPath(path);
                    } else {
                        canvas2.clipRect(f13, f4, f22 + f13, uc4Var.j.h);
                    }
                }
                pc4Var.m = as2Var;
                uc4Var.a(i3, i2, i, i2, z, canvas2, f, f11, pc4Var);
                pc4Var.m = null;
                pc4Var.a = -1L;
                if (!pc4Var.k) {
                    return f11;
                }
                canvas2.restore();
                return f11;
            }
        }
        return f11;
    }

    public final void j(int i, int i2, nc4 nc4Var) {
        pc4 pc4Var = new pc4();
        pc4Var.h = i;
        pc4Var.i = i2;
        rc4 rc4Var = new rc4();
        rc4Var.a = true;
        rc4Var.d = false;
        rc4Var.e = pc4Var;
        rc4Var.f = nc4Var;
        pc4Var.j = rc4Var;
        l(new qc4(this, pc4Var), true);
        pc4Var.j.a();
    }

    public final void k(int i, int i2, Canvas canvas, float f, float f2, boolean z, oc4 oc4Var) {
        pc4 pc4Var = new pc4();
        pc4Var.h = i;
        pc4Var.i = i2;
        pc4Var.b = f;
        pc4Var.c = f2;
        pc4Var.k = z;
        pc4Var.l = oc4Var;
        qc4 qc4Var = new qc4(this, pc4Var);
        qc4Var.c = canvas;
        l(qc4Var, true);
    }

    public final void l(sc4 sc4Var, boolean z) {
        mv1 wn1Var = (!z || this.d.z <= 0) ? this.e : new wn1(this.e);
        hm2 hm2VarM = null;
        for (int i = 0; i < wn1Var.j(); i++) {
            int iR = wn1Var.r(i);
            int iMax = Math.max(wn1Var.m(i), this.f);
            int iMin = Math.min(iR, this.g);
            if (iMax < iMin) {
                hm2VarM = m(iMax);
                boolean zT = wn1Var.t(i);
                ArrayList arrayList = new ArrayList();
                while (hm2VarM.c >= this.i.size()) {
                    if (iMax >= iMin) {
                        boolean zA = sc4Var.a(arrayList, zT, hm2VarM);
                        int size = this.h.size();
                        while (true) {
                            int i2 = hm2VarM.b + 1;
                            if (i2 >= size || ((as2) this.h.get(i2)).a > iMin) {
                                break;
                            } else {
                                hm2VarM.b++;
                            }
                        }
                        if (!zA) {
                            break;
                        }
                    } else {
                        jm3 jm3Var = new jm3();
                        jm3Var.a = iMax;
                        jm3Var.b = iMin;
                        jm3Var.c = zT;
                        arrayList.add(jm3Var);
                        iMax = iMin;
                    }
                }
                this.i.get(hm2VarM.c).getClass();
                st4.n();
                return;
            }
        }
        int i3 = hm2VarM == null ? 0 : hm2VarM.c;
        ArrayList arrayList2 = new ArrayList();
        if (i3 < this.i.size()) {
            this.i.get(i3).getClass();
            st4.n();
        } else {
            if (arrayList2.isEmpty()) {
                return;
            }
            if (hm2VarM == null) {
                hm2VarM = m(this.g);
            }
            hm2VarM.c = i3;
            sc4Var.a(arrayList2, false, hm2VarM);
        }
    }

    public final hm2 m(int i) {
        as2 as2Var = this.c;
        as2Var.a = i;
        int iBinarySearch = Collections.binarySearch(this.h, as2Var, o);
        if (iBinarySearch < 0) {
            iBinarySearch = -(iBinarySearch + 1);
        }
        if (iBinarySearch == this.h.size()) {
            iBinarySearch--;
        }
        while (iBinarySearch > 0 && ((as2) this.h.get(iBinarySearch)).a >= i) {
            iBinarySearch--;
        }
        if (this.i.size() > 0) {
            this.i.get(0).getClass();
            st4.n();
            return null;
        }
        hm2 hm2Var = new hm2(9);
        hm2Var.b = iBinarySearch;
        hm2Var.c = 0;
        return hm2Var;
    }

    public final void n(ud0 ud0Var, int i, int i2, List list, List list2, bv0 bv0Var, c03 c03Var, t6 t6Var, vc4 vc4Var) {
        this.d = ud0Var;
        this.f = i;
        this.g = i2;
        this.h = list;
        this.i = list2;
        this.e = bv0Var;
        this.k = c03Var;
        this.j = vc4Var;
        this.l = t6Var;
        vc4Var.b.getClass();
    }
}
