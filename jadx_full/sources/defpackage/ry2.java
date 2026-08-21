package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ry2 extends v74 implements em1 {
    public /* synthetic */ do1 X;
    public /* synthetic */ do1 Y;
    public final /* synthetic */ hd2 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ry2(hd2 hd2Var, ge0 ge0Var) {
        super(3, ge0Var);
        this.Z = hd2Var;
    }

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        ry2 ry2Var = new ry2(this.Z, (ge0) obj3);
        ry2Var.X = (do1) obj;
        ry2Var.Y = (do1) obj2;
        return ry2Var.p(xl4.a);
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        n12.S(obj);
        do1 do1Var = this.X;
        do1 do1Var2 = this.Y;
        do1Var2.getClass();
        do1Var.getClass();
        int i = do1Var2.a;
        int i2 = do1Var.a;
        return i > i2 ? true : i < i2 ? false : je.e0(do1Var2.b, do1Var.b, this.Z) ? do1Var2 : do1Var;
    }
}
