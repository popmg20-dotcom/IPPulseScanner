package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dj1 extends r4 {
    public final /* synthetic */ AtomicReference a;

    public dj1(AtomicReference atomicReference) {
        this.a = atomicReference;
    }

    @Override // defpackage.r4
    public final void a(Object obj) {
        r4 r4Var = (r4) this.a.get();
        if (r4Var != null) {
            r4Var.a(obj);
        } else {
            xe.q("Operation cannot be started before fragment is in created state");
        }
    }
}
