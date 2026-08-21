package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ay2 {
    public static final zf2 a = new zf2(21);

    /* JADX WARN: Removed duplicated region for block: B:83:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.xo a(defpackage.pt0 r18) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ay2.a(pt0):xo");
    }

    /* JADX WARN: Removed duplicated region for block: B:260:0x048f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.pk0 b(int r24, int[] r25, int[] r26) throws defpackage.d40, defpackage.qi1 {
        /*
            Method dump skipped, instruction units count: 1482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ay2.b(int, int[], int[]):pk0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x0035, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0035, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0035, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.tj c(defpackage.cn r20, int r21, int r22, boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ay2.c(cn, int, int, boolean, int, int, int, int):tj");
    }

    public static pt0 d(cn cnVar, xo xoVar, xk3 xk3Var, boolean z, int i, int i2) {
        boolean z2 = z;
        pt0 pt0Var = new pt0(xoVar, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int i5 = (int) xk3Var.a;
            int i6 = (int) xk3Var.b;
            while (i6 <= xoVar.i && i6 >= xoVar.h) {
                tj tjVarC = c(cnVar, 0, cnVar.b, z2, i5, i6, i, i2);
                if (tjVarC != null) {
                    ((tj[]) pt0Var.z)[pt0Var.L(i6)] = tjVarC;
                    i5 = z ? tjVarC.b : tjVarC.c;
                }
                i6 += i4;
                z2 = z;
            }
            i3++;
            z2 = z;
        }
        return pt0Var;
    }
}
