package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class pa0 extends xp {
    public final jp I0;

    public pa0(int i, jp jpVar, am1 am1Var) {
        super(i, am1Var);
        this.I0 = jpVar;
        if (jpVar == jp.b) {
            s53.t("This implementation does not support suspension for senders, use ", dh3.a(xp.class).c(), " instead");
            throw null;
        }
        if (i >= 1) {
            return;
        }
        e04.f(ha0.k("Buffered channel capacity must be at least 1, but ", i, " was specified"));
        throw null;
    }

    public final Object N(Object obj, boolean z) {
        am1 am1Var;
        t80 t80VarH;
        jp jpVar = this.I0;
        jp jpVar2 = jp.z;
        xl4 xl4Var = xl4.a;
        xs4 xs4Var = null;
        if (jpVar == jpVar2) {
            Object objE = super.e(obj);
            if (!(objE instanceof k30) || (objE instanceof j30)) {
                return objE;
            }
            if (z && (am1Var = this.f) != null && (t80VarH = ez4.h(am1Var, obj, null)) != null) {
                throw t80VarH;
            }
        } else {
            Object obj2 = obj;
            Object obj3 = zp.d;
            m30 m30Var = (m30) re.a.getObjectVolatile(this, xp.G0);
            while (true) {
                long andIncrement = xp.A.getAndIncrement(this);
                long j = 1152921504606846975L & andIncrement;
                boolean zW = w(andIncrement, false);
                int i = zp.b;
                long j2 = i;
                long j3 = j / j2;
                xs4 xs4Var2 = xs4Var;
                int i2 = (int) (j % j2);
                if (m30Var.A != j3) {
                    m30 m30VarN = n(j3, m30Var);
                    if (m30VarN != null) {
                        m30Var = m30VarN;
                    } else {
                        if (zW) {
                            return new j30(s());
                        }
                        xs4Var = xs4Var2;
                    }
                }
                int iK = K(m30Var, i2, obj2, j, obj3, zW);
                if (iK == 0) {
                    m30Var.a();
                    return xl4Var;
                }
                if (iK == 1) {
                    break;
                }
                if (iK != 2) {
                    if (iK == 3) {
                        xe.q("unexpected");
                        return xs4Var2;
                    }
                    if (iK == 4) {
                        if (j < r()) {
                            m30Var.a();
                        }
                        return new j30(s());
                    }
                    if (iK == 5) {
                        m30Var.a();
                    }
                    obj2 = obj;
                    xs4Var = xs4Var2;
                } else {
                    if (zW) {
                        m30Var.i();
                        return new j30(s());
                    }
                    xs4 xs4Var3 = obj3 instanceof xs4 ? (xs4) obj3 : xs4Var2;
                    if (xs4Var3 != null) {
                        xs4Var3.a(m30Var, i2 + i);
                    }
                    j((m30Var.A * j2) + ((long) i2));
                }
            }
        }
        return xl4Var;
    }

    @Override // defpackage.xp, defpackage.qs3
    public final Object a(ge0 ge0Var, Object obj) throws Throwable {
        t80 t80VarH;
        if (!(N(obj, true) instanceof j30)) {
            return xl4.a;
        }
        am1 am1Var = this.f;
        if (am1Var == null || (t80VarH = ez4.h(am1Var, obj, null)) == null) {
            throw s();
        }
        ek0.b(t80VarH, s());
        throw t80VarH;
    }

    @Override // defpackage.xp, defpackage.qs3
    public final Object e(Object obj) {
        return N(obj, false);
    }

    @Override // defpackage.xp
    public final boolean z() {
        return this.I0 == jp.f;
    }
}
