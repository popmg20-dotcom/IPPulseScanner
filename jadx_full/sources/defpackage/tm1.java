package defpackage;

import android.app.Application;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.getsurfboard.vpn.Jni;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import io.sentry.android.core.u;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tm1 implements Runnable {
    public final /* synthetic */ int b;
    public Object f;
    public final Object z;

    public /* synthetic */ tm1(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    private final void a() {
        gx4 gx4VarC = ((y84) this.z).b.f.c((String) this.f);
        if (gx4VarC == null || n12.c(mc0.j, gx4VarC.j)) {
            return;
        }
        synchronized (((y84) this.z).z) {
            ((y84) this.z).Y.put(l72.m(gx4VarC), gx4VarC);
            y84 y84Var = (y84) this.z;
            ((y84) this.z).Z.put(l72.m(gx4VarC), mw4.a(y84Var.y0, gx4VarC, (ef0) y84Var.f.b, y84Var));
        }
    }

    private final void b() {
        yc5 yc5Var = (yc5) this.z;
        synchronized (yc5Var) {
            try {
                yc5Var.b = false;
                dd5 dd5Var = yc5Var.z;
                if (!dd5Var.m1()) {
                    t65 t65Var = ((k85) dd5Var.f).Y;
                    k85.h(t65Var);
                    t65Var.H0.a("Connected to service");
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (r1 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        ((java.lang.Runnable) r10.f).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        defpackage.zs3.Y.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.f), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
    
        r10.f = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        Runnable runnable;
        boolean z = false;
        boolean zInterrupted = false;
        while (true) {
            try {
                synchronized (((zs3) this.z).f) {
                    if (z) {
                        runnable = (Runnable) ((zs3) this.z).f.poll();
                        this.f = runnable;
                        if (runnable != null) {
                        }
                    } else {
                        zs3 zs3Var = (zs3) this.z;
                        if (zs3Var.z != 4) {
                            zs3Var.A++;
                            zs3Var.z = 4;
                            z = true;
                            runnable = (Runnable) ((zs3) this.z).f.poll();
                            this.f = runnable;
                            if (runnable != null) {
                                ((zs3) this.z).z = 1;
                            }
                        }
                    }
                }
                if (!zInterrupted) {
                    return;
                }
            } finally {
                if (zInterrupted) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x05ec  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0640  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x067b  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x074b  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0865  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x08b9  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x091d  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x035a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:487:0x064f A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v112, types: [gb5] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        lk2 lk2Var;
        vs4 vs4Var;
        final t53 t53Var;
        lv1 lv1Var;
        String str;
        String installerPackageName;
        PackageManager packageManager;
        String str2;
        String string;
        int i;
        String str3;
        String str4;
        Integer numValueOf;
        String[] stringArray;
        List<String> listAsList;
        nb5 nb5Var;
        qf5 qf5Var;
        r95 r95Var;
        k85 k85Var;
        q65 q65Var;
        ue1 ue1Var;
        k85 k85Var2;
        r95 r95Var2;
        t95 t95Var;
        t95 t95Var2;
        k85 k85Var3;
        o95 o95VarK1;
        o95 o95VarK12;
        Bundle bundle;
        Iterator it;
        Boolean boolH1;
        u uVar;
        o75 o75Var;
        qf5 qf5Var2;
        k85 k85Var4;
        ue1 ue1Var2;
        t65 t65Var;
        q65 q65Var2;
        boolean z;
        try {
            switch (this.b) {
                case 0:
                    ca5 ca5Var = (ca5) this.z;
                    try {
                        l72.t((nc2) this.f);
                        ib5 ib5Var = (ib5) ca5Var.b;
                        ib5Var.V0();
                        ca5Var.c();
                        ib5Var.C0 = false;
                        ib5Var.D0 = 1;
                        t65 t65Var2 = ((k85) ib5Var.f).Y;
                        k85.h(t65Var2);
                        t65Var2.G0.b(((ee5) ca5Var.a).b, "Successfully registered trigger URI");
                        ib5Var.u1();
                        return;
                    } catch (ExecutionException e) {
                        ca5Var.a(e.getCause());
                        return;
                    } catch (Throwable th) {
                        ca5Var.a(th);
                        return;
                    }
                case 1:
                    l3 l3Var = (l3) this.f;
                    q3 q3Var = (q3) this.z;
                    nk2 nk2Var = q3Var.z;
                    if (nk2Var != null && (lk2Var = nk2Var.e) != null) {
                        lk2Var.a0(nk2Var);
                    }
                    View view = (View) q3Var.y0;
                    if (view != null && view.getWindowToken() != null) {
                        if (l3Var.b()) {
                            q3Var.K0 = l3Var;
                        } else if (l3Var.e != null) {
                            l3Var.d(0, 0, false, false);
                            q3Var.K0 = l3Var;
                        }
                    }
                    q3Var.M0 = null;
                    return;
                case 2:
                    ((Application) this.f).unregisterActivityLifecycleCallbacks((i4) this.z);
                    return;
                case 3:
                    mf mfVar = (mf) this.z;
                    of ofVar = (of) mfVar.Y;
                    if (ofVar.g == mfVar.f) {
                        List list = (List) mfVar.A;
                        ju0 ju0Var = (ju0) this.f;
                        Runnable runnable = (Runnable) mfVar.X;
                        ofVar.e = list;
                        ofVar.f = DesugarCollections.unmodifiableList(list);
                        ju0Var.b(ofVar.a);
                        ofVar.a(runnable);
                        return;
                    }
                    return;
                case 4:
                    try {
                        ((lu) this.z).f.put((aj3) this.f);
                        return;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                case 5:
                    try {
                        try {
                            r20 r20Var = (r20) this.z;
                            Object objE = n12.E((nc2) this.f);
                            vv vvVar = r20Var.f;
                            if (vvVar != null) {
                                vvVar.b(objE);
                            }
                        } catch (CancellationException unused2) {
                            ((r20) this.z).cancel(false);
                        }
                        break;
                    } catch (ExecutionException e2) {
                        r20 r20Var2 = (r20) this.z;
                        Throwable cause = e2.getCause();
                        vv vvVar2 = r20Var2.f;
                        if (vvVar2 != null) {
                            vvVar2.d(cause);
                        }
                    }
                    return;
                case 6:
                    yl0 yl0Var = (yl0) this.z;
                    ArrayList<wl0> arrayList = (ArrayList) this.f;
                    for (wl0 wl0Var : arrayList) {
                        ArrayList arrayList2 = yl0Var.q;
                        long j = yl0Var.f;
                        rg3 rg3Var = wl0Var.a;
                        View view2 = rg3Var == null ? null : rg3Var.a;
                        rg3 rg3Var2 = wl0Var.b;
                        View view3 = rg3Var2 != null ? rg3Var2.a : null;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(j);
                            arrayList2.add(wl0Var.a);
                            duration.translationX(wl0Var.e - wl0Var.c);
                            duration.translationY(wl0Var.f - wl0Var.d);
                            duration.alpha(0.0f).setListener(new vl0(yl0Var, wl0Var, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator viewPropertyAnimatorAnimate = view3.animate();
                            arrayList2.add(wl0Var.b);
                            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(j).alpha(1.0f).setListener(new vl0(yl0Var, wl0Var, viewPropertyAnimatorAnimate, view3, 1)).start();
                        }
                    }
                    arrayList.clear();
                    yl0Var.m.remove(arrayList);
                    return;
                case 7:
                    ue2 ue2VarG = ue2.g();
                    String str5 = rn0.d;
                    StringBuilder sb = new StringBuilder("Scheduling work ");
                    gx4 gx4Var = (gx4) this.f;
                    sb.append(gx4Var.a);
                    ue2VarG.a(str5, sb.toString());
                    ((rn0) this.z).a.e(gx4Var);
                    return;
                case 8:
                    final Jni jni = (Jni) this.f;
                    yw1 yw1Var = jni.a;
                    if (jni.u == null || (vs4Var = (vs4) ws4.c.d()) == null || !vs4Var.b || (t53Var = yw1Var.z) == null) {
                        return;
                    }
                    String string2 = UUID.randomUUID().toString();
                    string2.getClass();
                    final na3 na3Var = (na3) this.z;
                    new zz3(string2, t53Var, na3Var, yw1Var.y0.f, new fm1() { // from class: u32
                        /* JADX WARN: Removed duplicated region for block: B:33:0x00f5  */
                        @Override // defpackage.fm1
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object i(Object obj, Object obj2, Object obj3, Object obj4) {
                            xl4 xl4Var;
                            boolean z2;
                            int i2;
                            na3 na3Var2 = na3Var;
                            Jni jni2 = jni;
                            t53 t53Var2 = t53Var;
                            tm1 tm1Var = this;
                            String str6 = (String) obj;
                            String str7 = (String) obj2;
                            String str8 = (String) obj3;
                            nn0 nn0Var = (nn0) obj4;
                            xl4 xl4Var2 = xl4.a;
                            str6.getClass();
                            str7.getClass();
                            String str9 = "speedometer finished with: best = " + str8;
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str9);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("Jni", str9, null);
                            }
                            if (str8 == null || nn0Var == null) {
                                return xl4Var2;
                            }
                            boolean z3 = na3Var2 instanceof ma3;
                            if (z3) {
                                Long l = (Long) jni2.k.get(new e03(str6, str7));
                                long jLongValue = l != null ? l.longValue() : 0L;
                                if (jLongValue > 0) {
                                    z2 = z3;
                                    long j2 = jLongValue - nn0Var.a;
                                    int i3 = ((ma3) na3Var2).z0;
                                    xl4Var = xl4Var2;
                                    if (j2 < i3) {
                                        String str10 = "not exceed previous delay " + jLongValue + " with tolerance " + i3;
                                        if (fy4.b) {
                                            Xlog.logWrite2(0L, 3, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str10);
                                        }
                                        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                                            return xl4Var;
                                        }
                                        a1.o("Jni", str10, null);
                                        return xl4Var;
                                    }
                                }
                            } else {
                                xl4Var = xl4Var2;
                                z2 = z3;
                            }
                            vs4 vs4Var2 = (vs4) ws4.c.d();
                            if (vs4Var2 != null && vs4Var2.b) {
                                yw1 yw1Var2 = jni2.a;
                                String str11 = t53Var2.b;
                                String name = na3Var2.getName();
                                ((SurfboardVpn) yw1Var2).getClass();
                                str11.getClass();
                                name.getClass();
                                ua3 ua3VarT = oj0.a.t();
                                ke0.r(ua3VarT.a, false, true, new gj(16, ua3VarT, new sa3[]{new sa3(str11, name, str8)}));
                                yw1 yw1Var3 = jni2.a;
                                zw1.a(yw1Var3, yw1Var3.getClass(), t53Var2.b, na3Var2.getName(), str8, false);
                                if (z2) {
                                    i2 = ((ma3) na3Var2).y0;
                                } else {
                                    if (!(na3Var2 instanceof ia3)) {
                                        xe.k("unsupported proxy group type: ".concat(na3Var2.getClass().getName()));
                                        return null;
                                    }
                                    i2 = ((ia3) na3Var2).y0;
                                }
                                long j3 = ((long) i2) * 1000;
                                Handler handler = ((Jni) tm1Var.f).a.Y;
                                if (handler != null) {
                                    handler.postDelayed(tm1Var, j3);
                                }
                                jni2.k.put(new e03(str6, str7), Long.valueOf(nn0Var.a));
                            }
                            b04.a(str6, str7, null);
                            return xl4Var;
                        }
                    }, false).d();
                    return;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    i53 i53Var = (i53) this.z;
                    AtomicLong atomicLong = i53Var.A;
                    atomicLong.lazySet(atomicLong.get() + 1);
                    e53 e53Var = (e53) this.f;
                    if (((g53) e53Var.get()).a()) {
                        i53Var.z.offerLast(e53Var);
                        i53Var.d();
                        return;
                    }
                    return;
                case 10:
                    ((i01) this.f).accept(this.z);
                    return;
                case 11:
                    try {
                        c();
                        return;
                    } catch (Error e3) {
                        synchronized (((zs3) this.z).f) {
                            ((zs3) this.z).z = 1;
                            throw e3;
                        }
                    }
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    a();
                    return;
                case 13:
                    nc2 nc2Var = (nc2) this.f;
                    boolean zIsCancelled = nc2Var.isCancelled();
                    z00 z00Var = (z00) this.z;
                    if (zIsCancelled) {
                        z00Var.q(null);
                        return;
                    }
                    try {
                        z00Var.d(x1.g(nc2Var));
                        return;
                    } catch (ExecutionException e4) {
                        Throwable cause2 = e4.getCause();
                        if (cause2 != null) {
                            z00Var.d(new tk3(cause2));
                            return;
                        } else {
                            m82 m82Var = new m82();
                            n12.P(m82Var, n12.class.getName());
                            throw m82Var;
                        }
                    }
                case 14:
                    ((r92) this.f).a((gw4) this.z);
                    return;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    ab0 ab0Var = (ab0) this.f;
                    x8 x8Var = (x8) this.z;
                    t9 t9Var = (t9) x8Var.b;
                    sz4 sz4Var = (sz4) ((tp1) x8Var.Y).j.get((x9) x8Var.z);
                    if (sz4Var == null) {
                        return;
                    }
                    if (ab0Var.f != 0) {
                        sz4Var.o(ab0Var, null);
                        return;
                    }
                    x8Var.f = true;
                    if (t9Var.j()) {
                        if (!x8Var.f || (lv1Var = (lv1) x8Var.A) == null) {
                            return;
                        }
                        t9Var.k(lv1Var, (Set) x8Var.X);
                        return;
                    }
                    try {
                        t9Var.k(null, t9Var.a());
                        return;
                    } catch (SecurityException e5) {
                        a1.e("GoogleApiManager", "Failed to get service from broker. ", e5);
                        t9Var.b("Failed to get service from broker.");
                        sz4Var.o(new ab0(10), null);
                        return;
                    }
                case 16:
                    m95 m95Var = (m95) this.f;
                    m95Var.U();
                    if (d84.j()) {
                        m95Var.C().e1(this);
                        return;
                    }
                    n25 n25Var = (n25) this.z;
                    boolean z2 = n25Var.c != 0;
                    n25Var.c = 0L;
                    if (z2) {
                        n25Var.a();
                        return;
                    }
                    return;
                case 17:
                    o95 o95Var = o95.UNINITIALIZED;
                    k85 k85Var5 = (k85) this.z;
                    y95 y95Var = (y95) this.f;
                    f85 f85Var = k85Var5.Z;
                    t65 t65Var3 = k85Var5.Y;
                    l75 l75Var = k85Var5.X;
                    qf5 qf5Var3 = k85Var5.z0;
                    k85.h(f85Var);
                    f85Var.V0();
                    x15 x15Var = k85Var5.A;
                    ((k85) x15Var.f).getClass();
                    u25 u25Var = new u25(k85Var5);
                    ((k85) u25Var.f).R0++;
                    u25Var.Y0();
                    k85Var5.J0 = u25Var;
                    j45 j45Var = y95Var.d;
                    d65 d65Var = new d65(k85Var5, y95Var.c, j45Var == null ? 0L : j45Var.b);
                    d65Var.X0();
                    k85Var5.K0 = d65Var;
                    i65 i65Var = new i65(k85Var5);
                    i65Var.X0();
                    k85Var5.H0 = i65Var;
                    dd5 dd5Var = new dd5(k85Var5);
                    dd5Var.X0();
                    k85Var5.I0 = dd5Var;
                    boolean z3 = qf5Var3.X;
                    k85 k85Var6 = (k85) qf5Var3.f;
                    if (z3) {
                        xe.q("Can't initialize twice");
                        return;
                    }
                    qf5Var3.V0();
                    SecureRandom secureRandom = new SecureRandom();
                    long jNextLong = secureRandom.nextLong();
                    if (jNextLong == 0) {
                        jNextLong = secureRandom.nextLong();
                        if (jNextLong == 0) {
                            t65 t65Var4 = ((k85) qf5Var3.f).Y;
                            k85.h(t65Var4);
                            t65Var4.C0.a("Utils falling back to Random for random id");
                        }
                    }
                    qf5Var3.Z.set(jNextLong);
                    k85Var6.T0.incrementAndGet();
                    qf5Var3.X = true;
                    if (l75Var.X) {
                        xe.q("Can't initialize twice");
                        return;
                    }
                    SharedPreferences sharedPreferences = ((k85) l75Var.f).b.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                    l75Var.Y = sharedPreferences;
                    boolean z4 = sharedPreferences.getBoolean("has_been_opened", false);
                    l75Var.L0 = z4;
                    if (!z4) {
                        SharedPreferences.Editor editorEdit = l75Var.Y.edit();
                        editorEdit.putBoolean("has_been_opened", true);
                        editorEdit.apply();
                    }
                    l75Var.y0 = new i40(l75Var, Math.max(0L, ((Long) r55.d.a(null)).longValue()));
                    ((k85) l75Var.f).T0.incrementAndGet();
                    l75Var.X = true;
                    d65 d65Var2 = k85Var5.K0;
                    if (d65Var2.X) {
                        xe.q("Can't initialize twice");
                        return;
                    }
                    String str6 = "";
                    k85 k85Var7 = (k85) d65Var2.f;
                    t65 t65Var5 = k85Var7.Y;
                    t65 t65Var6 = k85Var7.Y;
                    k85.h(t65Var5);
                    t65Var5.H0.c("sdkVersion bundled with app, dynamiteVersion", Long.valueOf(d65Var2.D0), Long.valueOf(d65Var2.C0));
                    Context context = k85Var7.b;
                    String packageName = context.getPackageName();
                    PackageManager packageManager2 = context.getPackageManager();
                    if (packageManager2 == null) {
                        k85.h(t65Var6);
                        str = "Can't initialize twice";
                        t65Var6.z0.b(t65.Z0(packageName), "PackageManager is null, app identity information might be inaccurate. appId");
                        str3 = "Unknown";
                        string = str3;
                        installerPackageName = "unknown";
                        packageManager = packageManager2;
                        i = Integer.MIN_VALUE;
                    } else {
                        String str7 = "Unknown";
                        str = "Can't initialize twice";
                        try {
                            installerPackageName = packageManager2.getInstallerPackageName(packageName);
                        } catch (IllegalArgumentException unused3) {
                            k85.h(t65Var6);
                            t65Var6.z0.b(t65.Z0(packageName), "Error retrieving app installer package name. appId");
                            installerPackageName = "unknown";
                        }
                        if (installerPackageName == null) {
                            installerPackageName = "manual_install";
                        } else if ("com.android.vending".equals(installerPackageName)) {
                            installerPackageName = "";
                        }
                        try {
                            PackageInfo packageInfo = packageManager2.getPackageInfo(context.getPackageName(), 0);
                            if (packageInfo != null) {
                                CharSequence applicationLabel = packageManager2.getApplicationLabel(packageInfo.applicationInfo);
                                string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : str7;
                                packageManager = packageManager2;
                                try {
                                    str4 = packageInfo.versionName;
                                    break;
                                } catch (PackageManager.NameNotFoundException unused4) {
                                }
                                try {
                                    int i2 = packageInfo.versionCode;
                                    str3 = str4;
                                    i = i2;
                                } catch (PackageManager.NameNotFoundException unused5) {
                                    str7 = str4;
                                    str2 = string;
                                    k85.h(t65Var6);
                                    t65Var6.z0.c("Error retrieving package info. appId, appName", t65.Z0(packageName), str2);
                                    string = str2;
                                    i = Integer.MIN_VALUE;
                                    str3 = str7;
                                    installerPackageName = installerPackageName;
                                }
                            } else {
                                packageManager = packageManager2;
                                i = Integer.MIN_VALUE;
                                str3 = str7;
                                string = str3;
                            }
                        } catch (PackageManager.NameNotFoundException unused6) {
                            packageManager = packageManager2;
                            str2 = str7;
                        }
                    }
                    d65Var2.Y = packageName;
                    d65Var2.z0 = installerPackageName;
                    d65Var2.Z = str3;
                    d65Var2.y0 = i;
                    d65Var2.A0 = string;
                    d65Var2.B0 = 0L;
                    int iB = k85Var7.b();
                    if (iB == 0) {
                        k85.h(t65Var6);
                        t65Var6.H0.a("App measurement collection enabled");
                    } else if (iB == 1) {
                        k85.h(t65Var6);
                        t65Var6.F0.a("App measurement deactivated via the manifest");
                    } else if (iB == 3) {
                        k85.h(t65Var6);
                        t65Var6.F0.a("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                    } else if (iB == 4) {
                        k85.h(t65Var6);
                        t65Var6.F0.a("App measurement disabled via the manifest");
                    } else if (iB == 6) {
                        k85.h(t65Var6);
                        t65Var6.E0.a("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                    } else if (iB == 7) {
                        k85.h(t65Var6);
                        t65Var6.F0.a("App measurement disabled via the global data collection setting");
                    } else if (iB != 8) {
                        k85.h(t65Var6);
                        t65Var6.F0.a("App measurement disabled");
                        k85.h(t65Var6);
                        t65Var6.A0.a("Invalid scion state in identity");
                    } else {
                        k85.h(t65Var6);
                        t65Var6.F0.a("App measurement disabled due to denied storage consent");
                    }
                    d65Var2.H0 = "";
                    try {
                        String strY = n12.Y(context, k85Var7.G0);
                        if (!TextUtils.isEmpty(strY)) {
                            str6 = strY;
                        }
                        d65Var2.H0 = str6;
                        if (iB == 0) {
                            k85.h(t65Var6);
                            t65Var6.H0.c("App measurement enabled for app package, google app id", d65Var2.Y, d65Var2.H0);
                        }
                    } catch (IllegalStateException e6) {
                        k85.h(t65Var6);
                        t65Var6.z0.c("Fetching Google App Id failed with exception. appId", t65.Z0(packageName), e6);
                    }
                    d65Var2.E0 = null;
                    x15 x15Var2 = k85Var7.A;
                    k85 k85Var8 = (k85) x15Var2.f;
                    tj4.f("analytics.safelisted_events");
                    Bundle bundleG1 = x15Var2.g1();
                    if (bundleG1 != null) {
                        if (bundleG1.containsKey("analytics.safelisted_events")) {
                            numValueOf = Integer.valueOf(bundleG1.getInt("analytics.safelisted_events"));
                        }
                        if (numValueOf == null) {
                            try {
                                stringArray = k85Var8.b.getResources().getStringArray(numValueOf.intValue());
                            } catch (Resources.NotFoundException e7) {
                                t65 t65Var7 = k85Var8.Y;
                                k85.h(t65Var7);
                                t65Var7.z0.b(e7, "Failed to load string array from metadata: resource not found");
                            }
                            listAsList = stringArray != null ? Arrays.asList(stringArray) : null;
                            break;
                        }
                        if (listAsList == null) {
                            d65Var2.E0 = listAsList;
                        } else if (listAsList.isEmpty()) {
                            k85.h(t65Var6);
                            t65Var6.E0.a("Safelisted event list is empty. Ignoring");
                        } else {
                            for (String str8 : listAsList) {
                                qf5 qf5Var4 = k85Var7.z0;
                                k85.f(qf5Var4);
                                if (!qf5Var4.Y1("safelisted event", str8)) {
                                }
                            }
                            d65Var2.E0 = listAsList;
                        }
                        if (packageManager == null) {
                            d65Var2.G0 = v02.r(context) ? 1 : 0;
                        } else {
                            d65Var2.G0 = 0;
                        }
                        ((k85) d65Var2.f).T0.incrementAndGet();
                        d65Var2.X = true;
                        nb5Var = new nb5(k85Var5);
                        k85 k85Var9 = (k85) nb5Var.f;
                        k85Var9.R0++;
                        nb5Var.X0();
                        k85Var5.L0 = nb5Var;
                        if (!nb5Var.X) {
                            xe.q(str);
                            return;
                        }
                        nb5Var.Y = (JobScheduler) ((k85) nb5Var.f).b.getSystemService("jobscheduler");
                        k85Var9.T0.incrementAndGet();
                        nb5Var.X = true;
                        k85.h(t65Var3);
                        q65 q65Var3 = t65Var3.G0;
                        q65 q65Var4 = t65Var3.F0;
                        q65 q65Var5 = t65Var3.H0;
                        q65 q65Var6 = t65Var3.z0;
                        x15Var.a1();
                        q65Var4.b(133005L, "App measurement initialized, version");
                        k85.h(t65Var3);
                        q65Var4.a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
                        String strB1 = d65Var.b1();
                        if (qf5Var3.x1(strB1, x15Var.Y)) {
                            k85.h(t65Var3);
                            q65Var4.a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
                        } else {
                            k85.h(t65Var3);
                            q65Var4.a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(strB1)));
                        }
                        k85.h(t65Var3);
                        q65Var3.a("Debug-level message logging enabled");
                        int i3 = k85Var5.R0;
                        AtomicInteger atomicInteger = k85Var5.T0;
                        if (i3 != atomicInteger.get()) {
                            k85.h(t65Var3);
                            q65Var6.c("Not all components initialized", Integer.valueOf(k85Var5.R0), Integer.valueOf(atomicInteger.get()));
                        }
                        k85Var5.M0 = true;
                        long j2 = k85Var5.U0;
                        r95 r95Var3 = r95.ANALYTICS_STORAGE;
                        final ib5 ib5Var2 = k85Var5.D0;
                        k85.h(f85Var);
                        f85Var.V0();
                        k85.e(k85Var5.L0);
                        int iA1 = k85Var5.L0.a1();
                        mg5.a();
                        boolean zF1 = x15Var.f1(null, r55.R0);
                        boolean z5 = iA1 == 2;
                        if (zF1) {
                            qf5Var3.V0();
                            if (qf5Var3.s1() == 1) {
                                qf5Var3.V0();
                                IntentFilter intentFilter = new IntentFilter();
                                intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                                intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                                z = z5;
                                k85Var = k85Var6;
                                q65Var = q65Var6;
                                qf5Var = qf5Var3;
                                v9.r(k85Var.b, new wa(k85Var), intentFilter, 2);
                                t65 t65Var8 = k85Var.Y;
                                k85.h(t65Var8);
                                t65Var8.G0.a("Registered app receiver");
                                if (z) {
                                    r95Var = r95Var3;
                                } else {
                                    k85.e(k85Var5.L0);
                                    r95Var = r95Var3;
                                    k85Var5.L0.Z0(((Long) r55.C.a(null)).longValue());
                                }
                            } else if (z5) {
                                z5 = true;
                                qf5Var3.V0();
                                IntentFilter intentFilter2 = new IntentFilter();
                                intentFilter2.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                                intentFilter2.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                                z = z5;
                                k85Var = k85Var6;
                                q65Var = q65Var6;
                                qf5Var = qf5Var3;
                                v9.r(k85Var.b, new wa(k85Var), intentFilter2, 2);
                                t65 t65Var82 = k85Var.Y;
                                k85.h(t65Var82);
                                t65Var82.G0.a("Registered app receiver");
                                if (z) {
                                }
                            } else {
                                qf5Var = qf5Var3;
                                r95Var = r95Var3;
                                k85Var = k85Var6;
                                q65Var = q65Var6;
                            }
                        }
                        ue1 ue1Var3 = l75Var.A0;
                        t95 t95VarC1 = l75Var.c1();
                        int i4 = t95VarC1.b;
                        o95 o95VarK13 = x15Var.k1("google_analytics_default_allow_ad_storage", false);
                        k85 k85Var10 = k85Var;
                        o95 o95VarK14 = x15Var.k1("google_analytics_default_allow_analytics_storage", false);
                        if (o95VarK13 != o95Var || o95VarK14 != o95Var) {
                            ue1Var = ue1Var3;
                            k85Var2 = k85Var5;
                            if (t95.l(-10, l75Var.Z0().getInt("consent_source", 100))) {
                                EnumMap enumMap = new EnumMap(r95.class);
                                enumMap.put(r95.AD_STORAGE, o95VarK13);
                                r95Var2 = r95Var;
                                enumMap.put(r95Var2, o95VarK14);
                                t95Var = new t95(enumMap, -10);
                            }
                            if (t95Var == null) {
                                k85.g(ib5Var2);
                                ib5Var2.r1(t95Var, true);
                                t95Var2 = t95Var;
                            } else {
                                t95Var2 = t95VarC1;
                            }
                            k85.g(ib5Var2);
                            k85Var3 = (k85) ib5Var2.f;
                            ib5Var2.Z0(t95Var2);
                            l75Var.V0();
                            int i5 = o25.b(l75Var.Z0().getString("dma_consent_settings", null)).a;
                            o95VarK1 = x15Var.k1("google_analytics_default_allow_ad_personalization_signals", true);
                            if (o95VarK1 != o95Var) {
                                k85.h(t65Var3);
                                q65Var5.b(o95VarK1, "Default ad personalization consent from Manifest");
                            }
                            o95VarK12 = x15Var.k1("google_analytics_default_allow_ad_user_data", true);
                            if (o95VarK12 == o95Var && t95.l(-10, i5)) {
                                k85.g(ib5Var2);
                                EnumMap enumMap2 = new EnumMap(r95.class);
                                enumMap2.put(r95.AD_USER_DATA, o95VarK12);
                                ib5Var2.q1(new o25(enumMap2, -10, (Boolean) null, (String) null), true);
                            } else if (TextUtils.isEmpty(k85Var2.l().c1()) && (i5 == 0 || i5 == 30)) {
                                k85.g(ib5Var2);
                                ib5Var2.q1(new o25((Boolean) null, -10, (Boolean) null, (String) null), true);
                            } else if (TextUtils.isEmpty(k85Var2.l().c1()) && j45Var != null && (bundle = j45Var.A) != null && t95.l(30, i5)) {
                                o25 o25VarC = o25.c(30, bundle);
                                it = o25VarC.e.values().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (((o95) it.next()) != o95Var) {
                                            k85.g(ib5Var2);
                                            ib5Var2.q1(o25VarC, true);
                                        }
                                    }
                                }
                            }
                            boolH1 = x15Var.h1("google_analytics_tcf_data_enabled");
                            if (boolH1 != null || boolH1.booleanValue()) {
                                k85.h(t65Var3);
                                q65Var3.a("TCF client enabled.");
                                k85.g(ib5Var2);
                                ib5Var2.V0();
                                t65 t65Var9 = k85Var3.Y;
                                k85.h(t65Var9);
                                t65Var9.G0.a("Register tcfPrefChangeListener.");
                                if (ib5Var2.O0 == null) {
                                    ib5Var2.P0 = new ba5(ib5Var2, k85Var3, 2);
                                    ib5Var2.O0 = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: gb5
                                        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                                        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str9) {
                                            ib5 ib5Var3 = ib5Var2;
                                            k85 k85Var11 = (k85) ib5Var3.f;
                                            x15 x15Var3 = k85Var11.A;
                                            t65 t65Var10 = k85Var11.Y;
                                            if (!x15Var3.f1(null, r55.a1)) {
                                                if (Objects.equals(str9, "IABTCF_TCString")) {
                                                    k85.h(t65Var10);
                                                    t65Var10.H0.a("IABTCF_TCString change picked up in listener.");
                                                    ba5 ba5Var = ib5Var3.P0;
                                                    tj4.i(ba5Var);
                                                    ba5Var.b(500L);
                                                    return;
                                                }
                                                return;
                                            }
                                            if (Objects.equals(str9, "IABTCF_TCString") || Objects.equals(str9, "IABTCF_gdprApplies") || Objects.equals(str9, "IABTCF_EnableAdvertiserConsentMode")) {
                                                k85.h(t65Var10);
                                                t65Var10.H0.a("IABTCF_TCString change picked up in listener.");
                                                ba5 ba5Var2 = ib5Var3.P0;
                                                tj4.i(ba5Var2);
                                                ba5Var2.b(500L);
                                            }
                                        }
                                    };
                                }
                                l75 l75Var2 = k85Var3.X;
                                k85.f(l75Var2);
                                l75Var2.a1().registerOnSharedPreferenceChangeListener(ib5Var2.O0);
                                k85.g(ib5Var2);
                                ib5Var2.b1();
                            }
                            uVar = l75Var.z0;
                            if (uVar.a() == 0) {
                                k85.h(t65Var3);
                                q65Var5.b(Long.valueOf(j2), "Persisting first open");
                                uVar.b(j2);
                            }
                            k85.g(ib5Var2);
                            o75Var = ib5Var2.L0;
                            if (o75Var.d() && o75Var.c()) {
                                l75 l75Var3 = o75Var.a.X;
                                k85.f(l75Var3);
                                l75Var3.Q0.C(null);
                            }
                            if (!k85Var2.c()) {
                                qf5Var2 = qf5Var;
                                k85Var4 = k85Var2;
                                if (TextUtils.isEmpty(k85Var4.l().c1())) {
                                    ue1Var2 = ue1Var;
                                } else {
                                    String strC1 = k85Var4.l().c1();
                                    l75Var.V0();
                                    String string3 = l75Var.Z0().getString("gmp_app_id", null);
                                    boolean zIsEmpty = TextUtils.isEmpty(strC1);
                                    boolean zIsEmpty2 = TextUtils.isEmpty(string3);
                                    if (zIsEmpty || zIsEmpty2) {
                                        ue1Var2 = ue1Var;
                                        String strC12 = k85Var4.l().c1();
                                        l75Var.V0();
                                        SharedPreferences.Editor editorEdit2 = l75Var.Z0().edit();
                                        editorEdit2.putString("gmp_app_id", strC12);
                                        editorEdit2.apply();
                                    } else {
                                        tj4.i(strC1);
                                        if (!strC1.equals(string3)) {
                                            k85.h(t65Var3);
                                            q65Var4.a("Rechecking which service to use due to a GMP App Id change");
                                            l75Var.V0();
                                            l75Var.V0();
                                            Boolean boolValueOf = l75Var.Z0().contains("measurement_enabled") ? Boolean.valueOf(l75Var.Z0().getBoolean("measurement_enabled", true)) : null;
                                            SharedPreferences.Editor editorEdit3 = l75Var.Z0().edit();
                                            editorEdit3.clear();
                                            editorEdit3.apply();
                                            if (boolValueOf != null) {
                                                l75Var.V0();
                                                SharedPreferences.Editor editorEdit4 = l75Var.Z0().edit();
                                                editorEdit4.putBoolean("measurement_enabled", boolValueOf.booleanValue());
                                                editorEdit4.apply();
                                            }
                                            k85Var4.i().Z0();
                                            k85Var4.I0.d1();
                                            k85Var4.I0.b1();
                                            uVar.b(j2);
                                            ue1Var2 = ue1Var;
                                            ue1Var2.C(null);
                                        }
                                        String strC122 = k85Var4.l().c1();
                                        l75Var.V0();
                                        SharedPreferences.Editor editorEdit22 = l75Var.Z0().edit();
                                        editorEdit22.putString("gmp_app_id", strC122);
                                        editorEdit22.apply();
                                    }
                                }
                                if (!l75Var.c1().i(r95Var2)) {
                                    ue1Var2.C(null);
                                }
                                k85.g(ib5Var2);
                                ib5Var2.A0.set(ue1Var2.B());
                                try {
                                    k85Var10.b.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                                } catch (ClassNotFoundException unused7) {
                                    ue1 ue1Var4 = l75Var.P0;
                                    if (!TextUtils.isEmpty(ue1Var4.B())) {
                                        k85.h(t65Var3);
                                        t65Var = t65Var3;
                                        t65Var.C0.a("Remote config removed with active feature rollouts");
                                        ue1Var4.C(null);
                                    }
                                    if (!TextUtils.isEmpty(k85Var4.l().c1())) {
                                    }
                                    mg5.a();
                                    if (x15Var.f1(null, r55.R0)) {
                                    }
                                    l75Var.I0.b(true);
                                    return;
                                }
                                t65Var = t65Var3;
                                if (!TextUtils.isEmpty(k85Var4.l().c1())) {
                                    boolean zA = k85Var4.a();
                                    SharedPreferences sharedPreferences2 = l75Var.Y;
                                    if (!(sharedPreferences2 == null ? false : sharedPreferences2.contains("deferred_analytics_collection")) && !x15Var.i1()) {
                                        l75Var.e1(!zA);
                                    }
                                    if (zA) {
                                        k85.g(ib5Var2);
                                        ib5Var2.h1();
                                    }
                                    zd5 zd5Var = k85Var4.y0;
                                    k85.g(zd5Var);
                                    zd5Var.y0.e();
                                    k85Var4.j().Z0(new AtomicReference());
                                    k85Var4.j().a1(l75Var.S0.f());
                                }
                                break;
                            } else {
                                if (k85Var2.a()) {
                                    qf5Var2 = qf5Var;
                                    if (qf5Var2.u1("android.permission.INTERNET")) {
                                        q65Var2 = q65Var;
                                    } else {
                                        k85.h(t65Var3);
                                        q65Var2 = q65Var;
                                        q65Var2.a("App is missing INTERNET permission");
                                    }
                                    if (!qf5Var2.u1("android.permission.ACCESS_NETWORK_STATE")) {
                                        k85.h(t65Var3);
                                        q65Var2.a("App is missing ACCESS_NETWORK_STATE permission");
                                    }
                                    k85Var4 = k85Var2;
                                    Context context2 = k85Var4.b;
                                    if (!ay4.a(context2).b() && !x15Var.Y0()) {
                                        if (!qf5.N1(context2)) {
                                            k85.h(t65Var3);
                                            q65Var2.a("AppMeasurementReceiver not registered/enabled");
                                        }
                                        if (!qf5.o1(context2)) {
                                            k85.h(t65Var3);
                                            q65Var2.a("AppMeasurementService not registered/enabled");
                                        }
                                    }
                                    k85.h(t65Var3);
                                    q65Var2.a("Uploading is not possible. App measurement disabled");
                                } else {
                                    qf5Var2 = qf5Var;
                                    k85Var4 = k85Var2;
                                }
                                t65Var = t65Var3;
                            }
                            mg5.a();
                            if (x15Var.f1(null, r55.R0)) {
                                qf5Var2.V0();
                                if (qf5Var2.s1() == 1) {
                                    long jIntValue = ((Integer) r55.y0.a(null)).intValue();
                                    long jNextInt = new Random().nextInt(5000);
                                    k85Var4.B0.getClass();
                                    long jMax = Math.max(500L, ((jIntValue * 1000) + jNextInt) - SystemClock.elapsedRealtime());
                                    if (jMax > 500) {
                                        k85.h(t65Var);
                                        q65Var5.b(Long.valueOf(jMax), "Waiting to fetch trigger URIs until some time after boot. Delay in millis");
                                    }
                                    k85.g(ib5Var2);
                                    ib5Var2.V0();
                                    ba5 ba5Var = ib5Var2.F0;
                                    if (ba5Var == null) {
                                        ba5Var = new ba5(ib5Var2, k85Var3, 0);
                                        ib5Var2.F0 = ba5Var;
                                    }
                                    ba5Var.b(jMax);
                                }
                            }
                            l75Var.I0.b(true);
                            return;
                        }
                        ue1Var = ue1Var3;
                        k85Var2 = k85Var5;
                        r95Var2 = r95Var;
                        if (!TextUtils.isEmpty(k85Var2.l().c1()) && (i4 == 0 || i4 == 30 || i4 == 10 || i4 == 40)) {
                            k85.g(ib5Var2);
                            ib5Var2.r1(new t95(-10), false);
                        }
                        t95Var = null;
                        if (t95Var == null) {
                        }
                        k85.g(ib5Var2);
                        k85Var3 = (k85) ib5Var2.f;
                        ib5Var2.Z0(t95Var2);
                        l75Var.V0();
                        int i52 = o25.b(l75Var.Z0().getString("dma_consent_settings", null)).a;
                        o95VarK1 = x15Var.k1("google_analytics_default_allow_ad_personalization_signals", true);
                        if (o95VarK1 != o95Var) {
                        }
                        o95VarK12 = x15Var.k1("google_analytics_default_allow_ad_user_data", true);
                        if (o95VarK12 == o95Var) {
                            if (TextUtils.isEmpty(k85Var2.l().c1())) {
                                if (TextUtils.isEmpty(k85Var2.l().c1())) {
                                    o25 o25VarC2 = o25.c(30, bundle);
                                    it = o25VarC2.e.values().iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                        }
                                    }
                                }
                            }
                        }
                        boolH1 = x15Var.h1("google_analytics_tcf_data_enabled");
                        if (boolH1 != null) {
                            k85.h(t65Var3);
                            q65Var3.a("TCF client enabled.");
                            k85.g(ib5Var2);
                            ib5Var2.V0();
                            t65 t65Var92 = k85Var3.Y;
                            k85.h(t65Var92);
                            t65Var92.G0.a("Register tcfPrefChangeListener.");
                            if (ib5Var2.O0 == null) {
                            }
                            l75 l75Var22 = k85Var3.X;
                            k85.f(l75Var22);
                            l75Var22.a1().registerOnSharedPreferenceChangeListener(ib5Var2.O0);
                            k85.g(ib5Var2);
                            ib5Var2.b1();
                        }
                        uVar = l75Var.z0;
                        if (uVar.a() == 0) {
                        }
                        k85.g(ib5Var2);
                        o75Var = ib5Var2.L0;
                        if (o75Var.d()) {
                            l75 l75Var32 = o75Var.a.X;
                            k85.f(l75Var32);
                            l75Var32.Q0.C(null);
                        }
                        if (!k85Var2.c()) {
                        }
                        mg5.a();
                        if (x15Var.f1(null, r55.R0)) {
                        }
                        l75Var.I0.b(true);
                        return;
                    }
                    t65 t65Var10 = k85Var8.Y;
                    k85.h(t65Var10);
                    t65Var10.z0.a("Failed to load metadata: Metadata bundle is null");
                    numValueOf = null;
                    if (numValueOf == null) {
                    }
                    if (listAsList == null) {
                    }
                    if (packageManager == null) {
                    }
                    ((k85) d65Var2.f).T0.incrementAndGet();
                    d65Var2.X = true;
                    nb5Var = new nb5(k85Var5);
                    k85 k85Var92 = (k85) nb5Var.f;
                    k85Var92.R0++;
                    nb5Var.X0();
                    k85Var5.L0 = nb5Var;
                    if (!nb5Var.X) {
                    }
                    break;
                    break;
                case 18:
                    ((ib5) this.z).m1((Boolean) this.f, true);
                    return;
                case 19:
                    ib5 ib5Var3 = ((AppMeasurementDynamiteService) this.z).c.D0;
                    k85.g(ib5Var3);
                    ca5 ca5Var2 = (ca5) this.f;
                    ib5Var3.V0();
                    ib5Var3.W0();
                    ca5 ca5Var3 = ib5Var3.Z;
                    if (ca5Var2 != ca5Var3) {
                        tj4.k("EventInterceptor already set.", ca5Var3 == null);
                    }
                    ib5Var3.Z = ca5Var2;
                    return;
                case 20:
                    b();
                    return;
                case 21:
                    dd5 dd5Var2 = ((yc5) this.z).z;
                    dd5Var2.Z = null;
                    if (((ab0) this.f).f != 7777) {
                        dd5Var2.k1();
                        return;
                    }
                    ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = dd5Var2.A0;
                    if (scheduledExecutorServiceNewScheduledThreadPool == null) {
                        scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
                        dd5Var2.A0 = scheduledExecutorServiceNewScheduledThreadPool;
                    }
                    scheduledExecutorServiceNewScheduledThreadPool.schedule(new qz4(5, this), ((Long) r55.a0.a(null)).longValue(), TimeUnit.MILLISECONDS);
                    return;
                default:
                    rz4 rz4Var = (rz4) this.f;
                    JobParameters jobParameters = (JobParameters) this.z;
                    Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
                    ((hd5) ((Service) rz4Var.f)).c(jobParameters);
                    return;
            }
        } finally {
            ((r20) this.z).Z = null;
        }
        ((r20) this.z).Z = null;
    }

    public String toString() {
        int i = this.b;
        Object obj = this.z;
        switch (i) {
            case 0:
                n02 n02Var = new n02(tm1.class.getSimpleName());
                v62 v62Var = new v62(5, false);
                ((v62) n02Var.A).z = v62Var;
                n02Var.A = v62Var;
                v62Var.f = (ca5) obj;
                return n02Var.toString();
            case 11:
                Runnable runnable = (Runnable) this.f;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                StringBuilder sb = new StringBuilder("SequentialExecutorWorker{state=");
                int i2 = ((zs3) obj).z;
                sb.append(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "null" : "RUNNING" : "QUEUED" : "QUEUING" : "IDLE");
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ tm1(int i, Object obj, Object obj2, boolean z) {
        this.b = i;
        this.z = obj;
        this.f = obj2;
    }

    public tm1(zs3 zs3Var) {
        this.b = 11;
        this.z = zs3Var;
    }
}
