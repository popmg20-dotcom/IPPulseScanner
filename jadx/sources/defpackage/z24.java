package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z24 extends le {
    static {
        d34.a(Integer.TYPE);
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((int[]) obj).length == 0;
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        int[] iArr = (int[]) obj;
        int i = 0;
        if (iArr.length == 1 && p(gt3Var)) {
            int length = iArr.length;
            while (i < length) {
                i52Var.c0(iArr[i]);
                i++;
            }
            return;
        }
        int length2 = iArr.length;
        int length3 = iArr.length;
        i52Var.getClass();
        i52.n(length3, length2);
        i52Var.r0(iArr);
        while (i < length2) {
            i52Var.c0(iArr[i]);
            i++;
        }
        i52Var.I();
    }

    @Override // defpackage.le
    public final b72 q(nm nmVar, Boolean bool) {
        return new z24(this, nmVar, bool);
    }

    @Override // defpackage.le
    public final void r(Object obj, i52 i52Var, gt3 gt3Var) {
        for (int i : (int[]) obj) {
            i52Var.c0(i);
        }
    }

    @Override // defpackage.hd0
    public final hd0 o(zj4 zj4Var) {
        return this;
    }
}
