package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class de2 extends kn1 {
    public int X;
    public String Y = "";
    public List Z = Collections.EMPTY_LIST;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.h1;
        vn1Var.a(ee2.class, de2.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final ee2 q() {
        ee2 ee2Var = new ee2(this);
        ee2Var.X = "";
        ee2Var.Z = (byte) -1;
        if ((this.X & 2) != 0) {
            this.Z = DesugarCollections.unmodifiableList(this.Z);
            this.X &= -3;
        }
        ee2Var.Y = this.Z;
        int i = this.X;
        if (i != 0 && (i & 1) != 0) {
            ee2Var.X = this.Y;
        }
        R();
        return ee2Var;
    }

    public final void V(ee2 ee2Var) {
        if (ee2Var == ee2.y0) {
            return;
        }
        if (!ee2Var.H().isEmpty()) {
            this.Y = ee2Var.X;
            this.X |= 1;
            S();
        }
        if (!ee2Var.Y.isEmpty()) {
            if (this.Z.isEmpty()) {
                this.Z = ee2Var.Y;
                this.X &= -3;
            } else {
                if ((this.X & 2) == 0) {
                    this.Z = new ArrayList(this.Z);
                    this.X |= 2;
                }
                this.Z.addAll(ee2Var.Y);
            }
            S();
        }
        A(ee2Var.z);
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
                        if (iS == 10) {
                            this.Y = m60Var.r();
                            this.X |= 1;
                        } else if (iS == 18) {
                            je2 je2Var = (je2) m60Var.j(je2.D0, o91Var);
                            if ((this.X & 2) == 0) {
                                this.Z = new ArrayList(this.Z);
                                this.X |= 2;
                            }
                            this.Z.add(je2Var);
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
        return ee2.y0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        ee2 ee2VarQ = q();
        if (ee2VarQ.c()) {
            return ee2VarQ;
        }
        throw a1.C(ee2VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.g1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        ee2 ee2VarQ = q();
        if (ee2VarQ.c()) {
            return ee2VarQ;
        }
        throw a1.C(ee2VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof ee2) {
            V((ee2) c1Var);
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
        if (c1Var instanceof ee2) {
            V((ee2) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
