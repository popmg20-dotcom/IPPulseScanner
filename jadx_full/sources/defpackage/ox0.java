package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ox0 extends dd1 {
    public final Drawable a;
    public final boolean b;
    public final pi0 c;

    public ox0(Drawable drawable, boolean z, pi0 pi0Var) {
        this.a = drawable;
        this.b = z;
        this.c = pi0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ox0)) {
            return false;
        }
        ox0 ox0Var = (ox0) obj;
        return n12.c(this.a, ox0Var.a) && this.b == ox0Var.b && this.c == ox0Var.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + (((this.a.hashCode() * 31) + (this.b ? 1231 : 1237)) * 31);
    }
}
