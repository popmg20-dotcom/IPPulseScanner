package defpackage;

import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iq1 {
    public static final si1 j = si1.d;
    public static final int k = 1;
    public static final int l = 1;
    public static final int m = 2;
    public final ThreadLocal a;
    public final ConcurrentHashMap b;
    public final lb c;
    public final k42 d;
    public final List e;
    public final Map f;
    public final boolean g;
    public final si1 h;
    public final int i;

    public iq1(u61 u61Var, int i, Map map, si1 si1Var, int i2, List list, int i3, int i4, List list2) {
        this.a = new ThreadLocal();
        this.b = new ConcurrentHashMap();
        this.f = map;
        lb lbVar = new lb(29, map, list2);
        this.c = lbVar;
        int i5 = 1;
        this.g = true;
        this.h = si1Var;
        this.i = i2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(mj4.A);
        arrayList.add(i3 == 1 ? au2.c : new zt2(i3));
        arrayList.add(u61Var);
        arrayList.addAll(list);
        arrayList.add(mj4.p);
        arrayList.add(mj4.g);
        arrayList.add(mj4.d);
        arrayList.add(mj4.e);
        arrayList.add(mj4.f);
        ki4 ki4Var = mj4.k;
        arrayList.add(new ej4(Long.TYPE, Long.class, ki4Var));
        int i6 = 0;
        arrayList.add(new ej4(Double.TYPE, Double.class, new fq1(i6)));
        arrayList.add(new ej4(Float.TYPE, Float.class, new fq1(i5)));
        arrayList.add(i4 == 2 ? it2.b : new ht2(new it2(i4), i6));
        arrayList.add(mj4.h);
        arrayList.add(mj4.i);
        arrayList.add(new cj4(AtomicLong.class, new gq1(ki4Var, i6).a(), i6));
        arrayList.add(new cj4(AtomicLongArray.class, new gq1(ki4Var, i5).a(), i6));
        arrayList.add(mj4.j);
        arrayList.add(mj4.l);
        arrayList.add(mj4.q);
        arrayList.add(mj4.r);
        arrayList.add(new cj4(BigDecimal.class, mj4.m, i6));
        arrayList.add(new cj4(BigInteger.class, mj4.n, i6));
        arrayList.add(new cj4(y82.class, mj4.o, i6));
        arrayList.add(mj4.s);
        arrayList.add(mj4.t);
        arrayList.add(mj4.v);
        arrayList.add(mj4.w);
        arrayList.add(mj4.y);
        arrayList.add(mj4.u);
        arrayList.add(mj4.b);
        arrayList.add(el0.c);
        arrayList.add(mj4.x);
        if (d14.a) {
            arrayList.add(d14.c);
            arrayList.add(d14.b);
            arrayList.add(d14.d);
        }
        arrayList.add(pe.c);
        arrayList.add(mj4.a);
        arrayList.add(new c70(lbVar, i6));
        arrayList.add(new c70(lbVar, i5));
        k42 k42Var = new k42(lbVar);
        this.d = k42Var;
        arrayList.add(k42Var);
        arrayList.add(mj4.B);
        arrayList.add(new nh3(lbVar, i, u61Var, k42Var, list2));
        this.e = DesugarCollections.unmodifiableList(arrayList);
    }

    public static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final Object b(Reader reader, bk4 bk4Var) {
        Object objB;
        r62 r62Var = new r62(reader);
        int i = this.i;
        int i2 = i == 0 ? 2 : i;
        Object obj = null;
        if (i2 == 0) {
            throw null;
        }
        r62Var.F0 = i2;
        boolean z = true;
        if (i != 0) {
            if (i == 0) {
                throw null;
            }
            r62Var.F0 = i;
        } else if (i2 == 2) {
            r62Var.F0 = 1;
        }
        try {
            try {
                try {
                    r62Var.X();
                    z = false;
                    hi4 hi4VarD = d(bk4Var);
                    Class cls = bk4Var.a;
                    objB = hi4VarD.b(r62Var);
                    Class clsF = p95.F(cls);
                    if (objB != null && !clsF.isInstance(objB)) {
                        throw new ClassCastException("Type adapter '" + hi4VarD + "' returned wrong type; requested " + cls + " but got instance of " + objB.getClass() + "\nVerify that the adapter was registered for the correct type.");
                    }
                } catch (AssertionError e) {
                    throw new AssertionError("AssertionError (GSON 2.13.2): " + e.getMessage(), e);
                } catch (IllegalStateException e2) {
                    throw new l52(e2);
                }
            } catch (EOFException e3) {
                if (!z) {
                    throw new l52(e3);
                }
                if (i2 == 0) {
                    throw null;
                }
                r62Var.F0 = i2;
            } catch (IOException e4) {
                throw new l52(e4);
            }
            if (i2 == 0) {
                throw null;
            }
            r62Var.F0 = i2;
            obj = objB;
            if (obj != null) {
                try {
                    if (r62Var.X() != 10) {
                        throw new l52("JSON document was not fully consumed.");
                    }
                } catch (wf2 e5) {
                    throw new l52(e5);
                } catch (IOException e6) {
                    throw new l52(e6);
                }
            }
            return obj;
        } catch (Throwable th) {
            if (i2 == 0) {
                throw null;
            }
            r62Var.F0 = i2;
            throw th;
        }
    }

    public final Object c(String str, bk4 bk4Var) {
        if (str == null) {
            return null;
        }
        return b(new StringReader(str), bk4Var);
    }

    public final hi4 d(bk4 bk4Var) {
        boolean z;
        Objects.requireNonNull(bk4Var, "type must not be null");
        ConcurrentHashMap concurrentHashMap = this.b;
        hi4 hi4Var = (hi4) concurrentHashMap.get(bk4Var);
        if (hi4Var != null) {
            return hi4Var;
        }
        ThreadLocal threadLocal = this.a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z = true;
        } else {
            hi4 hi4Var2 = (hi4) map.get(bk4Var);
            if (hi4Var2 != null) {
                return hi4Var2;
            }
            z = false;
        }
        try {
            hq1 hq1Var = new hq1();
            map.put(bk4Var, hq1Var);
            Iterator it = this.e.iterator();
            hi4 hi4VarA = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                hi4VarA = ((ii4) it.next()).a(this, bk4Var);
                if (hi4VarA != null) {
                    if (hq1Var.a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    hq1Var.a = hi4VarA;
                    map.put(bk4Var, hi4VarA);
                }
            }
            if (z) {
                threadLocal.remove();
            }
            if (hi4VarA == null) {
                vp1.h(bk4Var, "GSON (2.13.2) cannot handle ");
                return null;
            }
            if (z) {
                concurrentHashMap.putAll(map);
            }
            return hi4VarA;
        } catch (Throwable th) {
            if (z) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final hi4 e(ii4 ii4Var, bk4 bk4Var) {
        Objects.requireNonNull(ii4Var, "skipPast must not be null");
        Objects.requireNonNull(bk4Var, "type must not be null");
        k42 k42Var = this.d;
        k42Var.getClass();
        ConcurrentHashMap concurrentHashMap = k42Var.f;
        if (ii4Var == k42.z) {
            ii4Var = k42Var;
        } else {
            Class cls = bk4Var.a;
            ii4 ii4Var2 = (ii4) concurrentHashMap.get(cls);
            if (ii4Var2 == null) {
                i42 i42Var = (i42) cls.getAnnotation(i42.class);
                if (i42Var != null) {
                    Class clsValue = i42Var.value();
                    if (ii4.class.isAssignableFrom(clsValue)) {
                        ii4 ii4Var3 = (ii4) k42Var.b.t(new bk4(clsValue), true).a();
                        ii4 ii4Var4 = (ii4) concurrentHashMap.putIfAbsent(cls, ii4Var3);
                        if (ii4Var4 != null) {
                            ii4Var3 = ii4Var4;
                        }
                        if (ii4Var3 == ii4Var) {
                        }
                    }
                }
            } else if (ii4Var2 == ii4Var) {
            }
        }
        boolean z = false;
        for (ii4 ii4Var5 : this.e) {
            if (z) {
                hi4 hi4VarA = ii4Var5.a(this, bk4Var);
                if (hi4VarA != null) {
                    return hi4VarA;
                }
            } else if (ii4Var5 == ii4Var) {
                z = true;
            }
        }
        if (!z) {
            return d(bk4Var);
        }
        vp1.h(bk4Var, "GSON cannot serialize or deserialize ");
        return null;
    }

    public final v72 f(Writer writer) {
        v72 v72Var = new v72(writer);
        v72Var.I(this.h);
        v72Var.z0 = this.g;
        int i = this.i;
        if (i == 0) {
            i = 2;
        }
        v72Var.M(i);
        v72Var.B0 = false;
        return v72Var;
    }

    public final String g(y42 y42Var) {
        StringBuilder sb = new StringBuilder();
        try {
            i(y42Var, f(new h44(sb)));
            return sb.toString();
        } catch (IOException e) {
            throw new l52(e);
        }
    }

    public final String h(Object obj) {
        if (obj == null) {
            return g(f62.b);
        }
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder();
        try {
            j(obj, cls, f(new h44(sb)));
            return sb.toString();
        } catch (IOException e) {
            throw new l52(e);
        }
    }

    public final void i(y42 y42Var, v72 v72Var) {
        int i = v72Var.y0;
        boolean z = v72Var.z0;
        boolean z2 = v72Var.B0;
        v72Var.z0 = this.g;
        v72Var.B0 = false;
        int i2 = this.i;
        if (i2 != 0) {
            v72Var.M(i2);
        } else if (i == 2) {
            v72Var.y0 = 1;
        }
        try {
            try {
                try {
                    mj4.z.getClass();
                    z42.e(y42Var, v72Var);
                    v72Var.M(i);
                    v72Var.z0 = z;
                    v72Var.B0 = z2;
                } catch (IOException e) {
                    throw new l52(e);
                }
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.13.2): " + e2.getMessage(), e2);
            }
        } catch (Throwable th) {
            v72Var.M(i);
            v72Var.z0 = z;
            v72Var.B0 = z2;
            throw th;
        }
    }

    public final void j(Object obj, Class cls, v72 v72Var) {
        hi4 hi4VarD = d(new bk4(cls));
        int i = v72Var.y0;
        int i2 = this.i;
        if (i2 != 0) {
            v72Var.M(i2);
        } else if (i == 2) {
            v72Var.y0 = 1;
        }
        boolean z = v72Var.z0;
        boolean z2 = v72Var.B0;
        v72Var.z0 = this.g;
        v72Var.B0 = false;
        try {
            try {
                hi4VarD.c(v72Var, obj);
            } catch (IOException e) {
                throw new l52(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.13.2): " + e2.getMessage(), e2);
            }
        } finally {
            v72Var.M(i);
            v72Var.z0 = z;
            v72Var.B0 = z2;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.e + ",instanceCreators:" + this.c + "}";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public iq1() {
        u61 u61Var = u61.A;
        Map map = Collections.EMPTY_MAP;
        List list = Collections.EMPTY_LIST;
        this(u61Var, k, map, j, 0, list, l, m, list);
    }
}
