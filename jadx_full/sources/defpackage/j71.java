package defpackage;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j71 extends InputStream {
    public final InputStream b;
    public int f = Pow2.MAX_POW2;

    public j71(InputStream inputStream) {
        this.b = inputStream;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.b.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i = this.b.read();
        if (i == -1) {
            this.f = 0;
        }
        return i;
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.b.skip(j);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int i = this.b.read(bArr);
        if (i == -1) {
            this.f = 0;
        }
        return i;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.b.read(bArr, i, i2);
        if (i3 == -1) {
            this.f = 0;
        }
        return i3;
    }
}
