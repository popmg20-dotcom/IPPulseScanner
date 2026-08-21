package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.dns.DnsRecord;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class fu extends es2 {
    public int a;
    public final dn b;
    public g20 c;

    public fu() {
        super(1);
        this.b = new dn();
    }

    public final void a(up3 up3Var) {
        g20 g20VarK = this.c;
        if (!up3Var.c.z) {
            g20VarK = g20.k(up3Var, g20VarK);
        }
        this.c = g20VarK;
    }

    public final void b(int i, boolean z, boolean z2, up3 up3Var, b7 b7Var) {
        k0 k0Var = up3Var.c;
        int[] iArrH = k0Var.h(i, b7Var);
        int i2 = 0;
        if (iArrH != null) {
            if (!z2) {
                c(z, up3Var, b7Var.b, iArrH);
                return;
            }
            fu fuVar = new fu();
            fuVar.c(z, up3Var, b7Var.b, iArrH);
            if (z) {
                fuVar.e(up3Var, 128, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, false);
            } else {
                fu fuVar2 = new fu();
                if (k0Var.b > 1) {
                    fuVar2.e(up3Var, 0, 127, true);
                } else {
                    fuVar2.b.i(up3Var, 0, 127);
                }
                fuVar.f(fuVar2, up3Var);
            }
            k(fuVar, up3Var);
            return;
        }
        int i3 = z2 ? 128 : 256;
        dn dnVar = this.b;
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 8:
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
            case 10:
            case 11:
            case 13:
            case 14:
                if (!z) {
                    while (i2 < 256) {
                        if (k0Var.j(i2, i)) {
                            dnVar.h(up3Var, i2);
                        }
                        i2++;
                    }
                    return;
                }
                while (i2 < 256) {
                    if (!k0Var.j(i2, i)) {
                        dnVar.h(up3Var, i2);
                    }
                    i2++;
                }
                a(up3Var);
                return;
            case 5:
            case 7:
                if (!z) {
                    while (i2 < i3) {
                        if (k0Var.j(i2, i)) {
                            dnVar.h(up3Var, i2);
                        }
                        i2++;
                    }
                    if (z2) {
                        return;
                    }
                    a(up3Var);
                    return;
                }
                while (i2 < 256) {
                    if (!k0Var.j(i2, i) || i2 >= i3) {
                        dnVar.h(up3Var, i2);
                    }
                    i2++;
                }
                if (z2) {
                    a(up3Var);
                    return;
                }
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                if (!z) {
                    while (i2 < i3) {
                        if (k0Var.o(i2)) {
                            dnVar.h(up3Var, i2);
                        }
                        i2++;
                    }
                    if (z2) {
                        return;
                    }
                    a(up3Var);
                    return;
                }
                while (i2 < 256) {
                    if (k0Var.g(i2) > 0 && !k0Var.j(i2, 12) && i2 < i3) {
                        dnVar.h(up3Var, i2);
                    }
                    i2++;
                }
                if (z2) {
                    a(up3Var);
                    return;
                }
                return;
            default:
                throw new l12("internal parser error (bug)");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
    
        r4 = r12[r6 + 2] + 1;
        r9 = r9 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(boolean r9, defpackage.up3 r10, int r11, int[] r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = r12[r0]
            dn r2 = r8.b
            r3 = 1
            if (r9 != 0) goto L4c
        L8:
            if (r0 >= r1) goto L3a
            int r9 = r0 * 2
            int r4 = r9 + 1
            r5 = r12[r4]
        L10:
            int r6 = r9 + 2
            r6 = r12[r6]
            if (r5 > r6) goto L37
            if (r5 < r11) goto L31
            r9 = r12[r4]
            if (r5 <= r9) goto L21
            r8.e(r10, r5, r6, r3)
        L1f:
            int r0 = r0 + 1
        L21:
            if (r0 >= r1) goto Lae
            int r9 = r0 * 2
            int r11 = r9 + 1
            r11 = r12[r11]
            int r9 = r9 + 2
            r9 = r12[r9]
            r8.e(r10, r11, r9, r3)
            goto L1f
        L31:
            r2.h(r10, r5)
            int r5 = r5 + 1
            goto L10
        L37:
            int r0 = r0 + 1
            goto L8
        L3a:
            if (r0 >= r1) goto Lae
            int r9 = r0 * 2
            int r11 = r9 + 1
            r11 = r12[r11]
            int r9 = r9 + 2
            r9 = r12[r9]
            r8.e(r10, r11, r9, r3)
            int r0 = r0 + 1
            goto L3a
        L4c:
            r9 = r0
            r4 = r9
        L4e:
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r9 >= r1) goto L89
        L53:
            int r6 = r9 * 2
            int r7 = r6 + 1
            r7 = r12[r7]
            if (r4 >= r7) goto L81
            if (r4 < r11) goto L7b
        L5d:
            if (r0 >= r1) goto L75
            int r9 = r0 * 2
            int r2 = r9 + 1
            r2 = r12[r2]
            if (r11 >= r2) goto L6c
            int r2 = r2 + (-1)
            r8.e(r10, r11, r2, r3)
        L6c:
            int r9 = r9 + 2
            r9 = r12[r9]
            int r11 = r9 + 1
            int r0 = r0 + 1
            goto L5d
        L75:
            if (r11 >= r5) goto Lae
            r8.e(r10, r11, r5, r3)
            return
        L7b:
            r2.h(r10, r4)
            int r4 = r4 + 1
            goto L53
        L81:
            int r6 = r6 + 2
            r4 = r12[r6]
            int r4 = r4 + r3
            int r9 = r9 + 1
            goto L4e
        L89:
            if (r4 >= r11) goto L91
            r2.h(r10, r4)
            int r4 = r4 + 1
            goto L89
        L91:
            if (r0 >= r1) goto La9
            int r9 = r0 * 2
            int r2 = r9 + 1
            r2 = r12[r2]
            if (r11 >= r2) goto La0
            int r2 = r2 + (-1)
            r8.e(r10, r11, r2, r3)
        La0:
            int r9 = r9 + 2
            r9 = r12[r9]
            int r11 = r9 + 1
            int r0 = r0 + 1
            goto L91
        La9:
            if (r11 >= r5) goto Lae
            r8.e(r10, r11, r5, r3)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fu.c(boolean, up3, int, int[]):void");
    }

    public final void d(up3 up3Var, int i, int i2, boolean z) {
        g20 g20VarD = this.c;
        if (i > i2) {
            up3Var.getClass();
            if (!((4194304 & (-2019556389)) != 0)) {
                throw new go4("empty range in char class");
            }
        } else {
            g20VarD = g20.d(g20VarD, up3Var, i, i2, z);
        }
        this.c = g20VarD;
    }

    public final void e(up3 up3Var, int i, int i2, boolean z) {
        this.c = g20.d(this.c, up3Var, i, i2, z);
    }

    public final void f(fu fuVar, up3 up3Var) {
        dn dnVar;
        g20 g20VarE;
        boolean zH = h();
        g20 g20Var = this.c;
        boolean zH2 = fuVar.h();
        dn dnVar2 = fuVar.b;
        g20 g20Var2 = fuVar.c;
        dn dnVar3 = this.b;
        if (zH) {
            dnVar = new dn();
            dnVar3.d(dnVar);
        } else {
            dnVar = dnVar3;
        }
        int[] iArr = dnVar.a;
        if (zH2) {
            dn dnVar4 = new dn();
            dnVar2.d(dnVar4);
            dnVar2 = dnVar4;
        }
        for (int i = 0; i < 8; i++) {
            iArr[i] = iArr[i] & dnVar2.a[i];
        }
        if (dnVar != dnVar3) {
            for (int i2 = 0; i2 < 8; i2++) {
                dnVar3.a[i2] = iArr[i2];
            }
        }
        if (zH) {
            dnVar3.c();
        }
        if (up3Var.c.z) {
            return;
        }
        if (zH && zH2) {
            g20VarE = g20.j(g20Var, g20Var2, up3Var, false, false);
        } else {
            g20VarE = g20.e(g20Var, g20Var2, up3Var, zH, zH2);
            if (zH) {
                g20VarE = g20.i(up3Var, g20VarE);
            }
        }
        this.c = g20VarE;
    }

    public final boolean g(int i, k0 k0Var) {
        boolean zI;
        if ((k0Var.b > 1 ? 2 : k0Var.g(i)) > 1 || i >= 256) {
            g20 g20Var = this.c;
            zI = g20Var == null ? false : r25.I(0, i, g20Var.f);
        } else {
            zI = this.b.a(i);
        }
        return h() ? !zI : zI;
    }

    @Override // defpackage.es2
    public final String getName() {
        return "Character Class";
    }

    public final boolean h() {
        return (this.a & 1) != 0;
    }

    public final void i(tj tjVar, fu fuVar, up3 up3Var) {
        int i;
        int i2 = tjVar.f;
        if (i2 == 2) {
            throw new s84("char-class value at end of range");
        }
        if (i2 == 1 && (i = tjVar.e) != 3) {
            if (i == 1) {
                this.b.h(up3Var, tjVar.b);
                if (fuVar != null) {
                    fuVar.b.g(tjVar.b);
                }
            } else if (i == 2) {
                int i3 = tjVar.b;
                d(up3Var, i3, i3, true);
                if (fuVar != null) {
                    int i4 = tjVar.b;
                    fuVar.d(up3Var, i4, i4, false);
                }
            }
        }
        tjVar.f = 1;
        tjVar.e = 3;
    }

    public final void j(tj tjVar, fu fuVar, up3 up3Var) {
        int i;
        int iG = fw.G(tjVar.f);
        dn dnVar = this.b;
        if (iG == 0) {
            int i2 = tjVar.e;
            if (i2 == 1) {
                dnVar.h(up3Var, tjVar.b);
                if (fuVar != null) {
                    fuVar.b.g(tjVar.b);
                }
            } else if (i2 == 2) {
                int i3 = tjVar.b;
                d(up3Var, i3, i3, true);
                if (fuVar != null) {
                    int i4 = tjVar.b;
                    fuVar.d(up3Var, i4, i4, false);
                }
            }
        } else if (iG == 1) {
            int i5 = tjVar.d;
            int i6 = tjVar.e;
            int i7 = tjVar.b;
            int i8 = DnsRecord.CLASS_ANY;
            if (i5 == i6) {
                if (i5 != 1) {
                    d(up3Var, i7, tjVar.c, true);
                    if (fuVar != null) {
                        fuVar.d(up3Var, tjVar.b, tjVar.c, false);
                    }
                } else {
                    if (i7 > 255 || (i = tjVar.c) > 255) {
                        throw new go4("invalid code point value");
                    }
                    if (i7 > i) {
                        if (!(((-2019556389) & 4194304) != 0)) {
                            throw new go4("empty range in char class");
                        }
                        tjVar.f = 3;
                    } else {
                        dnVar.i(up3Var, i7, i);
                        if (fuVar != null) {
                            fuVar.b.i(null, tjVar.b, tjVar.c);
                        }
                    }
                }
                tjVar.f = 3;
            } else {
                int i9 = tjVar.c;
                if (i7 > i9) {
                    if (!(((-2019556389) & 4194304) != 0)) {
                        throw new go4("empty range in char class");
                    }
                    tjVar.f = 3;
                } else {
                    if (i9 >= 255) {
                        i9 = 255;
                    }
                    dnVar.i(up3Var, i7, i9);
                    d(up3Var, tjVar.b, tjVar.c, true);
                    if (fuVar != null) {
                        dn dnVar2 = fuVar.b;
                        int i10 = tjVar.b;
                        int i11 = tjVar.c;
                        if (i11 < 255) {
                            i8 = i11;
                        }
                        dnVar2.i(null, i10, i8);
                        fuVar.d(up3Var, tjVar.b, tjVar.c, false);
                    }
                    tjVar.f = 3;
                }
            }
        } else if (iG == 2 || iG == 3) {
            tjVar.f = 1;
        }
        tjVar.b = tjVar.c;
        tjVar.e = tjVar.d;
    }

    public final void k(fu fuVar, up3 up3Var) {
        dn dnVar;
        g20 g20VarJ;
        boolean zH = h();
        g20 g20Var = this.c;
        boolean zH2 = fuVar.h();
        dn dnVar2 = fuVar.b;
        g20 g20Var2 = fuVar.c;
        dn dnVar3 = this.b;
        if (zH) {
            dnVar = new dn();
            dnVar3.d(dnVar);
        } else {
            dnVar = dnVar3;
        }
        int[] iArr = dnVar.a;
        if (zH2) {
            dn dnVar4 = new dn();
            dnVar2.d(dnVar4);
            dnVar2 = dnVar4;
        }
        for (int i = 0; i < 8; i++) {
            iArr[i] = iArr[i] | dnVar2.a[i];
        }
        if (dnVar != dnVar3) {
            for (int i2 = 0; i2 < 8; i2++) {
                dnVar3.a[i2] = iArr[i2];
            }
        }
        if (zH) {
            dnVar3.c();
        }
        if (up3Var.c.z) {
            return;
        }
        if (zH && zH2) {
            g20VarJ = g20.e(g20Var, g20Var2, up3Var, false, false);
        } else {
            g20VarJ = g20.j(g20Var, g20Var2, up3Var, zH, zH2);
            if (zH) {
                g20VarJ = g20.i(up3Var, g20VarJ);
            }
        }
        this.c = g20VarJ;
    }

    @Override // defpackage.es2
    public final String toString(int i) {
        StringBuilder sb = new StringBuilder();
        if (h()) {
            sb.append("NOT ");
        }
        StringBuilder sb2 = new StringBuilder("\n  flags: ".concat(sb.toString()));
        sb2.append("\n  bs: " + es2.pad(this.b, 1));
        sb2.append("\n  mbuf: " + es2.pad(this.c, 1));
        return sb2.toString();
    }
}
