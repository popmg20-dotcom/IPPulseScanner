package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sp extends mm1 implements em1 {
    public final /* synthetic */ int y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sp(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(i, obj, cls, str, str2, i2);
        this.y0 = i3;
    }

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        int i = this.y0;
        xl4 xl4Var = xl4.a;
        Object obj4 = this.f;
        switch (i) {
            case 0:
                am1 am1Var = ((xp) obj4).f;
                am1Var.getClass();
                ez4.g(am1Var, obj2, (cf0) obj3);
                return xl4Var;
            case 1:
                Object obj5 = ((l30) obj2).a;
                cf0 cf0Var = (cf0) obj3;
                am1 am1Var2 = ((xp) obj4).f;
                am1Var2.getClass();
                if (obj5 instanceof k30) {
                    obj5 = null;
                }
                obj5.getClass();
                ez4.g(am1Var2, obj5, cf0Var);
                return xl4Var;
            default:
                ((Number) obj2).intValue();
                return ke0.s((ge0) obj3, new gj3((sl3) obj, 0), ((hj3) obj4).e.a, true);
        }
    }
}
