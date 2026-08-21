package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cn4 implements af0 {
    public final cn4 b;
    public final lj0 f;

    public cn4(cn4 cn4Var, lj0 lj0Var) {
        this.b = cn4Var;
        this.f = lj0Var;
    }

    @Override // defpackage.cf0
    public final cf0 N(bf0 bf0Var) {
        return tj4.P(this, bf0Var);
    }

    @Override // defpackage.cf0
    public final cf0 X(cf0 cf0Var) {
        return tj4.W(this, cf0Var);
    }

    @Override // defpackage.cf0
    public final af0 Z(bf0 bf0Var) {
        return tj4.A(this, bf0Var);
    }

    public final void a(lj0 lj0Var) {
        if (this.f == lj0Var) {
            xe.q("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
            return;
        }
        cn4 cn4Var = this.b;
        if (cn4Var != null) {
            cn4Var.a(lj0Var);
        }
    }

    @Override // defpackage.cf0
    public final Object c0(Object obj, Function2 function2) {
        return function2.k(obj, this);
    }

    @Override // defpackage.af0
    public final bf0 getKey() {
        return wl3.z0;
    }
}
