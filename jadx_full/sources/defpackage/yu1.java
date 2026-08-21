package defpackage;

import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yu1 {
    public final String a;
    public final TreeMap b;

    public yu1(String str, TreeMap treeMap) {
        str.getClass();
        this.a = str;
        this.b = treeMap;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yu1)) {
            return false;
        }
        yu1 yu1Var = (yu1) obj;
        return n12.c(this.a, yu1Var.a) && this.b.equals(yu1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "HttpStringResponse(body=" + this.a + ", headers=" + this.b + ")";
    }
}
