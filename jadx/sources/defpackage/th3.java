package defpackage;

import java.nio.charset.Charset;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public th3(int r20, int r21, defpackage.k0 r22, byte[] r23) {
        /*
            Method dump skipped, instruction units count: 1614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.th3.<init>(int, int, k0, byte[]):void");
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
