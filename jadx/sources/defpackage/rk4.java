package defpackage;

import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class rk4 extends mf1 {
    public static final rk4 E0 = new rk4("UTF-32BE");

    @Override // defpackage.um2, defpackage.k0
    public final int f(int i, int i2, byte[] bArr) {
        bArr[i2] = (byte) (((-16777216) & i) >>> 24);
        bArr[i2 + 1] = (byte) ((16711680 & i) >>> 16);
        bArr[i2 + 2] = (byte) ((65280 & i) >>> 8);
        bArr[i2 + 3] = (byte) (i & DnsRecord.CLASS_ANY);
        return 4;
    }

    @Override // defpackage.k0
    public final boolean m(int i, int i2, byte[] bArr) {
        int i3 = i + 3;
        return i3 < i2 && bArr[i3] == 10 && bArr[i + 2] == 0 && bArr[i + 1] == 0 && bArr[i] == 0;
    }

    @Override // defpackage.tl4, defpackage.k0
    public final int t(int i, byte[] bArr, ue2 ue2Var, int i2, byte[] bArr2) {
        int i3 = ue2Var.b;
        int i4 = i3 + 3;
        if (!k0.i(bArr[i4] & 255) || bArr[i3 + 2] != 0 || bArr[i3 + 1] != 0 || bArr[i3] != 0) {
            return super.t(i, bArr, ue2Var, i2, bArr2);
        }
        bArr2[0] = 0;
        bArr2[1] = 0;
        bArr2[2] = 0;
        bArr2[3] = ek0.b[bArr[i4] & 255];
        ue2Var.b += 4;
        return 4;
    }

    @Override // defpackage.um2, defpackage.k0
    public final int u(int i, int i2, byte[] bArr) {
        return ((((((bArr[i] & 255) * 256) + (bArr[i + 1] & 255)) * 256) + (bArr[i + 2] & 255)) * 256) + (bArr[i + 3] & 255);
    }
}
