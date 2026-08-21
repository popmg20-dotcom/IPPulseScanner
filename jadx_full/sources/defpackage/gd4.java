package defpackage;

import j$.util.Objects;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gd4 {
    public int a;
    public final List b;
    public int c;
    public int d;
    public int e;

    public gd4(int i, List list, int i2, int i3, int i4) {
        this.a = i;
        this.b = list;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public final Object clone() {
        return new gd4(this.a, this.b, this.c, this.d, this.e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof gd4) {
            gd4 gd4Var = (gd4) obj;
            if (this.a == gd4Var.a && this.e == gd4Var.e && this.c == gd4Var.c && this.d == gd4Var.d && Objects.equals(this.b, gd4Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Objects.hashCode(this.b) + ((((((this.e + 31) * 31) + this.c) * 31) + this.d) * 31)) * 31) + this.a;
    }
}
