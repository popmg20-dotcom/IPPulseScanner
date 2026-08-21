package defpackage;

import java.io.Serializable;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v52 implements Serializable {
    public static final v52 f = new v52(null);
    public final Set b;

    public v52(Set set) {
        this.b = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == v52.class) {
            Set set = ((v52) obj).b;
            Set set2 = this.b;
            if (set2 == null ? set == null : set2.equals(set)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Set set = this.b;
        if (set == null) {
            return 0;
        }
        return set.size();
    }

    public final String toString() {
        return String.format("JsonIncludeProperties.Value(included=%s)", this.b);
    }
}
