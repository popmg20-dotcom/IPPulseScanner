package defpackage;

import android.graphics.Insets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t02 {
    public static final t02 e = new t02(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public t02(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static t02 a(t02 t02Var, t02 t02Var2) {
        return c(Math.max(t02Var.a, t02Var2.a), Math.max(t02Var.b, t02Var2.b), Math.max(t02Var.c, t02Var2.c), Math.max(t02Var.d, t02Var2.d));
    }

    public static t02 b(t02 t02Var, t02 t02Var2) {
        return c(Math.min(t02Var.a, t02Var2.a), Math.min(t02Var.b, t02Var2.b), Math.min(t02Var.c, t02Var2.c), Math.min(t02Var.d, t02Var2.d));
    }

    public static t02 c(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new t02(i, i2, i3, i4);
    }

    public static t02 d(Insets insets) {
        return c(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets e() {
        return v9.n(this.a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t02.class != obj.getClass()) {
            return false;
        }
        t02 t02Var = (t02) obj;
        return this.d == t02Var.d && this.a == t02Var.a && this.c == t02Var.c && this.b == t02Var.b;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Insets{left=");
        sb.append(this.a);
        sb.append(", top=");
        sb.append(this.b);
        sb.append(", right=");
        sb.append(this.c);
        sb.append(", bottom=");
        return ha0.p(sb, this.d, '}');
    }
}
