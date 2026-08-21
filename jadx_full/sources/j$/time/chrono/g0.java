package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends a implements Serializable {
    public static final g0 c = new g0();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        map.put("en", new String[]{"BB", "BE"});
        map.put("th", new String[]{"BB", "BE"});
        map2.put("en", new String[]{"B.B.", "B.E."});
        map2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        map3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        map3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private g0() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.a
    public final List A() {
        return j$.time.a.L(j0.values());
    }

    @Override // j$.time.chrono.a
    public final String B() {
        return "buddhist";
    }

    @Override // j$.time.chrono.a
    public final String C() {
        return "ThaiBuddhist";
    }

    @Override // j$.time.chrono.a
    public final int F(m mVar, int i) {
        if (mVar instanceof j0) {
            return mVar == j0.BE ? i : 1 - i;
        }
        throw new ClassCastException("Era must be BuddhistEra");
    }

    @Override // j$.time.chrono.a
    public final j$.time.temporal.u G(j$.time.temporal.a aVar) {
        int i = f0.a[aVar.ordinal()];
        if (i == 1) {
            j$.time.temporal.u uVar = j$.time.temporal.a.PROLEPTIC_MONTH.b;
            return j$.time.temporal.u.f(uVar.a + 6516, uVar.d + 6516);
        }
        if (i == 2) {
            j$.time.temporal.u uVar2 = j$.time.temporal.a.YEAR.b;
            return j$.time.temporal.u.g((-(uVar2.a + 543)) + 1, uVar2.d + 543);
        }
        if (i != 3) {
            return aVar.b;
        }
        j$.time.temporal.u uVar3 = j$.time.temporal.a.YEAR.b;
        return j$.time.temporal.u.f(uVar3.a + 543, uVar3.d + 543);
    }

    @Override // j$.time.chrono.a
    public final b J(Map map, j$.time.format.w wVar) {
        return (i0) super.J(map, wVar);
    }

    @Override // j$.time.chrono.a
    public final j N(Instant instant, ZoneId zoneId) {
        return l.B(this, instant, zoneId);
    }

    @Override // j$.time.chrono.a
    public final b i(int i, int i2, int i3) {
        return new i0(j$.time.i.K(i - 543, i2, i3));
    }

    @Override // j$.time.chrono.a
    public final b j(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof i0 ? (i0) temporalAccessor : new i0(j$.time.i.C(temporalAccessor));
    }

    @Override // j$.time.chrono.a
    public final b k(long j) {
        return new i0(j$.time.i.L(j));
    }

    @Override // j$.time.chrono.a
    public final b m() {
        return new i0(j$.time.i.C(j$.time.i.J(j$.time.a.T())));
    }

    @Override // j$.time.chrono.a
    public final b p(int i, int i2) {
        return new i0(j$.time.i.M(i - 543, i2));
    }

    @Override // j$.time.chrono.a
    public final m s(int i) {
        if (i == 0) {
            return j0.BEFORE_BE;
        }
        if (i == 1) {
            return j0.BE;
        }
        j$.time.h.d("Invalid era: ", i);
        return null;
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }
}
