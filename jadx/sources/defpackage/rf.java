package defpackage;

import android.os.Build;
import android.util.Log;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rf {
    public final cf0 a;
    public oj1 b;
    public wk4 c = new rz2();
    public ez2 d;
    public final n02 e;
    public final we0 f;
    public final oj1 g;
    public volatile boolean h;
    public volatile int i;
    public final m24 j;
    public final fe3 k;
    public final hv3 l;
    public final /* synthetic */ vf m;

    public rf(vf vfVar, cf0 cf0Var) {
        this.m = vfVar;
        this.a = cf0Var;
        ez2 ez2Var = ez2.e;
        ez2Var.getClass();
        this.d = ez2Var;
        n02 n02Var = new n02(9);
        this.e = n02Var;
        we0 we0Var = new we0();
        this.f = we0Var;
        this.g = new oj1((byte) 0, 26);
        this.j = n24.a(Boolean.FALSE);
        this.k = (fe3) n02Var.A;
        this.l = iv3.a(0, 64, jp.f);
        ((CopyOnWriteArrayList) we0Var.f).add(new fn(13, this));
    }

    public final Object a(int i) {
        Object objI;
        Object objI2;
        m24 m24Var = this.j;
        do {
            objI = m24Var.i();
            ((Boolean) objI).getClass();
        } while (!m24Var.g(objI, Boolean.TRUE));
        this.h = true;
        this.i = i;
        if (Build.ID != null && Log.isLoggable("Paging", 2)) {
            Log.v("Paging", "Accessing item index[" + i + ']', null);
        }
        oj1 oj1Var = this.b;
        if (oj1Var != null) {
            oj1Var.u(this.d.a(i));
        }
        Object objB = this.d.b(i);
        m24 m24Var2 = this.j;
        do {
            objI2 = m24Var2.i();
            ((Boolean) objI2).getClass();
        } while (!m24Var2.g(objI2, Boolean.FALSE));
        return objB;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.util.List r18, int r19, int r20, boolean r21, defpackage.gd2 r22, defpackage.gd2 r23, defpackage.oj1 r24, defpackage.ie0 r25) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rf.b(java.util.List, int, int, boolean, gd2, gd2, oj1, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(defpackage.ke0 r17, defpackage.ie0 r18) {
        /*
            Method dump skipped, instruction units count: 714
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rf.c(ke0, ie0):java.lang.Object");
    }
}
