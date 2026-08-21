package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class yz1 extends qk0 {
    public byte[] A;
    public byte[] X;
    public int Y;
    public Inflater z;

    @Override // defpackage.qk0, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Inflater inflater = this.z;
        if (inflater != null) {
            inflater.end();
        }
        super.close();
    }

    @Override // defpackage.qk0
    public final void g(InputStream inputStream, int i) {
        Inflater inflater = this.z;
        if (inflater != null) {
            inflater.end();
            this.z = null;
        }
        super.g(inputStream, i);
    }

    @Override // defpackage.qk0
    public final int n(PushbackInputStream pushbackInputStream) throws IOException {
        int remaining = this.z.getRemaining();
        if (remaining > 0) {
            pushbackInputStream.unread(this.b.z, this.Y - remaining, remaining);
        }
        return remaining;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        return -1;
     */
    @Override // defpackage.qk0, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
        L0:
            java.util.zip.Inflater r0 = r5.z     // Catch: java.util.zip.DataFormatException -> L40
            int r0 = r0.inflate(r6, r7, r8)     // Catch: java.util.zip.DataFormatException -> L40
            if (r0 != 0) goto L3f
            java.util.zip.Inflater r0 = r5.z     // Catch: java.util.zip.DataFormatException -> L40
            boolean r0 = r0.finished()     // Catch: java.util.zip.DataFormatException -> L40
            r1 = -1
            if (r0 != 0) goto L3e
            java.util.zip.Inflater r0 = r5.z     // Catch: java.util.zip.DataFormatException -> L40
            boolean r0 = r0.needsDictionary()     // Catch: java.util.zip.DataFormatException -> L40
            if (r0 == 0) goto L1a
            goto L3e
        L1a:
            java.util.zip.Inflater r0 = r5.z     // Catch: java.util.zip.DataFormatException -> L40
            boolean r0 = r0.needsInput()     // Catch: java.util.zip.DataFormatException -> L40
            if (r0 == 0) goto L0
            byte[] r0 = r5.A     // Catch: java.util.zip.DataFormatException -> L40
            int r2 = r0.length     // Catch: java.util.zip.DataFormatException -> L40
            u40 r3 = r5.b     // Catch: java.util.zip.DataFormatException -> L40
            r4 = 0
            int r2 = r3.read(r0, r4, r2)     // Catch: java.util.zip.DataFormatException -> L40
            r5.Y = r2     // Catch: java.util.zip.DataFormatException -> L40
            if (r2 == r1) goto L36
            java.util.zip.Inflater r1 = r5.z     // Catch: java.util.zip.DataFormatException -> L40
            r1.setInput(r0, r4, r2)     // Catch: java.util.zip.DataFormatException -> L40
            goto L0
        L36:
            java.io.EOFException r5 = new java.io.EOFException     // Catch: java.util.zip.DataFormatException -> L40
            java.lang.String r6 = "Unexpected end of input stream"
            r5.<init>(r6)     // Catch: java.util.zip.DataFormatException -> L40
            throw r5     // Catch: java.util.zip.DataFormatException -> L40
        L3e:
            return r1
        L3f:
            return r0
        L40:
            r5 = move-exception
            java.io.IOException r6 = new java.io.IOException
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yz1.read(byte[], int, int):int");
    }

    @Override // defpackage.qk0, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // defpackage.qk0, java.io.InputStream
    public final int read() {
        byte[] bArr = this.X;
        if (read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        return bArr[0];
    }
}
