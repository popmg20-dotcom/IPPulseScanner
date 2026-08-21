package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a34 extends c34 {
    static {
        d34.a(Long.TYPE);
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((long[]) obj).length == 0;
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        long[] jArr = (long[]) obj;
        int i = 0;
        if (jArr.length == 1 && p(gt3Var)) {
            int length = jArr.length;
            while (i < length) {
                i52Var.i0(jArr[i]);
                i++;
            }
            return;
        }
        int length2 = jArr.length;
        int length3 = jArr.length;
        i52Var.getClass();
        i52.n(length3, length2);
        i52Var.r0(jArr);
        while (i < length2) {
            i52Var.i0(jArr[i]);
            i++;
        }
        i52Var.I();
    }

    @Override // defpackage.le
    public final b72 q(nm nmVar, Boolean bool) {
        return new a34(this, nmVar, bool);
    }

    @Override // defpackage.le
    public final void r(Object obj, i52 i52Var, gt3 gt3Var) {
        for (long j : (long[]) obj) {
            i52Var.i0(j);
        }
    }
}
