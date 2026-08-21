package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class vd4 extends y32 {
    public static final /* synthetic */ long Z = re.a.objectFieldOffset(vd4.class.getDeclaredField("_state$volatile"));
    public final Thread X = Thread.currentThread();
    public zv0 Y;
    private volatile /* synthetic */ int _state$volatile;

    public static void o(int i) {
        throw new IllegalStateException(("Illegal state " + i).toString());
    }

    @Override // defpackage.y32
    public final boolean l() {
        return true;
    }

    @Override // defpackage.y32
    public final void m(Throwable th) {
        while (true) {
            Unsafe unsafe = re.a;
            long j = Z;
            int intVolatile = unsafe.getIntVolatile(this, j);
            if (intVolatile != 0) {
                if (intVolatile == 1 || intVolatile == 2 || intVolatile == 3) {
                    return;
                }
                o(intVolatile);
                throw null;
            }
            vd4 vd4Var = this;
            if (unsafe.compareAndSwapInt(vd4Var, Z, intVolatile, 2)) {
                vd4Var.X.interrupt();
                unsafe.putIntVolatile(vd4Var, j, 3);
                return;
            }
            this = vd4Var;
        }
    }

    public final void n() {
        vd4 vd4Var;
        while (true) {
            Unsafe unsafe = re.a;
            long j = Z;
            int intVolatile = unsafe.getIntVolatile(this, j);
            if (intVolatile == 0) {
                vd4Var = this;
                if (unsafe.compareAndSwapInt(vd4Var, j, intVolatile, 1)) {
                    zv0 zv0Var = vd4Var.Y;
                    if (zv0Var != null) {
                        zv0Var.c();
                        return;
                    }
                    return;
                }
            } else {
                if (intVolatile != 2) {
                    if (intVolatile == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        o(intVolatile);
                        throw null;
                    }
                }
                vd4Var = this;
            }
            this = vd4Var;
        }
    }
}
