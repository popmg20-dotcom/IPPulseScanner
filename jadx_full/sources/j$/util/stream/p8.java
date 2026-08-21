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
    */
    public final Object a() {
        long jC;
        boolean zB = b();
        if (zB || !this.j) {
            jC = -1;
        } else {
            w6 w6Var = w6.SIZED;
            a aVar = this.h;
            int i = aVar.c;
            int i2 = w6Var.e;
            if ((i & i2) == i2) {
                jC = aVar.C(this.b);
            }
        }
        w1 w1VarF = this.a.F(jC, this.i);
        o8 o8VarG = ((n8) this.h).g(w1VarF, this.j && !zB);
        this.a.N(this.b, o8VarG);
        e2 e2VarBuild = w1VarF.build();
        this.k = e2VarBuild.count();
        this.l = o8VarG.h();
        return e2VarBuild;
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
