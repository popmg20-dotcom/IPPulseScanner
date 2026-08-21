package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public class k2 extends d {
    public final a h;
    public final LongFunction i;
    public final BinaryOperator j;

    public k2(k2 k2Var, Spliterator spliterator) {
        super(k2Var, spliterator);
        this.h = k2Var.h;
        this.i = k2Var.i;
        this.j = k2Var.j;
    }

    @Override // j$.util.stream.d
    public d c(Spliterator spliterator) {
        return new k2(this, spliterator);
    }

    @Override // j$.util.stream.d
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final e2 a() {
        w1 w1Var = (w1) this.i.apply(this.h.C(this.b));
        this.h.N(this.b, w1Var);
        return w1Var.build();
    }

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        d dVar = this.d;
        if (dVar != null) {
            this.f = (e2) this.j.apply((e2) ((k2) dVar).f, (e2) ((k2) this.e).f);
        }
        super.onCompletion(countedCompleter);
    }

    public k2(a aVar, Spliterator spliterator, LongFunction longFunction, BinaryOperator binaryOperator) {
        super(aVar, spliterator);
        this.h = aVar;
        this.i = longFunction;
        this.j = binaryOperator;
    }
}
