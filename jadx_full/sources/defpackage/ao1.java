package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ao1 implements Cloneable {
    public final co1 b;
    public co1 f;

    public ao1(co1 co1Var) {
        this.b = co1Var;
        if (co1Var.g()) {
            xe.k("Default instance must be immutable.");
            throw null;
        }
        this.f = co1Var.i();
    }

    public final co1 a() {
        co1 co1VarB = b();
        co1VarB.getClass();
        if (co1.f(co1VarB, true)) {
            return co1VarB;
        }
        throw new wl4();
    }

    public final co1 b() {
        boolean zG = this.f.g();
        co1 co1Var = this.f;
        if (!zG) {
            return co1Var;
        }
        co1Var.getClass();
        v93 v93Var = v93.c;
        v93Var.getClass();
        v93Var.a(co1Var.getClass()).b(co1Var);
        co1Var.h();
        return this.f;
    }

    public final void c() {
        if (this.f.g()) {
            return;
        }
        co1 co1VarI = this.b.i();
        co1 co1Var = this.f;
        v93 v93Var = v93.c;
        v93Var.getClass();
        v93Var.a(co1VarI.getClass()).a(co1VarI, co1Var);
        this.f = co1VarI;
    }

    public final Object clone() {
        ao1 ao1Var = (ao1) this.b.c(5);
        ao1Var.f = b();
        return ao1Var;
    }
}
