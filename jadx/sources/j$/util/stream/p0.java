package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p0 implements c8, d8 {
    public final boolean a;

    public p0(boolean z) {
        this.a = z;
    }

    public /* synthetic */ void accept(double d) {
        t3.c();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.j5
    public final boolean e() {
        return false;
    }

    @Override // j$.util.stream.c8
    public final int f() {
        if (this.a) {
            return 0;
        }
        return w6.r;
    }

    public final void g(a aVar, Spliterator spliterator) {
        if (this.a) {
            new q0(aVar, spliterator, this).invoke();
        } else {
            new r0(aVar, spliterator, aVar.O(this)).invoke();
        }
    }

    public /* synthetic */ void accept(int i) {
        t3.k();
        throw null;
    }

    public /* synthetic */ void accept(long j) {
        t3.l();
        throw null;
    }

    @Override // j$.util.stream.j5
    public final void c(long j) {
    }

    @Override // j$.util.stream.j5
    public final void end() {
    }
}
