package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jh {
    public final List a;
    public final List b;
    public final int c;
    public final int d;
    public final int e;

    public jh(List list, List list2, int i, int i2, int i3) {
        this.a = list;
        this.b = list2;
        this.c = i;
        this.d = i2;
        this.e = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof jh) {
            jh jhVar = (jh) obj;
            List list = jhVar.a;
            List list2 = this.a;
            if (list2 != null ? list2.equals(list) : list == null) {
                List list3 = jhVar.b;
                List list4 = this.b;
                if (list4 != null ? list4.equals(list3) : list3 == null) {
                    if (this.c == jhVar.c && this.d == jhVar.d && this.e == jhVar.e) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        List list = this.a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        List list2 = this.b;
        return this.e ^ (((((((list2 != null ? list2.hashCode() : 0) ^ iHashCode) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BestSizesAndMaxFpsForConfigs{bestSizes=");
        sb.append(this.a);
        sb.append(", bestSizesForStreamUseCase=");
        sb.append(this.b);
        sb.append(", maxFpsForBestSizes=");
        sb.append(this.c);
        sb.append(", maxFpsForStreamUseCase=");
        sb.append(this.d);
        sb.append(", maxFpsForAllSizes=");
        return fw.w("}", sb, this.e);
    }
}
