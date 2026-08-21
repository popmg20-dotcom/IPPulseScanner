package defpackage;

import java.util.concurrent.CancellationException;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class q53 extends i0 implements y20, qs3 {
    public final xp A;

    public q53(cf0 cf0Var, xp xpVar) {
        super(cf0Var, true);
        this.A = xpVar;
    }

    @Override // defpackage.qs3
    public final Object a(ge0 ge0Var, Object obj) {
        return this.A.a(ge0Var, obj);
    }

    @Override // defpackage.qs3
    public final boolean b(Throwable th) {
        return this.A.d(th, false);
    }

    @Override // defpackage.qs3
    public final Object e(Object obj) {
        return this.A.e(obj);
    }

    @Override // defpackage.e42, defpackage.v32
    public final void g(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new w32(u(), null, this);
        }
        r(cancellationException);
    }

    @Override // defpackage.y20
    public final v62 h() {
        return this.A.h();
    }

    @Override // defpackage.y20
    public final Object i() {
        return this.A.i();
    }

    @Override // defpackage.y20
    public final rp iterator() {
        xp xpVar = this.A;
        xpVar.getClass();
        return new rp(xpVar);
    }

    @Override // defpackage.i0
    public final void j0(Throwable th, boolean z) {
        if (this.A.d(th, false) || z) {
            return;
        }
        r25.E(this.z, th);
    }

    @Override // defpackage.y20
    public final Object k(z70 z70Var) {
        xp xpVar = this.A;
        xpVar.getClass();
        return xp.E(xpVar, z70Var);
    }

    @Override // defpackage.i0
    public final void k0(Object obj) {
        this.A.b(null);
    }

    public final void m0(p53 p53Var) {
        Unsafe unsafe;
        Unsafe unsafe2;
        xp xpVar = this.A;
        xpVar.getClass();
        long j = xp.C0;
        do {
            unsafe = re.a;
            if (unsafe.compareAndSwapObject(xpVar, xp.C0, (Object) null, p53Var)) {
                return;
            }
        } while (unsafe.getObjectVolatile(xpVar, j) == null);
        while (true) {
            Object objectVolatile = re.a.getObjectVolatile(xpVar, j);
            br1 br1Var = zp.q;
            if (objectVolatile != br1Var) {
                if (objectVolatile == zp.r) {
                    xe.q("Another handler was already registered and successfully invoked");
                    return;
                } else {
                    ad0.o(objectVolatile, "Another handler is already registered: ");
                    return;
                }
            }
            br1 br1Var2 = zp.r;
            do {
                unsafe2 = re.a;
                if (unsafe2.compareAndSwapObject(xpVar, xp.C0, br1Var, br1Var2)) {
                    p53Var.g(xpVar.p());
                    return;
                }
            } while (unsafe2.getObjectVolatile(xpVar, j) == br1Var);
        }
    }

    @Override // defpackage.e42
    public final void r(CancellationException cancellationException) {
        this.A.d(cancellationException, true);
        q(cancellationException);
    }
}
