package defpackage;

import android.R;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.SparseArray;
import io.github.rosemoe.sora.widget.CodeEditor;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u11 {
    public static final int[] I = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] J = {R.attr.state_enabled};
    public Paint.FontMetricsInt A;
    public Paint.FontMetricsInt B;
    public int C;
    public lg0 D;
    public ud0 E;
    public ld0 F;
    public volatile boolean G;
    public boolean H;
    public final aq a;
    public final c03 b;
    public final c03 c;
    public final Rect d;
    public final RectF e;
    public final Path f;
    public final c03 g;
    public final RectF h;
    public final RectF i;
    public final t6 j = new t6((byte) 0, 6);
    public final mn2 k = new mn2();
    public final t6 l = new t6((byte) 0, 6);
    public final pn2 m;
    public final SparseArray n;
    public final SparseArray o;
    public final CodeEditor p;
    public final ArrayList q;
    public Paint.FontMetricsInt r;
    public Drawable s;
    public Drawable t;
    public Drawable u;
    public Drawable v;
    public final Drawable w;
    public final Drawable x;
    public final Drawable y;
    public volatile long z;

    public u11(CodeEditor codeEditor) {
        pn2 pn2Var = new pn2();
        long[] jArr = bq3.a;
        pn2Var.a = jArr;
        long[] jArr2 = ef2.a;
        pn2Var.b = jArr2;
        pn2Var.c = jArr2;
        int iB = bq3.b(6);
        int iMax = iB > 0 ? Math.max(7, bq3.a(iB)) : 0;
        pn2Var.d = iMax;
        if (iMax != 0) {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            qe.k0(jArr);
        }
        pn2Var.a = jArr;
        int i = iMax >> 3;
        long j = 255 << ((iMax & 7) << 3);
        jArr[i] = (jArr[i] & (~j)) | j;
        pn2Var.b = new long[iMax];
        pn2Var.c = new long[iMax];
        this.m = pn2Var;
        this.n = new SparseArray();
        this.o = new SparseArray();
        this.q = new ArrayList();
        new ArrayList();
        this.p = codeEditor;
        this.h = new RectF();
        this.i = new RectF();
        aq aqVar = new aq();
        aqVar.b = new float[128];
        this.a = aqVar;
        c03 c03Var = new c03(codeEditor.A1);
        this.b = c03Var;
        c03Var.setAntiAlias(true);
        c03 c03Var2 = new c03(false);
        this.c = c03Var2;
        c03Var2.setStrokeWidth(codeEditor.getDpUnit() * 1.8f);
        c03Var2.setStrokeCap(Paint.Cap.ROUND);
        c03Var2.setTypeface(Typeface.MONOSPACE);
        c03Var2.setAntiAlias(true);
        c03 c03Var3 = new c03(false);
        this.g = c03Var3;
        c03Var3.setAntiAlias(true);
        this.r = c03Var.getFontMetricsInt();
        this.A = c03Var2.getFontMetricsInt();
        this.d = new Rect();
        this.e = new RectF();
        this.f = new Path();
        this.w = codeEditor.getContext().getDrawable(com.getsurfboard.R.drawable.line_break);
        this.x = codeEditor.getContext().getDrawable(com.getsurfboard.R.drawable.softwrap_left);
        this.y = codeEditor.getContext().getDrawable(com.getsurfboard.R.drawable.softwrap_right);
        this.D = codeEditor.getCursor();
        this.F = codeEditor.getText();
    }

    public static boolean B(int i, int i2, int i3, boolean z) {
        return (i != i3 || z) && i >= i2 && i <= i3;
    }

    public final void A() {
        this.p.getStyles();
    }

    public final void C() {
        CodeEditor codeEditor = this.p;
        boolean z = codeEditor.A1;
        c03 c03Var = this.b;
        c03Var.b = z;
        this.B = this.g.getFontMetricsInt();
        this.A = this.c.getFontMetricsInt();
        this.r = c03Var.getFontMetricsInt();
        codeEditor.getRenderContext().a();
        G();
        codeEditor.h(true);
        codeEditor.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [n11] */
    public final void D(final Canvas canvas, final float f, int i, int i2, final int i3, final float f2, final int i4) {
        if (i3 != 0 || (f2 > 0.0f && i4 != 0)) {
            F(canvas, f, i, i2, null, new nc4() { // from class: n11
                @Override // defpackage.nc4
                public final boolean a(float f3, float f4) {
                    int i5;
                    u11 u11Var = this.a;
                    RectF rectF = u11Var.e;
                    c03 c03Var = u11Var.c;
                    float f5 = f;
                    if (f5 + f3 < 0.0f) {
                        return true;
                    }
                    rectF.top = u11Var.z(0);
                    rectF.bottom = u11Var.y(0);
                    rectF.left = f3;
                    rectF.right = f4;
                    int i6 = i3;
                    Canvas canvas2 = canvas;
                    if (i6 != 0) {
                        c03Var.setColor(i6);
                        u11Var.m(canvas2, rectF, c03Var);
                    }
                    float f6 = f2;
                    if (f6 > 0.0f && (i5 = i4) != 0) {
                        c03Var.setStyle(Paint.Style.STROKE);
                        c03Var.setColor(i5);
                        c03Var.setStrokeWidth(f6);
                        u11Var.m(canvas2, rectF, c03Var);
                        c03Var.setStyle(Paint.Style.FILL);
                    }
                    return f5 + f4 > ((float) u11Var.p.getWidth());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [q11] */
    public final void E(final Canvas canvas, float f, int i, int i2, final int i3, final int i4, final int i5) {
        c03 c03Var = this.b;
        c03Var.setColor(i3);
        CodeEditor codeEditor = this.p;
        this.c.setStrokeWidth(codeEditor.getRowHeightOfText() * 0.1f);
        codeEditor.getProps().getClass();
        c03Var.setStyle(Paint.Style.FILL_AND_STROKE);
        c03Var.setFakeBoldText(true);
        F(canvas, f, i, i2, new oc4() { // from class: q11
            @Override // defpackage.oc4
            public final void a(Canvas canvas2, char[] cArr, int i6, int i7, int i8, int i9, boolean z, float f2, float f3, vc4 vc4Var, as2 as2Var) {
                Canvas canvas3;
                u11 u11Var = this.a;
                c03 c03Var2 = u11Var.b;
                c03 c03Var3 = u11Var.c;
                RectF rectF = u11Var.e;
                if (as2Var == null) {
                    return;
                }
                int i10 = i4;
                Canvas canvas4 = canvas;
                if (i10 != 0) {
                    rectF.top = u11Var.z(0);
                    rectF.bottom = u11Var.y(0);
                    rectF.left = f2;
                    rectF.right = f2 + f3;
                    c03Var3.setColor(i10);
                    u11Var.m(canvas4, rectF, c03Var3);
                }
                long j = as2Var.b;
                if (i3 != 0) {
                    c03Var2.setTextSkewX((549755813888L & j) != 0 ? -0.2f : 0.0f);
                    c03Var2.setStrikeThruText((j & 1099511627776L) != 0);
                    canvas3 = canvas4;
                    canvas3.drawTextRun(cArr, i6, i7, i8, i9, f2, vc4Var.f, z, u11Var.b);
                } else {
                    canvas3 = canvas4;
                }
                int i11 = i5;
                if (i11 != 0) {
                    c03Var3.setColor(i11);
                    float f4 = vc4Var.d - (vc4Var.e * 0.05f);
                    canvas3.drawLine(f2, f4, f2 + f3, f4, u11Var.c);
                }
            }
        }, null);
        c03Var.setStyle(Paint.Style.FILL);
        c03Var.setFakeBoldText(false);
        c03Var.setTextSkewX(0.0f);
        c03Var.setStrikeThruText(false);
    }

    public final void F(Canvas canvas, float f, int i, int i2, q11 q11Var, n11 n11Var) {
        q30 q30Var;
        u11 u11Var = this;
        if (q11Var == null && n11Var == null) {
            return;
        }
        CodeEditor codeEditor = u11Var.p;
        int firstVisibleRow = codeEditor.getFirstVisibleRow();
        int lastVisibleRow = codeEditor.getLastVisibleRow();
        w82 layout = codeEditor.getLayout();
        int iD = layout.D(i);
        int iD2 = layout.D(i2);
        q30 q30VarJ = u11Var.D.b.j(i);
        q30 q30VarJ2 = u11Var.D.b.j(i2);
        km3 km3VarS = layout.s(iD, u11Var.n);
        int i3 = iD;
        while (i3 <= iD2 && km3VarS.hasNext()) {
            im3 next = km3VarS.next();
            if (firstVisibleRow > i3 || i3 > lastVisibleRow) {
                q30Var = q30VarJ;
            } else {
                int i4 = i3 == iD ? q30VarJ.c : next.d;
                int i5 = i3 == iD2 ? q30VarJ2.c : next.e;
                uc4 uc4VarD = u11Var.d(i3);
                float fX = ((codeEditor.getNonPrintablePaintingFlags() & 128) == 0 || next.b) ? f : u11Var.x() + f;
                q30Var = q30VarJ;
                float fMax = Math.max(0.0f, -fX);
                float width = fMax + codeEditor.getWidth();
                canvas.save();
                canvas.translate(fX + next.g, (codeEditor.getRowHeight() * i3) - codeEditor.getOffsetY());
                if (n11Var != null) {
                    uc4VarD.j(i4, i5, n11Var);
                }
                if (q11Var != null) {
                    uc4VarD.k(i4, i5, canvas, fMax, width, true, q11Var);
                }
                canvas.restore();
            }
            i3++;
            u11Var = this;
            q30VarJ = q30Var;
        }
    }

    public final void G() {
        this.z = SystemClock.elapsedRealtimeNanos();
    }

    public final void a(t11 t11Var, int i, int i2) {
        long jU = u(i, i2);
        t11Var.e = ((int) (jU >> 32)) == 1;
        t11Var.f = ((int) (jU & 4294967295L)) == 1;
    }

    public final void b(uc4 uc4Var, int i) {
        lg0 lg0Var;
        q30 q30Var;
        int i2;
        q30 q30Var2;
        int i3;
        if (!this.D.a() || i < (i2 = (q30Var = (lg0Var = this.D).c).b) || i > (i3 = (q30Var2 = lg0Var.d).b)) {
            return;
        }
        int i4 = i == i2 ? q30Var.c : 0;
        int i5 = i == i3 ? q30Var2.c : this.E.f;
        int iMax = Math.max(uc4Var.f, i4);
        int iMin = Math.min(uc4Var.g, i5);
        if (iMax < iMin) {
            uc4Var.m = iMax;
            uc4Var.n = iMin;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r28, int r29, long r30, boolean r32) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u11.c(int, int, long, boolean):void");
    }

    public final uc4 d(int i) {
        a54 styles = this.p.getStyles();
        lb lbVar = styles != null ? styles.a : null;
        sz3 lbVar2 = lbVar != null ? new lb(11, (Object) lbVar, false) : null;
        if (lbVar2 == null) {
            lbVar2 = i41.f;
        }
        im3 im3VarN = this.p.getLayout().N(i);
        ud0 ud0VarO = this.F.o(im3VarN.a);
        uc4 uc4Var = new uc4();
        jj2 jj2VarK = this.p.getRenderContext().a.K(im3VarN.a);
        t6 t6Var = (jj2VarK == null || jj2VarK.c < this.z) ? null : jj2VarK.b;
        uc4Var.n(ud0VarO, im3VarN.d, im3VarN.e, lbVar2.g(im3VarN.a), im3VarN.f, this.F.p(im3VarN.a), this.b, (t6Var == null || t6Var.f <= ud0VarO.f) ? null : t6Var, e());
        b(uc4Var, im3VarN.a);
        return uc4Var;
    }

    public final vc4 e() {
        CodeEditor codeEditor = this.p;
        int tabWidth = codeEditor.getTabWidth();
        Paint.FontMetricsInt fontMetricsInt = this.r;
        int iB = codeEditor.B(0);
        int iA = codeEditor.A(0) - (codeEditor.getLineSpacingPixels() / 2);
        int rowHeightOfText = codeEditor.getRowHeightOfText();
        int iZ = codeEditor.z(0);
        codeEditor.getRowHeight();
        int iA2 = codeEditor.A(0);
        int rowHeight = codeEditor.getRowHeight();
        codeEditor.getProps().getClass();
        return new vc4(tabWidth, fontMetricsInt, iB, iA, rowHeightOfText, iZ, iA2, rowHeight, codeEditor, codeEditor.getColorScheme(), this.c, this.g, this.B);
    }

    public final void f(Canvas canvas, float f, float f2, float f3, boolean z) {
        float f4 = f3 * 0.2f;
        float f5 = 0.866f * f4;
        Path path = this.f;
        path.reset();
        path.moveTo(f, f2);
        if (z) {
            f5 = -f5;
        }
        path.lineTo(f5 + f, (f4 / 2.0f) + f2);
        path.lineTo(f, f2 + f4);
        path.close();
        canvas.drawPath(path, this.b);
    }

    public final void g(Canvas canvas, int i, RectF rectF) {
        if (i != 0) {
            c03 c03Var = this.b;
            c03Var.setColor(i);
            canvas.drawRect(rectF, c03Var);
        }
    }

    public final void h(Canvas canvas, float f, int i) {
        CodeEditor codeEditor = this.p;
        boolean z = codeEditor.s1 && !codeEditor.Z0 && codeEditor.getOffsetX() > 0;
        float dividerWidth = codeEditor.getDividerWidth() + f;
        if (dividerWidth < 0.0f) {
            return;
        }
        float fMax = Math.max(0.0f, f);
        float height = codeEditor.getHeight();
        RectF rectF = this.e;
        rectF.bottom = height;
        rectF.top = 0.0f;
        int offsetY = codeEditor.getOffsetY();
        if (offsetY < 0) {
            float f2 = offsetY;
            rectF.bottom -= f2;
            rectF.top -= f2;
        }
        rectF.left = fMax;
        rectF.right = dividerWidth;
        c03 c03Var = this.b;
        if (z) {
            canvas.save();
            canvas.clipRect(rectF.left, rectF.top, codeEditor.getWidth(), rectF.bottom);
            c03Var.setShadowLayer(Math.min(codeEditor.getDpUnit() * 8.0f, codeEditor.getOffsetX()), 0.0f, 0.0f, -16777216);
        }
        g(canvas, i, rectF);
        if (z) {
            canvas.restore();
            c03Var.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    public final void i(Canvas canvas, int i, int i2, float f, float f2, int i3) {
        int i4;
        int i5;
        int i6;
        float f3 = f2 + f;
        if (f3 <= 0.0f) {
            return;
        }
        c03 c03Var = this.c;
        Paint.Align textAlign = c03Var.getTextAlign();
        CodeEditor codeEditor = this.p;
        if (textAlign != codeEditor.getLineNumberAlign()) {
            c03Var.setTextAlign(codeEditor.getLineNumberAlign());
        }
        c03Var.setColor(i3);
        Paint.FontMetricsInt fontMetricsInt = this.A;
        int i7 = fontMetricsInt.descent;
        int i8 = fontMetricsInt.ascent;
        float rowHeight = (((((codeEditor.getRowHeight() * i2) + codeEditor.A(i2)) / 2.0f) - ((i7 - i8) / 2.0f)) - i8) - codeEditor.getOffsetY();
        char[] cArrS = gb4.S(20);
        int i9 = i + 1;
        if (i9 >= 0) {
            i5 = -i9;
            i4 = 0;
        } else {
            i4 = 1;
            i5 = i9;
        }
        int i10 = -10;
        int i11 = 1;
        while (true) {
            if (i11 >= 10) {
                i6 = i4 + 10;
                break;
            } else if (i5 > i10) {
                i6 = i11 + i4;
                break;
            } else {
                i10 *= 10;
                i11++;
            }
        }
        int i12 = i6;
        char[] cArr = je.z;
        char[] cArr2 = je.A;
        boolean z = i9 < 0;
        if (!z) {
            i9 = -i9;
        }
        int i13 = i12;
        while (i9 <= -100) {
            int i14 = i9 / 100;
            int i15 = (i14 * 100) - i9;
            cArrS[i13 - 1] = cArr2[i15];
            i13 -= 2;
            cArrS[i13] = cArr[i15];
            i9 = i14;
        }
        int i16 = i13 - 1;
        int i17 = -i9;
        cArrS[i16] = cArr2[i17];
        if (i9 < -9) {
            i16 = i13 - 2;
            cArrS[i16] = cArr[i17];
        }
        if (z) {
            cArrS[i16 - 1] = '-';
        }
        int i18 = s11.a[codeEditor.getLineNumberAlign().ordinal()];
        if (i18 == 1) {
            canvas.drawText(cArrS, 0, i12, f, rowHeight, this.c);
        } else if (i18 == 2) {
            canvas.drawText(cArrS, 0, i12, f3, rowHeight, this.c);
        } else if (i18 == 3) {
            canvas.drawText(cArrS, 0, i12, ((codeEditor.getDividerMarginLeft() + f2) / 2.0f) + f, rowHeight, this.c);
        }
        gb4.U(cArrS);
    }

    public final void j(float f, float f2, int i, Canvas canvas) {
        float f3 = f2 + f;
        if (f3 < 0.0f) {
            return;
        }
        float fMax = Math.max(0.0f, f);
        CodeEditor codeEditor = this.p;
        float height = codeEditor.getHeight();
        RectF rectF = this.e;
        rectF.bottom = height;
        rectF.top = 0.0f;
        int offsetY = codeEditor.getOffsetY();
        if (offsetY < 0) {
            float f4 = offsetY;
            rectF.bottom -= f4;
            rectF.top -= f4;
        }
        rectF.left = fMax;
        rectF.right = f3;
        g(canvas, i, rectF);
    }

    public final void k(Canvas canvas, float f, int i, Drawable drawable) {
        int iA;
        int offsetY;
        CodeEditor codeEditor = this.p;
        if (i == -1) {
            iA = codeEditor.A(0);
            offsetY = codeEditor.getLineSpacingPixels() / 2;
        } else {
            iA = codeEditor.A(i) - (codeEditor.getLineSpacingPixels() / 2);
            offsetY = codeEditor.getOffsetY();
        }
        float f2 = iA - offsetY;
        float rowHeightOfText = codeEditor.getRowHeightOfText();
        Objects.requireNonNull(codeEditor.getProps());
        float f3 = rowHeightOfText * 0.5f;
        if (f3 <= 0.0f || drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return;
        }
        drawable.setColorFilter(codeEditor.getColorScheme().e(31), PorterDuff.Mode.SRC_ATOP);
        drawable.setBounds((int) f, (int) (f2 - f3), (int) (f + ((intrinsicWidth / intrinsicHeight) * f3)), (int) f2);
        drawable.draw(canvas);
    }

    public final void l(Canvas canvas, int i, int i2, int i3) {
        CodeEditor codeEditor = this.p;
        float rowHeight = (codeEditor.getRowHeight() * i2) - codeEditor.getOffsetY();
        RectF rectF = this.e;
        rectF.top = rowHeight;
        rectF.bottom = codeEditor.A(i2) - codeEditor.getOffsetY();
        rectF.left = 0.0f;
        rectF.right = i3;
        g(canvas, i, rectF);
    }

    public final void m(Canvas canvas, RectF rectF, c03 c03Var) {
        CodeEditor codeEditor = this.p;
        codeEditor.getProps().getClass();
        float rowHeight = codeEditor.getRowHeight();
        codeEditor.getProps().getClass();
        float rowHeight2 = codeEditor.getRowHeight();
        codeEditor.getProps().getClass();
        canvas.drawRoundRect(rectF, rowHeight * 0.13f, rowHeight2 * 0.13f, c03Var);
    }

    public final void n(Canvas canvas, RectF rectF, int i, int i2) {
        c03 c03Var = this.b;
        c03Var.setColor(i);
        m(canvas, rectF, c03Var);
        if (i2 == 0) {
            return;
        }
        c03Var.setColor(i2);
        c03Var.setStyle(Paint.Style.STROKE);
        c03Var.setStrokeWidth(this.p.getTextBorderWidth());
        m(canvas, rectF, c03Var);
        c03Var.setStyle(Paint.Style.FILL);
    }

    public final void o(final Canvas canvas, int i, uc4 uc4Var, int i2, int i3, int i4, int i5, final int i6, final int i7) {
        int iMax = Math.max(i2, i4);
        int iMin = Math.min(i3, i5);
        if (iMax < iMin) {
            int iZ = z(i);
            CodeEditor codeEditor = this.p;
            float offsetY = iZ - codeEditor.getOffsetY();
            RectF rectF = this.e;
            rectF.top = offsetY;
            rectF.bottom = y(i) - codeEditor.getOffsetY();
            float fT = codeEditor.T() - codeEditor.getOffsetX();
            if (codeEditor.Z0 && !codeEditor.getLayout().N(i).b && (codeEditor.getNonPrintablePaintingFlags() & 128) != 0) {
                fT += x();
            }
            final float f = fT;
            if (uc4Var == null) {
                uc4Var = d(i);
            }
            final int width = codeEditor.getWidth();
            uc4Var.j(iMax, iMin, new nc4() { // from class: r11
                @Override // defpackage.nc4
                public final boolean a(float f2, float f3) {
                    u11 u11Var = this.a;
                    RectF rectF2 = u11Var.e;
                    float f4 = f;
                    float f5 = f2 + f4;
                    rectF2.left = f5;
                    float f6 = f4 + f3;
                    rectF2.right = f6;
                    if (f6 < 0.0f || f5 > width) {
                        return false;
                    }
                    u11Var.n(canvas, rectF2, i6, i7);
                    return true;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x06fd  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x070f  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x076d  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x07d2  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x07df  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x07ed  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0806 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x080d  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x08c6  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x08e8  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0950  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0a3e  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0aa1  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0af1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(android.graphics.Canvas r54, float r55, defpackage.t6 r56, java.util.ArrayList r57, defpackage.mn2 r58, defpackage.ln2 r59) {
        /*
            Method dump skipped, instruction units count: 2982
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u11.p(android.graphics.Canvas, float, t6, java.util.ArrayList, mn2, ln2):void");
    }

    public final void q(Canvas canvas) {
        float f;
        float fCurrentTimeMillis;
        float f2;
        float f3;
        int[] iArr;
        CodeEditor codeEditor;
        float rowHeight;
        float[] fArr;
        float f4;
        Path path;
        float f5;
        float f6;
        RectF rectF = this.h;
        rectF.setEmpty();
        RectF rectF2 = this.i;
        rectF2.setEmpty();
        CodeEditor codeEditor2 = this.p;
        d21 eventHandler = codeEditor2.getEventHandler();
        eventHandler.getClass();
        if (System.currentTimeMillis() - eventHandler.o >= 3200 && !eventHandler.q && !eventHandler.r) {
            if (!codeEditor2.O()) {
                return;
            } else {
                codeEditor2.getProps().getClass();
            }
        }
        d21 eventHandler2 = codeEditor2.getEventHandler();
        eventHandler2.getClass();
        if (System.currentTimeMillis() - eventHandler2.o < 3000 || eventHandler2.q || eventHandler2.r) {
            f = 1.0f;
            fCurrentTimeMillis = 0.0f;
        } else {
            f = 1.0f;
            if (System.currentTimeMillis() - eventHandler2.o < 3000 || System.currentTimeMillis() - eventHandler2.o >= 3200) {
                fCurrentTimeMillis = 1.0f;
            } else {
                eventHandler2.a.postInvalidateOnAnimation();
                fCurrentTimeMillis = (((System.currentTimeMillis() - eventHandler2.o) - 3000) * 1.0f) / 200.0f;
            }
        }
        if (codeEditor2.O()) {
            codeEditor2.getProps().getClass();
            fCurrentTimeMillis = 0.0f;
        }
        float dpUnit = codeEditor2.getDpUnit() * 10.0f;
        boolean z = codeEditor2.q1;
        int[] iArr2 = J;
        int[] iArr3 = I;
        float f7 = f;
        RectF rectF3 = this.e;
        if (!z || codeEditor2.Z0 || codeEditor2.getScrollMaxX() <= (codeEditor2.getWidth() * 3) / 4) {
            f2 = 60.0f;
        } else {
            canvas.save();
            canvas.translate(0.0f, dpUnit * fCurrentTimeMillis);
            if (codeEditor2.getEventHandler().r) {
                f2 = 60.0f;
                rectF3.set(0.0f, codeEditor2.getHeight() - (codeEditor2.getDpUnit() * 10.0f), codeEditor2.getWidth(), codeEditor2.getHeight());
                Drawable drawable = this.t;
                if (drawable != null) {
                    drawable.setBounds((int) rectF3.left, (int) rectF3.top, (int) rectF3.right, (int) rectF3.bottom);
                    this.t.draw(canvas);
                } else {
                    g(canvas, codeEditor2.getColorScheme().e(13), rectF3);
                }
            } else {
                f2 = 60.0f;
            }
            int width = codeEditor2.getWidth();
            float scrollMaxX = codeEditor2.getScrollMaxX();
            float width2 = (width / (codeEditor2.getWidth() + scrollMaxX)) * codeEditor2.getWidth();
            float dpUnit2 = codeEditor2.getDpUnit() * f2;
            if (width2 <= dpUnit2) {
                width2 = dpUnit2;
            }
            float width3 = (codeEditor2.getWidth() - width2) * (codeEditor2.getOffsetX() / scrollMaxX);
            rectF3.top = codeEditor2.getHeight() - (codeEditor2.getDpUnit() * 10.0f);
            rectF3.bottom = codeEditor2.getHeight();
            rectF3.right = width2 + width3;
            rectF3.left = width3;
            rectF2.set(rectF3);
            Drawable drawable2 = this.s;
            if (drawable2 != null) {
                drawable2.setState(codeEditor2.getEventHandler().r ? iArr3 : iArr2);
                this.s.setBounds((int) rectF3.left, (int) rectF3.top, (int) rectF3.right, (int) rectF3.bottom);
                this.s.draw(canvas);
            } else {
                g(canvas, codeEditor2.getColorScheme().e(codeEditor2.getEventHandler().r ? 12 : 11), rectF3);
            }
            canvas.restore();
        }
        if (!codeEditor2.p1 || codeEditor2.getScrollMaxY() <= codeEditor2.getHeight() / 2) {
            return;
        }
        canvas.save();
        canvas.translate(dpUnit * fCurrentTimeMillis, 0.0f);
        if (codeEditor2.getEventHandler().q) {
            rectF3.right = codeEditor2.getWidth();
            rectF3.left = codeEditor2.getWidth() - (codeEditor2.getDpUnit() * 10.0f);
            rectF3.top = 0.0f;
            float height = codeEditor2.getHeight();
            rectF3.bottom = height;
            Drawable drawable3 = this.v;
            if (drawable3 != null) {
                drawable3.setBounds((int) rectF3.left, (int) rectF3.top, (int) rectF3.right, (int) height);
                this.v.draw(canvas);
            } else {
                g(canvas, codeEditor2.getColorScheme().e(13), rectF3);
            }
        }
        int height2 = codeEditor2.getHeight();
        float scrollMaxY = codeEditor2.getScrollMaxY() + height2;
        float f8 = height2;
        float fMax = Math.max((f8 / scrollMaxY) * f8, codeEditor2.getDpUnit() * f2);
        float offsetY = (f8 - fMax) * ((codeEditor2.getOffsetY() * f7) / codeEditor2.getScrollMaxY());
        if (codeEditor2.getEventHandler().q && codeEditor2.f1) {
            int lnPanelPositionMode = codeEditor2.getLnPanelPositionMode();
            int lnPanelPosition = codeEditor2.getLnPanelPosition();
            ((t60) codeEditor2.getLineNumberTipTextProvider()).getClass();
            String strA = dw2.A(codeEditor2.getFirstVisibleLine() + 1, "L");
            c03 c03Var = this.b;
            float textSize = c03Var.getTextSize();
            c03Var.setTextSize(codeEditor2.getLineInfoTextSize());
            Paint.FontMetricsInt fontMetricsInt = this.r;
            this.r = c03Var.getFontMetricsInt();
            float dpUnit3 = codeEditor2.getDpUnit() * 8.0f;
            float fMeasureText = c03Var.measureText(strA);
            f3 = fMax;
            if (lnPanelPositionMode == 0) {
                rectF3.top = ((codeEditor2.getHeight() / 2.0f) - (codeEditor2.getRowHeight() / 2.0f)) - dpUnit3;
                rectF3.bottom = (codeEditor2.getRowHeight() / 2.0f) + (codeEditor2.getHeight() / 2.0f) + dpUnit3;
                float f9 = fMeasureText / 2.0f;
                rectF3.left = ((codeEditor2.getWidth() / 2.0f) - f9) - dpUnit3;
                rectF3.right = (codeEditor2.getWidth() / 2.0f) + f9 + dpUnit3;
                float f10 = dpUnit3 * 2.0f;
                float height3 = (codeEditor2.getHeight() / 2.0f) + f10;
                float dpUnit4 = codeEditor2.getDpUnit() * 10.0f;
                if (lnPanelPosition != 15) {
                    if ((lnPanelPosition | 2) == lnPanelPosition) {
                        rectF3.top = dpUnit4;
                        rectF3.bottom = codeEditor2.getRowHeight() + dpUnit4 + f10;
                        iArr = iArr2;
                        height3 = codeEditor2.z(0) + dpUnit4 + dpUnit3;
                    } else {
                        iArr = iArr2;
                    }
                    if ((lnPanelPosition | 8) == lnPanelPosition) {
                        rectF3.top = ((codeEditor2.getHeight() - dpUnit4) - f10) - codeEditor2.getRowHeight();
                        rectF3.bottom = codeEditor2.getHeight() - dpUnit4;
                        height3 = ((codeEditor2.z(0) + (codeEditor2.getHeight() - codeEditor2.getRowHeight())) - dpUnit4) - dpUnit3;
                    }
                    if ((lnPanelPosition | 1) == lnPanelPosition) {
                        rectF3.left = dpUnit4;
                        rectF3.right = dpUnit4 + f10 + fMeasureText;
                    }
                    if ((lnPanelPosition | 4) == lnPanelPosition) {
                        rectF3.right = codeEditor2.getWidth() - dpUnit4;
                        rectF3.left = ((codeEditor2.getWidth() - dpUnit4) - f10) - fMeasureText;
                    }
                } else {
                    iArr = iArr2;
                }
                f6 = height3;
                int iE = codeEditor2.getColorScheme().e(16);
                if (iE != 0) {
                    c03Var.setColor(iE);
                    canvas.drawRoundRect(rectF3, rectF3.height() * 0.13f, rectF3.height() * 0.13f, c03Var);
                }
                codeEditor = codeEditor2;
                f5 = 0.0f;
            } else {
                iArr = iArr2;
                rectF3.right = codeEditor2.getWidth() - (codeEditor2.getDpUnit() * 30.0f);
                float f11 = dpUnit3 * 2.0f;
                rectF3.left = ((codeEditor2.getWidth() - (codeEditor2.getDpUnit() * 30.0f)) - f11) - fMeasureText;
                if (lnPanelPosition == 2) {
                    rectF3.top = offsetY;
                    rectF3.bottom = codeEditor2.getRowHeight() + offsetY + f11;
                    rowHeight = codeEditor2.z(0) + offsetY + dpUnit3;
                    fArr = new float[8];
                    int i = 0;
                    for (int i2 = 8; i < i2; i2 = 8) {
                        if (i != 5) {
                            fArr[i] = rectF3.height() * 0.5f;
                        }
                        i++;
                    }
                } else if (lnPanelPosition == 8) {
                    float f12 = offsetY + f3;
                    rectF3.top = (f12 - codeEditor2.getRowHeight()) - f11;
                    rectF3.bottom = f12;
                    rowHeight = f12 - (codeEditor2.z(0) / 2.0f);
                    float[] fArr2 = new float[8];
                    int i3 = 0;
                    for (int i4 = 8; i3 < i4; i4 = 8) {
                        if (i3 != 3) {
                            fArr2[i3] = rectF3.height() * 0.5f;
                        }
                        i3++;
                    }
                    fArr = fArr2;
                } else {
                    float f13 = (f3 / 2.0f) + offsetY;
                    rectF3.top = (f13 - (codeEditor2.getRowHeight() / 2.0f)) - dpUnit3;
                    rectF3.bottom = (codeEditor2.getRowHeight() / 2.0f) + f13 + dpUnit3;
                    rowHeight = (f13 - (codeEditor2.getRowHeight() / 2.0f)) + codeEditor2.z(0);
                    fArr = null;
                }
                Path path2 = this.f;
                if (fArr != null) {
                    path2.reset();
                    path2.addRoundRect(rectF3, fArr, Path.Direction.CW);
                    codeEditor = codeEditor2;
                    f4 = rowHeight;
                    path = path2;
                    f5 = 0.0f;
                } else {
                    float f14 = -dpUnit3;
                    rectF3.offset(f14, 0.0f);
                    rectF3.right += dpUnit3;
                    Matrix matrix = fp.a;
                    path2.reset();
                    float fWidth = rectF3.width();
                    float fHeight = rectF3.height() / 2.0f;
                    codeEditor = codeEditor2;
                    f4 = rowHeight;
                    float fSqrt = (float) Math.sqrt(2.0d);
                    float f15 = fSqrt * fHeight;
                    float fMax2 = Math.max(fHeight + f15, fWidth);
                    fp.a(path2, fHeight, fHeight, fHeight, 90.0f, 180.0f);
                    float f16 = fMax2 - f15;
                    fp.a(path2, f16, fHeight, fHeight, -90.0f, 45.0f);
                    float f17 = fHeight / 5.0f;
                    fp.a(path2, fMax2 - (fSqrt * f17), fHeight, f17, -45.0f, 90.0f);
                    fp.a(path2, f16, fHeight, fHeight, 45.0f, 45.0f);
                    path = path2;
                    path.close();
                    Matrix matrix2 = fp.a;
                    matrix2.reset();
                    matrix2.postTranslate(rectF3.left, rectF3.top);
                    path.transform(matrix2);
                    f5 = f14 / 2.0f;
                }
                c03Var.setColor(codeEditor.getColorScheme().e(16));
                canvas.drawPath(path, c03Var);
                f6 = f4;
            }
            float f18 = ((rectF3.left + rectF3.right) / 2.0f) + f5;
            c03Var.setColor(codeEditor.getColorScheme().e(17));
            c03Var.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(strA, f18, f6, c03Var);
            c03Var.setTextAlign(Paint.Align.LEFT);
            c03Var.setTextSize(textSize);
            this.r = fontMetricsInt;
        } else {
            f3 = fMax;
            iArr = iArr2;
            codeEditor = codeEditor2;
        }
        rectF3.right = codeEditor.getWidth();
        rectF3.left = codeEditor.getWidth() - (codeEditor.getDpUnit() * 10.0f);
        rectF3.top = offsetY;
        rectF3.bottom = offsetY + f3;
        rectF.set(rectF3);
        Drawable drawable4 = this.u;
        if (drawable4 != null) {
            drawable4.setState(codeEditor.getEventHandler().q ? iArr3 : iArr);
            this.u.setBounds((int) rectF3.left, (int) rectF3.top, (int) rectF3.right, (int) rectF3.bottom);
            this.u.draw(canvas);
        } else {
            g(canvas, codeEditor.getColorScheme().e(codeEditor.getEventHandler().q ? 12 : 11), rectF3);
        }
        canvas.restore();
    }

    public final float r(Canvas canvas, int i, float f, float f2, sz3 sz3Var, boolean z) {
        this.E = v(i);
        int i2 = v(i).f;
        sz3 sz3Var2 = (sz3Var == null || sz3Var.l() <= 0) ? i41.f : sz3Var;
        uc4 uc4Var = new uc4();
        this.p.getInlayHints();
        List list = Collections.EMPTY_LIST;
        jj2 jj2VarK = this.p.getRenderContext().a.K(i);
        t6 t6Var = (jj2VarK == null || jj2VarK.c < this.z) ? null : jj2VarK.b;
        uc4Var.n(this.E, 0, i2, sz3Var2.g(i), list, w(i), this.b, (t6Var == null || t6Var.f <= this.E.f) ? null : t6Var, e());
        b(uc4Var, i);
        if (canvas != null) {
            canvas.save();
            this.p.getRowHeight();
            canvas.translate(f, 0.0f + f2);
            if (z) {
                float f3 = -f;
                float fMax = Math.max(0.0f, f3);
                uc4Var.c(canvas, fMax, Math.max(fMax, f3 + this.p.getWidth()));
            } else {
                uc4Var.c(canvas, 0.0f, Float.MAX_VALUE);
            }
            canvas.restore();
        }
        if (canvas != null) {
            return 0.0f;
        }
        qc4 qc4Var = new qc4(uc4Var, new pc4());
        uc4Var.l(qc4Var, true);
        return qc4Var.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0739  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x073f  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0885  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ba  */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v144 */
    /* JADX WARN: Type inference failed for: r5v145 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(android.graphics.Canvas r38) {
        /*
            Method dump skipped, instruction units count: 3077
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u11.s(android.graphics.Canvas):void");
    }

    public final void t(Canvas canvas, uc4 uc4Var, char[] cArr, int i, int i2, int i3, int i4, boolean z, float f, float f2, int i5, int i6) {
        float f3;
        char c;
        int tabWidth;
        int i7;
        char c2;
        char c3;
        int i8;
        int i9 = i;
        int i10 = i9 + i2;
        int iMax = Math.max(i9, Math.min(i10, i5));
        int iMax2 = Math.max(i9, Math.min(i10, i6));
        if (iMax < iMax2) {
            float f4 = this.b.a;
            CodeEditor codeEditor = this.p;
            float f5 = 2.0f;
            int i11 = 0;
            float rowHeightOfText = (codeEditor.getRowHeightOfText() / 2.0f) + codeEditor.B(0);
            float f6 = z ? f + f2 : f;
            while (iMax < iMax2) {
                char c4 = cArr[iMax];
                if (c4 == ' ' || c4 == '\t') {
                    f3 = f5;
                    c = ' ';
                    float fG = uc4Var.g(iMax, i9, iMax, i3, i3 + i4, z);
                    f6 = z ? (f + f2) - fG : f + fG;
                } else {
                    f3 = f5;
                    c = ' ';
                }
                if (c4 == c) {
                    i7 = i11;
                    tabWidth = 1;
                } else if (c4 != '\t') {
                    tabWidth = i11;
                    i7 = tabWidth;
                } else if ((codeEditor.getNonPrintablePaintingFlags() & c) != 0) {
                    tabWidth = codeEditor.getTabWidth();
                    i7 = i11;
                } else {
                    tabWidth = i11;
                    i7 = 1;
                }
                for (int i12 = i11; i12 < tabWidth; i12++) {
                    float f7 = (i12 * f4) + f6;
                    float f8 = ((f7 + f4) + f7) / f3;
                    if (z) {
                        f8 -= f4;
                    }
                    aq aqVar = this.a;
                    float[] fArr = aqVar.b;
                    int length = fArr.length;
                    int i13 = aqVar.a;
                    if (length < (i13 + 1) * 2) {
                        float[] fArr2 = new float[fArr.length << 1];
                        System.arraycopy(fArr, 0, fArr2, 0, i13 * 2);
                        aqVar.b = fArr2;
                        fArr = fArr2;
                    }
                    int i14 = aqVar.a;
                    int i15 = i14 * 2;
                    fArr[i15] = f8 + aqVar.c;
                    fArr[i15 + 1] = aqVar.d + rowHeightOfText;
                    aqVar.a = i14 + 1;
                }
                if (i7 != 0) {
                    float tabWidth2 = codeEditor.getTabWidth() * f4;
                    float f9 = 0.05f * tabWidth2;
                    float f10 = z ? -tabWidth2 : 0.0f;
                    c2 = c4;
                    c3 = '\t';
                    i8 = 0;
                    canvas.drawLine(f6 + f9 + f10, rowHeightOfText, ((tabWidth2 + f6) + f10) - f9, rowHeightOfText, this.c);
                } else {
                    c2 = c4;
                    c3 = '\t';
                    i8 = 0;
                }
                if (c2 == ' ' || c2 == c3) {
                    float tabWidth3 = c2 == ' ' ? f4 : codeEditor.getTabWidth() * f4;
                    if (z) {
                        tabWidth3 = -tabWidth3;
                    }
                    f6 += tabWidth3;
                }
                iMax++;
                i9 = i;
                f5 = f3;
                i11 = i8;
            }
        }
    }

    public final long u(int i, int i2) {
        bv0 bv0VarW = w(i);
        int length = bv0VarW.b.length;
        if (length == 1) {
            return ez4.M(0, bv0VarW.t(0) ? 1 : 0);
        }
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (i4 == length || (bv0VarW.m(i3) <= i2 && i2 < bv0VarW.r(i3))) {
                this.p.getProps().getClass();
                return ez4.M(1, bv0VarW.t(i3) ? 1 : 0);
            }
            i3 = i4;
        }
        return ez4.M(0, 0);
    }

    public final ud0 v(int i) {
        if (!this.G) {
            return this.F.o(i);
        }
        ud0 ud0Var = (ud0) this.n.get(i);
        if (ud0Var != null) {
            return ud0Var;
        }
        ud0 ud0VarO = this.F.o(i);
        this.n.put(i, ud0VarO);
        return ud0VarO;
    }

    public final bv0 w(int i) {
        if (!this.G) {
            return this.F.p(i);
        }
        bv0 bv0Var = (bv0) this.o.get(i);
        if (bv0Var != null) {
            return bv0Var;
        }
        bv0 bv0VarP = this.F.p(i);
        this.o.put(i, bv0VarP);
        return bv0VarP;
    }

    public final float x() {
        CodeEditor codeEditor = this.p;
        float rowHeightOfText = codeEditor.getRowHeightOfText();
        Objects.requireNonNull(codeEditor.getProps());
        float f = rowHeightOfText * 0.5f;
        Drawable drawable = codeEditor.getContext().getDrawable(com.getsurfboard.R.drawable.line_break);
        if (drawable == null) {
            return 0.0f;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0 || f <= 0.0f) {
            return 0.0f;
        }
        return (intrinsicWidth / intrinsicHeight) * f;
    }

    public final int y(int i) {
        CodeEditor codeEditor = this.p;
        codeEditor.getProps().getClass();
        return codeEditor.A(i);
    }

    public final int z(int i) {
        CodeEditor codeEditor = this.p;
        codeEditor.getProps().getClass();
        return codeEditor.getRowHeight() * i;
    }
}
