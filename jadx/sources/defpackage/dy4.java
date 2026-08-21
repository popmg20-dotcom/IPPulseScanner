package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dy4 extends j52 {
    public static final char[] M0 = v30.a(true);
    public static final char[] N0 = v30.a(false);
    public final me2 F0;
    public final char G0;
    public char[] H0;
    public int I0;
    public int J0;
    public final int K0;
    public char[] L0;

    public dy4(vv1 vv1Var, int i, me2 me2Var, char c) {
        int[] iArrCopyOf;
        super(i, vv1Var);
        this.F0 = me2Var;
        if (vv1Var.Y != null) {
            xe.q("Trying to call same allocXxx() method second time");
            throw null;
        }
        mp mpVar = vv1Var.f;
        mpVar.getClass();
        int i2 = mp.d[1];
        i2 = i2 <= 0 ? 0 : i2;
        char[] cArr = (char[]) mpVar.b.getAndSet(1, null);
        cArr = (cArr == null || cArr.length < i2) ? new char[i2] : cArr;
        vv1Var.Y = cArr;
        this.H0 = cArr;
        this.K0 = cArr.length;
        this.G0 = c;
        boolean zX = x(u72.ESCAPE_FORWARD_SLASHES.b);
        if (c != '\"' || zX) {
            if (c == '\"') {
                iArrCopyOf = zX ? v30.g : v30.f;
            } else {
                u30 u30Var = u30.c;
                int[][] iArr = u30Var.a;
                int[][] iArr2 = u30Var.b;
                if (zX) {
                    iArrCopyOf = iArr2[c];
                    if (iArrCopyOf == null) {
                        iArrCopyOf = iArr[c];
                        if (iArrCopyOf == null) {
                            iArrCopyOf = Arrays.copyOf(v30.f, 128);
                            if (iArrCopyOf[c] == 0) {
                                iArrCopyOf[c] = -1;
                            }
                            iArr[c] = iArrCopyOf;
                        }
                        iArrCopyOf[47] = 47;
                        iArr2[c] = iArrCopyOf;
                    }
                } else {
                    iArrCopyOf = iArr[c];
                    if (iArrCopyOf == null) {
                        iArrCopyOf = Arrays.copyOf(v30.f, 128);
                        if (iArrCopyOf[c] == 0) {
                            iArrCopyOf[c] = -1;
                        }
                        iArr[c] = iArrCopyOf;
                    }
                }
            }
            this.z0 = iArrCopyOf;
        }
    }

    public static int T0(gp gpVar, byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = 0;
        while (i < i2) {
            bArr[i5] = bArr[i];
            i5++;
            i++;
        }
        int iMin = Math.min(i3, bArr.length);
        do {
            int i6 = iMin - i5;
            if (i6 == 0 || (i4 = gpVar.read(bArr, i5, i6)) < 0) {
                return i5;
            }
            i5 += i4;
        } while (i5 < 3);
        return i5;
    }

    @Override // defpackage.i52
    public final void C(yj yjVar, byte[] bArr, int i, int i2) throws g52 {
        int iA;
        if (bArr == null) {
            g("Invalid `byte[]` argument: `null`");
            throw null;
        }
        int length = bArr.length;
        int i3 = i + i2;
        if ((i | i2 | i3 | (length - i3)) < 0) {
            g(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `byte[]` of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(length)));
            throw null;
        }
        L0("write a binary value");
        int i4 = this.J0;
        int i5 = this.K0;
        if (i4 >= i5) {
            Q0();
        }
        char[] cArr = this.H0;
        int i6 = this.J0;
        this.J0 = i6 + 1;
        char c = this.G0;
        cArr[i6] = c;
        int i7 = i3 - 3;
        int i8 = i5 - 6;
        int i9 = yjVar.Y;
        loop0: while (true) {
            int i10 = i9 >> 2;
            while (i <= i7) {
                if (this.J0 > i8) {
                    Q0();
                }
                int i11 = i + 2;
                int i12 = ((bArr[i + 1] & 255) | (bArr[i] << 8)) << 8;
                i += 3;
                iA = yjVar.a(this.H0, i12 | (bArr[i11] & 255), this.J0);
                this.J0 = iA;
                i10--;
                if (i10 <= 0) {
                    break;
                }
            }
            char[] cArr2 = this.H0;
            int i13 = iA + 1;
            this.J0 = i13;
            cArr2[iA] = '\\';
            this.J0 = iA + 2;
            cArr2[i13] = 'n';
            i9 = yjVar.Y;
        }
        int i14 = i3 - i;
        if (i14 > 0) {
            if (this.J0 > i8) {
                Q0();
            }
            int i15 = i + 1;
            int i16 = bArr[i] << 16;
            if (i14 == 2) {
                i16 |= (bArr[i15] & 255) << 8;
            }
            this.J0 = yjVar.b(i16, i14, this.H0, this.J0);
        }
        if (this.J0 >= i5) {
            Q0();
        }
        char[] cArr3 = this.H0;
        int i17 = this.J0;
        this.J0 = i17 + 1;
        cArr3[i17] = c;
    }

    @Override // defpackage.i52
    public final void F(boolean z) {
        int i;
        L0("write a boolean value");
        if (this.J0 + 5 >= this.K0) {
            Q0();
        }
        int i2 = this.J0;
        char[] cArr = this.H0;
        if (z) {
            cArr[i2] = 't';
            cArr[i2 + 1] = 'r';
            cArr[i2 + 2] = 'u';
            i = i2 + 3;
            cArr[i] = 'e';
        } else {
            cArr[i2] = 'f';
            cArr[i2 + 1] = 'a';
            cArr[i2 + 2] = 'l';
            cArr[i2 + 3] = 's';
            i = i2 + 4;
            cArr[i] = 'e';
        }
        this.J0 = i + 1;
    }

    @Override // defpackage.i52
    public final void F0(ft3 ft3Var) {
        char c = this.G0;
        L0("write a string");
        int i = this.J0;
        int i2 = this.K0;
        if (i >= i2) {
            Q0();
        }
        char[] cArr = this.H0;
        int i3 = this.J0;
        int i4 = i3 + 1;
        this.J0 = i4;
        cArr[i3] = c;
        char[] cArrA = ft3Var.f;
        if (cArrA == null) {
            d72 d72Var = ft3.z;
            String str = ft3Var.b;
            d72Var.getClass();
            cArrA = d72.a(str);
            ft3Var.f = cArrA;
        }
        int length = cArrA.length;
        if (i4 + length > cArr.length) {
            length = -1;
        } else {
            System.arraycopy(cArrA, 0, cArr, i4, length);
        }
        if (length >= 0) {
            int i5 = this.J0 + length;
            this.J0 = i5;
            if (i5 >= i2) {
                Q0();
            }
            char[] cArr2 = this.H0;
            int i6 = this.J0;
            this.J0 = i6 + 1;
            cArr2[i6] = c;
            return;
        }
        char[] cArrA2 = ft3Var.a();
        int length2 = cArrA2.length;
        if (length2 < 32) {
            if (length2 > i2 - this.J0) {
                Q0();
            }
            System.arraycopy(cArrA2, 0, this.H0, this.J0, length2);
            this.J0 += length2;
        } else {
            Q0();
            this.F0.write(cArrA2, 0, length2);
        }
        if (this.J0 >= i2) {
            Q0();
        }
        char[] cArr3 = this.H0;
        int i7 = this.J0;
        this.J0 = i7 + 1;
        cArr3[i7] = c;
    }

    @Override // defpackage.i52
    public final void G0(String str) {
        L0("write a string");
        if (str == null) {
            W0();
            return;
        }
        int i = this.J0;
        int i2 = this.K0;
        if (i >= i2) {
            Q0();
        }
        char[] cArr = this.H0;
        int i3 = this.J0;
        this.J0 = i3 + 1;
        char c = this.G0;
        cArr[i3] = c;
        Y0(str);
        if (this.J0 >= i2) {
            Q0();
        }
        char[] cArr2 = this.H0;
        int i4 = this.J0;
        this.J0 = i4 + 1;
        cArr2[i4] = c;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[PHI: r11
      0x0045: PHI (r11v6 int) = (r11v3 int), (r11v7 int) binds: [B:15:0x0041, B:13:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.i52
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H0(char[] r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dy4.H0(char[], int, int):void");
    }

    @Override // defpackage.i52
    public final void I() throws g52 {
        lb4 lb4Var = this.X;
        if (lb4Var.b != 1) {
            g("Current context not Array but ".concat(lb4Var.h()));
            throw null;
        }
        g43 g43Var = this.b;
        if (g43Var != null) {
            int i = lb4Var.c + 1;
            dm0 dm0Var = (dm0) g43Var;
            cu2 cu2Var = dm0Var.b;
            if (!cu2Var.Y()) {
                dm0Var.A--;
            }
            if (i > 0) {
                cu2Var.c0(this, dm0Var.A);
            } else {
                n0(dm0Var.z0);
            }
            j0(']');
        } else {
            if (this.J0 >= this.K0) {
                Q0();
            }
            char[] cArr = this.H0;
            int i2 = this.J0;
            this.J0 = i2 + 1;
            cArr[i2] = ']';
        }
        this.X = (lb4) this.X.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    @Override // defpackage.eo1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L0(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dy4.L0(java.lang.String):void");
    }

    @Override // defpackage.i52
    public final void M() throws g52 {
        lb4 lb4Var = this.X;
        if (lb4Var.b != 2) {
            g("Current context not Object but ".concat(lb4Var.h()));
            throw null;
        }
        g43 g43Var = this.b;
        if (g43Var != null) {
            int i = lb4Var.c + 1;
            dm0 dm0Var = (dm0) g43Var;
            cu2 cu2Var = dm0Var.f;
            if (!cu2Var.Y()) {
                dm0Var.A--;
            }
            if (i > 0) {
                cu2Var.c0(this, dm0Var.A);
            } else {
                n0(dm0Var.Z);
            }
            j0('}');
        } else {
            if (this.J0 >= this.K0) {
                Q0();
            }
            char[] cArr = this.H0;
            int i2 = this.J0;
            this.J0 = i2 + 1;
            cArr[i2] = '}';
        }
        this.X = (lb4) this.X.g;
    }

    @Override // defpackage.i52
    public final void N(ft3 ft3Var) throws g52 {
        int iJ = this.X.j(ft3Var.b);
        if (iJ == 4) {
            g("Can not write a field name, expecting a value");
            throw null;
        }
        boolean z = iJ == 1;
        int i = this.K0;
        char c = this.G0;
        g43 g43Var = this.b;
        if (g43Var != null) {
            if (z) {
                dm0 dm0Var = (dm0) g43Var;
                n0(dm0Var.Y);
                dm0Var.f.c0(this, dm0Var.A);
            } else {
                dm0 dm0Var2 = (dm0) g43Var;
                dm0Var2.f.c0(this, dm0Var2.A);
            }
            char[] cArrA = ft3Var.a();
            if (this.C0) {
                Z0(cArrA, cArrA.length);
                return;
            }
            if (this.J0 >= i) {
                Q0();
            }
            char[] cArr = this.H0;
            int i2 = this.J0;
            this.J0 = i2 + 1;
            cArr[i2] = c;
            Z0(cArrA, cArrA.length);
            if (this.J0 >= i) {
                Q0();
            }
            char[] cArr2 = this.H0;
            int i3 = this.J0;
            this.J0 = i3 + 1;
            cArr2[i3] = c;
            return;
        }
        if (this.J0 + 1 >= i) {
            Q0();
        }
        if (z) {
            char[] cArr3 = this.H0;
            int i4 = this.J0;
            this.J0 = i4 + 1;
            cArr3[i4] = StringUtil.COMMA;
        }
        if (this.C0) {
            char[] cArrA2 = ft3Var.a();
            Z0(cArrA2, cArrA2.length);
            return;
        }
        char[] cArr4 = this.H0;
        int i5 = this.J0;
        int i6 = i5 + 1;
        this.J0 = i6;
        cArr4[i5] = c;
        char[] cArrA3 = ft3Var.f;
        if (cArrA3 == null) {
            d72 d72Var = ft3.z;
            String str = ft3Var.b;
            d72Var.getClass();
            cArrA3 = d72.a(str);
            ft3Var.f = cArrA3;
        }
        int length = cArrA3.length;
        if (i6 + length > cArr4.length) {
            length = -1;
        } else {
            System.arraycopy(cArrA3, 0, cArr4, i6, length);
        }
        if (length < 0) {
            char[] cArrA4 = ft3Var.a();
            Z0(cArrA4, cArrA4.length);
            if (this.J0 >= i) {
                Q0();
            }
            char[] cArr5 = this.H0;
            int i7 = this.J0;
            this.J0 = i7 + 1;
            cArr5[i7] = c;
            return;
        }
        int i8 = this.J0 + length;
        this.J0 = i8;
        if (i8 >= i) {
            Q0();
        }
        char[] cArr6 = this.H0;
        int i9 = this.J0;
        this.J0 = i9 + 1;
        cArr6[i9] = c;
    }

    public final char[] O0() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u', 0, 0, 0, 0};
        this.L0 = cArr;
        return cArr;
    }

    public final void P0(char c, int i) {
        int i2;
        int i3 = this.K0;
        if (i >= 0) {
            if (this.J0 + 2 > i3) {
                Q0();
            }
            char[] cArr = this.H0;
            int i4 = this.J0;
            int i5 = i4 + 1;
            this.J0 = i5;
            cArr[i4] = '\\';
            this.J0 = i4 + 2;
            cArr[i5] = (char) i;
            return;
        }
        if (i == -2) {
            throw null;
        }
        if (this.J0 + 5 >= i3) {
            Q0();
        }
        int i6 = this.J0;
        char[] cArr2 = this.H0;
        char[] cArr3 = this.D0 ? M0 : N0;
        cArr2[i6] = '\\';
        int i7 = i6 + 2;
        cArr2[i6 + 1] = 'u';
        if (c > 255) {
            int i8 = c >> '\b';
            int i9 = i6 + 3;
            cArr2[i7] = cArr3[(i8 & DnsRecord.CLASS_ANY) >> 4];
            i2 = i6 + 4;
            cArr2[i9] = cArr3[i8 & 15];
            c = (char) (c & 255);
        } else {
            int i10 = i6 + 3;
            cArr2[i7] = '0';
            i2 = i6 + 4;
            cArr2[i10] = '0';
        }
        cArr2[i2] = cArr3[c >> 4];
        cArr2[i2 + 1] = cArr3[c & 15];
        this.J0 = i2 + 2;
    }

    @Override // defpackage.i52
    public final void Q(String str) throws g52 {
        int iJ = this.X.j(str);
        if (iJ == 4) {
            g("Can not write a field name, expecting a value");
            throw null;
        }
        boolean z = iJ == 1;
        g43 g43Var = this.b;
        int i = this.K0;
        char c = this.G0;
        if (g43Var == null) {
            if (this.J0 + 1 >= i) {
                Q0();
            }
            if (z) {
                char[] cArr = this.H0;
                int i2 = this.J0;
                this.J0 = i2 + 1;
                cArr[i2] = StringUtil.COMMA;
            }
            if (this.C0) {
                Y0(str);
                return;
            }
            char[] cArr2 = this.H0;
            int i3 = this.J0;
            this.J0 = i3 + 1;
            cArr2[i3] = c;
            Y0(str);
            if (this.J0 >= i) {
                Q0();
            }
            char[] cArr3 = this.H0;
            int i4 = this.J0;
            this.J0 = i4 + 1;
            cArr3[i4] = c;
            return;
        }
        if (z) {
            dm0 dm0Var = (dm0) g43Var;
            n0(dm0Var.Y);
            dm0Var.f.c0(this, dm0Var.A);
        } else {
            dm0 dm0Var2 = (dm0) g43Var;
            dm0Var2.f.c0(this, dm0Var2.A);
        }
        if (this.C0) {
            Y0(str);
            return;
        }
        if (this.J0 >= i) {
            Q0();
        }
        char[] cArr4 = this.H0;
        int i5 = this.J0;
        this.J0 = i5 + 1;
        cArr4[i5] = c;
        Y0(str);
        if (this.J0 >= i) {
            Q0();
        }
        char[] cArr5 = this.H0;
        int i6 = this.J0;
        this.J0 = i6 + 1;
        cArr5[i6] = c;
    }

    public final void Q0() {
        int i = this.J0;
        int i2 = this.I0;
        int i3 = i - i2;
        if (i3 > 0) {
            this.I0 = 0;
            this.J0 = 0;
            this.F0.write(this.H0, i2, i3);
        }
    }

    public final int R0(char[] cArr, int i, int i2, char c, int i3) {
        int i4;
        me2 me2Var = this.F0;
        if (i3 >= 0) {
            if (i > 1 && i < i2) {
                int i5 = i - 2;
                cArr[i5] = '\\';
                cArr[i - 1] = (char) i3;
                return i5;
            }
            char[] cArrO0 = this.L0;
            if (cArrO0 == null) {
                cArrO0 = O0();
            }
            cArrO0[1] = (char) i3;
            me2Var.write(cArrO0, 0, 2);
            return i;
        }
        if (i3 == -2) {
            throw null;
        }
        char[] cArr2 = this.D0 ? M0 : N0;
        if (i <= 5 || i >= i2) {
            char[] cArrO02 = this.L0;
            if (cArrO02 == null) {
                cArrO02 = O0();
            }
            this.I0 = this.J0;
            if (c <= 255) {
                cArrO02[6] = cArr2[c >> 4];
                cArrO02[7] = cArr2[c & 15];
                me2Var.write(cArrO02, 2, 6);
                return i;
            }
            int i6 = c >> '\b';
            cArrO02[10] = cArr2[(i6 & DnsRecord.CLASS_ANY) >> 4];
            cArrO02[11] = cArr2[i6 & 15];
            cArrO02[12] = cArr2[(c & 255) >> 4];
            cArrO02[13] = cArr2[c & 15];
            me2Var.write(cArrO02, 8, 6);
            return i;
        }
        cArr[i - 6] = '\\';
        int i7 = i - 4;
        cArr[i - 5] = 'u';
        if (c > 255) {
            int i8 = c >> '\b';
            int i9 = i - 3;
            cArr[i7] = cArr2[(i8 & DnsRecord.CLASS_ANY) >> 4];
            i4 = i - 2;
            cArr[i9] = cArr2[i8 & 15];
            c = (char) (c & 255);
        } else {
            int i10 = i - 3;
            cArr[i7] = '0';
            i4 = i - 2;
            cArr[i10] = '0';
        }
        cArr[i4] = cArr2[c >> 4];
        cArr[i4 + 1] = cArr2[c & 15];
        return i4 - 4;
    }

    public final void S0(char c, int i) {
        int i2;
        me2 me2Var = this.F0;
        if (i >= 0) {
            int i3 = this.J0;
            if (i3 >= 2) {
                int i4 = i3 - 2;
                this.I0 = i4;
                char[] cArr = this.H0;
                cArr[i4] = '\\';
                cArr[i3 - 1] = (char) i;
                return;
            }
            char[] cArrO0 = this.L0;
            if (cArrO0 == null) {
                cArrO0 = O0();
            }
            this.I0 = this.J0;
            cArrO0[1] = (char) i;
            me2Var.write(cArrO0, 0, 2);
            return;
        }
        if (i == -2) {
            throw null;
        }
        char[] cArr2 = this.D0 ? M0 : N0;
        int i5 = this.J0;
        if (i5 < 6) {
            char[] cArrO02 = this.L0;
            if (cArrO02 == null) {
                cArrO02 = O0();
            }
            this.I0 = this.J0;
            if (c <= 255) {
                cArrO02[6] = cArr2[c >> 4];
                cArrO02[7] = cArr2[c & 15];
                me2Var.write(cArrO02, 2, 6);
                return;
            } else {
                int i6 = c >> '\b';
                cArrO02[10] = cArr2[(i6 & DnsRecord.CLASS_ANY) >> 4];
                cArrO02[11] = cArr2[i6 & 15];
                cArrO02[12] = cArr2[(c & 255) >> 4];
                cArrO02[13] = cArr2[c & 15];
                me2Var.write(cArrO02, 8, 6);
                return;
            }
        }
        char[] cArr3 = this.H0;
        int i7 = i5 - 6;
        this.I0 = i7;
        cArr3[i7] = '\\';
        cArr3[i5 - 5] = 'u';
        if (c > 255) {
            int i8 = c >> '\b';
            cArr3[i5 - 4] = cArr2[(i8 & DnsRecord.CLASS_ANY) >> 4];
            i2 = i5 - 3;
            cArr3[i2] = cArr2[i8 & 15];
            c = (char) (c & 255);
        } else {
            cArr3[i5 - 4] = '0';
            i2 = i5 - 3;
            cArr3[i2] = '0';
        }
        cArr3[i2 + 1] = cArr2[c >> 4];
        cArr3[i2 + 2] = cArr2[c & 15];
    }

    @Override // defpackage.i52
    public final void U() {
        L0("write a null");
        W0();
    }

    public final int U0(yj yjVar, gp gpVar, byte[] bArr) {
        int i = this.K0 - 6;
        int i2 = 2;
        int i3 = yjVar.Y >> 2;
        int i4 = -3;
        int i5 = 0;
        int iT0 = 0;
        int i6 = 0;
        while (true) {
            if (i5 > i4) {
                iT0 = T0(gpVar, bArr, i5, iT0, bArr.length);
                if (iT0 < 3) {
                    break;
                }
                i4 = iT0 - 3;
                i5 = 0;
            }
            if (this.J0 > i) {
                Q0();
            }
            int i7 = i5 + 2;
            int i8 = ((bArr[i5 + 1] & 255) | (bArr[i5] << 8)) << 8;
            i5 += 3;
            i6 += 3;
            int iA = yjVar.a(this.H0, (bArr[i7] & 255) | i8, this.J0);
            this.J0 = iA;
            i3--;
            if (i3 <= 0) {
                char[] cArr = this.H0;
                int i9 = iA + 1;
                this.J0 = i9;
                cArr[iA] = '\\';
                this.J0 = iA + 2;
                cArr[i9] = 'n';
                i3 = yjVar.Y >> 2;
            }
        }
        if (iT0 <= 0) {
            return i6;
        }
        if (this.J0 > i) {
            Q0();
        }
        int i10 = bArr[0] << 16;
        if (1 < iT0) {
            i10 |= (bArr[1] & 255) << 8;
        } else {
            i2 = 1;
        }
        int i11 = i6 + i2;
        this.J0 = yjVar.b(i10, i2, this.H0, this.J0);
        return i11;
    }

    public final int V0(yj yjVar, gp gpVar, byte[] bArr, int i) {
        int iT0;
        int i2 = this.K0 - 6;
        int i3 = 2;
        int i4 = yjVar.Y >> 2;
        int i5 = -3;
        int i6 = 0;
        int iT02 = 0;
        while (true) {
            if (i <= 2) {
                break;
            }
            if (i6 > i5) {
                iT02 = T0(gpVar, bArr, i6, iT02, i);
                if (iT02 < 3) {
                    i6 = 0;
                    break;
                }
                i5 = iT02 - 3;
                i6 = 0;
            }
            if (this.J0 > i2) {
                Q0();
            }
            int i7 = i6 + 2;
            int i8 = ((bArr[i6 + 1] & 255) | (bArr[i6] << 8)) << 8;
            i6 += 3;
            i -= 3;
            int iA = yjVar.a(this.H0, (bArr[i7] & 255) | i8, this.J0);
            this.J0 = iA;
            i4--;
            if (i4 <= 0) {
                char[] cArr = this.H0;
                int i9 = iA + 1;
                this.J0 = i9;
                cArr[iA] = '\\';
                this.J0 = iA + 2;
                cArr[i9] = 'n';
                i4 = yjVar.Y >> 2;
            }
        }
        if (i <= 0 || (iT0 = T0(gpVar, bArr, i6, iT02, i)) <= 0) {
            return i;
        }
        if (this.J0 > i2) {
            Q0();
        }
        int i10 = bArr[0] << 16;
        if (1 < iT0) {
            i10 |= (bArr[1] & 255) << 8;
        } else {
            i3 = 1;
        }
        this.J0 = yjVar.b(i10, i3, this.H0, this.J0);
        return i - i3;
    }

    public final void W0() {
        if (this.J0 + 4 >= this.K0) {
            Q0();
        }
        int i = this.J0;
        char[] cArr = this.H0;
        cArr[i] = 'n';
        cArr[i + 1] = 'u';
        cArr[i + 2] = 'l';
        cArr[i + 3] = 'l';
        this.J0 = i + 4;
    }

    @Override // defpackage.i52
    public final void X(double d) {
        if (!this.A) {
            String str = dt2.a;
            if (((Double.isInfinite(d) || Double.isNaN(d)) ? false : true) || !x(h52.QUOTE_NON_NUMERIC_NUMBERS)) {
                L0("write a number");
                n0(dt2.g(d, x(h52.USE_FAST_DOUBLE_WRITER)));
                return;
            }
        }
        G0(dt2.g(d, x(h52.USE_FAST_DOUBLE_WRITER)));
    }

    public final void X0(String str) {
        int i = this.J0;
        int i2 = this.K0;
        if (i >= i2) {
            Q0();
        }
        char[] cArr = this.H0;
        int i3 = this.J0;
        this.J0 = i3 + 1;
        char c = this.G0;
        cArr[i3] = c;
        n0(str);
        if (this.J0 >= i2) {
            Q0();
        }
        char[] cArr2 = this.H0;
        int i4 = this.J0;
        this.J0 = i4 + 1;
        cArr2[i4] = c;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[PHI: r16
      0x004b: PHI (r16v3 int) = (r16v0 int), (r16v4 int) binds: [B:18:0x0046, B:16:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y0(java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dy4.Y0(java.lang.String):void");
    }

    @Override // defpackage.i52
    public final void Z(float f) {
        if (!this.A) {
            String str = dt2.a;
            if ((!Float.isInfinite(f) && !Float.isNaN(f)) || !x(h52.QUOTE_NON_NUMERIC_NUMBERS)) {
                L0("write a number");
                n0(dt2.h(f, x(h52.USE_FAST_DOUBLE_WRITER)));
                return;
            }
        }
        G0(dt2.h(f, x(h52.USE_FAST_DOUBLE_WRITER)));
    }

    public final void Z0(char[] cArr, int i) throws g52 {
        int length = cArr.length;
        if (((length - i) | i) < 0) {
            g(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `char[]` of length %d", 0, Integer.valueOf(i), Integer.valueOf(length)));
            throw null;
        }
        if (i >= 32) {
            Q0();
            this.F0.write(cArr, 0, i);
        } else {
            if (i > this.K0 - this.J0) {
                Q0();
            }
            System.arraycopy(cArr, 0, this.H0, this.J0, i);
            this.J0 += i;
        }
    }

    @Override // defpackage.i52
    public final void c0(int i) {
        L0("write a number");
        boolean z = this.A;
        int i2 = this.K0;
        if (!z) {
            if (this.J0 + 11 >= i2) {
                Q0();
            }
            this.J0 = dt2.e(this.H0, i, this.J0);
            return;
        }
        if (this.J0 + 13 >= i2) {
            Q0();
        }
        char[] cArr = this.H0;
        int i3 = this.J0;
        int i4 = i3 + 1;
        this.J0 = i4;
        char c = this.G0;
        cArr[i3] = c;
        int iE = dt2.e(cArr, i, i4);
        char[] cArr2 = this.H0;
        this.J0 = iE + 1;
        cArr2[iE] = c;
    }

    @Override // defpackage.eo1, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        super.close();
        try {
            if (this.H0 != null && x(h52.AUTO_CLOSE_JSON_CONTENT)) {
                while (true) {
                    int i = this.X.b;
                    if (!(i == 1)) {
                        if (!(i == 2)) {
                            break;
                        } else {
                            M();
                        }
                    } else {
                        I();
                    }
                }
            }
            Q0();
            e = null;
        } catch (IOException e) {
            e = e;
        }
        this.I0 = 0;
        this.J0 = 0;
        if (this.F0 != null) {
            try {
                if (!x(h52.AUTO_CLOSE_TARGET)) {
                    x(h52.FLUSH_PASSED_TO_STREAM);
                }
            } catch (IOException | RuntimeException e2) {
                if (e != null) {
                    e2.addSuppressed(e);
                }
                throw e2;
            }
        }
        char[] cArr = this.H0;
        if (cArr != null) {
            this.H0 = null;
            vv1 vv1Var = this.z;
            char[] cArr2 = vv1Var.Y;
            if (cArr != cArr2 && cArr.length < cArr2.length) {
                xe.k("Trying to release buffer smaller than original");
                return;
            }
            vv1Var.Y = null;
            AtomicReferenceArray atomicReferenceArray = vv1Var.f.b;
            char[] cArr3 = (char[]) atomicReferenceArray.get(1);
            if (cArr3 == null || cArr.length > cArr3.length) {
                atomicReferenceArray.set(1, cArr);
            }
        }
        if (e != null) {
            throw e;
        }
    }

    @Override // java.io.Flushable
    public final void flush() {
        Q0();
        if (this.F0 != null) {
            x(h52.FLUSH_PASSED_TO_STREAM);
        }
    }

    @Override // defpackage.i52
    public final void i0(long j) {
        L0("write a number");
        boolean z = this.A;
        int i = this.K0;
        if (!z) {
            if (this.J0 + 21 >= i) {
                Q0();
            }
            this.J0 = dt2.f(j, this.H0, this.J0);
            return;
        }
        if (this.J0 + 23 >= i) {
            Q0();
        }
        char[] cArr = this.H0;
        int i2 = this.J0;
        int i3 = i2 + 1;
        this.J0 = i3;
        char c = this.G0;
        cArr[i2] = c;
        int iF = dt2.f(j, cArr, i3);
        char[] cArr2 = this.H0;
        this.J0 = iF + 1;
        cArr2[iF] = c;
    }

    @Override // defpackage.i52
    public final void j0(char c) {
        if (this.J0 >= this.K0) {
            Q0();
        }
        char[] cArr = this.H0;
        int i = this.J0;
        this.J0 = i + 1;
        cArr[i] = c;
    }

    @Override // defpackage.i52
    public final void n0(String str) {
        int length = str.length();
        int i = this.J0;
        int i2 = this.K0;
        int i3 = i2 - i;
        if (i3 == 0) {
            Q0();
            i = this.J0;
            i3 = i2 - i;
        }
        char[] cArr = this.H0;
        if (i3 >= length) {
            str.getChars(0, length, cArr, i);
            this.J0 += length;
            return;
        }
        int i4 = i2 - i;
        str.getChars(0, i4, cArr, i);
        this.J0 += i4;
        Q0();
        int length2 = str.length() - i4;
        while (true) {
            char[] cArr2 = this.H0;
            if (length2 <= i2) {
                str.getChars(i4, i4 + length2, cArr2, 0);
                this.I0 = 0;
                this.J0 = length2;
                return;
            } else {
                int i5 = i4 + i2;
                str.getChars(i4, i5, cArr2, 0);
                this.I0 = 0;
                this.J0 = i2;
                Q0();
                length2 -= i2;
                i4 = i5;
            }
        }
    }

    @Override // defpackage.i52
    public final void q0(Object obj) throws t34 {
        L0("start an array");
        lb4 lb4Var = this.X;
        lb4 lb4Var2 = (lb4) lb4Var.i;
        if (lb4Var2 == null) {
            iv1 iv1Var = (iv1) lb4Var.h;
            lb4Var2 = new lb4(1, lb4Var, iv1Var != null ? new iv1((eo1) iv1Var.f) : null, obj);
            lb4Var.i = lb4Var2;
        } else {
            lb4Var2.b = 1;
            lb4Var2.c = -1;
            lb4Var2.e = null;
            lb4Var2.f = false;
            lb4Var2.j = obj;
            iv1 iv1Var2 = (iv1) lb4Var2.h;
            if (iv1Var2 != null) {
                iv1Var2.z = null;
                iv1Var2.A = null;
                iv1Var2.X = null;
            }
        }
        this.X = lb4Var2;
        this.y0.a(lb4Var2.d);
        g43 g43Var = this.b;
        if (g43Var != null) {
            ((dm0) g43Var).a(this);
            return;
        }
        if (this.J0 >= this.K0) {
            Q0();
        }
        char[] cArr = this.H0;
        int i = this.J0;
        this.J0 = i + 1;
        cArr[i] = '[';
    }

    @Override // defpackage.i52
    public final void r0(Object obj) throws t34 {
        L0("start an array");
        lb4 lb4Var = this.X;
        lb4 lb4Var2 = (lb4) lb4Var.i;
        if (lb4Var2 == null) {
            iv1 iv1Var = (iv1) lb4Var.h;
            lb4Var2 = new lb4(1, lb4Var, iv1Var != null ? new iv1((eo1) iv1Var.f) : null, obj);
            lb4Var.i = lb4Var2;
        } else {
            lb4Var2.b = 1;
            lb4Var2.c = -1;
            lb4Var2.e = null;
            lb4Var2.f = false;
            lb4Var2.j = obj;
            iv1 iv1Var2 = (iv1) lb4Var2.h;
            if (iv1Var2 != null) {
                iv1Var2.z = null;
                iv1Var2.A = null;
                iv1Var2.X = null;
            }
        }
        this.X = lb4Var2;
        this.y0.a(lb4Var2.d);
        g43 g43Var = this.b;
        if (g43Var != null) {
            ((dm0) g43Var).a(this);
            return;
        }
        if (this.J0 >= this.K0) {
            Q0();
        }
        char[] cArr = this.H0;
        int i = this.J0;
        this.J0 = i + 1;
        cArr[i] = '[';
    }

    @Override // defpackage.i52
    public final void x0() throws t34 {
        L0("start an object");
        lb4 lb4Var = this.X;
        lb4 lb4Var2 = (lb4) lb4Var.i;
        if (lb4Var2 == null) {
            iv1 iv1Var = (iv1) lb4Var.h;
            lb4Var2 = new lb4(2, lb4Var, iv1Var != null ? new iv1((eo1) iv1Var.f) : null);
            lb4Var.i = lb4Var2;
        } else {
            lb4Var2.b = 2;
            lb4Var2.c = -1;
            lb4Var2.e = null;
            lb4Var2.f = false;
            iv1 iv1Var2 = (iv1) lb4Var2.h;
            if (iv1Var2 != null) {
                iv1Var2.z = null;
                iv1Var2.A = null;
                iv1Var2.X = null;
            }
        }
        this.X = lb4Var2;
        this.y0.a(lb4Var2.d);
        g43 g43Var = this.b;
        if (g43Var != null) {
            dm0 dm0Var = (dm0) g43Var;
            j0('{');
            if (dm0Var.f.Y()) {
                return;
            }
            dm0Var.A++;
            return;
        }
        if (this.J0 >= this.K0) {
            Q0();
        }
        char[] cArr = this.H0;
        int i = this.J0;
        this.J0 = i + 1;
        cArr[i] = '{';
    }

    @Override // defpackage.i52
    public final void z0(Object obj) throws t34 {
        L0("start an object");
        lb4 lb4Var = this.X;
        lb4 lb4Var2 = (lb4) lb4Var.i;
        if (lb4Var2 == null) {
            iv1 iv1Var = (iv1) lb4Var.h;
            lb4Var2 = new lb4(2, lb4Var, iv1Var != null ? new iv1((eo1) iv1Var.f) : null, obj);
            lb4Var.i = lb4Var2;
        } else {
            lb4Var2.b = 2;
            lb4Var2.c = -1;
            lb4Var2.e = null;
            lb4Var2.f = false;
            lb4Var2.j = obj;
            iv1 iv1Var2 = (iv1) lb4Var2.h;
            if (iv1Var2 != null) {
                iv1Var2.z = null;
                iv1Var2.A = null;
                iv1Var2.X = null;
            }
        }
        this.y0.a(lb4Var.d);
        this.X = lb4Var2;
        g43 g43Var = this.b;
        if (g43Var != null) {
            dm0 dm0Var = (dm0) g43Var;
            j0('{');
            if (dm0Var.f.Y()) {
                return;
            }
            dm0Var.A++;
            return;
        }
        if (this.J0 >= this.K0) {
            Q0();
        }
        char[] cArr = this.H0;
        int i = this.J0;
        this.J0 = i + 1;
        cArr[i] = '{';
    }
}
