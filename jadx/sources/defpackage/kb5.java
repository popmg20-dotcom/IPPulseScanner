package defpackage;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kb5 {
    public static final Logger e = Logger.getLogger(kb5.class.getName());
    public static final boolean f = me5.e;
    public ub4 a;
    public final byte[] b;
    public final int c;
    public int d;

    public kb5(byte[] bArr, int i) {
        int length = bArr.length;
        if (((length - i) | i) < 0) {
            Locale locale = Locale.US;
            xe.k(fw.s(length, i, "Array range is invalid. Buffer.length=", ", offset=0, length="));
            throw null;
        }
        this.b = bArr;
        this.d = 0;
        this.c = i;
    }

    public static int a(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int b(String str) {
        int length;
        try {
            length = qe5.b(str);
        } catch (oe5 unused) {
            length = str.getBytes(nc5.a).length;
        }
        return r(length) + length;
    }

    public static int r(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public final void c(int i, int i2) throws a60 {
        l((i << 3) | i2);
    }

    public final void d(int i, int i2) throws a60 {
        l(i << 3);
        k(i2);
    }

    public final void e(int i, int i2) throws a60 {
        l(i << 3);
        l(i2);
    }

    public final void f(int i, int i2) throws a60 {
        l((i << 3) | 5);
        m(i2);
    }

    public final void g(int i, long j) throws a60 {
        l(i << 3);
        n(j);
    }

    public final void h(int i, long j) throws a60 {
        l((i << 3) | 1);
        o(j);
    }

    public final void i(hb5 hb5Var) throws a60 {
        l(hb5Var.c());
        p(hb5Var.c(), hb5Var.f);
    }

    public final void j(byte b) throws a60 {
        int i = this.d;
        try {
            int i2 = i + 1;
            try {
                this.b[i] = b;
                this.d = i2;
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                i = i2;
                throw new a60(i, this.c, 1, e);
            }
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
        }
    }

    public final void k(int i) throws a60 {
        if (i >= 0) {
            l(i);
        } else {
            n(i);
        }
    }

    public final void l(int i) throws a60 {
        int i2;
        int i3 = this.d;
        while (true) {
            int i4 = i & (-128);
            byte[] bArr = this.b;
            if (i4 == 0) {
                i2 = i3 + 1;
                bArr[i3] = (byte) i;
                this.d = i2;
                return;
            } else {
                i2 = i3 + 1;
                try {
                    bArr[i3] = (byte) (i | 128);
                    i >>>= 7;
                    i3 = i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new a60(i2, this.c, 1, e2);
                }
            }
            throw new a60(i2, this.c, 1, e2);
        }
    }

    public final void m(int i) throws a60 {
        int i2 = this.d;
        try {
            byte[] bArr = this.b;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.d = i2 + 4;
        } catch (IndexOutOfBoundsException e2) {
            throw new a60(i2, this.c, 4, e2);
        }
    }

    public final void n(long j) throws a60 {
        int i;
        int i2 = this.d;
        byte[] bArr = this.b;
        int i3 = this.c;
        if (!f || i3 - i2 < 10) {
            while ((j & (-128)) != 0) {
                int i4 = i2 + 1;
                try {
                    bArr[i2] = (byte) (((int) j) | 128);
                    j >>>= 7;
                    i2 = i4;
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                    i = i4;
                    throw new a60(i, i3, 1, e);
                }
            }
            i = i2 + 1;
            try {
                bArr[i2] = (byte) j;
            } catch (IndexOutOfBoundsException e3) {
                e = e3;
                throw new a60(i, i3, 1, e);
            }
        } else {
            while ((j & (-128)) != 0) {
                me5.c.k(bArr, me5.f + ((long) i2), (byte) (((int) j) | 128));
                j >>>= 7;
                i2++;
            }
            i = i2 + 1;
            me5.c.k(bArr, me5.f + ((long) i2), (byte) j);
        }
        this.d = i;
    }

    public final void o(long j) throws a60 {
        int i = this.d;
        try {
            byte[] bArr = this.b;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.d = i + 8;
        } catch (IndexOutOfBoundsException e2) {
            throw new a60(i, this.c, 8, e2);
        }
    }

    public final void p(int i, byte[] bArr) throws a60 {
        try {
            System.arraycopy(bArr, 0, this.b, this.d, i);
            this.d += i;
        } catch (IndexOutOfBoundsException e2) {
            throw new a60(this.d, this.c, i, e2);
        }
    }

    public final void q(String str) throws a60 {
        int i = this.d;
        try {
            int iR = r(str.length() * 3);
            int iR2 = r(str.length());
            int i2 = this.c;
            byte[] bArr = this.b;
            if (iR2 != iR) {
                l(qe5.b(str));
                int i3 = this.d;
                this.d = qe5.c(str, bArr, i3, i2 - i3);
            } else {
                int i4 = i + iR2;
                this.d = i4;
                int iC = qe5.c(str, bArr, i4, i2 - i4);
                this.d = i;
                l((iC - i) - iR2);
                this.d = iC;
            }
        } catch (IndexOutOfBoundsException e2) {
            throw new a60(e2);
        } catch (oe5 e3) {
            this.d = i;
            e.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e3);
            byte[] bytes = str.getBytes(nc5.a);
            try {
                int length = bytes.length;
                l(length);
                p(length, bytes);
            } catch (IndexOutOfBoundsException e4) {
                throw new a60(e4);
            }
        }
    }
}
