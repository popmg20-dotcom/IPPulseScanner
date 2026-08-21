package j$.util.stream;

import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c5 implements g5 {
    public final j5 a;

    public c5(j5 j5Var) {
        this.a = (j5) Objects.requireNonNull(j5Var);
    }

    @Override // j$.util.stream.j5, j$.util.stream.h5, java.util.function.IntConsumer
    public final /* synthetic */ void accept(int i) {
        t3.k();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.j5
    public void c(long j) {
        this.a.c(j);
    }

    @Override // j$.util.stream.j5
    public boolean e() {
        return this.a.e();
    }

    @Override // j$.util.stream.j5
    public void end() {
        this.a.end();
    }

    @Override // j$.util.stream.g5
    public final /* synthetic */ void n(Double d) {
        t3.d(this, d);
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void accept(long j) {
        t3.l();
        throw null;
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.time.a.b(this, doubleConsumer);
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        n((Double) obj);
    }
}
