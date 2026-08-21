package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x21 {
    public static final x21 c = new x21(0.0f, "ALWAYS_ALLOW");
    public static final x21 d = new x21(-1.0f, "ALWAYS_DISALLOW");
    public final String a;
    public final float b;

    public x21(float f, String str) {
        this.a = str;
        this.b = f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x21)) {
            return false;
        }
        x21 x21Var = (x21) obj;
        return this.b == x21Var.b && this.a.equals(x21Var.a);
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.b) * 31) + this.a.hashCode();
    }

    public final String toString() {
        return fw.x(new StringBuilder("EmbeddingAspectRatio("), this.a, ')');
    }
}
