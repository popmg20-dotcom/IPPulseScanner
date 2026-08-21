package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h83 {
    public final float a;
    public final jc1 b;

    public h83(float f, jc1 jc1Var) {
        jc1Var.getClass();
        this.a = f;
        this.b = jc1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h83)) {
            return false;
        }
        h83 h83Var = (h83) obj;
        return Float.compare(this.a, h83Var.a) == 0 && n12.c(this.b, h83Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Float.floatToIntBits(this.a) * 31);
    }

    public final String toString() {
        return "ProgressableFeature(progress=" + this.a + ", feature=" + this.b + ')';
    }
}
