package defpackage;

import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class pk extends tl4 {
    public static final int[][] D0 = {new int[]{1, 42145, 42227}, new int[]{3, 36518, 36527, 36529, 36573, 42401, 42486}, new int[]{4, 41400, 41400, 45217, 53203, 53409, 62630, 9416865, 9432563}, new int[]{4, 65, 90, 97, 122, 41921, 41946, 41953, 41978}, new int[]{2, 42657, 42680, 42689, 42712}, new int[]{2, 42913, 42945, 42961, 42993}};
    public static final du E0 = new du(1);
    public static final int[] F0;

    static {
        String[] strArr = {"Hiragana", "Katakana", "Han", "Latin", "Greek", "Cyrillic"};
        for (int i = 0; i < 6; i++) {
            E0.h(strArr[i].getBytes(), Integer.valueOf(i + 15));
        }
        F0 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1};
    }

    @Override // defpackage.tl4
    public final boolean O(int i) {
        return ((i + (-161)) & DnsRecord.CLASS_ANY) > 93;
    }

    @Override // defpackage.um2, defpackage.k0
    public final int f(int i, int i2, byte[] bArr) {
        int i3;
        if ((16711680 & i) != 0) {
            i3 = i2 + 1;
            bArr[i2] = (byte) ((i >> 16) & DnsRecord.CLASS_ANY);
        } else {
            i3 = i2;
        }
        if ((65280 & i) != 0) {
            bArr[i3] = (byte) ((i >> 8) & DnsRecord.CLASS_ANY);
            i3++;
        }
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i & DnsRecord.CLASS_ANY);
        int iR = r(i2, i4, bArr);
        int i5 = i4 - i2;
        if (iR != i5) {
            return -400;
        }
        return i5;
    }

    @Override // defpackage.k0
    public final int g(int i) {
        if (k0.i(i)) {
            return 1;
        }
        if (i > 16777215) {
            return -401;
        }
        if (((-8355712) & i) == 8421504) {
            return 3;
        }
        return (i & (-32640)) == 32896 ? 2 : -400;
    }

    @Override // defpackage.k0
    public final int[] h(int i, b7 b7Var) {
        if (i <= 14) {
            return null;
        }
        b7Var.b = 128;
        int i2 = i - 15;
        if (i2 < 6) {
            return D0[i2];
        }
        throw new r41("undefined type (bug)");
    }

    @Override // defpackage.tl4, defpackage.um2, defpackage.k0
    public final boolean j(int i, int i2) {
        if (i2 <= 14) {
            return i < 128 ? k(i, i2) : k0.p(i2) && g(i) > 1;
        }
        int i3 = i2 - 15;
        if (i3 < 6) {
            return r25.I(0, i, D0[i3]);
        }
        throw new r41("undefined type (bug)");
    }

    @Override // defpackage.k0
    public final boolean n(byte[] bArr) {
        int i = bArr[0] & 255;
        return i <= 126 || i == 142 || i == 143;
    }

    @Override // defpackage.tl4, defpackage.k0
    public final int t(int i, byte[] bArr, ue2 ue2Var, int i2, byte[] bArr2) {
        int i3 = ue2Var.b;
        byte b = bArr[i3];
        if ((b & 255) < 128) {
            bArr2[0] = ek0.b[b & 255];
            ue2Var.b = i3 + 1;
            return 1;
        }
        int iH = H(i3, i2, bArr);
        if (um2.C(iH, 41921, 41946) || um2.C(iH, 42657, 42680)) {
            iH += 32;
        } else if (um2.C(iH, 42913, 42945)) {
            iH += 48;
        }
        int iF = f(iH, 0, bArr2);
        int i4 = iF != -400 ? iF : 1;
        ue2Var.b += i4;
        return i4;
    }

    @Override // defpackage.tl4, defpackage.k0
    public final int w(byte[] bArr, int i, int i2) {
        Integer num = (Integer) E0.b(i, i2, bArr);
        return num == null ? super.w(bArr, i, i2) : num.intValue();
    }
}
