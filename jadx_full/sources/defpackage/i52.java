package defpackage;

import j$.util.Objects;
import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class i52 implements Closeable, Flushable {
    public g43 b;

    static {
        f44[] f44VarArrValues = f44.values();
        if (f44VarArrValues.length > 31) {
            zo2.p("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", new Object[]{f44VarArrValues[0].getClass().getName(), Integer.valueOf(f44VarArrValues.length)});
            return;
        }
        for (f44 f44Var : f44VarArrValues) {
            f44Var.getClass();
        }
        f44.CAN_WRITE_FORMATTED_NUMBERS.c();
        f44.CAN_WRITE_BINARY_NATIVELY.c();
    }

    public static void n(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        zo2.p("invalid argument(s) (offset=%d, length=%d) for input array of %d element", new Object[]{0, Integer.valueOf(i2), Integer.valueOf(i)});
    }

    public abstract void C(yj yjVar, byte[] bArr, int i, int i2);

    public abstract void F(boolean z);

    public abstract void F0(ft3 ft3Var);

    public abstract void G0(String str);

    public abstract void H0(char[] cArr, int i, int i2);

    public abstract void I();

    public final void I0(e10 e10Var) throws t34 {
        Object obj = e10Var.X;
        g72 g72Var = (g72) e10Var.Z;
        String string = Objects.toString(obj, null);
        boolean z = false;
        if (string != null) {
            int i = e10Var.b;
            if (g72Var != g72.A) {
                if (i == 0) {
                    throw null;
                }
                if (i == 3 || i == 4) {
                    e10Var.b = 1;
                    i = 1;
                }
            }
            e10Var.f = true;
            int iG = fw.G(i);
            if (iG == 1) {
                x0();
                Q(string);
            } else if (iG == 2) {
                z0(e10Var.z);
                Q((String) e10Var.Y);
                G0(string);
                z = true;
            } else if (iG != 3 && iG != 4) {
                dy4 dy4Var = (dy4) this;
                dy4Var.L0("start an array");
                lb4 lb4Var = dy4Var.X;
                lb4 lb4Var2 = (lb4) lb4Var.i;
                if (lb4Var2 == null) {
                    iv1 iv1Var = (iv1) lb4Var.h;
                    lb4Var2 = new lb4(1, lb4Var, iv1Var != null ? new iv1((eo1) iv1Var.f) : null);
                    lb4Var.i = lb4Var2;
                } else {
                    lb4Var2.b = 1;
                    lb4Var2.c = -1;
                    lb4Var2.e = null;
                    lb4Var2.f = false;
                    iv1 iv1Var2 = (iv1) lb4Var2.h;
                    if (iv1Var2 != null) {
                        iv1Var2.z = null;
                        iv1Var2.A = null;
                        iv1Var2.X = null;
                    }
                }
                dy4Var.X = lb4Var2;
                dy4Var.y0.a(lb4Var2.d);
                g43 g43Var = dy4Var.b;
                if (g43Var != null) {
                    ((dm0) g43Var).a(dy4Var);
                } else {
                    if (dy4Var.J0 >= dy4Var.K0) {
                        dy4Var.Q0();
                    }
                    char[] cArr = dy4Var.H0;
                    int i2 = dy4Var.J0;
                    dy4Var.J0 = i2 + 1;
                    cArr[i2] = '[';
                }
                G0(string);
            }
        }
        int iOrdinal = g72Var.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal != 3) {
                return;
            }
            q0(e10Var.z);
        } else {
            if (z) {
                return;
            }
            z0(e10Var.z);
        }
    }

    public final void J0(e10 e10Var) {
        g72 g72Var = (g72) e10Var.Z;
        if (g72Var == g72.A) {
            M();
        } else if (g72Var == g72.X) {
            I();
        }
        if (e10Var.f) {
            int iG = fw.G(e10Var.b);
            if (iG == 0) {
                I();
                return;
            }
            if (iG == 2 || iG == 3) {
                return;
            }
            if (iG != 4) {
                M();
                return;
            }
            Object obj = e10Var.X;
            String strValueOf = obj instanceof String ? (String) obj : String.valueOf(obj);
            Q((String) e10Var.Y);
            G0(strValueOf);
        }
    }

    public abstract void M();

    public abstract void N(ft3 ft3Var);

    public abstract void Q(String str);

    public abstract void U();

    public abstract void X(double d);

    public abstract void Z(float f);

    public abstract void c0(int i);

    public final void g(String str) throws g52 {
        throw new g52(str, this);
    }

    public abstract void i0(long j);

    public abstract void j0(char c);

    public abstract void n0(String str);

    public abstract void q0(Object obj);

    public abstract void r0(Object obj);

    public abstract void s(Object obj);

    public abstract boolean x(h52 h52Var);

    public abstract void x0();

    public abstract void z0(Object obj);
}
