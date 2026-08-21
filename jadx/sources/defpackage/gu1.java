package defpackage;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gu1 implements r61 {
    public static final List g = jz4.k(new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});
    public static final List h = jz4.k(new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});
    public final me3 a;
    public final ve3 b;
    public final fu1 c;
    public volatile mu1 d;
    public final ba3 e;
    public volatile boolean f;

    public gu1(lu2 lu2Var, me3 me3Var, ve3 ve3Var, fu1 fu1Var) {
        lu2Var.getClass();
        fu1Var.getClass();
        this.a = me3Var;
        this.b = ve3Var;
        this.c = fu1Var;
        List list = lu2Var.s;
        ba3 ba3Var = ba3.H2_PRIOR_KNOWLEDGE;
        this.e = list.contains(ba3Var) ? ba3Var : ba3.HTTP_2;
    }

    @Override // defpackage.r61
    public final void a() {
        mu1 mu1Var = this.d;
        mu1Var.getClass();
        mu1Var.z0.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    @Override // defpackage.r61
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b() {
        /*
            r4 = this;
            mu1 r4 = r4.d
            r0 = 0
            if (r4 == 0) goto L20
            monitor-enter(r4)
            ku1 r1 = r4.y0     // Catch: java.lang.Throwable -> L17
            boolean r2 = r1.f     // Catch: java.lang.Throwable -> L17
            r3 = 1
            if (r2 == 0) goto L19
            hp r1 = r1.A     // Catch: java.lang.Throwable -> L17
            boolean r1 = r1.x()     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L19
            r1 = r3
            goto L1a
        L17:
            r0 = move-exception
            goto L1e
        L19:
            r1 = r0
        L1a:
            monitor-exit(r4)
            if (r1 != r3) goto L20
            return r3
        L1e:
            monitor-exit(r4)
            throw r0
        L20:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gu1.b():boolean");
    }

    @Override // defpackage.r61
    public final long c(kk3 kk3Var) {
        if (ru1.a(kk3Var)) {
            return jz4.e(kk3Var);
        }
        return 0L;
    }

    @Override // defpackage.r61
    public final void cancel() {
        this.f = true;
        mu1 mu1Var = this.d;
        if (mu1Var != null) {
            mu1Var.f(t51.CANCEL);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    @Override // defpackage.r61
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.jk3 d(boolean r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gu1.d(boolean):jk3");
    }

    @Override // defpackage.r61
    public final lz3 e(kk3 kk3Var) {
        mu1 mu1Var = this.d;
        mu1Var.getClass();
        return mu1Var.y0;
    }

    @Override // defpackage.r61
    public final vx3 f(cm2 cm2Var, long j) {
        cm2Var.getClass();
        mu1 mu1Var = this.d;
        mu1Var.getClass();
        return mu1Var.z0;
    }

    @Override // defpackage.r61
    public final void g(cm2 cm2Var) throws IOException {
        int i;
        mu1 mu1Var;
        boolean z;
        cm2Var.getClass();
        if (this.d != null) {
            return;
        }
        boolean z2 = ((ej3) cm2Var.X) != null;
        lr1 lr1Var = (lr1) cm2Var.A;
        ArrayList arrayList = new ArrayList(lr1Var.size() + 4);
        arrayList.add(new hr1(hr1.f, (String) cm2Var.z));
        bu buVar = hr1.g;
        ev1 ev1Var = (ev1) cm2Var.f;
        ev1Var.getClass();
        String strB = ev1Var.b();
        String strD = ev1Var.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new hr1(buVar, strB));
        String strA = lr1Var.a("Host");
        if (strA != null) {
            arrayList.add(new hr1(hr1.i, strA));
        }
        arrayList.add(new hr1(hr1.h, ev1Var.a));
        int size = lr1Var.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strZ = gb4.z(lr1Var, i2);
            Locale locale = Locale.US;
            locale.getClass();
            String lowerCase = strZ.toLowerCase(locale);
            lowerCase.getClass();
            if (!g.contains(lowerCase) || (lowerCase.equals("te") && gb4.B(lr1Var, i2).equals(HttpHeaders.Values.TRAILERS))) {
                arrayList.add(new hr1(lowerCase, gb4.B(lr1Var, i2)));
            }
        }
        fu1 fu1Var = this.c;
        fu1Var.getClass();
        boolean z3 = !z2;
        synchronized (fu1Var.N0) {
            synchronized (fu1Var) {
                try {
                    if (fu1Var.X > 1073741823) {
                        fu1Var.C(t51.REFUSED_STREAM);
                    }
                    if (fu1Var.Y) {
                        throw new bb0();
                    }
                    i = fu1Var.X;
                    fu1Var.X = i + 2;
                    mu1Var = new mu1(i, fu1Var, z3, false, null);
                    z = !z2 || fu1Var.K0 >= fu1Var.L0 || mu1Var.A >= mu1Var.X;
                    if (mu1Var.i()) {
                        fu1Var.f.put(Integer.valueOf(i), mu1Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            fu1Var.N0.C(i, arrayList, z3);
        }
        if (z) {
            fu1Var.N0.flush();
        }
        this.d = mu1Var;
        boolean z4 = this.f;
        mu1 mu1Var2 = this.d;
        if (z4) {
            mu1Var2.getClass();
            mu1Var2.f(t51.CANCEL);
            vp1.i("Canceled");
        } else {
            mu1Var2.getClass();
            mu1Var2.A0.g(this.b.g);
            mu1 mu1Var3 = this.d;
            mu1Var3.getClass();
            mu1Var3.B0.g(this.b.h);
        }
    }

    @Override // defpackage.r61
    public final void h() {
        this.c.flush();
    }

    @Override // defpackage.r61
    public final wy3 i() {
        mu1 mu1Var = this.d;
        mu1Var.getClass();
        return mu1Var;
    }

    @Override // defpackage.r61
    public final q61 j() {
        return this.a;
    }
}
