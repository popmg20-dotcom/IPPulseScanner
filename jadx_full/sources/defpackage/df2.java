package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class df2 extends bf2 {
    public static final df2 A = new df2(1, 0);

    public df2(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // defpackage.bf2
    public final boolean equals(Object obj) {
        if (!(obj instanceof df2)) {
            return false;
        }
        if (isEmpty() && ((df2) obj).isEmpty()) {
            return true;
        }
        df2 df2Var = (df2) obj;
        return this.b == df2Var.b && this.f == df2Var.f;
    }

    @Override // defpackage.bf2
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.b;
        long j2 = 31 * (j ^ (j >>> 32));
        long j3 = this.f;
        return (int) (j2 + (j3 ^ (j3 >>> 32)));
    }

    @Override // defpackage.bf2
    public final boolean isEmpty() {
        return this.b > this.f;
    }

    @Override // defpackage.bf2
    public final String toString() {
        return this.b + ".." + this.f;
    }
}
