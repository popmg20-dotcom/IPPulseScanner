package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zz2 extends a03 implements Iterable, z72 {
    public final int A;
    public final int X;
    public final List b;
    public final Object f;
    public final Object z;

    static {
        new zz2(g41.b, null, null, 0, 0);
    }

    public zz2(List list, Integer num, Integer num2, int i, int i2) {
        this.b = list;
        this.f = num;
        this.z = num2;
        this.A = i;
        this.X = i2;
        if (i != Integer.MIN_VALUE && i < 0) {
            xe.k("itemsBefore cannot be negative");
            throw null;
        }
        if (i2 == Integer.MIN_VALUE || i2 >= 0) {
            return;
        }
        xe.k("itemsAfter cannot be negative");
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zz2)) {
            return false;
        }
        zz2 zz2Var = (zz2) obj;
        return this.b.equals(zz2Var.b) && n12.c(this.f, zz2Var.f) && n12.c(this.z, zz2Var.z) && this.A == zz2Var.A && this.X == zz2Var.X;
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        Object obj = this.f;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.z;
        return ((((iHashCode2 + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.A) * 31) + this.X;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.b.listIterator();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LoadResult.Page(\n                    |   data size: ");
        List list = this.b;
        sb.append(list.size());
        sb.append("\n                    |   first Item: ");
        sb.append(d70.e0(list));
        sb.append("\n                    |   last Item: ");
        sb.append(d70.l0(list));
        sb.append("\n                    |   nextKey: ");
        sb.append(this.z);
        sb.append("\n                    |   prevKey: ");
        sb.append(this.f);
        sb.append("\n                    |   itemsBefore: ");
        sb.append(this.A);
        sb.append("\n                    |   itemsAfter: ");
        sb.append(this.X);
        sb.append("\n                    |) ");
        return q44.c0(sb.toString());
    }
}
