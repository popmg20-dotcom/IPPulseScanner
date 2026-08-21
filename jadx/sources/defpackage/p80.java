package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class p80 {
    public final Object a;
    public final t00 b;
    public final em1 c;
    public final Object d;
    public final Throwable e;

    public /* synthetic */ p80(Object obj, t00 t00Var, em1 em1Var, Throwable th, int i) {
        this(obj, (i & 2) != 0 ? null : t00Var, (i & 4) != 0 ? null : em1Var, (Object) null, (i & 16) != 0 ? null : th);
    }

    public static p80 a(p80 p80Var, t00 t00Var, Throwable th, int i) {
        Object obj = p80Var.a;
        if ((i & 2) != 0) {
            t00Var = p80Var.b;
        }
        t00 t00Var2 = t00Var;
        em1 em1Var = p80Var.c;
        Object obj2 = p80Var.d;
        if ((i & 16) != 0) {
            th = p80Var.e;
        }
        return new p80(obj, t00Var2, em1Var, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p80)) {
            return false;
        }
        p80 p80Var = (p80) obj;
        return n12.c(this.a, p80Var.a) && n12.c(this.b, p80Var.b) && n12.c(this.c, p80Var.c) && n12.c(this.d, p80Var.d) && n12.c(this.e, p80Var.e);
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        t00 t00Var = this.b;
        int iHashCode2 = (iHashCode + (t00Var == null ? 0 : t00Var.hashCode())) * 31;
        em1 em1Var = this.c;
        int iHashCode3 = (iHashCode2 + (em1Var == null ? 0 : em1Var.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public p80(Object obj, t00 t00Var, em1 em1Var, Object obj2, Throwable th) {
        this.a = obj;
        this.b = t00Var;
        this.c = em1Var;
        this.d = obj2;
        this.e = th;
    }
}
