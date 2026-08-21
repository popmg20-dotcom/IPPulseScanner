package defpackage;

import android.util.SparseArray;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lw4 extends v0 {
    public static final ArrayList y0;
    public final int A;
    public final float X;
    public final boolean Y;
    public List Z;

    static {
        ArrayList arrayList = new ArrayList();
        y0 = arrayList;
        arrayList.add(as2.a(0, uf2.G(0, true, true)));
    }

    public lw4(CodeEditor codeEditor, ld0 ld0Var, boolean z, lw4 lw4Var, boolean z2) {
        super(codeEditor, ld0Var);
        this.Y = z;
        List arrayList = lw4Var != null ? lw4Var.Z : new ArrayList();
        this.Z = arrayList;
        if (z2) {
            arrayList.clear();
        }
        float fX = (codeEditor.getNonPrintablePaintingFlags() & 128) != 0 ? codeEditor.getRenderer().x() : 0.0f;
        this.X = fX;
        this.A = (codeEditor.getWidth() - ((int) (codeEditor.getTextPaint().measureText("a") + codeEditor.T()))) - (((int) fX) * 2);
        int iMin = Math.min(8, (int) Math.ceil(this.f.b.size() / 3000.0f));
        int size = this.f.b.size() / iMin;
        u0 u0Var = new u0(iMin, new o73(14, this));
        this.b.setLayoutBusy(true);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iMin) {
                return;
            }
            i = i2 + 1;
            lw4 lw4Var2 = this;
            v0.z.submit(new jw4(lw4Var2, u0Var, i2, size * i2, (i == iMin ? this.f.b.size() : size * i) - 1));
            this = lw4Var2;
        }
    }

    @Override // defpackage.w82
    public final int D(int i) {
        int i2;
        q30 q30VarJ = this.b.getText().n().j(i);
        int i3 = q30VarJ.b;
        if (this.Z.isEmpty()) {
            return i3;
        }
        int i4 = q30VarJ.c;
        int iG = g(i3);
        if (iG >= this.Z.size()) {
            return 0;
        }
        iw4 iw4Var = (iw4) this.Z.get(iG);
        if (iw4Var.d != i3) {
            return 0;
        }
        while (iw4Var.a < i4 && (i2 = iG + 1) < this.Z.size()) {
            iw4 iw4Var2 = (iw4) this.Z.get(i2);
            if (iw4Var2.d != i3 || iw4Var2.a > i4) {
                break;
            }
            iG = i2;
            iw4Var = iw4Var2;
        }
        return iG;
    }

    @Override // defpackage.vd0
    public final void F(ld0 ld0Var, int i, int i2, int i3, int i4, CharSequence charSequence) {
        int i5 = i3 - i;
        if (i5 != 0) {
            for (int iG = g(i + 1); iG < this.Z.size(); iG++) {
                ((iw4) this.Z.get(iG)).d += i5;
            }
        }
        f(i, i3);
    }

    @Override // defpackage.w82
    public final void J() {
        this.b = null;
        this.f = null;
        this.Z = null;
    }

    @Override // defpackage.w82
    public final long L(int i, int i2) {
        long jM = ez4.M(0, 0);
        if (this.Z.isEmpty()) {
            int i3 = i - 1;
            if (i3 < 0) {
                return jM;
            }
            int i4 = this.f.o(i3).f;
            if (i2 > i4) {
                i2 = i4;
            }
            return ez4.M(i3, i2);
        }
        int iH = h(i, i2);
        if (iH <= 0) {
            return jM;
        }
        int i5 = i2 - ((iw4) this.Z.get(iH)).a;
        iw4 iw4Var = (iw4) this.Z.get(iH - 1);
        int i6 = iw4Var.b;
        int i7 = iw4Var.a;
        return ez4.M(iw4Var.d, i7 + Math.min(i5, i6 - i7));
    }

    @Override // defpackage.w82
    public final int M(int i) {
        if (this.Z.isEmpty()) {
            return Math.max(0, Math.min(i, this.f.b.size() - 1));
        }
        int size = this.Z.size();
        List list = this.Z;
        return i >= size ? ((iw4) list.get(list.size() - 1)).d : ((iw4) list.get(i)).d;
    }

    @Override // defpackage.w82
    public final im3 N(int i) {
        if (this.Z.isEmpty()) {
            im3 im3Var = new im3();
            im3Var.d = 0;
            im3Var.e = this.f.o(i).f;
            im3Var.b = true;
            im3Var.c = true;
            im3Var.a = i;
            c();
            im3Var.f = Collections.EMPTY_LIST;
            return im3Var;
        }
        iw4 iw4Var = (iw4) this.Z.get(i);
        boolean z = i <= 0 || ((iw4) this.Z.get(i + (-1))).d != iw4Var.d;
        int i2 = i + 1;
        boolean z2 = i2 >= this.Z.size() || ((iw4) this.Z.get(i2)).d != iw4Var.d;
        iw4 iw4Var2 = (iw4) this.Z.get(i);
        float f = this.A;
        iw4Var2.getClass();
        im3 im3Var2 = new im3();
        im3Var2.b = z;
        im3Var2.c = z2;
        im3Var2.d = iw4Var2.a;
        im3Var2.e = iw4Var2.b;
        im3Var2.a = iw4Var2.d;
        List list = iw4Var2.c;
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        im3Var2.f = list;
        im3Var2.g = iw4Var2.a(f);
        return im3Var2;
    }

    @Override // defpackage.vd0
    public final void Q(ld0 ld0Var, int i, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        int i6 = i3 - i;
        if (i6 != 0) {
            int iG = g(i);
            while (iG < this.Z.size() && (i5 = ((iw4) this.Z.get(iG)).d) >= i && i5 <= i3) {
                this.Z.remove(iG);
            }
            for (int iG2 = g(i3 + 1); iG2 < this.Z.size(); iG2++) {
                iw4 iw4Var = (iw4) this.Z.get(iG2);
                int i7 = iw4Var.d;
                if (i7 >= i3) {
                    iw4Var.d = i7 - i6;
                }
            }
        }
        f(i, i);
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
            f(i2, i2);
            i3 = i;
        }
    }

    @Override // defpackage.w82
    public final int Z() {
        return 0;
    }

    @Override // defpackage.w82
    public final int d() {
        return this.Z.isEmpty() ? this.f.b.size() : this.Z.size();
    }

    public final ArrayList e(int i, ud0 ud0Var, c03 c03Var) {
        if (c03Var == null) {
            c03Var = new c03(this.b.A1);
            c03Var.set(this.b.getTextPaint());
        }
        uc4 uc4Var = new uc4();
        bv0 bv0VarP = this.f.p(i);
        int i2 = ud0Var.f;
        c();
        uc4Var.n(ud0Var, 0, i2, y0, Collections.EMPTY_LIST, bv0VarP, c03Var, null, this.b.getRenderer().e());
        ArrayList<tc4> arrayList = new ArrayList();
        mc4 mc4Var = new mc4(uc4Var, arrayList, this.A, this.Y ? new e24(uc4Var.d) : d7.z0);
        uc4Var.l(mc4Var, false);
        if (arrayList.isEmpty()) {
            tc4 tc4Var = mc4Var.a;
            if (tc4Var.a) {
                tc4Var.a = false;
                tc4Var.b = uc4Var.f;
                tc4Var.c = uc4Var.g;
            }
        }
        if (!mc4Var.a.a) {
            mc4Var.b();
        }
        ArrayList arrayList2 = new ArrayList();
        for (tc4 tc4Var2 : arrayList) {
            arrayList2.add(new iw4(i, tc4Var2.b, tc4Var2.c, null, tc4Var2.d, false));
        }
        return arrayList2;
    }

    public final void f(int i, int i2) {
        int i3;
        int i4 = 0;
        while (i4 < this.Z.size() && ((iw4) this.Z.get(i4)).d < i) {
            i4++;
        }
        while (i4 < this.Z.size() && (i3 = ((iw4) this.Z.get(i4)).d) >= i && i3 <= i2) {
            this.Z.remove(i4);
        }
        ArrayList arrayList = new ArrayList();
        while (i <= i2) {
            arrayList.addAll(e(i, this.f.o(i), null));
            i++;
        }
        this.Z.addAll(i4, arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        r2 = java.lang.Math.max(0, java.lang.Math.min(r5.Z.size() - 1, r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(int r6) {
        /*
            r5 = this;
            java.util.List r0 = r5.Z
            int r0 = r0.size()
            r1 = 0
            r2 = r1
        L8:
            if (r2 > r0) goto L40
            int r3 = r2 + r0
            int r3 = r3 / 2
            if (r3 < 0) goto L30
            java.util.List r4 = r5.Z
            int r4 = r4.size()
            if (r3 < r4) goto L19
            goto L30
        L19:
            java.util.List r4 = r5.Z
            java.lang.Object r4 = r4.get(r3)
            iw4 r4 = (defpackage.iw4) r4
            int r4 = r4.d
            if (r4 >= r6) goto L28
            int r2 = r3 + 1
            goto L8
        L28:
            if (r4 <= r6) goto L2e
            int r3 = r3 + (-1)
            r0 = r3
            goto L8
        L2e:
            r2 = r3
            goto L40
        L30:
            java.util.List r6 = r5.Z
            int r6 = r6.size()
            int r6 = r6 + (-1)
            int r6 = java.lang.Math.min(r6, r3)
            int r2 = java.lang.Math.max(r1, r6)
        L40:
            if (r2 <= 0) goto L51
            java.util.List r6 = r5.Z
            java.lang.Object r6 = r6.get(r2)
            iw4 r6 = (defpackage.iw4) r6
            int r6 = r6.a
            if (r6 <= 0) goto L51
            int r2 = r2 + (-1)
            goto L40
        L51:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lw4.g(int):int");
    }

    public final int h(int i, int i2) {
        int i3;
        int iG = g(i);
        while (((iw4) this.Z.get(iG)).b <= i2 && (i3 = iG + 1) < this.Z.size() && ((iw4) this.Z.get(i3)).d == i) {
            iG = i3;
        }
        return iG;
    }

    @Override // defpackage.w82
    public final long k(float f, float f2) {
        if (this.Z.isEmpty()) {
            int iMin = Math.min(this.f.b.size() - 1, Math.max((int) (f2 / this.b.getRowHeight()), 0));
            return ez4.M(iMin, this.b.getRenderer().d(iMin).f(f));
        }
        int iMax = Math.max(0, Math.min((int) (f2 / this.b.getRowHeight()), this.Z.size() - 1));
        iw4 iw4Var = (iw4) this.Z.get(iMax);
        if (iw4Var.a != 0) {
            f -= this.X;
        }
        return ez4.M(iw4Var.d, this.b.getRenderer().d(iMax).f(f - iw4Var.a(this.A)));
    }

    @Override // defpackage.w82
    public final int l() {
        int size;
        int rowHeight;
        if (this.Z.isEmpty()) {
            size = this.b.getRowHeight();
            rowHeight = this.f.b.size();
        } else {
            size = this.Z.size();
            rowHeight = this.b.getRowHeight();
        }
        return rowHeight * size;
    }

    @Override // defpackage.w82
    public final float[] n(int i, int i2, float[] fArr) {
        int i3;
        if (fArr == null || fArr.length < 2) {
            fArr = new float[2];
        }
        if (this.Z.isEmpty()) {
            fArr[0] = this.b.A(i);
            fArr[1] = this.b.getRenderer().d(i).e(i2);
            return fArr;
        }
        int iG = g(i);
        if (iG >= this.Z.size()) {
            fArr[1] = 0.0f;
            fArr[0] = 0.0f;
            return fArr;
        }
        iw4 iw4Var = (iw4) this.Z.get(iG);
        if (iw4Var.d != i) {
            fArr[1] = 0.0f;
            fArr[0] = 0.0f;
            return fArr;
        }
        while (iw4Var.a < i2 && (i3 = iG + 1) < this.Z.size()) {
            iw4Var = (iw4) this.Z.get(i3);
            if (iw4Var.d != i || iw4Var.a > i2) {
                iw4Var = (iw4) this.Z.get(iG);
                break;
            }
            iG = i3;
        }
        fArr[0] = this.b.A(iG);
        float fE = this.b.getRenderer().d(iG).e(i2);
        fArr[1] = fE;
        if (iw4Var.a != 0) {
            fArr[1] = fE + this.X;
        }
        fArr[1] = iw4Var.a(this.A) + fArr[1];
        return fArr;
    }

    @Override // defpackage.w82
    public final km3 s(int i, SparseArray sparseArray) {
        return this.Z.isEmpty() ? new ma2(this, this.f, i, sparseArray) : new w41(this, i);
    }

    @Override // defpackage.w82
    public final long t(int i, int i2) {
        if (this.Z.isEmpty()) {
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
        int iH = h(i, i2);
        int i5 = iH + 1;
        if (i5 >= this.Z.size()) {
            return ez4.M(i, this.f.o(i).f);
        }
        int i6 = i2 - ((iw4) this.Z.get(iH)).a;
        iw4 iw4Var = (iw4) this.Z.get(i5);
        int i7 = iw4Var.b;
        int i8 = iw4Var.a;
        return ez4.M(iw4Var.d, i8 + Math.min(i6, i7 - i8));
    }

    @Override // defpackage.w82
    public final int u(int i) {
        if (this.Z.isEmpty()) {
            return 1;
        }
        int i2 = 0;
        for (int iG = g(i); iG < this.Z.size() && ((iw4) this.Z.get(iG)).d == i; iG++) {
            i2++;
        }
        return i2;
    }

    @Override // defpackage.vd0
    public final void a(ld0 ld0Var) {
    }
}
