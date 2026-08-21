package defpackage;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lb4 {
    public static final char[] k = new char[0];
    public final /* synthetic */ int a = 1;
    public int b;
    public int c;
    public int d;
    public String e;
    public boolean f;
    public final Object g;
    public Object h;
    public Object i;
    public Object j;

    public lb4(int i, lb4 lb4Var, iv1 iv1Var, Object obj) {
        this.b = i;
        this.g = lb4Var;
        this.d = lb4Var == null ? 0 : lb4Var.d + 1;
        this.h = iv1Var;
        this.c = -1;
        this.j = obj;
    }

    public static void a(int i, int i2) {
        throw new IllegalStateException("TextBuffer overrun: size reached (" + (((long) i) + ((long) i2)) + ") exceeds maximum of 2147483647");
    }

    public void b(int i, int i2, String str) {
        if (this.b >= 0) {
            i(i2);
        }
        this.e = null;
        this.j = null;
        char[] cArr = (char[]) this.i;
        int length = cArr.length;
        int i3 = this.d;
        int i4 = length - i3;
        if (i4 >= i2) {
            str.getChars(i, i + i2, cArr, i3);
            this.d += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = i + i4;
            str.getChars(i, i5, cArr, i3);
            i2 -= i4;
            i = i5;
        }
        while (true) {
            f();
            int iMin = Math.min(((char[]) this.i).length, i2);
            int i6 = i + iMin;
            str.getChars(i, i6, (char[]) this.i, 0);
            this.d += iMin;
            i2 -= iMin;
            if (i2 <= 0) {
                return;
            } else {
                i = i6;
            }
        }
    }

    public void c(char[] cArr, int i, int i2) {
        if (this.b >= 0) {
            i(i2);
        }
        this.e = null;
        this.j = null;
        char[] cArr2 = (char[]) this.i;
        int length = cArr2.length;
        int i3 = this.d;
        int i4 = length - i3;
        if (i4 >= i2) {
            System.arraycopy(cArr, i, cArr2, i3, i2);
            this.d += i2;
            return;
        }
        if (i4 > 0) {
            System.arraycopy(cArr, i, cArr2, i3, i4);
            i += i4;
            i2 -= i4;
        }
        do {
            f();
            int iMin = Math.min(((char[]) this.i).length, i2);
            System.arraycopy(cArr, i, (char[]) this.i, 0, iMin);
            this.d += iMin;
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    public char[] d() {
        int i;
        char[] charArray = (char[]) this.j;
        if (charArray == null) {
            String str = this.e;
            if (str != null) {
                charArray = str.toCharArray();
            } else {
                int i2 = this.b;
                char[] cArr = k;
                if (i2 < 0) {
                    int length = i2 >= 0 ? 0 : charArray != null ? charArray.length : str != null ? str.length() : this.c + this.d;
                    if (length < 1) {
                        if (length < 0) {
                            a(this.c, this.d);
                            throw null;
                        }
                        charArray = cArr;
                    } else {
                        charArray = new char[length];
                        ArrayList arrayList = (ArrayList) this.h;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            i = 0;
                            for (int i3 = 0; i3 < size; i3++) {
                                char[] cArr2 = (char[]) ((ArrayList) this.h).get(i3);
                                int length2 = cArr2.length;
                                System.arraycopy(cArr2, 0, charArray, i, length2);
                                i += length2;
                            }
                        } else {
                            i = 0;
                        }
                        System.arraycopy((char[]) this.i, 0, charArray, i, this.d);
                    }
                } else {
                    charArray = cArr;
                }
            }
            this.j = charArray;
        }
        return charArray;
    }

    public String e() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        char[] cArr = (char[]) this.j;
        if (cArr != null) {
            String str2 = new String(cArr);
            this.e = str2;
            return str2;
        }
        if (this.b >= 0) {
            this.e = "";
            return "";
        }
        int i = this.c;
        int i2 = this.d;
        if (i == 0) {
            if (i2 == 0) {
                this.e = "";
                return "";
            }
            String str3 = new String((char[]) this.i, 0, i2);
            this.e = str3;
            return str3;
        }
        int i3 = i + i2;
        if (i3 < 0) {
            a(i, i2);
            throw null;
        }
        StringBuilder sb = new StringBuilder(i3);
        ArrayList arrayList = (ArrayList) this.h;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                char[] cArr2 = (char[]) ((ArrayList) this.h).get(i4);
                sb.append(cArr2, 0, cArr2.length);
            }
        }
        sb.append((char[]) this.i, 0, this.d);
        String string = sb.toString();
        this.e = string;
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a A[PHI: r1
      0x002a: PHI (r1v5 int) = (r1v3 int), (r1v4 int) binds: [B:8:0x0028, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.h
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 != 0) goto Ld
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.h = r0
        Ld:
            java.lang.Object r1 = r3.i
            char[] r1 = (char[]) r1
            r2 = 1
            r3.f = r2
            r0.add(r1)
            int r0 = r3.c
            int r2 = r1.length
            int r0 = r0 + r2
            r3.c = r0
            if (r0 < 0) goto L36
            r0 = 0
            r3.d = r0
            int r0 = r1.length
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L2c
        L2a:
            r0 = r1
            goto L31
        L2c:
            r1 = 65536(0x10000, float:9.1835E-41)
            if (r0 <= r1) goto L31
            goto L2a
        L31:
            char[] r0 = new char[r0]
            r3.i = r0
            return
        L36:
            int r3 = r1.length
            int r0 = r0 - r3
            int r3 = r1.length
            a(r0, r3)
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lb4.f():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002d A[PHI: r1
      0x002d: PHI (r1v10 int) = (r1v8 int), (r1v9 int) binds: [B:8:0x002b, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public char[] g() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.h
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 != 0) goto Ld
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.h = r0
        Ld:
            r1 = 1
            r2.f = r1
            java.lang.Object r1 = r2.i
            char[] r1 = (char[]) r1
            r0.add(r1)
            java.lang.Object r0 = r2.i
            char[] r0 = (char[]) r0
            int r0 = r0.length
            int r1 = r2.c
            int r1 = r1 + r0
            r2.c = r1
            if (r1 < 0) goto L39
            r1 = 0
            r2.d = r1
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L2f
        L2d:
            r0 = r1
            goto L34
        L2f:
            r1 = 65536(0x10000, float:9.1835E-41)
            if (r0 <= r1) goto L34
            goto L2d
        L34:
            char[] r0 = new char[r0]
            r2.i = r0
            return r0
        L39:
            int r1 = r1 - r0
            a(r1, r0)
            r2 = 0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lb4.g():char[]");
    }

    public String h() {
        int i = this.b;
        return i != 0 ? i != 1 ? i != 2 ? "?" : "Object" : "Array" : "root";
    }

    public void i(int i) {
        char[] cArr;
        this.b = -1;
        char[] cArr2 = (char[]) this.i;
        if (cArr2 == null || i > cArr2.length) {
            mp mpVar = (mp) this.g;
            if (mpVar != null) {
                int i2 = mp.d[2];
                if (i < i2) {
                    i = i2;
                }
                cArr = (char[]) mpVar.b.getAndSet(2, null);
                if (cArr == null || cArr.length < i) {
                    cArr = new char[i];
                }
            } else {
                cArr = new char[Math.max(i, 500)];
            }
            this.i = cArr;
        }
        this.c = 0;
        this.d = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int j(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r5.b
            r1 = 2
            if (r0 != r1) goto L7e
            boolean r0 = r5.f
            if (r0 == 0) goto Lb
            goto L7e
        Lb:
            r0 = 1
            r5.f = r0
            r5.e = r6
            java.lang.Object r1 = r5.h
            iv1 r1 = (defpackage.iv1) r1
            r2 = 0
            if (r1 == 0) goto L78
            java.lang.Object r3 = r1.z
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L21
            r1.z = r6
        L1f:
            r3 = r2
            goto L63
        L21:
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L29
        L27:
            r3 = r0
            goto L63
        L29:
            java.lang.Object r3 = r1.A
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L32
            r1.A = r6
            goto L1f
        L32:
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L39
            goto L27
        L39:
            java.lang.Object r3 = r1.X
            java.util.HashSet r3 = (java.util.HashSet) r3
            if (r3 != 0) goto L5a
            java.util.HashSet r3 = new java.util.HashSet
            r4 = 16
            r3.<init>(r4)
            r1.X = r3
            java.lang.Object r4 = r1.z
            java.lang.String r4 = (java.lang.String) r4
            r3.add(r4)
            java.lang.Object r3 = r1.X
            java.util.HashSet r3 = (java.util.HashSet) r3
            java.lang.Object r4 = r1.A
            java.lang.String r4 = (java.lang.String) r4
            r3.add(r4)
        L5a:
            java.lang.Object r3 = r1.X
            java.util.HashSet r3 = (java.util.HashSet) r3
            boolean r3 = r3.add(r6)
            r3 = r3 ^ r0
        L63:
            if (r3 != 0) goto L66
            goto L78
        L66:
            java.lang.Object r5 = r1.f
            eo1 r5 = (defpackage.eo1) r5
            g52 r0 = new g52
            java.lang.String r1 = "Duplicate field '"
            java.lang.String r2 = "'"
            java.lang.String r6 = defpackage.ha0.o(r1, r6, r2)
            r0.<init>(r6, r5)
            throw r0
        L78:
            int r5 = r5.c
            if (r5 >= 0) goto L7d
            return r2
        L7d:
            return r0
        L7e:
            r5 = 4
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lb4.j(java.lang.String):int");
    }

    public final String toString() {
        switch (this.a) {
            case 0:
                try {
                    return e();
                } catch (IOException unused) {
                    return "TextBuffer: Exception when reading contents";
                }
            default:
                StringBuilder sb = new StringBuilder(64);
                int i = this.b;
                if (i != 0) {
                    if (i != 1) {
                        sb.append('{');
                        String str = this.e;
                        if (str != null) {
                            sb.append(StringUtil.DOUBLE_QUOTE);
                            int[] iArr = v30.f;
                            int length = iArr.length;
                            int length2 = str.length();
                            while (i < length2) {
                                char cCharAt = str.charAt(i);
                                if (cCharAt >= length || iArr[cCharAt] == 0) {
                                    sb.append(cCharAt);
                                } else {
                                    sb.append('\\');
                                    int i2 = iArr[cCharAt];
                                    if (i2 < 0) {
                                        sb.append("u00");
                                        char[] cArr = v30.a;
                                        sb.append(cArr[cCharAt >> 4]);
                                        sb.append(cArr[cCharAt & 15]);
                                    } else {
                                        sb.append((char) i2);
                                    }
                                }
                                i++;
                            }
                            sb.append(StringUtil.DOUBLE_QUOTE);
                        } else {
                            sb.append('?');
                        }
                        sb.append('}');
                    } else {
                        sb.append('[');
                        int i3 = this.c;
                        sb.append(i3 >= 0 ? i3 : 0);
                        sb.append(']');
                    }
                } else {
                    sb.append("/");
                }
                return sb.toString();
        }
    }

    public lb4(int i, lb4 lb4Var, iv1 iv1Var) {
        this.b = i;
        this.g = lb4Var;
        this.d = lb4Var == null ? 0 : lb4Var.d + 1;
        this.h = iv1Var;
        this.c = -1;
    }

    public lb4(mp mpVar) {
        this.g = mpVar;
    }
}
