package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final float h(java.util.ArrayList r26, boolean r27, defpackage.hm2 r28, android.graphics.Canvas r29, float r30, defpackage.pc4 r31) {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uc4.h(java.util.ArrayList, boolean, hm2, android.graphics.Canvas, float, pc4):float");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float i(int r28, int r29, boolean r30, defpackage.as2 r31, android.graphics.Canvas r32, float r33, defpackage.pc4 r34) {
        /*
            Method dump skipped, instruction units count: 983
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uc4.i(int, int, boolean, as2, android.graphics.Canvas, float, pc4):float");
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
