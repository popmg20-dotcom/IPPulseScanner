package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.Comparator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class w7 extends y7 implements Spliterator, Consumer {
    public Object e;

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public final void n(Object obj) {
        this.e = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.y7
    public final Spliterator b(Spliterator spliterator) {
        return new w7(spliterator, this);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        d7 d7Var = null;
        while (true) {
            x7 x7VarF = f();
            if (x7VarF == x7.NO_MORE) {
                return;
            }
            x7 x7Var = x7.MAYBE_MORE;
            Spliterator spliterator = this.a;
            if (x7VarF != x7Var) {
                spliterator.forEachRemaining(consumer);
                return;
            }
            if (d7Var == null) {
                d7Var = new d7();
            } else {
                d7Var.a = 0;
            }
            long j = 0;
            while (spliterator.tryAdvance(d7Var)) {
                j++;
                if (j >= 128) {
                    break;
                }
            }
            if (j == 0) {
                return;
            }
            long jA = a(j);
            for (int i = 0; i < jA; i++) {
                consumer.n(d7Var.b[i]);
            }
        }
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.time.a.m(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.time.a.o(this, i);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        while (f() != x7.NO_MORE && this.a.tryAdvance(this)) {
            if (a(1L) == 1) {
                consumer.n(this.e);
                this.e = null;
                return true;
            }
        }
        return false;
    }
}
