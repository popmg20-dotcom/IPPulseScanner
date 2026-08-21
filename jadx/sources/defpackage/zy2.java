package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zy2 extends v74 implements Function2 {
    public final /* synthetic */ az2 A0;
    public final /* synthetic */ int X;
    public bz2 Y;
    public yn2 Z;
    public az2 y0;
    public int z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zy2(az2 az2Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.A0 = az2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((zy2) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        az2 az2Var = this.A0;
        switch (i) {
            case 0:
                return new zy2(az2Var, ge0Var, 0);
            default:
                return new zy2(az2Var, ge0Var, 1);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        bz2 bz2Var;
        yn2 yn2Var;
        bz2 bz2Var2;
        yn2 yn2Var2;
        int i = this.X;
        xl4 xl4Var = xl4.a;
        az2 az2Var = this.A0;
        mf0 mf0Var = mf0.b;
        int i2 = 1;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                int i3 = this.z0;
                try {
                    if (i3 == 0) {
                        n12.S(obj);
                        bz2Var = az2Var.h;
                        yn2Var = bz2Var.a;
                        this.Y = bz2Var;
                        this.Z = yn2Var;
                        this.y0 = az2Var;
                        this.z0 = 1;
                        if (yn2Var.g(this) != mf0Var) {
                        }
                        return mf0Var;
                    }
                    if (i3 != 1) {
                        if (i3 == 2) {
                            n12.S(obj);
                            return xl4Var;
                        }
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    az2Var = this.y0;
                    yn2Var = this.Z;
                    bz2Var = this.Y;
                    n12.S(obj);
                    dz2 dz2Var = bz2Var.b;
                    pg1 pg1Var = new pg1(new cz2(dz2Var, ge0Var, i2), ez4.n(dz2Var.g));
                    yn2Var.n(null);
                    this.Y = null;
                    this.Z = null;
                    this.y0 = null;
                    this.z0 = 2;
                    if (az2Var.a(pg1Var, hd2.f, this) != mf0Var) {
                        return xl4Var;
                    }
                    return mf0Var;
                } finally {
                }
            default:
                int i4 = this.z0;
                try {
                    if (i4 == 0) {
                        n12.S(obj);
                        bz2Var2 = az2Var.h;
                        yn2Var2 = bz2Var2.a;
                        this.Y = bz2Var2;
                        this.Z = yn2Var2;
                        this.y0 = az2Var;
                        this.z0 = 1;
                        if (yn2Var2.g(this) != mf0Var) {
                        }
                        return mf0Var;
                    }
                    if (i4 != 1) {
                        if (i4 == 2) {
                            n12.S(obj);
                            return xl4Var;
                        }
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    az2Var = this.y0;
                    yn2Var2 = this.Z;
                    bz2Var2 = this.Y;
                    n12.S(obj);
                    dz2 dz2Var2 = bz2Var2.b;
                    pg1 pg1Var2 = new pg1(new cz2(dz2Var2, ge0Var, 0), ez4.n(dz2Var2.h));
                    yn2Var.n(null);
                    this.Y = null;
                    this.Z = null;
                    this.y0 = null;
                    this.z0 = 2;
                    if (az2Var.a(pg1Var2, hd2.z, this) != mf0Var) {
                        return xl4Var;
                    }
                    return mf0Var;
                } finally {
                }
        }
    }
}
