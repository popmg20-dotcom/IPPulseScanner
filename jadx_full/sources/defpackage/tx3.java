package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tx3 extends hz1 {
    public final transient Object Y;

    public tx3(Object obj) {
        super(0);
        this.Y = obj;
    }

    @Override // defpackage.bz1
    public final int a(Object[] objArr) {
        objArr[0] = this.Y;
        return 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.Y.equals(obj);
    }

    @Override // defpackage.hz1, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.Y.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new m22(this.Y);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.Y.toString() + ']';
    }
}
