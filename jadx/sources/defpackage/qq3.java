package defpackage;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qq3 extends fg3 {
    public x90 a;
    public final ViewPager2 b;
    public final yq4 c;
    public final LinearLayoutManager d;
    public int e;
    public int f;
    public final pq3 g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    public qq3(ViewPager2 viewPager2) {
        this.b = viewPager2;
        yq4 yq4Var = viewPager2.D0;
        this.c = yq4Var;
        this.d = (LinearLayoutManager) yq4Var.getLayoutManager();
        this.g = new pq3();
        e();
    }

    @Override // defpackage.fg3
    public final void a(RecyclerView recyclerView, int i) {
        x90 x90Var;
        int i2 = this.e;
        if (!(i2 == 1 && this.f == 1) && i == 1) {
            this.e = 1;
            int i3 = this.i;
            if (i3 != -1) {
                this.h = i3;
                this.i = -1;
            } else if (this.h == -1) {
                LinearLayoutManager linearLayoutManager = this.d;
                View viewU0 = linearLayoutManager.U0(0, linearLayoutManager.v(), false, true);
                this.h = viewU0 != null ? ag3.K(viewU0) : -1;
            }
            d(1);
            return;
        }
        if ((i2 == 1 || i2 == 4) && i == 2) {
            if (this.k) {
                d(2);
                this.j = true;
                return;
            }
            return;
        }
        pq3 pq3Var = this.g;
        if ((i2 == 1 || i2 == 4) && i == 0) {
            f();
            if (!this.k) {
                int i4 = pq3Var.a;
                if (i4 != -1 && (x90Var = this.a) != null) {
                    x90Var.b(i4, 0.0f, 0);
                }
            } else if (pq3Var.c == 0) {
                int i5 = this.h;
                int i6 = pq3Var.a;
                if (i5 != i6) {
                    c(i6);
                }
            }
            d(0);
            e();
        }
        if (this.e == 2 && i == 0 && this.l) {
            f();
            if (pq3Var.c == 0) {
                int i7 = this.i;
                int i8 = pq3Var.a;
                if (i7 != i8) {
                    if (i8 == -1) {
                        i8 = 0;
                    }
                    c(i8);
                }
                d(0);
                e();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    @Override // defpackage.fg3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
        /*
            r5 = this;
            r6 = 1
            r5.k = r6
            r5.f()
            boolean r0 = r5.j
            r1 = -1
            pq3 r2 = r5.g
            r3 = 0
            if (r0 == 0) goto L3e
            r5.j = r3
            if (r8 > 0) goto L2a
            if (r8 != 0) goto L32
            if (r7 >= 0) goto L18
            r7 = r6
            goto L19
        L18:
            r7 = r3
        L19:
            androidx.viewpager2.widget.ViewPager2 r8 = r5.b
            uq4 r8 = r8.A0
            androidx.recyclerview.widget.RecyclerView r8 = r8.b
            int r8 = r8.getLayoutDirection()
            if (r8 != r6) goto L27
            r8 = r6
            goto L28
        L27:
            r8 = r3
        L28:
            if (r7 != r8) goto L32
        L2a:
            int r7 = r2.c
            if (r7 == 0) goto L32
            int r7 = r2.a
            int r7 = r7 + r6
            goto L34
        L32:
            int r7 = r2.a
        L34:
            r5.i = r7
            int r8 = r5.h
            if (r8 == r7) goto L4a
            r5.c(r7)
            goto L4a
        L3e:
            int r7 = r5.e
            if (r7 != 0) goto L4a
            int r7 = r2.a
            if (r7 != r1) goto L47
            r7 = r3
        L47:
            r5.c(r7)
        L4a:
            int r7 = r2.a
            if (r7 != r1) goto L4f
            r7 = r3
        L4f:
            float r8 = r2.b
            int r0 = r2.c
            x90 r4 = r5.a
            if (r4 == 0) goto L5a
            r4.b(r7, r8, r0)
        L5a:
            int r7 = r2.a
            int r8 = r5.i
            if (r7 == r8) goto L62
            if (r8 != r1) goto L70
        L62:
            int r7 = r2.c
            if (r7 != 0) goto L70
            int r7 = r5.f
            if (r7 == r6) goto L70
            r5.d(r3)
            r5.e()
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qq3.b(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void c(int i) {
        x90 x90Var = this.a;
        if (x90Var != null) {
            x90Var.c(i);
        }
    }

    public final void d(int i) {
        if ((this.e == 3 && this.f == 0) || this.f == i) {
            return;
        }
        this.f = i;
        x90 x90Var = this.a;
        if (x90Var != null) {
            x90Var.a(i);
        }
    }

    public final void e() {
        this.e = 0;
        this.f = 0;
        pq3 pq3Var = this.g;
        pq3Var.a = -1;
        pq3Var.b = 0.0f;
        pq3Var.c = 0;
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.l = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qq3.f():void");
    }
}
