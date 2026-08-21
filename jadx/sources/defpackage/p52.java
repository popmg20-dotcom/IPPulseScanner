package defpackage;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p52 implements Serializable {
    public static final p52 Y = new p52(Collections.EMPTY_SET, false, false, false, true);
    public final boolean A;
    public final boolean X;
    public final Set b;
    public final boolean f;
    public final boolean z;

    public p52(Set set, boolean z, boolean z2, boolean z3, boolean z4) {
        if (set == null) {
            this.b = Collections.EMPTY_SET;
        } else {
            this.b = set;
        }
        this.f = z;
        this.z = z2;
        this.A = z3;
        this.X = z4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == p52.class) {
            p52 p52Var = (p52) obj;
            if (this.f == p52Var.f && this.X == p52Var.X && this.z == p52Var.z && this.A == p52Var.A && this.b.equals(p52Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.size() + (this.f ? 1 : -3) + (this.z ? 3 : -7) + (this.A ? 7 : -11) + (this.X ? 11 : -13);
    }

    public final String toString() {
        return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", this.b, Boolean.valueOf(this.f), Boolean.valueOf(this.z), Boolean.valueOf(this.A), Boolean.valueOf(this.X));
    }
}
