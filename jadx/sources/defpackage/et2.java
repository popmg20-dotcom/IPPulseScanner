package defpackage;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class et2 extends ue4 {
    public static final et2 X = new et2(0);
    public static final et2 Y = new et2(1);
    public final /* synthetic */ int A;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public et2(int i) {
        super(BigDecimal.class, 0);
        this.A = i;
        switch (i) {
            case 1:
                super(Object.class, 0);
                break;
            default:
                break;
        }
    }

    @Override // defpackage.ue4, defpackage.b72
    public boolean c(gt3 gt3Var, Object obj) {
        switch (this.A) {
            case 0:
                return false;
            default:
                return super.c(gt3Var, obj);
        }
    }

    @Override // defpackage.ue4, defpackage.b72
    public void e(Object obj, i52 i52Var, gt3 gt3Var) throws a62 {
        String string;
        switch (this.A) {
            case 0:
                if (i52Var.x(h52.WRITE_BIGDECIMAL_AS_PLAIN)) {
                    BigDecimal bigDecimal = (BigDecimal) obj;
                    int iScale = bigDecimal.scale();
                    if (iScale < -9999 || iScale > 9999) {
                        String str = String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(bigDecimal.scale()), 9999, 9999);
                        gt3Var.getClass();
                        throw new a62(((hm0) gt3Var).F0, str, null);
                    }
                    string = bigDecimal.toPlainString();
                } else {
                    string = obj.toString();
                }
                i52Var.G0(string);
                return;
            default:
                super.e(obj, i52Var, gt3Var);
                return;
        }
    }

    @Override // defpackage.ue4
    public final String o(Object obj) {
        switch (this.A) {
            case 0:
                throw new IllegalStateException();
            default:
                return obj.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ et2(Class cls, int i) {
        super(cls, i);
        this.A = 1;
    }
}
