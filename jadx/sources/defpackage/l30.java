package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class l30 {
    public static final k30 b = new k30();
    public final Object a;

    public /* synthetic */ l30(Object obj) {
        this.a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l30) {
            return n12.c(this.a, ((l30) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.a;
        return obj instanceof j30 ? ((j30) obj).toString() : ha0.m("Value(", obj, ')');
    }
}
