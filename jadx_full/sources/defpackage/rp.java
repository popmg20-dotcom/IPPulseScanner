package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class rp implements xs4 {
    public Object b = zp.p;
    public z00 f;
    public final /* synthetic */ xp z;

    public rp(xp xpVar) {
        this.z = xpVar;
    }

    @Override // defpackage.xs4
    public final void a(sr3 sr3Var, int i) {
        z00 z00Var = this.f;
        if (z00Var != null) {
            z00Var.a(sr3Var, i);
        }
    }

    public final Object b(ie0 ie0Var) {
        m30 m30Var;
        Boolean bool;
        m30 m30Var2;
        Object obj = this.b;
        boolean z = true;
        if (obj == zp.p || obj == zp.l) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = xp.y0;
            xp xpVar = this.z;
            m30 m30Var3 = (m30) atomicReferenceFieldUpdater.get(xpVar);
            while (true) {
                if (xpVar.x()) {
                    this.b = zp.l;
                    Throwable thP = xpVar.p();
                    if (thP != null) {
                        int i = t14.a;
                        throw thP;
                    }
                    z = false;
                } else {
                    long andIncrement = xp.X.getAndIncrement(xpVar);
                    long j = zp.b;
                    long j2 = andIncrement / j;
                    int i2 = (int) (andIncrement % j);
                    if (m30Var3.A != j2) {
                        m30 m30VarM = xpVar.m(j2, m30Var3);
                        if (m30VarM == null) {
                            continue;
                        } else {
                            m30Var = m30VarM;
                        }
                    } else {
                        m30Var = m30Var3;
                    }
                    Object objJ = xpVar.J(m30Var, i2, andIncrement, null);
                    br1 br1Var = zp.m;
                    pp ppVar = null;
                    if (objJ == br1Var) {
                        xe.q("unreachable");
                        return null;
                    }
                    br1 br1Var2 = zp.o;
                    if (objJ == br1Var2) {
                        if (andIncrement < xpVar.t()) {
                            m30Var.a();
                        }
                        m30Var3 = m30Var;
                    } else {
                        if (objJ == zp.n) {
                            z00 z00VarT = vo.t(p95.u(ie0Var));
                            try {
                                this.f = z00VarT;
                                Object objJ2 = xpVar.J(m30Var, i2, andIncrement, this);
                                am1 am1Var = xpVar.f;
                                if (objJ2 == br1Var) {
                                    a(m30Var, i2);
                                } else {
                                    if (objJ2 == br1Var2) {
                                        if (andIncrement < xpVar.t()) {
                                            m30Var.a();
                                        }
                                        m30 m30Var4 = (m30) xp.y0.get(xpVar);
                                        while (true) {
                                            if (xpVar.x()) {
                                                z00 z00Var = this.f;
                                                z00Var.getClass();
                                                this.f = null;
                                                this.b = zp.l;
                                                Throwable thP2 = xpVar.p();
                                                if (thP2 == null) {
                                                    z00Var.d(Boolean.FALSE);
                                                } else {
                                                    z00Var.d(new tk3(thP2));
                                                }
                                            } else {
                                                long andIncrement2 = xp.X.getAndIncrement(xpVar);
                                                long j3 = zp.b;
                                                long j4 = andIncrement2 / j3;
                                                int i3 = (int) (andIncrement2 % j3);
                                                if (m30Var4.A != j4) {
                                                    m30 m30VarM2 = xpVar.m(j4, m30Var4);
                                                    if (m30VarM2 != null) {
                                                        m30Var2 = m30VarM2;
                                                    }
                                                } else {
                                                    m30Var2 = m30Var4;
                                                }
                                                Object objJ3 = xpVar.J(m30Var2, i3, andIncrement2, this);
                                                m30 m30Var5 = m30Var2;
                                                if (objJ3 == zp.m) {
                                                    a(m30Var5, i3);
                                                    break;
                                                }
                                                if (objJ3 == zp.o) {
                                                    if (andIncrement2 < xpVar.t()) {
                                                        m30Var5.a();
                                                    }
                                                    m30Var4 = m30Var5;
                                                } else {
                                                    if (objJ3 == zp.n) {
                                                        throw new IllegalStateException("unexpected");
                                                    }
                                                    m30Var5.a();
                                                    this.b = objJ3;
                                                    this.f = null;
                                                    bool = Boolean.TRUE;
                                                    if (am1Var != null) {
                                                        ppVar = new pp(am1Var, objJ3);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        m30Var.a();
                                        this.b = objJ2;
                                        this.f = null;
                                        bool = Boolean.TRUE;
                                        if (am1Var != null) {
                                            ppVar = new pp(am1Var, objJ2);
                                        }
                                    }
                                    z00VarT.l(bool, ppVar);
                                }
                                return z00VarT.u();
                            } catch (Throwable th) {
                                z00VarT.D();
                                throw th;
                            }
                        }
                        m30Var.a();
                        this.b = objJ;
                    }
                }
            }
        }
        return Boolean.valueOf(z);
    }

    public final Object c() {
        Object obj = this.b;
        br1 br1Var = zp.p;
        if (obj == br1Var) {
            xe.q("`hasNext()` has not been invoked");
            return null;
        }
        this.b = br1Var;
        if (obj != zp.l) {
            return obj;
        }
        Throwable thQ = this.z.q();
        int i = t14.a;
        throw thQ;
    }
}
