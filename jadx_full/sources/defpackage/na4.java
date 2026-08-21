package defpackage;

import java.util.AbstractSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class na4 {
    public final String a;
    public final Map b;
    public final Set c;
    public final Set d;

    public na4(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        abstractSet.getClass();
        this.a = str;
        this.b = map;
        this.c = abstractSet;
        this.d = abstractSet2;
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof na4)) {
            return false;
        }
        na4 na4Var = (na4) obj;
        if (!this.a.equals(na4Var.a) || !this.b.equals(na4Var.b) || !this.c.equals(na4Var.c)) {
            return false;
        }
        Set set2 = this.d;
        if (set2 == null || (set = na4Var.d) == null) {
            return true;
        }
        return set2.equals(set);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n            |TableInfo {\n            |    name = '");
        sb.append(this.a);
        sb.append("',\n            |    columns = {");
        sb.append(r25.w(d70.u0(this.b.values(), new e1(21))));
        sb.append("\n            |    foreignKeys = {");
        sb.append(r25.w(this.c));
        sb.append("\n            |    indices = {");
        Set set = this.d;
        sb.append(r25.w(set != null ? d70.u0(set, new e1(22)) : g41.b));
        sb.append("\n            |}\n        ");
        return q44.c0(sb.toString());
    }
}
