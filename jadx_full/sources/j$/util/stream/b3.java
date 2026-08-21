package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class b3 extends o6 implements a2, u1 {
    @Override // j$.util.stream.d2, j$.util.stream.e2
    public final d2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void accept(double d) {
        t3.c();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.s6, j$.util.stream.d2
    public final Object b() {
        return (int[]) super.b();
    }

    @Override // j$.util.stream.j5
    public final void c(long j) {
        clear();
        s(j);
    }

    @Override // j$.util.stream.h5
    public final /* synthetic */ void d(Integer num) {
        t3.g(this, num);
    }

    @Override // j$.util.stream.j5
    public final boolean e() {
        return false;
    }

    @Override // j$.util.stream.s6, j$.util.stream.d2
    public final void f(int i, Object obj) {
        super.f(i, (int[]) obj);
    }

    @Override // j$.util.stream.s6, j$.util.stream.d2
    public final void g(Object obj) {
        super.g((IntConsumer) obj);
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ e2 j(long j, long j2, IntFunction intFunction) {
        return t3.u(this, j, j2);
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ void k(Object[] objArr, int i) {
        t3.o(this, (Integer[]) objArr, i);
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ Object[] m(IntFunction intFunction) {
        return t3.m(this, intFunction);
    }

    @Override // j$.util.stream.e2
    public final int o() {
        return 0;
    }

    @Override // j$.util.stream.o6, j$.util.stream.s6, java.lang.Iterable, j$.lang.a, j$.util.Collection
    public final j$.util.c1 spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.stream.w1
    public final e2 build() {
        return this;
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void accept(long j) {
        t3.l();
        throw null;
    }

    @Override // j$.util.stream.o6, j$.util.stream.s6, java.lang.Iterable, j$.lang.a, j$.util.Collection
    public final Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.stream.e2
    public final e2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        d((Integer) obj);
    }

    @Override // j$.util.stream.u1, j$.util.stream.w1
    public final a2 build() {
        return this;
    }

    @Override // j$.util.stream.j5
    public final void end() {
    }
}
