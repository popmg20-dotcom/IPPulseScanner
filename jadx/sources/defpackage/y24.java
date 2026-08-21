package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y24 extends c34 {
    static {
        d34.a(Float.TYPE);
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((float[]) obj).length == 0;
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        float[] fArr = (float[]) obj;
        int i = 0;
        if (fArr.length == 1 && p(gt3Var)) {
            int length = fArr.length;
            while (i < length) {
                i52Var.Z(fArr[i]);
                i++;
            }
            return;
        }
        i52Var.r0(fArr);
        int length2 = fArr.length;
        while (i < length2) {
            i52Var.Z(fArr[i]);
            i++;
        }
        i52Var.I();
    }

    @Override // defpackage.le
    public final b72 q(nm nmVar, Boolean bool) {
        return new y24(this, nmVar, bool);
    }

    @Override // defpackage.le
    public final void r(Object obj, i52 i52Var, gt3 gt3Var) {
        for (float f : (float[]) obj) {
            i52Var.Z(f);
        }
    }
}
