package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cd2 extends fd2 {
    public final Exception b;

    public cd2(Exception exc) {
        super(false);
        this.b = exc;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof cd2)) {
            return false;
        }
        cd2 cd2Var = (cd2) obj;
        return this.a == cd2Var.a && this.b.equals(cd2Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a ? 1231 : 1237);
    }

    public final String toString() {
        return "Error(endOfPaginationReached=" + this.a + ", error=" + this.b + ')';
    }
}
