package defpackage;

import j$.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class t24 {
    public static final t24 j = new t24(null, wn3.b, 0, 0, false, null, null, null);
    public int a;
    public int b;
    public final int c;
    public final t24 d;
    public final wn3 e;
    public final boolean f;
    public final String g;
    public final qt h;
    public final qt i;

    public t24(t24 t24Var, wn3 wn3Var, int i, int i2, boolean z, String str, qt qtVar, qt qtVar2) {
        this.d = t24Var;
        this.e = wn3Var;
        this.c = t24Var != null ? 1 + t24Var.c : 1;
        this.a = i;
        this.b = i2;
        this.f = z;
        this.g = str;
        this.h = qtVar;
        this.i = qtVar2;
    }

    public final void a(ArrayList arrayList) {
        t24 t24Var = this.d;
        if (t24Var != null) {
            t24Var.a(arrayList);
        }
        arrayList.add("(" + this.e + ", " + this.h + ", " + this.i + ")");
    }

    public final t24 b(qt qtVar) {
        if (this.i == qtVar) {
            return this;
        }
        int i = this.a;
        int i2 = this.b;
        t24 t24Var = this.d;
        t24Var.getClass();
        return new t24(t24Var, this.e, i, i2, this.f, this.g, this.h, qtVar);
    }

    public final t24 c(String str) {
        String str2 = this.g;
        if (str2 != null && str2.equals(str)) {
            return this;
        }
        return new t24(this.d, this.e, this.a, this.b, this.f, str, this.h, this.i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t24)) {
            return false;
        }
        t24 t24Var = (t24) obj;
        if (this == t24Var) {
            return true;
        }
        t24 t24Var2 = this;
        for (t24 t24Var3 = t24Var; t24Var2 != t24Var3 && (t24Var2 != null || t24Var3 != null); t24Var3 = t24Var3.d) {
            if (t24Var2 == null || t24Var3 == null || t24Var2.c != t24Var3.c || !Objects.equals(t24Var2.e, t24Var3.e) || !Objects.equals(t24Var2.g, t24Var3.g)) {
                return false;
            }
            t24Var2 = t24Var2.d;
        }
        qt qtVar = this.i;
        for (qt qtVar2 = t24Var.i; qtVar != qtVar2; qtVar2 = (qt) qtVar2.c) {
            if (qtVar == null && qtVar2 == null) {
                return true;
            }
            if (qtVar == null || qtVar2 == null || qtVar.b != qtVar2.b || !Objects.equals((String) ((v62) qtVar.d).z, (String) ((v62) qtVar2.d).z)) {
                return false;
            }
            qtVar = (qt) qtVar.c;
        }
        return true;
    }

    public final int hashCode() {
        return ((Objects.hashCode(this.e) + ((Objects.hashCode(this.d) + ((Objects.hashCode(this.g) + ((Objects.hashCode(this.i) + 31) * 31)) * 31)) * 31)) * 31) + this.c;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        a(arrayList);
        StringBuilder sb = new StringBuilder("[");
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb2.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb2.append((CharSequence) ", ");
            }
        }
        sb.append(sb2.toString());
        sb.append(']');
        return sb.toString();
    }
}
