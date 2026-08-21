package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class eg4 {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;

    public eg4(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
        this.g = j7;
        this.h = j8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eg4)) {
            return false;
        }
        eg4 eg4Var = (eg4) obj;
        return this.a == eg4Var.a && this.b == eg4Var.b && this.c == eg4Var.c && this.d == eg4Var.d && this.e == eg4Var.e && this.f == eg4Var.f && this.g == eg4Var.g && this.h == eg4Var.h;
    }

    public final int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.c;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.d;
        int i3 = (i2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.e;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.f;
        int i5 = (i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.g;
        int i6 = (i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j8 = this.h;
        return i6 + ((int) ((j8 >>> 32) ^ j8));
    }

    public final String toString() {
        StringBuilder sbC = fw.C("TrafficStat(totalSentBytes=", ", totalReceivedBytes=", this.a);
        sbC.append(this.b);
        sbC.append(", totalSentBytesDiff=");
        sbC.append(this.c);
        sbC.append(", totalReceivedBytesDiff=");
        sbC.append(this.d);
        sbC.append(", totalProxySentBytes=");
        sbC.append(this.e);
        sbC.append(", totalProxyReceivedBytes=");
        sbC.append(this.f);
        sbC.append(", totalProxySentBytesDiff=");
        sbC.append(this.g);
        sbC.append(", totalProxyReceivedBytesDiff=");
        return dw2.C(sbC, ")", this.h);
    }
}
