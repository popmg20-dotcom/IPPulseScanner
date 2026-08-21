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
    */
    public final Object d(ie0 ie0Var) {
        wr3 wr3Var;
        Object obj;
        z00 z00Var;
        xr3 xr3Var;
        if (ie0Var instanceof wr3) {
            wr3Var = (wr3) ie0Var;
            int i = wr3Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                wr3Var.Z = i - Integer.MIN_VALUE;
            } else {
                wr3Var = new wr3(this, ie0Var);
            }
        }
        wr3 wr3Var2 = wr3Var;
        Object obj2 = wr3Var2.X;
        int i2 = wr3Var2.Z;
        mf0 mf0Var = mf0.b;
        if (i2 == 0) {
            n12.S(obj2);
            wr3Var2.A = this;
            wr3Var2.Z = 1;
            z00 z00Var2 = new z00(1, p95.u(wr3Var2));
            z00Var2.w();
            loop0: while (true) {
                Unsafe unsafe = re.a;
                long j = Y;
                Object objectVolatile = unsafe.getObjectVolatile(this, j);
                obj = xl4.a;
                z00 z00Var3 = z00Var2;
                br1 br1Var = zr3.a;
                if (objectVolatile == br1Var) {
                    z00 z00Var4 = z00Var3;
                    while (true) {
                        Unsafe unsafe2 = re.a;
                        z00Var = z00Var4;
                        if (unsafe2.compareAndSwapObject(this, Y, objectVolatile, z00Var4)) {
                            z00Var.z(this);
                            break loop0;
                        }
                        if (unsafe2.getObjectVolatile(this, j) != objectVolatile) {
                            break;
                        }
                        z00Var4 = z00Var;
                    }
                    z00Var2 = z00Var;
                } else {
                    z00Var = z00Var3;
                    if (objectVolatile instanceof List) {
                        while (true) {
                            Unsafe unsafe3 = re.a;
                            if (unsafe3.compareAndSwapObject(this, Y, objectVolatile, br1Var)) {
                                Iterator it = ((Iterable) objectVolatile).iterator();
                                while (it.hasNext()) {
                                    vr3 vr3VarE = e(it.next());
                                    vr3VarE.getClass();
                                    vr3VarE.g = null;
                                    vr3VarE.h = -1;
                                    f(vr3VarE, true);
                                }
                            } else if (unsafe3.getObjectVolatile(this, j) != objectVolatile) {
                                break;
                            }
                        }
                        z00Var2 = z00Var;
                    } else {
                        if (!(objectVolatile instanceof vr3)) {
                            ad0.o(objectVolatile, "unexpected state: ");
                            return null;
                        }
                        z00Var.l(obj, ((vr3) objectVolatile).a(this, this.X));
                    }
                }
            }
            Object objU = z00Var.u();
            if (objU == mf0Var) {
                obj = objU;
            }
            if (obj != mf0Var) {
                xr3Var = this;
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                n12.S(obj2);
                return obj2;
            }
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        xr3Var = wr3Var2.A;
        n12.S(obj2);
        wr3Var2.A = null;
        wr3Var2.Z = 2;
        Object objC = xr3Var.c(wr3Var2);
        return objC == mf0Var ? mf0Var : objC;
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
