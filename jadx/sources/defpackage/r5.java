package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class r5 extends k70 {
    public final /* synthetic */ int X;
    public final wy4 Y;
    public final ed4 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r5(wy4 wy4Var, ed4 ed4Var, w7 w7Var, int i) {
        super(w7Var);
        this.X = i;
        this.Y = wy4Var;
        this.Z = ed4Var;
    }

    public static void X0(boolean z, File file, File file2) throws qy4 {
        if (!z) {
            if (file2.delete()) {
                return;
            }
            st4.j("Could not delete temporary file");
        } else if (!file.delete()) {
            st4.j("cannot delete old zip file");
        } else {
            if (file2.renameTo(file)) {
                return;
            }
            st4.j("cannot rename modified zip file");
        }
    }

    public static yy4 Y0(yy4 yy4Var, File file, r51 r51Var) throws IOException {
        yy4 yy4Var2 = new yy4(yy4Var);
        if (file.isDirectory()) {
            yy4Var2.k = 0L;
        } else {
            yy4Var2.k = file.length();
        }
        if (yy4Var.j <= 0) {
            long jLastModified = file.lastModified();
            if (jLastModified < 0) {
                yy4Var2.j = 0L;
            } else {
                yy4Var2.j = jLastModified;
            }
        }
        yy4Var2.l = false;
        if (!yr2.N(yy4Var.i)) {
            yy4Var2.i = v02.k(file, yy4Var);
        }
        if (file.isDirectory()) {
            yy4Var2.a = 1;
            yy4Var2.d = 1;
            yy4Var2.c = false;
            return yy4Var2;
        }
        if (yy4Var2.c && yy4Var2.d == 2) {
            r51Var.getClass();
            if (!file.exists() || !file.canRead()) {
                st4.j("input file is null or does not exist or cannot read. Cannot calculate CRC for the file");
                return null;
            }
            byte[] bArr = new byte[16384];
            CRC32 crc32 = new CRC32();
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    crc32.update(bArr, 0, i);
                    r51Var.a(i);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            long value = crc32.getValue();
            fileInputStream.close();
            yy4Var2.h = value;
        }
        if (file.length() == 0) {
            yy4Var2.a = 1;
        }
        return yy4Var2;
    }

    public static int a1(ArrayList arrayList, rd1 rd1Var) throws qy4 {
        for (int i = 0; i < arrayList.size(); i++) {
            if (((rd1) arrayList.get(i)).equals(rd1Var)) {
                return i;
            }
        }
        st4.j("Could not find file header in list of central directory file headers");
        return 0;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03c9 A[Catch: all -> 0x03d6, TRY_LEAVE, TryCatch #10 {all -> 0x03d6, blocks: (B:200:0x03c2, B:202:0x03c9), top: B:249:0x03c2, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x03d9 A[SYNTHETIC] */
    @Override // defpackage.k70
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L0(defpackage.k70 r27, defpackage.r51 r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1038
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r5.L0(k70, r51):void");
    }

    public void W0(File file, xy4 xy4Var, yy4 yy4Var, q04 q04Var) throws IOException {
        yy4 yy4Var2 = new yy4(yy4Var);
        String str = yy4Var.i;
        String name = file.getName();
        if (str.contains("/")) {
            name = str.substring(0, str.lastIndexOf("/") + 1) + name;
        }
        yy4Var2.i = name;
        yy4Var2.c = false;
        yy4Var2.a = 1;
        xy4Var.n(yy4Var2);
        xy4Var.write(v02.w(file).getBytes());
        Z0(xy4Var, q04Var, file, true);
    }

    public void Z0(xy4 xy4Var, q04 q04Var, File file, boolean z) throws IOException {
        q04 q04Var2;
        boolean z2;
        String str;
        String string;
        rd1 rd1VarG = xy4Var.g();
        byte[] bArrH = v02.h(file);
        if (!z) {
            bArrH[3] = r25.V(bArrH[3], 5);
        }
        rd1VarG.w = bArrH;
        ed4 ed4Var = this.Z;
        n02 n02Var = (n02) ed4Var.f;
        byte[] bArr = (byte[]) ed4Var.z;
        wy4 wy4Var = this.Y;
        if (wy4Var == null) {
            st4.j("invalid input parameters, cannot update local file header");
            return;
        }
        if (rd1VarG.v != q04Var.A) {
            String parent = wy4Var.y0.getParent();
            String strO = v02.o(wy4Var.y0.getName());
            if (parent != null) {
                str = parent + System.getProperty("file.separator");
            } else {
                str = "";
            }
            z2 = true;
            if (rd1VarG.v < 9) {
                StringBuilder sbD = fw.D(str, strO, ".z0");
                sbD.append(rd1VarG.v + 1);
                string = sbD.toString();
            } else {
                StringBuilder sbD2 = fw.D(str, strO, ".z");
                sbD2.append(rd1VarG.v + 1);
                string = sbD2.toString();
            }
            q04Var2 = new q04(new File(string));
        } else {
            q04Var2 = q04Var;
            z2 = false;
        }
        long filePointer = q04Var2.b.getFilePointer();
        q04Var2.b.seek(rd1VarG.x + 14);
        n02.U(bArr, rd1VarG.h);
        q04Var2.write(bArr, 0, 4);
        if (rd1VarG.j >= 4294967295L) {
            n02.U(bArr, 4294967295L);
            q04Var2.write(bArr, 0, 4);
            q04Var2.write(bArr, 0, 4);
            int i = rd1VarG.k + 8;
            if (q04Var2.b.skipBytes(i) != i) {
                st4.j(ha0.k("Unable to skip ", i, " bytes to update LFH"));
                return;
            } else {
                n02Var.T(q04Var2, rd1VarG.j);
                n02Var.T(q04Var2, rd1VarG.i);
            }
        } else {
            n02.U(bArr, rd1VarG.i);
            q04Var2.write(bArr, 0, 4);
            n02.U(bArr, rd1VarG.j);
            q04Var2.write(bArr, 0, 4);
        }
        if (z2) {
            q04Var2.close();
        } else {
            q04Var.b.seek(filePointer);
        }
    }

    public void b1(ArrayList arrayList, rd1 rd1Var, long j) throws qy4 {
        wy4 wy4Var;
        ly4 ly4Var;
        if (j == Long.MIN_VALUE) {
            throw new ArithmeticException("long overflow");
        }
        long j2 = -j;
        int iA1 = a1(arrayList, rd1Var);
        if (iA1 == -1) {
            st4.j("Could not locate modified file header in zipModel");
            return;
        }
        while (true) {
            iA1++;
            int size = arrayList.size();
            wy4Var = this.Y;
            if (iA1 >= size) {
                break;
            }
            rd1 rd1Var2 = (rd1) arrayList.get(iA1);
            rd1Var2.x += j2;
            if (wy4Var.z0 && (ly4Var = rd1Var2.q) != null) {
                long j3 = ly4Var.f;
                if (j3 != -1) {
                    ly4Var.f = j3 + j2;
                }
            }
        }
        z41 z41Var = wy4Var.z;
        z41Var.h -= j;
        z41Var.g--;
        int i = z41Var.f;
        if (i > 0) {
            z41Var.f = i - 1;
        }
        if (wy4Var.z0) {
            ky4 ky4Var = wy4Var.X;
            ky4Var.l -= j;
            ky4Var.i = ky4Var.j - 1;
            wy4Var.A.e -= j;
        }
    }
}
