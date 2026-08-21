package defpackage;

import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class gl extends r00 {
    public static final int[][] C0 = {new int[]{1, 33439, 33521}, new int[]{4, 166, 175, 177, 221, 33600, 33662, 33664, 33686}};
    public static final du D0;
    public static final boolean[] E0;
    public static final int[] F0;

    static {
        du duVar = new du(0);
        D0 = duVar;
        duVar.h("Hiragana".getBytes(), 15);
        duVar.h("Katakana".getBytes(), 16);
        E0 = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false};
        F0 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1};
    }

    public gl(String str, int[][] iArr) {
        super(str, F0, iArr, ek0.a, E0);
    }

    @Override // defpackage.r00, defpackage.um2, defpackage.k0
    public final int f(int i, int i2, byte[] bArr) {
        int i3;
        if ((65280 & i) != 0) {
            i3 = i2 + 1;
            bArr[i2] = (byte) ((i >> 8) & DnsRecord.CLASS_ANY);
        } else {
            i3 = i2;
        }
        bArr[i3] = (byte) (i & DnsRecord.CLASS_ANY);
        return (i3 + 1) - i2;
    }

    @Override // defpackage.k0
    public final int g(int i) {
        if (i < 256) {
            return F0[i] == 1 ? 1 : -400;
        }
        if (i <= 65535) {
            return !E0[i & DnsRecord.CLASS_ANY] ? -400 : 2;
        }
        return -400;
    }

    @Override // defpackage.k0
    public final int[] h(int i, b7 b7Var) {
        if (i <= 14) {
            return null;
        }
        b7Var.b = 128;
        int i2 = i - 15;
        if (i2 < 2) {
            return C0[i2];
        }
        throw new r41("undefined type (bug)");
    }

    @Override // defpackage.um2, defpackage.k0
    public final boolean j(int i, int i2) {
        if (i2 <= 14) {
            return i < 128 ? k(i, i2) : k0.p(i2);
        }
        int i3 = i2 - 15;
        if (i3 < 2) {
            return r25.I(0, i, C0[i3]);
        }
        throw new r41("undefined type (bug)");
    }

    @Override // defpackage.k0
    public final int t(int i, byte[] bArr, ue2 ue2Var, int i2, byte[] bArr2) {
        int i3 = ue2Var.b;
        if (bArr[i3] >= 0) {
            k0.d(bArr, ue2Var, bArr2);
            return 1;
        }
        int iH = H(i3, i2, bArr);
        if (um2.C(iH, 33376, 33401)) {
            iH += 33;
        } else if (um2.C(iH, 33695, 33718)) {
            iH += 32;
        } else if (um2.C(iH, 33856, 33888)) {
            iH += (iH < 33871 ? 0 : 1) + 48;
        }
        int iF = f(iH, 0, bArr2);
        ue2Var.b += iF;
        return iF;
    }

    @Override // defpackage.k0
    public final int w(byte[] bArr, int i, int i2) {
        Integer num = (Integer) D0.b(i, i2, bArr);
        return num == null ? super.w(bArr, i, i2) : num.intValue();
    }
}
