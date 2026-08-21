package j$.time.chrono;

import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends d {
    private static final long serialVersionUID = -8722293800195731463L;
    public final transient j$.time.i a;

    public i0(j$.time.i iVar) {
        Objects.requireNonNull(iVar, "isoDate");
        this.a = iVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 8, this);
    }

    @Override // j$.time.chrono.d
    /* JADX INFO: renamed from: B */
    public final b p(long j, j$.time.temporal.s sVar) {
        return (i0) super.p(j, sVar);
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

    public final int F() {
        return this.a.a + 543;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final i0 c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (i0) super.c(j, qVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        if (s(aVar) == j) {
            return this;
        }
        int[] iArr = h0.a;
        int i = iArr[aVar.ordinal()];
        if (i == 4) {
            int iA = g0.c.G(aVar).a(j, aVar);
            int i2 = iArr[aVar.ordinal()];
            if (i2 == 4) {
                j$.time.i iVar = this.a;
                if (F() < 1) {
                    iA = 1 - iA;
                }
                return H(iVar.V(iA - 543));
            }
            if (i2 == 6) {
                return H(this.a.V(iA - 543));
            }
            if (i2 == 7) {
                return H(this.a.V((-542) - F()));
            }
        } else {
            if (i == 5) {
                g0.c.G(aVar).b(j, aVar);
                long jF = ((long) F()) * 12;
                j$.time.i iVar2 = this.a;
                return H(iVar2.P(j - ((jF + ((long) iVar2.b)) - 1)));
            }
            if (i == 6 || i == 7) {
            }
        }
        return H(this.a.c(j, qVar));
    }

    public final i0 H(j$.time.i iVar) {
        return iVar.equals(this.a) ? this : new i0(iVar);
    }

    @Override // j$.time.chrono.b
    public final a a() {
        return g0.c;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b d(long j, j$.time.temporal.s sVar) {
        return (i0) super.d(j, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i0) {
            return this.a.equals(((i0) obj).a);
        }
        return false;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        g0.c.getClass();
        return this.a.hashCode() ^ 146118545;
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: i */
    public final j$.time.temporal.m o(j$.time.i iVar) {
        return (i0) super.o(iVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.i(this);
        }
        if (!j$.time.a.p(this, qVar)) {
            throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i = h0.a[aVar.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return this.a.j(qVar);
        }
        if (i != 4) {
            return g0.c.G(aVar);
        }
        j$.time.temporal.u uVar = j$.time.temporal.a.YEAR.b;
        return j$.time.temporal.u.f(1L, F() <= 0 ? (-(uVar.a + 543)) + 1 : uVar.d + 543);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b o(j$.time.temporal.n nVar) {
        return (i0) super.o(nVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m p(long j, j$.time.temporal.b bVar) {
        return (i0) super.p(j, bVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.m(this);
        }
        int i = h0.a[((j$.time.temporal.a) qVar).ordinal()];
        if (i == 4) {
            int iF = F();
            if (iF < 1) {
                iF = 1 - iF;
            }
            return iF;
        }
        if (i == 5) {
            return ((((long) F()) * 12) + ((long) this.a.b)) - 1;
        }
        if (i == 6) {
            return F();
        }
        if (i != 7) {
            return this.a.s(qVar);
        }
        return F() < 1 ? 0 : 1;
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
        return F() >= 1 ? j0.BE : j0.BEFORE_BE;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b x(j$.time.temporal.p pVar) {
        return (i0) super.x(pVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j, j$.time.temporal.s sVar) {
        return (i0) super.d(j, sVar);
    }
}
