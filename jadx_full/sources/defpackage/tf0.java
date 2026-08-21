package defpackage;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class tf0 extends OutputStream implements lx2 {
    public OutputStream b;
    public long f;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.b.close();
    }

    @Override // defpackage.lx2
    public final int g() {
        if (s()) {
            return ((q04) this.b).A;
        }
        return 0;
    }

    @Override // defpackage.lx2
    public final long n() {
        OutputStream outputStream = this.b;
        return outputStream instanceof q04 ? ((q04) outputStream).b.getFilePointer() : this.f;
    }

    public final boolean s() {
        OutputStream outputStream = this.b;
        return (outputStream instanceof q04) && ((q04) outputStream).f != -1;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.b.write(bArr, i, i2);
        this.f += (long) i2;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }
}
