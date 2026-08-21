package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class nv0 extends iq3 {
    public static final /* synthetic */ long X = re.a.objectFieldOffset(nv0.class.getDeclaredField("_decision$volatile"));
    private volatile /* synthetic */ int _decision$volatile;

    @Override // defpackage.iq3, defpackage.e42
    public final void o(Object obj) {
        p(obj);
    }

    @Override // defpackage.iq3, defpackage.e42
    public final void p(Object obj) {
        while (true) {
            Unsafe unsafe = re.a;
            long j = X;
            int intVolatile = unsafe.getIntVolatile(this, j);
            if (intVolatile != 0) {
                if (intVolatile == 1) {
                    mv0.a(p95.u(this.A), ke0.y(obj));
                    return;
                } else {
                    xe.q("Already resumed");
                    return;
                }
            }
            nv0 nv0Var = this;
            if (unsafe.compareAndSwapInt(nv0Var, j, 0, 2)) {
                return;
            } else {
                this = nv0Var;
            }
        }
    }
}
