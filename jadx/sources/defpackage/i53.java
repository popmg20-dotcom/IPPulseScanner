package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i53 extends AbstractMap implements ConcurrentMap, Serializable, j$.util.concurrent.ConcurrentMap {
    public static final int F0;
    public static final int G0;
    public final AtomicLong A;
    public final AtomicReferenceArray A0;
    public final AtomicReference B0;
    public transient d53 C0;
    public transient f53 D0;
    public transient d53 E0;
    public final AtomicLong X;
    public final ReentrantLock Y;
    public final ConcurrentLinkedQueue Z;
    public final ConcurrentHashMap b;
    public final long[] f;
    public final AtomicLongArray y0;
    public final kb2 z;
    public final AtomicLongArray z0;

    static {
        int iMin = Math.min(4, 1 << (32 - Integer.numberOfLeadingZeros(Runtime.getRuntime().availableProcessors() - 1)));
        F0 = iMin;
        G0 = iMin - 1;
    }

    public i53(x43 x43Var) {
        int i = x43Var.a;
        this.X = new AtomicLong(Math.min(x43Var.c, 9223372034707292160L));
        this.b = new ConcurrentHashMap(x43Var.b, 0.75f, i);
        this.Y = new ReentrantLock();
        this.A = new AtomicLong();
        this.z = new kb2();
        this.Z = new ConcurrentLinkedQueue();
        this.B0 = new AtomicReference(b53.b);
        int i2 = F0;
        this.f = new long[i2];
        this.y0 = new AtomicLongArray(i2);
        this.z0 = new AtomicLongArray(i2);
        this.A0 = new AtomicReferenceArray(i2 * 16);
    }

    public final void a(e53 e53Var) {
        int id = ((int) Thread.currentThread().getId()) & G0;
        AtomicLongArray atomicLongArray = this.y0;
        long j = atomicLongArray.get(id);
        atomicLongArray.lazySet(id, 1 + j);
        this.A0.lazySet((id * 16) + ((int) (15 & j)), e53Var);
        if (((b53) this.B0.get()).a(j - this.z0.get(id) < 4)) {
            g();
        }
    }

    public final void b(Runnable runnable) {
        this.Z.add(runnable);
        this.B0.lazySet(b53.f);
        g();
    }

    public final void c() {
        int i;
        Runnable runnable;
        e53 e53Var;
        int id = (int) Thread.currentThread().getId();
        int i2 = F0 + id;
        while (true) {
            i = 0;
            if (id >= i2) {
                break;
            }
            int i3 = G0 & id;
            long j = this.y0.get(i3);
            while (i < 8) {
                long[] jArr = this.f;
                int i4 = (i3 * 16) + ((int) (jArr[i3] & 15));
                AtomicReferenceArray atomicReferenceArray = this.A0;
                e53 e53Var2 = (e53) atomicReferenceArray.get(i4);
                if (e53Var2 == null) {
                    break;
                }
                atomicReferenceArray.lazySet(i4, null);
                kb2 kb2Var = this.z;
                if (kb2Var.b(e53Var2) && e53Var2 != (e53Var = kb2Var.f)) {
                    e53 e53Var3 = e53Var2.f;
                    e53 e53Var4 = e53Var2.z;
                    if (e53Var3 == null) {
                        kb2Var.b = e53Var4;
                    } else {
                        e53Var3.z = e53Var4;
                        e53Var2.f = null;
                    }
                    if (e53Var4 == null) {
                        kb2Var.f = e53Var3;
                        e53Var = e53Var3;
                    } else {
                        e53Var4.f = e53Var3;
                        e53Var2.z = null;
                    }
                    kb2Var.f = e53Var2;
                    if (e53Var == null) {
                        kb2Var.b = e53Var2;
                    } else {
                        e53Var.z = e53Var2;
                        e53Var2.f = e53Var;
                    }
                }
                jArr[i3] = jArr[i3] + 1;
                i++;
            }
            this.z0.lazySet(i3, j);
            id++;
        }
        while (i < 16 && (runnable = (Runnable) this.Z.poll()) != null) {
            runnable.run();
            i++;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        AtomicReferenceArray atomicReferenceArray = this.A0;
        ReentrantLock reentrantLock = this.Y;
        reentrantLock.lock();
        while (true) {
            try {
                e53 e53VarPollFirst = this.z.pollFirst();
                if (e53VarPollFirst == null) {
                    break;
                }
                this.b.remove(e53VarPollFirst.b, e53VarPollFirst);
                e(e53VarPollFirst);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        for (int i = 0; i < atomicReferenceArray.length(); i++) {
            atomicReferenceArray.lazySet(i, null);
        }
        while (true) {
            Runnable runnable = (Runnable) this.Z.poll();
            if (runnable == null) {
                reentrantLock.unlock();
                return;
            }
            runnable.run();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$compute(this, obj, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return ConcurrentMap.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.b.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        obj.getClass();
        Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            if (((e53) it.next()).a().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        e53 e53VarPollFirst;
        while (this.A.get() > this.X.get() && (e53VarPollFirst = this.z.pollFirst()) != null) {
            this.b.remove(e53VarPollFirst.b, e53VarPollFirst);
            e(e53VarPollFirst);
        }
    }

    public final void e(e53 e53Var) {
        g53 g53Var;
        do {
            g53Var = (g53) e53Var.get();
        } while (!e53Var.compareAndSet(g53Var, new g53(0, g53Var.b)));
        AtomicLong atomicLong = this.A;
        atomicLong.lazySet(atomicLong.get() - ((long) Math.abs(g53Var.a)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        d53 d53Var = this.E0;
        if (d53Var != null) {
            return d53Var;
        }
        d53 d53Var2 = new d53(this, 0);
        this.E0 = d53Var2;
        return d53Var2;
    }

    public final Object f(Object obj, Object obj2, boolean z) {
        g53 g53Var;
        obj.getClass();
        obj2.getClass();
        g53 g53Var2 = new g53(1, obj2);
        e53 e53Var = new e53(obj, g53Var2);
        while (true) {
            e53 e53Var2 = (e53) this.b.putIfAbsent(e53Var.b, e53Var);
            if (e53Var2 == null) {
                b(new tm1(9, this, e53Var, false));
                return null;
            }
            if (z) {
                a(e53Var2);
                return e53Var2.a();
            }
            do {
                g53Var = (g53) e53Var2.get();
                if (!g53Var.a()) {
                    break;
                }
            } while (!e53Var2.compareAndSet(g53Var, g53Var2));
            int i = 1 - g53Var.a;
            if (i == 0) {
                a(e53Var2);
            } else {
                b(new ec(this, e53Var2, i, 3));
            }
            return g53Var.b;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        ConcurrentMap.CC.$default$forEach(this, biConsumer);
    }

    public final void g() {
        y43 y43Var = b53.b;
        a53 a53Var = b53.z;
        AtomicReference atomicReference = this.B0;
        ReentrantLock reentrantLock = this.Y;
        if (reentrantLock.tryLock()) {
            try {
                atomicReference.lazySet(a53Var);
                c();
                while (!atomicReference.compareAndSet(a53Var, y43Var) && atomicReference.get() == a53Var) {
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                while (!atomicReference.compareAndSet(a53Var, y43Var) && atomicReference.get() == a53Var) {
                }
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        e53 e53Var = (e53) this.b.get(obj);
        if (e53Var == null) {
            return null;
        }
        a(e53Var);
        return e53Var.a();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return ConcurrentMap.CC.$default$getOrDefault(this, obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        d53 d53Var = this.C0;
        if (d53Var != null) {
            return d53Var;
        }
        d53 d53Var2 = new d53(this, 1);
        this.C0 = d53Var2;
        return d53Var2;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        return f(obj, obj2, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object putIfAbsent(Object obj, Object obj2) {
        return f(obj, obj2, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final boolean remove(Object obj, Object obj2) {
        boolean zCompareAndSet;
        ConcurrentHashMap concurrentHashMap = this.b;
        e53 e53Var = (e53) concurrentHashMap.get(obj);
        boolean z = false;
        if (e53Var != null && obj2 != null) {
            g53 g53Var = (g53) e53Var.get();
            while (true) {
                Object obj3 = g53Var.b;
                if (obj2 != obj3 && !obj3.equals(obj2)) {
                    return false;
                }
                if (g53Var.a()) {
                    zCompareAndSet = e53Var.compareAndSet(g53Var, new g53(-g53Var.a, g53Var.b));
                } else {
                    zCompareAndSet = false;
                }
                if (!zCompareAndSet) {
                    g53Var = (g53) e53Var.get();
                    if (!g53Var.a()) {
                        break;
                    }
                } else if (concurrentHashMap.remove(obj, e53Var)) {
                    b(new um1(7, this, e53Var, z));
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        g53 g53Var;
        obj.getClass();
        obj2.getClass();
        obj3.getClass();
        g53 g53Var2 = new g53(1, obj3);
        e53 e53Var = (e53) this.b.get(obj);
        if (e53Var != null) {
            do {
                g53Var = (g53) e53Var.get();
                if (g53Var.a()) {
                    Object obj4 = g53Var.b;
                    if (obj2 != obj4 && !obj4.equals(obj2)) {
                        return false;
                    }
                }
            } while (!e53Var.compareAndSet(g53Var, g53Var2));
            int i = 1 - g53Var.a;
            if (i == 0) {
                a(e53Var);
                return true;
            }
            b(new ec(this, e53Var, i, 3));
            return true;
        }
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        ConcurrentMap.CC.$default$replaceAll(this, biFunction);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.b.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        f53 f53Var = this.D0;
        if (f53Var != null) {
            return f53Var;
        }
        f53 f53Var2 = new f53(this);
        this.D0 = f53Var2;
        return f53Var2;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        g53 g53Var;
        obj.getClass();
        obj2.getClass();
        g53 g53Var2 = new g53(1, obj2);
        e53 e53Var = (e53) this.b.get(obj);
        if (e53Var == null) {
            return null;
        }
        do {
            g53Var = (g53) e53Var.get();
            if (!g53Var.a()) {
                return null;
            }
        } while (!e53Var.compareAndSet(g53Var, g53Var2));
        int i = 1 - g53Var.a;
        if (i == 0) {
            a(e53Var);
        } else {
            b(new ec(this, e53Var, i, 3));
        }
        return g53Var.b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        g53 g53Var;
        e53 e53Var = (e53) this.b.remove(obj);
        if (e53Var == null) {
            return null;
        }
        do {
            g53Var = (g53) e53Var.get();
            if (!g53Var.a()) {
                break;
            }
        } while (!e53Var.compareAndSet(g53Var, new g53(-g53Var.a, g53Var.b)));
        b(new um1(7, (Object) this, (Object) e53Var, false));
        return e53Var.a();
    }
}
