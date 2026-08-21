package defpackage;

import j$.util.DesugarCollections;
import java.util.Collection;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a02 {
    public final String a;
    public final LinkedHashMap b;

    public a02(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.a = str.trim();
        this.b = linkedHashMap;
    }

    public final void a(String str, String... strArr) {
        String strTrim = str.trim();
        synchronized (this.b) {
            if (((b02) this.b.get(strTrim)) == null) {
                b02 b02Var = new b02(strTrim, strArr);
                this.b.put(b02Var.a, b02Var);
            }
        }
    }

    public final Collection b() {
        return DesugarCollections.unmodifiableCollection(this.b.values());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a02.class != obj.getClass()) {
            return false;
        }
        a02 a02Var = (a02) obj;
        return this.a.equals(a02Var.a) && this.b.equals(a02Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }
}
