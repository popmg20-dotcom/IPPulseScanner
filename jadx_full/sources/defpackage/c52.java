package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c52 {
    public static final c52 c = new c52(0, 0);
    public final int a;
    public final int b;

    public c52(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != c52.class) {
            return false;
        }
        c52 c52Var = (c52) obj;
        return c52Var.a == this.a && c52Var.b == this.b;
    }

    public final int hashCode() {
        return this.b + this.a;
    }

    public final String toString() {
        return this == c ? "EMPTY" : String.format("(enabled=0x%x,disabled=0x%x)", Integer.valueOf(this.a), Integer.valueOf(this.b));
    }
}
