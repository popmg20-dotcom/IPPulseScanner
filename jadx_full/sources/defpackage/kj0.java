package defpackage;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kj0 extends v74 implements Function2 {
    public /* synthetic */ Object A0;
    public final /* synthetic */ Object B0;
    public final /* synthetic */ Object C0;
    public final /* synthetic */ int X = 1;
    public int Y;
    public final /* synthetic */ boolean Z;
    public Object y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kj0(aa1 aa1Var, ma1 ma1Var, boolean z, String str, String str2, ge0 ge0Var) {
        super(2, ge0Var);
        this.z0 = aa1Var;
        this.A0 = ma1Var;
        this.Z = z;
        this.B0 = str;
        this.C0 = str2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((kj0) n((ge0) obj2, (je1) obj)).p(xl4Var);
            case 1:
                return ((kj0) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                return ((kj0) n((ge0) obj2, (lf0) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.B0;
        Object obj3 = this.C0;
        Object obj4 = this.z0;
        switch (i) {
            case 0:
                kj0 kj0Var = new kj0((zg3) obj4, (lj0) obj3, this.B0, this.Z, ge0Var);
                kj0Var.A0 = obj;
                return kj0Var;
            case 1:
                return new kj0((aa1) obj4, (ma1) this.A0, this.Z, (String) obj2, (String) obj3, ge0Var);
            default:
                kj0 kj0Var2 = new kj0((ma1) this.y0, (aa1) obj4, this.Z, (String) obj2, (String) obj3, ge0Var);
                kj0Var2.A0 = obj;
                return kj0Var2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0175, code lost:
    
        if (r8.b(r4, r21) == r9) goto L53;
     */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [cf0, ge0, of0] */
    /* JADX WARN: Type inference failed for: r3v7 */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        je1 je1Var;
        Object num;
        zg3 zg3Var;
        ?? r3;
        Object objB0;
        aa1 aa1Var;
        cm2 cm2Var;
        int i = this.X;
        boolean z = this.Z;
        xl4 xl4Var = xl4.a;
        Object obj2 = this.C0;
        Object obj3 = this.B0;
        Object obj4 = this.z0;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                lj0 lj0Var = (lj0) obj2;
                zg3 zg3Var2 = (zg3) obj4;
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    je1Var = (je1) this.A0;
                    nx3 nx3VarC = lj0Var.c();
                    this.A0 = je1Var;
                    this.y0 = zg3Var2;
                    this.Y = 1;
                    num = new Integer(((AtomicInteger) nx3VarC.b.f).incrementAndGet());
                    if (num != mf0Var) {
                        zg3Var = zg3Var2;
                    }
                    return mf0Var;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    if (!z) {
                        return xl4Var;
                    }
                    lj0Var.y0.x(new fi0(obj3 != null ? obj3.hashCode() : 0, zg3Var2.b, obj3));
                    return xl4Var;
                }
                zg3Var = (zg3) this.y0;
                je1Var = (je1) this.A0;
                n12.S(obj);
                num = obj;
                zg3Var.b = ((Number) num).intValue();
                this.A0 = null;
                this.y0 = null;
                this.Y = 2;
                break;
            case 1:
                aa1 aa1Var2 = (aa1) obj4;
                ma1 ma1Var = (ma1) this.A0;
                ca1 ca1Var = ma1Var.z;
                int i3 = this.Y;
                ge0 ge0Var = null;
                if (i3 == 0) {
                    n12.S(obj);
                    gm0 gm0Var = qv0.a;
                    pl0 pl0Var = pl0.z;
                    ej ejVar = new ej((String) obj3, aa1Var2, (String) obj2, ge0Var, 3);
                    r3 = 0;
                    this.y0 = aa1Var2;
                    this.Y = 1;
                    objB0 = ji0.b0(pl0Var, ejVar, this);
                    if (objB0 == mf0Var) {
                        return mf0Var;
                    }
                    aa1Var = aa1Var2;
                } else {
                    if (i3 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    aa1 aa1Var3 = (aa1) this.y0;
                    n12.S(obj);
                    objB0 = obj;
                    aa1Var = aa1Var3;
                    r3 = 0;
                }
                aa1Var.c = ((Number) objB0).longValue();
                int iIndexOf = ca1Var.d.f.indexOf(aa1Var2);
                if (iIndexOf != -1) {
                    ca1Var.e(iIndexOf);
                }
                if (z || (cm2Var = ma1Var.b) == null) {
                    return xl4Var;
                }
                ((LinearProgressIndicator) cm2Var.X).b();
                ji0.B(uf2.t(ma1Var), r3, r3, new uf(ma1Var, aa1Var2, r3, 8), 3);
                return xl4Var;
            default:
                lf0 lf0Var = (lf0) this.A0;
                int i4 = this.Y;
                if (i4 == 0) {
                    n12.S(obj);
                    ma1 ma1Var2 = (ma1) this.y0;
                    aa1 aa1Var4 = (aa1) obj4;
                    String str = (String) obj3;
                    String str2 = (String) obj2;
                    r92 lifecycle = ma1Var2.getLifecycle();
                    gm0 gm0Var2 = qv0.a;
                    tq1 tq1Var = qf2.a.X;
                    cf0 cf0Var = this.f;
                    cf0Var.getClass();
                    boolean zQ0 = tq1Var.q0(cf0Var);
                    boolean z2 = this.Z;
                    q92 q92Var = q92.X;
                    if (!zQ0) {
                        if (lifecycle.b() == q92.b) {
                            vp1.m();
                        } else if (lifecycle.b().compareTo(q92Var) >= 0) {
                            ji0.B(lf0Var, null, null, new kj0(aa1Var4, ma1Var2, z2, str, str2, (ge0) null), 3);
                            return xl4Var;
                        }
                    }
                    la1 la1Var = new la1(lf0Var, aa1Var4, ma1Var2, z2, str, str2);
                    this.A0 = null;
                    this.Y = 1;
                    return ji0.V(lifecycle, q92Var, zQ0, tq1Var, la1Var, this) == mf0Var ? mf0Var : xl4Var;
                }
                if (i4 == 1) {
                    n12.S(obj);
                    return xl4Var;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kj0(ma1 ma1Var, aa1 aa1Var, boolean z, String str, String str2, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = ma1Var;
        this.z0 = aa1Var;
        this.Z = z;
        this.B0 = str;
        this.C0 = str2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kj0(zg3 zg3Var, lj0 lj0Var, Object obj, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.z0 = zg3Var;
        this.C0 = lj0Var;
        this.B0 = obj;
        this.Z = z;
    }
}
