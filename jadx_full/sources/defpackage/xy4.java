package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

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
    */
    public final void n(yy4 yy4Var) throws IOException {
        int i;
        long j;
        char c;
        long j2;
        boolean z;
        int i2;
        byte[] bArrO;
        boolean z2;
        n nVar;
        int i3;
        yy4 yy4Var2;
        int i4;
        v40 xr2Var;
        z90 s34Var;
        String str = yy4Var.i;
        if (str == null || str.trim().length() == 0) {
            xe.k("fileNameInZip is null or empty");
            return;
        }
        if (yy4Var.a == 1 && yy4Var.k < 0 && !v02.t(yy4Var.i) && yy4Var.l) {
            xe.k("uncompressed size should be set for zip entries of compression type store");
            return;
        }
        yy4 yy4Var3 = new yy4(yy4Var);
        if (v02.t(yy4Var.i)) {
            yy4Var3.l = false;
            yy4Var3.a = 1;
            yy4Var3.c = false;
            yy4Var3.k = 0L;
        }
        if (yy4Var.j <= 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis < 0) {
                yy4Var3.j = 0L;
            } else {
                yy4Var3.j = jCurrentTimeMillis;
            }
        }
        tf0 tf0Var = this.b;
        boolean zS = tf0Var.s();
        int iG = tf0Var.g();
        b71 b71Var = this.C0;
        b71Var.getClass();
        boolean z3 = b71Var.b;
        this.Z.getClass();
        rd1 rd1Var = new rd1();
        rd1Var.a = 3;
        int i5 = 51;
        byte[] bArr = {51, 3};
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            bArr[1] = 0;
        }
        this.A0.getClass();
        rd1Var.u = n02.J(0, bArr);
        char c2 = yy4Var3.a == 2 ? (char) 2 : (char) 1;
        if (yy4Var3.k > 4294967295L) {
            c2 = 3;
        }
        if (yy4Var3.c && fw.e(yy4Var3.d, 4)) {
            c2 = 4;
        }
        int i6 = 20;
        if (c2 == 1) {
            i = 10;
        } else if (c2 != 2) {
            if (c2 == 3) {
                i5 = 45;
            } else if (c2 != 4) {
                throw null;
            }
            i = i5;
        } else {
            i = 20;
        }
        rd1Var.d = i;
        boolean z4 = yy4Var3.c;
        if (z4 && yy4Var3.d == 4) {
            rd1Var.f = 3;
            n nVar2 = new n();
            j = 4294967295L;
            int i7 = yy4Var3.g;
            if (i7 != 0) {
                nVar2.e = i7;
            }
            int i8 = yy4Var3.f;
            if (i8 == 1) {
                nVar2.g = 1;
            } else if (i8 == 2) {
                nVar2.g = 2;
            } else {
                if (i8 != 3) {
                    st4.j("invalid AES key strength");
                    return;
                }
                nVar2.g = 3;
            }
            nVar2.h = yy4Var3.a;
            rd1Var.r = nVar2;
            rd1Var.l += 11;
        } else {
            j = 4294967295L;
            rd1Var.f = yy4Var3.a;
        }
        if (z4) {
            int i9 = yy4Var3.d;
            if (i9 == 0 || i9 == 1) {
                st4.j("Encryption method has to be set when encryptFiles flag is set in zip parameters");
                return;
            } else {
                rd1Var.n = true;
                rd1Var.o = i9;
            }
        }
        String str2 = yy4Var3.i;
        if (!yr2.N(str2)) {
            st4.j("fileNameInZip is null or empty");
            return;
        }
        rd1Var.m = str2;
        int i10 = iG;
        char[] cArr = null;
        rd1Var.k = p95.o(str2, null).length;
        if (!zS) {
            i10 = 0;
        }
        rd1Var.v = i10;
        rd1Var.g = yr2.y(yy4Var3.j);
        boolean zT = v02.t(str2);
        byte[] bArr2 = new byte[4];
        if (System.getProperty("os.name").toLowerCase().contains("nux") || System.getProperty("os.name").toLowerCase().contains("mac")) {
            if (zT) {
                System.arraycopy(v02.d, 0, bArr2, 0, 4);
            } else {
                System.arraycopy(v02.c, 0, bArr2, 0, 4);
            }
        } else if (System.getProperty("os.name").toLowerCase().contains("win") && zT) {
            bArr2[0] = r25.N(bArr2[0], 4);
        }
        rd1Var.w = bArr2;
        if (yy4Var3.l && yy4Var3.k == -1) {
            rd1Var.j = 0L;
        } else {
            rd1Var.j = yy4Var3.k;
        }
        if (yy4Var3.c && yy4Var3.d == 2) {
            rd1Var.h = yy4Var3.h;
        }
        byte[] bArr3 = new byte[2];
        byte bN = rd1Var.n ? r25.N((byte) 0, 0) : (byte) 0;
        boolean zE = fw.e(2, yy4Var3.a);
        int i11 = yy4Var3.b;
        if (!zE) {
            c = 1;
        } else if (fw.e(6, i11)) {
            c = 1;
            bN = r25.V(r25.V(bN, 1), 2);
        } else {
            c = 1;
            if (fw.e(8, i11)) {
                bN = r25.V(r25.N(bN, 1), 2);
            } else if (fw.e(4, i11)) {
                bN = r25.N(r25.V(bN, 1), 2);
            } else if (fw.e(2, i11) || fw.e(10, i11)) {
                bN = r25.N(r25.N(bN, 1), 2);
            }
        }
        if (yy4Var3.l) {
            bN = r25.N(bN, 3);
        }
        bArr3[0] = bN;
        bArr3[c] = r25.N(bArr3[c], 3);
        rd1Var.e = bArr3;
        rd1Var.p = yy4Var3.l;
        rd1Var.y = null;
        this.X = rd1Var;
        OutputStream outputStream = tf0Var.b;
        rd1Var.x = outputStream instanceof q04 ? ((q04) outputStream).b.getFilePointer() : tf0Var.f;
        rd1 rd1Var2 = this.X;
        qd2 qd2Var = new qd2();
        qd2Var.a = 1;
        qd2Var.d = rd1Var2.d;
        qd2Var.f = rd1Var2.f;
        qd2Var.g = rd1Var2.g;
        qd2Var.j = rd1Var2.j;
        qd2Var.k = rd1Var2.k;
        qd2Var.m = rd1Var2.m;
        qd2Var.n = rd1Var2.n;
        qd2Var.o = rd1Var2.o;
        qd2Var.r = rd1Var2.r;
        qd2Var.h = rd1Var2.h;
        qd2Var.i = rd1Var2.i;
        qd2Var.e = (byte[]) rd1Var2.e.clone();
        qd2Var.p = rd1Var2.p;
        qd2Var.l = rd1Var2.l;
        this.Y = qd2Var;
        wy4 wy4Var = this.z;
        ed4 ed4Var = this.y0;
        byte[] bArr4 = (byte[]) ed4Var.z;
        n02 n02Var = (n02) ed4Var.f;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            n02Var.S(byteArrayOutputStream, (int) ha0.g(qd2Var.a));
            n02Var.V(byteArrayOutputStream, qd2Var.d);
            byteArrayOutputStream.write(qd2Var.e);
            n02Var.V(byteArrayOutputStream, fw.h(qd2Var.f));
            n02.U(bArr4, qd2Var.g);
            byteArrayOutputStream.write(bArr4, 0, 4);
            n02.U(bArr4, qd2Var.h);
            byteArrayOutputStream.write(bArr4, 0, 4);
            long j3 = qd2Var.i;
            if (j3 < j) {
                j2 = j3;
                if (qd2Var.j < j) {
                    z = false;
                    if (z) {
                        n02.U(bArr4, j2);
                        i2 = 0;
                        byteArrayOutputStream.write(bArr4, 0, 4);
                        n02.U(bArr4, qd2Var.j);
                        byteArrayOutputStream.write(bArr4, 0, 4);
                        qd2Var.u = false;
                    } else {
                        n02.U(bArr4, j);
                        byteArrayOutputStream.write(bArr4, 0, 4);
                        byteArrayOutputStream.write(bArr4, 0, 4);
                        wy4Var.z0 = true;
                        qd2Var.u = true;
                        i2 = 0;
                    }
                    bArrO = new byte[i2];
                    if (yr2.N(qd2Var.m)) {
                        bArrO = p95.o(qd2Var.m, null);
                    }
                    n02Var.V(byteArrayOutputStream, bArrO.length);
                    if (z) {
                        i6 = 0;
                    }
                    if (qd2Var.r != null) {
                        i6 += 11;
                    }
                    n02Var.V(byteArrayOutputStream, i6);
                    if (bArrO.length > 0) {
                        byteArrayOutputStream.write(bArrO);
                    }
                    if (z) {
                        z2 = true;
                    } else {
                        z2 = true;
                        n02Var.V(byteArrayOutputStream, 1);
                        n02Var.V(byteArrayOutputStream, 16);
                        n02Var.T(byteArrayOutputStream, qd2Var.j);
                        n02Var.T(byteArrayOutputStream, qd2Var.i);
                    }
                    nVar = qd2Var.r;
                    if (nVar != null) {
                        n02Var.V(byteArrayOutputStream, (int) ha0.g(nVar.a));
                        n02Var.V(byteArrayOutputStream, nVar.d);
                        n02Var.V(byteArrayOutputStream, fw.o(nVar.e));
                        byteArrayOutputStream.write(p95.o(nVar.f, null));
                        byteArrayOutputStream.write(new byte[]{(byte) fw.l(nVar.g)});
                        n02Var.V(byteArrayOutputStream, fw.h(nVar.h));
                    }
                    tf0Var.write(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.close();
                    py4 py4Var = new py4();
                    py4Var.b = 0L;
                    py4Var.f = tf0Var;
                    py4Var.z = false;
                    if (yy4Var3.c) {
                        i3 = i11;
                        xr2Var = new xr2(py4Var, yy4Var3, cArr, z2, 0);
                        yy4Var2 = yy4Var3;
                    } else {
                        i3 = i11;
                        yy4Var2 = yy4Var3;
                        char[] cArr2 = this.f;
                        if (cArr2 == null || cArr2.length == 0) {
                            st4.j("password not set");
                            return;
                        }
                        int i12 = yy4Var2.d;
                        if (i12 != 4) {
                            i4 = 2;
                            if (i12 != 2) {
                                if (i12 == 3) {
                                    st4.j("ZIP_STANDARD_VARIANT_STRONG".concat(" encryption method is not supported"));
                                    return;
                                } else {
                                    st4.j("Invalid encryption method");
                                    return;
                                }
                            }
                            xr2Var = new xr2(py4Var, yy4Var2, cArr2, z3, 1);
                            if (yy4Var2.a == i4) {
                                int i13 = b71Var.a;
                                kn0 kn0Var = new kn0(xr2Var);
                                kn0Var.z = new Deflater(fw.G(i3), z2);
                                kn0Var.f = new byte[i13];
                                s34Var = kn0Var;
                            } else {
                                s34Var = new s34(xr2Var);
                            }
                            this.A = s34Var;
                            this.E0 = false;
                        }
                        k6 k6Var = new k6(py4Var, yy4Var2, cArr2, z3);
                        k6Var.z = new byte[16];
                        k6Var.A = 0;
                        xr2Var = k6Var;
                    }
                    i4 = 2;
                    if (yy4Var2.a == i4) {
                    }
                    this.A = s34Var;
                    this.E0 = false;
                }
            } else {
                j2 = j3;
            }
            z = true;
            if (z) {
            }
            bArrO = new byte[i2];
            if (yr2.N(qd2Var.m)) {
            }
            n02Var.V(byteArrayOutputStream, bArrO.length);
            if (z) {
            }
            if (qd2Var.r != null) {
            }
            n02Var.V(byteArrayOutputStream, i6);
            if (bArrO.length > 0) {
            }
            if (z) {
            }
            nVar = qd2Var.r;
            if (nVar != null) {
            }
            tf0Var.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
            py4 py4Var2 = new py4();
            py4Var2.b = 0L;
            py4Var2.f = tf0Var;
            py4Var2.z = false;
            if (yy4Var3.c) {
            }
            i4 = 2;
            if (yy4Var2.a == i4) {
            }
            this.A = s34Var;
            this.E0 = false;
        } finally {
        }
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
