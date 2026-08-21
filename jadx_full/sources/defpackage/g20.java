package defpackage;

import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class g20 implements uv2 {
    public static final g20[] A = new g20[0];
    public final /* synthetic */ int b = 1;
    public int[] f;
    public int z;

    public g20(int[] iArr, boolean z) {
        this.z = -1;
        this.f = iArr;
        if (z) {
            this.z = iArr[iArr.length - 1];
        }
    }

    public static g20 d(g20 g20Var, up3 up3Var, int i, int i2, boolean z) {
        int i3;
        if (i > i2) {
            i2 = i;
            i = i2;
        }
        if (g20Var == null) {
            g20Var = new g20();
            g20Var.f = new int[5];
            g20Var.l(0, 0);
            i3 = 0;
        } else {
            i3 = g20Var.f[0];
        }
        int[] iArr = g20Var.f;
        int i4 = i == 0 ? 0 : i3;
        int i5 = 0;
        while (i5 < i4) {
            int i6 = (i5 + i4) >>> 1;
            if (i - 1 > iArr[(i6 * 2) + 2]) {
                i5 = i6 + 1;
            } else {
                i4 = i6;
            }
        }
        int i7 = i2 == Integer.MAX_VALUE ? i3 : i5;
        int i8 = i3;
        while (i7 < i8) {
            int i9 = (i7 + i8) >>> 1;
            if (i2 + 1 >= iArr[(i9 * 2) + 1]) {
                i7 = i9 + 1;
            } else {
                i8 = i9;
            }
        }
        int i10 = i5 + 1;
        int i11 = i10 - i7;
        int i12 = i3 + i11;
        if (i12 > ja0.x) {
            throw new go4("too many multibyte code ranges are specified");
        }
        if (i11 != 1) {
            if (z) {
                int i13 = i5 * 2;
                int i14 = i13 + 1;
                int i15 = iArr[i13 + 2];
                if (i <= i15 && (iArr[i14] <= i || i15 <= i2)) {
                    up3Var.b();
                }
            }
            int i16 = iArr[(i5 * 2) + 1];
            if (i > i16) {
                i = i16;
            }
            int i17 = iArr[((i7 - 1) * 2) + 2];
            if (i2 < i17) {
                i2 = i17;
            }
        }
        if (i11 != 0) {
            int i18 = (i7 * 2) + 1;
            int i19 = (i10 * 2) + 1;
            if (i11 <= 0) {
                int[] iArr2 = g20Var.f;
                System.arraycopy(iArr2, i18, iArr2, i19, g20Var.z - i18);
                g20Var.z -= i18 - i19;
            } else if (i7 < i3) {
                int i20 = (i3 - i7) * 2;
                int i21 = i19 + i20;
                int[] iArr3 = g20Var.f;
                if (i21 > iArr3.length) {
                    int length = iArr3.length;
                    do {
                        length <<= 1;
                    } while (length < i21);
                    iArr3 = new int[length];
                    System.arraycopy(g20Var.f, 0, iArr3, 0, g20Var.z);
                    g20Var.f = iArr3;
                }
                System.arraycopy(iArr3, i18, iArr3, i19, i20);
                if (i21 > g20Var.z) {
                    g20Var.z = i21;
                }
            }
        }
        int i22 = i5 * 2;
        g20Var.l(i22 + 1, i);
        g20Var.l(i22 + 2, i2);
        g20Var.l(0, i12);
        return g20Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x009a A[EDGE_INSN: B:70:0x009a->B:57:0x009a BREAK  A[LOOP:3: B:41:0x006f->B:56:0x0097], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0097 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static g20 e(g20 g20Var, g20 g20Var2, up3 up3Var, boolean z, boolean z2) {
        g20 g20VarD = null;
        if (g20Var == null) {
            if (!z || g20Var2 == null) {
                return null;
            }
            return g20Var2.f();
        }
        if (g20Var2 == null) {
            if (z2) {
                return g20Var.f();
            }
            return null;
        }
        if (z) {
            g20Var2 = g20Var;
            g20Var = g20Var2;
        } else {
            z2 = z;
            z = z2;
        }
        int[] iArr = g20Var.f;
        int i = iArr[0];
        int[] iArr2 = g20Var2.f;
        int i2 = iArr2[0];
        if (!z && !z2) {
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * 2;
                int i5 = iArr[i4 + 1];
                int i6 = iArr[i4 + 2];
                for (int i7 = 0; i7 < i2; i7++) {
                    int i8 = i7 * 2;
                    int i9 = iArr2[i8 + 1];
                    int i10 = iArr2[i8 + 2];
                    if (i9 > i6) {
                        break;
                    }
                    if (i10 >= i5) {
                        if (i5 > i9) {
                            i9 = i5;
                        }
                        if (i6 < i10) {
                            i10 = i6;
                        }
                        g20VarD = d(g20VarD, up3Var, i9, i10, true);
                    }
                }
            }
            return g20VarD;
        }
        if (!z2) {
            for (int i11 = 0; i11 < i; i11++) {
                int i12 = i11 * 2;
                int i13 = iArr[i12 + 1];
                int i14 = iArr[i12 + 2];
                for (int i15 = 0; i15 < i2; i15++) {
                    int i16 = i15 * 2;
                    int i17 = iArr2[i16 + 1];
                    int i18 = iArr2[i16 + 2];
                    if (i17 >= i13) {
                        if (i17 > i14) {
                            i13 = i17;
                        } else if (i18 < i14) {
                            int i19 = i17 - 1;
                            if (i13 <= i19) {
                                g20VarD = d(g20VarD, up3Var, i13, i19, true);
                            }
                        } else {
                            i14 = i17 - 1;
                        }
                        if (i13 <= i14) {
                            break;
                        }
                    } else if (i18 < i13) {
                        continue;
                    }
                    i13 = i18 + 1;
                    if (i13 <= i14) {
                    }
                }
                if (i13 <= i14) {
                    g20VarD = d(g20VarD, up3Var, i13, i14, true);
                }
            }
        }
        return g20VarD;
    }

    public static g20 g(int i, int i2) {
        return new g20(new int[]{i2}, i);
    }

    public static g20 h(int i, int i2, int i3) {
        return new g20(new int[]{i2, i3}, i);
    }

    public static g20 i(up3 up3Var, g20 g20Var) {
        g20 g20VarD = null;
        if (g20Var == null) {
            return k(up3Var, null);
        }
        int[] iArr = g20Var.f;
        int i = iArr[0];
        if (i <= 0) {
            return k(up3Var, null);
        }
        int i2 = up3Var.c.b > 1 ? 0 : 128;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i4 * 2;
            int i6 = iArr[i5 + 1];
            i3 = iArr[i5 + 2];
            int i7 = i6 - 1;
            if (i2 <= i7) {
                g20VarD = d(g20VarD, up3Var, i2, i7, true);
            }
            if (i3 == Integer.MAX_VALUE) {
                break;
            }
            i2 = i3 + 1;
        }
        return i3 < Integer.MAX_VALUE ? d(g20VarD, up3Var, i3 + 1, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, true) : g20VarD;
    }

    public static g20 j(g20 g20Var, g20 g20Var2, up3 up3Var, boolean z, boolean z2) {
        g20 g20VarI = null;
        if (g20Var == null && g20Var2 == null) {
            if (z || z2) {
                return k(up3Var, null);
            }
            return null;
        }
        if (g20Var2 == null) {
            g20Var2 = g20Var;
            g20Var = g20Var2;
            z2 = z;
            z = z2;
        }
        if (g20Var == null) {
            return z ? k(up3Var, null) : !z2 ? g20Var2.f() : i(up3Var, g20Var2);
        }
        if (!z) {
            g20 g20Var3 = g20Var2;
            g20Var2 = g20Var;
            g20Var = g20Var3;
            boolean z3 = z2;
            z2 = z;
            z = z3;
        }
        if (!z && !z2) {
            g20VarI = g20Var.f();
        } else if (!z2) {
            g20VarI = i(up3Var, g20Var);
        }
        int[] iArr = g20Var2.f;
        int i = iArr[0];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            g20VarI = d(g20VarI, up3Var, iArr[i3 + 1], iArr[i3 + 2], true);
        }
        return g20VarI;
    }

    public static g20 k(up3 up3Var, g20 g20Var) {
        return d(g20Var, up3Var, up3Var.c.b > 1 ? 0 : 128, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, true);
    }

    @Override // defpackage.uv2
    public int a(int i) {
        int[] iArr = this.f;
        int i2 = i * 2;
        return Math.max(0, iArr[i2 + 1] - iArr[i2]);
    }

    @Override // defpackage.uv2
    public int b() {
        return this.z;
    }

    @Override // defpackage.uv2
    public int c(int i) {
        return Math.max(0, this.f[i * 2]);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        switch (this.b) {
            case 1:
                return f();
            default:
                return super.clone();
        }
    }

    @Override // defpackage.uv2
    public int count() {
        return this.f.length / 2;
    }

    public g20 f() {
        g20 g20Var = new g20();
        int length = this.f.length;
        int[] iArr = new int[length];
        g20Var.f = iArr;
        System.arraycopy(this.f, 0, iArr, 0, length);
        g20Var.z = this.z;
        return g20Var;
    }

    public void l(int i, int i2) {
        int i3 = i + 1;
        int[] iArr = this.f;
        if (iArr.length < i3) {
            int length = iArr.length;
            do {
                length <<= 1;
            } while (length < i3);
            iArr = new int[length];
            System.arraycopy(this.f, 0, iArr, 0, this.z);
            this.f = iArr;
        }
        iArr[i] = i2;
        if (this.z < i3) {
            this.z = i3;
        }
    }

    public String toString() {
        switch (this.b) {
            case 1:
                StringBuilder sb = new StringBuilder("CodeRange");
                sb.append("\n  used: " + this.z);
                sb.append(", size: " + this.f[0]);
                sb.append("\n  ranges: ");
                for (int i = 0; i < this.f[0]; i++) {
                    StringBuilder sb2 = new StringBuilder("[");
                    int i2 = i * 2;
                    sb2.append("0x" + Integer.toString(this.f[i2 + 1], 16));
                    sb2.append("..");
                    sb2.append("0x" + Integer.toString(this.f[i2 + 2], 16));
                    sb2.append("]");
                    sb.append(sb2.toString());
                    if (i > 0 && i % 6 == 0) {
                        sb.append("\n          ");
                    }
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ g20() {
    }

    public g20(int[] iArr, int i) {
        this.z = i;
        this.f = iArr;
    }
}
