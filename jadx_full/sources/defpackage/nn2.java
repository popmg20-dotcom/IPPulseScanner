package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nn2 {
    public long[] a;
    public int[] b;
    public int c;

    public nn2(int i) {
        long[] jArr;
        this.a = bq3.a;
        this.b = c12.a;
        if (i < 0) {
            xe.k("Capacity must be a positive value.");
            throw null;
        }
        int iB = bq3.b(i);
        int iMax = iB > 0 ? Math.max(7, bq3.a(iB)) : 0;
        this.c = iMax;
        if (iMax == 0) {
            jArr = bq3.a;
        } else {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            qe.k0(jArr);
        }
        this.a = jArr;
        int i2 = iMax >> 3;
        long j = 255 << ((iMax & 7) << 3);
        jArr[i2] = (jArr[i2] & (~j)) | j;
        long[] jArr2 = bq3.a;
        this.b = new int[iMax];
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b7, code lost:
    
        if (((r11 & ((~r11) << 6)) & r22) == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b9, code lost:
    
        r12 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [int] */
    /* JADX WARN: Type inference failed for: r19v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        long j;
        int iNumberOfTrailingZeros;
        boolean z5 = true;
        if (obj == this) {
            return true;
        }
        boolean z6 = false;
        if (!(obj instanceof nn2)) {
            return false;
        }
        nn2 nn2Var = (nn2) obj;
        int[] iArr = this.b;
        long[] jArr = this.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            long j3 = -9187201950435737472L;
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                for (?? r14 = z6; r14 < i4; r14++) {
                    if ((255 & j2) < 128) {
                        int i5 = iArr[(i2 << 3) + r14];
                        int i6 = (-862048943) * i5;
                        int i7 = i6 ^ (i6 << 16);
                        z3 = z5;
                        int i8 = i7 & 127;
                        z4 = z6;
                        int i9 = nn2Var.c;
                        int i10 = (i7 >>> 7) & i9;
                        ?? r19 = z4;
                        while (true) {
                            long[] jArr2 = nn2Var.a;
                            int i11 = i10 >> 3;
                            j = j3;
                            int i12 = (i10 & 7) << 3;
                            long j4 = (jArr2[i11] >>> i12) | ((jArr2[i11 + 1] << (64 - i12)) & ((-i12) >> 63));
                            i = i3;
                            long j5 = j4 ^ (((long) i8) * 72340172838076673L);
                            long j6 = (~j5) & (j5 - 72340172838076673L) & j;
                            while (true) {
                                if (j6 == 0) {
                                    break;
                                }
                                iNumberOfTrailingZeros = (i10 + (Long.numberOfTrailingZeros(j6) >> 3)) & i9;
                                if (nn2Var.b[iNumberOfTrailingZeros] == i5) {
                                    break;
                                }
                                j6 &= j6 - 1;
                            }
                            int i13 = r19 + 8;
                            i10 = (i10 + i13) & i9;
                            i3 = i;
                            j3 = j;
                            r19 = i13;
                        }
                        if (!(iNumberOfTrailingZeros >= 0 ? z3 : z4)) {
                            return z4;
                        }
                    } else {
                        z3 = z5;
                        z4 = z6;
                        i = i3;
                        j = j3;
                    }
                    j2 >>= i;
                    i3 = i;
                    z5 = z3;
                    z6 = z4;
                    j3 = j;
                }
                z = z5;
                z2 = z6;
                if (i4 != i3) {
                    return z;
                }
            } else {
                z = z5;
                z2 = z6;
            }
            if (i2 == length) {
                return z;
            }
            i2++;
            z5 = z;
            z6 = z2;
        }
    }

    public final int hashCode() {
        int[] iArr = this.b;
        long[] jArr = this.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        i2 += iArr[(i << 3) + i4];
                    }
                    j >>= 8;
                }
                if (i3 != 8) {
                    return i2;
                }
            }
            if (i == length) {
                return i2;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[PHI: r5
      0x005b: PHI (r5v2 int) = (r5v1 int), (r5v3 int) binds: [B:6:0x0024, B:18:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "[");
        int[] iArr = this.b;
        long[] jArr = this.a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = iArr[(i << 3) + i4];
                            if (i2 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append((CharSequence) ", ");
                            }
                            sb.append(i5);
                            i2++;
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            sb.append((CharSequence) "]");
        } else {
            sb.append((CharSequence) "]");
        }
        return sb.toString();
    }

    public nn2() {
        this(6);
    }
}
