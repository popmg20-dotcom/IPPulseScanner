package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ki0 implements be3 {
    public static final xk3[] c = new xk3[0];
    public static final be3[] d = new be3[0];
    public final /* synthetic */ int a;
    public Object b;

    public ki0(int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = new w7(21);
                break;
            case 2:
                break;
            case 3:
                this.b = new zf2(17);
                break;
            default:
                this.b = new cp1(20);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x062a, code lost:
    
        throw defpackage.qi1.a();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0685 A[LOOP:15: B:249:0x05d3->B:286:0x0685, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:596:0x05ec A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final vk3 b(lb lbVar) throws qs2, d40, qi1 {
        byte[] bArr;
        pk0 pk0Var;
        byte[] bArr2;
        int i;
        int iC;
        ArrayList arrayList;
        char c2;
        char c3;
        int iC2;
        int i2;
        int iC3;
        int i3;
        int i4;
        cp1 cp1Var = (cp1) this.b;
        cn cnVarU = lbVar.u();
        eg0 eg0Var = new eg0(cnVarU);
        xk3[] xk3VarArrB = ((lt4) eg0Var.z).b();
        xk3 xk3Var = xk3VarArrB[0];
        xk3 xk3Var2 = xk3VarArrB[1];
        xk3 xk3Var3 = xk3VarArrB[3];
        xk3 xk3Var4 = xk3VarArrB[2];
        int iX = eg0Var.X(xk3Var, xk3Var2);
        int iX2 = eg0Var.X(xk3Var2, xk3Var3);
        int iX3 = eg0Var.X(xk3Var3, xk3Var4);
        int iX4 = eg0Var.X(xk3Var4, xk3Var);
        int i5 = 3;
        xk3[] xk3VarArr = {xk3Var4, xk3Var, xk3Var2, xk3Var3};
        if (iX > iX2) {
            xk3VarArr[0] = xk3Var;
            xk3VarArr[1] = xk3Var2;
            xk3VarArr[2] = xk3Var3;
            xk3VarArr[3] = xk3Var4;
            iX = iX2;
        }
        if (iX > iX3) {
            xk3VarArr[0] = xk3Var2;
            xk3VarArr[1] = xk3Var3;
            xk3VarArr[2] = xk3Var4;
            xk3VarArr[3] = xk3Var;
        } else {
            iX3 = iX;
        }
        if (iX3 > iX4) {
            xk3VarArr[0] = xk3Var3;
            xk3VarArr[1] = xk3Var4;
            xk3VarArr[2] = xk3Var;
            xk3VarArr[3] = xk3Var2;
        }
        xk3 xk3Var5 = xk3VarArr[0];
        xk3 xk3Var6 = xk3VarArr[1];
        xk3 xk3Var7 = xk3VarArr[2];
        xk3 xk3Var8 = xk3VarArr[3];
        int iX5 = (eg0Var.X(xk3Var5, xk3Var8) + 1) * 4;
        if (eg0Var.X(eg0.V(xk3Var6, xk3Var7, iX5), xk3Var5) < eg0Var.X(eg0.V(xk3Var7, xk3Var6, iX5), xk3Var8)) {
            xk3VarArr[0] = xk3Var5;
            xk3VarArr[1] = xk3Var6;
            xk3VarArr[2] = xk3Var7;
            xk3VarArr[3] = xk3Var8;
        } else {
            xk3VarArr[0] = xk3Var6;
            xk3VarArr[1] = xk3Var7;
            xk3VarArr[2] = xk3Var8;
            xk3VarArr[3] = xk3Var5;
        }
        xk3 xk3Var9 = xk3VarArr[0];
        xk3 xk3Var10 = xk3VarArr[1];
        xk3 xk3Var11 = xk3VarArr[2];
        xk3 xk3Var12 = xk3VarArr[3];
        int iX6 = eg0Var.X(xk3Var9, xk3Var12);
        xk3 xk3VarV = eg0.V(xk3Var9, xk3Var10, (eg0Var.X(xk3Var10, xk3Var12) + 1) * 4);
        xk3 xk3VarV2 = eg0.V(xk3Var11, xk3Var10, (iX6 + 1) * 4);
        int iX7 = eg0Var.X(xk3VarV, xk3Var12);
        int iX8 = eg0Var.X(xk3VarV2, xk3Var12);
        int i6 = 2;
        int i7 = 0;
        float f = xk3Var12.a;
        float f2 = xk3Var11.a;
        float f3 = xk3Var10.a;
        float f4 = iX7 + 1;
        float f5 = xk3Var12.b;
        float f6 = xk3Var11.b;
        float f7 = xk3Var10.b;
        xk3 xk3Var13 = new xk3(((f2 - f3) / f4) + f, ((f6 - f7) / f4) + f5);
        float f8 = xk3Var9.a - f3;
        float f9 = iX8 + 1;
        xk3 xk3Var14 = new xk3((f8 / f9) + f, ((xk3Var9.b - f7) / f9) + f5);
        if (!eg0Var.N(xk3Var13)) {
            xk3Var13 = eg0Var.N(xk3Var14) ? xk3Var14 : null;
        } else if (eg0Var.N(xk3Var14) && eg0Var.X(xk3VarV2, xk3Var13) + eg0Var.X(xk3VarV, xk3Var13) <= eg0Var.X(xk3VarV2, xk3Var14) + eg0Var.X(xk3VarV, xk3Var14)) {
        }
        xk3VarArr[3] = xk3Var13;
        if (xk3Var13 == null) {
            throw qs2.a();
        }
        xk3 xk3Var15 = xk3VarArr[0];
        xk3 xk3Var16 = xk3VarArr[1];
        xk3 xk3Var17 = xk3VarArr[2];
        int iX9 = eg0Var.X(xk3Var15, xk3Var13) + 1;
        xk3 xk3VarV3 = eg0.V(xk3Var15, xk3Var16, (eg0Var.X(xk3Var17, xk3Var13) + 1) * 4);
        xk3 xk3VarV4 = eg0.V(xk3Var17, xk3Var16, iX9 * 4);
        int iX10 = eg0Var.X(xk3VarV3, xk3Var13);
        int i8 = iX10 + 1;
        int iX11 = eg0Var.X(xk3VarV4, xk3Var13);
        int i9 = iX11 + 1;
        if ((i8 & 1) == 1) {
            i8 = iX10 + 2;
        }
        if ((i9 & 1) == 1) {
            i9 = iX11 + 2;
        }
        float f10 = (((xk3Var15.a + xk3Var16.a) + xk3Var17.a) + xk3Var13.a) / 4.0f;
        float f11 = (((xk3Var15.b + xk3Var16.b) + xk3Var17.b) + xk3Var13.b) / 4.0f;
        xk3 xk3VarP = eg0.P(xk3Var15, f10, f11);
        xk3 xk3VarP2 = eg0.P(xk3Var16, f10, f11);
        xk3 xk3VarP3 = eg0.P(xk3Var17, f10, f11);
        xk3 xk3VarP4 = eg0.P(xk3Var13, f10, f11);
        int i10 = i9 * 4;
        int i11 = i8 * 4;
        xk3[] xk3VarArr2 = {eg0.V(eg0.V(xk3VarP, xk3VarP2, i10), xk3VarP4, i11), eg0.V(eg0.V(xk3VarP2, xk3VarP, i10), xk3VarP3, i11), eg0.V(eg0.V(xk3VarP3, xk3VarP4, i10), xk3VarP2, i11), eg0.V(eg0.V(xk3VarP4, xk3VarP3, i10), xk3VarP, i11)};
        xk3 xk3Var18 = xk3VarArr2[0];
        xk3 xk3Var19 = xk3VarArr2[1];
        xk3 xk3Var20 = xk3VarArr2[2];
        xk3 xk3Var21 = xk3VarArr2[3];
        int iX12 = eg0Var.X(xk3Var18, xk3Var21);
        int iMax = iX12 + 1;
        int iX13 = eg0Var.X(xk3Var20, xk3Var21);
        int i12 = iX13 + 1;
        if ((iMax & 1) == 1) {
            iMax = iX12 + 2;
        }
        if ((i12 & 1) == 1) {
            i12 = iX13 + 2;
        }
        if (iMax * 4 < i12 * 6 && i12 * 4 < iMax * 6) {
            iMax = Math.max(iMax, i12);
            i12 = iMax;
        }
        float f12 = iMax - 0.5f;
        float f13 = i12 - 0.5f;
        xk3[] xk3VarArr3 = {xk3Var18, xk3Var19, xk3Var20, xk3Var21};
        ed4 ed4Var = new ed4(yr2.i0(cnVarU, iMax, i12, d13.a(0.5f, 0.5f, f12, 0.5f, f12, f13, 0.5f, f13, xk3Var18.a, xk3Var18.b, xk3Var21.a, xk3Var21.b, xk3Var20.a, xk3Var20.b, xk3Var19.a, xk3Var19.b)));
        vo4 vo4Var = (vo4) ed4Var.A;
        cn cnVar = (cn) ed4Var.z;
        int i13 = vo4Var.g;
        byte[] bArr3 = new byte[i13];
        cn cnVar2 = (cn) ed4Var.f;
        int i14 = cnVar2.f;
        int i15 = cnVar2.b;
        int i16 = 0;
        boolean z = false;
        int i17 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i18 = 4;
        while (true) {
            if (i18 == i14 && i16 == 0 && !z) {
                int i19 = i17 + 1;
                bArr = bArr3;
                int i20 = i14 - 1;
                int i21 = (ed4Var.R(i20, i7, i14, i15) ? 1 : 0) << 1;
                if (ed4Var.R(i20, 1, i14, i15)) {
                    i21 |= 1;
                }
                int i22 = i21 << 1;
                if (ed4Var.R(i20, i6, i14, i15)) {
                    i22 |= 1;
                }
                int i23 = i22 << 1;
                if (ed4Var.R(0, i15 - 2, i14, i15)) {
                    i23 |= 1;
                }
                int i24 = i23 << 1;
                int i25 = i15 - 1;
                if (ed4Var.R(0, i25, i14, i15)) {
                    i24 |= 1;
                }
                int i26 = i24 << 1;
                if (ed4Var.R(1, i25, i14, i15)) {
                    i26 |= 1;
                }
                int i27 = i26 << 1;
                if (ed4Var.R(2, i25, i14, i15)) {
                    i27 |= 1;
                }
                int i28 = i27 << 1;
                bArr[i17] = (byte) (ed4Var.R(i5, i25, i14, i15) ? i28 | 1 : i28);
                i18 -= 2;
                i16 += 2;
                i17 = i19;
                z = true;
            } else {
                bArr = bArr3;
                int i29 = i14 - 2;
                if (i18 != i29 || i16 != 0 || (i15 & 3) == 0 || z2) {
                    boolean z5 = z;
                    int i30 = i17;
                    if (i18 == i14 + 4 && i16 == 2 && (i15 & 7) == 0 && !z3) {
                        i17 = i30 + 1;
                        int i31 = i14 - 1;
                        int i32 = (ed4Var.R(i31, 0, i14, i15) ? 1 : 0) << 1;
                        int i33 = i15 - 1;
                        if (ed4Var.R(i31, i33, i14, i15)) {
                            i32 |= 1;
                        }
                        int i34 = i32 << 1;
                        int i35 = i15 - 3;
                        int i36 = (ed4Var.R(0, i35, i14, i15) ? i34 | 1 : i34) << 1;
                        int i37 = i16;
                        int i38 = i15 - 2;
                        if (ed4Var.R(0, i38, i14, i15)) {
                            i36 |= 1;
                        }
                        int i39 = i36 << 1;
                        if (ed4Var.R(0, i33, i14, i15)) {
                            i39 |= 1;
                        }
                        int i40 = i39 << 1;
                        if (ed4Var.R(1, i35, i14, i15)) {
                            i40 |= 1;
                        }
                        int i41 = i40 << 1;
                        if (ed4Var.R(1, i38, i14, i15)) {
                            i41 |= 1;
                        }
                        int i42 = i41 << 1;
                        if (ed4Var.R(1, i33, i14, i15)) {
                            i42 |= 1;
                        }
                        bArr[i30] = (byte) i42;
                        i18 -= 2;
                        i16 = i37 + 2;
                        z = z5;
                        z3 = true;
                    } else {
                        int i43 = i16;
                        if (i18 == i29 && i43 == 0 && (i15 & 7) == 4 && !z4) {
                            i17 = i30 + 1;
                            int i44 = (ed4Var.R(i14 + (-3), 0, i14, i15) ? 1 : 0) << 1;
                            if (ed4Var.R(i29, 0, i14, i15)) {
                                i44 |= 1;
                            }
                            int i45 = i44 << 1;
                            if (ed4Var.R(i14 - 1, 0, i14, i15)) {
                                i45 |= 1;
                            }
                            int i46 = i45 << 1;
                            if (ed4Var.R(0, i15 - 2, i14, i15)) {
                                i46 |= 1;
                            }
                            int i47 = i46 << 1;
                            int i48 = i15 - 1;
                            if (ed4Var.R(0, i48, i14, i15)) {
                                i47 |= 1;
                            }
                            int i49 = i47 << 1;
                            if (ed4Var.R(1, i48, i14, i15)) {
                                i49 |= 1;
                            }
                            int i50 = i49 << 1;
                            if (ed4Var.R(2, i48, i14, i15)) {
                                i50 |= 1;
                            }
                            int i51 = i50 << 1;
                            if (ed4Var.R(3, i48, i14, i15)) {
                                i51 |= 1;
                            }
                            bArr[i30] = (byte) i51;
                            i18 -= 2;
                            i16 = i43 + 2;
                            z = z5;
                            z4 = true;
                        } else {
                            i17 = i30;
                            int i52 = i43;
                            while (true) {
                                if (i18 < i14 && i52 >= 0 && !cnVar.b(i52, i18)) {
                                    bArr[i17] = (byte) ed4Var.S(i18, i52, i14, i15);
                                    i17++;
                                }
                                int i53 = i18 - 2;
                                int i54 = i52 + 2;
                                if (i53 < 0 || i54 >= i15) {
                                    break;
                                }
                                i18 = i53;
                                i52 = i54;
                            }
                            int i55 = i18 - 1;
                            int i56 = i52 + 5;
                            while (true) {
                                if (i55 >= 0 && i56 < i15 && !cnVar.b(i56, i55)) {
                                    bArr[i17] = (byte) ed4Var.S(i55, i56, i14, i15);
                                    i17++;
                                }
                                int i57 = i55 + 2;
                                int i58 = i56 - 2;
                                if (i57 >= i14 || i58 < 0) {
                                    break;
                                }
                                i55 = i57;
                                i56 = i58;
                            }
                            i18 = i55 + 5;
                            i16 = i56 - 1;
                            z = z5;
                        }
                    }
                } else {
                    int i59 = i17 + 1;
                    boolean z6 = z;
                    int i60 = i17;
                    int i61 = (ed4Var.R(i14 + (-3), 0, i14, i15) ? 1 : 0) << 1;
                    if (ed4Var.R(i29, 0, i14, i15)) {
                        i61 |= 1;
                    }
                    int i62 = i61 << 1;
                    if (ed4Var.R(i14 - 1, 0, i14, i15)) {
                        i62 |= 1;
                    }
                    int i63 = i62 << 1;
                    if (ed4Var.R(0, i15 - 4, i14, i15)) {
                        i63 |= 1;
                    }
                    int i64 = i63 << 1;
                    if (ed4Var.R(0, i15 - 3, i14, i15)) {
                        i64 |= 1;
                    }
                    int i65 = i64 << 1;
                    if (ed4Var.R(0, i15 - 2, i14, i15)) {
                        i65 |= 1;
                    }
                    int i66 = i65 << 1;
                    int i67 = i15 - 1;
                    if (ed4Var.R(0, i67, i14, i15)) {
                        i66 |= 1;
                    }
                    int i68 = i66 << 1;
                    if (ed4Var.R(1, i67, i14, i15)) {
                        i68 |= 1;
                    }
                    bArr[i60] = (byte) i68;
                    i18 -= 2;
                    i16 += 2;
                    i17 = i59;
                    z = z6;
                    z2 = true;
                }
            }
            if (i18 >= i14 && i16 >= i15) {
                break;
            }
            i6 = 2;
            bArr3 = bArr;
            i7 = 0;
            i5 = 3;
        }
        if (i17 != i13) {
            throw qi1.a();
        }
        t6 t6Var = vo4Var.f;
        hm2[] hm2VarArr = (hm2[]) t6Var.z;
        int i69 = t6Var.f;
        int i70 = 0;
        for (hm2 hm2Var : hm2VarArr) {
            i70 += hm2Var.b;
        }
        gi0[] gi0VarArr = new gi0[i70];
        int length = hm2VarArr.length;
        int i71 = 0;
        for (int i72 = 0; i72 < length; i72++) {
            hm2 hm2Var2 = hm2VarArr[i72];
            int i73 = 0;
            while (i73 < hm2Var2.b) {
                int i74 = hm2Var2.c;
                gi0VarArr[i71] = new gi0(i74, 1, new byte[i69 + i74]);
                i73++;
                i71++;
                i69 = i69;
                hm2VarArr = hm2VarArr;
            }
        }
        int length2 = gi0VarArr[0].c.length - i69;
        int i75 = length2 - 1;
        int i76 = 0;
        for (int i77 = 0; i77 < i75; i77++) {
            int i78 = 0;
            while (i78 < i71) {
                gi0VarArr[i78].c[i77] = bArr[i76];
                i78++;
                i76++;
            }
        }
        boolean z7 = vo4Var.a == 24;
        int i79 = 8;
        int i80 = z7 ? 8 : i71;
        int i81 = 0;
        while (i81 < i80) {
            gi0VarArr[i81].c[i75] = bArr[i76];
            i81++;
            i76++;
        }
        int length3 = gi0VarArr[0].c.length;
        while (length2 < length3) {
            int i82 = 0;
            while (i82 < i71) {
                int i83 = z7 ? (i82 + 8) % i71 : i82;
                gi0VarArr[i83].c[(!z7 || i83 <= 7) ? length2 : length2 - 1] = bArr[i76];
                i82++;
                i76++;
            }
            length2++;
        }
        if (i76 == i13) {
            int i84 = 0;
            for (int i85 = 0; i85 < i70; i85++) {
                i84 += gi0VarArr[i85].b;
            }
            byte[] bArr4 = new byte[i84];
            int i86 = 0;
            for (int i87 = 0; i87 < i70; i87++) {
                gi0 gi0Var = gi0VarArr[i87];
                byte[] bArr5 = gi0Var.c;
                int i88 = gi0Var.b;
                int length4 = bArr5.length;
                int[] iArr = new int[length4];
                for (int i89 = 0; i89 < length4; i89++) {
                    iArr[i89] = bArr5[i89] & 255;
                }
                try {
                    int iW = ((ha1) cp1Var.f).w(iArr, bArr5.length - i88);
                    for (int i90 = 0; i90 < i88; i90++) {
                        bArr5[i90] = (byte) iArr[i90];
                    }
                    i86 += iW;
                    for (int i91 = 0; i91 < i88; i91++) {
                        bArr4[(i91 * i70) + i87] = bArr5[i91];
                    }
                } catch (wg3 unused) {
                    throw d40.a();
                }
            }
            en enVar = new en(bArr4, 0);
            ed4 ed4Var2 = new ed4(100);
            StringBuilder sb = new StringBuilder(0);
            ArrayList arrayList2 = new ArrayList(1);
            HashSet hashSet = new HashSet();
            int i92 = 2;
            boolean z8 = false;
            while (true) {
                int i93 = DnsRecord.CLASS_NONE;
                if (i92 == 2) {
                    boolean z9 = false;
                    while (true) {
                        int iC4 = enVar.c(i79);
                        if (iC4 == 0) {
                            throw qi1.a();
                        }
                        if (iC4 <= 128) {
                            if (z9) {
                                iC4 += 128;
                            }
                            ed4Var2.j((char) (iC4 - 1));
                            bArr2 = bArr4;
                        } else if (iC4 == 129) {
                            bArr2 = bArr4;
                            i4 = 1;
                        } else {
                            if (iC4 > 229) {
                                switch (iC4) {
                                    case 230:
                                        bArr2 = bArr4;
                                        i4 = 3;
                                        break;
                                    case 231:
                                        bArr2 = bArr4;
                                        i4 = 7;
                                        break;
                                    case 232:
                                        bArr2 = bArr4;
                                        hashSet.add(Integer.valueOf(ed4Var2.toString().length()));
                                        ed4Var2.j((char) 29);
                                        if (enVar.a() > 0) {
                                            bArr4 = bArr2;
                                            i93 = DnsRecord.CLASS_NONE;
                                            i79 = 8;
                                        }
                                        break;
                                    case 233:
                                    case 234:
                                        break;
                                    case 235:
                                        bArr2 = bArr4;
                                        z9 = true;
                                        if (enVar.a() > 0) {
                                        }
                                        break;
                                    case 236:
                                        bArr2 = bArr4;
                                        ((StringBuilder) ed4Var2.f).append("[)>\u001e05\u001d");
                                        sb.insert(0, "\u001e\u0004");
                                        if (enVar.a() > 0) {
                                        }
                                        break;
                                    case 237:
                                        ((StringBuilder) ed4Var2.f).append("[)>\u001e06\u001d");
                                        sb.insert(0, "\u001e\u0004");
                                        bArr2 = bArr4;
                                        if (enVar.a() > 0) {
                                        }
                                        break;
                                    case 238:
                                        bArr2 = bArr4;
                                        i4 = 5;
                                        break;
                                    case 239:
                                        bArr2 = bArr4;
                                        i4 = 4;
                                        break;
                                    case 240:
                                        bArr2 = bArr4;
                                        i4 = 6;
                                        break;
                                    case 241:
                                        bArr2 = bArr4;
                                        i4 = 8;
                                        break;
                                    default:
                                        if (iC4 != i93 || enVar.a() != 0) {
                                        }
                                        break;
                                }
                            } else {
                                int i94 = iC4 - 130;
                                if (i94 < 10) {
                                    ed4Var2.j('0');
                                }
                                ((StringBuilder) ed4Var2.f).append(String.valueOf(i94));
                            }
                            bArr2 = bArr4;
                            if (enVar.a() > 0) {
                            }
                        }
                    }
                    i4 = 2;
                    i92 = i4;
                    arrayList = arrayList2;
                    i = 6;
                } else {
                    bArr2 = bArr4;
                    switch (fw.G(i92)) {
                        case 2:
                            i = 6;
                            int[] iArr2 = new int[3];
                            boolean z10 = false;
                            int i95 = 0;
                            while (enVar.a() != 8 && (iC = enVar.c(8)) != 254) {
                                arrayList = arrayList2;
                                p95.y(iC, enVar.c(8), iArr2);
                                for (int i96 = 0; i96 < 3; i96++) {
                                    int i97 = iArr2[i96];
                                    if (i95 != 0) {
                                        if (i95 == 1) {
                                            c2 = 30;
                                            if (z10) {
                                                ed4Var2.j((char) (i97 + 128));
                                                z10 = false;
                                            } else {
                                                ed4Var2.j((char) i97);
                                            }
                                        } else if (i95 == 2) {
                                            char[] cArr = p95.c;
                                            if (i97 < 27) {
                                                char c4 = cArr[i97];
                                                if (z10) {
                                                    ed4Var2.j((char) (c4 + 128));
                                                    z10 = false;
                                                } else {
                                                    ed4Var2.j(c4);
                                                }
                                                c3 = 29;
                                                c2 = 30;
                                            } else if (i97 != 27) {
                                                c2 = 30;
                                                if (i97 != 30) {
                                                    throw qi1.a();
                                                }
                                                c3 = 29;
                                                z10 = true;
                                            } else {
                                                c2 = 30;
                                                hashSet.add(Integer.valueOf(ed4Var2.toString().length()));
                                                c3 = 29;
                                                ed4Var2.j((char) 29);
                                            }
                                        } else {
                                            if (i95 != 3) {
                                                throw qi1.a();
                                            }
                                            if (z10) {
                                                ed4Var2.j((char) (i97 + 224));
                                                z10 = false;
                                            } else {
                                                ed4Var2.j((char) (i97 + 96));
                                            }
                                            i95 = 0;
                                        }
                                        i95 = 0;
                                    } else if (i97 < 3) {
                                        i95 = i97 + 1;
                                    } else {
                                        char[] cArr2 = p95.b;
                                        if (i97 >= 40) {
                                            throw qi1.a();
                                        }
                                        char c5 = cArr2[i97];
                                        if (z10) {
                                            ed4Var2.j((char) (c5 + 128));
                                            z10 = false;
                                        } else {
                                            ed4Var2.j(c5);
                                        }
                                    }
                                }
                                if (enVar.a() <= 0) {
                                    i92 = 2;
                                } else {
                                    arrayList2 = arrayList;
                                }
                                break;
                            }
                            arrayList = arrayList2;
                            i92 = 2;
                            break;
                        case 3:
                            i = 6;
                            int[] iArr3 = new int[3];
                            boolean z11 = false;
                            int i98 = 0;
                            while (enVar.a() != 8 && (iC2 = enVar.c(8)) != 254) {
                                p95.y(iC2, enVar.c(8), iArr3);
                                int i99 = i98;
                                int i100 = 0;
                                while (i100 < 3) {
                                    int i101 = iArr3[i100];
                                    if (i99 != 0) {
                                        i2 = i100;
                                        if (i99 != 1) {
                                            if (i99 == 2) {
                                                char[] cArr3 = p95.e;
                                                if (i101 < 27) {
                                                    char c6 = cArr3[i101];
                                                    if (z11) {
                                                        ed4Var2.j((char) (c6 + 128));
                                                        z11 = false;
                                                    } else {
                                                        ed4Var2.j(c6);
                                                    }
                                                } else if (i101 == 27) {
                                                    hashSet.add(Integer.valueOf(ed4Var2.toString().length()));
                                                    ed4Var2.j((char) 29);
                                                } else {
                                                    if (i101 != 30) {
                                                        throw qi1.a();
                                                    }
                                                    z11 = true;
                                                }
                                                i99 = 0;
                                            } else {
                                                if (i99 != 3) {
                                                    throw qi1.a();
                                                }
                                                char[] cArr4 = p95.f;
                                                if (i101 >= 32) {
                                                    throw qi1.a();
                                                }
                                                char c7 = cArr4[i101];
                                                if (z11) {
                                                    ed4Var2.j((char) (c7 + 128));
                                                    z11 = false;
                                                } else {
                                                    ed4Var2.j(c7);
                                                }
                                                i99 = 0;
                                            }
                                        } else if (z11) {
                                            ed4Var2.j((char) (i101 + 128));
                                            z11 = false;
                                            i99 = 0;
                                        } else {
                                            ed4Var2.j((char) i101);
                                            i99 = 0;
                                        }
                                    } else {
                                        i2 = i100;
                                        if (i101 < 3) {
                                            i99 = i101 + 1;
                                        } else {
                                            char[] cArr5 = p95.d;
                                            if (i101 >= 40) {
                                                throw qi1.a();
                                            }
                                            char c8 = cArr5[i101];
                                            if (z11) {
                                                ed4Var2.j((char) (c8 + 128));
                                                z11 = false;
                                            } else {
                                                ed4Var2.j(c8);
                                            }
                                        }
                                    }
                                    i100 = i2 + 1;
                                }
                                if (enVar.a() <= 0) {
                                    arrayList = arrayList2;
                                    i92 = 2;
                                } else {
                                    i98 = i99;
                                }
                                break;
                            }
                            arrayList = arrayList2;
                            i92 = 2;
                            break;
                        case 4:
                            int i102 = 3;
                            int[] iArr4 = new int[3];
                            while (enVar.a() != 8 && (iC3 = enVar.c(8)) != 254) {
                                p95.y(iC3, enVar.c(8), iArr4);
                                int i103 = 0;
                                while (i103 < i102) {
                                    int i104 = iArr4[i103];
                                    if (i104 == 0) {
                                        ed4Var2.j(StringUtil.CARRIAGE_RETURN);
                                    } else if (i104 == 1) {
                                        ed4Var2.j('*');
                                    } else if (i104 == 2) {
                                        ed4Var2.j('>');
                                    } else if (i104 == i102) {
                                        ed4Var2.j(' ');
                                    } else if (i104 < 14) {
                                        ed4Var2.j((char) (i104 + 44));
                                    } else {
                                        if (i104 >= 40) {
                                            throw qi1.a();
                                        }
                                        ed4Var2.j((char) (i104 + 51));
                                    }
                                    i103++;
                                    i102 = 3;
                                }
                                if (enVar.a() <= 0) {
                                    arrayList = arrayList2;
                                    i = 6;
                                    i92 = 2;
                                } else {
                                    i102 = 3;
                                }
                                break;
                            }
                            arrayList = arrayList2;
                            i = 6;
                            i92 = 2;
                            break;
                        case 5:
                            while (true) {
                                if (enVar.a() <= 16) {
                                    i3 = 6;
                                } else {
                                    int i105 = 0;
                                    while (true) {
                                        if (i105 < 4) {
                                            i3 = 6;
                                            int iC5 = enVar.c(6);
                                            if (iC5 == 31) {
                                                int i106 = 8 - enVar.c;
                                                if (i106 != 8) {
                                                    enVar.c(i106);
                                                }
                                            } else {
                                                if ((iC5 & 32) == 0) {
                                                    iC5 |= 64;
                                                }
                                                ed4Var2.j((char) iC5);
                                                i105++;
                                            }
                                        } else {
                                            i3 = 6;
                                            if (enVar.a() <= 0) {
                                            }
                                        }
                                    }
                                }
                            }
                            arrayList = arrayList2;
                            i = i3;
                            i92 = 2;
                            break;
                        case 6:
                            int i107 = enVar.b;
                            int i108 = 8;
                            int i109 = i107 + 2;
                            int iE = p95.E(enVar.c(8), i107 + 1);
                            if (iE == 0) {
                                iE = enVar.a() / 8;
                            } else if (iE >= 250) {
                                iE = ((iE - 249) * 250) + p95.E(enVar.c(8), i109);
                                i109 = i107 + 3;
                            }
                            if (iE < 0) {
                                throw qi1.a();
                            }
                            byte[] bArr6 = new byte[iE];
                            int i110 = 0;
                            while (i110 < iE) {
                                int i111 = iE;
                                if (enVar.a() < i108) {
                                    throw qi1.a();
                                }
                                bArr6[i110] = (byte) p95.E(enVar.c(i108), i109);
                                i110++;
                                i109++;
                                iE = i111;
                                i108 = 8;
                            }
                            arrayList2.add(bArr6);
                            ((StringBuilder) ed4Var2.f).append(new String(bArr6, StandardCharsets.ISO_8859_1));
                            arrayList = arrayList2;
                            i = 6;
                            i92 = 2;
                            break;
                            break;
                        case 7:
                            if (enVar.a() < 8) {
                                throw qi1.a();
                            }
                            int iC6 = enVar.c(8);
                            if (iC6 <= 127) {
                                ed4Var2.k(iC6 - 1);
                            }
                            arrayList = arrayList2;
                            z8 = true;
                            i = 6;
                            i92 = 2;
                            break;
                            break;
                        default:
                            throw qi1.a();
                    }
                }
                if (i92 != 1 && enVar.a() > 0) {
                    bArr4 = bArr2;
                    arrayList2 = arrayList;
                    i79 = 8;
                }
            }
            if (sb.length() > 0) {
                ed4Var2.x();
                ((StringBuilder) ed4Var2.z).append((CharSequence) sb);
            }
            pk0Var = new pk0(bArr2, ed4Var2.toString(), arrayList.isEmpty() ? null : arrayList, null, -1, -1, z8 ? (hashSet.contains(0) || hashSet.contains(4)) ? 5 : (hashSet.contains(1) || hashSet.contains(5)) ? i : 4 : (hashSet.contains(0) || hashSet.contains(4)) ? 2 : (hashSet.contains(1) || hashSet.contains(5)) ? 3 : 1);
            pk0Var.e = Integer.valueOf(i86);
        } else {
            s53.d();
            pk0Var = null;
        }
        vk3 vk3Var = new vk3(pk0Var.b, pk0Var.a, xk3VarArr3, sj.Y);
        List list = pk0Var.c;
        if (list != null) {
            vk3Var.b(wk3.f, list);
        }
        String str = pk0Var.d;
        if (str != null) {
            vk3Var.b(wk3.z, str);
        }
        vk3Var.b(wk3.A, pk0Var.e);
        vk3Var.b(wk3.D0, "]d" + pk0Var.j);
        return vk3Var;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:136|321|137|138|(3:140|(22:143|319|144|352|149|(1:151)(1:153)|152|154|(1:156)(1:157)|158|323|159|178|(1:183)|184|(1:186)|187|(1:189)|(1:193)|194|195|141)|353)(1:147)|148|149|(0)(0)|152|154|(0)(0)|158|323|159|178|(2:180|183)|184|(0)|187|(0)|(2:191|193)|194|195) */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03da, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03db, code lost:
    
        r5 = r0;
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x03de, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03df, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03e0, code lost:
    
        r4.w();
        r4.z = null;
        r4.A = null;
        r4.f = true;
        r4.v();
        r4.t();
        r6 = (defpackage.cn) r4.b;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03fa, code lost:
    
        r8 = r7 + 1;
        r10 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0409, code lost:
    
        if (r6.b(r7, r10) != r6.b(r10, r7)) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x040b, code lost:
    
        r6.a(r10, r7);
        r6.a(r7, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0411, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0414, code lost:
    
        r7 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0416, code lost:
    
        r1 = r1.k0(r4);
        r1.g = new defpackage.yb3();
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0421, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0489, code lost:
    
        if (r0 != null) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x048b, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x048c, code lost:
    
        throw r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03fa A[Catch: d40 | qi1 -> 0x0489, TryCatch #2 {d40 | qi1 -> 0x0489, blocks: (B:165:0x03e0, B:166:0x03f6, B:168:0x03fa, B:169:0x03fd, B:171:0x0401, B:173:0x040b, B:174:0x0411, B:176:0x0416), top: B:317:0x03e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0247 A[SYNTHETIC] */
    @Override // defpackage.be3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final vk3 a(lb lbVar) throws qs2, d40, qi1 {
        char c2;
        int[] iArr;
        byte[] bArr;
        int iO;
        byte[] bArr2;
        String string;
        int i;
        re1 re1Var;
        re1 re1Var2;
        re1 re1Var3;
        float f;
        float f2;
        y6 y6VarR;
        float f3;
        float f4;
        float f5;
        int i2;
        xk3[] xk3VarArr;
        pk0 pk0VarK0;
        int i3;
        vk3 vk3Var;
        List list;
        String str;
        int i4;
        double d2;
        double dAbs;
        int i5;
        int i6;
        int iAbs;
        int i7 = this.a;
        wk3 wk3Var = wk3.A;
        wk3 wk3Var2 = wk3.z;
        int i8 = 0;
        int i9 = 1;
        switch (i7) {
            case 0:
                return b(lbVar);
            case 1:
                cn cnVarU = lbVar.u();
                int i10 = cnVarU.b;
                int i11 = cnVarU.f;
                int i12 = -1;
                int i13 = -1;
                for (int i14 = 0; i14 < cnVarU.f; i14++) {
                    int i15 = 0;
                    while (true) {
                        int i16 = cnVarU.z;
                        if (i15 < i16) {
                            int i17 = cnVarU.A[(i16 * i14) + i15];
                            if (i17 != 0) {
                                if (i14 < i11) {
                                    i11 = i14;
                                }
                                if (i14 > i13) {
                                    i13 = i14;
                                }
                                int i18 = i15 * 32;
                                if (i18 < i10) {
                                    int i19 = 0;
                                    while ((i17 << (31 - i19)) == 0) {
                                        i19++;
                                    }
                                    int i20 = i19 + i18;
                                    if (i20 < i10) {
                                        i10 = i20;
                                    }
                                }
                                if (i18 + 31 > i12) {
                                    int i21 = 31;
                                    while ((i17 >>> i21) == 0) {
                                        i21--;
                                    }
                                    int i22 = i18 + i21;
                                    if (i22 > i12) {
                                        i12 = i22;
                                    }
                                }
                            }
                            i15++;
                        }
                    }
                }
                if (i12 < i10 || i13 < i11) {
                    c2 = 1;
                    iArr = null;
                } else {
                    c2 = 1;
                    iArr = new int[]{i10, i11, (i12 - i10) + 1, (i13 - i11) + 1};
                }
                if (iArr == null) {
                    throw qs2.a();
                }
                int i23 = iArr[0];
                int i24 = iArr[c2];
                int i25 = iArr[2];
                int i26 = iArr[3];
                int[] iArr2 = new int[33];
                for (int i27 = 0; i27 < 33; i27++) {
                    int iMin = Math.min(((i26 / 2) + (i27 * i26)) / 33, i26 - 1) + i24;
                    for (int i28 = 0; i28 < 30; i28++) {
                        if (cnVarU.b(Math.min(((((i27 & 1) * i25) / 2) + ((i25 / 2) + (i28 * i25))) / 30, i25 - 1) + i23, iMin)) {
                            int i29 = (i28 / 32) + i27;
                            iArr2[i29] = iArr2[i29] | (1 << (i28 & 31));
                        }
                    }
                }
                w7 w7Var = (w7) this.b;
                byte[] bArr3 = new byte[144];
                for (int i30 = 0; i30 < 33; i30++) {
                    int[] iArr3 = l72.a[i30];
                    for (int i31 = 0; i31 < 30; i31++) {
                        int i32 = iArr3[i31];
                        if (i32 >= 0 && ((iArr2[(i31 / 32) + i30] >>> (i31 & 31)) & 1) != 0) {
                            int i33 = i32 / 6;
                            bArr3[i33] = (byte) (((byte) (1 << (5 - (i32 % 6)))) | bArr3[i33]);
                        }
                    }
                }
                int iO2 = w7Var.o(0, 10, 10, 0, bArr3);
                int i34 = bArr3[0] & 15;
                if (i34 == 2 || i34 == 3 || i34 == 4) {
                    bArr = bArr3;
                    iO = iO2 + w7Var.o(20, 84, 40, 1, bArr3) + w7Var.o(20, 84, 40, 2, bArr3);
                    bArr2 = new byte[94];
                } else {
                    if (i34 != 5) {
                        throw qi1.a();
                    }
                    iO = iO2 + w7Var.o(20, 68, 56, 1, bArr3) + w7Var.o(20, 68, 56, 2, bArr3);
                    bArr2 = new byte[78];
                    bArr = bArr3;
                }
                System.arraycopy(bArr, 0, bArr2, 0, 10);
                System.arraycopy(bArr, 20, bArr2, 10, bArr2.length - 10);
                StringBuilder sb = new StringBuilder(144);
                int i35 = 2;
                if (i34 == 2) {
                    if (i34 != i35) {
                        int iX = ez4.x(bArr2, ez4.d);
                        int iX2 = ez4.x(bArr2, ez4.c);
                        if (iX2 > 10) {
                            throw qi1.a();
                        }
                        string = new DecimalFormat("0000000000".substring(0, iX2)).format(iX);
                    } else {
                        byte[][] bArr4 = ez4.e;
                        StringBuilder sb2 = new StringBuilder(6);
                        for (int i36 = 0; i36 < 6; i36++) {
                            sb2.append(ez4.f[0].charAt(ez4.x(bArr2, bArr4[i36])));
                        }
                        string = sb2.toString();
                    }
                    DecimalFormat decimalFormat = new DecimalFormat("000");
                    String str2 = decimalFormat.format(ez4.x(bArr2, ez4.a));
                    String str3 = decimalFormat.format(ez4.x(bArr2, ez4.b));
                    sb.append(ez4.y(10, 84, bArr2));
                    if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                        sb.insert(0, string + (char) 29 + str2 + (char) 29 + str3 + (char) 29);
                    } else {
                        sb.insert(9, string + (char) 29 + str2 + (char) 29 + str3 + (char) 29);
                    }
                } else if (i34 == 3) {
                    i35 = 2;
                    if (i34 != i35) {
                    }
                    DecimalFormat decimalFormat2 = new DecimalFormat("000");
                    String str22 = decimalFormat2.format(ez4.x(bArr2, ez4.a));
                    String str32 = decimalFormat2.format(ez4.x(bArr2, ez4.b));
                    sb.append(ez4.y(10, 84, bArr2));
                    if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                    }
                } else if (i34 == 4) {
                    sb.append(ez4.y(1, 93, bArr2));
                } else if (i34 == 5) {
                    sb.append(ez4.y(1, 77, bArr2));
                }
                String string2 = sb.toString();
                String strValueOf = String.valueOf(i34);
                Integer numValueOf = Integer.valueOf(iO);
                vk3 vk3Var2 = new vk3(string2, bArr2, c, sj.A0);
                vk3Var2.b(wk3Var, numValueOf);
                if (strValueOf != null) {
                    vk3Var2.b(wk3Var2, strValueOf);
                }
                return vk3Var2;
            case 2:
                g();
                return c(lbVar);
            default:
                zf2 zf2Var = (zf2) this.b;
                cn cnVarU2 = lbVar.u();
                w7 w7Var2 = new w7(23, cnVarU2);
                ue1 ue1Var = new ue1(cnVarU2, 0);
                ArrayList arrayList = (ArrayList) ue1Var.z;
                int i37 = cnVarU2.f;
                int i38 = cnVarU2.b;
                int i39 = (i37 * 3) / 388;
                if (i39 >= 3) {
                    i = 3;
                } else {
                    i39 = 3;
                    i = 3;
                }
                int[] iArr4 = new int[5];
                int i40 = i39 - 1;
                boolean z = false;
                while (i40 < i37 && !z) {
                    Arrays.fill(iArr4, i8);
                    int i41 = i8;
                    boolean zN = z;
                    while (i41 < i38) {
                        if (cnVarU2.b(i41, i40)) {
                            if ((i8 & 1) == i9) {
                                i8++;
                            }
                            iArr4[i8] = iArr4[i8] + i9;
                            i5 = i37;
                        } else if ((i8 & 1) != 0) {
                            i5 = i37;
                            iArr4[i8] = iArr4[i8] + 1;
                        } else if (i8 == 4) {
                            if (!ue1.i(iArr4)) {
                                i5 = i37;
                                int i42 = i9;
                                iArr4[0] = iArr4[2];
                                iArr4[i42] = iArr4[i];
                                iArr4[2] = iArr4[4];
                                iArr4[i] = i42;
                                iArr4[4] = 0;
                            } else if (ue1Var.m(i40, i41, iArr4)) {
                                if (ue1Var.f) {
                                    zN = ue1Var.n();
                                    i5 = i37;
                                    i6 = 2;
                                } else {
                                    if (arrayList.size() <= i9) {
                                        i5 = i37;
                                        iAbs = 0;
                                        i6 = 2;
                                    } else {
                                        Iterator it = arrayList.iterator();
                                        re1 re1Var4 = null;
                                        while (true) {
                                            if (it.hasNext()) {
                                                re1 re1Var5 = (re1) it.next();
                                                i5 = i37;
                                                if (re1Var5.d >= 2) {
                                                    if (re1Var4 == null) {
                                                        re1Var4 = re1Var5;
                                                    } else {
                                                        ue1Var.f = true;
                                                        i6 = 2;
                                                        iAbs = ((int) (Math.abs(re1Var4.a - re1Var5.a) - Math.abs(re1Var4.b - re1Var5.b))) / 2;
                                                    }
                                                }
                                                i37 = i5;
                                            } else {
                                                i5 = i37;
                                                i6 = 2;
                                                iAbs = 0;
                                            }
                                        }
                                    }
                                    if (iAbs > iArr4[i6]) {
                                        i40 += (iAbs - r6) - 2;
                                        i41 = i38 - 1;
                                    }
                                }
                                Arrays.fill(iArr4, 0);
                                i8 = 0;
                                i39 = i6;
                            } else {
                                i5 = i37;
                                iArr4[0] = iArr4[2];
                                iArr4[1] = iArr4[i];
                                iArr4[2] = iArr4[4];
                                iArr4[i] = 1;
                                iArr4[4] = 0;
                            }
                            i8 = i;
                        } else {
                            i5 = i37;
                            int i43 = i8 + 1;
                            iArr4[i43] = iArr4[i43] + 1;
                            i8 = i43;
                        }
                        i41++;
                        i37 = i5;
                        i9 = 1;
                    }
                    int i44 = i37;
                    if (ue1.i(iArr4) && ue1Var.m(i40, i38, iArr4)) {
                        int i45 = iArr4[0];
                        if (ue1Var.f) {
                            i39 = i45;
                            zN = ue1Var.n();
                        } else {
                            i39 = i45;
                        }
                    }
                    i40 += i39;
                    i37 = i44;
                    z = zN;
                    i8 = 0;
                    i9 = 1;
                }
                if (arrayList.size() < i) {
                    throw qs2.a();
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (((re1) it2.next()).d < 2) {
                        it2.remove();
                    }
                }
                Collections.sort(arrayList, ue1.X);
                re1[] re1VarArr = new re1[3];
                int i46 = 0;
                double d3 = Double.MAX_VALUE;
                for (int i47 = 2; i46 < arrayList.size() - i47; i47 = 2) {
                    re1 re1Var6 = (re1) arrayList.get(i46);
                    float f6 = re1Var6.c;
                    i46++;
                    int i48 = i46;
                    while (i48 < arrayList.size() - 1) {
                        re1 re1Var7 = (re1) arrayList.get(i48);
                        double dY = ue1.y(re1Var6, re1Var7);
                        i48++;
                        int i49 = i48;
                        while (i49 < arrayList.size()) {
                            re1 re1Var8 = (re1) arrayList.get(i49);
                            re1[] re1VarArr2 = re1VarArr;
                            if (re1Var8.c <= 1.4f * f6) {
                                double dY2 = ue1.y(re1Var7, re1Var8);
                                double dY3 = ue1.y(re1Var6, re1Var8);
                                if (dY < dY2) {
                                    if (dY2 <= dY3) {
                                        dY3 = dY2;
                                        dY2 = dY3;
                                    } else if (dY >= dY3) {
                                        d2 = dY3;
                                        dY3 = dY;
                                        dAbs = Math.abs(dY2 - (d2 * 2.0d)) + Math.abs(dY2 - (dY3 * 2.0d));
                                        if (dAbs >= d3) {
                                            re1VarArr2[0] = re1Var6;
                                            re1VarArr2[1] = re1Var7;
                                            re1VarArr2[2] = re1Var8;
                                            d3 = dAbs;
                                        }
                                    }
                                    d2 = dY;
                                    dAbs = Math.abs(dY2 - (d2 * 2.0d)) + Math.abs(dY2 - (dY3 * 2.0d));
                                    if (dAbs >= d3) {
                                    }
                                } else {
                                    if (dY2 >= dY3) {
                                        d2 = dY3;
                                        dY3 = dY2;
                                    } else if (dY < dY3) {
                                        d2 = dY2;
                                        dY2 = dY3;
                                        dY3 = dY;
                                        dAbs = Math.abs(dY2 - (d2 * 2.0d)) + Math.abs(dY2 - (dY3 * 2.0d));
                                        if (dAbs >= d3) {
                                        }
                                    } else {
                                        d2 = dY2;
                                    }
                                    dY2 = dY;
                                    dAbs = Math.abs(dY2 - (d2 * 2.0d)) + Math.abs(dY2 - (dY3 * 2.0d));
                                    if (dAbs >= d3) {
                                    }
                                }
                            }
                            i49++;
                            re1VarArr = re1VarArr2;
                        }
                    }
                }
                re1[] re1VarArr3 = re1VarArr;
                if (d3 == Double.MAX_VALUE) {
                    throw qs2.a();
                }
                float fA = xk3.a(re1VarArr3[0], re1VarArr3[1]);
                float fA2 = xk3.a(re1VarArr3[1], re1VarArr3[2]);
                float fA3 = xk3.a(re1VarArr3[0], re1VarArr3[2]);
                if (fA2 >= fA && fA2 >= fA3) {
                    re1Var = re1VarArr3[0];
                    re1Var2 = re1VarArr3[1];
                    re1Var3 = re1VarArr3[2];
                } else if (fA3 < fA2 || fA3 < fA) {
                    re1Var = re1VarArr3[2];
                    re1Var2 = re1VarArr3[0];
                    re1Var3 = re1VarArr3[1];
                } else {
                    re1Var = re1VarArr3[1];
                    re1Var2 = re1VarArr3[0];
                    re1Var3 = re1VarArr3[2];
                }
                float f7 = re1Var.a;
                float f8 = re1Var.b;
                if (((re1Var2.b - f8) * (re1Var3.a - f7)) - ((re1Var2.a - f7) * (re1Var3.b - f8)) < 0.0f) {
                    re1 re1Var9 = re1Var3;
                    re1Var3 = re1Var2;
                    re1Var2 = re1Var9;
                }
                re1VarArr3[0] = re1Var2;
                re1VarArr3[1] = re1Var;
                re1VarArr3[2] = re1Var3;
                float fN = w7Var2.n(re1Var, re1Var3);
                float f9 = re1Var.a;
                float f10 = re1Var3.b;
                float f11 = re1Var3.a;
                float fN2 = w7Var2.n(re1Var, re1Var2);
                float f12 = re1Var2.b;
                float f13 = re1Var2.a;
                float f14 = (fN2 + fN) / 2.0f;
                if (f14 < 1.0f) {
                    throw qs2.a();
                }
                int iV = (gb4.V(xk3.a(re1Var, re1Var2) / f14) + gb4.V(xk3.a(re1Var, re1Var3) / f14)) / 2;
                int i50 = iV + 7;
                int i51 = i50 & 3;
                if (i51 == 0) {
                    i50 = iV + 8;
                } else if (i51 == 2) {
                    i50 = iV + 6;
                } else if (i51 == 3) {
                    i50 = iV + 5;
                }
                int i52 = i50;
                int[] iArr5 = wo4.e;
                if (i52 % 4 != 1) {
                    throw qi1.a();
                }
                try {
                    wo4 wo4VarC = wo4.c((i52 - 17) / 4);
                    int i53 = (wo4VarC.a * 4) + 10;
                    if (wo4VarC.b.length > 0) {
                        float f15 = (f11 - f9) + f13;
                        f2 = f12;
                        float f16 = (f10 - f8) + f2;
                        float f17 = 1.0f - (3.0f / i53);
                        int iH = (int) ha0.h(f15, f9, f17, f9);
                        int iH2 = (int) ha0.h(f16, f8, f17, f8);
                        f = f8;
                        for (int i54 = 4; i54 <= 16; i54 <<= 1) {
                            try {
                                y6VarR = w7Var2.r(f14, i54, iH, iH2);
                                float f18 = i52 - 3.5f;
                                if (y6VarR == null) {
                                    f3 = y6VarR.a;
                                    f4 = y6VarR.b;
                                    f5 = f18 - 3.0f;
                                } else {
                                    f3 = (f11 - f9) + f13;
                                    f4 = (f10 - f) + f2;
                                    f5 = f18;
                                }
                                cn cnVarI0 = yr2.i0(cnVarU2, i52, i52, d13.a(3.5f, 3.5f, f18, 3.5f, f5, f5, 3.5f, f18, re1Var.a, re1Var.b, re1Var3.a, re1Var3.b, f3, f4, re1Var2.a, re1Var2.b));
                                if (y6VarR != null) {
                                    i2 = 1;
                                    xk3VarArr = new xk3[]{re1Var2, re1Var, re1Var3};
                                } else {
                                    i2 = 1;
                                    xk3VarArr = new xk3[]{re1Var2, re1Var, re1Var3, y6VarR};
                                }
                                ue1 ue1Var2 = new ue1(cnVarI0, i2);
                                pk0VarK0 = zf2Var.k0(ue1Var2);
                                i3 = pk0VarK0.h;
                                if ((pk0VarK0.g instanceof yb3) && xk3VarArr.length >= 3) {
                                    xk3 xk3Var = xk3VarArr[0];
                                    xk3VarArr[0] = xk3VarArr[2];
                                    xk3VarArr[2] = xk3Var;
                                }
                                vk3Var = new vk3(pk0VarK0.b, pk0VarK0.a, xk3VarArr, sj.C0);
                                list = pk0VarK0.c;
                                if (list != null) {
                                    vk3Var.b(wk3.f, list);
                                }
                                str = pk0VarK0.d;
                                if (str != null) {
                                    vk3Var.b(wk3Var2, str);
                                }
                                if (i3 >= 0 && (i4 = pk0VarK0.i) >= 0) {
                                    vk3Var.b(wk3.B0, Integer.valueOf(i4));
                                    vk3Var.b(wk3.C0, Integer.valueOf(i3));
                                }
                                vk3Var.b(wk3Var, pk0VarK0.e);
                                vk3Var.b(wk3.D0, "]Q" + pk0VarK0.j);
                                return vk3Var;
                            } catch (qs2 unused) {
                            }
                        }
                    } else {
                        f = f8;
                        f2 = f12;
                    }
                    y6VarR = null;
                    float f182 = i52 - 3.5f;
                    if (y6VarR == null) {
                    }
                    cn cnVarI02 = yr2.i0(cnVarU2, i52, i52, d13.a(3.5f, 3.5f, f182, 3.5f, f5, f5, 3.5f, f182, re1Var.a, re1Var.b, re1Var3.a, re1Var3.b, f3, f4, re1Var2.a, re1Var2.b));
                    if (y6VarR != null) {
                    }
                    ue1 ue1Var22 = new ue1(cnVarI02, i2);
                    pk0VarK0 = zf2Var.k0(ue1Var22);
                    i3 = pk0VarK0.h;
                    if (pk0VarK0.g instanceof yb3) {
                        xk3 xk3Var2 = xk3VarArr[0];
                        xk3VarArr[0] = xk3VarArr[2];
                        xk3VarArr[2] = xk3Var2;
                    }
                    vk3Var = new vk3(pk0VarK0.b, pk0VarK0.a, xk3VarArr, sj.C0);
                    list = pk0VarK0.c;
                    if (list != null) {
                    }
                    str = pk0VarK0.d;
                    if (str != null) {
                    }
                    if (i3 >= 0) {
                        vk3Var.b(wk3.B0, Integer.valueOf(i4));
                        vk3Var.b(wk3.C0, Integer.valueOf(i3));
                    }
                    vk3Var.b(wk3Var, pk0VarK0.e);
                    vk3Var.b(wk3.D0, "]Q" + pk0VarK0.j);
                    return vk3Var;
                } catch (IllegalArgumentException unused2) {
                    throw qi1.a();
                }
        }
    }

    public vk3 c(lb lbVar) throws qs2 {
        be3[] be3VarArr = (be3[]) this.b;
        if (be3VarArr != null) {
            int length = be3VarArr.length;
            for (int i = 0; i < length; i++) {
                be3 be3Var = be3VarArr[i];
                if (Thread.currentThread().isInterrupted()) {
                    throw qs2.a();
                }
                try {
                    return be3Var.a(lbVar);
                } catch (de3 unused) {
                }
            }
        }
        throw qs2.a();
    }

    public void g() {
        ArrayList arrayList = new ArrayList();
        if (arrayList.isEmpty()) {
            arrayList.add(new vm2(0));
            arrayList.add(new ki0(3));
            arrayList.add(new ki0(0));
            arrayList.add(new yx2(1));
            arrayList.add(new yx2(0));
            arrayList.add(new ki0(1));
        }
        this.b = (be3[]) arrayList.toArray(d);
    }

    @Override // defpackage.be3
    public final void reset() {
        switch (this.a) {
            case 2:
                be3[] be3VarArr = (be3[]) this.b;
                if (be3VarArr != null) {
                    for (be3 be3Var : be3VarArr) {
                        be3Var.reset();
                    }
                }
                break;
        }
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void f() {
    }
}
