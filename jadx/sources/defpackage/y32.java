package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y32 extends xd2 implements zv0, oz1 {
    public e42 A;

    @Override // defpackage.oz1
    public final gs2 b() {
        return null;
    }

    @Override // defpackage.zv0
    public final void c() {
        y32 y32Var;
        Unsafe unsafe;
        long j;
        e42 e42VarK = k();
        while (true) {
            Object objH = e42VarK.H();
            if (objH instanceof y32) {
                if (objH != this) {
                    return;
                }
                do {
                    unsafe = re.a;
                    j = e42.f;
                    if (unsafe.compareAndSwapObject(e42VarK, j, objH, f42.g)) {
                        return;
                    }
                } while (unsafe.getObjectVolatile(e42VarK, j) == objH);
            } else {
                if (!(objH instanceof oz1) || ((oz1) objH).b() == null) {
                    return;
                }
                while (true) {
                    Object objG = this.g();
                    if (objG instanceof pi3) {
                        return;
                    }
                    if (objG == this) {
                        return;
                    }
                    objG.getClass();
                    xd2 xd2Var = (xd2) objG;
                    Unsafe unsafe2 = re.a;
                    long j2 = xd2.z;
                    pi3 pi3Var = (pi3) unsafe2.getObjectVolatile(xd2Var, j2);
                    if (pi3Var == null) {
                        pi3Var = new pi3(xd2Var);
                        unsafe2.putObjectVolatile(xd2Var, j2, pi3Var);
                    }
                    pi3 pi3Var2 = pi3Var;
                    while (true) {
                        Unsafe unsafe3 = re.a;
                        long j3 = xd2.b;
                        y32Var = this;
                        if (unsafe3.compareAndSwapObject(y32Var, j3, objG, pi3Var2)) {
                            xd2Var.e();
                            return;
                        } else if (unsafe3.getObjectVolatile(y32Var, j3) != objG) {
                            break;
                        } else {
                            this = y32Var;
                        }
                    }
                    this = y32Var;
                }
            }
        }
    }

    public v32 getParent() {
        return k();
    }

    @Override // defpackage.oz1
    public final boolean isActive() {
        return true;
    }

    public final e42 k() {
        e42 e42Var = this.A;
        if (e42Var != null) {
            return e42Var;
        }
        n12.T("job");
        throw null;
    }

    public abstract boolean l();

    public abstract void m(Throwable th);

    @Override // defpackage.xd2
    public final String toString() {
        return getClass().getSimpleName() + '@' + ek0.l(this) + "[job@" + ek0.l(k()) + ']';
    }
}
