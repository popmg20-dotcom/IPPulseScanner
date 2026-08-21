package defpackage;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b74 extends dn0 {
    public final yv o;
    public final vv p;
    public dn0 q;
    public d74 r;

    public b74(Size size, int i) {
        super(size, i);
        vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        vvVar.a = fw.class;
        try {
            this.p = vvVar;
            vvVar.a = "SettableFuture hashCode: " + hashCode();
        } catch (Exception e) {
            yvVar.b(e);
        }
        this.o = yvVar;
    }

    @Override // defpackage.dn0
    public final void a() {
        super.a();
        co4.S(new y64(this, 2));
    }

    @Override // defpackage.dn0
    public final nc2 f() {
        return this.o;
    }

    public final boolean g(dn0 dn0Var, Runnable runnable) {
        boolean z;
        Size size = this.h;
        co4.h();
        dn0Var.getClass();
        int i = dn0Var.i;
        Size size2 = dn0Var.h;
        dn0 dn0Var2 = this.q;
        if (dn0Var2 == dn0Var) {
            return false;
        }
        r25.j("A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider", dn0Var2 == null);
        r25.f(size.equals(size2), "The provider's size(" + size + ") must match the parent(" + size2 + ")");
        int i2 = this.i;
        r25.f(i2 == i, "The provider's format(" + i2 + ") must match the parent(" + i + ")");
        synchronized (this.a) {
            z = this.c;
        }
        r25.j("The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.", !z);
        this.q = dn0Var;
        n12.N(dn0Var.c(), this.p);
        dn0Var.d();
        n12.K(this.e).a(new z64(dn0Var, 1), yu0.a());
        n12.K(dn0Var.g).a(runnable, vf2.q());
        return true;
    }
}
