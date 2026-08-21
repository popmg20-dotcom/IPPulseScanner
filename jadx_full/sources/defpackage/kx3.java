package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class kx3 extends k0 {
    public final byte[] y0;

    public kx3(String str, short[] sArr, byte[] bArr) {
        super(str, 1, 1, sArr);
        this.y0 = bArr;
    }

    @Override // defpackage.k0
    public final int f(int i, int i2, byte[] bArr) {
        if (i > 255) {
            return -401;
        }
        bArr[i2] = (byte) i;
        return 1;
    }

    @Override // defpackage.k0
    public final int g(int i) {
        return 1;
    }

    @Override // defpackage.k0
    public final int[] h(int i, b7 b7Var) {
        return null;
    }

    @Override // defpackage.k0
    public final boolean n(byte[] bArr) {
        return true;
    }

    @Override // defpackage.k0
    public int r(int i, int i2, byte[] bArr) {
        return 1;
    }

    @Override // defpackage.k0
    public final int u(int i, int i2, byte[] bArr) {
        return bArr[i] & 255;
    }

    @Override // defpackage.k0
    public final int z(int i, int i2, byte[] bArr) {
        return i2 - i;
    }

    @Override // defpackage.k0
    public final int q(int i, int i2, int i3, byte[] bArr) {
        return i2;
    }
}
