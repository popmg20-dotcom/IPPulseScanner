package defpackage;

import androidx.fragment.app.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fj1 extends hj1 {
    public final /* synthetic */ jm1 a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ m4 c;
    public final /* synthetic */ l4 d;
    public final /* synthetic */ o e;

    public fj1(o oVar, jm1 jm1Var, AtomicReference atomicReference, m4 m4Var, l4 l4Var) {
        this.e = oVar;
        this.a = jm1Var;
        this.b = atomicReference;
        this.c = m4Var;
        this.d = l4Var;
    }

    @Override // defpackage.hj1
    public final void a() {
        o oVar = this.e;
        this.b.set(((x4) this.a.apply(null)).d(oVar.generateActivityResultKey(), oVar, this.c, this.d));
    }
}
