package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class b4 extends p4 implements o4, g5 {
    public final /* synthetic */ Supplier b;
    public final /* synthetic */ ObjDoubleConsumer c;
    public final /* synthetic */ p d;

    public b4(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, p pVar) {
        this.b = supplier;
        this.c = objDoubleConsumer;
        this.d = pVar;
    }

    @Override // j$.util.stream.j5
    public final void accept(double d) {
        this.c.accept(this.a, d);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.j5
    public final void c(long j) {
        this.a = this.b.get();
    }

    @Override // j$.util.stream.j5
    public final boolean e() {
        return false;
    }

    @Override // j$.util.stream.o4
    public final void i(o4 o4Var) {
        this.a = this.d.apply(this.a, ((b4) o4Var).a);
    }

    @Override // j$.util.stream.g5
    public final /* synthetic */ void n(Double d) {
        t3.d(this, d);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.time.a.b(this, doubleConsumer);
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void accept(long j) {
        t3.l();
        throw null;
    }

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        n((Double) obj);
    }

    @Override // j$.util.stream.j5, j$.util.stream.h5, java.util.function.IntConsumer
    public final /* synthetic */ void accept(int i) {
        t3.k();
        throw null;
    }

    @Override // j$.util.stream.j5
    public final void end() {
    }
}
