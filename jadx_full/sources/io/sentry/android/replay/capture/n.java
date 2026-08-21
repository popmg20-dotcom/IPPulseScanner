package io.sentry.android.replay.capture;

import defpackage.am1;
import defpackage.r82;
import defpackage.xl4;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n extends r82 implements am1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ o z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(o oVar, int i) {
        super(1);
        this.f = i;
        this.z = oVar;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.f;
        xl4 xl4Var = xl4.a;
        o oVar = this.z;
        switch (i) {
            case 0:
                l lVar = (l) obj;
                lVar.getClass();
                if (lVar instanceof j) {
                    j jVar = (j) lVar;
                    j.a(jVar, oVar.w);
                    oVar.k(oVar.e() + 1);
                    oVar.m(jVar.a.L0);
                }
                break;
            default:
                l lVar2 = (l) obj;
                lVar2.getClass();
                if (lVar2 instanceof j) {
                    j.a((j) lVar2, oVar.w);
                    oVar.k(oVar.e() + 1);
                }
                break;
        }
        return xl4Var;
    }
}
