package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t54 implements s54, Serializable {
    public transient Object A;
    public final transient Object b = new Object();
    public final jf4 f;
    public volatile transient boolean z;

    public t54(jf4 jf4Var) {
        this.f = jf4Var;
    }

    @Override // defpackage.s54
    public final Object get() {
        if (!this.z) {
            synchronized (this.b) {
                try {
                    if (!this.z) {
                        Object obj = this.f.get();
                        this.A = obj;
                        this.z = true;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.A;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (this.z) {
            obj = "<supplier that returned " + this.A + ">";
        } else {
            obj = this.f;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
