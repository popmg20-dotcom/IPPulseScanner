package j$.time;

import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = 7264499704384272492L;
    public final l a;
    public final ZoneOffset b;

    static {
        l lVar = l.e;
        ZoneOffset zoneOffset = ZoneOffset.g;
        lVar.getClass();
        new r(lVar, zoneOffset);
        l lVar2 = l.f;
        ZoneOffset zoneOffset2 = ZoneOffset.f;
        lVar2.getClass();
        new r(lVar2, zoneOffset2);
    }

    public r(l lVar, ZoneOffset zoneOffset) {
        this.a = (l) Objects.requireNonNull(lVar, RtspHeaders.Values.TIME);
        this.b = (ZoneOffset) Objects.requireNonNull(zoneOffset, "offset");
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 9, this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final r d(long j, j$.time.temporal.s sVar) {
        return sVar instanceof j$.time.temporal.b ? B(this.a.d(j, sVar), this.b) : (r) sVar.h(this, j);
    }

    public final r B(l lVar, ZoneOffset zoneOffset) {
        return (this.a == lVar && this.b.equals(zoneOffset)) ? this : new r(lVar, zoneOffset);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (r) qVar.p(this, j);
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.OFFSET_SECONDS;
        l lVar = this.a;
        if (qVar != aVar) {
            return B(lVar.c(j, qVar), this.b);
        }
        j$.time.temporal.a aVar2 = (j$.time.temporal.a) qVar;
        return B(lVar, ZoneOffset.J(aVar2.b.a(j, aVar2)));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        r rVar = (r) obj;
        boolean zEquals = this.b.equals(rVar.b);
        l lVar = this.a;
        if (zEquals) {
            return lVar.compareTo(rVar.a);
        }
        int iCompare = Long.compare(lVar.M() - (((long) this.b.b) * 1000000000), rVar.a.M() - (((long) rVar.b.b) * 1000000000));
        return iCompare == 0 ? this.a.compareTo(rVar.a) : iCompare;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean e(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).A() || qVar == j$.time.temporal.a.OFFSET_SECONDS : qVar != null && qVar.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.a.equals(rVar.a) && this.b.equals(rVar.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int h(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.a(this, qVar);
    }

    public final int hashCode() {
        return this.b.b ^ this.a.hashCode();
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: i */
    public final j$.time.temporal.m o(i iVar) {
        return (r) a.a(iVar, this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.i(this);
        }
        if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return ((j$.time.temporal.a) qVar).b;
        }
        l lVar = this.a;
        lVar.getClass();
        return j$.time.temporal.r.d(lVar, qVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m k(j$.time.temporal.m mVar) {
        return mVar.c(this.a.M(), j$.time.temporal.a.NANO_OF_DAY).c(this.b.b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object m(z zVar) {
        if (zVar == j$.time.temporal.r.d || zVar == j$.time.temporal.r.e) {
            return this.b;
        }
        if (((zVar == j$.time.temporal.r.a) || (zVar == j$.time.temporal.r.b)) || zVar == j$.time.temporal.r.f) {
            return null;
        }
        return zVar == j$.time.temporal.r.g ? this.a : zVar == j$.time.temporal.r.c ? j$.time.temporal.b.NANOS : zVar.g(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m p(long j, j$.time.temporal.b bVar) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = d(Long.MAX_VALUE, bVar);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.d(j2, bVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.OFFSET_SECONDS ? this.b.b : this.a.s(qVar) : qVar.m(this);
    }

    public final String toString() {
        return this.a.toString() + this.b.c;
    }
}
