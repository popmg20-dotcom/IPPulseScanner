package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.handler.ssl.OpenSslSessionTicketKey;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class st extends mh2 {
    public static final ThreadLocal a1 = new ThreadLocal();
    public l14[] H0;
    public int I0;
    public final int[] J0;
    public final int K0;
    public final int L0;
    public byte[] M0;
    public int N0;
    public int O0;
    public int P0;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public int U0;
    public final int[] V0;
    public int W0;
    public int X0;
    public byte[] Y0;
    public byte[] Z0;

    public st(th3 th3Var, k70 k70Var, byte[] bArr, int i) {
        l14[] l14VarArr;
        int i2;
        super(th3Var, k70Var, bArr, i);
        if (th3Var.c) {
            ThreadLocal threadLocal = a1;
            WeakReference weakReference = (WeakReference) threadLocal.get();
            if (weakReference == null) {
                l14VarArr = new l14[ja0.A];
                l14VarArr[0] = ja0.s ? new bo3() : new l14();
                threadLocal.set(new WeakReference(l14VarArr));
            } else {
                l14VarArr = (l14[]) weakReference.get();
                if (l14VarArr == null) {
                    l14VarArr = new l14[ja0.A];
                    l14VarArr[0] = ja0.s ? new bo3() : new l14();
                    threadLocal.set(new WeakReference(l14VarArr));
                }
            }
        } else {
            l14VarArr = null;
        }
        this.H0 = l14VarArr;
        boolean z = ja0.f;
        int i3 = th3Var.e;
        int i4 = th3Var.d;
        if (z) {
            i2 = ((i4 + 1) << 1) + i3;
            this.K0 = i3;
            this.L0 = i3 + i4 + 1;
        } else {
            i2 = (i4 << 1) + i3;
            int i5 = i3 - 1;
            this.K0 = i5;
            this.L0 = i5 + i4;
        }
        this.J0 = i2 > 0 ? new int[i2] : null;
        this.N0 = 256;
        this.P0 = 0;
        this.V0 = th3Var.a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
    
        r16.R0 = r16.P0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x016a, code lost:
    
        throw new defpackage.l12("undefined bytecode (bug)");
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int A() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        boolean zO = je.O(0);
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (i5 >= this.N0) {
                D();
                i = i4;
            } else {
                i = i6;
            }
            if (ja0.N) {
                x();
            }
            int i7 = this.P0;
            this.T0 = i7;
            int i8 = this.W0;
            int i9 = i8 + 1;
            this.W0 = i9;
            int[] iArr = this.V0;
            int i10 = iArr[i8];
            int[] iArr2 = this.J0;
            int i11 = this.Z;
            k0 k0Var = this.X;
            byte[] bArr = this.Y;
            switch (i10) {
                case 0:
                    return this.O0;
                case 1:
                    if (V()) {
                        return this.O0;
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 2:
                    W();
                    i5 = i;
                    i4 = 0;
                    break;
                case 3:
                    Y();
                    i5 = i;
                    i4 = 0;
                    break;
                case 4:
                    Z();
                    i5 = i;
                    i4 = 0;
                    break;
                case 5:
                    a0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 6:
                    b0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 7:
                    i0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 8:
                    d0();
                    i5 = i;
                    i4 = 0;
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    e0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 10:
                    f0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 11:
                    c0();
                    i5 = i;
                    i4 = 0;
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    g0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 13:
                    h0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 14:
                    X();
                    i5 = i;
                    i4 = 0;
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    j0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 16:
                    if (i7 >= this.Q0 || !E()) {
                        k0();
                    } else {
                        this.W0 += 8;
                        this.P0++;
                        this.R0 = this.T0;
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 17:
                    k0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 18:
                    if (i7 >= this.Q0 || !E()) {
                        k0();
                    } else {
                        int i12 = this.W0;
                        int i13 = i12 + 8;
                        int i14 = i12 + 9;
                        this.W0 = i14;
                        this.W0 = i14 + iArr[i13];
                        this.P0++;
                        this.R0 = this.T0;
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 19:
                    if (i7 >= this.Q0 || E()) {
                        k0();
                    } else {
                        this.W0 += 8;
                        this.P0++;
                        this.R0 = this.T0;
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 20:
                    if (i7 >= this.Q0) {
                        k0();
                    } else {
                        this.P0 = i7 + 1;
                        int i15 = i8 + 2;
                        this.W0 = i15;
                        this.W0 = i15 + iArr[i9];
                        this.R0 = i7;
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 21:
                    if (i7 >= this.Q0 || E()) {
                        k0();
                    } else {
                        int i16 = this.W0;
                        int i17 = i16 + 8;
                        this.P0++;
                        int i18 = i16 + 9;
                        this.W0 = i18;
                        this.W0 = i18 + iArr[i17];
                        this.R0 = this.T0;
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 22:
                    if (i7 >= this.Q0 || bArr[i7] == 10) {
                        k0();
                    } else {
                        this.P0 = i7 + 1;
                        this.R0 = i7;
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 23:
                    if (i7 >= this.Q0) {
                        k0();
                    } else {
                        this.P0 = i7 + 1;
                        this.R0 = i7;
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 24:
                    while (true) {
                        int i19 = this.P0;
                        if (i19 < this.Q0) {
                            H0(1, this.W0, i19, this.R0, this.U0);
                            int i20 = this.P0;
                            if (bArr[i20] == 10) {
                                k0();
                            } else {
                                this.R0 = i20;
                                this.P0 = i20 + 1;
                            }
                        }
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 25:
                    while (true) {
                        int i21 = this.P0;
                        if (i21 < this.Q0) {
                            H0(1, this.W0, i21, this.R0, this.U0);
                            int i22 = this.P0;
                            this.R0 = i22;
                            this.P0 = i22 + 1;
                        }
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 26:
                    byte b = (byte) iArr[i9];
                    while (true) {
                        int i23 = this.P0;
                        if (i23 < this.Q0) {
                            byte b2 = bArr[i23];
                            if (b == b2) {
                                H0(1, this.W0 + 1, i23, this.R0, this.U0);
                            }
                            if (b2 == 10) {
                                k0();
                            } else {
                                int i24 = this.P0;
                                this.R0 = i24;
                                this.P0 = i24 + 1;
                            }
                        } else {
                            this.W0++;
                            this.R0 = this.T0;
                        }
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 27:
                    byte b3 = (byte) iArr[i9];
                    while (true) {
                        int i25 = this.P0;
                        if (i25 >= this.Q0) {
                            this.W0++;
                            this.R0 = this.T0;
                            i5 = i;
                            i4 = 0;
                        } else {
                            if (b3 == bArr[i25]) {
                                H0(1, this.W0 + 1, i25, this.R0, this.U0);
                            }
                            int i26 = this.P0;
                            this.R0 = i26;
                            this.P0 = i26 + 1;
                        }
                        break;
                    }
                    break;
                case 28:
                    if (i7 >= this.Q0 || !k0Var.j(bArr[i7] & 255, 12)) {
                        k0();
                    } else {
                        this.P0++;
                        this.R0 = this.T0;
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 29:
                    if (i7 >= this.Q0 || k0Var.j(bArr[i7] & 255, 12)) {
                        k0();
                    } else {
                        this.P0++;
                        this.R0 = this.T0;
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 30:
                    if (i7 == 0) {
                        if (i7 >= this.Q0 || !k0Var.j(bArr[i7] & 255, 12)) {
                            k0();
                        }
                    } else if (i7 == i11) {
                        int i27 = this.R0;
                        if (i27 >= i11 || !k0Var.j(bArr[i27] & 255, 12)) {
                            k0();
                        }
                    } else if (k0Var.j(bArr[i7] & 255, 12) == k0Var.j(bArr[this.R0] & 255, 12)) {
                        k0();
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 31:
                    if (i7 == 0) {
                        if (i7 < this.Q0 && k0Var.j(bArr[i7] & 255, 12)) {
                            k0();
                        }
                    } else if (i7 == i11) {
                        int i28 = this.R0;
                        if (i28 < i11 && k0Var.j(bArr[i28] & 255, 12)) {
                            k0();
                        }
                    } else if (k0Var.j(bArr[i7] & 255, 12) != k0Var.j(bArr[this.R0] & 255, 12)) {
                        k0();
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 32:
                    if (i7 >= this.Q0 || !k0Var.j(bArr[i7] & 255, 12) || (this.P0 != 0 && k0Var.j(bArr[this.R0] & 255, 12))) {
                        k0();
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 33:
                    if (i7 == 0 || !k0Var.j(bArr[this.R0] & 255, 12) || ((i2 = this.P0) != i11 && k0Var.j(bArr[i2] & 255, 12))) {
                        k0();
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 34:
                    L();
                    i5 = i;
                    i4 = 0;
                    break;
                case 35:
                    o0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 36:
                    N();
                    i5 = i;
                    i4 = 0;
                    break;
                case 37:
                    p0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 38:
                    M();
                    i5 = i;
                    i4 = 0;
                    break;
                case 39:
                    O();
                    i5 = i;
                    i4 = 0;
                    break;
                case 40:
                    if (i7 != 0) {
                        k0();
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 41:
                    if (i7 != i11) {
                        k0();
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 42:
                    if (i7 != 0 && (bArr[this.R0] != 10 || i7 == i11)) {
                        k0();
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 43:
                    if (i7 == i11) {
                        if (ja0.j) {
                            if ((i11 == 0 || (i3 = this.R0) >= i11 || bArr[i3] != 10) && zO) {
                                k0();
                            }
                        } else if (zO) {
                            k0();
                        }
                    } else if (bArr[i7] != 10) {
                        k0();
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 44:
                    B0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 45:
                    if (i7 != this.B0) {
                        k0();
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 46:
                    t(1);
                    i5 = i;
                    i4 = 0;
                    break;
                case 47:
                    t(2);
                    i5 = i;
                    i4 = 0;
                    break;
                case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                    this.W0 = i8 + 2;
                    t(iArr[i9]);
                    i5 = i;
                    i4 = 0;
                    break;
                case 49:
                    S();
                    i5 = i;
                    i4 = 0;
                    break;
                case 50:
                    Q();
                    i5 = i;
                    i4 = 0;
                    break;
                case 51:
                    R();
                    i5 = i;
                    i4 = 0;
                    break;
                case 52:
                    P();
                    i5 = i;
                    i4 = 0;
                    break;
                case 53:
                    m0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 54:
                    n0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 55:
                    this.W0 = i8 + 2;
                    J0(iArr[i9], i7);
                    i5 = i;
                    i4 = 0;
                    break;
                case 56:
                    this.W0 = i8 + 2;
                    int i29 = iArr[i9];
                    int iB = B(i29);
                    J0(i29, this.P0);
                    iArr2[this.K0 + i29] = iB;
                    i5 = i;
                    i4 = 0;
                    break;
                case 57:
                    this.W0 = i8 + 2;
                    iArr2[this.L0 + iArr[i9]] = i7;
                    i5 = i;
                    i4 = 0;
                    break;
                case 58:
                    l0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 59:
                    this.U0 = i7;
                    i5 = i;
                    i4 = 0;
                    break;
                case 60:
                    k0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 61:
                    this.W0 = iArr[i9] + 1 + i9;
                    i5 = i;
                    i4 = 0;
                    break;
                case 62:
                    int i30 = i8 + 2;
                    this.W0 = i30;
                    H0(1, iArr[i9] + i30, i7, this.R0, this.U0);
                    i5 = i;
                    i4 = 0;
                    break;
                case 63:
                    this.I0--;
                    i5 = i;
                    i4 = 0;
                    break;
                case 64:
                    x0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 65:
                    v0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 66:
                    y0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 67:
                    z0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 68:
                    this.W0 = i8 + 2;
                    int i31 = iArr[i9];
                    L0(i31, iArr2[i31]);
                    i5 = i;
                    i4 = 0;
                    break;
                case 69:
                    this.W0 = i8 + 2;
                    int i32 = iArr[i9];
                    M0(i32, iArr2[i32]);
                    i5 = i;
                    i4 = 0;
                    break;
                case 70:
                    this.W0 = i8 + 2;
                    int i33 = iArr[i9];
                    L0(i33, C(i33));
                    i5 = i;
                    i4 = 0;
                    break;
                case 71:
                    this.W0 = i8 + 2;
                    int i34 = iArr[i9];
                    M0(i34, C(i34));
                    i5 = i;
                    i4 = 0;
                    break;
                case 72:
                    t0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 73:
                    q0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 74:
                    r0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 75:
                    s0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 76:
                    H0(1280, -1, i7, this.R0, this.U0);
                    i5 = i;
                    i4 = 0;
                    break;
                case 77:
                    u0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 78:
                    int i35 = i8 + 2;
                    this.W0 = i35;
                    H0(3, iArr[i9] + i35, i7, this.R0, this.U0);
                    i5 = i;
                    i4 = 0;
                    break;
                case 79:
                    while (true) {
                        l14[] l14VarArr = this.H0;
                        int i36 = this.I0 - 1;
                        this.I0 = i36;
                        l14 l14Var = l14VarArr[i36];
                        if (l14Var.a == 3) {
                            k0();
                            i5 = i;
                            i4 = 0;
                        } else {
                            G0(l14Var);
                        }
                        break;
                    }
                    break;
                case 80:
                    z().a = 1536;
                    this.I0++;
                    i5 = i;
                    i4 = 0;
                    break;
                case 81:
                    P0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 82:
                    this.W0 = i8 + 2;
                    int i37 = i7 - iArr[i9];
                    this.P0 = i37;
                    if (i37 < 0) {
                        k0();
                    } else {
                        this.R0 = i37 == 0 ? -1 : i37 - 1;
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 83:
                    w0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 84:
                    while (true) {
                        l14[] l14VarArr2 = this.H0;
                        int i38 = this.I0 - 1;
                        this.I0 = i38;
                        l14 l14Var2 = l14VarArr2[i38];
                        if (l14Var2.a == 2) {
                            k0();
                            i5 = i;
                            i4 = 0;
                        } else {
                            G0(l14Var2);
                        }
                        break;
                    }
                    break;
                case 85:
                    int i39 = this.Q0;
                    l14 l14VarZ = z();
                    l14VarZ.a = 2816;
                    l14VarZ.b = i7;
                    l14VarZ.c = i39;
                    this.I0++;
                    i5 = i;
                    i4 = 0;
                    break;
                case 86:
                    J();
                    i5 = i;
                    i4 = 0;
                    break;
                case 87:
                    K();
                    i5 = i;
                    i4 = 0;
                    break;
                case 88:
                    T();
                    i5 = i;
                    i4 = 0;
                    break;
                case 89:
                    A0();
                    i5 = i;
                    i4 = 0;
                    break;
                case 90:
                    U();
                    i5 = i;
                    i4 = 0;
                    break;
                case 91:
                    if (ja0.s) {
                        D0();
                    } else if (ja0.s) {
                        E0();
                    } else if (ja0.s) {
                        C0();
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 94:
                    if (ja0.s) {
                        this.W0 = i8 + 2;
                        int i40 = iArr[i9];
                        while (true) {
                            int i41 = this.P0;
                            if (i41 >= this.Q0) {
                                this.R0 = this.T0;
                            } else if (O0(i41, i40)) {
                                k0();
                            } else {
                                I0(this.W0, this.P0, this.R0, i40, this.U0);
                                int i42 = this.P0;
                                if (bArr[i42] == 10) {
                                    k0();
                                } else {
                                    this.R0 = i42;
                                    this.P0 = i42 + 1;
                                }
                            }
                        }
                    } else if (ja0.s) {
                        this.W0 = i8 + 2;
                        int i43 = iArr[i9];
                        while (true) {
                            int i44 = this.P0;
                            if (i44 >= this.Q0) {
                                this.R0 = this.T0;
                            } else if (O0(i44, i43)) {
                                k0();
                            } else {
                                I0(this.W0, this.P0, this.R0, i43, this.U0);
                                int i45 = this.P0;
                                this.R0 = i45;
                                this.P0 = i45 + 1;
                            }
                        }
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 98:
                    if (i7 < this.Q0) {
                        int i46 = iArr[i9];
                        byte[] bArrB = k0Var.B();
                        int i47 = this.P0;
                        this.P0 = i47 + 1;
                        if (i46 != bArrB[bArr[i47] & 255]) {
                            k0();
                        } else {
                            this.W0++;
                            this.R0 = this.T0;
                        }
                    }
                    i5 = i;
                    i4 = 0;
                    break;
                case 99:
                    this.W0 = i8 + 2;
                    int i48 = iArr[i9];
                    if (i7 + i48 <= this.Q0) {
                        byte[] bArrB2 = k0Var.B();
                        if (!ja0.C) {
                            while (true) {
                                int i49 = i48 - 1;
                                if (i48 <= 0) {
                                    break;
                                } else {
                                    int i50 = this.W0;
                                    this.W0 = i50 + 1;
                                    int i51 = iArr[i50];
                                    int i52 = this.P0;
                                    this.P0 = i52 + 1;
                                    if (i51 != bArrB2[bArr[i52] & 255]) {
                                        k0();
                                    } else {
                                        i48 = i49;
                                    }
                                }
                            }
                        } else {
                            byte[][] bArr2 = this.A.G;
                            int i53 = this.W0;
                            int i54 = i53 + 1;
                            this.W0 = i54;
                            byte[] bArr3 = bArr2[iArr[i53]];
                            this.W0 = i53 + 2;
                            int i55 = iArr[i54];
                            while (true) {
                                int i56 = i48 - 1;
                                if (i48 <= 0) {
                                    break;
                                } else {
                                    int i57 = i55 + 1;
                                    byte b4 = bArr3[i55];
                                    int i58 = this.P0;
                                    this.P0 = i58 + 1;
                                    if (b4 != bArrB2[bArr[i58] & 255]) {
                                        k0();
                                    } else {
                                        i55 = i57;
                                        i48 = i56;
                                    }
                                }
                            }
                        }
                    } else {
                        k0();
                    }
                    i5 = i;
                    i4 = 0;
                    break;
            }
        }
    }

    public final void A0() {
        int i = this.I0;
        int i2 = 0;
        while (true) {
            i--;
            l14 l14Var = this.H0[i];
            int i3 = l14Var.a;
            if (i3 == 2048) {
                if (i2 == 0) {
                    this.W0 = l14Var.b;
                    z().a = 2304;
                    this.I0++;
                    return;
                }
                i2--;
            } else if (i3 == 2304) {
                i2++;
            }
        }
    }

    public final int B(int i) {
        int i2 = this.I0;
        int i3 = 0;
        while (i2 > 0) {
            i2--;
            l14 l14Var = this.H0[i2];
            int i4 = l14Var.a;
            if ((32768 & i4) != 0 && l14Var.b == i) {
                i3++;
            } else if (i4 == 256 && l14Var.b == i) {
                if (i3 == 0) {
                    return i2;
                }
                i3--;
            }
        }
        return i2;
    }

    public final void B0() {
        boolean zO = je.O(0);
        int i = this.P0;
        byte[] bArr = this.Y;
        k0 k0Var = this.X;
        int i2 = this.Z;
        if (i != i2) {
            if (k0Var.m(i, i2, bArr)) {
                int i3 = this.P0;
                if (k0Var.r(i3, i2, bArr) + i3 == i2) {
                    return;
                }
            }
            k0();
            return;
        }
        if (!ja0.j) {
            if (zO) {
                k0();
            }
        } else if ((i2 == 0 || !k0Var.m(this.R0, i2, bArr)) && zO) {
            k0();
        }
    }

    public final int C(int i) {
        int i2 = this.I0;
        int i3 = 0;
        while (true) {
            i2--;
            l14 l14Var = this.H0[i2];
            int i4 = l14Var.a;
            if (i4 == 1792) {
                if (i3 == 0 && l14Var.d == i) {
                    return i2;
                }
            } else if (i4 == 2048) {
                i3--;
            } else if (i4 == 2304) {
                i3++;
            }
        }
    }

    public final void C0() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        if (O0(this.P0, i2)) {
            k0();
            return;
        }
        int i3 = this.P0;
        if (this.M0 != null) {
            l14 l14VarZ = z();
            l14VarZ.a = 4096;
            l14VarZ.c = i3;
            ((bo3) l14VarZ).f = i2;
            this.I0++;
        }
    }

    public final void D() {
        this.N0 = Math.min(this.N0 << 1, 32768);
    }

    public final void D0() {
        int i = this.W0;
        this.W0 = i + 1;
        int[] iArr = this.V0;
        int i2 = iArr[i];
        if (O0(this.P0, i2)) {
            k0();
            return;
        }
        int i3 = this.W0;
        int i4 = i3 + 1;
        this.W0 = i4;
        I0(i4 + iArr[i3], this.P0, this.R0, i2, this.U0);
    }

    public final boolean E() {
        int i = this.Y[this.P0] & 255;
        return (this.V0[this.W0 + (i >>> dn.b)] & (1 << i)) != 0;
    }

    public final void E0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        this.W0 = i + 2;
        int i4 = iArr[i2];
        boolean zO0 = O0(this.P0, i3);
        int i5 = this.W0;
        if (zO0) {
            this.W0 = i5 + i4;
        } else {
            I0(i5 + i4, this.P0, this.R0, i3, this.U0);
        }
    }

    public final boolean F() {
        int i = this.W0;
        this.W0 = i + 1;
        int[] iArr = this.V0;
        int i2 = iArr[i];
        int i3 = this.P0;
        if (i3 >= this.Q0) {
            return false;
        }
        int i4 = this.Z;
        k0 k0Var = this.X;
        byte[] bArr = this.Y;
        int iR = k0Var.r(i3, i4, bArr);
        int i5 = this.P0;
        int i6 = iR + i5;
        if (i6 > this.Q0) {
            return false;
        }
        this.P0 = i6;
        if (!r25.I(this.W0, k0Var.u(i5, i6, bArr), iArr)) {
            return false;
        }
        this.W0 += i2;
        return true;
    }

    public final l14 F0() {
        int i = this.A.l;
        if (i == 0) {
            while (true) {
                l14[] l14VarArr = this.H0;
                int i2 = this.I0 - 1;
                this.I0 = i2;
                l14 l14Var = l14VarArr[i2];
                int i3 = l14Var.a;
                if ((i3 & DnsRecord.CLASS_ANY) != 0) {
                    return l14Var;
                }
                if (ja0.s && i3 == 4096) {
                    N0();
                }
            }
        } else if (i != 1) {
            while (true) {
                l14[] l14VarArr2 = this.H0;
                int i4 = this.I0 - 1;
                this.I0 = i4;
                l14 l14Var2 = l14VarArr2[i4];
                if ((l14Var2.a & DnsRecord.CLASS_ANY) != 0) {
                    return l14Var2;
                }
                G0(l14Var2);
            }
        } else {
            while (true) {
                l14[] l14VarArr3 = this.H0;
                int i5 = this.I0 - 1;
                this.I0 = i5;
                l14 l14Var3 = l14VarArr3[i5];
                int i6 = l14Var3.a;
                if ((i6 & DnsRecord.CLASS_ANY) != 0) {
                    return l14Var3;
                }
                if (i6 == 256) {
                    int i7 = l14Var3.b;
                    int i8 = this.K0 + i7;
                    int i9 = l14Var3.d;
                    int[] iArr = this.J0;
                    iArr[i8] = i9;
                    iArr[this.L0 + i7] = l14Var3.e;
                } else if (ja0.s && i6 == 4096) {
                    N0();
                }
            }
        }
    }

    public final boolean G() {
        int i = this.W0;
        this.W0 = i + 1;
        int[] iArr = this.V0;
        int i2 = iArr[i];
        int i3 = this.P0;
        k0 k0Var = this.X;
        int i4 = this.Z;
        byte[] bArr = this.Y;
        int iR = k0Var.r(i3, i4, bArr);
        int i5 = this.P0;
        int i6 = iR + i5;
        int i7 = this.Q0;
        if (i6 > i7) {
            if (i5 >= i7) {
                return false;
            }
            this.P0 = i4;
            this.W0 += i2;
            return true;
        }
        this.P0 = i6;
        if (r25.I(this.W0, k0Var.u(i5, i6, bArr), iArr)) {
            return false;
        }
        this.W0 += i2;
        return true;
    }

    public final void G0(l14 l14Var) {
        int i = l14Var.a;
        int i2 = this.L0;
        int i3 = this.K0;
        int[] iArr = this.J0;
        if (i == 256) {
            int i4 = l14Var.b;
            iArr[i3 + i4] = l14Var.d;
            iArr[i2 + i4] = l14Var.e;
        } else if (i == 768) {
            l14 l14Var2 = this.H0[l14Var.b];
            l14Var2.b--;
        } else if (i == 33280) {
            int i5 = l14Var.b;
            iArr[i3 + i5] = l14Var.d;
            iArr[i2 + i5] = l14Var.e;
        } else if (ja0.s && i == 4096) {
            N0();
        }
    }

    public final boolean H(tt ttVar) {
        int i = this.X0;
        while (i < this.I0) {
            l14 l14Var = this.H0[i];
            int i2 = l14Var.a;
            if (i2 == 256) {
                int i3 = l14Var.b;
                if (i3 <= ja0.D && ez4.d(this.A.i, i3)) {
                    tt ttVar2 = new tt(1);
                    ttVar2.b = i3;
                    ttVar.a(ttVar2);
                    this.X0 = i + 1;
                    if (H(ttVar2)) {
                        break;
                    }
                    i = this.X0;
                }
            } else if (i2 == 33280 && l14Var.b == ttVar.b) {
                this.X0 = i;
                return false;
            }
        }
        return true;
    }

    public final void H0(int i, int i2, int i3, int i4, int i5) {
        l14 l14VarZ = z();
        l14VarZ.a = i;
        l14VarZ.b = i2;
        l14VarZ.c = i3;
        l14VarZ.d = i4;
        if (ja0.s) {
            ((bo3) l14VarZ).f = 0;
        }
        l14VarZ.e = i5;
        this.I0++;
    }

    public final void I() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        if (i2 == 61 || i2 == 62) {
            this.W0 = i + 2;
            return;
        }
        switch (i2) {
            case 68:
            case 69:
            case 70:
            case 71:
                this.W0 = i + 2;
                return;
            default:
                throw new l12("unexpected bytecode (bug)");
        }
    }

    public final void I0(int i, int i2, int i3, int i4, int i5) {
        l14 l14VarZ = z();
        l14VarZ.a = 1;
        l14VarZ.b = i;
        l14VarZ.c = i2;
        l14VarZ.d = i3;
        if (ja0.s) {
            bo3 bo3Var = (bo3) l14VarZ;
            if (this.M0 == null) {
                i4 = 0;
            }
            bo3Var.f = i4;
        }
        l14VarZ.e = i5;
        this.I0++;
    }

    public final void J() {
        int i = this.Q0;
        int i2 = this.W0;
        int i3 = i2 - 1;
        l14[] l14VarArr = this.H0;
        int i4 = this.I0 - 1;
        this.I0 = i4;
        l14 l14Var = l14VarArr[i4];
        int i5 = l14Var.b;
        this.Q0 = l14Var.c;
        this.W0 = i2 + 1;
        int i6 = this.V0[i2];
        boolean z = ja0.N;
        int i7 = this.Z;
        if (z) {
            System.out.println("ABSENT: s:" + this.P0 + " end:" + i7 + " absent:" + i5 + " aend:" + i);
        }
        if (i5 > i && this.P0 > i5) {
            F0();
            k0();
            return;
        }
        int i8 = this.P0;
        if (i8 >= i && i8 > i5) {
            if (i8 > i || i8 > i7) {
                k0();
                return;
            } else {
                this.W0 += i6;
                return;
            }
        }
        H0(1, this.W0 + i6, i8, this.R0, this.U0);
        int i9 = this.P0;
        int iR = i9 >= i7 ? 1 : this.X.r(i9, i7, this.Y);
        int i10 = this.Q0;
        l14 l14VarZ = z();
        l14VarZ.a = 2816;
        l14VarZ.b = i5;
        l14VarZ.c = i10;
        this.I0++;
        int i11 = this.P0;
        H0(1, i3, i11 + iR, i11, this.U0);
        z().a = 3072;
        this.I0++;
        this.Q0 = i;
    }

    public final void J0(int i, int i2) {
        l14 l14VarZ = z();
        l14VarZ.a = 33280;
        l14VarZ.b = i;
        l14VarZ.c = i2;
        int i3 = this.K0 + i;
        int[] iArr = this.J0;
        l14VarZ.d = iArr[i3];
        int i4 = this.L0;
        l14VarZ.e = iArr[i4 + i];
        int i5 = i4 + i;
        int i6 = this.I0;
        iArr[i5] = i6;
        this.I0 = i6 + 1;
    }

    public final void K() {
        int i = this.R0;
        if (i < this.Q0) {
            this.Q0 = i;
        }
        if (ja0.N) {
            System.out.println("ABSENT_END: end:" + this.Q0);
        }
        while (true) {
            l14[] l14VarArr = this.H0;
            int i2 = this.I0 - 1;
            this.I0 = i2;
            l14 l14Var = l14VarArr[i2];
            if (l14Var.a == 3072) {
                k0();
                return;
            }
            G0(l14Var);
        }
    }

    public final void K0(int i) {
        l14 l14VarZ = z();
        l14VarZ.a = 768;
        l14VarZ.b = i;
        this.I0++;
    }

    public final void L() {
        int i = this.P0;
        if (i < this.Q0) {
            int i2 = this.Z;
            k0 k0Var = this.X;
            byte[] bArr = this.Y;
            if (mh2.o(i, i2, k0Var, bArr)) {
                int i3 = this.P0;
                this.P0 = k0Var.r(i3, i2, bArr) + i3;
                this.R0 = this.T0;
                return;
            }
        }
        k0();
    }

    public final void L0(int i, int i2) {
        st stVar;
        l14 l14Var = this.H0[i2];
        int i3 = l14Var.b + 1;
        l14Var.b = i3;
        th3 th3Var = this.A;
        if (i3 >= th3Var.n[i]) {
            stVar = this;
        } else if (i3 >= th3Var.m[i]) {
            stVar = this;
            stVar.H0(1, this.W0, this.P0, this.R0, this.U0);
            stVar.W0 = l14Var.c;
        } else {
            stVar = this;
            stVar.W0 = l14Var.c;
        }
        stVar.K0(i2);
    }

    public final void M() {
        int i = this.P0;
        if (i < this.Q0) {
            int i2 = this.Z;
            k0 k0Var = this.X;
            byte[] bArr = this.Y;
            if (mh2.o(i, i2, k0Var, bArr) && (this.P0 == 0 || !mh2.o(this.R0, i2, k0Var, bArr))) {
                return;
            }
        }
        k0();
    }

    public final void M0(int i, int i2) {
        l14 l14Var = this.H0[i2];
        int i3 = l14Var.b + 1;
        l14Var.b = i3;
        th3 th3Var = this.A;
        int i4 = th3Var.n[i];
        if (i3 >= i4) {
            if (i3 == i4) {
                K0(i2);
                return;
            }
            return;
        }
        int i5 = th3Var.m[i];
        int i6 = l14Var.c;
        if (i3 >= i5) {
            K0(i2);
            H0(1, i6, this.P0, this.R0, this.U0);
        } else {
            this.W0 = i6;
            K0(i2);
        }
    }

    public final void N() {
        int i = this.P0;
        int i2 = this.Z;
        byte[] bArr = this.Y;
        k0 k0Var = this.X;
        if (i == 0) {
            if (i >= this.Q0 || !mh2.o(i, i2, k0Var, bArr)) {
                k0();
                return;
            }
            return;
        }
        if (i != i2) {
            if (mh2.o(i, i2, k0Var, bArr) == mh2.o(this.R0, i2, k0Var, bArr)) {
                k0();
            }
        } else {
            int i3 = this.R0;
            if (i3 >= i2 || !mh2.o(i3, i2, k0Var, bArr)) {
                k0();
            }
        }
    }

    public final void N0() {
        l14 l14Var = this.H0[this.I0];
        int i = l14Var.c;
        int i2 = (((bo3) l14Var).f - 1) + (i * this.A.g);
        byte[] bArr = this.M0;
        int i3 = i2 / 8;
        bArr[i3] = (byte) ((1 << (i2 % 8)) | bArr[i3]);
    }

    public final void O() {
        int i;
        if (this.P0 != 0) {
            int i2 = this.R0;
            int i3 = this.Z;
            k0 k0Var = this.X;
            byte[] bArr = this.Y;
            if (mh2.o(i2, i3, k0Var, bArr) && ((i = this.P0) == i3 || !mh2.o(i, i3, k0Var, bArr))) {
                return;
            }
        }
        k0();
    }

    public final boolean O0(int i, int i2) {
        byte[] bArr = this.M0;
        if (bArr == null) {
            return false;
        }
        int i3 = (i2 - 1) + (i * this.A.g);
        return (bArr[i3 / 8] & (1 << (i3 % 8))) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        if (Q0(r8, r2, r18, r4, r5) == false) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P() {
        int i;
        boolean z;
        int i2;
        int i3 = this.W0;
        int i4 = i3 + 1;
        this.W0 = i4;
        int[] iArr = this.V0;
        int i5 = iArr[i3];
        int i6 = i3 + 2;
        this.W0 = i6;
        int i7 = iArr[i4];
        int i8 = i3 + 3;
        this.W0 = i8;
        int i9 = iArr[i6];
        this.R0 = this.P0;
        boolean z2 = i5 != 0;
        int i10 = this.A.r;
        int i11 = this.I0 - 1;
        int i12 = 0;
        int i13 = -1;
        while (true) {
            if (i11 < 0) {
                break;
            }
            l14 l14Var = this.H0[i11];
            int i14 = l14Var.a;
            if (i14 == 2048) {
                i12--;
            } else if (i14 == 2304) {
                i12++;
            } else {
                if (i12 == i7) {
                    if (i14 == 256) {
                        int i15 = l14Var.b;
                        int i16 = i8;
                        int i17 = 0;
                        while (i17 < i9) {
                            int i18 = i16 + 1;
                            if (i15 == iArr[i16]) {
                                i = i7;
                                int i19 = l14Var.c;
                                if (i13 != -1) {
                                    boolean z3 = z2;
                                    int i20 = i13 - i19;
                                    int i21 = this.P0;
                                    int i22 = this.Z;
                                    if (i20 <= i22 - i21) {
                                        this.b = i21;
                                        byte[] bArr = this.Y;
                                        if (!z3) {
                                            while (i19 < i13) {
                                                int i23 = i19 + 1;
                                                byte b = bArr[i19];
                                                int i24 = this.b;
                                                this.b = i24 + 1;
                                                if (b == bArr[i24]) {
                                                    i19 = i23;
                                                }
                                            }
                                            this.P0 = this.b;
                                            if (this.R0 < this.Q0) {
                                                while (true) {
                                                    int i25 = this.R0;
                                                    int iR = this.X.r(i25, this.Z, bArr);
                                                    if (i25 + iR >= this.P0) {
                                                        break;
                                                    } else {
                                                        this.R0 += iR;
                                                    }
                                                }
                                            }
                                            this.W0 += i9;
                                            return;
                                        }
                                    }
                                }
                                z = z2;
                                i2 = i10;
                            } else {
                                i17++;
                                i7 = i7;
                                i16 = i18;
                            }
                        }
                    } else {
                        i = i7;
                        z = z2;
                        i2 = i10;
                        if (i14 == 33280) {
                            int i26 = l14Var.b;
                            int i27 = i8;
                            int i28 = 0;
                            while (true) {
                                if (i28 < i9) {
                                    int i29 = i27 + 1;
                                    if (i26 == iArr[i27]) {
                                        i13 = l14Var.c;
                                        break;
                                    } else {
                                        i28++;
                                        i27 = i29;
                                    }
                                }
                            }
                        }
                    }
                }
                i11--;
                i10 = i2;
                i7 = i;
                z2 = z;
            }
            i = i7;
            z = z2;
            i2 = i10;
            i11--;
            i10 = i2;
            i7 = i;
            z2 = z;
        }
        k0();
    }

    public final void P0() {
        int i = this.I0;
        while (true) {
            i--;
            l14 l14Var = this.H0[i];
            int i2 = l14Var.a;
            if ((i2 & 4351) != 0) {
                l14Var.a = 2560;
            } else if (i2 == 1536) {
                l14Var.a = 2560;
                return;
            }
        }
    }

    public final void Q() {
        int i = this.W0;
        this.W0 = i + 1;
        int[] iArr = this.V0;
        int i2 = iArr[i];
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int i4 = this.W0;
            this.W0 = i4 + 1;
            int i5 = iArr[i4];
            if (!v(i5)) {
                int iW = w(i5);
                int iU = u(i5) - iW;
                int i6 = this.P0;
                if (i6 + iU > this.Q0) {
                    continue;
                } else {
                    this.R0 = i6;
                    while (true) {
                        int i7 = iU - 1;
                        byte[] bArr = this.Y;
                        if (iU > 0) {
                            int i8 = iW + 1;
                            int i9 = i6 + 1;
                            if (bArr[iW] != bArr[i6]) {
                                break;
                            }
                            iW = i8;
                            iU = i7;
                            i6 = i9;
                        } else {
                            this.P0 = i6;
                            if (this.R0 < this.Q0) {
                                while (true) {
                                    int i10 = this.R0;
                                    int iR = this.X.r(i10, this.Z, bArr);
                                    if (i10 + iR >= this.P0) {
                                        break;
                                    } else {
                                        this.R0 += iR;
                                    }
                                }
                            }
                            this.W0 = ((i2 - i3) - 1) + this.W0;
                        }
                    }
                }
            }
            i3++;
        }
        if (i3 == i2) {
            k0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        r10 = r3;
        r9 = r5;
        r14 = r6;
        r0 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Q0(int i, int i2, st stVar, int i3, int i4) {
        byte[] bArr = this.Y0;
        if (bArr == null) {
            bArr = new byte[18];
            this.Y0 = bArr;
        }
        byte[] bArr2 = bArr;
        byte[] bArr3 = this.Z0;
        if (bArr3 == null) {
            bArr3 = new byte[18];
            this.Z0 = bArr3;
        }
        int i5 = stVar.b;
        int i6 = i3 + i2;
        loop0: while (i2 < i6) {
            this.b = i2;
            k0 k0Var = this.X;
            byte[] bArr4 = this.Y;
            st stVar2 = this;
            int i7 = i4;
            int i8 = i;
            int iT = k0Var.t(i8, bArr4, stVar2, i7, bArr2);
            i2 = stVar2.b;
            stVar2.b = i5;
            byte[] bArr5 = bArr3;
            int iT2 = stVar2.X.t(i8, bArr4, stVar2, i7, bArr5);
            i5 = stVar2.b;
            if (iT == iT2) {
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    int i11 = iT - 1;
                    if (iT > 0) {
                        if (bArr2[i9] != bArr5[i10]) {
                            break loop0;
                        }
                        i9++;
                        i10++;
                        iT = i11;
                    }
                }
            }
            return false;
        }
        stVar.b = i5;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R() {
        st stVar;
        int i = this.W0;
        this.W0 = i + 1;
        int[] iArr = this.V0;
        int i2 = iArr[i];
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                stVar = this;
                break;
            }
            int i4 = this.W0;
            this.W0 = i4 + 1;
            int i5 = iArr[i4];
            if (this.v(i5)) {
                stVar = this;
            } else {
                int iW = this.w(i5);
                int iU = this.u(i5) - iW;
                int i6 = this.P0;
                if (i6 + iU <= this.Q0) {
                    this.R0 = i6;
                    this.b = i6;
                    stVar = this;
                    if (stVar.Q0(this.A.r, iW, this, iU, this.Z)) {
                        stVar.P0 = stVar.b;
                        if (stVar.R0 < stVar.Q0) {
                            while (true) {
                                int i7 = stVar.R0;
                                int iR = stVar.X.r(i7, stVar.Z, stVar.Y);
                                if (i7 + iR >= stVar.P0) {
                                    break;
                                } else {
                                    stVar.R0 += iR;
                                }
                            }
                        }
                        stVar.W0 = ((i2 - i3) - 1) + stVar.W0;
                    }
                }
            }
            i3++;
            this = stVar;
        }
        if (i3 == i2) {
            stVar.k0();
        }
    }

    public final void S() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        th3 th3Var = this.A;
        if (i2 > th3Var.d || v(i2)) {
            k0();
            return;
        }
        int iW = w(i2);
        int iU = u(i2) - iW;
        int i3 = this.P0;
        if (i3 + iU > this.Q0) {
            k0();
            return;
        }
        this.R0 = i3;
        this.b = i3;
        if (!Q0(th3Var.r, iW, this, iU, this.Z)) {
            k0();
            return;
        }
        this.P0 = this.b;
        if (this.R0 >= this.Q0) {
            return;
        }
        while (true) {
            int i4 = this.R0;
            int iR = this.X.r(i4, this.Z, this.Y);
            if (i4 + iR >= this.P0) {
                return;
            } else {
                this.R0 += iR;
            }
        }
    }

    public final void T() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int i3 = this.V0[i];
        l14 l14VarZ = z();
        l14VarZ.a = 2048;
        l14VarZ.b = i2;
        this.I0++;
        this.W0 = i3;
    }

    public final void U() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = i + 2;
        this.W0 = i4;
        int i5 = iArr[i2];
        if (i3 <= this.A.d) {
            int i6 = this.L0 + i3;
            int[] iArr2 = this.J0;
            if (iArr2[i6] != -1 && iArr2[this.K0 + i3] != -1) {
                return;
            }
        }
        this.W0 = i4 + i5;
    }

    public final boolean V() {
        int i = this.P0;
        int i2 = this.S0;
        int i3 = i - i2;
        int i4 = this.O0;
        k70 k70Var = this.y0;
        if (i3 > i4) {
            boolean z = ja0.q;
            th3 th3Var = this.A;
            if (z && (th3Var.q & 16) != 0) {
                if (i3 <= this.z0) {
                    return y();
                }
                this.z0 = i3;
                this.A0 = i2;
            }
            this.O0 = i3;
            int i5 = this.U0;
            if (k70Var != null) {
                if (i5 <= i) {
                    i = i5;
                }
                this.C0 = i;
                k70Var.T0(0, i);
                int i6 = this.P0;
                this.D0 = i6;
                k70Var.U0(0, i6);
                for (int i7 = 1; i7 <= th3Var.d; i7++) {
                    int i8 = this.L0 + i7;
                    int[] iArr = this.J0;
                    int i9 = iArr[i8];
                    if (i9 != -1) {
                        int i10 = iArr[this.K0 + i7];
                        if (ez4.d(th3Var.j, i7)) {
                            i10 = this.H0[i10].c;
                        }
                        k70Var.T0(i7, i10);
                        if (ez4.d(th3Var.k, i7)) {
                            i9 = this.H0[i9].c;
                        }
                        k70Var.U0(i7, i9);
                    } else {
                        k70Var.T0(i7, -1);
                        k70Var.U0(i7, -1);
                    }
                }
                if (ja0.n && th3Var.i != 0) {
                    tt ttVar = (tt) k70Var.f;
                    if (ttVar == null) {
                        ttVar = new tt(1);
                        k70Var.f = ttVar;
                    } else {
                        for (int i11 = 0; i11 < ttVar.c; i11++) {
                            ((tt[]) ttVar.d)[i11] = null;
                        }
                        ttVar.c = 0;
                        ttVar.b = -1;
                    }
                    ttVar.b = 0;
                    this.X0 = 0;
                    H((tt) k70Var.f);
                }
            } else {
                if (i5 > i) {
                    i5 = i;
                }
                this.C0 = i5;
                this.D0 = i;
            }
        } else if (k70Var != null) {
            k70Var.F0();
        } else {
            this.D0 = 0;
            this.C0 = 0;
        }
        return y();
    }

    public final void W() {
        int i = this.P0;
        if (i < this.Q0) {
            int i2 = this.W0;
            if (this.V0[i2] == this.Y[i]) {
                this.W0 = i2 + 1;
                this.P0 = i + 1;
                this.R0 = this.T0;
                return;
            }
        }
        k0();
    }

    public final void X() {
        int i = this.P0;
        if (i >= this.Q0) {
            k0();
            return;
        }
        byte[] bArr = this.Y0;
        if (bArr == null) {
            bArr = new byte[18];
            this.Y0 = bArr;
        }
        byte[] bArr2 = bArr;
        this.b = i;
        int iT = this.X.t(this.A.r, this.Y, this, this.Z, bArr2);
        int i2 = this.b;
        this.P0 = i2;
        if (i2 > this.Q0) {
            k0();
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = iT - 1;
            if (iT <= 0) {
                this.R0 = this.T0;
                return;
            }
            int i5 = this.W0;
            if (this.V0[i5] != bArr2[i3]) {
                k0();
                return;
            } else {
                this.W0 = i5 + 1;
                i3++;
                iT = i4;
            }
        }
    }

    public final void Y() {
        int i = this.P0;
        int i2 = i + 2;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    this.R0 = i7;
                    this.W0 = i3 + 2;
                    this.P0 = i2;
                    return;
                }
            }
        }
        k0();
    }

    public final void Z() {
        int i = this.P0;
        int i2 = i + 3;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    int i8 = i3 + 2;
                    this.W0 = i8;
                    int i9 = iArr[i8];
                    int i10 = i + 2;
                    this.P0 = i10;
                    if (i9 == bArr[i10]) {
                        this.R0 = i10;
                        this.W0 = i3 + 3;
                        this.P0 = i2;
                        return;
                    }
                }
            }
        }
        k0();
    }

    public final void a0() {
        int i = this.P0;
        int i2 = i + 4;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    int i8 = i3 + 2;
                    this.W0 = i8;
                    int i9 = iArr[i8];
                    int i10 = i + 2;
                    this.P0 = i10;
                    if (i9 == bArr[i10]) {
                        int i11 = i3 + 3;
                        this.W0 = i11;
                        int i12 = iArr[i11];
                        int i13 = i + 3;
                        this.P0 = i13;
                        if (i12 == bArr[i13]) {
                            this.R0 = i13;
                            this.W0 = i3 + 4;
                            this.P0 = i2;
                            return;
                        }
                    }
                }
            }
        }
        k0();
    }

    public final void b0() {
        int i = this.P0;
        int i2 = i + 5;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    int i8 = i3 + 2;
                    this.W0 = i8;
                    int i9 = iArr[i8];
                    int i10 = i + 2;
                    this.P0 = i10;
                    if (i9 == bArr[i10]) {
                        int i11 = i3 + 3;
                        this.W0 = i11;
                        int i12 = iArr[i11];
                        int i13 = i + 3;
                        this.P0 = i13;
                        if (i12 == bArr[i13]) {
                            int i14 = i3 + 4;
                            this.W0 = i14;
                            int i15 = iArr[i14];
                            int i16 = i + 4;
                            this.P0 = i16;
                            if (i15 == bArr[i16]) {
                                this.R0 = i16;
                                this.W0 = i3 + 5;
                                this.P0 = i2;
                                return;
                            }
                        }
                    }
                }
            }
        }
        k0();
    }

    public final void c0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        if ((i3 * 2) + this.P0 > this.Q0) {
            k0();
            return;
        }
        boolean z = ja0.C;
        byte[] bArr = this.Y;
        if (!z) {
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                int i5 = this.W0;
                int i6 = iArr[i5];
                int i7 = this.P0;
                if (i6 != bArr[i7]) {
                    break;
                }
                int i8 = i5 + 1;
                this.W0 = i8;
                int i9 = iArr[i8];
                int i10 = i7 + 1;
                this.P0 = i10;
                if (i9 != bArr[i10]) {
                    break;
                }
                this.W0 = i5 + 2;
                this.P0 = i7 + 2;
                i3 = i4;
            }
            k0();
            return;
        }
        byte[][] bArr2 = this.A.G;
        int i11 = i + 2;
        this.W0 = i11;
        byte[] bArr3 = bArr2[iArr[i2]];
        this.W0 = i + 3;
        int i12 = iArr[i11];
        while (true) {
            int i13 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            byte b = bArr3[i12];
            int i14 = this.P0;
            if (b != bArr[i14]) {
                break;
            }
            byte b2 = bArr3[i12 + 1];
            int i15 = i14 + 1;
            this.P0 = i15;
            if (b2 != bArr[i15]) {
                break;
            }
            i12 += 2;
            this.P0 = i14 + 2;
            i3 = i13;
        }
        k0();
        return;
        this.R0 = this.P0 - 2;
    }

    public final void d0() {
        int i = this.P0;
        int i2 = i + 2;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    this.W0 = i3 + 2;
                    this.P0 = i2;
                    this.R0 = this.T0;
                    return;
                }
            }
        }
        k0();
    }

    public final void e0() {
        int i = this.P0;
        int i2 = i + 4;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    int i8 = i3 + 2;
                    this.W0 = i8;
                    int i9 = i + 2;
                    this.P0 = i9;
                    this.R0 = i9;
                    if (iArr[i8] == bArr[i9]) {
                        int i10 = i3 + 3;
                        this.W0 = i10;
                        int i11 = iArr[i10];
                        int i12 = i + 3;
                        this.P0 = i12;
                        if (i11 == bArr[i12]) {
                            this.W0 = i3 + 4;
                            this.P0 = i2;
                            return;
                        }
                    }
                    k0();
                    return;
                }
            }
        }
        k0();
    }

    public final void f0() {
        int i = this.P0;
        int i2 = i + 6;
        if (i2 <= this.Q0) {
            int i3 = this.W0;
            int[] iArr = this.V0;
            int i4 = iArr[i3];
            byte[] bArr = this.Y;
            if (i4 == bArr[i]) {
                int i5 = i3 + 1;
                this.W0 = i5;
                int i6 = iArr[i5];
                int i7 = i + 1;
                this.P0 = i7;
                if (i6 == bArr[i7]) {
                    int i8 = i3 + 2;
                    this.W0 = i8;
                    int i9 = iArr[i8];
                    int i10 = i + 2;
                    this.P0 = i10;
                    if (i9 == bArr[i10]) {
                        int i11 = i3 + 3;
                        this.W0 = i11;
                        int i12 = iArr[i11];
                        int i13 = i + 3;
                        this.P0 = i13;
                        if (i12 == bArr[i13]) {
                            int i14 = i3 + 4;
                            this.W0 = i14;
                            int i15 = i + 4;
                            this.P0 = i15;
                            this.R0 = i15;
                            if (iArr[i14] == bArr[i15]) {
                                int i16 = i3 + 5;
                                this.W0 = i16;
                                int i17 = iArr[i16];
                                int i18 = i + 5;
                                this.P0 = i18;
                                if (i17 == bArr[i18]) {
                                    this.W0 = i3 + 6;
                                    this.P0 = i2;
                                    return;
                                }
                            }
                            k0();
                            return;
                        }
                    }
                }
            }
        }
        k0();
    }

    public final void g0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        if ((i3 * 3) + this.P0 > this.Q0) {
            k0();
            return;
        }
        boolean z = ja0.C;
        byte[] bArr = this.Y;
        if (!z) {
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                int i5 = this.W0;
                int i6 = iArr[i5];
                int i7 = this.P0;
                if (i6 != bArr[i7]) {
                    break;
                }
                int i8 = i5 + 1;
                this.W0 = i8;
                int i9 = iArr[i8];
                int i10 = i7 + 1;
                this.P0 = i10;
                if (i9 != bArr[i10]) {
                    break;
                }
                int i11 = i5 + 2;
                this.W0 = i11;
                int i12 = iArr[i11];
                int i13 = i7 + 2;
                this.P0 = i13;
                if (i12 != bArr[i13]) {
                    break;
                }
                this.W0 = i5 + 3;
                this.P0 = i7 + 3;
                i3 = i4;
            }
            k0();
            return;
        }
        byte[][] bArr2 = this.A.G;
        int i14 = i + 2;
        this.W0 = i14;
        byte[] bArr3 = bArr2[iArr[i2]];
        this.W0 = i + 3;
        int i15 = iArr[i14];
        while (true) {
            int i16 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            byte b = bArr3[i15];
            int i17 = this.P0;
            if (b != bArr[i17]) {
                break;
            }
            byte b2 = bArr3[i15 + 1];
            int i18 = i17 + 1;
            this.P0 = i18;
            if (b2 != bArr[i18]) {
                break;
            }
            byte b3 = bArr3[i15 + 2];
            int i19 = i17 + 2;
            this.P0 = i19;
            if (b3 != bArr[i19]) {
                break;
            }
            i15 += 3;
            this.P0 = i17 + 3;
            i3 = i16;
        }
        k0();
        return;
        this.R0 = this.P0 - 3;
    }

    public final void h0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = i + 2;
        this.W0 = i4;
        int i5 = iArr[i2] * i3;
        if (this.P0 + i5 > this.Q0) {
            k0();
            return;
        }
        boolean z = ja0.C;
        byte[] bArr = this.Y;
        if (!z) {
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    break;
                }
                int i7 = this.W0;
                int i8 = iArr[i7];
                int i9 = this.P0;
                if (i8 != bArr[i9]) {
                    k0();
                    return;
                } else {
                    this.W0 = i7 + 1;
                    this.P0 = i9 + 1;
                    i5 = i6;
                }
            }
        } else {
            byte[][] bArr2 = this.A.G;
            int i10 = i + 3;
            this.W0 = i10;
            byte[] bArr3 = bArr2[iArr[i4]];
            this.W0 = i + 4;
            int i11 = iArr[i10];
            while (true) {
                int i12 = i5 - 1;
                if (i5 <= 0) {
                    break;
                }
                byte b = bArr3[i11];
                int i13 = this.P0;
                if (b != bArr[i13]) {
                    k0();
                    return;
                } else {
                    i11++;
                    this.P0 = i13 + 1;
                    i5 = i12;
                }
            }
        }
        this.R0 = this.P0 - i3;
    }

    public final void i0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        if (this.P0 + i3 > this.Q0) {
            k0();
            return;
        }
        boolean z = ja0.C;
        byte[] bArr = this.Y;
        if (!z) {
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                int i5 = this.W0;
                this.W0 = i5 + 1;
                int i6 = iArr[i5];
                int i7 = this.P0;
                this.P0 = i7 + 1;
                if (i6 != bArr[i7]) {
                    k0();
                    return;
                }
                i3 = i4;
            }
        } else {
            byte[][] bArr2 = this.A.G;
            int i8 = i + 2;
            this.W0 = i8;
            byte[] bArr3 = bArr2[iArr[i2]];
            this.W0 = i + 3;
            int i9 = iArr[i8];
            while (true) {
                int i10 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                int i11 = i9 + 1;
                byte b = bArr3[i9];
                int i12 = this.P0;
                this.P0 = i12 + 1;
                if (b != bArr[i12]) {
                    k0();
                    return;
                } else {
                    i9 = i11;
                    i3 = i10;
                }
            }
        }
        this.R0 = this.P0 - 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        r13 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        byte[] bArr = this.Y0;
        if (bArr == null) {
            bArr = new byte[18];
            this.Y0 = bArr;
        }
        byte[] bArr2 = bArr;
        boolean z = ja0.C;
        byte[] bArr3 = this.Y;
        th3 th3Var = this.A;
        if (!z) {
            int i4 = i2 + i3;
            while (this.W0 < i4) {
                int i5 = this.P0;
                this.R0 = i5;
                if (i5 >= this.Q0) {
                    k0();
                    return;
                }
                this.b = i5;
                int iT = this.X.t(th3Var.r, bArr3, this, this.Z, bArr2);
                int i6 = this.b;
                this.P0 = i6;
                if (i6 > this.Q0) {
                    k0();
                    return;
                }
                int i7 = 0;
                while (true) {
                    int i8 = iT - 1;
                    if (iT > 0) {
                        int i9 = this.W0;
                        if (iArr[i9] != bArr2[i7]) {
                            k0();
                            return;
                        } else {
                            this.W0 = i9 + 1;
                            i7++;
                            iT = i8;
                        }
                    }
                }
            }
            return;
        }
        byte[][] bArr4 = th3Var.G;
        int i10 = i + 2;
        this.W0 = i10;
        byte[] bArr5 = bArr4[iArr[i2]];
        this.W0 = i + 3;
        int i11 = iArr[i10];
        int i12 = i3 + i11;
        while (i11 < i12) {
            int i13 = this.P0;
            this.R0 = i13;
            if (i13 >= this.Q0) {
                this.k0();
                return;
            }
            this.b = i13;
            st stVar = this;
            int iT2 = this.X.t(th3Var.r, bArr3, stVar, this.Z, bArr2);
            int i14 = stVar.b;
            stVar.P0 = i14;
            if (i14 > stVar.Q0) {
                stVar.k0();
                return;
            }
            int i15 = 0;
            while (true) {
                int i16 = iT2 - 1;
                if (iT2 > 0) {
                    if (bArr5[i11] != bArr2[i15]) {
                        stVar.k0();
                        return;
                    } else {
                        i11++;
                        i15++;
                        iT2 = i16;
                    }
                }
            }
        }
    }

    public final void k0() {
        if (this.H0 == null) {
            this.W0 = this.A.b - 1;
            return;
        }
        l14 l14VarF0 = F0();
        this.W0 = l14VarF0.b;
        this.P0 = l14VarF0.c;
        this.R0 = l14VarF0.d;
        this.U0 = l14VarF0.e;
        if (!ja0.s || ((bo3) l14VarF0).f == 0) {
            return;
        }
        l14VarF0.a = 4096;
        this.I0++;
    }

    public final void l0() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.L0 + i2;
        int i4 = this.P0;
        int[] iArr = this.J0;
        iArr[i3] = i4;
        int iB = B(i2);
        int i5 = this.K0 + i2;
        if (!ez4.d(this.A.j, i2)) {
            iB = this.H0[iB].c;
        }
        iArr[i5] = iB;
        l14 l14VarZ = z();
        l14VarZ.a = 33792;
        l14VarZ.b = i2;
        this.I0++;
    }

    public final void m0() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.K0 + i2;
        int i4 = this.P0;
        int[] iArr = this.J0;
        iArr[i3] = i4;
        iArr[this.L0 + i2] = -1;
    }

    public final void n0() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.P0;
        l14 l14VarZ = z();
        l14VarZ.a = 256;
        l14VarZ.b = i2;
        l14VarZ.c = i3;
        int i4 = this.K0 + i2;
        int[] iArr = this.J0;
        l14VarZ.d = iArr[i4];
        int i5 = this.L0 + i2;
        l14VarZ.e = iArr[i5];
        int i6 = this.I0;
        iArr[i4] = i6;
        iArr[i5] = -1;
        this.I0 = i6 + 1;
    }

    public final void o0() {
        int i = this.P0;
        if (i < this.Q0) {
            int i2 = this.Z;
            k0 k0Var = this.X;
            byte[] bArr = this.Y;
            if (!mh2.o(i, i2, k0Var, bArr)) {
                int i3 = this.P0;
                this.P0 = k0Var.r(i3, i2, bArr) + i3;
                this.R0 = this.T0;
                return;
            }
        }
        k0();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0177, code lost:
    
        throw new defpackage.l12("undefined bytecode (bug)");
     */
    /* JADX WARN: Removed duplicated region for block: B:290:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0168  */
    @Override // defpackage.mh2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int p(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        boolean zO = je.O(0);
        this.Q0 = i;
        this.S0 = i2;
        this.R0 = i3;
        this.I0 = 0;
        this.W0 = 0;
        boolean z = ja0.N;
        int i10 = this.Z;
        if (z) {
            PrintStream printStream = ja0.G;
            StringBuilder sbD = dw2.D("match_at: str: 0, end: ", i10, ", start: ");
            sbD.append(this.S0);
            sbD.append(", sprev: ");
            sbD.append(this.R0);
            printStream.println(sbD.toString());
            printStream.println("size: " + i10 + ", start offset: " + this.S0);
        }
        l14[] l14VarArr = this.H0;
        int i11 = 1;
        th3 th3Var = this.A;
        if (l14VarArr != null) {
            int i12 = th3Var.b - 1;
            int i13 = this.I0;
            l14 l14Var = l14VarArr[i13];
            l14Var.a = 1;
            l14Var.b = i12;
            if (ja0.s) {
                ((bo3) l14Var).f = 0;
            }
            this.I0 = i13 + 1;
        }
        int i14 = this.L0;
        int i15 = this.K0;
        int[] iArr = this.J0;
        if (iArr != null) {
            for (int i16 = !ja0.f ? 1 : 0; i16 <= th3Var.d; i16++) {
                iArr[i16 + i14] = -1;
                iArr[i16 + i15] = -1;
            }
        }
        this.O0 = -1;
        this.P0 = i2;
        this.U0 = i2;
        k0 k0Var = this.X;
        if (k0Var.z) {
            return A();
        }
        int i17 = 0;
        while (true) {
            int i18 = i17 + 1;
            if (i17 >= this.N0) {
                D();
                i4 = i9;
            } else {
                i4 = i18;
            }
            if (ja0.N) {
                x();
            }
            int i19 = this.P0;
            this.T0 = i19;
            int i20 = this.W0;
            int i21 = i20 + 1;
            this.W0 = i21;
            int[] iArr2 = this.V0;
            int i22 = iArr2[i20];
            int i23 = i11;
            byte[] bArr = this.Y;
            switch (i22) {
                case 0:
                    return this.O0;
                case 1:
                    i5 = i23;
                    i6 = 0;
                    if (V()) {
                        return this.O0;
                    }
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                    break;
                case 2:
                    i5 = i23;
                    i6 = 0;
                    W();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 3:
                    i5 = i23;
                    i6 = 0;
                    Y();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 4:
                    i5 = i23;
                    i6 = 0;
                    Z();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 5:
                    i5 = i23;
                    i6 = 0;
                    a0();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 6:
                    i5 = i23;
                    i6 = 0;
                    b0();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 7:
                    i5 = i23;
                    i6 = 0;
                    i0();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 8:
                    i5 = i23;
                    i6 = 0;
                    d0();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    i5 = i23;
                    i6 = 0;
                    e0();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 10:
                    i5 = i23;
                    i6 = 0;
                    f0();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 11:
                    i5 = i23;
                    i6 = 0;
                    c0();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    i5 = i23;
                    i6 = 0;
                    g0();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 13:
                    i5 = i23;
                    i6 = 0;
                    h0();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 14:
                    i5 = i23;
                    i6 = 0;
                    X();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    i5 = i23;
                    i6 = 0;
                    j0();
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 16:
                    i5 = i23;
                    i6 = 0;
                    if (i19 >= this.Q0 || !E()) {
                        k0();
                    } else {
                        this.W0 += 8;
                        int i24 = this.P0;
                        int iR = k0Var.r(i24, i10, bArr) + i24;
                        this.P0 = iR;
                        if (iR > i10) {
                            this.P0 = i10;
                        }
                        this.R0 = this.T0;
                    }
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 17:
                    i5 = i23;
                    i6 = 0;
                    if (i19 >= this.Q0 || k0Var.r(i19, i10, bArr) == i5) {
                        k0();
                    } else if (F()) {
                        this.R0 = this.T0;
                    } else {
                        k0();
                    }
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 18:
                    i6 = 0;
                    if (i19 < this.Q0) {
                        if (k0Var.r(i19, i10, bArr) != 1) {
                            this.W0 += 8;
                            if (F()) {
                                i5 = 1;
                                this.R0 = this.T0;
                            } else {
                                k0();
                            }
                        } else if (E()) {
                            int i25 = this.W0;
                            int i26 = i25 + 8;
                            int i27 = i25 + 9;
                            this.W0 = i27;
                            this.W0 = i27 + iArr2[i26];
                            i5 = 1;
                            this.P0++;
                            this.R0 = this.T0;
                        } else {
                            k0();
                        }
                        i11 = i5;
                        i17 = i4;
                        i9 = i6;
                    } else {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 19:
                    i6 = 0;
                    if (i19 >= this.Q0 || E()) {
                        k0();
                    } else {
                        this.W0 += 8;
                        int i28 = this.P0;
                        int iR2 = k0Var.r(i28, i10, bArr) + i28;
                        this.P0 = iR2;
                        if (iR2 > i10) {
                            this.P0 = i10;
                        }
                        this.R0 = this.T0;
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 20:
                    i6 = 0;
                    if (i19 >= this.Q0) {
                        k0();
                    } else if (k0Var.r(i19, i10, bArr) == 1) {
                        this.P0++;
                        int i29 = this.W0;
                        int i30 = i29 + 1;
                        this.W0 = i30;
                        this.W0 = i30 + iArr2[i29];
                        this.R0 = this.T0;
                    } else if (G()) {
                        this.R0 = this.T0;
                    } else {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 21:
                    i6 = 0;
                    if (i19 < this.Q0) {
                        if (k0Var.r(i19, i10, bArr) != 1) {
                            this.W0 += 8;
                            if (G()) {
                                this.R0 = this.T0;
                            } else {
                                k0();
                            }
                        } else if (E()) {
                            k0();
                        } else {
                            int i31 = this.W0;
                            int i32 = i31 + 8;
                            int i33 = i31 + 9;
                            this.W0 = i33;
                            this.W0 = i33 + iArr2[i32];
                            this.P0++;
                            this.R0 = this.T0;
                        }
                        i11 = i5;
                        i17 = i4;
                        i9 = i6;
                    } else {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 22:
                    i6 = 0;
                    if (i19 < this.Q0) {
                        int iR3 = k0Var.r(i19, i10, bArr);
                        if (i19 + iR3 > this.Q0 || k0Var.m(this.P0, i10, bArr)) {
                            k0();
                        } else {
                            this.P0 += iR3;
                            this.R0 = this.T0;
                        }
                        i5 = 1;
                    }
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 23:
                    i6 = 0;
                    if (i19 >= this.Q0) {
                        k0();
                    } else {
                        int iR4 = this.P0 + k0Var.r(i19, i10, bArr);
                        if (iR4 > this.Q0) {
                            k0();
                        } else {
                            this.P0 = iR4;
                            this.R0 = this.T0;
                        }
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 24:
                    i6 = 0;
                    while (true) {
                        int i34 = this.P0;
                        if (i34 < this.Q0) {
                            H0(1, this.W0, i34, this.R0, this.U0);
                            int iR5 = k0Var.r(this.P0, i10, bArr);
                            int i35 = this.P0;
                            if (i35 + iR5 > this.Q0) {
                                k0();
                            } else if (k0Var.m(i35, i10, bArr)) {
                                k0();
                            } else {
                                int i36 = this.P0;
                                this.R0 = i36;
                                this.P0 = i36 + iR5;
                            }
                        }
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 25:
                    i6 = 0;
                    while (true) {
                        int i37 = this.P0;
                        if (i37 < this.Q0) {
                            H0(1, this.W0, i37, this.R0, this.U0);
                            int iR6 = k0Var.r(this.P0, i10, bArr);
                            int i38 = this.P0;
                            int i39 = iR6 + i38;
                            if (i39 > this.Q0) {
                                k0();
                            } else {
                                this.R0 = i38;
                                this.P0 = i39;
                            }
                        }
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 26:
                    i6 = 0;
                    byte b = (byte) iArr2[i21];
                    while (true) {
                        int i40 = this.P0;
                        if (i40 < this.Q0) {
                            if (b == bArr[i40]) {
                                H0(1, this.W0 + 1, i40, this.R0, this.U0);
                            }
                            int iR7 = k0Var.r(this.P0, i10, bArr);
                            int i41 = this.P0;
                            if (i41 + iR7 <= this.Q0 && !k0Var.m(i41, i10, bArr)) {
                                int i42 = this.P0;
                                this.R0 = i42;
                                this.P0 = i42 + iR7;
                            }
                        } else {
                            this.W0++;
                            this.R0 = this.T0;
                        }
                    }
                    k0();
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 27:
                    i6 = 0;
                    byte b2 = (byte) iArr2[i21];
                    while (true) {
                        int i43 = this.P0;
                        if (i43 < this.Q0) {
                            if (b2 == bArr[i43]) {
                                H0(1, this.W0 + 1, i43, this.R0, this.U0);
                            }
                            int iR8 = k0Var.r(this.P0, i10, bArr);
                            int i44 = this.P0;
                            int i45 = iR8 + i44;
                            if (i45 > this.Q0) {
                                k0();
                            } else {
                                this.R0 = i44;
                                this.P0 = i45;
                            }
                        } else {
                            this.W0++;
                            this.R0 = this.T0;
                        }
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 28:
                    i6 = 0;
                    if (i19 >= this.Q0 || !k0Var.l(i19, i10, bArr)) {
                        k0();
                    } else {
                        int i46 = this.P0;
                        this.P0 = k0Var.r(i46, i10, bArr) + i46;
                        this.R0 = this.T0;
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 29:
                    i6 = 0;
                    if (i19 >= this.Q0 || k0Var.l(i19, i10, bArr)) {
                        k0();
                    } else {
                        int i47 = this.P0;
                        this.P0 = k0Var.r(i47, i10, bArr) + i47;
                        this.R0 = this.T0;
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 30:
                    i6 = 0;
                    if (i19 == 0) {
                        if (i19 >= this.Q0 || !k0Var.l(i19, i10, bArr)) {
                            k0();
                        }
                    } else if (i19 == i10) {
                        int i48 = this.R0;
                        if (i48 >= i10 || !k0Var.l(i48, i10, bArr)) {
                            k0();
                        }
                    } else if (k0Var.l(i19, i10, bArr) == k0Var.l(this.R0, i10, bArr)) {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 31:
                    i6 = 0;
                    if (i19 == 0) {
                        if (i19 < this.Q0 && k0Var.l(i19, i10, bArr)) {
                            k0();
                        }
                    } else if (i19 == i10) {
                        int i49 = this.R0;
                        if (i49 < i10 && k0Var.l(i49, i10, bArr)) {
                            k0();
                        }
                    } else if (k0Var.l(i19, i10, bArr) != k0Var.l(this.R0, i10, bArr)) {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 32:
                    i6 = 0;
                    if (i19 >= this.Q0 || !k0Var.l(i19, i10, bArr) || (this.P0 != 0 && k0Var.l(this.R0, i10, bArr))) {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 33:
                    i6 = 0;
                    if (i19 == 0 || !k0Var.l(this.R0, i10, bArr) || ((i7 = this.P0) != i10 && k0Var.l(i7, i10, bArr))) {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 34:
                    i6 = 0;
                    L();
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 35:
                    i6 = 0;
                    o0();
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 36:
                    i6 = 0;
                    N();
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 37:
                    i6 = 0;
                    p0();
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 38:
                    i6 = 0;
                    M();
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 39:
                    i6 = 0;
                    O();
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 40:
                    i6 = 0;
                    if (i19 != 0) {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 41:
                    i6 = 0;
                    if (i19 != i10) {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 42:
                    i6 = 0;
                    if (i19 != 0 && (!k0Var.m(this.R0, i10, bArr) || this.P0 == i10)) {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 43:
                    i6 = 0;
                    if (i19 == i10) {
                        if (ja0.j) {
                            if ((i10 == 0 || !k0Var.m(this.R0, i10, bArr)) && zO) {
                                k0();
                            }
                        } else if (zO) {
                            k0();
                        }
                    } else if (!k0Var.m(i19, i10, bArr)) {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 44:
                    i6 = 0;
                    B0();
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 45:
                    i6 = 0;
                    if (i19 != this.B0) {
                        k0();
                    }
                    i5 = 1;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 46:
                    i6 = 0;
                    t(i23);
                    i5 = i23;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 47:
                    i6 = 0;
                    t(2);
                    i5 = i23;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                    i8 = 0;
                    this.W0 = i20 + 2;
                    t(iArr2[i21]);
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 49:
                    i8 = 0;
                    S();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 50:
                    i8 = 0;
                    Q();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 51:
                    i8 = 0;
                    R();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 52:
                    i8 = 0;
                    P();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 53:
                    i8 = 0;
                    m0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 54:
                    i8 = 0;
                    n0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 55:
                    i8 = 0;
                    this.W0 = i20 + 2;
                    J0(iArr2[i21], i19);
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 56:
                    i8 = 0;
                    this.W0 = i20 + 2;
                    int i50 = iArr2[i21];
                    int iB = B(i50);
                    J0(i50, this.P0);
                    iArr[i50 + i15] = iB;
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 57:
                    i8 = 0;
                    this.W0 = i20 + 2;
                    iArr[iArr2[i21] + i14] = i19;
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 58:
                    i8 = 0;
                    l0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 59:
                    i8 = 0;
                    this.U0 = i19;
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 60:
                    i8 = 0;
                    k0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 61:
                    i8 = 0;
                    this.W0 = iArr2[i21] + 1 + i21;
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 62:
                    i8 = 0;
                    int i51 = i20 + 2;
                    this.W0 = i51;
                    H0(1, iArr2[i21] + i51, i19, this.R0, this.U0);
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 63:
                    i8 = 0;
                    this.I0--;
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 64:
                    i8 = 0;
                    x0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 65:
                    i8 = 0;
                    v0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 66:
                    i8 = 0;
                    y0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 67:
                    i8 = 0;
                    z0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 68:
                    i8 = 0;
                    this.W0 = i20 + 2;
                    int i52 = iArr2[i21];
                    L0(i52, iArr[i52]);
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 69:
                    i8 = 0;
                    this.W0 = i20 + 2;
                    int i53 = iArr2[i21];
                    M0(i53, iArr[i53]);
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 70:
                    i8 = 0;
                    this.W0 = i20 + 2;
                    int i54 = iArr2[i21];
                    L0(i54, C(i54));
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 71:
                    i8 = 0;
                    this.W0 = i20 + 2;
                    int i55 = iArr2[i21];
                    M0(i55, C(i55));
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 72:
                    i8 = 0;
                    t0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 73:
                    i8 = 0;
                    q0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 74:
                    i8 = 0;
                    r0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 75:
                    i8 = 0;
                    s0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 76:
                    i8 = 0;
                    H0(1280, -1, i19, this.R0, this.U0);
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 77:
                    i8 = 0;
                    u0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 78:
                    i8 = 0;
                    int i56 = i20 + 2;
                    this.W0 = i56;
                    H0(3, iArr2[i21] + i56, i19, this.R0, this.U0);
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 79:
                    i8 = 0;
                    while (true) {
                        l14[] l14VarArr2 = this.H0;
                        int i57 = this.I0 - 1;
                        this.I0 = i57;
                        l14 l14Var2 = l14VarArr2[i57];
                        if (l14Var2.a == 3) {
                            k0();
                            i5 = i23;
                            i6 = i8;
                            i11 = i5;
                            i17 = i4;
                            i9 = i6;
                        } else {
                            G0(l14Var2);
                        }
                        break;
                    }
                    break;
                case 80:
                    i8 = 0;
                    z().a = 1536;
                    this.I0++;
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 81:
                    i8 = 0;
                    P0();
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 82:
                    this.W0 = i20 + 2;
                    int iY = k0Var.y(i19, i10, iArr2[i21], bArr);
                    this.P0 = iY;
                    if (iY == -1) {
                        k0();
                        i8 = 0;
                    } else {
                        i8 = 0;
                        this.R0 = k0Var.v(0, iY, i10, bArr);
                    }
                    i5 = i23;
                    i6 = i8;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 83:
                    w0();
                    i5 = i23;
                    i6 = 0;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 84:
                    while (true) {
                        l14[] l14VarArr3 = this.H0;
                        int i58 = this.I0 - 1;
                        this.I0 = i58;
                        l14 l14Var3 = l14VarArr3[i58];
                        if (l14Var3.a == 2) {
                            k0();
                            i5 = i23;
                            i6 = 0;
                            i11 = i5;
                            i17 = i4;
                            i9 = i6;
                        } else {
                            G0(l14Var3);
                        }
                        break;
                    }
                    break;
                case 85:
                    int i59 = this.Q0;
                    l14 l14VarZ = z();
                    l14VarZ.a = 2816;
                    l14VarZ.b = i19;
                    l14VarZ.c = i59;
                    this.I0++;
                    i5 = i23;
                    i6 = 0;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 86:
                    J();
                    i5 = i23;
                    i6 = 0;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 87:
                    K();
                    i5 = i23;
                    i6 = 0;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 88:
                    T();
                    i5 = i23;
                    i6 = 0;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 89:
                    A0();
                    i5 = i23;
                    i6 = 0;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 90:
                    U();
                    i5 = i23;
                    i6 = 0;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 91:
                    if (ja0.s) {
                        D0();
                    } else if (ja0.s) {
                        E0();
                    } else if (ja0.s) {
                        C0();
                    }
                    i5 = i23;
                    i6 = 0;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
                case 94:
                    if (ja0.s) {
                        this.W0 = i20 + 2;
                        int i60 = iArr2[i21];
                        while (true) {
                            int i61 = this.P0;
                            if (i61 >= this.Q0) {
                                this.R0 = this.T0;
                            } else if (O0(i61, i60)) {
                                k0();
                            } else {
                                I0(this.W0, this.P0, this.R0, i60, this.U0);
                                int iR9 = k0Var.r(this.P0, i10, bArr);
                                int i62 = this.P0;
                                if (i62 + iR9 <= this.Q0 && !k0Var.m(i62, i10, bArr)) {
                                    int i63 = this.P0;
                                    this.R0 = i63;
                                    this.P0 = i63 + iR9;
                                }
                            }
                        }
                        k0();
                    } else if (ja0.s) {
                        this.W0 = i20 + 2;
                        int i64 = iArr2[i21];
                        while (true) {
                            int i65 = this.P0;
                            if (i65 >= this.Q0) {
                                this.R0 = this.T0;
                            } else if (O0(i65, i64)) {
                                k0();
                            } else {
                                I0(this.W0, this.P0, this.R0, i64, this.U0);
                                int iR10 = k0Var.r(this.P0, i10, bArr);
                                int i66 = this.P0;
                                int i67 = iR10 + i66;
                                if (i67 > this.Q0) {
                                    k0();
                                } else {
                                    this.R0 = i66;
                                    this.P0 = i67;
                                }
                            }
                        }
                    }
                    i5 = i23;
                    i6 = 0;
                    i11 = i5;
                    i17 = i4;
                    i9 = i6;
                    break;
            }
        }
    }

    public final void p0() {
        int i = this.P0;
        int i2 = this.Z;
        byte[] bArr = this.Y;
        k0 k0Var = this.X;
        if (i == 0) {
            if (i >= this.Q0 || !mh2.o(i, i2, k0Var, bArr)) {
                return;
            }
            k0();
            return;
        }
        if (i != i2) {
            if (mh2.o(i, i2, k0Var, bArr) != mh2.o(this.R0, i2, k0Var, bArr)) {
                k0();
            }
        } else {
            int i3 = this.R0;
            if (i3 >= i2 || !mh2.o(i3, i2, k0Var, bArr)) {
                return;
            }
            k0();
        }
    }

    public final void q0() {
        l14 l14Var;
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.P0;
        int i4 = this.I0;
        while (true) {
            i4--;
            l14Var = this.H0[i4];
            if (l14Var.a == 12288 && l14Var.b == i2) {
                break;
            }
        }
        if (l14Var.c == i3) {
            if (ja0.N) {
                PrintStream printStream = ja0.G;
                StringBuilder sbD = dw2.D("NULL_CHECK_END: skip  id:", i2, ", s:");
                sbD.append(this.P0);
                printStream.println(sbD.toString());
            }
            I();
        }
    }

    public final void r0() {
        l14 l14Var;
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.P0;
        int i4 = this.I0;
        while (true) {
            i4--;
            l14Var = this.H0[i4];
            if (l14Var.a == 12288 && l14Var.b == i2) {
                break;
            }
        }
        byte b = 0;
        if (l14Var.c == i3) {
            byte b2 = 1;
            while (true) {
                if (i4 >= this.I0) {
                    b = b2;
                    break;
                }
                int i5 = i4 + 1;
                l14 l14Var2 = this.H0[i4];
                if (l14Var2.a == 256) {
                    if (l14Var2.e == -1) {
                        break;
                    }
                    int i6 = ez4.d(this.A.k, l14Var2.b) ? this.H0[l14Var2.e].c : l14Var2.e;
                    if (this.H0[l14Var2.d].c != i6) {
                        break;
                    } else if (i6 != i3) {
                        b2 = -1;
                    }
                }
                i4 = i5;
            }
        }
        if (b != 0) {
            if (ja0.N) {
                PrintStream printStream = ja0.G;
                StringBuilder sbD = dw2.D("NULL_CHECK_END_MEMST: skip  id:", i2, ", s:");
                sbD.append(this.P0);
                printStream.println(sbD.toString());
            }
            if (b == -1) {
                k0();
            } else {
                I();
            }
        }
    }

    public final void s0() {
        l14 l14Var;
        l14 l14Var2;
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        boolean z = ja0.i;
        int i3 = this.P0;
        int i4 = this.I0;
        byte b = 0;
        if (z) {
            int i5 = 0;
            while (true) {
                i4--;
                l14Var2 = this.H0[i4];
                int i6 = l14Var2.a;
                if (i6 == 12288) {
                    if (l14Var2.b != i2) {
                        continue;
                    } else if (i5 == 0) {
                        break;
                    } else {
                        i5--;
                    }
                } else if (i6 == 20480 && l14Var2.b == i2) {
                    i5++;
                }
            }
            if (l14Var2.c == i3) {
                byte b2 = 1;
                while (true) {
                    if (i4 >= this.I0) {
                        b = b2;
                        break;
                    }
                    if (l14Var2.a == 256) {
                        if (l14Var2.e == -1) {
                            break;
                        }
                        int i7 = ez4.d(this.A.k, l14Var2.b) ? this.H0[l14Var2.e].c : l14Var2.e;
                        if (this.H0[l14Var2.d].c != i7) {
                            break;
                        } else if (i7 != i3) {
                            b2 = -1;
                        }
                    }
                    i4++;
                    l14Var2 = this.H0[i4];
                }
            }
        } else {
            int i8 = 0;
            while (true) {
                i4--;
                l14Var = this.H0[i4];
                int i9 = l14Var.a;
                if (i9 == 12288) {
                    if (l14Var.b != i2) {
                        continue;
                    } else if (i8 == 0) {
                        break;
                    } else {
                        i8--;
                    }
                } else if (i9 == 20480) {
                    i8++;
                }
            }
            if (l14Var.c == i3) {
                b = 1;
            }
        }
        if (b == 0) {
            l14 l14VarZ = z();
            l14VarZ.a = 20480;
            l14VarZ.b = i2;
            this.I0++;
            return;
        }
        if (ja0.N) {
            PrintStream printStream = ja0.G;
            StringBuilder sbD = dw2.D("NULL_CHECK_END_MEMST_PUSH: skip  id:", i2, ", s:");
            sbD.append(this.P0);
            printStream.println(sbD.toString());
        }
        if (b == -1) {
            k0();
        } else {
            I();
        }
    }

    public final void t(int i) {
        if (i > this.A.d || v(i)) {
            k0();
            return;
        }
        int iW = w(i);
        int iU = u(i) - iW;
        int i2 = this.P0;
        if (i2 + iU > this.Q0) {
            k0();
            return;
        }
        this.R0 = i2;
        while (true) {
            int i3 = iU - 1;
            byte[] bArr = this.Y;
            if (iU > 0) {
                int i4 = iW + 1;
                byte b = bArr[iW];
                int i5 = this.P0;
                this.P0 = i5 + 1;
                if (b != bArr[i5]) {
                    k0();
                    return;
                } else {
                    iW = i4;
                    iU = i3;
                }
            } else {
                if (this.R0 >= this.Q0) {
                    return;
                }
                while (true) {
                    int i6 = this.R0;
                    int iR = this.X.r(i6, this.Z, bArr);
                    if (i6 + iR >= this.P0) {
                        return;
                    } else {
                        this.R0 += iR;
                    }
                }
            }
        }
    }

    public final void t0() {
        int i = this.W0;
        this.W0 = i + 1;
        int i2 = this.V0[i];
        int i3 = this.P0;
        l14 l14VarZ = z();
        l14VarZ.a = 12288;
        l14VarZ.b = i2;
        l14VarZ.c = i3;
        this.I0++;
    }

    public final int u(int i) {
        int i2 = this.J0[this.L0 + i];
        return ez4.d(this.A.k, i) ? this.H0[i2].c : i2;
    }

    public final void u0() {
        l14[] l14VarArr = this.H0;
        int i = this.I0;
        while (true) {
            i--;
            l14 l14Var = this.H0[i];
            int i2 = l14Var.a;
            if ((i2 & 4351) != 0) {
                l14Var.a = 2560;
            } else if (i2 == 1280) {
                l14Var.a = 2560;
                l14 l14Var2 = l14VarArr[i];
                this.P0 = l14Var2.c;
                this.R0 = l14Var2.d;
                return;
            }
        }
    }

    public final boolean v(int i) {
        int i2 = this.L0 + i;
        int[] iArr = this.J0;
        return iArr[i2] == -1 || iArr[this.K0 + i] == -1;
    }

    public final void v0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = this.P0;
        if (i4 >= this.Q0 || iArr[i2] != this.Y[i4]) {
            this.W0 = i + 2;
            return;
        }
        int i5 = i + 2;
        this.W0 = i5;
        H0(1, i5 + i3, i4, this.R0, this.U0);
    }

    public final int w(int i) {
        int i2 = this.J0[this.K0 + i];
        return ez4.d(this.A.j, i) ? this.H0[i2].c : i2;
    }

    public final void w0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        this.W0 = i + 2;
        int i4 = iArr[i2];
        int i5 = this.P0;
        k0 k0Var = this.X;
        int i6 = this.Z;
        byte[] bArr = this.Y;
        int iY = k0Var.y(i5, i6, i4, bArr);
        int i7 = this.W0;
        if (iY == -1) {
            this.W0 = i7 + i3;
            return;
        }
        H0(2, i7 + i3, this.P0, this.R0, this.U0);
        this.P0 = iY;
        this.R0 = k0Var.v(0, iY, i6, bArr);
    }

    public final void x() {
        int i;
        ja0.G.printf("%4d", Integer.valueOf(this.P0)).print("> \"");
        int i2 = this.P0;
        int i3 = 0;
        while (true) {
            i = this.Z;
            if (i3 >= 7 || i2 >= i || this.P0 < 0) {
                break;
            }
            k0 k0Var = this.X;
            byte[] bArr = this.Y;
            int iR = k0Var.r(i2, i, bArr);
            while (true) {
                int i4 = iR - 1;
                if (iR > 0) {
                    if (i2 < i) {
                        ja0.G.print(new String(bArr, i2, 1));
                        iR = i4;
                        i2++;
                    } else {
                        iR = i4;
                    }
                }
            }
            i3++;
        }
        String str = i2 < i ? "...\"" : "\"";
        int length = str.length() + i2;
        ja0.G.print(str);
        for (int i5 = 0; i5 < 20 - (length - this.P0); i5++) {
            ja0.G.print(" ");
        }
        StringBuilder sb = new StringBuilder();
        new lw2(this.A).c(this.W0, sb);
        ja0.G.println(sb.toString());
    }

    public final void x0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = this.P0;
        if (i4 >= this.Q0 || iArr[i2] != this.Y[i4]) {
            this.W0 = i3 + 1 + i2;
            return;
        }
        int i5 = i + 2;
        this.W0 = i5;
        H0(1, i5 + i3, i4, this.R0, this.U0);
    }

    public final boolean y() {
        int i = this.A.q;
        if ((i & 48) == 0) {
            return true;
        }
        if ((i & 32) != 0 && this.P0 == this.S0) {
            this.O0 = -1;
            k0();
            return false;
        }
        if ((i & 16) == 0 || this.P0 >= this.Q0) {
            return true;
        }
        k0();
        return false;
    }

    public final void y0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = i + 2;
        this.W0 = i4;
        int i5 = iArr[i2];
        this.J0[i3] = this.I0;
        l14 l14VarZ = z();
        l14VarZ.a = 1792;
        l14VarZ.d = i3;
        l14VarZ.c = i4;
        l14VarZ.b = 0;
        this.I0++;
        if (this.A.m[i3] == 0) {
            H0(1, this.W0 + i5, this.P0, this.R0, this.U0);
        }
    }

    public final l14 z() {
        int i = this.I0;
        l14[] l14VarArr = this.H0;
        if (i >= l14VarArr.length) {
            l14[] l14VarArr2 = new l14[l14VarArr.length << 1];
            System.arraycopy(l14VarArr, 0, l14VarArr2, 0, l14VarArr.length);
            this.H0 = l14VarArr2;
            l14VarArr = l14VarArr2;
        }
        int i2 = this.I0;
        l14 bo3Var = l14VarArr[i2];
        if (bo3Var == null) {
            bo3Var = ja0.s ? new bo3() : new l14();
            l14VarArr[i2] = bo3Var;
        }
        return bo3Var;
    }

    public final void z0() {
        int i = this.W0;
        int i2 = i + 1;
        this.W0 = i2;
        int[] iArr = this.V0;
        int i3 = iArr[i];
        int i4 = i + 2;
        this.W0 = i4;
        int i5 = iArr[i2];
        this.J0[i3] = this.I0;
        l14 l14VarZ = z();
        l14VarZ.a = 1792;
        l14VarZ.d = i3;
        l14VarZ.c = i4;
        l14VarZ.b = 0;
        this.I0++;
        if (this.A.m[i3] == 0) {
            H0(1, this.W0, this.P0, this.R0, this.U0);
            this.W0 += i5;
        }
    }
}
