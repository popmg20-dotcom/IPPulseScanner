package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import java.io.PrintStream;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class st extends mh2 {
    public static final ThreadLocal a1 = new ThreadLocal();
    public l14[] H0;
    public int I0;
    public final int[] J0;
    public final int K0;
    public final int L0;
    public byte[] M0;
    public int N0;
    public int O0;
    public int P0;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public int U0;
    public final int[] V0;
    public int W0;
    public int X0;
    public byte[] Y0;
    public byte[] Z0;

    public st(th3 th3Var, k70 k70Var, byte[] bArr, int i) {
        l14[] l14VarArr;
        int i2;
        super(th3Var, k70Var, bArr, i);
        if (th3Var.c) {
            ThreadLocal threadLocal = a1;
            WeakReference weakReference = (WeakReference) threadLocal.get();
            if (weakReference == null) {
                l14VarArr = new l14[ja0.A];
                l14VarArr[0] = ja0.s ? new bo3() : new l14();
                threadLocal.set(new WeakReference(l14VarArr));
            } else {
                l14VarArr = (l14[]) weakReference.get();
                if (l14VarArr == null) {
                    l14VarArr = new l14[ja0.A];
                    l14VarArr[0] = ja0.s ? new bo3() : new l14();
                    threadLocal.set(new WeakReference(l14VarArr));
                }
            }
        } else {
            l14VarArr = null;
        }
        this.H0 = l14VarArr;
        boolean z = ja0.f;
        int i3 = th3Var.e;
        int i4 = th3Var.d;
        if (z) {
            i2 = ((i4 + 1) << 1) + i3;
            this.K0 = i3;
            this.L0 = i3 + i4 + 1;
        } else {
            i2 = (i4 << 1) + i3;
            int i5 = i3 - 1;
            this.K0 = i5;
            this.L0 = i5 + i4;
        }
        this.J0 = i2 > 0 ? new int[i2] : null;
        this.N0 = 256;
        this.P0 = 0;
        this.V0 = th3Var.a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
    
        r16.R0 = r16.P0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x016a, code lost:
    
        throw new defpackage.l12("undefined bytecode (bug)");
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A() {
        /*
            Method dump skipped, instruction units count: 1806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.st.A():int");
    }

    public final void A0() {
        int i = this.I0;
        int i2 = 0;
        while (true) {
            i--;
            l14 l14Var = this.H0[i];
            int i3 = l14Var.a;
            if (i3 == 2048) {
                if (i2 == 0) {
                    this.W0 = l14Var.b;
                    z().a = 2304;
                    this.I0++;
                    return;
                }
                i2--;
            } else if (i3 == 2304) {
                i2++;
            }
        }
    }

    public final int B(int i) {
        int i2 = this.I0;
        int i3 = 0;
        while (i2 > 0) {
            i2--;
            l14 l14Var = this.H0[i2];
            int i4 = l14Var.a;
            if ((32768 & i4) != 0 && l14Var.b == i) {
                i3++;
            } else if (i4 == 256 && l14Var.b == i) {
                if (i3 == 0) {
                    return i2;
                }
                i3--;
            }
        }
        return i2;
    }

    public final void B0() {
        boolean zO = je.O(0);
        int i = this.P0;
        byte[] bArr = this.Y;
        k0 k0Var = this.X;
        int i2 = this.Z;
        if (i != i2) {
            if (k0Var.m(i, i2, bArr)) {
                int i3 = this.P0;
                if (k0Var.r(i3, i2, bArr) + i3 == i2) {
                    return;
                }
            }
            k0();
            return;
        }
        if (!ja0.j) {
            if (zO) {
                k0();
            }
        } else if ((i2 == 0 || !k0Var.m(this.R0, i2, bArr)) && zO) {
            k0();
        }
    }

    public final int C(int i) {
        int i2 = this.I0;
        int i3 = 0;
        while (true) {
            i2--;
            l14 l14Var = this.H0[i2];
            int i4 = l14Var.a;
            if (i4 == 1792) {
                if (i3 == 0 && l14Var.d == i) {
                    return i2;
                }
            } else if (i4 == 2048) {
                i3--;
            } else if (i4 == 2304) {
                i3++;
            }
        }
    }

    public final void C0() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        if (O0(this.P0, i2)) {
            k0();
            return;
        }
        int i3 = this.P0;
        if (this.M0 != null) {
            l14 l14VarZ = z();
            l14VarZ.a = 4096;
            l14VarZ.c = i3;
            ((bo3) l14VarZ).f = i2;
            this.I0++;
        }
    }

    public final void D() {
        this.N0 = Math.min(this.N0 << 1, 32768);
    }

    public final void D0() {
        int i = this.W0;
        this.W0 = i + 1;
        int[] iArr = this.V0;
        int i2 = iArr[i];
        if (O0(this.P0, i2)) {
            k0();
            return;
        }
        int i3 = this.W0;
        int i4 = i3 + 1;
        this.W0 = i4;
        I0(i4 + iArr[i3], this.P0, this.R0, i2, this.U0);
    }

    public final boolean E() {
        int i = this.Y[this.P0] & 255;
        return (this.V0[this.W0 + (i >>> dn.b)] & (1 << i)) != 0;
    }

    public final void E0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        this.W0 = i + 2;
        int i4 = iArr[i2];
        boolean zO0 = O0(this.P0, i3);
        int i5 = this.W0;
        if (zO0) {
            this.W0 = i5 + i4;
        } else {
            I0(i5 + i4, this.P0, this.R0, i3, this.U0);
        }
    }

    public final boolean F() {
        int i = this.W0;
        this.W0 = i + 1;
        int[] iArr = this.V0;
        int i2 = iArr[i];
        int i3 = this.P0;
        if (i3 >= this.Q0) {
            return false;
        }
        int i4 = this.Z;
        k0 k0Var = this.X;
        byte[] bArr = this.Y;
        int iR = k0Var.r(i3, i4, bArr);
        int i5 = this.P0;
        int i6 = iR + i5;
        if (i6 > this.Q0) {
            return false;
        }
        this.P0 = i6;
        if (!r25.I(this.W0, k0Var.u(i5, i6, bArr), iArr)) {
            return false;
        }
        this.W0 += i2;
        return true;
    }

    public final l14 F0() {
        int i = this.A.l;
        if (i == 0) {
            while (true) {
                l14[] l14VarArr = this.H0;
                int i2 = this.I0 - 1;
                this.I0 = i2;
                l14 l14Var = l14VarArr[i2];
                int i3 = l14Var.a;
                if ((i3 & DnsRecord.CLASS_ANY) != 0) {
                    return l14Var;
                }
                if (ja0.s && i3 == 4096) {
                    N0();
                }
            }
        } else if (i != 1) {
            while (true) {
                l14[] l14VarArr2 = this.H0;
                int i4 = this.I0 - 1;
                this.I0 = i4;
                l14 l14Var2 = l14VarArr2[i4];
                if ((l14Var2.a & DnsRecord.CLASS_ANY) != 0) {
                    return l14Var2;
                }
                G0(l14Var2);
            }
        } else {
            while (true) {
                l14[] l14VarArr3 = this.H0;
                int i5 = this.I0 - 1;
                this.I0 = i5;
                l14 l14Var3 = l14VarArr3[i5];
                int i6 = l14Var3.a;
                if ((i6 & DnsRecord.CLASS_ANY) != 0) {
                    return l14Var3;
                }
                if (i6 == 256) {
                    int i7 = l14Var3.b;
                    int i8 = this.K0 + i7;
                    int i9 = l14Var3.d;
                    int[] iArr = this.J0;
                    iArr[i8] = i9;
                    iArr[this.L0 + i7] = l14Var3.e;
                } else if (ja0.s && i6 == 4096) {
                    N0();
                }
            }
        }
    }

    public final boolean G() {
        int i = this.W0;
        this.W0 = i + 1;
        int[] iArr = this.V0;
        int i2 = iArr[i];
        int i3 = this.P0;
        k0 k0Var = this.X;
        int i4 = this.Z;
        byte[] bArr = this.Y;
        int iR = k0Var.r(i3, i4, bArr);
        int i5 = this.P0;
        int i6 = iR + i5;
        int i7 = this.Q0;
        if (i6 > i7) {
            if (i5 >= i7) {
                return false;
            }
            this.P0 = i4;
            this.W0 += i2;
            return true;
        }
        this.P0 = i6;
        if (r25.I(this.W0, k0Var.u(i5, i6, bArr), iArr)) {
            return false;
        }
        this.W0 += i2;
        return true;
    }

    public final void G0(l14 l14Var) {
        int i = l14Var.a;
        int i2 = this.L0;
        int i3 = this.K0;
        int[] iArr = this.J0;
        if (i == 256) {
            int i4 = l14Var.b;
            iArr[i3 + i4] = l14Var.d;
            iArr[i2 + i4] = l14Var.e;
        } else if (i == 768) {
            l14 l14Var2 = this.H0[l14Var.b];
            l14Var2.b--;
        } else if (i == 33280) {
            int i5 = l14Var.b;
            iArr[i3 + i5] = l14Var.d;
            iArr[i2 + i5] = l14Var.e;
        } else if (ja0.s && i == 4096) {
            N0();
        }
    }

    public final boolean H(tt ttVar) {
        int i = this.X0;
        while (i < this.I0) {
            l14 l14Var = this.H0[i];
            int i2 = l14Var.a;
            if (i2 == 256) {
                int i3 = l14Var.b;
                if (i3 <= ja0.D && ez4.d(this.A.i, i3)) {
                    tt ttVar2 = new tt(1);
                    ttVar2.b = i3;
                    ttVar.a(ttVar2);
                    this.X0 = i + 1;
                    if (H(ttVar2)) {
                        break;
                    }
                    i = this.X0;
                }
            } else if (i2 == 33280 && l14Var.b == ttVar.b) {
                this.X0 = i;
                return false;
            }
        }
        return true;
    }

    public final void H0(int i, int i2, int i3, int i4, int i5) {
        l14 l14VarZ = z();
        l14VarZ.a = i;
        l14VarZ.b = i2;
        l14VarZ.c = i3;
        l14VarZ.d = i4;
        if (ja0.s) {
            ((bo3) l14VarZ).f = 0;
        }
        l14VarZ.e = i5;
        this.I0++;
    }

    public final void I() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        if (i2 == 61 || i2 == 62) {
            this.W0 = i + 2;
            return;
        }
        switch (i2) {
            case 68:
            case 69:
            case 70:
            case 71:
                this.W0 = i + 2;
                return;
            default:
                throw new l12("unexpected bytecode (bug)");
        }
    }

    public final void I0(int i, int i2, int i3, int i4, int i5) {
        l14 l14VarZ = z();
        l14VarZ.a = 1;
        l14VarZ.b = i;
        l14VarZ.c = i2;
        l14VarZ.d = i3;
        if (ja0.s) {
            bo3 bo3Var = (bo3) l14VarZ;
            if (this.M0 == null) {
                i4 = 0;
            }
            bo3Var.f = i4;
        }
        l14VarZ.e = i5;
        this.I0++;
    }

    public final void J() {
        int i = this.Q0;
        int i2 = this.W0;
        int i3 = i2 - 1;
        l14[] l14VarArr = this.H0;
        int i4 = this.I0 - 1;
        this.I0 = i4;
        l14 l14Var = l14VarArr[i4];
        int i5 = l14Var.b;
        this.Q0 = l14Var.c;
        this.W0 = i2 + 1;
        int i6 = this.V0[i2];
        boolean z = ja0.N;
        int i7 = this.Z;
        if (z) {
            System.out.println("ABSENT: s:" + this.P0 + " end:" + i7 + " absent:" + i5 + " aend:" + i);
        }
        if (i5 > i && this.P0 > i5) {
            F0();
            k0();
            return;
        }
        int i8 = this.P0;
        if (i8 >= i && i8 > i5) {
            if (i8 > i || i8 > i7) {
                k0();
                return;
            } else {
                this.W0 += i6;
                return;
            }
        }
        H0(1, this.W0 + i6, i8, this.R0, this.U0);
        int i9 = this.P0;
        int iR = i9 >= i7 ? 1 : this.X.r(i9, i7, this.Y);
        int i10 = this.Q0;
        l14 l14VarZ = z();
        l14VarZ.a = 2816;
        l14VarZ.b = i5;
        l14VarZ.c = i10;
        this.I0++;
        int i11 = this.P0;
        H0(1, i3, i11 + iR, i11, this.U0);
        z().a = 3072;
        this.I0++;
        this.Q0 = i;
    }

    public final void J0(int i, int i2) {
        l14 l14VarZ = z();
        l14VarZ.a = 33280;
        l14VarZ.b = i;
        l14VarZ.c = i2;
        int i3 = this.K0 + i;
        int[] iArr = this.J0;
        l14VarZ.d = iArr[i3];
        int i4 = this.L0;
        l14VarZ.e = iArr[i4 + i];
        int i5 = i4 + i;
        int i6 = this.I0;
        iArr[i5] = i6;
        this.I0 = i6 + 1;
    }

    public final void K() {
        int i = this.R0;
        if (i < this.Q0) {
            this.Q0 = i;
        }
        if (ja0.N) {
            System.out.println("ABSENT_END: end:" + this.Q0);
        }
        while (true) {
            l14[] l14VarArr = this.H0;
            int i2 = this.I0 - 1;
            this.I0 = i2;
            l14 l14Var = l14VarArr[i2];
            if (l14Var.a == 3072) {
                k0();
                return;
            }
            G0(l14Var);
        }
    }

    public final void K0(int i) {
        l14 l14VarZ = z();
        l14VarZ.a = 768;
        l14VarZ.b = i;
        this.I0++;
    }

    public final void L() {
        int i = this.P0;
        if (i < this.Q0) {
            int i2 = this.Z;
            k0 k0Var = this.X;
            byte[] bArr = this.Y;
            if (mh2.o(i, i2, k0Var, bArr)) {
                int i3 = this.P0;
                this.P0 = k0Var.r(i3, i2, bArr) + i3;
                this.R0 = this.T0;
                return;
            }
        }
        k0();
    }

    public final void L0(int i, int i2) {
        st stVar;
        l14 l14Var = this.H0[i2];
        int i3 = l14Var.b + 1;
        l14Var.b = i3;
        th3 th3Var = this.A;
        if (i3 >= th3Var.n[i]) {
            stVar = this;
        } else if (i3 >= th3Var.m[i]) {
            stVar = this;
            stVar.H0(1, this.W0, this.P0, this.R0, this.U0);
            stVar.W0 = l14Var.c;
        } else {
            stVar = this;
            stVar.W0 = l14Var.c;
        }
        stVar.K0(i2);
    }

    public final void M() {
        int i = this.P0;
        if (i < this.Q0) {
            int i2 = this.Z;
            k0 k0Var = this.X;
            byte[] bArr = this.Y;
            if (mh2.o(i, i2, k0Var, bArr) && (this.P0 == 0 || !mh2.o(this.R0, i2, k0Var, bArr))) {
                return;
            }
        }
        k0();
    }

    public final void M0(int i, int i2) {
        l14 l14Var = this.H0[i2];
        int i3 = l14Var.b + 1;
        l14Var.b = i3;
        th3 th3Var = this.A;
        int i4 = th3Var.n[i];
        if (i3 >= i4) {
            if (i3 == i4) {
                K0(i2);
                return;
            }
            return;
        }
        int i5 = th3Var.m[i];
        int i6 = l14Var.c;
        if (i3 >= i5) {
            K0(i2);
            H0(1, i6, this.P0, this.R0, this.U0);
        } else {
            this.W0 = i6;
            K0(i2);
        }
    }

    public final void N() {
        int i = this.P0;
        int i2 = this.Z;
        byte[] bArr = this.Y;
        k0 k0Var = this.X;
        if (i == 0) {
            if (i >= this.Q0 || !mh2.o(i, i2, k0Var, bArr)) {
                k0();
                return;
            }
            return;
        }
        if (i != i2) {
            if (mh2.o(i, i2, k0Var, bArr) == mh2.o(this.R0, i2, k0Var, bArr)) {
                k0();
            }
        } else {
            int i3 = this.R0;
            if (i3 >= i2 || !mh2.o(i3, i2, k0Var, bArr)) {
                k0();
            }
        }
    }

    public final void N0() {
        l14 l14Var = this.H0[this.I0];
        int i = l14Var.c;
        int i2 = (((bo3) l14Var).f - 1) + (i * this.A.g);
        byte[] bArr = this.M0;
        int i3 = i2 / 8;
        bArr[i3] = (byte) ((1 << (i2 % 8)) | bArr[i3]);
    }

    public final void O() {
        int i;
        if (this.P0 != 0) {
            int i2 = this.R0;
            int i3 = this.Z;
            k0 k0Var = this.X;
            byte[] bArr = this.Y;
            if (mh2.o(i2, i3, k0Var, bArr) && ((i = this.P0) == i3 || !mh2.o(i, i3, k0Var, bArr))) {
                return;
            }
        }
        k0();
    }

    public final boolean O0(int i, int i2) {
        byte[] bArr = this.M0;
        if (bArr == null) {
            return false;
        }
        int i3 = (i2 - 1) + (i * this.A.g);
        return (bArr[i3 / 8] & (1 << (i3 % 8))) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        if (Q0(r8, r2, r18, r4, r5) == false) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P() {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.st.P():void");
    }

    public final void P0() {
        int i = this.I0;
        while (true) {
            i--;
            l14 l14Var = this.H0[i];
            int i2 = l14Var.a;
            if ((i2 & 4351) != 0) {
                l14Var.a = 2560;
            } else if (i2 == 1536) {
                l14Var.a = 2560;
                return;
            }
        }
    }

    public final void Q() {
        int i = this.W0;
        this.W0 = i + 1;
        int[] iArr = this.V0;
        int i2 = iArr[i];
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int i4 = this.W0;
            this.W0 = i4 + 1;
            int i5 = iArr[i4];
            if (!v(i5)) {
                int iW = w(i5);
                int iU = u(i5) - iW;
                int i6 = this.P0;
                if (i6 + iU > this.Q0) {
                    continue;
                } else {
                    this.R0 = i6;
                    while (true) {
                        int i7 = iU - 1;
                        byte[] bArr = this.Y;
                        if (iU > 0) {
                            int i8 = iW + 1;
                            int i9 = i6 + 1;
                            if (bArr[iW] != bArr[i6]) {
                                break;
                            }
                            iW = i8;
                            iU = i7;
                            i6 = i9;
                        } else {
                            this.P0 = i6;
                            if (this.R0 < this.Q0) {
                                while (true) {
                                    int i10 = this.R0;
                                    int iR = this.X.r(i10, this.Z, bArr);
                                    if (i10 + iR >= this.P0) {
                                        break;
                                    } else {
                                        this.R0 += iR;
                                    }
                                }
                            }
                            this.W0 = ((i2 - i3) - 1) + this.W0;
                        }
                    }
                }
            }
            i3++;
        }
        if (i3 == i2) {
            k0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        r10 = r3;
        r9 = r5;
        r14 = r6;
        r0 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Q0(int r10, int r11, defpackage.st r12, int r13, int r14) {
        /*
            r9 = this;
            byte[] r0 = r9.Y0
            r1 = 18
            if (r0 != 0) goto La
            byte[] r0 = new byte[r1]
            r9.Y0 = r0
        La:
            r7 = r0
            byte[] r0 = r9.Z0
            if (r0 != 0) goto L13
            byte[] r0 = new byte[r1]
            r9.Z0 = r0
        L13:
            int r1 = r12.b
            int r13 = r13 + r11
        L16:
            if (r11 >= r13) goto L53
            r9.b = r11
            k0 r2 = r9.X
            byte[] r3 = r9.Y
            r5 = r9
            r6 = r14
            r4 = r3
            r3 = r10
            int r9 = r2.t(r3, r4, r5, r6, r7)
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            int r11 = r4.b
            r4.b = r1
            k0 r1 = r4.X
            r6 = r0
            int r10 = r1.t(r2, r3, r4, r5, r6)
            int r1 = r4.b
            r14 = 0
            if (r9 == r10) goto L3b
            goto L47
        L3b:
            r10 = r14
            r0 = r10
        L3d:
            int r3 = r9 + (-1)
            if (r9 <= 0) goto L4e
            r9 = r7[r10]
            r8 = r6[r0]
            if (r9 == r8) goto L48
        L47:
            return r14
        L48:
            int r10 = r10 + 1
            int r0 = r0 + 1
            r9 = r3
            goto L3d
        L4e:
            r10 = r2
            r9 = r4
            r14 = r5
            r0 = r6
            goto L16
        L53:
            r12.b = r1
            r9 = 1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.st.Q0(int, int, st, int, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R() {
        /*
            r11 = this;
            int r0 = r11.W0
            int r1 = r0 + 1
            r11.W0 = r1
            int[] r1 = r11.V0
            r0 = r1[r0]
            r2 = 0
        Lb:
            if (r2 >= r0) goto L71
            int r3 = r11.W0
            int r4 = r3 + 1
            r11.W0 = r4
            r3 = r1[r3]
            boolean r4 = r11.v(r3)
            if (r4 == 0) goto L1d
        L1b:
            r5 = r11
            goto L42
        L1d:
            int r7 = r11.w(r3)
            int r3 = r11.u(r3)
            int r9 = r3 - r7
            int r3 = r11.P0
            int r4 = r3 + r9
            int r5 = r11.Q0
            if (r4 <= r5) goto L30
            goto L1b
        L30:
            r11.R0 = r3
            r11.b = r3
            th3 r3 = r11.A
            int r6 = r3.r
            int r10 = r11.Z
            r8 = r11
            r5 = r11
            boolean r11 = r5.Q0(r6, r7, r8, r9, r10)
            if (r11 != 0) goto L46
        L42:
            int r2 = r2 + 1
            r11 = r5
            goto Lb
        L46:
            int r11 = r5.b
            r5.P0 = r11
            int r11 = r5.R0
            int r1 = r5.Q0
            if (r11 >= r1) goto L67
        L50:
            int r11 = r5.R0
            byte[] r1 = r5.Y
            int r3 = r5.Z
            k0 r4 = r5.X
            int r1 = r4.r(r11, r3, r1)
            int r11 = r11 + r1
            int r3 = r5.P0
            if (r11 >= r3) goto L67
            int r11 = r5.R0
            int r11 = r11 + r1
            r5.R0 = r11
            goto L50
        L67:
            int r11 = r5.W0
            int r1 = r0 - r2
            int r1 = r1 + (-1)
            int r1 = r1 + r11
            r5.W0 = r1
            goto L72
        L71:
            r5 = r11
        L72:
            if (r2 != r0) goto L77
            r5.k0()
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.st.R():void");
    }

    public final void S() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        th3 th3Var = this.A;
        if (i2 > th3Var.d || v(i2)) {
            k0();
            return;
        }
        int iW = w(i2);
        int iU = u(i2) - iW;
        int i3 = this.P0;
        if (i3 + iU > this.Q0) {
            k0();
            return;
        }
        this.R0 = i3;
        this.b = i3;
        if (!Q0(th3Var.r, iW, this, iU, this.Z)) {
            k0();
            return;
        }
        this.P0 = this.b;
        if (this.R0 >= this.Q0) {
            return;
        }
        while (true) {
            int i4 = this.R0;
            int iR = this.X.r(i4, this.Z, this.Y);
            if (i4 + iR >= this.P0) {
                return;
            } else {
                this.R0 += iR;
            }
        }
    }

    public final void T() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int i3 = this.V0[i];
        l14 l14VarZ = z();
        l14VarZ.a = 2048;
        l14VarZ.b = i2;
        this.I0++;
        this.W0 = i3;
    }

    public final void U() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = i + 2;
        this.W0 = i4;
        int i5 = iArr[i2];
        if (i3 <= this.A.d) {
            int i6 = this.L0 + i3;
            int[] iArr2 = this.J0;
            if (iArr2[i6] != -1 && iArr2[this.K0 + i3] != -1) {
                return;
            }
        }
        this.W0 = i4 + i5;
    }

    public final boolean V() {
        int i = this.P0;
        int i2 = this.S0;
        int i3 = i - i2;
        int i4 = this.O0;
        k70 k70Var = this.y0;
        if (i3 > i4) {
            boolean z = ja0.q;
            th3 th3Var = this.A;
            if (z && (th3Var.q & 16) != 0) {
                if (i3 <= this.z0) {
                    return y();
                }
                this.z0 = i3;
                this.A0 = i2;
            }
            this.O0 = i3;
            int i5 = this.U0;
            if (k70Var != null) {
                if (i5 <= i) {
                    i = i5;
                }
                this.C0 = i;
                k70Var.T0(0, i);
                int i6 = this.P0;
                this.D0 = i6;
                k70Var.U0(0, i6);
                for (int i7 = 1; i7 <= th3Var.d; i7++) {
                    int i8 = this.L0 + i7;
                    int[] iArr = this.J0;
                    int i9 = iArr[i8];
                    if (i9 != -1) {
                        int i10 = iArr[this.K0 + i7];
                        if (ez4.d(th3Var.j, i7)) {
                            i10 = this.H0[i10].c;
                        }
                        k70Var.T0(i7, i10);
                        if (ez4.d(th3Var.k, i7)) {
                            i9 = this.H0[i9].c;
                        }
                        k70Var.U0(i7, i9);
                    } else {
                        k70Var.T0(i7, -1);
                        k70Var.U0(i7, -1);
                    }
                }
                if (ja0.n && th3Var.i != 0) {
                    tt ttVar = (tt) k70Var.f;
                    if (ttVar == null) {
                        ttVar = new tt(1);
                        k70Var.f = ttVar;
                    } else {
                        for (int i11 = 0; i11 < ttVar.c; i11++) {
                            ((tt[]) ttVar.d)[i11] = null;
                        }
                        ttVar.c = 0;
                        ttVar.b = -1;
                    }
                    ttVar.b = 0;
                    this.X0 = 0;
                    H((tt) k70Var.f);
                }
            } else {
                if (i5 > i) {
                    i5 = i;
                }
                this.C0 = i5;
                this.D0 = i;
            }
        } else if (k70Var != null) {
            k70Var.F0();
        } else {
            this.D0 = 0;
            this.C0 = 0;
        }
        return y();
    }

    public final void W() {
        int i = this.P0;
        if (i < this.Q0) {
            int i2 = this.W0;
            if (this.V0[i2] == this.Y[i]) {
                this.W0 = i2 + 1;
                this.P0 = i + 1;
                this.R0 = this.T0;
                return;
            }
        }
        k0();
    }

    public final void X() {
        int i = this.P0;
        if (i >= this.Q0) {
            k0();
            return;
        }
        byte[] bArr = this.Y0;
        if (bArr == null) {
            bArr = new byte[18];
            this.Y0 = bArr;
        }
        byte[] bArr2 = bArr;
        this.b = i;
        int iT = this.X.t(this.A.r, this.Y, this, this.Z, bArr2);
        int i2 = this.b;
        this.P0 = i2;
        if (i2 > this.Q0) {
            k0();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = iT - 1;
            if (iT <= 0) {
                this.R0 = this.T0;
                return;
            }
            int i5 = this.W0;
            if (this.V0[i5] != bArr2[i3]) {
                k0();
                return;
            } else {
                this.W0 = i5 + 1;
                i3++;
                iT = i4;
            }
        }
    }

    public final void Y() {
        int i = this.P0;
        int i2 = i + 2;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    this.R0 = i7;
                    this.W0 = i3 + 2;
                    this.P0 = i2;
                    return;
                }
            }
        }
        k0();
    }

    public final void Z() {
        int i = this.P0;
        int i2 = i + 3;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    int i8 = i3 + 2;
                    this.W0 = i8;
                    int i9 = iArr[i8];
                    int i10 = i + 2;
                    this.P0 = i10;
                    if (i9 == bArr[i10]) {
                        this.R0 = i10;
                        this.W0 = i3 + 3;
                        this.P0 = i2;
                        return;
                    }
                }
            }
        }
        k0();
    }

    public final void a0() {
        int i = this.P0;
        int i2 = i + 4;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    int i8 = i3 + 2;
                    this.W0 = i8;
                    int i9 = iArr[i8];
                    int i10 = i + 2;
                    this.P0 = i10;
                    if (i9 == bArr[i10]) {
                        int i11 = i3 + 3;
                        this.W0 = i11;
                        int i12 = iArr[i11];
                        int i13 = i + 3;
                        this.P0 = i13;
                        if (i12 == bArr[i13]) {
                            this.R0 = i13;
                            this.W0 = i3 + 4;
                            this.P0 = i2;
                            return;
                        }
                    }
                }
            }
        }
        k0();
    }

    public final void b0() {
        int i = this.P0;
        int i2 = i + 5;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    int i8 = i3 + 2;
                    this.W0 = i8;
                    int i9 = iArr[i8];
                    int i10 = i + 2;
                    this.P0 = i10;
                    if (i9 == bArr[i10]) {
                        int i11 = i3 + 3;
                        this.W0 = i11;
                        int i12 = iArr[i11];
                        int i13 = i + 3;
                        this.P0 = i13;
                        if (i12 == bArr[i13]) {
                            int i14 = i3 + 4;
                            this.W0 = i14;
                            int i15 = iArr[i14];
                            int i16 = i + 4;
                            this.P0 = i16;
                            if (i15 == bArr[i16]) {
                                this.R0 = i16;
                                this.W0 = i3 + 5;
                                this.P0 = i2;
                                return;
                            }
                        }
                    }
                }
            }
        }
        k0();
    }

    public final void c0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        if ((i3 * 2) + this.P0 > this.Q0) {
            k0();
            return;
        }
        boolean z = ja0.C;
        byte[] bArr = this.Y;
        if (!z) {
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                int i5 = this.W0;
                int i6 = iArr[i5];
                int i7 = this.P0;
                if (i6 != bArr[i7]) {
                    break;
                }
                int i8 = i5 + 1;
                this.W0 = i8;
                int i9 = iArr[i8];
                int i10 = i7 + 1;
                this.P0 = i10;
                if (i9 != bArr[i10]) {
                    break;
                }
                this.W0 = i5 + 2;
                this.P0 = i7 + 2;
                i3 = i4;
            }
            k0();
            return;
        }
        byte[][] bArr2 = this.A.G;
        int i11 = i + 2;
        this.W0 = i11;
        byte[] bArr3 = bArr2[iArr[i2]];
        this.W0 = i + 3;
        int i12 = iArr[i11];
        while (true) {
            int i13 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            byte b = bArr3[i12];
            int i14 = this.P0;
            if (b != bArr[i14]) {
                break;
            }
            byte b2 = bArr3[i12 + 1];
            int i15 = i14 + 1;
            this.P0 = i15;
            if (b2 != bArr[i15]) {
                break;
            }
            i12 += 2;
            this.P0 = i14 + 2;
            i3 = i13;
        }
        k0();
        return;
        this.R0 = this.P0 - 2;
    }

    public final void d0() {
        int i = this.P0;
        int i2 = i + 2;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    this.W0 = i3 + 2;
                    this.P0 = i2;
                    this.R0 = this.T0;
                    return;
                }
            }
        }
        k0();
    }

    public final void e0() {
        int i = this.P0;
        int i2 = i + 4;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    int i8 = i3 + 2;
                    this.W0 = i8;
                    int i9 = i + 2;
                    this.P0 = i9;
                    this.R0 = i9;
                    if (iArr[i8] == bArr[i9]) {
                        int i10 = i3 + 3;
                        this.W0 = i10;
                        int i11 = iArr[i10];
                        int i12 = i + 3;
                        this.P0 = i12;
                        if (i11 == bArr[i12]) {
                            this.W0 = i3 + 4;
                            this.P0 = i2;
                            return;
                        }
                    }
                    k0();
                    return;
                }
            }
        }
        k0();
    }

    public final void f0() {
        int i = this.P0;
        int i2 = i + 6;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    int i8 = i3 + 2;
                    this.W0 = i8;
                    int i9 = iArr[i8];
                    int i10 = i + 2;
                    this.P0 = i10;
                    if (i9 == bArr[i10]) {
                        int i11 = i3 + 3;
                        this.W0 = i11;
                        int i12 = iArr[i11];
                        int i13 = i + 3;
                        this.P0 = i13;
                        if (i12 == bArr[i13]) {
                            int i14 = i3 + 4;
                            this.W0 = i14;
                            int i15 = i + 4;
                            this.P0 = i15;
                            this.R0 = i15;
                            if (iArr[i14] == bArr[i15]) {
                                int i16 = i3 + 5;
                                this.W0 = i16;
                                int i17 = iArr[i16];
                                int i18 = i + 5;
                                this.P0 = i18;
                                if (i17 == bArr[i18]) {
                                    this.W0 = i3 + 6;
                                    this.P0 = i2;
                                    return;
                                }
                            }
                            k0();
                            return;
                        }
                    }
                }
            }
        }
        k0();
    }

    public final void g0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        if ((i3 * 3) + this.P0 > this.Q0) {
            k0();
            return;
        }
        boolean z = ja0.C;
        byte[] bArr = this.Y;
        if (!z) {
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                int i5 = this.W0;
                int i6 = iArr[i5];
                int i7 = this.P0;
                if (i6 != bArr[i7]) {
                    break;
                }
                int i8 = i5 + 1;
                this.W0 = i8;
                int i9 = iArr[i8];
                int i10 = i7 + 1;
                this.P0 = i10;
                if (i9 != bArr[i10]) {
                    break;
                }
                int i11 = i5 + 2;
                this.W0 = i11;
                int i12 = iArr[i11];
                int i13 = i7 + 2;
                this.P0 = i13;
                if (i12 != bArr[i13]) {
                    break;
                }
                this.W0 = i5 + 3;
                this.P0 = i7 + 3;
                i3 = i4;
            }
            k0();
            return;
        }
        byte[][] bArr2 = this.A.G;
        int i14 = i + 2;
        this.W0 = i14;
        byte[] bArr3 = bArr2[iArr[i2]];
        this.W0 = i + 3;
        int i15 = iArr[i14];
        while (true) {
            int i16 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            byte b = bArr3[i15];
            int i17 = this.P0;
            if (b != bArr[i17]) {
                break;
            }
            byte b2 = bArr3[i15 + 1];
            int i18 = i17 + 1;
            this.P0 = i18;
            if (b2 != bArr[i18]) {
                break;
            }
            byte b3 = bArr3[i15 + 2];
            int i19 = i17 + 2;
            this.P0 = i19;
            if (b3 != bArr[i19]) {
                break;
            }
            i15 += 3;
            this.P0 = i17 + 3;
            i3 = i16;
        }
        k0();
        return;
        this.R0 = this.P0 - 3;
    }

    public final void h0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = i + 2;
        this.W0 = i4;
        int i5 = iArr[i2] * i3;
        if (this.P0 + i5 > this.Q0) {
            k0();
            return;
        }
        boolean z = ja0.C;
        byte[] bArr = this.Y;
        if (!z) {
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    break;
                }
                int i7 = this.W0;
                int i8 = iArr[i7];
                int i9 = this.P0;
                if (i8 != bArr[i9]) {
                    k0();
                    return;
                } else {
                    this.W0 = i7 + 1;
                    this.P0 = i9 + 1;
                    i5 = i6;
                }
            }
        } else {
            byte[][] bArr2 = this.A.G;
            int i10 = i + 3;
            this.W0 = i10;
            byte[] bArr3 = bArr2[iArr[i4]];
            this.W0 = i + 4;
            int i11 = iArr[i10];
            while (true) {
                int i12 = i5 - 1;
                if (i5 <= 0) {
                    break;
                }
                byte b = bArr3[i11];
                int i13 = this.P0;
                if (b != bArr[i13]) {
                    k0();
                    return;
                } else {
                    i11++;
                    this.P0 = i13 + 1;
                    i5 = i12;
                }
            }
        }
        this.R0 = this.P0 - i3;
    }

    public final void i0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        if (this.P0 + i3 > this.Q0) {
            k0();
            return;
        }
        boolean z = ja0.C;
        byte[] bArr = this.Y;
        if (!z) {
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                int i5 = this.W0;
                this.W0 = i5 + 1;
                int i6 = iArr[i5];
                int i7 = this.P0;
                this.P0 = i7 + 1;
                if (i6 != bArr[i7]) {
                    k0();
                    return;
                }
                i3 = i4;
            }
        } else {
            byte[][] bArr2 = this.A.G;
            int i8 = i + 2;
            this.W0 = i8;
            byte[] bArr3 = bArr2[iArr[i2]];
            this.W0 = i + 3;
            int i9 = iArr[i8];
            while (true) {
                int i10 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                int i11 = i9 + 1;
                byte b = bArr3[i9];
                int i12 = this.P0;
                this.P0 = i12 + 1;
                if (b != bArr[i12]) {
                    k0();
                    return;
                } else {
                    i9 = i11;
                    i3 = i10;
                }
            }
        }
        this.R0 = this.P0 - 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        r13 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j0() {
        /*
            r13 = this;
            int r0 = r13.W0
            int r1 = r0 + 1
            r13.W0 = r1
            int[] r2 = r13.V0
            r3 = r2[r0]
            byte[] r4 = r13.Y0
            if (r4 != 0) goto L14
            r4 = 18
            byte[] r4 = new byte[r4]
            r13.Y0 = r4
        L14:
            r10 = r4
            boolean r4 = defpackage.ja0.C
            byte[] r7 = r13.Y
            r11 = 0
            th3 r12 = r13.A
            if (r4 == 0) goto L6d
            byte[][] r4 = r12.G
            int r5 = r0 + 2
            r13.W0 = r5
            r1 = r2[r1]
            r1 = r4[r1]
            int r0 = r0 + 3
            r13.W0 = r0
            r0 = r2[r5]
            int r3 = r3 + r0
        L2f:
            if (r0 >= r3) goto Lb0
            int r2 = r13.P0
            r13.R0 = r2
            int r4 = r13.Q0
            if (r2 < r4) goto L3d
            r13.k0()
            return
        L3d:
            r13.b = r2
            int r6 = r12.r
            int r9 = r13.Z
            k0 r5 = r13.X
            r8 = r13
            int r13 = r5.t(r6, r7, r8, r9, r10)
            int r2 = r8.b
            r8.P0 = r2
            int r4 = r8.Q0
            if (r2 <= r4) goto L56
            r8.k0()
            return
        L56:
            r2 = r11
        L57:
            int r4 = r13 + (-1)
            if (r13 <= 0) goto L6b
            r13 = r1[r0]
            r5 = r10[r2]
            if (r13 == r5) goto L65
            r8.k0()
            return
        L65:
            int r0 = r0 + 1
            int r2 = r2 + 1
            r13 = r4
            goto L57
        L6b:
            r13 = r8
            goto L2f
        L6d:
            r8 = r13
            int r1 = r1 + r3
        L6f:
            int r13 = r8.W0
            if (r13 >= r1) goto Lb0
            int r13 = r8.P0
            r8.R0 = r13
            int r0 = r8.Q0
            if (r13 < r0) goto L7f
            r8.k0()
            return
        L7f:
            r8.b = r13
            int r6 = r12.r
            int r9 = r8.Z
            k0 r5 = r8.X
            int r13 = r5.t(r6, r7, r8, r9, r10)
            int r0 = r8.b
            r8.P0 = r0
            int r3 = r8.Q0
            if (r0 <= r3) goto L97
            r8.k0()
            return
        L97:
            r0 = r11
        L98:
            int r3 = r13 + (-1)
            if (r13 <= 0) goto L6f
            int r13 = r8.W0
            r4 = r2[r13]
            r5 = r10[r0]
            if (r4 == r5) goto La8
            r8.k0()
            return
        La8:
            int r13 = r13 + 1
            r8.W0 = r13
            int r0 = r0 + 1
            r13 = r3
            goto L98
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.st.j0():void");
    }

    public final void k0() {
        if (this.H0 == null) {
            this.W0 = this.A.b - 1;
            return;
        }
        l14 l14VarF0 = F0();
        this.W0 = l14VarF0.b;
        this.P0 = l14VarF0.c;
        this.R0 = l14VarF0.d;
        this.U0 = l14VarF0.e;
        if (!ja0.s || ((bo3) l14VarF0).f == 0) {
            return;
        }
        l14VarF0.a = 4096;
        this.I0++;
    }

    public final void l0() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.L0 + i2;
        int i4 = this.P0;
        int[] iArr = this.J0;
        iArr[i3] = i4;
        int iB = B(i2);
        int i5 = this.K0 + i2;
        if (!ez4.d(this.A.j, i2)) {
            iB = this.H0[iB].c;
        }
        iArr[i5] = iB;
        l14 l14VarZ = z();
        l14VarZ.a = 33792;
        l14VarZ.b = i2;
        this.I0++;
    }

    public final void m0() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.K0 + i2;
        int i4 = this.P0;
        int[] iArr = this.J0;
        iArr[i3] = i4;
        iArr[this.L0 + i2] = -1;
    }

    public final void n0() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.P0;
        l14 l14VarZ = z();
        l14VarZ.a = 256;
        l14VarZ.b = i2;
        l14VarZ.c = i3;
        int i4 = this.K0 + i2;
        int[] iArr = this.J0;
        l14VarZ.d = iArr[i4];
        int i5 = this.L0 + i2;
        l14VarZ.e = iArr[i5];
        int i6 = this.I0;
        iArr[i4] = i6;
        iArr[i5] = -1;
        this.I0 = i6 + 1;
    }

    public final void o0() {
        int i = this.P0;
        if (i < this.Q0) {
            int i2 = this.Z;
            k0 k0Var = this.X;
            byte[] bArr = this.Y;
            if (!mh2.o(i, i2, k0Var, bArr)) {
                int i3 = this.P0;
                this.P0 = k0Var.r(i3, i2, bArr) + i3;
                this.R0 = this.T0;
                return;
            }
        }
        k0();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0177, code lost:
    
        throw new defpackage.l12("undefined bytecode (bug)");
     */
    /* JADX WARN: Removed duplicated region for block: B:290:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0168  */
    @Override // defpackage.mh2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int p(int r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 2164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.st.p(int, int, int):int");
    }

    public final void p0() {
        int i = this.P0;
        int i2 = this.Z;
        byte[] bArr = this.Y;
        k0 k0Var = this.X;
        if (i == 0) {
            if (i >= this.Q0 || !mh2.o(i, i2, k0Var, bArr)) {
                return;
            }
            k0();
            return;
        }
        if (i != i2) {
            if (mh2.o(i, i2, k0Var, bArr) != mh2.o(this.R0, i2, k0Var, bArr)) {
                k0();
            }
        } else {
            int i3 = this.R0;
            if (i3 >= i2 || !mh2.o(i3, i2, k0Var, bArr)) {
                return;
            }
            k0();
        }
    }

    public final void q0() {
        l14 l14Var;
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.P0;
        int i4 = this.I0;
        while (true) {
            i4--;
            l14Var = this.H0[i4];
            if (l14Var.a == 12288 && l14Var.b == i2) {
                break;
            }
        }
        if (l14Var.c == i3) {
            if (ja0.N) {
                PrintStream printStream = ja0.G;
                StringBuilder sbD = dw2.D("NULL_CHECK_END: skip  id:", i2, ", s:");
                sbD.append(this.P0);
                printStream.println(sbD.toString());
            }
            I();
        }
    }

    public final void r0() {
        l14 l14Var;
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.P0;
        int i4 = this.I0;
        while (true) {
            i4--;
            l14Var = this.H0[i4];
            if (l14Var.a == 12288 && l14Var.b == i2) {
                break;
            }
        }
        byte b = 0;
        if (l14Var.c == i3) {
            byte b2 = 1;
            while (true) {
                if (i4 >= this.I0) {
                    b = b2;
                    break;
                }
                int i5 = i4 + 1;
                l14 l14Var2 = this.H0[i4];
                if (l14Var2.a == 256) {
                    if (l14Var2.e == -1) {
                        break;
                    }
                    int i6 = ez4.d(this.A.k, l14Var2.b) ? this.H0[l14Var2.e].c : l14Var2.e;
                    if (this.H0[l14Var2.d].c != i6) {
                        break;
                    } else if (i6 != i3) {
                        b2 = -1;
                    }
                }
                i4 = i5;
            }
        }
        if (b != 0) {
            if (ja0.N) {
                PrintStream printStream = ja0.G;
                StringBuilder sbD = dw2.D("NULL_CHECK_END_MEMST: skip  id:", i2, ", s:");
                sbD.append(this.P0);
                printStream.println(sbD.toString());
            }
            if (b == -1) {
                k0();
            } else {
                I();
            }
        }
    }

    public final void s0() {
        l14 l14Var;
        l14 l14Var2;
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        boolean z = ja0.i;
        int i3 = this.P0;
        int i4 = this.I0;
        byte b = 0;
        if (z) {
            int i5 = 0;
            while (true) {
                i4--;
                l14Var2 = this.H0[i4];
                int i6 = l14Var2.a;
                if (i6 == 12288) {
                    if (l14Var2.b != i2) {
                        continue;
                    } else if (i5 == 0) {
                        break;
                    } else {
                        i5--;
                    }
                } else if (i6 == 20480 && l14Var2.b == i2) {
                    i5++;
                }
            }
            if (l14Var2.c == i3) {
                byte b2 = 1;
                while (true) {
                    if (i4 >= this.I0) {
                        b = b2;
                        break;
                    }
                    if (l14Var2.a == 256) {
                        if (l14Var2.e == -1) {
                            break;
                        }
                        int i7 = ez4.d(this.A.k, l14Var2.b) ? this.H0[l14Var2.e].c : l14Var2.e;
                        if (this.H0[l14Var2.d].c != i7) {
                            break;
                        } else if (i7 != i3) {
                            b2 = -1;
                        }
                    }
                    i4++;
                    l14Var2 = this.H0[i4];
                }
            }
        } else {
            int i8 = 0;
            while (true) {
                i4--;
                l14Var = this.H0[i4];
                int i9 = l14Var.a;
                if (i9 == 12288) {
                    if (l14Var.b != i2) {
                        continue;
                    } else if (i8 == 0) {
                        break;
                    } else {
                        i8--;
                    }
                } else if (i9 == 20480) {
                    i8++;
                }
            }
            if (l14Var.c == i3) {
                b = 1;
            }
        }
        if (b == 0) {
            l14 l14VarZ = z();
            l14VarZ.a = 20480;
            l14VarZ.b = i2;
            this.I0++;
            return;
        }
        if (ja0.N) {
            PrintStream printStream = ja0.G;
            StringBuilder sbD = dw2.D("NULL_CHECK_END_MEMST_PUSH: skip  id:", i2, ", s:");
            sbD.append(this.P0);
            printStream.println(sbD.toString());
        }
        if (b == -1) {
            k0();
        } else {
            I();
        }
    }

    public final void t(int i) {
        if (i > this.A.d || v(i)) {
            k0();
            return;
        }
        int iW = w(i);
        int iU = u(i) - iW;
        int i2 = this.P0;
        if (i2 + iU > this.Q0) {
            k0();
            return;
        }
        this.R0 = i2;
        while (true) {
            int i3 = iU - 1;
            byte[] bArr = this.Y;
            if (iU > 0) {
                int i4 = iW + 1;
                byte b = bArr[iW];
                int i5 = this.P0;
                this.P0 = i5 + 1;
                if (b != bArr[i5]) {
                    k0();
                    return;
                } else {
                    iW = i4;
                    iU = i3;
                }
            } else {
                if (this.R0 >= this.Q0) {
                    return;
                }
                while (true) {
                    int i6 = this.R0;
                    int iR = this.X.r(i6, this.Z, bArr);
                    if (i6 + iR >= this.P0) {
                        return;
                    } else {
                        this.R0 += iR;
                    }
                }
            }
        }
    }

    public final void t0() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.P0;
        l14 l14VarZ = z();
        l14VarZ.a = 12288;
        l14VarZ.b = i2;
        l14VarZ.c = i3;
        this.I0++;
    }

    public final int u(int i) {
        int i2 = this.J0[this.L0 + i];
        return ez4.d(this.A.k, i) ? this.H0[i2].c : i2;
    }

    public final void u0() {
        l14[] l14VarArr = this.H0;
        int i = this.I0;
        while (true) {
            i--;
            l14 l14Var = this.H0[i];
            int i2 = l14Var.a;
            if ((i2 & 4351) != 0) {
                l14Var.a = 2560;
            } else if (i2 == 1280) {
                l14Var.a = 2560;
                l14 l14Var2 = l14VarArr[i];
                this.P0 = l14Var2.c;
                this.R0 = l14Var2.d;
                return;
            }
        }
    }

    public final boolean v(int i) {
        int i2 = this.L0 + i;
        int[] iArr = this.J0;
        return iArr[i2] == -1 || iArr[this.K0 + i] == -1;
    }

    public final void v0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = this.P0;
        if (i4 >= this.Q0 || iArr[i2] != this.Y[i4]) {
            this.W0 = i + 2;
            return;
        }
        int i5 = i + 2;
        this.W0 = i5;
        H0(1, i5 + i3, i4, this.R0, this.U0);
    }

    public final int w(int i) {
        int i2 = this.J0[this.K0 + i];
        return ez4.d(this.A.j, i) ? this.H0[i2].c : i2;
    }

    public final void w0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        this.W0 = i + 2;
        int i4 = iArr[i2];
        int i5 = this.P0;
        k0 k0Var = this.X;
        int i6 = this.Z;
        byte[] bArr = this.Y;
        int iY = k0Var.y(i5, i6, i4, bArr);
        int i7 = this.W0;
        if (iY == -1) {
            this.W0 = i7 + i3;
            return;
        }
        H0(2, i7 + i3, this.P0, this.R0, this.U0);
        this.P0 = iY;
        this.R0 = k0Var.v(0, iY, i6, bArr);
    }

    public final void x() {
        int i;
        ja0.G.printf("%4d", Integer.valueOf(this.P0)).print("> \"");
        int i2 = this.P0;
        int i3 = 0;
        while (true) {
            i = this.Z;
            if (i3 >= 7 || i2 >= i || this.P0 < 0) {
                break;
            }
            k0 k0Var = this.X;
            byte[] bArr = this.Y;
            int iR = k0Var.r(i2, i, bArr);
            while (true) {
                int i4 = iR - 1;
                if (iR > 0) {
                    if (i2 < i) {
                        ja0.G.print(new String(bArr, i2, 1));
                        iR = i4;
                        i2++;
                    } else {
                        iR = i4;
                    }
                }
            }
            i3++;
        }
        String str = i2 < i ? "...\"" : "\"";
        int length = str.length() + i2;
        ja0.G.print(str);
        for (int i5 = 0; i5 < 20 - (length - this.P0); i5++) {
            ja0.G.print(" ");
        }
        StringBuilder sb = new StringBuilder();
        new lw2(this.A).c(this.W0, sb);
        ja0.G.println(sb.toString());
    }

    public final void x0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = this.P0;
        if (i4 >= this.Q0 || iArr[i2] != this.Y[i4]) {
            this.W0 = i3 + 1 + i2;
            return;
        }
        int i5 = i + 2;
        this.W0 = i5;
        H0(1, i5 + i3, i4, this.R0, this.U0);
    }

    public final boolean y() {
        int i = this.A.q;
        if ((i & 48) == 0) {
            return true;
        }
        if ((i & 32) != 0 && this.P0 == this.S0) {
            this.O0 = -1;
            k0();
            return false;
        }
        if ((i & 16) == 0 || this.P0 >= this.Q0) {
            return true;
        }
        k0();
        return false;
    }

    public final void y0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = i + 2;
        this.W0 = i4;
        int i5 = iArr[i2];
        this.J0[i3] = this.I0;
        l14 l14VarZ = z();
        l14VarZ.a = 1792;
        l14VarZ.d = i3;
        l14VarZ.c = i4;
        l14VarZ.b = 0;
        this.I0++;
        if (this.A.m[i3] == 0) {
            H0(1, this.W0 + i5, this.P0, this.R0, this.U0);
        }
    }

    public final l14 z() {
        int i = this.I0;
        l14[] l14VarArr = this.H0;
        if (i >= l14VarArr.length) {
            l14[] l14VarArr2 = new l14[l14VarArr.length << 1];
            System.arraycopy(l14VarArr, 0, l14VarArr2, 0, l14VarArr.length);
            this.H0 = l14VarArr2;
            l14VarArr = l14VarArr2;
        }
        int i2 = this.I0;
        l14 bo3Var = l14VarArr[i2];
        if (bo3Var == null) {
            bo3Var = ja0.s ? new bo3() : new l14();
            l14VarArr[i2] = bo3Var;
        }
        return bo3Var;
    }

    public final void z0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = i + 2;
        this.W0 = i4;
        int i5 = iArr[i2];
        this.J0[i3] = this.I0;
        l14 l14VarZ = z();
        l14VarZ.a = 1792;
        l14VarZ.d = i3;
        l14VarZ.c = i4;
        l14VarZ.b = 0;
        this.I0++;
        if (this.A.m[i3] == 0) {
            H0(1, this.W0, this.P0, this.R0, this.U0);
            this.W0 += i5;
        }
    }
}
