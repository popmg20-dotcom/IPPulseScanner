package j$.util.stream;

import j$.util.Objects;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class d1 extends e5 {
    public boolean b;
    public final j$.util.l0 c;
    public final /* synthetic */ e1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(e1 e1Var, j5 j5Var) {
        super(j5Var);
        this.d = e1Var;
        j5 j5Var2 = this.a;
        Objects.requireNonNull(j5Var2);
        this.c = new j$.util.l0(j5Var2, 1);
    }

    @Override // j$.util.stream.i5, j$.util.stream.j5
    public final void accept(long j) throws Exception {
        LongStream longStream = (LongStream) ((j$.util.p) this.d.m).apply(j);
        if (longStream != null) {
            try {
                boolean z = this.b;
                j$.util.l0 l0Var = this.c;
                if (z) {
                    j$.util.z0 z0VarSpliterator = longStream.sequential().spliterator();
                    while (!this.a.e() && z0VarSpliterator.tryAdvance((LongConsumer) l0Var)) {
                    }
                } else {
                    longStream.sequential().forEach(l0Var);
                }
            } catch (Throwable th) {
                try {
                    longStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (longStream != null) {
            longStream.close();
        }
    }

    @Override // j$.util.stream.e5, j$.util.stream.j5
    public final void c(long j) {
        this.a.c(-1L);
    }

    @Override // j$.util.stream.e5, j$.util.stream.j5
    public final boolean e() {
        this.b = true;
        return this.a.e();
    }
}
