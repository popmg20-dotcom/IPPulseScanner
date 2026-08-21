package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class mf1 extends tl4 {
    public final int D0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mf1(String str) {
        super(str, 4, 4, null, null);
        int i = 4;
        int i2 = 0;
        while (true) {
            i >>>= 1;
            if (i == 0) {
                this.D0 = i2;
                return;
            }
            i2++;
        }
    }

    @Override // defpackage.k0
    public final int g(int i) {
        return this.b;
    }

    @Override // defpackage.k0
    public final int[] h(int i, b7 b7Var) {
        b7Var.b = 0;
        return tl4.N(i);
    }

    @Override // defpackage.k0
    public final boolean n(byte[] bArr) {
        return false;
    }

    @Override // defpackage.tl4, defpackage.k0
    public final int q(int i, int i2, int i3, byte[] bArr) {
        return i2 <= i ? i2 : i2 - ((i2 - i) % this.f);
    }

    @Override // defpackage.um2, defpackage.k0
    public final int r(int i, int i2, byte[] bArr) {
        if (i2 < i) {
            return -1;
        }
        if (i2 - i < 4) {
            return (-1) - ((4 - i2) - i);
        }
        int iU = u(i, i2, bArr);
        return (Integer.compare(Integer.MIN_VALUE ^ iU, -2146369537) > 0 || (iU < 65536 && ((iU >> 8) & 248) == 216)) ? -1 : 4;
    }

    @Override // defpackage.um2, defpackage.k0
    public final int z(int i, int i2, byte[] bArr) {
        return (i2 - i) >>> this.D0;
    }
}
