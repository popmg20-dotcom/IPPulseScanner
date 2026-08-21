package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xd2 {
    public static final /* synthetic */ long b;
    public static final /* synthetic */ long f;
    public static final /* synthetic */ long z;
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    static {
        Unsafe unsafe = re.a;
        b = unsafe.objectFieldOffset(xd2.class.getDeclaredField("_next$volatile"));
        f = unsafe.objectFieldOffset(xd2.class.getDeclaredField("_prev$volatile"));
        z = unsafe.objectFieldOffset(xd2.class.getDeclaredField("_removedRef$volatile"));
    }

    public final boolean d(xd2 xd2Var, int i) {
        xd2 xd2Var2;
        xd2 xd2Var3;
        while (true) {
            xd2 xd2VarI = this.i();
            if (xd2VarI instanceof vb2) {
                return (((vb2) xd2VarI).A & i) == 0 && xd2VarI.d(xd2Var, i);
            }
            Unsafe unsafe = re.a;
            unsafe.putObjectVolatile(xd2Var, f, xd2VarI);
            long j = b;
            unsafe.putObjectVolatile(xd2Var, j, this);
            while (true) {
                Unsafe unsafe2 = re.a;
                xd2Var2 = this;
                xd2Var3 = xd2Var;
                if (unsafe2.compareAndSwapObject(xd2VarI, b, xd2Var2, xd2Var3)) {
                    xd2Var3.f(xd2Var2);
                    return true;
                }
                if (unsafe2.getObjectVolatile(xd2VarI, j) != xd2Var2) {
                    break;
                }
                this = xd2Var2;
                xd2Var = xd2Var3;
            }
            this = xd2Var2;
            xd2Var = xd2Var3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final xd2 e() {
        xd2 xd2Var;
        Unsafe unsafe;
        loop0: while (true) {
            Unsafe unsafe2 = re.a;
            long j = f;
            xd2 xd2Var2 = (xd2) unsafe2.getObjectVolatile(this, j);
            xd2 xd2Var3 = null;
            xd2 xd2Var4 = xd2Var2;
            while (xd2Var4 != null) {
                Unsafe unsafe3 = re.a;
                long j2 = b;
                Object objectVolatile = unsafe3.getObjectVolatile(xd2Var4, j2);
                if (objectVolatile != this) {
                    xd2 xd2Var5 = xd2Var2;
                    xd2Var = this;
                    if (xd2Var.j()) {
                        return null;
                    }
                    if (!(objectVolatile instanceof pi3)) {
                        objectVolatile.getClass();
                        xd2Var3 = xd2Var4;
                        xd2Var4 = (xd2) objectVolatile;
                    } else if (xd2Var3 != null) {
                        xd2 xd2Var6 = ((pi3) objectVolatile).a;
                        do {
                            xd2 xd2Var7 = xd2Var4;
                            unsafe = re.a;
                            boolean zCompareAndSwapObject = unsafe.compareAndSwapObject(xd2Var3, b, xd2Var7, xd2Var6);
                            xd2Var4 = xd2Var7;
                            if (zCompareAndSwapObject) {
                                this = xd2Var;
                                xd2Var4 = xd2Var3;
                                xd2Var2 = xd2Var5;
                                xd2Var3 = null;
                            }
                        } while (unsafe.getObjectVolatile(xd2Var3, j2) == xd2Var4);
                    } else {
                        if (xd2Var4 == null) {
                            st4.n();
                            return null;
                        }
                        xd2Var4 = (xd2) unsafe3.getObjectVolatile(xd2Var4, j);
                    }
                    this = xd2Var;
                    xd2Var2 = xd2Var5;
                } else {
                    if (xd2Var2 == xd2Var4) {
                        break;
                    }
                    while (true) {
                        Unsafe unsafe4 = re.a;
                        xd2 xd2Var8 = this;
                        boolean zCompareAndSwapObject2 = unsafe4.compareAndSwapObject(xd2Var8, f, xd2Var2, xd2Var4);
                        xd2 xd2Var9 = xd2Var2;
                        xd2Var = xd2Var8;
                        if (zCompareAndSwapObject2) {
                            break loop0;
                        }
                        if (unsafe4.getObjectVolatile(xd2Var, j) != xd2Var9) {
                            break;
                        }
                        this = xd2Var;
                        xd2Var2 = xd2Var9;
                    }
                }
                this = xd2Var;
            }
            st4.n();
            return null;
        }
    }

    public final void f(xd2 xd2Var) {
        xd2 xd2Var2;
        while (true) {
            Unsafe unsafe = re.a;
            long j = f;
            xd2 xd2Var3 = (xd2) unsafe.getObjectVolatile(xd2Var, j);
            if (this.g() != xd2Var) {
                return;
            }
            while (true) {
                Unsafe unsafe2 = re.a;
                xd2Var2 = this;
                xd2 xd2Var4 = xd2Var;
                if (unsafe2.compareAndSwapObject(xd2Var4, f, xd2Var3, xd2Var2)) {
                    if (xd2Var2.j()) {
                        xd2Var4.e();
                        return;
                    }
                    return;
                } else {
                    xd2Var = xd2Var4;
                    if (unsafe2.getObjectVolatile(xd2Var4, j) != xd2Var3) {
                        break;
                    } else {
                        this = xd2Var2;
                    }
                }
            }
            this = xd2Var2;
        }
    }

    public final Object g() {
        return re.a.getObjectVolatile(this, b);
    }

    public final xd2 h() {
        Object objG = g();
        pi3 pi3Var = objG instanceof pi3 ? (pi3) objG : null;
        if (pi3Var != null) {
            return pi3Var.a;
        }
        objG.getClass();
        return (xd2) objG;
    }

    public final xd2 i() {
        xd2 xd2VarE = e();
        if (xd2VarE != null) {
            return xd2VarE;
        }
        Unsafe unsafe = re.a;
        long j = f;
        Object objectVolatile = unsafe.getObjectVolatile(this, j);
        while (true) {
            xd2 xd2Var = (xd2) objectVolatile;
            if (!xd2Var.j()) {
                return xd2Var;
            }
            objectVolatile = re.a.getObjectVolatile(xd2Var, j);
        }
    }

    public boolean j() {
        return g() instanceof pi3;
    }

    public String toString() {
        return new wd2(this, ek0.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1) + '@' + ek0.l(this);
    }
}
