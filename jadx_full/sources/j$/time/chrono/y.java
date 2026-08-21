package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class y implements m, Serializable {
    public static final y d;
    public static final y[] e;
    private static final long serialVersionUID = 1466499369062886794L;
    public final transient int a;
    public final transient j$.time.i b;
    public final transient String c;

    static {
        y yVar = new y(-1, j$.time.i.K(1868, 1, 1), "Meiji");
        d = yVar;
        e = new y[]{yVar, new y(0, j$.time.i.K(1912, 7, 30), "Taisho"), new y(1, j$.time.i.K(1926, 12, 25), "Showa"), new y(2, j$.time.i.K(1989, 1, 8), "Heisei"), new y(3, j$.time.i.K(2019, 5, 1), "Reiwa")};
    }

    public y(int i, j$.time.i iVar, String str) {
        this.a = i;
        this.b = iVar;
        this.c = str;
    }

    public static y A(j$.time.i iVar) {
        if (iVar.G(x.d)) {
            j$.time.h.j("JapaneseDate before Meiji 6 are not supported");
            return null;
        }
        for (int length = e.length - 1; length >= 0; length--) {
            y yVar = e[length];
            if (iVar.compareTo(yVar.b) >= 0) {
                return yVar;
            }
        }
        return null;
    }

    public static y C(int i) {
        int i2 = i + 1;
        if (i2 >= 0) {
            y[] yVarArr = e;
            if (i2 < yVarArr.length) {
                return yVarArr[i2];
            }
        }
        j$.time.h.d("Invalid era: ", i);
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 5, this);
    }

    public final y B() {
        if (this == e[r0.length - 1]) {
            return null;
        }
        return C(this.a + 1);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ boolean e(j$.time.temporal.q qVar) {
        return j$.time.a.q(this, qVar);
    }

    @Override // j$.time.chrono.m
    public final int getValue() {
        return this.a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ int h(j$.time.temporal.q qVar) {
        return j$.time.a.l(this, qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        return qVar == aVar ? v.c.G(aVar) : j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m k(j$.time.temporal.m mVar) {
        return mVar.c(getValue(), j$.time.temporal.a.ERA);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ Object m(j$.time.z zVar) {
        return j$.time.a.u(this, zVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ long s(j$.time.temporal.q qVar) {
        return j$.time.a.n(this, qVar);
    }

    public final String toString() {
        return this.c;
    }
}
