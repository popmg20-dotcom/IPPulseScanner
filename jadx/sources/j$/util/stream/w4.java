package j$.util.stream;

import j$.util.Objects;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class w4 extends f5 {
    public final /* synthetic */ int b = 0;
    public boolean c;
    public final Object d;
    public final /* synthetic */ a e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w4(w wVar, j5 j5Var) {
        super(j5Var);
        this.e = wVar;
        j5 j5Var2 = this.a;
        Objects.requireNonNull(j5Var2);
        this.d = new j$.util.d0(j5Var2, 1);
    }

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public final void n(Object obj) throws Exception {
        int i = this.b;
        j5 j5Var = this.a;
        a aVar = this.e;
        Object obj2 = this.d;
        switch (i) {
            case 0:
                j$.util.l0 l0Var = (j$.util.l0) obj2;
                LongStream longStream = (LongStream) ((j$.util.p) ((e1) aVar).m).apply(obj);
                if (longStream != null) {
                    try {
                        if (this.c) {
                            j$.util.z0 z0VarSpliterator = longStream.sequential().spliterator();
                            while (!j5Var.e() && z0VarSpliterator.tryAdvance((LongConsumer) l0Var)) {
                            }
                        } else {
                            longStream.sequential().forEach(l0Var);
                        }
                    } catch (Throwable th) {
                        try {
                            longStream.close();
                            break;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                    break;
                }
                if (longStream != null) {
                    longStream.close();
                    return;
                }
                return;
            case 1:
                j$.util.h0 h0Var = (j$.util.h0) obj2;
                IntStream intStream = (IntStream) ((j$.util.p) ((t0) aVar).m).apply(obj);
                if (intStream != null) {
                    try {
                        if (this.c) {
                            j$.util.w0 w0VarSpliterator = intStream.sequential().spliterator();
                            while (!j5Var.e() && w0VarSpliterator.tryAdvance((IntConsumer) h0Var)) {
                            }
                        } else {
                            intStream.sequential().forEach(h0Var);
                        }
                    } catch (Throwable th3) {
                        try {
                            intStream.close();
                            break;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                    break;
                }
                if (intStream != null) {
                    intStream.close();
                    return;
                }
                return;
            default:
                j$.util.d0 d0Var = (j$.util.d0) obj2;
                DoubleStream doubleStream = (DoubleStream) ((j$.util.p) ((w) aVar).m).apply(obj);
                if (doubleStream != null) {
                    try {
                        if (this.c) {
                            j$.util.t0 t0VarSpliterator = doubleStream.sequential().spliterator();
                            while (!j5Var.e() && t0VarSpliterator.tryAdvance((DoubleConsumer) d0Var)) {
                            }
                        } else {
                            doubleStream.sequential().forEach(d0Var);
                        }
                    } catch (Throwable th5) {
                        try {
                            doubleStream.close();
                            break;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                    break;
                }
                if (doubleStream != null) {
                    doubleStream.close();
                    return;
                }
                return;
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.j5
    public final void c(long j) {
        switch (this.b) {
            case 0:
                this.a.c(-1L);
                break;
            case 1:
                this.a.c(-1L);
                break;
            default:
                this.a.c(-1L);
                break;
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.j5
    public final boolean e() {
        switch (this.b) {
            case 0:
                this.c = true;
                break;
            case 1:
                this.c = true;
                break;
            default:
                this.c = true;
                break;
        }
        return this.a.e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w4(t0 t0Var, j5 j5Var) {
        super(j5Var);
        this.e = t0Var;
        j5 j5Var2 = this.a;
        Objects.requireNonNull(j5Var2);
        this.d = new j$.util.h0(j5Var2, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w4(e1 e1Var, j5 j5Var) {
        super(j5Var);
        this.e = e1Var;
        j5 j5Var2 = this.a;
        Objects.requireNonNull(j5Var2);
        this.d = new j$.util.l0(j5Var2, 1);
    }
}
