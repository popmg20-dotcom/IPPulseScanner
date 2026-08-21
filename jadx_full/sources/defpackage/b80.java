package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b80 {
    public final fd2 a;
    public final fd2 b;
    public final fd2 c;
    public final gd2 d;
    public final gd2 e;

    public b80(fd2 fd2Var, fd2 fd2Var2, fd2 fd2Var3, gd2 gd2Var, gd2 gd2Var2) {
        fd2Var.getClass();
        fd2Var2.getClass();
        fd2Var3.getClass();
        gd2Var.getClass();
        this.a = fd2Var;
        this.b = fd2Var2;
        this.c = fd2Var3;
        this.d = gd2Var;
        this.e = gd2Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b80.class != obj.getClass()) {
            return false;
        }
        b80 b80Var = (b80) obj;
        return n12.c(this.a, b80Var.a) && n12.c(this.b, b80Var.b) && n12.c(this.c, b80Var.c) && n12.c(this.d, b80Var.d) && n12.c(this.e, b80Var.e);
    }

    public final int hashCode() {
        int iHashCode = (this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31;
        gd2 gd2Var = this.e;
        return iHashCode + (gd2Var != null ? gd2Var.hashCode() : 0);
    }

    public final String toString() {
        return "CombinedLoadStates(refresh=" + this.a + ", prepend=" + this.b + ", append=" + this.c + ", source=" + this.d + ", mediator=" + this.e + ')';
    }
}
