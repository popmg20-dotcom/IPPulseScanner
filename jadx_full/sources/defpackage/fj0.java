package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fj0 extends v74 implements Function2 {
    public Object A0;
    public final /* synthetic */ int X;
    public int Y;
    public /* synthetic */ boolean Z;
    public final /* synthetic */ lj0 y0;
    public final /* synthetic */ int z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fj0(lj0 lj0Var, int i, ge0 ge0Var, int i2) {
        super(2, ge0Var);
        this.X = i2;
        this.y0 = lj0Var;
        this.z0 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((fj0) n(ge0Var, bool)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        int i2 = this.z0;
        lj0 lj0Var = this.y0;
        switch (i) {
            case 0:
                fj0 fj0Var = new fj0(lj0Var, i2, ge0Var, 0);
                fj0Var.Z = ((Boolean) obj).booleanValue();
                return fj0Var;
            default:
                fj0 fj0Var2 = new fj0(lj0Var, i2, ge0Var, 1);
                fj0Var2.Z = ((Boolean) obj).booleanValue();
                return fj0Var2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7 */
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
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) throws Throwable {
        Throwable th;
        j24 wd3Var;
        boolean z;
        boolean z2;
        Object obj2;
        int i = this.X;
        int iIntValue = this.z0;
        mf0 mf0Var = mf0.b;
        lj0 lj0Var = this.y0;
        switch (i) {
            case 0:
                boolean z3 = this.Y;
                try {
                } catch (Throwable th2) {
                    th = th2;
                    if (z3 != 0) {
                        nx3 nx3VarC = lj0Var.c();
                        this.A0 = th;
                        this.Z = z3;
                        this.Y = 2;
                        Integer numA = nx3VarC.a();
                        if (numA == mf0Var) {
                            return mf0Var;
                        }
                        obj = numA;
                        th = th;
                        z3 = z3;
                    }
                    wd3Var = new wd3(th, iIntValue);
                    z = z3;
                    return new e03(wd3Var, Boolean.valueOf(z));
                }
                if (z3 == 0) {
                    n12.S(obj);
                    boolean z4 = this.Z;
                    this.Z = z4;
                    this.Y = 1;
                    obj = lj0Var.h(z4, this);
                    z3 = z4;
                    if (obj == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (z3 != 1) {
                        if (z3 != 2) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        boolean z5 = this.Z;
                        th = (Throwable) this.A0;
                        n12.S(obj);
                        z3 = z5;
                        iIntValue = ((Number) obj).intValue();
                        th = th;
                        wd3Var = new wd3(th, iIntValue);
                        z = z3;
                        return new e03(wd3Var, Boolean.valueOf(z));
                    }
                    boolean z6 = this.Z;
                    n12.S(obj);
                    z3 = z6;
                }
                wd3Var = (j24) obj;
                z = z3;
                return new e03(wd3Var, Boolean.valueOf(z));
            default:
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    z2 = this.Z;
                    this.Z = z2;
                    this.Y = 1;
                    obj = ((ee1) lj0Var.A0.getValue()).a(new xi0(3, (ge0) null), this);
                    if (obj == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        obj2 = this.A0;
                        n12.S(obj);
                        iIntValue = ((Number) obj).intValue();
                        obj = obj2;
                        return new fi0(obj == null ? obj.hashCode() : 0, iIntValue, obj);
                    }
                    z2 = this.Z;
                    n12.S(obj);
                }
                if (z2) {
                    nx3 nx3VarC2 = lj0Var.c();
                    this.A0 = obj;
                    this.Y = 2;
                    Integer numA2 = nx3VarC2.a();
                    if (numA2 == mf0Var) {
                        return mf0Var;
                    }
                    Object obj3 = obj;
                    obj = numA2;
                    obj2 = obj3;
                    iIntValue = ((Number) obj).intValue();
                    obj = obj2;
                }
                return new fi0(obj == null ? obj.hashCode() : 0, iIntValue, obj);
        }
    }
}
