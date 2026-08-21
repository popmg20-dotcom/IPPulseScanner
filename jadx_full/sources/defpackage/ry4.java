package defpackage;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ry4 implements Closeable {
    public ed4 A;
    public int X;
    public ArrayList Y;
    public boolean Z;
    public File b;
    public wy4 f;
    public r51 z;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ArrayList arrayList = this.Y;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InputStream) it.next()).close();
        }
        arrayList.clear();
    }

    public final void g(File file) {
        boolean z = this.Z;
        int i = this.X;
        List listSingletonList = Collections.singletonList(file);
        yy4 yy4Var = new yy4();
        File file2 = this.b;
        if (listSingletonList == null || listSingletonList.size() == 0) {
            st4.j("input file List is null or empty");
            return;
        }
        if (this.f == null) {
            if (!file2.exists()) {
                wy4 wy4Var = new wy4();
                this.f = wy4Var;
                wy4Var.y0 = file2;
            } else {
                if (!file2.canRead()) {
                    st4.j("no read access for the input zip file");
                    return;
                }
                try {
                    RandomAccessFile randomAccessFileN = n();
                    try {
                        wy4 wy4VarP = new ed4((byte) 0, 27).P(randomAccessFileN, new b71(i, z));
                        this.f = wy4VarP;
                        wy4VarP.y0 = file2;
                        randomAccessFileN.close();
                    } finally {
                    }
                } catch (qy4 e) {
                    throw e;
                } catch (IOException e2) {
                    throw new qy4(e2);
                }
            }
        }
        if (this.f == null) {
            st4.j("internal error: zip model is null");
        } else if (file2.exists() && this.f.Y) {
            st4.j("Zip file already exists. Zip file format does not allow updating split/spanned files");
        } else {
            new r5(this.f, this.A, new w7(9, this.z), 0).K0(new q5(listSingletonList, yy4Var, new b71(i, z)));
        }
    }

    public final RandomAccessFile n() throws IOException {
        File file = this.b;
        if (!file.getName().endsWith(".zip.001")) {
            return new RandomAccessFile(file, "r");
        }
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(".");
        if (iLastIndexOf != -1) {
            name = name.substring(0, iLastIndexOf);
        }
        File[] fileArrListFiles = file.getParentFile().listFiles(new he1(name, 0));
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        } else {
            Arrays.sort(fileArrListFiles);
        }
        kt2 kt2Var = new kt2(file, fileArrListFiles);
        kt2Var.g(kt2Var.f.length - 1);
        return kt2Var;
    }

    public final String toString() {
        return this.b.toString();
    }
}
