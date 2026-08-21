package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class a8 extends y6 {
    @Override // j$.util.stream.y6
    public final void d() {
        t6 t6Var = new t6();
        this.h = t6Var;
        Objects.requireNonNull(t6Var);
        this.e = this.b.O(new z7(t6Var, 0));
        this.f = new j$.util.p(15, this);
    }

    @Override // j$.util.stream.y6
    public final y6 e(Spliterator spliterator) {
        return new a8(this.b, spliterator, this.a);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(consumer)) {
            }
            return;
        }
        Objects.requireNonNull(consumer);
        c();
        Objects.requireNonNull(consumer);
        z7 z7Var = new z7(consumer, 1);
        this.b.N(this.d, z7Var);
        this.i = true;
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Object obj;
        Objects.requireNonNull(consumer);
        boolean zA = a();
        if (!zA) {
            return zA;
        }
        t6 t6Var = (t6) this.h;
        long j = this.g;
        if (t6Var.c != 0) {
            if (j >= t6Var.count()) {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
            for (int i = 0; i <= t6Var.c; i++) {
                long j2 = t6Var.d[i];
                Object[] objArr = t6Var.f[i];
                if (j < ((long) objArr.length) + j2) {
                    obj = objArr[(int) (j - j2)];
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
        if (j >= t6Var.b) {
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
        obj = t6Var.e[(int) j];
        consumer.n(obj);
        return zA;
    }
}
