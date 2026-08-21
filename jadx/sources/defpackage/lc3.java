package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lc3 implements l83 {
    public static final k83 b = new k83("DAV:", "quota-available-bytes");
    public final long a;

    public lc3(long j) {
        this.a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof lc3) && this.a == ((lc3) obj).a;
    }

    public final int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "QuotaAvailableBytes(quotaAvailableBytes=" + this.a + ')';
    }
}
