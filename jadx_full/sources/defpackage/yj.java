package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yj implements Serializable {
    public final String A;
    public final char X;
    public final int Y;
    public final boolean Z;
    public final transient int[] b;
    public final transient char[] f;
    public final int y0;
    public final transient byte[] z;

    public yj(String str, String str2, boolean z, char c, int i) {
        int[] iArr = new int[128];
        this.b = iArr;
        char[] cArr = new char[64];
        this.f = cArr;
        this.z = new byte[64];
        this.A = str;
        this.Z = z;
        this.X = c;
        this.Y = i;
        int length = str2.length();
        if (length != 64) {
            xe.k(ha0.k("Base64Alphabet length must be exactly 64 (was ", length, ")"));
            throw null;
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = this.f[i2];
            this.z[i2] = (byte) c2;
            this.b[c2] = i2;
        }
        if (z) {
            this.b[c] = -2;
        }
        this.y0 = z ? 2 : 1;
    }

    public final int a(char[] cArr, int i, int i2) {
        char[] cArr2 = this.f;
        cArr[i2] = cArr2[(i >> 18) & 63];
        cArr[i2 + 1] = cArr2[(i >> 12) & 63];
        int i3 = i2 + 3;
        cArr[i2 + 2] = cArr2[(i >> 6) & 63];
        int i4 = i2 + 4;
        cArr[i3] = cArr2[i & 63];
        return i4;
    }

    public final int b(int i, int i2, char[] cArr, int i3) {
        char[] cArr2 = this.f;
        cArr[i3] = cArr2[(i >> 18) & 63];
        int i4 = i3 + 2;
        cArr[i3 + 1] = cArr2[(i >> 12) & 63];
        if (!this.Z) {
            if (i2 != 2) {
                return i4;
            }
            int i5 = i3 + 3;
            cArr[i4] = cArr2[(i >> 6) & 63];
            return i5;
        }
        int i6 = i3 + 3;
        char c = this.X;
        cArr[i4] = i2 == 2 ? cArr2[(i >> 6) & 63] : c;
        int i7 = i3 + 4;
        cArr[i6] = c;
        return i7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != yj.class) {
            return false;
        }
        yj yjVar = (yj) obj;
        return yjVar.X == this.X && yjVar.Y == this.Y && yjVar.Z == this.Z && yjVar.y0 == this.y0 && this.A.equals(yjVar.A);
    }

    public final int hashCode() {
        return this.A.hashCode();
    }

    public final String toString() {
        return this.A;
    }

    public yj(yj yjVar) {
        int i = yjVar.y0;
        int[] iArr = new int[128];
        this.b = iArr;
        char[] cArr = new char[64];
        this.f = cArr;
        byte[] bArr = new byte[64];
        this.z = bArr;
        this.A = "MIME-NO-LINEFEEDS";
        byte[] bArr2 = yjVar.z;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = yjVar.f;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = yjVar.b;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.Z = true;
        this.X = '=';
        this.Y = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.y0 = i;
    }
}
