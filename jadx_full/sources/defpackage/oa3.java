package defpackage;

import android.util.Rational;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oa3 implements Comparator {
    public final /* synthetic */ int b;
    public final Serializable f;

    public /* synthetic */ oa3(int i, Serializable serializable) {
        this.b = i;
        this.f = serializable;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        long j;
        int i = this.b;
        Serializable serializable = this.f;
        switch (i) {
            case 0:
                HashMap map = (HashMap) serializable;
                pn0 pn0Var = (pn0) map.get((f82) obj);
                long j2 = Long.MAX_VALUE;
                if (pn0Var == null) {
                    j = 9223372036854775805L;
                } else if (pn0Var instanceof mn0) {
                    j = 9223372036854775806L;
                } else {
                    if (!(pn0Var instanceof ln0)) {
                        if (pn0Var instanceof nn0) {
                            j = ((nn0) pn0Var).a;
                        }
                        g.d();
                        return 0;
                    }
                    j = Long.MAX_VALUE;
                }
                Long lValueOf = Long.valueOf(j);
                pn0 pn0Var2 = (pn0) map.get((f82) obj2);
                if (pn0Var2 == null) {
                    j2 = 9223372036854775805L;
                } else if (pn0Var2 instanceof mn0) {
                    j2 = 9223372036854775806L;
                } else if (!(pn0Var2 instanceof ln0)) {
                    if (pn0Var2 instanceof nn0) {
                        j2 = ((nn0) pn0Var2).a;
                    }
                    g.d();
                    return 0;
                }
                return ye.f(lValueOf, Long.valueOf(j2));
            default:
                Rational rational = (Rational) obj2;
                Rational rational2 = (Rational) serializable;
                float fFloatValue = ((Rational) obj).floatValue();
                float fFloatValue2 = rational2.floatValue();
                float f = fFloatValue > fFloatValue2 ? fFloatValue2 / fFloatValue : fFloatValue / fFloatValue2;
                float fFloatValue3 = rational.floatValue();
                float fFloatValue4 = rational2.floatValue();
                return Float.compare(fFloatValue3 > fFloatValue4 ? fFloatValue4 / fFloatValue3 : fFloatValue3 / fFloatValue4, f);
        }
    }
}
