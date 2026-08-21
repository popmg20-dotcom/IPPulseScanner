package defpackage;

import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class je1 extends xd1 {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(Object obj, ie0 ie0Var) throws IOException {
        ie1 ie1Var;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (ie0Var instanceof ie1) {
            ie1Var = (ie1) ie0Var;
            int i = ie1Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                ie1Var.y0 = i - Integer.MIN_VALUE;
            } else {
                ie1Var = new ie1(this, ie0Var);
            }
        }
        Object obj2 = ie1Var.Y;
        int i2 = ie1Var.y0;
        xl4 xl4Var = xl4.a;
        if (i2 == 0) {
            n12.S(obj2);
            if (this.b.get()) {
                xe.q("This scope has already been closed.");
                return null;
            }
            FileOutputStream fileOutputStream3 = new FileOutputStream(this.a);
            try {
                zk4 zk4Var = new zk4(fileOutputStream3);
                ie1Var.A = fileOutputStream3;
                ie1Var.X = fileOutputStream3;
                ie1Var.y0 = 1;
                pr1.w(obj, zk4Var);
                mf0 mf0Var = mf0.b;
                if (xl4Var == mf0Var) {
                    return mf0Var;
                }
                fileOutputStream2 = fileOutputStream3;
                fileOutputStream = fileOutputStream2;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream3;
                throw th;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            fileOutputStream2 = ie1Var.X;
            fileOutputStream = ie1Var.A;
            try {
                n12.S(obj2);
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    ez4.l(fileOutputStream, th);
                    throw th3;
                }
            }
        }
        fileOutputStream2.getFD().sync();
        ez4.l(fileOutputStream, null);
        return xl4Var;
    }
}
