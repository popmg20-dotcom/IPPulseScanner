package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class bq3 {
    public static final long[] a = {-9187201950435737345L, -1};

    static {
        int iB = b(0);
        int iMax = iB > 0 ? Math.max(7, a(iB)) : 0;
        if (iMax != 0) {
            long[] jArr = new long[((iMax + 15) & (-8)) >> 3];
            qe.k0(jArr);
            int i = iMax >> 3;
            long j = 255 << ((iMax & 7) << 3);
            jArr[i] = (jArr[i] & (~j)) | j;
        }
        if (iMax != 0) {
            Object[] objArr = new Object[iMax];
        }
        if (iMax == 0) {
            return;
        }
        Object[] objArr2 = new Object[iMax];
    }

    public static final int a(int i) {
        if (i > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i);
        }
        return 0;
    }

    public static final int b(int i) {
        if (i == 7) {
            return 8;
        }
        return ((i - 1) / 7) + i;
    }
}
