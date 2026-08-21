package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tg1 implements zf1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ zf1 f;
    public final /* synthetic */ Object z;

    public /* synthetic */ tg1(zf1 zf1Var, Object obj, int i) {
        this.b = i;
        this.f = zf1Var;
        this.z = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b1, code lost:
    
        if (r15 == r5) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b1 -> B:35:0x00b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00c7 -> B:38:0x00c1). Please report as a decompilation issue!!! */
    @Override // defpackage.zf1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ag1 ag1Var, ge0 ge0Var) throws Throwable {
        sg1 sg1Var;
        long j;
        long j2;
        tg1 tg1Var;
        ag1 ag1Var2;
        Throwable th;
        int i = this.b;
        int i2 = 2;
        Object obj = this.z;
        zf1 zf1Var = this.f;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                if (ge0Var instanceof sg1) {
                    sg1Var = (sg1) ge0Var;
                    int i3 = sg1Var.X;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        sg1Var.X = i3 - Integer.MIN_VALUE;
                    } else {
                        sg1Var = new sg1(this, ge0Var);
                    }
                }
                Object objI = sg1Var.A;
                int i4 = sg1Var.X;
                if (i4 == 0) {
                    n12.S(objI);
                    j = 0;
                    ph1 ph1Var = (ph1) this.f;
                    sg1Var.Z = this;
                    sg1Var.y0 = ag1Var;
                    sg1Var.z0 = null;
                    sg1Var.A0 = j;
                    sg1Var.X = 1;
                    objI = je.o(ph1Var, ag1Var, sg1Var);
                    if (objI != mf0Var) {
                    }
                    return mf0Var;
                }
                if (i4 != 1) {
                    if (i4 != 2) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    j2 = sg1Var.A0;
                    th = sg1Var.z0;
                    ag1Var2 = sg1Var.y0;
                    tg1Var = sg1Var.Z;
                    n12.S(objI);
                    if (!((Boolean) objI).booleanValue()) {
                        throw th;
                    }
                    j2++;
                    boolean z = true;
                    long j3 = j2;
                    ag1Var = ag1Var2;
                    this = tg1Var;
                    j = j3;
                    if (!z) {
                        return xl4Var;
                    }
                    ph1 ph1Var2 = (ph1) this.f;
                    sg1Var.Z = this;
                    sg1Var.y0 = ag1Var;
                    sg1Var.z0 = null;
                    sg1Var.A0 = j;
                    sg1Var.X = 1;
                    objI = je.o(ph1Var2, ag1Var, sg1Var);
                    if (objI != mf0Var) {
                        long j4 = j;
                        tg1Var = this;
                        ag1Var2 = ag1Var;
                        j2 = j4;
                        th = (Throwable) objI;
                        if (th == null) {
                            kl4 kl4Var = (kl4) tg1Var.z;
                            Long l = new Long(j2);
                            sg1Var.Z = tg1Var;
                            sg1Var.y0 = ag1Var2;
                            sg1Var.z0 = th;
                            sg1Var.A0 = j2;
                            sg1Var.X = 2;
                            objI = kl4Var.i(ag1Var2, th, l, sg1Var);
                            break;
                        } else {
                            z = false;
                            long j32 = j2;
                            ag1Var = ag1Var2;
                            this = tg1Var;
                            j = j32;
                            if (!z) {
                            }
                            ph1 ph1Var22 = (ph1) this.f;
                            sg1Var.Z = this;
                            sg1Var.y0 = ag1Var;
                            sg1Var.z0 = null;
                            sg1Var.A0 = j;
                            sg1Var.X = 1;
                            objI = je.o(ph1Var22, ag1Var, sg1Var);
                            if (objI != mf0Var) {
                            }
                        }
                    }
                    return mf0Var;
                }
                j2 = sg1Var.A0;
                ag1 ag1Var3 = sg1Var.y0;
                tg1 tg1Var2 = sg1Var.Z;
                n12.S(objI);
                tg1Var = tg1Var2;
                ag1Var2 = ag1Var3;
                th = (Throwable) objI;
                if (th == null) {
                }
                break;
            case 1:
                Object objA = ((pg1) zf1Var).a(new eg1(new xg3(), ag1Var, (gd) obj), ge0Var);
                return objA == mf0Var ? objA : xl4Var;
            default:
                Object objA2 = zf1Var.a(new tf(i2, ag1Var, (vh1) obj), ge0Var);
                return objA2 == mf0Var ? objA2 : xl4Var;
        }
    }
}
