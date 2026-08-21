package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qz2 extends ke0 {
    public final ez2 e;
    public final ez2 f;

    public qz2(ez2 ez2Var, ez2 ez2Var2) {
        ez2Var2.getClass();
        this.e = ez2Var;
        this.f = ez2Var2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof qz2)) {
            return false;
        }
        ez2 ez2Var = this.e;
        int i = ez2Var.c;
        qz2 qz2Var = (qz2) obj;
        ez2 ez2Var2 = qz2Var.f;
        ez2 ez2Var3 = qz2Var.e;
        if (i != ez2Var3.c || ez2Var.d != ez2Var3.d || ez2Var.f() != ez2Var3.f() || ez2Var.b != ez2Var3.b) {
            return false;
        }
        ez2 ez2Var4 = this.f;
        return ez2Var4.c == ez2Var2.c && ez2Var4.d == ez2Var2.d && ez2Var4.f() == ez2Var2.f() && ez2Var4.b == ez2Var2.b;
    }

    public final int hashCode() {
        return this.f.hashCode() + this.e.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PagingDataEvent.Refresh loaded newList\n                    |   newList (\n                    |       placeholdersBefore: ");
        ez2 ez2Var = this.e;
        sb.append(ez2Var.c);
        sb.append("\n                    |       placeholdersAfter: ");
        sb.append(ez2Var.d);
        sb.append("\n                    |       size: ");
        sb.append(ez2Var.f());
        sb.append("\n                    |       dataCount: ");
        sb.append(ez2Var.b);
        sb.append("\n                    |   )\n                    |   previousList (\n                    |       placeholdersBefore: ");
        ez2 ez2Var2 = this.f;
        sb.append(ez2Var2.c);
        sb.append("\n                    |       placeholdersAfter: ");
        sb.append(ez2Var2.d);
        sb.append("\n                    |       size: ");
        sb.append(ez2Var2.f());
        sb.append("\n                    |       dataCount: ");
        sb.append(ez2Var2.b);
        sb.append("\n                    |   )\n                    |");
        return q44.c0(sb.toString());
    }
}
