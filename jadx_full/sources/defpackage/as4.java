package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class as4 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public as4(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final int a(hd2 hd2Var) {
        hd2Var.getClass();
        int iOrdinal = hd2Var.ordinal();
        if (iOrdinal == 0) {
            xe.k("Cannot get presentedItems for loadType: REFRESH");
            return 0;
        }
        if (iOrdinal == 1) {
            return this.a;
        }
        if (iOrdinal == 2) {
            return this.b;
        }
        g.d();
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof as4)) {
            return false;
        }
        as4 as4Var = (as4) obj;
        return this.a == as4Var.a && this.b == as4Var.b && this.c == as4Var.c && this.d == as4Var.d;
    }

    public int hashCode() {
        return this.a + this.b + this.c + this.d;
    }
}
