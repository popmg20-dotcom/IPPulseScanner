package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m04 {
    public static final m04 c = new m04(0.0f, "expandContainers");
    public static final m04 d = xb5.H(0.5f);
    public static final m04 e = new m04(-1.0f, "hinge");
    public final String a;
    public final float b;

    public m04(float f, String str) {
        this.a = str;
        this.b = f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m04)) {
            return false;
        }
        m04 m04Var = (m04) obj;
        return this.b == m04Var.b && this.a.equals(m04Var.a);
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.b) * 31) + this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}
