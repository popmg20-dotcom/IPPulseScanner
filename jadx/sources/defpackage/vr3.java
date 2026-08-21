package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class vr3 {
    public final Object a;
    public final em1 b;
    public final em1 c;
    public final Object d;
    public final v74 e;
    public final em1 f;
    public Object g;
    public int h = -1;
    public final /* synthetic */ xr3 i;

    public vr3(xr3 xr3Var, Object obj, em1 em1Var, em1 em1Var2, Object obj2, v74 v74Var, em1 em1Var3) {
        this.i = xr3Var;
        this.a = obj;
        this.b = em1Var;
        this.c = em1Var2;
        this.d = obj2;
        this.e = v74Var;
        this.f = em1Var3;
    }

    public final em1 a(xr3 xr3Var, Object obj) {
        em1 em1Var = this.f;
        if (em1Var != null) {
            return (em1) em1Var.e(xr3Var, this.d, obj);
        }
        return null;
    }

    public final void b() {
        Object obj = this.g;
        if (obj instanceof sr3) {
            ((sr3) obj).h(this.h, this.i.b);
            return;
        }
        zv0 zv0Var = obj instanceof zv0 ? (zv0) obj : null;
        if (zv0Var != null) {
            zv0Var.c();
        }
    }
}
