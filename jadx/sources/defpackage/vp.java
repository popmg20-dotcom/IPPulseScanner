package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class vp extends ie0 {
    public /* synthetic */ Object A;
    public final /* synthetic */ xp X;
    public int Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vp(xp xpVar, ie0 ie0Var) {
        super(ie0Var);
        this.X = xpVar;
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        this.A = obj;
        this.Y |= Integer.MIN_VALUE;
        Object objE = xp.E(this.X, this);
        return objE == mf0.b ? objE : new l30(objE);
    }
}
