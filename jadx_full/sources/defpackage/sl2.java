package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.handler.ssl.OpenSslSessionTicketKey;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sl2 implements gq3 {
    public static final int[] n = new int[0];
    public static final Unsafe o;
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final d1 e;
    public final boolean f;
    public final int[] g;
    public final int h;
    public final int i;
    public final qr2 j;
    public final wb2 k;
    public final em4 l;
    public final tg2 m;

    static {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new qm4(1));
        } catch (Throwable unused) {
            unsafe = null;
        }
        o = unsafe;
    }

    public sl2(int[] iArr, Object[] objArr, int i, int i2, d1 d1Var, int[] iArr2, int i3, int i4, qr2 qr2Var, wb2 wb2Var, em4 em4Var, q91 q91Var, tg2 tg2Var) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.f = d1Var instanceof co1;
        this.g = iArr2;
        this.h = i3;
        this.i = i4;
        this.j = qr2Var;
        this.k = wb2Var;
        this.l = em4Var;
        this.e = d1Var;
        this.m = tg2Var;
    }

    public static Field F(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbD = fw.D("Field ", str, " for ");
            sbD.append(cls.getName());
            sbD.append(" not found. Known fields are ");
            sbD.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbD.toString());
        }
    }

    public static int I(int i) {
        return (i & 267386880) >>> 20;
    }

    public static boolean p(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof co1) {
            return ((co1) obj).g();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x028b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static sl2 w(qd3 qd3Var, qr2 qr2Var, wb2 wb2Var, em4 em4Var, q91 q91Var, tg2 tg2Var) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        int i17;
        int i18;
        int[] iArr2;
        int i19;
        int i20;
        Object[] objArr;
        int iObjectFieldOffset;
        int i21;
        int i22;
        int i23;
        int iObjectFieldOffset2;
        int iObjectFieldOffset3;
        Field fieldF;
        char cCharAt9;
        int i24;
        int i25;
        int i26;
        Object obj;
        Field fieldF2;
        Object obj2;
        Field fieldF3;
        int i27;
        char cCharAt10;
        int i28;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        if (!(qd3Var instanceof qd3)) {
            st4.n();
            return null;
        }
        String str = qd3Var.b;
        int length = str.length();
        char c = 55296;
        if (str.charAt(0) >= 55296) {
            int i32 = 1;
            while (true) {
                i = i32 + 1;
                if (str.charAt(i32) < 55296) {
                    break;
                }
                i32 = i;
            }
        } else {
            i = 1;
        }
        int i33 = i + 1;
        int iCharAt2 = str.charAt(i);
        if (iCharAt2 >= 55296) {
            int i34 = iCharAt2 & 8191;
            int i35 = 13;
            while (true) {
                i31 = i33 + 1;
                cCharAt13 = str.charAt(i33);
                if (cCharAt13 < 55296) {
                    break;
                }
                i34 |= (cCharAt13 & 8191) << i35;
                i35 += 13;
                i33 = i31;
            }
            iCharAt2 = i34 | (cCharAt13 << i35);
            i33 = i31;
        }
        if (iCharAt2 == 0) {
            i3 = 0;
            i6 = 0;
            iCharAt = 0;
            i2 = 0;
            i5 = 0;
            i7 = 0;
            iArr = n;
            i4 = 0;
        } else {
            int i36 = i33 + 1;
            int iCharAt3 = str.charAt(i33);
            if (iCharAt3 >= 55296) {
                int i37 = iCharAt3 & 8191;
                int i38 = 13;
                while (true) {
                    i15 = i36 + 1;
                    cCharAt8 = str.charAt(i36);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt8 & 8191) << i38;
                    i38 += 13;
                    i36 = i15;
                }
                iCharAt3 = i37 | (cCharAt8 << i38);
                i36 = i15;
            }
            int i39 = i36 + 1;
            int iCharAt4 = str.charAt(i36);
            if (iCharAt4 >= 55296) {
                int i40 = iCharAt4 & 8191;
                int i41 = 13;
                while (true) {
                    i14 = i39 + 1;
                    cCharAt7 = str.charAt(i39);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt7 & 8191) << i41;
                    i41 += 13;
                    i39 = i14;
                }
                iCharAt4 = i40 | (cCharAt7 << i41);
                i39 = i14;
            }
            int i42 = i39 + 1;
            int iCharAt5 = str.charAt(i39);
            if (iCharAt5 >= 55296) {
                int i43 = iCharAt5 & 8191;
                int i44 = 13;
                while (true) {
                    i13 = i42 + 1;
                    cCharAt6 = str.charAt(i42);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt6 & 8191) << i44;
                    i44 += 13;
                    i42 = i13;
                }
                iCharAt5 = i43 | (cCharAt6 << i44);
                i42 = i13;
            }
            int i45 = i42 + 1;
            int iCharAt6 = str.charAt(i42);
            if (iCharAt6 >= 55296) {
                int i46 = iCharAt6 & 8191;
                int i47 = 13;
                while (true) {
                    i12 = i45 + 1;
                    cCharAt5 = str.charAt(i45);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt5 & 8191) << i47;
                    i47 += 13;
                    i45 = i12;
                }
                iCharAt6 = i46 | (cCharAt5 << i47);
                i45 = i12;
            }
            int i48 = i45 + 1;
            iCharAt = str.charAt(i45);
            if (iCharAt >= 55296) {
                int i49 = iCharAt & 8191;
                int i50 = 13;
                while (true) {
                    i11 = i48 + 1;
                    cCharAt4 = str.charAt(i48);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt4 & 8191) << i50;
                    i50 += 13;
                    i48 = i11;
                }
                iCharAt = i49 | (cCharAt4 << i50);
                i48 = i11;
            }
            int i51 = i48 + 1;
            int iCharAt7 = str.charAt(i48);
            if (iCharAt7 >= 55296) {
                int i52 = iCharAt7 & 8191;
                int i53 = 13;
                while (true) {
                    i10 = i51 + 1;
                    cCharAt3 = str.charAt(i51);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt3 & 8191) << i53;
                    i53 += 13;
                    i51 = i10;
                }
                iCharAt7 = i52 | (cCharAt3 << i53);
                i51 = i10;
            }
            int i54 = i51 + 1;
            int iCharAt8 = str.charAt(i51);
            if (iCharAt8 >= 55296) {
                int i55 = iCharAt8 & 8191;
                int i56 = 13;
                while (true) {
                    i9 = i54 + 1;
                    cCharAt2 = str.charAt(i54);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt2 & 8191) << i56;
                    i56 += 13;
                    i54 = i9;
                }
                iCharAt8 = i55 | (cCharAt2 << i56);
                i54 = i9;
            }
            int i57 = i54 + 1;
            int iCharAt9 = str.charAt(i54);
            if (iCharAt9 >= 55296) {
                int i58 = iCharAt9 & 8191;
                int i59 = 13;
                while (true) {
                    i8 = i57 + 1;
                    cCharAt = str.charAt(i57);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i58 |= (cCharAt & 8191) << i59;
                    i59 += 13;
                    i57 = i8;
                }
                iCharAt9 = i58 | (cCharAt << i59);
                i57 = i8;
            }
            int[] iArr3 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i60 = (iCharAt3 * 2) + iCharAt4;
            int i61 = iCharAt7;
            i2 = iCharAt5;
            i3 = i61;
            i4 = iCharAt3;
            i33 = i57;
            iArr = iArr3;
            i5 = iCharAt6;
            i6 = i60;
            i7 = iCharAt9;
        }
        Object[] objArr2 = qd3Var.c;
        Class<?> cls = qd3Var.a.getClass();
        int[] iArr4 = new int[iCharAt * 3];
        Object[] objArr3 = new Object[iCharAt * 2];
        int i62 = i7 + i3;
        int i63 = i62;
        int i64 = i7;
        int i65 = 0;
        int i66 = 0;
        while (i33 < length) {
            int i67 = i33 + 1;
            int iCharAt10 = str.charAt(i33);
            if (iCharAt10 >= c) {
                int i68 = iCharAt10 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i30 = i69 + 1;
                    cCharAt12 = str.charAt(i69);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i68 |= (cCharAt12 & 8191) << i70;
                    i70 += 13;
                    i69 = i30;
                }
                iCharAt10 = i68 | (cCharAt12 << i70);
                i16 = i30;
            } else {
                i16 = i67;
            }
            int i71 = i16 + 1;
            int iCharAt11 = str.charAt(i16);
            if (iCharAt11 >= c) {
                int i72 = iCharAt11 & 8191;
                int i73 = i71;
                int i74 = 13;
                while (true) {
                    i29 = i73 + 1;
                    cCharAt11 = str.charAt(i73);
                    i17 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i72 |= (cCharAt11 & 8191) << i74;
                    i74 += 13;
                    i73 = i29;
                    length = i17;
                }
                iCharAt11 = i72 | (cCharAt11 << i74);
                i18 = i29;
            } else {
                i17 = length;
                i18 = i71;
            }
            int i75 = iCharAt11 & DnsRecord.CLASS_ANY;
            int i76 = iCharAt10;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i65] = i66;
                i65++;
            }
            int i77 = i4;
            Unsafe unsafe = o;
            if (i75 >= 51) {
                int i78 = i18 + 1;
                int iCharAt12 = str.charAt(i18);
                if (iCharAt12 >= 55296) {
                    int i79 = iCharAt12 & 8191;
                    int i80 = i78;
                    int i81 = 13;
                    while (true) {
                        i27 = i80 + 1;
                        cCharAt10 = str.charAt(i80);
                        i28 = i79;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i79 = i28 | ((cCharAt10 & 8191) << i81);
                        i81 += 13;
                        i80 = i27;
                    }
                    iCharAt12 = i28 | (cCharAt10 << i81);
                    i25 = i27;
                } else {
                    i25 = i78;
                }
                int i82 = iCharAt12;
                int i83 = i75 - 51;
                int i84 = i25;
                if (i83 == 9 || i83 == 17) {
                    i26 = i6 + 1;
                    objArr3[((i66 / 3) * 2) + 1] = objArr2[i6];
                } else {
                    if (i83 == 12 && (fw.e(qd3Var.a(), 1) || (iCharAt11 & 2048) != 0)) {
                        i26 = i6 + 1;
                        objArr3[((i66 / 3) * 2) + 1] = objArr2[i6];
                    }
                    int i85 = i82 * 2;
                    obj = objArr2[i85];
                    if (obj instanceof Field) {
                        fieldF2 = F(cls, (String) obj);
                        objArr2[i85] = fieldF2;
                    } else {
                        fieldF2 = (Field) obj;
                    }
                    iArr2 = iArr4;
                    i19 = i62;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldF2);
                    int i86 = i85 + 1;
                    obj2 = objArr2[i86];
                    if (obj2 instanceof Field) {
                        fieldF3 = F(cls, (String) obj2);
                        objArr2[i86] = fieldF3;
                    } else {
                        fieldF3 = (Field) obj2;
                    }
                    iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldF3);
                    objArr = objArr3;
                    i21 = i84;
                    i23 = 0;
                }
                i6 = i26;
                int i852 = i82 * 2;
                obj = objArr2[i852];
                if (obj instanceof Field) {
                }
                iArr2 = iArr4;
                i19 = i62;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldF2);
                int i862 = i852 + 1;
                obj2 = objArr2[i862];
                if (obj2 instanceof Field) {
                }
                iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldF3);
                objArr = objArr3;
                i21 = i84;
                i23 = 0;
            } else {
                iArr2 = iArr4;
                i19 = i62;
                int i87 = i6 + 1;
                Field fieldF4 = F(cls, (String) objArr2[i6]);
                if (i75 == 9 || i75 == 17) {
                    i20 = i87;
                    objArr3[((i66 / 3) * 2) + 1] = fieldF4.getType();
                } else {
                    if (i75 == 27 || i75 == 49) {
                        i24 = i6 + 2;
                        objArr3[((i66 / 3) * 2) + 1] = objArr2[i87];
                    } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                        i20 = i87;
                        if (qd3Var.a() == 1 || (iCharAt11 & 2048) != 0) {
                            i24 = i6 + 2;
                            objArr3[((i66 / 3) * 2) + 1] = objArr2[i20];
                        }
                    } else if (i75 == 50) {
                        int i88 = i64 + 1;
                        iArr[i64] = i66;
                        int i89 = (i66 / 3) * 2;
                        i20 = i6 + 2;
                        objArr3[i89] = objArr2[i87];
                        if ((iCharAt11 & 2048) != 0) {
                            objArr3[i89 + 1] = objArr2[i20];
                            i20 = i6 + 3;
                        }
                        i64 = i88;
                    } else {
                        i20 = i87;
                    }
                    i20 = i24;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldF4);
                if ((iCharAt11 & 4096) == 0 || i75 > 17) {
                    objArr = objArr3;
                    iObjectFieldOffset = 1048575;
                    i21 = i18;
                    i22 = 0;
                } else {
                    int i90 = i18 + 1;
                    int iCharAt13 = str.charAt(i18);
                    if (iCharAt13 >= 55296) {
                        int i91 = iCharAt13 & 8191;
                        int i92 = 13;
                        while (true) {
                            i21 = i90 + 1;
                            cCharAt9 = str.charAt(i90);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i91 |= (cCharAt9 & 8191) << i92;
                            i92 += 13;
                            i90 = i21;
                        }
                        iCharAt13 = i91 | (cCharAt9 << i92);
                    } else {
                        i21 = i90;
                    }
                    int i93 = (iCharAt13 / 32) + (i77 * 2);
                    Object obj3 = objArr2[i93];
                    if (obj3 instanceof Field) {
                        fieldF = (Field) obj3;
                    } else {
                        fieldF = F(cls, (String) obj3);
                        objArr2[i93] = fieldF;
                    }
                    objArr = objArr3;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldF);
                    i22 = iCharAt13 % 32;
                }
                if (i75 < 18 || i75 > 49) {
                    int i94 = iObjectFieldOffset;
                    i23 = i22;
                    iObjectFieldOffset2 = iObjectFieldOffset4;
                    iObjectFieldOffset3 = i94;
                } else {
                    iArr[i63] = iObjectFieldOffset4;
                    int i95 = iObjectFieldOffset;
                    i23 = i22;
                    iObjectFieldOffset2 = iObjectFieldOffset4;
                    iObjectFieldOffset3 = i95;
                    i63++;
                }
                i6 = i20;
            }
            int i96 = i66 + 1;
            iArr2[i66] = i76;
            int i97 = i66 + 2;
            String str2 = str;
            iArr2[i96] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | (i75 << 20) | iObjectFieldOffset2;
            i66 += 3;
            iArr2[i97] = (i23 << 20) | iObjectFieldOffset3;
            objArr3 = objArr;
            str = str2;
            i33 = i21;
            length = i17;
            i4 = i77;
            iArr4 = iArr2;
            i62 = i19;
            c = 55296;
        }
        return new sl2(iArr4, objArr3, i2, i5, qd3Var.a, iArr, i7, i62, qr2Var, wb2Var, em4Var, q91Var, tg2Var);
    }

    public static long x(int i) {
        return i & 1048575;
    }

    public static int y(long j, Object obj) {
        return ((Integer) xm4.h(obj, j)).intValue();
    }

    public static long z(long j, Object obj) {
        return ((Long) xm4.h(obj, j)).longValue();
    }

    public final int A(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        int[] iArr = this.a;
        int length = (iArr.length / 3) - 1;
        int i2 = 0;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final void B(Object obj, long j, r02 r02Var, gq3 gq3Var, p91 p91Var) throws r12 {
        int iU;
        this.k.getClass();
        h12 h12VarA = wb2.a(j, obj);
        p60 p60Var = (p60) r02Var.d;
        int i = r02Var.a;
        if ((i & 7) != 3) {
            throw t12.b();
        }
        do {
            co1 co1VarI = gq3Var.i();
            r02Var.g(co1VarI, gq3Var, p91Var);
            gq3Var.b(co1VarI);
            ((x93) h12VarA).add(co1VarI);
            if (p60Var.c() || r02Var.c != 0) {
                return;
            } else {
                iU = p60Var.u();
            }
        } while (iU == i);
        r02Var.c = iU;
    }

    public final void C(Object obj, int i, r02 r02Var, gq3 gq3Var, p91 p91Var) throws t12 {
        int iU;
        this.k.getClass();
        h12 h12VarA = wb2.a(i & 1048575, obj);
        p60 p60Var = (p60) r02Var.d;
        int i2 = r02Var.a;
        if ((i2 & 7) != 2) {
            throw t12.b();
        }
        do {
            co1 co1VarI = gq3Var.i();
            r02Var.h(co1VarI, gq3Var, p91Var);
            gq3Var.b(co1VarI);
            ((x93) h12VarA).add(co1VarI);
            if (p60Var.c() || r02Var.c != 0) {
                return;
            } else {
                iU = p60Var.u();
            }
        } while (iU == i2);
        r02Var.c = iU;
    }

    public final void D(int i, r02 r02Var, Object obj) throws r12 {
        p60 p60Var = (p60) r02Var.d;
        if ((536870912 & i) != 0) {
            r02Var.C(2);
            xm4.o(obj, i & 1048575, p60Var.t());
        } else if (!this.f) {
            xm4.o(obj, i & 1048575, r02Var.j());
        } else {
            r02Var.C(2);
            xm4.o(obj, i & 1048575, p60Var.s());
        }
    }

    public final void E(int i, r02 r02Var, Object obj) throws r12 {
        boolean z = (536870912 & i) != 0;
        wb2 wb2Var = this.k;
        if (z) {
            wb2Var.getClass();
            r02Var.x(wb2.a(i & 1048575, obj), true);
        } else {
            wb2Var.getClass();
            r02Var.x(wb2.a(i & 1048575, obj), false);
        }
    }

    public final void G(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        xm4.m(obj, j, (1 << (i2 >>> 20)) | xm4.f(obj, j));
    }

    public final void H(int i, int i2, Object obj) {
        xm4.m(obj, this.a[i2 + 2] & 1048575, i);
    }

    public final int J(int i) {
        return this.a[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Object obj, Object obj2) {
        Object obj3;
        if (!p(obj)) {
            vp1.h(obj, "Mutating immutable message: ");
            return;
        }
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                hq3.k(this.l, obj, obj2);
                return;
            }
            int iJ = J(i);
            long j = 1048575 & iJ;
            int i2 = iArr[i];
            switch (I(iJ)) {
                case 0:
                    if (!n(i, obj2)) {
                        obj3 = obj;
                    } else {
                        vm4 vm4Var = xm4.c;
                        obj3 = obj;
                        vm4Var.g(obj3, j, vm4Var.c(j, obj2));
                        G(i, obj3);
                    }
                    break;
                case 1:
                    if (n(i, obj2)) {
                        vm4 vm4Var2 = xm4.c;
                        vm4Var2.h(obj, j, vm4Var2.d(j, obj2));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 2:
                    if (n(i, obj2)) {
                        xm4.n(obj, j, xm4.g(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 3:
                    if (n(i, obj2)) {
                        xm4.n(obj, j, xm4.g(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 4:
                    if (n(i, obj2)) {
                        xm4.m(obj, j, xm4.f(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 5:
                    if (n(i, obj2)) {
                        xm4.n(obj, j, xm4.g(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 6:
                    if (n(i, obj2)) {
                        xm4.m(obj, j, xm4.f(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 7:
                    if (n(i, obj2)) {
                        vm4 vm4Var3 = xm4.c;
                        vm4Var3.e(obj, j, vm4Var3.a(j, obj2));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 8:
                    if (n(i, obj2)) {
                        xm4.o(obj, j, xm4.h(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    s(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 10:
                    if (n(i, obj2)) {
                        xm4.o(obj, j, xm4.h(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 11:
                    if (n(i, obj2)) {
                        xm4.m(obj, j, xm4.f(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    if (n(i, obj2)) {
                        xm4.m(obj, j, xm4.f(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 13:
                    if (n(i, obj2)) {
                        xm4.m(obj, j, xm4.f(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 14:
                    if (n(i, obj2)) {
                        xm4.n(obj, j, xm4.g(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    if (n(i, obj2)) {
                        xm4.m(obj, j, xm4.f(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 16:
                    if (n(i, obj2)) {
                        xm4.n(obj, j, xm4.g(obj2, j));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 17:
                    s(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                case 49:
                    this.k.getClass();
                    h12 h12VarC = (h12) xm4.h(obj, j);
                    h12 h12Var = (h12) xm4.h(obj2, j);
                    int i3 = ((x93) h12VarC).z;
                    int i4 = ((x93) h12Var).z;
                    if (i3 > 0 && i4 > 0) {
                        if (!((x93) h12VarC).b) {
                            h12VarC = ((x93) h12VarC).c(i4 + i3);
                        }
                        ((x93) h12VarC).addAll(h12Var);
                    }
                    if (i3 > 0) {
                        h12Var = h12VarC;
                    }
                    xm4.o(obj, j, h12Var);
                    obj3 = obj;
                    break;
                case 50:
                    Class cls = hq3.a;
                    Object objH = xm4.h(obj, j);
                    Object objH2 = xm4.h(obj2, j);
                    this.m.getClass();
                    xm4.o(obj, j, tg2.a(objH, objH2));
                    obj3 = obj;
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (q(i2, i, obj2)) {
                        xm4.o(obj, j, xm4.h(obj2, j));
                        H(i2, i, obj);
                    }
                    obj3 = obj;
                    break;
                case 60:
                    t(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (q(i2, i, obj2)) {
                        xm4.o(obj, j, xm4.h(obj2, j));
                        H(i2, i, obj);
                    }
                    obj3 = obj;
                    break;
                case 68:
                    t(i, obj, obj2);
                    obj3 = obj;
                    break;
            }
            i += 3;
            obj = obj3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Object obj) {
        if (p(obj)) {
            if (obj instanceof co1) {
                co1 co1Var = (co1) obj;
                co1Var.k(ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
                co1Var.memoizedHashCode = 0;
                co1Var.h();
            }
            int[] iArr = this.a;
            int length = iArr.length;
            for (int i = 0; i < length; i += 3) {
                int iJ = J(i);
                long j = 1048575 & iJ;
                int I = I(iJ);
                Unsafe unsafe = o;
                if (I != 9) {
                    if (I != 60 && I != 68) {
                        switch (I) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                            case 49:
                                this.k.getClass();
                                x93 x93Var = (x93) ((h12) xm4.h(obj, j));
                                if (x93Var.b) {
                                    x93Var.b = false;
                                }
                                break;
                            case 50:
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    this.m.getClass();
                                    ((sg2) object).b = false;
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (q(iArr[i], i, obj)) {
                        m(i).b(unsafe.getObject(obj, j));
                    }
                } else if (n(i, obj)) {
                    m(i).b(unsafe.getObject(obj, j));
                }
            }
            this.l.getClass();
            dm4 dm4Var = ((co1) obj).unknownFields;
            if (dm4Var.e) {
                dm4Var.e = false;
            }
        }
    }

    @Override // defpackage.gq3
    public final boolean c(Object obj) {
        int i;
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.h) {
            int i7 = this.g[i6];
            int[] iArr = this.a;
            int i8 = iArr[i7];
            int iJ = J(i7);
            int i9 = iArr[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = o.getInt(obj, i10);
                }
                i2 = i7;
                i3 = i5;
                i = i10;
            } else {
                int i12 = i5;
                i = i4;
                i2 = i7;
                i3 = i12;
            }
            if ((268435456 & iJ) == 0 || o(obj, i2, i, i3, i11)) {
                int I = I(iJ);
                if (I != 9 && I != 17) {
                    if (I != 27) {
                        if (I == 60 || I == 68) {
                            if (!q(i8, i2, obj) || m(i2).c(xm4.h(obj, iJ & 1048575))) {
                                i6++;
                                i4 = i;
                                i5 = i3;
                            }
                        } else if (I != 49) {
                            if (I != 50) {
                                continue;
                            } else {
                                Object objH = xm4.h(obj, iJ & 1048575);
                                this.m.getClass();
                                sg2 sg2Var = (sg2) objH;
                                if (sg2Var.isEmpty()) {
                                    continue;
                                } else {
                                    if (((bw4) ((jg2) this.b[(i2 / 3) * 2]).a.z).b != dw4.MESSAGE) {
                                        continue;
                                    } else {
                                        gq3 gq3VarA = null;
                                        for (Object obj2 : sg2Var.values()) {
                                            if (gq3VarA == null) {
                                                gq3VarA = v93.c.a(obj2.getClass());
                                            }
                                            if (!gq3VarA.c(obj2)) {
                                            }
                                        }
                                    }
                                }
                            }
                            i6++;
                            i4 = i;
                            i5 = i3;
                        }
                    }
                    List list = (List) xm4.h(obj, iJ & 1048575);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        gq3 gq3VarM = m(i2);
                        for (int i13 = 0; i13 < list.size(); i13++) {
                            if (gq3VarM.c(list.get(i13))) {
                            }
                        }
                    }
                    i6++;
                    i4 = i;
                    i5 = i3;
                } else if (!o(obj, i2, i, i3, i11) || m(i2).c(xm4.h(obj, iJ & 1048575))) {
                    i6++;
                    i4 = i;
                    i5 = i3;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.gq3
    public final void d(Object obj, zf2 zf2Var) throws IOException {
        int i;
        int i2;
        int i3;
        boolean z;
        sl2 sl2Var = this;
        zf2Var.getClass();
        r60 r60Var = (r60) zf2Var.f;
        int[] iArr = sl2Var.a;
        int length = iArr.length;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int iJ = sl2Var.J(i6);
            int i8 = iArr[i6];
            int I = I(iJ);
            Unsafe unsafe = o;
            if (I <= 17) {
                int i9 = iArr[i6 + 2];
                i = 1;
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i7 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                int i11 = 1 << (i9 >>> 20);
                i2 = iJ;
                i3 = i11;
            } else {
                i = 1;
                i2 = iJ;
                i3 = 0;
            }
            long j = i2 & i4;
            switch (I) {
                case 0:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.t(i8, Double.doubleToRawLongBits(xm4.c.c(j, obj)));
                    }
                    break;
                case 1:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.r(i8, Float.floatToRawIntBits(xm4.c.d(j, obj)));
                    }
                    sl2Var = this;
                    break;
                case 2:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.E(i8, unsafe.getLong(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 3:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.E(i8, unsafe.getLong(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 4:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.v(i8, unsafe.getInt(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 5:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.t(i8, unsafe.getLong(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 6:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.r(i8, unsafe.getInt(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 7:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.o(i8, xm4.c.a(j, obj));
                    }
                    sl2Var = this;
                    break;
                case 8:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof String) {
                            r60Var.z(i8, (String) object);
                        } else {
                            r60Var.p(i8, (au) object);
                        }
                    }
                    sl2Var = this;
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.y(i8, (d1) unsafe.getObject(obj, j), sl2Var.m(i6));
                    }
                    break;
                case 10:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.p(i8, (au) unsafe.getObject(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 11:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.C(i8, unsafe.getInt(obj, j));
                    }
                    sl2Var = this;
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.v(i8, unsafe.getInt(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 13:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.r(i8, unsafe.getInt(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 14:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.t(i8, unsafe.getLong(obj, j));
                    }
                    sl2Var = this;
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        int i12 = unsafe.getInt(obj, j);
                        r60Var.C(i8, (i12 >> 31) ^ (i12 << 1));
                    }
                    sl2Var = this;
                    break;
                case 16:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        long j2 = unsafe.getLong(obj, j);
                        r60Var.E(i8, (j2 >> 63) ^ (j2 << 1));
                    }
                    sl2Var = this;
                    break;
                case 17:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        zf2Var.r0(i8, unsafe.getObject(obj, j), sl2Var.m(i6));
                    }
                    break;
                case 18:
                    hq3.n(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 19:
                    hq3.r(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 20:
                    hq3.t(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 21:
                    hq3.z(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 22:
                    hq3.s(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 23:
                    hq3.q(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 24:
                    hq3.p(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 25:
                    hq3.m(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 26:
                    int i13 = iArr[i6];
                    List list = (List) unsafe.getObject(obj, j);
                    Class cls = hq3.a;
                    if (list != null && !list.isEmpty()) {
                        for (int i14 = 0; i14 < list.size(); i14++) {
                            r60Var.z(i13, (String) list.get(i14));
                        }
                    }
                    break;
                case 27:
                    int i15 = iArr[i6];
                    List list2 = (List) unsafe.getObject(obj, j);
                    gq3 gq3VarM = sl2Var.m(i6);
                    Class cls2 = hq3.a;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i16 = 0; i16 < list2.size(); i16++) {
                            r60Var.y(i15, (d1) list2.get(i16), gq3VarM);
                        }
                    }
                    break;
                case 28:
                    int i17 = iArr[i6];
                    List list3 = (List) unsafe.getObject(obj, j);
                    Class cls3 = hq3.a;
                    if (list3 != null && !list3.isEmpty()) {
                        for (int i18 = 0; i18 < list3.size(); i18++) {
                            r60Var.p(i17, (au) list3.get(i18));
                        }
                    }
                    break;
                case 29:
                    z = false;
                    hq3.y(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 30:
                    z = false;
                    hq3.o(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 31:
                    z = false;
                    hq3.u(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 32:
                    z = false;
                    hq3.v(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 33:
                    z = false;
                    hq3.w(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 34:
                    z = false;
                    hq3.x(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 35:
                    hq3.n(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 36:
                    hq3.r(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 37:
                    hq3.t(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 38:
                    hq3.z(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 39:
                    hq3.s(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 40:
                    hq3.q(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 41:
                    hq3.p(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 42:
                    hq3.m(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 43:
                    hq3.y(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 44:
                    hq3.o(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 45:
                    hq3.u(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 46:
                    hq3.v(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 47:
                    hq3.w(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                    hq3.x(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, true);
                    break;
                case 49:
                    int i19 = iArr[i6];
                    List list4 = (List) unsafe.getObject(obj, j);
                    gq3 gq3VarM2 = sl2Var.m(i6);
                    Class cls4 = hq3.a;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            zf2Var.r0(i19, list4.get(i20), gq3VarM2);
                        }
                    }
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j);
                    if (object2 != null) {
                        int i21 = 2;
                        Object obj2 = sl2Var.b[(i6 / 3) * 2];
                        sl2Var.m.getClass();
                        n02 n02Var = ((jg2) obj2).a;
                        for (Map.Entry entry : ((sg2) object2).entrySet()) {
                            r60Var.B(i8, i21);
                            r60Var.D(jg2.a(n02Var, entry.getKey(), entry.getValue()));
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            ld1.b(r60Var, (bw4) n02Var.f, i, key);
                            i21 = 2;
                            ld1.b(r60Var, (bw4) n02Var.z, 2, value);
                            i = 1;
                        }
                    }
                    break;
                case 51:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.t(i8, Double.doubleToRawLongBits(((Double) xm4.h(obj, j)).doubleValue()));
                    }
                    break;
                case 52:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.r(i8, Float.floatToRawIntBits(((Float) xm4.h(obj, j)).floatValue()));
                    }
                    break;
                case 53:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.E(i8, z(j, obj));
                    }
                    break;
                case 54:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.E(i8, z(j, obj));
                    }
                    break;
                case 55:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.v(i8, y(j, obj));
                    }
                    break;
                case 56:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.t(i8, z(j, obj));
                    }
                    break;
                case 57:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.r(i8, y(j, obj));
                    }
                    break;
                case 58:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.o(i8, ((Boolean) xm4.h(obj, j)).booleanValue());
                    }
                    break;
                case 59:
                    if (sl2Var.q(i8, i6, obj)) {
                        Object object3 = unsafe.getObject(obj, j);
                        if (object3 instanceof String) {
                            r60Var.z(i8, (String) object3);
                        } else {
                            r60Var.p(i8, (au) object3);
                        }
                    }
                    break;
                case 60:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.y(i8, (d1) unsafe.getObject(obj, j), sl2Var.m(i6));
                    }
                    break;
                case 61:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.p(i8, (au) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.C(i8, y(j, obj));
                    }
                    break;
                case 63:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.v(i8, y(j, obj));
                    }
                    break;
                case 64:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.r(i8, y(j, obj));
                    }
                    break;
                case 65:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.t(i8, z(j, obj));
                    }
                    break;
                case 66:
                    if (sl2Var.q(i8, i6, obj)) {
                        int iY = y(j, obj);
                        r60Var.C(i8, (iY >> 31) ^ (iY << 1));
                    }
                    break;
                case 67:
                    if (sl2Var.q(i8, i6, obj)) {
                        long jZ = z(j, obj);
                        r60Var.E(i8, (jZ << i) ^ (jZ >> 63));
                    }
                    break;
                case 68:
                    if (sl2Var.q(i8, i6, obj)) {
                        zf2Var.r0(i8, unsafe.getObject(obj, j), sl2Var.m(i6));
                    }
                    break;
            }
            i6 += 3;
            i4 = 1048575;
        }
        sl2Var.l.getClass();
        ((co1) obj).unknownFields.d(zf2Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e(co1 co1Var, co1 co1Var2) {
        int[] iArr = this.a;
        int length = iArr.length;
        int i = 0;
        while (true) {
            boolean zL = true;
            if (i < length) {
                int iJ = J(i);
                long j = iJ & 1048575;
                switch (I(iJ)) {
                    case 0:
                        if (j(co1Var, co1Var2, i)) {
                            vm4 vm4Var = xm4.c;
                            if (Double.doubleToLongBits(vm4Var.c(j, co1Var)) != Double.doubleToLongBits(vm4Var.c(j, co1Var2))) {
                                zL = false;
                            }
                            break;
                        }
                        break;
                    case 1:
                        if (j(co1Var, co1Var2, i)) {
                            vm4 vm4Var2 = xm4.c;
                            if (Float.floatToIntBits(vm4Var2.d(j, co1Var)) != Float.floatToIntBits(vm4Var2.d(j, co1Var2))) {
                            }
                        }
                        break;
                    case 2:
                        if (!j(co1Var, co1Var2, i) || xm4.g(co1Var, j) != xm4.g(co1Var2, j)) {
                        }
                        break;
                    case 3:
                        if (!j(co1Var, co1Var2, i) || xm4.g(co1Var, j) != xm4.g(co1Var2, j)) {
                        }
                        break;
                    case 4:
                        if (!j(co1Var, co1Var2, i) || xm4.f(co1Var, j) != xm4.f(co1Var2, j)) {
                        }
                        break;
                    case 5:
                        if (!j(co1Var, co1Var2, i) || xm4.g(co1Var, j) != xm4.g(co1Var2, j)) {
                        }
                        break;
                    case 6:
                        if (!j(co1Var, co1Var2, i) || xm4.f(co1Var, j) != xm4.f(co1Var2, j)) {
                        }
                        break;
                    case 7:
                        if (j(co1Var, co1Var2, i)) {
                            vm4 vm4Var3 = xm4.c;
                            if (vm4Var3.a(j, co1Var) != vm4Var3.a(j, co1Var2)) {
                            }
                        }
                        break;
                    case 8:
                        if (!j(co1Var, co1Var2, i) || !hq3.l(xm4.h(co1Var, j), xm4.h(co1Var2, j))) {
                        }
                        break;
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                        if (!j(co1Var, co1Var2, i) || !hq3.l(xm4.h(co1Var, j), xm4.h(co1Var2, j))) {
                        }
                        break;
                    case 10:
                        if (!j(co1Var, co1Var2, i) || !hq3.l(xm4.h(co1Var, j), xm4.h(co1Var2, j))) {
                        }
                        break;
                    case 11:
                        if (!j(co1Var, co1Var2, i) || xm4.f(co1Var, j) != xm4.f(co1Var2, j)) {
                        }
                        break;
                    case FileClientSessionCache.MAX_SIZE /* 12 */:
                        if (!j(co1Var, co1Var2, i) || xm4.f(co1Var, j) != xm4.f(co1Var2, j)) {
                        }
                        break;
                    case 13:
                        if (!j(co1Var, co1Var2, i) || xm4.f(co1Var, j) != xm4.f(co1Var2, j)) {
                        }
                        break;
                    case 14:
                        if (!j(co1Var, co1Var2, i) || xm4.g(co1Var, j) != xm4.g(co1Var2, j)) {
                        }
                        break;
                    case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                        if (!j(co1Var, co1Var2, i) || xm4.f(co1Var, j) != xm4.f(co1Var2, j)) {
                        }
                        break;
                    case 16:
                        if (!j(co1Var, co1Var2, i) || xm4.g(co1Var, j) != xm4.g(co1Var2, j)) {
                        }
                        break;
                    case 17:
                        if (!j(co1Var, co1Var2, i) || !hq3.l(xm4.h(co1Var, j), xm4.h(co1Var2, j))) {
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                    case 49:
                        zL = hq3.l(xm4.h(co1Var, j), xm4.h(co1Var2, j));
                        break;
                    case 50:
                        zL = hq3.l(xm4.h(co1Var, j), xm4.h(co1Var2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long j2 = iArr[i + 2] & 1048575;
                        if (xm4.f(co1Var, j2) != xm4.f(co1Var2, j2) || !hq3.l(xm4.h(co1Var, j), xm4.h(co1Var2, j))) {
                        }
                        break;
                }
                if (zL) {
                    i += 3;
                }
            } else {
                this.l.getClass();
                if (co1Var.unknownFields.equals(co1Var2.unknownFields)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7 A[PHI: r3
      0x00d7: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x01f0, B:41:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int f(co1 co1Var) {
        int i;
        int iB;
        int i2;
        int[] iArr = this.a;
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iJ = J(i4);
            int i5 = iArr[i4];
            long j = 1048575 & iJ;
            int i6 = 1237;
            int iHashCode = 37;
            switch (I(iJ)) {
                case 0:
                    i = i3 * 53;
                    iB = j12.b(Double.doubleToLongBits(xm4.c.c(j, co1Var)));
                    i3 = iB + i;
                    break;
                case 1:
                    i = i3 * 53;
                    iB = Float.floatToIntBits(xm4.c.d(j, co1Var));
                    i3 = iB + i;
                    break;
                case 2:
                    i = i3 * 53;
                    iB = j12.b(xm4.g(co1Var, j));
                    i3 = iB + i;
                    break;
                case 3:
                    i = i3 * 53;
                    iB = j12.b(xm4.g(co1Var, j));
                    i3 = iB + i;
                    break;
                case 4:
                    i = i3 * 53;
                    iB = xm4.f(co1Var, j);
                    i3 = iB + i;
                    break;
                case 5:
                    i = i3 * 53;
                    iB = j12.b(xm4.g(co1Var, j));
                    i3 = iB + i;
                    break;
                case 6:
                    i = i3 * 53;
                    iB = xm4.f(co1Var, j);
                    i3 = iB + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    boolean zA = xm4.c.a(j, co1Var);
                    Charset charset = j12.a;
                    if (zA) {
                        i6 = 1231;
                    }
                    i3 = i6 + i2;
                    break;
                case 8:
                    i = i3 * 53;
                    iB = ((String) xm4.h(co1Var, j)).hashCode();
                    i3 = iB + i;
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    Object objH = xm4.h(co1Var, j);
                    if (objH != null) {
                        iHashCode = objH.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iB = xm4.h(co1Var, j).hashCode();
                    i3 = iB + i;
                    break;
                case 11:
                    i = i3 * 53;
                    iB = xm4.f(co1Var, j);
                    i3 = iB + i;
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    i = i3 * 53;
                    iB = xm4.f(co1Var, j);
                    i3 = iB + i;
                    break;
                case 13:
                    i = i3 * 53;
                    iB = xm4.f(co1Var, j);
                    i3 = iB + i;
                    break;
                case 14:
                    i = i3 * 53;
                    iB = j12.b(xm4.g(co1Var, j));
                    i3 = iB + i;
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    i = i3 * 53;
                    iB = xm4.f(co1Var, j);
                    i3 = iB + i;
                    break;
                case 16:
                    i = i3 * 53;
                    iB = j12.b(xm4.g(co1Var, j));
                    i3 = iB + i;
                    break;
                case 17:
                    Object objH2 = xm4.h(co1Var, j);
                    if (objH2 != null) {
                        iHashCode = objH2.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                case 49:
                    i = i3 * 53;
                    iB = xm4.h(co1Var, j).hashCode();
                    i3 = iB + i;
                    break;
                case 50:
                    i = i3 * 53;
                    iB = xm4.h(co1Var, j).hashCode();
                    i3 = iB + i;
                    break;
                case 51:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = j12.b(Double.doubleToLongBits(((Double) xm4.h(co1Var, j)).doubleValue()));
                        i3 = iB + i;
                    }
                    break;
                case 52:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = Float.floatToIntBits(((Float) xm4.h(co1Var, j)).floatValue());
                        i3 = iB + i;
                    }
                    break;
                case 53:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = j12.b(z(j, co1Var));
                        i3 = iB + i;
                    }
                    break;
                case 54:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = j12.b(z(j, co1Var));
                        i3 = iB + i;
                    }
                    break;
                case 55:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = y(j, co1Var);
                        i3 = iB + i;
                    }
                    break;
                case 56:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = j12.b(z(j, co1Var));
                        i3 = iB + i;
                    }
                    break;
                case 57:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = y(j, co1Var);
                        i3 = iB + i;
                    }
                    break;
                case 58:
                    if (q(i5, i4, co1Var)) {
                        i2 = i3 * 53;
                        boolean zBooleanValue = ((Boolean) xm4.h(co1Var, j)).booleanValue();
                        Charset charset2 = j12.a;
                        if (zBooleanValue) {
                        }
                        i3 = i6 + i2;
                    }
                    break;
                case 59:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = ((String) xm4.h(co1Var, j)).hashCode();
                        i3 = iB + i;
                    }
                    break;
                case 60:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = xm4.h(co1Var, j).hashCode();
                        i3 = iB + i;
                    }
                    break;
                case 61:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = xm4.h(co1Var, j).hashCode();
                        i3 = iB + i;
                    }
                    break;
                case 62:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = y(j, co1Var);
                        i3 = iB + i;
                    }
                    break;
                case 63:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = y(j, co1Var);
                        i3 = iB + i;
                    }
                    break;
                case 64:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = y(j, co1Var);
                        i3 = iB + i;
                    }
                    break;
                case 65:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = j12.b(z(j, co1Var));
                        i3 = iB + i;
                    }
                    break;
                case 66:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = y(j, co1Var);
                        i3 = iB + i;
                    }
                    break;
                case 67:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = j12.b(z(j, co1Var));
                        i3 = iB + i;
                    }
                    break;
                case 68:
                    if (q(i5, i4, co1Var)) {
                        i = i3 * 53;
                        iB = xm4.h(co1Var, j).hashCode();
                        i3 = iB + i;
                    }
                    break;
            }
        }
        this.l.getClass();
        return co1Var.unknownFields.hashCode() + (i3 * 53);
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x01cd  */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int g(co1 co1Var) {
        int i;
        int iH;
        int iH2;
        int iH3;
        int iJ;
        int iH4;
        int iJ2;
        int iH5;
        int iH6;
        int iH7;
        int iA;
        int i2;
        int iF;
        int iH8;
        int iA2;
        int iC;
        int size;
        int i3;
        int iH9;
        int iH10;
        int iH11;
        int size2;
        int iH12;
        int i4;
        int iA3;
        int iH13;
        int iH14;
        int iJ3;
        int iH15;
        int iJ4;
        int i5;
        sl2 sl2Var = this;
        co1 co1Var2 = co1Var;
        int i6 = 0;
        int i7 = 0;
        int iF2 = 0;
        int i8 = 1048575;
        while (true) {
            int[] iArr = sl2Var.a;
            if (i6 >= iArr.length) {
                sl2Var.l.getClass();
                return co1Var2.unknownFields.b() + iF2;
            }
            int iJ5 = sl2Var.J(i6);
            int I = I(iJ5);
            int i9 = iArr[i6];
            int i10 = iArr[i6 + 2];
            int i11 = i10 & 1048575;
            Unsafe unsafe = o;
            if (I <= 17) {
                if (i11 != i8) {
                    i7 = i11 == 1048575 ? 0 : unsafe.getInt(co1Var2, i11);
                    i8 = i11;
                }
                i = 1 << (i10 >>> 20);
            } else {
                i = 0;
            }
            long j = iJ5 & 1048575;
            if (I >= md1.f.b) {
                int i12 = md1.z.b;
            }
            switch (I) {
                case 0:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        iH = r60.h(i9);
                        iC = iH + 8;
                        iF2 += iC;
                    }
                    break;
                case 1:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        iH2 = r60.h(i9);
                        iH6 = iH2 + 4;
                        iF2 += iH6;
                    }
                    sl2Var = this;
                    co1Var2 = co1Var;
                    break;
                case 2:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        long j2 = unsafe.getLong(co1Var2, j);
                        iH3 = r60.h(i9);
                        iJ = r60.j(j2);
                        iF2 += iJ + iH3;
                    }
                    sl2Var = this;
                    break;
                case 3:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        long j3 = unsafe.getLong(co1Var2, j);
                        iH3 = r60.h(i9);
                        iJ = r60.j(j3);
                        iF2 += iJ + iH3;
                    }
                    sl2Var = this;
                    break;
                case 4:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        int i13 = unsafe.getInt(co1Var2, j);
                        iH4 = r60.h(i9);
                        iJ2 = r60.j(i13);
                        iF = iJ2 + iH4;
                        iF2 += iF;
                    }
                    sl2Var = this;
                    break;
                case 5:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        iH5 = r60.h(i9);
                        iH6 = iH5 + 8;
                        iF2 += iH6;
                    }
                    sl2Var = this;
                    co1Var2 = co1Var;
                    break;
                case 6:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        iH2 = r60.h(i9);
                        iH6 = iH2 + 4;
                        iF2 += iH6;
                    }
                    sl2Var = this;
                    co1Var2 = co1Var;
                    break;
                case 7:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        iH6 = r60.h(i9) + 1;
                        iF2 += iH6;
                    }
                    sl2Var = this;
                    co1Var2 = co1Var;
                    break;
                case 8:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        Object object = unsafe.getObject(co1Var2, j);
                        iF2 = (object instanceof au ? r60.f(i9, (au) object) : r60.g((String) object) + r60.h(i9)) + iF2;
                    }
                    sl2Var = this;
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        Object object2 = unsafe.getObject(co1Var2, j);
                        gq3 gq3VarM = sl2Var.m(i6);
                        Class cls = hq3.a;
                        iH7 = r60.h(i9);
                        iA = ((d1) object2).a(gq3VarM);
                        i2 = r60.i(iA);
                        i5 = i2 + iA + iH7;
                        iF2 += i5;
                    }
                    break;
                case 10:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        iF = r60.f(i9, (au) unsafe.getObject(co1Var2, j));
                        iF2 += iF;
                    }
                    sl2Var = this;
                    break;
                case 11:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        int i14 = unsafe.getInt(co1Var2, j);
                        iH4 = r60.h(i9);
                        iJ2 = r60.i(i14);
                        iF = iJ2 + iH4;
                        iF2 += iF;
                    }
                    sl2Var = this;
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        int i15 = unsafe.getInt(co1Var2, j);
                        iH4 = r60.h(i9);
                        iJ2 = r60.j(i15);
                        iF = iJ2 + iH4;
                        iF2 += iF;
                    }
                    sl2Var = this;
                    break;
                case 13:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        iH2 = r60.h(i9);
                        iH6 = iH2 + 4;
                        iF2 += iH6;
                    }
                    sl2Var = this;
                    co1Var2 = co1Var;
                    break;
                case 14:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        iH5 = r60.h(i9);
                        iH6 = iH5 + 8;
                        iF2 += iH6;
                    }
                    sl2Var = this;
                    co1Var2 = co1Var;
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        int i16 = unsafe.getInt(co1Var2, j);
                        iH4 = r60.h(i9);
                        iJ2 = r60.i((i16 >> 31) ^ (i16 << 1));
                        iF = iJ2 + iH4;
                        iF2 += iF;
                    }
                    sl2Var = this;
                    break;
                case 16:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        long j4 = unsafe.getLong(co1Var2, j);
                        iH3 = r60.h(i9);
                        iJ = r60.j((j4 << 1) ^ (j4 >> 63));
                        iF2 += iJ + iH3;
                    }
                    sl2Var = this;
                    break;
                case 17:
                    if (sl2Var.o(co1Var2, i6, i8, i7, i)) {
                        d1 d1Var = (d1) unsafe.getObject(co1Var2, j);
                        gq3 gq3VarM2 = sl2Var.m(i6);
                        iH8 = r60.h(i9) * 2;
                        iA2 = d1Var.a(gq3VarM2);
                        iC = iA2 + iH8;
                        iF2 += iC;
                    }
                    break;
                case 18:
                    iC = hq3.c(i9, (List) unsafe.getObject(co1Var2, j));
                    iF2 += iC;
                    break;
                case 19:
                    iC = hq3.b(i9, (List) unsafe.getObject(co1Var2, j));
                    iF2 += iC;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(co1Var2, j);
                    Class cls2 = hq3.a;
                    iH10 = list.size() == 0 ? 0 : (r60.h(i9) * list.size()) + hq3.e(list);
                    iF2 += iH10;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(co1Var2, j);
                    Class cls3 = hq3.a;
                    size = list2.size();
                    if (size != 0) {
                        i3 = hq3.i(list2);
                        iH9 = r60.h(i9);
                        iH10 = (iH9 * size) + i3;
                        iF2 += iH10;
                    }
                    iF2 += iH10;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(co1Var2, j);
                    Class cls4 = hq3.a;
                    size = list3.size();
                    if (size != 0) {
                        i3 = hq3.d(list3);
                        iH9 = r60.h(i9);
                        iH10 = (iH9 * size) + i3;
                        iF2 += iH10;
                    }
                    iF2 += iH10;
                    break;
                case 23:
                    iC = hq3.c(i9, (List) unsafe.getObject(co1Var2, j));
                    iF2 += iC;
                    break;
                case 24:
                    iC = hq3.b(i9, (List) unsafe.getObject(co1Var2, j));
                    iF2 += iC;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(co1Var2, j);
                    Class cls5 = hq3.a;
                    int size3 = list4.size();
                    iF2 += size3 == 0 ? 0 : (r60.h(i9) + 1) * size3;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(co1Var2, j);
                    Class cls6 = hq3.a;
                    int size4 = list5.size();
                    if (size4 != 0) {
                        iH10 = r60.h(i9) * size4;
                        for (int i17 = 0; i17 < size4; i17++) {
                            Object obj = list5.get(i17);
                            if (obj instanceof au) {
                                int size5 = ((au) obj).size();
                                iH10 = r60.i(size5) + size5 + iH10;
                            } else {
                                iH10 = r60.g((String) obj) + iH10;
                            }
                        }
                    }
                    iF2 += iH10;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(co1Var2, j);
                    gq3 gq3VarM3 = sl2Var.m(i6);
                    Class cls7 = hq3.a;
                    int size6 = list6.size();
                    if (size6 == 0) {
                        iH11 = 0;
                    } else {
                        iH11 = r60.h(i9) * size6;
                        for (int i18 = 0; i18 < size6; i18++) {
                            int iA4 = ((d1) list6.get(i18)).a(gq3VarM3);
                            iH11 += r60.i(iA4) + iA4;
                        }
                    }
                    iF2 += iH11;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(co1Var2, j);
                    Class cls8 = hq3.a;
                    int size7 = list7.size();
                    if (size7 != 0) {
                        iH10 = r60.h(i9) * size7;
                        for (int i19 = 0; i19 < list7.size(); i19++) {
                            int size8 = ((au) list7.get(i19)).size();
                            iH10 += r60.i(size8) + size8;
                        }
                    }
                    iF2 += iH10;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(co1Var2, j);
                    Class cls9 = hq3.a;
                    size = list8.size();
                    if (size != 0) {
                        i3 = hq3.h(list8);
                        iH9 = r60.h(i9);
                        iH10 = (iH9 * size) + i3;
                        iF2 += iH10;
                    }
                    iF2 += iH10;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(co1Var2, j);
                    Class cls10 = hq3.a;
                    size = list9.size();
                    if (size != 0) {
                        i3 = hq3.a(list9);
                        iH9 = r60.h(i9);
                        iH10 = (iH9 * size) + i3;
                        iF2 += iH10;
                    }
                    iF2 += iH10;
                    break;
                case 31:
                    iC = hq3.b(i9, (List) unsafe.getObject(co1Var2, j));
                    iF2 += iC;
                    break;
                case 32:
                    iC = hq3.c(i9, (List) unsafe.getObject(co1Var2, j));
                    iF2 += iC;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(co1Var2, j);
                    Class cls11 = hq3.a;
                    size = list10.size();
                    if (size != 0) {
                        i3 = hq3.f(list10);
                        iH9 = r60.h(i9);
                        iH10 = (iH9 * size) + i3;
                        iF2 += iH10;
                    }
                    iF2 += iH10;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(co1Var2, j);
                    Class cls12 = hq3.a;
                    size = list11.size();
                    if (size != 0) {
                        i3 = hq3.g(list11);
                        iH9 = r60.h(i9);
                        iH10 = (iH9 * size) + i3;
                        iF2 += iH10;
                    }
                    iF2 += iH10;
                    break;
                case 35:
                    List list12 = (List) unsafe.getObject(co1Var2, j);
                    Class cls13 = hq3.a;
                    size2 = list12.size() * 8;
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 36:
                    List list13 = (List) unsafe.getObject(co1Var2, j);
                    Class cls14 = hq3.a;
                    size2 = list13.size() * 4;
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 37:
                    size2 = hq3.e((List) unsafe.getObject(co1Var2, j));
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 38:
                    size2 = hq3.i((List) unsafe.getObject(co1Var2, j));
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 39:
                    size2 = hq3.d((List) unsafe.getObject(co1Var2, j));
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 40:
                    List list14 = (List) unsafe.getObject(co1Var2, j);
                    Class cls15 = hq3.a;
                    size2 = list14.size() * 8;
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 41:
                    List list15 = (List) unsafe.getObject(co1Var2, j);
                    Class cls16 = hq3.a;
                    size2 = list15.size() * 4;
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 42:
                    List list16 = (List) unsafe.getObject(co1Var2, j);
                    Class cls17 = hq3.a;
                    size2 = list16.size();
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 43:
                    size2 = hq3.h((List) unsafe.getObject(co1Var2, j));
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 44:
                    size2 = hq3.a((List) unsafe.getObject(co1Var2, j));
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 45:
                    List list17 = (List) unsafe.getObject(co1Var2, j);
                    Class cls18 = hq3.a;
                    size2 = list17.size() * 4;
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 46:
                    List list18 = (List) unsafe.getObject(co1Var2, j);
                    Class cls19 = hq3.a;
                    size2 = list18.size() * 8;
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 47:
                    size2 = hq3.f((List) unsafe.getObject(co1Var2, j));
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                    size2 = hq3.g((List) unsafe.getObject(co1Var2, j));
                    if (size2 > 0) {
                        iH12 = r60.h(i9);
                        i4 = r60.i(size2);
                        iF2 += i4 + iH12 + size2;
                    }
                    break;
                case 49:
                    List list19 = (List) unsafe.getObject(co1Var2, j);
                    gq3 gq3VarM4 = sl2Var.m(i6);
                    Class cls20 = hq3.a;
                    int size9 = list19.size();
                    if (size9 == 0) {
                        iA3 = 0;
                    } else {
                        iA3 = 0;
                        for (int i20 = 0; i20 < size9; i20++) {
                            iA3 += ((d1) list19.get(i20)).a(gq3VarM4) + (r60.h(i9) * 2);
                        }
                    }
                    iF2 += iA3;
                    break;
                case 50:
                    Object object3 = unsafe.getObject(co1Var2, j);
                    Object obj2 = sl2Var.b[(i6 / 3) * 2];
                    sl2Var.m.getClass();
                    sg2 sg2Var = (sg2) object3;
                    jg2 jg2Var = (jg2) obj2;
                    if (!sg2Var.isEmpty()) {
                        iH10 = 0;
                        for (Map.Entry entry : sg2Var.entrySet()) {
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            jg2Var.getClass();
                            int iH16 = r60.h(i9);
                            int iA5 = jg2.a(jg2Var.a, key, value);
                            iH10 += r60.i(iA5) + iA5 + iH16;
                        }
                    }
                    iF2 += iH10;
                    break;
                case 51:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        iH = r60.h(i9);
                        iC = iH + 8;
                        iF2 += iC;
                    }
                    break;
                case 52:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        iH13 = r60.h(i9);
                        iC = iH13 + 4;
                        iF2 += iC;
                    }
                    break;
                case 53:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        long jZ = z(j, co1Var2);
                        iH14 = r60.h(i9);
                        iJ3 = r60.j(jZ);
                        i5 = iJ3 + iH14;
                        iF2 += i5;
                    }
                    break;
                case 54:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        long jZ2 = z(j, co1Var2);
                        iH14 = r60.h(i9);
                        iJ3 = r60.j(jZ2);
                        i5 = iJ3 + iH14;
                        iF2 += i5;
                    }
                    break;
                case 55:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        int iY = y(j, co1Var2);
                        iH15 = r60.h(i9);
                        iJ4 = r60.j(iY);
                        iC = iJ4 + iH15;
                        iF2 += iC;
                    }
                    break;
                case 56:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        iH = r60.h(i9);
                        iC = iH + 8;
                        iF2 += iC;
                    }
                    break;
                case 57:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        iH13 = r60.h(i9);
                        iC = iH13 + 4;
                        iF2 += iC;
                    }
                    break;
                case 58:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        iC = r60.h(i9) + 1;
                        iF2 += iC;
                    }
                    break;
                case 59:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        Object object4 = unsafe.getObject(co1Var2, j);
                        iF2 = (object4 instanceof au ? r60.f(i9, (au) object4) : r60.g((String) object4) + r60.h(i9)) + iF2;
                    }
                    break;
                case 60:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        Object object5 = unsafe.getObject(co1Var2, j);
                        gq3 gq3VarM5 = sl2Var.m(i6);
                        Class cls21 = hq3.a;
                        iH7 = r60.h(i9);
                        iA = ((d1) object5).a(gq3VarM5);
                        i2 = r60.i(iA);
                        i5 = i2 + iA + iH7;
                        iF2 += i5;
                    }
                    break;
                case 61:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        iC = r60.f(i9, (au) unsafe.getObject(co1Var2, j));
                        iF2 += iC;
                    }
                    break;
                case 62:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        int iY2 = y(j, co1Var2);
                        iH15 = r60.h(i9);
                        iJ4 = r60.i(iY2);
                        iC = iJ4 + iH15;
                        iF2 += iC;
                    }
                    break;
                case 63:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        int iY3 = y(j, co1Var2);
                        iH15 = r60.h(i9);
                        iJ4 = r60.j(iY3);
                        iC = iJ4 + iH15;
                        iF2 += iC;
                    }
                    break;
                case 64:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        iH13 = r60.h(i9);
                        iC = iH13 + 4;
                        iF2 += iC;
                    }
                    break;
                case 65:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        iH = r60.h(i9);
                        iC = iH + 8;
                        iF2 += iC;
                    }
                    break;
                case 66:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        int iY4 = y(j, co1Var2);
                        iH15 = r60.h(i9);
                        iJ4 = r60.i((iY4 >> 31) ^ (iY4 << 1));
                        iC = iJ4 + iH15;
                        iF2 += iC;
                    }
                    break;
                case 67:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        long jZ3 = z(j, co1Var2);
                        iH14 = r60.h(i9);
                        iJ3 = r60.j((jZ3 << 1) ^ (jZ3 >> 63));
                        i5 = iJ3 + iH14;
                        iF2 += i5;
                    }
                    break;
                case 68:
                    if (sl2Var.q(i9, i6, co1Var2)) {
                        d1 d1Var2 = (d1) unsafe.getObject(co1Var2, j);
                        gq3 gq3VarM6 = sl2Var.m(i6);
                        iH8 = r60.h(i9) * 2;
                        iA2 = d1Var2.a(gq3VarM6);
                        iC = iA2 + iH8;
                        iF2 += iC;
                    }
                    break;
            }
            i6 += 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x082a A[Catch: all -> 0x0500, TryCatch #1 {all -> 0x0500, blocks: (B:158:0x0825, B:160:0x082a, B:161:0x082f, B:114:0x04fb, B:117:0x0503, B:118:0x051b, B:119:0x0533, B:120:0x054b, B:121:0x0563, B:122:0x057b, B:123:0x0593, B:124:0x05ab, B:125:0x05c3, B:126:0x05eb, B:127:0x060b, B:128:0x062b, B:129:0x064c, B:130:0x066d, B:131:0x0690, B:132:0x06b0, B:133:0x06c9, B:134:0x06f1, B:135:0x0702, B:136:0x0724, B:137:0x0745, B:138:0x0766, B:139:0x0786, B:140:0x07a6, B:141:0x07c5, B:142:0x07e7, B:148:0x0809), top: B:181:0x0825 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0850 A[LOOP:3: B:170:0x084e->B:171:0x0850, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x085a  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0835 A[SYNTHETIC] */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(Object obj, r02 r02Var, p91 p91Var) throws Throwable {
        sl2 sl2Var;
        int[] iArr;
        int i;
        int i2;
        r02 r02Var2;
        p91 p91Var2;
        int I;
        Unsafe unsafe;
        wb2 wb2Var;
        sl2 sl2Var2 = this;
        Object obj2 = obj;
        r02 r02Var3 = r02Var;
        p91 p91Var3 = p91Var;
        p91Var3.getClass();
        if (!p(obj2)) {
            vp1.h(obj2, "Mutating immutable message: ");
            return;
        }
        em4 em4Var = sl2Var2.l;
        int[] iArr2 = sl2Var2.g;
        int i3 = sl2Var2.i;
        int i4 = sl2Var2.h;
        dm4 dm4VarA = null;
        while (true) {
            try {
                int iF = r02Var3.f();
                int iA = sl2Var2.A(iF);
                if (iA >= 0) {
                    int iJ = sl2Var2.J(iA);
                    try {
                        try {
                            I = I(iJ);
                            unsafe = o;
                            wb2Var = sl2Var2.k;
                        } catch (r12 unused) {
                            sl2Var = sl2Var2;
                            iArr = iArr2;
                            i2 = i3;
                        }
                        switch (I) {
                            case 0:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX = x(iJ);
                                r02Var2.C(1);
                                try {
                                    try {
                                        xm4.c.g(obj, jX, ((p60) r02Var2.d).h());
                                        obj2 = obj;
                                        sl2Var.G(iA, obj2);
                                    } catch (r12 unused2) {
                                        obj2 = obj;
                                        try {
                                            em4Var.getClass();
                                            if (dm4VarA == null) {
                                            }
                                            if (!em4.b(0, r02Var2, dm4VarA)) {
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            i = i2;
                                            while (i4 < i) {
                                                sl2Var.k(iArr[i4], obj2, dm4VarA);
                                                i4++;
                                            }
                                            if (dm4VarA != null) {
                                                em4Var.getClass();
                                                ((co1) obj2).unknownFields = dm4VarA;
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        obj2 = obj;
                                        i = i2;
                                        while (i4 < i) {
                                        }
                                        if (dm4VarA != null) {
                                        }
                                        throw th;
                                    }
                                } catch (r12 unused3) {
                                    obj2 = obj;
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj2 = obj;
                                }
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 1:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX2 = x(iJ);
                                r02Var2.C(5);
                                xm4.c.h(obj2, jX2, ((p60) r02Var2.d).l());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 2:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX3 = x(iJ);
                                r02Var2.C(0);
                                xm4.n(obj2, jX3, ((p60) r02Var2.d).n());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 3:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX4 = x(iJ);
                                r02Var2.C(0);
                                xm4.n(obj2, jX4, ((p60) r02Var2.d).w());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 4:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX5 = x(iJ);
                                r02Var2.C(0);
                                xm4.m(obj2, jX5, ((p60) r02Var2.d).m());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 5:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX6 = x(iJ);
                                r02Var2.C(1);
                                xm4.n(obj2, jX6, ((p60) r02Var2.d).k());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 6:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX7 = x(iJ);
                                r02Var2.C(5);
                                xm4.m(obj2, jX7, ((p60) r02Var2.d).j());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 7:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX8 = x(iJ);
                                r02Var2.C(0);
                                xm4.c.e(obj2, jX8, ((p60) r02Var2.d).f());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 8:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                sl2Var.D(iJ, r02Var2, obj2);
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                                sl2Var = sl2Var2;
                                iArr = iArr2;
                                i2 = i3;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                d1 d1Var = (d1) sl2Var.u(iA, obj2);
                                gq3 gq3VarM = sl2Var.m(iA);
                                r02Var2.C(2);
                                r02Var2.h(d1Var, gq3VarM, p91Var2);
                                unsafe.putObject(obj2, sl2Var.J(iA) & 1048575, d1Var);
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 10:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                xm4.o(obj2, x(iJ), r02Var2.j());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 11:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX9 = x(iJ);
                                r02Var2.C(0);
                                xm4.m(obj2, jX9, ((p60) r02Var2.d).v());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case FileClientSessionCache.MAX_SIZE /* 12 */:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var2.C(0);
                                int i5 = ((p60) r02Var2.d).i();
                                sl2Var.l(iA);
                                xm4.m(obj2, x(iJ), i5);
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 13:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX10 = x(iJ);
                                r02Var2.C(5);
                                xm4.m(obj2, jX10, ((p60) r02Var2.d).o());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 14:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX11 = x(iJ);
                                r02Var2.C(1);
                                xm4.n(obj2, jX11, ((p60) r02Var2.d).p());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX12 = x(iJ);
                                r02Var2.C(0);
                                xm4.m(obj2, jX12, ((p60) r02Var2.d).q());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 16:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX13 = x(iJ);
                                r02Var2.C(0);
                                xm4.n(obj2, jX13, ((p60) r02Var2.d).r());
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 17:
                                sl2Var = sl2Var2;
                                iArr = iArr2;
                                i2 = i3;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                d1 d1Var2 = (d1) sl2Var.u(iA, obj2);
                                gq3 gq3VarM2 = sl2Var.m(iA);
                                r02Var2.C(3);
                                r02Var2.g(d1Var2, gq3VarM2, p91Var2);
                                unsafe.putObject(obj2, sl2Var.J(iA) & 1048575, d1Var2);
                                sl2Var.G(iA, obj2);
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 18:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX14 = x(iJ);
                                wb2Var.getClass();
                                r02Var2.l(wb2.a(jX14, obj2));
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 19:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX15 = x(iJ);
                                wb2Var.getClass();
                                r02Var2.q(wb2.a(jX15, obj2));
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 20:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX16 = x(iJ);
                                wb2Var.getClass();
                                r02Var2.s(wb2.a(jX16, obj2));
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 21:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX17 = x(iJ);
                                wb2Var.getClass();
                                r02Var2.z(wb2.a(jX17, obj2));
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 22:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX18 = x(iJ);
                                wb2Var.getClass();
                                r02Var2.r(wb2.a(jX18, obj2));
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 23:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX19 = x(iJ);
                                wb2Var.getClass();
                                r02Var2.p(wb2.a(jX19, obj2));
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 24:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX20 = x(iJ);
                                wb2Var.getClass();
                                r02Var2.o(wb2.a(jX20, obj2));
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 25:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                long jX21 = x(iJ);
                                wb2Var.getClass();
                                r02Var2.i(wb2.a(jX21, obj2));
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 26:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                try {
                                    sl2Var.E(iJ, r02Var2, obj2);
                                } catch (r12 unused4) {
                                    em4Var.getClass();
                                    if (dm4VarA == null) {
                                        dm4VarA = em4.a(obj2);
                                    }
                                    if (!em4.b(0, r02Var2, dm4VarA)) {
                                        int i6 = i2;
                                        while (i4 < i6) {
                                            sl2Var.k(iArr[i4], obj2, dm4VarA);
                                            i4++;
                                        }
                                        if (dm4VarA == null) {
                                            return;
                                        }
                                        ((co1) obj2).unknownFields = dm4VarA;
                                        return;
                                    }
                                }
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 27:
                                iArr = iArr2;
                                i2 = i3;
                                try {
                                    sl2Var2.C(obj2, iJ, r02Var3, sl2Var2.m(iA), p91Var);
                                    r02Var2 = r02Var3;
                                    p91Var2 = p91Var;
                                    sl2Var = sl2Var2;
                                } catch (r12 unused5) {
                                    r02Var2 = r02Var3;
                                    p91Var2 = p91Var;
                                    sl2Var = sl2Var2;
                                    em4Var.getClass();
                                    if (dm4VarA == null) {
                                    }
                                    if (!em4.b(0, r02Var2, dm4VarA)) {
                                    }
                                }
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 28:
                                iArr = iArr2;
                                i2 = i3;
                                long jX22 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.k(wb2.a(jX22, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 29:
                                iArr = iArr2;
                                i2 = i3;
                                long jX23 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.y(wb2.a(jX23, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 30:
                                iArr = iArr2;
                                i2 = i3;
                                long jX24 = x(iJ);
                                wb2Var.getClass();
                                h12 h12VarA = wb2.a(jX24, obj2);
                                r02Var3.m(h12VarA);
                                sl2Var2.l(iA);
                                hq3.j(obj2, iF, h12VarA, dm4VarA, em4Var);
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 31:
                                iArr = iArr2;
                                i2 = i3;
                                long jX25 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.t(wb2.a(jX25, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 32:
                                iArr = iArr2;
                                i2 = i3;
                                long jX26 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.u(wb2.a(jX26, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 33:
                                iArr = iArr2;
                                i2 = i3;
                                long jX27 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.v(wb2.a(jX27, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 34:
                                iArr = iArr2;
                                i2 = i3;
                                long jX28 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.w(wb2.a(jX28, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 35:
                                iArr = iArr2;
                                i2 = i3;
                                long jX29 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.l(wb2.a(jX29, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 36:
                                iArr = iArr2;
                                i2 = i3;
                                long jX30 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.q(wb2.a(jX30, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 37:
                                iArr = iArr2;
                                i2 = i3;
                                long jX31 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.s(wb2.a(jX31, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 38:
                                iArr = iArr2;
                                i2 = i3;
                                long jX32 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.z(wb2.a(jX32, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 39:
                                iArr = iArr2;
                                i2 = i3;
                                long jX33 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.r(wb2.a(jX33, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 40:
                                iArr = iArr2;
                                i2 = i3;
                                long jX34 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.p(wb2.a(jX34, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 41:
                                iArr = iArr2;
                                i2 = i3;
                                long jX35 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.o(wb2.a(jX35, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 42:
                                iArr = iArr2;
                                i2 = i3;
                                long jX36 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.i(wb2.a(jX36, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 43:
                                iArr = iArr2;
                                i2 = i3;
                                long jX37 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.y(wb2.a(jX37, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 44:
                                iArr = iArr2;
                                i2 = i3;
                                long jX38 = x(iJ);
                                wb2Var.getClass();
                                h12 h12VarA2 = wb2.a(jX38, obj2);
                                r02Var3.m(h12VarA2);
                                sl2Var2.l(iA);
                                hq3.j(obj2, iF, h12VarA2, dm4VarA, em4Var);
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 45:
                                iArr = iArr2;
                                i2 = i3;
                                long jX39 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.t(wb2.a(jX39, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 46:
                                iArr = iArr2;
                                i2 = i3;
                                long jX40 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.u(wb2.a(jX40, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 47:
                                iArr = iArr2;
                                i2 = i3;
                                long jX41 = x(iJ);
                                wb2Var.getClass();
                                r02Var3.v(wb2.a(jX41, obj2));
                                p91Var2 = p91Var;
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                                iArr = iArr2;
                                i2 = i3;
                                try {
                                    long jX42 = x(iJ);
                                    wb2Var.getClass();
                                    r02Var3.w(wb2.a(jX42, obj2));
                                    p91Var2 = p91Var;
                                    sl2Var = sl2Var2;
                                    r02Var2 = r02Var3;
                                } catch (r12 unused6) {
                                    p91Var2 = p91Var;
                                    sl2Var = sl2Var2;
                                    r02Var2 = r02Var3;
                                    em4Var.getClass();
                                    if (dm4VarA == null) {
                                    }
                                    if (!em4.b(0, r02Var2, dm4VarA)) {
                                    }
                                }
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 49:
                                iArr = iArr2;
                                i2 = i3;
                                obj2 = obj;
                                try {
                                    sl2Var2.B(obj2, x(iJ), r02Var, sl2Var2.m(iA), p91Var);
                                    r02Var3 = r02Var;
                                    p91Var2 = p91Var;
                                    sl2Var = sl2Var2;
                                    r02Var2 = r02Var3;
                                } catch (r12 unused7) {
                                    p91Var2 = p91Var;
                                    sl2Var = sl2Var2;
                                    r02Var2 = r02Var;
                                    em4Var.getClass();
                                    if (dm4VarA == null) {
                                    }
                                    if (!em4.b(0, r02Var2, dm4VarA)) {
                                    }
                                }
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 50:
                                iArr = iArr2;
                                i2 = i3;
                                try {
                                    sl2Var2.r(obj2, iA, sl2Var2.b[(iA / 3) * 2], p91Var3, r02Var3);
                                    obj2 = obj;
                                    r02Var2 = r02Var;
                                    p91Var2 = p91Var;
                                    sl2Var = sl2Var2;
                                    break;
                                } catch (r12 unused8) {
                                    obj2 = obj;
                                    r02Var2 = r02Var;
                                    p91Var2 = p91Var;
                                    sl2Var = sl2Var2;
                                    em4Var.getClass();
                                    if (dm4VarA == null) {
                                    }
                                    if (!em4.b(0, r02Var2, dm4VarA)) {
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj2 = obj;
                                    sl2Var = sl2Var2;
                                    i = i2;
                                    while (i4 < i) {
                                    }
                                    if (dm4VarA != null) {
                                    }
                                    throw th;
                                }
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 51:
                                iArr = iArr2;
                                i2 = i3;
                                long jX43 = x(iJ);
                                r02Var3.C(1);
                                xm4.o(obj2, jX43, Double.valueOf(((p60) r02Var3.d).h()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 52:
                                iArr = iArr2;
                                i2 = i3;
                                long jX44 = x(iJ);
                                r02Var3.C(5);
                                xm4.o(obj2, jX44, Float.valueOf(((p60) r02Var3.d).l()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 53:
                                iArr = iArr2;
                                i2 = i3;
                                long jX45 = x(iJ);
                                r02Var3.C(0);
                                xm4.o(obj2, jX45, Long.valueOf(((p60) r02Var3.d).n()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 54:
                                iArr = iArr2;
                                i2 = i3;
                                long jX46 = x(iJ);
                                r02Var3.C(0);
                                xm4.o(obj2, jX46, Long.valueOf(((p60) r02Var3.d).w()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 55:
                                iArr = iArr2;
                                i2 = i3;
                                long jX47 = x(iJ);
                                r02Var3.C(0);
                                xm4.o(obj2, jX47, Integer.valueOf(((p60) r02Var3.d).m()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 56:
                                iArr = iArr2;
                                i2 = i3;
                                long jX48 = x(iJ);
                                r02Var3.C(1);
                                xm4.o(obj2, jX48, Long.valueOf(((p60) r02Var3.d).k()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 57:
                                iArr = iArr2;
                                i2 = i3;
                                long jX49 = x(iJ);
                                r02Var3.C(5);
                                xm4.o(obj2, jX49, Integer.valueOf(((p60) r02Var3.d).j()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 58:
                                iArr = iArr2;
                                i2 = i3;
                                long jX50 = x(iJ);
                                r02Var3.C(0);
                                xm4.o(obj2, jX50, Boolean.valueOf(((p60) r02Var3.d).f()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 59:
                                iArr = iArr2;
                                i2 = i3;
                                sl2Var2.D(iJ, r02Var3, obj2);
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 60:
                                iArr = iArr2;
                                i2 = i3;
                                d1 d1Var3 = (d1) sl2Var2.v(iF, iA, obj2);
                                gq3 gq3VarM3 = sl2Var2.m(iA);
                                r02Var3.C(2);
                                r02Var3.h(d1Var3, gq3VarM3, p91Var3);
                                unsafe.putObject(obj2, sl2Var2.J(iA) & 1048575, d1Var3);
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 61:
                                iArr = iArr2;
                                i2 = i3;
                                xm4.o(obj2, x(iJ), r02Var3.j());
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 62:
                                iArr = iArr2;
                                i2 = i3;
                                long jX51 = x(iJ);
                                r02Var3.C(0);
                                xm4.o(obj2, jX51, Integer.valueOf(((p60) r02Var3.d).v()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 63:
                                iArr = iArr2;
                                i2 = i3;
                                r02Var3.C(0);
                                int i7 = ((p60) r02Var3.d).i();
                                sl2Var2.l(iA);
                                xm4.o(obj2, x(iJ), Integer.valueOf(i7));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 64:
                                iArr = iArr2;
                                i2 = i3;
                                long jX52 = x(iJ);
                                r02Var3.C(5);
                                xm4.o(obj2, jX52, Integer.valueOf(((p60) r02Var3.d).o()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 65:
                                iArr = iArr2;
                                i2 = i3;
                                long jX53 = x(iJ);
                                r02Var3.C(1);
                                xm4.o(obj2, jX53, Long.valueOf(((p60) r02Var3.d).p()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 66:
                                iArr = iArr2;
                                i2 = i3;
                                long jX54 = x(iJ);
                                r02Var3.C(0);
                                xm4.o(obj2, jX54, Integer.valueOf(((p60) r02Var3.d).q()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 67:
                                iArr = iArr2;
                                i2 = i3;
                                long jX55 = x(iJ);
                                r02Var3.C(0);
                                xm4.o(obj2, jX55, Long.valueOf(((p60) r02Var3.d).r()));
                                sl2Var2.H(iF, iA, obj2);
                                sl2Var = sl2Var2;
                                r02Var2 = r02Var3;
                                p91Var2 = p91Var3;
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            case 68:
                                try {
                                    d1 d1Var4 = (d1) sl2Var2.v(iF, iA, obj2);
                                    gq3 gq3VarM4 = sl2Var2.m(iA);
                                    r02Var3.C(3);
                                    r02Var3.g(d1Var4, gq3VarM4, p91Var3);
                                    iArr = iArr2;
                                    i2 = i3;
                                    try {
                                        try {
                                            unsafe.putObject(obj2, sl2Var2.J(iA) & 1048575, d1Var4);
                                            sl2Var2.H(iF, iA, obj2);
                                            sl2Var = sl2Var2;
                                            r02Var2 = r02Var3;
                                            p91Var2 = p91Var3;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            sl2Var = sl2Var2;
                                            i = i2;
                                            while (i4 < i) {
                                            }
                                            if (dm4VarA != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (r12 unused9) {
                                        sl2Var = sl2Var2;
                                        r02Var2 = r02Var3;
                                        p91Var2 = p91Var3;
                                        em4Var.getClass();
                                        if (dm4VarA == null) {
                                        }
                                        if (!em4.b(0, r02Var2, dm4VarA)) {
                                        }
                                    }
                                } catch (r12 unused10) {
                                    iArr = iArr2;
                                    i2 = i3;
                                } catch (Throwable th6) {
                                    th = th6;
                                    iArr = iArr2;
                                    i2 = i3;
                                }
                                r02Var3 = r02Var2;
                                p91Var3 = p91Var2;
                                iArr2 = iArr;
                                i3 = i2;
                                sl2Var2 = sl2Var;
                                break;
                            default:
                                if (dm4VarA == null) {
                                    em4Var.getClass();
                                    dm4VarA = em4.a(obj2);
                                }
                                em4Var.getClass();
                                if (em4.b(0, r02Var3, dm4VarA)) {
                                    sl2Var = sl2Var2;
                                    iArr = iArr2;
                                    i2 = i3;
                                    r02Var2 = r02Var3;
                                    p91Var2 = p91Var3;
                                    r02Var3 = r02Var2;
                                    p91Var3 = p91Var2;
                                    iArr2 = iArr;
                                    i3 = i2;
                                    sl2Var2 = sl2Var;
                                } else {
                                    while (i4 < i3) {
                                        sl2Var2.k(iArr2[i4], obj2, dm4VarA);
                                        i4++;
                                    }
                                    if (dm4VarA == null) {
                                        return;
                                    }
                                }
                                break;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        sl2Var = sl2Var2;
                        iArr = iArr2;
                        i2 = i3;
                    }
                } else if (iF == Integer.MAX_VALUE) {
                    while (i4 < i3) {
                        sl2Var2.k(iArr2[i4], obj2, dm4VarA);
                        i4++;
                    }
                    if (dm4VarA == null) {
                        return;
                    } else {
                        em4Var.getClass();
                    }
                } else {
                    em4Var.getClass();
                    if (dm4VarA == null) {
                        dm4VarA = em4.a(obj2);
                    }
                    if (!em4.b(0, r02Var3, dm4VarA)) {
                        while (i4 < i3) {
                            sl2Var2.k(iArr2[i4], obj2, dm4VarA);
                            i4++;
                        }
                        if (dm4VarA == null) {
                            return;
                        }
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                sl2Var = sl2Var2;
                iArr = iArr2;
                i = i3;
            }
        }
    }

    @Override // defpackage.gq3
    public final co1 i() {
        this.j.getClass();
        return ((co1) this.e).i();
    }

    public final boolean j(co1 co1Var, co1 co1Var2, int i) {
        return n(i, co1Var) == n(i, co1Var2);
    }

    public final void k(int i, Object obj, Object obj2) {
        int i2 = this.a[i];
        if (xm4.h(obj, J(i) & 1048575) == null) {
            return;
        }
        l(i);
    }

    public final void l(int i) {
        if (this.b[((i / 3) * 2) + 1] == null) {
            return;
        }
        st4.n();
    }

    public final gq3 m(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.b;
        gq3 gq3Var = (gq3) objArr[i2];
        if (gq3Var != null) {
            return gq3Var;
        }
        gq3 gq3VarA = v93.c.a((Class) objArr[i2 + 1]);
        objArr[i2] = gq3VarA;
        return gq3VarA;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean n(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = i2 & 1048575;
        if (j == 1048575) {
            int iJ = J(i);
            long j2 = iJ & 1048575;
            switch (I(iJ)) {
                case 0:
                    return Double.doubleToRawLongBits(xm4.c.c(j2, obj)) != 0;
                case 1:
                    if (Float.floatToRawIntBits(xm4.c.d(j2, obj)) != 0) {
                    }
                    break;
                case 2:
                    if (xm4.g(obj, j2) != 0) {
                    }
                    break;
                case 3:
                    if (xm4.g(obj, j2) != 0) {
                    }
                    break;
                case 4:
                    if (xm4.f(obj, j2) != 0) {
                    }
                    break;
                case 5:
                    if (xm4.g(obj, j2) != 0) {
                    }
                    break;
                case 6:
                    if (xm4.f(obj, j2) != 0) {
                    }
                    break;
                case 7:
                    return xm4.c.a(j2, obj);
                case 8:
                    Object objH = xm4.h(obj, j2);
                    if (objH instanceof String) {
                        return !((String) objH).isEmpty();
                    }
                    if (objH instanceof au) {
                        return !au.z.equals(objH);
                    }
                    s53.d();
                    return false;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    if (xm4.h(obj, j2) != null) {
                    }
                    break;
                case 10:
                    return !au.z.equals(xm4.h(obj, j2));
                case 11:
                    if (xm4.f(obj, j2) != 0) {
                    }
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    if (xm4.f(obj, j2) != 0) {
                    }
                    break;
                case 13:
                    if (xm4.f(obj, j2) != 0) {
                    }
                    break;
                case 14:
                    if (xm4.g(obj, j2) != 0) {
                    }
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    if (xm4.f(obj, j2) != 0) {
                    }
                    break;
                case 16:
                    if (xm4.g(obj, j2) != 0) {
                    }
                    break;
                case 17:
                    if (xm4.h(obj, j2) != null) {
                    }
                    break;
                default:
                    s53.d();
                    return false;
            }
        } else if (((1 << (i2 >>> 20)) & xm4.f(obj, j)) != 0) {
        }
    }

    public final boolean o(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? n(i, obj) : (i3 & i4) != 0;
    }

    public final boolean q(int i, int i2, Object obj) {
        return xm4.f(obj, (long) (this.a[i2 + 2] & 1048575)) == i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009d, code lost:
    
        r9.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a0, code lost:
    
        r10.d(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(Object obj, int i, Object obj2, p91 p91Var, r02 r02Var) throws r12 {
        long J = J(i) & 1048575;
        Object objH = xm4.h(obj, J);
        tg2 tg2Var = this.m;
        if (objH == null) {
            tg2Var.getClass();
            objH = sg2.f.b();
            xm4.o(obj, J, objH);
        } else {
            tg2Var.getClass();
            if (!((sg2) objH).b) {
                Object objB = sg2.f.b();
                tg2.a(objB, objH);
                xm4.o(obj, J, objB);
                objH = objB;
            }
        }
        tg2Var.getClass();
        sg2 sg2Var = (sg2) objH;
        n02 n02Var = ((jg2) obj2).a;
        r02Var.C(2);
        p60 p60Var = (p60) r02Var.d;
        int iE = p60Var.e(p60Var.v());
        Object obj3 = n02Var.A;
        Object objN = "";
        Object objN2 = obj3;
        while (true) {
            try {
                int iF = r02Var.f();
                if (iF == Integer.MAX_VALUE || p60Var.c()) {
                    break;
                }
                if (iF == 1) {
                    objN = r02Var.n((bw4) n02Var.f, null, null);
                } else if (iF != 2) {
                    try {
                        if (!r02Var.D()) {
                            throw new t12("Unable to parse map entry.");
                        }
                    } catch (r12 unused) {
                        if (!r02Var.D()) {
                            throw new t12("Unable to parse map entry.");
                        }
                    }
                } else {
                    objN2 = r02Var.n((bw4) n02Var.z, obj3.getClass(), p91Var);
                }
            } catch (Throwable th) {
                p60Var.d(iE);
                throw th;
            }
        }
    }

    public final void s(int i, Object obj, Object obj2) {
        if (n(i, obj2)) {
            long J = J(i) & 1048575;
            Unsafe unsafe = o;
            Object object = unsafe.getObject(obj2, J);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.a[i] + " is present but null: " + obj2);
            }
            gq3 gq3VarM = m(i);
            if (!n(i, obj)) {
                if (p(object)) {
                    co1 co1VarI = gq3VarM.i();
                    gq3VarM.a(co1VarI, object);
                    unsafe.putObject(obj, J, co1VarI);
                } else {
                    unsafe.putObject(obj, J, object);
                }
                G(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, J);
            if (!p(object2)) {
                co1 co1VarI2 = gq3VarM.i();
                gq3VarM.a(co1VarI2, object2);
                unsafe.putObject(obj, J, co1VarI2);
                object2 = co1VarI2;
            }
            gq3VarM.a(object2, object);
        }
    }

    public final void t(int i, Object obj, Object obj2) {
        int[] iArr = this.a;
        int i2 = iArr[i];
        if (q(i2, i, obj2)) {
            long J = J(i) & 1048575;
            Unsafe unsafe = o;
            Object object = unsafe.getObject(obj2, J);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2);
            }
            gq3 gq3VarM = m(i);
            if (!q(i2, i, obj)) {
                if (p(object)) {
                    co1 co1VarI = gq3VarM.i();
                    gq3VarM.a(co1VarI, object);
                    unsafe.putObject(obj, J, co1VarI);
                } else {
                    unsafe.putObject(obj, J, object);
                }
                H(i2, i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, J);
            if (!p(object2)) {
                co1 co1VarI2 = gq3VarM.i();
                gq3VarM.a(co1VarI2, object2);
                unsafe.putObject(obj, J, co1VarI2);
                object2 = co1VarI2;
            }
            gq3VarM.a(object2, object);
        }
    }

    public final Object u(int i, Object obj) {
        gq3 gq3VarM = m(i);
        long J = J(i) & 1048575;
        if (!n(i, obj)) {
            return gq3VarM.i();
        }
        Object object = o.getObject(obj, J);
        if (p(object)) {
            return object;
        }
        co1 co1VarI = gq3VarM.i();
        if (object != null) {
            gq3VarM.a(co1VarI, object);
        }
        return co1VarI;
    }

    public final Object v(int i, int i2, Object obj) {
        gq3 gq3VarM = m(i2);
        if (!q(i, i2, obj)) {
            return gq3VarM.i();
        }
        Object object = o.getObject(obj, J(i2) & 1048575);
        if (p(object)) {
            return object;
        }
        co1 co1VarI = gq3VarM.i();
        if (object != null) {
            gq3VarM.a(co1VarI, object);
        }
        return co1VarI;
    }
}
