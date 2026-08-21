package defpackage;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q60 {
    public static final Logger d = Logger.getLogger(q60.class.getName());
    public static final boolean e = wm4.d;
    public final byte[] a;
    public final int b;
    public int c;

    public q60(byte[] bArr, int i) {
        if (((bArr.length - i) | i) < 0) {
            Locale locale = Locale.US;
            xe.k(fw.s(bArr.length, i, "Array range is invalid. Buffer.length=", ", offset=0, length="));
            throw null;
        }
        this.a = bArr;
        this.c = 0;
        this.b = i;
    }

    public static int b(int i) {
        return h(i) + 1;
    }

    public static int c(int i, zt ztVar) {
        int iH = h(i);
        int size = ztVar.size();
        return j(size) + size + iH;
    }

    public static int d(int i, int i2) {
        return l(i2) + h(i);
    }

    public static int e(int i, int i2) {
        return l(i2) + h(i);
    }

    public static int f(int i, nl2 nl2Var) {
        int iH = h(i);
        int iH2 = nl2Var.h();
        return j(iH2) + iH2 + iH;
    }

    public static int g(String str) {
        int length;
        try {
            length = zn4.a(str);
        } catch (xn4 unused) {
            length = str.getBytes(i12.a).length;
        }
        return j(length) + length;
    }

    public static int h(int i) {
        return j(i << 3);
    }

    public static int i(int i, int i2) {
        return j(i2) + h(i);
    }

    public static int j(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int k(int i, long j) {
        return l(j) + h(i);
    }

    public static int l(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public final void A(int i, long j) throws a60 {
        x(i, 0);
        B(j);
    }

    public final void B(long j) throws a60 {
        int i;
        int i2 = this.c;
        boolean z = e;
        int i3 = this.b;
        byte[] bArr = this.a;
        if (!z || i3 - i2 < 10) {
            while ((j & (-128)) != 0) {
                i = i2 + 1;
                try {
                    bArr[i2] = (byte) (((int) j) | 128);
                    j >>>= 7;
                    i2 = i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new a60(i, i3, 1, e2);
                }
            }
            i = i2 + 1;
            bArr[i2] = (byte) j;
        } else {
            while ((j & (-128)) != 0) {
                wm4.g(bArr, i2, (byte) (((int) j) | 128));
                j >>>= 7;
                i2++;
            }
            i = i2 + 1;
            wm4.g(bArr, i2, (byte) j);
        }
        this.c = i;
    }

    public final void a() {
        if (this.b - this.c == 0) {
            return;
        }
        xe.q("Did not write as much data as expected.");
    }

    public final void m(byte[] bArr, int i, int i2) throws a60 {
        try {
            System.arraycopy(bArr, i, this.a, this.c, i2);
            this.c += i2;
        } catch (IndexOutOfBoundsException e2) {
            throw new a60(this.c, this.b, i2, e2);
        }
    }

    public final void n(int i, boolean z) throws a60 {
        x(i, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        int i2 = this.c;
        try {
            int i3 = i2 + 1;
            try {
                this.a[i2] = b;
                this.c = i3;
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                i2 = i3;
                throw new a60(i2, this.b, 1, e);
            }
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
        }
    }

    public final void o(int i, zt ztVar) throws a60 {
        x(i, 2);
        p(ztVar);
    }

    public final void p(zt ztVar) throws a60 {
        z(ztVar.size());
        m(ztVar.f, ztVar.e(), ztVar.size());
    }

    public final void q(int i) throws a60 {
        int i2 = this.c;
        try {
            byte[] bArr = this.a;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.c = i2 + 4;
        } catch (IndexOutOfBoundsException e2) {
            throw new a60(i2, this.b, 4, e2);
        }
    }

    public final void r(long j) throws a60 {
        int i = this.c;
        try {
            byte[] bArr = this.a;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.c = i + 8;
        } catch (IndexOutOfBoundsException e2) {
            throw new a60(i, this.b, 8, e2);
        }
    }

    public final void s(int i, int i2) throws a60 {
        x(i, 0);
        t(i2);
    }

    public final void t(int i) throws a60 {
        if (i >= 0) {
            z(i);
        } else {
            B(i);
        }
    }

    public final void u(int i, nl2 nl2Var) throws a60 {
        x(i, 2);
        z(nl2Var.h());
        nl2Var.d(this);
    }

    public final void v(int i, zt ztVar) throws a60 {
        x(1, 3);
        y(2, i);
        o(3, ztVar);
        x(1, 4);
    }

    public final void w(String str) throws a60 {
        int i = this.c;
        try {
            int iJ = j(str.length() * 3);
            int iJ2 = j(str.length());
            int i2 = this.b;
            byte[] bArr = this.a;
            if (iJ2 != iJ) {
                z(zn4.a(str));
                int i3 = this.c;
                this.c = zn4.a.l(str, bArr, i3, i2 - i3);
                return;
            }
            int i4 = i + iJ2;
            this.c = i4;
            int iL = zn4.a.l(str, bArr, i4, i2 - i4);
            this.c = i;
            z((iL - i) - iJ2);
            this.c = iL;
        } catch (IndexOutOfBoundsException e2) {
            throw new a60(e2);
        } catch (xn4 e3) {
            this.c = i;
            d.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e3);
            byte[] bytes = str.getBytes(i12.a);
            try {
                z(bytes.length);
                m(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e4) {
                throw new a60(e4);
            }
        }
    }

    public final void x(int i, int i2) throws a60 {
        z((i << 3) | i2);
    }

    public final void y(int i, int i2) throws a60 {
        x(i, 0);
        z(i2);
    }

    public final void z(int i) throws a60 {
        int i2;
        int i3 = this.c;
        while (true) {
            int i4 = i & (-128);
            byte[] bArr = this.a;
            if (i4 == 0) {
                i2 = i3 + 1;
                bArr[i3] = (byte) i;
                this.c = i2;
                return;
            } else {
                i2 = i3 + 1;
                try {
                    bArr[i3] = (byte) (i | 128);
                    i >>>= 7;
                    i3 = i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new a60(i2, this.b, 1, e2);
                }
            }
            throw new a60(i2, this.b, 1, e2);
        }
    }
}
