package defpackage;

import java.io.PrintStream;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class mh2 extends ue2 {
    public final th3 A;
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public int E0;
    public int F0;
    public byte[] G0;
    public final k0 X;
    public final byte[] Y;
    public final int Z;
    public final k70 y0;
    public int z0;

    static {
        new InterruptedException();
        new he4();
    }

    public mh2(th3 th3Var, k70 k70Var, byte[] bArr, int i) {
        this.A = th3Var;
        this.X = th3Var.p;
        this.Y = bArr;
        this.Z = i;
        this.y0 = k70Var;
    }

    public static void l(int i, int i2, int i3) {
        if (ja0.M) {
            PrintStream printStream = ja0.G;
            StringBuilder sbA = fw.A(i, i2, "onig_search (entry point): str: 0, end: ", ", start: ", ", range ");
            sbA.append(i3);
            printStream.println(sbA.toString());
        }
    }

    public static boolean o(int i, int i2, k0 k0Var, byte[] bArr) {
        return t.z0.j(k0Var.u(i, i2, bArr), 12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a7, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k(int i, int i2, int i3, int i4, byte[] bArr) {
        int iD;
        k0 k0Var;
        th3 th3Var = this.A;
        int i5 = i3 + th3Var.E;
        int iV = i2;
        while (true) {
            iD = th3Var.u.D(this, bArr, i5, i4, i, iV, i2, i5);
            if (iD != -1) {
                int i6 = th3Var.z;
                k0Var = this.X;
                if (i6 != 0) {
                    if (i6 == 2) {
                        if (iD == 0) {
                            break;
                        }
                        iV = k0Var.v(0, iD, i, bArr);
                        if (k0Var.m(iV, i, bArr)) {
                            break;
                        }
                    } else {
                        if (i6 != 32) {
                            break;
                        }
                        if (iD != i) {
                            if (k0Var.m(iD, i, bArr)) {
                                break;
                            }
                            int iV2 = k0Var.v(i4, iD, i, bArr);
                            if (iV2 == -1) {
                                break;
                            }
                            iV = iV2;
                        } else if (!ja0.j) {
                            int iV3 = k0Var.v(i4, iD, i, bArr);
                            if (iV3 != -1) {
                                if (!k0Var.m(iV3, i, bArr)) {
                                    break;
                                }
                                iV = iV3;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
            } else if (ja0.M) {
                ja0.G.println("backward_search_range: fail.");
            }
        }
        int i7 = th3Var.F;
        if (i7 != Integer.MAX_VALUE) {
            this.E0 = iD - i7;
            int i8 = iD - th3Var.E;
            this.F0 = i8;
            int iQ = k0Var.q(i4, i8, i, bArr);
            if (iQ < i8) {
                iQ += k0Var.r(iQ, i, bArr);
            }
            this.F0 = iQ;
        }
        boolean z = ja0.M;
        if (!z) {
            return true;
        }
        int i9 = this.E0;
        int i10 = this.F0;
        if (!z) {
            return true;
        }
        ja0.G.println("backward_search_range: low: " + i9 + ", high: " + i10);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m(int i, int i2, int i3, int i4) {
        th3 th3Var = this.A;
        int i5 = th3Var.x;
        if (i4 >= i5) {
            int i6 = th3Var.y;
            k0 k0Var = this.X;
            int i7 = this.Z;
            byte[] bArr = this.Y;
            if (i2 > i) {
                if (i3 - i > i6) {
                    int i8 = i3 - i6;
                    if (i8 < i7) {
                        i = k0Var.q(0, i8, i7, bArr);
                        if (i < i8) {
                            i = k0Var.r(i, i7, bArr) + i;
                        }
                    } else {
                        i = k0Var.v(0, i7, i7, bArr);
                    }
                }
                int i9 = i4 - (i2 - 1);
                int i10 = th3Var.x;
                if (i9 < i10) {
                    i2 = (i4 - i10) + 1;
                }
                if (i < i2) {
                    return false;
                }
            } else {
                if (i3 - i2 > i6) {
                    i2 = i3 - i6;
                }
                if (i4 - i < i5) {
                    i = k0Var.q(0, i4 - i5, i7, bArr);
                }
                if (i2 > i) {
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x0160, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean n(int i, int i2, int i3, mh2 mh2Var, byte[] bArr) {
        int iR;
        boolean z;
        int iQ;
        int iR2;
        boolean z2 = ja0.M;
        if (z2 && z2) {
            PrintStream printStream = ja0.G;
            StringBuilder sbA = fw.A(i, i2, "forward_search_range: str: 0, end: ", ", s: ", ", range: ");
            sbA.append(i3);
            printStream.println(sbA.toString());
        }
        th3 th3Var = this.A;
        int i4 = th3Var.E;
        k0 k0Var = this.X;
        if (i4 <= 0) {
            iR = i2;
        } else if (k0Var.z) {
            iR = i4 + i2;
        } else {
            int i5 = i4 + i2;
            iR = i2;
            while (iR < i5 && iR < i) {
                iR += k0Var.r(iR, i, bArr);
            }
        }
        int i6 = -1;
        while (true) {
            z = ja0.M;
            if (z) {
                String strD = th3Var.t.D();
                ja0.G.println(strD + ": text: " + iR + ", text_end: " + i + ", text_range: " + i3);
            }
            iQ = th3Var.t.Q(iR, i, i3, this, bArr);
            if (iQ == -1 || iQ >= i3) {
                break;
            }
            if (iQ - th3Var.E >= i2) {
                int i7 = th3Var.z;
                if (i7 != 0) {
                    if (i7 == 2) {
                        if (iQ != 0) {
                            if (k0Var.m(k0Var.v(i6 != -1 ? i6 : 0, iQ, i, bArr), i, bArr)) {
                                break;
                            }
                            iR2 = k0Var.r(iQ, i, bArr);
                        } else {
                            break;
                        }
                    } else {
                        if (i7 != 32) {
                            break;
                        }
                        if (iQ != i) {
                            if (k0Var.m(iQ, i, bArr)) {
                                break;
                            }
                            iR2 = k0Var.r(iQ, i, bArr);
                        } else {
                            if (ja0.j) {
                                break;
                            }
                            int iV = k0Var.v(i6 != -1 ? i6 : 0, iQ, i, bArr);
                            if (iV == -1 || !k0Var.m(iV, i, bArr)) {
                                break;
                            }
                            iR2 = k0Var.r(iQ, i, bArr);
                        }
                    }
                } else {
                    break;
                }
            } else {
                iR2 = k0Var.r(iQ, i, bArr);
            }
            iR = iR2 + iQ;
            i6 = iQ;
        }
        int i8 = th3Var.F;
        if (i8 == 0) {
            this.E0 = iQ;
            if (mh2Var != null) {
                if (iQ > i2) {
                    mh2Var.b = k0Var.v(i2, iQ, i, bArr);
                } else {
                    if (i6 == -1) {
                        i6 = 0;
                    }
                    mh2Var.b = k0Var.v(i6, iQ, i, bArr);
                }
            }
        } else if (i8 != Integer.MAX_VALUE) {
            int i9 = iQ - i8;
            this.E0 = i9;
            if (i9 > i2) {
                int iQ2 = k0Var.q(i2, i9, i, bArr);
                if (iQ2 < i9) {
                    if (mh2Var != null) {
                        mh2Var.b = iQ2;
                    }
                    iQ2 += k0Var.r(iQ2, i, bArr);
                } else if (mh2Var != null) {
                    mh2Var.b = -1;
                }
                this.E0 = iQ2;
                if (mh2Var != null && mh2Var.b == -1) {
                    if (i6 == -1) {
                        i6 = i2;
                    }
                    mh2Var.b = k0Var.v(i6, iQ2, i, bArr);
                }
            } else if (mh2Var != null) {
                if (i6 == -1) {
                    i6 = 0;
                }
                mh2Var.b = k0Var.v(i6, i9, i, bArr);
            }
        }
        int i10 = iQ - th3Var.E;
        this.F0 = i10;
        if (!z) {
            return true;
        }
        int i11 = this.E0;
        if (!z) {
            return true;
        }
        PrintStream printStream2 = ja0.G;
        StringBuilder sbA2 = fw.A(i11, i10, "forward_search_range success: low: ", ", high: ", ", dmin: ");
        sbA2.append(th3Var.E);
        sbA2.append(", dmax: ");
        sbA2.append(th3Var.F);
        printStream2.println(sbA2.toString());
        return true;
    }

    public abstract int p(int i, int i2, int i3);

    public final boolean q(int i, int i2, int i3) {
        boolean z = ja0.m;
        th3 th3Var = this.A;
        if (!z) {
            boolean z2 = ja0.q;
            int i4 = this.Z;
            if (z2) {
                return p(i4, i2, i3) != -1 && (th3Var.q & 16) == 0;
            }
            if (p(i4, i2, i3) == -1) {
                return false;
            }
        } else {
            if (ja0.q) {
                return p(i, i2, i3) != -1 && (th3Var.q & 16) == 0;
            }
            if (p(i, i2, i3) == -1) {
                return false;
            }
        }
        return true;
    }

    public final int r() {
        if (!ja0.q || this.z0 < 0) {
            return -1;
        }
        return this.A0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r18 < r20) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        r4 = r18 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        if (r2 != 0) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        if (m(r2, r20, r7, r7) != false) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0083, code lost:
    
        if (r18 < r20) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int s(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        byte[] bArr;
        int i9;
        int i10;
        byte[] bArr2;
        int iR = i2;
        boolean z = ja0.M;
        int i11 = this.Z;
        if (z) {
            l(i11, iR, i3);
        }
        if (iR <= i11 && iR >= 0) {
            th3 th3Var = this.A;
            int i12 = th3Var.w;
            byte[] bArr3 = this.Y;
            k0 k0Var = this.X;
            if (i12 == 0 || i11 <= 0) {
                if (i11 == 0) {
                    if (z) {
                        ja0.G.println("onig_search: empty string.");
                    }
                    if (th3Var.v == 0) {
                        this.B0 = 0;
                        if (ja0.q) {
                            this.z0 = -1;
                        }
                        if (ja0.s) {
                            ((st) this).M0 = null;
                        }
                        if (q(i11, 0, -1)) {
                            return 0;
                        }
                        return r();
                    }
                }
                i4 = iR;
                i5 = i3;
            } else {
                if ((i12 & 4) != 0) {
                    if (i3 > iR) {
                        if (i > iR) {
                        }
                        int i13 = iR + 1;
                        i5 = i13;
                    }
                    i4 = iR;
                    i5 = i4;
                } else {
                    i5 = 1;
                    if ((i12 & 1) != 0) {
                        if (i3 <= iR) {
                            if (i3 <= 0) {
                                i4 = iR;
                                iR = 0;
                                i5 = 0;
                            }
                        }
                    } else if ((i12 & 8) == 0) {
                        if ((i12 & 16) != 0) {
                            int iY = k0Var.y(i11, i11, 1, bArr3);
                            if (!k0Var.m(iY, i11, bArr3)) {
                            }
                        } else if ((i12 & 32768) != 0) {
                            if (i3 > iR) {
                                if (i > iR) {
                                }
                                int i132 = iR + 1;
                                i5 = i132;
                            }
                            i4 = iR;
                            i5 = i4;
                        }
                        i4 = iR;
                        i5 = i3;
                    }
                }
                i4 = iR;
            }
            if (z) {
                l(i11, iR, i5);
            }
            this.B0 = i;
            if (ja0.q) {
                this.z0 = -1;
            }
            if (ja0.s) {
                int iMin = Math.min(iR, i5);
                int i14 = th3Var.g;
                st stVar = (st) this;
                if (i14 <= 0 || i11 < ja0.E) {
                    stVar.M0 = null;
                } else {
                    int i15 = (((i11 + 1) * i14) + 7) >>> 3;
                    int i16 = (iMin * i14) >>> 3;
                    if (i15 <= 0 || i16 >= i15 || i15 >= ja0.F) {
                        stVar.M0 = null;
                    } else {
                        if (i15 >= 16) {
                            bArr2 = new byte[i15];
                            stVar.M0 = bArr2;
                        } else {
                            bArr2 = new byte[i15];
                            stVar.M0 = bArr2;
                        }
                        Arrays.fill(bArr2, i16, i15 - i16, (byte) 0);
                    }
                }
            }
            if (i5 > iR) {
                int iV = iR > 0 ? k0Var.v(0, iR, i11, bArr3) : 0;
                if (th3Var.t != null) {
                    int i17 = th3Var.F;
                    if (i17 == 0) {
                        i10 = i5;
                    } else if (i17 == Integer.MAX_VALUE || (i10 = i5 + i17) > i11) {
                        i10 = i11;
                    }
                    int i18 = this.Z;
                    if (i18 - iR < th3Var.v) {
                        return r();
                    }
                    if (i17 != Integer.MAX_VALUE) {
                        while (true) {
                            int i19 = i10;
                            byte[] bArr4 = bArr3;
                            if (!n(this.Z, iR, i19, this, bArr4)) {
                                return r();
                            }
                            int i20 = this.E0;
                            if (iR < i20) {
                                iV = this.b;
                                iR = i20;
                            }
                            while (iR <= this.F0) {
                                if (q(i3, iR, iV)) {
                                    return iR;
                                }
                                iV = iR;
                                iR = k0Var.r(iR, i11, bArr4) + iR;
                            }
                            if (iR >= i5) {
                                return r();
                            }
                            bArr3 = bArr4;
                            i10 = i19;
                        }
                    } else {
                        bArr = bArr3;
                        i9 = iR;
                        if (!n(i18, iR, i10, null, bArr)) {
                            return r();
                        }
                        if ((th3Var.w & 16384) != 0) {
                            int i21 = i9;
                            while (!q(i3, i21, iV)) {
                                int iR2 = k0Var.r(i21, i11, bArr) + i21;
                                if ((th3Var.w & 6144) == 0) {
                                    while (!k0Var.m(i21, i11, bArr) && iR2 < i5) {
                                        i21 = iR2;
                                        iR2 = k0Var.r(iR2, i11, bArr) + iR2;
                                    }
                                }
                                iV = i21;
                                i21 = iR2;
                                if (i21 >= i5) {
                                    return r();
                                }
                            }
                            return i21;
                        }
                    }
                } else {
                    bArr = bArr3;
                    i9 = iR;
                }
                int i22 = i9;
                while (!q(i3, i22, iV)) {
                    int iR3 = k0Var.r(i22, i11, bArr) + i22;
                    if (iR3 < i5) {
                        iV = i22;
                        i22 = iR3;
                    } else if (iR3 == i5 && q(i3, iR3, i22)) {
                        return iR3;
                    }
                }
                return i22;
            }
            int i23 = iR;
            int iR4 = (!ja0.m || i4 >= i11) ? i4 : k0Var.r(i4, i11, bArr3) + i4;
            if (th3Var.u != null) {
                int iQ = i5 < i11 ? k0Var.q(0, i5, i11, bArr3) : i11;
                int i24 = th3Var.F;
                if (i24 == Integer.MAX_VALUE || i11 - i5 < th3Var.v) {
                    i6 = i5;
                    if (i11 - i6 < th3Var.v) {
                        return r();
                    }
                    if (!k(this.Z, i24 != 0 ? (i24 != Integer.MAX_VALUE && (i7 = i24 + i23) <= i11) ? k0Var.q(i23, i7, i11, bArr3) : i11 : i23, i6, iQ, bArr3)) {
                        return r();
                    }
                } else {
                    while (true) {
                        int i25 = th3Var.F + i23;
                        int i26 = this.Z;
                        if (i25 > i26) {
                            i8 = i26;
                        } else {
                            i26 = i25;
                            i8 = i26;
                        }
                        int i27 = i5;
                        if (!k(i8, i26, i27, iQ, bArr3)) {
                            return r();
                        }
                        int i28 = this.F0;
                        if (i23 > i28) {
                            i23 = i28;
                        }
                        while (i23 != -1 && i23 >= this.E0) {
                            int iV2 = k0Var.v(0, i23, i11, bArr3);
                            if (q(iR4, i23, iV2)) {
                                return i23;
                            }
                            i23 = iV2;
                        }
                        if (i23 < i27) {
                            return r();
                        }
                        i5 = i27;
                    }
                }
            } else {
                i6 = i5;
            }
            int i29 = i23;
            while (true) {
                int iV3 = k0Var.v(0, i29, i11, bArr3);
                if (q(iR4, i29, iV3)) {
                    return i29;
                }
                if (iV3 < i6) {
                    break;
                }
                i29 = iV3;
            }
            return r();
        }
        return -1;
    }
}
