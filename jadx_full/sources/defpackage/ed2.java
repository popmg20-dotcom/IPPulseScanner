package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ed2 extends fd2 {
    public static final ed2 b = new ed2(true);
    public static final ed2 c = new ed2(false);

    public final boolean equals(Object obj) {
        if (obj instanceof ed2) {
            return this.a == ((ed2) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return this.a ? 1231 : 1237;
    }

    public final String toString() {
        return "NotLoading(endOfPaginationReached=" + this.a + ')';
    }
}
