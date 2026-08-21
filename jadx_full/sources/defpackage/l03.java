package defpackage;

import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class l03 {
    public final String a;
    public final List b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;

    public l03(String str, ArrayList arrayList, int i, int i2, String str2, String str3) {
        this.a = str;
        this.b = arrayList;
        this.c = i;
        this.d = i2;
        this.e = str2;
        this.f = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l03) {
            l03 l03Var = (l03) obj;
            if (this.d == l03Var.d && this.c == l03Var.c && Objects.equals(this.f, l03Var.f) && Objects.equals(this.e, l03Var.e) && Objects.equals(this.b, l03Var.b) && Objects.equals(this.a, l03Var.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a) + ((Objects.hashCode(this.b) + ((Objects.hashCode(this.e) + ((Objects.hashCode(this.f) + ((((this.d + 31) * 31) + this.c) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ParsedThemeRule [scope=");
        sb.append(this.a);
        sb.append(", parentScopes=");
        sb.append(this.b);
        sb.append(", index=");
        sb.append(this.c);
        sb.append(", fontStyle=");
        sb.append(this.d);
        sb.append(", foreground=");
        sb.append(this.e);
        sb.append(", background=");
        return fw.y(sb, this.f, "]");
    }
}
