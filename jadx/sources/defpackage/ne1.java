package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ne1 implements Iterator, z72 {
    public final /* synthetic */ oe1 A;
    public final Iterator b;
    public int f = -1;
    public Object z;

    public ne1(oe1 oe1Var) {
        this.A = oe1Var;
        this.b = oe1Var.a.iterator();
    }

    public final void a() {
        Object next;
        oe1 oe1Var;
        do {
            Iterator it = this.b;
            if (!it.hasNext()) {
                this.f = 0;
                return;
            } else {
                next = it.next();
                oe1Var = this.A;
            }
        } while (((Boolean) oe1Var.c.g(next)).booleanValue() != oe1Var.b);
        this.z = next;
        this.f = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f == -1) {
            a();
        }
        return this.f == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f == -1) {
            a();
        }
        if (this.f == 0) {
            vp1.g();
            return null;
        }
        Object obj = this.z;
        this.z = null;
        this.f = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
