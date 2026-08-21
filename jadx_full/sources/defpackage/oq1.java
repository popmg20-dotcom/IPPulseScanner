package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oq1 extends nt4 {
    @Override // defpackage.io0
    public final void a(io0 io0Var) {
        oo0 oo0Var = this.h;
        if (oo0Var.c && !oo0Var.j) {
            oo0Var.d((int) ((((oo0) oo0Var.l.get(0)).g * ((nq1) this.b).p0) + 0.5f));
        }
    }

    @Override // defpackage.nt4
    public final void d() {
        jc0 jc0Var = this.b;
        nq1 nq1Var = (nq1) jc0Var;
        int i = nq1Var.q0;
        int i2 = nq1Var.r0;
        int i3 = nq1Var.t0;
        oo0 oo0Var = this.h;
        if (i3 == 1) {
            if (i != -1) {
                oo0Var.l.add(jc0Var.S.d.h);
                this.b.S.d.h.k.add(oo0Var);
                oo0Var.f = i;
            } else if (i2 != -1) {
                oo0Var.l.add(jc0Var.S.d.i);
                this.b.S.d.i.k.add(oo0Var);
                oo0Var.f = -i2;
            } else {
                oo0Var.b = true;
                oo0Var.l.add(jc0Var.S.d.i);
                this.b.S.d.i.k.add(oo0Var);
            }
            m(this.b.d.h);
            m(this.b.d.i);
            return;
        }
        if (i != -1) {
            oo0Var.l.add(jc0Var.S.e.h);
            this.b.S.e.h.k.add(oo0Var);
            oo0Var.f = i;
        } else if (i2 != -1) {
            oo0Var.l.add(jc0Var.S.e.i);
            this.b.S.e.i.k.add(oo0Var);
            oo0Var.f = -i2;
        } else {
            oo0Var.b = true;
            oo0Var.l.add(jc0Var.S.e.i);
            this.b.S.e.i.k.add(oo0Var);
        }
        m(this.b.e.h);
        m(this.b.e.i);
    }

    @Override // defpackage.nt4
    public final void e() {
        jc0 jc0Var = this.b;
        int i = ((nq1) jc0Var).t0;
        oo0 oo0Var = this.h;
        if (i == 1) {
            jc0Var.X = oo0Var.g;
        } else {
            jc0Var.Y = oo0Var.g;
        }
    }

    @Override // defpackage.nt4
    public final void f() {
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
