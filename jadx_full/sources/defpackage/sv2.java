package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class sv2 {
    public static final sv2 c = new sv2(0, 0);
    public final int a;
    public final int b;

    public sv2(int i, int i2) {
        this.a = Math.max(i, 0);
        this.b = Math.max(i2, 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof sv2) {
            sv2 sv2Var = (sv2) obj;
            if (this.b == sv2Var.b && this.a == sv2Var.a) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.b + 31) * 31) + this.a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{, \"start\": ");
        int i = this.a;
        sb.append(i);
        sb.append(", \"end\": ");
        int i2 = this.b;
        sb.append(i2);
        sb.append(", \"length\": ");
        sb.append(i2 - i);
        sb.append("}");
        return sb.toString();
    }
}
