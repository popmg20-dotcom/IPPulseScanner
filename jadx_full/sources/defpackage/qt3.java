package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qt3 implements rt3 {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final rt3 b;

    public qt3(rt3 rt3Var) {
        this.b = rt3Var;
    }

    @Override // defpackage.rt3
    public final void a(tt3 tt3Var) {
        if (this.a.get()) {
            return;
        }
        this.b.a(tt3Var);
    }

    public final void b() {
        this.a.set(true);
    }
}
