package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class kt2 extends RandomAccessFile {
    public final byte[] A;
    public int X;
    public final String Y;
    public final long b;
    public final File[] f;
    public RandomAccessFile z;

    public kt2(File file, File[] fileArr) throws IOException {
        super(file, "r");
        this.A = new byte[1];
        this.X = 0;
        super.close();
        int i = 1;
        for (File file2 : fileArr) {
            String name = file2.getName();
            String strSubstring = !name.contains(".") ? "" : name.substring(name.lastIndexOf(".") + 1);
            try {
                if (i != Integer.parseInt(strSubstring)) {
                    throw new IOException("Split file number " + i + " does not exist");
                }
                i++;
            } catch (NumberFormatException unused) {
                vp1.i(ha0.o("Split file extension not in expected format. Found: ", strSubstring, " expected of format: .001, .002, etc"));
                throw null;
            }
        }
        this.z = new RandomAccessFile(file, "r");
        this.f = fileArr;
        this.b = file.length();
        this.Y = "r";
    }

    @Override // java.io.RandomAccessFile, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        RandomAccessFile randomAccessFile = this.z;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        super.close();
    }

    public final void g(int i) throws IOException {
        if (this.X == i) {
            return;
        }
        File[] fileArr = this.f;
        if (i > fileArr.length - 1) {
            vp1.i("split counter greater than number of split files");
            return;
        }
        RandomAccessFile randomAccessFile = this.z;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        this.z = new RandomAccessFile(fileArr[i], this.Y);
        this.X = i;
    }

    @Override // java.io.RandomAccessFile
    public final long getFilePointer() {
        return this.z.getFilePointer();
    }

    @Override // java.io.RandomAccessFile
    public final long length() {
        return this.z.length();
    }

    @Override // java.io.RandomAccessFile
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.z.read(bArr, i, i2);
        if (i3 != -1) {
            return i3;
        }
        int i4 = this.X;
        if (i4 == this.f.length - 1) {
            return -1;
        }
        g(i4 + 1);
        return read(bArr, i, i2);
    }

    @Override // java.io.RandomAccessFile
    public final void seek(long j) throws IOException {
        long j2 = this.b;
        int i = (int) (j / j2);
        if (i != this.X) {
            g(i);
        }
        this.z.seek(j - (((long) i) * j2));
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
        throw null;
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public final void write(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public final void write(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.RandomAccessFile
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile
    public final int read() {
        byte[] bArr = this.A;
        if (read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }
}
