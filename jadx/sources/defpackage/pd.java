package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pd {
    public final int a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    public pd(int i, long j, long j2, long j3, long j4) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pd)) {
            return false;
        }
        pd pdVar = (pd) obj;
        return this.a == pdVar.a && this.b == pdVar.b && this.c == pdVar.c && this.d == pdVar.d && this.e == pdVar.e;
    }

    public final int hashCode() {
        int i = this.a * 31;
        long j = this.b;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.c;
        int i3 = (i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.d;
        int i4 = (i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.e;
        return i4 + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        return "AppTrafficStat(uid=" + this.a + ", sentBytes=" + this.b + ", receivedBytes=" + this.c + ", sentBytesDiff=" + this.d + ", receivedBytesDiff=" + this.e + ")";
    }
}
