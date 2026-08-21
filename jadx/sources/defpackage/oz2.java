package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oz2 extends ke0 {
    public final int e;
    public final int f;
    public final int g;

    public oz2(int i, int i2, int i3) {
        this.e = i;
        this.f = i2;
        this.g = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof oz2)) {
            return false;
        }
        oz2 oz2Var = (oz2) obj;
        return this.e == oz2Var.e && this.f == oz2Var.f && this.g == oz2Var.g;
    }

    public final int hashCode() {
        return this.e + this.f + this.g;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PagingDataEvent.DropPrepend dropped ");
        int i = this.e;
        sb.append(i);
        sb.append(" items (\n                    |   dropCount: ");
        sb.append(i);
        sb.append("\n                    |   newPlaceholdersBefore: ");
        sb.append(this.f);
        sb.append("\n                    |   oldPlaceholdersBefore: ");
        sb.append(this.g);
        sb.append("\n                    |)\n                    |");
        return q44.c0(sb.toString());
    }
}
