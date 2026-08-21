package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l81 {
    public final ArrayList a;
    public final int b;

    public l81(ArrayList arrayList, int i) {
        this.a = new ArrayList(arrayList);
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l81) {
            return this.a.equals(((l81) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "{ " + this.a + " }";
    }
}
