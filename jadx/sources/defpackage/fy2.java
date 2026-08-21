package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class fy2 implements f50 {
    public final Class a;

    public fy2(Class cls) {
        this.a = cls;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof fy2) {
            return this.a.equals(((fy2) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString() + " (Kotlin reflection is not available)";
    }
}
