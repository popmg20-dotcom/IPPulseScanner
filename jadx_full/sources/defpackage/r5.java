package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
    */
    public final void L0(k70 k70Var, r51 r51Var) throws Throwable {
        FileInputStream fileInputStream;
        int i;
        boolean z;
        q04 q04Var;
        Throwable th;
        File file;
        Iterator it;
        long j;
        b71 b71Var;
        long j2;
        int i2 = this.X;
        ed4 ed4Var = this.Z;
        wy4 wy4Var = this.Y;
        switch (i2) {
            case 0:
                r51 r51Var2 = (r51) this.f;
                q5 q5Var = (q5) k70Var;
                yy4 yy4Var = q5Var.Y;
                int i3 = yy4Var.n;
                int i4 = yy4Var.a;
                if (i4 != 1 && i4 != 2) {
                    st4.j("unsupported compression type");
                    return;
                }
                if (yy4Var.c) {
                    if (yy4Var.d != 1) {
                        st4.j("input password is empty or null");
                        return;
                    } else {
                        st4.j("Encryption method has to be set, when encrypt files flag is set");
                        return;
                    }
                }
                yy4Var.d = 1;
                ArrayList<File> arrayList = new ArrayList();
                for (File file2 : q5Var.X) {
                    arrayList.add(file2);
                    if (v02.s(file2) && !fw.e(1, i3)) {
                        arrayList.addAll(v02.i(file2, yy4Var));
                    }
                }
                b71 b71Var2 = (b71) q5Var.f;
                Iterator it2 = arrayList.iterator();
                while (true) {
                    int i5 = 3;
                    if (it2.hasNext()) {
                        File file3 = (File) it2.next();
                        if (!v02.s(file3)) {
                            if (!file3.exists()) {
                                throw new qy4("File does not exist: " + file3);
                            }
                        } else if (fw.e(i3, 3) || fw.e(i3, 2)) {
                            if (!file3.exists()) {
                                throw new qy4("Symlink target '" + v02.w(file3) + "' does not exist for link '" + file3 + "'");
                            }
                        }
                    } else {
                        byte[] bArr = new byte[b71Var2.a];
                        ArrayList<File> arrayList2 = new ArrayList(arrayList);
                        if (wy4Var.y0.exists()) {
                            for (File file4 : arrayList) {
                                if (!yr2.N(file4.getName())) {
                                    arrayList2.remove(file4);
                                }
                                rd1 rd1VarQ = p95.q(wy4Var, v02.k(file4, yy4Var));
                                if (rd1VarQ != null) {
                                    if (yy4Var.m) {
                                        r51Var.getClass();
                                        new r5(wy4Var, ed4Var, new w7(9, r51Var), 1).K0(new oi3(Collections.singletonList(rd1VarQ.m), b71Var2));
                                        r51Var2.getClass();
                                    } else {
                                        arrayList2.remove(file4);
                                    }
                                }
                            }
                        }
                        q04 q04Var2 = new q04(wy4Var.y0, wy4Var.Z);
                        try {
                            if (wy4Var.y0.exists()) {
                                q04Var2.b.seek(wy4Var.z0 ? wy4Var.X.l : wy4Var.z.h);
                            }
                            xy4 xy4Var = new xy4(q04Var2, null, b71Var2, wy4Var);
                            try {
                                for (File file5 : arrayList2) {
                                    r51Var2.getClass();
                                    yy4 yy4VarY0 = Y0(yy4Var, file5, r51Var);
                                    int i6 = yy4VarY0.n;
                                    file5.getAbsolutePath();
                                    r51Var.getClass();
                                    if (!v02.s(file5) || (!fw.e(1, i6) && !fw.e(i5, i6))) {
                                        xy4Var.n(yy4VarY0);
                                        if (file5.exists() && !file5.isDirectory()) {
                                            fileInputStream = new FileInputStream(file5);
                                            while (true) {
                                                try {
                                                    i = fileInputStream.read(bArr);
                                                    if (i == -1) {
                                                        xy4Var.write(bArr, 0, i);
                                                        r51Var.a(i);
                                                        r51Var2.getClass();
                                                    } else {
                                                        fileInputStream.close();
                                                    }
                                                } catch (Throwable th2) {
                                                    try {
                                                        fileInputStream.close();
                                                        throw th2;
                                                    } catch (Throwable th3) {
                                                        th2.addSuppressed(th3);
                                                        throw th2;
                                                    }
                                                }
                                            }
                                        }
                                        Z0(xy4Var, q04Var2, file5, false);
                                        i5 = 3;
                                    }
                                    W0(file5, xy4Var, yy4VarY0, q04Var2);
                                    if (!fw.e(1, i6)) {
                                        xy4Var.n(yy4VarY0);
                                        if (file5.exists()) {
                                            fileInputStream = new FileInputStream(file5);
                                            while (true) {
                                                i = fileInputStream.read(bArr);
                                                if (i == -1) {
                                                }
                                            }
                                        }
                                        Z0(xy4Var, q04Var2, file5, false);
                                        i5 = 3;
                                    }
                                }
                                xy4Var.close();
                                q04Var2.close();
                                return;
                            } catch (Throwable th4) {
                                try {
                                    xy4Var.close();
                                    throw th4;
                                } catch (Throwable th5) {
                                    th4.addSuppressed(th5);
                                    throw th4;
                                }
                            }
                        } finally {
                        }
                    }
                }
                break;
            default:
                oi3 oi3Var = (oi3) k70Var;
                if (wy4Var.Y) {
                    st4.j("This is a split archive. Zip file format does not allow updating split/spanned files");
                    return;
                }
                List<String> list = oi3Var.X;
                b71 b71Var3 = (b71) oi3Var.f;
                ArrayList arrayList3 = new ArrayList();
                for (String str : list) {
                    if (p95.q(wy4Var, str) != null) {
                        arrayList3.add(str);
                    }
                }
                if (arrayList3.isEmpty()) {
                    return;
                }
                String path = wy4Var.y0.getPath();
                SecureRandom secureRandom = new SecureRandom();
                File file6 = new File(path + secureRandom.nextInt(10000));
                while (file6.exists()) {
                    file6 = new File(path + secureRandom.nextInt(10000));
                }
                try {
                    q04Var = new q04(file6);
                } catch (Throwable th6) {
                    th = th6;
                    z = false;
                }
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(wy4Var.y0, "r");
                    try {
                        ArrayList arrayList4 = new ArrayList(wy4Var.f.a);
                        Collections.sort(arrayList4, new e1(0));
                        Iterator it3 = arrayList4.iterator();
                        long j3 = 0;
                        while (it3.hasNext()) {
                            try {
                                rd1 rd1Var = (rd1) it3.next();
                                try {
                                    int iA1 = a1(arrayList4, rd1Var);
                                    if (iA1 != arrayList4.size() - 1) {
                                        file = file6;
                                        it = it3;
                                        j = ((rd1) arrayList4.get(iA1 + 1)).x;
                                    } else if (wy4Var.z0) {
                                        file = file6;
                                        it = it3;
                                        try {
                                            j = wy4Var.X.l;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            file6 = file;
                                            Throwable th8 = th;
                                            try {
                                                randomAccessFile.close();
                                                throw th8;
                                            } catch (Throwable th9) {
                                                th8.addSuppressed(th9);
                                                throw th8;
                                            }
                                        }
                                    } else {
                                        file = file6;
                                        it = it3;
                                        j = wy4Var.z.h;
                                    }
                                    long filePointer = j - q04Var.b.getFilePointer();
                                    Iterator it4 = arrayList3.iterator();
                                    while (it4.hasNext()) {
                                        String str2 = (String) it4.next();
                                        Iterator it5 = it4;
                                        if ((!str2.endsWith("/") || !rd1Var.m.startsWith(str2)) && !rd1Var.m.equals(str2)) {
                                            it4 = it5;
                                        }
                                        b1(arrayList4, rd1Var, filePointer);
                                        if (!wy4Var.f.a.remove(rd1Var)) {
                                            throw new qy4("Could not remove entry from list of central directory headers");
                                        }
                                        j3 += filePointer;
                                        b71Var = b71Var3;
                                        ((r51) this.f).getClass();
                                        file6 = file;
                                        it3 = it;
                                        b71Var3 = b71Var;
                                    }
                                    int i7 = b71Var3.a;
                                    long j4 = j3 + filePointer;
                                    if (j3 < 0 || j4 < 0 || j3 > j4) {
                                        b71Var = b71Var3;
                                        j2 = filePointer;
                                        st4.j("invalid offsets");
                                    } else if (j3 == j4) {
                                        b71Var = b71Var3;
                                        j2 = filePointer;
                                    } else {
                                        try {
                                            randomAccessFile.seek(j3);
                                            long j5 = j4 - j3;
                                            j2 = filePointer;
                                            byte[] bArr2 = j5 < ((long) i7) ? new byte[(int) j5] : new byte[i7];
                                            b71Var = b71Var3;
                                            long j6 = 0;
                                            while (true) {
                                                int i8 = randomAccessFile.read(bArr2);
                                                long j7 = j5;
                                                if (i8 != -1) {
                                                    q04Var.write(bArr2, 0, i8);
                                                    long j8 = i8;
                                                    r51Var.a(j8);
                                                    j6 += j8;
                                                    if (j6 != j7) {
                                                        if (((long) bArr2.length) + j6 > j7) {
                                                            bArr2 = new byte[(int) (j7 - j6)];
                                                        }
                                                        j5 = j7;
                                                    }
                                                }
                                            }
                                        } catch (IOException e) {
                                            throw new qy4(e);
                                        }
                                    }
                                    j3 += j2;
                                    ((r51) this.f).getClass();
                                    file6 = file;
                                    it3 = it;
                                    b71Var3 = b71Var;
                                } catch (Throwable th10) {
                                    th = th10;
                                    file = file6;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                            }
                            break;
                        }
                        File file7 = file6;
                        ed4Var.z(wy4Var, q04Var);
                        try {
                            randomAccessFile.close();
                            try {
                                q04Var.close();
                                X0(true, wy4Var.y0, file7);
                                return;
                            } catch (Throwable th12) {
                                th = th12;
                                file6 = file7;
                                z = true;
                                X0(z, wy4Var.y0, file6);
                                throw th;
                            }
                        } catch (Throwable th13) {
                            file6 = file7;
                            th = th13;
                            z = true;
                            try {
                                try {
                                    q04Var.close();
                                    throw th;
                                } catch (Throwable th14) {
                                    th.addSuppressed(th14);
                                    throw th;
                                }
                            } catch (Throwable th15) {
                                th = th15;
                                X0(z, wy4Var.y0, file6);
                                throw th;
                            }
                        }
                    } catch (Throwable th16) {
                        th = th16;
                    }
                } catch (Throwable th17) {
                    th = th17;
                    z = false;
                    q04Var.close();
                    throw th;
                }
                break;
                break;
        }
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
