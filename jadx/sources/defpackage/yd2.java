package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class yd2 {
    public static final /* synthetic */ long a = re.a.objectFieldOffset(yd2.class.getDeclaredField("_cur$volatile"));
    private volatile /* synthetic */ Object _cur$volatile = new ae2(8, false);

    public final boolean a(Runnable runnable) {
        yd2 yd2Var;
        while (true) {
            Unsafe unsafe = re.a;
            long j = a;
            ae2 ae2Var = (ae2) unsafe.getObjectVolatile(this, j);
            int iA = ae2Var.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                ae2 ae2VarC = ae2Var.c();
                while (true) {
                    Unsafe unsafe2 = re.a;
                    yd2Var = this;
                    if (!unsafe2.compareAndSwapObject(yd2Var, a, ae2Var, ae2VarC) && unsafe2.getObjectVolatile(yd2Var, j) == ae2Var) {
                        this = yd2Var;
                    }
                }
            } else {
                if (iA == 2) {
                    return false;
                }
                yd2Var = this;
            }
            this = yd2Var;
        }
    }

    public final void b() {
        yd2 yd2Var;
        while (true) {
            Unsafe unsafe = re.a;
            long j = a;
            ae2 ae2Var = (ae2) unsafe.getObjectVolatile(this, j);
            if (ae2Var.b()) {
                return;
            }
            ae2 ae2VarC = ae2Var.c();
            while (true) {
                yd2Var = this;
                if (!re.a.compareAndSwapObject(yd2Var, a, ae2Var, ae2VarC) && re.a.getObjectVolatile(yd2Var, j) == ae2Var) {
                    this = yd2Var;
                }
            }
            this = yd2Var;
        }
    }

    public final int c() {
        ae2 ae2Var = (ae2) re.a.getObjectVolatile(this, a);
        ae2Var.getClass();
        long longVolatile = re.a.getLongVolatile(ae2Var, ae2.g);
        return 1073741823 & (((int) ((longVolatile & 1152921503533105152L) >> 30)) - ((int) (1073741823 & longVolatile)));
    }

    public final Object d() {
        yd2 yd2Var;
        while (true) {
            Unsafe unsafe = re.a;
            long j = a;
            ae2 ae2Var = (ae2) unsafe.getObjectVolatile(this, j);
            Object objD = ae2Var.d();
            if (objD != ae2.e) {
                return objD;
            }
            ae2 ae2VarC = ae2Var.c();
            while (true) {
                yd2Var = this;
                if (!re.a.compareAndSwapObject(yd2Var, a, ae2Var, ae2VarC) && re.a.getObjectVolatile(yd2Var, j) == ae2Var) {
                    this = yd2Var;
                }
            }
            this = yd2Var;
        }
    }
}
