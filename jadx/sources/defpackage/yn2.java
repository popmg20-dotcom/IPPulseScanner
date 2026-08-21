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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(defpackage.ie0 r6) {
        /*
            r5 = this;
            boolean r0 = r5.d()
            xl4 r1 = defpackage.xl4.a
            if (r0 == 0) goto L9
            goto L50
        L9:
            ge0 r6 = defpackage.p95.u(r6)
            z00 r6 = defpackage.vo.t(r6)
            xn2 r0 = new xn2     // Catch: java.lang.Throwable -> L51
            r0.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
        L16:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = defpackage.ms3.X     // Catch: java.lang.Throwable -> L51
            int r2 = r2.getAndDecrement(r5)     // Catch: java.lang.Throwable -> L51
            int r3 = r5.b     // Catch: java.lang.Throwable -> L51
            if (r2 > r3) goto L16
            if (r2 <= 0) goto L3d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = defpackage.yn2.z0     // Catch: java.lang.Throwable -> L51
            yn2 r2 = r0.f     // Catch: java.lang.Throwable -> L51
            r3 = 0
            r5.set(r2, r3)     // Catch: java.lang.Throwable -> L51
            z00 r5 = r0.b     // Catch: java.lang.Throwable -> L51
            f0 r3 = new f0     // Catch: java.lang.Throwable -> L51
            r3.<init>(r2, r0)     // Catch: java.lang.Throwable -> L51
            int r0 = r5.z     // Catch: java.lang.Throwable -> L51
            op r2 = new op     // Catch: java.lang.Throwable -> L51
            r4 = 1
            r2.<init>(r4, r3)     // Catch: java.lang.Throwable -> L51
            r5.E(r1, r0, r2)     // Catch: java.lang.Throwable -> L51
            goto L43
        L3d:
            boolean r2 = r5.b(r0)     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L16
        L43:
            java.lang.Object r5 = r6.u()
            mf0 r6 = defpackage.mf0.b
            if (r5 != r6) goto L4c
            goto L4d
        L4c:
            r5 = r1
        L4d:
            if (r5 != r6) goto L50
            return r5
        L50:
            return r1
        L51:
            r5 = move-exception
            r6.D()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yn2.g(ie0):java.lang.Object");
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
