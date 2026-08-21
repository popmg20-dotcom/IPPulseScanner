package defpackage;

import android.util.SparseArray;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class na2 extends v0 {
    public final AtomicInteger A;
    public qn X;
    public qn Y;
    public jr2 Z;

    public na2(CodeEditor codeEditor, ld0 ld0Var) {
        super(codeEditor, ld0Var);
        this.A = new AtomicInteger(0);
        jr2 jr2Var = new jr2(codeEditor.getTabWidth());
        this.Z = jr2Var;
        jr2Var.b = codeEditor.A1;
        this.X = new qn();
        qn qnVar = new qn();
        this.Y = qnVar;
        e(this.X, qnVar);
    }

    public static void f() {
        Iterator it = Collections.EMPTY_LIST.iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
    }

    @Override // defpackage.w82
    public final int D(int i) {
        return this.b.getText().n().j(i).b;
    }

    @Override // defpackage.vd0
    public final void F(ld0 ld0Var, int i, int i2, int i3, int i4, CharSequence charSequence) {
        for (int i5 = i; i5 <= i3; i5++) {
            if (i5 != i) {
                this.X.a(i5, g(i5, true));
            } else if (i3 == i) {
                int iC = this.Y.c(i5);
                c();
                List list = Collections.EMPTY_LIST;
                this.b.getTextPaint();
                f();
                this.Y.e(i5, 0);
                qn qnVar = this.X;
                int i6 = 0 - iC;
                qnVar.e(i5, i6 + qnVar.c(i5) + ((int) this.Z.b(this.f.o(i5), i2, i4, this.b.getTextPaint())));
            } else {
                this.X.e(i5, g(i5, false));
            }
        }
    }

    @Override // defpackage.w82
    public final void J() {
        this.b = null;
        this.f = null;
        this.X = null;
        this.Y = null;
    }

    @Override // defpackage.w82
    public final long L(int i, int i2) {
        int i3 = i - 1;
        if (i3 < 0) {
            return ez4.M(0, 0);
        }
        int i4 = this.f.o(i3).f;
        if (i2 > i4) {
            i2 = i4;
        }
        return ez4.M(i3, i2);
    }

    @Override // defpackage.w82
    public final int M(int i) {
        return Math.max(0, Math.min(i, this.f.b.size() - 1));
    }

    @Override // defpackage.w82
    public final im3 N(int i) {
        im3 im3Var = new im3();
        im3Var.a = i;
        im3Var.d = 0;
        im3Var.b = true;
        im3Var.c = true;
        im3Var.e = this.f.o(i).f;
        c();
        im3Var.f = Collections.EMPTY_LIST;
        return im3Var;
    }

    @Override // defpackage.vd0
    public final void Q(ld0 ld0Var, int i, int i2, int i3, int i4, StringBuilder sb) {
        if (i < i3) {
            int i5 = i + 1;
            int i6 = i3 + 1;
            this.X.d(i5, i6);
            this.Y.d(i5, i6);
        }
        if (i != i3) {
            this.X.e(i, g(i, false));
            return;
        }
        int iC = this.Y.c(i);
        c();
        List list = Collections.EMPTY_LIST;
        this.b.getTextPaint();
        f();
        this.Y.e(i, 0);
        qn qnVar = this.X;
        qnVar.e(i, (0 - iC) + (qnVar.c(i) - ((int) this.Z.b(sb, 0, i4 - i2, this.b.getTextPaint()))));
    }

    @Override // defpackage.w82
    public final void R(oj1 oj1Var) {
        int i;
        int i2;
        int[] iArr = (int[]) oj1Var.f;
        int size = this.f.b.size() - 1;
        int i3 = 0;
        while (true) {
            if (!(i3 < iArr.length)) {
                return;
            }
            if (i3 < iArr.length) {
                i = i3 + 1;
                i2 = iArr[i3];
                if (i2 > size) {
                    i3 = i;
                    i = i3;
                    i2 = size;
                }
            } else {
                i = i3;
                i2 = size;
            }
            this.X.e(i2, g(i2, false));
            i3 = i;
        }
    }

    @Override // defpackage.w82
    public final int Z() {
        qn qnVar = this.X;
        if (qnVar.e == 0) {
            return 214748364;
        }
        int i = qnVar.f;
        if (i != qnVar.j) {
            qnVar.j = i;
        }
        qnVar.k = 0;
        on onVar = qnVar.g;
        while (true) {
            int i2 = qnVar.k;
            if (onVar == null) {
                return i2;
            }
            qnVar.k = Math.max(i2, onVar.c);
            onVar = onVar.d;
        }
    }

    @Override // defpackage.w82
    public final int d() {
        return this.f.b.size();
    }

    public final void e(qn qnVar, qn qnVar2) {
        if (this.f == null) {
            return;
        }
        c03 c03Var = new c03(this.b.A1);
        c03Var.set(this.b.getTextPaint());
        c03Var.b();
        int i = this.A.get();
        la2 la2Var = new la2(this, new u0(1, new ja2(i, this)), qnVar, this.Z, c03Var, qnVar2, i);
        this.b.setLayoutBusy(true);
        v0.z.submit(la2Var);
    }

    public final int g(int i, boolean z) {
        ud0 ud0VarO = this.f.o(i);
        c();
        List list = Collections.EMPTY_LIST;
        this.b.getTextPaint();
        f();
        qn qnVar = this.Y;
        if (z) {
            qnVar.a(i, 0);
        } else {
            qnVar.e(i, 0);
        }
        return (int) this.Z.b(ud0VarO, 0, ud0VarO.f, this.b.getTextPaint());
    }

    @Override // defpackage.w82
    public final long k(float f, float f2) {
        int iMin = Math.min(this.f.b.size() - 1, Math.max((int) (f2 / this.b.getRowHeight()), 0));
        return ez4.M(iMin, this.b.getRenderer().d(iMin).f(f));
    }

    @Override // defpackage.w82
    public final int l() {
        return this.b.getRowHeight() * this.f.b.size();
    }

    @Override // defpackage.w82
    public final float[] n(int i, int i2, float[] fArr) {
        if (fArr == null || fArr.length < 2) {
            fArr = new float[2];
        }
        fArr[0] = this.b.A(i);
        fArr[1] = this.b.getRenderer().d(i).e(i2);
        return fArr;
    }

    @Override // defpackage.w82
    public final km3 s(int i, SparseArray sparseArray) {
        return new ma2(this, this.f, i, sparseArray);
    }

    @Override // defpackage.w82
    public final long t(int i, int i2) {
        int size = this.f.b.size();
        int i3 = i + 1;
        ld0 ld0Var = this.f;
        if (i3 >= size) {
            return ez4.M(i, ld0Var.o(i).f);
        }
        int i4 = ld0Var.o(i3).f;
        if (i2 > i4) {
            i2 = i4;
        }
        return ez4.M(i3, i2);
    }

    @Override // defpackage.w82
    public final int u(int i) {
        return 1;
    }

    @Override // defpackage.vd0
    public final void a(ld0 ld0Var) {
    }
}
