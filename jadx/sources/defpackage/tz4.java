package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tz4 {
    public final x9 a;
    public final ic1 b;

    public /* synthetic */ tz4(x9 x9Var, ic1 ic1Var) {
        this.a = x9Var;
        this.b = ic1Var;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof tz4)) {
            return false;
        }
        tz4 tz4Var = (tz4) obj;
        return gb4.I(this.a, tz4Var.a) && gb4.I(this.b, tz4Var.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        v62 v62Var = new v62(this);
        v62Var.o(this.a, "key");
        v62Var.o(this.b, "feature");
        return v62Var.toString();
    }
}
