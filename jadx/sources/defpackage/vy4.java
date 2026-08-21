package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class vy4 extends InputStream {
    public final char[] A;
    public boolean A0;
    public boolean B0;
    public qd2 X;
    public final CRC32 Y;
    public byte[] Z;
    public final PushbackInputStream b;
    public qk0 f;
    public boolean y0;
    public final ed4 z;
    public final b71 z0;

    public vy4(InputStream inputStream, char[] cArr) {
        b71 b71Var = new b71(4096, true);
        this.z = new ed4((byte) 0, 27);
        this.Y = new CRC32();
        this.y0 = false;
        this.A0 = false;
        this.B0 = false;
        this.b = new PushbackInputStream(inputStream, 4096);
        this.A = cArr;
        this.z0 = b71Var;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        if (!this.A0) {
            return !this.B0 ? 1 : 0;
        }
        vp1.i("Stream closed");
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.A0) {
            return;
        }
        qk0 qk0Var = this.f;
        if (qk0Var != null) {
            qk0Var.close();
        }
        this.A0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vy4.g():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.qd2 n() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 737
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vy4.n():qd2");
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.A0) {
            vp1.i("Stream closed");
            return 0;
        }
        if (i2 < 0) {
            xe.k("Negative read length");
            return 0;
        }
        if (i2 == 0) {
            return 0;
        }
        if (this.X == null) {
            return -1;
        }
        try {
            int i3 = this.f.read(bArr, i, i2);
            if (i3 == -1) {
                g();
                return i3;
            }
            this.Y.update(bArr, i, i3);
            return i3;
        } catch (IOException e) {
            qd2 qd2Var = this.X;
            if (!qd2Var.n || !fw.e(2, qd2Var.o)) {
                throw e;
            }
            qy4 qy4Var = new qy4(e.getMessage(), e.getCause());
            qy4Var.b = 1;
            throw qy4Var;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }
}
