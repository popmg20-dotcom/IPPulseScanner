package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class v4 extends d {
    public final t3 h;

    public v4(v4 v4Var, Spliterator spliterator) {
        super(v4Var, spliterator);
        this.h = v4Var.h;
    }

    @Override // j$.util.stream.d
    public final Object a() {
        a aVar = this.a;
        o4 o4VarY = this.h.Y();
        aVar.N(this.b, o4VarY);
        return o4VarY;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new v4(this, spliterator);
    }

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        d dVar = this.d;
        if (dVar != null) {
            o4 o4Var = (o4) ((v4) dVar).f;
            o4Var.i((o4) ((v4) this.e).f);
            this.f = o4Var;
        }
        super.onCompletion(countedCompleter);
    }

    public v4(t3 t3Var, a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.h = t3Var;
    }
}
