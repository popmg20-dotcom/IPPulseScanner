package j$.util.stream;

import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o2 extends g2 implements d2 {
    @Override // j$.util.stream.d2
    public final Object b() {
        long j = this.c;
        if (j >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            return null;
        }
        Object objNewArray = newArray((int) j);
        f(0, objNewArray);
        return objNewArray;
    }

    @Override // j$.util.stream.d2
    public final void f(int i, Object obj) {
        e2 e2Var = this.a;
        ((d2) e2Var).f(i, obj);
        ((d2) this.b).f(i + ((int) ((d2) e2Var).count()), obj);
    }

    @Override // j$.util.stream.d2
    public final void g(Object obj) {
        ((d2) this.a).g(obj);
        ((d2) this.b).g(obj);
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ Object[] m(IntFunction intFunction) {
        return t3.m(this, intFunction);
    }

    public final String toString() {
        long j = this.c;
        return j < 32 ? String.format("%s[%s.%s]", getClass().getName(), this.a, this.b) : String.format("%s[size=%d]", getClass().getName(), Long.valueOf(j));
    }
}
