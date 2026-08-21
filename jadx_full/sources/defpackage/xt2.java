package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xt2 extends rt2 implements Serializable {
    public static final jl Z;
    public final hm0 A;
    public final tm X;
    public nt0 Y;
    public final ch2 b;
    public final ma0 f;
    public bt3 z;

    static {
        r22 r22Var = new r22();
        r22Var.b = new o82(48, 48);
        r22Var.f = true;
        Z = new jl(null, r22Var, rj4.z, e34.C0, Locale.getDefault(), zj.a, new qv());
    }

    public xt2() {
        new ConcurrentHashMap(64, 0.6f, 2);
        this.b = new ch2(this);
        m34 m34Var = new m34(false, 21);
        o82 o82Var = new o82();
        o82Var.b = new o82(20, 200);
        nj4[] nj4VarArr = rj4.f;
        dx3 dx3Var = new dx3();
        wl wlVar = new wl();
        jl jlVar = Z;
        jl jlVar2 = jlVar.f == wlVar ? jlVar : new jl(wlVar, jlVar.z, jlVar.b, jlVar.X, jlVar.Y, jlVar.Z, jlVar.A);
        t52 t52Var = t52.X;
        ma0 ma0Var = new ma0();
        ma0Var.f = t52Var;
        this.f = ma0Var;
        int[] iArr = new int[hn2.b];
        s60 s60Var = new s60();
        tj0 tj0Var = sj0.a;
        this.z = new bt3(jlVar2, m34Var, dx3Var, o82Var, ma0Var, tj0Var);
        this.Y = new nt0(jlVar2, m34Var, dx3Var, o82Var, ma0Var, s60Var, tj0Var);
        bt3 bt3Var = this.z;
        ah2 ah2Var = ah2.SORT_PROPERTIES_ALPHABETICALLY;
        if (bt3Var.f(ah2Var)) {
            b(ah2Var);
        }
        this.A = new hm0();
        new o82(Math.min(64, 500), 2000);
        new HashMap(8);
        new ReentrantLock();
        this.X = tm.z0;
    }

    public final void a(dy4 dy4Var, Object obj) throws Throwable {
        bt3 bt3Var = this.z;
        boolean zH = bt3Var.h(dt3.CLOSE_CLOSEABLE);
        tm tmVar = this.X;
        hm0 hm0Var = this.A;
        if (!zH || !(obj instanceof Closeable)) {
            try {
                hm0Var.getClass();
                new hm0(hm0Var, bt3Var, tmVar).F(dy4Var, obj);
                dy4Var.close();
                return;
            } catch (Exception e) {
                Annotation[] annotationArr = n50.a;
                dy4Var.N0(h52.AUTO_CLOSE_JSON_CONTENT);
                try {
                    dy4Var.close();
                } catch (Exception e2) {
                    e.addSuppressed(e2);
                }
                if (e instanceof IOException) {
                    throw ((IOException) e);
                }
                n50.v(e);
                vp1.p(e);
                return;
            }
        }
        Closeable closeable = (Closeable) obj;
        try {
            hm0Var.getClass();
            new hm0(hm0Var, bt3Var, tmVar).F(dy4Var, obj);
        } catch (Exception e3) {
            e = e3;
        }
        try {
            closeable.close();
            dy4Var.close();
        } catch (Exception e4) {
            e = e4;
            closeable = null;
            Annotation[] annotationArr2 = n50.a;
            dy4Var.N0(h52.AUTO_CLOSE_JSON_CONTENT);
            try {
                dy4Var.close();
            } catch (Exception e5) {
                e.addSuppressed(e5);
            }
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e6) {
                    e.addSuppressed(e6);
                }
            }
            if (e instanceof IOException) {
                throw ((IOException) e);
            }
            n50.v(e);
            vp1.p(e);
        }
    }

    public final void b(ah2 ah2Var) {
        bt3 bt3Var = this.z;
        long j = bt3Var.b;
        long j2 = (~new ah2[]{ah2Var}[0].f) & j;
        if (j2 != j) {
            bt3Var = new bt3(bt3Var, j2, bt3Var.C0);
        }
        this.z = bt3Var;
        nt0 nt0Var = this.Y;
        long j3 = nt0Var.b;
        long j4 = (~new ah2[]{ah2Var}[0].f) & j3;
        if (j4 != j3) {
            nt0Var = new nt0(nt0Var, j4, nt0Var.B0);
        }
        this.Y = nt0Var;
    }

    public final dy4 c(me2 me2Var) {
        ch2 ch2Var = this.b;
        xd0 xd0Var = new xd0(me2Var, ch2Var.X);
        mp mpVarA = (mp) ((lb4) me2Var.f).g;
        boolean z = mpVarA != null;
        if (mpVarA == null) {
            mpVarA = (!ha0.c(4, ch2Var.b) ? s62.f : ch2Var.z).a();
        }
        vv1 vv1Var = new vv1(ch2Var.Y, mpVarA, xd0Var);
        if (z) {
            vv1Var.z = false;
        }
        dy4 dy4Var = new dy4(vv1Var, ch2Var.f, me2Var, ch2Var.y0);
        ft3 ft3Var = ch2Var.Z;
        if (ft3Var != ch2.B0) {
            dy4Var.B0 = ft3Var;
        }
        bt3 bt3Var = this.z;
        bt3Var.getClass();
        dt3 dt3Var = dt3.INDENT_OUTPUT;
        int i = bt3Var.C0;
        if ((dt3Var.f & i) != 0 && dy4Var.b == null) {
            g43 g43Var = bt3Var.B0;
            if (g43Var instanceof dm0) {
                dm0 dm0Var = (dm0) g43Var;
                dm0 dm0Var2 = new dm0();
                dm0Var2.b = cm0.b;
                dm0Var2.f = ol0.A;
                dm0Var2.z = dm0Var.z;
                dm0Var2.b = dm0Var.b;
                dm0Var2.f = dm0Var.f;
                dm0Var2.A = dm0Var.A;
                dm0Var2.X = dm0Var.X;
                dm0Var2.Y = dm0Var.Y;
                dm0Var2.Z = dm0Var.Z;
                dm0Var2.y0 = dm0Var.y0;
                dm0Var2.z0 = dm0Var.z0;
                g43Var = dm0Var2;
            }
            if (g43Var != null) {
                dy4Var.b = g43Var;
            }
        }
        boolean z2 = (dt3.WRITE_BIGDECIMAL_AS_PLAIN.f & i) != 0;
        if (z2) {
            int i2 = z2 ? h52.WRITE_BIGDECIMAL_AS_PLAIN.f : 0;
            int i3 = i2;
            int i4 = dy4Var.f;
            int i5 = (i2 & i3) | ((~i3) & i4);
            int i6 = i4 ^ i5;
            if (i6 != 0) {
                dy4Var.f = i5;
                if ((eo1.Z & i6) != 0) {
                    dy4Var.A = h52.WRITE_NUMBERS_AS_STRINGS.a(i5);
                    h52 h52Var = h52.ESCAPE_NON_ASCII;
                    if (h52Var.a(i6)) {
                        if (h52Var.a(i5)) {
                            dy4Var.A0 = 127;
                        } else {
                            dy4Var.A0 = 0;
                        }
                    }
                    h52 h52Var2 = h52.STRICT_DUPLICATE_DETECTION;
                    if (h52Var2.a(i6)) {
                        boolean zA = h52Var2.a(i5);
                        lb4 lb4Var = dy4Var.X;
                        if (!zA) {
                            lb4Var.h = null;
                            dy4Var.X = lb4Var;
                        } else if (((iv1) lb4Var.h) == null) {
                            lb4Var.h = new iv1(dy4Var);
                            dy4Var.X = lb4Var;
                        }
                    }
                }
                dy4Var.C0 = !h52.QUOTE_FIELD_NAMES.a(i5);
                dy4Var.D0 = h52.WRITE_HEX_UPPER_CASE.a(i5);
            }
        }
        return dy4Var;
    }

    public final String d(Object obj) throws l62 {
        ch2 ch2Var = this.b;
        try {
            me2 me2Var = new me2((!ha0.c(4, ch2Var.b) ? s62.f : ch2Var.z).a());
            try {
                a(c(me2Var), obj);
                return me2Var.x();
            } finally {
            }
        } catch (l62 e) {
            throw e;
        } catch (IOException e2) {
            throw new a62(null, "Unexpected IOException (of type " + e2.getClass().getName() + "): " + n50.g(e2));
        }
    }
}
