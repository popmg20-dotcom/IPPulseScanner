package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class rf1 {
    public static final float[] a;

    static {
        long[] jArr = bq3.a;
        int iB = bq3.b(0);
        int iMax = iB > 0 ? Math.max(7, bq3.a(iB)) : 0;
        if (iMax != 0) {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            qe.k0(jArr);
        }
        int i = iMax >> 3;
        long j = 255 << ((iMax & 7) << 3);
        jArr[i] = (jArr[i] & (~j)) | j;
        float[] fArr = new float[iMax];
        a = new float[0];
    }
}
