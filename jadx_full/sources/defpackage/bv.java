package defpackage;

import android.os.Build;
import android.util.Log;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bv extends v74 implements em1 {
    public final /* synthetic */ int X;
    public int Y;
    public Object Z;
    public /* synthetic */ Object y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bv(ge0 ge0Var, Object obj, int i) {
        super(3, ge0Var);
        this.X = i;
        this.z0 = obj;
    }

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        Object obj4 = this.z0;
        switch (i) {
            case 0:
                bv bvVar = new bv((ge0) obj3, (z50) obj4, 0);
                bvVar.Z = (ag1) obj;
                bvVar.y0 = obj2;
                return bvVar.p(xl4Var);
            case 1:
                bv bvVar2 = new bv((Function2) obj4, (ge0) obj3, 1);
                bvVar2.Z = (ag1) obj;
                bvVar2.y0 = obj2;
                return bvVar2.p(xl4Var);
            case 2:
                ((Boolean) obj2).getClass();
                bv bvVar3 = new bv((oy2) obj4, (ge0) obj3, 2);
                bvVar3.y0 = (ky2) obj;
                return bvVar3.p(xl4Var);
            case 3:
                bv bvVar4 = new bv((ge0) obj3, (oy2) obj4, 3);
                bvVar4.Z = (ag1) obj;
                bvVar4.y0 = obj2;
                return bvVar4.p(xl4Var);
            default:
                bv bvVar5 = new bv((ge0) obj3, (pj3) obj4, 4);
                bvVar5.Z = (ag1) obj;
                bvVar5.y0 = obj2;
                return bvVar5.p(xl4Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x02b2, code lost:
    
        if (r2.h(r3, r18) == r1) goto L119;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01cf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f9  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        ag1 ag1Var;
        Object objK;
        ky2 ky2Var;
        Object objA;
        b03 b03Var;
        hj3 hj3Var;
        Object objB;
        List list;
        b03 b03Var2;
        Integer numValueOf;
        b03 b03Var3;
        z50 z50Var;
        int i = 3;
        int i2 = 0;
        int i3 = 2;
        int i4 = 1;
        ge0 ge0Var = null;
        switch (this.X) {
            case 0:
                mf0 mf0Var = mf0.b;
                int i5 = this.Y;
                if (i5 == 0) {
                    n12.S(obj);
                    ag1 ag1Var2 = (ag1) this.Z;
                    gn2 gn2Var = new gn2((z50) this.z0, (kz2) this.y0);
                    this.Y = 1;
                    if (ag1Var2.h(gn2Var, this) == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i5 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 1:
                mf0 mf0Var2 = mf0.b;
                int i6 = this.Y;
                if (i6 == 0) {
                    n12.S(obj);
                    ag1Var = (ag1) this.Z;
                    Object obj2 = this.y0;
                    Function2 function2 = (Function2) this.z0;
                    this.Z = ag1Var;
                    this.Y = 1;
                    objK = function2.k(obj2, this);
                    if (objK != mf0Var2) {
                    }
                    return mf0Var2;
                }
                if (i6 != 1) {
                    if (i6 == 2) {
                        n12.S(obj);
                        return xl4.a;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ag1Var = (ag1) this.Z;
                n12.S(obj);
                objK = obj;
                this.Z = null;
                this.Y = 2;
                break;
            case 2:
                oy2 oy2Var = (oy2) this.z0;
                mf0 mf0Var3 = mf0.b;
                int i7 = this.Y;
                if (i7 == 0) {
                    n12.S(obj);
                    ky2Var = (ky2) this.y0;
                    hj3 hj3Var2 = ky2Var != null ? ky2Var.a.b : null;
                    this.y0 = ky2Var;
                    this.Y = 1;
                    objA = oy2Var.a(hj3Var2, this);
                    if (objA != mf0Var3) {
                    }
                    return mf0Var3;
                }
                if (i7 != 1) {
                    if (i7 != 2) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    hj3Var = (hj3) this.Z;
                    ky2 ky2Var2 = (ky2) this.y0;
                    n12.S(obj);
                    ky2Var = ky2Var2;
                    objB = obj;
                    b03Var = (b03) objB;
                    list = b03Var != null ? b03Var.a : null;
                    if ((list == null || list.isEmpty()) && ky2Var != null && (b03Var2 = ky2Var.b) != null && (!b03Var2.a.isEmpty())) {
                    }
                    if ((b03Var != null ? b03Var.b : null) == null) {
                        if (((ky2Var == null || (b03Var3 = ky2Var.b) == null) ? null : b03Var3.b) != null) {
                            b03Var = ky2Var.b;
                        }
                    }
                    if (b03Var == null) {
                        numValueOf = null;
                    } else {
                        hj3Var.getClass();
                        Integer num = b03Var.b;
                        numValueOf = num != null ? Integer.valueOf(Math.max(0, num.intValue() - (b03Var.c.b / 2))) : null;
                        if (Build.ID != null && Log.isLoggable("Paging", 3)) {
                            Log.d("Paging", "Refresh key " + numValueOf + " returned from PagingSource " + hj3Var, null);
                        }
                    }
                    if (ky2Var != null) {
                        ky2Var.a.i.g(null);
                    }
                    if (ky2Var != null) {
                        ky2Var.c.g(null);
                    }
                    return new ky2(new az2(numValueOf, hj3Var, oy2Var.b, (av) oy2Var.d.z, b03Var, new ly2(0, oy2Var, oy2.class, "refresh", "refresh()V", 0, 0)), b03Var, je.b());
                }
                ky2Var = (ky2) this.y0;
                n12.S(obj);
                objA = obj;
                hj3 hj3Var3 = (hj3) objA;
                if (ky2Var == null) {
                    b03Var = null;
                    hj3Var = hj3Var3;
                    if (b03Var != null) {
                    }
                    if (list == null) {
                    }
                    if ((b03Var != null ? b03Var.b : null) == null) {
                    }
                    if (b03Var == null) {
                    }
                    if (ky2Var != null) {
                    }
                    if (ky2Var != null) {
                    }
                    return new ky2(new az2(numValueOf, hj3Var, oy2Var.b, (av) oy2Var.d.z, b03Var, new ly2(0, oy2Var, oy2.class, "refresh", "refresh()V", 0, 0)), b03Var, je.b());
                }
                az2 az2Var = ky2Var.a;
                this.y0 = ky2Var;
                this.Z = hj3Var3;
                this.Y = 2;
                objB = az2Var.b(this);
                if (objB != mf0Var3) {
                    hj3Var = hj3Var3;
                    b03Var = (b03) objB;
                    if (b03Var != null) {
                    }
                    b03Var = list == null ? b03Var2 : b03Var2;
                    if ((b03Var != null ? b03Var.b : null) == null) {
                    }
                    if (b03Var == null) {
                    }
                    if (ky2Var != null) {
                    }
                    if (ky2Var != null) {
                    }
                    return new ky2(new az2(numValueOf, hj3Var, oy2Var.b, (av) oy2Var.d.z, b03Var, new ly2(0, oy2Var, oy2.class, "refresh", "refresh()V", 0, 0)), b03Var, je.b());
                }
                return mf0Var3;
            case 3:
                oy2 oy2Var2 = (oy2) this.z0;
                mf0 mf0Var4 = mf0.b;
                int i8 = this.Y;
                if (i8 == 0) {
                    n12.S(obj);
                    ag1 ag1Var3 = (ag1) this.Z;
                    ky2 ky2Var3 = (ky2) this.y0;
                    kz2 kz2Var = new kz2(new pg1(ky2Var3.a.j, new tu(i3, ge0Var, i3), i3), new v62(oy2Var2, oy2Var2.d), new oj1(17, ky2Var3.a), jz2.f);
                    this.Y = 1;
                    if (ag1Var3.h(kz2Var, this) == mf0Var4) {
                        return mf0Var4;
                    }
                } else {
                    if (i8 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            default:
                mf0 mf0Var5 = mf0.b;
                int i9 = this.Y;
                if (i9 == 0) {
                    n12.S(obj);
                    ag1 ag1Var4 = (ag1) this.Z;
                    int i10 = 7;
                    zf1 zf1Var = new oy2(new gz2(new cj(4, (oj3) this.y0), null), new ue2(7)).e;
                    pj3 pj3Var = (pj3) this.z0;
                    synchronized (kq4.a) {
                        z50Var = (z50) pj3Var.c("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
                        if (z50Var == null) {
                            cf0 cf0Var = c41.b;
                            try {
                                gm0 gm0Var = qv0.a;
                                cf0Var = qf2.a.X;
                                break;
                            } catch (IllegalStateException | ss2 unused) {
                            }
                            z50 z50Var2 = new z50(cf0Var.X(gb4.d()));
                            pj3Var.a("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", z50Var2);
                            z50Var = z50Var2;
                        }
                    }
                    zf1Var.getClass();
                    zf1 zf1VarU = ez4.U(new fg1(zf1Var, new bv(ge0Var, z50Var, i2), ge0Var, i4));
                    cv cvVar = new cv(i, ge0Var, i2);
                    zf1VarU.getClass();
                    ng1 ng1Var = new ng1(new pg1(new lt(i3, ge0Var, i4), new av(i2, new av(i10, new fg1(zf1VarU, cvVar, ge0Var, i2)))), new dv(3, null));
                    wl3 wl3Var = vv3.b;
                    y20.m.getClass();
                    int i11 = x20.b;
                    if (1 >= i11) {
                        i11 = 1;
                    }
                    lw2 lw2Var = new lw2(i11 - 1, jp.b, c41.b, ng1Var);
                    hv3 hv3VarA = iv3.a(1, lw2Var.b, (jp) lw2Var.d);
                    ji0.A(z50Var, (cf0) lw2Var.e, wl3Var.equals(vv3.a) ? of0.b : of0.A, new hj((zf1) lw2Var.c, hv3VarA, ge0Var, 15));
                    ee3 ee3Var = new ee3(hv3VarA);
                    this.Z = null;
                    this.y0 = null;
                    this.Y = 1;
                    if (r25.v(ag1Var4, ee3Var, this) == mf0Var5) {
                        return mf0Var5;
                    }
                } else {
                    if (i9 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bv(Object obj, ge0 ge0Var, int i) {
        super(3, ge0Var);
        this.X = i;
        this.z0 = obj;
    }
}
