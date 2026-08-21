package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hy2 extends jy2 {
    public static final hy2 g;
    public final hd2 a;
    public final List b;
    public final int c;
    public final int d;
    public final gd2 e;
    public final gd2 f;

    static {
        List listX = p95.x(lg4.d);
        ed2 ed2Var = ed2.c;
        ed2 ed2Var2 = ed2.b;
        g = new hy2(hd2.b, listX, 0, 0, new gd2(ed2Var, ed2Var2, ed2Var2), null);
    }

    public hy2(hd2 hd2Var, List list, int i, int i2, gd2 gd2Var, gd2 gd2Var2) {
        this.a = hd2Var;
        this.b = list;
        this.c = i;
        this.d = i2;
        this.e = gd2Var;
        this.f = gd2Var2;
        if (hd2Var != hd2.z && i < 0) {
            e04.f(dw2.A(i, "Prepend insert defining placeholdersBefore must be > 0, but was "));
            throw null;
        }
        if (hd2Var != hd2.f && i2 < 0) {
            e04.f(dw2.A(i2, "Append insert defining placeholdersAfter must be > 0, but was "));
            throw null;
        }
        if (hd2Var == hd2.b && list.isEmpty()) {
            xe.k("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hy2)) {
            return false;
        }
        hy2 hy2Var = (hy2) obj;
        return this.a == hy2Var.a && this.b.equals(hy2Var.b) && this.c == hy2Var.c && this.d == hy2Var.d && this.e.equals(hy2Var.e) && n12.c(this.f, hy2Var.f);
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + ((((((this.b.hashCode() + (this.a.hashCode() * 31)) * 31) + this.c) * 31) + this.d) * 31)) * 31;
        gd2 gd2Var = this.f;
        return iHashCode + (gd2Var == null ? 0 : gd2Var.hashCode());
    }

    public final String toString() {
        List list = this.b;
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((lg4) it.next()).b.size();
        }
        int i = this.c;
        String strValueOf = i != -1 ? String.valueOf(i) : "none";
        int i2 = this.d;
        String strValueOf2 = i2 != -1 ? String.valueOf(i2) : "none";
        StringBuilder sb = new StringBuilder("PageEvent.Insert for ");
        sb.append(this.a);
        sb.append(", with ");
        sb.append(size);
        sb.append(" items (\n                    |   first item: ");
        lg4 lg4Var = (lg4) d70.e0(list);
        sb.append(lg4Var != null ? d70.e0(lg4Var.b) : null);
        sb.append("\n                    |   last item: ");
        lg4 lg4Var2 = (lg4) d70.l0(list);
        sb.append(lg4Var2 != null ? d70.l0(lg4Var2.b) : null);
        sb.append("\n                    |   placeholdersBefore: ");
        sb.append(strValueOf);
        sb.append("\n                    |   placeholdersAfter: ");
        sb.append(strValueOf2);
        sb.append("\n                    |   sourceLoadStates: ");
        sb.append(this.e);
        sb.append("\n                    ");
        String string = sb.toString();
        gd2 gd2Var = this.f;
        if (gd2Var != null) {
            string = string + "|   mediatorLoadStates: " + gd2Var + '\n';
        }
        return q44.c0(string.concat("|)"));
    }
}
