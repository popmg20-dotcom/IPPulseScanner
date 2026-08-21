package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class z7 implements j5 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ z7(Consumer consumer, int i) {
        this.a = i;
        this.b = consumer;
    }

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public final void n(Object obj) {
        int i = this.a;
        Consumer consumer = this.b;
        switch (i) {
            case 0:
                ((t6) consumer).n(obj);
                break;
            default:
                consumer.n(obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.j5
    public final void c(long j) {
        int i = this.a;
    }

    @Override // j$.util.stream.j5
    public final boolean e() {
        switch (this.a) {
        }
        return false;
    }

    @Override // j$.util.stream.j5
    public final void end() {
        int i = this.a;
    }

    @Override // j$.util.stream.j5, j$.util.stream.h5, java.util.function.IntConsumer
    public final /* synthetic */ void accept(int i) {
        switch (this.a) {
            case 0:
                t3.k();
                throw null;
            default:
                t3.k();
                throw null;
        }
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void accept(long j) {
        switch (this.a) {
            case 0:
                t3.l();
                throw null;
            default:
                t3.l();
                throw null;
        }
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void accept(double d) {
        switch (this.a) {
            case 0:
                t3.c();
                throw null;
            default:
                t3.c();
                throw null;
        }
    }

    private final void a(long j) {
    }

    private final void b(long j) {
    }

    private final void f() {
    }

    private final void g() {
    }
}
