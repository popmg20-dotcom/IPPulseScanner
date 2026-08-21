package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i0 implements d8 {
    public boolean a;
    public Object b;

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void n(Object obj) {
        if (this.a) {
            return;
        }
        this.a = true;
        this.b = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.j5
    public final boolean e() {
        return this.a;
    }

    @Override // j$.util.stream.j5, j$.util.stream.h5, java.util.function.IntConsumer
    public /* synthetic */ void accept(int i) {
        t3.k();
        throw null;
    }

    @Override // j$.util.stream.j5
    public /* synthetic */ void accept(long j) {
        t3.l();
        throw null;
    }

    @Override // j$.util.stream.j5
    public /* synthetic */ void accept(double d) {
        t3.c();
        throw null;
    }

    @Override // j$.util.stream.j5
    public final void c(long j) {
    }

    @Override // j$.util.stream.j5
    public final void end() {
    }
}
