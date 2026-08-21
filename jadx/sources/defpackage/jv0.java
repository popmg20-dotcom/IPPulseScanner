package defpackage;

import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jv0 implements Closeable, Flushable {
    public static final uh3 H0 = new uh3("[a-z0-9_-]{1,120}");
    public final u03 A;
    public ge3 A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public boolean F0;
    public final iv0 G0;
    public final u03 X;
    public final LinkedHashMap Y;
    public final ce0 Z;
    public final u03 b;
    public final long f;
    public long y0;
    public final u03 z;
    public int z0;

    public jv0(long j, ef0 ef0Var, ge1 ge1Var, u03 u03Var) {
        this.b = u03Var;
        this.f = j;
        if (j <= 0) {
            xe.k("maxSize <= 0");
            throw null;
        }
        this.z = u03Var.d("journal");
        this.A = u03Var.d("journal.tmp");
        this.X = u03Var.d("journal.bkp");
        this.Y = new LinkedHashMap(0, 0.75f, true);
        this.Z = p95.a(tj4.W(gb4.d(), ef0Var.r0(1)));
        this.G0 = new iv0(ge1Var);
    }

    public static void X(String str) {
        if (H0.d(str)) {
            return;
        }
        ad0.f(str, 34, "keys must match regex [a-z0-9_-]{1,120}: \"");
    }

    public final void C() {
        ji0.B(this.Z, null, null, new gt(this, null, 2), 3);
    }

    public final ge3 F() {
        return new ge3(new ec1(this.G0.f.g(this.z), new f0(6, this)));
    }

    public final void I() {
        Iterator it = this.Y.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            gv0 gv0Var = (gv0) it.next();
            int i = 0;
            if (gv0Var.g == null) {
                while (i < 2) {
                    j += gv0Var.b[i];
                    i++;
                }
            } else {
                gv0Var.g = null;
                while (i < 2) {
                    u03 u03Var = (u03) gv0Var.c.get(i);
                    iv0 iv0Var = this.G0;
                    iv0Var.C(u03Var);
                    iv0Var.C((u03) gv0Var.d.get(i));
                    i++;
                }
                it.remove();
            }
        }
        this.y0 = j;
    }

    public final void M() throws Throwable {
        lz3 lz3VarX = this.G0.f.X(this.z);
        lz3VarX.getClass();
        he3 he3Var = new he3(lz3VarX);
        try {
            String strU = he3Var.U(Long.MAX_VALUE);
            String strU2 = he3Var.U(Long.MAX_VALUE);
            String strU3 = he3Var.U(Long.MAX_VALUE);
            String strU4 = he3Var.U(Long.MAX_VALUE);
            String strU5 = he3Var.U(Long.MAX_VALUE);
            if (!"libcore.io.DiskLruCache".equals(strU) || !"1".equals(strU2) || !n12.c(String.valueOf(1), strU3) || !n12.c(String.valueOf(2), strU4) || strU5.length() > 0) {
                throw new IOException("unexpected journal header: [" + strU + ", " + strU2 + ", " + strU3 + ", " + strU4 + ", " + strU5 + ']');
            }
            int i = 0;
            while (true) {
                try {
                    N(he3Var.U(Long.MAX_VALUE));
                    i++;
                } catch (EOFException unused) {
                    this.z0 = i - this.Y.size();
                    if (he3Var.g()) {
                        this.A0 = F();
                    } else {
                        Z();
                    }
                    try {
                        he3Var.close();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                he3Var.close();
            } catch (Throwable th3) {
                ek0.b(th, th3);
            }
        }
        if (th != null) {
            throw th;
        }
    }

    public final void N(String str) throws IOException {
        String strSubstring;
        int iU0 = p44.u0(str, ' ', 0, 6);
        if (iU0 == -1) {
            vp1.i("unexpected journal line: ".concat(str));
            return;
        }
        int i = iU0 + 1;
        int iU02 = p44.u0(str, ' ', i, 4);
        LinkedHashMap linkedHashMap = this.Y;
        if (iU02 == -1) {
            strSubstring = str.substring(i);
            if (iU0 == 6 && w44.j0(str, "REMOVE", false)) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iU02);
        }
        Object gv0Var = linkedHashMap.get(strSubstring);
        if (gv0Var == null) {
            gv0Var = new gv0(this, strSubstring);
            linkedHashMap.put(strSubstring, gv0Var);
        }
        gv0 gv0Var2 = (gv0) gv0Var;
        if (iU02 == -1 || iU0 != 5 || !w44.j0(str, "CLEAN", false)) {
            if (iU02 == -1 && iU0 == 5 && w44.j0(str, "DIRTY", false)) {
                gv0Var2.g = new ue1(this, gv0Var2);
                return;
            } else {
                if (iU02 == -1 && iU0 == 4 && w44.j0(str, "READ", false)) {
                    return;
                }
                vp1.i("unexpected journal line: ".concat(str));
                return;
            }
        }
        List listK0 = p44.K0(str.substring(iU02 + 1), new char[]{' '}, 6);
        gv0Var2.e = true;
        gv0Var2.g = null;
        if (listK0.size() != 2) {
            st4.i(listK0, "unexpected journal line: ");
            return;
        }
        try {
            int size = listK0.size();
            for (int i2 = 0; i2 < size; i2++) {
                gv0Var2.b[i2] = Long.parseLong((String) listK0.get(i2));
            }
        } catch (NumberFormatException unused) {
            st4.i(listK0, "unexpected journal line: ");
        }
    }

    public final void Q(gv0 gv0Var) {
        ge3 ge3Var;
        int i = gv0Var.h;
        String str = gv0Var.a;
        if (i > 0 && (ge3Var = this.A0) != null) {
            ge3Var.S("DIRTY");
            ge3Var.writeByte(32);
            ge3Var.S(str);
            ge3Var.writeByte(10);
            ge3Var.flush();
        }
        if (gv0Var.h > 0 || gv0Var.g != null) {
            gv0Var.f = true;
            return;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            this.G0.C((u03) gv0Var.c.get(i2));
            long j = this.y0;
            long[] jArr = gv0Var.b;
            this.y0 = j - jArr[i2];
            jArr[i2] = 0;
        }
        this.z0++;
        ge3 ge3Var2 = this.A0;
        if (ge3Var2 != null) {
            ge3Var2.S("REMOVE");
            ge3Var2.writeByte(32);
            ge3Var2.S(str);
            ge3Var2.writeByte(10);
        }
        this.Y.remove(str);
        if (this.z0 >= 2000) {
            C();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        Q(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U() {
        /*
            r4 = this;
        L0:
            long r0 = r4.y0
            long r2 = r4.f
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L27
            java.util.LinkedHashMap r0 = r4.Y
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L12:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L26
            java.lang.Object r1 = r0.next()
            gv0 r1 = (defpackage.gv0) r1
            boolean r2 = r1.f
            if (r2 != 0) goto L12
            r4.Q(r1)
            goto L0
        L26:
            return
        L27:
            r0 = 0
            r4.E0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jv0.U():void");
    }

    public final synchronized void Z() {
        Throwable th;
        try {
            ge3 ge3Var = this.A0;
            if (ge3Var != null) {
                ge3Var.close();
            }
            ge3 ge3VarD = co4.d(this.G0.U(this.A));
            try {
                ge3VarD.S("libcore.io.DiskLruCache");
                ge3VarD.writeByte(10);
                ge3VarD.S("1");
                ge3VarD.writeByte(10);
                ge3VarD.n(1L);
                ge3VarD.writeByte(10);
                ge3VarD.n(2L);
                ge3VarD.writeByte(10);
                ge3VarD.writeByte(10);
                for (gv0 gv0Var : this.Y.values()) {
                    if (gv0Var.g != null) {
                        ge3VarD.S("DIRTY");
                        ge3VarD.writeByte(32);
                        ge3VarD.S(gv0Var.a);
                        ge3VarD.writeByte(10);
                    } else {
                        ge3VarD.S("CLEAN");
                        ge3VarD.writeByte(32);
                        ge3VarD.S(gv0Var.a);
                        for (long j : gv0Var.b) {
                            ge3VarD.writeByte(32);
                            ge3VarD.n(j);
                        }
                        ge3VarD.writeByte(10);
                    }
                }
                try {
                    ge3VarD.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    ge3VarD.close();
                } catch (Throwable th4) {
                    ek0.b(th3, th4);
                }
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            boolean zF = this.G0.F(this.z);
            iv0 iv0Var = this.G0;
            if (zF) {
                iv0Var.f.n(this.z, this.X);
                this.G0.f.n(this.A, this.z);
                this.G0.x(this.X);
            } else {
                iv0Var.f.n(this.A, this.z);
            }
            this.A0 = F();
            this.z0 = 0;
            this.B0 = false;
            this.F0 = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.C0 && !this.D0) {
                for (gv0 gv0Var : (gv0[]) this.Y.values().toArray(new gv0[0])) {
                    ue1 ue1Var = gv0Var.g;
                    if (ue1Var != null) {
                        gv0 gv0Var2 = (gv0) ue1Var.b;
                        if (n12.c(gv0Var2.g, ue1Var)) {
                            gv0Var2.f = true;
                        }
                    }
                }
                U();
                p95.e(this.Z);
                ge3 ge3Var = this.A0;
                ge3Var.getClass();
                ge3Var.close();
                this.A0 = null;
                this.D0 = true;
                return;
            }
            this.D0 = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
        if (this.C0) {
            if (this.D0) {
                throw new IllegalStateException("cache is closed");
            }
            U();
            ge3 ge3Var = this.A0;
            ge3Var.getClass();
            ge3Var.flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x011e A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0011, B:11:0x0018, B:13:0x0020, B:15:0x0030, B:23:0x003e, B:26:0x0058, B:30:0x0076, B:32:0x0086, B:34:0x008d, B:27:0x0061, B:29:0x006f, B:38:0x00ad, B:40:0x00b4, B:43:0x00b9, B:45:0x00ca, B:48:0x00cf, B:53:0x010a, B:55:0x0115, B:59:0x011e, B:49:0x00e7, B:51:0x00fc, B:52:0x0107, B:37:0x009d, B:62:0x0123, B:63:0x012a), top: B:66:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void g(defpackage.ue1 r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jv0.g(ue1, boolean):void");
    }

    public final synchronized ue1 n(String str) {
        if (this.D0) {
            throw new IllegalStateException("cache is closed");
        }
        X(str);
        x();
        gv0 gv0Var = (gv0) this.Y.get(str);
        if ((gv0Var != null ? gv0Var.g : null) != null) {
            return null;
        }
        if (gv0Var != null && gv0Var.h != 0) {
            return null;
        }
        if (!this.E0 && !this.F0) {
            ge3 ge3Var = this.A0;
            ge3Var.getClass();
            ge3Var.S("DIRTY");
            ge3Var.writeByte(32);
            ge3Var.S(str);
            ge3Var.writeByte(10);
            ge3Var.flush();
            if (this.B0) {
                return null;
            }
            if (gv0Var == null) {
                gv0Var = new gv0(this, str);
                this.Y.put(str, gv0Var);
            }
            ue1 ue1Var = new ue1(this, gv0Var);
            gv0Var.g = ue1Var;
            return ue1Var;
        }
        C();
        return null;
    }

    public final synchronized hv0 s(String str) {
        hv0 hv0VarA;
        if (this.D0) {
            throw new IllegalStateException("cache is closed");
        }
        X(str);
        x();
        gv0 gv0Var = (gv0) this.Y.get(str);
        if (gv0Var != null && (hv0VarA = gv0Var.a()) != null) {
            boolean z = true;
            this.z0++;
            ge3 ge3Var = this.A0;
            ge3Var.getClass();
            ge3Var.S("READ");
            ge3Var.writeByte(32);
            ge3Var.S(str);
            ge3Var.writeByte(10);
            if (this.z0 < 2000) {
                z = false;
            }
            if (z) {
                C();
            }
            return hv0VarA;
        }
        return null;
    }

    public final synchronized void x() {
        try {
            if (this.C0) {
                return;
            }
            this.G0.x(this.A);
            if (this.G0.F(this.X)) {
                boolean zF = this.G0.F(this.z);
                iv0 iv0Var = this.G0;
                u03 u03Var = this.X;
                if (zF) {
                    iv0Var.x(u03Var);
                } else {
                    iv0Var.f.n(u03Var, this.z);
                }
            }
            if (this.G0.F(this.z)) {
                try {
                    M();
                    I();
                    this.C0 = true;
                    return;
                } catch (IOException unused) {
                    try {
                        close();
                        ji0.l(this.G0, this.b);
                        this.D0 = false;
                        Z();
                        this.C0 = true;
                    } catch (Throwable th) {
                        this.D0 = false;
                        throw th;
                    }
                }
            }
            Z();
            this.C0 = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
