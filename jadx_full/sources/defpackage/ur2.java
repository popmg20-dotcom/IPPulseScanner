package defpackage;

import java.nio.file.Path;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ur2 extends ue4 {
    public ur2() {
        super(vp1.a());
    }

    @Override // defpackage.ue4, defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        i52Var.G0(zo2.e(obj).toUri().toString());
    }

    @Override // defpackage.ue4, defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        Path pathE = zo2.e(obj);
        Class clsA = vp1.a();
        e10 e10VarD = zj4Var.d(pathE, g72.Z);
        e10VarD.A = clsA;
        e10 e10VarE = zj4Var.e(i52Var, e10VarD);
        i52Var.G0(pathE.toUri().toString());
        zj4Var.f(i52Var, e10VarE);
    }
}
