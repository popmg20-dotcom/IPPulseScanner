package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gd2 {
    public static final gd2 d;
    public final fd2 a;
    public final fd2 b;
    public final fd2 c;

    static {
        ed2 ed2Var = ed2.c;
        d = new gd2(ed2Var, ed2Var, ed2Var);
    }

    public gd2(fd2 fd2Var, fd2 fd2Var2, fd2 fd2Var3) {
        this.a = fd2Var;
        this.b = fd2Var2;
        this.c = fd2Var3;
    }

    public static gd2 a(gd2 gd2Var, int i) {
        int i2 = i & 1;
        fd2 fd2Var = ed2.c;
        fd2 fd2Var2 = i2 != 0 ? gd2Var.a : fd2Var;
        fd2 fd2Var3 = (i & 2) != 0 ? gd2Var.b : fd2Var;
        if ((i & 4) != 0) {
            fd2Var = gd2Var.c;
        }
        return new gd2(fd2Var2, fd2Var3, fd2Var);
    }

    public final gd2 b(hd2 hd2Var) {
        hd2Var.getClass();
        int iOrdinal = hd2Var.ordinal();
        if (iOrdinal == 0) {
            return a(this, 6);
        }
        if (iOrdinal == 1) {
            return a(this, 5);
        }
        if (iOrdinal == 2) {
            return a(this, 3);
        }
        g.d();
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gd2)) {
            return false;
        }
        gd2 gd2Var = (gd2) obj;
        return this.a.equals(gd2Var.a) && this.b.equals(gd2Var.b) && this.c.equals(gd2Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "LoadStates(refresh=" + this.a + ", prepend=" + this.b + ", append=" + this.c + ')';
    }
}
