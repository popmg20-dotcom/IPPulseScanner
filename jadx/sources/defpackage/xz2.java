package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xz2 extends a03 {
    public final Exception b;

    public xz2(Exception exc) {
        this.b = exc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof xz2) && this.b.equals(((xz2) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return q44.c0("LoadResult.Error(\n                    |   throwable: " + this.b + "\n                    |) ");
    }
}
