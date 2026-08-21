package io.sentry.vendor.gson.stream;

import com.tencent.mars.xlog.Xlog;
import defpackage.a60;
import defpackage.fw;
import defpackage.st4;
import defpackage.xe;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.io.EOFException;
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
    */
    public final int F(boolean z) throws IOException {
        int i = this.A;
        int i2 = this.X;
        while (true) {
            if (i == i2) {
                this.A = i;
                if (!s(1)) {
                    if (z) {
                        throw new EOFException("End of input".concat(C()));
                    }
                    return -1;
                }
                i = this.A;
                i2 = this.X;
            }
            int i3 = i + 1;
            char[] cArr = this.z;
            char c = cArr[i];
            if (c == '\n') {
                this.Y++;
                this.Z = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.A = i3;
                    if (i3 == i2) {
                        this.A = i;
                        boolean zS = s(2);
                        this.A++;
                        if (!zS) {
                            break;
                        }
                        break;
                        break;
                    }
                    g();
                    int i4 = this.A;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.A = i4 + 1;
                        while (true) {
                            if (this.A + 2 > this.X && !s(2)) {
                                Z("Unterminated comment");
                                throw null;
                            }
                            int i5 = this.A;
                            if (cArr[i5] != '\n') {
                                int i6 = 0;
                                while (true) {
                                    int i7 = this.A;
                                    if (i6 >= 2) {
                                        i = i7 + 2;
                                        i2 = this.X;
                                        break;
                                    }
                                    if (cArr[i7 + i6] != "*/".charAt(i6)) {
                                        break;
                                    }
                                    i6++;
                                }
                            } else {
                                this.Y++;
                                this.Z = i5 + 1;
                            }
                            this.A++;
                        }
                    } else {
                        if (c2 != '/') {
                            break;
                        }
                        this.A = i4 + 1;
                        X();
                        i = this.A;
                        i2 = this.X;
                    }
                } else {
                    if (c != '#') {
                        this.A = i3;
                        return c;
                    }
                    this.A = i3;
                    g();
                    X();
                    i = this.A;
                    i2 = this.X;
                }
            }
            i = i3;
        }
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
    */
    public final String I(char c) {
        char[] cArr;
        int i;
        StringBuilder sb = null;
        do {
            int i2 = this.A;
            int i3 = this.X;
            while (true) {
                int i4 = i3;
                int i5 = i2;
                while (true) {
                    cArr = this.z;
                    if (i2 >= i4) {
                        break;
                    }
                    int i6 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 == c) {
                        this.A = i6;
                        int i7 = (i6 - i5) - 1;
                        if (sb == null) {
                            return new String(cArr, i5, i7);
                        }
                        sb.append(cArr, i5, i7);
                        return sb.toString();
                    }
                    if (c2 == '\\') {
                        break;
                    }
                    if (c2 == '\n') {
                        this.Y++;
                        this.Z = i6;
                    }
                    i2 = i6;
                }
                sb.append(cArr, i5, i);
                sb.append(Q());
                i2 = this.A;
                i3 = this.X;
            }
        } while (s(1));
        Z("Unterminated string");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        g();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String M() {
        char[] cArr;
        String string;
        StringBuilder sb = null;
        int i = 0;
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.A + i2;
                int i4 = this.X;
                cArr = this.z;
                if (i3 < i4) {
                    char c = cArr[i3];
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
                } else if (i2 >= cArr.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(cArr, this.A, i2);
                    this.A += i2;
                } else if (s(i2 + 1)) {
                }
            }
            i = i2;
            int i5 = this.A;
            if (sb != null) {
                string = new String(cArr, i5, i);
            } else {
                sb.append(cArr, i5, i);
                string = sb.toString();
            }
            this.A += i;
            return string;
        } while (s(1));
        int i52 = this.A;
        if (sb != null) {
        }
        this.A += i;
        return string;
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
    */
    public final int n() {
        int iF;
        String str;
        String str2;
        int i;
        int i2;
        char c;
        char c2;
        char c3;
        int i3;
        int[] iArr = this.C0;
        int i4 = this.D0 - 1;
        int i5 = iArr[i4];
        char[] cArr = this.z;
        if (i5 == 1) {
            iArr[i4] = 2;
        } else if (i5 == 2) {
            int iF2 = F(true);
            if (iF2 != 44) {
                if (iF2 != 59) {
                    if (iF2 == 93) {
                        this.y0 = 4;
                        return 4;
                    }
                    Z("Unterminated array");
                    throw null;
                }
                g();
            }
        } else {
            if (i5 == 3 || i5 == 5) {
                iArr[i4] = 4;
                if (i5 == 5 && (iF = F(true)) != 44) {
                    if (iF != 59) {
                        if (iF == 125) {
                            this.y0 = 2;
                            return 2;
                        }
                        Z("Unterminated object");
                        throw null;
                    }
                    g();
                }
                int iF3 = F(true);
                if (iF3 == 34) {
                    this.y0 = 13;
                    return 13;
                }
                if (iF3 == 39) {
                    g();
                    this.y0 = 12;
                    return 12;
                }
                if (iF3 == 125) {
                    if (i5 != 5) {
                        this.y0 = 2;
                        return 2;
                    }
                    Z("Expected name");
                    throw null;
                }
                g();
                this.A--;
                if (x((char) iF3)) {
                    this.y0 = 14;
                    return 14;
                }
                Z("Expected name");
                throw null;
            }
            if (i5 == 4) {
                iArr[i4] = 5;
                int iF4 = F(true);
                if (iF4 != 58) {
                    if (iF4 != 61) {
                        Z("Expected ':'");
                        throw null;
                    }
                    g();
                    if (this.A < this.X || s(1)) {
                        int i6 = this.A;
                        if (cArr[i6] == '>') {
                            this.A = i6 + 1;
                        }
                    }
                }
            } else if (i5 == 6) {
                if (this.f) {
                    F(true);
                    int i7 = this.A;
                    int i8 = i7 - 1;
                    this.A = i8;
                    if ((i7 + 4 <= this.X || s(5)) && cArr[i8] == ')' && cArr[i7] == ']' && cArr[i7 + 1] == '}' && cArr[i7 + 2] == '\'' && cArr[i7 + 3] == '\n') {
                        this.A += 5;
                    }
                }
                this.C0[this.D0 - 1] = 7;
            } else if (i5 == 7) {
                if (F(false) == -1) {
                    this.y0 = 17;
                    return 17;
                }
                g();
                this.A--;
            } else if (i5 == 8) {
                xe.q("JsonReader is closed");
                return 0;
            }
        }
        int iF5 = F(true);
        if (iF5 == 34) {
            this.y0 = 9;
            return 9;
        }
        if (iF5 == 39) {
            g();
            this.y0 = 8;
            return 8;
        }
        if (iF5 != 44 && iF5 != 59) {
            if (iF5 == 91) {
                this.y0 = 3;
                return 3;
            }
            if (iF5 != 93) {
                if (iF5 == 123) {
                    this.y0 = 1;
                    return 1;
                }
                int i9 = this.A - 1;
                this.A = i9;
                char c4 = cArr[i9];
                if (c4 == 't' || c4 == 'T') {
                    str = "true";
                    str2 = "TRUE";
                    i = 5;
                } else if (c4 == 'f' || c4 == 'F') {
                    str = "false";
                    str2 = "FALSE";
                    i = 6;
                } else {
                    if (c4 == 'n' || c4 == 'N') {
                        str = "null";
                        str2 = "NULL";
                        i = 7;
                    }
                    i2 = 0;
                    if (i2 == 0) {
                        return i2;
                    }
                    int i10 = this.A;
                    int i11 = this.X;
                    boolean z = true;
                    int i12 = 0;
                    boolean z2 = false;
                    char c5 = 0;
                    long j = 0;
                    while (true) {
                        if (i10 + i12 == i11) {
                            if (i12 == cArr.length) {
                                break;
                            }
                            if (!s(i12 + 1)) {
                                break;
                            }
                            i10 = this.A;
                            i11 = this.X;
                            c2 = cArr[i10 + i12];
                            if (c2 != '+') {
                            }
                        } else {
                            c2 = cArr[i10 + i12];
                            if (c2 != '+') {
                                c3 = 6;
                                if (c5 != 5) {
                                    break;
                                }
                                c5 = c3;
                                i12++;
                            } else if (c2 == 'E' || c2 == 'e') {
                                if (c5 != 2 && c5 != 4) {
                                    break;
                                }
                                c5 = 5;
                                i12++;
                            } else if (c2 == '-') {
                                c3 = 6;
                                if (c5 == 0) {
                                    z2 = true;
                                    c5 = 1;
                                    i12++;
                                } else {
                                    if (c5 != 5) {
                                        break;
                                    }
                                    c5 = c3;
                                    i12++;
                                }
                            } else if (c2 == '.') {
                                if (c5 != 2) {
                                    break;
                                }
                                c5 = 3;
                                i12++;
                            } else {
                                if (c2 < '0' || c2 > '9') {
                                    break;
                                }
                                if (c5 == 1 || c5 == 0) {
                                    j = -(c2 - '0');
                                    c5 = 2;
                                } else if (c5 == 2) {
                                    if (j == 0) {
                                        break;
                                    }
                                    long j2 = (10 * j) - ((long) (c2 - '0'));
                                    z &= j > -922337203685477580L || (j == -922337203685477580L && j2 < j);
                                    j = j2;
                                } else if (c5 == 3) {
                                    c5 = 4;
                                } else if (c5 == 5 || c5 == 6) {
                                    c5 = 7;
                                }
                                i12++;
                            }
                        }
                        if (i3 == 0) {
                            return i3;
                        }
                        if (!x(cArr[this.A])) {
                            Z("Expected value");
                            throw null;
                        }
                        g();
                        this.y0 = 10;
                        return 10;
                    }
                    char c6 = 2;
                    if (c5 != 2) {
                        if (c5 != c6 || c5 == 4 || c5 == 7) {
                            this.A0 = i12;
                            i3 = 16;
                            this.y0 = 16;
                        } else {
                            i3 = 0;
                        }
                    } else if (!z || ((j == Long.MIN_VALUE && !z2) || (j == 0 && z2))) {
                        c6 = 2;
                        if (c5 != c6) {
                        }
                        this.A0 = i12;
                        i3 = 16;
                        this.y0 = 16;
                    } else {
                        if (!z2) {
                            j = -j;
                        }
                        this.z0 = j;
                        this.A += i12;
                        i3 = 15;
                        this.y0 = 15;
                    }
                    if (i3 == 0) {
                    }
                }
                int length = str.length();
                int i13 = 1;
                while (true) {
                    int i14 = this.A;
                    int i15 = this.X;
                    if (i13 < length) {
                        if ((i14 + i13 >= i15 && !s(i13 + 1)) || ((c = cArr[this.A + i13]) != str.charAt(i13) && c != str2.charAt(i13))) {
                            break;
                        }
                        i13++;
                    } else {
                        if ((i14 + length < i15 || s(length + 1)) && x(cArr[this.A + length])) {
                            break;
                        }
                        this.A += length;
                        this.y0 = i;
                        i2 = i;
                    }
                }
                if (i2 == 0) {
                }
            } else if (i5 == 1) {
                this.y0 = 4;
                return 4;
            }
        }
        if (i5 != 1 && i5 != 2) {
            Z("Unexpected value");
            throw null;
        }
        g();
        this.A--;
        this.y0 = 7;
        return 7;
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
