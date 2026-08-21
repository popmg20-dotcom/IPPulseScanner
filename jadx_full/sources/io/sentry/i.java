package io.sentry;

import defpackage.e04;
import defpackage.xe;
import defpackage.zo2;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i extends AbstractCollection implements Queue, Serializable {
    public final int X;
    public final transient Object[] b;
    public transient int f = 0;
    public transient int z = 0;
    public transient boolean A = false;

    public i(int i) {
        if (i <= 0) {
            xe.k("The size must be greater than 0");
            throw null;
        }
        Object[] objArr = new Object[i];
        this.b = objArr;
        this.X = objArr.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        int i = 0;
        if (obj == null) {
            zo2.n("Attempted to add null object to queue");
            return false;
        }
        int size = size();
        int i2 = this.X;
        if (size == i2) {
            remove();
        }
        int i3 = this.z;
        int i4 = i3 + 1;
        this.z = i4;
        this.b[i3] = obj;
        if (i4 >= i2) {
            this.z = 0;
        } else {
            i = i4;
        }
        if (i == this.f) {
            this.A = true;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.A = false;
        this.f = 0;
        this.z = 0;
        Arrays.fill(this.b, (Object) null);
    }

    @Override // java.util.Queue
    public final Object element() {
        if (!isEmpty()) {
            return peek();
        }
        e04.h("queue is empty");
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new h(this);
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        add(obj);
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        if (isEmpty()) {
            return null;
        }
        return this.b[this.f];
    }

    @Override // java.util.Queue
    public final Object poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public final Object remove() {
        if (isEmpty()) {
            e04.h("queue is empty");
            return null;
        }
        int i = this.f;
        Object[] objArr = this.b;
        Object obj = objArr[i];
        if (obj != null) {
            int i2 = i + 1;
            this.f = i2;
            objArr[i] = null;
            if (i2 >= this.X) {
                this.f = 0;
            }
            this.A = false;
        }
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        int i = this.z;
        int i2 = this.f;
        int i3 = this.X;
        if (i < i2) {
            return (i3 - i2) + i;
        }
        if (i != i2) {
            return i - i2;
        }
        if (this.A) {
            return i3;
        }
        return 0;
    }
}
