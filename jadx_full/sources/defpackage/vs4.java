package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vs4 {
    public final String a;
    public final boolean b;

    public vs4(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vs4)) {
            return false;
        }
        vs4 vs4Var = (vs4) obj;
        return n12.c(this.a, vs4Var.a) && this.b == vs4Var.b;
    }

    public final int hashCode() {
        String str = this.a;
        return ((str == null ? 0 : str.hashCode()) * 31) + (this.b ? 1231 : 1237);
    }

    public final String toString() {
        return "VpnStartedEvent(profileName=" + this.a + ", started=" + this.b + ")";
    }

    public /* synthetic */ vs4() {
        this(null, false);
    }
}
