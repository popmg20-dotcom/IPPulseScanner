package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class tp extends mm1 implements em1 {
    public static final tp y0 = new tp(3, xp.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
    
        return defpackage.xl4.a;
     */
    @Override // defpackage.em1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(Object obj, Object obj2, Object obj3) {
        m30 m30Var;
        xp xpVar = (xp) obj;
        xr3 xr3Var = (xr3) obj2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = xp.A;
        xpVar.getClass();
        m30 m30Var2 = (m30) re.a.getObjectVolatile(xpVar, xp.E0);
        while (true) {
            if (xpVar.x()) {
                xr3Var.X = zp.l;
                break;
            }
            long andIncrement = xp.X.getAndIncrement(xpVar);
            long j = zp.b;
            long j2 = andIncrement / j;
            int i = (int) (andIncrement % j);
            if (m30Var2.A != j2) {
                m30 m30VarM = xpVar.m(j2, m30Var2);
                if (m30VarM == null) {
                    continue;
                } else {
                    m30Var = m30VarM;
                }
            } else {
                m30Var = m30Var2;
            }
            Object objJ = xpVar.J(m30Var, i, andIncrement, xr3Var);
            m30 m30Var3 = m30Var;
            if (objJ == zp.m) {
                if (xr3Var == null) {
                    xr3Var = null;
                }
                if (xr3Var != null) {
                    xr3Var.z = m30Var3;
                    xr3Var.A = i;
                }
            } else if (objJ == zp.o) {
                if (andIncrement < xpVar.t()) {
                    m30Var3.a();
                }
                m30Var2 = m30Var3;
            } else {
                if (objJ == zp.n) {
                    xe.q("unexpected");
                    return null;
                }
                m30Var3.a();
                xr3Var.X = objJ;
            }
        }
    }
}
