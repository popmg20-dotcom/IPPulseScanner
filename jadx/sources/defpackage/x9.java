package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x9 {
    public final int a;
    public final w7 b;
    public final fb4 c;
    public final String d;

    public x9(w7 w7Var, fb4 fb4Var, String str) {
        this.b = w7Var;
        this.c = fb4Var;
        this.d = str;
        this.a = Arrays.hashCode(new Object[]{w7Var, fb4Var, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x9)) {
            return false;
        }
        x9 x9Var = (x9) obj;
        return gb4.I(this.b, x9Var.b) && gb4.I(this.c, x9Var.c) && gb4.I(this.d, x9Var.d);
    }

    public final int hashCode() {
        return this.a;
    }
}
