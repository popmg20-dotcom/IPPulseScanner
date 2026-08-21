package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fq1 extends hi4 {
    public final /* synthetic */ int a;

    public /* synthetic */ fq1(int i) {
        this.a = i;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        switch (this.a) {
            case 0:
                if (r62Var.X() != 9) {
                    return Double.valueOf(r62Var.nextDouble());
                }
                r62Var.N();
                return null;
            case 1:
                if (r62Var.X() != 9) {
                    return Float.valueOf((float) r62Var.nextDouble());
                }
                r62Var.N();
                return null;
            default:
                r62Var.t();
                return null;
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        switch (this.a) {
            case 0:
                Number number = (Number) obj;
                if (number != null) {
                    double dDoubleValue = number.doubleValue();
                    iq1.a(dDoubleValue);
                    v72Var.Q(dDoubleValue);
                } else {
                    v72Var.C();
                }
                break;
            case 1:
                Number numberValueOf = (Number) obj;
                if (numberValueOf != null) {
                    float fFloatValue = numberValueOf.floatValue();
                    iq1.a(fFloatValue);
                    if (!(numberValueOf instanceof Float)) {
                        numberValueOf = Float.valueOf(fFloatValue);
                    }
                    v72Var.X(numberValueOf);
                } else {
                    v72Var.C();
                }
                break;
            default:
                v72Var.C();
                break;
        }
    }

    public String toString() {
        switch (this.a) {
            case 2:
                return "AnonymousOrNonStaticLocalClassAdapter";
            default:
                return super.toString();
        }
    }
}
