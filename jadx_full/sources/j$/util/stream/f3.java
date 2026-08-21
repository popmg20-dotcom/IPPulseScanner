package j$.util.stream;

import j$.util.Spliterator;
import java.util.Deque;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f3 extends h3 implements j$.util.c1 {
    @Override // j$.util.c1
    public final void forEachRemaining(Object obj) {
        if (this.a == null) {
            return;
        }
        if (this.d != null) {
            while (tryAdvance(obj)) {
            }
            return;
        }
        Spliterator spliterator = this.c;
        if (spliterator != null) {
            ((j$.util.c1) spliterator).forEachRemaining(obj);
            return;
        }
        Deque dequeB = b();
        while (true) {
            d2 d2Var = (d2) h3.a(dequeB);
            if (d2Var == null) {
                this.a = null;
                return;
            }
            d2Var.g(obj);
        }
    }

    @Override // j$.util.c1
    public final boolean tryAdvance(Object obj) {
        d2 d2Var;
        if (!c()) {
            return false;
        }
        boolean zTryAdvance = ((j$.util.c1) this.d).tryAdvance(obj);
        if (!zTryAdvance) {
            if (this.c == null && (d2Var = (d2) h3.a(this.e)) != null) {
                j$.util.c1 c1VarSpliterator = d2Var.spliterator();
                this.d = c1VarSpliterator;
                return c1VarSpliterator.tryAdvance(obj);
            }
            this.a = null;
        }
        return zTryAdvance;
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        forEachRemaining((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return tryAdvance((Object) doubleConsumer);
    }
}
