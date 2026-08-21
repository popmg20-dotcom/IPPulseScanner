package defpackage;

import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class qk4 extends tl4 {
    public static final qk4 D0 = new qk4("UTF-16LE", 2, 4, pk4.D0, null);

    @Override // defpackage.um2, defpackage.k0
    public final int f(int i, int i2, byte[] bArr) {
        if (i <= 65535) {
            bArr[i2] = (byte) (i & DnsRecord.CLASS_ANY);
            bArr[i2 + 1] = (byte) ((i & 65280) >>> 8);
            return 2;
        }
        int i3 = (i >>> 10) + 55232;
        int i4 = (i & 1023) + 56320;
        bArr[i2] = (byte) (i3 & DnsRecord.CLASS_ANY);
        bArr[i2 + 1] = (byte) ((i3 >>> 8) & DnsRecord.CLASS_ANY);
        bArr[i2 + 2] = (byte) (i4 & DnsRecord.CLASS_ANY);
        bArr[i2 + 3] = (byte) ((i4 >>> 8) & DnsRecord.CLASS_ANY);
        return 4;
    }

    @Override // defpackage.k0
    public final int g(int i) {
        return i > 65535 ? 4 : 2;
    }

    @Override // defpackage.k0
    public final int[] h(int i, b7 b7Var) {
        b7Var.b = 0;
        return tl4.N(i);
    }

    @Override // defpackage.k0
    public final boolean m(int i, int i2, byte[] bArr) {
        int i3 = i + 1;
        return i3 < i2 && bArr[i] == 10 && bArr[i3] == 0;
    }

    @Override // defpackage.k0
    public final boolean n(byte[] bArr) {
        return false;
    }

    @Override // defpackage.tl4, defpackage.k0
    public final int q(int i, int i2, int i3, byte[] bArr) {
        if (i2 <= i) {
            return i2;
        }
        if ((i2 - i) % 2 == 1) {
            i2--;
        }
        return ((bArr[i2 + 1] & 252) != 220 || i2 <= i + 1) ? i2 : i2 - 2;
    }

    @Override // defpackage.um2, defpackage.k0
    public final int r(int i, int i2, byte[] bArr) {
        int i3 = i2 - i;
        if (i3 < 2) {
            return -2;
        }
        byte b = bArr[i + 1];
        if ((b & 248) != 216) {
            return 2;
        }
        if ((b & 252) == 216) {
            if (i3 < 4) {
                return (-1) - (4 - i3);
            }
            if ((bArr[i + 3] & 252) == 220) {
                return 4;
            }
        }
        return -1;
    }

    @Override // defpackage.tl4, defpackage.k0
    public final int t(int i, byte[] bArr, ue2 ue2Var, int i2, byte[] bArr2) {
        int i3 = ue2Var.b;
        if (!k0.i(bArr[i3] & 255) || bArr[i3 + 1] != 0) {
            return super.t(i, bArr, ue2Var, i2, bArr2);
        }
        bArr2[0] = ek0.b[bArr[i3] & 255];
        bArr2[1] = 0;
        ue2Var.b += 2;
        return 2;
    }

    @Override // defpackage.um2, defpackage.k0
    public final int u(int i, int i2, byte[] bArr) {
        int i3;
        int i4;
        byte b = bArr[i + 1];
        if ((b & 252) == 216) {
            i3 = (((((b & 255) << 8) + (bArr[i] & 255)) & 1023) << 10) + ((((bArr[i + 3] & 255) << 8) + (bArr[i + 2] & 255)) & 1023);
            i4 = 65536;
        } else {
            i3 = (b & 255) * 256;
            i4 = bArr[i] & 255;
        }
        return i3 + i4;
    }
}
