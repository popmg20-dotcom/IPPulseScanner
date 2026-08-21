package defpackage;

import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qb3 {
    public static final Path a;

    static {
        Supplier supplier;
        AtomicReference atomicReference = y03.a;
        synchronized (atomicReference) {
            supplier = (Supplier) atomicReference.get();
        }
        a = (supplier == null ? x03.a : zo2.e(supplier.get())).resolve(".ssh");
    }
}
