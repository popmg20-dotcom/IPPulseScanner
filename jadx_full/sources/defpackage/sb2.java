package defpackage;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sb2 implements ListIterator, z72 {
    public int A;
    public final f1 X;
    public int f;
    public final /* synthetic */ int b = 0;
    public int z = -1;

    public sb2(ub2 ub2Var, int i) {
        this.X = ub2Var;
        this.f = i;
        this.A = ((AbstractList) ub2Var).modCount;
    }

    public void a() {
        if (((AbstractList) ((tb2) this.X).X).modCount != this.A) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i = this.b;
        f1 f1Var = this.X;
        switch (i) {
            case 0:
                a();
                tb2 tb2Var = (tb2) f1Var;
                int i2 = this.f;
                this.f = i2 + 1;
                tb2Var.add(i2, obj);
                this.z = -1;
                this.A = ((AbstractList) tb2Var).modCount;
                break;
            default:
                b();
                ub2 ub2Var = (ub2) f1Var;
                int i3 = this.f;
                this.f = i3 + 1;
                ub2Var.add(i3, obj);
                this.z = -1;
                this.A = ((AbstractList) ub2Var).modCount;
                break;
        }
    }

    public void b() {
        if (((AbstractList) ((ub2) this.X)).modCount != this.A) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        int i = this.b;
        f1 f1Var = this.X;
        switch (i) {
            case 0:
                if (this.f < ((tb2) f1Var).z) {
                }
                break;
            default:
                if (this.f < ((ub2) f1Var).f) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.b) {
            case 0:
                if (this.f > 0) {
                }
                break;
            default:
                if (this.f > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i = this.b;
        f1 f1Var = this.X;
        switch (i) {
            case 0:
                a();
                int i2 = this.f;
                tb2 tb2Var = (tb2) f1Var;
                if (i2 >= tb2Var.z) {
                    vp1.g();
                } else {
                    this.f = i2 + 1;
                    this.z = i2;
                }
                break;
            default:
                b();
                int i3 = this.f;
                ub2 ub2Var = (ub2) f1Var;
                if (i3 >= ub2Var.f) {
                    vp1.g();
                } else {
                    this.f = i3 + 1;
                    this.z = i3;
                }
                break;
        }
        return null;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.b) {
        }
        return this.f;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        int i = this.b;
        f1 f1Var = this.X;
        switch (i) {
            case 0:
                a();
                int i2 = this.f;
                if (i2 <= 0) {
                    vp1.g();
                } else {
                    int i3 = i2 - 1;
                    this.f = i3;
                    this.z = i3;
                    tb2 tb2Var = (tb2) f1Var;
                }
                break;
            default:
                b();
                int i4 = this.f;
                if (i4 <= 0) {
                    vp1.g();
                } else {
                    int i5 = i4 - 1;
                    this.f = i5;
                    this.z = i5;
                }
                break;
        }
        return null;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i;
        switch (this.b) {
            case 0:
                i = this.f;
                break;
            default:
                i = this.f;
                break;
        }
        return i - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i = this.b;
        f1 f1Var = this.X;
        switch (i) {
            case 0:
                tb2 tb2Var = (tb2) f1Var;
                a();
                int i2 = this.z;
                if (i2 == -1) {
                    xe.q("Call next() or previous() before removing element from the iterator.");
                } else {
                    tb2Var.b(i2);
                    this.f = this.z;
                    this.z = -1;
                    this.A = ((AbstractList) tb2Var).modCount;
                }
                break;
            default:
                ub2 ub2Var = (ub2) f1Var;
                b();
                int i3 = this.z;
                if (i3 == -1) {
                    xe.q("Call next() or previous() before removing element from the iterator.");
                } else {
                    ub2Var.b(i3);
                    this.f = this.z;
                    this.z = -1;
                    this.A = ((AbstractList) ub2Var).modCount;
                }
                break;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        int i = this.b;
        f1 f1Var = this.X;
        switch (i) {
            case 0:
                a();
                int i2 = this.z;
                if (i2 == -1) {
                    xe.q("Call next() or previous() before replacing element from the iterator.");
                } else {
                    ((tb2) f1Var).set(i2, obj);
                }
                break;
            default:
                b();
                int i3 = this.z;
                if (i3 == -1) {
                    xe.q("Call next() or previous() before replacing element from the iterator.");
                } else {
                    ((ub2) f1Var).set(i3, obj);
                }
                break;
        }
    }

    public sb2(tb2 tb2Var, int i) {
        this.X = tb2Var;
        this.f = i;
        this.A = ((AbstractList) tb2Var).modCount;
    }
}
