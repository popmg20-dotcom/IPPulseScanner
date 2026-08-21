package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.ssl.OpenSslSessionTicketKey;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m92 extends ue2 implements v51 {
    public static final int[] F0 = {58, 93};
    public final k0 A;
    public final int A0;
    public int B0;
    public final th3 C0;
    public final up3 D0;
    public final se4 E0 = new se4();
    public final byte[] X;
    public int Y;
    public int Z;
    public int y0;
    public int z0;

    public m92(th3 th3Var, byte[] bArr, int i) {
        this.A = th3Var.p;
        this.X = bArr;
        this.A0 = i;
        this.C0 = th3Var;
        this.D0 = new up3(th3Var);
    }

    public static int D(int i) {
        if (i == 39) {
            return 39;
        }
        if (i == 40) {
            return 41;
        }
        if (i != 60) {
            return i != 123 ? 0 : 125;
        }
        return 62;
    }

    public static void G(String str) {
        throw new go4(str);
    }

    public final void A() {
        int i = this.Y;
        this.y0 = i;
        byte[] bArr = this.X;
        this.Y = this.A.r(i, this.Z, bArr) + i;
    }

    public final void B(boolean z) {
        if (z) {
            this.Y = this.B0;
        } else {
            E("invalid repeat range {lower,upper}");
            throw null;
        }
    }

    public final boolean C() {
        return this.Y < this.Z;
    }

    public final void E(String str) {
        throw new s84(str);
    }

    public final void F(int i, int i2, String str) {
        throw new go4(str.replaceAll("%n", new String(this.X, i, i2 - i)));
    }

    public final int H() {
        int i = this.Y;
        int i2 = this.Z;
        if (i < i2) {
            return this.A.u(i, i2, this.X);
        }
        return 0;
    }

    public final boolean I(int i) {
        return H() == i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if (r3.a == 12) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J() {
        /*
            r6 = this;
            boolean r0 = r6.C()
            r1 = 0
            r2 = 1
            se4 r3 = r6.E0
            if (r0 == 0) goto L39
            r0 = 43
            boolean r0 = r6.I(r0)
            if (r0 == 0) goto L39
            r0 = -1570030630(0xffffffffa26b3bda, float:-3.1880124E-18)
            r4 = r0 & 16
            if (r4 == 0) goto L1b
            r4 = r2
            goto L1c
        L1b:
            r4 = r1
        L1c:
            r5 = 12
            if (r4 == 0) goto L24
            int r4 = r3.a
            if (r4 != r5) goto L31
        L24:
            r0 = r0 & 32
            if (r0 == 0) goto L2a
            r0 = r2
            goto L2b
        L2a:
            r0 = r1
        L2b:
            if (r0 == 0) goto L39
            int r0 = r3.a
            if (r0 != r5) goto L39
        L31:
            r6.k()
            r3.g = r2
            r3.h = r2
            return
        L39:
            r3.g = r2
            r3.h = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m92.J():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
    
        if (r8 <= r7) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        r6.z0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int K(int r7, int r8) {
        /*
            r6 = this;
            int r0 = r6.z0
            int r7 = r8 - r7
            r1 = 0
        L5:
            boolean r2 = r6.C()
            if (r2 == 0) goto L4c
            int r2 = r8 + (-1)
            if (r8 == 0) goto L4b
            r6.k()
            int r3 = r6.z0
            r4 = 11
            k0 r5 = r6.A
            boolean r3 = r5.j(r3, r4)
            if (r3 == 0) goto L46
            int r8 = r6.z0
            r3 = 4
            boolean r3 = r5.j(r8, r3)
            if (r3 == 0) goto L2a
            int r8 = r8 + (-48)
            goto L37
        L2a:
            r3 = 10
            boolean r3 = r5.j(r8, r3)
            if (r3 == 0) goto L35
            int r8 = r8 + (-55)
            goto L37
        L35:
            int r8 = r8 + (-87)
        L37:
            r3 = 2147483647(0x7fffffff, float:NaN)
            int r3 = r3 - r8
            int r3 = r3 / 16
            if (r3 >= r1) goto L41
            r6 = -1
            return r6
        L41:
            int r1 = r1 << 4
            int r1 = r1 + r8
            r8 = r2
            goto L5
        L46:
            int r2 = r6.y0
            r6.Y = r2
            goto L4c
        L4b:
            r8 = r2
        L4c:
            if (r8 <= r7) goto L50
            r6 = -2
            return r6
        L50:
            r6.z0 = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m92.K(int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        r5.z0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int L() {
        /*
            r5 = this;
            int r0 = r5.z0
            r1 = 0
        L3:
            boolean r2 = r5.C()
            if (r2 == 0) goto L2c
            r5.k()
            int r2 = r5.z0
            r3 = 4
            k0 r4 = r5.A
            boolean r2 = r4.j(r2, r3)
            if (r2 == 0) goto L28
            int r2 = r1 * 10
            int r3 = r5.z0
            int r3 = r3 + (-48)
            int r2 = r2 + r3
            r1 = r1 ^ r2
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r3
            if (r1 == 0) goto L26
            r5 = -1
            return r5
        L26:
            r1 = r2
            goto L3
        L28:
            int r2 = r5.y0
            r5.Y = r2
        L2c:
            r5.z0 = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m92.L():int");
    }

    public final int M(int i) {
        int i2;
        int i3 = this.z0;
        int i4 = 0;
        while (C()) {
            int i5 = i - 1;
            if (i == 0) {
                break;
            }
            k();
            if (!this.A.j(this.z0, 4) || (i2 = this.z0) >= 56) {
                this.Y = this.y0;
                break;
            }
            int i6 = (i2 - 48) + (i4 << 3);
            if (((i4 ^ i6) & Integer.MIN_VALUE) != 0) {
                return -1;
            }
            i4 = i6;
            i = i5;
        }
        this.z0 = i3;
        return i4;
    }

    public final void k() {
        int i = this.Y;
        int i2 = this.Z;
        k0 k0Var = this.A;
        byte[] bArr = this.X;
        this.z0 = k0Var.u(i, i2, bArr);
        int i3 = this.Y;
        this.y0 = i3;
        this.Y = k0Var.r(i3, this.Z, bArr) + i3;
    }

    public final int l() {
        this.B0 = this.Y;
        while (C()) {
            int i = this.Y;
            k();
            int i2 = this.z0;
            byte[] bArr = this.X;
            if (i2 == 125) {
                return this.A.w(bArr, this.B0, i);
            }
            if (i2 == 40 || i2 == 41 || i2 == 123 || i2 == 124) {
                du duVar = q41.f;
                throw new w30(this.B0, i, bArr);
            }
        }
        F(this.B0, this.Z, "property name never terminated \\p{%n");
        throw null;
    }

    public final void m() {
        if (!C()) {
            E("end pattern at escape");
            throw null;
        }
        k();
        int i = this.z0;
        if (i == 67) {
            if (!(((-1570030630) & 2048) != 0)) {
                n();
                return;
            }
            if (!C()) {
                E("end pattern at control");
                throw null;
            }
            k();
            if (this.z0 == 45) {
                o();
                return;
            } else {
                E("invalid control-code syntax");
                throw null;
            }
        }
        if (i != 77) {
            if (i == 99) {
                if ((134217728 & 2146948438) != 0) {
                    o();
                }
            }
            n();
            return;
        }
        if (!(((-1570030630) & 4096) != 0)) {
            n();
            return;
        }
        if (!C()) {
            E("end pattern at meta");
            throw null;
        }
        k();
        if (this.z0 != 45) {
            E("invalid meta-code syntax");
            throw null;
        }
        if (!C()) {
            E("end pattern at meta");
            throw null;
        }
        k();
        if (this.z0 == 92) {
            m();
        }
        this.z0 = (this.z0 & DnsRecord.CLASS_ANY) | 128;
    }

    public final void n() {
        int i = this.z0;
        if ((67108864 & 2146948438) != 0) {
            if (i == 97) {
                i = 7;
            } else if (i == 98) {
                i = 8;
            } else if (i == 101) {
                i = 27;
            } else if (i == 102) {
                i = 12;
            } else if (i == 110) {
                i = 10;
            } else if (i == 114) {
                i = 13;
            } else if (i == 116) {
                i = 9;
            } else if (i == 118) {
                if (((-1570030630) & 8192) != 0) {
                    i = 11;
                }
            } else if ((97 <= i && i <= 122) || (65 <= i && i <= 90)) {
                String.valueOf((char) i);
            }
        }
        this.z0 = i;
    }

    public final void o() {
        if (!C()) {
            E("end pattern at control");
            throw null;
        }
        k();
        int i = this.z0;
        if (i == 63) {
            this.z0 = 127;
            return;
        }
        if (i == 92) {
            m();
        }
        this.z0 &= 159;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int p(int r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m92.p(int, boolean):int");
    }

    public final void q(int i, int i2, int i3, String str) {
        while (C()) {
            i3 = this.Y;
            k();
            int i4 = this.z0;
            if (i4 == i2 || i4 == 41) {
                break;
            }
        }
        if (!C()) {
            i3 = this.Z;
        }
        F(i, i3, str);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:147:0x006f A[EDGE_INSN: B:147:0x006f->B:32:0x006f BREAK  A[LOOP:0: B:16:0x0042->B:155:0x0042], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() {
        /*
            Method dump skipped, instruction units count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m92.r():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:410:0x0536, code lost:
    
        if (r1.b(4096) == false) goto L550;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0538, code lost:
    
        r3.a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x053c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0215  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instruction units count: 1666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m92.s():void");
    }

    public final void t(int i) {
        se4 se4Var = this.E0;
        se4Var.a = 10;
        se4Var.e = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u() {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m92.u():void");
    }

    public final void v(int i, int i2) {
        se4 se4Var = this.E0;
        se4Var.a = 11;
        se4Var.e = i;
        se4Var.f = i2;
        z();
    }

    public final void w() {
        if (!((268435456 & 2146948438) != 0)) {
            if (this.z0 != 48) {
                A();
                return;
            }
            return;
        }
        int i = this.Y;
        int iM = M(this.z0 == 48 ? 2 : 3);
        if (iM < 0 || iM > 255) {
            G("too big number");
            throw null;
        }
        int i2 = this.Y != i ? iM : 0;
        se4 se4Var = this.E0;
        se4Var.a = 2;
        se4Var.c = 8;
        se4Var.e = i2;
    }

    public final void x() {
        boolean zC = C();
        se4 se4Var = this.E0;
        if (!zC) {
            se4Var.a = 1;
            return;
        }
        k();
        se4Var.a = 3;
        se4Var.c = 0;
        int i = this.z0;
        se4Var.e = i;
        se4Var.b = false;
        if (i == 93) {
            se4Var.a = 23;
            return;
        }
        if (i == 45) {
            se4Var.a = 24;
            return;
        }
        byte[] bArr = this.X;
        k0 k0Var = this.A;
        r84 r84Var = r84.a;
        if (i != 92) {
            if (i != 91) {
                if (i == 38 && r84Var.c(64) && C() && I(38)) {
                    A();
                    se4Var.a = 26;
                    return;
                }
                return;
            }
            if (!r84Var.b(16777216) || !I(58)) {
                if (r84Var.c(64)) {
                    se4Var.a = 27;
                    return;
                }
                return;
            }
            se4Var.d = this.Y;
            A();
            int i2 = this.Y;
            int i3 = this.Z;
            int iR = i2;
            loop0: while (true) {
                int i4 = i;
                while (iR < i3) {
                    if (i4 != 0) {
                        break;
                    }
                    int iU = k0Var.u(iR, i3, bArr);
                    int iR2 = k0Var.r(iR, i3, bArr) + iR;
                    int[] iArr = F0;
                    if (iU == iArr[i]) {
                        int iR3 = iR2;
                        int i5 = 1;
                        while (i5 < 2 && iR3 < i3 && k0Var.u(iR3, i3, bArr) == iArr[i5]) {
                            iR3 += k0Var.r(iR3, i3, bArr);
                            i5++;
                        }
                        if (i5 >= 2) {
                            se4Var.a = 25;
                            return;
                        }
                        iR = k0Var.r(iR, i3, bArr) + iR;
                    } else {
                        int iU2 = k0Var.u(iR, i3, bArr);
                        if (iU2 == 93) {
                            break loop0;
                        }
                        i4 = iU2 == 92 ? 1 : i4;
                        iR = iR2;
                    }
                    i = 0;
                }
                iR += k0Var.r(iR, i3, bArr);
            }
            this.Y = this.y0;
            if (r84Var.c(64)) {
                se4Var.a = 27;
                return;
            }
            return;
        }
        if (r84Var.a(2097152)) {
            if (!C()) {
                E("end pattern at escape");
                throw null;
            }
            k();
            se4Var.b = true;
            int i6 = this.z0;
            se4Var.e = i6;
            if (i6 == 68) {
                y(4, true);
                return;
            }
            if (i6 == 72) {
                if (r84Var.c(524288)) {
                    y(11, true);
                    return;
                }
                return;
            }
            if (i6 != 80) {
                if (i6 == 83) {
                    y(9, true);
                    return;
                }
                if (i6 == 87) {
                    y(12, true);
                    return;
                }
                if (i6 == 100) {
                    y(4, false);
                    return;
                }
                if (i6 == 104) {
                    if (r84Var.c(524288)) {
                        y(11, false);
                        return;
                    }
                    return;
                }
                if (i6 != 112) {
                    if (i6 == 115) {
                        y(9, false);
                        return;
                    }
                    if (i6 == 117) {
                        if (C()) {
                            int i7 = this.Y;
                            if (r84Var.c(16384)) {
                                int iK = K(4, 4);
                                if (iK < -1) {
                                    G("too short digits");
                                    throw null;
                                }
                                if (iK < 0) {
                                    G("too big number");
                                    throw null;
                                }
                                i = this.Y != i7 ? iK : 0;
                                se4Var.a = 5;
                                se4Var.c = 16;
                                se4Var.e = i;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (i6 == 119) {
                        y(12, false);
                        return;
                    }
                    if (i6 != 120) {
                        switch (i6) {
                            case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 54:
                            case 55:
                                if (r84Var.b(268435456)) {
                                    int i8 = this.y0;
                                    this.Y = i8;
                                    int iM = M(3);
                                    if (iM < 0 || iM > 255) {
                                        G("too big number");
                                        throw null;
                                    }
                                    i = this.Y != i8 ? iM : 0;
                                    se4Var.a = 2;
                                    se4Var.c = 8;
                                    se4Var.e = i;
                                    return;
                                }
                                return;
                            default:
                                this.Y = this.y0;
                                m();
                                int i9 = se4Var.e;
                                int i10 = this.z0;
                                if (i9 != i10) {
                                    se4Var.e = i10;
                                    se4Var.a = 5;
                                    return;
                                }
                                return;
                        }
                    }
                    if (C()) {
                        int i11 = this.Y;
                        if (!I(123) || !r84Var.b(Pow2.MAX_POW2)) {
                            if (r84Var.b(536870912)) {
                                int iK2 = K(0, 2);
                                if (iK2 < 0) {
                                    G("too big number");
                                    throw null;
                                }
                                i = this.Y != i11 ? iK2 : 0;
                                se4Var.a = 2;
                                se4Var.c = 16;
                                se4Var.e = i;
                                return;
                            }
                            return;
                        }
                        A();
                        int iK3 = K(0, 8);
                        if (iK3 < 0) {
                            G("too big wide-char value");
                            throw null;
                        }
                        if (C() && k0Var.j(H(), 11)) {
                            G("too long wide-char value");
                            throw null;
                        }
                        if (this.Y <= k0Var.r(i11, this.Z, bArr) + i11 || !C() || !I(125)) {
                            this.Y = i11;
                            return;
                        }
                        A();
                        se4Var.a = 5;
                        se4Var.c = 16;
                        se4Var.e = iK3;
                        return;
                    }
                    return;
                }
            }
            if (C()) {
                if (H() != 123 || !r84Var.c(65536)) {
                    "invalid Unicode Property \\<%n>".replace("<%n>", Character.toString((char) this.z0));
                    return;
                }
                A();
                se4Var.a = 19;
                se4Var.f = this.z0 == 80 ? 1 : 0;
                if (C() && r84Var.c(131072)) {
                    int iU3 = k0Var.u(this.Y, this.Z, bArr);
                    int i12 = this.Y;
                    this.y0 = i12;
                    this.Y = k0Var.r(i12, this.Z, bArr) + i12;
                    if (iU3 == 94) {
                        se4Var.f = !se4Var.a() ? 1 : 0;
                    } else {
                        this.Y = this.y0;
                    }
                }
            }
        }
    }

    public final void y(int i, boolean z) {
        se4 se4Var = this.E0;
        se4Var.a = 7;
        se4Var.e = i;
        se4Var.f = z ? 1 : 0;
    }

    public final void z() {
        if (C() && I(63)) {
            if ((33554432 & 2146948438) != 0) {
                k();
                se4 se4Var = this.E0;
                se4Var.g = 0;
                se4Var.h = 0;
                return;
            }
        }
        J();
    }
}
