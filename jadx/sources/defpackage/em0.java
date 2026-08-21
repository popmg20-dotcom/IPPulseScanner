package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class em0 {
    public final ef0 a;
    public final ef0 b;
    public final ef0 c;
    public final ef0 d;
    public final Bitmap.Config e;

    public em0() {
        gm0 gm0Var = qv0.a;
        tq1 tq1Var = qf2.a.X;
        pl0 pl0Var = pl0.z;
        Bitmap.Config config = j.a;
        this.a = tq1Var;
        this.b = pl0Var;
        this.c = pl0Var;
        this.d = pl0Var;
        this.e = config;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof em0)) {
            return false;
        }
        em0 em0Var = (em0) obj;
        if (!n12.c(this.a, em0Var.a) || !n12.c(this.b, em0Var.b) || !n12.c(this.c, em0Var.c) || !n12.c(this.d, em0Var.d)) {
            return false;
        }
        ls2 ls2Var = qg4.a;
        return ls2Var.equals(ls2Var) && this.e == em0Var.e;
    }

    public final int hashCode() {
        int iHashCode = (((((this.e.hashCode() + ((m23.b.hashCode() + ((ls2.class.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + 1231) * 31) + 1237) * 923521;
        mu muVar = mu.ENABLED;
        return muVar.hashCode() + ((muVar.hashCode() + ((muVar.hashCode() + iHashCode) * 31)) * 31);
    }
}
