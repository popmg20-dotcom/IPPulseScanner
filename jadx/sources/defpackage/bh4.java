package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bh4 extends xg4 {
    public final /* synthetic */ int a;
    public vg4 b;

    public /* synthetic */ bh4(vg4 vg4Var, int i) {
        this.a = i;
        this.b = vg4Var;
    }

    @Override // defpackage.xg4, defpackage.tg4
    public void a(vg4 vg4Var) {
        switch (this.a) {
            case 1:
                ch4 ch4Var = (ch4) this.b;
                if (!ch4Var.a1) {
                    ch4Var.S();
                    ch4Var.a1 = true;
                }
                break;
        }
    }

    @Override // defpackage.xg4, defpackage.tg4
    public void c(vg4 vg4Var) {
        switch (this.a) {
            case 1:
                ch4 ch4Var = (ch4) this.b;
                int i = ch4Var.Z0 - 1;
                ch4Var.Z0 = i;
                if (i == 0) {
                    ch4Var.a1 = false;
                    ch4Var.n();
                }
                vg4Var.E(this);
                break;
            case 2:
                this.b.J();
                vg4Var.E(this);
                break;
        }
    }

    @Override // defpackage.xg4, defpackage.tg4
    public void g(vg4 vg4Var) {
        switch (this.a) {
            case 0:
                ch4 ch4Var = (ch4) this.b;
                ch4Var.X0.remove(vg4Var);
                if (!ch4Var.w()) {
                    ch4Var.B(ch4Var, e04.A, false);
                    ch4Var.K0 = true;
                    ch4Var.B(ch4Var, e04.z, false);
                }
                break;
        }
    }

    public /* synthetic */ bh4() {
        this.a = 1;
    }
}
