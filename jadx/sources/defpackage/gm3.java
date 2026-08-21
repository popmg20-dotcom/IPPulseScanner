package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gm3 {
    public final hm3 a;
    public final hm3 b;
    public final Throwable c;

    public /* synthetic */ gm3(hm3 hm3Var, ta0 ta0Var, Throwable th, int i) {
        this(hm3Var, (i & 2) != 0 ? null : ta0Var, (i & 4) != 0 ? null : th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gm3)) {
            return false;
        }
        gm3 gm3Var = (gm3) obj;
        return n12.c(this.a, gm3Var.a) && n12.c(this.b, gm3Var.b) && n12.c(this.c, gm3Var.c);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        hm3 hm3Var = this.b;
        int iHashCode2 = (iHashCode + (hm3Var == null ? 0 : hm3Var.hashCode())) * 31;
        Throwable th = this.c;
        return iHashCode2 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "ConnectResult(plan=" + this.a + ", nextPlan=" + this.b + ", throwable=" + this.c + ')';
    }

    public gm3(hm3 hm3Var, hm3 hm3Var2, Throwable th) {
        this.a = hm3Var;
        this.b = hm3Var2;
        this.c = th;
    }
}
