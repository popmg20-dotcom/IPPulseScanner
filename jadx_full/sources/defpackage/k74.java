package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k74 {
    public final HashMap a;
    public final HashMap b;
    public final int c;

    public k74(HashMap map, HashMap map2, int i) {
        this.a = map;
        this.b = map2;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k74)) {
            return false;
        }
        k74 k74Var = (k74) obj;
        return this.a.equals(k74Var.a) && this.b.equals(k74Var.b) && this.c == k74Var.c;
    }

    public final int hashCode() {
        return ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31) + this.c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SurfaceStreamSpecQueryResult(useCaseStreamSpecs=");
        sb.append(this.a);
        sb.append(", attachedSurfaceStreamSpecs=");
        sb.append(this.b);
        sb.append(", maxSupportedFrameRate=");
        return ha0.p(sb, this.c, ')');
    }
}
