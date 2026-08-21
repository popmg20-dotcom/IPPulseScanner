package io.sentry.cache.tape;

import defpackage.dw2;
import defpackage.fw;
import defpackage.ha0;
import defpackage.vp1;
import defpackage.xe;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Closeable, Iterable {
    public static final byte[] B0 = new byte[4096];
    public int A;
    public boolean A0;
    public g X;
    public g Y;
    public RandomAccessFile b;
    public final File f;
    public long z;
    public final int z0;
    public final byte[] Z = new byte[32];
    public int y0 = 0;

    public i(File file, RandomAccessFile randomAccessFile, int i) throws IOException {
        this.f = file;
        this.b = randomAccessFile;
        this.z0 = i;
        x();
    }

    public static int C(int i, byte[] bArr) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    public static long F(int i, byte[] bArr) {
        return ((((long) bArr[i]) & 255) << 56) + ((((long) bArr[i + 1]) & 255) << 48) + ((((long) bArr[i + 2]) & 255) << 40) + ((((long) bArr[i + 3]) & 255) << 32) + ((((long) bArr[i + 4]) & 255) << 24) + ((((long) bArr[i + 5]) & 255) << 16) + ((((long) bArr[i + 6]) & 255) << 8) + (((long) bArr[i + 7]) & 255);
    }

    public static RandomAccessFile g(File file) throws IOException {
        if (!file.exists()) {
            File file2 = new File(file.getPath() + DiskFileUpload.postfix);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                randomAccessFile.setLength(4096L);
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(-2147483647);
                randomAccessFile.writeLong(4096L);
                randomAccessFile.close();
                if (!file2.renameTo(file)) {
                    vp1.i("Rename failed!");
                    return null;
                }
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        }
        return new RandomAccessFile(file, "rwd");
    }

    public static void i0(int i, int i2, byte[] bArr) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    public static void j0(long j, int i, byte[] bArr) {
        bArr[i] = (byte) (j >> 56);
        bArr[i + 1] = (byte) (j >> 48);
        bArr[i + 2] = (byte) (j >> 40);
        bArr[i + 3] = (byte) (j >> 32);
        bArr[i + 4] = (byte) (j >> 24);
        bArr[i + 5] = (byte) (j >> 16);
        bArr[i + 6] = (byte) (j >> 8);
        bArr[i + 7] = (byte) j;
    }

    public final void I(int i) throws IOException {
        if (i < 0) {
            xe.k(ha0.k("Cannot remove negative (", i, ") number of elements."));
            return;
        }
        if (i == 0) {
            return;
        }
        int i2 = this.A;
        if (i == i2) {
            clear();
            return;
        }
        if (i2 == 0) {
            vp1.g();
            return;
        }
        if (i > i2) {
            xe.k(fw.w(").", dw2.D("Cannot remove more elements (", i, ") than present in queue ("), this.A));
            return;
        }
        g gVar = this.X;
        long j = gVar.a;
        int iC = gVar.b;
        long jZ = j;
        long j2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            j2 += (long) (iC + 4);
            jZ = Z(jZ + 4 + ((long) iC));
            byte[] bArr = this.Z;
            if (!U(jZ, 4, bArr)) {
                return;
            }
            iC = C(0, bArr);
        }
        c0(this.z, this.A - i, jZ, this.Y.a);
        this.A -= i;
        this.y0++;
        this.X = new g(jZ, iC);
        while (j2 > 0) {
            int iMin = (int) Math.min(j2, 4096L);
            X(j, iMin, B0);
            long j3 = iMin;
            j2 -= j3;
            j += j3;
        }
    }

    public final void M() throws IOException {
        this.b.close();
        File file = this.f;
        file.delete();
        this.b = g(file);
        x();
    }

    public final boolean U(long j, int i, byte[] bArr) throws IOException {
        try {
            long jZ = Z(j);
            long j2 = ((long) i) + jZ;
            long j3 = this.z;
            RandomAccessFile randomAccessFile = this.b;
            if (j2 <= j3) {
                randomAccessFile.seek(jZ);
                this.b.readFully(bArr, 0, i);
                return true;
            }
            int i2 = (int) (j3 - jZ);
            randomAccessFile.seek(jZ);
            this.b.readFully(bArr, 0, i2);
            this.b.seek(32L);
            this.b.readFully(bArr, i2, i - i2);
            return true;
        } catch (EOFException unused) {
            M();
            return false;
        } catch (IOException e) {
            throw e;
        } catch (Throwable unused2) {
            M();
            return false;
        }
    }

    public final void X(long j, int i, byte[] bArr) throws IOException {
        long jZ = Z(j);
        long j2 = ((long) i) + jZ;
        long j3 = this.z;
        RandomAccessFile randomAccessFile = this.b;
        if (j2 <= j3) {
            randomAccessFile.seek(jZ);
            this.b.write(bArr, 0, i);
            return;
        }
        int i2 = (int) (j3 - jZ);
        randomAccessFile.seek(jZ);
        this.b.write(bArr, 0, i2);
        this.b.seek(32L);
        this.b.write(bArr, i2, i - i2);
    }

    public final long Z(long j) {
        long j2 = this.z;
        return j < j2 ? j : (j + 32) - j2;
    }

    public final void c0(long j, int i, long j2, long j3) throws IOException {
        this.b.seek(0L);
        byte[] bArr = this.Z;
        i0(0, -2147483647, bArr);
        j0(j, 4, bArr);
        i0(12, i, bArr);
        j0(j2, 16, bArr);
        j0(j3, 24, bArr);
        this.b.write(bArr, 0, 32);
    }

    public final void clear() throws IOException {
        if (this.A0) {
            xe.q("closed");
            return;
        }
        c0(4096L, 0, 0L, 0L);
        this.b.seek(32L);
        this.b.write(B0, 0, 4064);
        this.A = 0;
        g gVar = g.c;
        this.X = gVar;
        this.Y = gVar;
        if (this.z > 4096) {
            this.b.setLength(4096L);
            this.b.getChannel().force(true);
        }
        this.z = 4096L;
        this.y0++;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A0 = true;
        this.b.close();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new h(this);
    }

    public final g s(long j) {
        if (j != 0) {
            byte[] bArr = this.Z;
            if (U(j, 4, bArr)) {
                return new g(j, C(0, bArr));
            }
        }
        return g.c;
    }

    public final String toString() {
        return "QueueFile{file=" + this.f + ", zero=true, length=" + this.z + ", size=" + this.A + ", first=" + this.X + ", last=" + this.Y + '}';
    }

    public final void x() throws IOException {
        this.b.seek(0L);
        RandomAccessFile randomAccessFile = this.b;
        byte[] bArr = this.Z;
        randomAccessFile.readFully(bArr);
        this.z = F(4, bArr);
        this.A = C(12, bArr);
        long jF = F(16, bArr);
        long jF2 = F(24, bArr);
        long j = this.z;
        long length = this.b.length();
        long j2 = this.z;
        if (j > length) {
            StringBuilder sbC = fw.C("File is truncated. Expected length: ", ", Actual length: ", j2);
            sbC.append(this.b.length());
            throw new IOException(sbC.toString());
        }
        if (j2 <= 32) {
            vp1.i(dw2.C(new StringBuilder("File is corrupt; length stored in header ("), ") is invalid.", this.z));
        } else {
            this.X = s(jF);
            this.Y = s(jF2);
        }
    }
}
