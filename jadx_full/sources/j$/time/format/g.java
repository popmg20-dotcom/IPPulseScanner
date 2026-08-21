package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import j$.time.z;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements e {
    public static volatile Map.Entry b;
    public static volatile Map.Entry c;
    public final /* synthetic */ int a;

    public /* synthetic */ g(int i) {
        this.a = i;
    }

    public static int a(p pVar, CharSequence charSequence, int i, int i2, i iVar) {
        String upperCase = charSequence.subSequence(i, i2).toString().toUpperCase();
        if (i2 >= charSequence.length()) {
            pVar.e(ZoneId.D(upperCase, true));
            return i2;
        }
        if (charSequence.charAt(i2) == '0' || pVar.a(charSequence.charAt(i2), 'Z')) {
            pVar.e(ZoneId.D(upperCase, true));
            return i2;
        }
        p pVar2 = new p(pVar.a);
        pVar2.b = pVar.b;
        pVar2.c = pVar.c;
        int i3 = iVar.i(pVar2, charSequence, i2);
        try {
            if (i3 >= 0) {
                pVar.e(ZoneId.E(upperCase, ZoneOffset.J((int) pVar2.d(j$.time.temporal.a.OFFSET_SECONDS).longValue())));
                return i3;
            }
            if (iVar == i.e) {
                return ~i;
            }
            pVar.e(ZoneId.D(upperCase, true));
            return i2;
        } catch (j$.time.c unused) {
            return ~i;
        }
    }

    @Override // j$.time.format.e
    public final boolean h(r rVar, StringBuilder sb) {
        int i = 0;
        switch (this.a) {
            case 0:
                Long lA = rVar.a(j$.time.temporal.a.INSTANT_SECONDS);
                TemporalAccessor temporalAccessor = rVar.a;
                j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
                Long lValueOf = temporalAccessor.e(aVar) ? Long.valueOf(temporalAccessor.s(aVar)) : null;
                if (lA == null) {
                    return false;
                }
                long jLongValue = lA.longValue();
                int iA = aVar.b.a(lValueOf != null ? lValueOf.longValue() : 0L, aVar);
                if (jLongValue >= -62167219200L) {
                    long j = jLongValue - 253402300800L;
                    long jO = j$.time.a.O(j, 315569520000L) + 1;
                    LocalDateTime localDateTimeE = LocalDateTime.E(j$.time.a.N(j, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                    if (jO > 0) {
                        sb.append('+');
                        sb.append(jO);
                    }
                    sb.append(localDateTimeE);
                    if (localDateTimeE.b.c == 0) {
                        sb.append(":00");
                    }
                } else {
                    long j2 = jLongValue + 62167219200L;
                    long j3 = j2 / 315569520000L;
                    long j4 = j2 % 315569520000L;
                    LocalDateTime localDateTimeE2 = LocalDateTime.E(j4 - 62167219200L, 0, ZoneOffset.UTC);
                    int length = sb.length();
                    sb.append(localDateTimeE2);
                    if (localDateTimeE2.b.c == 0) {
                        sb.append(":00");
                    }
                    if (j3 < 0) {
                        if (localDateTimeE2.a.a == -10000) {
                            sb.replace(length, length + 2, Long.toString(j3 - 1));
                        } else if (j4 == 0) {
                            sb.insert(length, j3);
                        } else {
                            sb.insert(length + 1, Math.abs(j3));
                        }
                    }
                }
                if (iA > 0) {
                    sb.append('.');
                    int i2 = 100000000;
                    while (true) {
                        if (iA > 0 || i % 3 != 0 || i < -2) {
                            int i3 = iA / i2;
                            sb.append((char) (i3 + 48));
                            iA -= i3 * i2;
                            i2 /= 10;
                            i++;
                        }
                    }
                }
                sb.append('Z');
                return true;
            default:
                z zVar = o.f;
                TemporalAccessor temporalAccessor2 = rVar.a;
                Object objM = temporalAccessor2.m(zVar);
                if (objM == null && rVar.c == 0) {
                    throw new j$.time.c("Unable to extract " + zVar + " from temporal " + temporalAccessor2);
                }
                ZoneId zoneId = (ZoneId) objM;
                if (zoneId == null) {
                    return false;
                }
                sb.append(zoneId.B());
                return true;
        }
    }

    @Override // j$.time.format.e
    public final int i(p pVar, CharSequence charSequence, int i) {
        int i2;
        int i3 = 1;
        switch (this.a) {
            case 0:
                o oVar = new o();
                oVar.a(DateTimeFormatter.ISO_LOCAL_DATE);
                oVar.c('T');
                j$.time.temporal.a aVar = j$.time.temporal.a.HOUR_OF_DAY;
                oVar.g(aVar, 2);
                oVar.c(':');
                j$.time.temporal.a aVar2 = j$.time.temporal.a.MINUTE_OF_HOUR;
                oVar.g(aVar2, 2);
                oVar.c(':');
                j$.time.temporal.a aVar3 = j$.time.temporal.a.SECOND_OF_MINUTE;
                oVar.g(aVar3, 2);
                j$.time.temporal.a aVar4 = j$.time.temporal.a.NANO_OF_SECOND;
                oVar.b(new f(aVar4));
                oVar.c('Z');
                d dVar = oVar.l(Locale.getDefault(), w.SMART, null).a;
                if (dVar.b) {
                    dVar = new d(dVar.a, false);
                }
                p pVar2 = new p(pVar.a);
                pVar2.b = pVar.b;
                pVar2.c = pVar.c;
                int i4 = dVar.i(pVar2, charSequence, i);
                if (i4 < 0) {
                    return i4;
                }
                long jLongValue = pVar2.d(j$.time.temporal.a.YEAR).longValue();
                int iIntValue = pVar2.d(j$.time.temporal.a.MONTH_OF_YEAR).intValue();
                int iIntValue2 = pVar2.d(j$.time.temporal.a.DAY_OF_MONTH).intValue();
                int iIntValue3 = pVar2.d(aVar).intValue();
                int iIntValue4 = pVar2.d(aVar2).intValue();
                Long lD = pVar2.d(aVar3);
                Long lD2 = pVar2.d(aVar4);
                int iIntValue5 = lD != null ? lD.intValue() : 0;
                int iIntValue6 = lD2 != null ? lD2.intValue() : 0;
                if (iIntValue3 == 24 && iIntValue4 == 0 && iIntValue5 == 0 && iIntValue6 == 0) {
                    iIntValue3 = 0;
                } else {
                    if (iIntValue3 == 23 && iIntValue4 == 59 && iIntValue5 == 60) {
                        pVar.c().d = true;
                        iIntValue5 = 59;
                    }
                    i3 = 0;
                }
                int i5 = ((int) jLongValue) % 10000;
                try {
                    LocalDateTime localDateTime = LocalDateTime.c;
                    j$.time.i iVarK = j$.time.i.K(i5, iIntValue, iIntValue2);
                    j$.time.l lVarE = j$.time.l.E(iIntValue3, iIntValue4, iIntValue5, 0);
                    return pVar.f(aVar4, iIntValue6, i, pVar.f(j$.time.temporal.a.INSTANT_SECONDS, j$.time.a.v(new LocalDateTime(iVarK, lVarE).J(iVarK.O(i3), lVarE), ZoneOffset.UTC) + j$.time.a.P(jLongValue / 10000, 315569520000L), i, i4));
                } catch (RuntimeException unused) {
                    return ~i;
                }
            default:
                int length = charSequence.length();
                if (i > length) {
                    throw new IndexOutOfBoundsException();
                }
                if (i != length) {
                    char cCharAt = charSequence.charAt(i);
                    if (cCharAt == '+' || cCharAt == '-') {
                        return a(pVar, charSequence, i, i, i.e);
                    }
                    int i6 = i + 2;
                    if (length >= i6) {
                        char cCharAt2 = charSequence.charAt(i + 1);
                        if (pVar.a(cCharAt, 'U') && pVar.a(cCharAt2, 'T')) {
                            int i7 = i + 3;
                            return (length < i7 || !pVar.a(charSequence.charAt(i6), 'C')) ? a(pVar, charSequence, i, i6, i.f) : a(pVar, charSequence, i, i7, i.f);
                        }
                        if (pVar.a(cCharAt, 'G') && length >= (i2 = i + 3) && pVar.a(cCharAt2, 'M') && pVar.a(charSequence.charAt(i6), 'T')) {
                            int i8 = i + 4;
                            if (length < i8 || !pVar.a(charSequence.charAt(i2), '0')) {
                                return a(pVar, charSequence, i, i2, i.f);
                            }
                            pVar.e(ZoneId.D("GMT0", true));
                            return i8;
                        }
                    }
                    Set<String> set = j$.time.zone.i.d;
                    int size = set.size();
                    Map.Entry simpleImmutableEntry = pVar.b ? b : c;
                    if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                        synchronized (this) {
                            try {
                                simpleImmutableEntry = pVar.b ? b : c;
                                if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                                    Integer numValueOf = Integer.valueOf(size);
                                    k kVar = pVar.b ? new k("", null, null) : new j("", null, null);
                                    for (String str : set) {
                                        kVar.a(str, str);
                                    }
                                    simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(numValueOf, kVar);
                                    if (pVar.b) {
                                        b = simpleImmutableEntry;
                                    } else {
                                        c = simpleImmutableEntry;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    k kVar2 = (k) simpleImmutableEntry.getValue();
                    ParsePosition parsePosition = new ParsePosition(i);
                    String strC = kVar2.c(charSequence, parsePosition);
                    if (strC != null) {
                        pVar.e(ZoneId.D(strC, true));
                        return parsePosition.getIndex();
                    }
                    if (pVar.a(cCharAt, 'Z')) {
                        pVar.e(ZoneOffset.UTC);
                        return i + 1;
                    }
                    break;
                }
                return ~i;
        }
    }

    public final String toString() {
        switch (this.a) {
            case 0:
                return "Instant()";
            default:
                return "ZoneRegionId()";
        }
    }
}
