package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g62 extends y42 {
    public final pb2 b;

    public g62() {
        e1 e1Var = pb2.z0;
        this.b = new pb2(false);
    }

    public final void e(String str, y42 y42Var) {
        this.b.put(str, y42Var);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof g62) && ((g62) obj).b.equals(this.b);
        }
        return true;
    }

    public final void f(String str, Boolean bool) {
        this.b.put(str, new k62(bool));
    }

    public final void g(String str, String str2) {
        this.b.put(str, str2 == null ? f62.b : new k62(str2));
    }

    public final y42 h(String str) {
        return (y42) this.b.get(str);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
