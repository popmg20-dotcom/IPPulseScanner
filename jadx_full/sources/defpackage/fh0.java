package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fh0 extends v74 implements Function2 {
    public final /* synthetic */ Object A0;
    public final /* synthetic */ Object B0;
    public final /* synthetic */ int X = 0;
    public int Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ boolean y0;
    public Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fh0(vh4 vh4Var, int[] iArr, boolean z, String[] strArr, ge0 ge0Var) {
        super(2, ge0Var);
        this.z0 = vh4Var;
        this.A0 = iArr;
        this.y0 = z;
        this.B0 = strArr;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((fh0) n((ge0) obj2, (jg4) obj)).p(xl4Var);
            default:
                ((fh0) n((ge0) obj2, (ag1) obj)).p(xl4Var);
                return mf0.b;
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.B0;
        Object obj3 = this.A0;
        switch (i) {
            case 0:
                fh0 fh0Var = new fh0(ge0Var, (am1) obj2, (pl3) obj3, this.y0);
                fh0Var.Z = obj;
                return fh0Var;
            default:
                fh0 fh0Var2 = new fh0((vh4) this.z0, (int[]) obj3, this.y0, (String[]) obj2, ge0Var);
                fh0Var2.Z = obj;
                return fh0Var2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        ig4 ig4Var;
        jg4 jg4Var;
        jg4 jg4Var2;
        Object objA;
        Object objD;
        Object obj2;
        ag1 ag1Var;
        Object objH;
        mt mtVar;
        int i = this.X;
        Object obj3 = this.B0;
        mf0 mf0Var = mf0.b;
        Object obj4 = this.A0;
        int i2 = 1;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                am1 am1Var = (am1) obj3;
                pl3 pl3Var = (pl3) obj4;
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    jg4 jg4Var3 = (jg4) this.Z;
                    jg4Var3.getClass();
                    return am1Var.g(((ld3) jg4Var3).c());
                }
                if (i3 == 1) {
                    ig4Var = (ig4) this.z0;
                    jg4Var = (jg4) this.Z;
                    n12.S(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        y12 y12VarG = pl3Var.g();
                        this.Z = jg4Var;
                        this.z0 = ig4Var;
                        this.Y = 2;
                        if (y12VarG.c(this) == mf0Var) {
                            return mf0Var;
                        }
                    }
                } else if (i3 == 2) {
                    ig4Var = (ig4) this.z0;
                    jg4Var = (jg4) this.Z;
                    n12.S(obj);
                } else {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        Object obj5 = this.Z;
                        n12.S(obj);
                        obj2 = obj5;
                        objD = obj;
                        if (!((Boolean) objD).booleanValue()) {
                            return obj2;
                        }
                        y12 y12VarG2 = pl3Var.g();
                        y12VarG2.b.d(y12VarG2.e, y12VarG2.f);
                        return obj2;
                    }
                    jg4Var2 = (jg4) this.Z;
                    n12.S(obj);
                    objA = obj;
                    if (!this.y0) {
                        return objA;
                    }
                    this.Z = objA;
                    this.Y = 4;
                    objD = jg4Var2.d(this);
                    if (objD == mf0Var) {
                        return mf0Var;
                    }
                    obj2 = objA;
                    if (!((Boolean) objD).booleanValue()) {
                    }
                }
                jg4 jg4Var4 = jg4Var;
                ig4 ig4Var2 = ig4Var;
                jg4Var2 = jg4Var4;
                ah0 ah0Var = new ah0(ge0Var, am1Var, i2);
                this.Z = jg4Var2;
                this.z0 = null;
                this.Y = 3;
                objA = jg4Var2.a(ig4Var2, ah0Var, this);
                if (objA == mf0Var) {
                    return mf0Var;
                }
                if (!this.y0) {
                }
                break;
            default:
                int[] iArr = (int[]) obj4;
                vh4 vh4Var = (vh4) this.z0;
                int i4 = this.Y;
                try {
                    if (i4 == 0) {
                        n12.S(obj);
                        ag1Var = (ag1) this.Z;
                        if (vh4Var.h.r(iArr)) {
                            pl3 pl3Var2 = vh4Var.a;
                            this.Z = ag1Var;
                            this.Y = 1;
                            objH = ke0.h(pl3Var2, this);
                            if (objH == mf0Var) {
                                return mf0Var;
                            }
                            mtVar = new mt(vh4Var, ge0Var, 20);
                            this.Z = ag1Var;
                            this.Y = 2;
                            if (ji0.b0((cf0) objH, mtVar, this) == mf0Var) {
                            }
                        }
                    } else if (i4 == 1) {
                        ag1Var = (ag1) this.Z;
                        n12.S(obj);
                        objH = obj;
                        mtVar = new mt(vh4Var, ge0Var, 20);
                        this.Z = ag1Var;
                        this.Y = 2;
                        if (ji0.b0((cf0) objH, mtVar, this) == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                xe.q("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            n12.S(obj);
                            throw new t80();
                        }
                        ag1Var = (ag1) this.Z;
                        n12.S(obj);
                    }
                    ag1 ag1Var2 = ag1Var;
                    bh3 bh3Var = new bh3();
                    oj1 oj1Var = vh4Var.i;
                    nh4 nh4Var = new nh4(bh3Var, this.y0, ag1Var2, (String[]) obj3, iArr);
                    this.Z = null;
                    this.Y = 3;
                    oj1Var.x(nh4Var, this);
                    return mf0Var;
                } catch (Throwable th) {
                    vh4Var.h.s(iArr);
                    throw th;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fh0(ge0 ge0Var, am1 am1Var, pl3 pl3Var, boolean z) {
        super(2, ge0Var);
        this.y0 = z;
        this.A0 = pl3Var;
        this.B0 = am1Var;
    }
}
