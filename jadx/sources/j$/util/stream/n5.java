package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class n5 extends y0 {
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n5(a1 a1Var, int i, long j, long j2) {
        super(a1Var, i);
        this.l = j;
        this.m = j2;
    }

    @Override // j$.util.stream.a
    public final e2 G(a aVar, Spliterator spliterator, IntFunction intFunction) {
        long jMin;
        long j;
        long jC = aVar.C(spliterator);
        if (jC > 0 && spliterator.hasCharacteristics(16384)) {
            a aVar2 = aVar;
            while (aVar2.e > 0) {
                aVar2 = aVar2.b;
            }
            return t3.C(aVar, t3.Z(aVar2.E(), spliterator, this.l, this.m), true);
        }
        if (w6.ORDERED.k(aVar.f)) {
            return (e2) new t5(this, aVar, spliterator, intFunction, this.l, this.m).invoke();
        }
        j$.util.w0 w0Var = (j$.util.w0) aVar.P(spliterator);
        long j2 = this.l;
        long j3 = this.m;
        if (j2 <= jC) {
            long j4 = jC - j2;
            jMin = j3 >= 0 ? Math.min(j3, j4) : j4;
            j = 0;
        } else {
            jMin = j3;
            j = j2;
        }
        return t3.C(this, new t7(w0Var, j, jMin), true);
    }

    @Override // j$.util.stream.a
    public final Spliterator H(a aVar, Spliterator spliterator) {
        long jC = aVar.C(spliterator);
        if (jC > 0 && spliterator.hasCharacteristics(16384)) {
            j$.util.w0 w0Var = (j$.util.w0) aVar.P(spliterator);
            long j = this.l;
            return new n7(w0Var, j, t3.z(j, this.m));
        }
        if (w6.ORDERED.k(aVar.f)) {
            return ((e2) new t5(this, aVar, spliterator, new v0(23), this.l, this.m).invoke()).spliterator();
        }
        j$.util.w0 w0Var2 = (j$.util.w0) aVar.P(spliterator);
        long j2 = this.l;
        long jMin = this.m;
        if (j2 <= jC) {
            long j3 = jC - j2;
            jMin = jMin >= 0 ? Math.min(jMin, j3) : j3;
            j2 = 0;
        }
        return new t7(w0Var2, j2, jMin);
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        return new m5(this, j5Var);
    }
}
