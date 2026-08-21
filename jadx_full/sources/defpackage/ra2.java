package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ra2 {
    public final qt a;
    public final int b;

    public ra2(qt qtVar, int i) {
        this.a = qtVar;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ra2)) {
            return false;
        }
        ra2 ra2Var = (ra2) obj;
        return this.b == ra2Var.b && this.a == ra2Var.a;
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.b * 31);
    }

    public final String toString() {
        Object[] objArr = {this.a, Integer.valueOf(this.b)};
        String[] strArrSplit = "a;b".length() == 0 ? new String[0] : "a;b".split(";");
        StringBuilder sb = new StringBuilder(ra2.class.getSimpleName());
        sb.append("[");
        for (int i = 0; i < strArrSplit.length; i++) {
            sb.append(strArrSplit[i]);
            sb.append("=");
            sb.append(objArr[i]);
            if (i != strArrSplit.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
