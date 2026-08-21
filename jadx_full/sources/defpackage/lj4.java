package defpackage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class lj4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) {
        return new AtomicBoolean(r62Var.I());
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        v72Var.c0(((AtomicBoolean) obj).get());
    }
}
