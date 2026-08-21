package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
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
    */
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        while (true) {
            try {
                int iInflate = this.z.inflate(bArr, i, i2);
                if (iInflate != 0) {
                    return iInflate;
                }
                if (this.z.finished() || this.z.needsDictionary()) {
                    break;
                }
                if (this.z.needsInput()) {
                    byte[] bArr2 = this.A;
                    int i3 = this.b.read(bArr2, 0, bArr2.length);
                    this.Y = i3;
                    if (i3 == -1) {
                        throw new EOFException("Unexpected end of input stream");
                    }
                    this.z.setInput(bArr2, 0, i3);
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
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
