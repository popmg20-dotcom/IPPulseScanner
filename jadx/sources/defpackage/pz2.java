package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pz2 extends ke0 {
    public final ArrayList e;
    public final int f;
    public final int g;

    public pz2(ArrayList arrayList, int i, int i2) {
        this.e = arrayList;
        this.f = i;
        this.g = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof pz2)) {
            return false;
        }
        pz2 pz2Var = (pz2) obj;
        return this.e.equals(pz2Var.e) && this.f == pz2Var.f && this.g == pz2Var.g;
    }

    public final int hashCode() {
        return this.e.hashCode() + this.f + this.g;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PagingDataEvent.Prepend loaded ");
        ArrayList arrayList = this.e;
        sb.append(arrayList.size());
        sb.append(" items (\n                    |   first item: ");
        sb.append(d70.e0(arrayList));
        sb.append("\n                    |   last item: ");
        sb.append(d70.l0(arrayList));
        sb.append("\n                    |   newPlaceholdersBefore: ");
        sb.append(this.f);
        sb.append("\n                    |   oldPlaceholdersBefore: ");
        sb.append(this.g);
        sb.append("\n                    |)\n                    |");
        return q44.c0(sb.toString());
    }
}
