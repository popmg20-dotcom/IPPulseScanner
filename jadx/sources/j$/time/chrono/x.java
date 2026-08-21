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
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.temporal.u j(j$.time.temporal.q r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof j$.time.temporal.a
            if (r0 == 0) goto L99
            boolean r0 = r5.e(r6)
            if (r0 == 0) goto L8d
            j$.time.temporal.a r6 = (j$.time.temporal.a) r6
            int[] r0 = j$.time.chrono.w.a
            int r1 = r6.ordinal()
            r0 = r0[r1]
            r1 = 1
            r2 = 1
            if (r0 == r1) goto L81
            r4 = 2
            if (r0 == r4) goto L48
            r4 = 3
            if (r0 == r4) goto L26
            j$.time.chrono.v r5 = j$.time.chrono.v.c
            j$.time.temporal.u r5 = r5.G(r6)
            return r5
        L26:
            j$.time.chrono.y r5 = r5.b
            j$.time.i r6 = r5.b
            int r6 = r6.a
            j$.time.chrono.y r5 = r5.B()
            if (r5 == 0) goto L3e
            j$.time.i r5 = r5.b
            int r5 = r5.a
            int r5 = r5 - r6
            int r5 = r5 + r1
            long r5 = (long) r5
            j$.time.temporal.u r5 = j$.time.temporal.u.f(r2, r5)
            return r5
        L3e:
            r5 = 999999999(0x3b9ac9ff, float:0.004723787)
            int r5 = r5 - r6
            long r5 = (long) r5
            j$.time.temporal.u r5 = j$.time.temporal.u.f(r2, r5)
            return r5
        L48:
            j$.time.chrono.y r6 = r5.b
            j$.time.chrono.y r6 = r6.B()
            if (r6 == 0) goto L60
            j$.time.i r6 = r6.b
            int r0 = r6.a
            j$.time.i r4 = r5.a
            int r4 = r4.a
            if (r0 != r4) goto L60
            int r6 = r6.F()
            int r6 = r6 - r1
            goto L6d
        L60:
            j$.time.i r6 = r5.a
            boolean r6 = r6.H()
            if (r6 == 0) goto L6b
            r6 = 366(0x16e, float:5.13E-43)
            goto L6d
        L6b:
            r6 = 365(0x16d, float:5.11E-43)
        L6d:
            int r0 = r5.c
            if (r0 != r1) goto L7b
            j$.time.chrono.y r5 = r5.b
            j$.time.i r5 = r5.b
            int r5 = r5.F()
            int r5 = r5 - r1
            int r6 = r6 - r5
        L7b:
            long r5 = (long) r6
            j$.time.temporal.u r5 = j$.time.temporal.u.f(r2, r5)
            return r5
        L81:
            j$.time.i r5 = r5.a
            int r5 = r5.I()
            long r5 = (long) r5
            j$.time.temporal.u r5 = j$.time.temporal.u.f(r2, r5)
            return r5
        L8d:
            j$.time.temporal.t r5 = new j$.time.temporal.t
            java.lang.String r0 = "Unsupported field: "
            java.lang.String r6 = j$.time.d.a(r0, r6)
            r5.<init>(r6)
            throw r5
        L99:
            j$.time.temporal.u r5 = r6.i(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.x.j(j$.time.temporal.q):j$.time.temporal.u");
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
