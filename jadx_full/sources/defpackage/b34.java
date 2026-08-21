package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b34 extends c34 {
    static {
        d34.a(Short.TYPE);
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((short[]) obj).length == 0;
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        short[] sArr = (short[]) obj;
        int i = 0;
        if (sArr.length == 1 && p(gt3Var)) {
            int length = sArr.length;
            while (i < length) {
                i52Var.c0(sArr[i]);
                i++;
            }
            return;
        }
        i52Var.r0(sArr);
        int length2 = sArr.length;
        while (i < length2) {
            i52Var.c0(sArr[i]);
            i++;
        }
        i52Var.I();
    }

    @Override // defpackage.le
    public final b72 q(nm nmVar, Boolean bool) {
        return new b34(this, nmVar, bool);
    }

    @Override // defpackage.le
    public final void r(Object obj, i52 i52Var, gt3 gt3Var) {
        for (short s : (short[]) obj) {
            i52Var.c0(s);
        }
    }
}
