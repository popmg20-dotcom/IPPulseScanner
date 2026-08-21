package defpackage;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final byte[] a;
    public static final long[] b;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(y30.a);
        bytes.getClass();
        a = bytes;
        b = new long[]{-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, Long.MAX_VALUE};
    }

    public static final boolean a(rr3 rr3Var, int i, byte[] bArr, int i2, int i3) {
        int i4 = rr3Var.c;
        byte[] bArr2 = rr3Var.a;
        while (i2 < i3) {
            if (i == i4) {
                rr3Var = rr3Var.f;
                rr3Var.getClass();
                byte[] bArr3 = rr3Var.a;
                bArr2 = bArr3;
                i = rr3Var.b;
                i4 = rr3Var.c;
            }
            if (bArr2[i] != bArr[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static final String b(hp hpVar, long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (hpVar.C(j2) == 13) {
                String strR0 = hpVar.r0(j2, y30.a);
                hpVar.z0(2L);
                return strR0;
            }
        }
        String strR02 = hpVar.r0(j, y30.a);
        hpVar.z0(1L);
        return strR02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
    
        if (r18 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0079, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int c(hp hpVar, qw2 qw2Var, boolean z) {
        int i;
        int i2;
        int i3;
        rr3 rr3Var;
        int i4;
        rr3 rr3Var2 = hpVar.b;
        if (rr3Var2 != null) {
            byte[] bArr = rr3Var2.a;
            int i5 = rr3Var2.b;
            int i6 = rr3Var2.c;
            int[] iArr = qw2Var.f;
            rr3 rr3Var3 = rr3Var2;
            int i7 = -1;
            int i8 = 0;
            loop0: while (true) {
                int i9 = i8 + 1;
                int i10 = iArr[i8];
                int i11 = i8 + 2;
                int i12 = iArr[i9];
                if (i12 != -1) {
                    i7 = i12;
                }
                if (rr3Var3 == null) {
                    break;
                }
                if (i10 >= 0) {
                    int i13 = i5 + 1;
                    int i14 = bArr[i5] & 255;
                    int i15 = i11 + i10;
                    while (i11 != i15) {
                        if (i14 == iArr[i11]) {
                            i = iArr[i11 + i10];
                            if (i13 == i6) {
                                rr3Var3 = rr3Var3.f;
                                rr3Var3.getClass();
                                int i16 = rr3Var3.b;
                                byte[] bArr2 = rr3Var3.a;
                                i2 = rr3Var3.c;
                                if (rr3Var3 == rr3Var2) {
                                    i3 = i16;
                                    bArr = bArr2;
                                    rr3Var3 = null;
                                } else {
                                    i3 = i16;
                                    bArr = bArr2;
                                }
                            } else {
                                i2 = i6;
                                i3 = i13;
                            }
                            if (i >= 0) {
                                return i;
                            }
                            int i17 = i2;
                            i8 = -i;
                            i5 = i3;
                            i6 = i17;
                        } else {
                            i11++;
                        }
                    }
                    break loop0;
                }
                int i18 = (i10 * (-1)) + i11;
                while (true) {
                    int i19 = i5 + 1;
                    int i20 = i11 + 1;
                    if ((bArr[i5] & 255) != iArr[i11]) {
                        break loop0;
                    }
                    boolean z2 = i20 == i18;
                    if (i19 == i6) {
                        rr3Var3.getClass();
                        rr3 rr3Var4 = rr3Var3.f;
                        rr3Var4.getClass();
                        i3 = rr3Var4.b;
                        byte[] bArr3 = rr3Var4.a;
                        i4 = rr3Var4.c;
                        if (rr3Var4 != rr3Var2) {
                            rr3Var = rr3Var4;
                            bArr = bArr3;
                        } else {
                            if (!z2) {
                                break loop0;
                            }
                            bArr = bArr3;
                            rr3Var = null;
                        }
                    } else {
                        rr3Var = rr3Var3;
                        i4 = i6;
                        i3 = i19;
                    }
                    if (z2) {
                        i = iArr[i20];
                        int i21 = i4;
                        rr3Var3 = rr3Var;
                        i2 = i21;
                        break;
                    }
                    i5 = i3;
                    i6 = i4;
                    rr3Var3 = rr3Var;
                    i11 = i20;
                }
            }
        } else {
            return z ? -2 : -1;
        }
    }
}
