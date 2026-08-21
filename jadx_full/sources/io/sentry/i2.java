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
    */
    public final int nextInt() {
        String strI;
        int i;
        double d;
        io.sentry.vendor.gson.stream.a aVar = this.b;
        int iN = aVar.y0;
        if (iN == 0) {
            iN = aVar.n();
        }
        if (iN == 15) {
            long j = aVar.z0;
            i = (int) j;
            if (j != i) {
                throw new NumberFormatException("Expected an int but was " + aVar.z0 + aVar.C());
            }
            aVar.y0 = 0;
            int[] iArr = aVar.F0;
            int i2 = aVar.D0 - 1;
            iArr[i2] = iArr[i2] + 1;
        } else {
            if (iN == 16) {
                aVar.B0 = new String(aVar.z, aVar.A, aVar.A0);
                aVar.A += aVar.A0;
            } else {
                if (iN != 8 && iN != 9 && iN != 10) {
                    StringBuilder sb = new StringBuilder("Expected an int but was ");
                    sb.append(aVar.peek());
                    st4.m(sb, aVar.C());
                    return 0;
                }
                if (iN == 10) {
                    strI = aVar.M();
                    aVar.B0 = strI;
                } else {
                    strI = aVar.I(iN == 8 ? '\'' : StringUtil.DOUBLE_QUOTE);
                    aVar.B0 = strI;
                }
                try {
                    i = Integer.parseInt(strI);
                    aVar.y0 = 0;
                    int[] iArr2 = aVar.F0;
                    int i3 = aVar.D0 - 1;
                    iArr2[i3] = iArr2[i3] + 1;
                } catch (NumberFormatException unused) {
                    aVar.y0 = 11;
                    d = Double.parseDouble(aVar.B0);
                    i = (int) d;
                    if (i == d) {
                    }
                }
            }
            aVar.y0 = 11;
            d = Double.parseDouble(aVar.B0);
            i = (int) d;
            if (i == d) {
                st4.k("Expected an int but was ", aVar.B0, aVar.C());
                return 0;
            }
            aVar.B0 = null;
            aVar.y0 = 0;
            int[] iArr3 = aVar.F0;
            int i4 = aVar.D0 - 1;
            iArr3[i4] = iArr3[i4] + 1;
        }
        n();
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    @Override // io.sentry.m3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long nextLong() {
        String strI;
        long j;
        double d;
        long j2;
        io.sentry.vendor.gson.stream.a aVar = this.b;
        int iN = aVar.y0;
        if (iN == 0) {
            iN = aVar.n();
        }
        if (iN == 15) {
            aVar.y0 = 0;
            int[] iArr = aVar.F0;
            int i = aVar.D0 - 1;
            iArr[i] = iArr[i] + 1;
            j = aVar.z0;
        } else {
            if (iN == 16) {
                aVar.B0 = new String(aVar.z, aVar.A, aVar.A0);
                aVar.A += aVar.A0;
            } else {
                if (iN != 8 && iN != 9 && iN != 10) {
                    StringBuilder sb = new StringBuilder("Expected a long but was ");
                    sb.append(aVar.peek());
                    st4.m(sb, aVar.C());
                    return 0L;
                }
                if (iN == 10) {
                    strI = aVar.M();
                    aVar.B0 = strI;
                } else {
                    strI = aVar.I(iN == 8 ? '\'' : StringUtil.DOUBLE_QUOTE);
                    aVar.B0 = strI;
                }
                try {
                    long j3 = Long.parseLong(strI);
                    aVar.y0 = 0;
                    int[] iArr2 = aVar.F0;
                    int i2 = aVar.D0 - 1;
                    iArr2[i2] = iArr2[i2] + 1;
                    j = j3;
                } catch (NumberFormatException unused) {
                    aVar.y0 = 11;
                    d = Double.parseDouble(aVar.B0);
                    j2 = (long) d;
                    if (j2 == d) {
                    }
                }
            }
            aVar.y0 = 11;
            d = Double.parseDouble(aVar.B0);
            j2 = (long) d;
            if (j2 == d) {
                st4.k("Expected a long but was ", aVar.B0, aVar.C());
                return 0L;
            }
            aVar.B0 = null;
            aVar.y0 = 0;
            int[] iArr3 = aVar.F0;
            int i3 = aVar.D0 - 1;
            iArr3[i3] = iArr3[i3] + 1;
            j = j2;
        }
        n();
        return j;
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
    */
    public final void t() {
        io.sentry.vendor.gson.stream.a aVar;
        int i = 0;
        do {
            aVar = this.b;
            int iN = aVar.y0;
            if (iN == 0) {
                iN = aVar.n();
            }
            if (iN == 3) {
                aVar.N(1);
            } else if (iN == 1) {
                aVar.N(3);
            } else if (iN == 4 || iN == 2) {
                aVar.D0--;
                i--;
                aVar.y0 = 0;
            } else {
                if (iN == 14 || iN == 10) {
                    do {
                        int i2 = 0;
                        while (true) {
                            int i3 = aVar.A + i2;
                            if (i3 < aVar.X) {
                                char c = aVar.z[i3];
                                if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                                    if (c != '#') {
                                        if (c != ',') {
                                            if (c != '/' && c != '=') {
                                                if (c != '{' && c != '}' && c != ':') {
                                                    if (c != ';') {
                                                        switch (c) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i2++;
                                                                break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                aVar.A = i3;
                            }
                        }
                        aVar.A += i2;
                    } while (aVar.s(1));
                } else if (iN == 8 || iN == 12) {
                    aVar.U('\'');
                } else if (iN == 9 || iN == 13) {
                    aVar.U(StringUtil.DOUBLE_QUOTE);
                } else if (iN == 16) {
                    aVar.A += aVar.A0;
                }
                aVar.y0 = 0;
            }
            i++;
            aVar.y0 = 0;
        } while (i != 0);
        int[] iArr = aVar.F0;
        int i4 = aVar.D0 - 1;
        iArr[i4] = iArr[i4] + 1;
        aVar.E0[i4] = "null";
        n();
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
