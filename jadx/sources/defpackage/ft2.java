package defpackage;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ft2 extends ue4 implements ee0 {
    public static final ft2 A = new ft2(Number.class);

    @Override // defpackage.ee0
    public final b72 a(gt3 gt3Var, nm nmVar) {
        Class cls = this.b;
        e52 e52VarK = l34.k(gt3Var, nmVar, cls);
        return (e52VarK == null || e52VarK.f.ordinal() != 8) ? this : cls == BigDecimal.class ? et2.X : et2.Y;
    }

    @Override // defpackage.ue4, defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        Number number = (Number) obj;
        if (number instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) number;
            dy4 dy4Var = (dy4) i52Var;
            dy4Var.L0("write a number");
            if (dy4Var.A) {
                dy4Var.X0(dy4Var.K0(bigDecimal));
                return;
            } else {
                dy4Var.n0(dy4Var.K0(bigDecimal));
                return;
            }
        }
        if (number instanceof BigInteger) {
            BigInteger bigInteger = (BigInteger) number;
            dy4 dy4Var2 = (dy4) i52Var;
            dy4Var2.L0("write a number");
            if (dy4Var2.A) {
                dy4Var2.X0(bigInteger.toString());
                return;
            } else {
                dy4Var2.n0(bigInteger.toString());
                return;
            }
        }
        if (number instanceof Long) {
            i52Var.i0(number.longValue());
            return;
        }
        if (number instanceof Double) {
            i52Var.X(number.doubleValue());
            return;
        }
        if (number instanceof Float) {
            i52Var.Z(number.floatValue());
            return;
        }
        if ((number instanceof Integer) || (number instanceof Byte) || (number instanceof Short)) {
            i52Var.c0(number.intValue());
            return;
        }
        String string = number.toString();
        dy4 dy4Var3 = (dy4) i52Var;
        dy4Var3.L0("write a number");
        if (string == null) {
            dy4Var3.W0();
        } else if (dy4Var3.A) {
            dy4Var3.X0(string);
        } else {
            dy4Var3.n0(string);
        }
    }
}
