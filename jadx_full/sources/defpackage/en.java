package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class en {
    public final byte[] a;
    public int b;
    public int c;

    public en(byte[] bArr, int i) {
        switch (i) {
            case 1:
                int length = bArr.length;
                this.a = bArr;
                this.b = 0;
                this.c = length;
                break;
            default:
                this.a = bArr;
                break;
        }
    }

    public static void b(int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        StringBuilder sbD = dw2.D("Field ", i, ": expected ");
        sbD.append(i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 5 ? "unknown" : "fixed32" : "length-delimited" : "fixed64" : "varint");
        sbD.append(" (wire type ");
        sbD.append(i2);
        sbD.append(") but got ");
        sbD.append(i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 5 ? "unknown" : "fixed32" : "length-delimited" : "fixed64" : "varint");
        sbD.append(" (wire type ");
        sbD.append(i3);
        sbD.append(")");
        throw new IOException(sbD.toString());
    }

    public int a() {
        return ((this.a.length - this.b) * 8) - this.c;
    }

    public int c(int i) {
        int i2 = 0;
        if (i < 1 || i > 32 || i > a()) {
            xe.k(String.valueOf(i));
            return 0;
        }
        int i3 = this.c;
        byte[] bArr = this.a;
        if (i3 > 0) {
            int i4 = 8 - i3;
            int iMin = Math.min(i, i4);
            int i5 = i4 - iMin;
            int i6 = (DnsRecord.CLASS_ANY >> (8 - iMin)) << i5;
            int i7 = this.b;
            int i8 = (i6 & bArr[i7]) >> i5;
            i -= iMin;
            int i9 = this.c + iMin;
            this.c = i9;
            if (i9 == 8) {
                this.c = 0;
                this.b = i7 + 1;
            }
            i2 = i8;
        }
        if (i <= 0) {
            return i2;
        }
        while (i >= 8) {
            int i10 = this.b;
            i2 = (i2 << 8) | (bArr[i10] & 255);
            this.b = i10 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return i2;
        }
        int i11 = 8 - i;
        int i12 = (i2 << i) | ((((DnsRecord.CLASS_ANY >> i11) << i11) & bArr[this.b]) >> i11);
        this.c += i;
        return i12;
    }

    public boolean d() {
        return i() != 0;
    }

    public byte[] e() {
        int i = (int) i();
        if (i < 0) {
            vp1.i(dw2.A(i, "Negative length: "));
            return null;
        }
        int i2 = this.c;
        int i3 = this.b;
        if (i2 - i3 < i) {
            throw new EOFException("Not enough bytes for length-delimited field");
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.a, i3, bArr, 0, i);
        this.b += i;
        return bArr;
    }

    public en f() {
        return new en(e(), 1);
    }

    public String g() {
        return new String(e(), StandardCharsets.UTF_8);
    }

    public int h() {
        if (this.b < this.c) {
            return (int) i();
        }
        return 0;
    }

    public long i() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            int i2 = this.b;
            if (i2 >= this.c) {
                throw new EOFException("Truncated varint");
            }
            this.b = i2 + 1;
            byte b = this.a[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        vp1.i("Malformed varint");
        return 0L;
    }

    public void j(int i) {
        int i2 = this.c;
        if (i == 0) {
            i();
            return;
        }
        if (i == 1) {
            int i3 = this.b;
            if (i2 - i3 < 8) {
                throw new EOFException("Not enough bytes to skip fixed64");
            }
            this.b = i3 + 8;
            return;
        }
        if (i == 2) {
            int i4 = (int) i();
            int i5 = this.b;
            if (i2 - i5 < i4) {
                throw new EOFException("Not enough bytes to skip length-delimited");
            }
            this.b = i5 + i4;
            return;
        }
        if (i != 5) {
            vp1.i(dw2.A(i, "Unknown wire type: "));
            return;
        }
        int i6 = this.b;
        if (i2 - i6 < 4) {
            throw new EOFException("Not enough bytes to skip fixed32");
        }
        this.b = i6 + 4;
    }
}
