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
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.chrono.i0 c(long r8, j$.time.temporal.q r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof j$.time.temporal.a
            if (r0 == 0) goto L9f
            r0 = r10
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            long r1 = r7.s(r0)
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 != 0) goto L10
            return r7
        L10:
            int[] r1 = j$.time.chrono.h0.a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L49
            r6 = 5
            if (r2 == r6) goto L25
            if (r2 == r4) goto L49
            if (r2 == r3) goto L49
            goto L5f
        L25:
            j$.time.chrono.g0 r10 = j$.time.chrono.g0.c
            j$.time.temporal.u r10 = r10.G(r0)
            r10.b(r8, r0)
            int r10 = r7.F()
            long r0 = (long) r10
            r2 = 12
            long r0 = r0 * r2
            j$.time.i r10 = r7.a
            short r2 = r10.b
            long r2 = (long) r2
            long r0 = r0 + r2
            r2 = 1
            long r0 = r0 - r2
            long r8 = r8 - r0
            j$.time.i r8 = r10.P(r8)
            j$.time.chrono.i0 r7 = r7.H(r8)
            return r7
        L49:
            j$.time.chrono.g0 r2 = j$.time.chrono.g0.c
            j$.time.temporal.u r2 = r2.G(r0)
            int r2 = r2.a(r8, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L88
            if (r0 == r4) goto L7b
            if (r0 == r3) goto L6a
        L5f:
            j$.time.i r0 = r7.a
            j$.time.i r8 = r0.c(r8, r10)
            j$.time.chrono.i0 r7 = r7.H(r8)
            return r7
        L6a:
            j$.time.i r8 = r7.a
            int r9 = r7.F()
            int r9 = (-542) - r9
            j$.time.i r8 = r8.V(r9)
            j$.time.chrono.i0 r7 = r7.H(r8)
            return r7
        L7b:
            j$.time.i r8 = r7.a
            int r2 = r2 + (-543)
            j$.time.i r8 = r8.V(r2)
            j$.time.chrono.i0 r7 = r7.H(r8)
            return r7
        L88:
            j$.time.i r8 = r7.a
            int r9 = r7.F()
            r10 = 1
            if (r9 < r10) goto L92
            goto L94
        L92:
            int r2 = 1 - r2
        L94:
            int r2 = r2 + (-543)
            j$.time.i r8 = r8.V(r2)
            j$.time.chrono.i0 r7 = r7.H(r8)
            return r7
        L9f:
            j$.time.chrono.b r7 = super.c(r8, r10)
            j$.time.chrono.i0 r7 = (j$.time.chrono.i0) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.i0.c(long, j$.time.temporal.q):j$.time.chrono.i0");
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
