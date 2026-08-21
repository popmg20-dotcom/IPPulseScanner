package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hm implements lc2 {
    public final lc2 b;
    public int f = 0;
    public int z = -1;
    public int A = -1;
    public Object X = null;

    public hm(lc2 lc2Var) {
        this.b = lc2Var;
    }

    @Override // defpackage.lc2
    public final void D(int i, int i2) {
        int i3;
        if (this.f == 1 && i >= (i3 = this.z)) {
            int i4 = this.A;
            if (i <= i3 + i4) {
                this.A = i4 + i2;
                this.z = Math.min(i, i3);
                return;
            }
        }
        a();
        this.z = i;
        this.A = i2;
        this.f = 1;
    }

    @Override // defpackage.lc2
    public final void P(int i, int i2) {
        int i3;
        if (this.f == 2 && (i3 = this.z) >= i && i3 <= i + i2) {
            this.A += i2;
            this.z = i;
        } else {
            a();
            this.z = i;
            this.A = i2;
            this.f = 2;
        }
    }

    public final void a() {
        int i = this.f;
        if (i == 0) {
            return;
        }
        lc2 lc2Var = this.b;
        if (i == 1) {
            lc2Var.D(this.z, this.A);
        } else if (i == 2) {
            lc2Var.P(this.z, this.A);
        } else if (i == 3) {
            lc2Var.d0(this.z, this.A, this.X);
        }
        this.X = null;
        this.f = 0;
    }

    @Override // defpackage.lc2
    public final void d0(int i, int i2, Object obj) {
        int i3;
        int i4;
        int i5;
        if (this.f == 3 && i <= (i4 = this.A + (i3 = this.z)) && (i5 = i + i2) >= i3 && this.X == obj) {
            this.z = Math.min(i, i3);
            this.A = Math.max(i4, i5) - this.z;
            return;
        }
        a();
        this.z = i;
        this.A = i2;
        this.X = obj;
        this.f = 3;
    }

    @Override // defpackage.lc2
    public final void g(int i, int i2) {
        a();
        this.b.g(i, i2);
    }
}
