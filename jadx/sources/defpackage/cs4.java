package defpackage;

import java.lang.reflect.Member;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cs4 extends c9 {
    public final Class D0;
    public final nj4 E0;
    public final String F0;

    public cs4(yj4 yj4Var, Class cls, String str, nj4 nj4Var) {
        super(yj4Var, null);
        this.D0 = cls;
        this.E0 = nj4Var;
        this.F0 = str;
    }

    @Override // defpackage.c9
    public final Class O() {
        return this.D0;
    }

    @Override // defpackage.c9
    public final Member Q() {
        return null;
    }

    @Override // defpackage.c9
    public final Object R(Object obj) {
        throw new IllegalArgumentException(fw.y(new StringBuilder("Cannot get virtual property '"), this.F0, "'"));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!n50.n(obj, cs4.class)) {
            return false;
        }
        cs4 cs4Var = (cs4) obj;
        return cs4Var.D0 == this.D0 && cs4Var.F0.equals(this.F0);
    }

    public final int hashCode() {
        return this.F0.hashCode();
    }

    @Override // defpackage.xb5
    public final int p() {
        return 0;
    }

    @Override // defpackage.xb5
    public final String q() {
        return this.F0;
    }

    public final String toString() {
        return "[virtual " + P() + "]";
    }

    @Override // defpackage.xb5
    public final Class u() {
        return this.E0.L0;
    }

    @Override // defpackage.xb5
    public final nj4 x() {
        return this.E0;
    }

    @Override // defpackage.c9
    public final xb5 T(cp1 cp1Var) {
        return this;
    }
}
