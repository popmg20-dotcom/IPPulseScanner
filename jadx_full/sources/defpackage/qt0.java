package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qt0 {
    public static final int[] g = {3808, 476, 2107, 1799};
    public final cn a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;

    public qt0(cn cnVar) {
        this.a = cnVar;
    }

    public static xk3[] b(xk3[] xk3VarArr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        xk3 xk3Var = xk3VarArr[0];
        float f2 = xk3Var.a;
        xk3 xk3Var2 = xk3VarArr[2];
        float f3 = xk3Var2.a;
        float f4 = f2 - f3;
        float f5 = xk3Var.b;
        float f6 = xk3Var2.b;
        float f7 = f5 - f6;
        float f8 = (f2 + f3) / 2.0f;
        float f9 = (f5 + f6) / 2.0f;
        float f10 = f4 * f;
        float f11 = f7 * f;
        xk3 xk3Var3 = new xk3(f8 + f10, f9 + f11);
        xk3 xk3Var4 = new xk3(f8 - f10, f9 - f11);
        xk3 xk3Var5 = xk3VarArr[1];
        float f12 = xk3Var5.a;
        xk3 xk3Var6 = xk3VarArr[3];
        float f13 = xk3Var6.a;
        float f14 = f12 - f13;
        float f15 = xk3Var5.b;
        float f16 = xk3Var6.b;
        float f17 = f15 - f16;
        float f18 = (f12 + f13) / 2.0f;
        float f19 = (f15 + f16) / 2.0f;
        float f20 = f14 * f;
        float f21 = f * f17;
        return new xk3[]{xk3Var3, new xk3(f18 + f20, f19 + f21), xk3Var4, new xk3(f18 - f20, f19 - f21)};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final wh a(boolean z) throws qs2 {
        xk3 xk3VarH;
        xk3 xk3Var;
        xk3 xk3Var2;
        xk3 xk3Var3;
        xk3 xk3VarH2;
        xk3 xk3VarH3;
        xk3 xk3Var4;
        xk3 xk3Var5;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j;
        int i8;
        hm2 hm2Var;
        cn cnVar = this.a;
        int i9 = -1;
        int i10 = 1;
        try {
            xk3[] xk3VarArrB = new lt4(cnVar).b();
            xk3Var2 = xk3VarArrB[0];
            xk3Var3 = xk3VarArrB[1];
            xk3Var = xk3VarArrB[2];
            xk3VarH = xk3VarArrB[3];
        } catch (qs2 unused) {
            int i11 = cnVar.b / 2;
            int i12 = cnVar.f / 2;
            int i13 = i11 + 7;
            int i14 = i12 - 7;
            xk3 xk3VarH4 = e(new hm2(i13, i14, 3), false, 1, -1).h();
            int i15 = i12 + 7;
            xk3 xk3VarH5 = e(new hm2(i13, i15, 3), false, 1, 1).h();
            int i16 = i11 - 7;
            xk3 xk3VarH6 = e(new hm2(i16, i15, 3), false, -1, 1).h();
            xk3VarH = e(new hm2(i16, i14, 3), false, -1, -1).h();
            xk3Var = xk3VarH6;
            xk3Var2 = xk3VarH4;
            xk3Var3 = xk3VarH5;
        }
        int iV = gb4.V((((xk3Var2.a + xk3VarH.a) + xk3Var3.a) + xk3Var.a) / 4.0f);
        int iV2 = gb4.V((((xk3Var2.b + xk3VarH.b) + xk3Var3.b) + xk3Var.b) / 4.0f);
        char c = 15;
        try {
            xk3[] xk3VarArrB2 = new lt4(cnVar, 15, iV, iV2).b();
            xk3Var5 = xk3VarArrB2[0];
            xk3Var4 = xk3VarArrB2[1];
            xk3VarH2 = xk3VarArrB2[2];
            xk3VarH3 = xk3VarArrB2[3];
        } catch (qs2 unused2) {
            int i17 = iV + 7;
            int i18 = iV2 - 7;
            xk3 xk3VarH7 = e(new hm2(i17, i18, 3), false, 1, -1).h();
            int i19 = iV2 + 7;
            xk3 xk3VarH8 = e(new hm2(i17, i19, 3), false, 1, 1).h();
            int i20 = iV - 7;
            xk3VarH2 = e(new hm2(i20, i19, 3), false, -1, 1).h();
            xk3VarH3 = e(new hm2(i20, i18, 3), false, -1, -1).h();
            xk3Var4 = xk3VarH8;
            xk3Var5 = xk3VarH7;
        }
        hm2 hm2Var2 = new hm2(gb4.V((((xk3Var5.a + xk3VarH3.a) + xk3Var4.a) + xk3VarH2.a) / 4.0f), gb4.V((((xk3Var5.b + xk3VarH3.b) + xk3Var4.b) + xk3VarH2.b) / 4.0f), 3);
        this.e = 1;
        boolean z2 = true;
        hm2 hm2Var3 = hm2Var2;
        hm2 hm2Var4 = hm2Var3;
        hm2 hm2Var5 = hm2Var4;
        while (true) {
            i = hm2Var5.c;
            i2 = hm2Var5.b;
            char c2 = c;
            i3 = hm2Var2.c;
            i4 = hm2Var2.b;
            if (this.e >= 9) {
                i5 = i10;
                break;
            }
            hm2 hm2VarE = e(hm2Var2, z2, i10, i9);
            int i21 = hm2VarE.c;
            int i22 = hm2VarE.b;
            hm2 hm2VarE2 = e(hm2Var3, z2, i10, i10);
            hm2 hm2VarE3 = e(hm2Var4, z2, i9, i10);
            hm2 hm2VarE4 = e(hm2Var5, z2, i9, i9);
            int i23 = hm2VarE4.c;
            i5 = i10;
            int i24 = hm2VarE4.b;
            boolean z3 = z2;
            if (this.e > 2) {
                double dG = (gb4.G(i24, i23, i22, i21) * this.e) / (gb4.G(i2, i, i4, i3) * (this.e + 2));
                if (dG < 0.75d || dG > 1.25d) {
                    break;
                }
                hm2 hm2Var6 = new hm2(Math.max(0, i22 - 3), Math.min(cnVar.f - 1, i21 + 3), 3);
                hm2 hm2Var7 = new hm2(Math.max(0, hm2VarE2.b - 3), Math.max(0, hm2VarE2.c - 3), 3);
                hm2Var = hm2VarE2;
                hm2 hm2Var8 = new hm2(Math.min(cnVar.b - 1, hm2VarE3.b + 3), Math.max(0, Math.min(cnVar.f - 1, hm2VarE3.c - 3)), 3);
                hm2 hm2Var9 = new hm2(Math.min(cnVar.b - 1, i24 + 3), Math.min(cnVar.f - 1, i23 + 3), 3);
                int iC = c(hm2Var9, hm2Var6);
                if (iC == 0 || c(hm2Var6, hm2Var7) != iC || c(hm2Var7, hm2Var8) != iC || c(hm2Var8, hm2Var9) != iC) {
                    break;
                }
            } else {
                hm2Var = hm2VarE2;
            }
            z2 = !z3;
            this.e++;
            hm2Var4 = hm2VarE3;
            c = c2;
            hm2Var2 = hm2VarE;
            i10 = i5;
            hm2Var5 = hm2VarE4;
            hm2Var3 = hm2Var;
            i9 = -1;
        }
        int i25 = this.e;
        if (i25 != 5 && i25 != 7) {
            throw qs2.a();
        }
        this.b = i25 == 5 ? i5 : 0;
        xk3 xk3Var6 = new xk3(i4 + 0.5f, i3 - 0.5f);
        xk3 xk3Var7 = new xk3(hm2Var3.b + 0.5f, hm2Var3.c + 0.5f);
        xk3 xk3Var8 = new xk3(hm2Var4.b - 0.5f, hm2Var4.c + 0.5f);
        xk3 xk3Var9 = new xk3(i2 - 0.5f, i - 0.5f);
        xk3[] xk3VarArr = new xk3[4];
        xk3VarArr[0] = xk3Var6;
        xk3VarArr[i5] = xk3Var7;
        xk3VarArr[2] = xk3Var8;
        xk3VarArr[3] = xk3Var9;
        int i26 = i25 * 2;
        xk3[] xk3VarArrB3 = b(xk3VarArr, i26 - 3, i26);
        if (z) {
            xk3 xk3Var10 = xk3VarArrB3[0];
            xk3VarArrB3[0] = xk3VarArrB3[2];
            xk3VarArrB3[2] = xk3Var10;
        }
        if (!g(xk3VarArrB3[0]) || !g(xk3VarArrB3[i5]) || !g(xk3VarArrB3[2]) || !g(xk3VarArrB3[3])) {
            throw qs2.a();
        }
        int i27 = this.e * 2;
        int[] iArr = {h(xk3VarArrB3[0], xk3VarArrB3[i5], i27), h(xk3VarArrB3[i5], xk3VarArrB3[2], i27), h(xk3VarArrB3[2], xk3VarArrB3[3], i27), h(xk3VarArrB3[3], xk3VarArrB3[0], i27)};
        int i28 = 0;
        for (int i29 = 0; i29 < 4; i29++) {
            int i30 = iArr[i29];
            i28 = (i28 << 3) + ((i30 >> (i27 - 2)) << 1) + (i30 & 1);
        }
        int i31 = ((i28 & 1) << 11) + (i28 >> 1);
        for (int i32 = 0; i32 < 4; i32++) {
            if (Integer.bitCount(g[i32] ^ i31) <= 2) {
                this.f = i32;
                long j2 = 0;
                int i33 = 0;
                while (true) {
                    i6 = 10;
                    if (i33 >= 4) {
                        break;
                    }
                    int i34 = iArr[(this.f + i33) % 4];
                    if (this.b) {
                        j = j2 << 7;
                        i8 = (i34 >> 1) & 127;
                    } else {
                        j = j2 << 10;
                        i8 = ((i34 >> 2) & 992) + ((i34 >> 1) & 31);
                    }
                    j2 = j + ((long) i8);
                    i33++;
                }
                if (this.b) {
                    i6 = 7;
                    i7 = 2;
                } else {
                    i7 = 4;
                }
                int i35 = i6 - i7;
                int[] iArr2 = new int[i6];
                for (int i36 = i6 - 1; i36 >= 0; i36--) {
                    iArr2[i36] = ((int) j2) & 15;
                    j2 >>= 4;
                }
                try {
                    int iW = new ha1(21, ho1.k).w(iArr2, i35);
                    int i37 = 0;
                    for (int i38 = 0; i38 < i7; i38++) {
                        i37 = (i37 << 4) + iArr2[i38];
                    }
                    if (this.b) {
                        this.c = (i37 >> 6) + 1;
                        this.d = (i37 & 63) + 1;
                    } else {
                        this.c = (i37 >> 11) + 1;
                        this.d = (i37 & 2047) + 1;
                    }
                    int i39 = this.f;
                    xk3 xk3Var11 = xk3VarArrB3[i39 % 4];
                    xk3 xk3Var12 = xk3VarArrB3[(i39 + 1) % 4];
                    xk3 xk3Var13 = xk3VarArrB3[(i39 + 2) % 4];
                    xk3 xk3Var14 = xk3VarArrB3[(i39 + 3) % 4];
                    int iD = d();
                    float f = iD / 2.0f;
                    float f2 = this.e;
                    float f3 = f - f2;
                    float f4 = f + f2;
                    return new wh(yr2.i0(cnVar, iD, iD, d13.a(f3, f3, f4, f3, f4, f4, f3, f4, xk3Var11.a, xk3Var11.b, xk3Var12.a, xk3Var12.b, xk3Var13.a, xk3Var13.b, xk3Var14.a, xk3Var14.b)), b(xk3VarArrB3, this.e * 2, d()), this.b, this.d, this.c, iW);
                } catch (wg3 unused3) {
                    throw qs2.a();
                }
            }
        }
        throw qs2.a();
    }

    public final int c(hm2 hm2Var, hm2 hm2Var2) {
        int i = hm2Var.b;
        int i2 = hm2Var.c;
        float fG = gb4.G(i, i2, hm2Var2.b, hm2Var2.c);
        if (fG != 0.0f) {
            float f = (r1 - i) / fG;
            float f2 = (r12 - i2) / fG;
            float f3 = i;
            float f4 = i2;
            cn cnVar = this.a;
            boolean zB = cnVar.b(i, i2);
            int iFloor = (int) Math.floor(fG);
            int i3 = 0;
            for (int i4 = 0; i4 < iFloor; i4++) {
                if (cnVar.b(gb4.V(f3), gb4.V(f4)) != zB) {
                    i3++;
                }
                f3 += f;
                f4 += f2;
            }
            float f5 = i3 / fG;
            if (f5 <= 0.1f || f5 >= 0.9f) {
                return (f5 <= 0.1f) == zB ? 1 : -1;
            }
        }
        return 0;
    }

    public final int d() {
        boolean z = this.b;
        int i = this.c;
        if (z) {
            return (i * 4) + 11;
        }
        return ((((i * 2) + 6) / 15) * 2) + (i * 4) + 15;
    }

    public final hm2 e(hm2 hm2Var, boolean z, int i, int i2) {
        cn cnVar;
        int i3 = hm2Var.b + i;
        int i4 = hm2Var.c;
        while (true) {
            i4 += i2;
            boolean zF = f(i3, i4);
            cnVar = this.a;
            if (!zF || cnVar.b(i3, i4) != z) {
                break;
            }
            i3 += i;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        while (f(i5, i6) && cnVar.b(i5, i6) == z) {
            i5 += i;
        }
        int i7 = i5 - i;
        while (f(i7, i6) && cnVar.b(i7, i6) == z) {
            i6 += i2;
        }
        return new hm2(i7, i6 - i2, 3);
    }

    public final boolean f(int i, int i2) {
        if (i < 0) {
            return false;
        }
        cn cnVar = this.a;
        return i < cnVar.b && i2 >= 0 && i2 < cnVar.f;
    }

    public final boolean g(xk3 xk3Var) {
        return f(gb4.V(xk3Var.a), gb4.V(xk3Var.b));
    }

    public final int h(xk3 xk3Var, xk3 xk3Var2, int i) {
        float f = xk3Var.a;
        float f2 = xk3Var.b;
        float f3 = xk3Var2.a;
        float f4 = xk3Var2.b;
        float F = gb4.F(f, f2, f3, f4);
        float f5 = F / i;
        float f6 = xk3Var.a;
        float f7 = ((xk3Var2.a - f6) * f5) / F;
        float f8 = ((f4 - f2) * f5) / F;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f9 = i3;
            if (this.a.b(gb4.V((f9 * f7) + f6), gb4.V((f9 * f8) + f2))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }
}
