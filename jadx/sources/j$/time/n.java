package j$.time;

import com.tencent.mars.xlog.Xlog;
import j$.time.temporal.TemporalAccessor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements TemporalAccessor, j$.time.temporal.n {
    public static final n APRIL;
    public static final n AUGUST;
    public static final n DECEMBER;
    public static final n FEBRUARY;
    public static final n JANUARY;
    public static final n JULY;
    public static final n JUNE;
    public static final n MARCH;
    public static final n MAY;
    public static final n NOVEMBER;
    public static final n OCTOBER;
    public static final n SEPTEMBER;
    public static final n[] a;
    public static final /* synthetic */ n[] b;

    static {
        n nVar = new n("JANUARY", 0);
        JANUARY = nVar;
        n nVar2 = new n("FEBRUARY", 1);
        FEBRUARY = nVar2;
        n nVar3 = new n("MARCH", 2);
        MARCH = nVar3;
        n nVar4 = new n("APRIL", 3);
        APRIL = nVar4;
        n nVar5 = new n("MAY", 4);
        MAY = nVar5;
        n nVar6 = new n("JUNE", 5);
        JUNE = nVar6;
        n nVar7 = new n("JULY", 6);
        JULY = nVar7;
        n nVar8 = new n("AUGUST", 7);
        AUGUST = nVar8;
        n nVar9 = new n("SEPTEMBER", 8);
        SEPTEMBER = nVar9;
        n nVar10 = new n("OCTOBER", 9);
        OCTOBER = nVar10;
        n nVar11 = new n("NOVEMBER", 10);
        NOVEMBER = nVar11;
        n nVar12 = new n("DECEMBER", 11);
        DECEMBER = nVar12;
        b = new n[]{nVar, nVar2, nVar3, nVar4, nVar5, nVar6, nVar7, nVar8, nVar9, nVar10, nVar11, nVar12};
        a = values();
    }

    public static n D(int i) {
        if (i >= 1 && i <= 12) {
            return a[i - 1];
        }
        h.d("Invalid value for MonthOfYear: ", i);
        return null;
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) b.clone();
    }

    public final int A(boolean z) {
        switch (m.a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z ? 1 : 0) + 91;
            case 3:
                return (z ? 1 : 0) + 152;
            case 4:
                return (z ? 1 : 0) + 244;
            case 5:
                return (z ? 1 : 0) + 305;
            case 6:
                return 1;
            case 7:
                return (z ? 1 : 0) + 60;
            case 8:
                return (z ? 1 : 0) + 121;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return (z ? 1 : 0) + 182;
            case 10:
                return (z ? 1 : 0) + 213;
            case 11:
                return (z ? 1 : 0) + 274;
            default:
                return (z ? 1 : 0) + 335;
        }
    }

    public final int B(boolean z) {
        int i = m.a[ordinal()];
        return i != 1 ? (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31 : z ? 29 : 28;
    }

    public final int C() {
        int i = m.a[ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31;
        }
        return 29;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean e(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.MONTH_OF_YEAR : qVar != null && qVar.h(this);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int h(j$.time.temporal.q qVar) {
        return qVar == j$.time.temporal.a.MONTH_OF_YEAR ? getValue() : j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        return qVar == j$.time.temporal.a.MONTH_OF_YEAR ? qVar.k() : j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m k(j$.time.temporal.m mVar) {
        if (a.J(mVar).equals(j$.time.chrono.s.c)) {
            return mVar.c(getValue(), j$.time.temporal.a.MONTH_OF_YEAR);
        }
        h.j("Adjustment only supported on ISO date-time");
        return null;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object m(z zVar) {
        return zVar == j$.time.temporal.r.b ? j$.time.chrono.s.c : zVar == j$.time.temporal.r.c ? j$.time.temporal.b.MONTHS : j$.time.temporal.r.c(this, zVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return getValue();
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
        return qVar.m(this);
    }
}
