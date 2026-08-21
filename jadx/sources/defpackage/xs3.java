package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class xs3 implements e14 {
    public final /* synthetic */ Iterator b;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ hq z;

    public xs3(hq hqVar, Iterator it, boolean z) {
        this.z = hqVar;
        this.b = it;
        this.f = z;
    }

    @Override // defpackage.e14
    public final void s(wk0 wk0Var) {
        boolean z;
        b22 b22Var;
        hq hqVar = this.z;
        we2 we2Var = (we2) hqVar.f;
        boolean zIsTraceEnabled = we2Var.isTraceEnabled();
        do {
            Iterator it = this.b;
            boolean zHasNext = it.hasNext();
            z = this.f;
            if (!zHasNext) {
                if (it.hasNext()) {
                    return;
                }
                if (we2Var.isDebugEnabled()) {
                    we2Var.debug("doClose({}) signal close complete immediately={}", this, Boolean.valueOf(z));
                }
                hqVar.X.b1();
                return;
            }
            b22Var = (b22) it.next();
        } while (b22Var == null);
        if (zIsTraceEnabled) {
            we2Var.trace("doClose({}) closing {} immediately={}", this, b22Var, Boolean.valueOf(z));
        }
        b22Var.W0(z).W0(this);
    }
}
