package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class xy4 extends OutputStream {
    public z90 A;
    public final n02 A0;
    public long B0;
    public final b71 C0;
    public boolean D0;
    public boolean E0;
    public rd1 X;
    public qd2 Y;
    public final d7 Z;
    public final tf0 b;
    public final char[] f;
    public final ed4 y0;
    public final wy4 z;
    public final CRC32 z0;

    public xy4(OutputStream outputStream, char[] cArr, b71 b71Var, wy4 wy4Var) {
        this.Z = new d7(19);
        this.y0 = new ed4((byte) 0, 28);
        this.z0 = new CRC32();
        n02 n02Var = new n02(14);
        this.A0 = n02Var;
        this.B0 = 0L;
        this.E0 = true;
        if (b71Var.a < 512) {
            xe.k("Buffer size cannot be less than 512 bytes");
            throw null;
        }
        tf0 tf0Var = new tf0();
        tf0Var.f = 0L;
        tf0Var.b = outputStream;
        this.b = tf0Var;
        this.f = cArr;
        this.C0 = b71Var;
        wy4Var = wy4Var == null ? new wy4() : wy4Var;
        if (tf0Var.s()) {
            wy4Var.Y = true;
            wy4Var.Z = tf0Var.s() ? ((q04) outputStream).f : 0L;
        }
        this.z = wy4Var;
        this.D0 = false;
        if (tf0Var.s()) {
            n02Var.S(tf0Var, 134695760);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (!this.E0) {
            g();
        }
        wy4 wy4Var = this.z;
        z41 z41Var = wy4Var.z;
        tf0 tf0Var = this.b;
        OutputStream outputStream = tf0Var.b;
        z41Var.h = outputStream instanceof q04 ? ((q04) outputStream).b.getFilePointer() : tf0Var.f;
        this.C0.getClass();
        this.y0.z(wy4Var, tf0Var);
        tf0Var.close();
        this.D0 = true;
    }

    public final rd1 g() throws IOException {
        this.A.g();
        long j = this.A.b.b.b;
        rd1 rd1Var = this.X;
        rd1Var.i = j;
        qd2 qd2Var = this.Y;
        qd2Var.i = j;
        long j2 = this.B0;
        rd1Var.j = j2;
        qd2Var.j = j2;
        boolean zE = (rd1Var.n && fw.e(rd1Var.o, 4)) ? fw.e(rd1Var.r.e, 1) : true;
        CRC32 crc32 = this.z0;
        if (zE) {
            this.X.h = crc32.getValue();
            this.Y.h = crc32.getValue();
        }
        wy4 wy4Var = this.z;
        wy4Var.b.add(this.Y);
        wy4Var.f.a.add(this.X);
        qd2 qd2Var2 = this.Y;
        if (qd2Var2.p) {
            ed4 ed4Var = this.y0;
            n02 n02Var = (n02) ed4Var.f;
            byte[] bArr = (byte[]) ed4Var.z;
            tf0 tf0Var = this.b;
            if (tf0Var == null) {
                st4.j("input parameters is null, cannot write extended local header");
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                n02Var.S(byteArrayOutputStream, 134695760);
                n02.U(bArr, qd2Var2.h);
                byteArrayOutputStream.write(bArr, 0, 4);
                boolean z = qd2Var2.u;
                long j3 = qd2Var2.i;
                if (z) {
                    n02Var.T(byteArrayOutputStream, j3);
                    n02Var.T(byteArrayOutputStream, qd2Var2.j);
                } else {
                    n02.U(bArr, j3);
                    byteArrayOutputStream.write(bArr, 0, 4);
                    n02.U(bArr, qd2Var2.j);
                    byteArrayOutputStream.write(bArr, 0, 4);
                }
                tf0Var.write(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        this.B0 = 0L;
        crc32.reset();
        this.A.close();
        this.E0 = true;
        return this.X;
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x0304 A[Catch: all -> 0x02fb, TryCatch #1 {all -> 0x02fb, blocks: (B:137:0x02bc, B:139:0x02f0, B:148:0x0304, B:150:0x032a, B:152:0x0334, B:153:0x033a, B:157:0x0343, B:159:0x0347, B:160:0x0349, B:162:0x0351, B:165:0x0358, B:167:0x036b, B:169:0x036f, B:170:0x03a9, B:149:0x0317), top: B:210:0x02bc }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0317 A[Catch: all -> 0x02fb, TryCatch #1 {all -> 0x02fb, blocks: (B:137:0x02bc, B:139:0x02f0, B:148:0x0304, B:150:0x032a, B:152:0x0334, B:153:0x033a, B:157:0x0343, B:159:0x0347, B:160:0x0349, B:162:0x0351, B:165:0x0358, B:167:0x036b, B:169:0x036f, B:170:0x03a9, B:149:0x0317), top: B:210:0x02bc }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0334 A[Catch: all -> 0x02fb, TryCatch #1 {all -> 0x02fb, blocks: (B:137:0x02bc, B:139:0x02f0, B:148:0x0304, B:150:0x032a, B:152:0x0334, B:153:0x033a, B:157:0x0343, B:159:0x0347, B:160:0x0349, B:162:0x0351, B:165:0x0358, B:167:0x036b, B:169:0x036f, B:170:0x03a9, B:149:0x0317), top: B:210:0x02bc }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0347 A[Catch: all -> 0x02fb, TryCatch #1 {all -> 0x02fb, blocks: (B:137:0x02bc, B:139:0x02f0, B:148:0x0304, B:150:0x032a, B:152:0x0334, B:153:0x033a, B:157:0x0343, B:159:0x0347, B:160:0x0349, B:162:0x0351, B:165:0x0358, B:167:0x036b, B:169:0x036f, B:170:0x03a9, B:149:0x0317), top: B:210:0x02bc }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0351 A[Catch: all -> 0x02fb, TryCatch #1 {all -> 0x02fb, blocks: (B:137:0x02bc, B:139:0x02f0, B:148:0x0304, B:150:0x032a, B:152:0x0334, B:153:0x033a, B:157:0x0343, B:159:0x0347, B:160:0x0349, B:162:0x0351, B:165:0x0358, B:167:0x036b, B:169:0x036f, B:170:0x03a9, B:149:0x0317), top: B:210:0x02bc }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0358 A[Catch: all -> 0x02fb, TryCatch #1 {all -> 0x02fb, blocks: (B:137:0x02bc, B:139:0x02f0, B:148:0x0304, B:150:0x032a, B:152:0x0334, B:153:0x033a, B:157:0x0343, B:159:0x0347, B:160:0x0349, B:162:0x0351, B:165:0x0358, B:167:0x036b, B:169:0x036f, B:170:0x03a9, B:149:0x0317), top: B:210:0x02bc }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x036f A[Catch: all -> 0x02fb, TryCatch #1 {all -> 0x02fb, blocks: (B:137:0x02bc, B:139:0x02f0, B:148:0x0304, B:150:0x032a, B:152:0x0334, B:153:0x033a, B:157:0x0343, B:159:0x0347, B:160:0x0349, B:162:0x0351, B:165:0x0358, B:167:0x036b, B:169:0x036f, B:170:0x03a9, B:149:0x0317), top: B:210:0x02bc }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0418  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(defpackage.yy4 r26) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1103
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xy4.n(yy4):void");
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.D0) {
            vp1.i("Stream is closed");
            return;
        }
        this.z0.update(bArr, i, i2);
        this.A.write(bArr, i, i2);
        this.B0 += (long) i2;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public xy4(OutputStream outputStream, char[] cArr) {
        this(outputStream, cArr, new b71(4096, true), new wy4());
    }
}
