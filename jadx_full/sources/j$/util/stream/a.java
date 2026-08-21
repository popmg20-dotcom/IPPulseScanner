package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements BaseStream {
    public final a a;
    public final a b;
    public final int c;
    public final a d;
    public int e;
    public int f;
    public Spliterator g;
    public boolean h;
    public final boolean i;
    public Runnable j;
    public boolean k;

    public a(a aVar, int i) {
        if (aVar.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        aVar.h = true;
        aVar.d = this;
        this.b = aVar;
        this.c = w6.h & i;
        this.f = w6.h(i, aVar.f);
        a aVar2 = aVar.a;
        this.a = aVar2;
        if (I()) {
            aVar2.i = true;
        }
        this.e = aVar.e + 1;
    }

    public final e2 A(IntFunction intFunction) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        if (!this.a.k || this.b == null || !I()) {
            return y(K(0), true, intFunction);
        }
        this.e = 0;
        a aVar = this.b;
        return G(aVar, aVar.K(0), intFunction);
    }

    public abstract e2 B(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction);

    public final long C(Spliterator spliterator) {
        if (w6.SIZED.k(this.f)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    public abstract boolean D(Spliterator spliterator, j5 j5Var);

    public abstract x6 E();

    public abstract w1 F(long j, IntFunction intFunction);

    public e2 G(a aVar, Spliterator spliterator, IntFunction intFunction) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    public Spliterator H(a aVar, Spliterator spliterator) {
        return G(aVar, spliterator, new j$.time.z(10)).spliterator();
    }

    public abstract boolean I();

    public abstract j5 J(int i, j5 j5Var);

    public final Spliterator K(int i) {
        int i2;
        int i3;
        a aVar = this.a;
        Spliterator spliteratorH = aVar.g;
        if (spliteratorH == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        aVar.g = null;
        if (aVar.k && aVar.i) {
            a aVar2 = aVar.d;
            int i4 = 1;
            while (aVar != this) {
                int i5 = aVar2.c;
                if (aVar2.I()) {
                    if (w6.SHORT_CIRCUIT.k(i5)) {
                        i5 &= ~w6.u;
                    }
                    spliteratorH = aVar2.H(aVar, spliteratorH);
                    if (spliteratorH.hasCharacteristics(64)) {
                        i2 = (~w6.t) & i5;
                        i3 = w6.s;
                    } else {
                        i2 = (~w6.s) & i5;
                        i3 = w6.t;
                    }
                    i5 = i2 | i3;
                    i4 = 0;
                }
                int i6 = i4 + 1;
                aVar2.e = i4;
                aVar2.f = w6.h(i5, aVar.f);
                a aVar3 = aVar2;
                aVar2 = aVar2.d;
                aVar = aVar3;
                i4 = i6;
            }
        }
        if (i != 0) {
            this.f = w6.h(i, this.f);
        }
        return spliteratorH;
    }

    public final Spliterator L() {
        a aVar = this.a;
        if (this != aVar) {
            throw new IllegalStateException();
        }
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        Spliterator spliterator = aVar.g;
        if (spliterator == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        aVar.g = null;
        return spliterator;
    }

    public abstract Spliterator M(a aVar, Supplier supplier, boolean z);

    public final j5 N(Spliterator spliterator, j5 j5Var) {
        w(spliterator, O((j5) Objects.requireNonNull(j5Var)));
        return j5Var;
    }

    public final j5 O(j5 j5Var) {
        Objects.requireNonNull(j5Var);
        while (this.e > 0) {
            j5Var = this.J(this.b.f, j5Var);
            this = this.b;
        }
        return j5Var;
    }

    public final Spliterator P(Spliterator spliterator) {
        return this.e == 0 ? spliterator : M(this, new j$.util.p(4, spliterator), this.a.k);
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.h = true;
        this.g = null;
        a aVar = this.a;
        Runnable runnable = aVar.j;
        if (runnable != null) {
            aVar.j = null;
            runnable.run();
        }
    }

    @Override // j$.util.stream.BaseStream
    public final boolean isParallel() {
        return this.a.k;
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream onClose(Runnable runnable) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        Objects.requireNonNull(runnable);
        a aVar = this.a;
        Runnable runnable2 = aVar.j;
        if (runnable2 != null) {
            runnable = new b8(runnable2, runnable);
        }
        aVar.j = runnable;
        return this;
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream parallel() {
        this.a.k = true;
        return this;
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream sequential() {
        this.a.k = false;
        return this;
    }

    @Override // j$.util.stream.BaseStream
    public Spliterator spliterator() {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        a aVar = this.a;
        if (this != aVar) {
            return M(this, new j$.util.p(3, this), aVar.k);
        }
        Spliterator spliterator = aVar.g;
        if (spliterator == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        aVar.g = null;
        return spliterator;
    }

    public final void w(Spliterator spliterator, j5 j5Var) {
        Objects.requireNonNull(j5Var);
        if (w6.SHORT_CIRCUIT.k(this.f)) {
            x(spliterator, j5Var);
            return;
        }
        j5Var.c(spliterator.getExactSizeIfKnown());
        spliterator.forEachRemaining(j5Var);
        j5Var.end();
    }

    public final boolean x(Spliterator spliterator, j5 j5Var) {
        while (this.e > 0) {
            this = this.b;
        }
        j5Var.c(spliterator.getExactSizeIfKnown());
        boolean zD = this.D(spliterator, j5Var);
        j5Var.end();
        return zD;
    }

    public final e2 y(Spliterator spliterator, boolean z, IntFunction intFunction) {
        if (this.a.k) {
            return B(this, spliterator, z, intFunction);
        }
        w1 w1VarF = F(C(spliterator), intFunction);
        N(spliterator, w1VarF);
        return w1VarF.build();
    }

    public final Object z(c8 c8Var) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        return this.a.k ? c8Var.b(this, K(c8Var.f())) : c8Var.a(this, K(c8Var.f()));
    }

    public a(Spliterator spliterator, int i, boolean z) {
        this.b = null;
        this.g = spliterator;
        this.a = this;
        int i2 = w6.g & i;
        this.c = i2;
        this.f = (~(i2 << 1)) & w6.l;
        this.e = 0;
        this.k = z;
    }
}
