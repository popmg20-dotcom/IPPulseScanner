package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ox3 extends k70 {
    public int X;
    public int Y;

    public ox3(int i, int i2) {
        super((byte) 0, 7);
        this.X = i;
        this.Y = i2;
    }

    @Override // defpackage.k70
    public final void F0() {
        this.Y = -1;
        this.X = -1;
    }

    @Override // defpackage.k70
    public final int M0(int i) {
        if (i == 0) {
            return this.X;
        }
        s53.k(dw2.A(i, ""));
        return 0;
    }

    @Override // defpackage.k70
    public final int N0(int i) {
        if (i == 0) {
            return this.Y;
        }
        s53.k(dw2.A(i, ""));
        return 0;
    }

    @Override // defpackage.k70
    public final int O0() {
        return 1;
    }

    @Override // defpackage.k70
    public final int T0(int i, int i2) {
        if (i == 0) {
            this.X = i2;
            return i2;
        }
        s53.k(dw2.A(i, ""));
        return 0;
    }

    @Override // defpackage.k70
    public final int U0(int i, int i2) {
        if (i == 0) {
            this.Y = i2;
            return i2;
        }
        s53.k(dw2.A(i, ""));
        return 0;
    }

    public final Object clone() {
        ox3 ox3Var = new ox3(this.X, this.Y);
        tt ttVar = (tt) this.f;
        if (ttVar != null) {
            ox3Var.f = ttVar.b();
        }
        return ox3Var;
    }
}
