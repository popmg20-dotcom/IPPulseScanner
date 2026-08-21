package defpackage;

import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o00 implements ln4 {
    public final qn2 a;

    public o00(qn2 qn2Var) {
        this.a = qn2Var;
        pg pgVar = ta4.U;
        Class cls = (Class) qn2Var.p(pgVar, null);
        if (cls != null && !cls.equals(z34.class)) {
            ad0.k("Invalid target class configuration for ", this, ": ", cls);
            throw null;
        }
        qn2Var.g(mn4.k0, on4.X);
        qn2Var.g(pgVar, z34.class);
        pg pgVar2 = ta4.T;
        if (qn2Var.p(pgVar2, null) == null) {
            qn2Var.g(pgVar2, z34.class.getCanonicalName() + "-" + UUID.randomUUID());
        }
    }

    @Override // defpackage.z81
    public qn2 a() {
        return this.a;
    }

    @Override // defpackage.ln4
    public mn4 b() {
        return new a44(sw2.a(this.a));
    }

    public o00() {
        qn2 qn2VarC = qn2.c();
        this.a = qn2VarC;
        pg pgVar = ta4.U;
        Class cls = (Class) qn2VarC.p(pgVar, null);
        if (cls != null && !cls.equals(n00.class)) {
            ad0.k("Invalid target class configuration for ", this, ": ", cls);
            throw null;
        }
        qn2VarC.g(pgVar, n00.class);
        pg pgVar2 = ta4.T;
        if (qn2VarC.p(pgVar2, null) == null) {
            qn2VarC.g(pgVar2, n00.class.getCanonicalName() + "-" + UUID.randomUUID());
        }
    }
}
