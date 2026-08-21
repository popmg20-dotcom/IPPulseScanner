package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lf4 extends gb4 {
    public final /* synthetic */ int g;
    public boolean h;
    public int i;
    public final /* synthetic */ Object j;

    public lf4(dr4 dr4Var) {
        this.g = 1;
        this.j = dr4Var;
        this.h = false;
        this.i = 0;
    }

    @Override // defpackage.gb4, defpackage.er4
    public void a() {
        switch (this.g) {
            case 0:
                this.h = true;
                break;
        }
    }

    @Override // defpackage.gb4, defpackage.er4
    public final void b() {
        int i = this.g;
        Object obj = this.j;
        switch (i) {
            case 0:
                ((mf4) obj).a.setVisibility(0);
                break;
            default:
                if (!this.h) {
                    this.h = true;
                    er4 er4Var = ((dr4) obj).d;
                    if (er4Var != null) {
                        er4Var.b();
                    }
                    break;
                }
                break;
        }
    }

    @Override // defpackage.er4
    public final void c() {
        int i = this.g;
        Object obj = this.j;
        switch (i) {
            case 0:
                if (!this.h) {
                    ((mf4) obj).a.setVisibility(this.i);
                }
                break;
            default:
                int i2 = this.i + 1;
                this.i = i2;
                dr4 dr4Var = (dr4) obj;
                if (i2 == dr4Var.a.size()) {
                    er4 er4Var = dr4Var.d;
                    if (er4Var != null) {
                        er4Var.c();
                    }
                    this.i = 0;
                    this.h = false;
                    dr4Var.e = false;
                }
                break;
        }
    }

    public lf4(mf4 mf4Var, int i) {
        this.g = 0;
        this.j = mf4Var;
        this.i = i;
        this.h = false;
    }
}
