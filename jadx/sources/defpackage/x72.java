package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class x72 extends ge1 {
    @Override // defpackage.ge1
    public final List I(u03 u03Var) throws IOException {
        File file = u03Var.toFile();
        String[] list = file.list();
        if (list == null) {
            if (file.exists()) {
                st4.i(u03Var, "failed to list ");
                return null;
            }
            a71.f(u03Var, "no such file: ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            str.getClass();
            arrayList.add(u03Var.d(str));
        }
        h70.S(arrayList);
        return arrayList;
    }

    @Override // defpackage.ge1
    public no0 N(u03 u03Var) {
        u03Var.getClass();
        File file = u03Var.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (!zIsFile && !zIsDirectory && jLastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new no0(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
    }

    @Override // defpackage.ge1
    public final w72 Q(u03 u03Var) {
        return new w72(new RandomAccessFile(u03Var.toFile(), "r"));
    }

    @Override // defpackage.ge1
    public final vx3 U(u03 u03Var) {
        u03Var.getClass();
        return new kx2(new FileOutputStream(u03Var.toFile(), false), new de4());
    }

    @Override // defpackage.ge1
    public final lz3 X(u03 u03Var) {
        u03Var.getClass();
        return new q02(new FileInputStream(u03Var.toFile()), de4.d);
    }

    @Override // defpackage.ge1
    public final vx3 g(u03 u03Var) {
        return new kx2(new FileOutputStream(u03Var.toFile(), true), new de4());
    }

    @Override // defpackage.ge1
    public void n(u03 u03Var, u03 u03Var2) throws IOException {
        u03Var2.getClass();
        if (u03Var.toFile().renameTo(u03Var2.toFile())) {
            return;
        }
        throw new IOException("failed to move " + u03Var + " to " + u03Var2);
    }

    @Override // defpackage.ge1
    public final void s(u03 u03Var) throws IOException {
        u03Var.getClass();
        if (u03Var.toFile().mkdir()) {
            return;
        }
        no0 no0VarN = N(u03Var);
        if (no0VarN == null || !no0VarN.c) {
            st4.i(u03Var, "failed to create directory: ");
        }
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }

    @Override // defpackage.ge1
    public final void x(u03 u03Var) throws IOException {
        u03Var.getClass();
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = u03Var.toFile();
        if (file.delete() || !file.exists()) {
            return;
        }
        st4.i(u03Var, "failed to delete ");
    }
}
