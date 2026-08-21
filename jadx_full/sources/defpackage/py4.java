package defpackage;

import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class py4 extends OutputStream {
    public long b;
    public OutputStream f;
    public boolean z;

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        if (this.z) {
            xe.q("ZipEntryOutputStream is closed");
        } else {
            this.f.write(bArr, i, i2);
            this.b += (long) i2;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
