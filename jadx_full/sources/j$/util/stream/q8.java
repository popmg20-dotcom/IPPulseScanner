package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class q8 extends b {
    public final a j;
    public final IntFunction k;
    public final boolean l;
    public long m;
    public boolean n;
    public volatile boolean o;

    public q8(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction) {
        super(aVar2, spliterator);
        this.j = aVar;
        this.k = intFunction;
        this.l = w6.ORDERED.k(aVar2.f);
    }

    @Override // j$.util.stream.d
    public final Object a() {
        w1 w1VarF = this.a.F(-1L, this.k);
        j5 j5VarJ = this.j.J(this.a.f, w1VarF);
        a aVar = this.a;
        boolean zX = aVar.x(this.b, aVar.O(j5VarJ));
        this.n = zX;
        if (zX) {
            g();
        }
        e2 e2VarBuild = w1VarF.build();
        this.m = e2VarBuild.count();
        return e2VarBuild;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new q8(this, spliterator);
    }

    @Override // j$.util.stream.b
    public final void f() {
        this.i = true;
        if (this.l && this.o) {
            d(t3.G(this.j.E()));
        }
    }

    @Override // j$.util.stream.b
    public final Object h() {
        return t3.G(this.j.E());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onCompletion(CountedCompleter countedCompleter) {
        Object objE;
        d dVar = this.d;
        if (dVar != null) {
            this.n = ((q8) dVar).n | ((q8) this.e).n;
            if (this.l && this.i) {
                this.m = 0L;
                objE = t3.G(this.j.E());
            } else if (this.l) {
                q8 q8Var = (q8) this.d;
                if (q8Var.n) {
                    this.m = q8Var.m;
                    objE = (e2) q8Var.i();
                } else {
                    q8 q8Var2 = (q8) this.d;
                    long j = q8Var2.m;
                    q8 q8Var3 = (q8) this.e;
                    this.m = j + q8Var3.m;
                    objE = q8Var2.m == 0 ? (e2) q8Var3.i() : q8Var3.m == 0 ? (e2) q8Var2.i() : t3.E(this.j.E(), (e2) ((q8) this.d).i(), (e2) ((q8) this.e).i());
                }
            }
            d(objE);
        }
        this.o = true;
        super.onCompletion(countedCompleter);
    }

    public q8(q8 q8Var, Spliterator spliterator) {
        super(q8Var, spliterator);
        this.j = q8Var.j;
        this.k = q8Var.k;
        this.l = q8Var.l;
    }
}
