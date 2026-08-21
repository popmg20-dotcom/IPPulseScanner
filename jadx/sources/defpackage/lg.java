package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lg {
    public final int a;
    public final mg b;

    public lg(int i, mg mgVar) {
        if (i == 0) {
            zo2.n("Null type");
            throw null;
        }
        this.a = i;
        this.b = mgVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lg)) {
            return false;
        }
        lg lgVar = (lg) obj;
        if (!fw.e(this.a, lgVar.a)) {
            return false;
        }
        mg mgVar = lgVar.b;
        mg mgVar2 = this.b;
        return mgVar2 == null ? mgVar == null : mgVar2.equals(mgVar);
    }

    public final int hashCode() {
        int iG = (fw.G(this.a) ^ 1000003) * 1000003;
        mg mgVar = this.b;
        return (mgVar == null ? 0 : mgVar.hashCode()) ^ iG;
    }

    public final String toString() {
        return "CameraState{type=" + fw.I(this.a) + ", error=" + this.b + "}";
    }
}
