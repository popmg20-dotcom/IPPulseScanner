package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class v extends a implements Serializable {
    public static final v c = new v();
    private static final long serialVersionUID = 459996390165777884L;

    private v() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.a
    public final List A() {
        y[] yVarArr = y.e;
        return j$.time.a.L((y[]) Arrays.copyOf(yVarArr, yVarArr.length));
    }

    @Override // j$.time.chrono.a
    public final String B() {
        return "japanese";
    }

    @Override // j$.time.chrono.a
    public final String C() {
        return "Japanese";
    }

    @Override // j$.time.chrono.a
    public final int F(m mVar, int i) {
        if (!(mVar instanceof y)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        int i2 = ((y) mVar).b.a;
        int i3 = (i2 + i) - 1;
        if (i == 1 || (i3 >= -999999999 && i3 <= 999999999 && i3 >= i2 && mVar == y.A(j$.time.i.K(i3, 1, 1)))) {
            return i3;
        }
        j$.time.h.j("Invalid yearOfEra value");
        return 0;
    }

    @Override // j$.time.chrono.a
    public final j$.time.temporal.u G(j$.time.temporal.a aVar) {
        switch (u.a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                j$.time.h.b(aVar, "Unsupported field: ");
                return null;
            case 5:
                y[] yVarArr = y.e;
                int i = yVarArr[yVarArr.length - 1].b.a;
                int iMin = 1000000000 - yVarArr[yVarArr.length - 1].b.a;
                int i2 = yVarArr[0].b.a;
                int i3 = 1;
                while (true) {
                    y[] yVarArr2 = y.e;
                    if (i3 >= yVarArr2.length) {
                        return j$.time.temporal.u.g(iMin, 999999999 - i);
                    }
                    y yVar = yVarArr2[i3];
                    iMin = Math.min(iMin, (yVar.b.a - i2) + 1);
                    i2 = yVar.b.a;
                    i3++;
                }
                break;
            case 6:
                y yVar2 = y.d;
                long jMin = j$.time.temporal.a.DAY_OF_YEAR.b.c;
                for (y yVar3 : y.e) {
                    jMin = Math.min(jMin, ((yVar3.b.H() ? 366 : 365) - yVar3.b.F()) + 1);
                    if (yVar3.B() != null) {
                        jMin = Math.min(jMin, yVar3.B().b.F() - 1);
                    }
                }
                return j$.time.temporal.u.g(jMin, j$.time.temporal.a.DAY_OF_YEAR.b.d);
            case 7:
                return j$.time.temporal.u.f(x.d.a, 999999999L);
            case 8:
                long j = y.d.a;
                y[] yVarArr3 = y.e;
                return j$.time.temporal.u.f(j, yVarArr3[yVarArr3.length - 1].a);
            default:
                return aVar.b;
        }
    }

    @Override // j$.time.chrono.a
    public final b J(Map map, j$.time.format.w wVar) {
        return (x) super.J(map, wVar);
    }

    @Override // j$.time.chrono.a
    public final b M(Map map, j$.time.format.w wVar) {
        x xVarI;
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        Long l = (Long) map.get(aVar);
        y yVarC = l != null ? y.C(G(aVar).a(l.longValue(), aVar)) : null;
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR_OF_ERA;
        Long l2 = (Long) map.get(aVar2);
        int iA = l2 != null ? G(aVar2).a(l2.longValue(), aVar2) : 0;
        if (yVarC == null && l2 != null && !map.containsKey(j$.time.temporal.a.YEAR) && wVar != j$.time.format.w.STRICT) {
            y[] yVarArr = y.e;
            yVarC = ((y[]) Arrays.copyOf(yVarArr, yVarArr.length))[((y[]) Arrays.copyOf(yVarArr, yVarArr.length)).length - 1];
        }
        if (l2 != null && yVarC != null) {
            j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                j$.time.temporal.a aVar4 = j$.time.temporal.a.DAY_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    map.remove(aVar);
                    map.remove(aVar2);
                    if (wVar == j$.time.format.w.LENIENT) {
                        return new x(j$.time.i.K((yVarC.b.a + iA) - 1, 1, 1)).F(j$.time.a.Q(((Long) map.remove(aVar3)).longValue(), 1L), j$.time.temporal.b.MONTHS).F(j$.time.a.Q(((Long) map.remove(aVar4)).longValue(), 1L), j$.time.temporal.b.DAYS);
                    }
                    int iA2 = G(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int iA3 = G(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    if (wVar != j$.time.format.w.SMART) {
                        j$.time.i iVar = x.d;
                        Objects.requireNonNull(yVarC, "era");
                        j$.time.i iVarK = j$.time.i.K((yVarC.b.a + iA) - 1, iA2, iA3);
                        if (!iVarK.G(yVarC.b) && yVarC == y.A(iVarK)) {
                            return new x(yVarC, iA, iVarK);
                        }
                        j$.time.h.j("year, month, and day not valid for Era");
                        return null;
                    }
                    if (iA < 1) {
                        j$.time.h.d("Invalid YearOfEra: ", iA);
                        return null;
                    }
                    int i = (yVarC.b.a + iA) - 1;
                    try {
                        xVarI = new x(j$.time.i.K(i, iA2, iA3));
                    } catch (j$.time.c unused) {
                        xVarI = new x(j$.time.i.K(i, iA2, 1)).I(new j$.time.z(2));
                    }
                    if (xVarI.b == yVarC || j$.time.temporal.r.a(xVarI, j$.time.temporal.a.YEAR_OF_ERA) <= 1 || iA <= 1) {
                        return xVarI;
                    }
                    throw new j$.time.c("Invalid YearOfEra for Era: " + yVarC + " " + iA);
                }
            }
            j$.time.temporal.a aVar5 = j$.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar5)) {
                map.remove(aVar);
                map.remove(aVar2);
                if (wVar == j$.time.format.w.LENIENT) {
                    return new x(j$.time.i.M((yVarC.b.a + iA) - 1, 1)).F(j$.time.a.Q(((Long) map.remove(aVar5)).longValue(), 1L), j$.time.temporal.b.DAYS);
                }
                int iA4 = G(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5);
                j$.time.i iVar2 = x.d;
                Objects.requireNonNull(yVarC, "era");
                j$.time.i iVar3 = yVarC.b;
                int i2 = iVar3.a;
                j$.time.i iVarM = iA == 1 ? j$.time.i.M(i2, (iVar3.F() + iA4) - 1) : j$.time.i.M((i2 + iA) - 1, iA4);
                if (!iVarM.G(yVarC.b) && yVarC == y.A(iVarM)) {
                    return new x(yVarC, iA, iVarM);
                }
                j$.time.h.j("Invalid parameters");
            }
        }
        return null;
    }

    @Override // j$.time.chrono.a
    public final j N(Instant instant, ZoneId zoneId) {
        return l.B(this, instant, zoneId);
    }

    @Override // j$.time.chrono.a
    public final b i(int i, int i2, int i3) {
        return new x(j$.time.i.K(i, i2, i3));
    }

    @Override // j$.time.chrono.a
    public final b j(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof x ? (x) temporalAccessor : new x(j$.time.i.C(temporalAccessor));
    }

    @Override // j$.time.chrono.a
    public final b k(long j) {
        return new x(j$.time.i.L(j));
    }

    @Override // j$.time.chrono.a
    public final b m() {
        return new x(j$.time.i.C(j$.time.i.J(j$.time.a.T())));
    }

    @Override // j$.time.chrono.a
    public final b p(int i, int i2) {
        return new x(j$.time.i.M(i, i2));
    }

    @Override // j$.time.chrono.a
    public final m s(int i) {
        return y.C(i);
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }
}
