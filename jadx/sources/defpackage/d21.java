package defpackage;

import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Build;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d21 implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener {
    public float A;
    public float B;
    public int C;
    public long D;
    public boolean E;
    public PointF F;
    public boolean G;
    public boolean H;
    public q30 I;
    public boolean J;
    public boolean K;
    public long P;
    public boolean Q;
    public float R;
    public final CodeEditor a;
    public final v11 b;
    public final nf2 d;
    public boolean f;
    public float g;
    public float h;
    public boolean i;
    public boolean j;
    public float n;
    public final float w;
    public int x;
    public final int y;
    public MotionEvent z;
    public int e = -1;
    public boolean k = false;
    public long o = 0;
    public long p = 0;
    public boolean q = false;
    public boolean r = false;
    public float s = 0.0f;
    public float t = 0.0f;
    public int L = -1;
    public int M = -1;
    public int N = -1;
    public int O = -1;
    public final float l = TypedValue.applyDimension(2, 26.0f, Resources.getSystem().getDisplayMetrics());
    public final float m = TypedValue.applyDimension(2, 8.0f, Resources.getSystem().getDisplayMetrics());
    public t6 u = new t6(1, 3, this);
    public t6 v = new t6(2, 3, this);
    public final t6 c = new t6(0, 3, this);

    public d21(CodeEditor codeEditor) {
        this.a = codeEditor;
        this.w = codeEditor.getDpUnit() * 18.0f;
        this.b = new v11(codeEditor);
        this.d = new nf2(codeEditor);
        this.y = ViewConfiguration.get(codeEditor.getContext()).getScaledTouchSlop();
    }

    public static boolean g(float f, float f2) {
        if (Math.abs(f) < 100000.0d || Math.abs(f2) < 100000.0d) {
            return false;
        }
        if (f >= 0.0f || f2 >= 0.0f) {
            return f > 0.0f && f2 > 0.0f;
        }
        return true;
    }

    public final int a(l60 l60Var, q30 q30Var, MotionEvent motionEvent) {
        long J = xb5.J(this.a, motionEvent, -1);
        return b(l60Var, q30Var, motionEvent, (int) (J >> 32), (int) (J & 4294967295L));
    }

    public final int b(l60 l60Var, q30 q30Var, MotionEvent motionEvent, int i, int i2) {
        p60 kt1Var;
        CodeEditor codeEditor = this.a;
        if (q30Var == null) {
            long jY = codeEditor.y(motionEvent.getX(), motionEvent.getY());
            q30Var = codeEditor.getText().n().m((int) (jY >> 32), (int) (jY & 4294967295L));
        }
        a54 styles = codeEditor.getStyles();
        ld0 text = codeEditor.getText();
        as2 as2VarX = uf2.x(styles, q30Var, 0);
        as2 as2VarX2 = uf2.x(styles, q30Var, 1);
        if (as2VarX != null) {
            su suVarN = text.n();
            int i3 = q30Var.b;
            q30 q30VarM = suVarN.m(i3, je.q(as2VarX.a, text.o(i3).f));
            int i4 = q30Var.b;
            new ic4(q30VarM, as2VarX2 != null ? text.n().m(i4, je.q(as2VarX2.a, text.o(i4).f)) : text.n().m(i4, text.o(i4).f));
        }
        switch (l60Var.b) {
            case 0:
                kt1Var = new kt1(codeEditor, q30Var, motionEvent);
                break;
            case 1:
                kt1Var = new af2(codeEditor, q30Var, motionEvent);
                break;
            case 2:
                kt1Var = new w50(codeEditor, q30Var, motionEvent);
                break;
            case 3:
                kt1Var = new w50(codeEditor, q30Var, motionEvent);
                break;
            default:
                kt1Var = new w50(codeEditor, q30Var, motionEvent);
                break;
        }
        return codeEditor.C0.a(kt1Var);
    }

    public final void c(int i, boolean z) {
        CodeEditor codeEditor = this.a;
        codeEditor.C0.a(new qq1(codeEditor, i, z));
    }

    public final void d() {
        boolean z = this.K;
        this.J = false;
        this.K = false;
        this.L = -1;
        this.M = -1;
        this.N = -1;
        this.O = -1;
        if (z) {
            CodeEditor codeEditor = this.a;
            codeEditor.C0.a(new nx0(codeEditor));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(android.view.MotionEvent r11, boolean r12) {
        /*
            r10 = this;
            io.github.rosemoe.sora.widget.CodeEditor r0 = r10.a
            uu0 r1 = r0.getProps()
            r1.getClass()
            boolean r1 = r10.J
            r2 = 0
            if (r1 != 0) goto Lf
            return r2
        Lf:
            ld0 r1 = r0.getText()
            int r3 = r1.A
            r7 = 1
            if (r3 != 0) goto L1a
            goto L9e
        L1a:
            float r3 = r11.getX()
            float r4 = r11.getY()
            long r3 = r0.y(r3, r4)
            r5 = 32
            long r5 = r3 >> r5
            int r5 = (int) r5
            r8 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r3 = r3 & r8
            int r3 = (int) r3
            int r8 = r1.l(r5, r3)
            boolean r3 = r10.K
            if (r3 != 0) goto L46
            int r3 = r10.L
            if (r8 != r3) goto L44
            if (r12 != 0) goto L9e
            r10.m(r11)
            return r7
        L44:
            r10.K = r7
        L46:
            int r3 = r10.O
            if (r8 != r3) goto L53
            r10.o(r11)
            if (r12 != 0) goto L9e
            r10.m(r11)
            return r7
        L53:
            int r3 = r10.L
            if (r8 > r3) goto L5a
            int r3 = r10.N
            goto L5c
        L5a:
            int r3 = r10.M
        L5c:
            int r4 = r1.A
            int r3 = defpackage.je.q(r3, r4)
            int r4 = java.lang.Math.min(r3, r8)
            int r3 = java.lang.Math.max(r3, r8)
            su r1 = r1.n()
            if (r4 != r3) goto L7d
            q30 r1 = r1.j(r4)
            int r3 = r1.b
            int r1 = r1.c
            r4 = 2
            r0.j0(r3, r1, r4, r2)
            goto L94
        L7d:
            q30 r2 = r1.j(r4)
            q30 r1 = r1.j(r3)
            r3 = r1
            int r1 = r2.b
            int r2 = r2.c
            r4 = r3
            int r3 = r4.b
            int r4 = r4.c
            r6 = 0
            r5 = 2
            r0.l0(r1, r2, r3, r4, r5, r6)
        L94:
            r10.O = r8
            r10.o(r11)
            if (r12 != 0) goto L9e
            r10.m(r11)
        L9e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d21.e(android.view.MotionEvent, boolean):boolean");
    }

    public final boolean f() {
        return this.e != -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x024c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(android.view.MotionEvent r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d21.h(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        if (r0 != 3) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d21.i(android.view.MotionEvent):boolean");
    }

    public final void j() {
        this.B = 0.0f;
        this.A = 0.0f;
        this.G = false;
        this.H = false;
        this.I = null;
        if (this.E) {
            this.E = false;
            this.D = 0L;
        }
    }

    public final void k(float f, float f2, boolean z) {
        v11 v11Var = this.b;
        int currX = v11Var.b.getCurrX() + ((int) f);
        OverScroller overScroller = v11Var.b;
        int currY = overScroller.getCurrY() + ((int) f2);
        int iMax = Math.max(currX, 0);
        int iMax2 = Math.max(currY, 0);
        CodeEditor codeEditor = this.a;
        int iMin = Math.min(iMax2, codeEditor.getScrollMaxY());
        int iMin2 = Math.min(iMax, codeEditor.getScrollMaxX());
        codeEditor.m(new oq3(codeEditor, overScroller.getCurrX(), overScroller.getCurrY(), iMin2, iMin, 1));
        if (z) {
            int currX2 = v11Var.b.getCurrX();
            int currY2 = overScroller.getCurrY();
            int currX3 = iMin2 - overScroller.getCurrX();
            int currY3 = iMin - overScroller.getCurrY();
            v11Var.a.getProps().getClass();
            v11Var.b(currX2, currY2, currX3, currY3, 250);
        } else {
            v11Var.b(v11Var.b.getCurrX(), overScroller.getCurrY(), iMin2 - overScroller.getCurrX(), iMin - overScroller.getCurrY(), 0);
            overScroller.abortAnimation();
            v11Var.a();
        }
        codeEditor.invalidate();
    }

    public final void l(MotionEvent motionEvent, float f, float f2) {
        if (motionEvent != null) {
            f = motionEvent.getX();
            f2 = motionEvent.getY();
        }
        float f3 = this.w;
        int i = f < f3 ? 1 : 0;
        if (f2 < f3) {
            i |= 4;
        }
        CodeEditor codeEditor = this.a;
        if (f > codeEditor.getWidth() - f3) {
            i |= 2;
        }
        if (f2 > codeEditor.getHeight() - f3) {
            i |= 8;
        }
        if (i == 0) {
            this.x = 0;
            return;
        }
        int i2 = this.x;
        this.x = i;
        this.z = motionEvent == null ? null : MotionEvent.obtain(motionEvent);
        if (i2 == 0) {
            codeEditor.b0(new c21(this, (int) (codeEditor.getDpUnit() * 8.0f)));
        }
    }

    public final void m(MotionEvent motionEvent) {
        l(motionEvent, 0.0f, 0.0f);
    }

    public final boolean n() {
        return System.currentTimeMillis() - this.p < 3500 || this.e == 0;
    }

    public final void o(MotionEvent motionEvent) {
        this.a.getProps().getClass();
        int i = this.x;
        nf2 nf2Var = this.d;
        if (i == 0) {
            nf2Var.getClass();
            if (this.K) {
                if (!nf2Var.b.isShowing()) {
                    double x = motionEvent.getX() - this.t;
                    double y = motionEvent.getY() - this.s;
                    if (Math.sqrt((y * y) + (x * x)) < 4.0d) {
                        return;
                    }
                }
                nf2Var.b((int) motionEvent.getX(), (int) (motionEvent.getY() - r0.getRowHeight()));
                return;
            }
        }
        nf2Var.a();
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        CodeEditor codeEditor = this.a;
        codeEditor.K();
        long jY = codeEditor.y(motionEvent.getX(), motionEvent.getY());
        int i = (int) (jY >> 32);
        int i2 = (int) (jY & 4294967295L);
        if ((a(new l60(3), codeEditor.getText().n().m(i, i2), motionEvent) & 2) == 0 && !codeEditor.getCursor().a() && motionEvent.getPointerCount() == 1) {
            codeEditor.g0(i, i2);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return this.a.isEnabled();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3;
        CodeEditor codeEditor = this.a;
        codeEditor.getProps().getClass();
        float f4 = 0.0f;
        if (Math.abs(f) > Math.abs(f2)) {
            f3 = 0.0f;
            f4 = f;
        } else {
            f3 = f2;
        }
        codeEditor.getProps().getClass();
        v11 v11Var = this.b;
        OverScroller overScroller = v11Var.b;
        OverScroller overScroller2 = v11Var.b;
        int i = 1;
        overScroller.forceFinished(true);
        v11Var.a();
        int scrollMaxX = codeEditor.getScrollMaxX();
        int scrollMaxY = codeEditor.getScrollMaxY();
        codeEditor.getProps().getClass();
        codeEditor.getProps().getClass();
        overScroller2.fling(overScroller2.getCurrX(), overScroller2.getCurrY(), (int) (-f4), (int) (-f3), 0, scrollMaxX, 0, scrollMaxY, 0, 0);
        v11Var.a();
        float dpUnit = codeEditor.getDpUnit() * 2000.0f;
        if (Math.abs(f4) >= dpUnit || Math.abs(f3) >= dpUnit) {
            this.o = System.currentTimeMillis();
            codeEditor.a0(new b21(this, i), 3000L);
        }
        codeEditor.Y1.onRelease();
        codeEditor.X1.onRelease();
        codeEditor.C0.a(new oq3(codeEditor, overScroller2.getCurrX(), overScroller2.getCurrY(), overScroller2.getFinalX(), overScroller2.getFinalY(), 2));
        codeEditor.postInvalidateOnAnimation();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        v11 v11Var = this.b;
        v11Var.b.forceFinished(true);
        v11Var.a();
        CodeEditor codeEditor = this.a;
        codeEditor.Y1.onRelease();
        codeEditor.X1.onRelease();
        codeEditor.K();
        long jY = codeEditor.y(motionEvent.getX(), motionEvent.getY());
        int i = (int) (jY >> 32);
        int i2 = (int) (jY & 4294967295L);
        if ((a(new l60(1), codeEditor.getText().n().m(i, i2), motionEvent) & 2) != 0) {
            return;
        }
        codeEditor.getProps().getClass();
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        codeEditor.performHapticFeedback(0);
        codeEditor.g0(i, i2);
        if (codeEditor.getCursor().a()) {
            codeEditor.getProps().getClass();
            ld0 text = codeEditor.getText();
            this.L = text.l(i, i2);
            lg0 cursor = codeEditor.getCursor();
            q30 q30Var = cursor.c;
            this.M = text.l(q30Var.b, q30Var.c);
            q30 q30Var2 = cursor.d;
            this.N = text.l(q30Var2.b, q30Var2.c);
            this.O = this.L;
            this.J = true;
            this.K = false;
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        CodeEditor codeEditor = this.a;
        codeEditor.K();
        if (!codeEditor.X0) {
            return false;
        }
        float scaleFactor = scaleGestureDetector.getScaleFactor() * codeEditor.getTextSizePx();
        if (scaleFactor >= this.m && scaleFactor <= this.l) {
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            int rowHeight = codeEditor.getRowHeight();
            codeEditor.setTextSizePxDirect(scaleFactor);
            float rowHeight2 = (codeEditor.getRowHeight() * 1.0f) / rowHeight;
            v11 v11Var = this.b;
            OverScroller overScroller = v11Var.b;
            OverScroller overScroller2 = v11Var.b;
            int iMax = (int) Math.max(0.0f, Math.min((scaleGestureDetector.getScaleFactor() * (overScroller2.getCurrX() + focusX)) - focusX, codeEditor.getScrollMaxX()));
            int iMax2 = (int) Math.max(0.0f, Math.min(((overScroller.getCurrY() + focusY) * rowHeight2) - focusY, codeEditor.getScrollMaxY()));
            codeEditor.C0.a(new oq3(codeEditor, overScroller2.getCurrX(), overScroller2.getCurrY(), iMax, iMax2, 5));
            this.b.b(iMax, iMax2, 0, 0, 0);
            overScroller2.abortAnimation();
            v11Var.a();
            this.k = true;
            codeEditor.invalidate();
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        v11 v11Var = this.b;
        v11Var.b.forceFinished(true);
        v11Var.a();
        CodeEditor codeEditor = this.a;
        this.n = codeEditor.getTextSizePx();
        if (!codeEditor.X0) {
            return false;
        }
        codeEditor.K();
        return !f();
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.k = false;
        float f = this.n;
        CodeEditor codeEditor = this.a;
        if (f == codeEditor.getTextSizePx()) {
            return;
        }
        codeEditor.getRenderer().H = true;
        if (codeEditor.Z0) {
            this.R = scaleGestureDetector.getFocusY();
            this.P = codeEditor.y(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            this.Q = true;
        } else {
            this.Q = false;
        }
        codeEditor.getRenderContext().a();
        codeEditor.getRenderer().G();
        codeEditor.invalidate();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3;
        float f4;
        boolean z;
        boolean z2;
        CodeEditor codeEditor = this.a;
        codeEditor.getProps().getClass();
        if (Math.abs(f) > Math.abs(f2)) {
            f4 = f;
            f3 = 0.0f;
        } else {
            f3 = f2;
            f4 = 0.0f;
        }
        v11 v11Var = this.b;
        OverScroller overScroller = v11Var.b;
        OverScroller overScroller2 = v11Var.b;
        int currX = overScroller.getCurrX() + ((int) f4);
        int currY = overScroller2.getCurrY() + ((int) f3);
        int iMax = Math.max(currX, 0);
        int iMin = Math.min(Math.max(currY, 0), codeEditor.getScrollMaxY());
        int iMin2 = Math.min(iMax, codeEditor.getScrollMaxX());
        if (codeEditor.getVerticalEdgeEffect().isFinished()) {
            z = true;
        } else {
            float fMax = Math.max(0.0f, Math.min(1.0f, motionEvent2.getX() / codeEditor.getWidth()));
            float measuredHeight = (this.i ? f3 : -f3) / codeEditor.getMeasuredHeight();
            if (measuredHeight > 0.0f) {
                iMin = overScroller2.getCurrY();
                EdgeEffect verticalEdgeEffect = codeEditor.getVerticalEdgeEffect();
                if (this.i) {
                    fMax = 1.0f - fMax;
                }
                verticalEdgeEffect.onPull(measuredHeight, fMax);
            } else if (Build.VERSION.SDK_INT >= 31) {
                EdgeEffect verticalEdgeEffect2 = codeEditor.getVerticalEdgeEffect();
                if (this.i) {
                    fMax = 1.0f - fMax;
                }
                verticalEdgeEffect2.onPullDistance(measuredHeight, fMax);
                if (verticalEdgeEffect2.getDistance() != 0.0f) {
                    iMin = overScroller2.getCurrY();
                }
            } else {
                codeEditor.getVerticalEdgeEffect().finish();
            }
            z = false;
        }
        int i = iMin;
        if (codeEditor.getHorizontalEdgeEffect().isFinished()) {
            z2 = true;
        } else {
            float fMax2 = Math.max(0.0f, Math.min(1.0f, motionEvent2.getY() / codeEditor.getHeight()));
            float measuredWidth = (this.j ? f4 : -f4) / codeEditor.getMeasuredWidth();
            if (measuredWidth > 0.0f) {
                iMin2 = overScroller2.getCurrX();
                EdgeEffect horizontalEdgeEffect = codeEditor.getHorizontalEdgeEffect();
                if (!this.j) {
                    fMax2 = 1.0f - fMax2;
                }
                horizontalEdgeEffect.onPull(measuredWidth, fMax2);
            } else if (Build.VERSION.SDK_INT >= 31) {
                EdgeEffect horizontalEdgeEffect2 = codeEditor.getHorizontalEdgeEffect();
                if (!this.j) {
                    fMax2 = 1.0f - fMax2;
                }
                horizontalEdgeEffect2.onPullDistance(measuredWidth, fMax2);
                if (horizontalEdgeEffect2.getDistance() != 0.0f) {
                    iMin2 = overScroller2.getCurrX();
                }
            } else {
                codeEditor.getHorizontalEdgeEffect().finish();
            }
            z2 = false;
        }
        int i2 = iMin2;
        v11Var.b(v11Var.b.getCurrX(), overScroller2.getCurrY(), i2 - overScroller2.getCurrX(), i - overScroller2.getCurrY(), 0);
        if (z && overScroller2.getCurrY() + f3 < -2.0f) {
            codeEditor.getVerticalEdgeEffect().onPull((-f3) / codeEditor.getMeasuredHeight(), Math.max(0.0f, Math.min(1.0f, motionEvent2.getX() / codeEditor.getWidth())));
            this.i = false;
        }
        if (z && overScroller2.getCurrY() + f3 > codeEditor.getScrollMaxY() + 2.0f) {
            codeEditor.getVerticalEdgeEffect().onPull(f3 / codeEditor.getMeasuredHeight(), Math.max(0.0f, Math.min(1.0f, motionEvent2.getX() / codeEditor.getWidth())));
            this.i = true;
        }
        if (z2 && overScroller2.getCurrX() + f4 < -2.0f) {
            codeEditor.getHorizontalEdgeEffect().onPull((-f4) / codeEditor.getMeasuredWidth(), Math.max(0.0f, Math.min(1.0f, motionEvent2.getY() / codeEditor.getHeight())));
            this.j = false;
        }
        if (z2 && overScroller2.getCurrX() + f4 > codeEditor.getScrollMaxX() + 2.0f) {
            codeEditor.getHorizontalEdgeEffect().onPull(f4 / codeEditor.getMeasuredWidth(), Math.max(0.0f, Math.min(1.0f, motionEvent2.getY() / codeEditor.getHeight())));
            this.j = true;
        }
        codeEditor.invalidate();
        codeEditor.C0.a(new oq3(codeEditor, overScroller2.getCurrX(), overScroller2.getCurrY(), i2, i, 1));
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        v11 v11Var = this.b;
        v11Var.b.forceFinished(true);
        v11Var.a();
        CodeEditor codeEditor = this.a;
        codeEditor.K();
        motionEvent.getClass();
        long J = xb5.J(codeEditor, motionEvent, -1);
        int i = (int) (J >> 32);
        int i2 = (int) (J & 4294967295L);
        long jY = codeEditor.y(motionEvent.getX(), motionEvent.getY());
        int i3 = (int) (jY >> 32);
        int i4 = (int) (jY & 4294967295L);
        codeEditor.performClick();
        int i5 = 0;
        if (i == 2) {
            if (codeEditor.getLayout().N(Math.max(0, Math.min(((int) (motionEvent.getY() + codeEditor.getOffsetX())) / codeEditor.getRowHeight(), codeEditor.getLayout().d() - 1))).b) {
                codeEditor.getRenderer().p.getStyles();
            }
        }
        if ((b(new l60(2), codeEditor.getText().n().m(i3, i4), motionEvent, i, i2) & 2) == 0) {
            if (codeEditor.H() && codeEditor.isEnabled()) {
                if (codeEditor.isInTouchMode() && !codeEditor.isFocused()) {
                    codeEditor.requestFocusFromTouch();
                }
                if (!codeEditor.isFocused()) {
                    codeEditor.requestFocus();
                }
                if (codeEditor.c()) {
                    codeEditor.H1.showSoftInput(codeEditor, 0);
                }
            }
            codeEditor.invalidate();
            this.p = System.currentTimeMillis();
            codeEditor.a0(new b21(this, i5), 3500L);
            codeEditor.getProps().getClass();
            if (i == 5) {
                if (!codeEditor.y1) {
                    codeEditor.j0(i3, i4, 3, true);
                    return true;
                }
                q30 q30Var = codeEditor.getCursor().c;
                codeEditor.l0(q30Var.b, q30Var.c, i3, i4, 3, false);
                codeEditor.y1 = false;
                return true;
            }
            if (i == 1) {
                codeEditor.j0(i3, i4, 3, true);
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }
}
