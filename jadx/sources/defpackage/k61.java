package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k61 {
    public final k61 c;
    public final l61[][] e = new l61[5][];
    public boolean f = true;
    public final HashMap a = new HashMap();
    public final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    public final Vector d = new Vector();

    public k61(k61 k61Var) {
        this.c = k61Var;
        if (k61Var != null) {
            k61Var.d.add(this);
        }
    }

    public final int a(p60 p60Var) {
        int i;
        LinkedList linkedList;
        l61[] l61VarArr;
        k61 k61Var;
        if (!this.f) {
            return p60Var.a;
        }
        j61 j61VarB = b(p60Var.getClass());
        j61VarB.a.readLock().lock();
        try {
            int size = j61VarB.b.size();
            synchronized (this) {
                int i2 = 0;
                while (true) {
                    try {
                        l61[][] l61VarArr2 = this.e;
                        linkedList = null;
                        if (i2 >= l61VarArr2.length) {
                            l61VarArr = null;
                            break;
                        }
                        l61VarArr = l61VarArr2[i2];
                        if (l61VarArr != null && l61VarArr.length >= size) {
                            l61VarArr2[i2] = null;
                            break;
                        }
                        i2++;
                    } finally {
                    }
                }
            }
            if (l61VarArr == null) {
                l61VarArr = new l61[size];
            }
            j61VarB.b.toArray(l61VarArr);
            try {
                id0 id0Var = new id0();
                id0Var.b = false;
                LinkedList linkedList2 = null;
                for (int i3 = 0; i3 < size; i3++) {
                    try {
                        if ((p60Var.a & 1) != 0) {
                            break;
                        }
                        l61 l61Var = l61VarArr[i3];
                        l61Var.a(p60Var, id0Var);
                        if (id0Var.b) {
                            if (linkedList2 == null) {
                                linkedList2 = new LinkedList();
                            }
                            linkedList2.add(l61Var);
                        }
                        id0Var.b = false;
                    } catch (Throwable th) {
                        th = th;
                        linkedList = linkedList2;
                        if (linkedList != null) {
                            j61VarB.a.writeLock().lock();
                            try {
                                j61VarB.b.removeAll(linkedList);
                            } finally {
                            }
                        }
                        c(l61VarArr);
                        throw th;
                    }
                }
                if (linkedList2 != null) {
                    j61VarB.a.writeLock().lock();
                    try {
                        j61VarB.b.removeAll(linkedList2);
                    } finally {
                    }
                }
                c(l61VarArr);
                for (i = 0; i < this.d.size() && (p60Var.a & 1) == 0; i++) {
                    try {
                        k61Var = (k61) this.d.get(i);
                    } catch (IndexOutOfBoundsException unused) {
                        k61Var = null;
                    }
                    if (k61Var != null) {
                        k61Var.a(p60Var);
                    }
                }
                return p60Var.a;
            } catch (Throwable th2) {
                th = th2;
            }
        } finally {
            j61VarB.a.readLock().unlock();
        }
    }

    public final j61 b(Class cls) {
        HashMap map = this.a;
        ReentrantReadWriteLock reentrantReadWriteLock = this.b;
        reentrantReadWriteLock.readLock().lock();
        try {
            j61 j61Var = (j61) map.get(cls);
            if (j61Var != null) {
                return j61Var;
            }
            reentrantReadWriteLock.writeLock().lock();
            try {
                j61 j61Var2 = (j61) map.get(cls);
                if (j61Var2 == null) {
                    j61Var2 = new j61();
                    j61Var2.a = new ReentrantReadWriteLock();
                    j61Var2.b = new ArrayList();
                    map.put(cls, j61Var2);
                }
                return j61Var2;
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
    
        java.util.Arrays.fill(r4, (java.lang.Object) null);
        r3.e[r0] = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void c(defpackage.l61[] r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
        L2:
            l61[][] r1 = r3.e     // Catch: java.lang.Throwable -> L14
            int r2 = r1.length     // Catch: java.lang.Throwable -> L14
            if (r0 >= r2) goto L19
            r1 = r1[r0]     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L16
            r1 = 0
            java.util.Arrays.fill(r4, r1)     // Catch: java.lang.Throwable -> L14
            l61[][] r1 = r3.e     // Catch: java.lang.Throwable -> L14
            r1[r0] = r4     // Catch: java.lang.Throwable -> L14
            goto L19
        L14:
            r4 = move-exception
            goto L1b
        L16:
            int r0 = r0 + 1
            goto L2
        L19:
            monitor-exit(r3)
            return
        L1b:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L14
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k61.c(l61[]):void");
    }

    public final void d(boolean z) {
        if (this.c != null || z) {
            this.f = z;
        } else {
            xe.q("The event manager is set to be root, and can not be disabled");
        }
    }

    public final void e(Class cls, i61 i61Var) {
        f(cls, new g11(4, i61Var));
    }

    public final i54 f(Class cls, l61 l61Var) {
        j61 j61VarB = b(cls);
        ReentrantReadWriteLock reentrantReadWriteLock = j61VarB.a;
        reentrantReadWriteLock.writeLock().lock();
        try {
            ArrayList arrayList = j61VarB.b;
            if (arrayList.contains(l61Var)) {
                return new i54(this, cls, l61Var);
            }
            arrayList.add(l61Var);
            reentrantReadWriteLock.writeLock().unlock();
            return new i54(this, cls, l61Var);
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }
}
