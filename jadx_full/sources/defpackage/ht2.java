package defpackage;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ht2 implements ii4 {
    public final /* synthetic */ int b;
    public final /* synthetic */ hi4 f;

    public /* synthetic */ ht2(hi4 hi4Var, int i) {
        this.b = i;
        this.f = hi4Var;
    }

    @Override // defpackage.ii4
    public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
        int i = this.b;
        hi4 hi4Var = this.f;
        switch (i) {
            case 0:
                if (bk4Var.a == Number.class) {
                    return (it2) hi4Var;
                }
                return null;
            default:
                Class cls = bk4Var.a;
                if (cls == Calendar.class || cls == GregorianCalendar.class) {
                    return (aj4) hi4Var;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.b) {
            case 1:
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((aj4) this.f) + "]";
            default:
                return super.toString();
        }
    }
}
