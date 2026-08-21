package defpackage;

import j$.util.Objects;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gi3 extends gz1 {
    public static final gi3 Z = new gi3(null, new Object[0], 0);
    public final transient Object A;
    public final transient Object[] X;
    public final transient int Y;

    public gi3(Object obj, Object[] objArr, int i) {
        this.A = obj;
        this.X = objArr;
        this.Y = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0199  */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static gi3 a(int i, Object[] objArr, qt qtVar) {
        boolean z;
        int i2;
        char c;
        ?? r3;
        char c2;
        short[] sArr;
        boolean z2;
        int i3;
        ?? r16;
        boolean z3;
        boolean z4;
        int i4 = i;
        Object[] objArrCopyOf = objArr;
        if (i4 == 0) {
            return Z;
        }
        fz1 fz1Var = null;
        ?? r32 = 0;
        fz1 fz1Var2 = null;
        fz1 fz1Var3 = null;
        boolean z5 = false;
        int i5 = 1;
        if (i4 == 1) {
            Objects.requireNonNull(objArrCopyOf[0]);
            Objects.requireNonNull(objArrCopyOf[1]);
            return new gi3(null, objArrCopyOf, 1);
        }
        co4.i(i4, objArrCopyOf.length >> 1);
        int iJ = hz1.j(i4);
        char c3 = 2;
        if (i4 != 1) {
            int i6 = iJ - 1;
            if (iJ <= 128) {
                byte[] bArr = new byte[iJ];
                Arrays.fill(bArr, (byte) -1);
                int i7 = 0;
                int i8 = 0;
                while (i7 < i4) {
                    int i9 = i7 * 2;
                    int i10 = i8 * 2;
                    Object obj = objArrCopyOf[i9];
                    Objects.requireNonNull(obj);
                    Object obj2 = objArrCopyOf[i9 ^ i5];
                    Objects.requireNonNull(obj2);
                    int iP = r25.P(obj.hashCode());
                    while (true) {
                        int i11 = iP & i6;
                        z2 = z5;
                        i3 = i5;
                        int i12 = bArr[i11] & 255;
                        if (i12 == 255) {
                            bArr[i11] = (byte) i10;
                            if (i8 < i7) {
                                objArrCopyOf[i10] = obj;
                                objArrCopyOf[i10 ^ 1] = obj2;
                            }
                            i8++;
                        } else {
                            if (obj.equals(objArrCopyOf[i12 == true ? 1 : 0])) {
                                int i13 = ~i12;
                                Object obj3 = objArrCopyOf[i13 == true ? 1 : 0];
                                Objects.requireNonNull(obj3);
                                fz1Var2 = new fz1(obj, obj2, obj3);
                                objArrCopyOf[i13 == true ? 1 : 0] = obj2;
                                break;
                            }
                            iP = i11 + 1;
                            z5 = z2;
                            i5 = i3;
                        }
                    }
                    i7++;
                    z5 = z2;
                    i5 = i3;
                }
                z = z5;
                i2 = i5;
                if (i8 == i4) {
                    r32 = bArr;
                    z4 = z;
                } else {
                    sArr = new Object[3];
                    sArr[z ? 1 : 0] = bArr;
                    sArr[i2] = Integer.valueOf(i8);
                    sArr[2] = fz1Var2;
                    r32 = sArr;
                    z4 = z;
                }
            } else {
                z = false;
                i2 = 1;
                if (iJ <= 32768) {
                    sArr = new short[iJ];
                    Arrays.fill(sArr, (short) -1);
                    int i14 = 0;
                    for (int i15 = 0; i15 < i4; i15++) {
                        int i16 = i15 * 2;
                        int i17 = i14 * 2;
                        Object obj4 = objArrCopyOf[i16];
                        Objects.requireNonNull(obj4);
                        Object obj5 = objArrCopyOf[i16 ^ 1];
                        Objects.requireNonNull(obj5);
                        int iP2 = r25.P(obj4.hashCode());
                        while (true) {
                            int i18 = iP2 & i6;
                            int i19 = sArr[i18] & 65535;
                            if (i19 == 65535) {
                                sArr[i18] = (short) i17;
                                if (i14 < i15) {
                                    objArrCopyOf[i17] = obj4;
                                    objArrCopyOf[i17 ^ 1] = obj5;
                                }
                                i14++;
                            } else {
                                if (obj4.equals(objArrCopyOf[i19 == true ? 1 : 0])) {
                                    int i20 = ~i19;
                                    Object obj6 = objArrCopyOf[i20 == true ? 1 : 0];
                                    Objects.requireNonNull(obj6);
                                    fz1Var3 = new fz1(obj4, obj5, obj6);
                                    objArrCopyOf[i20 == true ? 1 : 0] = obj5;
                                    break;
                                }
                                iP2 = i18 + 1;
                            }
                        }
                    }
                    if (i14 == i4) {
                        r32 = sArr;
                        z4 = z;
                    } else {
                        r32 = new Object[]{sArr, Integer.valueOf(i14), fz1Var3};
                        z4 = z;
                    }
                } else {
                    int[] iArr = new int[iJ];
                    Arrays.fill(iArr, -1);
                    int i21 = 0;
                    int i22 = 0;
                    while (i21 < i4) {
                        int i23 = i21 * 2;
                        int i24 = i22 * 2;
                        Object obj7 = objArrCopyOf[i23];
                        Objects.requireNonNull(obj7);
                        Object obj8 = objArrCopyOf[i23 ^ 1];
                        Objects.requireNonNull(obj8);
                        int iP3 = r25.P(obj7.hashCode());
                        while (true) {
                            int i25 = iP3 & i6;
                            int i26 = iArr[i25];
                            if (i26 == -1) {
                                iArr[i25] = i24;
                                if (i22 < i21) {
                                    objArrCopyOf[i24] = obj7;
                                    objArrCopyOf[i24 ^ 1] = obj8;
                                }
                                i22++;
                                c2 = c3;
                            } else {
                                c2 = c3;
                                if (obj7.equals(objArrCopyOf[i26])) {
                                    int i27 = i26 ^ 1;
                                    Object obj9 = objArrCopyOf[i27];
                                    Objects.requireNonNull(obj9);
                                    fz1Var = new fz1(obj7, obj8, obj9);
                                    objArrCopyOf[i27] = obj8;
                                    break;
                                }
                                iP3 = i25 + 1;
                                c3 = c2;
                            }
                        }
                        i21++;
                        c3 = c2;
                    }
                    c = c3;
                    if (i22 == i4) {
                        r3 = iArr;
                        r16 = z;
                    } else {
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = iArr;
                        objArr2[1] = Integer.valueOf(i22);
                        objArr2[c] = fz1Var;
                        r3 = objArr2;
                        r16 = z;
                    }
                }
            }
            z3 = r3 instanceof Object[];
            ?? r33 = r3;
            if (z3) {
                Object[] objArr3 = (Object[]) r3;
                fz1 fz1Var4 = (fz1) objArr3[c];
                if (qtVar == null) {
                    throw fz1Var4.a();
                }
                qtVar.d = fz1Var4;
                Object obj10 = objArr3[r16];
                int iIntValue = ((Integer) objArr3[i2]).intValue();
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue * 2);
                r33 = obj10;
                i4 = iIntValue;
            }
            return new gi3(r33, objArrCopyOf, i4);
        }
        Objects.requireNonNull(objArrCopyOf[0]);
        Objects.requireNonNull(objArrCopyOf[1]);
        z4 = false;
        i2 = 1;
        c = 2;
        r3 = r32;
        r16 = z4;
        z3 = r3 instanceof Object[];
        ?? r332 = r3;
        if (z3) {
        }
        return new gi3(r332, objArrCopyOf, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x0037->B:22:0x004d], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0062->B:32:0x0079], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x0088->B:43:0x00a0]] */
    @Override // defpackage.gz1, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            Object[] objArr = this.X;
            if (this.Y == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                }
            } else {
                Object obj4 = this.A;
                if (obj4 != null) {
                    if (obj4 instanceof byte[]) {
                        byte[] bArr = (byte[]) obj4;
                        int length = bArr.length - 1;
                        int iP = r25.P(obj.hashCode());
                        while (true) {
                            int i = iP & length;
                            int i2 = bArr[i] & 255;
                            if (i2 == 255) {
                                break;
                            }
                            if (obj.equals(objArr[i2])) {
                                obj2 = objArr[i2 ^ 1];
                                break;
                            }
                            iP = i + 1;
                        }
                    } else if (obj4 instanceof short[]) {
                        short[] sArr = (short[]) obj4;
                        int length2 = sArr.length - 1;
                        int iP2 = r25.P(obj.hashCode());
                        while (true) {
                            int i3 = iP2 & length2;
                            int i4 = sArr[i3] & 65535;
                            if (i4 == 65535) {
                                break;
                            }
                            if (obj.equals(objArr[i4])) {
                                obj2 = objArr[i4 ^ 1];
                                break;
                            }
                            iP2 = i3 + 1;
                        }
                    } else {
                        int[] iArr = (int[]) obj4;
                        int length3 = iArr.length - 1;
                        int iP3 = r25.P(obj.hashCode());
                        while (true) {
                            int i5 = iP3 & length3;
                            int i6 = iArr[i5];
                            if (i6 == -1) {
                                break;
                            }
                            if (obj.equals(objArr[i6])) {
                                obj2 = objArr[i6 ^ 1];
                                break;
                            }
                            iP3 = i5 + 1;
                        }
                    }
                }
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.Y;
    }
}
