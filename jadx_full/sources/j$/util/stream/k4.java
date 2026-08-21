package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class k4 implements o4, h5 {
    public boolean a;
    public int b;
    public final /* synthetic */ IntBinaryOperator c;

    public k4(IntBinaryOperator intBinaryOperator) {
        this.c = intBinaryOperator;
    }

    @Override // j$.util.stream.j5, j$.util.stream.h5, java.util.function.IntConsumer
    public final void accept(int i) {
        if (!this.a) {
            this.b = this.c.applyAsInt(this.b, i);
        } else {
            this.a = false;
            this.b = i;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.j5
    public final void c(long j) {
        this.a = true;
        this.b = 0;
    }

    @Override // j$.util.stream.h5
    public final /* synthetic */ void d(Integer num) {
        t3.g(this, num);
    }

    @Override // j$.util.stream.j5
    public final boolean e() {
        return false;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.a ? j$.util.b0.c : new j$.util.b0(this.b);
    }

    @Override // j$.util.stream.o4
    public final void i(o4 o4Var) {
        k4 k4Var = (k4) o4Var;
        if (k4Var.a) {
            return;
        }
        accept(k4Var.b);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.time.a.c(this, intConsumer);
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void accept(long j) {
        t3.l();
        throw null;
    }

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        d((Integer) obj);
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void accept(double d) {
        t3.c();
        throw null;
    }

    @Override // j$.util.stream.j5
    public final void end() {
    }
}
