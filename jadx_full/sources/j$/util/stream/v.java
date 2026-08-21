package j$.util.stream;

import j$.util.Objects;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class v extends c5 {
    public boolean b;
    public final j$.util.d0 c;
    public final /* synthetic */ w d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(w wVar, j5 j5Var) {
        super(j5Var);
        this.d = wVar;
        j5 j5Var2 = this.a;
        Objects.requireNonNull(j5Var2);
        this.c = new j$.util.d0(j5Var2, 1);
    }

    @Override // j$.util.stream.g5, j$.util.stream.j5
    public final void accept(double d) throws Exception {
        DoubleStream doubleStream = (DoubleStream) ((j$.util.p) this.d.m).apply(d);
        if (doubleStream != null) {
            try {
                boolean z = this.b;
                j$.util.d0 d0Var = this.c;
                if (z) {
                    j$.util.t0 t0VarSpliterator = doubleStream.sequential().spliterator();
                    while (!this.a.e() && t0VarSpliterator.tryAdvance((DoubleConsumer) d0Var)) {
                    }
                } else {
                    doubleStream.sequential().forEach(d0Var);
                }
            } catch (Throwable th) {
                try {
                    doubleStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (doubleStream != null) {
            doubleStream.close();
        }
    }

    @Override // j$.util.stream.c5, j$.util.stream.j5
    public final void c(long j) {
        this.a.c(-1L);
    }

    @Override // j$.util.stream.c5, j$.util.stream.j5
    public final boolean e() {
        this.b = true;
        return this.a.e();
    }
}
