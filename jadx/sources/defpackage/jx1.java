package defpackage;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jx1 {
    public static final px1 a;

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
    static {
        Object size = new Size(640, 480);
        Object sj3Var = new sj3(pr1.b, new tj3(yx3.b), null);
        qx qxVar = new qx(2);
        pg pgVar = hy1.C;
        qn2 qn2Var = qxVar.b;
        qn2Var.g(pgVar, size);
        qn2Var.g(mn4.e0, 1);
        qn2Var.g(hy1.v, 0);
        qn2Var.g(hy1.F, sj3Var);
        oz0 oz0Var = oz0.d;
        if (!oz0Var.equals(oz0Var)) {
            vp1.n("ImageAnalysis currently only supports SDR");
        } else {
            qn2Var.g(dy1.u, oz0Var);
            a = new px1(sw2.a(qn2Var));
        }
    }
}
