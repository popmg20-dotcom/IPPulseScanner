package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class d0 implements c8 {
    public final int a;
    public final Object b;
    public final Predicate c;
    public final Supplier d;

    public d0(boolean z, x6 x6Var, Object obj, Predicate predicate, Supplier supplier) {
        this.a = (z ? 0 : w6.r) | w6.u;
        this.b = obj;
        this.c = predicate;
        this.d = supplier;
    }

    @Override // j$.util.stream.c8
    public final Object a(a aVar, Spliterator spliterator) {
        d8 d8Var = (d8) this.d.get();
        aVar.N(spliterator, d8Var);
        Object obj = d8Var.get();
        return obj != null ? obj : this.b;
    }

    @Override // j$.util.stream.c8
    public final Object b(a aVar, Spliterator spliterator) {
        return new j0(this, w6.ORDERED.k(aVar.f), aVar, spliterator).invoke();
    }

    @Override // j$.util.stream.c8
    public final int f() {
        return this.a;
    }
}
