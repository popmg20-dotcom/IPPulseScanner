package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class cw0 implements ag1 {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ ag1 f;
    public final /* synthetic */ bh3 z;

    public cw0(dw0 dw0Var, bh3 bh3Var, ag1 ag1Var) {
        this.z = bh3Var;
        this.f = ag1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) {
        bw0 bw0Var;
        rg1 rg1Var;
        int i = this.b;
        Object obj2 = xl4.a;
        ag1 ag1Var = this.f;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                if (ge0Var instanceof bw0) {
                    bw0Var = (bw0) ge0Var;
                    int i2 = bw0Var.Y;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        bw0Var.Y = i2 - Integer.MIN_VALUE;
                    } else {
                        bw0Var = new bw0(this, ge0Var);
                    }
                }
                Object obj3 = bw0Var.A;
                int i3 = bw0Var.Y;
                if (i3 != 0) {
                    if (i3 == 1) {
                        n12.S(obj3);
                        return obj2;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj3);
                bh3 bh3Var = this.z;
                Object obj4 = bh3Var.b;
                if (obj4 != at2.a && n12.c(obj4, obj)) {
                    return obj2;
                }
                bh3Var.b = obj;
                bw0Var.Y = 1;
                return ag1Var.h(obj, bw0Var) == mf0Var ? mf0Var : obj2;
            default:
                if (ge0Var instanceof rg1) {
                    rg1Var = (rg1) ge0Var;
                    int i4 = rg1Var.Z;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        rg1Var.Z = i4 - Integer.MIN_VALUE;
                    } else {
                        rg1Var = new rg1(this, ge0Var);
                    }
                }
                Object obj5 = rg1Var.X;
                int i5 = rg1Var.Z;
                try {
                    if (i5 == 0) {
                        n12.S(obj5);
                        rg1Var.A = this;
                        rg1Var.Z = 1;
                        Object objH = ag1Var.h(obj, rg1Var);
                        this = objH;
                        if (objH == mf0Var) {
                            obj2 = mf0Var;
                            this = objH;
                        }
                    } else {
                        if (i5 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        cw0 cw0Var = rg1Var.A;
                        n12.S(obj5);
                        this = cw0Var;
                    }
                    return obj2;
                } catch (Throwable th) {
                    this.z.b = th;
                    throw th;
                }
        }
    }

    public cw0(ag1 ag1Var, bh3 bh3Var) {
        this.f = ag1Var;
        this.z = bh3Var;
    }
}
