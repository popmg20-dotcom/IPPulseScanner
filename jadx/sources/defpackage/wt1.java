package defpackage;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class wt1 implements r61 {
    public static final lr1 f;
    public final lu2 a;
    public final q61 b;
    public final ed4 c;
    public int d;
    public final i40 e;

    static {
        lr1 lr1Var = lr1.f;
        String[] strArr = (String[]) Arrays.copyOf(new String[]{"OkHttp-Response-Body", "Truncated"}, 2);
        if (strArr.length % 2 != 0) {
            xe.k("Expected alternating header names and values");
            return;
        }
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        int length = strArr2.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (strArr2[i2] == null) {
                xe.k("Headers cannot be null");
                return;
            }
            strArr2[i2] = p44.U0(strArr[i2]).toString();
        }
        int iZ = ye.z(0, strArr2.length - 1, 2);
        if (iZ >= 0) {
            while (true) {
                String str = strArr2[i];
                String str2 = strArr2[i + 1];
                gb4.O(str);
                gb4.P(str2, str);
                if (i == iZ) {
                    break;
                } else {
                    i += 2;
                }
            }
        }
        f = new lr1(strArr2);
    }

    public wt1(lu2 lu2Var, q61 q61Var, ed4 ed4Var) {
        ed4Var.getClass();
        this.a = lu2Var;
        this.b = q61Var;
        this.c = ed4Var;
        this.e = new i40((he3) ed4Var.z);
    }

    @Override // defpackage.r61
    public final void a() {
        ((ge3) this.c.A).flush();
    }

    @Override // defpackage.r61
    public final boolean b() {
        return this.d == 6;
    }

    @Override // defpackage.r61
    public final long c(kk3 kk3Var) {
        if (!ru1.a(kk3Var)) {
            return 0L;
        }
        if (HttpHeaders.Values.CHUNKED.equalsIgnoreCase(kk3.g(kk3Var, HttpHeaders.Names.TRANSFER_ENCODING))) {
            return -1L;
        }
        return jz4.e(kk3Var);
    }

    @Override // defpackage.r61
    public final void cancel() {
        this.b.cancel();
    }

    @Override // defpackage.r61
    public final jk3 d(boolean z) {
        i40 i40Var = this.e;
        int i = this.d;
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            s53.r(this.d, "state: ");
            return null;
        }
        try {
            String strU = ((he3) i40Var.z).U(i40Var.f);
            i40Var.f -= (long) strU.length();
            qt qtVarG = vo.G(strU);
            int i2 = qtVarG.b;
            jk3 jk3Var = new jk3();
            jk3Var.b = (ba3) qtVarG.c;
            jk3Var.c = i2;
            jk3Var.d = (String) qtVarG.d;
            jk3Var.f = gb4.A(i40Var.g());
            if (z && i2 == 100) {
                return null;
            }
            if (i2 == 100) {
                this.d = 3;
                return jk3Var;
            }
            if (102 > i2 || i2 >= 200) {
                this.d = 4;
                return jk3Var;
            }
            this.d = 3;
            return jk3Var;
        } catch (EOFException e) {
            throw new IOException("unexpected end of stream on ".concat(this.b.g().a.i.h()), e);
        }
    }

    @Override // defpackage.r61
    public final lz3 e(kk3 kk3Var) {
        cm2 cm2Var = kk3Var.b;
        if (!ru1.a(kk3Var)) {
            return k((ev1) cm2Var.f, 0L);
        }
        if (HttpHeaders.Values.CHUNKED.equalsIgnoreCase(kk3.g(kk3Var, HttpHeaders.Names.TRANSFER_ENCODING))) {
            ev1 ev1Var = (ev1) cm2Var.f;
            if (this.d == 4) {
                this.d = 5;
                return new st1(this, ev1Var);
            }
            s53.r(this.d, "state: ");
            return null;
        }
        long jE = jz4.e(kk3Var);
        if (jE != -1) {
            return k((ev1) cm2Var.f, jE);
        }
        ev1 ev1Var2 = (ev1) cm2Var.f;
        if (this.d != 4) {
            s53.r(this.d, "state: ");
            return null;
        }
        this.d = 5;
        this.b.d();
        ev1Var2.getClass();
        return new vt1(this, ev1Var2);
    }

    @Override // defpackage.r61
    public final vx3 f(cm2 cm2Var, long j) {
        cm2Var.getClass();
        if (HttpHeaders.Values.CHUNKED.equalsIgnoreCase(((lr1) cm2Var.A).a(HttpHeaders.Names.TRANSFER_ENCODING))) {
            if (this.d == 1) {
                this.d = 2;
                return new rt1(this);
            }
            s53.r(this.d, "state: ");
            return null;
        }
        if (j == -1) {
            xe.q("Cannot stream a request body without chunked encoding or a known content length!");
            return null;
        }
        if (this.d == 1) {
            this.d = 2;
            return new ut1(this);
        }
        s53.r(this.d, "state: ");
        return null;
    }

    @Override // defpackage.r61
    public final void g(cm2 cm2Var) {
        cm2Var.getClass();
        Proxy.Type type = this.b.g().b.type();
        type.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append((String) cm2Var.z);
        sb.append(' ');
        ev1 ev1Var = (ev1) cm2Var.f;
        if (ev1Var.f() || type != Proxy.Type.HTTP) {
            String strB = ev1Var.b();
            String strD = ev1Var.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb.append(strB);
        } else {
            sb.append(ev1Var);
        }
        sb.append(" HTTP/1.1");
        l((lr1) cm2Var.A, sb.toString());
    }

    @Override // defpackage.r61
    public final void h() {
        ((ge3) this.c.A).flush();
    }

    @Override // defpackage.r61
    public final wy3 i() {
        return this.c;
    }

    @Override // defpackage.r61
    public final q61 j() {
        return this.b;
    }

    public final tt1 k(ev1 ev1Var, long j) {
        if (this.d == 4) {
            this.d = 5;
            return new tt1(this, ev1Var, j);
        }
        s53.r(this.d, "state: ");
        return null;
    }

    public final void l(lr1 lr1Var, String str) {
        if (this.d != 0) {
            s53.r(this.d, "state: ");
            return;
        }
        ed4 ed4Var = this.c;
        ge3 ge3Var = (ge3) ed4Var.A;
        ge3Var.S(str);
        ge3Var.S("\r\n");
        int size = lr1Var.size();
        int i = 0;
        while (true) {
            ge3 ge3Var2 = (ge3) ed4Var.A;
            if (i >= size) {
                ge3Var2.S("\r\n");
                this.d = 1;
                return;
            } else {
                ge3Var2.S(gb4.z(lr1Var, i));
                ge3Var2.S(": ");
                ge3Var2.S(gb4.B(lr1Var, i));
                ge3Var2.S("\r\n");
                i++;
            }
        }
    }
}
