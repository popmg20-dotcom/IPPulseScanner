package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class la4 {
    public final String a;
    public final String b;
    public final String c;
    public final List d;
    public final List e;

    public la4(String str, String str2, String str3, List list, List list2) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof la4)) {
            return false;
        }
        la4 la4Var = (la4) obj;
        if (n12.c(this.a, la4Var.a) && n12.c(this.b, la4Var.b) && n12.c(this.c, la4Var.c) && this.d.equals(la4Var.d)) {
            return this.e.equals(la4Var.e);
        }
        return false;
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.d.hashCode() + dw2.w(dw2.w(this.a.hashCode() * 31, 31, this.b), 31, this.c)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n            |ForeignKey {\n            |   referenceTable = '");
        sb.append(this.a);
        sb.append("',\n            |   onDelete = '");
        sb.append(this.b);
        sb.append("',\n            |   onUpdate = '");
        sb.append(this.c);
        sb.append("',\n            |   columnNames = {");
        q44.a0(d70.j0(d70.t0(this.d), ",", null, null, null, 62));
        q44.a0("},");
        xl4 xl4Var = xl4.a;
        sb.append(xl4Var);
        sb.append("\n            |   referenceColumnNames = {");
        q44.a0(d70.j0(d70.t0(this.e), ",", null, null, null, 62));
        q44.a0(" }");
        sb.append(xl4Var);
        sb.append("\n            |}\n        ");
        return q44.a0(q44.c0(sb.toString()));
    }
}
