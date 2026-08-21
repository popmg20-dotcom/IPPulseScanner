package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kl4 extends v74 implements fm1 {
    public int X;
    public /* synthetic */ Throwable Y;
    public /* synthetic */ long Z;

    @Override // defpackage.fm1
    public final Object i(Object obj, Object obj2, Object obj3, Object obj4) {
        long jLongValue = ((Number) obj3).longValue();
        kl4 kl4Var = new kl4(4, (ge0) obj4);
        kl4Var.Y = (Throwable) obj2;
        kl4Var.Z = jLongValue;
        return kl4Var.p(xl4.a);
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        if (i == 0) {
            n12.S(obj);
            Throwable th = this.Y;
            long j = this.Z;
            ue2.g().f(ll4.a, "Cannot check for unfinished work", th);
            long jMin = Math.min(j * 30000, ll4.b);
            this.X = 1;
            Object objE = gb4.E(jMin, this);
            mf0 mf0Var = mf0.b;
            if (objE == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(obj);
        }
        return Boolean.TRUE;
    }
}
