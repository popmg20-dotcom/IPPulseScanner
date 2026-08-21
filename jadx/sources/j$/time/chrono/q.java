package j$.time.chrono;

import com.tencent.mars.xlog.Xlog;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends d {
    private static final long serialVersionUID = -5207853542612002020L;
    public final transient o a;
    public final transient int b;
    public final transient int c;
    public final transient int d;

    public q(o oVar, long j) {
        int i = (int) j;
        oVar.O();
        if (i < oVar.e || i >= oVar.f) {
            j$.time.h.j("Hijrah date out of range");
            throw null;
        }
        int iBinarySearch = Arrays.binarySearch(oVar.d, i);
        iBinarySearch = iBinarySearch < 0 ? (-iBinarySearch) - 2 : iBinarySearch;
        int i2 = oVar.g;
        int[] iArr = {(iBinarySearch + i2) / 12, ((i2 + iBinarySearch) % 12) + 1, (i - oVar.d[iBinarySearch]) + 1};
        this.a = oVar;
        this.b = iArr[0];
        this.c = iArr[1];
        this.d = iArr[2];
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 6, this);
    }

    @Override // j$.time.chrono.d
    /* JADX INFO: renamed from: B */
    public final b p(long j, j$.time.temporal.s sVar) {
        return (q) super.p(j, sVar);
    }

    @Override // j$.time.chrono.d
    public final b E(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = ((long) this.b) + ((long) ((int) j));
        int i = (int) j2;
        if (j2 == i) {
            return I(i, this.c, this.d);
        }
        throw new ArithmeticException();
    }

    public final int F() {
        return this.a.T(this.b, this.c - 1) + this.d;
    }

    @Override // j$.time.chrono.d
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public final q C(long j) {
        return new q(this.a, t() + j);
    }

    @Override // j$.time.chrono.d
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final q D(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.b) * 12) + ((long) (this.c - 1)) + j;
        o oVar = this.a;
        long jO = j$.time.a.O(j2, 12L);
        int i = oVar.g;
        if (jO >= i / 12 && jO <= (((oVar.d.length - 1) + i) / 12) - 1) {
            return I((int) jO, ((int) j$.time.a.N(j2, 12L)) + 1, this.d);
        }
        throw new j$.time.c("Invalid Hijrah year: " + jO);
    }

    public final q I(int i, int i2, int i3) {
        int iR = this.a.R(i, i2);
        if (i3 > iR) {
            i3 = iR;
        }
        return new q(this.a, i, i2, i3);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final q c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (q) super.c(j, qVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        this.a.G(aVar).b(j, aVar);
        int i = (int) j;
        switch (p.a[aVar.ordinal()]) {
            case 1:
                return I(this.b, this.c, i);
            case 2:
                return C(Math.min(i, this.a.T(this.b, 12)) - F());
            case 3:
                return C((j - s(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return C(j - ((long) (((int) j$.time.a.N(t() + 3, 7L)) + 1)));
            case 5:
                return C(j - s(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return C(j - s(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new q(this.a, j);
            case 8:
                return C((j - s(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return I(this.b, i, this.d);
            case 10:
                return D(j - (((((long) this.b) * 12) + ((long) this.c)) - 1));
            case 11:
                if (this.b < 1) {
                    i = 1 - i;
                }
                return I(i, this.c, this.d);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return I(i, this.c, this.d);
            case 13:
                return I(1 - this.b, this.c, this.d);
            default:
                throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.b
    public final a a() {
        return this.a;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b d(long j, j$.time.temporal.s sVar) {
        return (q) super.d(j, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.b == qVar.b && this.c == qVar.c && this.d == qVar.d && this.a.equals(qVar.a)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        int i = this.b;
        int i2 = this.c;
        int i3 = this.d;
        this.a.getClass();
        return ((i & (-2048)) ^ 2100100019) ^ (((i << 11) + (i2 << 6)) + i3);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: i */
    public final j$.time.temporal.m o(j$.time.i iVar) {
        return (q) super.o(iVar);
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
        int i = p.a[aVar.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? this.a.G(aVar) : j$.time.temporal.u.f(1L, 5L) : j$.time.temporal.u.f(1L, this.a.T(this.b, 12)) : j$.time.temporal.u.f(1L, this.a.R(this.b, this.c));
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b o(j$.time.temporal.n nVar) {
        return (q) super.o(nVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m p(long j, j$.time.temporal.b bVar) {
        return (q) super.p(j, bVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        int iF;
        int iN;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.m(this);
        }
        switch (p.a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                iF = this.d;
                return iF;
            case 2:
                iF = F();
                return iF;
            case 3:
                iN = (this.d - 1) / 7;
                iF = iN + 1;
                return iF;
            case 4:
                iN = (int) j$.time.a.N(t() + 3, 7L);
                iF = iN + 1;
                return iF;
            case 5:
                iN = (this.d - 1) % 7;
                iF = iN + 1;
                return iF;
            case 6:
                iN = (F() - 1) % 7;
                iF = iN + 1;
                return iF;
            case 7:
                return t();
            case 8:
                iN = (F() - 1) / 7;
                iF = iN + 1;
                return iF;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                iF = this.c;
                return iF;
            case 10:
                return ((((long) this.b) * 12) + ((long) this.c)) - 1;
            case 11:
                iF = this.b;
                return iF;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                iF = this.b;
                return iF;
            case 13:
                return this.b <= 1 ? 0 : 1;
            default:
                throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final long t() {
        return this.a.Q(this.b, this.c, this.d);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final e u(j$.time.l lVar) {
        return new g(this, lVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final m v() {
        return r.AH;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b x(j$.time.temporal.p pVar) {
        return (q) super.x(pVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j, j$.time.temporal.s sVar) {
        return (q) super.d(j, sVar);
    }

    public q(o oVar, int i, int i2, int i3) {
        oVar.Q(i, i2, i3);
        this.a = oVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }
}
