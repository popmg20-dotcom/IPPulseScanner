package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b03 {
    public final List a;
    public final Integer b;
    public final ue2 c;
    public final int d;

    public b03(List list, Integer num, ue2 ue2Var, int i) {
        this.a = list;
        this.b = num;
        this.c = ue2Var;
        this.d = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b03)) {
            return false;
        }
        b03 b03Var = (b03) obj;
        return this.a.equals(b03Var.a) && n12.c(this.b, b03Var.b) && this.c == b03Var.c && this.d == b03Var.d;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode();
        Integer num = this.b;
        return this.c.hashCode() + iHashCode + (num != null ? num.hashCode() : 0) + this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PagingState(pages=");
        sb.append(this.a);
        sb.append(", anchorPosition=");
        sb.append(this.b);
        sb.append(", config=");
        sb.append(this.c);
        sb.append(", leadingPlaceholderCount=");
        return ha0.p(sb, this.d, ')');
    }
}
