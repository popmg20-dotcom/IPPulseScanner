package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lg4 {
    public static final lg4 d = new lg4(0, g41.b);
    public final int[] a;
    public final List b;
    public final int c;

    public lg4(int i, List list) {
        this.a = new int[]{i};
        this.b = list;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || lg4.class != obj.getClass()) {
            return false;
        }
        lg4 lg4Var = (lg4) obj;
        return Arrays.equals(this.a, lg4Var.a) && this.b.equals(lg4Var.b) && this.c == lg4Var.c;
    }

    public final int hashCode() {
        return (((this.b.hashCode() + (Arrays.hashCode(this.a) * 31)) * 31) + this.c) * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransformablePage(originalPageOffsets=");
        sb.append(Arrays.toString(this.a));
        sb.append(", data=");
        sb.append(this.b);
        sb.append(", hintOriginalPageOffset=");
        return fw.w(", hintOriginalIndices=null)", sb, this.c);
    }
}
