package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pf extends v74 implements Function2 {
    public /* synthetic */ boolean X;

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        return ((pf) n((ge0) obj2, bool)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        pf pfVar = new pf(2, ge0Var);
        pfVar.X = ((Boolean) obj).booleanValue();
        return pfVar;
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        n12.S(obj);
        return Boolean.valueOf(!this.X);
    }
}
