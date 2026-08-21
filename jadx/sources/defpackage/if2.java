package defpackage;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class if2 {
    public final /* synthetic */ int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public final Object f;
    public final Object g;

    public if2(int i) {
        this.a = 0;
        this.b = i;
        if (i <= 0) {
            xe.k("maxSize <= 0");
            throw null;
        }
        this.f = new jf2(0);
        this.g = new d7(23);
    }

    public void a() {
        View view = (View) fw.r((ArrayList) this.f, 1);
        v14 v14Var = (v14) view.getLayoutParams();
        this.c = ((StaggeredGridLayoutManager) this.g).r.d(view);
        v14Var.getClass();
    }

    public void b() {
        ((ArrayList) this.f).clear();
        this.b = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
        this.d = 0;
    }

    public Object c(Object obj) {
        obj.getClass();
        return null;
    }

    public void d(Object obj, Object obj2, Object obj3) {
        obj.getClass();
        obj2.getClass();
    }

    public int e() {
        return ((StaggeredGridLayoutManager) this.g).w ? g(r1.size() - 1, -1) : g(0, ((ArrayList) this.f).size());
    }

    public int f() {
        return ((StaggeredGridLayoutManager) this.g).w ? g(0, ((ArrayList) this.f).size()) : g(r1.size() - 1, -1);
    }

    public int g(int i, int i2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        int iM = staggeredGridLayoutManager.r.m();
        int i3 = staggeredGridLayoutManager.r.i();
        int i4 = i2 > i ? 1 : -1;
        while (i != i2) {
            View view = (View) ((ArrayList) this.f).get(i);
            int iG = staggeredGridLayoutManager.r.g(view);
            int iD = staggeredGridLayoutManager.r.d(view);
            boolean z = iG <= i3;
            boolean z2 = iD >= iM;
            if (z && z2 && (iG < iM || iD > i3)) {
                return ag3.K(view);
            }
            i += i4;
        }
        return -1;
    }

    public Object h(Object obj) {
        Object objPut;
        obj.getClass();
        synchronized (((d7) this.g)) {
            Object obj2 = ((jf2) this.f).a.get(obj);
            if (obj2 != null) {
                this.d++;
                return obj2;
            }
            this.e++;
            Object objC = c(obj);
            if (objC == null) {
                return null;
            }
            synchronized (((d7) this.g)) {
                objPut = ((jf2) this.f).a.put(obj, objC);
                if (objPut != null) {
                    ((jf2) this.f).a.put(obj, objPut);
                } else {
                    this.c += n(obj, objC);
                }
            }
            if (objPut != null) {
                d(obj, objC, objPut);
                return objPut;
            }
            p(this.b);
            return objC;
        }
    }

    public int i(int i) {
        int i2 = this.c;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (((ArrayList) this.f).size() == 0) {
            return i;
        }
        a();
        return this.c;
    }

    public View j(int i, int i2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        ArrayList arrayList = (ArrayList) this.f;
        View view = null;
        if (i2 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.w && ag3.K(view2) >= i) || ((!staggeredGridLayoutManager.w && ag3.K(view2) <= i) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            View view3 = (View) arrayList.get(i3);
            if ((staggeredGridLayoutManager.w && ag3.K(view3) <= i) || ((!staggeredGridLayoutManager.w && ag3.K(view3) >= i) || !view3.hasFocusable())) {
                break;
            }
            i3++;
            view = view3;
        }
        return view;
    }

    public int k(int i) {
        ArrayList arrayList = (ArrayList) this.f;
        int i2 = this.b;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (arrayList.size() == 0) {
            return i;
        }
        View view = (View) arrayList.get(0);
        v14 v14Var = (v14) view.getLayoutParams();
        this.b = ((StaggeredGridLayoutManager) this.g).r.g(view);
        v14Var.getClass();
        return this.b;
    }

    public Object l(Object obj, Object obj2) {
        Object objPut;
        obj.getClass();
        synchronized (((d7) this.g)) {
            this.c += n(obj, obj2);
            objPut = ((jf2) this.f).a.put(obj, obj2);
            if (objPut != null) {
                this.c -= n(obj, objPut);
            }
        }
        if (objPut != null) {
            d(obj, objPut, obj2);
        }
        p(this.b);
        return objPut;
    }

    public void m(Object obj) {
        Object objRemove;
        obj.getClass();
        synchronized (((d7) this.g)) {
            objRemove = ((jf2) this.f).a.remove(obj);
            if (objRemove != null) {
                this.c -= n(obj, objRemove);
            }
        }
        if (objRemove != null) {
            d(obj, objRemove, null);
        }
    }

    public int n(Object obj, Object obj2) {
        int iO = o(obj, obj2);
        if (iO >= 0) {
            return iO;
        }
        throw new IllegalStateException("Negative size: " + obj + '=' + obj2);
    }

    public int o(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0089, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0091, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p(int r7) {
        /*
            r6 = this;
        L0:
            java.lang.Object r0 = r6.g
            d7 r0 = (defpackage.d7) r0
            monitor-enter(r0)
            int r1 = r6.c     // Catch: java.lang.Throwable -> L1a
            if (r1 < 0) goto L8a
            java.lang.Object r1 = r6.f     // Catch: java.lang.Throwable -> L1a
            jf2 r1 = (defpackage.jf2) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.a     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1d
            int r1 = r6.c     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L8a
            goto L1d
        L1a:
            r6 = move-exception
            goto L92
        L1d:
            int r1 = r6.c     // Catch: java.lang.Throwable -> L1a
            if (r1 <= r7) goto L88
            java.lang.Object r1 = r6.f     // Catch: java.lang.Throwable -> L1a
            jf2 r1 = (defpackage.jf2) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.a     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L2e
            goto L88
        L2e:
            java.lang.Object r1 = r6.f     // Catch: java.lang.Throwable -> L1a
            jf2 r1 = (defpackage.jf2) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.a     // Catch: java.lang.Throwable -> L1a
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L1a
            r1.getClass()     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L1a
            r3 = 0
            if (r2 == 0) goto L50
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r2 == 0) goto L4a
        L48:
            r1 = r3
            goto L5f
        L4a:
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L1a
            goto L5f
        L50:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L1a
            if (r2 != 0) goto L5b
            goto L48
        L5b:
            java.lang.Object r1 = r1.next()     // Catch: java.lang.Throwable -> L1a
        L5f:
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L65
            monitor-exit(r0)
            return
        L65:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r4 = r6.f     // Catch: java.lang.Throwable -> L1a
            jf2 r4 = (defpackage.jf2) r4     // Catch: java.lang.Throwable -> L1a
            r2.getClass()     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r4 = r4.a     // Catch: java.lang.Throwable -> L1a
            r4.remove(r2)     // Catch: java.lang.Throwable -> L1a
            int r4 = r6.c     // Catch: java.lang.Throwable -> L1a
            int r5 = r6.n(r2, r1)     // Catch: java.lang.Throwable -> L1a
            int r4 = r4 - r5
            r6.c = r4     // Catch: java.lang.Throwable -> L1a
            monitor-exit(r0)
            r6.d(r2, r1, r3)
            goto L0
        L88:
            monitor-exit(r0)
            return
        L8a:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L1a
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L1a
            throw r7     // Catch: java.lang.Throwable -> L1a
        L92:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.if2.p(int):void");
    }

    public String toString() {
        String str;
        switch (this.a) {
            case 0:
                synchronized (((d7) this.g)) {
                    try {
                        int i = this.d;
                        int i2 = this.e + i;
                        str = "LruCache[maxSize=" + this.b + ",hits=" + this.d + ",misses=" + this.e + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            default:
                return super.toString();
        }
    }

    public if2(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.a = 1;
        this.g = staggeredGridLayoutManager;
        this.f = new ArrayList();
        this.b = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
        this.d = 0;
        this.e = i;
    }
}
