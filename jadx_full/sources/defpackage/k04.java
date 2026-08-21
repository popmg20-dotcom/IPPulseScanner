package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k04 {
    public static final k04 c = new k04("LOCALE", 0);
    public static final k04 d = new k04("LEFT_TO_RIGHT", 1);
    public static final k04 e = new k04("RIGHT_TO_LEFT", 2);
    public static final k04 f = new k04("TOP_TO_BOTTOM", 3);
    public static final k04 g = new k04("BOTTOM_TO_TOP", 4);
    public final String a;
    public final int b;

    public k04(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k04)) {
            return false;
        }
        k04 k04Var = (k04) obj;
        return this.a.equals(k04Var.a) && this.b == k04Var.b;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return this.a;
    }
}
