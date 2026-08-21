package defpackage;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class sy4 extends ge1 {
    public static final u03 X;
    public final LinkedHashMap A;
    public final u03 f;
    public final ge1 z;

    static {
        String str = u03.f;
        X = pr1.q("/");
    }

    public sy4(u03 u03Var, ge1 ge1Var, LinkedHashMap linkedHashMap) {
        this.f = u03Var;
        this.z = ge1Var;
        this.A = linkedHashMap;
    }

    @Override // defpackage.ge1
    public final List I(u03 u03Var) throws IOException {
        u03 u03Var2 = X;
        u03Var2.getClass();
        ny4 ny4Var = (ny4) this.A.get(f.a(u03Var2, u03Var, true));
        if (ny4Var != null) {
            return d70.y0(ny4Var.q);
        }
        st4.i(u03Var, "not a directory: ");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00cf  */
    @Override // defpackage.ge1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.no0 N(defpackage.u03 r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sy4.N(u03):no0");
    }

    @Override // defpackage.ge1
    public final w72 Q(u03 u03Var) {
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // defpackage.ge1
    public final vx3 U(u03 u03Var) throws IOException {
        u03Var.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // defpackage.ge1
    public final lz3 X(u03 u03Var) throws Throwable {
        Throwable th;
        he3 he3Var;
        u03Var.getClass();
        u03 u03Var2 = X;
        u03Var2.getClass();
        ny4 ny4Var = (ny4) this.A.get(f.a(u03Var2, u03Var, true));
        if (ny4Var == null) {
            a71.f(u03Var, "no such file: ");
            return null;
        }
        long j = ny4Var.f;
        w72 w72VarQ = this.z.Q(this.f);
        try {
            he3Var = new he3(w72VarQ.g(ny4Var.h));
            try {
                w72VarQ.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (w72VarQ != null) {
                try {
                    w72VarQ.close();
                } catch (Throwable th4) {
                    ek0.b(th3, th4);
                }
            }
            th = th3;
            he3Var = null;
        }
        if (th != null) {
            throw th;
        }
        he3Var.getClass();
        fx3.D(he3Var, null);
        if (ny4Var.g == 0) {
            return new lf1(he3Var, j, true);
        }
        return new lf1(new zz1(new he3(new lf1(he3Var, ny4Var.e, true)), new Inflater(true)), j, false);
    }

    @Override // defpackage.ge1
    public final vx3 g(u03 u03Var) throws IOException {
        throw new IOException("zip file systems are read-only");
    }

    @Override // defpackage.ge1
    public final void n(u03 u03Var, u03 u03Var2) throws IOException {
        u03Var2.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // defpackage.ge1
    public final void s(u03 u03Var) throws IOException {
        u03Var.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // defpackage.ge1
    public final void x(u03 u03Var) throws IOException {
        u03Var.getClass();
        throw new IOException("zip file systems are read-only");
    }
}
