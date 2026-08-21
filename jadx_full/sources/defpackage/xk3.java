package defpackage;

import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class xk3 {
    public final float a;
    public final float b;

    public xk3(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public static float a(xk3 xk3Var, xk3 xk3Var2) {
        return gb4.F(xk3Var.a, xk3Var.b, xk3Var2.a, xk3Var2.b);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof xk3) {
            xk3 xk3Var = (xk3) obj;
            if (this.a == xk3Var.a && this.b == xk3Var.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.b) + (Float.floatToIntBits(this.a) * 31);
    }

    public final String toString() {
        return "(" + this.a + StringUtil.COMMA + this.b + ')';
    }
}
