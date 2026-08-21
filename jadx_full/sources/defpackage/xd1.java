package defpackage;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class xd1 implements y50 {
    public final File a;
    public final AtomicBoolean b = new AtomicBoolean(false);

    public xd1(File file) {
        this.a = file;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [xd1] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, xd1] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [xd1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(xd1 xd1Var, ie0 ie0Var) throws IOException {
        wd1 wd1Var;
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        Throwable th2;
        if (ie0Var instanceof wd1) {
            wd1Var = (wd1) ie0Var;
            int i = wd1Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                wd1Var.y0 = i - Integer.MIN_VALUE;
            } else {
                wd1Var = new wd1(xd1Var, ie0Var);
            }
        }
        Object obj = wd1Var.Y;
        ?? r1 = wd1Var.y0;
        boolean z = true;
        mf0 mf0Var = mf0.b;
        try {
        } catch (FileNotFoundException unused) {
            xd1Var = r1;
            if (xd1Var.a.exists()) {
            }
        }
        if (r1 != 0) {
            if (r1 == 1) {
                fileInputStream3 = wd1Var.X;
                r1 = (xd1) wd1Var.A;
                try {
                    n12.S(obj);
                    ez4.l(fileInputStream3, null);
                    return obj;
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            if (r1 != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            fileInputStream = (Closeable) wd1Var.A;
            try {
                n12.S(obj);
                ez4.l(fileInputStream, null);
                return obj;
            } catch (Throwable th4) {
                th = th4;
                try {
                    throw th;
                } finally {
                }
            }
        }
        n12.S(obj);
        if (xd1Var.b.get()) {
            xe.q("This scope has already been closed.");
            return null;
        }
        try {
            fileInputStream2 = new FileInputStream(xd1Var.a);
        } catch (FileNotFoundException unused2) {
            if (xd1Var.a.exists()) {
                return new rn2(z);
            }
            FileInputStream fileInputStream4 = new FileInputStream(xd1Var.a);
            try {
                wd1Var.A = fileInputStream4;
                wd1Var.X = null;
                wd1Var.y0 = 2;
                rn2 rn2VarV = pr1.v(fileInputStream4);
                if (rn2VarV != mf0Var) {
                    obj = rn2VarV;
                    fileInputStream = fileInputStream4;
                    ez4.l(fileInputStream, null);
                    return obj;
                }
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = fileInputStream4;
                throw th;
            }
        }
        try {
            wd1Var.A = xd1Var;
            wd1Var.X = fileInputStream2;
            wd1Var.y0 = 1;
            rn2 rn2VarV2 = pr1.v(fileInputStream2);
            if (rn2VarV2 != mf0Var) {
                fileInputStream3 = fileInputStream2;
                obj = rn2VarV2;
                ez4.l(fileInputStream3, null);
                return obj;
            }
            return mf0Var;
        } catch (Throwable th6) {
            r1 = xd1Var;
            fileInputStream3 = fileInputStream2;
            th2 = th6;
            throw th;
        }
    }

    @Override // defpackage.y50
    public final void close() {
        this.b.set(true);
    }
}
