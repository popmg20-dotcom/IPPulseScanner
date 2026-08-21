package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class z44 {
    public static final z44 d = new z44(-1, 0, 0);
    public final int a;
    public final int b;
    public final int c;

    public z44(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z44) {
            z44 z44Var = (z44) obj;
            if (this.c == z44Var.c && this.a == z44Var.a && this.b == z44Var.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.c + 31) * 31) + this.a) * 31) + this.b;
    }
}
