package defpackage;

import java.io.IOException;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d64 implements va0 {
    public final wn1 b;

    public d64(wn1 wn1Var) {
        this.b = wn1Var;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        ((f64) this.b.f).close();
    }

    @Override // defpackage.va0
    public final Object m(boolean z, Function2 function2, ie0 ie0Var) {
        f64 f64Var = (f64) this.b.f;
        f64Var.getClass();
        return function2.k(new h64(new c64(f64Var.T())), ie0Var);
    }
}
