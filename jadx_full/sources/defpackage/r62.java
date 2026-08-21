package defpackage;

import com.tencent.mars.xlog.Xlog;
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
    */
    public final int M(boolean z) throws IOException {
        int i = this.z;
        int i2 = this.A;
        while (true) {
            if (i == i2) {
                this.z = i;
                if (!s(1)) {
                    if (z) {
                        throw new EOFException("End of input".concat(F()));
                    }
                    return -1;
                }
                i = this.z;
                i2 = this.A;
            }
            int i3 = i + 1;
            char[] cArr = this.f;
            char c = cArr[i];
            if (c == '\n') {
                this.X++;
                this.Y = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.z = i3;
                    if (i3 == i2) {
                        this.z = i;
                        boolean zS = s(2);
                        this.z++;
                        if (!zS) {
                            break;
                        }
                        break;
                        break;
                    }
                    g();
                    int i4 = this.z;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.z = i4 + 1;
                        while (true) {
                            if (this.z + 2 > this.A && !s(2)) {
                                q0("Unterminated comment");
                                throw null;
                            }
                            int i5 = this.z;
                            if (cArr[i5] != '\n') {
                                int i6 = 0;
                                while (true) {
                                    int i7 = this.z;
                                    if (i6 >= 2) {
                                        i = i7 + 2;
                                        i2 = this.A;
                                        break;
                                    }
                                    if (cArr[i7 + i6] != "*/".charAt(i6)) {
                                        break;
                                    }
                                    i6++;
                                }
                            } else {
                                this.X++;
                                this.Y = i5 + 1;
                            }
                            this.z++;
                        }
                    } else {
                        if (c2 != '/') {
                            break;
                        }
                        this.z = i4 + 1;
                        j0();
                        i = this.z;
                        i2 = this.A;
                    }
                } else {
                    if (c != '#') {
                        this.z = i3;
                        return c;
                    }
                    this.z = i3;
                    g();
                    j0();
                    i = this.z;
                    i2 = this.A;
                }
            }
            i = i3;
        }
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
    */
    public final String Q(char c) throws wf2 {
        char[] cArr;
        int i;
        StringBuilder sb = null;
        do {
            int i2 = this.z;
            int i3 = this.A;
            while (true) {
                int i4 = i3;
                int i5 = i2;
                while (true) {
                    cArr = this.f;
                    if (i2 >= i4) {
                        break;
                    }
                    int i6 = i2 + 1;
                    char c2 = cArr[i2];
                    if (this.F0 == 3 && c2 < ' ') {
                        q0("Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode");
                        throw null;
                    }
                    if (c2 == c) {
                        this.z = i6;
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
                        this.X++;
                        this.Y = i6;
                    }
                    i2 = i6;
                }
                sb.append(cArr, i5, i);
                sb.append(c0());
                i2 = this.z;
                i3 = this.A;
            }
        } while (s(1));
        q0("Unterminated string");
        throw null;
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
    */
    public final String U() throws wf2 {
        char[] cArr;
        String string;
        StringBuilder sb = null;
        int i = 0;
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.z + i2;
                int i4 = this.A;
                cArr = this.f;
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
                    sb.append(cArr, this.z, i2);
                    this.z += i2;
                } else if (s(i2 + 1)) {
                }
            }
            i = i2;
            int i5 = this.z;
            if (sb != null) {
                string = new String(cArr, i5, i);
            } else {
                sb.append(cArr, i5, i);
                string = sb.toString();
            }
            this.z += i;
            return string;
        } while (s(1));
        int i52 = this.z;
        if (sb != null) {
        }
        this.z += i;
        return string;
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
    */
    public final int n() throws IOException {
        int iM;
        int i;
        String str;
        String str2;
        int i2;
        int i3;
        char c;
        char c2;
        long j;
        int i4;
        int[] iArr = this.B0;
        boolean z = true;
        int i5 = this.C0 - 1;
        int i6 = iArr[i5];
        char[] cArr = this.f;
        if (i6 == 1) {
            iArr[i5] = 2;
        } else if (i6 == 2) {
            int iM2 = M(true);
            if (iM2 != 44) {
                if (iM2 != 59) {
                    if (iM2 == 93) {
                        this.Z = 4;
                        return 4;
                    }
                    q0("Unterminated array");
                    throw null;
                }
                g();
            }
        } else {
            if (i6 == 3 || i6 == 5) {
                iArr[i5] = 4;
                if (i6 == 5 && (iM = M(true)) != 44) {
                    if (iM != 59) {
                        if (iM == 125) {
                            this.Z = 2;
                            return 2;
                        }
                        q0("Unterminated object");
                        throw null;
                    }
                    g();
                }
                int iM3 = M(true);
                if (iM3 == 34) {
                    this.Z = 13;
                    return 13;
                }
                if (iM3 == 39) {
                    g();
                    this.Z = 12;
                    return 12;
                }
                if (iM3 == 125) {
                    if (i6 != 5) {
                        this.Z = 2;
                        return 2;
                    }
                    q0("Expected name");
                    throw null;
                }
                g();
                this.z--;
                if (C((char) iM3)) {
                    this.Z = 14;
                    return 14;
                }
                q0("Expected name");
                throw null;
            }
            if (i6 == 4) {
                iArr[i5] = 5;
                int iM4 = M(true);
                if (iM4 != 58) {
                    if (iM4 != 61) {
                        q0("Expected ':'");
                        throw null;
                    }
                    g();
                    if (this.z < this.A || s(1)) {
                        int i7 = this.z;
                        if (cArr[i7] == '>') {
                            this.z = i7 + 1;
                        }
                    }
                }
            } else if (i6 == 6) {
                if (this.F0 == 1) {
                    M(true);
                    int i8 = this.z;
                    this.z = i8 - 1;
                    if (i8 + 4 <= this.A || s(5)) {
                        int i9 = this.z;
                        if (cArr[i9] == ')' && cArr[i9 + 1] == ']' && cArr[i9 + 2] == '}' && cArr[i9 + 3] == '\'' && cArr[i9 + 4] == '\n') {
                            this.z = i9 + 5;
                        }
                    }
                }
                this.B0[this.C0 - 1] = 7;
            } else if (i6 == 7) {
                if (M(false) == -1) {
                    this.Z = 17;
                    return 17;
                }
                g();
                this.z--;
            } else if (i6 == 8) {
                xe.q("JsonReader is closed");
                return 0;
            }
        }
        int iM5 = M(true);
        if (iM5 == 34) {
            this.Z = 9;
            return 9;
        }
        if (iM5 == 39) {
            g();
            this.Z = 8;
            return 8;
        }
        if (iM5 == 44 || iM5 == 59) {
            i = 1;
        } else {
            if (iM5 == 91) {
                this.Z = 3;
                return 3;
            }
            if (iM5 == 93) {
                i = 1;
                if (i6 == 1) {
                    this.Z = 4;
                    return 4;
                }
            } else {
                if (iM5 == 123) {
                    this.Z = 1;
                    return 1;
                }
                int i10 = this.z - 1;
                this.z = i10;
                char c3 = cArr[i10];
                if (c3 == 't' || c3 == 'T') {
                    str = "true";
                    str2 = "TRUE";
                    i2 = 5;
                } else if (c3 == 'f' || c3 == 'F') {
                    str = "false";
                    str2 = "FALSE";
                    i2 = 6;
                } else {
                    if (c3 == 'n' || c3 == 'N') {
                        str = "null";
                        str2 = "NULL";
                        i2 = 7;
                    }
                    i3 = 0;
                    if (i3 == 0) {
                        return i3;
                    }
                    int i11 = this.z;
                    int i12 = this.A;
                    boolean z2 = true;
                    int i13 = 0;
                    long j2 = 0;
                    boolean z3 = false;
                    char c4 = 0;
                    while (true) {
                        if (i11 + i13 == i12) {
                            if (i13 == cArr.length) {
                                break;
                            }
                            if (!s(i13 + 1)) {
                                j = j2;
                                break;
                            }
                            i11 = this.z;
                            i12 = this.A;
                            c2 = cArr[i11 + i13];
                            if (c2 != '+') {
                            }
                        } else {
                            c2 = cArr[i11 + i13];
                            if (c2 != '+') {
                                if (c4 != 5) {
                                    break;
                                }
                                c4 = 6;
                                i13++;
                                z = true;
                            } else if (c2 == 'E' || c2 == 'e') {
                                if (c4 != 2 && c4 != 4) {
                                    break;
                                }
                                c4 = 5;
                                i13++;
                                z = true;
                            } else if (c2 != '-') {
                                if (c2 == '.') {
                                    if (c4 != 2) {
                                        break;
                                    }
                                    c4 = 3;
                                    i13++;
                                    z = true;
                                } else {
                                    if (c2 < '0' || c2 > '9') {
                                        break;
                                    }
                                    if (c4 == z || c4 == 0) {
                                        j2 = -(c2 - '0');
                                        c4 = 2;
                                    } else if (c4 != 2) {
                                        long j3 = j2;
                                        if (c4 == 3) {
                                            j2 = j3;
                                            c4 = 4;
                                        } else if (c4 == 5 || c4 == 6) {
                                            j2 = j3;
                                            c4 = 7;
                                        } else {
                                            j2 = j3;
                                        }
                                    } else {
                                        if (j2 == 0) {
                                            break;
                                        }
                                        long j4 = j2;
                                        long j5 = (10 * j2) - ((long) (c2 - '0'));
                                        z2 &= j4 > -922337203685477580L || (j4 == -922337203685477580L && j5 < j4);
                                        j2 = j5;
                                    }
                                    i13++;
                                    z = true;
                                }
                            } else if (c4 == 0) {
                                z3 = true;
                                c4 = 1;
                                i13++;
                                z = true;
                            } else {
                                if (c4 != 5) {
                                    break;
                                }
                                c4 = 6;
                                i13++;
                                z = true;
                            }
                        }
                        if (i4 == 0) {
                            return i4;
                        }
                        if (!C(cArr[this.z])) {
                            q0("Expected value");
                            throw null;
                        }
                        g();
                        this.Z = 10;
                        return 10;
                    }
                    char c5 = 2;
                    if (c4 != 2) {
                        if (c4 != c5 || c4 == 4 || c4 == 7) {
                            this.z0 = i13;
                            i4 = 16;
                            this.Z = 16;
                        } else {
                            i4 = 0;
                        }
                    } else if (!z2 || ((j == Long.MIN_VALUE && !z3) || (j == 0 && z3))) {
                        c5 = 2;
                        if (c4 != c5) {
                        }
                        this.z0 = i13;
                        i4 = 16;
                        this.Z = 16;
                    } else {
                        long j6 = j;
                        if (!z3) {
                            j6 = -j6;
                        }
                        this.y0 = j6;
                        this.z += i13;
                        i4 = 15;
                        this.Z = 15;
                    }
                    if (i4 == 0) {
                    }
                }
                boolean z4 = this.F0 != 3;
                int length = str.length();
                int i14 = 0;
                while (true) {
                    int i15 = this.z;
                    int i16 = this.A;
                    if (i14 < length) {
                        if ((i15 + i14 >= i16 && !s(i14 + 1)) || ((c = cArr[this.z + i14]) != str.charAt(i14) && (!z4 || c != str2.charAt(i14)))) {
                            break;
                        }
                        i14++;
                    } else {
                        if ((i15 + length < i16 || s(length + 1)) && C(cArr[this.z + length])) {
                            break;
                        }
                        this.z += length;
                        this.Z = i2;
                        i3 = i2;
                    }
                }
                i3 = 0;
                if (i3 == 0) {
                }
            }
        }
        if (i6 != i && i6 != 2) {
            q0("Unexpected value");
            throw null;
        }
        g();
        this.z -= i;
        this.Z = 7;
        return 7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0046, code lost:
    
        g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n0() throws wf2 {
        do {
            int i = 0;
            while (true) {
                int i2 = this.z + i;
                if (i2 < this.A) {
                    char c = this.f[i2];
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
                                                    i++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.z = i2;
                }
            }
            this.z += i;
            return;
        } while (s(1));
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
