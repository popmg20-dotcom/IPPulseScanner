package defpackage;

import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class n20 {
    public static final n20 c = new n20(d70.C0(new ArrayList()), null);
    public final Set a;
    public final ek0 b;

    public n20(Set set, ek0 ek0Var) {
        this.a = set;
        this.b = ek0Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n20)) {
            return false;
        }
        n20 n20Var = (n20) obj;
        return n20Var.a.equals(this.a) && n12.c(n20Var.b, this.b);
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() + 1517) * 41;
        ek0 ek0Var = this.b;
        return iHashCode + (ek0Var != null ? ek0Var.hashCode() : 0);
    }
}
