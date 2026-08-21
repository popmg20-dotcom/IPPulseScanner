package defpackage;

import java.io.IOException;
import java.util.GregorianCalendar;
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
    */
    public final no0 N(u03 u03Var) throws Throwable {
        boolean z;
        Long lValueOf;
        Long lValueOf2;
        Long l;
        Long lValueOf3;
        Throwable th;
        Throwable th2;
        u03Var.getClass();
        u03 u03Var2 = X;
        u03Var2.getClass();
        ny4 ny4VarD = (ny4) this.A.get(f.a(u03Var2, u03Var, true));
        if (ny4VarD == null) {
            return null;
        }
        long j = ny4VarD.h;
        if (j != -1) {
            w72 w72VarQ = this.z.Q(this.f);
            try {
                he3 he3Var = new he3(w72VarQ.g(j));
                try {
                    ny4VarD = fx3.D(he3Var, ny4VarD);
                    ny4VarD.getClass();
                    try {
                        he3Var.close();
                        th2 = null;
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                } catch (Throwable th4) {
                    try {
                        he3Var.close();
                    } catch (Throwable th5) {
                        ek0.b(th4, th5);
                    }
                    th2 = th4;
                    ny4VarD = null;
                }
                if (th2 != null) {
                    throw th2;
                }
                try {
                    w72VarQ.close();
                    th = null;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                if (w72VarQ != null) {
                    try {
                        w72VarQ.close();
                    } catch (Throwable th8) {
                        ek0.b(th7, th8);
                    }
                }
                th = th7;
                ny4VarD = null;
            }
            if (th != null) {
                throw th;
            }
        }
        boolean z2 = ny4VarD.b;
        boolean z3 = !z2;
        Long lValueOf4 = z2 ? null : Long.valueOf(ny4VarD.f);
        Long l2 = ny4VarD.m;
        if (l2 != null) {
            lValueOf = Long.valueOf((l2.longValue() / 10000) - 11644473600000L);
            z = true;
        } else {
            Integer num = ny4VarD.p;
            if (num != null) {
                z = true;
                lValueOf = Long.valueOf(((long) num.intValue()) * 1000);
            } else {
                z = true;
                lValueOf = null;
            }
        }
        Long l3 = ny4VarD.k;
        if (l3 != null) {
            lValueOf2 = Long.valueOf((l3.longValue() / 10000) - 11644473600000L);
        } else {
            Integer num2 = ny4VarD.n;
            if (num2 != null) {
                lValueOf2 = Long.valueOf(((long) num2.intValue()) * 1000);
            } else {
                int i = ny4VarD.j;
                if (i != -1) {
                    int i2 = ny4VarD.i;
                    if (i == -1) {
                        lValueOf2 = null;
                    } else {
                        int i3 = (i >> 11) & 31;
                        int i4 = (i >> 5) & 63;
                        int i5 = (i & 31) << 1;
                        GregorianCalendar gregorianCalendar = new GregorianCalendar();
                        gregorianCalendar.set(14, 0);
                        gregorianCalendar.set(((i2 >> 9) & 127) + 1980, ((i2 >> 5) & 15) - 1, i2 & 31, i3, i4, i5);
                        lValueOf2 = Long.valueOf(gregorianCalendar.getTime().getTime());
                    }
                }
            }
        }
        Long l4 = ny4VarD.l;
        if (l4 != null) {
            lValueOf3 = Long.valueOf((l4.longValue() / 10000) - 11644473600000L);
        } else {
            Integer num3 = ny4VarD.o;
            if (num3 == null) {
                l = null;
                return new no0(z3, z2, null, lValueOf4, lValueOf, lValueOf2, l);
            }
            lValueOf3 = Long.valueOf(((long) num3.intValue()) * 1000);
        }
        l = lValueOf3;
        return new no0(z3, z2, null, lValueOf4, lValueOf, lValueOf2, l);
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
