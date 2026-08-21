package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c53 implements Iterator {
    public final /* synthetic */ i53 A;
    public final /* synthetic */ int b;
    public final Iterator f;
    public Object z;

    public c53(i53 i53Var, int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.A = i53Var;
                this.f = i53Var.b.values().iterator();
                break;
            case 2:
                this.A = i53Var;
                this.f = i53Var.b.keySet().iterator();
                break;
            default:
                this.A = i53Var;
                this.f = i53Var.b.values().iterator();
                break;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.b) {
        }
        return this.f.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        Iterator it = this.f;
        switch (i) {
            case 0:
                this.z = (e53) it.next();
                return new h53(this.A, (e53) this.z);
            case 1:
                e53 e53Var = (e53) it.next();
                this.z = e53Var;
                return e53Var.a();
            default:
                Object next = it.next();
                this.z = next;
                return next;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z;
        int i = this.b;
        i53 i53Var = this.A;
        switch (i) {
            case 0:
                e53 e53Var = (e53) this.z;
                z = e53Var != null;
                int i2 = i53.F0;
                if (!z) {
                    st4.g();
                } else {
                    i53Var.remove(e53Var.b);
                    this.z = null;
                }
                break;
            case 1:
                e53 e53Var2 = (e53) this.z;
                z = e53Var2 != null;
                int i3 = i53.F0;
                if (!z) {
                    st4.g();
                } else {
                    i53Var.remove(e53Var2.b);
                    this.z = null;
                }
                break;
            default:
                Object obj = this.z;
                z = obj != null;
                int i4 = i53.F0;
                if (!z) {
                    st4.g();
                } else {
                    i53Var.remove(obj);
                    this.z = null;
                }
                break;
        }
    }
}
