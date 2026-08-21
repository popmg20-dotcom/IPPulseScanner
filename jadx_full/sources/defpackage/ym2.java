package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ym2 extends k70 {
    public final int[] X;

    public ym2(int i) {
        super((byte) 0, 7);
        this.X = new int[i * 2];
    }

    @Override // defpackage.k70
    public final void F0() {
        Arrays.fill(this.X, -1);
    }

    @Override // defpackage.k70
    public final int M0(int i) {
        return this.X[i * 2];
    }

    @Override // defpackage.k70
    public final int N0(int i) {
        return this.X[(i * 2) + 1];
    }

    @Override // defpackage.k70
    public final int O0() {
        return this.X.length / 2;
    }

    @Override // defpackage.k70
    public final int T0(int i, int i2) {
        this.X[i * 2] = i2;
        return i2;
    }

    @Override // defpackage.k70
    public final int U0(int i, int i2) {
        this.X[(i * 2) + 1] = i2;
        return i2;
    }

    public final Object clone() {
        ym2 ym2Var = new ym2(O0());
        int[] iArr = ym2Var.X;
        int[] iArr2 = this.X;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        tt ttVar = (tt) this.f;
        if (ttVar != null) {
            ym2Var.f = ttVar.b();
        }
        return ym2Var;
    }
}
