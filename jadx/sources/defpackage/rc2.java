package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rc2 extends sc2 {
    public final di0 a;

    public rc2(di0 di0Var) {
        this.a = di0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || rc2.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((rc2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (rc2.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Success {mOutputData=" + this.a + '}';
    }
}
