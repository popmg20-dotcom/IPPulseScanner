package defpackage;

import j$.util.Objects;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j60 {
    public static final i60 f = new i60(0);
    public static final i60 g = new i60(1);
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;

    public static int a(int i, List list) {
        if (list.isEmpty()) {
            return -1;
        }
        int size = list.size() - 1;
        int i2 = 0;
        int i3 = size;
        while (true) {
            if (i2 <= i3) {
                int i4 = ((i3 - i2) / 2) + i2;
                if (i4 >= 0 && i4 <= size) {
                    j60 j60Var = (j60) list.get(i4);
                    if (j60Var == null) {
                        int i5 = i4 - 1;
                        while (true) {
                            i4++;
                            if (i5 < i2 && i4 > i3) {
                                return -1;
                            }
                            if (i5 >= i2 && list.get(i5) != null) {
                                i4 = i5;
                                break;
                            }
                            if (i4 <= i3 && list.get(i4) != null) {
                                break;
                            }
                            i5--;
                        }
                        j60Var = (j60) list.get(i4);
                    }
                    int i6 = j60Var.c;
                    if (i6 <= i) {
                        if (i6 >= i) {
                            i2 = i4;
                            break;
                        }
                        i2 = i4 + 1;
                    } else {
                        i3 = i4 - 1;
                    }
                } else {
                    return -1;
                }
            } else {
                break;
            }
        }
        if (i2 < 0 || i2 > size) {
            return -1;
        }
        return i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j60.class != obj.getClass()) {
            return false;
        }
        j60 j60Var = (j60) obj;
        return this.a == j60Var.a && this.b == j60Var.b && this.c == j60Var.c && this.d == j60Var.d && this.e == j60Var.e;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Boolean.valueOf(this.e));
    }

    public final String toString() {
        return "BlockLine{startLine=" + this.a + ", startColumn=" + this.b + ", endLine=" + this.c + ", endColumn=" + this.d + ", toBottomOfEndLine=" + this.e + '}';
    }
}
