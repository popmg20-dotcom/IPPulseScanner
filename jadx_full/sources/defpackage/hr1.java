package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class hr1 {
    public static final bu d;
    public static final bu e;
    public static final bu f;
    public static final bu g;
    public static final bu h;
    public static final bu i;
    public final bu a;
    public final bu b;
    public final int c;

    static {
        bu buVar = bu.A;
        d = t60.n(":");
        e = t60.n(":status");
        f = t60.n(":method");
        g = t60.n(":path");
        h = t60.n(":scheme");
        i = t60.n(":authority");
    }

    public hr1(bu buVar, bu buVar2) {
        buVar.getClass();
        buVar2.getClass();
        this.a = buVar;
        this.b = buVar2;
        this.c = buVar2.d() + buVar.d() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hr1)) {
            return false;
        }
        hr1 hr1Var = (hr1) obj;
        return n12.c(this.a, hr1Var.a) && n12.c(this.b, hr1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return this.a.r() + ": " + this.b.r();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public hr1(String str, String str2) {
        this(t60.n(str), t60.n(str2));
        bu buVar = bu.A;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public hr1(bu buVar, String str) {
        this(buVar, t60.n(str));
        buVar.getClass();
        str.getClass();
        bu buVar2 = bu.A;
    }
}
