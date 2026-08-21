package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kb0 implements ss3 {
    public final AtomicReference a;

    public kb0(ss3 ss3Var) {
        this.a = new AtomicReference(ss3Var);
    }

    @Override // defpackage.ss3
    public final Iterator iterator() {
        ss3 ss3Var = (ss3) this.a.getAndSet(null);
        if (ss3Var != null) {
            return ss3Var.iterator();
        }
        xe.q("This sequence can be consumed only once.");
        return null;
    }
}
