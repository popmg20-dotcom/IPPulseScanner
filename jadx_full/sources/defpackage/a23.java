package defpackage;

import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a23 extends ByteArrayOutputStream {
    public final qt b;

    public a23(qt qtVar, int i) {
        this.b = qtVar;
        ((ByteArrayOutputStream) this).buf = qtVar.i(Math.max(i, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.s(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public final void finalize() {
        this.b.s(((ByteArrayOutputStream) this).buf);
    }

    public final void g(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        int i3 = (i2 + i) * 2;
        qt qtVar = this.b;
        byte[] bArrI = qtVar.i(i3);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrI, 0, ((ByteArrayOutputStream) this).count);
        qtVar.s(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrI;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        g(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        g(i2);
        super.write(bArr, i, i2);
    }
}
