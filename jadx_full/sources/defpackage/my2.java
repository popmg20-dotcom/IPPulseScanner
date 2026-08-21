package defpackage;

import kotlin.Function;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class my2 implements ag1, km1 {
    public final /* synthetic */ hx3 b;

    public my2(hx3 hx3Var) {
        this.b = hx3Var;
    }

    @Override // defpackage.km1
    public final Function a() {
        return new mm1(2, this.b, hx3.class, "send", "send(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ag1) && (obj instanceof km1)) {
            return a().equals(((km1) obj).a());
        }
        return false;
    }

    @Override // defpackage.ag1
    public final Object h(Object obj, ge0 ge0Var) {
        Object objA = this.b.f.a(ge0Var, (kz2) obj);
        return objA == mf0.b ? objA : xl4.a;
    }

    public final int hashCode() {
        return a().hashCode();
    }
}
