package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h50 implements Comparable, Serializable {
    public String b;
    public Class f;
    public int z;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.b.compareTo(((h50) obj).b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == h50.class && ((h50) obj).f == this.f;
    }

    public final int hashCode() {
        return this.z;
    }

    public final String toString() {
        return this.b;
    }
}
