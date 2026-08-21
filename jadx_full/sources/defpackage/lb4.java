package defpackage;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

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
    */
    public void f() {
        ArrayList arrayList = (ArrayList) this.h;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.h = arrayList;
        }
        char[] cArr = (char[]) this.i;
        this.f = true;
        arrayList.add(cArr);
        int length = this.c + cArr.length;
        this.c = length;
        if (length < 0) {
            a(length - cArr.length, cArr.length);
            throw null;
        }
        this.d = 0;
        int length2 = cArr.length;
        int i = length2 + (length2 >> 1);
        int i2 = 500;
        if (i < 500) {
            i = i2;
        } else {
            i2 = 65536;
            if (i > 65536) {
            }
        }
        this.i = new char[i];
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002d A[PHI: r1
      0x002d: PHI (r1v10 int) = (r1v8 int), (r1v9 int) binds: [B:8:0x002b, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public char[] g() {
        ArrayList arrayList = (ArrayList) this.h;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.h = arrayList;
        }
        this.f = true;
        arrayList.add((char[]) this.i);
        int length = ((char[]) this.i).length;
        int i = this.c + length;
        this.c = i;
        if (i < 0) {
            a(i - length, length);
            throw null;
        }
        this.d = 0;
        int i2 = length + (length >> 1);
        int i3 = 500;
        if (i2 < 500) {
            i2 = i3;
        } else {
            i3 = 65536;
            if (i2 > 65536) {
            }
        }
        char[] cArr = new char[i2];
        this.i = cArr;
        return cArr;
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
    */
    public int j(String str) {
        boolean z;
        if (this.b != 2 || this.f) {
            return 4;
        }
        this.f = true;
        this.e = str;
        iv1 iv1Var = (iv1) this.h;
        if (iv1Var != null) {
            String str2 = (String) iv1Var.z;
            if (str2 == null) {
                iv1Var.z = str;
            } else if (!str.equals(str2)) {
                String str3 = (String) iv1Var.A;
                if (str3 == null) {
                    iv1Var.A = str;
                } else {
                    if (str.equals(str3)) {
                        z = true;
                    } else {
                        if (((HashSet) iv1Var.X) == null) {
                            HashSet hashSet = new HashSet(16);
                            iv1Var.X = hashSet;
                            hashSet.add((String) iv1Var.z);
                            ((HashSet) iv1Var.X).add((String) iv1Var.A);
                        }
                        z = !((HashSet) iv1Var.X).add(str);
                    }
                    if (z) {
                        throw new g52(ha0.o("Duplicate field '", str, "'"), (eo1) iv1Var.f);
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        return this.c < 0 ? 0 : 1;
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
