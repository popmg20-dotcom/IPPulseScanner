package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

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
    */
    public final void g() throws IOException {
        boolean z;
        long jI;
        long jH;
        long jH2;
        qk0 qk0Var = this.f;
        PushbackInputStream pushbackInputStream = this.b;
        this.f.g(pushbackInputStream, qk0Var.n(pushbackInputStream));
        qd2 qd2Var = this.X;
        if (qd2Var.p && !this.y0) {
            List list = qd2Var.t;
            if (list == null) {
                z = false;
                ed4 ed4Var = this.z;
                ed4Var.getClass();
                byte[] bArr = new byte[4];
                yr2.f0(pushbackInputStream, bArr);
                n02 n02Var = (n02) ed4Var.z;
                byte[] bArr2 = (byte[]) n02Var.A;
                jI = n02Var.I(0, bArr);
                if (jI == 134695760) {
                    yr2.f0(pushbackInputStream, bArr);
                    jI = n02Var.I(0, bArr);
                }
                if (z) {
                    jH = n02Var.H(pushbackInputStream);
                    jH2 = n02Var.H(pushbackInputStream);
                } else {
                    n02.F(pushbackInputStream, bArr2, bArr2.length);
                    jH = n02Var.I(0, bArr2);
                    n02.F(pushbackInputStream, bArr2, bArr2.length);
                    jH2 = n02Var.I(0, bArr2);
                }
                qd2 qd2Var2 = this.X;
                qd2Var2.i = jH;
                qd2Var2.j = jH2;
                qd2Var2.h = jI;
                qd2Var = qd2Var2;
            } else {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((pa1) it.next()).d == 1) {
                        z = true;
                        break;
                    }
                }
                z = false;
                ed4 ed4Var2 = this.z;
                ed4Var2.getClass();
                byte[] bArr3 = new byte[4];
                yr2.f0(pushbackInputStream, bArr3);
                n02 n02Var2 = (n02) ed4Var2.z;
                byte[] bArr22 = (byte[]) n02Var2.A;
                jI = n02Var2.I(0, bArr3);
                if (jI == 134695760) {
                }
                if (z) {
                }
                qd2 qd2Var22 = this.X;
                qd2Var22.i = jH;
                qd2Var22.j = jH2;
                qd2Var22.h = jI;
                qd2Var = qd2Var22;
            }
        }
        int i = qd2Var.o;
        CRC32 crc32 = this.Y;
        if ((i == 4 && fw.e(qd2Var.r.e, 2)) || this.X.h == crc32.getValue()) {
            this.X = null;
            crc32.reset();
            this.B0 = true;
        } else {
            qd2 qd2Var3 = this.X;
            throw new qy4("Reached end of entry, but crc verification failed for " + this.X.m, (qd2Var3.n && fw.e(2, qd2Var3.o)) ? 1 : 3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final qd2 n() throws IOException {
        int i;
        char c;
        PushbackInputStream pushbackInputStream;
        String str;
        String str2;
        qd2 qd2Var;
        int i2;
        int i3;
        int i4;
        List listL;
        int iM;
        int i5;
        long j;
        wr2 wr2Var;
        u40 u40Var;
        qk0 r34Var;
        byte[] bArr;
        if (this.X != null) {
            if (this.Z == null) {
                this.Z = new byte[512];
            }
            do {
                bArr = this.Z;
            } while (read(bArr, 0, bArr.length) != -1);
            this.B0 = true;
        }
        b71 b71Var = this.z0;
        b71Var.getClass();
        ed4 ed4Var = this.z;
        ed4Var.getClass();
        n02 n02Var = (n02) ed4Var.z;
        qd2 qd2Var2 = new qd2();
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = (byte[]) n02Var.A;
        byte[] bArr4 = (byte[]) n02Var.f;
        PushbackInputStream pushbackInputStream2 = this.b;
        int iH = n02Var.H(pushbackInputStream2);
        if (iH == 808471376) {
            iH = n02Var.H(pushbackInputStream2);
        }
        long j2 = -1;
        if (iH != 67324752) {
            i = 1;
            c = 0;
            pushbackInputStream = pushbackInputStream2;
            str2 = "/";
            str = "\\";
            qd2Var2 = null;
            qd2Var = null;
            i2 = 6;
            i4 = 2;
        } else {
            qd2Var2.a = 1;
            n02.F(pushbackInputStream2, bArr4, bArr4.length);
            qd2Var2.d = n02.J(0, bArr4);
            byte[] bArr5 = new byte[2];
            i = 1;
            if (yr2.f0(pushbackInputStream2, bArr5) != 2) {
                st4.j("Could not read enough bytes for generalPurposeFlags");
                return null;
            }
            qd2Var2.n = r25.F(bArr5[0], 0);
            qd2Var2.p = r25.F(bArr5[0], 3);
            qd2Var2.s = r25.F(bArr5[1], 3);
            qd2Var2.e = (byte[]) bArr5.clone();
            n02.F(pushbackInputStream2, bArr4, bArr4.length);
            qd2Var2.f = fw.c(n02.J(0, bArr4));
            qd2Var2.g = n02Var.H(pushbackInputStream2);
            yr2.f0(pushbackInputStream2, bArr2);
            qd2Var2.h = n02Var.I(0, bArr2);
            Arrays.fill(bArr3, (byte) 0);
            n02.F(pushbackInputStream2, bArr3, 4);
            qd2Var2.i = n02Var.I(0, bArr3);
            Arrays.fill(bArr3, (byte) 0);
            n02.F(pushbackInputStream2, bArr3, 4);
            qd2Var2.j = n02Var.I(0, bArr3);
            n02.F(pushbackInputStream2, bArr4, bArr4.length);
            int iJ = n02.J(0, bArr4);
            qd2Var2.k = iJ;
            n02.F(pushbackInputStream2, bArr4, bArr4.length);
            qd2Var2.l = n02.J(0, bArr4);
            if (iJ <= 0) {
                st4.j("Invalid entry name in local file header");
                return null;
            }
            byte[] bArr6 = new byte[iJ];
            yr2.f0(pushbackInputStream2, bArr6);
            String strJ = p95.j(bArr6, qd2Var2.s, null);
            qd2Var2.m = strJ;
            if (!strJ.endsWith("/")) {
                strJ.endsWith("\\");
            }
            int i6 = qd2Var2.l;
            if (i6 > 0) {
                if (i6 < 4) {
                    if (i6 > 0) {
                        pushbackInputStream2.skip(i6);
                    }
                    listL = null;
                } else {
                    byte[] bArr7 = new byte[i6];
                    yr2.f0(pushbackInputStream2, bArr7);
                    try {
                        listL = ed4Var.L(i6, bArr7);
                    } catch (Exception unused) {
                        listL = Collections.EMPTY_LIST;
                    }
                }
                qd2Var2.t = listL;
            }
            List list = qd2Var2.t;
            if (list == null || list.size() <= 0) {
                c = 0;
                pushbackInputStream = pushbackInputStream2;
                str = "\\";
                str2 = "/";
                qd2Var = null;
                i2 = 6;
                i3 = 3;
                i4 = 2;
            } else {
                c = 0;
                pushbackInputStream = pushbackInputStream2;
                qd2Var = null;
                str2 = "/";
                i3 = 3;
                i4 = 2;
                str = "\\";
                i2 = 6;
                ly4 ly4VarT = ed4.T(qd2Var2.t, n02Var, qd2Var2.j, qd2Var2.i, 0L, 0);
                if (ly4VarT != null) {
                    qd2Var2.q = ly4VarT;
                    long j3 = ly4VarT.e;
                    if (j3 != -1) {
                        qd2Var2.j = j3;
                    }
                    long j4 = ly4VarT.d;
                    if (j4 != -1) {
                        qd2Var2.i = j4;
                    }
                }
            }
            ed4.O(qd2Var2, n02Var);
            if (qd2Var2.n && qd2Var2.o != 4) {
                if (r25.F(qd2Var2.e[c], i2)) {
                    qd2Var2.o = i3;
                } else {
                    qd2Var2.o = i4;
                }
            }
        }
        this.X = qd2Var2;
        if (qd2Var2 == null) {
            return qd2Var;
        }
        String str3 = qd2Var2.m;
        if (!str3.endsWith(str2) && !str3.endsWith(str) && qd2Var2.f == i && qd2Var2.j < 0) {
            vp1.i(fw.y(new StringBuilder("Invalid local file header for: "), qd2Var2.m, ". Uncompressed size has to be set for entry of compression type store which is not a directory"));
            return qd2Var;
        }
        this.Y.reset();
        this.y0 = c;
        qd2 qd2Var3 = this.X;
        if (fw.e(yr2.C(qd2Var3), 1)) {
            j = qd2Var3.j;
        } else {
            if (!qd2Var3.p || this.y0) {
                long j5 = qd2Var3.i;
                if (qd2Var3.n) {
                    if (fw.e(qd2Var3.o, 4)) {
                        n nVar = qd2Var3.r;
                        if (nVar == null || (i5 = nVar.g) == 0) {
                            st4.j("AesExtraDataRecord not found or invalid for Aes encrypted entry");
                            return qd2Var;
                        }
                        iM = fw.m(i5) + 12;
                    } else {
                        iM = fw.e(qd2Var3.o, i4) ? 12 : 0;
                    }
                    j2 = j5 - ((long) iM);
                }
            }
            j = j2;
        }
        oy4 oy4Var = new oy4();
        oy4Var.f = 0L;
        oy4Var.z = new byte[1];
        oy4Var.b = pushbackInputStream;
        oy4Var.A = j;
        if (qd2Var3.n) {
            int i7 = qd2Var3.o;
            if (i7 == 4) {
                j6 j6Var = new j6(oy4Var, qd2Var3, this.A, b71Var.a, b71Var.b);
                j6Var.X = new byte[1];
                j6Var.Y = new byte[16];
                j6Var.Z = 0;
                j6Var.y0 = 0;
                j6Var.z0 = 0;
                j6Var.A0 = 0;
                j6Var.B0 = 0;
                j6Var.C0 = 0;
                u40Var = j6Var;
                if (yr2.C(qd2Var3) != i4) {
                    int i8 = b71Var.a;
                    yz1 yz1Var = new yz1(u40Var);
                    yz1Var.X = new byte[1];
                    yz1Var.z = new Inflater(true);
                    yz1Var.A = new byte[i8];
                    r34Var = yz1Var;
                } else {
                    r34Var = new r34(u40Var);
                }
                this.f = r34Var;
                this.B0 = false;
                return this.X;
            }
            if (i7 != i4) {
                throw new qy4(ha0.o("Entry [", qd2Var3.m, "] Strong Encryption not supported"), i2);
            }
            wr2Var = new wr2(oy4Var, qd2Var3, this.A, b71Var.a, b71Var.b, 1);
        } else {
            wr2Var = new wr2(oy4Var, qd2Var3, this.A, b71Var.a, true, 0);
        }
        u40Var = wr2Var;
        if (yr2.C(qd2Var3) != i4) {
        }
        this.f = r34Var;
        this.B0 = false;
        return this.X;
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
