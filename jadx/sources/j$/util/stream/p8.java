package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class p8 extends d {
    public final a h;
    public final IntFunction i;
    public final boolean j;
    public long k;
    public long l;

    public p8(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction) {
        super(aVar2, spliterator);
        this.h = aVar;
        this.i = intFunction;
        this.j = w6.ORDERED.k(aVar2.f);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    @Override // j$.util.stream.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a() {
        /*
            r5 = this;
            boolean r0 = r5.b()
            if (r0 != 0) goto L1c
            boolean r1 = r5.j
            if (r1 == 0) goto L1c
            j$.util.stream.w6 r1 = j$.util.stream.w6.SIZED
            j$.util.stream.a r2 = r5.h
            int r3 = r2.c
            int r1 = r1.e
            r3 = r3 & r1
            if (r3 != r1) goto L1c
            j$.util.Spliterator r1 = r5.b
            long r1 = r2.C(r1)
            goto L1e
        L1c:
            r1 = -1
        L1e:
            j$.util.stream.a r3 = r5.a
            java.util.function.IntFunction r4 = r5.i
            j$.util.stream.w1 r1 = r3.F(r1, r4)
            j$.util.stream.a r2 = r5.h
            j$.util.stream.n8 r2 = (j$.util.stream.n8) r2
            boolean r3 = r5.j
            if (r3 == 0) goto L32
            if (r0 != 0) goto L32
            r0 = 1
            goto L33
        L32:
            r0 = 0
        L33:
            j$.util.stream.o8 r0 = r2.g(r1, r0)
            j$.util.stream.a r2 = r5.a
            j$.util.Spliterator r3 = r5.b
            r2.N(r3, r0)
            j$.util.stream.e2 r1 = r1.build()
            long r2 = r1.count()
            r5.k = r2
            long r2 = r0.h()
            r5.l = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.p8.a():java.lang.Object");
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new p8(this, spliterator);
    }

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        d dVar = this.d;
        if (dVar != null) {
            if (this.j) {
                p8 p8Var = (p8) dVar;
                long j = p8Var.l;
                this.l = j;
                if (j == p8Var.k) {
                    this.l = j + ((p8) this.e).l;
                }
            }
            p8 p8Var2 = (p8) dVar;
            long j2 = p8Var2.k;
            p8 p8Var3 = (p8) this.e;
            this.k = j2 + p8Var3.k;
            e2 e2VarE = p8Var2.k == 0 ? (e2) p8Var3.f : p8Var3.k == 0 ? (e2) p8Var2.f : t3.E(this.h.E(), (e2) ((p8) this.d).f, (e2) ((p8) this.e).f);
            if (b() && this.j) {
                e2VarE = e2VarE.j(this.l, e2VarE.count(), this.i);
            }
            this.f = e2VarE;
        }
        super.onCompletion(countedCompleter);
    }

    public p8(p8 p8Var, Spliterator spliterator) {
        super(p8Var, spliterator);
        this.h = p8Var.h;
        this.i = p8Var.i;
        this.j = p8Var.j;
    }
}
