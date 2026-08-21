package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class u4 extends p4 implements o4 {
    public long b;

    public /* synthetic */ void accept(double d) {
        t3.c();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.j5
    public final void c(long j) {
        this.b = 0L;
    }

    @Override // j$.util.stream.j5
    public final boolean e() {
        return false;
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
    public final void end() {
    }
}
