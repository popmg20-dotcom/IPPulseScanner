package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ab2 {
    public h31 a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;

    public ab2() {
        c();
    }

    public final void a() {
        boolean z = this.d;
        h31 h31Var = this.a;
        this.c = z ? h31Var.i() : h31Var.m();
    }

    public final void b(View view, int i) {
        h31 h31Var = this.a;
        int iN = Integer.MIN_VALUE == h31Var.a ? 0 : h31Var.n() - h31Var.a;
        if (iN >= 0) {
            boolean z = this.d;
            h31 h31Var2 = this.a;
            if (z) {
                int iD = h31Var2.d(view);
                h31 h31Var3 = this.a;
                this.c = (Integer.MIN_VALUE != h31Var3.a ? h31Var3.n() - h31Var3.a : 0) + iD;
            } else {
                this.c = h31Var2.g(view);
            }
            this.b = i;
            return;
        }
        this.b = i;
        boolean z2 = this.d;
        h31 h31Var4 = this.a;
        if (!z2) {
            int iG = h31Var4.g(view);
            int iM = iG - this.a.m();
            this.c = iG;
            if (iM > 0) {
                int i2 = (this.a.i() - Math.min(0, (this.a.i() - iN) - this.a.d(view))) - (this.a.e(view) + iG);
                if (i2 < 0) {
                    this.c -= Math.min(iM, -i2);
                    return;
                }
                return;
            }
            return;
        }
        int i3 = (h31Var4.i() - iN) - this.a.d(view);
        this.c = this.a.i() - i3;
        if (i3 > 0) {
            int iE = this.c - this.a.e(view);
            int iM2 = this.a.m();
            int iMin = iE - (Math.min(this.a.g(view) - iM2, 0) + iM2);
            if (iMin < 0) {
                this.c = Math.min(i3, -iMin) + this.c;
            }
        }
    }

    public final void c() {
        this.b = -1;
        this.c = Integer.MIN_VALUE;
        this.d = false;
        this.e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
    }
}
