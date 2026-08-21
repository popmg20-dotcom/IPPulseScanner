package defpackage;

import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a74 implements gf {
    public final /* synthetic */ lh A;
    public final /* synthetic */ lh X;
    public final /* synthetic */ c74 b;
    public final /* synthetic */ b74 f;
    public final /* synthetic */ int z;

    public /* synthetic */ a74(c74 c74Var, b74 b74Var, int i, lh lhVar, lh lhVar2) {
        this.b = c74Var;
        this.f = b74Var;
        this.z = i;
        this.A = lhVar;
        this.X = lhVar2;
    }

    @Override // defpackage.gf
    /* JADX INFO: renamed from: apply */
    public final nc2 mo23apply(Object obj) {
        b74 b74Var = this.f;
        Surface surface = (Surface) obj;
        c74 c74Var = this.b;
        c74Var.getClass();
        surface.getClass();
        try {
            b74Var.d();
            d74 d74Var = new d74(surface, this.z, c74Var.g.a, this.A, this.X);
            d74Var.B0.f.a(new y64(b74Var, 1), yu0.a());
            r25.j("Consumer can only be linked once.", b74Var.r == null);
            b74Var.r = d74Var;
            return n12.F(d74Var);
        } catch (cn0 e) {
            return new zy1(1, e);
        }
    }
}
