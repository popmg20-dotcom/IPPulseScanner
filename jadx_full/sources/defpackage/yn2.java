package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class yn2 extends ms3 implements wn2 {
    private volatile /* synthetic */ Object owner$volatile;
    public static final /* synthetic */ AtomicReferenceFieldUpdater z0 = AtomicReferenceFieldUpdater.newUpdater(yn2.class, Object.class, "owner$volatile");
    public static final /* synthetic */ long A0 = re.a.objectFieldOffset(yn2.class.getDeclaredField("owner$volatile"));

    public yn2() {
        super(1);
        this.owner$volatile = zn2.a;
    }

    public final boolean d() {
        yn2 yn2Var;
        while (true) {
            Unsafe unsafe = re.a;
            long j = ms3.Y;
            int intVolatile = unsafe.getIntVolatile(this, j);
            if (intVolatile > this.b) {
                while (true) {
                    Unsafe unsafe2 = re.a;
                    long j2 = ms3.Y;
                    int intVolatile2 = unsafe2.getIntVolatile(this, j2);
                    int i = this.b;
                    if (intVolatile2 <= i) {
                        yn2Var = this;
                        break;
                    }
                    yn2 yn2Var2 = this;
                    yn2Var = yn2Var2;
                    if (unsafe2.compareAndSwapInt(yn2Var2, j2, intVolatile2, i)) {
                        break;
                    }
                    this = yn2Var;
                }
            } else {
                yn2Var = this;
                if (intVolatile <= 0) {
                    return false;
                }
                if (unsafe.compareAndSwapInt(yn2Var, j, intVolatile, intVolatile - 1)) {
                    unsafe.putObjectVolatile(yn2Var, A0, (Object) null);
                    return true;
                }
            }
            this = yn2Var;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        r5 = defpackage.yn2.z0;
        r2 = r0.f;
        r5.set(r2, null);
        r5 = r0.b;
        r5.E(r1, r5.z, new defpackage.op(1, new defpackage.f0(r2, r0)));
     */
    @Override // defpackage.wn2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(ie0 ie0Var) {
        boolean zD = d();
        xl4 xl4Var = xl4.a;
        if (!zD) {
            z00 z00VarT = vo.t(p95.u(ie0Var));
            try {
                xn2 xn2Var = new xn2(this, z00VarT);
                while (true) {
                    int andDecrement = ms3.X.getAndDecrement(this);
                    if (andDecrement <= this.b) {
                        if (andDecrement > 0) {
                            break;
                        }
                        if (b(xn2Var)) {
                            break;
                        }
                    }
                }
                Object objU = z00VarT.u();
                mf0 mf0Var = mf0.b;
                if (objU != mf0Var) {
                    objU = xl4Var;
                }
                if (objU == mf0Var) {
                    return objU;
                }
            } catch (Throwable th) {
                z00VarT.D();
                throw th;
            }
        }
        return xl4Var;
    }

    @Override // defpackage.wn2
    public final void n(Object obj) {
        while (true) {
            Unsafe unsafe = re.a;
            if (Math.max(unsafe.getIntVolatile(this, ms3.Y), 0) != 0) {
                xe.q("This mutex is not locked");
                return;
            }
            long j = A0;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            br1 br1Var = zn2.a;
            if (objectVolatile != br1Var) {
                if (objectVolatile != obj && obj != null) {
                    s53.n("This mutex is locked by ", objectVolatile, ", but ", obj, " is expected");
                    return;
                }
                while (true) {
                    Unsafe unsafe2 = re.a;
                    yn2 yn2Var = this;
                    if (unsafe2.compareAndSwapObject(yn2Var, A0, objectVolatile, br1Var)) {
                        yn2Var.c();
                        return;
                    } else {
                        if (unsafe2.getObjectVolatile(yn2Var, j) != objectVolatile) {
                            this = yn2Var;
                            break;
                        }
                        this = yn2Var;
                    }
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Mutex@");
        sb.append(ek0.l(this));
        sb.append("[isLocked=");
        Unsafe unsafe = re.a;
        sb.append(Math.max(unsafe.getIntVolatile(this, ms3.Y), 0) == 0);
        sb.append(",owner=");
        sb.append(unsafe.getObjectVolatile(this, A0));
        sb.append(']');
        return sb.toString();
    }
}
