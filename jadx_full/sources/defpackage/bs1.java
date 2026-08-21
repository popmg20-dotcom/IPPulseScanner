package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bs1 extends nt4 {
    @Override // defpackage.io0
    public final void a(io0 io0Var) {
        wj wjVar = (wj) this.b;
        int i = wjVar.r0;
        oo0 oo0Var = this.h;
        Iterator it = oo0Var.l.iterator();
        int i2 = 0;
        int i3 = -1;
        while (it.hasNext()) {
            int i4 = ((oo0) it.next()).g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (i == 0 || i == 2) {
            oo0Var.d(i3 + wjVar.t0);
        } else {
            oo0Var.d(i2 + wjVar.t0);
        }
    }

    @Override // defpackage.nt4
    public final void d() {
        jc0 jc0Var = this.b;
        if (jc0Var instanceof wj) {
            oo0 oo0Var = this.h;
            oo0Var.b = true;
            ArrayList arrayList = oo0Var.l;
            wj wjVar = (wj) jc0Var;
            int i = wjVar.r0;
            boolean z = wjVar.s0;
            int i2 = 0;
            if (i == 0) {
                oo0Var.e = 4;
                while (i2 < wjVar.q0) {
                    jc0 jc0Var2 = wjVar.p0[i2];
                    if (z || jc0Var2.f0 != 8) {
                        oo0 oo0Var2 = jc0Var2.d.h;
                        oo0Var2.k.add(oo0Var);
                        arrayList.add(oo0Var2);
                    }
                    i2++;
                }
                m(this.b.d.h);
                m(this.b.d.i);
                return;
            }
            if (i == 1) {
                oo0Var.e = 5;
                while (i2 < wjVar.q0) {
                    jc0 jc0Var3 = wjVar.p0[i2];
                    if (z || jc0Var3.f0 != 8) {
                        oo0 oo0Var3 = jc0Var3.d.i;
                        oo0Var3.k.add(oo0Var);
                        arrayList.add(oo0Var3);
                    }
                    i2++;
                }
                m(this.b.d.h);
                m(this.b.d.i);
                return;
            }
            if (i == 2) {
                oo0Var.e = 6;
                while (i2 < wjVar.q0) {
                    jc0 jc0Var4 = wjVar.p0[i2];
                    if (z || jc0Var4.f0 != 8) {
                        oo0 oo0Var4 = jc0Var4.e.h;
                        oo0Var4.k.add(oo0Var);
                        arrayList.add(oo0Var4);
                    }
                    i2++;
                }
                m(this.b.e.h);
                m(this.b.e.i);
                return;
            }
            if (i != 3) {
                return;
            }
            oo0Var.e = 7;
            while (i2 < wjVar.q0) {
                jc0 jc0Var5 = wjVar.p0[i2];
                if (z || jc0Var5.f0 != 8) {
                    oo0 oo0Var5 = jc0Var5.e.i;
                    oo0Var5.k.add(oo0Var);
                    arrayList.add(oo0Var5);
                }
                i2++;
            }
            m(this.b.e.h);
            m(this.b.e.i);
        }
    }

    @Override // defpackage.nt4
    public final void e() {
        jc0 jc0Var = this.b;
        if (jc0Var instanceof wj) {
            int i = ((wj) jc0Var).r0;
            oo0 oo0Var = this.h;
            if (i == 0 || i == 1) {
                jc0Var.X = oo0Var.g;
            } else {
                jc0Var.Y = oo0Var.g;
            }
        }
    }

    @Override // defpackage.nt4
    public final void f() {
        this.c = null;
        this.h.c();
    }

    @Override // defpackage.nt4
    public final boolean k() {
        return false;
    }

    public final void m(oo0 oo0Var) {
        oo0 oo0Var2 = this.h;
        oo0Var2.k.add(oo0Var);
        oo0Var.l.add(oo0Var2);
    }
}
