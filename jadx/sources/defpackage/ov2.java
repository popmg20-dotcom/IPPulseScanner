package defpackage;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ov2 implements be3 {
    public static float c(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    public static void d(int i, bn bnVar, int[] iArr) throws qs2 {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int i3 = bnVar.f;
        if (i >= i3) {
            throw qs2.a();
        }
        boolean z = !bnVar.d(i);
        while (i < i3) {
            if (bnVar.d(i) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != i3) {
                throw qs2.a();
            }
        }
    }

    public static void e(int i, bn bnVar, int[] iArr) throws qs2 {
        int length = iArr.length;
        boolean zD = bnVar.d(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bnVar.d(i) != zD) {
                length--;
                zD = !zD;
            }
        }
        if (length >= 0) {
            throw qs2.a();
        }
        d(i + 1, bnVar, iArr);
    }

    @Override // defpackage.be3
    public vk3 a(lb lbVar) throws qs2 {
        int i;
        lb lbVar2 = lbVar;
        kf2 kf2Var = (kf2) ((iv1) lbVar2.f).f;
        int i2 = kf2Var.a;
        int i3 = kf2Var.b;
        bn bnVar = new bn(i2);
        int i4 = 1;
        int iMax = Math.max(1, i3 >> 5);
        int i5 = i3 / 2;
        EnumMap enumMap = null;
        int i6 = 0;
        while (i6 < 15) {
            int i7 = i6 + 1;
            int i8 = i7 / 2;
            if ((i6 & 1) != 0) {
                i8 = -i8;
            }
            int i9 = (i8 * iMax) + i5;
            if (i9 < 0 || i9 >= i3) {
                break;
            }
            try {
                bnVar = lbVar2.v(bnVar, i9);
                int i10 = 0;
                while (i10 < 2) {
                    if (i10 == i4) {
                        bnVar.i();
                        if (enumMap != null) {
                            fk0 fk0Var = fk0.X;
                            if (enumMap.containsKey(fk0Var)) {
                                EnumMap enumMap2 = new EnumMap(fk0.class);
                                enumMap2.putAll(enumMap);
                                enumMap2.remove(fk0Var);
                                enumMap = enumMap2;
                            }
                        }
                    }
                    try {
                        vk3 vk3VarB = b(i9, bnVar, enumMap);
                        if (i10 == i4) {
                            vk3VarB.b(wk3.b, 180);
                            xk3[] xk3VarArr = vk3VarB.c;
                            if (xk3VarArr != null) {
                                i = i4;
                                float f = i2;
                                try {
                                    xk3 xk3Var = xk3VarArr[0];
                                    xk3VarArr[0] = new xk3((f - xk3Var.a) - 1.0f, xk3Var.b);
                                    xk3 xk3Var2 = xk3VarArr[i];
                                    xk3VarArr[i] = new xk3((f - xk3Var2.a) - 1.0f, xk3Var2.b);
                                } catch (de3 unused) {
                                    continue;
                                    i10++;
                                    i4 = i;
                                }
                            }
                        }
                        return vk3VarB;
                    } catch (de3 unused2) {
                        i = i4;
                    }
                }
            } catch (qs2 unused3) {
            }
            lbVar2 = lbVar;
            i6 = i7;
            i4 = i4;
        }
        throw qs2.a();
    }

    public abstract vk3 b(int i, bn bnVar, Map map);

    @Override // defpackage.be3
    public void reset() {
    }
}
