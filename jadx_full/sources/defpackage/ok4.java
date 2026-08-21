package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ok4 extends kx3 {
    public static final ok4 z0 = new ok4("US-ASCII", ek0.a, ek0.b);

    @Override // defpackage.k0
    public final byte[] B() {
        return this.y0;
    }

    @Override // defpackage.k0
    public final boolean j(int i, int i2) {
        if (i < 128) {
            return k(i, i2);
        }
        return false;
    }

    @Override // defpackage.kx3, defpackage.k0
    public final int r(int i, int i2, byte[] bArr) {
        return (bArr[i] & 128) == 0 ? 1 : -1;
    }
}
