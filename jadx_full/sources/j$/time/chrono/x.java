package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends d {
    public static final j$.time.i d = j$.time.i.K(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;
    public final transient j$.time.i a;
    public final transient y b;
    public final transient int c;

    public x(j$.time.i iVar) {
        if (iVar.G(d)) {
            j$.time.h.j("JapaneseDate before Meiji 6 is not supported");
            throw null;
        }
        y yVarA = y.A(iVar);
        this.b = yVarA;
        this.c = (iVar.a - yVarA.b.a) + 1;
        this.a = iVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 4, this);
    }

    @Override // j$.time.chrono.d
    /* JADX INFO: renamed from: B */
    public final b p(long j, j$.time.temporal.s sVar) {
        return (x) super.p(j, sVar);
    }

    @Override // j$.time.chrono.d
    public final b C(long j) {
        return H(this.a.O(j));
    }

    @Override // j$.time.chrono.d
    public final b D(long j) {
        return H(this.a.P(j));
    }

    @Override // j$.time.chrono.d
    public final b E(long j) {
        return H(this.a.R(j));
    }

    public final x F(long j, j$.time.temporal.b bVar) {
        return (x) super.d(j, (j$.time.temporal.s) bVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public final x c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (x) super.c(j, qVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        if (s(aVar) == j) {
            return this;
        }
        int[] iArr = w.a;
        int i = iArr[aVar.ordinal()];
        if (i == 3 || i == 8 || i == 9) {
            v vVar = v.c;
            int iA = vVar.G(aVar).a(j, aVar);
            int i2 = iArr[aVar.ordinal()];
            if (i2 == 3) {
                return H(this.a.V(vVar.F(this.b, iA)));
            }
            if (i2 == 8) {
                return H(this.a.V(vVar.F(y.C(iA), this.c)));
            }
            if (i2 == 9) {
                return H(this.a.V(iA));
            }
        }
        return H(this.a.c(j, qVar));
    }

    public final x H(j$.time.i iVar) {
        return iVar.equals(this.a) ? this : new x(iVar);
    }

    public final x I(j$.time.z zVar) {
        return (x) super.o(zVar);
    }

    @Override // j$.time.chrono.b
    public final a a() {
        return v.c;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b d(long j, j$.time.temporal.s sVar) {
        return (x) super.d(j, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.TemporalAccessor
    public final boolean e(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || qVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || qVar == j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH || qVar == j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).isDateBased() : qVar != null && qVar.h(this);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.a.equals(((x) obj).a);
        }
        return false;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        v.c.getClass();
        return this.a.hashCode() ^ (-688086063);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: i */
    public final j$.time.temporal.m o(j$.time.i iVar) {
        return (x) super.o(iVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    @Override // j$.time.chrono.d, j$.time.temporal.TemporalAccessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        int iF;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.i(this);
        }
        if (!e(qVar)) {
            throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i = w.a[aVar.ordinal()];
        if (i == 1) {
            return j$.time.temporal.u.f(1L, this.a.I());
        }
        if (i != 2) {
            if (i != 3) {
                return v.c.G(aVar);
            }
            y yVar = this.b;
            int i2 = yVar.b.a;
            return yVar.B() != null ? j$.time.temporal.u.f(1L, (r5.b.a - i2) + 1) : j$.time.temporal.u.f(1L, 999999999 - i2);
        }
        y yVarB = this.b.B();
        if (yVarB != null) {
            j$.time.i iVar = yVarB.b;
            iF = iVar.a == this.a.a ? iVar.F() - 1 : this.a.H() ? 366 : 365;
        }
        if (this.c == 1) {
            iF -= this.b.b.F() - 1;
        }
        return j$.time.temporal.u.f(1L, iF);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b o(j$.time.temporal.n nVar) {
        return (x) super.o(nVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m p(long j, j$.time.temporal.b bVar) {
        return (x) super.p(j, bVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.m(this);
        }
        switch (w.a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 2:
                int i = this.c;
                j$.time.i iVar = this.a;
                return i == 1 ? (iVar.F() - this.b.b.F()) + 1 : iVar.F();
            case 3:
                return this.c;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
            case 8:
                return this.b.a;
            default:
                return this.a.s(qVar);
        }
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final long t() {
        return this.a.t();
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final e u(j$.time.l lVar) {
        return new g(this, lVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final m v() {
        return this.b;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b x(j$.time.temporal.p pVar) {
        return (x) super.x(pVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j, j$.time.temporal.s sVar) {
        return (x) super.d(j, sVar);
    }

    public x(y yVar, int i, j$.time.i iVar) {
        if (!iVar.G(d)) {
            this.b = yVar;
            this.c = i;
            this.a = iVar;
            return;
        }
        j$.time.h.j("JapaneseDate before Meiji 6 is not supported");
        throw null;
    }
}
