package io.sentry.android.core;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends InputStream {
    public final BufferedInputStream b;
    public long f;

    public b1(BufferedInputStream bufferedInputStream, int i) {
        this.b = bufferedInputStream;
        this.f = i;
    }

    @Override // java.io.InputStream
    public final int available() {
        return Math.min(this.b.available(), (int) this.f);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        d1.d(this.b, this.f);
        this.f = 0L;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f;
        if (j <= 0) {
            return -1;
        }
        int i3 = this.b.read(bArr, i, Math.min(i2, (int) j));
        if (i3 > 0) {
            this.f -= (long) i3;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        long jSkip = this.b.skip(Math.min(j, this.f));
        this.f -= jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f <= 0) {
            return -1;
        }
        int i = this.b.read();
        if (i != -1) {
            this.f--;
        }
        return i;
    }
}
