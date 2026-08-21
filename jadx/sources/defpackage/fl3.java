package defpackage;

import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fl3 implements ListIterator, z72 {
    public final ListIterator b;
    public final /* synthetic */ gl3 f;

    public fl3(gl3 gl3Var, int i) {
        this.f = gl3Var;
        this.b = gl3Var.b.listIterator(d70.r0(i, gl3Var));
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        ListIterator listIterator = this.b;
        listIterator.add(obj);
        listIterator.previous();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.b.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return (this.f.size() - 1) - this.b.previousIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return this.b.next();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return (this.f.size() - 1) - this.b.nextIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        this.b.remove();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        this.b.set(obj);
    }
}
