package j$.util.stream;

import j$.util.Spliterator;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h3 implements Spliterator {
    public e2 a;
    public int b;
    public Spliterator c;
    public Spliterator d;
    public Deque e;

    public h3(g2 g2Var) {
        this.a = g2Var;
    }

    public static e2 a(Deque deque) {
        while (true) {
            ArrayDeque arrayDeque = (ArrayDeque) deque;
            e2 e2Var = (e2) arrayDeque.pollFirst();
            if (e2Var == null) {
                return null;
            }
            if (e2Var.o() != 0) {
                for (int iO = e2Var.o() - 1; iO >= 0; iO--) {
                    arrayDeque.addFirst(e2Var.a(iO));
                }
            } else if (e2Var.count() > 0) {
                return e2Var;
            }
        }
    }

    public final Deque b() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int iO = this.a.o();
        while (true) {
            iO--;
            if (iO < this.b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.a.a(iO));
        }
    }

    public final boolean c() {
        if (this.a == null) {
            return false;
        }
        if (this.d != null) {
            return true;
        }
        Spliterator spliterator = this.c;
        if (spliterator != null) {
            this.d = spliterator;
            return true;
        }
        Deque dequeB = b();
        this.e = dequeB;
        e2 e2VarA = a(dequeB);
        if (e2VarA != null) {
            this.d = e2VarA.spliterator();
            return true;
        }
        this.a = null;
        return false;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 64;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        long jCount = 0;
        if (this.a == null) {
            return 0L;
        }
        Spliterator spliterator = this.c;
        if (spliterator != null) {
            return spliterator.estimateSize();
        }
        for (int i = this.b; i < this.a.o(); i++) {
            jCount += this.a.a(i).count();
        }
        return jCount;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.time.a.m(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.time.a.o(this, i);
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        e2 e2Var = this.a;
        if (e2Var == null || this.d != null) {
            return null;
        }
        Spliterator spliterator = this.c;
        if (spliterator != null) {
            return spliterator.trySplit();
        }
        int i = this.b;
        int iO = e2Var.o() - 1;
        e2 e2Var2 = this.a;
        int i2 = this.b;
        if (i < iO) {
            this.b = i2 + 1;
            return e2Var2.a(i2).spliterator();
        }
        e2 e2VarA = e2Var2.a(i2);
        this.a = e2VarA;
        int iO2 = e2VarA.o();
        e2 e2Var3 = this.a;
        if (iO2 != 0) {
            this.b = 1;
            return e2Var3.a(0).spliterator();
        }
        Spliterator spliterator2 = e2Var3.spliterator();
        this.c = spliterator2;
        return spliterator2.trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.c1 trySplit() {
        return (j$.util.c1) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.w0 trySplit() {
        return (j$.util.w0) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.z0 trySplit() {
        return (j$.util.z0) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.t0 trySplit() {
        return (j$.util.t0) trySplit();
    }
}
