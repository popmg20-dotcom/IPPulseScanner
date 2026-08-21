package defpackage;

import java.io.Serializable;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hj0 extends v74 implements am1 {
    public final /* synthetic */ Object A0;
    public final /* synthetic */ int X = 0;
    public int Y;
    public final /* synthetic */ lj0 Z;
    public Object y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hj0(bh3 bh3Var, lj0 lj0Var, zg3 zg3Var, ge0 ge0Var) {
        super(1, ge0Var);
        this.z0 = bh3Var;
        this.Z = lj0Var;
        this.A0 = zg3Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        Object obj2 = this.A0;
        Object obj3 = this.z0;
        lj0 lj0Var = this.Z;
        ge0 ge0Var = (ge0) obj;
        switch (i) {
            case 0:
                return new hj0((bh3) obj3, lj0Var, (zg3) obj2, ge0Var).p(xl4Var);
            default:
                return new hj0(lj0Var, (cf0) obj3, (Function2) obj2, ge0Var).p(xl4Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) throws Throwable {
        bh3 bh3Var;
        zg3 zg3Var;
        fi0 fi0Var;
        Object obj2;
        int i = this.X;
        Object obj3 = this.A0;
        Object obj4 = this.z0;
        mf0 mf0Var = mf0.b;
        lj0 lj0Var = this.Z;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                zg3 zg3Var2 = (zg3) obj3;
                bh3 bh3Var2 = (bh3) obj4;
                int i2 = this.Y;
                try {
                } catch (sf0 unused) {
                    Object obj5 = bh3Var2.b;
                    this.y0 = zg3Var2;
                    this.Y = 3;
                    obj = lj0Var.i(obj5, true, this);
                    if (obj == mf0Var) {
                        return mf0Var;
                    }
                }
                if (i2 == 0) {
                    n12.S(obj);
                    this.y0 = bh3Var2;
                    this.Y = 1;
                    obj = ((ee1) lj0Var.A0.getValue()).a(new xi0(3, (ge0) null), this);
                    if (obj == mf0Var) {
                        return mf0Var;
                    }
                    bh3Var = bh3Var2;
                } else {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            zg3Var = (zg3) ((Serializable) this.y0);
                            n12.S(obj);
                            zg3Var.b = ((Number) obj).intValue();
                            return xl4.a;
                        }
                        if (i2 != 3) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        zg3Var2 = (zg3) ((Serializable) this.y0);
                        n12.S(obj);
                        zg3Var2.b = ((Number) obj).intValue();
                        return xl4.a;
                    }
                    bh3Var = (bh3) ((Serializable) this.y0);
                    n12.S(obj);
                }
                bh3Var.b = obj;
                nx3 nx3VarC = lj0Var.c();
                this.y0 = zg3Var2;
                this.Y = 2;
                obj = nx3VarC.a();
                if (obj == mf0Var) {
                    return mf0Var;
                }
                zg3Var = zg3Var2;
                zg3Var.b = ((Number) obj).intValue();
                return xl4.a;
            default:
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    this.Y = 1;
                    obj = lj0Var.h(true, this);
                    if (obj == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                xe.q("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            Object obj6 = this.y0;
                            n12.S(obj);
                            return obj6;
                        }
                        fi0Var = (fi0) this.y0;
                        n12.S(obj);
                        obj2 = fi0Var.b;
                        if ((obj2 == null ? obj2.hashCode() : 0) == fi0Var.c) {
                            xe.q("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
                            return null;
                        }
                        if (!n12.c(fi0Var.b, obj)) {
                            this.y0 = obj;
                            this.Y = 3;
                            if (lj0Var.i(obj, true, this) == mf0Var) {
                                return mf0Var;
                            }
                        }
                        return obj;
                    }
                    n12.S(obj);
                }
                fi0Var = (fi0) obj;
                hj hjVar = new hj((Function2) obj3, fi0Var, ge0Var, 11);
                this.y0 = fi0Var;
                this.Y = 2;
                obj = ji0.b0((cf0) obj4, hjVar, this);
                if (obj == mf0Var) {
                    return mf0Var;
                }
                obj2 = fi0Var.b;
                if ((obj2 == null ? obj2.hashCode() : 0) == fi0Var.c) {
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hj0(lj0 lj0Var, cf0 cf0Var, Function2 function2, ge0 ge0Var) {
        super(1, ge0Var);
        this.Z = lj0Var;
        this.z0 = cf0Var;
        this.A0 = function2;
    }
}
