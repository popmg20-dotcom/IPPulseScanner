package io.sentry;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g7 implements Queue, Collection, Serializable {
    public final i b;
    public final io.sentry.util.a f = new io.sentry.util.a();

    public g7(i iVar) {
        this.b = iVar;
    }

    @Override // java.util.Queue, java.util.Collection
    public final boolean add(Object obj) {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            boolean zAdd = this.b.add(obj);
            aVar.close();
            return zAdd;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            boolean zAddAll = this.b.addAll(collection);
            aVar.close();
            return zAddAll;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final void clear() {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            this.b.clear();
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            boolean zContains = this.b.contains(obj);
            aVar.close();
            return zContains;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            boolean zContainsAll = this.b.containsAll(collection);
            aVar.close();
            return zContainsAll;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public final Object element() {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            Object objElement = this.b.element();
            aVar.close();
            return objElement;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            boolean zEquals = this.b.equals(obj);
            aVar.close();
            return zEquals;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final int hashCode() {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            int iHashCode = this.b.hashCode();
            aVar.close();
            return iHashCode;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            boolean zIsEmpty = this.b.isEmpty();
            aVar.close();
            return zIsEmpty;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.b.iterator();
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            boolean zOffer = this.b.offer(obj);
            aVar.close();
            return zOffer;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public final Object peek() {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            Object objPeek = this.b.peek();
            aVar.close();
            return objPeek;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public final Object poll() {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            Object objPoll = this.b.poll();
            aVar.close();
            return objPoll;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public final Object remove() {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            Object objRemove = this.b.remove();
            aVar.close();
            return objRemove;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            boolean zRemoveAll = this.b.removeAll(collection);
            aVar.close();
            return zRemoveAll;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            boolean zRetainAll = this.b.retainAll(collection);
            aVar.close();
            return zRetainAll;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final int size() {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            int size = this.b.size();
            aVar.close();
            return size;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            Object[] array = this.b.toArray();
            aVar.close();
            return array;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final String toString() {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            String string = this.b.toString();
            aVar.close();
            return string;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            boolean zRemove = this.b.remove(obj);
            aVar.close();
            return zRemove;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            Object[] array = this.b.toArray(objArr);
            aVar.close();
            return array;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
