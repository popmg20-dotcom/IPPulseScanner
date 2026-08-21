package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lt4 {
    public final cn a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public lt4(cn cnVar, int i, int i2, int i3) throws qs2 {
        this.a = cnVar;
        int i4 = cnVar.f;
        this.b = i4;
        int i5 = cnVar.b;
        this.c = i5;
        int i6 = i / 2;
        int i7 = i2 - i6;
        this.d = i7;
        int i8 = i2 + i6;
        this.e = i8;
        int i9 = i3 - i6;
        this.g = i9;
        int i10 = i3 + i6;
        this.f = i10;
        if (i9 < 0 || i7 < 0 || i10 >= i4 || i8 >= i5) {
            throw qs2.a();
        }
    }

    public final boolean a(int i, int i2, int i3, boolean z) {
        cn cnVar = this.a;
        if (z) {
            while (i <= i2) {
                if (cnVar.b(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (cnVar.b(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public final xk3[] b() throws qs2 {
        int i;
        boolean z;
        int i2;
        int i3 = this.d;
        int i4 = this.e;
        int i5 = this.g;
        int i6 = this.f;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = true;
        do {
            i = this.c;
            if (!z6) {
                z = false;
                break;
            }
            boolean z7 = false;
            boolean zA = true;
            while (true) {
                if ((!zA && z2) || i4 >= i) {
                    break;
                }
                zA = a(i5, i6, i4, false);
                if (zA) {
                    i4++;
                    z2 = true;
                    z7 = true;
                } else if (!z2) {
                    i4++;
                }
            }
            if (i4 >= i) {
                break;
            }
            boolean zA2 = true;
            while (true) {
                i2 = this.b;
                if ((!zA2 && z3) || i6 >= i2) {
                    break;
                }
                zA2 = a(i3, i4, i6, true);
                if (zA2) {
                    i6++;
                    z3 = true;
                    z7 = true;
                } else if (!z3) {
                    i6++;
                }
            }
            if (i6 >= i2) {
                break;
            }
            boolean zA3 = true;
            while (true) {
                if ((!zA3 && z4) || i3 < 0) {
                    break;
                }
                zA3 = a(i5, i6, i3, false);
                if (zA3) {
                    i3--;
                    z4 = true;
                    z7 = true;
                } else if (!z4) {
                    i3--;
                }
            }
            if (i3 < 0) {
                break;
            }
            z6 = z7;
            boolean zA4 = true;
            while (true) {
                if ((!zA4 && z5) || i5 < 0) {
                    break;
                }
                zA4 = a(i3, i4, i5, true);
                if (zA4) {
                    i5--;
                    z6 = true;
                    z5 = true;
                } else if (!z5) {
                    i5--;
                }
            }
        } while (i5 >= 0);
        z = true;
        if (z) {
            throw qs2.a();
        }
        int i7 = i4 - i3;
        xk3 xk3VarC = null;
        xk3 xk3VarC2 = null;
        for (int i8 = 1; xk3VarC2 == null && i8 < i7; i8++) {
            xk3VarC2 = c(i3, i6 - i8, i3 + i8, i6);
        }
        if (xk3VarC2 == null) {
            throw qs2.a();
        }
        xk3 xk3VarC3 = null;
        for (int i9 = 1; xk3VarC3 == null && i9 < i7; i9++) {
            xk3VarC3 = c(i3, i5 + i9, i3 + i9, i5);
        }
        if (xk3VarC3 == null) {
            throw qs2.a();
        }
        xk3 xk3VarC4 = null;
        for (int i10 = 1; xk3VarC4 == null && i10 < i7; i10++) {
            xk3VarC4 = c(i4, i5 + i10, i4 - i10, i5);
        }
        if (xk3VarC4 == null) {
            throw qs2.a();
        }
        for (int i11 = 1; xk3VarC == null && i11 < i7; i11++) {
            xk3VarC = c(i4, i6 - i11, i4 - i11, i6);
        }
        if (xk3VarC == null) {
            throw qs2.a();
        }
        float f = xk3VarC.a;
        float f2 = xk3VarC.b;
        float f3 = xk3VarC2.a;
        float f4 = xk3VarC2.b;
        float f5 = xk3VarC4.a;
        float f6 = xk3VarC4.b;
        float f7 = xk3VarC3.a;
        float f8 = xk3VarC3.b;
        return f < ((float) i) / 2.0f ? new xk3[]{new xk3(f7 - 1.0f, f8 + 1.0f), new xk3(f3 + 1.0f, f4 + 1.0f), new xk3(f5 - 1.0f, f6 - 1.0f), new xk3(f + 1.0f, f2 - 1.0f)} : new xk3[]{new xk3(f7 + 1.0f, f8 + 1.0f), new xk3(f3 + 1.0f, f4 - 1.0f), new xk3(f5 - 1.0f, f6 + 1.0f), new xk3(f - 1.0f, f2 - 1.0f)};
    }

    public final xk3 c(float f, float f2, float f3, float f4) {
        int iV = gb4.V(gb4.F(f, f2, f3, f4));
        float f5 = iV;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < iV; i++) {
            float f8 = i;
            int iV2 = gb4.V((f8 * f6) + f);
            int iV3 = gb4.V((f8 * f7) + f2);
            if (this.a.b(iV2, iV3)) {
                return new xk3(iV2, iV3);
            }
        }
        return null;
    }

    public lt4(cn cnVar) {
        this(cnVar, 10, cnVar.b / 2, cnVar.f / 2);
    }
}
