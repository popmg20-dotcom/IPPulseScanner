package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ox2 implements lc2 {
    public int A;
    public int X;
    public int Y;
    public int Z;
    public final ez2 b;
    public final zf2 f;
    public int z;

    public ox2(ez2 ez2Var, ez2 ez2Var2, zf2 zf2Var) {
        ez2Var.getClass();
        this.b = ez2Var2;
        this.f = zf2Var;
        this.z = ez2Var.c;
        this.A = ez2Var.d;
        this.X = ez2Var.b;
        this.Y = 1;
        this.Z = 1;
    }

    @Override // defpackage.lc2
    public final void D(int i, int i2) {
        int i3 = this.X;
        pu0 pu0Var = pu0.f;
        zf2 zf2Var = this.f;
        if (i >= i3 && this.Z != 2) {
            int iMin = Math.min(i2, this.A);
            if (iMin > 0) {
                this.Z = 3;
                zf2Var.d0(this.z + i, iMin, pu0Var);
                this.A -= iMin;
            }
            int i4 = i2 - iMin;
            if (i4 > 0) {
                zf2Var.D(i + iMin + this.z, i4);
            }
        } else if (i <= 0 && this.Y != 2) {
            int iMin2 = Math.min(i2, this.z);
            if (iMin2 > 0) {
                this.Y = 3;
                zf2Var.d0((0 - iMin2) + this.z, iMin2, pu0Var);
                this.z -= iMin2;
            }
            int i5 = i2 - iMin2;
            if (i5 > 0) {
                zf2Var.D(this.z, i5);
            }
        } else {
            zf2Var.D(i + this.z, i2);
        }
        this.X += i2;
    }

    @Override // defpackage.lc2
    public final void P(int i, int i2) {
        int i3;
        int i4 = i + i2;
        int i5 = this.X;
        pu0 pu0Var = pu0.b;
        ez2 ez2Var = this.b;
        zf2 zf2Var = this.f;
        if (i4 >= i5 && this.Z != 3) {
            int iMin = Math.min(ez2Var.d - this.A, i2);
            i3 = iMin >= 0 ? iMin : 0;
            int i6 = i2 - i3;
            if (i3 > 0) {
                this.Z = 2;
                zf2Var.d0(this.z + i, i3, pu0Var);
                this.A += i3;
            }
            if (i6 > 0) {
                zf2Var.P(i + i3 + this.z, i6);
            }
        } else if (i <= 0 && this.Y != 3) {
            int iMin2 = Math.min(ez2Var.c - this.z, i2);
            i3 = iMin2 >= 0 ? iMin2 : 0;
            int i7 = i2 - i3;
            if (i7 > 0) {
                zf2Var.P(this.z, i7);
            }
            if (i3 > 0) {
                this.Y = 2;
                zf2Var.d0(this.z, i3, pu0Var);
                this.z += i3;
            }
        } else {
            zf2Var.P(i + this.z, i2);
        }
        this.X -= i2;
    }

    @Override // defpackage.lc2
    public final void d0(int i, int i2, Object obj) {
        this.f.d0(i + this.z, i2, obj);
    }

    @Override // defpackage.lc2
    public final void g(int i, int i2) {
        int i3 = this.z;
        this.f.g(i + i3, i2 + i3);
    }
}
