package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qk0 extends InputStream {
    public final u40 b;
    public final byte[] f = new byte[1];

    public qk0(u40 u40Var) {
        this.b = u40Var;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    public void g(InputStream inputStream, int i) {
        this.b.g(inputStream, i);
    }

    public int n(PushbackInputStream pushbackInputStream) {
        return 0;
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = this.f;
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.b.read(bArr, i, i2);
    }
}
