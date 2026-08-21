package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qu0 extends p95 {
    public final int n;

    public qu0(int i) {
        this.n = i;
        if (i > 0) {
            return;
        }
        xe.k("px must be > 0.");
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof qu0) {
            return this.n == ((qu0) obj).n;
        }
        return false;
    }

    public final int hashCode() {
        return this.n;
    }

    public final String toString() {
        return String.valueOf(this.n);
    }
}
