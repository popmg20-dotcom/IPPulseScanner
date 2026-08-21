package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ga0 {
    public static final /* synthetic */ long b;
    public static final /* synthetic */ long f;
    public static final /* synthetic */ int z = 0;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    static {
        Unsafe unsafe = re.a;
        b = unsafe.objectFieldOffset(ga0.class.getDeclaredField("_next$volatile"));
        f = unsafe.objectFieldOffset(ga0.class.getDeclaredField("_prev$volatile"));
    }

    public ga0(sr3 sr3Var) {
        this._prev$volatile = sr3Var;
    }

    public final void a() {
        re.a.putObjectVolatile(this, f, (Object) null);
    }

    public final ga0 c() {
        Object objectVolatile = re.a.getObjectVolatile(this, b);
        if (objectVolatile == fa0.a) {
            return null;
        }
        return (ga0) objectVolatile;
    }

    public abstract boolean d();

    public final void e() {
        ga0 ga0Var;
        Unsafe unsafe;
        if (c() == null) {
            return;
        }
        while (true) {
            Unsafe unsafe2 = re.a;
            long j = f;
            ga0 ga0Var2 = (ga0) unsafe2.getObjectVolatile(this, j);
            while (ga0Var2 != null && ga0Var2.d()) {
                ga0Var2 = (ga0) re.a.getObjectVolatile(ga0Var2, j);
            }
            ga0 ga0VarC = c();
            ga0VarC.getClass();
            do {
                ga0Var = ga0VarC;
                if (!ga0Var.d()) {
                    break;
                } else {
                    ga0VarC = ga0Var.c();
                }
            } while (ga0VarC != null);
            while (true) {
                Object objectVolatile = re.a.getObjectVolatile(ga0Var, j);
                ga0 ga0Var3 = ((ga0) objectVolatile) == null ? null : ga0Var2;
                do {
                    unsafe = re.a;
                    if (unsafe.compareAndSwapObject(ga0Var, f, objectVolatile, ga0Var3)) {
                        break;
                    }
                } while (unsafe.getObjectVolatile(ga0Var, j) == objectVolatile);
            }
            if (ga0Var2 != null) {
                unsafe.putObjectVolatile(ga0Var2, b, ga0Var);
            }
            if (!ga0Var.d() || ga0Var.c() == null) {
                if (ga0Var2 == null || !ga0Var2.d()) {
                    return;
                }
            }
        }
    }
}
