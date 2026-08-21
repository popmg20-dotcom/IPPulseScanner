package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Network;
import android.os.Build;
import android.os.Trace;
import android.view.MotionEvent;
import android.view.Surface;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import com.getsurfboard.R;
import com.getsurfboard.ui.SurfboardApp;
import com.getsurfboard.ui.fragment.settings.AppSettingsFragment;
import com.getsurfboard.ui.fragment.settings.OthersSettingsFragment;
import com.getsurfboard.ui.fragment.settings.OverrideSettingsFragment;
import com.google.firebase.FirebaseCommonRegistrar;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.sentry.android.core.ActivityLifecycleIntegration;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.a2;
import io.sentry.android.core.e;
import io.sentry.android.core.internal.gestures.g;
import io.sentry.android.core.u1;
import io.sentry.android.core.z;
import io.sentry.c;
import io.sentry.c4;
import io.sentry.d1;
import io.sentry.e4;
import io.sentry.h4;
import io.sentry.p1;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.w;
import io.sentry.x3;
import io.sentry.x6;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.conscrypt.BuildConfig;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ed implements w23, gf, n90, i74, nw0, i61, wv, ny1, v23, h73, zm2, jd0, e4, h4, u1, c4 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ ed(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    @Override // io.sentry.c4
    public void a(x3 x3Var) {
        d1 d1Var = (d1) this.f;
        p6 p6Var = (p6) this.z;
        c cVar = (c) x3Var.e;
        if (cVar.f) {
            x3 x3VarS = d1Var.s();
            w wVarG = d1Var.g();
            cVar.d("sentry-trace_id", ((w) x3VarS.b).a());
            cVar.d("sentry-public_key", p6Var.retrieveParsedDsn().b);
            cVar.d("sentry-release", p6Var.getRelease());
            cVar.d("sentry-environment", p6Var.getEnvironment());
            if (!w.f.equals(wVarG)) {
                cVar.d("sentry-replay_id", wVarG.a());
            }
            cVar.d("sentry-org_id", p6Var.getEffectiveOrgId());
            cVar.d("sentry-transaction", null);
            if (cVar.f) {
                cVar.c = null;
            }
            cVar.d("sentry-sampled", null);
            cVar.f = false;
        }
    }

    @Override // defpackage.gf
    /* JADX INFO: renamed from: apply */
    public nc2 mo23apply(Object obj) {
        int i = this.b;
        Object obj2 = this.z;
        Object obj3 = this.f;
        switch (i) {
            case 1:
                o10 o10Var = (o10) obj3;
                o10Var.b();
                ((az1) obj2).a();
                return o10Var.o();
            default:
                ArrayList arrayList = (ArrayList) obj2;
                List list = (List) obj;
                ez4.o("SyncCaptureSessionBase", "[" + ((m84) obj3) + "] getSurface done with results: " + list);
                return list.isEmpty() ? new zy1(1, new IllegalArgumentException("Unable to open capture session without surfaces")) : list.contains(null) ? new zy1(1, new cn0("Surface closed", (dn0) arrayList.get(list.indexOf(null)))) : n12.F(list);
        }
    }

    @Override // defpackage.jd0
    public void b(int i, ud0 ud0Var, id0 id0Var) {
        jw4 jw4Var = (jw4) this.f;
        ((ArrayList) this.z).addAll(jw4Var.Z.e(i, ud0Var, jw4Var.Y));
        if (jw4Var.b()) {
            return;
        }
        id0Var.b = true;
    }

    @Override // io.sentry.android.core.u1
    public void c() {
        a2 a2Var = (a2) this.f;
        Activity activity = (Activity) ((WeakReference) this.z).get();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        activity.runOnUiThread(new z(5, a2Var, activity));
    }

    @Override // defpackage.h73
    public void d(String str) {
        bx0 bx0Var = (bx0) this.f;
        zk zkVar = (zk) this.z;
        str.getClass();
        if (d73.g(str).exists()) {
            p95.C(R.string.profile_name_existed, new Object[0]);
            return;
        }
        wn1 wn1Var = (wn1) bx0Var.f;
        if (wn1Var != null) {
            String name = zkVar.getName();
            name.getClass();
            d83 d83Var = (d83) wn1Var.f;
            ji0.B(uf2.t(d83Var), null, null, new uf(d83Var, str, name, (ge0) null, 21), 3);
        }
    }

    @Override // defpackage.nw0
    public List e(String str) throws UnknownHostException {
        Network network = (Network) this.f;
        ev1 ev1Var = (ev1) this.z;
        str.getClass();
        InetAddress[] allByName = network.getAllByName(ev1Var.d);
        allByName.getClass();
        return qe.s0(allByName);
    }

    @Override // defpackage.i74
    public void f(oh ohVar) {
        xm0 xm0Var = (xm0) this.f;
        dn1 dn1Var = (((j74) this.z).c.a() && ohVar.d) ? dn1.z : dn1.f;
        bw2 bw2Var = xm0Var.a;
        gn1.d(bw2Var.a, true);
        gn1.c(bw2Var.c);
        if (bw2Var.l != dn1Var) {
            bw2Var.l = dn1Var;
            bw2Var.k(bw2Var.m);
        }
    }

    @Override // defpackage.n90
    public Object g(rk3 rk3Var) {
        int i = this.b;
        Object obj = this.z;
        String str = (String) this.f;
        switch (i) {
            case 3:
                x80 x80Var = (x80) obj;
                try {
                    Trace.beginSection(str);
                    return x80Var.f.g(rk3Var);
                } finally {
                    Trace.endSection();
                }
            default:
                Context context = (Context) rk3Var.get(Context.class);
                int i2 = ((a71) obj).b;
                String strValueOf = "";
                switch (i2) {
                    case 20:
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        if (applicationInfo != null) {
                            strValueOf = String.valueOf(applicationInfo.targetSdkVersion);
                        }
                        break;
                    case 21:
                        strValueOf = FirebaseCommonRegistrar.a(context);
                        break;
                    case 22:
                        if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
                            strValueOf = "tv";
                        } else if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                            strValueOf = "watch";
                        } else if (context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                            strValueOf = "auto";
                        } else if (Build.VERSION.SDK_INT >= 26 && context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                            strValueOf = "embedded";
                        }
                        break;
                    default:
                        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                        if (installerPackageName != null) {
                            strValueOf = FirebaseCommonRegistrar.b(installerPackageName);
                        }
                        break;
                }
                return new zg(str, strValueOf);
        }
    }

    @Override // io.sentry.e4
    public void h(p1 p1Var) {
        int i = this.b;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i) {
            case 22:
                d1 d1Var = (d1) obj;
                if (p1Var == ((x6) obj2)) {
                    d1Var.m();
                }
                break;
            case 23:
                d1 d1Var2 = (d1) obj;
                if (p1Var == ((p1) obj2)) {
                    d1Var2.m();
                }
                break;
            default:
                d1 d1Var3 = (d1) obj;
                if (p1Var == ((g) obj2).e) {
                    d1Var3.m();
                }
                break;
        }
    }

    @Override // defpackage.v23
    public boolean i(Preference preference, Object obj) {
        int i = this.b;
        Object obj2 = this.z;
        Object obj3 = this.f;
        switch (i) {
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return OverrideSettingsFragment.onViewCreated$lambda$2$0((Set) obj3, (OverrideSettingsFragment) obj2, preference, obj);
            default:
                return OverrideSettingsFragment.onViewCreated$lambda$3$0$1((OverrideSettingsFragment) obj3, (EditTextPreference) obj2, preference, obj);
        }
    }

    @Override // defpackage.i61
    public void j(p60 p60Var) {
        a11 a11Var = (a11) this.f;
        d4 d4Var = (d4) this.z;
        kt1 kt1Var = (kt1) p60Var;
        CodeEditor codeEditor = a11Var.f;
        if (codeEditor.O()) {
            MotionEvent motionEvent = kt1Var.d;
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 9) {
                    codeEditor.removeCallbacks(d4Var);
                    a11Var.g();
                    a11.e(a11Var, kt1Var);
                    return;
                } else {
                    if (action != 10) {
                        return;
                    }
                    a11Var.J0 = null;
                    if (a11Var.H0.a) {
                        return;
                    }
                    a11.f(a11Var, d4Var);
                    a11.e(a11Var, kt1Var);
                    return;
                }
            }
            if (a11Var.H0.a) {
                return;
            }
            if (!codeEditor.P(motionEvent.getX(), motionEvent.getY())) {
                a11Var.J0 = null;
                a11.f(a11Var, d4Var);
            } else if (Math.abs(motionEvent.getX() - ((Number) a11Var.K0.b).floatValue()) > 20.0f || Math.abs(motionEvent.getY() - ((Number) a11Var.K0.f).floatValue()) > 20.0f) {
                a11.e(a11Var, kt1Var);
                long jY = codeEditor.y(motionEvent.getX(), motionEvent.getY());
                a11Var.J0 = codeEditor.getText().n().m((int) (jY >> 32), (int) (jY & 4294967295L));
                a11.f(a11Var, d4Var);
            }
        }
    }

    @Override // defpackage.w23
    public boolean k(Preference preference) {
        int i = this.b;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                return AppSettingsFragment.onViewCreated$lambda$2$0((AppSettingsFragment) obj2, (Preference) obj, preference);
            default:
                return OthersSettingsFragment.onViewCreated$lambda$2$0((zg3) obj2, (OthersSettingsFragment) obj, preference);
        }
    }

    @Override // defpackage.zm2
    public void l(lk3 lk3Var, int i) {
        am1 am1Var = (am1) this.f;
        xg3 xg3Var = (xg3) this.z;
        if (i == 0) {
            throw null;
        }
        if (i == 1) {
            am1Var.g(Boolean.TRUE);
            xg3Var.b = true;
        }
    }

    @Override // io.sentry.h4
    public void m(d1 d1Var) {
        int i = this.b;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i) {
            case 24:
                d1Var.D(new e((ActivityLifecycleIntegration) obj2, d1Var, (p1) obj));
                break;
            default:
                d1Var.D(new m10(12, (g) obj2, d1Var, (p1) obj));
                break;
        }
    }

    @Override // defpackage.wv
    public Object n(vv vvVar) {
        int i = this.b;
        xu0 xu0Var = xu0.b;
        final int i2 = 0;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i) {
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                vvVar.a(new Runnable() { // from class: oc2
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i3 = i2;
                        AtomicBoolean atomicBoolean2 = atomicBoolean;
                        switch (i3) {
                            case 0:
                                atomicBoolean2.set(true);
                                break;
                            default:
                                atomicBoolean2.set(true);
                                break;
                        }
                    }
                }, xu0Var);
                ((Executor) obj2).execute(new b0(11, atomicBoolean, vvVar, (tw4) obj));
                return "setForegroundAsync";
            case 16:
                ((AtomicReference) obj).set(vvVar);
                return "SurfaceRequest-surface-recreation(" + ((j74) obj2).hashCode() + ")";
            case 18:
                ad4 ad4Var = (ad4) obj2;
                Surface surface = (Surface) obj;
                ez4.o("TextureViewImpl", "Surface set on Preview.");
                ad4Var.h.a(surface, yu0.a(), new e74(2, vvVar));
                return "provideSurface[request=" + ad4Var.h + " surface=" + surface + "]";
            default:
                final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                final int i3 = 1;
                vvVar.a(new Runnable() { // from class: oc2
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i32 = i3;
                        AtomicBoolean atomicBoolean22 = atomicBoolean2;
                        switch (i32) {
                            case 0:
                                atomicBoolean22.set(true);
                                break;
                            default:
                                atomicBoolean22.set(true);
                                break;
                        }
                    }
                }, xu0Var);
                ((Executor) obj2).execute(new b0(20, atomicBoolean2, vvVar, (pl1) obj));
                return xl4.a;
        }
    }

    @Override // defpackage.ny1
    public void o(oy1 oy1Var) {
        int i = this.b;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i) {
            case 10:
                ((ny1) obj).o((ha1) obj2);
                break;
            default:
                ((ny1) obj).o((e10) obj2);
                break;
        }
    }

    public void p(p6 p6Var) {
        String str = (String) this.f;
        SurfboardApp surfboardApp = (SurfboardApp) this.z;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) p6Var;
        sentryAndroidOptions.setDsn("https://70361e780fe954173e1999f039d1ab2d@o85318.ingest.sentry.io/4506053665816576");
        sentryAndroidOptions.setRelease(str);
        sentryAndroidOptions.setDiagnosticLevel(p5.WARNING);
        sentryAndroidOptions.setEnvironment(BuildConfig.BUILD_TYPE);
        sentryAndroidOptions.setEnableScopeSync(true);
        sentryAndroidOptions.setAttachThreads(true);
        sentryAndroidOptions.setAttachScreenshot(false);
        sentryAndroidOptions.setAttachViewHierarchy(false);
        sentryAndroidOptions.setTombstoneEnabled(true);
        sentryAndroidOptions.setSampleRate(Double.valueOf(0.5d));
        Double dValueOf = Double.valueOf(0.0d);
        sentryAndroidOptions.setTracesSampleRate(dValueOf);
        sentryAndroidOptions.setProfilesSampleRate(dValueOf);
        sentryAndroidOptions.addEventProcessor(new zf0(surfboardApp));
    }
}
