package defpackage;

import android.content.Context;
import android.net.Uri;
import com.getsurfboard.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import java.io.ByteArrayInputStream;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u73 extends v74 implements Function2 {
    public int A0;
    public int B0;
    public final /* synthetic */ d83 C0;
    public final /* synthetic */ Uri D0;
    public d83 X;
    public Object Y;
    public Object Z;
    public String y0;
    public int z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u73(d83 d83Var, Uri uri, ge0 ge0Var) {
        super(2, ge0Var);
        this.C0 = d83Var;
        this.D0 = uri;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((u73) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new u73(this.C0, this.D0, ge0Var);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:18|19|(3:214|80|(3:228|81|82))|(5:224|84|(4:86|(2:88|89)|90|106)(4:94|200|95|96)|185|186)|93|210|100|101|196|102|(3:105|90|106)|184) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:187|63|(6:222|65|(0)|212|73|(3:76|77|107))|72|212|73|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x028a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x028b, code lost:
    
        r19 = r0;
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x028f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0290, code lost:
    
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x034a, code lost:
    
        if (defpackage.ji0.V(r0, r1, r2, r2, r18, r25) == r12) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03e3, code lost:
    
        if (defpackage.ji0.V(r0, r1, r6, r4, r4, r25) != r12) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01f1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f2, code lost:
    
        r19 = r0;
        r8 = r3;
        r18 = r4;
        r2 = 0;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0042: MOVE (r18 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:67), block:B:11:0x0040 */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x019a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x020e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3 A[PHI: r0 r2 r3 r4 r8
      0x00b3: PHI (r0v18 java.lang.String) = (r0v15 java.lang.String), (r0v24 java.lang.String) binds: [B:47:0x0156, B:27:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00b3: PHI (r2v15 int) = (r2v8 int), (r2v19 int) binds: [B:47:0x0156, B:27:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00b3: PHI (r3v10 android.content.Context) = (r3v5 android.content.Context), (r3v15 android.content.Context) binds: [B:47:0x0156, B:27:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00b3: PHI (r4v14 d83) = (r4v11 d83), (r4v18 d83) binds: [B:47:0x0156, B:27:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00b3: PHI (r8v6 java.lang.Object) = (r8v5 java.lang.Object), (r8v8 java.lang.Object) binds: [B:47:0x0156, B:27:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e5  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        Throwable th;
        d83 d83Var;
        d83 d83Var2;
        Context context;
        int i;
        boolean zQ0;
        Uri uri;
        int i2;
        d83 d83Var3;
        Context context2;
        Uri uri2;
        int i3;
        Context context3;
        String strD;
        Object objB0;
        int i4;
        Context context4;
        d83 d83Var4;
        String str;
        int i5;
        q92 q92Var;
        Object objI;
        String str2;
        String str3;
        d83 d83Var5;
        Object obj2;
        Throwable thA;
        e03[] e03VarArr;
        Context context5;
        int i6;
        d83 d83Var6;
        r92 lifecycle;
        d83 d83Var7;
        tq1 tq1Var;
        boolean zQ02;
        d83 d83Var8;
        int i7 = this.B0;
        int i8 = 1;
        q92 q92Var2 = q92.b;
        q92 q92Var3 = q92.X;
        cf0 cf0Var = this.f;
        int i9 = 0;
        ge0 ge0Var = null;
        mf0 mf0Var = mf0.b;
        try {
        } catch (Throwable th2) {
            th = th2;
            d83Var2 = d83Var;
        }
        switch (i7) {
            case 0:
                n12.S(obj);
                d83 d83Var9 = this.C0;
                Context context6 = d83Var9.getContext();
                if (context6 != null) {
                    r92 lifecycle2 = d83Var9.getLifecycle();
                    gm0 gm0Var = qv0.a;
                    tq1 tq1Var2 = qf2.a.X;
                    cf0Var.getClass();
                    boolean zQ03 = tq1Var2.q0(cf0Var);
                    uri = this.D0;
                    if (!zQ03) {
                        if (lifecycle2.b() == q92Var2) {
                            vp1.m();
                            return null;
                        }
                        if (lifecycle2.b().compareTo(q92Var3) >= 0) {
                            y3 y3Var = d83Var9.b;
                            y3Var.getClass();
                            ((LinearProgressIndicator) y3Var.g).e();
                            i3 = 0;
                            d83Var3 = d83Var9;
                            context3 = context6;
                            strD = g73.d(g73.a(uri));
                            gm0 gm0Var2 = qv0.a;
                            pl0 pl0Var = pl0.z;
                            gd gdVar = new gd(context3, uri, ge0Var, 15);
                            this.X = d83Var3;
                            this.Y = context3;
                            this.Z = strD;
                            this.y0 = null;
                            this.z0 = i3;
                            this.B0 = 2;
                            objB0 = ji0.b0(pl0Var, gdVar, this);
                            if (objB0 != mf0Var) {
                                i4 = i3;
                                context4 = context3;
                                d83Var4 = d83Var3;
                                try {
                                    str = (String) objB0;
                                    try {
                                        byte[] bytes = str.getBytes(y30.a);
                                        bytes.getClass();
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                                        k01 k01Var = k01.A;
                                        try {
                                            t60 t60Var = t60.Y;
                                            try {
                                                vd3 vd3Var = vd3.A;
                                                this.X = d83Var4;
                                                this.Y = context4;
                                                this.Z = strD;
                                                this.y0 = str;
                                                this.z0 = i4;
                                                i5 = 0;
                                                this.B0 = 3;
                                                q92Var = q92Var3;
                                                try {
                                                    objI = c63.i(strD, byteArrayInputStream, k01Var, t60Var, vd3Var, this);
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    q92Var3 = q92Var;
                                                    th = th;
                                                    i = i4;
                                                    context = context4;
                                                    d83Var2 = d83Var4;
                                                    r92 lifecycle3 = d83Var2.getLifecycle();
                                                    gm0 gm0Var3 = qv0.a;
                                                    tq1 tq1Var3 = qf2.a.X;
                                                    cf0Var.getClass();
                                                    zQ0 = tq1Var3.q0(cf0Var);
                                                    if (!zQ0) {
                                                    }
                                                    t73 t73Var = new t73(d83Var2, th, context, 0);
                                                    this.X = null;
                                                    this.Y = null;
                                                    this.Z = null;
                                                    this.y0 = null;
                                                    this.z0 = i;
                                                    this.A0 = 0;
                                                    this.B0 = 7;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                q92Var3 = q92Var3;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            q92Var3 = q92Var3;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        q92Var3 = q92Var3;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                }
                                if (objI != mf0Var) {
                                    str2 = strD;
                                    str3 = str;
                                    context = context4;
                                    d83Var5 = d83Var4;
                                    obj2 = objI;
                                    try {
                                        thA = uk3.a(obj2);
                                    } catch (Throwable th8) {
                                        th = th8;
                                        d83Var4 = d83Var5;
                                        q92Var3 = q92Var;
                                    }
                                    if (thA == null) {
                                        q92Var3 = q92Var;
                                        try {
                                            thA.printStackTrace();
                                            r92 lifecycle4 = d83Var5.getLifecycle();
                                            try {
                                                gm0 gm0Var4 = qv0.a;
                                                tq1 tq1Var4 = qf2.a.X;
                                                cf0Var.getClass();
                                                boolean zQ04 = tq1Var4.q0(cf0Var);
                                                if (!zQ04) {
                                                    try {
                                                        if (lifecycle4.b() == q92Var2) {
                                                            throw new x92(null);
                                                        }
                                                        if (lifecycle4.b().compareTo(q92Var3) < 0) {
                                                            d83 d83Var10 = d83Var5;
                                                            String str4 = str3;
                                                            Context context7 = context;
                                                            try {
                                                                r73 r73Var = new r73(d83Var10, thA, context7, str2, str4);
                                                                d83Var4 = d83Var10;
                                                                context4 = context7;
                                                                this.X = d83Var4;
                                                                this.Y = context4;
                                                                this.Z = null;
                                                                this.y0 = null;
                                                                this.z0 = i4;
                                                                this.A0 = 0;
                                                                this.B0 = 6;
                                                            } catch (Throwable th9) {
                                                                th = th9;
                                                                d83Var4 = d83Var10;
                                                                context4 = context7;
                                                                th = th;
                                                                i = i4;
                                                                context = context4;
                                                                d83Var2 = d83Var4;
                                                                r92 lifecycle32 = d83Var2.getLifecycle();
                                                                gm0 gm0Var32 = qv0.a;
                                                                tq1 tq1Var32 = qf2.a.X;
                                                                cf0Var.getClass();
                                                                zQ0 = tq1Var32.q0(cf0Var);
                                                                if (!zQ0) {
                                                                }
                                                                t73 t73Var2 = new t73(d83Var2, th, context, 0);
                                                                this.X = null;
                                                                this.Y = null;
                                                                this.Z = null;
                                                                this.y0 = null;
                                                                this.z0 = i;
                                                                this.A0 = 0;
                                                                this.B0 = 7;
                                                            }
                                                        } else {
                                                            CharSequence text = context.getText(R.string.profile_decode_error);
                                                            text.getClass();
                                                            Context context8 = context;
                                                            d83 d83Var11 = d83Var5;
                                                            try {
                                                                context = context8;
                                                                d83Var2 = d83Var11;
                                                                try {
                                                                    d83Var2.o(thA, text, str2, str3, new r73(d83Var11, str2, str3, thA, context8));
                                                                    y3 y3Var2 = d83Var2.b;
                                                                    y3Var2.getClass();
                                                                    ((LinearProgressIndicator) y3Var2.g).b();
                                                                } catch (Throwable th10) {
                                                                    th = th10;
                                                                    i = i4;
                                                                    r92 lifecycle322 = d83Var2.getLifecycle();
                                                                    gm0 gm0Var322 = qv0.a;
                                                                    tq1 tq1Var322 = qf2.a.X;
                                                                    cf0Var.getClass();
                                                                    zQ0 = tq1Var322.q0(cf0Var);
                                                                    if (!zQ0) {
                                                                    }
                                                                    t73 t73Var22 = new t73(d83Var2, th, context, 0);
                                                                    this.X = null;
                                                                    this.Y = null;
                                                                    this.Z = null;
                                                                    this.y0 = null;
                                                                    this.z0 = i;
                                                                    this.A0 = 0;
                                                                    this.B0 = 7;
                                                                }
                                                            } catch (Throwable th11) {
                                                                th = th11;
                                                                d83Var5 = d83Var11;
                                                                context = context8;
                                                                th = th;
                                                                d83Var2 = d83Var5;
                                                            }
                                                        }
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                    }
                                                    break;
                                                }
                                            } catch (Throwable th13) {
                                                th = th13;
                                                context4 = context;
                                                d83Var4 = d83Var5;
                                            }
                                        } catch (Throwable th14) {
                                            th = th14;
                                            d83Var4 = d83Var5;
                                            th = th;
                                            i = i4;
                                            d83Var2 = d83Var4;
                                            r92 lifecycle3222 = d83Var2.getLifecycle();
                                            gm0 gm0Var3222 = qv0.a;
                                            tq1 tq1Var3222 = qf2.a.X;
                                            cf0Var.getClass();
                                            zQ0 = tq1Var3222.q0(cf0Var);
                                            if (!zQ0) {
                                            }
                                            t73 t73Var222 = new t73(d83Var2, th, context, 0);
                                            this.X = null;
                                            this.Y = null;
                                            this.Z = null;
                                            this.y0 = null;
                                            this.z0 = i;
                                            this.A0 = 0;
                                            this.B0 = 7;
                                            break;
                                        }
                                        d83Var2 = d83Var4;
                                        r92 lifecycle32222 = d83Var2.getLifecycle();
                                        gm0 gm0Var32222 = qv0.a;
                                        tq1 tq1Var32222 = qf2.a.X;
                                        cf0Var.getClass();
                                        zQ0 = tq1Var32222.q0(cf0Var);
                                        if (!zQ0) {
                                            if (lifecycle32222.b() == q92Var2) {
                                                vp1.m();
                                                return null;
                                            }
                                            if (lifecycle32222.b().compareTo(q92Var3) >= 0) {
                                                CharSequence text2 = context.getText(R.string.profile_decode_error);
                                                text2.getClass();
                                                d83Var2.o(th, text2, null, null, null);
                                                y3 y3Var3 = d83Var2.b;
                                                y3Var3.getClass();
                                                ((LinearProgressIndicator) y3Var3.g).b();
                                            }
                                        }
                                        t73 t73Var2222 = new t73(d83Var2, th, context, 0);
                                        this.X = null;
                                        this.Y = null;
                                        this.Z = null;
                                        this.y0 = null;
                                        this.z0 = i;
                                        this.A0 = 0;
                                        this.B0 = 7;
                                    } else {
                                        try {
                                            e03 e03Var = (e03) obj2;
                                            e1 e1Var = d73.a;
                                            Object obj3 = e03Var.b;
                                            zk zkVarE = d73.e(((t53) obj3).b);
                                            if (zkVarE != null) {
                                                try {
                                                    if (zkVarE.O() != ((t53) obj3).f) {
                                                    }
                                                    e03VarArr = new e03[1];
                                                    e03VarArr[i5] = e03Var;
                                                    this.X = d83Var5;
                                                    this.Y = context;
                                                    this.Z = null;
                                                    this.y0 = null;
                                                    this.z0 = i4;
                                                    this.A0 = i5;
                                                    this.B0 = 4;
                                                    if (d73.j(e03VarArr, this) != mf0Var) {
                                                        d83 d83Var12 = d83Var5;
                                                        context5 = context;
                                                        i6 = i4;
                                                        d83Var6 = d83Var12;
                                                        d83Var8 = d83Var6;
                                                        y3 y3Var4 = d83Var8.b;
                                                        y3Var4.getClass();
                                                        ((LinearProgressIndicator) y3Var4.g).b();
                                                    }
                                                } catch (Throwable th15) {
                                                    th = th15;
                                                    d83Var2 = d83Var5;
                                                    q92Var3 = q92Var;
                                                    i = i4;
                                                    r92 lifecycle322222 = d83Var2.getLifecycle();
                                                    gm0 gm0Var322222 = qv0.a;
                                                    tq1 tq1Var322222 = qf2.a.X;
                                                    cf0Var.getClass();
                                                    zQ0 = tq1Var322222.q0(cf0Var);
                                                    if (!zQ0) {
                                                    }
                                                    t73 t73Var22222 = new t73(d83Var2, th, context, 0);
                                                    this.X = null;
                                                    this.Y = null;
                                                    this.Z = null;
                                                    this.y0 = null;
                                                    this.z0 = i;
                                                    this.A0 = 0;
                                                    this.B0 = 7;
                                                }
                                            }
                                            d83Var5.A.g = ((t53) obj3).b;
                                            e03VarArr = new e03[1];
                                            e03VarArr[i5] = e03Var;
                                            this.X = d83Var5;
                                            this.Y = context;
                                            this.Z = null;
                                            this.y0 = null;
                                            this.z0 = i4;
                                            this.A0 = i5;
                                            this.B0 = 4;
                                            if (d73.j(e03VarArr, this) != mf0Var) {
                                            }
                                        } catch (Throwable th16) {
                                            th = th16;
                                            q92Var3 = q92Var;
                                            th = th;
                                            d83Var2 = d83Var5;
                                            i = i4;
                                            r92 lifecycle3222222 = d83Var2.getLifecycle();
                                            gm0 gm0Var3222222 = qv0.a;
                                            tq1 tq1Var3222222 = qf2.a.X;
                                            cf0Var.getClass();
                                            zQ0 = tq1Var3222222.q0(cf0Var);
                                            if (!zQ0) {
                                            }
                                            t73 t73Var222222 = new t73(d83Var2, th, context, 0);
                                            this.X = null;
                                            this.Y = null;
                                            this.Z = null;
                                            this.y0 = null;
                                            this.z0 = i;
                                            this.A0 = 0;
                                            this.B0 = 7;
                                        }
                                    }
                                    i = i4;
                                    r92 lifecycle32222222 = d83Var2.getLifecycle();
                                    gm0 gm0Var32222222 = qv0.a;
                                    tq1 tq1Var32222222 = qf2.a.X;
                                    cf0Var.getClass();
                                    zQ0 = tq1Var32222222.q0(cf0Var);
                                    if (!zQ0) {
                                    }
                                    t73 t73Var2222222 = new t73(d83Var2, th, context, 0);
                                    this.X = null;
                                    this.Y = null;
                                    this.Z = null;
                                    this.y0 = null;
                                    this.z0 = i;
                                    this.A0 = 0;
                                    this.B0 = 7;
                                }
                                break;
                            }
                            return mf0Var;
                        }
                    }
                    s73 s73Var = new s73(d83Var9, i9);
                    this.X = d83Var9;
                    this.Y = uri;
                    this.Z = context6;
                    this.y0 = null;
                    this.z0 = 0;
                    this.A0 = 0;
                    this.B0 = 1;
                    if (ji0.V(lifecycle2, q92Var3, zQ03, tq1Var2, s73Var, this) != mf0Var) {
                        i2 = 0;
                        d83Var3 = d83Var9;
                        context2 = context6;
                        uri2 = uri;
                        uri = uri2;
                        context3 = context2;
                        i3 = i2;
                        strD = g73.d(g73.a(uri));
                        gm0 gm0Var22 = qv0.a;
                        pl0 pl0Var2 = pl0.z;
                        gd gdVar2 = new gd(context3, uri, ge0Var, 15);
                        this.X = d83Var3;
                        this.Y = context3;
                        this.Z = strD;
                        this.y0 = null;
                        this.z0 = i3;
                        this.B0 = 2;
                        objB0 = ji0.b0(pl0Var2, gdVar2, this);
                        if (objB0 != mf0Var) {
                        }
                    }
                    return mf0Var;
                }
                return xl4.a;
            case 1:
                i2 = this.z0;
                context2 = (Context) this.Z;
                uri2 = (Uri) this.Y;
                d83Var3 = this.X;
                n12.S(obj);
                uri = uri2;
                context3 = context2;
                i3 = i2;
                strD = g73.d(g73.a(uri));
                gm0 gm0Var222 = qv0.a;
                pl0 pl0Var22 = pl0.z;
                gd gdVar22 = new gd(context3, uri, ge0Var, 15);
                this.X = d83Var3;
                this.Y = context3;
                this.Z = strD;
                this.y0 = null;
                this.z0 = i3;
                this.B0 = 2;
                objB0 = ji0.b0(pl0Var22, gdVar22, this);
                if (objB0 != mf0Var) {
                }
                return mf0Var;
            case 2:
                i3 = this.z0;
                strD = (String) this.Z;
                context3 = (Context) this.Y;
                d83Var3 = this.X;
                n12.S(obj);
                objB0 = obj;
                i4 = i3;
                context4 = context3;
                d83Var4 = d83Var3;
                str = (String) objB0;
                byte[] bytes2 = str.getBytes(y30.a);
                bytes2.getClass();
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bytes2);
                k01 k01Var2 = k01.A;
                t60 t60Var2 = t60.Y;
                vd3 vd3Var2 = vd3.A;
                this.X = d83Var4;
                this.Y = context4;
                this.Z = strD;
                this.y0 = str;
                this.z0 = i4;
                i5 = 0;
                this.B0 = 3;
                q92Var = q92Var3;
                objI = c63.i(strD, byteArrayInputStream2, k01Var2, t60Var2, vd3Var2, this);
                if (objI != mf0Var) {
                }
                return mf0Var;
            case 3:
                i = this.z0;
                String str5 = this.y0;
                String str6 = (String) this.Z;
                Context context9 = (Context) this.Y;
                d83 d83Var13 = this.X;
                try {
                    n12.S(obj);
                    obj2 = ((uk3) obj).b;
                    str3 = str5;
                    str2 = str6;
                    context = context9;
                    i5 = 0;
                    d83Var5 = d83Var13;
                    q92Var = q92Var3;
                    i4 = i;
                    thA = uk3.a(obj2);
                    if (thA == null) {
                    }
                } catch (Throwable th17) {
                    th = th17;
                    context = context9;
                    d83Var2 = d83Var13;
                    r92 lifecycle322222222 = d83Var2.getLifecycle();
                    gm0 gm0Var322222222 = qv0.a;
                    tq1 tq1Var322222222 = qf2.a.X;
                    cf0Var.getClass();
                    zQ0 = tq1Var322222222.q0(cf0Var);
                    if (!zQ0) {
                    }
                    t73 t73Var22222222 = new t73(d83Var2, th, context, 0);
                    this.X = null;
                    this.Y = null;
                    this.Z = null;
                    this.y0 = null;
                    this.z0 = i;
                    this.A0 = 0;
                    this.B0 = 7;
                    break;
                }
                i = i4;
                r92 lifecycle3222222222 = d83Var2.getLifecycle();
                gm0 gm0Var3222222222 = qv0.a;
                tq1 tq1Var3222222222 = qf2.a.X;
                cf0Var.getClass();
                zQ0 = tq1Var3222222222.q0(cf0Var);
                if (!zQ0) {
                }
                t73 t73Var222222222 = new t73(d83Var2, th, context, 0);
                this.X = null;
                this.Y = null;
                this.Z = null;
                this.y0 = null;
                this.z0 = i;
                this.A0 = 0;
                this.B0 = 7;
                break;
            case 4:
                int i10 = this.A0;
                i6 = this.z0;
                context5 = (Context) this.Y;
                d83Var6 = this.X;
                try {
                    n12.S(obj);
                    q92Var = q92Var3;
                    d83Var8 = d83Var6;
                } catch (Throwable th18) {
                    Throwable th19 = th18;
                    q92Var = q92Var3;
                    Context context10 = context5;
                    d83Var2 = d83Var6;
                    i4 = i6;
                    try {
                        th19.printStackTrace();
                        lifecycle = d83Var2.getLifecycle();
                        try {
                            gm0 gm0Var5 = qv0.a;
                            tq1Var = qf2.a.X;
                            cf0Var.getClass();
                            zQ02 = tq1Var.q0(cf0Var);
                        } catch (Throwable th20) {
                            th = th20;
                            q92Var3 = q92Var;
                            d83Var7 = d83Var2;
                        }
                        break;
                    } catch (Throwable th21) {
                        q92Var3 = q92Var;
                        th = th21;
                        context = context10;
                        i = i4;
                    }
                    if (!zQ02) {
                        try {
                            if (lifecycle.b() == q92Var2) {
                                d83Var7 = d83Var2;
                                try {
                                    throw new x92(null);
                                } catch (Throwable th22) {
                                    th = th22;
                                    context = context10;
                                    q92Var3 = q92Var;
                                    i = i4;
                                    d83Var2 = d83Var7;
                                    r92 lifecycle32222222222 = d83Var2.getLifecycle();
                                    gm0 gm0Var32222222222 = qv0.a;
                                    tq1 tq1Var32222222222 = qf2.a.X;
                                    cf0Var.getClass();
                                    zQ0 = tq1Var32222222222.q0(cf0Var);
                                    if (!zQ0) {
                                    }
                                    t73 t73Var2222222222 = new t73(d83Var2, th, context, 0);
                                    this.X = null;
                                    this.Y = null;
                                    this.Z = null;
                                    this.y0 = null;
                                    this.z0 = i;
                                    this.A0 = 0;
                                    this.B0 = 7;
                                }
                            } else {
                                if (lifecycle.b().compareTo(q92Var) >= 0) {
                                    CharSequence text3 = context10.getText(R.string.unknown_error);
                                    text3.getClass();
                                    d83Var2.o(th19, text3, null, null, null);
                                    d83Var7 = d83Var2;
                                }
                                d83Var8 = d83Var7;
                                d83Var8.A.g = null;
                            }
                            break;
                        } catch (Throwable th23) {
                            th = th23;
                            context = context10;
                            q92Var3 = q92Var;
                            i = i4;
                            r92 lifecycle322222222222 = d83Var2.getLifecycle();
                            gm0 gm0Var322222222222 = qv0.a;
                            tq1 tq1Var322222222222 = qf2.a.X;
                            cf0Var.getClass();
                            zQ0 = tq1Var322222222222.q0(cf0Var);
                            if (!zQ0) {
                            }
                            t73 t73Var22222222222 = new t73(d83Var2, th, context, 0);
                            this.X = null;
                            this.Y = null;
                            this.Z = null;
                            this.y0 = null;
                            this.z0 = i;
                            this.A0 = 0;
                            this.B0 = 7;
                            break;
                        }
                        return xl4.a;
                    }
                    d83Var7 = d83Var2;
                    t73 t73Var3 = new t73(d83Var7, th19, context10, i8);
                    this.X = d83Var7;
                    this.Y = context10;
                    this.Z = null;
                    this.y0 = null;
                    this.z0 = i4;
                    this.A0 = i10;
                    this.B0 = 5;
                    q92Var3 = q92Var;
                    if (ji0.V(lifecycle, q92Var3, zQ02, tq1Var, t73Var3, this) != mf0Var) {
                        d83Var8 = d83Var7;
                        d83Var8.A.g = null;
                    }
                    return mf0Var;
                }
                y3 y3Var42 = d83Var8.b;
                y3Var42.getClass();
                ((LinearProgressIndicator) y3Var42.g).b();
                return xl4.a;
            case 5:
                int i11 = this.z0;
                d83Var8 = this.X;
                n12.S(obj);
                d83Var8.A.g = null;
                y3 y3Var422 = d83Var8.b;
                y3Var422.getClass();
                ((LinearProgressIndicator) y3Var422.g).b();
                return xl4.a;
            case 6:
                int i12 = this.z0;
                d83 d83Var14 = this.X;
                n12.S(obj);
                return xl4.a;
            case 7:
                n12.S(obj);
                return xl4.a;
            default:
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
