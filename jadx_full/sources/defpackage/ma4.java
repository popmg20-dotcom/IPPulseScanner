package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ma4 {
    public final String a;
    public final boolean b;
    public final List c;
    public final List d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.ArrayList] */
    public ma4(String str, boolean z, List list, List list2) {
        str.getClass();
        this.a = str;
        this.b = z;
        this.c = list;
        this.d = list2;
        if (list2.isEmpty()) {
            int size = list.size();
            list2 = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                list2.add("ASC");
            }
        }
        this.d = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ma4) {
            ma4 ma4Var = (ma4) obj;
            String str = ma4Var.a;
            if (this.b == ma4Var.b && this.c.equals(ma4Var.c) && n12.c(this.d, ma4Var.d)) {
                String str2 = this.a;
                return w44.j0(str2, "index_", false) ? w44.j0(str, "index_", false) : str2.equals(str);
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        return this.d.hashCode() + ((this.c.hashCode() + ((((w44.j0(str, "index_", false) ? -1184239155 : str.hashCode()) * 31) + (this.b ? 1 : 0)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n            |Index {\n            |   name = '");
        sb.append(this.a);
        sb.append("',\n            |   unique = '");
        sb.append(this.b);
        sb.append("',\n            |   columns = {");
        q44.a0(d70.j0(this.c, ",", null, null, null, 62));
        q44.a0("},");
        xl4 xl4Var = xl4.a;
        sb.append(xl4Var);
        sb.append("\n            |   orders = {");
        q44.a0(d70.j0(this.d, ",", null, null, null, 62));
        q44.a0(" }");
        sb.append(xl4Var);
        sb.append("\n            |}\n        ");
        return q44.a0(q44.c0(sb.toString()));
    }
}
