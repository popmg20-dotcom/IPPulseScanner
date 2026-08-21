package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ry1 {
    public final Context a;
    public final Object b;
    public final ty1 c;
    public final Bitmap.Config d;
    public final m23 e;
    public final qg4 f;
    public final lr1 g;
    public final ra4 h;
    public final boolean i;
    public final boolean j;
    public final mu k;
    public final mu l;
    public final mu m;
    public final ef0 n;
    public final ef0 o;
    public final ef0 p;
    public final ef0 q;
    public final r92 r;
    public final xx3 s;
    public final sp3 t;
    public final i03 u;
    public final Integer v;
    public final jn0 w;
    public final em0 x;

    public ry1(Context context, Object obj, ty1 ty1Var, Bitmap.Config config, m23 m23Var, qg4 qg4Var, lr1 lr1Var, ra4 ra4Var, boolean z, boolean z2, mu muVar, mu muVar2, mu muVar3, ef0 ef0Var, ef0 ef0Var2, ef0 ef0Var3, ef0 ef0Var4, r92 r92Var, xx3 xx3Var, sp3 sp3Var, i03 i03Var, Integer num, jn0 jn0Var, em0 em0Var) {
        this.a = context;
        this.b = obj;
        this.c = ty1Var;
        this.d = config;
        this.e = m23Var;
        this.f = qg4Var;
        this.g = lr1Var;
        this.h = ra4Var;
        this.i = z;
        this.j = z2;
        this.k = muVar;
        this.l = muVar2;
        this.m = muVar3;
        this.n = ef0Var;
        this.o = ef0Var2;
        this.p = ef0Var3;
        this.q = ef0Var4;
        this.r = r92Var;
        this.s = xx3Var;
        this.t = sp3Var;
        this.u = i03Var;
        this.v = num;
        this.w = jn0Var;
        this.x = em0Var;
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
        if (!(obj instanceof ry1)) {
            return false;
        }
        ry1 ry1Var = (ry1) obj;
        if (!n12.c(this.a, ry1Var.a) || !this.b.equals(ry1Var.b) || !n12.c(this.c, ry1Var.c) || this.d != ry1Var.d || this.e != ry1Var.e) {
            return false;
        }
        g41 g41Var = g41.b;
        return g41Var.equals(g41Var) && n12.c(this.f, ry1Var.f) && n12.c(this.g, ry1Var.g) && this.h.equals(ry1Var.h) && this.i == ry1Var.i && this.j == ry1Var.j && this.k == ry1Var.k && this.l == ry1Var.l && this.m == ry1Var.m && n12.c(this.n, ry1Var.n) && n12.c(this.o, ry1Var.o) && n12.c(this.p, ry1Var.p) && n12.c(this.q, ry1Var.q) && n12.c(this.v, ry1Var.v) && n12.c(this.r, ry1Var.r) && this.s.equals(ry1Var.s) && this.t == ry1Var.t && this.u.equals(ry1Var.u) && this.w.equals(ry1Var.w) && n12.c(this.x, ry1Var.x);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        ty1 ty1Var = this.c;
        int iHashCode2 = (this.u.b.hashCode() + ((this.t.hashCode() + ((this.s.hashCode() + ((this.r.hashCode() + ((this.q.hashCode() + ((this.p.hashCode() + ((this.o.hashCode() + ((this.n.hashCode() + ((this.m.hashCode() + ((this.l.hashCode() + ((this.k.hashCode() + ha0.i((((((this.h.a.hashCode() + ((((this.f.hashCode() + ((((this.e.hashCode() + ((this.d.hashCode() + ((iHashCode + (ty1Var != null ? ty1Var.f.hashCode() : 0)) * 923521)) * 961)) * 29791) + 1) * 31)) * 31) + Arrays.hashCode(this.g.b)) * 31)) * 31) + 1231) * 31) + (this.i ? 1231 : 1237)) * 31, this.j ? 1231 : 1237, 31, 1231, 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 961;
        Integer num = this.v;
        return this.x.hashCode() + ((this.w.hashCode() + ((iHashCode2 + (num != null ? num.hashCode() : 0)) * 887503681)) * 31);
    }
}
