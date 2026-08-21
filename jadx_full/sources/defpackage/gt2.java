package defpackage;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gt2 extends ue4 implements ee0 {
    public static final gt2 X = new gt2(0);
    public static final gt2 Y = new gt2(1);
    public static final gt2 Z = new gt2(2);
    public final /* synthetic */ int A;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt2(int i) {
        super(Float.class);
        this.A = i;
        switch (i) {
            case 1:
                super(Number.class);
                break;
            case 2:
                super(Short.class);
                break;
            default:
                break;
        }
    }

    @Override // defpackage.ee0
    public final b72 a(gt3 gt3Var, nm nmVar) {
        Class cls = this.b;
        e52 e52VarK = l34.k(gt3Var, nmVar, cls);
        return (e52VarK == null || e52VarK.f.ordinal() != 8) ? this : cls == BigDecimal.class ? et2.X : et2.Y;
    }

    @Override // defpackage.ue4, defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        switch (this.A) {
            case 0:
                i52Var.Z(((Float) obj).floatValue());
                break;
            case 1:
                i52Var.c0(((Number) obj).intValue());
                break;
            case 2:
                short sShortValue = ((Short) obj).shortValue();
                dy4 dy4Var = (dy4) i52Var;
                int i = dy4Var.K0;
                dy4Var.L0("write a number");
                if (!dy4Var.A) {
                    if (dy4Var.J0 + 6 >= i) {
                        dy4Var.Q0();
                    }
                    dy4Var.J0 = dt2.e(dy4Var.H0, sShortValue, dy4Var.J0);
                } else {
                    char c = dy4Var.G0;
                    if (dy4Var.J0 + 8 >= i) {
                        dy4Var.Q0();
                    }
                    char[] cArr = dy4Var.H0;
                    int i2 = dy4Var.J0;
                    int i3 = i2 + 1;
                    dy4Var.J0 = i3;
                    cArr[i2] = c;
                    int iE = dt2.e(cArr, sShortValue, i3);
                    char[] cArr2 = dy4Var.H0;
                    dy4Var.J0 = iE + 1;
                    cArr2[iE] = c;
                }
                break;
            case 3:
                i52Var.X(((Double) obj).doubleValue());
                break;
            case 4:
                i52Var.c0(((Integer) obj).intValue());
                break;
            default:
                i52Var.i0(((Long) obj).longValue());
                break;
        }
    }

    @Override // defpackage.ue4, defpackage.b72
    public void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        switch (this.A) {
            case 3:
                Double d = (Double) obj;
                double dDoubleValue = d.doubleValue();
                String str = dt2.a;
                if (!((Double.isInfinite(dDoubleValue) || Double.isNaN(dDoubleValue)) ? false : true)) {
                    e10 e10VarE = zj4Var.e(i52Var, zj4Var.d(obj, g72.y0));
                    i52Var.X(d.doubleValue());
                    zj4Var.f(i52Var, e10VarE);
                } else {
                    i52Var.X(d.doubleValue());
                }
                break;
            case 4:
                e(obj, i52Var, gt3Var);
                break;
            default:
                super.f(obj, i52Var, gt3Var, zj4Var);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gt2(Class cls, int i) {
        super(cls);
        this.A = i;
    }
}
