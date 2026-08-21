package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import j$.time.z;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements TemporalAccessor {
    public final /* synthetic */ j$.time.chrono.b a;
    public final /* synthetic */ TemporalAccessor b;
    public final /* synthetic */ j$.time.chrono.a c;
    public final /* synthetic */ ZoneId d;

    public q(j$.time.chrono.b bVar, TemporalAccessor temporalAccessor, j$.time.chrono.a aVar, ZoneId zoneId) {
        this.a = bVar;
        this.b = temporalAccessor;
        this.c = aVar;
        this.d = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean e(j$.time.temporal.q qVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !qVar.isDateBased()) ? this.b.e(qVar) : bVar.e(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ int h(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !qVar.isDateBased()) ? this.b.j(qVar) : bVar.j(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object m(z zVar) {
        return zVar == j$.time.temporal.r.b ? this.c : zVar == j$.time.temporal.r.a ? this.d : zVar == j$.time.temporal.r.c ? this.b.m(zVar) : zVar.g(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !qVar.isDateBased()) ? this.b.s(qVar) : bVar.s(qVar);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.a aVar = this.c;
        if (aVar != null) {
            str = " with chronology " + aVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.b + str + str2;
    }
}
