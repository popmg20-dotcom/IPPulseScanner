package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class aq2 extends vf2 {
    public final vp2 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq2(vp2 vp2Var) {
        super(16);
        vp2Var.getClass();
        this.Z = vp2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && aq2.class == obj.getClass() && n12.c(this.Z, ((aq2) obj).Z);
    }

    public final int hashCode() {
        return this.Z.hashCode() - 31;
    }

    @Override // defpackage.vf2
    public final String toString() {
        return "InProgress(latestEvent=" + this.Z + ", direction=-1)";
    }
}
