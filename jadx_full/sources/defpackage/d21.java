package defpackage;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.os.SystemClock;
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
    */
    public final boolean e(MotionEvent motionEvent, boolean z) {
        CodeEditor codeEditor = this.a;
        codeEditor.getProps().getClass();
        if (!this.J) {
            return false;
        }
        ld0 text = codeEditor.getText();
        if (text.A != 0) {
            long jY = codeEditor.y(motionEvent.getX(), motionEvent.getY());
            int iL = text.l((int) (jY >> 32), (int) (jY & 4294967295L));
            if (this.K) {
                if (iL != this.O) {
                    o(motionEvent);
                    if (!z) {
                        m(motionEvent);
                        return true;
                    }
                } else {
                    int iQ = je.q(iL <= this.L ? this.N : this.M, text.A);
                    int iMin = Math.min(iQ, iL);
                    int iMax = Math.max(iQ, iL);
                    su suVarN = text.n();
                    if (iMin == iMax) {
                        q30 q30VarJ = suVarN.j(iMin);
                        codeEditor.j0(q30VarJ.b, q30VarJ.c, 2, false);
                    } else {
                        q30 q30VarJ2 = suVarN.j(iMin);
                        q30 q30VarJ3 = suVarN.j(iMax);
                        codeEditor.l0(q30VarJ2.b, q30VarJ2.c, q30VarJ3.b, q30VarJ3.c, 2, false);
                    }
                    this.O = iL;
                    o(motionEvent);
                    if (!z) {
                        m(motionEvent);
                    }
                }
            } else if (iL != this.L) {
                this.K = true;
                if (iL != this.O) {
                }
            } else if (!z) {
                m(motionEvent);
                return true;
            }
        }
        return true;
    }

    public final boolean f() {
        return this.e != -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x024c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h(MotionEvent motionEvent) throws Throwable {
        CodeEditor codeEditor = this.a;
        codeEditor.K();
        if (this.r || this.q) {
            return i(motionEvent);
        }
        this.F = null;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.A = motionEvent.getX();
            this.B = motionEvent.getY();
            int buttonState = motionEvent.getButtonState();
            this.C = buttonState;
            this.G = true;
            if ((buttonState & 1) == 0 || (i(motionEvent) && (this.r || this.q))) {
                return true;
            }
            if (SystemClock.uptimeMillis() - this.D < ViewConfiguration.getDoubleTapTimeout()) {
                this.E = true;
                onDoubleTap(motionEvent);
                return true;
            }
            long jY = codeEditor.y(this.A, this.B);
            int i = (int) (jY >> 32);
            int i2 = (int) (4294967295L & jY);
            q30 q30VarM = codeEditor.getText().n().m(i, i2);
            if (codeEditor.I1.a()) {
                ic4 cursorRange = codeEditor.getCursorRange();
                int i3 = q30VarM.a;
                if (i3 < cursorRange.a.a || i3 >= cursorRange.b.a || !codeEditor.P(this.A, this.B)) {
                    this.H = false;
                    codeEditor.j0(i, i2, 8, true);
                    codeEditor.requestFocus();
                } else {
                    this.H = true;
                }
                this.I = q30VarM;
                codeEditor.postInvalidate();
            }
        } else {
            if (actionMasked == 1) {
                if (motionEvent.getEventTime() - motionEvent.getDownTime() > ViewConfiguration.getTapTimeout() * 2.0f) {
                    this.G = false;
                }
                if (!this.E) {
                    if (this.H && !this.G && (this.C & 1) != 0) {
                        long jY2 = codeEditor.y(motionEvent.getX(), motionEvent.getY());
                        q30 q30VarM2 = codeEditor.getText().n().m((int) (jY2 >> 32), (int) (4294967295L & jY2));
                        ic4 cursorRange2 = codeEditor.getCursorRange();
                        int i4 = q30VarM2.a;
                        q30 q30Var = cursorRange2.a;
                        q30 q30Var2 = cursorRange2.b;
                        if (!(i4 >= q30Var.a && i4 < q30Var2.a) && (codeEditor.getKeyMetaStates().c || !q30Var2.equals(q30VarM2))) {
                            int i5 = q30Var2.a - q30Var.a;
                            boolean z = codeEditor.getKeyMetaStates().c;
                            int i6 = q30VarM2.a;
                            if (!z && i6 >= q30Var.a) {
                                i6 -= i5;
                            }
                            ld0 text = codeEditor.getText();
                            String strD = text.D(q30Var.a, q30Var2.a);
                            if (codeEditor.getKeyMetaStates().c) {
                                text.r(q30VarM2.b, q30VarM2.c, strD);
                            } else {
                                text.b();
                                codeEditor.j();
                                q30VarM2 = text.n().j(i6);
                                text.r(q30VarM2.b, q30VarM2.c, strD);
                                text.k();
                            }
                            q30 q30VarJ = text.n().j(i6 + i5);
                            q30 q30Var3 = q30VarM2;
                            codeEditor.l0(q30Var3.b, q30Var3.c, q30VarJ.b, q30VarJ.c, 8, true);
                        }
                    }
                    if (this.G) {
                        int i7 = this.C;
                        if ((i7 & 1) != 0) {
                            onSingleTapUp(motionEvent);
                            this.D = motionEvent.getEventTime();
                        } else if ((i7 & 2) != 0) {
                            this.F = new PointF(motionEvent.getX(), motionEvent.getY());
                            if ((a(new l60(4), null, motionEvent) & 2) == 0) {
                                int i8 = Build.VERSION.SDK_INT;
                                if (i8 >= 24) {
                                    codeEditor.performContextClick(motionEvent.getX(), motionEvent.getY());
                                } else {
                                    codeEditor.performContextClick();
                                }
                                codeEditor.getProps().getClass();
                                if (i8 >= 24) {
                                    codeEditor.showContextMenu(motionEvent.getX(), motionEvent.getY());
                                } else {
                                    codeEditor.showContextMenu();
                                }
                            }
                        }
                    }
                }
                j();
                this.x = 0;
                return true;
            }
            if (actionMasked != 2) {
                if (actionMasked == 3) {
                    j();
                    this.x = 0;
                    return true;
                }
            } else if (!this.E) {
                float fAbs = Math.abs(motionEvent.getX() - this.A);
                float f = this.y;
                if (fAbs > f || Math.abs(motionEvent.getY() - this.B) > f) {
                    this.G = false;
                }
                if ((this.C & 1) != 0) {
                    long jY3 = codeEditor.y(motionEvent.getX(), motionEvent.getY());
                    int i9 = (int) (jY3 >> 32);
                    int i10 = (int) (4294967295L & jY3);
                    q30 q30VarM3 = codeEditor.getText().n().m(i9, i10);
                    if (!this.G && !this.H) {
                        q30 q30Var4 = codeEditor.A0;
                        codeEditor.l0(q30Var4.b, q30Var4.c, i9, i10, 8, true);
                    }
                    this.I = q30VarM3;
                    codeEditor.postInvalidate();
                    m(motionEvent);
                    return true;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        if (r0 != 3) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i(MotionEvent motionEvent) {
        int iMin;
        int i;
        this.h = motionEvent.getY();
        this.g = motionEvent.getX();
        int action = motionEvent.getAction();
        int i2 = 0;
        int i3 = 1;
        CodeEditor codeEditor = this.a;
        if (action != 0) {
            nf2 nf2Var = this.d;
            if (action != 1) {
                if (action == 2) {
                    if (this.q) {
                        float y = motionEvent.getY() - this.s;
                        this.s = motionEvent.getY();
                        k(0.0f, (y / (codeEditor.getHeight() - codeEditor.getRenderer().h.height())) * codeEditor.getScrollMaxY(), false);
                        return true;
                    }
                    if (this.r) {
                        float x = motionEvent.getX() - this.t;
                        this.t = motionEvent.getX();
                        k((x / (codeEditor.getRenderer().i.width() <= codeEditor.getDpUnit() * 60.0f ? codeEditor.getWidth() - codeEditor.getRenderer().i.width() : codeEditor.getWidth())) * (codeEditor.getWidth() + codeEditor.getScrollMaxX()), 0.0f, false);
                        return true;
                    }
                    if (!e(motionEvent, false)) {
                        if (!this.f) {
                            float fAbs = Math.abs(motionEvent.getX() - this.t);
                            float f = this.y;
                            if (fAbs > f || Math.abs(motionEvent.getY() - this.s) > f) {
                                this.f = true;
                            }
                        }
                        if (this.f) {
                            int i4 = this.e;
                            if (i4 == 0) {
                                this.c.f(motionEvent);
                                m(motionEvent);
                            } else if (i4 == 1) {
                                codeEditor.A0 = codeEditor.getCursor().d.a();
                                this.u.f(motionEvent);
                                m(motionEvent);
                            } else if (i4 == 2) {
                                codeEditor.A0 = codeEditor.getCursor().c.a();
                                this.v.f(motionEvent);
                                m(motionEvent);
                            }
                            if (!nf2Var.b.isShowing()) {
                                if (Math.sqrt(ha0.h(motionEvent.getY(), this.s, motionEvent.getY() - this.s, (motionEvent.getX() - this.t) * (motionEvent.getX() - this.t))) >= 4.0d) {
                                    if (this.x == 0 && f()) {
                                        int i5 = this.e;
                                        RectF rectF = (i5 != 0 ? i5 != 1 ? i5 != 2 ? null : codeEditor.getRightHandleDescriptor() : codeEditor.getLeftHandleDescriptor() : codeEditor.getInsertHandleDescriptor()).a;
                                        float fHeight = rectF.height();
                                        if (codeEditor.w1) {
                                            iMin = Math.min((int) motionEvent.getX(), (int) rectF.right);
                                            i = (int) (rectF.top - (fHeight / 2.0f));
                                        } else {
                                            int x2 = (int) motionEvent.getX();
                                            int y2 = (int) ((motionEvent.getY() - (fHeight / 2.0f)) - codeEditor.getRowHeight());
                                            iMin = x2;
                                            i = y2;
                                        }
                                        nf2Var.b(iMin, i);
                                    } else {
                                        nf2Var.a();
                                    }
                                }
                            }
                            codeEditor.invalidate();
                            return true;
                        }
                    }
                }
                return false;
            }
            if (this.q || this.r) {
                this.r = false;
                this.q = false;
                this.o = System.currentTimeMillis();
                this.o = System.currentTimeMillis();
                codeEditor.a0(new b21(this, i3), 3000L);
            }
            d();
            int i6 = this.e;
            if (i6 != -1) {
                c(i6, false);
                if (this.e == 0) {
                    this.p = System.currentTimeMillis();
                    codeEditor.a0(new b21(this, i2), 3500L);
                }
                this.e = -1;
            }
            codeEditor.invalidate();
            this.x = 0;
            nf2Var.a();
            return false;
        }
        d();
        this.s = motionEvent.getY();
        this.t = motionEvent.getX();
        this.r = false;
        this.q = false;
        RectF rectF2 = codeEditor.getRenderer().h;
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        float dpUnit = codeEditor.getDpUnit() * 10.0f;
        if (x3 >= rectF2.left - dpUnit && x3 <= rectF2.right + dpUnit && y3 >= rectF2.top && y3 <= rectF2.bottom) {
            this.q = true;
        }
        if (codeEditor.getRenderer().i.contains(motionEvent.getX(), motionEvent.getY())) {
            this.r = true;
        }
        boolean z = this.q;
        if (z || this.r) {
            if (z && this.r) {
                this.r = false;
            }
            codeEditor.invalidate();
            return true;
        }
        float dpUnit2 = codeEditor.getDpUnit() * 7.0f;
        if (n() && tj4.a(codeEditor.getInsertHandleDescriptor().a, motionEvent.getX(), motionEvent.getY(), dpUnit2)) {
            this.e = 0;
        }
        boolean zA = tj4.a(codeEditor.getLeftHandleDescriptor().a, motionEvent.getX(), motionEvent.getY(), dpUnit2);
        boolean zA2 = tj4.a(codeEditor.getRightHandleDescriptor().a, motionEvent.getX(), motionEvent.getY(), dpUnit2);
        if (zA) {
            this.e = 1;
        } else if (zA2) {
            this.e = 2;
        }
        int i7 = this.e;
        if (i7 != -1) {
            this.f = false;
            c(i7, true);
        }
        return true;
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
