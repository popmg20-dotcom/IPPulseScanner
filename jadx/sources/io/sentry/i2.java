package io.sentry;

import com.tencent.mars.xlog.Xlog;
import defpackage.st4;
import io.netty.util.internal.StringUtil;
import j$.util.DesugarTimeZone;
import java.io.Reader;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i2 implements m3 {
    public final io.sentry.vendor.gson.stream.a b;
    public final ArrayDeque f = new ArrayDeque();
    public int z = 0;

    public i2(Reader reader) {
        this.b = new io.sentry.vendor.gson.stream.a(reader);
    }

    @Override // io.sentry.m3
    public final void B0() {
        io.sentry.vendor.gson.stream.a aVar = this.b;
        int iN = aVar.y0;
        if (iN == 0) {
            iN = aVar.n();
        }
        if (iN != 3) {
            StringBuilder sb = new StringBuilder("Expected BEGIN_ARRAY but was ");
            sb.append(aVar.peek());
            st4.m(sb, aVar.C());
        } else {
            aVar.N(1);
            aVar.F0[aVar.D0 - 1] = 0;
            aVar.y0 = 0;
            n();
            this.z++;
        }
    }

    public final void C(h2 h2Var) {
        io.sentry.vendor.gson.stream.a aVar;
        while (true) {
            int i = this.z;
            int i2 = h2Var.a;
            aVar = this.b;
            if (i <= i2) {
                break;
            }
            io.sentry.vendor.gson.stream.b bVarPeek = aVar.peek();
            if (bVarPeek == io.sentry.vendor.gson.stream.b.END_OBJECT) {
                V();
            } else if (bVarPeek == io.sentry.vendor.gson.stream.b.END_ARRAY) {
                w0();
            } else {
                t();
            }
        }
        if (h2Var.c || aVar.peek() != h2Var.b) {
            return;
        }
        t();
    }

    @Override // io.sentry.m3
    public final TimeZone E(ILogger iLogger) {
        if (this.b.peek() == io.sentry.vendor.gson.stream.b.NULL) {
            x();
            return null;
        }
        try {
            return DesugarTimeZone.getTimeZone(q());
        } catch (Exception e) {
            iLogger.d(p5.ERROR, "Error when deserializing TimeZone", e);
            return null;
        }
    }

    @Override // io.sentry.m3
    public final String G() {
        if (this.b.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return q();
        }
        x();
        return null;
    }

    @Override // io.sentry.m3
    public final void H(boolean z) {
        this.b.f = z;
    }

    @Override // io.sentry.m3
    public final HashMap J(ILogger iLogger, x1 x1Var) {
        boolean z;
        io.sentry.vendor.gson.stream.a aVar = this.b;
        if (aVar.peek() == io.sentry.vendor.gson.stream.b.NULL) {
            x();
            return null;
        }
        p0();
        HashMap map = new HashMap();
        if (aVar.hasNext()) {
            while (true) {
                String strR = aVar.R();
                h2 h2Var = new h2(this.z, aVar.peek());
                this.f.addLast(h2Var);
                try {
                    try {
                        map.put(strR, x1Var.a(this, iLogger));
                    } catch (Exception e) {
                        iLogger.d(p5.WARNING, "Failed to deserialize object in map.", e);
                        try {
                            C(h2Var);
                            z = true;
                        } catch (Exception e2) {
                            iLogger.d(p5.ERROR, "Stream unrecoverable, aborting map deserialization.", e2);
                            z = false;
                        }
                        if (!z) {
                            g(h2Var);
                            break;
                        }
                        V();
                        return map;
                    }
                    g(h2Var);
                    if (aVar.peek() != io.sentry.vendor.gson.stream.b.BEGIN_OBJECT && aVar.peek() != io.sentry.vendor.gson.stream.b.NAME) {
                        break;
                    }
                } catch (Throwable th) {
                    g(h2Var);
                    throw th;
                }
            }
        }
        V();
        return map;
    }

    @Override // io.sentry.m3
    public final Double O() {
        if (this.b.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Double.valueOf(nextDouble());
        }
        x();
        return null;
    }

    @Override // io.sentry.m3
    public final String R() {
        return this.b.R();
    }

    @Override // io.sentry.m3
    public final void V() {
        io.sentry.vendor.gson.stream.a aVar = this.b;
        int iN = aVar.y0;
        if (iN == 0) {
            iN = aVar.n();
        }
        if (iN != 2) {
            StringBuilder sb = new StringBuilder("Expected END_OBJECT but was ");
            sb.append(aVar.peek());
            st4.m(sb, aVar.C());
            return;
        }
        int i = aVar.D0;
        int i2 = i - 1;
        aVar.D0 = i2;
        aVar.E0[i2] = null;
        int[] iArr = aVar.F0;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        aVar.y0 = 0;
        this.z--;
    }

    @Override // io.sentry.m3
    public final Date Y(ILogger iLogger) {
        if (this.b.peek() == io.sentry.vendor.gson.stream.b.NULL) {
            x();
            return null;
        }
        String strQ = q();
        if (strQ == null) {
            return null;
        }
        try {
            try {
                return io.sentry.config.a.h(strQ);
            } catch (Exception e) {
                iLogger.d(p5.ERROR, "Error when deserializing millis timestamp format.", e);
                return null;
            }
        } catch (Exception unused) {
            return io.sentry.config.a.i(strQ);
        }
    }

    @Override // io.sentry.m3
    public final Boolean b0() {
        if (this.b.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Boolean.valueOf(s());
        }
        x();
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.close();
    }

    public final void g(h2 h2Var) {
        if (h2Var == null) {
            return;
        }
        ArrayDeque arrayDeque = this.f;
        if (arrayDeque.isEmpty() || arrayDeque.peekLast() != h2Var) {
            arrayDeque.remove(h2Var);
        } else {
            arrayDeque.removeLast();
        }
    }

    @Override // io.sentry.m3
    public final boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // io.sentry.m3
    public final Float l0() {
        if (this.b.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Float.valueOf(nextFloat());
        }
        x();
        return null;
    }

    @Override // io.sentry.m3
    public final Object m0(ILogger iLogger, x1 x1Var) {
        if (this.b.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return x1Var.a(this, iLogger);
        }
        x();
        return null;
    }

    public final void n() {
        h2 h2Var = (h2) this.f.peekLast();
        if (h2Var != null) {
            h2Var.c = true;
        }
    }

    @Override // io.sentry.m3
    public final double nextDouble() {
        double dNextDouble = this.b.nextDouble();
        n();
        return dNextDouble;
    }

    @Override // io.sentry.m3
    public final float nextFloat() {
        double dNextDouble = this.b.nextDouble();
        n();
        return (float) dNextDouble;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
    @Override // io.sentry.m3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int nextInt() {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.i2.nextInt():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    @Override // io.sentry.m3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long nextLong() {
        /*
            r11 = this;
            io.sentry.vendor.gson.stream.a r0 = r11.b
            int r1 = r0.y0
            if (r1 != 0) goto La
            int r1 = r0.n()
        La:
            r2 = 15
            r3 = 0
            if (r1 != r2) goto L21
            r0.y0 = r3
            int[] r1 = r0.F0
            int r2 = r0.D0
            int r2 = r2 + (-1)
            r3 = r1[r2]
            int r3 = r3 + 1
            r1[r2] = r3
            long r0 = r0.z0
            goto Lab
        L21:
            r2 = 16
            r4 = 0
            java.lang.String r6 = "Expected a long but was "
            if (r1 != r2) goto L3e
            java.lang.String r1 = new java.lang.String
            char[] r2 = r0.z
            int r7 = r0.A
            int r8 = r0.A0
            r1.<init>(r2, r7, r8)
            r0.B0 = r1
            int r1 = r0.A
            int r2 = r0.A0
            int r1 = r1 + r2
            r0.A = r1
            goto L89
        L3e:
            r2 = 10
            r7 = 8
            if (r1 == r7) goto L5f
            r8 = 9
            if (r1 == r8) goto L5f
            if (r1 != r2) goto L4b
            goto L5f
        L4b:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r6)
            io.sentry.vendor.gson.stream.b r1 = r0.peek()
            r11.append(r1)
            java.lang.String r0 = r0.C()
            defpackage.st4.m(r11, r0)
            return r4
        L5f:
            if (r1 != r2) goto L68
            java.lang.String r1 = r0.M()
            r0.B0 = r1
            goto L75
        L68:
            if (r1 != r7) goto L6d
            r1 = 39
            goto L6f
        L6d:
            r1 = 34
        L6f:
            java.lang.String r1 = r0.I(r1)
            r0.B0 = r1
        L75:
            long r1 = java.lang.Long.parseLong(r1)     // Catch: java.lang.NumberFormatException -> L89
            r0.y0 = r3     // Catch: java.lang.NumberFormatException -> L89
            int[] r7 = r0.F0     // Catch: java.lang.NumberFormatException -> L89
            int r8 = r0.D0     // Catch: java.lang.NumberFormatException -> L89
            int r8 = r8 + (-1)
            r9 = r7[r8]     // Catch: java.lang.NumberFormatException -> L89
            int r9 = r9 + 1
            r7[r8] = r9     // Catch: java.lang.NumberFormatException -> L89
            r0 = r1
            goto Lab
        L89:
            r1 = 11
            r0.y0 = r1
            java.lang.String r1 = r0.B0
            double r1 = java.lang.Double.parseDouble(r1)
            long r7 = (long) r1
            double r9 = (double) r7
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 != 0) goto Laf
            r1 = 0
            r0.B0 = r1
            r0.y0 = r3
            int[] r1 = r0.F0
            int r0 = r0.D0
            int r0 = r0 + (-1)
            r2 = r1[r0]
            int r2 = r2 + 1
            r1[r0] = r2
            r0 = r7
        Lab:
            r11.n()
            return r0
        Laf:
            java.lang.String r11 = r0.B0
            java.lang.String r0 = r0.C()
            defpackage.st4.k(r6, r11, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.i2.nextLong():long");
    }

    @Override // io.sentry.m3
    public final Object o0() {
        g2 g2Var = new g2();
        boolean zB = false;
        while (!zB) {
            int[] iArr = z1.a;
            io.sentry.vendor.gson.stream.a aVar = this.b;
            int i = iArr[aVar.peek().ordinal()];
            ArrayList arrayList = g2Var.a;
            switch (i) {
                case 1:
                    B0();
                    arrayList.add(new c2());
                    break;
                case 2:
                    w0();
                    zB = g2Var.b();
                    break;
                case 3:
                    p0();
                    arrayList.add(new d2());
                    break;
                case 4:
                    V();
                    zB = g2Var.b();
                    break;
                case 5:
                    arrayList.add(new e2(aVar.R()));
                    break;
                case 6:
                    zB = g2Var.c(new y1(this, 0));
                    break;
                case 7:
                    zB = g2Var.c(new y1(g2Var, this));
                    break;
                case 8:
                    zB = g2Var.c(new y1(this, 2));
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    x();
                    zB = g2Var.c(new st4(8));
                    break;
                case 10:
                    zB = true;
                    break;
            }
        }
        b2 b2VarA = g2Var.a();
        if (b2VarA != null) {
            return b2VarA.getValue();
        }
        return null;
    }

    @Override // io.sentry.m3
    public final void p0() {
        io.sentry.vendor.gson.stream.a aVar = this.b;
        int iN = aVar.y0;
        if (iN == 0) {
            iN = aVar.n();
        }
        if (iN != 1) {
            StringBuilder sb = new StringBuilder("Expected BEGIN_OBJECT but was ");
            sb.append(aVar.peek());
            st4.m(sb, aVar.C());
        } else {
            aVar.N(3);
            aVar.y0 = 0;
            n();
            this.z++;
        }
    }

    @Override // io.sentry.m3
    public final io.sentry.vendor.gson.stream.b peek() {
        return this.b.peek();
    }

    @Override // io.sentry.m3
    public final String q() {
        String str;
        io.sentry.vendor.gson.stream.a aVar = this.b;
        int iN = aVar.y0;
        if (iN == 0) {
            iN = aVar.n();
        }
        if (iN == 10) {
            str = aVar.M();
        } else if (iN == 8) {
            str = aVar.I('\'');
        } else if (iN == 9) {
            str = aVar.I(StringUtil.DOUBLE_QUOTE);
        } else if (iN == 11) {
            str = aVar.B0;
            aVar.B0 = null;
        } else if (iN == 15) {
            str = Long.toString(aVar.z0);
        } else {
            if (iN != 16) {
                StringBuilder sb = new StringBuilder("Expected a string but was ");
                sb.append(aVar.peek());
                st4.m(sb, aVar.C());
                return null;
            }
            str = new String(aVar.z, aVar.A, aVar.A0);
            aVar.A += aVar.A0;
        }
        aVar.y0 = 0;
        int[] iArr = aVar.F0;
        int i = aVar.D0 - 1;
        iArr[i] = iArr[i] + 1;
        n();
        return str;
    }

    public final boolean s() {
        io.sentry.vendor.gson.stream.a aVar = this.b;
        int iN = aVar.y0;
        if (iN == 0) {
            iN = aVar.n();
        }
        boolean z = false;
        if (iN == 5) {
            aVar.y0 = 0;
            int[] iArr = aVar.F0;
            int i = aVar.D0 - 1;
            iArr[i] = iArr[i] + 1;
            z = true;
        } else {
            if (iN != 6) {
                StringBuilder sb = new StringBuilder("Expected a boolean but was ");
                sb.append(aVar.peek());
                st4.m(sb, aVar.C());
                return false;
            }
            aVar.y0 = 0;
            int[] iArr2 = aVar.F0;
            int i2 = aVar.D0 - 1;
            iArr2[i2] = iArr2[i2] + 1;
        }
        n();
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a3, code lost:
    
        r2.g();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:61:0x009d. Please report as an issue. */
    @Override // io.sentry.m3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t() {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.i2.t():void");
    }

    @Override // io.sentry.m3
    public final Integer u() {
        if (this.b.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Integer.valueOf(nextInt());
        }
        x();
        return null;
    }

    @Override // io.sentry.m3
    public final void w(ILogger iLogger, AbstractMap abstractMap, String str) throws Throwable {
        h2 h2Var;
        h2 h2Var2 = null;
        try {
            try {
                h2Var = new h2(this.z, this.b.peek());
                this.f.addLast(h2Var);
            } catch (Throwable th) {
                th = th;
                g(h2Var2);
                throw th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            abstractMap.put(str, o0());
            g(h2Var);
        } catch (Exception e2) {
            e = e2;
            h2Var2 = h2Var;
            iLogger.b(p5.ERROR, e, "Error deserializing unknown key: %s", str);
            if (h2Var2 != null) {
                try {
                    C(h2Var2);
                } catch (Exception e3) {
                    iLogger.d(p5.ERROR, "Stream unrecoverable after unknown key deserialization failure.", e3);
                }
            }
            g(h2Var2);
        } catch (Throwable th2) {
            th = th2;
            h2Var2 = h2Var;
            g(h2Var2);
            throw th;
        }
    }

    @Override // io.sentry.m3
    public final void w0() {
        io.sentry.vendor.gson.stream.a aVar = this.b;
        int iN = aVar.y0;
        if (iN == 0) {
            iN = aVar.n();
        }
        if (iN != 4) {
            StringBuilder sb = new StringBuilder("Expected END_ARRAY but was ");
            sb.append(aVar.peek());
            st4.m(sb, aVar.C());
            return;
        }
        int i = aVar.D0;
        aVar.D0 = i - 1;
        int[] iArr = aVar.F0;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        aVar.y0 = 0;
        this.z--;
    }

    public final void x() {
        io.sentry.vendor.gson.stream.a aVar = this.b;
        int iN = aVar.y0;
        if (iN == 0) {
            iN = aVar.n();
        }
        if (iN != 7) {
            StringBuilder sb = new StringBuilder("Expected null but was ");
            sb.append(aVar.peek());
            st4.m(sb, aVar.C());
        } else {
            aVar.y0 = 0;
            int[] iArr = aVar.F0;
            int i = aVar.D0 - 1;
            iArr[i] = iArr[i] + 1;
            n();
        }
    }

    @Override // io.sentry.m3
    public final Long y() {
        if (this.b.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Long.valueOf(nextLong());
        }
        x();
        return null;
    }

    @Override // io.sentry.m3
    public final ArrayList y0(ILogger iLogger, x1 x1Var) {
        boolean z;
        io.sentry.vendor.gson.stream.a aVar = this.b;
        if (aVar.peek() == io.sentry.vendor.gson.stream.b.NULL) {
            x();
            return null;
        }
        B0();
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (!aVar.hasNext()) {
                break;
            }
            h2 h2Var = new h2(this.z, aVar.peek());
            this.f.addLast(h2Var);
            try {
                try {
                    arrayList.add(x1Var.a(this, iLogger));
                } catch (Exception e) {
                    iLogger.d(p5.WARNING, "Failed to deserialize object in list.", e);
                    try {
                        C(h2Var);
                        z = true;
                    } catch (Exception e2) {
                        iLogger.d(p5.ERROR, "Stream unrecoverable, aborting list deserialization.", e2);
                        z = false;
                    }
                    if (!z) {
                        g(h2Var);
                        w0();
                        return arrayList;
                    }
                }
                g(h2Var);
            } catch (Throwable th) {
                g(h2Var);
                throw th;
            }
        }
        w0();
        return arrayList;
    }
}
