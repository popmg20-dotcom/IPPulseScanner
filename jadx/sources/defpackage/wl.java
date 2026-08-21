package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wl extends fx3 implements Serializable {
    public static final ul X = ul.d(null, jx3.t0(String.class), new w8(String.class));
    public static final ul Y;
    public static final ul Z;
    public static final ul y0;
    public static final ul z0;

    static {
        Class cls = Boolean.TYPE;
        Y = ul.d(null, jx3.t0(cls), new w8(cls));
        Class cls2 = Integer.TYPE;
        Z = ul.d(null, jx3.t0(cls2), new w8(cls2));
        Class cls3 = Long.TYPE;
        y0 = ul.d(null, jx3.t0(cls3), new w8(cls3));
        z0 = ul.d(null, jx3.t0(Object.class), new w8(Object.class));
    }

    public static ul S(yg2 yg2Var, nj4 nj4Var) {
        Class cls = nj4Var.L0;
        if (cls.isPrimitive()) {
            if (cls != Integer.TYPE) {
                if (cls != Long.TYPE) {
                    if (cls != Boolean.TYPE) {
                        return null;
                    }
                    return Y;
                }
                return y0;
            }
            return Z;
        }
        if (!n50.p(cls)) {
            if (d62.class.isAssignableFrom(cls)) {
                return ul.d(yg2Var, nj4Var, new w8(cls));
            }
            return null;
        }
        if (cls == Object.class) {
            return z0;
        }
        if (cls == String.class) {
            return X;
        }
        if (cls != Integer.class) {
            if (cls != Long.class) {
                if (cls != Boolean.class) {
                    return null;
                }
                return Y;
            }
            return y0;
        }
        return Z;
    }
}
