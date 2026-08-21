package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r60 {
    public static final Logger f = Logger.getLogger(r60.class.getName());
    public static final boolean g = xm4.e;
    public zf2 a;
    public final byte[] b;
    public final int c;
    public int d;
    public final zk4 e;

    public r60(zk4 zk4Var, int i) {
        if (i < 0) {
            xe.k("bufferSize must be >= 0");
            throw null;
        }
        int iMax = Math.max(i, 20);
        this.b = new byte[iMax];
        this.c = iMax;
        this.e = zk4Var;
    }

    public static int f(int i, au auVar) {
        int iH = h(i);
        int size = auVar.size();
        return i(size) + size + iH;
    }

    public static int g(String str) {
        int length;
        try {
            length = ao4.a(str);
        } catch (yn4 unused) {
            length = str.getBytes(j12.a).length;
        }
        return i(length) + length;
    }

    public static int h(int i) {
        return i(i << 3);
    }

    public static int i(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int j(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public final void A(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int i = i(length);
            int i2 = i + length;
            int i3 = this.c;
            if (i2 > i3) {
                byte[] bArr = new byte[length];
                int iN = ao4.a.n(str, bArr, 0, length);
                D(iN);
                n(bArr, 0, iN);
                return;
            }
            if (i2 > i3 - this.d) {
                k();
            }
            int i4 = i(str.length());
            int i5 = this.d;
            byte[] bArr2 = this.b;
            try {
                try {
                    if (i4 == i) {
                        int i6 = i5 + i4;
                        this.d = i6;
                        int iN2 = ao4.a.n(str, bArr2, i6, i3 - i6);
                        this.d = i5;
                        d((iN2 - i5) - i4);
                        this.d = iN2;
                    } else {
                        int iA = ao4.a(str);
                        d(iA);
                        this.d = ao4.a.n(str, bArr2, this.d, iA);
                    }
                } catch (yn4 e) {
                    this.d = i5;
                    throw e;
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new a60(e2);
            }
        } catch (yn4 e3) {
            f.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e3);
            byte[] bytes = str.getBytes(j12.a);
            try {
                D(bytes.length);
                x(0, bytes.length, bytes);
            } catch (IndexOutOfBoundsException e4) {
                throw new a60(e4);
            }
        }
    }

    public final void B(int i, int i2) {
        D((i << 3) | i2);
    }

    public final void C(int i, int i2) {
        l(20);
        c(i, 0);
        d(i2);
    }

    public final void D(int i) {
        l(5);
        d(i);
    }

    public final void E(int i, long j) {
        l(20);
        c(i, 0);
        e(j);
    }

    public final void F(long j) {
        l(10);
        e(j);
    }

    public final void a(int i) {
        int i2 = this.d;
        int i3 = i2 + 1;
        this.d = i3;
        byte b = (byte) (i & DnsRecord.CLASS_ANY);
        byte[] bArr = this.b;
        bArr[i2] = b;
        int i4 = i2 + 2;
        this.d = i4;
        bArr[i3] = (byte) ((i >> 8) & DnsRecord.CLASS_ANY);
        int i5 = i2 + 3;
        this.d = i5;
        bArr[i4] = (byte) ((i >> 16) & DnsRecord.CLASS_ANY);
        this.d = i2 + 4;
        bArr[i5] = (byte) ((i >> 24) & DnsRecord.CLASS_ANY);
    }

    public final void b(long j) {
        int i = this.d;
        int i2 = i + 1;
        this.d = i2;
        byte[] bArr = this.b;
        bArr[i] = (byte) (j & 255);
        int i3 = i + 2;
        this.d = i3;
        bArr[i2] = (byte) ((j >> 8) & 255);
        int i4 = i + 3;
        this.d = i4;
        bArr[i3] = (byte) ((j >> 16) & 255);
        int i5 = i + 4;
        this.d = i5;
        bArr[i4] = (byte) (255 & (j >> 24));
        int i6 = i + 5;
        this.d = i6;
        bArr[i5] = (byte) (((int) (j >> 32)) & DnsRecord.CLASS_ANY);
        int i7 = i + 6;
        this.d = i7;
        bArr[i6] = (byte) (((int) (j >> 40)) & DnsRecord.CLASS_ANY);
        int i8 = i + 7;
        this.d = i8;
        bArr[i7] = (byte) (((int) (j >> 48)) & DnsRecord.CLASS_ANY);
        this.d = i + 8;
        bArr[i8] = (byte) (((int) (j >> 56)) & DnsRecord.CLASS_ANY);
    }

    public final void c(int i, int i2) {
        d((i << 3) | i2);
    }

    public final void d(int i) {
        boolean z = g;
        byte[] bArr = this.b;
        if (z) {
            while (true) {
                int i2 = i & (-128);
                int i3 = this.d;
                if (i2 == 0) {
                    this.d = i3 + 1;
                    xm4.j(bArr, i3, (byte) i);
                    return;
                } else {
                    this.d = i3 + 1;
                    xm4.j(bArr, i3, (byte) ((i | 128) & DnsRecord.CLASS_ANY));
                    i >>>= 7;
                }
            }
        } else {
            while (true) {
                int i4 = i & (-128);
                int i5 = this.d;
                if (i4 == 0) {
                    this.d = i5 + 1;
                    bArr[i5] = (byte) i;
                    return;
                } else {
                    this.d = i5 + 1;
                    bArr[i5] = (byte) ((i | 128) & DnsRecord.CLASS_ANY);
                    i >>>= 7;
                }
            }
        }
    }

    public final void e(long j) {
        boolean z = g;
        byte[] bArr = this.b;
        if (z) {
            while (true) {
                long j2 = j & (-128);
                int i = this.d;
                if (j2 == 0) {
                    this.d = i + 1;
                    xm4.j(bArr, i, (byte) j);
                    return;
                } else {
                    this.d = i + 1;
                    xm4.j(bArr, i, (byte) ((((int) j) | 128) & DnsRecord.CLASS_ANY));
                    j >>>= 7;
                }
            }
        } else {
            while (true) {
                long j3 = j & (-128);
                int i2 = this.d;
                if (j3 == 0) {
                    this.d = i2 + 1;
                    bArr[i2] = (byte) j;
                    return;
                } else {
                    this.d = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) | 128) & DnsRecord.CLASS_ANY);
                    j >>>= 7;
                }
            }
        }
    }

    public final void k() {
        this.e.write(this.b, 0, this.d);
        this.d = 0;
    }

    public final void l(int i) {
        if (this.c - this.d < i) {
            k();
        }
    }

    public final void m(byte b) {
        if (this.d == this.c) {
            k();
        }
        int i = this.d;
        this.d = i + 1;
        this.b[i] = b;
    }

    public final void n(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.d;
        int i4 = this.c;
        int i5 = i4 - i3;
        byte[] bArr2 = this.b;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.d += i2;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i3, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.d = i4;
        k();
        if (i7 > i4) {
            this.e.write(bArr, i6, i7);
        } else {
            System.arraycopy(bArr, i6, bArr2, 0, i7);
            this.d = i7;
        }
    }

    public final void o(int i, boolean z) {
        l(11);
        c(i, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        int i2 = this.d;
        this.d = i2 + 1;
        this.b[i2] = b;
    }

    public final void p(int i, au auVar) throws IOException {
        B(i, 2);
        q(auVar);
    }

    public final void q(au auVar) throws IOException {
        D(auVar.size());
        x(auVar.e(), auVar.size(), auVar.f);
    }

    public final void r(int i, int i2) {
        l(14);
        c(i, 5);
        a(i2);
    }

    public final void s(int i) {
        l(4);
        a(i);
    }

    public final void t(int i, long j) {
        l(18);
        c(i, 1);
        b(j);
    }

    public final void u(long j) {
        l(8);
        b(j);
    }

    public final void v(int i, int i2) {
        l(20);
        c(i, 0);
        if (i2 >= 0) {
            d(i2);
        } else {
            e(i2);
        }
    }

    public final void w(int i) {
        if (i >= 0) {
            D(i);
        } else {
            F(i);
        }
    }

    public final void x(int i, int i2, byte[] bArr) throws IOException {
        n(bArr, i, i2);
    }

    public final void y(int i, d1 d1Var, gq3 gq3Var) {
        B(i, 2);
        D(d1Var.a(gq3Var));
        gq3Var.d(d1Var, this.a);
    }

    public final void z(int i, String str) throws IOException {
        B(i, 2);
        A(str);
    }
}
