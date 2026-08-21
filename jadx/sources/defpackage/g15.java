package defpackage;

import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g15 extends hm4 implements ListIterator {
    public final o15 A;
    public final int f;
    public int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g15(o15 o15Var, int i) {
        super(1);
        int size = o15Var.size();
        if (i < 0 || i > size) {
            s53.k(vf2.H(i, size, "index"));
            throw null;
        }
        this.f = size;
        this.z = i;
        this.A = o15Var;
    }

    public final Object a(int i) {
        return this.A.get(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.z < this.f;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.z > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            vp1.g();
            return null;
        }
        int i = this.z;
        this.z = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.z;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            vp1.g();
            return null;
        }
        int i = this.z - 1;
        this.z = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.z - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
