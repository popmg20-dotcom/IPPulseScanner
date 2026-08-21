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
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.g20 e(defpackage.g20 r10, defpackage.g20 r11, defpackage.up3 r12, boolean r13, boolean r14) {
        /*
            r0 = 0
            if (r10 != 0) goto Ld
            if (r13 == 0) goto Lc
            if (r11 == 0) goto Lc
            g20 r10 = r11.f()
            return r10
        Lc:
            return r0
        Ld:
            if (r11 != 0) goto L17
            if (r14 == 0) goto L16
            g20 r10 = r10.f()
            return r10
        L16:
            return r0
        L17:
            if (r13 == 0) goto L1d
            r9 = r11
            r11 = r10
            r10 = r9
            goto L20
        L1d:
            r9 = r14
            r14 = r13
            r13 = r9
        L20:
            int[] r10 = r10.f
            r1 = 0
            r2 = r10[r1]
            int[] r11 = r11.f
            r3 = r11[r1]
            r4 = 1
            if (r13 != 0) goto L5f
            if (r14 != 0) goto L5f
            r13 = r1
        L2f:
            if (r13 >= r2) goto L5e
            int r14 = r13 * 2
            int r5 = r14 + 1
            r5 = r10[r5]
            int r14 = r14 + 2
            r14 = r10[r14]
            r6 = r1
        L3c:
            if (r6 >= r3) goto L5b
            int r7 = r6 * 2
            int r8 = r7 + 1
            r8 = r11[r8]
            int r7 = r7 + 2
            r7 = r11[r7]
            if (r8 <= r14) goto L4b
            goto L5b
        L4b:
            if (r7 >= r5) goto L4e
            goto L58
        L4e:
            if (r5 <= r8) goto L51
            r8 = r5
        L51:
            if (r14 >= r7) goto L54
            r7 = r14
        L54:
            g20 r0 = d(r0, r12, r8, r7, r4)
        L58:
            int r6 = r6 + 1
            goto L3c
        L5b:
            int r13 = r13 + 1
            goto L2f
        L5e:
            return r0
        L5f:
            if (r14 != 0) goto La4
            r13 = r1
        L62:
            if (r13 >= r2) goto La4
            int r14 = r13 * 2
            int r5 = r14 + 1
            r5 = r10[r5]
            int r14 = r14 + 2
            r14 = r10[r14]
            r6 = r1
        L6f:
            if (r6 >= r3) goto L9a
            int r7 = r6 * 2
            int r8 = r7 + 1
            r8 = r11[r8]
            int r7 = r7 + 2
            r7 = r11[r7]
            if (r8 >= r5) goto L83
            if (r7 >= r5) goto L80
            goto L97
        L80:
            int r5 = r7 + 1
            goto L94
        L83:
            if (r8 > r14) goto L93
            if (r7 >= r14) goto L90
            int r8 = r8 + (-1)
            if (r5 > r8) goto L80
            g20 r0 = d(r0, r12, r5, r8, r4)
            goto L80
        L90:
            int r14 = r8 + (-1)
            goto L94
        L93:
            r5 = r8
        L94:
            if (r5 <= r14) goto L97
            goto L9a
        L97:
            int r6 = r6 + 1
            goto L6f
        L9a:
            if (r5 > r14) goto La1
            g20 r14 = d(r0, r12, r5, r14, r4)
            r0 = r14
        La1:
            int r13 = r13 + 1
            goto L62
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g20.e(g20, g20, up3, boolean, boolean):g20");
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
