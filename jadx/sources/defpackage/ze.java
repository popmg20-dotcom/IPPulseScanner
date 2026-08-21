package defpackage;

import android.graphics.RectF;
import android.util.Rational;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ze implements Comparator {
    public final /* synthetic */ int b = 0;
    public final Object f;
    public final Object z;

    public ze(Rational rational, Rational rational2) {
        this.z = rational2 == null ? new Rational(4, 3) : rational2;
        this.f = b(rational);
    }

    public static float a(RectF rectF, RectF rectF2) {
        return (rectF.width() < rectF2.width() ? rectF.width() : rectF2.width()) * (rectF.height() < rectF2.height() ? rectF.height() : rectF2.height());
    }

    public RectF b(Rational rational) {
        float fFloatValue = rational.floatValue();
        Rational rational2 = (Rational) this.z;
        return fFloatValue == rational2.floatValue() ? new RectF(0.0f, 0.0f, rational2.getNumerator(), rational2.getDenominator()) : rational.floatValue() > rational2.floatValue() ? new RectF(0.0f, 0.0f, rational2.getNumerator(), (rational.getDenominator() * rational2.getNumerator()) / rational.getNumerator()) : new RectF(0.0f, 0.0f, (rational.getNumerator() * rational2.getDenominator()) / rational.getDenominator(), rational2.getDenominator());
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = this.b;
        Object obj3 = this.f;
        boolean z = false;
        switch (i) {
            case 0:
                Rational rational = (Rational) obj;
                Rational rational2 = (Rational) obj2;
                RectF rectF = (RectF) obj3;
                if (rational.equals(rational2)) {
                    return 0;
                }
                RectF rectFB = b(rational);
                RectF rectFB2 = b(rational2);
                boolean z2 = rectFB.width() >= rectF.width() && rectFB.height() >= rectF.height();
                if (rectFB2.width() >= rectF.width() && rectFB2.height() >= rectF.height()) {
                    z = true;
                }
                if (z2 && z) {
                    return (int) Math.signum((rectFB.height() * rectFB.width()) - (rectFB2.height() * rectFB2.width()));
                }
                if (z2) {
                    return -1;
                }
                if (z) {
                    return 1;
                }
                return -((int) Math.signum(a(rectFB, rectF) - a(rectFB2, rectF)));
            default:
                d25 d25Var = (d25) obj;
                d25 d25Var2 = (d25) obj2;
                if (d25Var instanceof j25) {
                    return !(d25Var2 instanceof j25) ? 1 : 0;
                }
                if (d25Var2 instanceof j25) {
                    return -1;
                }
                s15 s15Var = (s15) obj3;
                return s15Var == null ? d25Var.h().compareTo(d25Var2.h()) : (int) je.s0(s15Var.j((ih4) this.z, Arrays.asList(d25Var, d25Var2)).g().doubleValue());
        }
    }

    public ze(s15 s15Var, ih4 ih4Var) {
        this.f = s15Var;
        this.z = ih4Var;
    }
}
