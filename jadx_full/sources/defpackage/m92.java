package defpackage;

import io.netty.channel.internal.ChannelUtils;
import io.netty.channel.unix.Socket;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.ssl.OpenSslSessionTicketKey;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import org.joni.ast.QuantifierNode;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m92 extends ue2 implements v51 {
    public static final int[] F0 = {58, 93};
    public final k0 A;
    public final int A0;
    public int B0;
    public final th3 C0;
    public final up3 D0;
    public final se4 E0 = new se4();
    public final byte[] X;
    public int Y;
    public int Z;
    public int y0;
    public int z0;

    public m92(th3 th3Var, byte[] bArr, int i) {
        this.A = th3Var.p;
        this.X = bArr;
        this.A0 = i;
        this.C0 = th3Var;
        this.D0 = new up3(th3Var);
    }

    public static int D(int i) {
        if (i == 39) {
            return 39;
        }
        if (i == 40) {
            return 41;
        }
        if (i != 60) {
            return i != 123 ? 0 : 125;
        }
        return 62;
    }

    public static void G(String str) {
        throw new go4(str);
    }

    public final void A() {
        int i = this.Y;
        this.y0 = i;
        byte[] bArr = this.X;
        this.Y = this.A.r(i, this.Z, bArr) + i;
    }

    public final void B(boolean z) {
        if (z) {
            this.Y = this.B0;
        } else {
            E("invalid repeat range {lower,upper}");
            throw null;
        }
    }

    public final boolean C() {
        return this.Y < this.Z;
    }

    public final void E(String str) {
        throw new s84(str);
    }

    public final void F(int i, int i2, String str) {
        throw new go4(str.replaceAll("%n", new String(this.X, i, i2 - i)));
    }

    public final int H() {
        int i = this.Y;
        int i2 = this.Z;
        if (i < i2) {
            return this.A.u(i, i2, this.X);
        }
        return 0;
    }

    public final boolean I(int i) {
        return H() == i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if (r3.a == 12) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void J() {
        boolean zC = C();
        se4 se4Var = this.E0;
        if (zC && I(43)) {
            if (!(((-1570030630) & 16) != 0) || se4Var.a == 12) {
                if (((-1570030630) & 32) != 0) {
                }
            }
            k();
            se4Var.g = 1;
            se4Var.h = 1;
            return;
        }
        se4Var.g = 1;
        se4Var.h = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
    
        if (r8 <= r7) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        r6.z0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int K(int i, int i2) {
        int i3 = this.z0;
        int i4 = i2 - i;
        int i5 = 0;
        while (true) {
            if (!C()) {
                break;
            }
            int i6 = i2 - 1;
            if (i2 == 0) {
                i2 = i6;
                break;
            }
            k();
            int i7 = this.z0;
            k0 k0Var = this.A;
            if (!k0Var.j(i7, 11)) {
                this.Y = this.y0;
                break;
            }
            int i8 = this.z0;
            int i9 = k0Var.j(i8, 4) ? i8 - 48 : k0Var.j(i8, 10) ? i8 - 55 : i8 - 87;
            if ((ChannelUtils.WRITE_STATUS_SNDBUF_FULL - i9) / 16 < i5) {
                return -1;
            }
            i5 = (i5 << 4) + i9;
            i2 = i6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        r5.z0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int L() {
        int i = this.z0;
        int i2 = 0;
        while (true) {
            if (!C()) {
                break;
            }
            k();
            if (!this.A.j(this.z0, 4)) {
                this.Y = this.y0;
                break;
            }
            int i3 = (i2 * 10) + (this.z0 - 48);
            if (((i2 ^ i3) & Integer.MIN_VALUE) != 0) {
                return -1;
            }
            i2 = i3;
        }
    }

    public final int M(int i) {
        int i2;
        int i3 = this.z0;
        int i4 = 0;
        while (C()) {
            int i5 = i - 1;
            if (i == 0) {
                break;
            }
            k();
            if (!this.A.j(this.z0, 4) || (i2 = this.z0) >= 56) {
                this.Y = this.y0;
                break;
            }
            int i6 = (i2 - 48) + (i4 << 3);
            if (((i4 ^ i6) & Integer.MIN_VALUE) != 0) {
                return -1;
            }
            i4 = i6;
            i = i5;
        }
        this.z0 = i3;
        return i4;
    }

    public final void k() {
        int i = this.Y;
        int i2 = this.Z;
        k0 k0Var = this.A;
        byte[] bArr = this.X;
        this.z0 = k0Var.u(i, i2, bArr);
        int i3 = this.Y;
        this.y0 = i3;
        this.Y = k0Var.r(i3, this.Z, bArr) + i3;
    }

    public final int l() {
        this.B0 = this.Y;
        while (C()) {
            int i = this.Y;
            k();
            int i2 = this.z0;
            byte[] bArr = this.X;
            if (i2 == 125) {
                return this.A.w(bArr, this.B0, i);
            }
            if (i2 == 40 || i2 == 41 || i2 == 123 || i2 == 124) {
                du duVar = q41.f;
                throw new w30(this.B0, i, bArr);
            }
        }
        F(this.B0, this.Z, "property name never terminated \\p{%n");
        throw null;
    }

    public final void m() {
        if (!C()) {
            E("end pattern at escape");
            throw null;
        }
        k();
        int i = this.z0;
        if (i == 67) {
            if (!(((-1570030630) & 2048) != 0)) {
                n();
                return;
            }
            if (!C()) {
                E("end pattern at control");
                throw null;
            }
            k();
            if (this.z0 == 45) {
                o();
                return;
            } else {
                E("invalid control-code syntax");
                throw null;
            }
        }
        if (i != 77) {
            if (i == 99) {
                if ((134217728 & 2146948438) != 0) {
                    o();
                }
            }
            n();
            return;
        }
        if (!(((-1570030630) & 4096) != 0)) {
            n();
            return;
        }
        if (!C()) {
            E("end pattern at meta");
            throw null;
        }
        k();
        if (this.z0 != 45) {
            E("invalid meta-code syntax");
            throw null;
        }
        if (!C()) {
            E("end pattern at meta");
            throw null;
        }
        k();
        if (this.z0 == 92) {
            m();
        }
        this.z0 = (this.z0 & DnsRecord.CLASS_ANY) | 128;
    }

    public final void n() {
        int i = this.z0;
        if ((67108864 & 2146948438) != 0) {
            if (i == 97) {
                i = 7;
            } else if (i == 98) {
                i = 8;
            } else if (i == 101) {
                i = 27;
            } else if (i == 102) {
                i = 12;
            } else if (i == 110) {
                i = 10;
            } else if (i == 114) {
                i = 13;
            } else if (i == 116) {
                i = 9;
            } else if (i == 118) {
                if (((-1570030630) & 8192) != 0) {
                    i = 11;
                }
            } else if ((97 <= i && i <= 122) || (65 <= i && i <= 90)) {
                String.valueOf((char) i);
            }
        }
        this.z0 = i;
    }

    public final void o() {
        if (!C()) {
            E("end pattern at control");
            throw null;
        }
        k();
        int i = this.z0;
        if (i == 63) {
            this.z0 = 127;
            return;
        }
        if (i == 92) {
            m();
        }
        this.z0 &= 159;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int p(int i, boolean z) {
        String str;
        int i2;
        char c;
        String str2;
        int i3;
        boolean z2 = ja0.e;
        int i4 = this.Y;
        String str3 = v51.q;
        int i5 = 0;
        k0 k0Var = this.A;
        if (z2) {
            this.b = 0;
            int iD = D(i);
            int i6 = this.Y;
            int i7 = this.Z;
            if (!C()) {
                G("group name is empty");
                throw null;
            }
            k();
            int i8 = this.z0;
            if (i8 == iD) {
                G("group name is empty");
                throw null;
            }
            if (k0Var.j(i8, 4)) {
                if (z) {
                    str2 = null;
                    c = 1;
                } else {
                    c = 0;
                    str2 = "invalid group name <%n>";
                }
                i3 = 1;
            } else if (this.z0 == 45) {
                if (z) {
                    i6 = this.Y;
                    c = 2;
                    str2 = null;
                    i3 = -1;
                }
                c = 0;
                str2 = "invalid group name <%n>";
                i3 = 1;
            } else {
                c = 0;
                str2 = null;
                i3 = 1;
            }
            if (str2 != null) {
                q(i4, iD, i7, str2);
                throw null;
            }
            while (C()) {
                i7 = this.Y;
                k();
                int i9 = this.z0;
                if (i9 == iD || i9 == 41) {
                    if (c == 2) {
                        q(i4, iD, i7, "invalid group name <%n>");
                        throw null;
                    }
                    if (this.z0 == iD) {
                        F(i4, this.Z, "invalid group name <%n>");
                        throw null;
                    }
                    if (c != 0) {
                        this.B0 = this.Y;
                        this.Y = i6;
                        int iL = L();
                        this.Y = this.B0;
                        if (iL < 0) {
                            G("too big number");
                            throw null;
                        }
                        if (iL == 0) {
                            F(i4, i7, "invalid group name <%n>");
                            throw null;
                        }
                        i5 = iL * i3;
                    }
                    this.b = i7;
                    return i5;
                }
                if (c != 0) {
                    if (!k0Var.j(i9, 4)) {
                        if (k0Var.j(this.z0, 12)) {
                            str3 = "invalid group name <%n>";
                        }
                        q(i4, iD, i7, str3);
                        throw null;
                    }
                    c = 1;
                }
            }
            if (this.z0 == iD) {
            }
        } else {
            this.b = 0;
            int iD2 = D(i);
            int i10 = this.Y;
            int i11 = this.Z;
            if (!C()) {
                G("group name is empty");
                throw null;
            }
            k();
            int i12 = this.z0;
            if (i12 == iD2) {
                G("group name is empty");
                throw null;
            }
            if (k0Var.j(i12, 4)) {
                str = null;
            } else {
                if (this.z0 == 45) {
                    i10 = this.Y;
                    str = null;
                    i2 = -1;
                    while (C()) {
                        i11 = this.Y;
                        k();
                        int i13 = this.z0;
                        if (i13 == iD2 || i13 == 41) {
                            break;
                        }
                        if (!k0Var.j(i13, 4)) {
                            str = str3;
                        }
                    }
                    if (str == null && this.z0 != iD2) {
                        i11 = this.Z;
                        str = "invalid group name <%n>";
                    }
                    if (str == null) {
                        F(i4, i11, str);
                        throw null;
                    }
                    this.B0 = this.Y;
                    this.Y = i10;
                    int iL2 = L();
                    this.Y = this.B0;
                    if (iL2 < 0) {
                        G("too big number");
                        throw null;
                    }
                    if (iL2 == 0) {
                        F(i4, i11, "invalid group name <%n>");
                        throw null;
                    }
                    int i14 = iL2 * i2;
                    this.b = i11;
                    return i14;
                }
                str = str3;
            }
            i2 = 1;
            while (C()) {
            }
            if (str == null) {
                i11 = this.Z;
                str = "invalid group name <%n>";
            }
            if (str == null) {
            }
        }
    }

    public final void q(int i, int i2, int i3, String str) {
        while (C()) {
            i3 = this.Y;
            k();
            int i4 = this.z0;
            if (i4 == i2 || i4 == 41) {
                break;
            }
        }
        if (!C()) {
            i3 = this.Z;
        }
        F(i, i3, str);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:147:0x006f A[EDGE_INSN: B:147:0x006f->B:32:0x006f BREAK  A[LOOP:0: B:16:0x0042->B:155:0x0042], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r() {
        int i;
        Throwable th;
        int iP;
        m41[] m41VarArr;
        m41[] m41VarArr2;
        Object obj;
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        int i7 = this.Y;
        boolean z2 = ja0.h;
        int i8 = this.z0;
        se4 se4Var = this.E0;
        if (z2) {
            int iD = D(i8);
            int i9 = this.Y;
            int i10 = this.Z;
            if (!C()) {
                G("group name is empty");
                throw null;
            }
            k();
            int i11 = this.z0;
            if (i11 == iD) {
                G("group name is empty");
                throw null;
            }
            k0 k0Var = this.A;
            if (k0Var.j(i11, 4)) {
                obj = null;
                c = 1;
            } else if (this.z0 == 45) {
                i9 = this.Y;
                c = 2;
                obj = null;
                i2 = -1;
                while (true) {
                    th = null;
                    if (C()) {
                        break;
                    }
                    i10 = this.Y;
                    k();
                    int i12 = this.z0;
                    if (i12 == iD || i12 == 41 || i12 == 43 || i12 == 45) {
                        break;
                    }
                    if (c != 0) {
                        if (k0Var.j(i12, 4)) {
                            c = 1;
                        } else {
                            obj = "invalid group name <%n>";
                        }
                    }
                }
                if (c == 2) {
                    obj = "invalid group name <%n>";
                }
                if (obj == null || (i6 = this.z0) == iD) {
                    i3 = 0;
                    i4 = 0;
                } else {
                    if (i6 == 43 || i6 == 45) {
                        int i13 = i6 == 45 ? -1 : 1;
                        if (!C()) {
                            G(v51.q);
                            throw null;
                        }
                        k();
                        if (!k0Var.j(this.z0, 4)) {
                            F(i7, this.Z, "invalid group name <%n>");
                            throw null;
                        }
                        this.Y = this.y0;
                        int iL = L();
                        if (iL < 0) {
                            G("too big number");
                            throw null;
                        }
                        i3 = iL * i13;
                        if (C()) {
                            k();
                            z = this.z0 == iD;
                            i4 = 1;
                        }
                    } else {
                        z = false;
                        i3 = 0;
                        i4 = 0;
                    }
                    if (!z) {
                        i10 = this.Z;
                        obj = "invalid group name <%n>";
                    }
                }
                if (obj == null) {
                    F(i7, i10, "invalid group name <%n>");
                    throw null;
                }
                if (c != 0) {
                    this.B0 = this.Y;
                    this.Y = i9;
                    int iL2 = L();
                    this.Y = this.B0;
                    if (iL2 < 0) {
                        G("too big number");
                        throw null;
                    }
                    if (iL2 == 0) {
                        F(i7, this.Z, "invalid group name <%n>");
                        throw null;
                    }
                    i5 = iL2 * i2;
                } else {
                    i5 = 0;
                }
                this.b = i10;
                se4Var.h = i4;
                se4Var.i = i3;
                iP = i5;
                i = 1;
            } else {
                obj = null;
                c = 0;
            }
            i2 = 1;
            while (true) {
                th = null;
                if (C()) {
                }
            }
            if (c == 2) {
            }
            if (obj == null) {
                i3 = 0;
                i4 = 0;
                if (obj == null) {
                }
            }
        } else {
            i = 1;
            th = null;
            iP = p(i8, true);
        }
        int i14 = this.b;
        up3 up3Var = this.D0;
        String str = v51.p;
        if (iP != 0) {
            if (iP < 0 && (iP = iP + up3Var.j + i) <= 0) {
                G(str);
                throw th;
            }
            if ((((-2019556389) & 32) != 0) && (iP > up3Var.j || up3Var.l == null)) {
                G(str);
                throw th;
            }
            se4Var.a = 8;
            se4Var.g = 0;
            se4Var.e = 1;
            se4Var.f = iP;
            return;
        }
        du duVar = this.C0.s;
        ho2 ho2Var = duVar != null ? (ho2) duVar.b(i7, i14, this.X) : th;
        if (ho2Var == 0) {
            F(i7, i14, "undefined name <%n> reference");
            throw th;
        }
        if (((-2019556389) & 32) != 0) {
            if (ho2Var.d == 1) {
                int i15 = ho2Var.e;
                if (i15 > up3Var.j || (m41VarArr2 = up3Var.l) == null || m41VarArr2[i15] == null) {
                    G(str);
                    throw th;
                }
            } else {
                for (int i16 = 0; i16 < ho2Var.d; i16++) {
                    int i17 = ho2Var.f[i16];
                    if (i17 > up3Var.j || (m41VarArr = up3Var.l) == null || m41VarArr[i17] == null) {
                        G(str);
                        throw th;
                    }
                }
            }
        }
        se4Var.a = 8;
        se4Var.g = 1;
        int i18 = ho2Var.d;
        if (i18 == 1) {
            se4Var.e = 1;
            se4Var.f = ho2Var.e;
        } else {
            se4Var.e = i18;
            se4Var.j = ho2Var.f;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:410:0x0536, code lost:
    
        if (r1.b(4096) == false) goto L550;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0538, code lost:
    
        r3.a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x053c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0215  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s() {
        m41[] m41VarArr;
        int i;
        int i2;
        while (true) {
            boolean zC = C();
            se4 se4Var = this.E0;
            if (!zC) {
                se4Var.a = 1;
                return;
            }
            se4Var.a = 4;
            se4Var.c = 0;
            se4Var.d = this.Y;
            k();
            int i3 = this.z0;
            k0 k0Var = this.A;
            up3 up3Var = this.D0;
            r84 r84Var = r84.a;
            if (i3 == 92 && !r84Var.c(1048576)) {
                if (!C()) {
                    E("end pattern at escape");
                    throw null;
                }
                se4Var.d = this.Y;
                k();
                int i4 = this.z0;
                se4Var.e = i4;
                se4Var.b = true;
                byte[] bArr = this.X;
                switch (i4) {
                    case 39:
                        if (r84Var.c(32768)) {
                            t(8);
                            return;
                        }
                        return;
                    case 40:
                        if (r84Var.b(8192)) {
                            se4Var.a = 15;
                            return;
                        }
                        return;
                    case 41:
                        if (r84Var.b(8192)) {
                            se4Var.a = 16;
                            return;
                        }
                        return;
                    case 42:
                        if (r84Var.b(8)) {
                            v(0, -1);
                            return;
                        }
                        return;
                    case 43:
                        if (r84Var.b(32)) {
                            v(1, -1);
                            return;
                        }
                        return;
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 58:
                    case 59:
                    case 61:
                    case 64:
                    case 67:
                    case 69:
                    case 70:
                    case 73:
                    case 74:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 84:
                    case 85:
                    case 86:
                    case 89:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 97:
                    case 99:
                    case 101:
                    case 102:
                    case 105:
                    case 106:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 113:
                    case 114:
                    case 116:
                    case 118:
                    case 121:
                    default:
                        this.Y = this.y0;
                        m();
                        int i5 = se4Var.e;
                        int i6 = this.z0;
                        if (i5 != i6) {
                            se4Var.a = 5;
                            se4Var.e = i6;
                            return;
                        }
                        int iR = k0Var.r(se4Var.d, this.Z, bArr);
                        if (iR != -1) {
                            this.Y = se4Var.d + iR;
                            return;
                        } else {
                            xe.k("Invalid character found.");
                            return;
                        }
                    case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                        w();
                        return;
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        int i7 = this.y0;
                        this.Y = i7;
                        int iL = L();
                        if (iL < 0 || iL > ja0.u || !r84Var.b(65536) || (iL > up3Var.j && iL > 9)) {
                            int i8 = this.z0;
                            if (i8 == 56 || i8 == 57) {
                                this.Y = i7;
                                A();
                                return;
                            } else {
                                this.Y = i7;
                                w();
                                return;
                            }
                        }
                        if (r84Var.a(32) && (iL > up3Var.j || (m41VarArr = up3Var.l) == null || m41VarArr[iL] == null)) {
                            G(v51.p);
                            throw null;
                        }
                        se4Var.a = 8;
                        se4Var.e = 1;
                        se4Var.f = iL;
                        se4Var.g = 0;
                        if (ja0.h) {
                            se4Var.h = 0;
                            return;
                        }
                        return;
                    case 60:
                        if (ja0.p && r84Var.b(524288)) {
                            t(256);
                            se4Var.f = je.L(up3Var.a) ? 1 : 0;
                            return;
                        }
                        return;
                    case 62:
                        if (ja0.p && r84Var.b(524288)) {
                            t(512);
                            se4Var.f = je.L(up3Var.a) ? 1 : 0;
                            return;
                        }
                        return;
                    case 63:
                        if (r84Var.b(128)) {
                            v(0, 1);
                            return;
                        }
                        return;
                    case 65:
                        if (r84Var.b(16384)) {
                            t(1);
                            return;
                        }
                        return;
                    case 66:
                        if (r84Var.b(1048576)) {
                            t(128);
                            se4Var.f = (je.L(up3Var.a) && (up3Var.a & 16384) == 0) ? 1 : 0;
                            return;
                        }
                        return;
                    case 68:
                        if (r84Var.b(4194304)) {
                            y(4, true);
                            return;
                        }
                        return;
                    case 71:
                        if (r84Var.b(32768)) {
                            t(4);
                            return;
                        }
                        return;
                    case 72:
                        if (r84Var.c(524288)) {
                            y(11, true);
                            return;
                        }
                        return;
                    case 75:
                        if (r84Var.c(33554432)) {
                            se4Var.a = 22;
                            return;
                        }
                        return;
                    case 80:
                    case 112:
                        if (!I(123) || !r84Var.c(65536)) {
                            "invalid Unicode Property \\<%n>".replace("<%n>", Character.toString((char) this.z0));
                            return;
                        }
                        A();
                        se4Var.a = 19;
                        se4Var.f = this.z0 == 80 ? 1 : 0;
                        if (C() && r84Var.c(131072)) {
                            k();
                            if (this.z0 == 94) {
                                se4Var.f = !se4Var.a() ? 1 : 0;
                                return;
                            } else {
                                this.Y = this.y0;
                                return;
                            }
                        }
                        return;
                    case 81:
                        if (r84Var.c(1)) {
                            se4Var.a = 18;
                            return;
                        }
                        return;
                    case 82:
                        if (r84Var.c(2097152)) {
                            se4Var.a = 20;
                            return;
                        }
                        return;
                    case 83:
                        if (r84Var.b(2097152)) {
                            y(9, true);
                            return;
                        }
                        return;
                    case 87:
                        if (r84Var.b(262144)) {
                            y(12, true);
                            return;
                        }
                        return;
                    case 88:
                        if (r84Var.c(4194304)) {
                            se4Var.a = 21;
                            return;
                        }
                        return;
                    case 90:
                        if (r84Var.b(16384)) {
                            t(16);
                            return;
                        }
                        return;
                    case 96:
                        if (r84Var.c(32768)) {
                            t(1);
                            return;
                        }
                        return;
                    case 98:
                        if (r84Var.b(1048576)) {
                            t(64);
                            se4Var.f = (je.L(up3Var.a) && (up3Var.a & 16384) == 0) ? 1 : 0;
                            return;
                        }
                        return;
                    case Socket.UDS_SUN_PATH_SIZE /* 100 */:
                        if (r84Var.b(4194304)) {
                            y(4, false);
                            return;
                        }
                        return;
                    case 103:
                        if (ja0.e && r84Var.c(67108864) && C()) {
                            k();
                            if (this.z0 == 123) {
                                r();
                            } else {
                                this.Y = this.y0;
                            }
                        }
                        if (ja0.f && r84Var.c(512) && C()) {
                            k();
                            int i9 = this.z0;
                            if (i9 != 60 && i9 != 39) {
                                this.Y = this.y0;
                                return;
                            }
                            int iH = H();
                            if (iH == 48) {
                                A();
                                if (I(D(this.z0))) {
                                    A();
                                    i = this.Y;
                                    i2 = 0;
                                } else {
                                    i2 = 0;
                                    i = 0;
                                    iP = -1;
                                }
                            } else if (iH == 43) {
                                A();
                                i = 0;
                                iP = -1;
                                i2 = 1;
                            }
                            int i10 = this.Y;
                            if (iP < 0) {
                                iP = p(this.z0, true);
                                i = this.b;
                            }
                            se4Var.a = 9;
                            se4Var.e = i10;
                            se4Var.f = i;
                            se4Var.g = iP;
                            se4Var.h = i2;
                            return;
                        }
                        return;
                    case 104:
                        if (r84Var.c(524288)) {
                            y(11, false);
                            return;
                        }
                        return;
                    case 107:
                        if (ja0.e && r84Var.c(256) && C()) {
                            k();
                            int i11 = this.z0;
                            if (i11 == 60 || i11 == 39) {
                                r();
                                return;
                            } else {
                                this.Y = this.y0;
                                return;
                            }
                        }
                        return;
                    case 115:
                        if (r84Var.b(2097152)) {
                            y(9, false);
                            return;
                        }
                        return;
                    case 117:
                        if (C()) {
                            int i12 = this.Y;
                            if (r84Var.c(16384)) {
                                int iK = K(4, 4);
                                if (iK < -1) {
                                    G("too short digits");
                                    throw null;
                                }
                                if (iK < 0) {
                                    G("too big number");
                                    throw null;
                                }
                                iP = this.Y != i12 ? iK : 0;
                                se4Var.a = 5;
                                se4Var.c = 16;
                                se4Var.e = iP;
                                return;
                            }
                            return;
                        }
                        return;
                    case 119:
                        if (r84Var.b(262144)) {
                            y(12, false);
                            return;
                        }
                        return;
                    case 120:
                        if (C()) {
                            int i13 = this.Y;
                            if (!I(123) || !r84Var.b(Pow2.MAX_POW2)) {
                                if (r84Var.b(536870912)) {
                                    int iK2 = K(0, 2);
                                    if (iK2 < 0) {
                                        G("too big number");
                                        throw null;
                                    }
                                    iP = this.Y != i13 ? iK2 : 0;
                                    se4Var.a = 2;
                                    se4Var.c = 16;
                                    se4Var.e = iP;
                                    return;
                                }
                                return;
                            }
                            A();
                            int iK3 = K(0, 8);
                            if (iK3 < 0) {
                                G("too big wide-char value");
                                throw null;
                            }
                            if (C() && k0Var.j(H(), 11)) {
                                G("too long wide-char value");
                                throw null;
                            }
                            if (this.Y <= k0Var.r(i13, this.Z, bArr) + i13 || !C() || !I(125)) {
                                this.Y = i13;
                                return;
                            }
                            A();
                            se4Var.a = 5;
                            se4Var.e = iK3;
                            return;
                        }
                        return;
                    case 122:
                        if (r84Var.b(16384)) {
                            t(8);
                            return;
                        }
                        return;
                    case 123:
                        if (r84Var.b(512)) {
                            u();
                            return;
                        }
                        return;
                    case 124:
                        if (r84Var.b(2048)) {
                            se4Var.a = 14;
                            return;
                        }
                        return;
                }
            }
            int i14 = this.z0;
            se4Var.e = i14;
            se4Var.b = false;
            if (ja0.o && i14 != 0 && r84Var.b(1)) {
                int i15 = this.z0;
                if (i15 == 0) {
                    se4Var.a = 6;
                    return;
                }
                if (i15 == 0) {
                    v(0, -1);
                    return;
                }
                if (i15 == 0) {
                    v(0, 1);
                    return;
                } else if (i15 == 0) {
                    v(1, -1);
                    return;
                } else {
                    if (i15 == 0) {
                        se4Var.a = 13;
                        return;
                    }
                    return;
                }
            }
            int i16 = this.z0;
            if (i16 != 9 && i16 != 10 && i16 != 12 && i16 != 13 && i16 != 32) {
                if (i16 == 46) {
                    if (r84Var.b(2)) {
                        se4Var.a = 6;
                        return;
                    }
                    return;
                }
                if (i16 == 63) {
                    if (r84Var.b(64)) {
                        v(0, 1);
                        return;
                    }
                    return;
                }
                if (i16 == 91) {
                    if (r84Var.b(131072)) {
                        se4Var.a = 17;
                        return;
                    }
                    return;
                }
                if (i16 == 35) {
                    if ((up3Var.a & 2) == 0) {
                        return;
                    }
                    while (C()) {
                        k();
                        if (k0Var.j(this.z0, 0)) {
                            break;
                        }
                    }
                } else {
                    if (i16 == 36) {
                        if (r84Var.b(8388608)) {
                            t((up3Var.a & 8) != 0 ? 16 : 32);
                            return;
                        }
                        return;
                    }
                    if (i16 != 93) {
                        if (i16 == 94) {
                            if (r84Var.b(8388608)) {
                                t((up3Var.a & 8) != 0 ? 1 : 2);
                                return;
                            }
                            return;
                        }
                        if (i16 == 123) {
                            if (r84Var.b(256)) {
                                u();
                                return;
                            }
                            return;
                        }
                        if (i16 == 124) {
                            if (r84Var.b(1024)) {
                                se4Var.a = 14;
                                return;
                            }
                            return;
                        }
                        switch (i16) {
                            case 40:
                                if (I(63) && r84Var.c(2)) {
                                    A();
                                    if (I(35)) {
                                        k();
                                        while (C()) {
                                            k();
                                            int i17 = this.z0;
                                            if (i17 != 92) {
                                                if (i17 == 41) {
                                                }
                                                break;
                                            } else if (C()) {
                                                k();
                                            }
                                        }
                                        E("end pattern in group");
                                        throw null;
                                    }
                                    this.Y = this.y0;
                                }
                                break;
                            case 41:
                                if (r84Var.b(4096)) {
                                    se4Var.a = 16;
                                    return;
                                }
                                return;
                            case 42:
                                if (r84Var.b(4)) {
                                    v(0, -1);
                                    return;
                                }
                                return;
                            case 43:
                                if (r84Var.b(16)) {
                                    v(1, -1);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                if ((up3Var.a & 2) == 0) {
                    return;
                }
            }
        }
    }

    public final void t(int i) {
        se4 se4Var = this.E0;
        se4Var.a = 10;
        se4Var.e = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u() {
        boolean z;
        int iL;
        char c;
        this.B0 = this.Y;
        boolean z2 = ((-2019556389) & 8) != 0;
        if (C()) {
            if (!z2) {
                int iH = H();
                this.z0 = iH;
                if (iH == 41 || iH == 40 || iH == 124) {
                    E("end pattern at left brace");
                    throw null;
                }
            }
            int iL2 = L();
            if (iL2 < 0) {
                E("too big number for repeat range");
                throw null;
            }
            int i = ja0.w;
            if (iL2 > i) {
                E("too big number for repeat range");
                throw null;
            }
            if (this.Y == this.B0) {
                if (((-2019556389) & 16) != 0) {
                    iL2 = 0;
                    z = true;
                } else {
                    B(z2);
                }
            } else {
                z = false;
            }
            if (C()) {
                k();
                if (this.z0 == 44) {
                    int i2 = this.Y;
                    iL = L();
                    if (iL < 0) {
                        G("too big number for repeat range");
                        throw null;
                    }
                    if (iL > i) {
                        G("too big number for repeat range");
                        throw null;
                    }
                    if (this.Y == i2) {
                        if (z) {
                            B(z2);
                        } else {
                            iL = -1;
                        }
                    }
                    c = 0;
                    if (C()) {
                        B(z2);
                    } else {
                        k();
                        if ((2146948438 & 512) != 0) {
                            if (this.z0 == 92 && C()) {
                                k();
                                if (this.z0 == 125) {
                                }
                            } else {
                                B(z2);
                            }
                        } else if (this.z0 == 125) {
                            B(z2);
                        } else {
                            if (!QuantifierNode.isRepeatInfinite(iL) && iL2 > iL) {
                                G("upper is smaller than lower in repeat range");
                                throw null;
                            }
                            se4 se4Var = this.E0;
                            se4Var.a = 12;
                            se4Var.e = iL2;
                            se4Var.f = iL;
                        }
                    }
                } else if (z) {
                    B(z2);
                } else {
                    this.Y = this.y0;
                    iL = iL2;
                    c = 2;
                    if (C()) {
                    }
                }
                if (c != 0) {
                    z();
                    return;
                } else {
                    if (c != 2) {
                        return;
                    }
                    if (((-2019556389) & 512) != 0) {
                        J();
                        return;
                    } else {
                        z();
                        return;
                    }
                }
            }
            B(z2);
        } else if (!z2) {
            E("end pattern at left brace");
            throw null;
        }
        c = 1;
        if (c != 0) {
        }
    }

    public final void v(int i, int i2) {
        se4 se4Var = this.E0;
        se4Var.a = 11;
        se4Var.e = i;
        se4Var.f = i2;
        z();
    }

    public final void w() {
        if (!((268435456 & 2146948438) != 0)) {
            if (this.z0 != 48) {
                A();
                return;
            }
            return;
        }
        int i = this.Y;
        int iM = M(this.z0 == 48 ? 2 : 3);
        if (iM < 0 || iM > 255) {
            G("too big number");
            throw null;
        }
        int i2 = this.Y != i ? iM : 0;
        se4 se4Var = this.E0;
        se4Var.a = 2;
        se4Var.c = 8;
        se4Var.e = i2;
    }

    public final void x() {
        boolean zC = C();
        se4 se4Var = this.E0;
        if (!zC) {
            se4Var.a = 1;
            return;
        }
        k();
        se4Var.a = 3;
        se4Var.c = 0;
        int i = this.z0;
        se4Var.e = i;
        se4Var.b = false;
        if (i == 93) {
            se4Var.a = 23;
            return;
        }
        if (i == 45) {
            se4Var.a = 24;
            return;
        }
        byte[] bArr = this.X;
        k0 k0Var = this.A;
        r84 r84Var = r84.a;
        if (i != 92) {
            if (i != 91) {
                if (i == 38 && r84Var.c(64) && C() && I(38)) {
                    A();
                    se4Var.a = 26;
                    return;
                }
                return;
            }
            if (!r84Var.b(16777216) || !I(58)) {
                if (r84Var.c(64)) {
                    se4Var.a = 27;
                    return;
                }
                return;
            }
            se4Var.d = this.Y;
            A();
            int i2 = this.Y;
            int i3 = this.Z;
            int iR = i2;
            loop0: while (true) {
                int i4 = i;
                while (iR < i3) {
                    if (i4 != 0) {
                        break;
                    }
                    int iU = k0Var.u(iR, i3, bArr);
                    int iR2 = k0Var.r(iR, i3, bArr) + iR;
                    int[] iArr = F0;
                    if (iU == iArr[i]) {
                        int iR3 = iR2;
                        int i5 = 1;
                        while (i5 < 2 && iR3 < i3 && k0Var.u(iR3, i3, bArr) == iArr[i5]) {
                            iR3 += k0Var.r(iR3, i3, bArr);
                            i5++;
                        }
                        if (i5 >= 2) {
                            se4Var.a = 25;
                            return;
                        }
                        iR = k0Var.r(iR, i3, bArr) + iR;
                    } else {
                        int iU2 = k0Var.u(iR, i3, bArr);
                        if (iU2 == 93) {
                            break loop0;
                        }
                        i4 = iU2 == 92 ? 1 : i4;
                        iR = iR2;
                    }
                    i = 0;
                }
                iR += k0Var.r(iR, i3, bArr);
            }
            this.Y = this.y0;
            if (r84Var.c(64)) {
                se4Var.a = 27;
                return;
            }
            return;
        }
        if (r84Var.a(2097152)) {
            if (!C()) {
                E("end pattern at escape");
                throw null;
            }
            k();
            se4Var.b = true;
            int i6 = this.z0;
            se4Var.e = i6;
            if (i6 == 68) {
                y(4, true);
                return;
            }
            if (i6 == 72) {
                if (r84Var.c(524288)) {
                    y(11, true);
                    return;
                }
                return;
            }
            if (i6 != 80) {
                if (i6 == 83) {
                    y(9, true);
                    return;
                }
                if (i6 == 87) {
                    y(12, true);
                    return;
                }
                if (i6 == 100) {
                    y(4, false);
                    return;
                }
                if (i6 == 104) {
                    if (r84Var.c(524288)) {
                        y(11, false);
                        return;
                    }
                    return;
                }
                if (i6 != 112) {
                    if (i6 == 115) {
                        y(9, false);
                        return;
                    }
                    if (i6 == 117) {
                        if (C()) {
                            int i7 = this.Y;
                            if (r84Var.c(16384)) {
                                int iK = K(4, 4);
                                if (iK < -1) {
                                    G("too short digits");
                                    throw null;
                                }
                                if (iK < 0) {
                                    G("too big number");
                                    throw null;
                                }
                                i = this.Y != i7 ? iK : 0;
                                se4Var.a = 5;
                                se4Var.c = 16;
                                se4Var.e = i;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (i6 == 119) {
                        y(12, false);
                        return;
                    }
                    if (i6 != 120) {
                        switch (i6) {
                            case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 54:
                            case 55:
                                if (r84Var.b(268435456)) {
                                    int i8 = this.y0;
                                    this.Y = i8;
                                    int iM = M(3);
                                    if (iM < 0 || iM > 255) {
                                        G("too big number");
                                        throw null;
                                    }
                                    i = this.Y != i8 ? iM : 0;
                                    se4Var.a = 2;
                                    se4Var.c = 8;
                                    se4Var.e = i;
                                    return;
                                }
                                return;
                            default:
                                this.Y = this.y0;
                                m();
                                int i9 = se4Var.e;
                                int i10 = this.z0;
                                if (i9 != i10) {
                                    se4Var.e = i10;
                                    se4Var.a = 5;
                                    return;
                                }
                                return;
                        }
                    }
                    if (C()) {
                        int i11 = this.Y;
                        if (!I(123) || !r84Var.b(Pow2.MAX_POW2)) {
                            if (r84Var.b(536870912)) {
                                int iK2 = K(0, 2);
                                if (iK2 < 0) {
                                    G("too big number");
                                    throw null;
                                }
                                i = this.Y != i11 ? iK2 : 0;
                                se4Var.a = 2;
                                se4Var.c = 16;
                                se4Var.e = i;
                                return;
                            }
                            return;
                        }
                        A();
                        int iK3 = K(0, 8);
                        if (iK3 < 0) {
                            G("too big wide-char value");
                            throw null;
                        }
                        if (C() && k0Var.j(H(), 11)) {
                            G("too long wide-char value");
                            throw null;
                        }
                        if (this.Y <= k0Var.r(i11, this.Z, bArr) + i11 || !C() || !I(125)) {
                            this.Y = i11;
                            return;
                        }
                        A();
                        se4Var.a = 5;
                        se4Var.c = 16;
                        se4Var.e = iK3;
                        return;
                    }
                    return;
                }
            }
            if (C()) {
                if (H() != 123 || !r84Var.c(65536)) {
                    "invalid Unicode Property \\<%n>".replace("<%n>", Character.toString((char) this.z0));
                    return;
                }
                A();
                se4Var.a = 19;
                se4Var.f = this.z0 == 80 ? 1 : 0;
                if (C() && r84Var.c(131072)) {
                    int iU3 = k0Var.u(this.Y, this.Z, bArr);
                    int i12 = this.Y;
                    this.y0 = i12;
                    this.Y = k0Var.r(i12, this.Z, bArr) + i12;
                    if (iU3 == 94) {
                        se4Var.f = !se4Var.a() ? 1 : 0;
                    } else {
                        this.Y = this.y0;
                    }
                }
            }
        }
    }

    public final void y(int i, boolean z) {
        se4 se4Var = this.E0;
        se4Var.a = 7;
        se4Var.e = i;
        se4Var.f = z ? 1 : 0;
    }

    public final void z() {
        if (C() && I(63)) {
            if ((33554432 & 2146948438) != 0) {
                k();
                se4 se4Var = this.E0;
                se4Var.g = 0;
                se4Var.h = 0;
                return;
            }
        }
        J();
    }
}
