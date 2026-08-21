package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class o24 extends b2 {
    public final AtomicReference a = new AtomicReference(null);

    @Override // defpackage.b2
    public final boolean a(a2 a2Var) {
        AtomicReference atomicReference = this.a;
        if (atomicReference.get() != null) {
            return false;
        }
        atomicReference.set(n24.a);
        return true;
    }

    @Override // defpackage.b2
    public final ge0[] b(a2 a2Var) {
        this.a.set(null);
        return ye.a;
    }
}
