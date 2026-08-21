package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n64 implements l83 {
    public static final k83 d = new k83("urn:ietf:params:xml:ns:caldav", "supported-calendar-component-set");
    public static final k83 e = new k83("urn:ietf:params:xml:ns:caldav", "allcomp");
    public static final k83 f = new k83("urn:ietf:params:xml:ns:caldav", "comp");
    public boolean a;
    public boolean b;
    public boolean c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n64)) {
            return false;
        }
        n64 n64Var = (n64) obj;
        return this.a == n64Var.a && this.b == n64Var.b && this.c == n64Var.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        boolean z = this.a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.b;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.c;
        return i2 + (z3 ? 1 : z3);
    }

    public final String toString() {
        return "SupportedCalendarComponentSet(supportsEvents=" + this.a + ", supportsTasks=" + this.b + ", supportsJournal=" + this.c + ')';
    }
}
