package j$.time.format;

import io.netty.util.internal.StringUtil;
import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import j$.time.z;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class v implements TemporalAccessor {
    public ZoneId b;
    public j$.time.chrono.a c;
    public boolean d;
    public w e;
    public j$.time.chrono.b f;
    public j$.time.l g;
    public final Map a = new HashMap();
    public j$.time.s h = j$.time.s.d;

    public final void A() {
        if (((HashMap) this.a).containsKey(j$.time.temporal.a.INSTANT_SECONDS)) {
            ZoneId zoneId = this.b;
            if (zoneId != null) {
                B(zoneId);
                return;
            }
            Long l = (Long) ((HashMap) this.a).get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l != null) {
                B(ZoneOffset.J(l.intValue()));
            }
        }
    }

    public final void B(ZoneId zoneId) {
        Map map = this.a;
        j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
        F(this.c.N(Instant.A(((Long) ((HashMap) map).remove(aVar)).longValue(), 0), zoneId).f());
        G(aVar, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(r5.b().N()));
    }

    public final void C(long j, long j2, long j3, long j4) {
        if (this.e == w.LENIENT) {
            long jK = j$.time.a.K(j$.time.a.K(j$.time.a.K(j$.time.a.P(j, 3600000000000L), j$.time.a.P(j2, 60000000000L)), j$.time.a.P(j3, 1000000000L)), j4);
            E(j$.time.l.F(j$.time.a.N(jK, 86400000000000L)), j$.time.s.a(0, 0, (int) j$.time.a.O(jK, 86400000000000L)));
            return;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.MINUTE_OF_HOUR;
        int iA = aVar.b.a(j2, aVar);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.NANO_OF_SECOND;
        int iA2 = aVar2.b.a(j4, aVar2);
        if (this.e == w.SMART && j == 24 && iA == 0 && j3 == 0 && iA2 == 0) {
            E(j$.time.l.g, j$.time.s.a(0, 0, 1));
            return;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.HOUR_OF_DAY;
        int iA3 = aVar3.b.a(j, aVar3);
        j$.time.temporal.a aVar4 = j$.time.temporal.a.SECOND_OF_MINUTE;
        E(j$.time.l.E(iA3, iA, aVar4.b.a(j3, aVar4), iA2), j$.time.s.d);
    }

    public final void D() {
        Map map = this.a;
        j$.time.temporal.a aVar = j$.time.temporal.a.CLOCK_HOUR_OF_DAY;
        if (((HashMap) map).containsKey(aVar)) {
            long jLongValue = ((Long) ((HashMap) this.a).remove(aVar)).longValue();
            w wVar = this.e;
            if (wVar == w.STRICT || (wVar == w.SMART && jLongValue != 0)) {
                aVar.s(jLongValue);
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.HOUR_OF_DAY;
            if (jLongValue == 24) {
                jLongValue = 0;
            }
            G(aVar, aVar2, Long.valueOf(jLongValue));
        }
        Map map2 = this.a;
        j$.time.temporal.a aVar3 = j$.time.temporal.a.CLOCK_HOUR_OF_AMPM;
        if (((HashMap) map2).containsKey(aVar3)) {
            long jLongValue2 = ((Long) ((HashMap) this.a).remove(aVar3)).longValue();
            w wVar2 = this.e;
            if (wVar2 == w.STRICT || (wVar2 == w.SMART && jLongValue2 != 0)) {
                aVar3.s(jLongValue2);
            }
            G(aVar3, j$.time.temporal.a.HOUR_OF_AMPM, Long.valueOf(jLongValue2 != 12 ? jLongValue2 : 0L));
        }
        Map map3 = this.a;
        j$.time.temporal.a aVar4 = j$.time.temporal.a.AMPM_OF_DAY;
        if (((HashMap) map3).containsKey(aVar4)) {
            Map map4 = this.a;
            j$.time.temporal.a aVar5 = j$.time.temporal.a.HOUR_OF_AMPM;
            if (((HashMap) map4).containsKey(aVar5)) {
                long jLongValue3 = ((Long) ((HashMap) this.a).remove(aVar4)).longValue();
                long jLongValue4 = ((Long) ((HashMap) this.a).remove(aVar5)).longValue();
                if (this.e == w.LENIENT) {
                    G(aVar4, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(j$.time.a.K(j$.time.a.P(jLongValue3, 12L), jLongValue4)));
                } else {
                    aVar4.s(jLongValue3);
                    aVar5.s(jLongValue3);
                    G(aVar4, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf((jLongValue3 * 12) + jLongValue4));
                }
            }
        }
        Map map5 = this.a;
        j$.time.temporal.a aVar6 = j$.time.temporal.a.NANO_OF_DAY;
        if (((HashMap) map5).containsKey(aVar6)) {
            long jLongValue5 = ((Long) ((HashMap) this.a).remove(aVar6)).longValue();
            if (this.e != w.LENIENT) {
                aVar6.s(jLongValue5);
            }
            G(aVar6, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue5 / 3600000000000L));
            G(aVar6, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((jLongValue5 / 60000000000L) % 60));
            G(aVar6, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf((jLongValue5 / 1000000000) % 60));
            G(aVar6, j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue5 % 1000000000));
        }
        Map map6 = this.a;
        j$.time.temporal.a aVar7 = j$.time.temporal.a.MICRO_OF_DAY;
        if (((HashMap) map6).containsKey(aVar7)) {
            long jLongValue6 = ((Long) ((HashMap) this.a).remove(aVar7)).longValue();
            if (this.e != w.LENIENT) {
                aVar7.s(jLongValue6);
            }
            G(aVar7, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(jLongValue6 / 1000000));
            G(aVar7, j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(jLongValue6 % 1000000));
        }
        Map map7 = this.a;
        j$.time.temporal.a aVar8 = j$.time.temporal.a.MILLI_OF_DAY;
        if (((HashMap) map7).containsKey(aVar8)) {
            long jLongValue7 = ((Long) ((HashMap) this.a).remove(aVar8)).longValue();
            if (this.e != w.LENIENT) {
                aVar8.s(jLongValue7);
            }
            G(aVar8, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(jLongValue7 / 1000));
            G(aVar8, j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(jLongValue7 % 1000));
        }
        Map map8 = this.a;
        j$.time.temporal.a aVar9 = j$.time.temporal.a.SECOND_OF_DAY;
        if (((HashMap) map8).containsKey(aVar9)) {
            long jLongValue8 = ((Long) ((HashMap) this.a).remove(aVar9)).longValue();
            if (this.e != w.LENIENT) {
                aVar9.s(jLongValue8);
            }
            G(aVar9, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue8 / 3600));
            G(aVar9, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((jLongValue8 / 60) % 60));
            G(aVar9, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf(jLongValue8 % 60));
        }
        Map map9 = this.a;
        j$.time.temporal.a aVar10 = j$.time.temporal.a.MINUTE_OF_DAY;
        if (((HashMap) map9).containsKey(aVar10)) {
            long jLongValue9 = ((Long) ((HashMap) this.a).remove(aVar10)).longValue();
            if (this.e != w.LENIENT) {
                aVar10.s(jLongValue9);
            }
            G(aVar10, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue9 / 60));
            G(aVar10, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf(jLongValue9 % 60));
        }
        Map map10 = this.a;
        j$.time.temporal.a aVar11 = j$.time.temporal.a.NANO_OF_SECOND;
        if (((HashMap) map10).containsKey(aVar11)) {
            long jLongValue10 = ((Long) ((HashMap) this.a).get(aVar11)).longValue();
            w wVar3 = this.e;
            w wVar4 = w.LENIENT;
            if (wVar3 != wVar4) {
                aVar11.s(jLongValue10);
            }
            Map map11 = this.a;
            j$.time.temporal.a aVar12 = j$.time.temporal.a.MICRO_OF_SECOND;
            if (((HashMap) map11).containsKey(aVar12)) {
                long jLongValue11 = ((Long) ((HashMap) this.a).remove(aVar12)).longValue();
                if (this.e != wVar4) {
                    aVar12.s(jLongValue11);
                }
                jLongValue10 = (jLongValue10 % 1000) + (jLongValue11 * 1000);
                G(aVar12, aVar11, Long.valueOf(jLongValue10));
            }
            Map map12 = this.a;
            j$.time.temporal.a aVar13 = j$.time.temporal.a.MILLI_OF_SECOND;
            if (((HashMap) map12).containsKey(aVar13)) {
                long jLongValue12 = ((Long) ((HashMap) this.a).remove(aVar13)).longValue();
                if (this.e != wVar4) {
                    aVar13.s(jLongValue12);
                }
                G(aVar13, aVar11, Long.valueOf((jLongValue10 % 1000000) + (jLongValue12 * 1000000)));
            }
        }
        Map map13 = this.a;
        j$.time.temporal.a aVar14 = j$.time.temporal.a.HOUR_OF_DAY;
        if (((HashMap) map13).containsKey(aVar14)) {
            Map map14 = this.a;
            j$.time.temporal.a aVar15 = j$.time.temporal.a.MINUTE_OF_HOUR;
            if (((HashMap) map14).containsKey(aVar15)) {
                Map map15 = this.a;
                j$.time.temporal.a aVar16 = j$.time.temporal.a.SECOND_OF_MINUTE;
                if (((HashMap) map15).containsKey(aVar16) && ((HashMap) this.a).containsKey(aVar11)) {
                    C(((Long) ((HashMap) this.a).remove(aVar14)).longValue(), ((Long) ((HashMap) this.a).remove(aVar15)).longValue(), ((Long) ((HashMap) this.a).remove(aVar16)).longValue(), ((Long) ((HashMap) this.a).remove(aVar11)).longValue());
                }
            }
        }
    }

    public final void E(j$.time.l lVar, j$.time.s sVar) {
        j$.time.l lVar2 = this.g;
        if (lVar2 == null) {
            this.g = lVar;
            this.h = sVar;
            return;
        }
        if (!lVar2.equals(lVar)) {
            j$.time.h.g("Conflict found: Fields resolved to different times: ", this.g, " ", lVar);
            return;
        }
        j$.time.s sVar2 = this.h;
        j$.time.s sVar3 = j$.time.s.d;
        if (sVar2 == sVar3 || sVar == sVar3 || sVar2.equals(sVar)) {
            this.h = sVar;
        } else {
            j$.time.h.g("Conflict found: Fields resolved to different excess periods: ", this.h, " ", sVar);
        }
    }

    public final void F(j$.time.chrono.b bVar) {
        j$.time.chrono.b bVar2 = this.f;
        if (bVar2 != null) {
            if (bVar == null || bVar2.equals(bVar)) {
                return;
            }
            j$.time.h.g("Conflict found: Fields resolved to two different dates: ", this.f, " ", bVar);
            return;
        }
        if (bVar != null) {
            if (this.c.equals(bVar.a())) {
                this.f = bVar;
                return;
            }
            throw new j$.time.c("ChronoLocalDate must use the effective parsed chronology: " + this.c);
        }
    }

    public final void G(j$.time.temporal.q qVar, j$.time.temporal.a aVar, Long l) {
        Long l2 = (Long) ((HashMap) this.a).put(aVar, l);
        if (l2 == null || l2.longValue() == l.longValue()) {
            return;
        }
        throw new j$.time.c("Conflict found: " + aVar + " " + l2 + " differs from " + aVar + " " + l + " while resolving  " + qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean e(j$.time.temporal.q qVar) {
        if (((HashMap) this.a).containsKey(qVar)) {
            return true;
        }
        j$.time.chrono.b bVar = this.f;
        if (bVar != null && bVar.e(qVar)) {
            return true;
        }
        j$.time.l lVar = this.g;
        if (lVar == null || !lVar.e(qVar)) {
            return (qVar == null || (qVar instanceof j$.time.temporal.a) || !qVar.h(this)) ? false : true;
        }
        return true;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ int h(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ j$.time.temporal.u j(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    public final void k(TemporalAccessor temporalAccessor) {
        Iterator it = ((HashMap) this.a).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            j$.time.temporal.q qVar = (j$.time.temporal.q) entry.getKey();
            if (temporalAccessor.e(qVar)) {
                try {
                    long jS = temporalAccessor.s(qVar);
                    long jLongValue = ((Long) entry.getValue()).longValue();
                    if (jS != jLongValue) {
                        throw new j$.time.c("Conflict found: Field " + qVar + " " + jS + " differs from " + qVar + " " + jLongValue + " derived from " + temporalAccessor);
                    }
                    it.remove();
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object m(z zVar) {
        if (zVar == j$.time.temporal.r.a) {
            return this.b;
        }
        if (zVar == j$.time.temporal.r.b) {
            return this.c;
        }
        if (zVar == j$.time.temporal.r.f) {
            j$.time.chrono.b bVar = this.f;
            if (bVar != null) {
                return j$.time.i.C(bVar);
            }
            return null;
        }
        if (zVar == j$.time.temporal.r.g) {
            return this.g;
        }
        if (zVar == j$.time.temporal.r.d) {
            Long l = (Long) ((HashMap) this.a).get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l != null) {
                return ZoneOffset.J(l.intValue());
            }
            ZoneId zoneId = this.b;
            return zoneId instanceof ZoneOffset ? zoneId : zVar.g(this);
        }
        if (zVar == j$.time.temporal.r.e) {
            return zVar.g(this);
        }
        if (zVar == j$.time.temporal.r.c) {
            return null;
        }
        return zVar.g(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        Objects.requireNonNull(qVar, "field");
        Long l = (Long) ((HashMap) this.a).get(qVar);
        if (l != null) {
            return l.longValue();
        }
        j$.time.chrono.b bVar = this.f;
        if (bVar != null && bVar.e(qVar)) {
            return this.f.s(qVar);
        }
        j$.time.l lVar = this.g;
        if (lVar != null && lVar.e(qVar)) {
            return this.g.s(qVar);
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
        return qVar.m(this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(this.a);
        sb.append(StringUtil.COMMA);
        sb.append(this.c);
        if (this.b != null) {
            sb.append(StringUtil.COMMA);
            sb.append(this.b);
        }
        if (this.f != null || this.g != null) {
            sb.append(" resolved to ");
            j$.time.chrono.b bVar = this.f;
            if (bVar != null) {
                sb.append(bVar);
                if (this.g != null) {
                    sb.append('T');
                    sb.append(this.g);
                }
            } else {
                sb.append(this.g);
            }
        }
        return sb.toString();
    }
}
