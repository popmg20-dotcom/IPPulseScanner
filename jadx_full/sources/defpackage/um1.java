package defpackage;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.ui.fragment.settings.VpnSettingsFragment;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class um1 implements Runnable {
    public final /* synthetic */ int b;
    public Object f;
    public final Object z;

    public um1(vf vfVar) {
        this.b = 3;
        this.z = vfVar;
        this.f = new AtomicReference(null);
    }

    private final void a() {
        try {
            ((Runnable) this.z).run();
            synchronized (((la) this.f).A) {
                ((la) this.f).c();
            }
        } catch (Throwable th) {
            synchronized (((la) this.f).A) {
                ((la) this.f).c();
                throw th;
            }
        }
    }

    private final void b() {
        f95 f95Var = (f95) this.z;
        synchronized (f95Var.c) {
            e24 e24Var = (e24) f95Var.d;
            ((Map) ((e24) e24Var.z).z).remove((wa4) e24Var.f);
        }
    }

    private final void c() {
        f95 f95Var = (f95) this.z;
        synchronized (f95Var.c) {
            dv2 dv2Var = (dv2) f95Var.d;
            tj4.i(((wt2) this.f).c());
            dv2Var.c();
        }
    }

    private final void d() {
        f95 f95Var = (f95) this.z;
        synchronized (f95Var.c) {
            jf4 jf4Var = (jf4) f95Var.d;
            ((wt2) this.f).d();
            ((CountDownLatch) jf4Var.f).countDown();
        }
    }

    private final void e() {
        yc5 yc5Var = (yc5) this.z;
        synchronized (yc5Var) {
            try {
                yc5Var.b = false;
                dd5 dd5Var = yc5Var.z;
                if (!dd5Var.m1()) {
                    t65 t65Var = ((k85) dd5Var.f).Y;
                    k85.h(t65Var);
                    t65Var.G0.a("Connected to remote service");
                    v55 v55Var = (v55) this.f;
                    dd5Var.V0();
                    dd5Var.Z = v55Var;
                    dd5Var.i1();
                    dd5Var.k1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        dd5 dd5Var2 = ((yc5) this.z).z;
        ScheduledExecutorService scheduledExecutorService = dd5Var2.A0;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            dd5Var2.A0 = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:263:0x01f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e0  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Long lValueOf;
        lv1 jh5Var = null;
        int i = 0;
        int i2 = 1;
        switch (this.b) {
            case 0:
                om1 om1Var = (om1) this.z;
                try {
                    om1Var.m(n12.C((Future) this.f));
                    return;
                } catch (Error e) {
                    e = e;
                    om1Var.q(e);
                    return;
                } catch (RuntimeException e2) {
                    e = e2;
                    om1Var.q(e);
                    return;
                } catch (ExecutionException e3) {
                    Throwable cause = e3.getCause();
                    if (cause == null) {
                        om1Var.q(e3);
                        return;
                    } else {
                        om1Var.q(cause);
                        return;
                    }
                }
            case 1:
                ((i4) this.f).b = this.z;
                return;
            case 2:
                Object obj = this.z;
                Object obj2 = this.f;
                try {
                    Method method = j4.d;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        j4.e.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e4) {
                    if (e4.getClass() == RuntimeException.class && e4.getMessage() != null && e4.getMessage().startsWith("Unable to stop")) {
                        throw e4;
                    }
                    return;
                } catch (Throwable th) {
                    a1.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
            case 3:
                b80 b80Var = (b80) ((AtomicReference) this.f).get();
                if (b80Var != null) {
                    Iterator it = ((vf) this.z).i.iterator();
                    while (it.hasNext()) {
                        ((am1) it.next()).g(b80Var);
                    }
                    return;
                }
                return;
            case 4:
                ub4 ub4Var = (ub4) this.f;
                Typeface typeface = (Typeface) this.z;
                ji0 ji0Var = (ji0) ub4Var.b;
                if (ji0Var != null) {
                    ji0Var.F(typeface);
                    return;
                }
                return;
            case 5:
                g22 g22Var = (g22) this.f;
                rg3 rg3Var = g22Var.e;
                k22 k22Var = (k22) this.z;
                RecyclerView recyclerView = k22Var.r;
                if (recyclerView == null || !recyclerView.M0 || g22Var.k || rg3Var.b() == -1) {
                    return;
                }
                xf3 itemAnimator = k22Var.r.getItemAnimator();
                if (itemAnimator == null || !itemAnimator.f()) {
                    ArrayList arrayList = k22Var.p;
                    int size = arrayList.size();
                    while (i < size) {
                        if (((g22) arrayList.get(i)).l) {
                            i++;
                        }
                    }
                    k22Var.m.n(rg3Var);
                    return;
                }
                k22Var.r.post(this);
                return;
            case 6:
                break;
            case 7:
                i53 i53Var = (i53) this.z;
                kb2 kb2Var = i53Var.z;
                e53 e53Var = (e53) this.f;
                if (kb2Var.b(e53Var)) {
                    e53 e53Var2 = e53Var.f;
                    e53 e53Var3 = e53Var.z;
                    if (e53Var2 == null) {
                        kb2Var.b = e53Var3;
                    } else {
                        e53Var2.z = e53Var3;
                        e53Var.f = null;
                    }
                    if (e53Var3 == null) {
                        kb2Var.f = e53Var2;
                    } else {
                        e53Var3.f = e53Var2;
                        e53Var.z = null;
                    }
                }
                i53Var.e(e53Var);
                return;
            case 8:
                ((z00) this.z).F((z61) this.f);
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                a();
                return;
            case 10:
                nc2 nc2Var = (nc2) this.f;
                boolean zIsCancelled = nc2Var.isCancelled();
                z00 z00Var = (z00) this.z;
                if (zIsCancelled) {
                    z00Var.q(null);
                    return;
                }
                while (true) {
                    try {
                        try {
                            Object obj3 = nc2Var.get();
                            if (i != 0) {
                                Thread.currentThread().interrupt();
                            }
                            z00Var.d(obj3);
                            return;
                        } catch (ExecutionException e5) {
                            Throwable cause2 = e5.getCause();
                            cause2.getClass();
                            z00Var.d(new tk3(cause2));
                            return;
                        }
                    } catch (InterruptedException unused) {
                        i = 1;
                    } catch (Throwable th2) {
                        if (i != 0) {
                            Thread.currentThread().interrupt();
                        }
                        throw th2;
                    }
                }
                break;
            case 11:
                ((VpnSettingsFragment) this.f).attemptScrollAndFlick((Preference) this.z);
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                ((r92) this.f).c((gw4) this.z);
                return;
            case 13:
                b05 b05Var = (b05) this.z;
                m05 m05Var = (m05) this.f;
                ab0 ab0Var = m05Var.f;
                if (ab0Var.f == 0) {
                    t05 t05Var = m05Var.z;
                    tj4.i(t05Var);
                    ab0 ab0Var2 = t05Var.z;
                    if (ab0Var2.f != 0) {
                        a1.p("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(ab0Var2)), new Exception());
                        b05Var.j.L(ab0Var2);
                        b05Var.i.n();
                        return;
                    }
                    x8 x8Var = b05Var.j;
                    IBinder iBinder = t05Var.f;
                    if (iBinder != null) {
                        int i3 = a3.d;
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                        jh5Var = iInterfaceQueryLocalInterface instanceof lv1 ? (lv1) iInterfaceQueryLocalInterface : new jh5(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                    }
                    Set set = b05Var.g;
                    x8Var.getClass();
                    if (jh5Var == null || set == null) {
                        a1.p("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                        x8Var.L(new ab0(4));
                    } else {
                        x8Var.A = jh5Var;
                        x8Var.X = set;
                        if (x8Var.f) {
                            ((t9) x8Var.b).k(jh5Var, set);
                        }
                    }
                } else {
                    b05Var.j.L(ab0Var);
                }
                b05Var.i.n();
                return;
            case 14:
                n75 n75Var = (n75) this.z;
                k85 k85Var = n75Var.f.a;
                f85 f85Var = k85Var.Z;
                k85.h(f85Var);
                f85Var.V0();
                Bundle bundle = new Bundle();
                bundle.putString("package_name", n75Var.b);
                try {
                    e35 e35Var = (e35) ((g35) this.f);
                    Parcel parcelC = e35Var.c();
                    d35.b(parcelC, bundle);
                    Parcel parcelB = e35Var.b(parcelC, 1);
                    Bundle bundle2 = (Bundle) d35.a(parcelB, Bundle.CREATOR);
                    parcelB.recycle();
                    if (bundle2 == null) {
                        t65 t65Var = k85Var.Y;
                        k85.h(t65Var);
                        t65Var.z0.a("Install Referrer Service returned a null response");
                    }
                    break;
                } catch (Exception e6) {
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.z0.b(e6.getMessage(), "Exception occurred while retrieving the Install Referrer");
                }
                f85 f85Var2 = k85Var.Z;
                k85.h(f85Var2);
                f85Var2.V0();
                throw new IllegalStateException("Unexpected call on client side");
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                b();
                return;
            case 16:
                ff5 ff5Var = ((i95) this.z).c;
                ff5Var.x();
                q15 q15Var = (q15) this.f;
                if (q15Var.z.a() == null) {
                    ff5Var.getClass();
                    String str = q15Var.b;
                    tj4.i(str);
                    tg5 tg5VarN = ff5Var.N(str);
                    if (tg5VarN != null) {
                        ff5Var.Y(q15Var, tg5VarN);
                        return;
                    }
                    return;
                }
                ff5Var.getClass();
                String str2 = q15Var.b;
                tj4.i(str2);
                tg5 tg5VarN2 = ff5Var.N(str2);
                if (tg5VarN2 != null) {
                    ff5Var.X(q15Var, tg5VarN2);
                    return;
                }
                return;
            case 17:
                c();
                return;
            case 18:
                ib5 ib5Var = (ib5) this.z;
                ib5Var.V0();
                ib5Var.W0();
                Bundle bundle3 = (Bundle) this.f;
                String string = bundle3.getString("name");
                String string2 = bundle3.getString("origin");
                tj4.f(string);
                tj4.f(string2);
                tj4.i(bundle3.get("value"));
                k85 k85Var2 = (k85) ib5Var.f;
                if (!k85Var2.a()) {
                    t65 t65Var3 = k85Var2.Y;
                    k85.h(t65Var3);
                    t65Var3.H0.a("Conditional property not set since app measurement is disabled");
                    return;
                }
                kf5 kf5Var = new kf5(bundle3.getLong("triggered_timestamp"), bundle3.get("value"), string, string2);
                try {
                    qf5 qf5Var = k85Var2.z0;
                    k85.f(qf5Var);
                    bundle3.getString("app_id");
                    z25 z25VarZ1 = qf5Var.z1(bundle3.getString("triggered_event_name"), bundle3.getBundle("triggered_event_params"), string2, 0L, true);
                    k85.f(qf5Var);
                    bundle3.getString("app_id");
                    z25 z25VarZ12 = qf5Var.z1(bundle3.getString("timed_out_event_name"), bundle3.getBundle("timed_out_event_params"), string2, 0L, true);
                    bundle3.getString("app_id");
                    k85Var2.j().o1(new q15(bundle3.getString("app_id"), string2, kf5Var, bundle3.getLong("creation_timestamp"), false, bundle3.getString("trigger_event_name"), z25VarZ12, bundle3.getLong("trigger_timeout"), z25VarZ1, bundle3.getLong("time_to_live"), qf5Var.z1(bundle3.getString("expired_event_name"), bundle3.getBundle("expired_event_params"), string2, 0L, true)));
                    return;
                } catch (IllegalArgumentException unused2) {
                    return;
                }
            case 19:
                v35 v35Var = (v35) this.f;
                ib5 ib5Var2 = (ib5) this.z;
                zd5 zd5Var = ((k85) ib5Var2.f).y0;
                k85.g(zd5Var);
                k85 k85Var3 = (k85) zd5Var.f;
                l75 l75Var = k85Var3.X;
                l75 l75Var2 = k85Var3.X;
                k85.f(l75Var);
                if (l75Var.c1().i(r95.ANALYTICS_STORAGE)) {
                    k85.f(l75Var2);
                    k85Var3.B0.getClass();
                    if (!l75Var2.f1(System.currentTimeMillis())) {
                        k85.f(l75Var2);
                        if (l75Var2.K0.a() != 0) {
                            k85.f(l75Var2);
                            lValueOf = Long.valueOf(l75Var2.K0.a());
                        }
                    }
                    if (lValueOf == null) {
                        qf5 qf5Var2 = ((k85) ib5Var2.f).z0;
                        k85.f(qf5Var2);
                        qf5Var2.G1(v35Var, lValueOf.longValue());
                        return;
                    } else {
                        try {
                            v35Var.t(null);
                            return;
                        } catch (RemoteException e7) {
                            t65 t65Var4 = ((k85) ib5Var2.f).Y;
                            k85.h(t65Var4);
                            t65Var4.z0.b(e7, "getSessionId failed with exception");
                            return;
                        }
                    }
                }
                t65 t65Var5 = k85Var3.Y;
                k85.h(t65Var5);
                t65Var5.E0.a("Analytics storage consent denied; will not get session id");
                lValueOf = null;
                if (lValueOf == null) {
                }
                break;
            case 20:
                k85 k85Var4 = (k85) ((ib5) this.z).f;
                l75 l75Var3 = k85Var4.X;
                t65 t65Var6 = k85Var4.Y;
                k85.f(l75Var3);
                l75Var3.V0();
                l75Var3.V0();
                o25 o25VarB = o25.b(l75Var3.Z0().getString("dma_consent_settings", null));
                o25 o25Var = (o25) this.f;
                int i4 = o25Var.a;
                if (!t95.l(i4, o25VarB.a)) {
                    k85.h(t65Var6);
                    t65Var6.F0.b(Integer.valueOf(i4), "Lower precedence consent source ignored, proposed source");
                    return;
                }
                SharedPreferences.Editor editorEdit = l75Var3.Z0().edit();
                editorEdit.putString("dma_consent_settings", o25Var.b);
                editorEdit.apply();
                k85.h(t65Var6);
                t65Var6.H0.b(o25Var, "Setting DMA consent(FE)");
                if (k85Var4.j().f1()) {
                    dd5 dd5VarJ = k85Var4.j();
                    dd5VarJ.V0();
                    dd5VarJ.W0();
                    dd5VarJ.j1(new xc5(dd5VarJ, i2));
                    return;
                }
                dd5 dd5VarJ2 = k85Var4.j();
                dd5VarJ2.V0();
                dd5VarJ2.W0();
                if (dd5VarJ2.e1()) {
                    dd5VarJ2.j1(new ic5(dd5VarJ2, dd5VarJ2.l1(false), 1));
                    return;
                }
                return;
            case 21:
                k85 k85Var5 = (k85) ((ib5) this.f).f;
                d65 d65VarL = k85Var5.l();
                String str3 = (String) this.z;
                String str4 = d65VarL.K0;
                if (str4 != null && !str4.equals(str3)) {
                    i = 1;
                }
                d65VarL.K0 = str3;
                if (i != 0) {
                    k85Var5.l().a1();
                    return;
                }
                return;
            case 22:
                d();
                return;
            case 23:
                dd5 dd5Var = (dd5) this.z;
                v55 v55Var = dd5Var.Z;
                k85 k85Var6 = (k85) dd5Var.f;
                if (v55Var == null) {
                    t65 t65Var7 = k85Var6.Y;
                    k85.h(t65Var7);
                    t65Var7.z0.a("Failed to send current screen to service");
                    return;
                }
                try {
                    rb5 rb5Var = (rb5) this.f;
                    if (rb5Var == null) {
                        v55Var.h(0L, null, null, k85Var6.b.getPackageName());
                    } else {
                        v55Var.h(rb5Var.c, rb5Var.a, rb5Var.b, k85Var6.b.getPackageName());
                    }
                    dd5Var.i1();
                    return;
                } catch (RemoteException e8) {
                    t65 t65Var8 = k85Var6.Y;
                    k85.h(t65Var8);
                    t65Var8.z0.b(e8, "Failed to send current screen to the service");
                    return;
                }
            case 24:
                ((yc5) this.z).z.g1((ComponentName) this.f);
                return;
            case 25:
                e();
                return;
            case 26:
                ff5 ff5Var2 = (ff5) this.f;
                ff5Var2.x();
                Runnable runnable = (Runnable) this.z;
                ff5Var2.C().V0();
                ArrayList arrayList2 = ff5Var2.G0;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    ff5Var2.G0 = arrayList2;
                }
                arrayList2.add(runnable);
                ff5Var2.l();
                return;
            default:
                wt2 wt2Var = (wt2) this.f;
                try {
                    wt2Var.g(((Callable) this.z).call());
                    return;
                } catch (Exception e9) {
                    wt2Var.h(e9);
                    return;
                } catch (Throwable th3) {
                    wt2Var.h(new RuntimeException(th3));
                    return;
                }
        }
        while (true) {
            try {
                ((Runnable) this.f).run();
            } catch (Throwable th4) {
                r25.E(c41.b, th4);
            }
            Runnable runnableX0 = ((ia2) this.z).x0();
            if (runnableX0 == null) {
                return;
            }
            try {
                this.f = runnableX0;
                i++;
                if (i >= 16) {
                    ia2 ia2Var = (ia2) this.z;
                    if (mv0.c(ia2Var.A, ia2Var)) {
                        ia2 ia2Var2 = (ia2) this.z;
                        mv0.b(ia2Var2.A, ia2Var2, this);
                        return;
                    }
                }
            } catch (Throwable th5) {
                ia2 ia2Var3 = (ia2) this.z;
                synchronized (ia2Var3.Z) {
                    ia2.y0.decrementAndGet(ia2Var3);
                    throw th5;
                }
            }
        }
    }

    public String toString() {
        switch (this.b) {
            case 0:
                return um1.class.getSimpleName() + "," + ((om1) this.z);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ um1(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.f = obj2;
        this.z = obj3;
    }

    public /* synthetic */ um1(int i, Object obj, Object obj2, boolean z) {
        this.b = i;
        this.z = obj;
        this.f = obj2;
    }

    public um1(n75 n75Var, g35 g35Var, n75 n75Var2) {
        this.b = 14;
        this.f = g35Var;
        this.z = n75Var;
    }

    public um1(ib5 ib5Var, v35 v35Var) {
        this.b = 19;
        this.f = v35Var;
        Objects.requireNonNull(ib5Var);
        this.z = ib5Var;
    }

    public um1(dd5 dd5Var, rb5 rb5Var) {
        this.b = 23;
        this.f = rb5Var;
        Objects.requireNonNull(dd5Var);
        this.z = dd5Var;
    }

    public /* synthetic */ um1(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    public um1(k22 k22Var, g22 g22Var, int i) {
        this.b = 5;
        this.z = k22Var;
        this.f = g22Var;
    }
}
