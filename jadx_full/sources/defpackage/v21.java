package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v21 {
    public static final v21 b = new v21(0);
    public static final v21 c = new v21(1);
    public final int a;

    public v21(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v21) {
            return this.a == ((v21) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return this.a * 31;
    }

    public final String toString() {
        int i = this.a;
        return i != 0 ? i != 1 ? dw2.A(i, "Unknown value: ") : "JUMP_CUT" : "DEFAULT";
    }
}
