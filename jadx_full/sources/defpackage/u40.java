package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u40 extends InputStream {
    public final byte[] A = new byte[1];
    public final oy4 b;
    public final sk0 f;
    public final byte[] z;

    public u40(oy4 oy4Var, qd2 qd2Var, char[] cArr, int i, boolean z) {
        this.b = oy4Var;
        this.f = n(qd2Var, cArr, z);
        if (fw.e(yr2.C(qd2Var), 2)) {
            this.z = new byte[i];
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.b.close();
    }

    public abstract sk0 n(qd2 qd2Var, char[] cArr, boolean z);

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int iG0 = yr2.g0(this.b, bArr, i, i2);
        if (iG0 > 0) {
            byte[] bArr2 = this.z;
            if (bArr2 != null) {
                System.arraycopy(bArr, 0, bArr2, 0, iG0);
            }
            this.f.r(i, iG0, bArr);
        }
        return iG0;
    }

    public final void s(byte[] bArr) throws IOException {
        PushbackInputStream pushbackInputStream = this.b.b;
        int i = pushbackInputStream.read(bArr);
        if (i == -1) {
            vp1.i("Unexpected EOF reached when trying to read stream");
            return;
        }
        if (i != bArr.length) {
            int length = bArr.length - i;
            int i2 = 0;
            for (int i3 = 0; i < bArr.length && i2 != -1 && i3 < 15; i3++) {
                i2 += pushbackInputStream.read(bArr, i, length);
                if (i2 > 0) {
                    i += i2;
                    length -= i2;
                }
            }
            if (i == bArr.length) {
                return;
            }
            vp1.i("Cannot read fully into byte buffer");
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = this.A;
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public void g(InputStream inputStream, int i) {
    }
}
