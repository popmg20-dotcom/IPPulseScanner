package defpackage;

import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x80 {
    public final String a;
    public final Set b;
    public final Set c;
    public final int d;
    public final int e;
    public final n90 f;
    public final Set g;

    public x80(String str, Set set, Set set2, int i, int i2, n90 n90Var, Set set3) {
        this.a = str;
        this.b = DesugarCollections.unmodifiableSet(set);
        this.c = DesugarCollections.unmodifiableSet(set2);
        this.d = i;
        this.e = i2;
        this.f = n90Var;
        this.g = DesugarCollections.unmodifiableSet(set3);
    }

    public static x80 a(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(fc3.a(cls));
        for (Class cls2 : clsArr) {
            ez4.k(cls2, "Null interface");
            hashSet.add(fc3.a(cls2));
        }
        return new x80(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new w80(1, obj), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.b.toArray()) + ">{" + this.d + ", type=" + this.e + ", deps=" + Arrays.toString(this.c.toArray()) + "}";
    }
}
