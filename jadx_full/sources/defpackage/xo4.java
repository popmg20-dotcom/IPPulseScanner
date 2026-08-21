package defpackage;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xo4 implements Comparable {
    public static final xo4 Y;
    public final String A;
    public final n84 X = new n84(new fn(25, this));
    public final int b;
    public final int f;
    public final int z;

    static {
        new xo4(0, 0, 0, "");
        Y = new xo4(0, 1, 0, "");
        new xo4(1, 0, 0, "");
    }

    public xo4(int i, int i2, int i3, String str) {
        this.b = i;
        this.f = i2;
        this.z = i3;
        this.A = str;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        xo4 xo4Var = (xo4) obj;
        xo4Var.getClass();
        Object value = this.X.getValue();
        value.getClass();
        Object value2 = xo4Var.X.getValue();
        value2.getClass();
        return ((BigInteger) value).compareTo((BigInteger) value2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof xo4)) {
            return false;
        }
        xo4 xo4Var = (xo4) obj;
        return this.b == xo4Var.b && this.f == xo4Var.f && this.z == xo4Var.z;
    }

    public final int hashCode() {
        return ((((527 + this.b) * 31) + this.f) * 31) + this.z;
    }

    public final String toString() {
        String str = this.A;
        String strConcat = !p44.x0(str) ? "-".concat(str) : "";
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append('.');
        sb.append(this.f);
        sb.append('.');
        return fw.w(strConcat, sb, this.z);
    }
}
