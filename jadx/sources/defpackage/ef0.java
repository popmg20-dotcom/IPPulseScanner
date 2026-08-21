package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ef0 extends j0 implements af0 {
    public static final df0 f = new df0(pr1.f, new ji(2));

    public ef0() {
        super(pr1.f);
    }

    @Override // defpackage.j0, defpackage.cf0
    public final cf0 N(bf0 bf0Var) {
        bf0Var.getClass();
        if (bf0Var instanceof df0) {
            df0 df0Var = (df0) bf0Var;
            bf0 bf0Var2 = this.b;
            if ((bf0Var2 != df0Var && df0Var.f != bf0Var2) || ((af0) df0Var.b.g(this)) == null) {
                return this;
            }
        } else if (pr1.f != bf0Var) {
            return this;
        }
        return c41.b;
    }

    @Override // defpackage.j0, defpackage.cf0
    public final af0 Z(bf0 bf0Var) {
        af0 af0Var;
        bf0Var.getClass();
        if (!(bf0Var instanceof df0)) {
            if (pr1.f == bf0Var) {
                return this;
            }
            return null;
        }
        df0 df0Var = (df0) bf0Var;
        bf0 bf0Var2 = this.b;
        if ((bf0Var2 == df0Var || df0Var.f == bf0Var2) && (af0Var = (af0) df0Var.b.g(this)) != null) {
            return af0Var;
        }
        return null;
    }

    public abstract void j0(cf0 cf0Var, Runnable runnable);

    public void n0(cf0 cf0Var, Runnable runnable) {
        mv0.b(this, cf0Var, runnable);
    }

    public boolean q0(cf0 cf0Var) {
        return !(this instanceof al4);
    }

    public ef0 r0(int i) {
        vf2.d(i);
        return new ia2(this, i);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + ek0.l(this);
    }
}
