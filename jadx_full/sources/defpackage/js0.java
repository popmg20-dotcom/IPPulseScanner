package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class js0 extends ln1 {
    public int Y;
    public List Z = Collections.EMPTY_LIST;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.F1;
        vn1Var.a(ns0.class, js0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final ns0 q() {
        ns0 ns0Var = new ns0(this);
        ns0Var.Z = (byte) -1;
        if ((this.Y & 1) != 0) {
            this.Z = DesugarCollections.unmodifiableList(this.Z);
            this.Y &= -2;
        }
        ns0Var.Y = this.Z;
        R();
        return ns0Var;
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return ns0.y0;
    }

    public final void a0(ns0 ns0Var) {
        if (ns0Var == ns0.y0) {
            return;
        }
        if (!ns0Var.Y.isEmpty()) {
            if (this.Z.isEmpty()) {
                this.Z = ns0Var.Y;
                this.Y &= -2;
            } else {
                if ((this.Y & 1) == 0) {
                    this.Z = new ArrayList(this.Z);
                    this.Y |= 1;
                }
                this.Z.addAll(ns0Var.Y);
            }
            S();
        }
        W(ns0Var);
        A(ns0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    if (iS != 0) {
                        if (iS == 10) {
                            ms0 ms0Var = (ms0) m60Var.j(ms0.F0, o91Var);
                            if ((this.Y & 1) == 0) {
                                this.Z = new ArrayList(this.Z);
                                this.Y = 1 | this.Y;
                            }
                            this.Z.add(ms0Var);
                        } else if (!X(m60Var, o91Var, iS)) {
                        }
                    }
                    z = true;
                } catch (s12 e) {
                    throw e.c();
                }
            } catch (Throwable th) {
                S();
                throw th;
            }
        }
        S();
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        ns0 ns0VarQ = q();
        if (ns0VarQ.c()) {
            return ns0VarQ;
        }
        throw a1.C(ns0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return V();
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.E1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        ns0 ns0VarQ = q();
        if (ns0VarQ.c()) {
            return ns0VarQ;
        }
        throw a1.C(ns0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof ns0) {
            a0((ns0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: w */
    public final /* bridge */ /* synthetic */ a1 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    public final a1 x(c1 c1Var) {
        if (c1Var instanceof ns0) {
            a0((ns0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
