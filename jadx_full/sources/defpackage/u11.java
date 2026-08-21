package defpackage;

import android.R;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.sentry.android.core.a1;
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
    */
    public final void c(int i, int i2, long j, boolean z) {
        char c;
        char c2;
        boolean z2;
        int iHash;
        ld0 ld0Var = this.F;
        CodeEditor codeEditor = this.p;
        ri3 renderContext = codeEditor.getRenderContext();
        for (int i3 = i; i3 <= i2 && i3 < ld0Var.b.size(); i3++) {
            ud0 ud0VarV = z ? v(i3) : this.F.o(i3);
            v62 v62Var = codeEditor.getRenderContext().a;
            ArrayList arrayList = (ArrayList) v62Var.z;
            jj2 jj2VarK = v62Var.K(i3);
            if (jj2VarK == null) {
                jj2VarK = new jj2();
                jj2VarK.a = i3;
                jj2VarK.b = null;
                jj2VarK.c = 0L;
                arrayList.add(jj2VarK);
                while (arrayList.size() > 75 && !arrayList.isEmpty()) {
                    arrayList.remove(0);
                }
            }
            if (jj2VarK.c < j) {
                t6 t6Var = jj2VarK.b;
                if (t6Var != null) {
                    c = '\b';
                    if (t6Var.f >= ud0VarV.f) {
                        z2 = false;
                        c2 = 1;
                    }
                    List listC = codeEditor.C(i3);
                    Integer numValueOf = Integer.valueOf(ud0VarV.f);
                    Integer numValueOf2 = Integer.valueOf(codeEditor.getTabWidth());
                    c03 c03Var = this.b;
                    Integer numValueOf3 = Integer.valueOf(c03Var.getFlags());
                    Float fValueOf = Float.valueOf(c03Var.getTextSize());
                    Float fValueOf2 = Float.valueOf(c03Var.getTextScaleX());
                    Float fValueOf3 = Float.valueOf(c03Var.getLetterSpacing());
                    String fontFeatureSettings = c03Var.getFontFeatureSettings();
                    Integer numValueOf4 = Integer.valueOf(c03Var.getTypeface().hashCode());
                    Object[] objArr = new Object[9];
                    objArr[0] = listC;
                    objArr[c2] = numValueOf;
                    objArr[2] = numValueOf2;
                    objArr[3] = numValueOf3;
                    objArr[4] = fValueOf;
                    objArr[5] = fValueOf2;
                    objArr[6] = fValueOf3;
                    objArr[7] = fontFeatureSettings;
                    objArr[c] = numValueOf4;
                    iHash = Objects.hash(objArr);
                    if (((mn2) renderContext.a.f).b(i3) == iHash || z2) {
                        mn2 mn2Var = (mn2) renderContext.a.f;
                        if (i3 >= 0 || i3 >= mn2Var.b) {
                            s53.k("Index must be between 0 and size");
                            return;
                        }
                        int[] iArr = mn2Var.a;
                        int i4 = iArr[i3];
                        iArr[i3] = iHash;
                        km3 km3VarS = codeEditor.D0.s(codeEditor.D0.D(ld0Var.l(i3, 0)), null);
                        uc4 uc4Var = new uc4();
                        ud0 ud0VarO = ld0Var.o(i3);
                        bv0 bv0VarP = ld0Var.p(i3);
                        int i5 = ud0VarO.f + 10;
                        t6 t6Var2 = jj2VarK.b;
                        if (t6Var2 == null || t6Var2.f < i5) {
                            t6Var2 = new t6(i5, 11);
                            jj2VarK.b = t6Var2;
                        }
                        while (km3VarS.hasNext()) {
                            im3 next = km3VarS.next();
                            if (next.a != i3) {
                                break;
                            }
                            ud0 ud0Var = ud0VarO;
                            uc4Var.n(ud0Var, next.d, next.e, listC, next.f, bv0VarP, this.b, null, e());
                            pc4 pc4Var = new pc4();
                            pc4Var.n = t6Var2;
                            uc4Var.l(new qc4(uc4Var, pc4Var), c2);
                            ud0VarO = ud0Var;
                        }
                        int i6 = ud0VarO.f;
                        char c3 = 0;
                        uc4Var.f = 0;
                        uc4Var.g = i6;
                        float[][] fArr = (float[][]) t6Var2.z;
                        int length = fArr.length;
                        int i7 = 0;
                        while (i7 < length) {
                            float[] fArr2 = fArr[i7];
                            float f = fArr2[c3];
                            fArr2[c3] = 0.0f;
                            float f2 = f;
                            int i8 = 1;
                            while (i8 <= fArr2.length - 1) {
                                float f3 = fArr2[i8];
                                fArr2[i8] = fArr2[i8 - 1] + f2;
                                i8++;
                                f2 = f3;
                            }
                            i7++;
                            c3 = 0;
                        }
                        jj2VarK.c = j;
                    }
                } else {
                    c = '\b';
                }
                c2 = 1;
                jj2VarK.b = new t6(Math.max(ud0VarV.f + 8, 90), 11);
                z2 = true;
                List listC2 = codeEditor.C(i3);
                Integer numValueOf5 = Integer.valueOf(ud0VarV.f);
                Integer numValueOf22 = Integer.valueOf(codeEditor.getTabWidth());
                c03 c03Var2 = this.b;
                Integer numValueOf32 = Integer.valueOf(c03Var2.getFlags());
                Float fValueOf4 = Float.valueOf(c03Var2.getTextSize());
                Float fValueOf22 = Float.valueOf(c03Var2.getTextScaleX());
                Float fValueOf32 = Float.valueOf(c03Var2.getLetterSpacing());
                String fontFeatureSettings2 = c03Var2.getFontFeatureSettings();
                Integer numValueOf42 = Integer.valueOf(c03Var2.getTypeface().hashCode());
                Object[] objArr2 = new Object[9];
                objArr2[0] = listC2;
                objArr2[c2] = numValueOf5;
                objArr2[2] = numValueOf22;
                objArr2[3] = numValueOf32;
                objArr2[4] = fValueOf4;
                objArr2[5] = fValueOf22;
                objArr2[6] = fValueOf32;
                objArr2[7] = fontFeatureSettings2;
                objArr2[c] = numValueOf42;
                iHash = Objects.hash(objArr2);
                if (((mn2) renderContext.a.f).b(i3) == iHash) {
                    mn2 mn2Var2 = (mn2) renderContext.a.f;
                    if (i3 >= 0) {
                    }
                    s53.k("Index must be between 0 and size");
                    return;
                }
            }
        }
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
    */
    public final void p(Canvas canvas, float f, t6 t6Var, ArrayList arrayList, mn2 mn2Var, ln2 ln2Var) {
        q30 q30VarJ;
        pn2 pn2Var;
        lb lbVar;
        int i;
        sz3 sz3Var;
        t6 t6Var2;
        final int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        final int i3;
        CodeEditor codeEditor;
        lb lbVar2;
        float f6;
        int i4;
        final float f7;
        final u11 u11Var;
        int i5;
        int i6;
        final Canvas canvas2;
        q30 q30Var;
        boolean zA;
        ArrayList arrayList2;
        q30 q30Var2;
        q30 selectingTarget;
        int iMin;
        int iMin2;
        boolean z;
        float fIntBitsToFloat;
        t6 t6Var3;
        int i7;
        int i8;
        char c;
        float f8;
        int i9;
        float f9;
        int i10;
        t6 t6Var4;
        im3 im3Var;
        int i11;
        float f10;
        int i12;
        q30 q30Var3;
        lb lbVar3;
        q30 q30Var4;
        pn2 pn2Var2;
        int i13;
        Canvas canvas3;
        float f11;
        int i14;
        lg0 lg0Var;
        q30 q30Var5;
        int i15;
        q30 q30Var6;
        int i16;
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        int i17;
        long[] jArr4;
        long[] jArr5;
        long[] jArr6;
        int i18;
        int i19;
        int i20;
        t6 t6Var5;
        boolean z2;
        int i21;
        final u11 u11Var2 = this;
        Canvas canvas4 = canvas;
        int firstVisibleRow = u11Var2.p.getFirstVisibleRow();
        km3 km3VarS = u11Var2.p.getLayout().s(firstVisibleRow, u11Var2.n);
        lb lbVar4 = u11Var2.p.getStyles() == null ? null : u11Var2.p.getStyles().a;
        t6 t6Var6 = u11Var2.l;
        pn2 pn2Var3 = u11Var2.m;
        t6Var6.f = 0;
        pn2Var3.a();
        int i22 = u11Var2.D.a() ? -1 : u11Var2.D.c.b;
        int iE = u11Var2.p.getColorScheme().e(9);
        int iD = u11Var2.D.a() ? -1 : u11Var2.p.getLayout().D(u11Var2.D.c.a);
        int iE2 = u11Var2.p.getColorScheme().e(80);
        CodeEditor codeEditor2 = u11Var2.p;
        lb lbVar5 = lbVar4;
        float fX = (!codeEditor2.Z0 || (codeEditor2.getNonPrintablePaintingFlags() & 128) == 0) ? 0.0f : u11Var2.x();
        if (!u11Var2.p.B0.b.a() || (i21 = u11Var2.p.B0.b.a) < 0) {
            q30VarJ = null;
        } else {
            ld0 ld0Var = u11Var2.F;
            if (i21 < ld0Var.A) {
                q30VarJ = ld0Var.n().j(u11Var2.p.B0.b.a);
            }
        }
        CodeEditor codeEditor3 = u11Var2.p;
        w90 w90Var = codeEditor3.B0.b;
        int i23 = w90Var.b - w90Var.a;
        q30 q30Var7 = codeEditor3.getEventHandler().I;
        q30 q30Var8 = q30Var7;
        float fMin = (u11Var2.p.I0 & (-185)) != 0 ? Math.min(r10.getRowHeight(), u11Var2.b.a) * 0.125f : 0.0f;
        if (Build.VERSION.SDK_INT >= 29 && !u11Var2.p.Z0 && canvas4.isHardwareAccelerated()) {
            CodeEditor codeEditor4 = u11Var2.p;
            if (codeEditor4.j2) {
                codeEditor4.getRenderContext().b.d(firstVisibleRow, u11Var2.p.getLastVisibleRow());
            }
        }
        float offsetX = u11Var2.p.getOffsetX() - u11Var2.p.T();
        if (((tm2) u11Var2.p.getCursorAnimator()).b()) {
            CodeEditor codeEditor5 = u11Var2.p;
            pn2Var = pn2Var3;
            if (codeEditor5.o1 && codeEditor5.H()) {
                u11Var2.p.getProps().getClass();
                u11Var2.p.getProps().getClass();
            }
        } else {
            pn2Var = pn2Var3;
        }
        int i24 = iE2;
        int i25 = -1;
        for (int i26 = firstVisibleRow; i26 <= u11Var2.p.getLastVisibleRow() && km3VarS.hasNext(); i26++) {
            int i27 = km3VarS.next().a;
            if (i25 != i27) {
                u11Var2.E = u11Var2.v(i27);
                i25 = i27;
            }
            u11Var2.p.getProps().getClass();
            if (i27 != i22 || ((tm2) u11Var2.p.getCursorAnimator()).b()) {
                z2 = false;
            } else {
                CodeEditor codeEditor6 = u11Var2.p;
                if (codeEditor6.o1 && codeEditor6.H()) {
                    z2 = true;
                }
            }
            CodeEditor codeEditor7 = u11Var2.p;
            if (z2) {
                codeEditor7.getProps().getClass();
            } else {
                codeEditor7.getStyles();
            }
            if (z2) {
                u11Var2.l(canvas4, iE, i26, u11Var2.d.right);
                mn2Var.a(mn2Var.b + 1);
                int[] iArr = mn2Var.a;
                int i28 = mn2Var.b;
                iArr[i28] = i26;
                mn2Var.b = i28 + 1;
            }
        }
        int i29 = 1;
        if (((tm2) u11Var2.p.getCursorAnimator()).b()) {
            CodeEditor codeEditor8 = u11Var2.p;
            if (codeEditor8.o1) {
                codeEditor8.getProps().getClass();
                RectF rectF = u11Var2.e;
                CodeEditor codeEditor9 = u11Var2.p;
                float fFloatValue = ((Float) ((tm2) codeEditor9.getCursorAnimator()).d.getAnimatedValue()).floatValue() - codeEditor9.getOffsetY();
                rectF.bottom = fFloatValue;
                rectF.top = fFloatValue - ((Float) ((tm2) codeEditor9.getCursorAnimator()).e.getAnimatedValue()).floatValue();
                rectF.left = 0.0f;
                rectF.right = u11Var2.d.right;
                u11Var2.g(canvas4, iE, rectF);
            }
        }
        km3VarS.reset();
        int i30 = firstVisibleRow;
        while (i30 <= u11Var2.p.getLastVisibleRow() && km3VarS.hasNext()) {
            im3 next = km3VarS.next();
            canvas4.save();
            canvas4.translate(next.g, 0.0f);
            int i31 = next.a;
            int i32 = u11Var2.v(i31).f;
            if (i25 != i31) {
                CodeEditor codeEditor10 = u11Var2.p;
                codeEditor10.getClass();
                c = ' ';
                t6Var6.f = 0;
                x11 x11Var = codeEditor10.a2;
                f8 = 2.0f;
                if (x11Var.b == null || x11Var.c == null || !x11Var.b() || (t6Var5 = codeEditor10.a2.e) == null) {
                    i7 = i32;
                } else {
                    int iL = codeEditor10.J1.l(i31, 0);
                    int i33 = codeEditor10.J1.o(i31).f + iL;
                    i7 = i32;
                    int iMax = Math.max(0, t6Var6.m(iL) - 1);
                    while (iMax < t6Var5.f) {
                        long j = t6Var5.j(iMax);
                        int i34 = iMax;
                        i8 = iD;
                        int i35 = (int) (j >> 32);
                        t6 t6Var7 = t6Var5;
                        int iMax2 = Math.max(i35, iL);
                        int iMin3 = Math.min((int) (j & 4294967295L), i33);
                        if (iMax2 < iMin3) {
                            t6Var6.e(ez4.M(iMax2 - iL, iMin3 - iL));
                        }
                        if (i35 > i33) {
                            break;
                        }
                        iMax = i34 + 1;
                        iD = i8;
                        t6Var5 = t6Var7;
                    }
                }
                i8 = iD;
                u11Var2.p.getClass();
                pn2Var.a();
                u11Var2.E = u11Var2.v(i31);
                i9 = i31;
            } else {
                i7 = i32;
                i8 = iD;
                c = ' ';
                f8 = 2.0f;
                i9 = i25;
            }
            float f12 = -offsetX;
            float f13 = !next.b ? f12 + fX : f12;
            if (t6Var6.f > 0) {
                uc4 uc4VarD = u11Var2.d(i30);
                int i36 = i30;
                int i37 = 0;
                while (i37 < t6Var6.f) {
                    long j2 = t6Var6.j(i37);
                    t6 t6Var8 = t6Var6;
                    uc4 uc4Var = uc4VarD;
                    u11Var2.o(canvas, i36, uc4Var, (int) (j2 >> c), (int) (j2 & 4294967295L), next.d, next.e, u11Var2.p.getColorScheme().e(29), u11Var2.p.getColorScheme().e(78));
                    i37++;
                    i8 = i8;
                    uc4VarD = uc4Var;
                    next = next;
                    pn2Var = pn2Var;
                    i31 = i31;
                    f13 = f13;
                    q30VarJ = q30VarJ;
                    firstVisibleRow = firstVisibleRow;
                    f12 = f12;
                    offsetX = offsetX;
                    i9 = i9;
                    lbVar5 = lbVar5;
                    q30Var8 = q30Var8;
                    t6Var6 = t6Var8;
                }
                f9 = offsetX;
                i10 = i36;
                i13 = i8;
                t6Var4 = t6Var6;
                im3Var = next;
                i11 = i31;
                f10 = f12;
                i12 = i9;
                q30Var3 = q30VarJ;
                lbVar3 = lbVar5;
                q30Var4 = q30Var8;
                pn2Var2 = pn2Var;
            } else {
                f9 = offsetX;
                i10 = i30;
                t6Var4 = t6Var6;
                im3Var = next;
                i11 = i31;
                f10 = f12;
                i12 = i9;
                q30Var3 = q30VarJ;
                lbVar3 = lbVar5;
                q30Var4 = q30Var8;
                pn2Var2 = pn2Var;
                i13 = i8;
            }
            float f14 = f13;
            int i38 = firstVisibleRow;
            char c2 = c;
            if (pn2Var2.e > 0) {
                uc4 uc4VarD2 = u11Var2.d(i10);
                long[] jArr7 = pn2Var2.b;
                long[] jArr8 = pn2Var2.c;
                long[] jArr9 = pn2Var2.a;
                int length = jArr9.length - 2;
                if (length >= 0) {
                    int i39 = 0;
                    while (true) {
                        long j3 = jArr9[i39];
                        char c3 = c2;
                        f11 = f14;
                        if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i40 = 8 - ((~(i39 - length)) >>> 31);
                            long j4 = j3;
                            int i41 = 0;
                            while (i41 < i40) {
                                if ((j4 & 255) < 128) {
                                    int i42 = (i39 << 3) + i41;
                                    long j5 = jArr7[i42];
                                    long j6 = jArr8[i42];
                                    jArr6 = jArr9;
                                    i19 = i39;
                                    i18 = length;
                                    jArr5 = jArr8;
                                    i20 = i41;
                                    jArr4 = jArr7;
                                    u11Var2 = this;
                                    u11Var2.o(canvas, i10, uc4VarD2, (int) (j5 >> c3), (int) (j5 & 4294967295L), im3Var.d, im3Var.e, (int) (j6 >> c3), (int) (j6 & 4294967295L));
                                } else {
                                    jArr4 = jArr7;
                                    jArr5 = jArr8;
                                    jArr6 = jArr9;
                                    i18 = length;
                                    i19 = i39;
                                    i20 = i41;
                                }
                                j4 >>= 8;
                                i41 = i20 + 1;
                                jArr7 = jArr4;
                                jArr8 = jArr5;
                                jArr9 = jArr6;
                                length = i18;
                                i39 = i19;
                            }
                            jArr = jArr7;
                            jArr2 = jArr8;
                            jArr3 = jArr9;
                            int i43 = length;
                            int i44 = i39;
                            canvas3 = canvas;
                            if (i40 != 8) {
                                break;
                            }
                            length = i43;
                            i17 = i44;
                        } else {
                            jArr = jArr7;
                            jArr2 = jArr8;
                            jArr3 = jArr9;
                            canvas3 = canvas;
                            i17 = i39;
                        }
                        if (i17 == length) {
                            break;
                        }
                        i39 = i17 + 1;
                        jArr7 = jArr;
                        jArr8 = jArr2;
                        c2 = c3;
                        jArr9 = jArr3;
                        f14 = f11;
                    }
                } else {
                    canvas3 = canvas;
                    f11 = f14;
                }
            }
            if (u11Var2.D.a() && i11 >= (i15 = (q30Var5 = (lg0Var = u11Var2.D).c).b) && i11 <= (i16 = (q30Var6 = lg0Var.d).b)) {
                int i45 = i11 == i15 ? q30Var5.c : 0;
                int i46 = i11 == i16 ? q30Var6.c : i7;
                if (u11Var2.v(i11).f == 0 && i11 != u11Var2.D.d.b) {
                    u11Var2.e.top = u11Var2.z(i10) - u11Var2.p.getOffsetY();
                    u11Var2.e.bottom = u11Var2.y(i10) - u11Var2.p.getOffsetY();
                    RectF rectF2 = u11Var2.e;
                    float f15 = f11;
                    rectF2.left = f15;
                    rectF2.right = (u11Var2.b.a * f8) + f15;
                    u11Var2.n(canvas3, rectF2, u11Var2.p.getColorScheme().e(6), u11Var2.p.getColorScheme().e(79));
                } else if (i45 < i46) {
                    u11Var2.o(canvas3, i10, null, i45, i46, im3Var.d, im3Var.e, u11Var2.p.getColorScheme().e(6), u11Var2.p.getColorScheme().e(79));
                }
            }
            Canvas canvas5 = canvas3;
            canvas5.restore();
            if (i10 != i13 || i24 == 0) {
                i14 = i24;
            } else {
                u11Var2.e.top = (u11Var2.p.getRowHeight() * i10) - u11Var2.p.getOffsetY();
                u11Var2.e.bottom = u11Var2.p.A(i10) - u11Var2.p.getOffsetY();
                u11Var2.e.left = Math.max(0.0f, f10);
                u11Var2.e.right = u11Var2.p.getWidth();
                i14 = i24;
                u11Var2.b.setColor(i14);
                u11Var2.b.setStyle(Paint.Style.STROKE);
                u11Var2.b.setStrokeWidth(u11Var2.p.getDpUnit());
                canvas5.drawRect(u11Var2.e, u11Var2.b);
                u11Var2.b.setStyle(Paint.Style.FILL);
            }
            iD = i13;
            i30 = i10 + 1;
            canvas4 = canvas5;
            i24 = i14;
            pn2Var = pn2Var2;
            q30VarJ = q30Var3;
            firstVisibleRow = i38;
            offsetX = f9;
            i25 = i12;
            lbVar5 = lbVar3;
            q30Var8 = q30Var4;
            t6Var6 = t6Var4;
        }
        Canvas canvas6 = canvas4;
        float f16 = offsetX;
        q30 q30Var9 = q30VarJ;
        lb lbVar6 = lbVar5;
        q30 q30Var10 = q30Var8;
        int i47 = 31;
        char c4 = ' ';
        int i48 = firstVisibleRow;
        km3VarS.reset();
        u11Var2.p.getSnippetController().getClass();
        u11Var2.p.getProps().getClass();
        sz3 sz3Var2 = null;
        t6 t6Var9 = null;
        int i49 = i48;
        int i50 = -1;
        int i51 = 0;
        int i52 = 0;
        while (i49 <= u11Var2.p.getLastVisibleRow() && km3VarS.hasNext()) {
            im3 next2 = km3VarS.next();
            final int i53 = next2.a;
            final int i54 = u11Var2.v(i53).f;
            int i55 = i48;
            if (i49 != i55 || ln2Var == null) {
                if (next2.b) {
                    i48 = i55;
                    t6Var.e(ez4.M(i53, i49));
                }
                if (i50 == i53) {
                    jj2 jj2VarK = u11Var2.p.getRenderContext().a.K(i53);
                    t6 t6Var10 = (jj2VarK == null || jj2VarK.c != u11Var2.z || (t6Var3 = jj2VarK.b) == null || t6Var3.f <= i54) ? null : t6Var3;
                    u11Var2.E = u11Var2.v(i53);
                    if (sz3Var2 != null) {
                        try {
                            sz3Var2.d(-1);
                        } catch (Exception e) {
                            a1.o("EditorRenderer", "Failed to release SpanReader", e);
                        }
                    }
                    lbVar = lbVar6;
                    sz3 lbVar7 = lbVar == null ? i41.f : new lb(11, (Object) lbVar, false);
                    try {
                        lbVar7.d(i53);
                    } catch (Exception e2) {
                        a1.o("EditorRenderer", "Failed to read span", e2);
                        lbVar7 = i41.f;
                    }
                    if (lbVar7.l() == 0) {
                        lbVar7 = i41.f;
                    }
                    sz3 sz3Var3 = lbVar7;
                    CodeEditor codeEditor11 = u11Var2.p;
                    if ((codeEditor11.I0 & (-185)) != 0) {
                        ud0 ud0Var = u11Var2.E;
                        codeEditor11.getClass();
                        char[] cArr = ud0Var.b;
                        int i56 = ud0Var.f;
                        int i57 = 0;
                        while (i57 < i56) {
                            char c5 = cArr[i57];
                            if (c5 != '\t' && c5 != c4) {
                                break;
                            }
                            i57++;
                            c4 = ' ';
                        }
                        if (i57 == i56 || (codeEditor11.I0 & 6) == 0) {
                            long jM = ez4.M(i57, i56);
                            i51 = (int) (jM & 4294967295L);
                            sz3Var = sz3Var3;
                            t6Var2 = t6Var10;
                            i = i53;
                            f2 = f16;
                            i2 = (int) (jM >> 32);
                        } else {
                            while (i56 > 0) {
                                char c6 = cArr[i56 - 1];
                                if (c6 != '\t' && c6 != ' ') {
                                    break;
                                } else {
                                    i56--;
                                }
                            }
                            long jM2 = ez4.M(i57, i56);
                            i51 = (int) (jM2 & 4294967295L);
                            sz3Var = sz3Var3;
                            t6Var2 = t6Var10;
                            i = i53;
                            f2 = f16;
                            i2 = (int) (jM2 >> 32);
                        }
                        float f17 = next2.g;
                        f3 = (-f2) + f17;
                        f4 = f2 - f17;
                        if (next2.b || (u11Var2.p.getNonPrintablePaintingFlags() & 128) == 0) {
                            f5 = f;
                        } else {
                            f5 = f;
                            u11Var2.k(canvas6, f5, i49, u11Var2.x);
                            f3 += fX;
                            f4 -= fX;
                        }
                        final int nonPrintablePaintingFlags = u11Var2.p.getNonPrintablePaintingFlags();
                        i3 = i51;
                        codeEditor = u11Var2.p;
                        int i58 = i;
                        if (codeEditor.j2 && !codeEditor.getEventHandler().k && canvas6.isHardwareAccelerated()) {
                            CodeEditor codeEditor12 = u11Var2.p;
                            if (!codeEditor12.Z0) {
                                lbVar2 = lbVar;
                                if (Build.VERSION.SDK_INT >= 29) {
                                    if (next2.e - next2.d > 128) {
                                        codeEditor12.getProps().getClass();
                                    } else {
                                        float fB = codeEditor12.getRenderContext().b.b(f5, (u11Var2.p.getRowHeight() * i49) - u11Var2.p.getOffsetY(), i53, canvas6) + f5;
                                        if (next2.c && (nonPrintablePaintingFlags & 16) != 0) {
                                            u11Var2.k(canvas6, fB, i49, u11Var2.w);
                                        }
                                        f6 = 0.0f;
                                        c4 = ' ';
                                    }
                                }
                                uc4 uc4Var2 = new uc4();
                                uc4Var2.n(u11Var2.E, next2.d, next2.e, sz3Var.g(i53), next2.f, u11Var2.w(i53), u11Var2.b, t6Var2, u11Var2.e());
                                u11Var2.b(uc4Var2, i53);
                                canvas6.save();
                                canvas6.translate(-f4, (u11Var2.p.getRowHeight() * i49) - u11Var2.p.getOffsetY());
                                float fMax = Math.max(0.0f, f4);
                                long jC = uc4Var2.c(canvas6, fMax, u11Var2.p.getWidth() + fMax);
                                canvas6.restore();
                                c4 = ' ';
                                if (((int) (jC >> 32)) != i29) {
                                }
                                fIntBitsToFloat = Float.intBitsToFloat((int) (jC & 4294967295L)) + f3;
                                if (!z) {
                                    if (!next2.c) {
                                        u11Var2.k(canvas6, fIntBitsToFloat, i49, u11Var2.y);
                                    }
                                    f6 = 0.0f;
                                }
                            }
                            uc4 uc4Var22 = new uc4();
                            uc4Var22.n(u11Var2.E, next2.d, next2.e, sz3Var.g(i53), next2.f, u11Var2.w(i53), u11Var2.b, t6Var2, u11Var2.e());
                            u11Var2.b(uc4Var22, i53);
                            canvas6.save();
                            canvas6.translate(-f4, (u11Var2.p.getRowHeight() * i49) - u11Var2.p.getOffsetY());
                            float fMax2 = Math.max(0.0f, f4);
                            long jC2 = uc4Var22.c(canvas6, fMax2, u11Var2.p.getWidth() + fMax2);
                            canvas6.restore();
                            c4 = ' ';
                            if (((int) (jC2 >> 32)) != i29) {
                            }
                            fIntBitsToFloat = Float.intBitsToFloat((int) (jC2 & 4294967295L)) + f3;
                            if (!z) {
                            }
                        } else {
                            lbVar2 = lbVar;
                            uc4 uc4Var222 = new uc4();
                            uc4Var222.n(u11Var2.E, next2.d, next2.e, sz3Var.g(i53), next2.f, u11Var2.w(i53), u11Var2.b, t6Var2, u11Var2.e());
                            u11Var2.b(uc4Var222, i53);
                            canvas6.save();
                            canvas6.translate(-f4, (u11Var2.p.getRowHeight() * i49) - u11Var2.p.getOffsetY());
                            float fMax22 = Math.max(0.0f, f4);
                            long jC22 = uc4Var222.c(canvas6, fMax22, u11Var2.p.getWidth() + fMax22);
                            canvas6.restore();
                            c4 = ' ';
                            z = ((int) (jC22 >> 32)) != i29;
                            fIntBitsToFloat = Float.intBitsToFloat((int) (jC22 & 4294967295L)) + f3;
                            if (!z && next2.c && (nonPrintablePaintingFlags & 16) != 0) {
                                u11Var2.k(canvas6, fIntBitsToFloat, i49, u11Var2.w);
                            } else if (!next2.c && u11Var2.p.Z0 && (nonPrintablePaintingFlags & 128) != 0) {
                                u11Var2.k(canvas6, fIntBitsToFloat, i49, u11Var2.y);
                            }
                            f6 = 0.0f;
                        }
                        if (fMin == f6 || (i2 == i54 && (nonPrintablePaintingFlags & 8) == 0)) {
                            i4 = i3;
                            f7 = f3;
                            u11Var = u11Var2;
                            i5 = i2;
                            i6 = i53;
                            canvas2 = canvas6;
                        } else {
                            final uc4 uc4Var3 = new uc4();
                            uc4Var3.n(u11Var2.E, next2.d, next2.e, sz3Var.g(i53), next2.f, u11Var2.w(i53), u11Var2.b, t6Var2, u11Var2.e());
                            canvas6.save();
                            canvas6.translate(f3, u11Var2.p.B(i49) - u11Var2.p.getOffsetY());
                            aq aqVar = u11Var2.a;
                            float fB2 = u11Var2.p.B(i49) - u11Var2.p.getOffsetY();
                            aqVar.c = f3;
                            aqVar.d = fB2;
                            float fMax3 = Math.max(0.0f, f3);
                            float width = fMax3 + u11Var2.p.getWidth();
                            u11Var2.c.setColor(u11Var2.p.getColorScheme().e(i47));
                            f7 = f3;
                            i5 = i2;
                            i4 = i3;
                            u11Var = this;
                            i6 = i53;
                            uc4Var3.k(next2.d, next2.e, canvas, fMax3, width, false, new oc4() { // from class: o11
                                @Override // defpackage.oc4
                                public final void a(Canvas canvas7, char[] cArr2, int i59, int i60, int i61, int i62, boolean z3, float f18, float f19, vc4 vc4Var, as2 as2Var) {
                                    int i63;
                                    int i64;
                                    lg0 lg0Var2;
                                    q30 q30Var11;
                                    int i65;
                                    int i66;
                                    q30 q30Var12;
                                    int i67;
                                    int i68;
                                    int i69;
                                    u11 u11Var3;
                                    int i70 = nonPrintablePaintingFlags;
                                    int i71 = i70 & 1;
                                    u11 u11Var4 = this.a;
                                    uc4 uc4Var4 = uc4Var3;
                                    int i72 = i2;
                                    if (i71 != 0) {
                                        u11Var4.t(canvas7, uc4Var4, cArr2, i59, i60, i61, i62, z3, f18, f19, 0, i72);
                                    }
                                    int i73 = i70 & 2;
                                    int i74 = i3;
                                    if (i73 != 0) {
                                        u11Var4.t(canvas7, uc4Var4, cArr2, i59, i60, i61, i62, z3, f18, f19, i72, i74);
                                        i72 = i72;
                                        i74 = i74;
                                    }
                                    int i75 = i70 & 4;
                                    int i76 = i72;
                                    int i77 = i54;
                                    if (i75 != 0) {
                                        i63 = i70;
                                        i64 = i76;
                                        u11Var4.t(canvas7, uc4Var4, cArr2, i59, i60, i61, i62, z3, f18, f19, i74, i77);
                                    } else {
                                        i63 = i70;
                                        i64 = i76;
                                    }
                                    if ((i63 & 64) == 0 || !u11Var4.D.a() || (i66 = i53) < (i65 = (q30Var11 = (lg0Var2 = u11Var4.D).c).b) || i66 > (i67 = (q30Var12 = lg0Var2.d).b)) {
                                        return;
                                    }
                                    int i78 = i66 == i65 ? q30Var11.c : 0;
                                    if (i66 == i67) {
                                        i77 = q30Var12.c;
                                    }
                                    if ((i63 & 14) == 0) {
                                        u11Var4.t(canvas7, uc4Var4, cArr2, i59, i60, i61, i62, z3, f18, f19, i78, i77);
                                        return;
                                    }
                                    u11 u11Var5 = u11Var4;
                                    int i79 = i74;
                                    int i80 = i77;
                                    int i81 = i78;
                                    if (i71 == 0) {
                                        i68 = i80;
                                        u11Var5.t(canvas7, uc4Var4, cArr2, i59, i60, i61, i62, z3, f18, f19, i81, Math.min(i64, i80));
                                        u11Var5 = u11Var5;
                                    } else {
                                        i68 = i80;
                                    }
                                    if (i73 == 0) {
                                        i69 = i81;
                                        u11Var3 = u11Var5;
                                        u11Var3.t(canvas7, uc4Var4, cArr2, i59, i60, i61, i62, z3, f18, f19, Math.max(i64, i81), Math.min(i79, i68));
                                    } else {
                                        i69 = i81;
                                        u11Var3 = u11Var5;
                                    }
                                    if (i75 == 0) {
                                        u11Var3.t(canvas7, uc4Var4, cArr2, i59, i60, i61, i62, z3, f18, f19, Math.max(i79, i69), i68);
                                    }
                                }
                            });
                            canvas2 = canvas;
                            canvas2.restore();
                            aq aqVar2 = u11Var.a;
                            aqVar2.c = 0.0f;
                            aqVar2.d = 0.0f;
                        }
                        q30Var = q30Var9;
                        if (q30Var9 != null && i6 == q30Var.b) {
                            int i59 = q30Var.c;
                            int i60 = i59 + i23;
                            iMin = Math.min(Math.max(i59, next2.d), next2.e);
                            iMin2 = Math.min(Math.max(i60, next2.d), next2.e);
                            if (iMin < iMin2) {
                                uc4 uc4Var4 = new uc4();
                                uc4Var4.n(u11Var.E, next2.d, next2.e, sz3Var.g(i6), next2.f, u11Var.F.p(i6), u11Var.b, t6Var2, u11Var.e());
                                u11Var.e.top = u11Var.p.A(i49) - u11Var.p.getOffsetY();
                                RectF rectF3 = u11Var.e;
                                rectF3.bottom = (u11Var.p.getRowHeight() * 0.06f) + rectF3.top;
                                uc4Var4.j(iMin, iMin2, new nc4() { // from class: p11
                                    @Override // defpackage.nc4
                                    public final boolean a(float f18, float f19) {
                                        u11 u11Var3 = this.a;
                                        CodeEditor codeEditor13 = u11Var3.p;
                                        RectF rectF4 = u11Var3.e;
                                        float f20 = f7;
                                        float f21 = f18 + f20;
                                        rectF4.left = f21;
                                        float f22 = f20 + f19;
                                        rectF4.right = f22;
                                        if (f22 > 0.0f && f21 < codeEditor13.getWidth()) {
                                            u11Var3.g(canvas2, codeEditor13.getColorScheme().e(10), rectF4);
                                        }
                                        return rectF4.right < ((float) codeEditor13.getWidth());
                                    }
                                });
                            }
                        }
                        w82 layout = u11Var.p.getLayout();
                        zA = u11Var.D.a();
                        lg0 lg0Var2 = u11Var.D;
                        if (zA) {
                            q30 q30Var11 = lg0Var2.c;
                            if (q30Var11.b == i6 && B(q30Var11.c, next2.d, next2.e, next2.c)) {
                                float fT = u11Var.p.T();
                                q30 q30Var12 = u11Var.D.c;
                                float offsetX2 = (fT + ((v0) layout).b(q30Var12.b, q30Var12.c)[1]) - u11Var.p.getOffsetX();
                                ld0 ld0Var2 = u11Var.F;
                                q30 q30Var13 = u11Var.D.c;
                                int i61 = ld0Var2.t(q30Var13.b, q30Var13.c) ? 2 : 1;
                                u11Var2 = u11Var;
                                t11 t11Var = new t11(u11Var2, offsetX2, u11Var.y(i49) - u11Var.p.getOffsetY(), i61, u11Var.p.getLeftHandleDescriptor());
                                arrayList2 = arrayList;
                                arrayList2.add(t11Var);
                                q30 q30Var14 = u11Var2.D.c;
                                u11Var2.a(t11Var, q30Var14.b, q30Var14.c);
                            } else {
                                arrayList2 = arrayList;
                                u11Var2 = u11Var;
                            }
                            q30 q30Var15 = u11Var2.D.d;
                            if (q30Var15.b == i6 && B(q30Var15.c, next2.d, next2.e, next2.c)) {
                                float fT2 = u11Var2.p.T();
                                q30 q30Var16 = u11Var2.D.d;
                                float offsetX3 = (fT2 + ((v0) layout).b(q30Var16.b, q30Var16.c)[1]) - u11Var2.p.getOffsetX();
                                ld0 ld0Var3 = u11Var2.F;
                                q30 q30Var17 = u11Var2.D.d;
                                t11 t11Var2 = new t11(u11Var2, offsetX3, u11Var2.y(i49) - u11Var2.p.getOffsetY(), ld0Var3.t(q30Var17.b, q30Var17.c) ? 1 : 2, u11Var2.p.getRightHandleDescriptor());
                                u11Var = u11Var2;
                                arrayList2.add(t11Var2);
                                q30 q30Var18 = u11Var.D.d;
                                u11Var.a(t11Var2, q30Var18.b, q30Var18.c);
                                u11Var2 = u11Var;
                            }
                        } else {
                            arrayList2 = arrayList;
                            q30 q30Var19 = lg0Var2.c;
                            if (q30Var19.b == i6 && B(q30Var19.c, next2.d, next2.e, next2.c)) {
                                float fT3 = u11Var.p.T();
                                q30 q30Var20 = u11Var.D.c;
                                u11Var2 = u11Var;
                                t11 t11Var3 = new t11(u11Var2, (fT3 + ((v0) layout).b(q30Var20.b, q30Var20.c)[1]) - u11Var.p.getOffsetX(), u11Var.y(i49) - u11Var.p.getOffsetY(), 0, u11Var.p.getInsertHandleDescriptor());
                                arrayList2.add(t11Var3);
                                q30 q30Var21 = u11Var2.D.c;
                                u11Var2.a(t11Var3, q30Var21.b, q30Var21.c);
                            } else {
                                u11Var2 = u11Var;
                            }
                        }
                        q30Var2 = q30Var10;
                        if (q30Var2 == null) {
                            if (u11Var2.p.O() && u11Var2.p.I1.a() && (selectingTarget = u11Var2.p.getSelectingTarget()) != null && selectingTarget.b == i6 && B(selectingTarget.c, next2.d, next2.e, next2.c)) {
                                i29 = 1;
                                t11 t11Var4 = new t11(u11Var2, (u11Var2.p.T() + ((v0) layout).b(selectingTarget.b, selectingTarget.c)[1]) - u11Var2.p.getOffsetX(), u11Var2.y(i49) - u11Var2.p.getOffsetY(), -1, null);
                                arrayList2.add(t11Var4);
                                u11Var2.a(t11Var4, selectingTarget.b, selectingTarget.c);
                            }
                            i49++;
                            canvas6 = canvas2;
                            q30Var9 = q30Var;
                            q30Var10 = q30Var2;
                            sz3Var2 = sz3Var;
                            f16 = f2;
                            i50 = i58;
                            lbVar6 = lbVar2;
                            t6Var9 = t6Var2;
                            i51 = i4;
                            i52 = i5;
                            i47 = 31;
                        } else if (q30Var2.b == i6 && B(q30Var2.c, next2.d, next2.e, next2.c)) {
                            t11 t11Var5 = new t11(u11Var2, (u11Var2.p.T() + ((v0) layout).b(q30Var2.b, q30Var2.c)[1]) - u11Var2.p.getOffsetX(), u11Var2.y(i49) - u11Var2.p.getOffsetY(), -1, null);
                            arrayList2.add(t11Var5);
                            u11Var2.a(t11Var5, q30Var2.b, q30Var2.c);
                        }
                        i29 = 1;
                        i49++;
                        canvas6 = canvas2;
                        q30Var9 = q30Var;
                        q30Var10 = q30Var2;
                        sz3Var2 = sz3Var;
                        f16 = f2;
                        i50 = i58;
                        lbVar6 = lbVar2;
                        t6Var9 = t6Var2;
                        i51 = i4;
                        i52 = i5;
                        i47 = 31;
                    } else {
                        sz3Var = sz3Var3;
                        t6Var2 = t6Var10;
                        i = i53;
                    }
                } else {
                    lbVar = lbVar6;
                    i = i50;
                    sz3Var = sz3Var2;
                    t6Var2 = t6Var9;
                }
                i2 = i52;
                f2 = f16;
                float f172 = next2.g;
                f3 = (-f2) + f172;
                f4 = f2 - f172;
                if (next2.b) {
                    f5 = f;
                }
                final int nonPrintablePaintingFlags2 = u11Var2.p.getNonPrintablePaintingFlags();
                i3 = i51;
                codeEditor = u11Var2.p;
                int i582 = i;
                if (codeEditor.j2) {
                    lbVar2 = lbVar;
                    uc4 uc4Var2222 = new uc4();
                    uc4Var2222.n(u11Var2.E, next2.d, next2.e, sz3Var.g(i53), next2.f, u11Var2.w(i53), u11Var2.b, t6Var2, u11Var2.e());
                    u11Var2.b(uc4Var2222, i53);
                    canvas6.save();
                    canvas6.translate(-f4, (u11Var2.p.getRowHeight() * i49) - u11Var2.p.getOffsetY());
                    float fMax222 = Math.max(0.0f, f4);
                    long jC222 = uc4Var2222.c(canvas6, fMax222, u11Var2.p.getWidth() + fMax222);
                    canvas6.restore();
                    c4 = ' ';
                    if (((int) (jC222 >> 32)) != i29) {
                    }
                    fIntBitsToFloat = Float.intBitsToFloat((int) (jC222 & 4294967295L)) + f3;
                    if (!z) {
                    }
                }
                if (fMin == f6) {
                    i4 = i3;
                    f7 = f3;
                    u11Var = u11Var2;
                    i5 = i2;
                    i6 = i53;
                    canvas2 = canvas6;
                }
                q30Var = q30Var9;
                if (q30Var9 != null) {
                    int i592 = q30Var.c;
                    int i602 = i592 + i23;
                    iMin = Math.min(Math.max(i592, next2.d), next2.e);
                    iMin2 = Math.min(Math.max(i602, next2.d), next2.e);
                    if (iMin < iMin2) {
                    }
                }
                w82 layout2 = u11Var.p.getLayout();
                zA = u11Var.D.a();
                lg0 lg0Var22 = u11Var.D;
                if (zA) {
                }
                q30Var2 = q30Var10;
                if (q30Var2 == null) {
                }
                i29 = 1;
                i49++;
                canvas6 = canvas2;
                q30Var9 = q30Var;
                q30Var10 = q30Var2;
                sz3Var2 = sz3Var;
                f16 = f2;
                i50 = i582;
                lbVar6 = lbVar2;
                t6Var9 = t6Var2;
                i51 = i4;
                i52 = i5;
                i47 = 31;
            } else {
                ln2Var.a = i53;
            }
            i48 = i55;
            if (i50 == i53) {
            }
            i2 = i52;
            f2 = f16;
            float f1722 = next2.g;
            f3 = (-f2) + f1722;
            f4 = f2 - f1722;
            if (next2.b) {
            }
            final int nonPrintablePaintingFlags22 = u11Var2.p.getNonPrintablePaintingFlags();
            i3 = i51;
            codeEditor = u11Var2.p;
            int i5822 = i;
            if (codeEditor.j2) {
            }
            if (fMin == f6) {
            }
            q30Var = q30Var9;
            if (q30Var9 != null) {
            }
            w82 layout22 = u11Var.p.getLayout();
            zA = u11Var.D.a();
            lg0 lg0Var222 = u11Var.D;
            if (zA) {
            }
            q30Var2 = q30Var10;
            if (q30Var2 == null) {
            }
            i29 = 1;
            i49++;
            canvas6 = canvas2;
            q30Var9 = q30Var;
            q30Var10 = q30Var2;
            sz3Var2 = sz3Var;
            f16 = f2;
            i50 = i5822;
            lbVar6 = lbVar2;
            t6Var9 = t6Var2;
            i51 = i4;
            i52 = i5;
            i47 = 31;
        }
        Canvas canvas7 = canvas6;
        if (sz3Var2 != null) {
            try {
                sz3Var2.d(-1);
            } catch (Exception e3) {
                a1.o("EditorRenderer", "Failed to release SpanReader", e3);
            }
        }
        u11Var2.b.setFakeBoldText(false);
        u11Var2.b.setTextSkewX(0.0f);
        u11Var2.c.setStrokeWidth(fMin * 2.0f);
        aq aqVar3 = u11Var2.a;
        c03 c03Var = u11Var2.c;
        int i62 = aqVar3.a;
        if (i62 == 0) {
            return;
        }
        canvas7.drawPoints(aqVar3.b, 0, i62 * 2, c03Var);
        aqVar3.a = 0;
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
    */
    public final void s(Canvas canvas) {
        Canvas canvas2;
        float f;
        float f2;
        float f3;
        int i;
        mn2 mn2Var;
        ln2 ln2Var;
        u11 u11Var;
        int i2;
        char c;
        t6 t6Var;
        float f4;
        int i3;
        boolean z;
        u11 u11Var2;
        int i4;
        u11 u11Var3;
        boolean z2;
        ?? r5;
        ?? r13;
        ?? r3;
        gs3 gs3Var;
        u11 u11Var4;
        ArrayList arrayList;
        c03 c03Var;
        int i5;
        float fE;
        float fE2;
        int iA;
        int currentCursorBlock;
        char c2;
        int offsetY;
        float rowHeight;
        hm2 hm2Var;
        hm2 hm2Var2;
        float f5;
        int i6;
        int i7;
        u11 u11Var5 = this;
        u11Var5.D.b.m(u11Var5.p.getFirstVisibleLine(), 0);
        u01 colorScheme = u11Var5.p.getColorScheme();
        int iE = colorScheme.e(4);
        Rect rect = u11Var5.d;
        c03 c03Var2 = u11Var5.b;
        if (iE != 0) {
            c03Var2.setColor(iE);
            canvas.drawRect(rect, c03Var2);
        }
        float fS = u11Var5.p.S();
        u11Var5.A();
        float fT = u11Var5.p.T() + (-u11Var5.p.getOffsetX());
        float f6 = fS + 0.0f;
        int dividerMarginRight = (int) (u11Var5.p.getDividerMarginRight() + u11Var5.p.getDividerMarginLeft() + u11Var5.p.getDividerWidth() + f6);
        CodeEditor codeEditor = u11Var5.p;
        if (codeEditor.Z0) {
            int i8 = u11Var5.C;
            if (i8 == 0) {
                u11Var5.C = dividerMarginRight;
            } else if (i8 != dividerMarginRight && !codeEditor.getEventHandler().k) {
                u11Var5.C = dividerMarginRight;
                CodeEditor codeEditor2 = u11Var5.p;
                Objects.requireNonNull(codeEditor2);
                codeEditor2.b0(new d4(27, codeEditor2));
                u11Var5.p.h(false);
            } else if (u11Var5.H) {
                u11Var5.p.h(true);
                CodeEditor codeEditor3 = u11Var5.p;
                Objects.requireNonNull(codeEditor3);
                codeEditor3.b0(new d4(27, codeEditor3));
            }
        } else {
            u11Var5.C = 0;
            if (u11Var5.H) {
                codeEditor.h(true);
            }
        }
        u11Var5.H = false;
        int firstVisibleLine = u11Var5.p.getFirstVisibleLine();
        int lastVisibleLine = u11Var5.p.getLastVisibleLine();
        u11Var5.n.clear();
        u11Var5.o.clear();
        ld0 ld0Var = u11Var5.F;
        int iMin = Math.min(u11Var5.F.b.size() - 1, lastVisibleLine + 5);
        ld0Var.u(false);
        for (int iMax = Math.max(0, firstVisibleLine - 5); iMax <= iMin; iMax++) {
            try {
                ud0 ud0Var = (ud0) ld0Var.b.get(iMax);
                bv0 bv0VarB = ld0Var.y0.b(iMax, ud0Var);
                u11Var5.n.put(iMax, ud0Var);
                u11Var5.o.put(iMax, bv0VarB);
            } catch (Throwable th) {
                ld0Var.F(false);
                throw th;
            }
        }
        ld0Var.F(false);
        u11Var5.c(u11Var5.p.getFirstVisibleLine(), u11Var5.p.getLastVisibleLine(), u11Var5.z, true);
        CodeEditor codeEditor4 = u11Var5.p;
        if (!codeEditor4.Z0) {
            codeEditor4.getProps().getClass();
        }
        boolean zA = u11Var5.D.a();
        CodeEditor codeEditor5 = u11Var5.p;
        if (zA) {
            gs3 insertHandleDescriptor = codeEditor5.getInsertHandleDescriptor();
            insertHandleDescriptor.a.setEmpty();
            insertHandleDescriptor.b = 0;
        } else {
            gs3 leftHandleDescriptor = codeEditor5.getLeftHandleDescriptor();
            leftHandleDescriptor.a.setEmpty();
            leftHandleDescriptor.b = 0;
            gs3 rightHandleDescriptor = u11Var5.p.getRightHandleDescriptor();
            rightHandleDescriptor.a.setEmpty();
            rightHandleDescriptor.b = 0;
        }
        CodeEditor codeEditor6 = u11Var5.p;
        boolean z3 = codeEditor6.k1 && (codeEditor6.Z0 || !codeEditor6.s1);
        t6 t6Var2 = u11Var5.j;
        t6Var2.f = 0;
        mn2 mn2Var2 = u11Var5.k;
        mn2Var2.b = 0;
        ArrayList<t11> arrayList2 = new ArrayList(3);
        CodeEditor codeEditor7 = u11Var5.p;
        ln2 ln2Var2 = (codeEditor7.u1 && codeEditor7.Z0) ? new ln2(-1) : null;
        canvas.save();
        canvas.clipRect(0.0f, 0.0f, u11Var5.p.getWidth(), u11Var5.p.getHeight());
        ln2 ln2Var3 = ln2Var2;
        u11Var5.p(canvas, fT, t6Var2, arrayList2, mn2Var2, ln2Var3);
        t6 t6Var3 = t6Var2;
        CodeEditor codeEditor8 = u11Var5.p;
        if (!codeEditor8.B0.b.a()) {
            codeEditor8.getProps().getClass();
            if (codeEditor8.getCursor().a() || (hm2Var = (hm2) codeEditor8.z0.z) == null) {
                canvas2 = canvas;
                f = fT;
                f2 = fS;
                f3 = 0.0f;
                i = 1;
                mn2Var = mn2Var2;
                ln2Var = ln2Var3;
            } else {
                int i9 = hm2Var.c;
                i = 1;
                int iE2 = codeEditor8.getColorScheme().e(39);
                f3 = 0.0f;
                int iE3 = codeEditor8.getColorScheme().e(41);
                int iE4 = codeEditor8.getColorScheme().e(40);
                int iE5 = codeEditor8.getColorScheme().e(75);
                float textBorderWidth = codeEditor8.getTextBorderWidth();
                int i10 = hm2Var.b;
                if (i10 >= 0) {
                    int i11 = i10 + 1;
                    f = fT;
                    int i12 = u11Var5.F.A;
                    if (i11 <= i12 && i9 >= 0 && i9 + 1 <= i12) {
                        int i13 = i10 + 1;
                        boolean z4 = i13 == i9;
                        if (iE2 == 0 && iE4 == 0) {
                            mn2Var = mn2Var2;
                            i7 = iE3;
                            f2 = fS;
                            hm2Var2 = hm2Var;
                            ln2Var = ln2Var3;
                            f5 = f;
                            i6 = i9;
                        } else {
                            if (z4) {
                                mn2Var = mn2Var2;
                                ln2Var = ln2Var3;
                                f2 = fS;
                                hm2Var2 = hm2Var;
                                f5 = f;
                                i6 = i9;
                                u11Var5.E(canvas, f5, i10, i9 + 1, iE2, iE3, iE4);
                            } else {
                                mn2Var = mn2Var2;
                                ln2Var = ln2Var3;
                                f2 = fS;
                                hm2Var2 = hm2Var;
                                f5 = f;
                                i6 = i9;
                                u11Var5.E(canvas, f5, i10, i13, iE2, iE3, iE4);
                                int i14 = hm2Var2.c;
                                E(canvas, f5, i14, i14 + 1, iE2, iE3, iE4);
                            }
                            i7 = 0;
                        }
                        if (i7 != 0 || (iE5 != 0 && textBorderWidth > 0.0f)) {
                            int i15 = hm2Var2.b;
                            if (z4) {
                                u11Var5 = this;
                                canvas2 = canvas;
                                u11Var5.D(canvas2, f5, i15, i6 + 1, i7, textBorderWidth, iE5);
                            } else {
                                u11Var5 = this;
                                canvas2 = canvas;
                                u11Var5.D(canvas2, f5, i15, i15 + 1, i7, textBorderWidth, iE5);
                                int i16 = hm2Var2.c;
                                u11Var5.D(canvas2, f5, i16, i16 + 1, i7, textBorderWidth, iE5);
                            }
                        } else {
                            u11Var5 = this;
                            canvas2 = canvas;
                        }
                        f = f5;
                    }
                } else {
                    f = fT;
                }
                canvas2 = canvas;
                mn2Var = mn2Var2;
                ln2Var = ln2Var3;
                f2 = fS;
            }
        }
        CodeEditor codeEditor9 = u11Var5.p;
        codeEditor9.getDiagnostics();
        codeEditor9.getDiagnosticIndicatorStyle();
        u11Var5.q.clear();
        canvas2.restore();
        float f7 = -u11Var5.p.getOffsetX();
        int i17 = u11Var5.D.a() ? -1 : u11Var5.D.c.b;
        if (z3) {
            c = ' ';
            u11Var5.j(f7, u11Var5.p.getDividerMarginLeft() + f6, colorScheme.e(3), canvas2);
            int iE6 = u11Var5.p.getColorScheme().e(2);
            int iE7 = u11Var5.p.getColorScheme().e(9);
            if (((tm2) u11Var5.p.getCursorAnimator()).b()) {
                CodeEditor codeEditor10 = u11Var5.p;
                if (codeEditor10.o1 && codeEditor10.H()) {
                    u11Var5.e.bottom = ((Float) ((tm2) u11Var5.p.getCursorAnimator()).d.getAnimatedValue()).floatValue() - u11Var5.p.getOffsetY();
                    RectF rectF = u11Var5.e;
                    rectF.top = rectF.bottom - ((Float) ((tm2) u11Var5.p.getCursorAnimator()).e.getAnimatedValue()).floatValue();
                    RectF rectF2 = u11Var5.e;
                    rectF2.left = f3;
                    rectF2.right = (int) (f - u11Var5.p.getDividerMarginRight());
                    u11Var5.g(canvas2, iE7, u11Var5.e);
                }
            }
            canvas2.save();
            canvas2.clipRect(0.0f, 0.0f, u11Var5.p.getWidth(), u11Var5.p.getHeight());
            for (int i18 = 0; i18 < mn2Var.b; i18++) {
                u11Var5.l(canvas2, iE7, mn2Var.b(i18), (int) (f - u11Var5.p.getDividerMarginRight()));
            }
            u11Var5.p.getDividerMarginRight();
            CodeEditor codeEditor11 = u11Var5.p;
            int lastVisibleLine2 = codeEditor11.getLastVisibleLine();
            for (int firstVisibleLine2 = codeEditor11.getFirstVisibleLine(); firstVisibleLine2 <= lastVisibleLine2; firstVisibleLine2++) {
                codeEditor11.getStyles();
            }
            float f8 = f7 + f2;
            u11Var5.A();
            canvas2.restore();
            u11Var5.h(canvas2, u11Var5.p.getDividerMarginLeft() + f8 + 0.0f, colorScheme.e(i));
            canvas2.save();
            canvas2.clipRect(0.0f, 0.0f, u11Var5.p.getWidth(), u11Var5.p.getHeight());
            if (ln2Var == null || ln2Var.a == -1) {
                c2 = 2;
            } else {
                int iA2 = u11Var5.p.A(0);
                if (t6Var3.f != 0) {
                    if ((u11Var5.p.getRowHeight() * ((int) (t6Var3.j(0) & 4294967295L))) - u11Var5.p.getOffsetY() > iA2) {
                        int iA3 = u11Var5.p.A(0);
                        u11Var5.p.getRowHeight();
                        Paint.FontMetricsInt fontMetricsInt = u11Var5.A;
                        int i19 = fontMetricsInt.descent;
                        offsetY = fontMetricsInt.ascent;
                        rowHeight = (iA3 / 2.0f) - ((i19 - offsetY) / 2.0f);
                    } else {
                        int iJ = ((int) (t6Var3.j(0) & 4294967295L)) - 1;
                        Paint.FontMetricsInt fontMetricsInt2 = u11Var5.A;
                        int i20 = fontMetricsInt2.descent;
                        int i21 = fontMetricsInt2.ascent;
                        rowHeight = ((((u11Var5.p.getRowHeight() * iJ) + u11Var5.p.A(iJ)) / 2.0f) - ((i20 - i21) / 2.0f)) - i21;
                        offsetY = u11Var5.p.getOffsetY();
                    }
                    float f9 = rowHeight - offsetY;
                    u11Var5.c.setTextAlign(u11Var5.p.getLineNumberAlign());
                    u11Var5.c.setColor(ln2Var.a == i17 ? colorScheme.e(45) : iE6);
                    String string = Integer.toString(ln2Var.a + 1);
                    int i22 = s11.a[u11Var5.p.getLineNumberAlign().ordinal()];
                    if (i22 != 1) {
                        c2 = 2;
                        if (i22 == 2) {
                            canvas2.drawText(string, f8, f9, u11Var5.c);
                        } else if (i22 == 3) {
                            canvas2.drawText(string, ((u11Var5.p.getDividerMarginLeft() + f2) / 2.0f) + f7, f9, u11Var5.c);
                        }
                    } else {
                        c2 = 2;
                        canvas2.drawText(string, f7, f9, u11Var5.c);
                    }
                }
            }
            int i23 = 0;
            while (i23 < t6Var3.f) {
                long j = t6Var3.j(i23);
                int i24 = i17;
                int i25 = (int) (j >> 32);
                int i26 = (int) (j & 4294967295L);
                int iE8 = i25 == i24 ? colorScheme.e(45) : iE6;
                float f10 = f2;
                u11Var5.i(canvas2, i25, i26, f7, f10, iE8);
                f2 = f10;
                i23++;
                c2 = 2;
                i17 = i24;
            }
            i2 = i17;
            u11Var = u11Var5;
            canvas2.restore();
        } else {
            u11Var = u11Var5;
            i2 = i17;
            c = ' ';
        }
        if (u11Var.p.l1) {
            canvas2.save();
            canvas2.clipRect(0.0f, 0.0f, u11Var.p.getWidth(), u11Var.p.getHeight());
            CodeEditor codeEditor12 = u11Var.p;
            boolean z5 = codeEditor12.Z0;
            c03 c03Var3 = u11Var.b;
            if (z5) {
                codeEditor12.getProps().getClass();
                ArrayList arrayList3 = codeEditor12.getStyles() == null ? null : codeEditor12.getStyles().b;
                if (arrayList3 != null && !arrayList3.isEmpty() && (currentCursorBlock = codeEditor12.getCurrentCursorBlock()) >= 0 && currentCursorBlock < arrayList3.size()) {
                    j60 j60Var = (j60) arrayList3.get(currentCursorBlock);
                    try {
                        v0 v0Var = (v0) codeEditor12.getLayout();
                        float rowHeight2 = (v0Var.b(j60Var.a, j60Var.b)[0] - codeEditor12.getRowHeight()) - codeEditor12.getOffsetY();
                        float offsetY2 = v0Var.b(j60Var.c, j60Var.d)[0] - codeEditor12.getOffsetY();
                        float fS2 = codeEditor12.S();
                        float dividerMarginLeft = (((codeEditor12.getDividerMarginLeft() + fS2) + fS2) / 2.0f) - codeEditor12.getOffsetX();
                        c03Var3.setColor(codeEditor12.getColorScheme().e(38));
                        c03Var3.setStrokeWidth(codeEditor12.getDpUnit() * codeEditor12.getBlockLineWidth());
                        Canvas canvas3 = canvas2;
                        try {
                            canvas3.drawLine(dividerMarginLeft, rowHeight2, dividerMarginLeft, offsetY2, u11Var.b);
                            canvas2 = canvas3;
                        } catch (IndexOutOfBoundsException unused) {
                            canvas2 = canvas3;
                        }
                    } catch (IndexOutOfBoundsException unused2) {
                    }
                }
            } else {
                RectF rectF3 = u11Var.e;
                a54 styles = codeEditor12.getStyles();
                ArrayList arrayList4 = styles == null ? null : styles.b;
                boolean z6 = styles != null && styles.d;
                if (arrayList4 != null && !arrayList4.isEmpty()) {
                    int firstVisibleRow = codeEditor12.getFirstVisibleRow();
                    int lastVisibleRow = codeEditor12.getLastVisibleRow();
                    int i27 = styles.c;
                    boolean z7 = z6;
                    int iA4 = j60.a(firstVisibleRow, arrayList4);
                    f4 = f6;
                    if (iA4 == -1) {
                        iA4 = 0;
                    }
                    int currentCursorBlock2 = codeEditor12.getCurrentCursorBlock();
                    i3 = i2;
                    z = z3;
                    int i28 = 0;
                    boolean z8 = false;
                    while (true) {
                        if (iA4 >= arrayList4.size()) {
                            t6Var = t6Var3;
                            break;
                        }
                        j60 j60Var2 = (j60) arrayList4.get(iA4);
                        if (j60Var2 == null) {
                            c03Var = c03Var3;
                            arrayList = arrayList4;
                            i5 = lastVisibleRow;
                            t6Var = t6Var3;
                        } else {
                            arrayList = arrayList4;
                            int i29 = j60Var2.a;
                            t6Var = t6Var3;
                            int i30 = j60Var2.c;
                            if (i30 <= firstVisibleRow || i29 >= lastVisibleRow) {
                                c03Var = c03Var3;
                                i5 = lastVisibleRow;
                                if (!z8) {
                                    continue;
                                } else if (i28 >= i27) {
                                    break;
                                } else {
                                    i28++;
                                }
                            } else {
                                try {
                                    ud0 ud0VarV = u11Var.v(i30);
                                    if (z7) {
                                        fE = c03Var3.a * j60Var2.d;
                                        i5 = lastVisibleRow;
                                    } else {
                                        i5 = lastVisibleRow;
                                        fE = u11Var.d(j60Var2.c).e(Math.min(j60Var2.d, ud0VarV.f));
                                    }
                                    ud0 ud0VarV2 = u11Var.v(j60Var2.a);
                                    if (z7) {
                                        try {
                                            fE2 = c03Var3.a * j60Var2.b;
                                            c03Var = c03Var3;
                                        } catch (IndexOutOfBoundsException unused3) {
                                            c03Var = c03Var3;
                                        }
                                    } else {
                                        c03Var = c03Var3;
                                        fE2 = u11Var.d(j60Var2.a).e(Math.min(j60Var2.b, ud0VarV2.f));
                                    }
                                    float fMin = Math.min(fE, fE2) + f;
                                    rectF3.top = Math.max(0, codeEditor12.A(j60Var2.a) - codeEditor12.getOffsetY());
                                    int height = codeEditor12.getHeight();
                                    boolean z9 = j60Var2.e;
                                    int i31 = j60Var2.c;
                                    if (z9) {
                                        try {
                                            iA = codeEditor12.A(i31);
                                        } catch (IndexOutOfBoundsException unused4) {
                                        }
                                    } else {
                                        iA = codeEditor12.getRowHeight() * i31;
                                    }
                                    rectF3.bottom = Math.min(height, iA - codeEditor12.getOffsetY());
                                    rectF3.left = fMin - ((codeEditor12.getDpUnit() * codeEditor12.getBlockLineWidth()) / 2.0f);
                                    rectF3.right = ((codeEditor12.getDpUnit() * codeEditor12.getBlockLineWidth()) / 2.0f) + fMin;
                                    u11Var.g(canvas2, codeEditor12.getColorScheme().e(iA4 == currentCursorBlock2 ? 15 : 14), rectF3);
                                } catch (IndexOutOfBoundsException unused5) {
                                    c03Var = c03Var3;
                                    i5 = lastVisibleRow;
                                }
                                z8 = true;
                            }
                        }
                        iA4++;
                        arrayList4 = arrayList;
                        t6Var3 = t6Var;
                        lastVisibleRow = i5;
                        c03Var3 = c03Var;
                    }
                }
                canvas2.restore();
            }
            t6Var = t6Var3;
            f4 = f6;
            i3 = i2;
            z = z3;
            canvas2.restore();
        } else {
            t6Var = t6Var3;
            f4 = f6;
            i3 = i2;
            z = z3;
        }
        int i32 = 7;
        if (((tm2) u11Var.p.getCursorAnimator()).b()) {
            u11Var2 = u11Var;
            i4 = 0;
            RectF rectF4 = u11Var2.e;
            CodeEditor codeEditor13 = u11Var2.p;
            if (codeEditor13.H()) {
                float fFloatValue = ((Float) ((tm2) codeEditor13.getCursorAnimator()).c.getAnimatedValue()).floatValue() - codeEditor13.getOffsetY();
                rectF4.bottom = fFloatValue;
                codeEditor13.getProps().getClass();
                rectF4.top = fFloatValue - codeEditor13.getRowHeight();
                float fFloatValue2 = ((Float) ((tm2) codeEditor13.getCursorAnimator()).b.getAnimatedValue()).floatValue() - codeEditor13.getOffsetX();
                rectF4.left = fFloatValue2 - (codeEditor13.getInsertSelectionWidth() / 2.0f);
                rectF4.right = (codeEditor13.getInsertSelectionWidth() / 2.0f) + fFloatValue2;
                u11Var2.g(canvas2, codeEditor13.getColorScheme().e(7), rectF4);
                q30 q30Var = u11Var2.D.c;
                long jU = u11Var2.u(q30Var.b, q30Var.c);
                if (((int) (jU >> c)) == 1) {
                    u11Var2.f(canvas2, fFloatValue2, rectF4.top, rectF4.height(), ((int) (jU & 4294967295L)) == 1);
                    u11Var2 = u11Var2;
                }
                if (!codeEditor13.getEventHandler().n() || codeEditor13.O()) {
                    canvas2 = canvas;
                } else {
                    hs3 handleStyle = codeEditor13.getHandleStyle();
                    float f11 = rectF4.bottom;
                    codeEditor13.getRowHeight();
                    canvas2 = canvas;
                    ((rq1) handleStyle).a(canvas2, 0, fFloatValue2, f11, codeEditor13.getColorScheme().e(8), codeEditor13.getInsertHandleDescriptor());
                }
            }
        } else {
            for (t11 t11Var : arrayList2) {
                gs3 gs3Var2 = t11.h;
                u11 u11Var6 = t11Var.g;
                int i33 = t11Var.c;
                if (i33 != -1) {
                    CodeEditor codeEditor14 = u11Var6.p;
                    if (codeEditor14.B0.c || !codeEditor14.isFocused()) {
                        u11Var4 = u11Var;
                    } else if (i33 != 0 || u11Var6.p.H()) {
                        gs3 gs3Var3 = t11Var.d;
                        if (gs3Var3 == null) {
                            gs3Var3 = gs3Var2;
                        }
                        RectF rectF5 = gs3Var3.a;
                        if (!rectF5.isEmpty()) {
                            CodeEditor codeEditor15 = u11Var6.p;
                            if (!codeEditor15.w1) {
                                int i34 = codeEditor15.getEventHandler().e;
                                boolean z10 = t11Var.f;
                                if (i34 == ((z10 && i33 == 1) ? 2 : (z10 && i33 == 2) ? 1 : i33) && i33 != -1 && u11Var6.p.getEventHandler().f) {
                                    t11Var.a = ((gs3Var3.b != 0 ? rectF5.width() : 0.0f) * (gs3Var3.b == 1 ? 1 : -1)) + u11Var6.p.getEventHandler().g;
                                    t11Var.b = u11Var6.p.getEventHandler().h - ((rectF5.height() * 2.0f) / 3.0f);
                                }
                            }
                        }
                        if (i33 == 1 || i33 == 2) {
                            u11Var6.p.getProps().getClass();
                        }
                        if (t11Var.a() || i33 == -1) {
                            float f12 = t11Var.b;
                            u11Var6.p.getProps().getClass();
                            float rowHeight3 = f12 - u11Var6.p.getRowHeight();
                            float f13 = t11Var.b;
                            u11Var6.b.setColor(u11Var6.p.getColorScheme().e(i32));
                            u11Var6.b.setStrokeWidth(u11Var6.p.getInsertSelectionWidth());
                            u11Var6.b.setStyle(Paint.Style.STROKE);
                            if (u11Var6.p.y1 && i33 != 1 && i33 != 2) {
                                float f14 = f13 - rowHeight3;
                                float f15 = f14 / 8.0f;
                                u11Var6.b.setPathEffect(new DashPathEffect(new float[]{f15, f15}, f14 / 16.0f));
                                u11Var6.b.setStrokeWidth(u11Var6.p.getInsertSelectionWidth() * 1.5f);
                            }
                            float f16 = t11Var.a;
                            gs3Var = gs3Var3;
                            canvas.drawLine(f16, rowHeight3, f16, f13, u11Var6.b);
                            u11Var6.b.setStyle(Paint.Style.FILL);
                            u11Var6.b.setPathEffect(null);
                            if (t11Var.a() && t11Var.e) {
                                t11Var.g.f(canvas, t11Var.a, rowHeight3, f13 - rowHeight3, t11Var.f);
                            }
                        } else {
                            gs3Var = gs3Var3;
                        }
                        if (i33 == 0) {
                            CodeEditor codeEditor16 = u11Var6.p;
                            int i35 = (codeEditor16.y1 || !codeEditor16.getEventHandler().n()) ? -1 : i33;
                            if (i35 == -1 || u11Var6.p.O()) {
                                gs3 gs3Var4 = gs3Var;
                                u11Var4 = u11Var;
                                canvas2 = canvas;
                                gs3Var4.a.setEmpty();
                                gs3Var4.b = 0;
                            } else {
                                hs3 handleStyle2 = u11Var6.p.getHandleStyle();
                                float f17 = t11Var.a;
                                float f18 = t11Var.b;
                                u11Var6.p.getRowHeight();
                                gs3 gs3Var5 = gs3Var;
                                u11Var4 = u11Var;
                                canvas2 = canvas;
                                ((rq1) handleStyle2).a(canvas2, i35, f17, f18, u11Var6.p.getColorScheme().e(8), gs3Var5);
                                if (gs3Var5 == gs3Var2) {
                                    gs3Var5.a.setEmpty();
                                    gs3Var5.b = 0;
                                }
                            }
                        }
                    }
                }
                u11Var = u11Var4;
                i32 = 7;
            }
            i4 = 0;
            u11Var2 = u11Var;
        }
        CodeEditor codeEditor17 = u11Var2.p;
        if (!codeEditor17.k1 || z) {
            u11Var3 = u11Var2;
            z2 = true;
        } else {
            u11Var2.j(0.0f, codeEditor17.getDividerMarginLeft() + f4, colorScheme.e(3), canvas2);
            canvas2.save();
            canvas2.clipRect(0.0f, 0.0f, u11Var2.p.getWidth(), u11Var2.p.getHeight());
            int iE9 = u11Var2.p.getColorScheme().e(2);
            int iE10 = u11Var2.p.getColorScheme().e(9);
            if (((tm2) u11Var2.p.getCursorAnimator()).b()) {
                CodeEditor codeEditor18 = u11Var2.p;
                if (codeEditor18.o1 && codeEditor18.H()) {
                    u11Var2.e.bottom = ((Float) ((tm2) u11Var2.p.getCursorAnimator()).d.getAnimatedValue()).floatValue() - u11Var2.p.getOffsetY();
                    RectF rectF6 = u11Var2.e;
                    rectF6.top = rectF6.bottom - ((Float) ((tm2) u11Var2.p.getCursorAnimator()).e.getAnimatedValue()).floatValue();
                    RectF rectF7 = u11Var2.e;
                    rectF7.left = 0.0f;
                    rectF7.right = (int) (f - u11Var2.p.getDividerMarginRight());
                    u11Var2.g(canvas2, iE10, u11Var2.e);
                }
            }
            for (int i36 = i4; i36 < mn2Var.b; i36++) {
                u11Var2.l(canvas2, iE10, mn2Var.b(i36), (int) ((f - u11Var2.p.getDividerMarginRight()) + u11Var2.p.getOffsetX()));
            }
            u11Var2.p.getDividerMarginRight();
            u11Var2.p.getOffsetX();
            CodeEditor codeEditor19 = u11Var2.p;
            int lastVisibleLine3 = codeEditor19.getLastVisibleLine();
            for (int firstVisibleLine3 = codeEditor19.getFirstVisibleLine(); firstVisibleLine3 <= lastVisibleLine3; firstVisibleLine3++) {
                codeEditor19.getStyles();
            }
            u11Var2.A();
            canvas2.restore();
            z2 = true;
            u11Var2.h(canvas2, u11Var2.p.getDividerMarginLeft() + f4, colorScheme.e(1));
            canvas2.save();
            canvas2.clipRect(0.0f, 0.0f, u11Var2.p.getWidth(), u11Var2.p.getHeight());
            int i37 = i4;
            t6 t6Var4 = t6Var;
            while (i37 < t6Var4.f) {
                long j2 = t6Var4.j(i37);
                int i38 = (int) (j2 >> c);
                int i39 = i3;
                u11Var2.i(canvas2, i38, (int) (j2 & 4294967295L), 0.0f, f2, i38 == i39 ? colorScheme.e(45) : iE9);
                i37++;
                i3 = i39;
            }
            u11Var3 = u11Var2;
            canvas2.restore();
        }
        u11Var3.p.getColorScheme().e(2);
        q(canvas);
        CodeEditor codeEditor20 = u11Var3.p;
        EdgeEffect verticalEdgeEffect = codeEditor20.getVerticalEdgeEffect();
        EdgeEffect horizontalEdgeEffect = codeEditor20.getHorizontalEdgeEffect();
        if (verticalEdgeEffect.isFinished()) {
            r5 = i4;
        } else {
            boolean z11 = codeEditor20.getEventHandler().i;
            if (z11) {
                canvas2.save();
                canvas2.translate(-codeEditor20.getMeasuredWidth(), codeEditor20.getMeasuredHeight());
                canvas2.rotate(180.0f, codeEditor20.getMeasuredWidth(), 0.0f);
            }
            boolean zDraw = verticalEdgeEffect.draw(canvas2);
            if (z11) {
                canvas2.restore();
            }
            r5 = zDraw;
        }
        if (codeEditor20.Z0) {
            horizontalEdgeEffect.finish();
        }
        ?? r52 = r5;
        if (!horizontalEdgeEffect.isFinished()) {
            canvas2.save();
            if (codeEditor20.getEventHandler().j) {
                canvas2.rotate(90.0f);
                canvas2.translate(0.0f, -codeEditor20.getMeasuredWidth());
            } else {
                canvas2.translate(0.0f, codeEditor20.getMeasuredHeight());
                canvas2.rotate(-90.0f);
            }
            ?? r53 = (horizontalEdgeEffect.draw(canvas2) || r5 != 0) ? z2 : i4;
            canvas2.restore();
            r52 = r53;
        }
        OverScroller overScroller = codeEditor20.getScroller().b;
        if (overScroller.isOverScrolled()) {
            if (!verticalEdgeEffect.isFinished() || (overScroller.getCurrY() >= 0 && overScroller.getCurrY() <= codeEditor20.getScrollMaxY())) {
                r3 = r52;
            } else {
                codeEditor20.getEventHandler().i = overScroller.getCurrY() >= codeEditor20.getScrollMaxY() ? z2 : i4;
                verticalEdgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                r3 = z2;
            }
            if (!horizontalEdgeEffect.isFinished() || (overScroller.getCurrX() >= 0 && overScroller.getCurrX() <= codeEditor20.getScrollMaxX())) {
                r13 = r3;
            } else {
                codeEditor20.getEventHandler().j = overScroller.getCurrX() >= codeEditor20.getScrollMaxX() ? z2 : i4;
                horizontalEdgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                r13 = z2;
            }
        } else {
            r13 = r52;
        }
        if (r13 != 0) {
            codeEditor20.postInvalidate();
        }
        u11Var3.n.clear();
        u11Var3.o.clear();
        u11Var3.p.K();
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
