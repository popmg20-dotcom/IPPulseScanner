package j$.util.stream;

import j$.util.Objects;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class w0 extends d5 {
    public boolean b;
    public final j$.util.h0 c;
    public final /* synthetic */ t0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(t0 t0Var, j5 j5Var) {
        super(j5Var);
        this.d = t0Var;
        j5 j5Var2 = this.a;
        Objects.requireNonNull(j5Var2);
        this.c = new j$.util.h0(j5Var2, 1);
    }

    @Override // j$.util.stream.h5, java.util.function.IntConsumer
    public final void accept(int i) throws Exception {
        IntStream intStream = (IntStream) ((k0) this.d.m).apply(i);
        if (intStream != null) {
            try {
                boolean z = this.b;
                j$.util.h0 h0Var = this.c;
                if (z) {
                    j$.util.w0 w0VarSpliterator = intStream.sequential().spliterator();
                    while (!this.a.e() && w0VarSpliterator.tryAdvance((IntConsumer) h0Var)) {
                    }
                } else {
                    intStream.sequential().forEach(h0Var);
                }
            } catch (Throwable th) {
                try {
                    intStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (intStream != null) {
            intStream.close();
        }
    }

    @Override // j$.util.stream.d5, j$.util.stream.j5
    public final void c(long j) {
        this.a.c(-1L);
    }

    @Override // j$.util.stream.d5, j$.util.stream.j5
    public final boolean e() {
        this.b = true;
        return this.a.e();
    }
}
