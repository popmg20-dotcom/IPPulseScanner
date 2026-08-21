package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tw0 {
    public final byte[] a;
    public final long b;

    public tw0(byte[] bArr, long j) {
        bArr.getClass();
        this.a = bArr;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!tw0.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        tw0 tw0Var = (tw0) obj;
        return Arrays.equals(this.a, tw0Var.a) && this.b == tw0Var.b;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.a) * 31;
        long j = this.b;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "CacheEntry(response=" + Arrays.toString(this.a) + ", expirationTime=" + this.b + ")";
    }
}
