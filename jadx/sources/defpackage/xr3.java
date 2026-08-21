package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class xr3 implements t00, xs4 {
    public static final /* synthetic */ long Y = re.a.objectFieldOffset(xr3.class.getDeclaredField("state$volatile"));
    public final cf0 b;
    public Object z;
    private volatile /* synthetic */ Object state$volatile = zr3.a;
    public ArrayList f = new ArrayList(2);
    public int A = -1;
    public Object X = zr3.d;

    public xr3(cf0 cf0Var) {
        this.b = cf0Var;
    }

    @Override // defpackage.xs4
    public final void a(sr3 sr3Var, int i) {
        this.z = sr3Var;
        this.A = i;
    }

    @Override // defpackage.t00
    public final void b(Throwable th) {
        xr3 xr3Var;
        while (true) {
            Unsafe unsafe = re.a;
            long j = Y;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            if (objectVolatile == zr3.b) {
                return;
            }
            while (true) {
                Unsafe unsafe2 = re.a;
                xr3Var = this;
                if (unsafe2.compareAndSwapObject(xr3Var, Y, objectVolatile, zr3.c)) {
                    ArrayList arrayList = xr3Var.f;
                    if (arrayList == null) {
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((vr3) it.next()).b();
                    }
                    xr3Var.X = zr3.d;
                    xr3Var.f = null;
                    return;
                }
                if (unsafe2.getObjectVolatile(xr3Var, j) != objectVolatile) {
                    break;
                } else {
                    this = xr3Var;
                }
            }
            this = xr3Var;
        }
    }

    public final Object c(ie0 ie0Var) {
        Unsafe unsafe = re.a;
        long j = Y;
        Object objectVolatile = unsafe.getObjectVolatile(this, j);
        objectVolatile.getClass();
        vr3 vr3Var = (vr3) objectVolatile;
        Object obj = vr3Var.d;
        Object obj2 = this.X;
        ArrayList<vr3> arrayList = this.f;
        if (arrayList != null) {
            for (vr3 vr3Var2 : arrayList) {
                if (vr3Var2 != vr3Var) {
                    vr3Var2.b();
                }
            }
            re.a.putObjectVolatile(this, j, zr3.b);
            this.X = zr3.d;
            this.f = null;
        }
        Object objE = vr3Var.c.e(vr3Var.a, obj, obj2);
        lm1 lm1Var = vr3Var.e;
        return obj == zr3.e ? ((am1) lm1Var).g(ie0Var) : ((Function2) lm1Var).k(objE, ie0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(defpackage.ie0 r16) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xr3.d(ie0):java.lang.Object");
    }

    public final vr3 e(Object obj) {
        ArrayList arrayList = this.f;
        Object obj2 = null;
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((vr3) next).a == obj) {
                obj2 = next;
                break;
            }
        }
        vr3 vr3Var = (vr3) obj2;
        if (vr3Var != null) {
            return vr3Var;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    public final void f(vr3 vr3Var, boolean z) {
        Object obj = vr3Var.a;
        Unsafe unsafe = re.a;
        long j = Y;
        if (unsafe.getObjectVolatile(this, j) instanceof vr3) {
            return;
        }
        if (!z) {
            ArrayList arrayList = this.f;
            arrayList.getClass();
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((vr3) it.next()).a == obj) {
                        zo2.m(obj, "Cannot use select clauses on the same object: ");
                        return;
                    }
                }
            }
        }
        vr3Var.b.e(obj, this, vr3Var.d);
        if (this.X != zr3.d) {
            re.a.putObjectVolatile(this, j, vr3Var);
            return;
        }
        if (!z) {
            ArrayList arrayList2 = this.f;
            arrayList2.getClass();
            arrayList2.add(vr3Var);
        }
        vr3Var.g = this.z;
        vr3Var.h = this.A;
        this.z = null;
        this.A = -1;
    }

    public final boolean g(Object obj, Object obj2) {
        return h(obj, obj2) == 0;
    }

    public final int h(Object obj, Object obj2) {
        xr3 xr3Var;
        Unsafe unsafe;
        Unsafe unsafe2;
        while (true) {
            Unsafe unsafe3 = re.a;
            long j = Y;
            Object objectVolatile = unsafe3.getObjectVolatile(this, j);
            if (objectVolatile instanceof y00) {
                vr3 vr3VarE = this.e(obj);
                if (vr3VarE == null) {
                    continue;
                } else {
                    em1 em1VarA = vr3VarE.a(this, obj2);
                    while (true) {
                        Unsafe unsafe4 = re.a;
                        xr3Var = this;
                        if (unsafe4.compareAndSwapObject(xr3Var, Y, objectVolatile, vr3VarE)) {
                            y00 y00Var = (y00) objectVolatile;
                            xr3Var.X = obj2;
                            br1 br1VarF = y00Var.f(xl4.a, em1VarA);
                            if (br1VarF == null) {
                                xr3Var.X = zr3.d;
                                return 2;
                            }
                            y00Var.m(br1VarF);
                            return 0;
                        }
                        if (unsafe4.getObjectVolatile(xr3Var, j) != objectVolatile) {
                            break;
                        }
                        this = xr3Var;
                    }
                }
            } else {
                xr3Var = this;
                if (n12.c(objectVolatile, zr3.b) || (objectVolatile instanceof vr3)) {
                    return 3;
                }
                if (n12.c(objectVolatile, zr3.c)) {
                    return 2;
                }
                if (n12.c(objectVolatile, zr3.a)) {
                    List listX = p95.x(obj);
                    do {
                        unsafe2 = re.a;
                        if (unsafe2.compareAndSwapObject(xr3Var, Y, objectVolatile, listX)) {
                            return 1;
                        }
                    } while (unsafe2.getObjectVolatile(xr3Var, j) == objectVolatile);
                } else {
                    if (!(objectVolatile instanceof List)) {
                        ad0.o(objectVolatile, "Unexpected state: ");
                        return 0;
                    }
                    ArrayList arrayListN0 = d70.n0((Collection) objectVolatile, obj);
                    do {
                        unsafe = re.a;
                        if (unsafe.compareAndSwapObject(xr3Var, Y, objectVolatile, arrayListN0)) {
                            return 1;
                        }
                    } while (unsafe.getObjectVolatile(xr3Var, j) == objectVolatile);
                }
            }
            this = xr3Var;
        }
    }
}
