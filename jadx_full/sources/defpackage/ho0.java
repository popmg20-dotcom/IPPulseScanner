package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ho0 {
    public final fc3 a;
    public final int b;
    public final int c;

    public ho0(fc3 fc3Var, int i, int i2) {
        this.a = fc3Var;
        this.b = i;
        this.c = i2;
    }

    public static ho0 a(Class cls) {
        return new ho0(1, 0, cls);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ho0)) {
            return false;
        }
        ho0 ho0Var = (ho0) obj;
        return this.a.equals(ho0Var.a) && this.b == ho0Var.b && this.c == ho0Var.c;
    }

    public final int hashCode() {
        return this.c ^ ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.a);
        sb.append(", type=");
        int i = this.b;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", injection=");
        int i2 = this.c;
        if (i2 == 0) {
            str = "direct";
        } else if (i2 == 1) {
            str = "provider";
        } else {
            if (i2 != 2) {
                xe.i(dw2.A(i2, "Unsupported injection: "));
                return null;
            }
            str = "deferred";
        }
        return fw.y(sb, str, "}");
    }

    public ho0(int i, int i2, Class cls) {
        this(fc3.a(cls), i, i2);
    }
}
