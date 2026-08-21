package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f92 extends z14 {
    public final ge0 A;

    /* JADX WARN: Multi-variable type inference failed */
    public f92(cf0 cf0Var, Function2 function2) {
        super(cf0Var, false);
        this.A = ((kk) function2).n(this, this);
    }

    @Override // defpackage.e42
    public final void a0() throws Throwable {
        try {
            mv0.a(p95.u(this.A), xl4.a);
        } catch (Throwable th) {
            th = th;
            if (th instanceof kv0) {
                th = ((kv0) th).b;
            }
            d(new tk3(th));
            throw th;
        }
    }
}
