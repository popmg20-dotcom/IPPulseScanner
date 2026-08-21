package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class fo1 implements Iterator, z72 {
    public Object b;
    public int f = -2;
    public final /* synthetic */ go1 z;

    public fo1(go1 go1Var) {
        this.z = go1Var;
    }

    public final void a() {
        Object objG;
        int i = this.f;
        go1 go1Var = this.z;
        if (i == -2) {
            objG = ((pl1) go1Var.c).a();
        } else {
            am1 am1Var = go1Var.b;
            Object obj = this.b;
            obj.getClass();
            objG = am1Var.g(obj);
        }
        this.b = objG;
        this.f = objG == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f < 0) {
            a();
        }
        return this.f == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f < 0) {
            a();
        }
        if (this.f == 0) {
            vp1.g();
            return null;
        }
        Object obj = this.b;
        obj.getClass();
        this.f = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
