package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kg0 implements l83 {
    public static final k83 f = new k83("DAV:", "current-user-privilege-set");
    public static final k83 g = new k83("DAV:", "privilege");
    public static final k83 h = new k83("DAV:", "read");
    public static final k83 i = new k83("DAV:", "write");
    public static final k83 j = new k83("DAV:", "write-properties");
    public static final k83 k = new k83("DAV:", "write-content");
    public static final k83 l = new k83("DAV:", "bind");
    public static final k83 m = new k83("DAV:", "unbind");
    public static final k83 n = new k83("DAV:", "all");
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kg0)) {
            return false;
        }
        kg0 kg0Var = (kg0) obj;
        return this.a == kg0Var.a && this.b == kg0Var.b && this.c == kg0Var.c && this.d == kg0Var.d && this.e == kg0Var.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean z = this.a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        boolean z2 = this.b;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i3 = (i2 + r2) * 31;
        boolean z3 = this.c;
        ?? r22 = z3;
        if (z3) {
            r22 = 1;
        }
        int i4 = (i3 + r22) * 31;
        boolean z4 = this.d;
        ?? r23 = z4;
        if (z4) {
            r23 = 1;
        }
        int i5 = (i4 + r23) * 31;
        boolean z5 = this.e;
        return i5 + (z5 ? 1 : z5);
    }

    public final String toString() {
        return "CurrentUserPrivilegeSet(mayRead=" + this.a + ", mayWriteProperties=" + this.b + ", mayWriteContent=" + this.c + ", mayBind=" + this.d + ", mayUnbind=" + this.e + ')';
    }
}
