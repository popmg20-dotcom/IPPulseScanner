package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class be implements Iterator, Iterable {
    public final Object[] b;
    public int f = 0;

    public be(Object[] objArr) {
        this.b = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f < this.b.length;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f;
        Object[] objArr = this.b;
        if (i < objArr.length) {
            this.f = i + 1;
            return objArr[i];
        }
        vp1.g();
        return null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this;
    }
}
