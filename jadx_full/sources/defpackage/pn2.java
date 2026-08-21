package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pn2 {
    public long[] a;
    public long[] b;
    public long[] c;
    public int d;
    public int e;

    public final void a() {
        this.e = 0;
        long[] jArr = this.a;
        if (jArr != bq3.a) {
            qe.k0(jArr);
            long[] jArr2 = this.a;
            int i = this.d;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i2] = (jArr2[i2] & (~j)) | j;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c1, code lost:
    
        r29 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00cf, code lost:
    
        if (((r12 & ((~r12) << 6)) & r25) == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d1, code lost:
    
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00dc, code lost:
    
        return r21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [int] */
    /* JADX WARN: Type inference failed for: r22v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        boolean z;
        long[] jArr;
        boolean z2;
        boolean z3;
        long[] jArr2;
        boolean z4;
        int i;
        long j;
        int iNumberOfTrailingZeros;
        boolean z5 = true;
        if (obj == this) {
            return true;
        }
        boolean z6 = false;
        if (!(obj instanceof pn2)) {
            return false;
        }
        pn2 pn2Var = (pn2) obj;
        if (pn2Var.e != this.e) {
            return false;
        }
        long[] jArr3 = this.b;
        long[] jArr4 = this.c;
        long[] jArr5 = this.a;
        int length = jArr5.length - 2;
        if (length < 0) {
            return true;
        }
        int i2 = 0;
        loop0: while (true) {
            long j2 = jArr5[i2];
            int i3 = 7;
            long j3 = -9187201950435737472L;
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i2 - length)) >>> 31);
                for (?? r15 = z6; r15 < i5; r15++) {
                    if ((j2 & 255) < 128) {
                        int i6 = (i2 << 3) + r15;
                        long j4 = jArr3[i6];
                        long j5 = jArr4[i6];
                        z3 = z5;
                        jArr2 = jArr3;
                        int i7 = ((int) (j4 ^ (j4 >>> 32))) * (-862048943);
                        int i8 = i7 ^ (i7 << 16);
                        int i9 = i8 & 127;
                        z4 = z6;
                        int i10 = pn2Var.d;
                        int i11 = (i8 >>> i3) & i10;
                        ?? r22 = z4;
                        while (true) {
                            long[] jArr6 = pn2Var.a;
                            int i12 = i11 >> 3;
                            j = j3;
                            int i13 = (i11 & 7) << 3;
                            long j6 = (jArr6[i12] >>> i13) | ((jArr6[i12 + 1] << (64 - i13)) & ((-i13) >> 63));
                            int i14 = i4;
                            long j7 = j6 ^ (((long) i9) * 72340172838076673L);
                            long j8 = (j7 - 72340172838076673L) & (~j7) & j;
                            while (true) {
                                if (j8 == 0) {
                                    break;
                                }
                                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j8) >> 3) + i11) & i10;
                                i = i14;
                                if (pn2Var.b[iNumberOfTrailingZeros] == j4) {
                                    break;
                                }
                                j8 &= j8 - 1;
                                i14 = i;
                            }
                            int i15 = r22 + 8;
                            i11 = (i11 + i15) & i10;
                            j3 = j;
                            i4 = i;
                            r22 = i15;
                        }
                        if (iNumberOfTrailingZeros < 0 || j5 != pn2Var.c[iNumberOfTrailingZeros]) {
                            break loop0;
                        }
                    } else {
                        z3 = z5;
                        jArr2 = jArr3;
                        z4 = z6;
                        i = i4;
                        j = j3;
                    }
                    j2 >>= i;
                    jArr3 = jArr2;
                    z5 = z3;
                    z6 = z4;
                    j3 = j;
                    i4 = i;
                    i3 = 7;
                }
                z = z5;
                jArr = jArr3;
                z2 = z6;
                if (i5 != i4) {
                    return z;
                }
            } else {
                z = z5;
                jArr = jArr3;
                z2 = z6;
            }
            if (i2 == length) {
                return z;
            }
            i2++;
            jArr3 = jArr;
            z5 = z;
            z6 = z2;
        }
    }

    public final int hashCode() {
        int i;
        int i2;
        long[] jArr = this.b;
        long[] jArr2 = this.c;
        long[] jArr3 = this.a;
        int length = jArr3.length - 2;
        if (length < 0) {
            return 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            long j = jArr3[i3];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i5) {
                    if ((255 & j) < 128) {
                        int i7 = (i3 << 3) + i6;
                        long j2 = jArr[i7];
                        long j3 = jArr2[i7];
                        i2 = i3;
                        i4 += ((int) (j3 ^ (j3 >>> 32))) ^ ((int) (j2 ^ (j2 >>> 32)));
                    } else {
                        i2 = i3;
                    }
                    j >>= 8;
                    i6++;
                    i3 = i2;
                }
                i = i3;
                if (i5 != 8) {
                    return i4;
                }
            } else {
                i = i3;
            }
            if (i == length) {
                return i4;
            }
            i3 = i + 1;
        }
    }

    public final String toString() {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.e == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        long[] jArr = this.b;
        long[] jArr2 = this.c;
        long[] jArr3 = this.a;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                long j = jArr3[i5];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8;
                    int i8 = 8 - ((~(i5 - length)) >>> 31);
                    int i9 = 0;
                    while (i9 < i8) {
                        if ((255 & j) < 128) {
                            int i10 = (i5 << 3) + i9;
                            i2 = i5;
                            long j2 = jArr[i10];
                            i3 = i7;
                            i4 = i9;
                            long j3 = jArr2[i10];
                            sb.append(j2);
                            sb.append("=");
                            sb.append(j3);
                            i6++;
                            if (i6 < this.e) {
                                sb.append(", ");
                            }
                        } else {
                            i2 = i5;
                            i3 = i7;
                            i4 = i9;
                        }
                        j >>= i3;
                        i9 = i4 + 1;
                        i5 = i2;
                        i7 = i3;
                    }
                    int i11 = i5;
                    if (i8 != i7) {
                        break;
                    }
                    i = i11;
                } else {
                    i = i5;
                }
                if (i == length) {
                    break;
                }
                i5 = i + 1;
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
