package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import java.util.HashSet;
import org.joni.ast.QuantifierNode;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class zd implements v51 {
    public final Cloneable A;
    public final Object X;
    public Object Y;
    public Object Z;
    public int b;
    public int f;
    public Object z;

    public zd(Class cls, Class... clsArr) {
        this.z = null;
        HashSet hashSet = new HashSet();
        this.A = hashSet;
        this.X = new HashSet();
        this.b = 0;
        this.f = 0;
        this.Z = new HashSet();
        hashSet.add(fc3.a(cls));
        for (Class cls2 : clsArr) {
            ez4.k(cls2, "Null interface");
            ((HashSet) this.A).add(fc3.a(cls2));
        }
    }

    public static boolean n(int i) {
        return i == 7 || i == 11 || i == 12 || i == 13 || i == 15 || i == 99;
    }

    public void a(ho0 ho0Var) {
        if (((HashSet) this.A).contains(ho0Var.a)) {
            xe.k("Components are not allowed to depend on interfaces they themselves provide.");
        } else {
            ((HashSet) this.X).add(ho0Var);
        }
    }

    public void b(int i, int i2, byte[] bArr) {
        int i3 = this.b + i2;
        int[] iArr = (int[]) this.Y;
        if (i3 >= iArr.length) {
            int length = iArr.length;
            do {
                length <<= 1;
            } while (length <= i3);
            int[] iArr2 = new int[length];
            int[] iArr3 = (int[]) this.Y;
            System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            this.Y = iArr2;
        }
        int i4 = i2 + i;
        while (i < i4) {
            int[] iArr4 = (int[]) this.Y;
            int i5 = this.b;
            this.b = i5 + 1;
            iArr4[i5] = bArr[i];
            i++;
        }
    }

    public void c(int i, boolean z, byte[] bArr, int i2, int i3) {
        byte[][] bArr2;
        int iP = p(i2, i3, z);
        e(iP);
        if (iP == 13) {
            e(i2);
        }
        if (n(iP)) {
            if (iP == 15 || iP == 99) {
                e(i3);
            } else {
                e(i3 / i2);
            }
        }
        if (!ja0.C || !n(iP)) {
            b(i, i3, bArr);
            return;
        }
        e(this.f);
        e(i);
        int i4 = this.f;
        if (i4 == 0) {
            bArr2 = new byte[2][];
            this.Z = bArr2;
        } else {
            byte[][] bArr3 = (byte[][]) this.Z;
            if (i4 == bArr3.length) {
                byte[][] bArr4 = new byte[i4 * 2][];
                System.arraycopy(bArr3, 0, bArr4, 0, i4);
                this.Z = bArr4;
                bArr2 = bArr4;
            } else {
                bArr2 = bArr3;
            }
        }
        int i5 = this.f;
        this.f = i5 + 1;
        bArr2[i5] = bArr;
    }

    public int d(int i, int i2, boolean z) {
        int i3;
        int iP = p(i, i2, z);
        if (ja0.C && n(iP)) {
            i3 = 4;
        } else {
            i3 = (n(iP) ? 2 : 1) + i2;
        }
        return iP == 13 ? i3 + 1 : i3;
    }

    public void e(int i) {
        int i2 = this.b;
        int[] iArr = (int[]) this.Y;
        if (i2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length << 1];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.Y = iArr2;
            iArr = iArr2;
        }
        int i3 = this.b;
        this.b = i3 + 1;
        iArr[i3] = i;
    }

    public void f(int[] iArr, int i) {
        int i2 = this.b + i;
        int[] iArr2 = (int[]) this.Y;
        if (i2 >= iArr2.length) {
            int length = iArr2.length;
            do {
                length <<= 1;
            } while (length <= i2);
            iArr2 = new int[length];
            int[] iArr3 = (int[]) this.Y;
            System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            this.Y = iArr2;
        }
        System.arraycopy(iArr, 0, iArr2, this.b, i);
        this.b += i;
    }

    public void g(int i, int i2) {
        e(i);
        e(i2);
    }

    public x80 h() {
        if (((n90) this.Y) != null) {
            return new x80((String) this.z, new HashSet((HashSet) this.A), new HashSet((HashSet) this.X), this.b, this.f, (n90) this.Y, (HashSet) this.Z);
        }
        xe.q("Missing required property: factory.");
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0248 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x024b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int i(es2 es2Var) {
        int i;
        int i2;
        k0 k0Var = (k0) this.A;
        th3 th3Var = (th3) this.X;
        switch (es2Var.getType()) {
            case 0:
                j44 j44Var = (j44) es2Var;
                if (j44Var.d()) {
                    if (j44Var.e() > 0) {
                        return d(1, j44Var.e(), false);
                    }
                } else if (j44Var.e() > 0) {
                    boolean zC = j44Var.c();
                    int i3 = j44Var.b;
                    int i4 = j44Var.c;
                    byte[] bArr = j44Var.a;
                    int iR = k0Var.r(i3, i4, bArr);
                    int i5 = i3 + iR;
                    int i6 = iR;
                    while (i5 < i4) {
                        int iR2 = k0Var.r(i5, i4, bArr);
                        if (iR2 == iR || zC) {
                            i6 += iR2;
                        } else {
                            iD = d(iR, i6, zC) + iD;
                            iR = iR2;
                            i6 = iR;
                        }
                        i5 += iR2;
                    }
                    return d(iR, i6, zC) + iD;
                }
                return 0;
            case 1:
                fu fuVar = (fu) es2Var;
                if (fuVar.c == null) {
                    return 9;
                }
                return fuVar.c.z + 1 + ((k0Var.b > 1 || fuVar.b.e()) ? 1 : 9);
            case 2:
            case 3:
                return 1;
            case 4:
                zh zhVar = (zh) es2Var;
                if (ja0.h && zhVar.isNestLevel()) {
                    return zhVar.b + 4;
                }
                int i7 = zhVar.b;
                if (i7 != 1) {
                    return i7 + 2;
                }
                if (je.M(th3Var.q) || zhVar.a[0] > 2) {
                    return 2;
                }
                break;
            case 5:
                if (!ja0.s) {
                    QuantifierNode quantifierNode = (QuantifierNode) es2Var;
                    boolean zIsRepeatInfinite = QuantifierNode.isRepeatInfinite(quantifierNode.upper);
                    int i8 = quantifierNode.targetEmptyInfo;
                    int i9 = i(quantifierNode.target);
                    if (quantifierNode.target.getType() == 3 && quantifierNode.greedy && zIsRepeatInfinite) {
                        es2 es2Var2 = quantifierNode.nextHeadExact;
                        int i10 = quantifierNode.lower;
                        return es2Var2 != null ? (i9 * i10) + 2 : (i9 * i10) + 1;
                    }
                    int i11 = i8 != 0 ? i9 + 4 : i9;
                    if (zIsRepeatInfinite && ((i = quantifierNode.lower) <= 1 || i9 * i <= 50)) {
                        return ((!quantifierNode.greedy || (quantifierNode.headExact == null && quantifierNode.nextHeadExact == null)) ? i11 + 4 : i11 + 5) + ((i != 1 || i9 <= 50) ? i9 * i : 2);
                    }
                    int i12 = quantifierNode.upper;
                    if (i12 == 0 && quantifierNode.isRefered) {
                        return i9 + 2;
                    }
                    if (zIsRepeatInfinite || !quantifierNode.greedy || (i12 != 1 && (i9 + 2) * i12 > 50)) {
                        return (!quantifierNode.greedy && i12 == 1 && quantifierNode.lower == 0) ? i9 + 4 : i11 + 5;
                    }
                    int i13 = quantifierNode.lower;
                    return ((i12 - i13) * (i9 + 2)) + (i9 * i13);
                }
                QuantifierNode quantifierNode2 = (QuantifierNode) es2Var;
                boolean zIsRepeatInfinite2 = QuantifierNode.isRepeatInfinite(quantifierNode2.upper);
                int i14 = quantifierNode2.targetEmptyInfo;
                int i15 = i(quantifierNode2.target);
                int i16 = th3Var.g > 0 ? quantifierNode2.combExpCheckNum : 0;
                int i17 = i16 > 0 ? 1 : 0;
                if (quantifierNode2.target.getType() == 3 && quantifierNode2.greedy && zIsRepeatInfinite2) {
                    return (quantifierNode2.nextHeadExact == null || i16 > 0) ? (i15 * quantifierNode2.lower) + 1 + i17 : (i15 * quantifierNode2.lower) + 2 + i17;
                }
                int i18 = i14 != 0 ? i15 + 4 : i15;
                if (zIsRepeatInfinite2 && (i2 = quantifierNode2.lower) <= 1) {
                    if (quantifierNode2.greedy) {
                        return i17 + 2 + i18 + 2 + (i2 == 1 ? 2 : 0);
                    }
                    return i18 + 2 + i17 + (i2 == 0 ? 2 : 0);
                }
                int i19 = quantifierNode2.upper;
                if (i19 == 0) {
                    if (quantifierNode2.isRefered) {
                        return i15 + 2;
                    }
                    return 0;
                }
                if (i19 == 1 && quantifierNode2.greedy) {
                    return quantifierNode2.lower == 0 ? i16 > 0 ? i15 + 3 : i15 + 2 : i15;
                }
                if (!quantifierNode2.greedy && i19 == 1 && quantifierNode2.lower == 0) {
                    return i17 + 4 + i15;
                }
                return i16 > 0 ? i18 + 7 : i18 + 5;
            case 6:
                m41 m41Var = (m41) es2Var;
                int i20 = m41Var.a;
                if ((i20 & 2) != 0) {
                    int i21 = th3Var.q;
                    th3Var.q = m41Var.c;
                    int i22 = i(m41Var.d);
                    th3Var.q = i21;
                    int i23 = ja0.a;
                    return i22;
                }
                es2 es2Var3 = m41Var.d;
                iD = es2Var3 != null ? i(es2Var3) : 0;
                if (i20 == 1) {
                    boolean z = ja0.f;
                    return (z && m41Var.isCalled()) ? ez4.d(th3Var.k, m41Var.b) ? iD + 9 : iD + 9 : (z && m41Var.isRecursion()) ? iD + 4 : iD + 4;
                }
                if (i20 == 4) {
                    if (!m41Var.isStopBtSimpleRepeat()) {
                        return iD + 2;
                    }
                    QuantifierNode quantifierNode3 = (QuantifierNode) m41Var.d;
                    int i24 = i(quantifierNode3.target);
                    return (quantifierNode3.lower * i24) + 2 + i24 + 3;
                }
                if (i20 != 8) {
                    if (i20 == 16) {
                        return iD + 4;
                    }
                    o();
                    throw null;
                }
                if (m41Var.d.getType() != 9) {
                    o();
                    throw null;
                }
                bc2 bc2Var = (bc2) m41Var.d;
                int i25 = i(bc2Var.a) + 5;
                bc2 bc2Var2 = bc2Var.b;
                if (bc2Var2 == null) {
                    o();
                    throw null;
                }
                int i26 = i(bc2Var2.a) + i25;
                if (bc2Var2.b == null) {
                    return i26;
                }
                throw new s84("invalid conditional pattern");
            case 7:
                g7 g7Var = (g7) es2Var;
                es2 es2Var4 = g7Var.c;
                iD = es2Var4 != null ? i(es2Var4) : 0;
                int i27 = g7Var.a;
                if (i27 == 1024) {
                    return iD + 2;
                }
                if (i27 == 2048) {
                    return iD + 3;
                }
                if (i27 == 4096) {
                    return iD + 2;
                }
                if (i27 == 8192) {
                    return iD + 4;
                }
                return 1;
            case 8:
                bc2 bc2Var3 = (bc2) es2Var;
                do {
                    iD += i(bc2Var3.a);
                    bc2Var3 = bc2Var3.b;
                } while (bc2Var3 != null);
                return iD;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                bc2 bc2Var4 = (bc2) es2Var;
                int i28 = 0;
                while (true) {
                    iD += i(bc2Var4.a);
                    int i29 = i28 + 1;
                    bc2Var4 = bc2Var4.b;
                    if (bc2Var4 == null) {
                        return (i28 * 4) + iD;
                    }
                    i28 = i29;
                }
                break;
            case 10:
                if (!ja0.f) {
                    return 0;
                }
                break;
            default:
                o();
                throw null;
        }
    }

    public void j(QuantifierNode quantifierNode, int i, int i2) {
        th3 th3Var = (th3) this.X;
        th3Var.c = true;
        int i3 = th3Var.e;
        e(quantifierNode.greedy ? 66 : 67);
        e(i3);
        th3Var.e++;
        e(i + 2);
        int i4 = quantifierNode.lower;
        int i5 = quantifierNode.upper;
        int[] iArr = th3Var.m;
        if (iArr == null) {
            th3Var.m = new int[8];
            th3Var.n = new int[8];
        } else if (i3 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 8];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            th3Var.m = iArr2;
            int[] iArr3 = th3Var.n;
            int[] iArr4 = new int[iArr3.length + 8];
            System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
            th3Var.n = iArr4;
        }
        th3Var.m[i3] = i4;
        int[] iArr5 = th3Var.n;
        if (QuantifierNode.isRepeatInfinite(i5)) {
            i5 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        }
        iArr5[i3] = i5;
        l(quantifierNode.target, i2);
        if ((!ja0.f || th3Var.h <= 0) && !quantifierNode.isInRepeat()) {
            e(quantifierNode.greedy ? 68 : 69);
        } else {
            e(quantifierNode.greedy ? 70 : 71);
        }
        e(i3);
    }

    public void k(es2 es2Var) {
        boolean z;
        int i;
        int i2;
        k0 k0Var = (k0) this.A;
        th3 th3Var = (th3) this.X;
        int i3 = 0;
        switch (es2Var.getType()) {
            case 0:
                j44 j44Var = (j44) es2Var;
                if (j44Var.d()) {
                    if (j44Var.e() <= 0) {
                        return;
                    }
                    c(j44Var.b, false, j44Var.a, 1, j44Var.e());
                    return;
                }
                if (j44Var.e() <= 0) {
                    return;
                }
                boolean zC = j44Var.c();
                int i4 = j44Var.b;
                int i5 = j44Var.c;
                byte[] bArr = j44Var.a;
                int iR = k0Var.r(i4, i5, bArr);
                int i6 = iR;
                int i7 = i4 + iR;
                int i8 = i6;
                while (i7 < i5) {
                    int iR2 = k0Var.r(i7, i5, bArr);
                    if (iR2 == i8 || zC) {
                        z = zC;
                        i6 += iR2;
                    } else {
                        z = zC;
                        c(i4, z, bArr, i8, i6);
                        i4 = i7;
                        i8 = iR2;
                        i6 = i8;
                    }
                    i7 += iR2;
                    zC = z;
                }
                c(i4, zC, bArr, i8, i6);
                return;
            case 1:
                fu fuVar = (fu) es2Var;
                g20 g20Var = fuVar.c;
                dn dnVar = fuVar.b;
                int[] iArr = dnVar.a;
                if (g20Var == null) {
                    if (fuVar.h()) {
                        e(19);
                    } else {
                        e(16);
                    }
                    f(iArr, 8);
                    return;
                }
                if (k0Var.b > 1 || dnVar.e()) {
                    if (fuVar.h()) {
                        e(20);
                    } else {
                        e(17);
                    }
                    g20 g20Var2 = fuVar.c;
                    e(g20Var2.z);
                    f(g20Var2.f, g20Var2.z);
                    return;
                }
                if (fuVar.h()) {
                    e(21);
                } else {
                    e(18);
                }
                f(iArr, 8);
                g20 g20Var3 = fuVar.c;
                e(g20Var3.z);
                f(g20Var3.f, g20Var3.z);
                return;
            case 2:
                iu iuVar = (iu) es2Var;
                if (iuVar.a != 12) {
                    o();
                    throw null;
                }
                boolean z2 = iuVar.b;
                boolean z3 = iuVar.c;
                e(z2 ? z3 ? 35 : 29 : z3 ? 34 : 28);
                return;
            case 3:
                if (je.N(th3Var.q)) {
                    e(23);
                    return;
                } else {
                    e(22);
                    return;
                }
            case 4:
                zh zhVar = (zh) es2Var;
                int[] iArr2 = zhVar.a;
                if (ja0.h && zhVar.isNestLevel()) {
                    e(52);
                    e(th3Var.q & 1);
                    e(zhVar.c);
                    e(zhVar.b);
                    for (int i9 = zhVar.b - 1; i9 >= 0; i9--) {
                        e(iArr2[i9]);
                    }
                    return;
                }
                int i10 = zhVar.b;
                int i11 = th3Var.q;
                if (i10 != 1) {
                    if (je.M(i11)) {
                        e(51);
                    } else {
                        e(50);
                    }
                    e(zhVar.b);
                    for (int i12 = zhVar.b - 1; i12 >= 0; i12--) {
                        e(iArr2[i12]);
                    }
                    return;
                }
                if (je.M(i11)) {
                    e(49);
                    e(iArr2[0]);
                    return;
                }
                int i13 = iArr2[0];
                if (i13 == 1) {
                    e(46);
                    return;
                } else if (i13 == 2) {
                    e(47);
                    return;
                } else {
                    e(48);
                    e(iArr2[0]);
                    return;
                }
            case 5:
                if (!ja0.s) {
                    QuantifierNode quantifierNode = (QuantifierNode) es2Var;
                    th3Var.c = true;
                    boolean zIsRepeatInfinite = QuantifierNode.isRepeatInfinite(quantifierNode.upper);
                    int i14 = quantifierNode.targetEmptyInfo;
                    int i15 = i(quantifierNode.target);
                    if (quantifierNode.isAnyCharStar()) {
                        m(quantifierNode.target, quantifierNode.lower);
                        es2 es2Var2 = quantifierNode.nextHeadExact;
                        int i16 = th3Var.q;
                        if (es2Var2 == null) {
                            if (je.N(i16)) {
                                e(25);
                                return;
                            } else {
                                e(24);
                                return;
                            }
                        }
                        if (je.N(i16)) {
                            e(27);
                        } else {
                            e(26);
                        }
                        j44 j44Var2 = (j44) quantifierNode.nextHeadExact;
                        b(j44Var2.b, 1, j44Var2.a);
                        return;
                    }
                    int i17 = i14 != 0 ? i15 + 4 : i15;
                    if (!zIsRepeatInfinite || ((i = quantifierNode.lower) > 1 && i15 * i > 50)) {
                        int i18 = quantifierNode.upper;
                        if (i18 == 0 && quantifierNode.isRefered) {
                            g(61, i15);
                            k(quantifierNode.target);
                            return;
                        }
                        if (zIsRepeatInfinite || !quantifierNode.greedy || (i18 != 1 && (i15 + 2) * i18 > 50)) {
                            if (quantifierNode.greedy || i18 != 1 || quantifierNode.lower != 0) {
                                j(quantifierNode, i17, i14);
                                return;
                            }
                            g(62, 2);
                            g(61, i15);
                            k(quantifierNode.target);
                            return;
                        }
                        int i19 = quantifierNode.lower;
                        int i20 = i18 - i19;
                        m(quantifierNode.target, i19);
                        for (int i21 = 0; i21 < i20; i21++) {
                            int i22 = i20 - i21;
                            g(62, ((i22 - 1) * 2) + (i22 * i15));
                            k(quantifierNode.target);
                        }
                        return;
                    }
                    if (i != 1 || i15 <= 50) {
                        m(quantifierNode.target, i);
                    } else if (!quantifierNode.greedy) {
                        g(61, 2);
                    } else if (quantifierNode.headExact == null && quantifierNode.nextHeadExact == null) {
                        g(61, 2);
                    } else {
                        g(61, 3);
                    }
                    if (!quantifierNode.greedy) {
                        g(61, i17);
                        l(quantifierNode.target, i14);
                        g(62, -(i17 + 2));
                        return;
                    }
                    if (quantifierNode.headExact != null) {
                        g(64, i17 + 2);
                        j44 j44Var3 = (j44) quantifierNode.headExact;
                        b(j44Var3.b, 1, j44Var3.a);
                        l(quantifierNode.target, i14);
                        g(61, -(i17 + 5));
                        return;
                    }
                    if (quantifierNode.nextHeadExact == null) {
                        g(62, i17 + 2);
                        l(quantifierNode.target, i14);
                        g(61, -(i17 + 4));
                        return;
                    } else {
                        g(65, i17 + 2);
                        j44 j44Var4 = (j44) quantifierNode.nextHeadExact;
                        b(j44Var4.b, 1, j44Var4.a);
                        l(quantifierNode.target, i14);
                        g(61, -(i17 + 5));
                        return;
                    }
                }
                QuantifierNode quantifierNode2 = (QuantifierNode) es2Var;
                th3Var.c = true;
                boolean zIsRepeatInfinite2 = QuantifierNode.isRepeatInfinite(quantifierNode2.upper);
                int i23 = quantifierNode2.targetEmptyInfo;
                int i24 = i(quantifierNode2.target);
                int i25 = th3Var.g > 0 ? quantifierNode2.combExpCheckNum : 0;
                if (quantifierNode2.isAnyCharStar()) {
                    m(quantifierNode2.target, quantifierNode2.lower);
                    if (quantifierNode2.nextHeadExact != null && i25 <= 0) {
                        if (je.N(th3Var.q)) {
                            e(27);
                        } else {
                            e(26);
                        }
                        if (i25 > 0) {
                            e(i25);
                        }
                        j44 j44Var5 = (j44) quantifierNode2.nextHeadExact;
                        b(j44Var5.b, 1, j44Var5.a);
                        return;
                    }
                    if (je.N(th3Var.q)) {
                        if (i25 > 0) {
                            e(95);
                        } else {
                            e(25);
                        }
                    } else if (i25 > 0) {
                        e(94);
                    } else {
                        e(24);
                    }
                    if (i25 > 0) {
                        e(i25);
                        return;
                    }
                    return;
                }
                int i26 = i23 != 0 ? i24 + 4 : i24;
                if (zIsRepeatInfinite2 && (i2 = quantifierNode2.lower) <= 1) {
                    if (quantifierNode2.greedy) {
                        if (i2 == 1) {
                            g(61, i25 > 0 ? 3 : 2);
                        }
                        if (i25 > 0) {
                            e(91);
                            e(i25);
                            e(i26 + 2);
                        } else {
                            g(62, i26 + 2);
                        }
                        l(quantifierNode2.target, i23);
                        g(61, -(i26 + 2 + (i25 <= 0 ? 2 : 3)));
                        return;
                    }
                    if (i2 == 0) {
                        g(61, i26);
                    }
                    l(quantifierNode2.target, i23);
                    if (i25 <= 0) {
                        g(62, -(i26 + 2));
                        return;
                    }
                    e(92);
                    e(i25);
                    e(-(i26 + 3));
                    return;
                }
                int i27 = quantifierNode2.upper;
                if (i27 == 0) {
                    if (quantifierNode2.isRefered) {
                        g(61, i24);
                        k(quantifierNode2.target);
                        return;
                    }
                    return;
                }
                if (i27 == 1 && quantifierNode2.greedy) {
                    if (quantifierNode2.lower == 0) {
                        if (i25 > 0) {
                            e(91);
                            e(i25);
                            e(i24);
                        } else {
                            g(62, i24);
                        }
                    }
                    k(quantifierNode2.target);
                    return;
                }
                if (quantifierNode2.greedy || i27 != 1 || quantifierNode2.lower != 0) {
                    j(quantifierNode2, i26, i23);
                    if (i25 > 0) {
                        e(93);
                        e(i25);
                        return;
                    }
                    return;
                }
                if (i25 > 0) {
                    e(91);
                    e(i25);
                    e(2);
                } else {
                    g(62, 2);
                }
                g(61, i24);
                k(quantifierNode2.target);
                return;
            case 6:
                m41 m41Var = (m41) es2Var;
                int i28 = m41Var.a;
                if ((i28 & 2) != 0) {
                    int i29 = th3Var.q;
                    int i30 = ja0.a;
                    th3Var.q = m41Var.c;
                    k(m41Var.d);
                    th3Var.q = i29;
                    return;
                }
                if (i28 == 1) {
                    boolean z4 = ja0.f;
                    if (z4 && m41Var.isCalled()) {
                        th3Var.c = true;
                        e(88);
                        m41Var.e = this.b + 3;
                        m41Var.setAddrFixed();
                        e(m41Var.e);
                        int i31 = i(m41Var.d);
                        ez4.d(th3Var.k, m41Var.b);
                        g(61, i31 + 5);
                    }
                    if (ez4.d(th3Var.j, m41Var.b)) {
                        th3Var.c = true;
                        e(54);
                    } else {
                        e(53);
                    }
                    e(m41Var.b);
                    k(m41Var.d);
                    if (z4 && m41Var.isCalled()) {
                        if (ez4.d(th3Var.k, m41Var.b)) {
                            e(m41Var.isRecursion() ? 56 : 55);
                        } else {
                            e(m41Var.isRecursion() ? 58 : 57);
                        }
                        e(m41Var.b);
                        e(89);
                        return;
                    }
                    if (z4 && m41Var.isRecursion()) {
                        if (ez4.d(th3Var.k, m41Var.b)) {
                            e(56);
                        } else {
                            e(58);
                        }
                        e(m41Var.b);
                        return;
                    }
                    if (ez4.d(th3Var.k, m41Var.b)) {
                        e(55);
                    } else {
                        e(57);
                    }
                    e(m41Var.b);
                    return;
                }
                if (i28 == 4) {
                    th3Var.c = true;
                    if (!m41Var.isStopBtSimpleRepeat()) {
                        e(80);
                        k(m41Var.d);
                        e(81);
                        return;
                    }
                    QuantifierNode quantifierNode3 = (QuantifierNode) m41Var.d;
                    m(quantifierNode3.target, quantifierNode3.lower);
                    int i32 = i(quantifierNode3.target);
                    g(62, i32 + 3);
                    k(quantifierNode3.target);
                    e(63);
                    g(61, -(i32 + 5));
                    return;
                }
                if (i28 != 8) {
                    if (i28 != 16) {
                        o();
                        throw null;
                    }
                    th3Var.c = true;
                    int i33 = i(m41Var.d);
                    e(85);
                    g(86, i33 + 1);
                    k(m41Var.d);
                    e(87);
                    return;
                }
                e(90);
                e(m41Var.b);
                if (m41Var.d.getType() != 9) {
                    o();
                    throw null;
                }
                bc2 bc2Var = (bc2) m41Var.d;
                int i34 = i(bc2Var.a);
                bc2 bc2Var2 = bc2Var.b;
                if (bc2Var2 == null) {
                    o();
                    throw null;
                }
                int i35 = i(bc2Var2.a);
                if (bc2Var2.b != null) {
                    throw new s84("invalid conditional pattern");
                }
                bc2 bc2Var3 = (bc2) m41Var.d;
                e(i34 + 2);
                k(bc2Var3.a);
                g(61, i35);
                k(bc2Var3.b.a);
                return;
            case 7:
                g7 g7Var = (g7) es2Var;
                b7 b7Var = (b7) this.z;
                int i36 = g7Var.a;
                boolean z5 = g7Var.b;
                if (i36 == 1) {
                    e(40);
                    return;
                }
                if (i36 == 2) {
                    e(42);
                    return;
                }
                switch (i36) {
                    case 4:
                        e(45);
                        return;
                    case 8:
                        e(41);
                        return;
                    case 16:
                        e(44);
                        return;
                    case 32:
                        e(43);
                        return;
                    case 64:
                        if (z5) {
                            e(36);
                            return;
                        } else {
                            e(30);
                            return;
                        }
                    case 128:
                        if (z5) {
                            e(37);
                            return;
                        } else {
                            e(31);
                            return;
                        }
                    case 256:
                        if (ja0.p) {
                            if (z5) {
                                e(38);
                                return;
                            } else {
                                e(32);
                                return;
                            }
                        }
                        return;
                    case 512:
                        if (ja0.p) {
                            if (z5) {
                                e(39);
                                return;
                            } else {
                                e(33);
                                return;
                            }
                        }
                        return;
                    case 1024:
                        th3Var.c = true;
                        e(76);
                        k(g7Var.c);
                        e(77);
                        return;
                    case 2048:
                        th3Var.c = true;
                        g(78, i(g7Var.c) + 1);
                        k(g7Var.c);
                        e(79);
                        return;
                    case 4096:
                        e(82);
                        int iQ = g7Var.d;
                        if (iQ < 0) {
                            iQ = b7Var.Q(g7Var.c, 0);
                            if (b7Var.G0 != 0) {
                                throw new s84("invalid pattern in look-behind");
                            }
                        }
                        e(iQ);
                        k(g7Var.c);
                        return;
                    case 8192:
                        th3Var.c = true;
                        g(83, i(g7Var.c) + 1);
                        int iQ2 = g7Var.d;
                        if (iQ2 < 0) {
                            iQ2 = b7Var.Q(g7Var.c, 0);
                            if (b7Var.G0 != 0) {
                                throw new s84("invalid pattern in look-behind");
                            }
                        }
                        e(iQ2);
                        k(g7Var.c);
                        e(84);
                        return;
                    case 65536:
                        e(59);
                        return;
                    default:
                        o();
                        throw null;
                }
            case 8:
                bc2 bc2Var4 = (bc2) es2Var;
                do {
                    k(bc2Var4.a);
                    bc2Var4 = bc2Var4.b;
                } while (bc2Var4 != null);
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                bc2 bc2Var5 = (bc2) es2Var;
                bc2 bc2Var6 = bc2Var5;
                do {
                    int i37 = i(bc2Var6.a) + i3;
                    bc2Var6 = bc2Var6.b;
                    if (bc2Var6 != null) {
                        i37 += 4;
                    }
                    i3 = i37;
                } while (bc2Var6 != null);
                int i38 = this.b + i3;
                do {
                    int i39 = i(bc2Var5.a);
                    if (bc2Var5.b != null) {
                        th3Var.c = true;
                        g(62, i39 + 2);
                    }
                    k(bc2Var5.a);
                    if (bc2Var5.b != null) {
                        g(61, i38 - (this.b + 2));
                    }
                    bc2Var5 = bc2Var5.b;
                } while (bc2Var5 != null);
                return;
            case 10:
                if (ja0.f) {
                    ov ovVar = (ov) es2Var;
                    e(88);
                    qt qtVar = ovVar.f;
                    int i40 = this.b;
                    m41 m41Var2 = ovVar.e;
                    int i41 = qtVar.b;
                    int[] iArr3 = (int[]) qtVar.d;
                    if (i41 >= iArr3.length) {
                        m41[] m41VarArr = (m41[]) qtVar.c;
                        m41[] m41VarArr2 = new m41[m41VarArr.length << 1];
                        System.arraycopy(m41VarArr, 0, m41VarArr2, 0, i41);
                        qtVar.c = m41VarArr2;
                        int[] iArr4 = (int[]) qtVar.d;
                        iArr3 = new int[iArr4.length << 1];
                        System.arraycopy(iArr4, 0, iArr3, 0, qtVar.b);
                        qtVar.d = iArr3;
                    }
                    m41[] m41VarArr3 = (m41[]) qtVar.c;
                    int i42 = qtVar.b;
                    m41VarArr3[i42] = m41Var2;
                    iArr3[i42] = i40;
                    qtVar.b = i42 + 1;
                    e(0);
                    return;
                }
                return;
            default:
                o();
                throw null;
        }
    }

    public void l(es2 es2Var, int i) {
        th3 th3Var = (th3) this.X;
        int i2 = th3Var.f;
        if (i != 0) {
            th3Var.c = true;
            e(72);
            e(th3Var.f);
            th3Var.f++;
        }
        k(es2Var);
        if (i != 0) {
            if (i == 1) {
                e(73);
            } else if (i == 2) {
                e(74);
            } else if (i == 3) {
                e(75);
            }
            e(i2);
        }
    }

    public void m(es2 es2Var, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            k(es2Var);
        }
    }

    public void o() {
        throw new l12("internal parser error (bug)");
    }

    public int p(int i, int i2, boolean z) {
        int i3 = ((i2 + i) - 1) / i;
        if (z) {
            k0 k0Var = (k0) this.A;
            return i3 != 1 ? k0Var.B() != null ? 99 : 15 : k0Var.B() != null ? 98 : 14;
        }
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 13 : 12;
            }
            if (i3 == 1) {
                return 8;
            }
            if (i3 != 2) {
                return i3 != 3 ? 11 : 10;
            }
            return 9;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 3;
        }
        if (i3 == 3) {
            return 4;
        }
        if (i3 != 4) {
            return i3 != 5 ? 7 : 6;
        }
        return 5;
    }

    public zd(b7 b7Var) {
        this.z = b7Var;
        th3 th3Var = b7Var.C0;
        this.X = th3Var;
        this.A = th3Var.p;
    }
}
