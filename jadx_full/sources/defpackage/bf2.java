package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class bf2 implements Iterable, z72 {
    public final long b;
    public final long f;
    public final long z;

    public bf2(long j, long j2, long j3) {
        if (j3 == 0) {
            xe.k("Step must be non-zero.");
            throw null;
        }
        if (j3 == Long.MIN_VALUE) {
            xe.k("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.b = j;
        if (j3 > 0) {
            if (j < j2) {
                long j4 = j2 % j3;
                long j5 = j % j3;
                long j6 = ((j4 < 0 ? j4 + j3 : j4) - (j5 < 0 ? j5 + j3 : j5)) % j3;
                j2 -= j6 < 0 ? j6 + j3 : j6;
            }
        } else {
            if (j3 >= 0) {
                xe.k("Step is zero.");
                throw null;
            }
            if (j > j2) {
                long j7 = -j3;
                long j8 = j % j7;
                long j9 = j2 % j7;
                long j10 = ((j8 < 0 ? j8 + j7 : j8) - (j9 < 0 ? j9 + j7 : j9)) % j7;
                j2 += j10 < 0 ? j10 + j7 : j10;
            }
        }
        this.f = j2;
        this.z = j3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bf2)) {
            return false;
        }
        if (isEmpty() && ((bf2) obj).isEmpty()) {
            return true;
        }
        bf2 bf2Var = (bf2) obj;
        return this.b == bf2Var.b && this.f == bf2Var.f && this.z == bf2Var.z;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.b;
        long j2 = this.f;
        long j3 = (((j ^ (j >>> 32)) * 31) + (j2 ^ (j2 >>> 32))) * 31;
        long j4 = this.z;
        return (int) (j3 + (j4 ^ (j4 >>> 32)));
    }

    public boolean isEmpty() {
        long j = this.z;
        long j2 = this.f;
        long j3 = this.b;
        return j > 0 ? j3 > j2 : j3 < j2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new cf2(this.b, this.f, this.z);
    }

    public String toString() {
        StringBuilder sb;
        long j = this.z;
        long j2 = this.f;
        long j3 = this.b;
        if (j > 0) {
            sb = new StringBuilder();
            sb.append(j3);
            sb.append("..");
            sb.append(j2);
            sb.append(" step ");
            sb.append(j);
        } else {
            sb = new StringBuilder();
            sb.append(j3);
            sb.append(" downTo ");
            sb.append(j2);
            sb.append(" step ");
            sb.append(-j);
        }
        return sb.toString();
    }
}
