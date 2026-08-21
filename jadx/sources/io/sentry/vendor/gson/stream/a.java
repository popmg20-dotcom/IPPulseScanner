package io.sentry.vendor.gson.stream;

import com.tencent.mars.xlog.Xlog;
import defpackage.a60;
import defpackage.fw;
import defpackage.st4;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {
    public int A0;
    public String B0;
    public int[] C0;
    public String[] E0;
    public int[] F0;
    public final Reader b;
    public long z0;
    public boolean f = false;
    public final char[] z = new char[1024];
    public int A = 0;
    public int X = 0;
    public int Y = 0;
    public int Z = 0;
    public int y0 = 0;
    public int D0 = 1;

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.C0 = iArr;
        iArr[0] = 6;
        this.E0 = new String[32];
        this.F0 = new int[32];
        this.b = reader;
    }

    public final String C() {
        StringBuilder sbA = fw.A(this.Y + 1, (this.A - this.Z) + 1, " at line ", " column ", " path ");
        StringBuilder sb = new StringBuilder("$");
        int i = this.D0;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.C0[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.F0[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.E0[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        sbA.append(sb.toString());
        return sbA.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int F(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.F(boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r10.A = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        r1.append(r7, r3, r2 - r3);
        r10.A = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String I(char r11) {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r10.A
            int r3 = r10.X
        L6:
            r4 = r3
            r3 = r2
        L8:
            r5 = 16
            r6 = 1
            char[] r7 = r10.z
            if (r2 >= r4) goto L5b
            int r8 = r2 + 1
            char r2 = r7[r2]
            if (r2 != r11) goto L29
            r10.A = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L21
            java.lang.String r10 = new java.lang.String
            r10.<init>(r7, r3, r8)
            return r10
        L21:
            r1.append(r7, r3, r8)
            java.lang.String r10 = r1.toString()
            return r10
        L29:
            r9 = 92
            if (r2 != r9) goto L4e
            r10.A = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L3f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r5)
            r1.<init>(r4)
        L3f:
            r1.append(r7, r3, r2)
            char r2 = r10.Q()
            r1.append(r2)
            int r2 = r10.A
            int r3 = r10.X
            goto L6
        L4e:
            r5 = 10
            if (r2 != r5) goto L59
            int r2 = r10.Y
            int r2 = r2 + r6
            r10.Y = r2
            r10.Z = r8
        L59:
            r2 = r8
            goto L8
        L5b:
            if (r1 != 0) goto L6b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6b:
            int r4 = r2 - r3
            r1.append(r7, r3, r4)
            r10.A = r2
            boolean r2 = r10.s(r6)
            if (r2 == 0) goto L79
            goto L2
        L79:
            java.lang.String r11 = "Unterminated string"
            r10.Z(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.I(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        g();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String M() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.A
            int r3 = r3 + r2
            int r4 = r6.X
            char[] r5 = r6.z
            if (r3 >= r4) goto L4c
            char r3 = r5[r3]
            r4 = 9
            if (r3 == r4) goto L58
            r4 = 10
            if (r3 == r4) goto L58
            r4 = 12
            if (r3 == r4) goto L58
            r4 = 13
            if (r3 == r4) goto L58
            r4 = 32
            if (r3 == r4) goto L58
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L58
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L58
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L58
            r4 = 58
            if (r3 == r4) goto L58
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L58;
                case 92: goto L48;
                case 93: goto L58;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r6.g()
            goto L58
        L4c:
            int r3 = r5.length
            if (r2 >= r3) goto L5a
            int r3 = r2 + 1
            boolean r3 = r6.s(r3)
            if (r3 == 0) goto L58
            goto L3
        L58:
            r1 = r2
            goto L78
        L5a:
            if (r0 != 0) goto L67
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L67:
            int r3 = r6.A
            r0.append(r5, r3, r2)
            int r3 = r6.A
            int r3 = r3 + r2
            r6.A = r3
            r2 = 1
            boolean r2 = r6.s(r2)
            if (r2 != 0) goto L2
        L78:
            int r2 = r6.A
            if (r0 != 0) goto L82
            java.lang.String r0 = new java.lang.String
            r0.<init>(r5, r2, r1)
            goto L89
        L82:
            r0.append(r5, r2, r1)
            java.lang.String r0 = r0.toString()
        L89:
            int r2 = r6.A
            int r2 = r2 + r1
            r6.A = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.M():java.lang.String");
    }

    public final void N(int i) {
        int i2 = this.D0;
        int[] iArr = this.C0;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.C0 = Arrays.copyOf(iArr, i3);
            this.F0 = Arrays.copyOf(this.F0, i3);
            this.E0 = (String[]) Arrays.copyOf(this.E0, i3);
        }
        int[] iArr2 = this.C0;
        int i4 = this.D0;
        this.D0 = i4 + 1;
        iArr2[i4] = i;
    }

    public final char Q() throws a60 {
        int i;
        if (this.A == this.X && !s(1)) {
            Z("Unterminated escape sequence");
            throw null;
        }
        int i2 = this.A;
        int i3 = i2 + 1;
        this.A = i3;
        char[] cArr = this.z;
        char c = cArr[i2];
        if (c == '\n') {
            this.Y++;
            this.Z = i3;
            return c;
        }
        if (c == '\"' || c == '\'' || c == '/' || c == '\\') {
            return c;
        }
        if (c == 'b') {
            return '\b';
        }
        if (c == 'f') {
            return '\f';
        }
        if (c == 'n') {
            return '\n';
        }
        if (c == 'r') {
            return StringUtil.CARRIAGE_RETURN;
        }
        if (c == 't') {
            return '\t';
        }
        if (c != 'u') {
            Z("Invalid escape sequence");
            throw null;
        }
        if (i2 + 5 > this.X && !s(4)) {
            Z("Unterminated escape sequence");
            throw null;
        }
        int i4 = this.A;
        int i5 = i4 + 4;
        char c2 = 0;
        while (i4 < i5) {
            char c3 = cArr[i4];
            char c4 = (char) (c2 << 4);
            if (c3 >= '0' && c3 <= '9') {
                i = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    throw new NumberFormatException("\\u".concat(new String(cArr, this.A, 4)));
                }
                i = c3 - '7';
            }
            c2 = (char) (i + c4);
            i4++;
        }
        this.A += 4;
        return c2;
    }

    public final String R() {
        String strI;
        int iN = this.y0;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 14) {
            strI = M();
        } else if (iN == 12) {
            strI = I('\'');
        } else {
            if (iN != 13) {
                StringBuilder sb = new StringBuilder("Expected a name but was ");
                sb.append(peek());
                st4.m(sb, C());
                return null;
            }
            strI = I(StringUtil.DOUBLE_QUOTE);
        }
        this.y0 = 0;
        this.E0[this.D0 - 1] = strI;
        return strI;
    }

    public final void U(char c) {
        do {
            int i = this.A;
            int i2 = this.X;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = this.z[i];
                if (c2 == c) {
                    this.A = i3;
                    return;
                }
                if (c2 == '\\') {
                    this.A = i3;
                    Q();
                    i = this.A;
                    i2 = this.X;
                } else {
                    if (c2 == '\n') {
                        this.Y++;
                        this.Z = i3;
                    }
                    i = i3;
                }
            }
            this.A = i;
        } while (s(1));
        Z("Unterminated string");
        throw null;
    }

    public final void X() {
        char c;
        do {
            if (this.A >= this.X && !s(1)) {
                return;
            }
            int i = this.A;
            int i2 = i + 1;
            this.A = i2;
            c = this.z[i];
            if (c == '\n') {
                this.Y++;
                this.Z = i2;
                return;
            }
        } while (c != '\r');
    }

    public final void Z(String str) throws a60 {
        throw new a60(str.concat(C()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.y0 = 0;
        this.C0[0] = 8;
        this.D0 = 1;
        this.b.close();
    }

    public final void g() {
        if (this.f) {
            return;
        }
        Z("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final boolean hasNext() {
        int iN = this.y0;
        if (iN == 0) {
            iN = n();
        }
        return (iN == 2 || iN == 4) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x020a, code lost:
    
        if (x(r9) != false) goto L121;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0179 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0265 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0266  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int n() {
        /*
            Method dump skipped, instruction units count: 781
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.n():int");
    }

    public final double nextDouble() {
        int iN = this.y0;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 15) {
            this.y0 = 0;
            int[] iArr = this.F0;
            int i = this.D0 - 1;
            iArr[i] = iArr[i] + 1;
            return this.z0;
        }
        if (iN == 16) {
            this.B0 = new String(this.z, this.A, this.A0);
            this.A += this.A0;
        } else if (iN == 8 || iN == 9) {
            this.B0 = I(iN == 8 ? '\'' : StringUtil.DOUBLE_QUOTE);
        } else if (iN == 10) {
            this.B0 = M();
        } else if (iN != 11) {
            StringBuilder sb = new StringBuilder("Expected a double but was ");
            sb.append(peek());
            st4.m(sb, C());
            return 0.0d;
        }
        this.y0 = 11;
        double d = Double.parseDouble(this.B0);
        if (!this.f && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new a60("JSON forbids NaN and infinities: " + d + C());
        }
        this.B0 = null;
        this.y0 = 0;
        int[] iArr2 = this.F0;
        int i2 = this.D0 - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }

    public final b peek() {
        int iN = this.y0;
        if (iN == 0) {
            iN = n();
        }
        switch (iN) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
            case 10:
            case 11:
                return b.STRING;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
            case 13:
            case 14:
                return b.NAME;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final boolean s(int i) throws IOException {
        int i2;
        int i3;
        int i4 = this.Z;
        int i5 = this.A;
        this.Z = i4 - i5;
        int i6 = this.X;
        char[] cArr = this.z;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.X = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.X = 0;
        }
        this.A = 0;
        do {
            int i8 = this.X;
            int i9 = this.b.read(cArr, i8, cArr.length - i8);
            if (i9 == -1) {
                return false;
            }
            i2 = this.X + i9;
            this.X = i2;
            if (this.Y == 0 && (i3 = this.Z) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.A++;
                this.Z = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    public final String toString() {
        return a.class.getSimpleName().concat(C());
    }

    public final boolean x(char c) {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        g();
        return false;
    }
}
