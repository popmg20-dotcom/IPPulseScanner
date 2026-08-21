package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w24 extends le {
    static {
        d34.a(Boolean.TYPE);
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((boolean[]) obj).length == 0;
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        boolean[] zArr = (boolean[]) obj;
        int i = 0;
        if (zArr.length == 1 && p(gt3Var)) {
            int length = zArr.length;
            while (i < length) {
                i52Var.F(zArr[i]);
                i++;
            }
            return;
        }
        i52Var.r0(zArr);
        int length2 = zArr.length;
        while (i < length2) {
            i52Var.F(zArr[i]);
            i++;
        }
        i52Var.I();
    }

    @Override // defpackage.le
    public final b72 q(nm nmVar, Boolean bool) {
        return new w24(this, nmVar, bool);
    }

    @Override // defpackage.le
    public final void r(Object obj, i52 i52Var, gt3 gt3Var) {
        for (boolean z : (boolean[]) obj) {
            i52Var.F(z);
        }
    }

    @Override // defpackage.hd0
    public final hd0 o(zj4 zj4Var) {
        return this;
    }
}
