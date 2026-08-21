package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public final TemporalAccessor a;
    public final DateTimeFormatter b;
    public int c;

    public r(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        j$.time.chrono.a aVar = dateTimeFormatter.e;
        if (aVar != null) {
            j$.time.chrono.a aVar2 = (j$.time.chrono.a) temporalAccessor.m(j$.time.temporal.r.b);
            ZoneId zoneId = (ZoneId) temporalAccessor.m(j$.time.temporal.r.a);
            j$.time.chrono.b bVarJ = null;
            aVar = Objects.equals(aVar, aVar2) ? null : aVar;
            Objects.equals(null, zoneId);
            if (aVar != null) {
                j$.time.chrono.a aVar3 = aVar != null ? aVar : aVar2;
                if (aVar != null) {
                    if (temporalAccessor.e(j$.time.temporal.a.EPOCH_DAY)) {
                        bVarJ = aVar3.j(temporalAccessor);
                    } else if (aVar != j$.time.chrono.s.c || aVar2 != null) {
                        for (j$.time.temporal.a aVar4 : j$.time.temporal.a.values()) {
                            if (aVar4.isDateBased() && temporalAccessor.e(aVar4)) {
                                throw new j$.time.c("Unable to apply override chronology '" + aVar + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                            }
                        }
                    }
                }
                temporalAccessor = new q(bVarJ, temporalAccessor, aVar3, zoneId);
            }
        }
        this.a = temporalAccessor;
        this.b = dateTimeFormatter;
    }

    public final Long a(j$.time.temporal.q qVar) {
        int i = this.c;
        TemporalAccessor temporalAccessor = this.a;
        if (i <= 0 || temporalAccessor.e(qVar)) {
            return Long.valueOf(temporalAccessor.s(qVar));
        }
        return null;
    }

    public final String toString() {
        return this.a.toString();
    }
}
