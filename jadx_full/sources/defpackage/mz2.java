package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mz2 extends ke0 {
    public final int e;
    public final ArrayList f;
    public final int g;
    public final int h;

    public mz2(int i, ArrayList arrayList, int i2, int i3) {
        this.e = i;
        this.f = arrayList;
        this.g = i2;
        this.h = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof mz2)) {
            return false;
        }
        mz2 mz2Var = (mz2) obj;
        return this.e == mz2Var.e && this.f.equals(mz2Var.f) && this.g == mz2Var.g && this.h == mz2Var.h;
    }

    public final int hashCode() {
        return this.f.hashCode() + this.e + this.g + this.h;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PagingDataEvent.Append loaded ");
        ArrayList arrayList = this.f;
        sb.append(arrayList.size());
        sb.append(" items (\n                    |   startIndex: ");
        sb.append(this.e);
        sb.append("\n                    |   first item: ");
        sb.append(d70.e0(arrayList));
        sb.append("\n                    |   last item: ");
        sb.append(d70.l0(arrayList));
        sb.append("\n                    |   newPlaceholdersBefore: ");
        sb.append(this.g);
        sb.append("\n                    |   oldPlaceholdersBefore: ");
        sb.append(this.h);
        sb.append("\n                    |)\n                    |");
        return q44.c0(sb.toString());
    }
}
