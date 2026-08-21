package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class yg1 extends ie0 {
    public /* synthetic */ Object A;
    public int X;
    public final /* synthetic */ pg1 Y;
    public ah1 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yg1(pg1 pg1Var, ge0 ge0Var) {
        super(ge0Var);
        this.Y = pg1Var;
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        this.A = obj;
        this.X |= Integer.MIN_VALUE;
        return this.Y.a(null, this);
    }
}
