package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class q04 extends OutputStream implements lx2 {
    public int A;
    public long X;
    public final n02 Y;
    public RandomAccessFile b;
    public final long f;
    public File z;

    public q04(File file, long j) throws qy4 {
        this.Y = new n02(14);
        if (j >= 0 && j < 65536) {
            st4.j("split length less than minimum allowed split length of 65536 Bytes");
            throw null;
        }
        this.b = new RandomAccessFile(file, "rw");
        this.f = j;
        this.z = file;
        this.A = 0;
        this.X = 0L;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.b.close();
    }

    @Override // defpackage.lx2
    public final int g() {
        return this.A;
    }

    @Override // defpackage.lx2
    public final long n() {
        return this.b.getFilePointer();
    }

    public final void s() {
        String str;
        String strO = v02.o(this.z.getName());
        String absolutePath = this.z.getAbsolutePath();
        if (this.z.getParent() == null) {
            str = "";
        } else {
            str = this.z.getParent() + System.getProperty("file.separator");
        }
        String str2 = ".z0" + (this.A + 1);
        if (this.A >= 9) {
            str2 = ".z" + (this.A + 1);
        }
        File file = new File(ha0.o(str, strO, str2));
        this.b.close();
        if (file.exists()) {
            throw new IOException("split file: " + file.getName() + " already exists in the current directory, cannot rename this file");
        }
        if (!this.z.renameTo(file)) {
            vp1.i("cannot rename newly created split file");
            return;
        }
        this.z = new File(absolutePath);
        this.b = new RandomAccessFile(this.z, "rw");
        this.A++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 <= 0) {
            return;
        }
        long j = this.f;
        if (j == -1) {
            this.b.write(bArr, i, i2);
            this.X += (long) i2;
            return;
        }
        long j2 = this.X;
        if (j2 >= j) {
            s();
            this.b.write(bArr, i, i2);
            this.X = i2;
            return;
        }
        long j3 = i2;
        if (j2 + j3 <= j) {
            this.b.write(bArr, i, i2);
            this.X += j3;
            return;
        }
        this.Y.getClass();
        int iG = n02.G(0, bArr);
        for (int i3 : fw.L(12)) {
            if (i3 != 8 && ha0.g(i3) == iG) {
                s();
                this.b.write(bArr, i, i2);
                this.X = j3;
                return;
            }
        }
        this.b.write(bArr, i, (int) (j - this.X));
        s();
        RandomAccessFile randomAccessFile = this.b;
        long j4 = j - this.X;
        randomAccessFile.write(bArr, i + ((int) j4), (int) (j3 - j4));
        this.X = j3 - (j - this.X);
    }

    public q04(File file) {
        this(file, -1L);
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
