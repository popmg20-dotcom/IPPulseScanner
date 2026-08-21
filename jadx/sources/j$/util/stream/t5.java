package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class t5 extends b {
    public final a j;
    public final IntFunction k;
    public final long l;
    public final long m;
    public long n;
    public volatile boolean o;

    public t5(t5 t5Var, Spliterator spliterator) {
        super(t5Var, spliterator);
        this.j = t5Var.j;
        this.k = t5Var.k;
        this.l = t5Var.l;
        this.m = t5Var.m;
    }

    @Override // j$.util.stream.d
    public final Object a() {
        if (b()) {
            w6 w6Var = w6.SIZED;
            a aVar = this.j;
            int i = aVar.c;
            int i2 = w6Var.e;
            w1 w1VarF = this.j.F((i & i2) == i2 ? aVar.C(this.b) : -1L, this.k);
            j5 j5VarJ = this.j.J(this.a.f, w1VarF);
            a aVar2 = this.a;
            aVar2.x(this.b, aVar2.O(j5VarJ));
            return w1VarF.build();
        }
        w1 w1VarF2 = this.j.F(-1L, this.k);
        if (this.l == 0) {
            j5 j5VarJ2 = this.j.J(this.a.f, w1VarF2);
            a aVar3 = this.a;
            aVar3.x(this.b, aVar3.O(j5VarJ2));
        } else {
            this.a.N(this.b, w1VarF2);
        }
        e2 e2VarBuild = w1VarF2.build();
        this.n = e2VarBuild.count();
        this.o = true;
        this.b = null;
        return e2VarBuild;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new t5(this, spliterator);
    }

    @Override // j$.util.stream.b
    public final void f() {
        this.i = true;
        if (this.o) {
            d(t3.G(this.j.E()));
        }
    }

    @Override // j$.util.stream.b
    public final Object h() {
        return t3.G(this.j.E());
    }

    public final long j(long j) {
        if (this.o) {
            return this.n;
        }
        t5 t5Var = (t5) this.d;
        t5 t5Var2 = (t5) this.e;
        if (t5Var == null || t5Var2 == null) {
            return this.n;
        }
        long j2 = t5Var.j(j);
        return j2 >= j ? j2 : t5Var2.j(j) + j2;
    }

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        t5 t5Var;
        e2 e2VarG;
        d dVar = this.d;
        if (dVar != null) {
            this.n = ((t5) dVar).n + ((t5) this.e).n;
            if (this.i) {
                this.n = 0L;
                e2VarG = t3.G(this.j.E());
            } else {
                e2VarG = this.n == 0 ? t3.G(this.j.E()) : ((t5) this.d).n == 0 ? (e2) ((t5) this.e).i() : t3.E(this.j.E(), (e2) ((t5) this.d).i(), (e2) ((t5) this.e).i());
            }
            e2 e2VarJ = e2VarG;
            if (b()) {
                e2VarJ = e2VarJ.j(this.l, this.m >= 0 ? Math.min(e2VarJ.count(), this.l + this.m) : this.n, this.k);
            }
            d(e2VarJ);
            this.o = true;
        }
        if (this.m >= 0 && !b()) {
            long j = this.l + this.m;
            long j2 = this.o ? this.n : j(j);
            if (j2 >= j) {
                g();
            } else {
                t5 t5Var2 = (t5) ((d) getCompleter());
                Object obj = this;
                while (true) {
                    if (t5Var2 == null) {
                        if (j2 >= j) {
                            break;
                        }
                    } else {
                        if (obj == t5Var2.e && (t5Var = (t5) t5Var2.d) != null) {
                            long j3 = t5Var.j(j) + j2;
                            if (j3 >= j) {
                                break;
                            } else {
                                j2 = j3;
                            }
                        }
                        obj = t5Var2;
                        t5Var2 = (t5) ((d) t5Var2.getCompleter());
                    }
                }
                g();
            }
        }
        super.onCompletion(countedCompleter);
    }

    public t5(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction, long j, long j2) {
        super(aVar2, spliterator);
        this.j = aVar;
        this.k = intFunction;
        this.l = j;
        this.m = j2;
    }
}
