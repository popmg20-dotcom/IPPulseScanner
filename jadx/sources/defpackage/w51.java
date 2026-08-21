package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w51 extends sy1 {
    public final Drawable a;
    public final ry1 b;
    public final Throwable c;

    public w51(Drawable drawable, ry1 ry1Var, Throwable th) {
        this.a = drawable;
        this.b = ry1Var;
        this.c = th;
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
        if (!(obj instanceof w51)) {
            return false;
        }
        w51 w51Var = (w51) obj;
        return n12.c(this.a, w51Var.a) && n12.c(this.b, w51Var.b) && this.c.equals(w51Var.c);
    }

    public final int hashCode() {
        Drawable drawable = this.a;
        int iHashCode = drawable != null ? drawable.hashCode() : 0;
        return this.c.hashCode() + ((this.b.hashCode() + (iHashCode * 31)) * 31);
    }
}
