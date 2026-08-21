package defpackage;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.IllegalFormatConversionException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class th3 {
    public final byte[] A;
    public final int B;
    public byte[] C;
    public int[] D;
    public int E;
    public int F;
    public final byte[][] G;
    public final int H;
    public final int[] a;
    public final int b;
    public boolean c;
    public final int d;
    public int e;
    public int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public int[] m;
    public int[] n;
    public final vd3 o;
    public final k0 p;
    public int q;
    public final int r;
    public du s;
    public n12 t;
    public ek0 u;
    public int v;
    public final int w;
    public final int x;
    public final int y;
    public int z;

    static {
        du duVar = p41.b;
        byte[] bytes = Charset.defaultCharset().name().getBytes();
        duVar.getClass();
        o41 o41Var = (o41) duVar.b(0, bytes.length, bytes);
        if (o41Var == null) {
            int[] iArr = tk4.D0;
            return;
        }
        byte[] bArr = o41Var.d;
        if (o41Var.a == null) {
            String str = o41Var.b;
            if (bArr == null) {
                o41Var.a = r25.x(str);
            } else {
                o41Var.a = r25.x(str).x(bArr);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x0309  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public th3(int i, int i2, k0 k0Var, byte[] bArr) {
        char c;
        m41[] m41VarArr;
        int i3;
        qt qtVar;
        int i4 = ja0.a;
        if (i4 > 0 && i > i4) {
            throw new go4("regex length too long");
        }
        if ((i2 & 384) == 384) {
            throw new go4("invalid combination of options");
        }
        int i5 = (i2 & 64) != 0 ? (i2 | 28672) & (-9) : i2 | 28672;
        this.p = k0Var;
        this.q = i5;
        this.r = Pow2.MAX_POW2;
        b7 b7Var = new b7(this, bArr, i);
        boolean z = ja0.H;
        char c2 = 0;
        k0 k0Var2 = b7Var.A;
        if (z) {
            PrintStream printStream = ja0.G;
            StringBuilder sb = new StringBuilder("\nPATTERN: /");
            if (k0Var2.b > 1) {
                int iR = 0;
                while (iR < i) {
                    int iU = k0Var2.u(iR, i, bArr);
                    if (iU >= 128) {
                        try {
                            sb.append(String.format(" 0x%04x ", Integer.valueOf(iU)));
                        } catch (IllegalFormatConversionException unused) {
                            sb.append(iU);
                        }
                    } else {
                        sb.append((char) iU);
                    }
                    iR += k0Var2.r(iR, i, bArr);
                }
            } else {
                for (int i6 = 0; i6 < i; i6++) {
                    sb.append(new String(bArr, i6, 1));
                }
            }
            sb.append("/");
            printStream.println(sb.toString());
        }
        b7Var.Y = 0;
        b7Var.Z = i;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.m = null;
        this.n = null;
        this.g = 0;
        if (ja0.s) {
            this.g = 0;
        }
        b7Var.s();
        es2 es2VarH0 = b7Var.h0(1);
        boolean z2 = ja0.f;
        up3 up3Var = b7Var.D0;
        if (z2 && up3Var.h > 0) {
            m41 m41VarA = m41.a(up3Var.a, false);
            m41VarA.b = 0;
            m41VarA.d = es2VarH0;
            es2VarH0.parent = m41VarA;
            m41[] m41VarArr2 = up3Var.l;
            if (m41VarArr2 == null) {
                m41VarArr2 = new m41[ja0.d];
                up3Var.l = m41VarArr2;
            }
            m41VarArr2[0] = m41VarA;
            es2VarH0 = m41VarA;
        }
        this.d = up3Var.j;
        if (ja0.e && up3Var.k > 0) {
            if (((128 & (-2019556389)) != 0) && (this.q & 256) == 0) {
                int i7 = up3Var.k;
                int i8 = up3Var.j;
                if (i7 != i8) {
                    int[] iArr = new int[i8 + 1];
                    ue2 ue2Var = new ue2();
                    ue2Var.b = 0;
                    es2VarH0 = b7.V(es2VarH0, iArr, ue2Var);
                    b7.k0(es2VarH0, iArr);
                    int i9 = 1;
                    for (int i10 = 1; i10 <= up3Var.j; i10++) {
                        if (iArr[i10] > 0) {
                            m41[] m41VarArr3 = up3Var.l;
                            m41VarArr3[i9] = m41VarArr3[i10];
                            i9++;
                        }
                    }
                    int i11 = up3Var.d;
                    up3Var.d = 0;
                    for (int i12 = 1; i12 <= ja0.D; i12++) {
                        if (ez4.d(i11, i12)) {
                            int i13 = up3Var.d;
                            int i14 = iArr[i12];
                            up3Var.d = i14 < 32 ? i13 | (1 << i14) : i13;
                        }
                    }
                    int i15 = up3Var.k;
                    up3Var.j = i15;
                    this.d = i15;
                    du duVar = this.s;
                    if (duVar != null) {
                        fr1 fr1Var = duVar.z.d;
                        while (fr1Var != duVar.z) {
                            fr1 fr1Var2 = fr1Var.d;
                            ho2 ho2Var = (ho2) fr1Var.e;
                            int i16 = ho2Var.d;
                            if (i16 > 1) {
                                for (int i17 = 0; i17 < ho2Var.d; i17++) {
                                    int[] iArr2 = ho2Var.f;
                                    iArr2[i17] = iArr[iArr2[i17]];
                                }
                            } else if (i16 == 1) {
                                ho2Var.e = iArr[ho2Var.e];
                            }
                            fr1Var = fr1Var2;
                        }
                    }
                } else {
                    b7.W(es2VarH0);
                }
            }
        }
        if (ja0.e) {
            int i18 = up3Var.h;
            if (i18 > 0) {
                qt qtVar2 = new qt(c2, 15);
                qtVar2.c = new m41[i18];
                qtVar2.d = new int[i18];
                up3Var.i = qtVar2;
                b7Var.o0(es2VarH0);
                b7.t0(es2VarH0);
                b7Var.r0(es2VarH0);
                this.h = up3Var.h;
            } else {
                this.h = 0;
            }
        }
        boolean z3 = ja0.I;
        if (z3 && ja0.J) {
            ja0.G.println("<RAW TREE>\n" + es2VarH0 + "\n");
        }
        cs2 cs2VarNewTop = es2.newTop(es2VarH0);
        b7Var.p0(es2VarH0, 0);
        es2 es2Var = cs2VarNewTop.a;
        if (z3) {
            ja0.G.println("<TREE>\n" + es2Var + "\n");
        }
        int i19 = up3Var.d;
        this.i = i19;
        this.j = up3Var.e;
        if ((this.q & 48) != 0) {
            this.k = -1;
        } else {
            this.k = i19 | up3Var.f;
        }
        if (ja0.s) {
            if (up3Var.g == 0 || (ja0.f && up3Var.h == 0)) {
                b7Var.m0(es2Var, 0);
                if (ja0.f && up3Var.p) {
                    up3Var.m = 0;
                } else if (up3Var.n > 0) {
                    int i20 = 1;
                    while (true) {
                        if (i20 >= up3Var.n) {
                            break;
                        }
                        if (ez4.d(up3Var.g, i20)) {
                            up3Var.m = 0;
                            break;
                        }
                        i20++;
                    }
                }
            }
            this.g = up3Var.m;
        }
        this.t = null;
        this.u = null;
        this.w = 0;
        this.y = 0;
        this.x = 0;
        this.z = 0;
        this.A = null;
        this.B = 0;
        if (ja0.B) {
            c = ' ';
            m41VarArr = null;
        } else {
            cm2 cm2Var = new cm2(11);
            pf1 pf1Var = (pf1) cm2Var.X;
            hm2 hm2Var = (hm2) cm2Var.f;
            c = ' ';
            pf1 pf1Var2 = (pf1) cm2Var.A;
            lw2 lw2Var = (lw2) cm2Var.Z;
            hm2 hm2Var2 = (hm2) lw2Var.d;
            kw2 kw2Var = new kw2(0);
            k0 k0Var3 = this.p;
            kw2Var.d = k0Var3;
            kw2Var.a = this.q;
            kw2Var.b = this.r;
            kw2Var.e = up3Var;
            hm2 hm2Var3 = (hm2) kw2Var.c;
            hm2Var3.c = 0;
            hm2Var3.b = 0;
            b7Var.X(es2Var, cm2Var, kw2Var);
            hm2 hm2Var4 = (hm2) cm2Var.z;
            int i21 = hm2Var4.b;
            int i22 = 53253 & i21;
            this.w = i22;
            if ((i21 & 6144) != 0) {
                i22 = i21 & 20485;
                this.w = i22;
            }
            int i23 = hm2Var4.c;
            int i24 = i22 | (i23 & 2072);
            this.w = i24;
            if ((i24 & 24) != 0) {
                this.x = hm2Var.b;
                this.y = hm2Var.c;
            }
            int i25 = pf1Var2.c;
            hm2 hm2Var5 = (hm2) pf1Var2.d;
            if (i25 > 0 || pf1Var.c > 0) {
                pf1Var2.h(pf1Var, k0Var2);
                int i26 = lw2Var.b;
                if (i26 <= 0) {
                    int i27 = pf1Var2.c;
                    if (i27 != 0) {
                        byte[] bArr2 = (byte[]) pf1Var2.f;
                        this.A = bArr2;
                        this.B = i27;
                        boolean zN = k0Var3.n(bArr2);
                        boolean z4 = k0Var3.z;
                        int i28 = pf1Var2.b;
                        int i29 = pf1Var2.c;
                        if (i28 > 0) {
                            vq3 vq3Var = xq3.e;
                            vq3 vq3Var2 = xq3.g;
                            if (i29 >= 3 || (i29 >= 2 && zN)) {
                                this.t = k0Var3.B() != null ? vq3Var2 : vq3Var;
                                if (c(true)) {
                                    this.t = k0Var3.B() != null ? vq3Var2 : vq3Var;
                                } else {
                                    if (!zN) {
                                        vq3Var = xq3.k;
                                    } else if (k0Var3.B() != null) {
                                        vq3Var = vq3Var2;
                                    }
                                    this.t = vq3Var;
                                }
                            } else {
                                this.t = k0Var3.B() != null ? vq3Var2 : vq3Var;
                            }
                            this.u = k0Var3.B() != null ? xq3.h : xq3.f;
                        } else {
                            vq3 vq3Var3 = xq3.a;
                            vq3 vq3Var4 = xq3.c;
                            if (i29 < 3 && (i29 < 2 || !zN)) {
                                this.t = z4 ? vq3Var4 : vq3Var3;
                            } else if (c(false)) {
                                this.t = z4 ? vq3Var4 : vq3Var3;
                            } else {
                                this.t = zN ? xq3.i : xq3.j;
                            }
                            this.u = z4 ? xq3.d : xq3.b;
                        }
                        int i30 = hm2Var5.b;
                        this.E = i30;
                        this.F = hm2Var5.c;
                        if (i30 != Integer.MAX_VALUE) {
                            this.v = this.B + i30;
                        }
                    }
                    b((hm2) pf1Var2.e);
                } else {
                    if ((i26 <= 0 ? -1 : hm2Var5.d((hm2) lw2Var.c, pf1Var2.c * 20 * (pf1Var2.b > 0 ? 1 : 2), 200 / i26)) > 0) {
                        a(lw2Var);
                        b(hm2Var2);
                    }
                }
            } else if (lw2Var.b > 0) {
                a(lw2Var);
                b(hm2Var2);
            } else {
                int i31 = this.z | (i21 & 2);
                this.z = i31;
                if (hm2Var.c == 0) {
                    this.z = i31 | (i23 & 32);
                }
            }
            if (ja0.K || ja0.N) {
                PrintStream printStream2 = ja0.G;
                StringBuilder sb2 = new StringBuilder("optimize: ");
                n12 n12Var = this.t;
                StringBuilder sbQ = ha0.q(fw.y(sb2, n12Var != null ? n12Var.D() : "NONE", "\n"), "  anchor:     ");
                sbQ.append(hm2.c(this.w));
                String string = sbQ.toString();
                if ((this.w & 24) != 0) {
                    int i32 = this.x;
                    int i33 = this.y;
                    String strConcat = (i32 == Integer.MAX_VALUE ? "inf" : ha0.k("(", i32, ")")).concat("-");
                    string = string.concat(i33 == Integer.MAX_VALUE ? strConcat.concat("inf") : strConcat + "(" + i33 + ")");
                }
                String strConcat2 = string.concat("\n");
                if (this.t != null) {
                    StringBuilder sbQ2 = ha0.q(strConcat2, "  sub anchor: ");
                    sbQ2.append(hm2.c(this.z));
                    sbQ2.append("\n");
                    strConcat2 = sbQ2.toString();
                }
                StringBuilder sbQ3 = ha0.q(strConcat2, "dmin: ");
                sbQ3.append(this.E);
                sbQ3.append(" dmax: ");
                String strW = fw.w("\n", ha0.q(fw.w("\n", sbQ3, this.F), "threshold length: "), this.v);
                if (this.A != null) {
                    StringBuilder sbQ4 = ha0.q(strW, "exact: [");
                    sbQ4.append(new String(this.A, 0, this.B));
                    sbQ4.append("]: length: ");
                    strW = fw.w("\n", sbQ4, this.B);
                } else {
                    n12 n12Var2 = this.t;
                    if (n12Var2 == xq3.l || n12Var2 == xq3.n) {
                        int i34 = 0;
                        for (int i35 = 0; i35 < ja0.b; i35++) {
                            if (this.C[i35] != 0) {
                                i34++;
                            }
                        }
                        strW = strW + "map: n = " + i34 + "\n";
                        if (i34 > 0) {
                            String strConcat3 = strW.concat("[");
                            int i36 = 0;
                            for (int i37 = 0; i37 < ja0.b; i37++) {
                                if (this.C[i37] != 0) {
                                    strConcat3 = i36 > 0 ? strConcat3.concat(", ") : strConcat3;
                                    i36++;
                                    strConcat3 = (k0Var3.f == 1 && k0Var3.j(i37, 7)) ? strConcat3 + ((char) i37) : dw2.A(i37, strConcat3);
                                }
                            }
                            strW = strConcat3.concat("]\n");
                        }
                    }
                }
                printStream2.println(strW);
            }
            m41VarArr = null;
        }
        up3Var.l = m41VarArr;
        zd zdVar = new zd(b7Var);
        zdVar.Y = new int[ja0.C ? 8 : (i * 2) + 2];
        zdVar.b = 0;
        zdVar.k(es2Var);
        zdVar.e(1);
        zdVar.e(0);
        th3 th3Var = (th3) zdVar.X;
        th3Var.a = (int[]) zdVar.Y;
        th3Var.b = zdVar.b;
        th3Var.G = (byte[][]) zdVar.Z;
        th3Var.H = zdVar.f;
        th3Var.o = vd3.Y;
        if (ja0.f && (qtVar = up3Var.i) != null) {
            for (int i38 = 0; i38 < qtVar.b; i38++) {
                m41 m41Var = ((m41[]) qtVar.c)[i38];
                if (!m41Var.isAddrFixed()) {
                    throw new l12("internal parser error (bug)");
                }
                th3Var.a[((int[]) qtVar.d)[i38]] = m41Var.e;
            }
            up3Var.i = null;
        }
        if (this.e != 0 || this.k != 0) {
            i3 = 0;
            this.l = 2;
        } else if (this.j != 0) {
            this.l = 1;
            i3 = 0;
        } else {
            i3 = 0;
            this.l = 0;
        }
        if (ja0.K) {
            if (ja0.e) {
                PrintStream printStream3 = ja0.G;
                StringBuilder sb3 = new StringBuilder();
                if (this.s != null) {
                    sb3.append("name table\n");
                    du duVar2 = this.s;
                    duVar2.getClass();
                    fr1 fr1Var3 = duVar2.z.d;
                    while (fr1Var3 != duVar2.z) {
                        fr1 fr1Var4 = fr1Var3.d;
                        ho2 ho2Var2 = (ho2) fr1Var3.e;
                        sb3.append("  ");
                        sb3.append(ho2Var2);
                        sb3.append("\n");
                        fr1Var3 = fr1Var4;
                    }
                    sb3.append("\n");
                }
                printStream3.print(sb3.toString());
            }
            PrintStream printStream4 = ja0.G;
            printStream4.println("stack used: " + this.c);
            if (ja0.C) {
                printStream4.print("templates: " + this.H + "\n");
            }
            lw2 lw2Var2 = new lw2(this);
            StringBuilder sb4 = new StringBuilder("code length: ");
            int i39 = lw2Var2.b;
            sb4.append(i39);
            sb4.append('\n');
            int i40 = -1;
            for (int iC = i3; iC < i39; iC = lw2Var2.c(iC, sb4)) {
                i40++;
                sb4.append(i40 % 5 == 0 ? '\n' : c);
            }
            sb4.append("\n");
            printStream4.println(sb4.toString());
        }
        this.q &= -28673;
    }

    public final void a(lw2 lw2Var) {
        this.C = (byte[]) lw2Var.e;
        if (this.p.z) {
            this.t = xq3.n;
            this.u = xq3.o;
        } else {
            this.t = xq3.l;
            this.u = xq3.m;
        }
        hm2 hm2Var = (hm2) lw2Var.c;
        int i = hm2Var.b;
        this.E = i;
        this.F = hm2Var.c;
        if (i != Integer.MAX_VALUE) {
            this.v = i + 1;
        }
    }

    public final void b(hm2 hm2Var) {
        this.z = (hm2Var.c & 32) | this.z | (hm2Var.b & 2);
    }

    public final boolean c(boolean z) {
        int i;
        byte[] bArr = new byte[234];
        boolean z2 = ja0.r;
        int i2 = this.B;
        int i3 = z2 ? i2 : i2 - 1;
        boolean z3 = ja0.t;
        int i4 = this.r;
        k0 k0Var = this.p;
        byte[] bArr2 = this.A;
        g20[] g20VarArrE = g20.A;
        if (z3 || i2 < (i = ja0.b)) {
            if (this.C == null) {
                this.C = new byte[ja0.b];
            }
            for (int i5 = 0; i5 < ja0.b; i5++) {
                this.C[i5] = (byte) (ja0.r ? i2 + 1 : i2);
            }
            int i6 = 0;
            while (i6 < i3) {
                if (z) {
                    g20VarArrE = k0Var.e(i4, bArr2, i6, i2);
                }
                int iD = d(bArr2, i6, i2, g20VarArrE, bArr);
                if (iD == 0) {
                    return true;
                }
                for (int i7 = 0; i7 < iD; i7++) {
                    byte b = (byte) ((i3 - i6) - i7);
                    this.C[bArr2[i6 + i7] & 255] = b;
                    for (int i8 = 0; i8 < g20VarArrE.length; i8++) {
                        this.C[bArr[(i8 * 13) + i7] & 255] = b;
                    }
                }
                i6 += iD;
            }
        } else {
            if (this.D == null) {
                this.D = new int[i];
            }
            for (int i9 = 0; i9 < ja0.b; i9++) {
                this.D[i9] = ja0.r ? i2 + 1 : i2;
            }
            int i10 = 0;
            while (i10 < i3) {
                if (z) {
                    g20VarArrE = k0Var.e(i4, bArr2, i10, i2);
                }
                int iD2 = d(bArr2, i10, i2, g20VarArrE, bArr);
                if (iD2 == 0) {
                    return true;
                }
                for (int i11 = 0; i11 < iD2; i11++) {
                    int i12 = (i3 - i10) - i11;
                    this.D[bArr2[i10 + i11] & 255] = i12;
                    for (int i13 = 0; i13 < g20VarArrE.length; i13++) {
                        this.D[bArr[(i13 * 13) + i11] & 255] = i12;
                    }
                }
                i10 += iD2;
            }
        }
        return false;
    }

    public final int d(byte[] bArr, int i, int i2, g20[] g20VarArr, byte[] bArr2) {
        k0 k0Var = this.p;
        int iR = k0Var.r(i, i2, bArr);
        if (i + iR > i2) {
            iR = i2 - i;
        }
        for (int i3 = 0; i3 < g20VarArr.length; i3++) {
            g20 g20Var = g20VarArr[i3];
            int[] iArr = g20Var.f;
            if (iArr.length != 1 || g20Var.z != iR || k0Var.f(iArr[0], i3 * 13, bArr2) != iR) {
                return 0;
            }
        }
        return iR;
    }
}
