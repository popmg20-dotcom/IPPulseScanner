package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class yu extends ie0 {
    public /* synthetic */ Object A;
    public int X;
    public final /* synthetic */ zu Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yu(zu zuVar, ge0 ge0Var) {
        super(ge0Var);
        this.Y = zuVar;
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        this.A = obj;
        this.X |= Integer.MIN_VALUE;
        return this.Y.h(null, this);
    }
}
