package defpackage;

import com.getsurfboard.R;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z73 extends v74 implements Function2 {
    public final /* synthetic */ String A0;
    public final /* synthetic */ d83 B0;
    public final /* synthetic */ boolean C0;
    public String X;
    public d83 Y;
    public int Z;
    public int y0;
    public final /* synthetic */ String z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z73(String str, String str2, d83 d83Var, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.z0 = str;
        this.A0 = str2;
        this.B0 = d83Var;
        this.C0 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((z73) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new z73(this.z0, this.A0, this.B0, this.C0, ge0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a7, code lost:
    
        if (defpackage.ji0.V(r0, r3, r4, r10, r4, r22) == r15) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01c2, code lost:
    
        if (defpackage.ji0.b0(r0, r1, r22) == r15) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085 A[PHI: r0 r11
      0x0085: PHI (r0v7 java.lang.Object) = (r0v6 java.lang.Object), (r0v24 java.lang.Object) binds: [B:24:0x0081, B:14:0x003e] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r11v3 java.lang.String) = (r11v1 java.lang.String), (r11v9 java.lang.String) binds: [B:24:0x0081, B:14:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017c  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        String strB;
        Object objB0;
        Throwable thA;
        d83 d83Var;
        x53 x53Var;
        x53 x53Var2;
        Throwable th;
        d83 d83Var2;
        int i;
        e03[] e03VarArr;
        r92 lifecycle;
        tq1 tq1Var;
        boolean zQ0;
        y73 y73Var;
        d83 d83Var3;
        int i2 = this.y0;
        int i3 = 1;
        q92 q92Var = q92.b;
        q92 q92Var2 = q92.X;
        cf0 cf0Var = this.f;
        d83 d83Var4 = this.B0;
        int i4 = 0;
        ge0 ge0Var = null;
        mf0 mf0Var = mf0.b;
        switch (i2) {
            case 0:
                n12.S(obj);
                gm0 gm0Var = qv0.a;
                tq1 tq1Var2 = qf2.a;
                w73 w73Var = new w73(d83Var4, ge0Var, i4);
                this.y0 = 1;
                if (ji0.b0(tq1Var2, w73Var, this) != mf0Var) {
                    String str = this.A0;
                    String str2 = this.z0;
                    strB = str2 != null ? g73.b(str) : str2;
                    gm0 gm0Var2 = qv0.a;
                    pl0 pl0Var = pl0.z;
                    dh0 dh0Var = new dh0(str, str2, this.C0, (ge0) null);
                    this.X = strB;
                    this.y0 = 2;
                    objB0 = ji0.b0(pl0Var, dh0Var, this);
                    if (objB0 != mf0Var) {
                        Object obj2 = ((uk3) objB0).b;
                        thA = uk3.a(obj2);
                        if (thA == null) {
                            r92 lifecycle2 = d83Var4.getLifecycle();
                            gm0 gm0Var3 = qv0.a;
                            tq1 tq1Var3 = qf2.a.X;
                            cf0Var.getClass();
                            boolean zQ02 = tq1Var3.q0(cf0Var);
                            if (!zQ02) {
                                if (lifecycle2.b() == q92Var) {
                                    vp1.m();
                                } else {
                                    if (lifecycle2.b().compareTo(q92Var2) >= 0) {
                                        if (thA instanceof x53) {
                                            x53Var2 = (x53) thA;
                                        } else {
                                            Throwable cause = thA.getCause();
                                            if (cause instanceof x53) {
                                                x53Var2 = (x53) cause;
                                            } else {
                                                x53Var = null;
                                                if (x53Var == null) {
                                                    String str3 = x53Var.b;
                                                    String string = d83Var4.getString(R.string.unknown_error);
                                                    string.getClass();
                                                    d83Var4.o(x53Var, string, strB, str3, new x73(d83Var4, strB, str3, x53Var));
                                                } else {
                                                    String string2 = d83Var4.getString(R.string.unknown_error);
                                                    string2.getClass();
                                                    d83Var4.o(thA, string2, null, null, null);
                                                }
                                            }
                                        }
                                        x53Var = x53Var2;
                                        if (x53Var == null) {
                                        }
                                    }
                                    d83Var = d83Var4;
                                    d83Var.A.g = null;
                                    gm0 gm0Var4 = qv0.a;
                                    tq1 tq1Var4 = qf2.a;
                                    w73 w73Var2 = new w73(d83Var4, ge0Var, i3);
                                    this.X = null;
                                    this.Y = null;
                                    this.y0 = 6;
                                }
                            }
                            nt ntVar = new nt(4, thA, d83Var4, strB);
                            this.X = null;
                            this.Y = d83Var4;
                            this.Z = 0;
                            this.y0 = 5;
                        } else {
                            e03 e03Var = (e03) obj2;
                            e1 e1Var = d73.a;
                            Object obj3 = e03Var.b;
                            zk zkVarE = d73.e(((t53) obj3).b);
                            if (zkVarE == null || zkVarE.O() != ((t53) obj3).f) {
                                d83Var4.A.g = ((t53) obj3).b;
                            }
                            try {
                                e03VarArr = new e03[]{e03Var};
                                this.X = null;
                                this.Y = d83Var4;
                                this.Z = 0;
                                this.y0 = 3;
                            } catch (Throwable th2) {
                                th = th2;
                                d83Var2 = d83Var4;
                                i = 0;
                                th.printStackTrace();
                                lifecycle = d83Var2.getLifecycle();
                                gm0 gm0Var5 = qv0.a;
                                tq1Var = qf2.a.X;
                                cf0Var.getClass();
                                zQ0 = tq1Var.q0(cf0Var);
                                if (!zQ0) {
                                    if (lifecycle.b() == q92Var) {
                                        vp1.m();
                                        return null;
                                    }
                                    if (lifecycle.b().compareTo(q92Var2) >= 0) {
                                        CharSequence text = d83Var2.getText(R.string.unknown_error);
                                        text.getClass();
                                        d83Var2.o(th, text, null, null, null);
                                        d83Var2.A.g = null;
                                        gm0 gm0Var42 = qv0.a;
                                        tq1 tq1Var42 = qf2.a;
                                        w73 w73Var22 = new w73(d83Var4, ge0Var, i3);
                                        this.X = null;
                                        this.Y = null;
                                        this.y0 = 6;
                                    }
                                    break;
                                }
                                y73Var = new y73(d83Var2, th, i4);
                                this.X = null;
                                this.Y = d83Var2;
                                this.Z = i;
                                this.y0 = 4;
                                if (ji0.V(lifecycle, q92Var2, zQ0, tq1Var, y73Var, this) != mf0Var) {
                                    d83Var3 = d83Var2;
                                    d83Var2 = d83Var3;
                                    d83Var2.A.g = null;
                                    gm0 gm0Var422 = qv0.a;
                                    tq1 tq1Var422 = qf2.a;
                                    w73 w73Var222 = new w73(d83Var4, ge0Var, i3);
                                    this.X = null;
                                    this.Y = null;
                                    this.y0 = 6;
                                    break;
                                }
                                return mf0Var;
                            }
                            if (d73.j(e03VarArr, this) != mf0Var) {
                                gm0 gm0Var4222 = qv0.a;
                                tq1 tq1Var4222 = qf2.a;
                                w73 w73Var2222 = new w73(d83Var4, ge0Var, i3);
                                this.X = null;
                                this.Y = null;
                                this.y0 = 6;
                            }
                        }
                    }
                }
                break;
            case 1:
                n12.S(obj);
                String str4 = this.A0;
                String str22 = this.z0;
                if (str22 != null) {
                }
                gm0 gm0Var22 = qv0.a;
                pl0 pl0Var2 = pl0.z;
                dh0 dh0Var2 = new dh0(str4, str22, this.C0, (ge0) null);
                this.X = strB;
                this.y0 = 2;
                objB0 = ji0.b0(pl0Var2, dh0Var2, this);
                if (objB0 != mf0Var) {
                }
                break;
            case 2:
                String str5 = this.X;
                n12.S(obj);
                strB = str5;
                objB0 = obj;
                Object obj22 = ((uk3) objB0).b;
                thA = uk3.a(obj22);
                if (thA == null) {
                }
                break;
            case 3:
                i = this.Z;
                d83Var2 = this.Y;
                try {
                    n12.S(obj);
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                    lifecycle = d83Var2.getLifecycle();
                    gm0 gm0Var52 = qv0.a;
                    tq1Var = qf2.a.X;
                    cf0Var.getClass();
                    zQ0 = tq1Var.q0(cf0Var);
                    if (!zQ0) {
                    }
                    y73Var = new y73(d83Var2, th, i4);
                    this.X = null;
                    this.Y = d83Var2;
                    this.Z = i;
                    this.y0 = 4;
                    if (ji0.V(lifecycle, q92Var2, zQ0, tq1Var, y73Var, this) != mf0Var) {
                    }
                    return mf0Var;
                }
                gm0 gm0Var42222 = qv0.a;
                tq1 tq1Var42222 = qf2.a;
                w73 w73Var22222 = new w73(d83Var4, ge0Var, i3);
                this.X = null;
                this.Y = null;
                this.y0 = 6;
                break;
            case 4:
                d83Var3 = this.Y;
                n12.S(obj);
                d83Var2 = d83Var3;
                d83Var2.A.g = null;
                gm0 gm0Var422222 = qv0.a;
                tq1 tq1Var422222 = qf2.a;
                w73 w73Var222222 = new w73(d83Var4, ge0Var, i3);
                this.X = null;
                this.Y = null;
                this.y0 = 6;
                break;
            case 5:
                d83Var = this.Y;
                n12.S(obj);
                d83Var.A.g = null;
                gm0 gm0Var4222222 = qv0.a;
                tq1 tq1Var4222222 = qf2.a;
                w73 w73Var2222222 = new w73(d83Var4, ge0Var, i3);
                this.X = null;
                this.Y = null;
                this.y0 = 6;
                break;
            case 6:
                n12.S(obj);
                break;
            default:
                xe.q("call to 'resume' before 'invoke' with coroutine");
                break;
        }
        return null;
    }
}
