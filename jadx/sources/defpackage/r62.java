package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class r62 implements Closeable {
    public String A0;
    public int[] B0;
    public String[] D0;
    public int[] E0;
    public final Reader b;
    public long y0;
    public int z0;
    public int F0 = 2;
    public final char[] f = new char[1024];
    public int z = 0;
    public int A = 0;
    public int X = 0;
    public int Y = 0;
    public int Z = 0;
    public int C0 = 1;

    static {
        vd3.z0 = new vd3(22);
    }

    public r62(Reader reader) {
        int[] iArr = new int[32];
        this.B0 = iArr;
        iArr[0] = 6;
        this.D0 = new String[32];
        this.E0 = new int[32];
        this.b = reader;
    }

    public final void B0() throws IOException {
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 3) {
            throw r0("BEGIN_ARRAY");
        }
        Z(1);
        this.E0[this.C0 - 1] = 0;
        this.Z = 0;
    }

    public final boolean C(char c) throws wf2 {
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

    public final String F() {
        StringBuilder sbA = fw.A(this.X + 1, (this.z - this.Y) + 1, " at line ", " column ", " path ");
        sbA.append(x(false));
        return sbA.toString();
    }

    public final boolean I() throws IOException {
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 5) {
            this.Z = 0;
            int[] iArr = this.E0;
            int i = this.C0 - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iN != 6) {
            throw r0("a boolean");
        }
        this.Z = 0;
        int[] iArr2 = this.E0;
        int i2 = this.C0 - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int M(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r62.M(boolean):int");
    }

    public final void N() {
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 7) {
            throw r0("null");
        }
        this.Z = 0;
        int[] iArr = this.E0;
        int i = this.C0 - 1;
        iArr[i] = iArr[i] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        r11.z = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
    
        r1.append(r7, r3, r2 - r3);
        r11.z = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String Q(char r12) throws defpackage.wf2 {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r11.z
            int r3 = r11.A
        L6:
            r4 = r3
            r3 = r2
        L8:
            r5 = 16
            r6 = 1
            char[] r7 = r11.f
            if (r2 >= r4) goto L6b
            int r8 = r2 + 1
            char r2 = r7[r2]
            int r9 = r11.F0
            r10 = 3
            if (r9 != r10) goto L23
            r9 = 32
            if (r2 < r9) goto L1d
            goto L23
        L1d:
            java.lang.String r12 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            r11.q0(r12)
            throw r0
        L23:
            if (r2 != r12) goto L39
            r11.z = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L31
            java.lang.String r11 = new java.lang.String
            r11.<init>(r7, r3, r8)
            return r11
        L31:
            r1.append(r7, r3, r8)
            java.lang.String r11 = r1.toString()
            return r11
        L39:
            r9 = 92
            if (r2 != r9) goto L5e
            r11.z = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L4f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r5)
            r1.<init>(r4)
        L4f:
            r1.append(r7, r3, r2)
            char r2 = r11.c0()
            r1.append(r2)
            int r2 = r11.z
            int r3 = r11.A
            goto L6
        L5e:
            r5 = 10
            if (r2 != r5) goto L69
            int r2 = r11.X
            int r2 = r2 + r6
            r11.X = r2
            r11.Y = r8
        L69:
            r2 = r8
            goto L8
        L6b:
            if (r1 != 0) goto L7b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L7b:
            int r4 = r2 - r3
            r1.append(r7, r3, r4)
            r11.z = r2
            boolean r2 = r11.s(r6)
            if (r2 == 0) goto L8a
            goto L2
        L8a:
            java.lang.String r12 = "Unterminated string"
            r11.q0(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r62.Q(char):java.lang.String");
    }

    public final String R() throws IOException {
        String strQ;
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 14) {
            strQ = U();
        } else if (iN == 12) {
            strQ = Q('\'');
        } else {
            if (iN != 13) {
                throw r0("a name");
            }
            strQ = Q(StringUtil.DOUBLE_QUOTE);
        }
        this.Z = 0;
        this.D0[this.C0 - 1] = strQ;
        return strQ;
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
    public final java.lang.String U() throws defpackage.wf2 {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.z
            int r3 = r3 + r2
            int r4 = r6.A
            char[] r5 = r6.f
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
            int r3 = r6.z
            r0.append(r5, r3, r2)
            int r3 = r6.z
            int r3 = r3 + r2
            r6.z = r3
            r2 = 1
            boolean r2 = r6.s(r2)
            if (r2 != 0) goto L2
        L78:
            int r2 = r6.z
            if (r0 != 0) goto L82
            java.lang.String r0 = new java.lang.String
            r0.<init>(r5, r2, r1)
            goto L89
        L82:
            r0.append(r5, r2, r1)
            java.lang.String r0 = r0.toString()
        L89:
            int r2 = r6.z
            int r2 = r2 + r1
            r6.z = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r62.U():java.lang.String");
    }

    public final void V() throws IOException {
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 2) {
            throw r0("END_OBJECT");
        }
        int i = this.C0;
        int i2 = i - 1;
        this.C0 = i2;
        this.D0[i2] = null;
        int[] iArr = this.E0;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.Z = 0;
    }

    public final int X() throws IOException {
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        switch (iN) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
            case 10:
            case 11:
                return 6;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
            case 13:
            case 14:
                return 5;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void Z(int i) throws wf2 {
        int i2 = this.C0;
        if (i2 - 1 >= 255) {
            throw new wf2("Nesting limit 255 reached".concat(F()));
        }
        int[] iArr = this.B0;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.B0 = Arrays.copyOf(iArr, i3);
            this.E0 = Arrays.copyOf(this.E0, i3);
            this.D0 = (String[]) Arrays.copyOf(this.D0, i3);
        }
        int[] iArr2 = this.B0;
        int i4 = this.C0;
        this.C0 = i4 + 1;
        iArr2[i4] = i;
    }

    public final char c0() throws wf2 {
        int i;
        if (this.z == this.A && !s(1)) {
            q0("Unterminated escape sequence");
            throw null;
        }
        int i2 = this.z;
        int i3 = i2 + 1;
        this.z = i3;
        char[] cArr = this.f;
        char c = cArr[i2];
        if (c != '\n') {
            if (c != '\"') {
                if (c != '\'') {
                    if (c != '/' && c != '\\') {
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
                            q0("Invalid escape sequence");
                            throw null;
                        }
                        if (i2 + 5 > this.A && !s(4)) {
                            q0("Unterminated escape sequence");
                            throw null;
                        }
                        int i4 = this.z;
                        int i5 = i4 + 4;
                        int i6 = 0;
                        while (i4 < i5) {
                            char c2 = cArr[i4];
                            int i7 = i6 << 4;
                            if (c2 >= '0' && c2 <= '9') {
                                i = c2 - '0';
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                i = c2 - 'W';
                            } else {
                                if (c2 < 'A' || c2 > 'F') {
                                    q0("Malformed Unicode escape \\u".concat(new String(cArr, this.z, 4)));
                                    throw null;
                                }
                                i = c2 - '7';
                            }
                            i6 = i + i7;
                            i4++;
                        }
                        this.z += 4;
                        return (char) i6;
                    }
                }
            }
            return c;
        }
        if (this.F0 == 3) {
            q0("Cannot escape a newline character in strict mode");
            throw null;
        }
        this.X++;
        this.Y = i3;
        if (this.F0 == 3) {
            q0("Invalid escaped character \"'\" in strict mode");
            throw null;
        }
        return c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.Z = 0;
        this.B0[0] = 8;
        this.C0 = 1;
        this.b.close();
    }

    public final void g() throws wf2 {
        if (this.F0 == 1) {
            return;
        }
        q0("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    public final boolean hasNext() throws IOException {
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        return (iN == 2 || iN == 4 || iN == 17) ? false : true;
    }

    public final void i0(char c) throws wf2 {
        do {
            int i = this.z;
            int i2 = this.A;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = this.f[i];
                if (c2 == c) {
                    this.z = i3;
                    return;
                }
                if (c2 == '\\') {
                    this.z = i3;
                    c0();
                    i = this.z;
                    i2 = this.A;
                } else {
                    if (c2 == '\n') {
                        this.X++;
                        this.Y = i3;
                    }
                    i = i3;
                }
            }
            this.z = i;
        } while (s(1));
        q0("Unterminated string");
        throw null;
    }

    public final void j0() {
        char c;
        do {
            if (this.z >= this.A && !s(1)) {
                return;
            }
            int i = this.z;
            int i2 = i + 1;
            this.z = i2;
            c = this.f[i];
            if (c == '\n') {
                this.X++;
                this.Y = i2;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x01cd, code lost:
    
        r24 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0222, code lost:
    
        if (C(r14) != false) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0184 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x027e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x027f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int n() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 813
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r62.n():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0046, code lost:
    
        g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n0() throws defpackage.wf2 {
        /*
            r3 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r3.z
            int r1 = r1 + r0
            int r2 = r3.A
            if (r1 >= r2) goto L4f
            char[] r2 = r3.f
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L49
            r2 = 10
            if (r1 == r2) goto L49
            r2 = 12
            if (r1 == r2) goto L49
            r2 = 13
            if (r1 == r2) goto L49
            r2 = 32
            if (r1 == r2) goto L49
            r2 = 35
            if (r1 == r2) goto L46
            r2 = 44
            if (r1 == r2) goto L49
            r2 = 47
            if (r1 == r2) goto L46
            r2 = 61
            if (r1 == r2) goto L46
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L49
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L49
            r2 = 58
            if (r1 == r2) goto L49
            r2 = 59
            if (r1 == r2) goto L46
            switch(r1) {
                case 91: goto L49;
                case 92: goto L46;
                case 93: goto L49;
                default: goto L43;
            }
        L43:
            int r0 = r0 + 1
            goto L1
        L46:
            r3.g()
        L49:
            int r1 = r3.z
            int r1 = r1 + r0
            r3.z = r1
            return
        L4f:
            r3.z = r1
            r0 = 1
            boolean r0 = r3.s(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r62.n0():void");
    }

    public final double nextDouble() throws IOException {
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 15) {
            this.Z = 0;
            int[] iArr = this.E0;
            int i = this.C0 - 1;
            iArr[i] = iArr[i] + 1;
            return this.y0;
        }
        if (iN == 16) {
            this.A0 = new String(this.f, this.z, this.z0);
            this.z += this.z0;
        } else if (iN == 8 || iN == 9) {
            this.A0 = Q(iN == 8 ? '\'' : StringUtil.DOUBLE_QUOTE);
        } else if (iN == 10) {
            this.A0 = U();
        } else if (iN != 11) {
            throw r0("a double");
        }
        this.Z = 11;
        double d = Double.parseDouble(this.A0);
        if (this.F0 != 1 && (Double.isNaN(d) || Double.isInfinite(d))) {
            q0("JSON forbids NaN and infinities: " + d);
            throw null;
        }
        this.A0 = null;
        this.Z = 0;
        int[] iArr2 = this.E0;
        int i2 = this.C0 - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }

    public final int nextInt() throws IOException {
        String strQ;
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 15) {
            long j = this.y0;
            int i = (int) j;
            if (j == i) {
                this.Z = 0;
                int[] iArr = this.E0;
                int i2 = this.C0 - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            throw new NumberFormatException("Expected an int but was " + this.y0 + F());
        }
        if (iN == 16) {
            this.A0 = new String(this.f, this.z, this.z0);
            this.z += this.z0;
        } else {
            if (iN != 8 && iN != 9 && iN != 10) {
                throw r0("an int");
            }
            if (iN == 10) {
                strQ = U();
                this.A0 = strQ;
            } else {
                strQ = Q(iN == 8 ? '\'' : StringUtil.DOUBLE_QUOTE);
                this.A0 = strQ;
            }
            try {
                int i3 = Integer.parseInt(strQ);
                this.Z = 0;
                int[] iArr2 = this.E0;
                int i4 = this.C0 - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
        this.Z = 11;
        double d = Double.parseDouble(this.A0);
        int i5 = (int) d;
        if (i5 != d) {
            st4.k("Expected an int but was ", this.A0, F());
            return 0;
        }
        this.A0 = null;
        this.Z = 0;
        int[] iArr3 = this.E0;
        int i6 = this.C0 - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public final long nextLong() throws IOException {
        String strQ;
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 15) {
            this.Z = 0;
            int[] iArr = this.E0;
            int i = this.C0 - 1;
            iArr[i] = iArr[i] + 1;
            return this.y0;
        }
        if (iN == 16) {
            this.A0 = new String(this.f, this.z, this.z0);
            this.z += this.z0;
        } else {
            if (iN != 8 && iN != 9 && iN != 10) {
                throw r0("a long");
            }
            if (iN == 10) {
                strQ = U();
                this.A0 = strQ;
            } else {
                strQ = Q(iN == 8 ? '\'' : StringUtil.DOUBLE_QUOTE);
                this.A0 = strQ;
            }
            try {
                long j = Long.parseLong(strQ);
                this.Z = 0;
                int[] iArr2 = this.E0;
                int i2 = this.C0 - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.Z = 11;
        double d = Double.parseDouble(this.A0);
        long j2 = (long) d;
        if (j2 != d) {
            st4.k("Expected a long but was ", this.A0, F());
            return 0L;
        }
        this.A0 = null;
        this.Z = 0;
        int[] iArr3 = this.E0;
        int i3 = this.C0 - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j2;
    }

    public final void p0() throws IOException {
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 1) {
            throw r0("BEGIN_OBJECT");
        }
        Z(3);
        this.Z = 0;
    }

    public final String q() throws IOException {
        String str;
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 10) {
            str = U();
        } else if (iN == 8) {
            str = Q('\'');
        } else if (iN == 9) {
            str = Q(StringUtil.DOUBLE_QUOTE);
        } else if (iN == 11) {
            str = this.A0;
            this.A0 = null;
        } else if (iN == 15) {
            str = Long.toString(this.y0);
        } else {
            if (iN != 16) {
                throw r0("a string");
            }
            str = new String(this.f, this.z, this.z0);
            this.z += this.z0;
        }
        this.Z = 0;
        int[] iArr = this.E0;
        int i = this.C0 - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    public final void q0(String str) throws wf2 {
        throw new wf2(str + F() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("malformed-json"));
    }

    public final IllegalStateException r0(String str) {
        String str2 = X() == 9 ? "adapter-not-null-safe" : "unexpected-json-structure";
        StringBuilder sbD = fw.D("Expected ", str, " but was ");
        sbD.append(ha0.B(X()));
        sbD.append(F());
        sbD.append("\nSee ");
        sbD.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(str2));
        return new IllegalStateException(sbD.toString());
    }

    public final boolean s(int i) throws IOException {
        int i2;
        int i3;
        int i4 = this.Y;
        int i5 = this.z;
        this.Y = i4 - i5;
        int i6 = this.A;
        char[] cArr = this.f;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.A = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.A = 0;
        }
        this.z = 0;
        do {
            int i8 = this.A;
            int i9 = this.b.read(cArr, i8, cArr.length - i8);
            if (i9 == -1) {
                return false;
            }
            i2 = this.A + i9;
            this.A = i2;
            if (this.X == 0 && (i3 = this.Y) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.z++;
                this.Y = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void t() throws IOException {
        int i = 0;
        do {
            int iN = this.Z;
            if (iN == 0) {
                iN = n();
            }
            switch (iN) {
                case 1:
                    Z(3);
                    i++;
                    this.Z = 0;
                    break;
                case 2:
                    if (i == 0) {
                        this.D0[this.C0 - 1] = null;
                    }
                    this.C0--;
                    i--;
                    this.Z = 0;
                    break;
                case 3:
                    Z(1);
                    i++;
                    this.Z = 0;
                    break;
                case 4:
                    this.C0--;
                    i--;
                    this.Z = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                default:
                    this.Z = 0;
                    break;
                case 8:
                    i0('\'');
                    this.Z = 0;
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    i0(StringUtil.DOUBLE_QUOTE);
                    this.Z = 0;
                    break;
                case 10:
                    n0();
                    this.Z = 0;
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    i0('\'');
                    if (i == 0) {
                        this.D0[this.C0 - 1] = "<skipped>";
                    }
                    this.Z = 0;
                    break;
                case 13:
                    i0(StringUtil.DOUBLE_QUOTE);
                    if (i == 0) {
                        this.D0[this.C0 - 1] = "<skipped>";
                    }
                    this.Z = 0;
                    break;
                case 14:
                    n0();
                    if (i == 0) {
                        this.D0[this.C0 - 1] = "<skipped>";
                    }
                    this.Z = 0;
                    break;
                case 16:
                    this.z += this.z0;
                    this.Z = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i > 0);
        int[] iArr = this.E0;
        int i2 = this.C0 - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    public final String toString() {
        return r62.class.getSimpleName().concat(F());
    }

    public final void w0() throws IOException {
        int iN = this.Z;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 4) {
            throw r0("END_ARRAY");
        }
        int i = this.C0;
        this.C0 = i - 1;
        int[] iArr = this.E0;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        this.Z = 0;
    }

    public final String x(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i2 = this.C0;
            if (i >= i2) {
                return sb.toString();
            }
            int i3 = this.B0[i];
            switch (i3) {
                case 1:
                case 2:
                    int i4 = this.E0[i];
                    if (z && i4 > 0 && i == i2 - 1) {
                        i4--;
                    }
                    sb.append('[');
                    sb.append(i4);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.D0[i];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    xe.i(dw2.A(i3, "Unknown scope value: "));
                    return null;
            }
            i++;
        }
    }
}
