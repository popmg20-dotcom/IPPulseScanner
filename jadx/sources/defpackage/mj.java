package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mj {
    public final sv3 a;
    public final v92 b;
    public final ha1 c;

    public mj(sv3 sv3Var, v92 v92Var, ha1 ha1Var) {
        this.a = sv3Var;
        this.b = v92Var;
        this.c = ha1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mj)) {
            return false;
        }
        mj mjVar = (mj) obj;
        return this.a == mjVar.a && this.b == mjVar.b && this.c == mjVar.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "BackupStores(settingsStore=" + this.a + ", metadataStore=" + this.b + ", profileStore=" + this.c + ")";
    }
}
