package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sg {
    public final c74 a;
    public final c74 b;
    public final ArrayList c;

    public sg(c74 c74Var, c74 c74Var2, ArrayList arrayList) {
        if (c74Var == null) {
            zo2.n("Null primarySurfaceEdge");
            throw null;
        }
        this.a = c74Var;
        if (c74Var2 == null) {
            zo2.n("Null secondarySurfaceEdge");
            throw null;
        }
        this.b = c74Var2;
        this.c = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sg)) {
            return false;
        }
        sg sgVar = (sg) obj;
        return this.a.equals(sgVar.a) && this.b.equals(sgVar.b) && this.c.equals(sgVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() ^ ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003);
    }

    public final String toString() {
        return "In{primarySurfaceEdge=" + this.a + ", secondarySurfaceEdge=" + this.b + ", outConfigs=" + this.c + "}";
    }
}
