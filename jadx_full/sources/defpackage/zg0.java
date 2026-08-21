package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zg0 {
    public final fc3 a;
    public final boolean b;

    public zg0(fc3 fc3Var, boolean z) {
        this.a = fc3Var;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zg0) {
            zg0 zg0Var = (zg0) obj;
            if (zg0Var.a.equals(this.a) && zg0Var.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.b).hashCode() ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }
}
