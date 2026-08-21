package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class s8 extends v8 implements IntConsumer, j$.util.w0 {
    public final IntPredicate e;
    public int f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s8(j$.util.w0 w0Var, s8 s8Var, int i) {
        super(w0Var, s8Var);
        this.g = i;
        this.e = s8Var.e;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        this.d = (this.d + 1) & 63;
        this.f = i;
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.time.a.c(this, intConsumer);
    }

    @Override // j$.util.stream.v8
    public final Spliterator b(Spliterator spliterator) {
        switch (this.g) {
            case 0:
                return new s8((j$.util.w0) spliterator, this, 0);
            default:
                return new s8((j$.util.w0) spliterator, this, 1);
        }
    }

    @Override // j$.util.c1
    public final void forEachRemaining(IntConsumer intConsumer) {
        while (tryAdvance(intConsumer)) {
        }
    }

    @Override // j$.util.c1
    public final boolean tryAdvance(IntConsumer intConsumer) {
        boolean zTryAdvance;
        boolean zTest;
        int i = this.g;
        IntPredicate intPredicate = this.e;
        Spliterator spliterator = this.a;
        boolean z = false;
        switch (i) {
            case 0:
                if (!this.c) {
                    return ((j$.util.w0) spliterator).tryAdvance(intConsumer);
                }
                this.c = false;
                while (true) {
                    zTryAdvance = ((j$.util.w0) spliterator).tryAdvance((IntConsumer) this);
                    if (zTryAdvance && a() && intPredicate.test(this.f)) {
                        z = true;
                    }
                }
                if (!zTryAdvance) {
                    return zTryAdvance;
                }
                if (z) {
                    this.b.set(true);
                }
                intConsumer.accept(this.f);
                return zTryAdvance;
            default:
                if (this.c && a() && ((j$.util.w0) spliterator).tryAdvance((IntConsumer) this)) {
                    zTest = intPredicate.test(this.f);
                    if (zTest) {
                        intConsumer.accept(this.f);
                        return true;
                    }
                } else {
                    zTest = true;
                }
                this.c = false;
                if (!zTest) {
                    this.b.set(true);
                }
                return false;
        }
    }

    @Override // j$.util.stream.v8, j$.util.Spliterator
    public j$.util.w0 trySplit() {
        switch (this.g) {
            case 1:
                if (this.b.get()) {
                    return null;
                }
                return (j$.util.w0) super.trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // j$.util.stream.v8, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.time.a.i(this, consumer);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s8(j$.util.w0 w0Var, IntPredicate intPredicate, int i) {
        super(w0Var);
        this.g = i;
        this.e = intPredicate;
    }

    @Override // j$.util.stream.v8, j$.util.Spliterator
    public /* bridge */ /* synthetic */ Spliterator trySplit() {
        switch (this.g) {
            case 1:
                return trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // j$.util.stream.v8, j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.c1 trySplit() {
        switch (this.g) {
            case 1:
                return trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.time.a.y(this, consumer);
    }
}
