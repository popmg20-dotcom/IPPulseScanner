package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.getsurfboard.ui.fragment.ProfileAddMethodsFragment;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.jvm.functions.Function2;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w53 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public Object Z;
    public final /* synthetic */ Object y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w53(Object obj, Object obj2, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
        this.y0 = obj2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 1:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 2:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 3:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 4:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 5:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 6:
                return ((w53) n((ge0) obj2, (kz2) obj)).p(xl4Var);
            case 7:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 8:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 10:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 11:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                return ((w53) n((ge0) obj2, obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.y0;
        switch (i) {
            case 0:
                return new w53((ProfileAddMethodsFragment) this.Z, (List) obj2, ge0Var, 0);
            case 1:
                return new w53((ProfileEditorActivity) this.Z, (Throwable) obj2, ge0Var, 1);
            case 2:
                return new w53((ProfileEditorActivity) this.Z, (String) obj2, ge0Var, 2);
            case 3:
                w53 w53Var = new w53((Uri) obj2, ge0Var, 3);
                w53Var.Z = obj;
                return w53Var;
            case 4:
                return new w53((zb3) this.Z, (String) obj2, ge0Var, 4);
            case 5:
                return new w53((te3) this.Z, (ry1) obj2, ge0Var, 5);
            case 6:
                w53 w53Var2 = new w53((RecentRequestsActivity) obj2, ge0Var, 6);
                w53Var2.Z = obj;
                return w53Var2;
            case 7:
                return new w53((pl3) this.Z, (Function2) obj2, ge0Var, 7);
            case 8:
                return new w53((iv1) obj2, ge0Var, 8);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new w53((xp) this.Z, (Function2) obj2, ge0Var, 9);
            case 10:
                return new w53((zz3) this.Z, (String) obj2, ge0Var, 10);
            case 11:
                return new w53((vh4) this.Z, (pl1) obj2, ge0Var, 11);
            default:
                w53 w53Var3 = new w53((ag1) obj2, ge0Var, 12);
                w53Var3.Z = obj;
                return w53Var3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0278, code lost:
    
        if (r6.k(r0, r5) != r12) goto L146;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0132  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x0278 -> B:146:0x027c). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) throws Throwable {
        Object tk3Var;
        Object objH;
        Object objB0;
        Object objB;
        hj hjVar;
        Object obj2;
        Object objU;
        xp xpVar;
        m30 m30Var;
        z00 z00Var;
        m30 m30Var2;
        Object objB2;
        w53 w53Var = this;
        int i = w53Var.X;
        int i2 = 9;
        cf0 cf0Var = w53Var.f;
        q92 q92Var = q92.b;
        xl4 xl4Var = xl4.a;
        Object obj3 = w53Var.y0;
        mf0 mf0Var = mf0.b;
        int i3 = 1;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                int i4 = w53Var.Y;
                if (i4 == 0) {
                    n12.S(obj);
                    ProfileAddMethodsFragment profileAddMethodsFragment = (ProfileAddMethodsFragment) w53Var.Z;
                    List list = (List) obj3;
                    r92 lifecycle = profileAddMethodsFragment.getLifecycle();
                    gm0 gm0Var = qv0.a;
                    tq1 tq1Var = qf2.a.X;
                    cf0Var.getClass();
                    boolean zQ0 = tq1Var.q0(cf0Var);
                    q92 q92Var2 = q92.X;
                    if (!zQ0) {
                        if (lifecycle.b() == q92Var) {
                            vp1.m();
                        } else if (lifecycle.b().compareTo(q92Var2) >= 0) {
                            d83 d83Var = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var == null) {
                                return xl4Var;
                            }
                            d83Var.k(list);
                            return xl4Var;
                        }
                    }
                    kt ktVar = new kt(7, profileAddMethodsFragment, list);
                    w53Var.Y = 1;
                    return ji0.V(lifecycle, q92Var2, zQ0, tq1Var, ktVar, w53Var) == mf0Var ? mf0Var : xl4Var;
                }
                if (i4 == 1) {
                    n12.S(obj);
                    return xl4Var;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                int i5 = w53Var.Y;
                if (i5 != 0) {
                    if (i5 == 1) {
                        n12.S(obj);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) w53Var.Z;
                Throwable th = (Throwable) obj3;
                fa2 fa2Var = profileEditorActivity.b;
                gm0 gm0Var2 = qv0.a;
                tq1 tq1Var2 = qf2.a.X;
                cf0Var.getClass();
                boolean zQ02 = tq1Var2.q0(cf0Var);
                q92 q92Var3 = q92.X;
                if (!zQ02) {
                    q92 q92Var4 = fa2Var.c;
                    if (q92Var4 == q92Var) {
                        vp1.m();
                        return null;
                    }
                    if (q92Var4.compareTo(q92Var3) >= 0) {
                        th.printStackTrace();
                        cm2 cm2Var = profileEditorActivity.S0;
                        if (cm2Var == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((LinearProgressIndicator) cm2Var.A).b();
                        InputMethodManager inputMethodManagerM = ContextUtilsKt.m();
                        cm2 cm2Var2 = profileEditorActivity.S0;
                        if (cm2Var2 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        inputMethodManagerM.hideSoftInputFromWindow(((CodeEditor) cm2Var2.z).getWindowToken(), 0);
                        String message = th.getMessage();
                        if (message == null) {
                            message = profileEditorActivity.getString(R.string.unknown_error);
                            message.getClass();
                        }
                        profileEditorActivity.B(message);
                        return xl4Var;
                    }
                }
                kt ktVar2 = new kt(i2, th, profileEditorActivity);
                w53Var.Y = 1;
                return ji0.V(fa2Var, q92Var3, zQ02, tq1Var2, ktVar2, w53Var) == mf0Var ? mf0Var : xl4Var;
            case 2:
                int i6 = w53Var.Y;
                if (i6 == 0) {
                    n12.S(obj);
                    ProfileEditorActivity profileEditorActivity2 = (ProfileEditorActivity) w53Var.Z;
                    String str = (String) obj3;
                    fa2 fa2Var2 = profileEditorActivity2.b;
                    gm0 gm0Var3 = qv0.a;
                    tq1 tq1Var3 = qf2.a.X;
                    cf0Var.getClass();
                    boolean zQ03 = tq1Var3.q0(cf0Var);
                    q92 q92Var5 = q92.X;
                    if (!zQ03) {
                        q92 q92Var6 = fa2Var2.c;
                        if (q92Var6 == q92Var) {
                            vp1.m();
                        } else if (q92Var6.compareTo(q92Var5) >= 0) {
                            wh2 wh2Var = new wh2(profileEditorActivity2);
                            wh2Var.x(R.string.unknown_error);
                            ((p6) wh2Var.z).g = str;
                            wh2Var.w(R.string.i_got_it, null);
                            wh2Var.v(R.string.copy_message, new uh0(2, str));
                            wh2Var.r();
                            return xl4Var;
                        }
                    }
                    kt ktVar3 = new kt(10, profileEditorActivity2, str);
                    w53Var.Y = 1;
                    return ji0.V(fa2Var2, q92Var5, zQ03, tq1Var3, ktVar3, w53Var) == mf0Var ? mf0Var : xl4Var;
                }
                if (i6 == 1) {
                    n12.S(obj);
                    return xl4Var;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                int i7 = w53Var.Y;
                try {
                    if (i7 == 0) {
                        n12.S(obj);
                        Uri uri = (Uri) obj3;
                        String strD = g73.d(g73.a(uri));
                        k01 k01Var = k01.A;
                        t60 t60Var = t60.Y;
                        vd3 vd3Var = vd3.A;
                        w53Var.Z = null;
                        w53Var.Y = 1;
                        objH = c63.h(strD, uri, k01Var, t60Var, vd3Var, w53Var);
                        if (objH == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        if (i7 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                        objH = ((uk3) obj).b;
                    }
                    n12.S(objH);
                    tk3Var = (e03) objH;
                    break;
                } catch (Throwable th2) {
                    tk3Var = new tk3(th2);
                }
                return new uk3(tk3Var);
            case 4:
                zb3 zb3Var = (zb3) w53Var.Z;
                int i8 = w53Var.Y;
                int i9 = 3;
                q92 q92Var7 = q92.A;
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                    r92 lifecycle2 = zb3Var.getLifecycle();
                    gm0 gm0Var4 = qv0.a;
                    tq1 tq1Var4 = qf2.a.X;
                    cf0Var.getClass();
                    boolean zQ04 = tq1Var4.q0(cf0Var);
                    if (!zQ04) {
                        if (lifecycle2.b() == q92Var) {
                            vp1.m();
                        } else if (lifecycle2.b().compareTo(q92Var7) >= 0) {
                            zb3Var.j(false, false);
                            p95.C(R.string.generate_qrcode_failed, new Object[0]);
                            return xl4Var;
                        }
                    }
                    cj cjVar = new cj(i9, zb3Var);
                    w53Var.Y = 3;
                    if (ji0.V(lifecycle2, q92Var7, zQ04, tq1Var4, cjVar, w53Var) != mf0Var) {
                        return xl4Var;
                    }
                    return mf0Var;
                }
                if (i8 == 0) {
                    n12.S(obj);
                    w53Var.Y = 1;
                    objB0 = ji0.b0(qv0.a, new p81((String) obj3, null, 8), w53Var);
                    if (objB0 == mf0Var) {
                    }
                    return mf0Var;
                }
                if (i8 != 1) {
                    if (i8 == 2) {
                        n12.S(obj);
                        return xl4Var;
                    }
                    if (i8 == 3) {
                        n12.S(obj);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                objB0 = obj;
                Bitmap bitmap = (Bitmap) objB0;
                r92 lifecycle3 = zb3Var.getLifecycle();
                gm0 gm0Var5 = qv0.a;
                tq1 tq1Var5 = qf2.a.X;
                cf0Var.getClass();
                boolean zQ05 = tq1Var5.q0(cf0Var);
                if (!zQ05) {
                    if (lifecycle3.b() == q92Var) {
                        throw new x92(null);
                    }
                    if (lifecycle3.b().compareTo(q92Var7) >= 0) {
                        zf2 zf2Var = zb3Var.H0;
                        zf2Var.getClass();
                        ((ImageView) zf2Var.f).setImageBitmap(bitmap);
                        return xl4Var;
                    }
                }
                kt ktVar4 = new kt(11, zb3Var, bitmap);
                w53Var.Y = 2;
                if (ji0.V(lifecycle3, q92Var7, zQ05, tq1Var5, ktVar4, w53Var) != mf0Var) {
                    return xl4Var;
                }
                return mf0Var;
            case 5:
                te3 te3Var = (te3) w53Var.Z;
                int i10 = w53Var.Y;
                if (i10 == 0) {
                    n12.S(obj);
                    w53Var.Y = 1;
                    objB = te3Var.b((ry1) obj3, w53Var);
                    if (objB == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i10 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objB = obj;
                }
                return objB;
            case 6:
                RecentRequestsActivity recentRequestsActivity = (RecentRequestsActivity) obj3;
                kz2 kz2Var = (kz2) w53Var.Z;
                int i11 = w53Var.Y;
                if (i11 != 0) {
                    if (i11 == 1) {
                        n12.S(obj);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                j80 j80Var = recentRequestsActivity.S0;
                if (j80Var == null) {
                    n12.T("binding");
                    throw null;
                }
                recentRequestsActivity.W0 = ((RecyclerView) j80Var.c).computeVerticalScrollOffset() == 0;
                mf3 mf3Var = recentRequestsActivity.V0;
                w53Var.Z = null;
                w53Var.Y = 1;
                vf vfVar = mf3Var.e;
                vfVar.g.incrementAndGet();
                rf rfVar = vfVar.f;
                Object objE = rfVar.g.E(new ej0(rfVar, kz2Var, null, 2), w53Var);
                if (objE != mf0Var) {
                    objE = xl4Var;
                }
                if (objE != mf0Var) {
                    objE = xl4Var;
                }
                if (objE != mf0Var) {
                    objE = xl4Var;
                }
                return objE == mf0Var ? mf0Var : xl4Var;
            case 7:
                int i12 = w53Var.Y;
                if (i12 == 0) {
                    n12.S(obj);
                    w53Var.Y = 1;
                    Object objR = ((pl3) w53Var.Z).r(true, (Function2) obj3, w53Var);
                    return objR == mf0Var ? mf0Var : objR;
                }
                if (i12 == 1) {
                    n12.S(obj);
                    return obj;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 8:
                iv1 iv1Var = (iv1) obj3;
                int i13 = w53Var.Y;
                if (i13 == 0) {
                    n12.S(obj);
                    if (((AtomicInteger) ((cp1) iv1Var.X).f).get() > 0) {
                        je.A(((lf0) iv1Var.f).I());
                        hj hjVar2 = (hj) iv1Var.z;
                        xpVar = (xp) iv1Var.A;
                        w53Var.Z = hjVar2;
                        w53Var.Y = i3;
                        xpVar.getClass();
                        AtomicLongFieldUpdater atomicLongFieldUpdater = xp.X;
                        Unsafe unsafe = re.a;
                        long j = xp.E0;
                        m30 m30Var3 = (m30) unsafe.getObjectVolatile(xpVar, j);
                        while (!xpVar.x()) {
                        }
                        Throwable thQ = xpVar.q();
                        int i14 = t14.a;
                        throw thQ;
                    }
                    xe.q("Check failed.");
                    return null;
                }
                if (i13 != 1) {
                    if (i13 != 2) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    if (((AtomicInteger) ((cp1) iv1Var.X).f).decrementAndGet() == 0) {
                        return xl4Var;
                    }
                    i3 = 1;
                    je.A(((lf0) iv1Var.f).I());
                    hj hjVar22 = (hj) iv1Var.z;
                    xpVar = (xp) iv1Var.A;
                    w53Var.Z = hjVar22;
                    w53Var.Y = i3;
                    xpVar.getClass();
                    AtomicLongFieldUpdater atomicLongFieldUpdater2 = xp.X;
                    Unsafe unsafe2 = re.a;
                    long j2 = xp.E0;
                    m30 m30Var32 = (m30) unsafe2.getObjectVolatile(xpVar, j2);
                    while (!xpVar.x()) {
                        long andIncrement = atomicLongFieldUpdater2.getAndIncrement(xpVar);
                        long j3 = zp.b;
                        long j4 = andIncrement / j3;
                        int i15 = (int) (andIncrement % j3);
                        if (m30Var32.A == j4) {
                            m30Var = m30Var32;
                        } else {
                            m30 m30VarM = xpVar.m(j4, m30Var32);
                            if (m30VarM != null) {
                                m30Var = m30VarM;
                            }
                        }
                        Object objJ = xpVar.J(m30Var, i15, andIncrement, null);
                        br1 br1Var = zp.m;
                        if (objJ == br1Var) {
                            xe.q("unexpected");
                            return null;
                        }
                        br1 br1Var2 = zp.o;
                        if (objJ != br1Var2) {
                            if (objJ == zp.n) {
                                am1 am1Var = xpVar.f;
                                z00 z00VarT = vo.t(p95.u(this));
                                try {
                                    Object objJ2 = xpVar.J(m30Var, i15, andIncrement, z00VarT);
                                    m30 m30Var4 = m30Var;
                                    z00Var = z00VarT;
                                    if (objJ2 != br1Var) {
                                        if (objJ2 != br1Var2) {
                                            hjVar = hjVar22;
                                            m30Var4.a();
                                            z00Var.l(objJ2, am1Var != null ? new sp(3, xpVar, xp.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, 0) : null);
                                        } else {
                                            if (andIncrement < xpVar.t()) {
                                                m30Var4.a();
                                            }
                                            m30 m30Var5 = (m30) re.a.getObjectVolatile(xpVar, j2);
                                            while (!xpVar.x()) {
                                                long andIncrement2 = atomicLongFieldUpdater2.getAndIncrement(xpVar);
                                                long j5 = zp.b;
                                                long j6 = andIncrement2 / j5;
                                                int i16 = (int) (andIncrement2 % j5);
                                                hjVar = hjVar22;
                                                AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
                                                if (m30Var5.A == j6) {
                                                    m30Var2 = m30Var5;
                                                } else {
                                                    m30 m30VarM2 = xpVar.m(j6, m30Var5);
                                                    if (m30VarM2 == null) {
                                                        continue;
                                                        atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
                                                        hjVar22 = hjVar;
                                                    } else {
                                                        m30Var2 = m30VarM2;
                                                    }
                                                }
                                                z00 z00Var2 = z00Var;
                                                Object objJ3 = xpVar.J(m30Var2, i16, andIncrement2, z00Var2);
                                                m30Var5 = m30Var2;
                                                z00Var = z00Var2;
                                                if (objJ3 == zp.m) {
                                                    z00Var.a(m30Var5, i16);
                                                } else if (objJ3 == zp.o) {
                                                    if (andIncrement2 < xpVar.t()) {
                                                        m30Var5.a();
                                                    }
                                                    atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
                                                    hjVar22 = hjVar;
                                                } else {
                                                    if (objJ3 == zp.n) {
                                                        throw new IllegalStateException("unexpected");
                                                    }
                                                    m30Var5.a();
                                                    z00Var.l(objJ3, am1Var != null ? new sp(3, xpVar, xp.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, 0) : null);
                                                }
                                            }
                                            z00Var.d(new tk3(xpVar.q()));
                                        }
                                        objU = z00Var.u();
                                    } else {
                                        try {
                                            z00Var.a(m30Var4, i15);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            z00Var.D();
                                            throw th;
                                        }
                                    }
                                    hjVar = hjVar22;
                                    objU = z00Var.u();
                                } catch (Throwable th4) {
                                    th = th4;
                                    z00Var = z00VarT;
                                }
                            } else {
                                hjVar = hjVar22;
                                m30Var.a();
                                objU = objJ;
                            }
                            if (objU != mf0Var) {
                                w53Var = this;
                                obj2 = null;
                                w53Var.Z = obj2;
                                w53Var.Y = 2;
                                break;
                            }
                            return mf0Var;
                        }
                        if (andIncrement < xpVar.t()) {
                            m30Var.a();
                        }
                        m30Var32 = m30Var;
                    }
                    Throwable thQ2 = xpVar.q();
                    int i142 = t14.a;
                    throw thQ2;
                }
                hj hjVar3 = (hj) w53Var.Z;
                n12.S(obj);
                hjVar = hjVar3;
                obj2 = null;
                objU = obj;
                w53Var.Z = obj2;
                w53Var.Y = 2;
                break;
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                xp xpVar2 = (xp) w53Var.Z;
                int i17 = w53Var.Y;
                try {
                    if (i17 == 0) {
                        n12.S(obj);
                        uf ufVar = new uf(xpVar2, (Function2) obj3, ge0Var, 24);
                        w53Var.Y = 1;
                        if (p95.h(ufVar, w53Var) == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        if (i17 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                    }
                    xpVar2.b(null);
                    return xl4Var;
                } catch (Throwable th5) {
                    xpVar2.d(th5, false);
                    return xl4Var;
                }
            case 10:
                int i18 = w53Var.Y;
                if (i18 != 0) {
                    if (i18 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                long j7 = ((long) ((zz3) w53Var.Z).i) * 1000;
                p81 p81Var = new p81((String) obj3, ge0Var, i2);
                w53Var.Y = 1;
                Object objX = r25.X(j7, p81Var, w53Var);
                return objX == mf0Var ? mf0Var : objX;
            case 11:
                pl1 pl1Var = (pl1) obj3;
                int i19 = w53Var.Y;
                try {
                    if (i19 == 0) {
                        n12.S(obj);
                        vh4 vh4Var = (vh4) w53Var.Z;
                        w53Var.Y = 1;
                        objB2 = vh4Var.b(w53Var);
                        if (objB2 == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        if (i19 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                        objB2 = obj;
                    }
                    return xl4Var;
                } finally {
                    pl1Var.a();
                }
            default:
                int i20 = w53Var.Y;
                if (i20 == 0) {
                    n12.S(obj);
                    Object obj4 = w53Var.Z;
                    w53Var.Y = 1;
                    return ((ag1) obj3).h(obj4, w53Var) == mf0Var ? mf0Var : xl4Var;
                }
                if (i20 == 1) {
                    n12.S(obj);
                    return xl4Var;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w53(Object obj, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.y0 = obj;
    }
}
