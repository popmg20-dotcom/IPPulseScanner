package defpackage;

import android.os.Trace;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j53 {
    public static final j53 b = new j53(new j80());
    public final j80 a;

    public j53(j80 j80Var) {
        this.a = j80Var;
    }

    public final s92 a(da2 da2Var, b00 b00Var, in4... in4VarArr) {
        int iB;
        j80 j80Var = this.a;
        in4[] in4VarArr2 = (in4[]) Arrays.copyOf(in4VarArr, in4VarArr.length);
        Trace.beginSection(vo.O("CX:bindToLifecycle"));
        try {
            n00 n00Var = (n00) j80Var.e;
            if (n00Var == null) {
                iB = 0;
            } else {
                rw rwVar = n00Var.g;
                if (rwVar == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                iB = rwVar.b.b();
            }
            if (iB == 2) {
                throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
            }
            j80Var.f(1);
            s92 s92VarA = j80.a(j80Var, da2Var, b00Var, new r90(qe.l0(in4VarArr2), g41.b));
            Trace.endSection();
            return s92VarA;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}
