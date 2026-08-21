package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u54 implements s54 {
    public static final e04 A = new e04(7);
    public final Object b = new Object();
    public volatile s54 f;
    public Object z;

    public u54(jf4 jf4Var) {
        this.f = jf4Var;
    }

    @Override // defpackage.s54
    public final Object get() {
        s54 s54Var = this.f;
        e04 e04Var = A;
        if (s54Var != e04Var) {
            synchronized (this.b) {
                try {
                    if (this.f != e04Var) {
                        Object obj = this.f.get();
                        this.z = obj;
                        this.f = e04Var;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.z;
    }

    public final String toString() {
        Object obj = this.f;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (obj == A) {
            obj = "<supplier that returned " + this.z + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
