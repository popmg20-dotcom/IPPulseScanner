package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o14 extends kn1 {
    public int X;
    public long Y;
    public List Z = Collections.EMPTY_LIST;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.F0;
        vn1Var.a(p14.class, o14.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final p14 q() {
        p14 p14Var = new p14(this);
        p14Var.X = 0L;
        p14Var.Z = (byte) -1;
        if ((this.X & 2) != 0) {
            this.Z = DesugarCollections.unmodifiableList(this.Z);
            this.X &= -3;
        }
        p14Var.Y = this.Z;
        int i = this.X;
        if (i != 0 && (i & 1) != 0) {
            p14Var.X = this.Y;
        }
        R();
        return p14Var;
    }

    public final void V(p14 p14Var) {
        if (p14Var == p14.y0) {
            return;
        }
        long j = p14Var.X;
        if (j != 0) {
            this.Y = j;
            this.X |= 1;
            S();
        }
        if (!p14Var.Y.isEmpty()) {
            if (this.Z.isEmpty()) {
                this.Z = p14Var.Y;
                this.X &= -3;
            } else {
                if ((this.X & 2) == 0) {
                    this.Z = new ArrayList(this.Z);
                    this.X |= 2;
                }
                this.Z.addAll(p14Var.Y);
            }
            S();
        }
        A(p14Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    if (iS != 0) {
                        if (iS == 8) {
                            this.Y = m60Var.p();
                            this.X |= 1;
                        } else if (iS == 18) {
                            s14 s14Var = (s14) m60Var.j(s14.B0, o91Var);
                            if ((this.X & 2) == 0) {
                                this.Z = new ArrayList(this.Z);
                                this.X |= 2;
                            }
                            this.Z.add(s14Var);
                        } else if (!u().t(iS, m60Var)) {
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

    @Override // defpackage.ol2
    public final c1 a() {
        return p14.y0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        p14 p14VarQ = q();
        if (p14VarQ.c()) {
            return p14VarQ;
        }
        throw a1.C(p14VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.E0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        p14 p14VarQ = q();
        if (p14VarQ.c()) {
            return p14VarQ;
        }
        throw a1.C(p14VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof p14) {
            V((p14) c1Var);
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
        if (c1Var instanceof p14) {
            V((p14) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
