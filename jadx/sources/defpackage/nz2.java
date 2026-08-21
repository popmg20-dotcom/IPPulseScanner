package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nz2 extends ke0 {
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    public nz2(int i, int i2, int i3, int i4) {
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof nz2)) {
            return false;
        }
        nz2 nz2Var = (nz2) obj;
        return this.e == nz2Var.e && this.f == nz2Var.f && this.g == nz2Var.g && this.h == nz2Var.h;
    }

    public final int hashCode() {
        return this.e + this.f + this.g + this.h;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PagingDataEvent.DropAppend dropped ");
        int i = this.f;
        sb.append(i);
        sb.append(" items (\n                    |   startIndex: ");
        sb.append(this.e);
        sb.append("\n                    |   dropCount: ");
        sb.append(i);
        sb.append("\n                    |   newPlaceholdersBefore: ");
        sb.append(this.g);
        sb.append("\n                    |   oldPlaceholdersBefore: ");
        sb.append(this.h);
        sb.append("\n                    |)\n                    |");
        return q44.c0(sb.toString());
    }
}
