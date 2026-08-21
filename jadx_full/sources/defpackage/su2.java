package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class su2 {
    public final ru2 a;
    public final da2 b;

    public su2(da2 da2Var, ru2 ru2Var) {
        ru2Var.getClass();
        this.a = ru2Var;
        this.b = da2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof su2)) {
            return false;
        }
        su2 su2Var = (su2) obj;
        return n12.c(this.a, su2Var.a) && n12.c(this.b, su2Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        da2 da2Var = this.b;
        return iHashCode + (da2Var == null ? 0 : da2Var.hashCode());
    }

    public final String toString() {
        return "OnBackPressedCallbackInfo(callback=" + this.a + ", owner=" + this.b + ')';
    }
}
