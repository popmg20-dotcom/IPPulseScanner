package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class s1 extends b {
    public final j$.time.format.t j;

    public s1(s1 s1Var, Spliterator spliterator) {
        super(s1Var, spliterator);
        this.j = s1Var.j;
    }

    @Override // j$.util.stream.d
    public final Object a() {
        a aVar = this.a;
        q1 q1Var = (q1) ((Supplier) this.j.c).get();
        aVar.N(this.b, q1Var);
        boolean z = q1Var.b;
        if (z == ((r1) this.j.b).b) {
            Boolean boolValueOf = Boolean.valueOf(z);
            AtomicReference atomicReference = this.h;
            while (!atomicReference.compareAndSet(null, boolValueOf) && atomicReference.get() == null) {
            }
        }
        return null;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new s1(this, spliterator);
    }

    @Override // j$.util.stream.b
    public final Object h() {
        return Boolean.valueOf(!((r1) this.j.b).b);
    }

    public s1(j$.time.format.t tVar, a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.j = tVar;
    }
}
