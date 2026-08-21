package defpackage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class kj4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) {
        try {
            return new AtomicInteger(r62Var.nextInt());
        } catch (NumberFormatException e) {
            throw new l52(e);
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        v72Var.U(((AtomicInteger) obj).get());
    }
}
