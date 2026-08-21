package j$.time.zone;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.s;
import j$.time.l;
import j$.time.n;
import j$.time.temporal.o;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements Serializable {
    public static final long[] i = new long[0];
    public static final e[] j = new e[0];
    public static final LocalDateTime[] k = new LocalDateTime[0];
    public static final b[] l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;
    public final long[] a;
    public final ZoneOffset[] b;
    public final long[] c;
    public final LocalDateTime[] d;
    public final ZoneOffset[] e;
    public final e[] f;
    public final TimeZone g;
    public final transient ConcurrentHashMap h = new ConcurrentHashMap();

    public f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.a = jArr;
        this.b = zoneOffsetArr;
        this.c = jArr2;
        this.e = zoneOffsetArr2;
        this.f = eVarArr;
        if (jArr2.length == 0) {
            this.d = k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < jArr2.length) {
                ZoneOffset zoneOffset = zoneOffsetArr2[i2];
                int i3 = i2 + 1;
                ZoneOffset zoneOffset2 = zoneOffsetArr2[i3];
                LocalDateTime localDateTimeE = LocalDateTime.E(jArr2[i2], 0, zoneOffset);
                if (zoneOffset2.b > zoneOffset.b) {
                    arrayList.add(localDateTimeE);
                    arrayList.add(localDateTimeE.G(zoneOffset2.b - zoneOffset.b));
                } else {
                    arrayList.add(localDateTimeE.G(r3 - r4));
                    arrayList.add(localDateTimeE);
                }
                i2 = i3;
            }
            this.d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.g = null;
    }

    public static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime localDateTime2 = bVar.b;
        if (bVar.d.b > bVar.c.b) {
            if (localDateTime.C(localDateTime2)) {
                return bVar.c;
            }
            if (!localDateTime.C(bVar.b.G(bVar.d.b - bVar.c.b))) {
                return bVar.d;
            }
        } else {
            if (!localDateTime.C(localDateTime2)) {
                return bVar.d;
            }
            if (localDateTime.C(bVar.b.G(bVar.d.b - bVar.c.b))) {
                return bVar.c;
            }
        }
        return bVar;
    }

    public static int c(long j2, ZoneOffset zoneOffset) {
        return j$.time.i.L(j$.time.a.O(j2 + ((long) zoneOffset.b), 86400L)).a;
    }

    public static ZoneOffset g(int i2) {
        return ZoneOffset.J(i2 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.g != null ? (byte) 100 : (byte) 1, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b[] b(int i2) {
        j$.time.i iVarB;
        b[] bVarArr = l;
        Integer numValueOf = Integer.valueOf(i2);
        b[] bVarArr2 = (b[]) this.h.get(numValueOf);
        if (bVarArr2 != null) {
            return bVarArr2;
        }
        long j2 = 1;
        int i3 = 0;
        int i4 = 1;
        if (this.g != null) {
            if (i2 < 1800) {
                return bVarArr;
            }
            LocalDateTime localDateTime = LocalDateTime.c;
            j$.time.i iVarK = j$.time.i.K(i2 - 1, 12, 31);
            j$.time.temporal.a.HOUR_OF_DAY.s(0L);
            long jV = j$.time.a.v(new LocalDateTime(iVarK, l.h[0]), this.b[0]);
            long j3 = 1000;
            int offset = this.g.getOffset(jV * 1000);
            long j4 = 31968000 + jV;
            while (jV < j4) {
                long j5 = jV + 7776000;
                long j6 = j3;
                if (offset != this.g.getOffset(j5 * j6)) {
                    while (j5 - jV > j2) {
                        long jO = j$.time.a.O(j5 + jV, 2L);
                        if (this.g.getOffset(jO * j6) == offset) {
                            jV = jO;
                        } else {
                            j5 = jO;
                        }
                        j2 = 1;
                    }
                    if (this.g.getOffset(jV * j6) == offset) {
                        jV = j5;
                    }
                    ZoneOffset zoneOffsetG = g(offset);
                    int offset2 = this.g.getOffset(jV * j6);
                    ZoneOffset zoneOffsetG2 = g(offset2);
                    if (c(jV, zoneOffsetG2) == i2) {
                        bVarArr = (b[]) Arrays.copyOf(bVarArr, bVarArr.length + 1);
                        bVarArr[bVarArr.length - 1] = new b(jV, zoneOffsetG, zoneOffsetG2);
                    }
                    offset = offset2;
                } else {
                    jV = j5;
                }
                j3 = j6;
                j2 = 1;
            }
            if (1916 <= i2 && i2 < 2100) {
                this.h.putIfAbsent(numValueOf, bVarArr);
            }
            return bVarArr;
        }
        e[] eVarArr = this.f;
        b[] bVarArr3 = new b[eVarArr.length];
        int i5 = 0;
        while (i5 < eVarArr.length) {
            e eVar = eVarArr[i5];
            byte b = eVar.b;
            n nVar = eVar.a;
            if (b < 0) {
                long j7 = i2;
                s.c.getClass();
                int iB = nVar.B(s.O(j7)) + 1 + eVar.b;
                j$.time.i iVar = j$.time.i.d;
                j$.time.temporal.a.YEAR.s(j7);
                Objects.requireNonNull(nVar, "month");
                j$.time.temporal.a.DAY_OF_MONTH.s(iB);
                iVarB = j$.time.i.B(i2, nVar.getValue(), iB);
                j$.time.e eVar2 = eVar.c;
                if (eVar2 != null) {
                    iVarB = iVarB.i(new o(eVar2.getValue(), i4));
                }
            } else {
                j$.time.i iVar2 = j$.time.i.d;
                j$.time.temporal.a.YEAR.s(i2);
                Objects.requireNonNull(nVar, "month");
                j$.time.temporal.a.DAY_OF_MONTH.s(b);
                iVarB = j$.time.i.B(i2, nVar.getValue(), b);
                j$.time.e eVar3 = eVar.c;
                if (eVar3 != null) {
                    iVarB = iVarB.i(new o(eVar3.getValue(), i3));
                }
            }
            if (eVar.e) {
                iVarB = iVarB.O(1L);
            }
            LocalDateTime localDateTimeD = LocalDateTime.D(iVarB, eVar.d);
            d dVar = eVar.f;
            ZoneOffset zoneOffset = eVar.g;
            ZoneOffset zoneOffset2 = eVar.h;
            dVar.getClass();
            int i6 = c.a[dVar.ordinal()];
            if (i6 == 1) {
                localDateTimeD = localDateTimeD.G(zoneOffset2.b - ZoneOffset.UTC.b);
            } else if (i6 == 2) {
                localDateTimeD = localDateTimeD.G(zoneOffset2.b - zoneOffset.b);
            }
            bVarArr3[i5] = new b(localDateTimeD, eVar.h, eVar.i);
            i5++;
            i3 = 0;
        }
        if (i2 < 2100) {
            this.h.putIfAbsent(numValueOf, bVarArr3);
        }
        return bVarArr3;
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            long j2 = instant.a;
            return g(timeZone.getOffset((j2 >= 0 || instant.b <= 0) ? j$.time.a.K(j$.time.a.P(j2, 1000L), instant.b / 1000000) : j$.time.a.K(j$.time.a.P(j2 + 1, 1000L), (instant.b / 1000000) - 1000)));
        }
        if (this.c.length == 0) {
            return this.b[0];
        }
        long epochSecond = instant.getEpochSecond();
        if (this.f.length > 0) {
            if (epochSecond > this.c[r9.length - 1]) {
                b[] bVarArrB = b(c(epochSecond, this.e[r9.length - 1]));
                b bVar = null;
                for (int i2 = 0; i2 < bVarArrB.length; i2++) {
                    bVar = bVarArrB[i2];
                    if (epochSecond < bVar.a) {
                        return bVar.c;
                    }
                }
                return bVar.d;
            }
        }
        int iBinarySearch = Arrays.binarySearch(this.c, epochSecond);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return this.e[iBinarySearch + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(j$.time.LocalDateTime r9) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.f.e(j$.time.LocalDateTime):java.lang.Object");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Objects.equals(this.g, fVar.g) && Arrays.equals(this.a, fVar.a) && Arrays.equals(this.b, fVar.b) && Arrays.equals(this.c, fVar.c) && Arrays.equals(this.e, fVar.e) && Arrays.equals(this.f, fVar.f);
    }

    public final List f(LocalDateTime localDateTime) {
        Object objE = e(localDateTime);
        if (!(objE instanceof b)) {
            return Collections.singletonList((ZoneOffset) objE);
        }
        b bVar = (b) objE;
        ZoneOffset zoneOffset = bVar.d;
        int i2 = zoneOffset.b;
        ZoneOffset zoneOffset2 = bVar.c;
        return i2 > zoneOffset2.b ? Collections.EMPTY_LIST : j$.time.a.L(new Object[]{zoneOffset2, zoneOffset});
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f) ^ ((((Objects.hashCode(this.g) ^ Arrays.hashCode(this.a)) ^ Arrays.hashCode(this.b)) ^ Arrays.hashCode(this.c)) ^ Arrays.hashCode(this.e));
    }

    public final String toString() {
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.b[r3.length - 1] + "]";
    }

    public f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.b = zoneOffsetArr;
        long[] jArr = i;
        this.a = jArr;
        this.c = jArr;
        this.d = k;
        this.e = zoneOffsetArr;
        this.f = j;
        this.g = null;
    }

    public f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {g(timeZone.getRawOffset())};
        this.b = zoneOffsetArr;
        long[] jArr = i;
        this.a = jArr;
        this.c = jArr;
        this.d = k;
        this.e = zoneOffsetArr;
        this.f = j;
        this.g = timeZone;
    }
}
