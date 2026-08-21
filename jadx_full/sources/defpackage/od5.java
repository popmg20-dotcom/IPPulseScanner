package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class od5 {
    public static final od5 c = new od5();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final w7 a = new w7(2);

    /* JADX WARN: Removed duplicated region for block: B:140:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0433  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final sd5 a(Class cls) {
        sd5 jd5Var;
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        char cCharAt;
        int i7;
        char cCharAt2;
        int i8;
        char cCharAt3;
        int i9;
        char cCharAt4;
        int i10;
        char cCharAt5;
        int i11;
        char cCharAt6;
        int i12;
        char cCharAt7;
        int i13;
        char cCharAt8;
        Object[] objArr;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        Field fieldU;
        char cCharAt9;
        int i25;
        int i26;
        int i27;
        int i28;
        Object obj;
        Field fieldU2;
        Object obj2;
        Field fieldU3;
        int i29;
        char cCharAt10;
        int i30;
        int i31;
        char cCharAt11;
        int i32;
        int i33;
        char cCharAt12;
        int i34;
        char cCharAt13;
        Charset charset = nc5.a;
        if (cls == null) {
            zo2.n("messageType");
            return null;
        }
        ConcurrentHashMap concurrentHashMap = this.b;
        sd5 sd5Var = (sd5) concurrentHashMap.get(cls);
        if (sd5Var != null) {
            return sd5Var;
        }
        q84 q84Var = ud5.a;
        dc5.class.isAssignableFrom(cls);
        qd5 qd5VarH = ((jf4) this.a.f).h(cls);
        int i35 = 0;
        if ((qd5VarH.d & 2) == 2) {
            q84 q84Var2 = ud5.a;
            l74 l74Var = sb5.a;
            jd5Var = new jd5(q84Var2, qd5VarH.a);
        } else {
            int i36 = ld5.a;
            int i37 = rc5.a;
            q84 q84Var3 = ud5.a;
            l74 l74Var2 = qd5VarH.a() + (-1) != 1 ? sb5.a : null;
            int i38 = bd5.a;
            int[] iArr2 = id5.j;
            if (!(qd5VarH instanceof qd5)) {
                st4.n();
                return null;
            }
            String str = qd5VarH.b;
            int length = str.length();
            if (str.charAt(0) >= 55296) {
                int i39 = 1;
                while (true) {
                    i = i39 + 1;
                    if (str.charAt(i39) < 55296) {
                        break;
                    }
                    i39 = i;
                }
            } else {
                i = 1;
            }
            int i40 = i + 1;
            int iCharAt4 = str.charAt(i);
            if (iCharAt4 >= 55296) {
                int i41 = iCharAt4 & 8191;
                int i42 = 13;
                while (true) {
                    i34 = i40 + 1;
                    cCharAt13 = str.charAt(i40);
                    if (cCharAt13 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt13 & 8191) << i42;
                    i42 += 13;
                    i40 = i34;
                }
                iCharAt4 = i41 | (cCharAt13 << i42);
                i40 = i34;
            }
            if (iCharAt4 == 0) {
                i4 = 0;
                iCharAt = 0;
                iCharAt2 = 0;
                iCharAt3 = 0;
                i5 = 0;
                iArr = id5.j;
                i3 = 0;
            } else {
                int i43 = i40 + 1;
                int iCharAt5 = str.charAt(i40);
                if (iCharAt5 >= 55296) {
                    int i44 = iCharAt5 & 8191;
                    int i45 = 13;
                    while (true) {
                        i13 = i43 + 1;
                        cCharAt8 = str.charAt(i43);
                        if (cCharAt8 < 55296) {
                            break;
                        }
                        i44 |= (cCharAt8 & 8191) << i45;
                        i45 += 13;
                        i43 = i13;
                    }
                    iCharAt5 = i44 | (cCharAt8 << i45);
                    i43 = i13;
                }
                int i46 = i43 + 1;
                int iCharAt6 = str.charAt(i43);
                if (iCharAt6 >= 55296) {
                    int i47 = iCharAt6 & 8191;
                    int i48 = 13;
                    while (true) {
                        i12 = i46 + 1;
                        cCharAt7 = str.charAt(i46);
                        if (cCharAt7 < 55296) {
                            break;
                        }
                        i47 |= (cCharAt7 & 8191) << i48;
                        i48 += 13;
                        i46 = i12;
                    }
                    iCharAt6 = i47 | (cCharAt7 << i48);
                    i46 = i12;
                }
                int i49 = i46 + 1;
                iCharAt = str.charAt(i46);
                if (iCharAt >= 55296) {
                    int i50 = iCharAt & 8191;
                    int i51 = 13;
                    while (true) {
                        i11 = i49 + 1;
                        cCharAt6 = str.charAt(i49);
                        if (cCharAt6 < 55296) {
                            break;
                        }
                        i50 |= (cCharAt6 & 8191) << i51;
                        i51 += 13;
                        i49 = i11;
                    }
                    iCharAt = i50 | (cCharAt6 << i51);
                    i49 = i11;
                }
                int i52 = i49 + 1;
                iCharAt2 = str.charAt(i49);
                if (iCharAt2 >= 55296) {
                    int i53 = iCharAt2 & 8191;
                    int i54 = 13;
                    while (true) {
                        i10 = i52 + 1;
                        cCharAt5 = str.charAt(i52);
                        if (cCharAt5 < 55296) {
                            break;
                        }
                        i53 |= (cCharAt5 & 8191) << i54;
                        i54 += 13;
                        i52 = i10;
                    }
                    iCharAt2 = i53 | (cCharAt5 << i54);
                    i52 = i10;
                }
                int i55 = i52 + 1;
                iCharAt3 = str.charAt(i52);
                if (iCharAt3 >= 55296) {
                    int i56 = iCharAt3 & 8191;
                    int i57 = 13;
                    while (true) {
                        i9 = i55 + 1;
                        cCharAt4 = str.charAt(i55);
                        if (cCharAt4 < 55296) {
                            break;
                        }
                        i56 |= (cCharAt4 & 8191) << i57;
                        i57 += 13;
                        i55 = i9;
                    }
                    iCharAt3 = i56 | (cCharAt4 << i57);
                    i55 = i9;
                }
                int i58 = i55 + 1;
                int iCharAt7 = str.charAt(i55);
                if (iCharAt7 >= 55296) {
                    int i59 = iCharAt7 & 8191;
                    int i60 = 13;
                    while (true) {
                        i8 = i58 + 1;
                        cCharAt3 = str.charAt(i58);
                        if (cCharAt3 < 55296) {
                            break;
                        }
                        i59 |= (cCharAt3 & 8191) << i60;
                        i60 += 13;
                        i58 = i8;
                    }
                    iCharAt7 = i59 | (cCharAt3 << i60);
                    i58 = i8;
                }
                int i61 = i58 + 1;
                int iCharAt8 = str.charAt(i58);
                if (iCharAt8 >= 55296) {
                    int i62 = iCharAt8 & 8191;
                    int i63 = i61;
                    int i64 = 13;
                    while (true) {
                        i7 = i63 + 1;
                        cCharAt2 = str.charAt(i63);
                        if (cCharAt2 < 55296) {
                            break;
                        }
                        i62 |= (cCharAt2 & 8191) << i64;
                        i64 += 13;
                        i63 = i7;
                    }
                    iCharAt8 = i62 | (cCharAt2 << i64);
                    i2 = i7;
                } else {
                    i2 = i61;
                }
                int i65 = i2 + 1;
                int iCharAt9 = str.charAt(i2);
                if (iCharAt9 >= 55296) {
                    int i66 = iCharAt9 & 8191;
                    int i67 = i65;
                    int i68 = 13;
                    while (true) {
                        i6 = i67 + 1;
                        cCharAt = str.charAt(i67);
                        if (cCharAt < 55296) {
                            break;
                        }
                        i66 |= (cCharAt & 8191) << i68;
                        i68 += 13;
                        i67 = i6;
                    }
                    iCharAt9 = i66 | (cCharAt << i68);
                    i65 = i6;
                }
                int i69 = iCharAt9 + iCharAt7 + iCharAt8;
                int i70 = iCharAt5 + iCharAt5 + iCharAt6;
                int[] iArr3 = new int[i69];
                int i71 = iCharAt7;
                iArr = iArr3;
                i3 = i71;
                i4 = i70;
                i5 = iCharAt9;
                i35 = iCharAt5;
                i40 = i65;
            }
            Unsafe unsafe = id5.k;
            Object[] objArr2 = qd5VarH.c;
            int i72 = i40;
            Class<?> cls2 = qd5VarH.a.getClass();
            int i73 = i3 + i5;
            int i74 = i35;
            int i75 = iCharAt3 + iCharAt3;
            int[] iArr4 = new int[iCharAt3 * 3];
            Object[] objArr3 = new Object[i75];
            int i76 = i4;
            int i77 = i72;
            int i78 = i73;
            int i79 = i5;
            int i80 = 0;
            int i81 = 0;
            while (i77 < length) {
                int i82 = i77 + 1;
                int iCharAt10 = str.charAt(i77);
                int i83 = length;
                if (iCharAt10 >= 55296) {
                    int i84 = iCharAt10 & 8191;
                    int i85 = i82;
                    int i86 = 13;
                    while (true) {
                        i33 = i85 + 1;
                        cCharAt12 = str.charAt(i85);
                        objArr = objArr3;
                        if (cCharAt12 < 55296) {
                            break;
                        }
                        i84 |= (cCharAt12 & 8191) << i86;
                        i86 += 13;
                        i85 = i33;
                        objArr3 = objArr;
                    }
                    iCharAt10 = i84 | (cCharAt12 << i86);
                    i14 = i33;
                } else {
                    objArr = objArr3;
                    i14 = i82;
                }
                int i87 = i14 + 1;
                int iCharAt11 = str.charAt(i14);
                if (iCharAt11 >= 55296) {
                    int i88 = iCharAt11 & 8191;
                    int i89 = i87;
                    int i90 = 13;
                    while (true) {
                        i31 = i89 + 1;
                        cCharAt11 = str.charAt(i89);
                        i32 = i88;
                        if (cCharAt11 < 55296) {
                            break;
                        }
                        i88 = i32 | ((cCharAt11 & 8191) << i90);
                        i90 += 13;
                        i89 = i31;
                    }
                    iCharAt11 = i32 | (cCharAt11 << i90);
                    i15 = i31;
                } else {
                    i15 = i87;
                }
                Object[] objArr4 = objArr2;
                if ((iCharAt11 & 1024) != 0) {
                    iArr[i81] = i80;
                    i81++;
                }
                int i91 = iCharAt11 & DnsRecord.CLASS_ANY;
                int i92 = i73;
                int i93 = iCharAt11 & 2048;
                if (i91 >= 51) {
                    int i94 = i15 + 1;
                    int iCharAt12 = str.charAt(i15);
                    if (iCharAt12 >= 55296) {
                        int i95 = iCharAt12 & 8191;
                        int i96 = i94;
                        int i97 = 13;
                        while (true) {
                            i29 = i96 + 1;
                            cCharAt10 = str.charAt(i96);
                            i30 = i95;
                            if (cCharAt10 < 55296) {
                                break;
                            }
                            i95 = i30 | ((cCharAt10 & 8191) << i97);
                            i97 += 13;
                            i96 = i29;
                        }
                        iCharAt12 = i30 | (cCharAt10 << i97);
                        i26 = i29;
                    } else {
                        i26 = i94;
                    }
                    int i98 = iCharAt12;
                    int i99 = i91 - 51;
                    int i100 = i26;
                    if (i99 == 9 || i99 == 17) {
                        i27 = i76 + 1;
                        int i101 = i80 / 3;
                        objArr[i101 + i101 + 1] = objArr4[i76];
                    } else {
                        if (i99 != 12) {
                            i28 = i93;
                        } else if (qd5VarH.a() == 1 || i93 != 0) {
                            i27 = i76 + 1;
                            int i102 = i80 / 3;
                            objArr[i102 + i102 + 1] = objArr4[i76];
                        } else {
                            i28 = 0;
                        }
                        int i103 = i98 + i98;
                        obj = objArr4[i103];
                        i24 = i28;
                        if (obj instanceof Field) {
                            fieldU2 = id5.u(cls2, (String) obj);
                            objArr4[i103] = fieldU2;
                        } else {
                            fieldU2 = (Field) obj;
                        }
                        i16 = iCharAt10;
                        int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldU2);
                        int i104 = i103 + 1;
                        obj2 = objArr4[i104];
                        if (obj2 instanceof Field) {
                            fieldU3 = id5.u(cls2, (String) obj2);
                            objArr4[i104] = fieldU3;
                        } else {
                            fieldU3 = (Field) obj2;
                        }
                        int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldU3);
                        i17 = iCharAt;
                        i18 = iCharAt2;
                        i77 = i100;
                        i22 = 0;
                        iObjectFieldOffset2 = iObjectFieldOffset4;
                        i23 = iObjectFieldOffset3;
                    }
                    i76 = i27;
                    i28 = i93;
                    int i1032 = i98 + i98;
                    obj = objArr4[i1032];
                    i24 = i28;
                    if (obj instanceof Field) {
                    }
                    i16 = iCharAt10;
                    int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldU2);
                    int i1042 = i1032 + 1;
                    obj2 = objArr4[i1042];
                    if (obj2 instanceof Field) {
                    }
                    int iObjectFieldOffset42 = (int) unsafe.objectFieldOffset(fieldU3);
                    i17 = iCharAt;
                    i18 = iCharAt2;
                    i77 = i100;
                    i22 = 0;
                    iObjectFieldOffset2 = iObjectFieldOffset42;
                    i23 = iObjectFieldOffset32;
                } else {
                    i16 = iCharAt10;
                    int i105 = i76 + 1;
                    Field fieldU4 = id5.u(cls2, (String) objArr4[i76]);
                    if (i91 == 9 || i91 == 17) {
                        i17 = iCharAt;
                        int i106 = i80 / 3;
                        objArr[i106 + i106 + 1] = fieldU4.getType();
                    } else {
                        if (i91 == 27) {
                            i17 = iCharAt;
                            i25 = 1;
                            i76 += 2;
                        } else if (i91 == 49) {
                            i76 += 2;
                            i17 = iCharAt;
                            i25 = 1;
                        } else {
                            if (i91 == 12 || i91 == 30 || i91 == 44) {
                                i17 = iCharAt;
                                if (qd5VarH.a() == 1 || i93 != 0) {
                                    i76 += 2;
                                    int i107 = i80 / 3;
                                    objArr[i107 + i107 + 1] = objArr4[i105];
                                    i18 = iCharAt2;
                                    i19 = i93;
                                } else {
                                    i18 = iCharAt2;
                                    i76 = i105;
                                    i19 = 0;
                                }
                            } else if (i91 == 50) {
                                int i108 = i76 + 2;
                                int i109 = i79 + 1;
                                iArr[i79] = i80;
                                int i110 = i80 / 3;
                                int i111 = i110 + i110;
                                objArr[i111] = objArr4[i105];
                                if (i93 != 0) {
                                    i76 += 3;
                                    objArr[i111 + 1] = objArr4[i108];
                                    i18 = iCharAt2;
                                    i19 = i93;
                                    i79 = i109;
                                } else {
                                    i76 = i108;
                                    i18 = iCharAt2;
                                    i79 = i109;
                                    i19 = 0;
                                }
                                i17 = iCharAt;
                            } else {
                                i17 = iCharAt;
                            }
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldU4);
                            iObjectFieldOffset2 = 1048575;
                            if ((iCharAt11 & 4096) == 0 || i91 > 17) {
                                i20 = i15;
                                i21 = 0;
                            } else {
                                int i112 = i15 + 1;
                                int iCharAt13 = str.charAt(i15);
                                if (iCharAt13 >= 55296) {
                                    int i113 = iCharAt13 & 8191;
                                    int i114 = 13;
                                    while (true) {
                                        i20 = i112 + 1;
                                        cCharAt9 = str.charAt(i112);
                                        if (cCharAt9 < 55296) {
                                            break;
                                        }
                                        i113 |= (cCharAt9 & 8191) << i114;
                                        i114 += 13;
                                        i112 = i20;
                                    }
                                    iCharAt13 = i113 | (cCharAt9 << i114);
                                } else {
                                    i20 = i112;
                                }
                                int i115 = (iCharAt13 / 32) + i74 + i74;
                                Object obj3 = objArr4[i115];
                                if (obj3 instanceof Field) {
                                    fieldU = (Field) obj3;
                                } else {
                                    fieldU = id5.u(cls2, (String) obj3);
                                    objArr4[i115] = fieldU;
                                }
                                i21 = iCharAt13 % 32;
                                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldU);
                            }
                            if (i91 >= 18 || i91 > 49) {
                                int i116 = i19;
                                i22 = i21;
                                i23 = iObjectFieldOffset;
                                i77 = i20;
                                i24 = i116;
                            } else {
                                int i117 = i78 + 1;
                                iArr[i78] = iObjectFieldOffset;
                                int i118 = i19;
                                i22 = i21;
                                i23 = iObjectFieldOffset;
                                i77 = i20;
                                i24 = i118;
                                i78 = i117;
                            }
                        }
                        int i119 = i80 / 3;
                        objArr[i119 + i119 + i25] = objArr4[i105];
                        i18 = iCharAt2;
                        i19 = i93;
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldU4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) == 0) {
                            i20 = i15;
                            i21 = 0;
                            if (i91 >= 18) {
                                int i1162 = i19;
                                i22 = i21;
                                i23 = iObjectFieldOffset;
                                i77 = i20;
                                i24 = i1162;
                            }
                        }
                    }
                    i18 = iCharAt2;
                    i19 = i93;
                    i76 = i105;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldU4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) == 0) {
                    }
                }
                int i120 = i80 + 1;
                iArr4[i80] = i16;
                int i121 = i80 + 2;
                String str2 = str;
                iArr4[i120] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i24 != 0 ? Integer.MIN_VALUE : 0) | (i91 << 20) | i23;
                i80 += 3;
                iArr4[i121] = (i22 << 20) | iObjectFieldOffset2;
                iCharAt2 = i18;
                objArr2 = objArr4;
                length = i83;
                i73 = i92;
                objArr3 = objArr;
                iCharAt = i17;
                str = str2;
            }
            jd5Var = new id5(iArr4, objArr3, iCharAt, iCharAt2, qd5VarH.a, iArr, i5, i73, q84Var3, l74Var2);
        }
        Charset charset2 = nc5.a;
        sd5 sd5Var2 = (sd5) concurrentHashMap.putIfAbsent(cls, jd5Var);
        return sd5Var2 != null ? sd5Var2 : jd5Var;
    }
}
