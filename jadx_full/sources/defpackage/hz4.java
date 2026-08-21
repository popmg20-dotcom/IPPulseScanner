package defpackage;

import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class hz4 {
    public static final byte[] a = new byte[0];
    public static final qw2 b;

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0104, code lost:
    
        continue;
     */
    static {
        int i;
        bu buVar = bu.A;
        bu[] buVarArr = {t60.k("efbbbf"), t60.k("feff"), t60.k("fffe0000"), t60.k("fffe"), t60.k("0000feff")};
        ArrayList arrayList = new ArrayList(new yd(buVarArr, false));
        h70.S(arrayList);
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(-1);
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < 5) {
            bu buVar2 = buVarArr[i3];
            int i5 = i4 + 1;
            int size2 = arrayList.size();
            e70.N(arrayList.size(), size2);
            int i6 = size2 - 1;
            int i7 = 0;
            while (true) {
                if (i7 > i6) {
                    i = -(i7 + 1);
                    break;
                }
                i = (i7 + i6) >>> 1;
                int iF = ye.f((Comparable) arrayList.get(i), buVar2);
                if (iF < 0) {
                    i7 = i + 1;
                } else if (iF > 0) {
                    i6 = i - 1;
                }
            }
            arrayList2.set(i, Integer.valueOf(i4));
            i3++;
            i4 = i5;
        }
        if (((bu) arrayList.get(0)).d() <= 0) {
            xe.k("the empty byte string is not a supported option");
            return;
        }
        int i8 = 0;
        while (i8 < arrayList.size()) {
            bu buVar3 = (bu) arrayList.get(i8);
            int i9 = i8 + 1;
            int i10 = i9;
            while (i10 < arrayList.size()) {
                bu buVar4 = (bu) arrayList.get(i10);
                buVar4.getClass();
                buVar3.getClass();
                if (buVar4.m(0, buVar3, buVar3.d())) {
                    if (buVar4.d() == buVar3.d()) {
                        st4.o(buVar4, "duplicate option: ");
                        return;
                    } else if (((Number) arrayList2.get(i10)).intValue() > ((Number) arrayList2.get(i8)).intValue()) {
                        arrayList.remove(i10);
                        ((Number) arrayList2.remove(i10)).intValue();
                    } else {
                        i10++;
                    }
                }
            }
            i8 = i9;
        }
        hp hpVar = new hp();
        ye.b(0L, hpVar, 0, arrayList, 0, arrayList.size(), arrayList2);
        int i11 = (int) (hpVar.f / 4);
        int[] iArr = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i12] = hpVar.j0();
        }
        b = new qw2((bu[]) Arrays.copyOf(buVarArr, 5), iArr);
    }

    public static final void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            StringBuilder sbC = fw.C("length=", ", offset=", j);
            sbC.append(j2);
            sbC.append(", count=");
            sbC.append(j2);
            throw new ArrayIndexOutOfBoundsException(sbC.toString());
        }
    }

    public static final void b(Closeable closeable) {
        closeable.getClass();
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final int c(int i, int i2, String str, String str2) {
        str.getClass();
        while (i < i2) {
            if (p44.p0(str2, str.charAt(i))) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int d(String str, char c, int i, int i2) {
        str.getClass();
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final boolean e(String[] strArr, String[] strArr2, Comparator comparator) {
        strArr.getClass();
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final int f(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (n12.l(cCharAt, 31) <= 0 || n12.l(cCharAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int g(int i, int i2, String str) {
        str.getClass();
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int h(int i, int i2, String str) {
        str.getClass();
        int i3 = i2 - 1;
        if (i <= i3) {
            while (true) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i3 + 1;
                }
                if (i3 == i) {
                    break;
                }
                i3--;
            }
        }
        return i;
    }

    public static final String[] i(String[] strArr, String[] strArr2, Comparator comparator) {
        strArr.getClass();
        strArr2.getClass();
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean j(String str) {
        str.getClass();
        return str.equalsIgnoreCase("Authorization") || str.equalsIgnoreCase(HttpHeaders.Names.COOKIE) || str.equalsIgnoreCase(HttpHeaders.Names.PROXY_AUTHORIZATION) || str.equalsIgnoreCase(HttpHeaders.Names.SET_COOKIE);
    }

    public static final int k(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' > c || c >= 'G') {
            return -1;
        }
        return c - '7';
    }

    public static final int l(he3 he3Var) {
        return (he3Var.s() & 255) | ((he3Var.s() & 255) << 16) | ((he3Var.s() & 255) << 8);
    }

    public static final int m(hp hpVar) {
        int i = 0;
        while (!hpVar.x() && hpVar.C(0L) == 61) {
            i++;
            hpVar.U();
        }
        return i;
    }

    public static final int n(int i, String str) {
        if (str == null) {
            return i;
        }
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
