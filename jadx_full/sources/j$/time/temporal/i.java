package j$.time.temporal;

import j$.time.Duration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public enum i implements s {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");

    public final String a;

    static {
        Duration.ofSeconds(31556952L);
        Duration.ofSeconds(7889238L);
    }

    i(String str) {
        this.a = str;
    }

    @Override // j$.time.temporal.s
    public final m h(m mVar, long j) {
        int i = c.a[ordinal()];
        if (i == 1) {
            return mVar.c(j$.time.a.K(mVar.h(r4), j), j.c);
        }
        if (i == 2) {
            return mVar.d(j / 4, b.YEARS).d((j % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.a;
    }
}
