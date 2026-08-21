package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s32 {
    public final int a;
    public final n93 b;
    public final String c;
    public final boolean d;

    public s32(int i, n93 n93Var, String str, int i2) {
        str = (i2 & 4) != 0 ? null : str;
        boolean z = (i2 & 8) == 0;
        this.a = i;
        this.b = n93Var;
        this.c = str;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s32)) {
            return false;
        }
        s32 s32Var = (s32) obj;
        return this.a == s32Var.a && this.b.equals(s32Var.b) && n12.c(this.c, s32Var.c) && this.d == s32Var.d;
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a * 31)) * 31;
        String str = this.c;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.d ? 1231 : 1237);
    }

    public final String toString() {
        return "DnsQueryResult(strategyType=" + this.a + ", strategy=" + this.b + ", dohUrl=" + this.c + ", useMdns=" + this.d + ")";
    }
}
