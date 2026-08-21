package defpackage;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kb2 extends AbstractCollection implements Deque {
    public e53 b;
    public e53 f;

    public final void a() {
        if (isEmpty()) {
            vp1.g();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
    public final boolean add(Object obj) {
        return offerLast((e53) obj);
    }

    @Override // java.util.Deque
    public final void addFirst(Object obj) {
        e53 e53Var = (e53) obj;
        if (b(e53Var)) {
            s53.d();
            return;
        }
        e53 e53Var2 = this.b;
        this.b = e53Var;
        if (e53Var2 == null) {
            this.f = e53Var;
        } else {
            e53Var2.f = e53Var;
            e53Var.z = e53Var2;
        }
    }

    @Override // java.util.Deque
    public final void addLast(Object obj) {
        if (offerLast((e53) obj)) {
            return;
        }
        s53.d();
    }

    public final boolean b(e53 e53Var) {
        return (e53Var.f == null && e53Var.z == null && e53Var != this.b) ? false : true;
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final boolean offerLast(e53 e53Var) {
        if (b(e53Var)) {
            return false;
        }
        e53 e53Var2 = this.f;
        this.f = e53Var;
        if (e53Var2 == null) {
            this.b = e53Var;
            return true;
        }
        e53Var2.z = e53Var;
        e53Var.f = e53Var2;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        e53 e53Var = this.b;
        while (e53Var != null) {
            e53 e53Var2 = e53Var.z;
            e53Var.f = null;
            e53Var.z = null;
            e53Var = e53Var2;
        }
        this.f = null;
        this.b = null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final boolean contains(Object obj) {
        return (obj instanceof e53) && b((e53) obj);
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final e53 pollFirst() {
        if (isEmpty()) {
            return null;
        }
        e53 e53Var = this.b;
        e53 e53Var2 = e53Var.z;
        e53Var.z = null;
        this.b = e53Var2;
        if (e53Var2 == null) {
            this.f = null;
            return e53Var;
        }
        e53Var2.f = null;
        return e53Var;
    }

    @Override // java.util.Deque
    public final Iterator descendingIterator() {
        return new jb2(this.f, 1);
    }

    @Override // java.util.Deque, java.util.Queue
    public final Object element() {
        a();
        return this.b;
    }

    @Override // java.util.Deque
    public final Object getFirst() {
        a();
        return this.b;
    }

    @Override // java.util.Deque
    public final Object getLast() {
        a();
        return this.f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.b == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Deque
    public final Iterator iterator() {
        return new jb2(this.b, 0);
    }

    @Override // java.util.Deque, java.util.Queue
    public final boolean offer(Object obj) {
        return offerLast((e53) obj);
    }

    @Override // java.util.Deque
    public final boolean offerFirst(Object obj) {
        e53 e53Var = (e53) obj;
        if (b(e53Var)) {
            return false;
        }
        e53 e53Var2 = this.b;
        this.b = e53Var;
        if (e53Var2 == null) {
            this.f = e53Var;
            return true;
        }
        e53Var2.f = e53Var;
        e53Var.z = e53Var2;
        return true;
    }

    @Override // java.util.Deque, java.util.Queue
    public final Object peek() {
        return this.b;
    }

    @Override // java.util.Deque
    public final Object peekFirst() {
        return this.b;
    }

    @Override // java.util.Deque
    public final Object peekLast() {
        return this.f;
    }

    @Override // java.util.Deque, java.util.Queue
    public final Object poll() {
        return pollFirst();
    }

    @Override // java.util.Deque
    public final Object pollLast() {
        if (isEmpty()) {
            return null;
        }
        e53 e53Var = this.f;
        e53 e53Var2 = e53Var.f;
        e53Var.f = null;
        this.f = e53Var2;
        if (e53Var2 == null) {
            this.b = null;
            return e53Var;
        }
        e53Var2.z = null;
        return e53Var;
    }

    @Override // java.util.Deque
    public final Object pop() {
        a();
        return pollFirst();
    }

    @Override // java.util.Deque
    public final void push(Object obj) {
        e53 e53Var = (e53) obj;
        if (b(e53Var)) {
            s53.d();
            return;
        }
        e53 e53Var2 = this.b;
        this.b = e53Var;
        if (e53Var2 == null) {
            this.f = e53Var;
        } else {
            e53Var2.f = e53Var;
            e53Var.z = e53Var2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final boolean remove(Object obj) {
        if (!(obj instanceof e53)) {
            return false;
        }
        e53 e53Var = (e53) obj;
        if (!b(e53Var)) {
            return false;
        }
        e53 e53Var2 = e53Var.f;
        e53 e53Var3 = e53Var.z;
        if (e53Var2 == null) {
            this.b = e53Var3;
        } else {
            e53Var2.z = e53Var3;
            e53Var.f = null;
        }
        if (e53Var3 == null) {
            this.f = e53Var2;
            return true;
        }
        e53Var3.f = e53Var2;
        e53Var.z = null;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Deque
    public final Object removeFirst() {
        a();
        return pollFirst();
    }

    @Override // java.util.Deque
    public final boolean removeFirstOccurrence(Object obj) {
        return remove(obj);
    }

    @Override // java.util.Deque
    public final Object removeLast() {
        a();
        if (isEmpty()) {
            return null;
        }
        e53 e53Var = this.f;
        e53 e53Var2 = e53Var.f;
        e53Var.f = null;
        this.f = e53Var2;
        if (e53Var2 == null) {
            this.b = null;
            return e53Var;
        }
        e53Var2.z = null;
        return e53Var;
    }

    @Override // java.util.Deque
    public final boolean removeLastOccurrence(Object obj) {
        return remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final int size() {
        int i = 0;
        for (e53 e53Var = this.b; e53Var != null; e53Var = e53Var.z) {
            i++;
        }
        return i;
    }

    @Override // java.util.Deque, java.util.Queue
    public final Object remove() {
        a();
        return pollFirst();
    }
}
