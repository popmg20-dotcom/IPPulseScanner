package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l54 extends sy1 {
    public final Drawable a;
    public final ry1 b;
    public final pi0 c;
    public final tj2 d;
    public final String e;
    public final boolean f;
    public final boolean g;

    public l54(Drawable drawable, ry1 ry1Var, pi0 pi0Var, tj2 tj2Var, String str, boolean z, boolean z2) {
        this.a = drawable;
        this.b = ry1Var;
        this.c = pi0Var;
        this.d = tj2Var;
        this.e = str;
        this.f = z;
        this.g = z2;
    }

    @Override // defpackage.sy1
    public final Drawable a() {
        return this.a;
    }

    @Override // defpackage.sy1
    public final ry1 b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l54)) {
            return false;
        }
        l54 l54Var = (l54) obj;
        return n12.c(this.a, l54Var.a) && n12.c(this.b, l54Var.b) && this.c == l54Var.c && n12.c(this.d, l54Var.d) && n12.c(this.e, l54Var.e) && this.f == l54Var.f && this.g == l54Var.g;
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
        tj2 tj2Var = this.d;
        int iHashCode2 = (iHashCode + (tj2Var != null ? tj2Var.hashCode() : 0)) * 31;
        String str = this.e;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + (this.f ? 1231 : 1237)) * 31) + (this.g ? 1231 : 1237);
    }
}
