package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class f40 extends y32 {
    public final z00 X;

    public f40(z00 z00Var) {
        this.X = z00Var;
    }

    @Override // defpackage.y32
    public final boolean l() {
        return true;
    }

    @Override // defpackage.y32
    public final void m(Throwable th) {
        Unsafe unsafe;
        Unsafe unsafe2;
        e42 e42VarK = k();
        z00 z00Var = this.X;
        Throwable thT = z00Var.t(e42VarK);
        if (z00Var.A()) {
            lv0 lv0Var = (lv0) z00Var.A;
            long j = lv0.y0;
            loop0: while (true) {
                Object objectVolatile = re.a.getObjectVolatile(lv0Var, j);
                br1 br1Var = mv0.b;
                if (n12.c(objectVolatile, br1Var)) {
                    do {
                        unsafe = re.a;
                        if (unsafe.compareAndSwapObject(lv0Var, lv0.y0, br1Var, thT)) {
                            return;
                        }
                    } while (unsafe.getObjectVolatile(lv0Var, j) == br1Var);
                } else {
                    if (objectVolatile instanceof Throwable) {
                        return;
                    }
                    do {
                        unsafe2 = re.a;
                        if (unsafe2.compareAndSwapObject(lv0Var, lv0.y0, objectVolatile, (Object) null)) {
                            break loop0;
                        }
                    } while (unsafe2.getObjectVolatile(lv0Var, j) == objectVolatile);
                }
            }
        }
        z00Var.q(thT);
        if (z00Var.A()) {
            return;
        }
        z00Var.r();
    }
}
