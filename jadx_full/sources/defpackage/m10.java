package defpackage;

import android.app.Activity;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Size;
import android.view.Surface;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import io.sentry.a7;
import io.sentry.android.core.ActivityLifecycleIntegration;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.b;
import io.sentry.android.core.c;
import io.sentry.android.core.d;
import io.sentry.android.core.e;
import io.sentry.android.core.internal.gestures.g;
import io.sentry.c7;
import io.sentry.d1;
import io.sentry.d4;
import io.sentry.e4;
import io.sentry.f5;
import io.sentry.hints.a;
import io.sentry.l0;
import io.sentry.p1;
import io.sentry.p5;
import io.sentry.protocol.n;
import io.sentry.protocol.r;
import io.sentry.protocol.w;
import io.sentry.x6;
import io.sentry.y6;
import io.sentry.z6;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m10 implements gf, wv, f23, i74, kd0, d4, c7, e4 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ m10(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
    }

    @Override // defpackage.f23
    public boolean a(sk2 sk2Var) {
        int i = this.b;
        Object obj = this.A;
        Object obj2 = this.z;
        Object obj3 = this.f;
        switch (i) {
            case 2:
                ha1 ha1Var = ((ca1) obj3).e;
                aa1 aa1Var = (aa1) obj2;
                e22 e22Var = (e22) obj;
                int i2 = sk2Var.a;
                if (i2 == R.id.update) {
                    ha1Var.C(aa1Var, false);
                    return true;
                }
                if (i2 == R.id.view) {
                    ConstraintLayout constraintLayout = e22Var.a;
                    constraintLayout.getClass();
                    ca1.t(constraintLayout, aa1Var);
                    return true;
                }
                if (i2 == R.id.delete) {
                    ha1Var.getClass();
                    String str = aa1Var.a;
                    ca1 ca1Var = ((ma1) ha1Var.f).z;
                    of ofVar = ca1Var.d;
                    sf3 sf3Var = ca1Var.a;
                    int iIndexOf = ofVar.f.indexOf(aa1Var);
                    ea1 ea1Var = aa1Var.e;
                    if (ea1Var instanceof ix3) {
                        boolean z = nj3.a;
                        ((fv0) nj3.e.g).s(((ix3) ea1Var).a);
                        str.getClass();
                        new File(new File(ContextUtilsKt.getContext().getFilesDir(), "rule_set"), ha0.x(r25.K(str), ".conf")).delete();
                        if (iIndexOf == -1) {
                            return true;
                        }
                        sf3Var.f(iIndexOf, 1);
                        return true;
                    }
                    if (ea1Var instanceof gx3) {
                        boolean z2 = nj3.a;
                        ((fv0) nj3.e.g).s(((gx3) ea1Var).a);
                        str.getClass();
                        new File(new File(ContextUtilsKt.getContext().getFilesDir(), "policy_path"), ha0.x(r25.K(str), ".conf")).delete();
                        if (iIndexOf == -1) {
                            return true;
                        }
                        sf3Var.f(iIndexOf, 1);
                        return true;
                    }
                    if (ea1Var instanceof bx3) {
                        boolean z3 = nj3.a;
                        ((fv0) nj3.e.g).s(((bx3) ea1Var).a);
                        str.getClass();
                        new File(new File(ContextUtilsKt.getContext().getFilesDir(), "domain_set"), ha0.x(r25.K(str), ".conf")).delete();
                        if (iIndexOf == -1) {
                            return true;
                        }
                        sf3Var.f(iIndexOf, 1);
                        return true;
                    }
                    g.d();
                }
                return false;
            default:
                bt1 bt1Var = (bt1) obj3;
                ls1 ls1Var = (ls1) obj2;
                at1 at1Var = (at1) obj;
                int i3 = sk2Var.a;
                if (i3 == R.id.delete) {
                    bt1Var.g.g(ls1Var);
                } else if (i3 == R.id.edit) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) at1Var.u.b;
                    constraintLayout2.getClass();
                    bt1Var.f.k(constraintLayout2, ls1Var);
                }
                return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0142 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:4:0x0019, B:12:0x002b, B:13:0x003f, B:17:0x0044, B:18:0x004b, B:20:0x0051, B:21:0x0067, B:22:0x00c9, B:24:0x00cf, B:25:0x00e0, B:27:0x00f0, B:29:0x00f4, B:30:0x0100, B:31:0x0118, B:33:0x011e, B:35:0x012c, B:37:0x0134, B:41:0x0142, B:43:0x0154, B:46:0x016c, B:47:0x0178, B:49:0x019b, B:51:0x019f, B:53:0x01a9, B:54:0x01ca, B:56:0x01d0, B:57:0x01e0, B:59:0x01f6, B:60:0x01fb, B:61:0x0203, B:64:0x0206, B:65:0x020c, B:67:0x020e, B:68:0x0223), top: B:72:0x0019, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0169  */
    @Override // defpackage.gf
    /* JADX INFO: renamed from: apply */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public nc2 mo23apply(Object obj) {
        InputConfiguration inputConfiguration;
        boolean z;
        ax2 ax2VarG;
        String str;
        int i;
        o10 o10Var = (o10) this.f;
        tt3 tt3Var = (tt3) this.z;
        CameraDevice cameraDevice = (CameraDevice) this.A;
        List list = (List) obj;
        synchronized (o10Var.a) {
            try {
                int iG = fw.G(o10Var.j);
                if (iG == 0 || iG == 7 || iG == 2) {
                    return new zy1(1, new IllegalStateException("openCaptureSession() should not be possible in state: ".concat(fw.J(o10Var.j))));
                }
                if (iG != 3) {
                    return new zy1(1, new CancellationException("openCaptureSession() not execute in state: ".concat(fw.J(o10Var.j))));
                }
                o10Var.g.clear();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    o10Var.g.put((dn0) o10Var.h.get(i2), (Surface) list.get(i2));
                }
                o10Var.q(7);
                ez4.o("CaptureSession", "Opening capture session.");
                n10 n10Var = new n10(2, Arrays.asList(o10Var.c, new n10(1, tt3Var.d)));
                f10 f10Var = tt3Var.g;
                rx rxVar = new rx(14, f10Var.b);
                HashSet hashSet = new HashSet();
                qn2.c();
                ArrayList arrayList = new ArrayList();
                vn2.a();
                hashSet.addAll(f10Var.a);
                qn2 qn2VarD = qn2.d(f10Var.b);
                int i3 = f10Var.c;
                arrayList.addAll(f10Var.d);
                boolean z2 = f10Var.e;
                pa4 pa4Var = f10Var.f;
                ArrayMap arrayMap = new ArrayMap();
                for (String str2 : pa4Var.a.keySet()) {
                    arrayMap.put(str2, pa4Var.a.get(str2));
                }
                vn2 vn2Var = new vn2(arrayMap);
                HashMap map = new HashMap();
                if (o10Var.s && Build.VERSION.SDK_INT >= 35) {
                    map = o10.d(o10.i(tt3Var.a), o10Var.g);
                }
                ArrayList arrayList2 = new ArrayList();
                String str3 = (String) ((ka0) rxVar.f).p(rx.z0, null);
                for (fh fhVar : tt3Var.a) {
                    qn2 qn2Var = qn2VarD;
                    if (o10Var.s) {
                        z = z2;
                        ax2VarG = Build.VERSION.SDK_INT >= 35 ? (ax2) map.get(fhVar) : null;
                        if (ax2VarG != null) {
                            ax2VarG = o10Var.g(fhVar, o10Var.g, str3);
                            str = str3;
                            if (o10Var.m.containsKey(fhVar.a)) {
                                i = i3;
                                ax2VarG.a.j(((Long) o10Var.m.get(fhVar.a)).longValue());
                            }
                            arrayList2.add(ax2VarG);
                            i3 = i;
                            qn2VarD = qn2Var;
                            z2 = z;
                            str3 = str;
                        } else {
                            str = str3;
                        }
                        i = i3;
                        arrayList2.add(ax2VarG);
                        i3 = i;
                        qn2VarD = qn2Var;
                        z2 = z;
                        str3 = str;
                    } else {
                        z = z2;
                    }
                    if (ax2VarG != null) {
                    }
                    i = i3;
                    arrayList2.add(ax2VarG);
                    i3 = i;
                    qn2VarD = qn2Var;
                    z2 = z;
                    str3 = str;
                }
                qn2 qn2Var2 = qn2VarD;
                boolean z3 = z2;
                int i4 = i3;
                ArrayList arrayListH = o10.h(arrayList2);
                m84 m84Var = o10Var.d;
                int i5 = tt3Var.h;
                m84Var.f = n10Var;
                xt3 xt3Var = new xt3(i5, arrayListH, m84Var.d, new py(1, m84Var));
                if (tt3Var.g.c == 5 && (inputConfiguration = tt3Var.i) != null) {
                    xt3Var.a.i(j02.a(inputConfiguration));
                }
                try {
                    ArrayList arrayList3 = new ArrayList(hashSet);
                    sw2 sw2VarA = sw2.a(qn2Var2);
                    ArrayList arrayList4 = new ArrayList(arrayList);
                    pa4 pa4Var2 = pa4.b;
                    ArrayMap arrayMap2 = new ArrayMap();
                    for (String str4 : vn2Var.a.keySet()) {
                        arrayMap2.put(str4, vn2Var.a.get(str4));
                    }
                    CaptureRequest captureRequestO = gb4.o(new f10(arrayList3, sw2VarA, i4, arrayList4, z3, new pa4(arrayMap2), null), cameraDevice, o10Var.r);
                    if (captureRequestO != null) {
                        xt3Var.a.h(captureRequestO);
                    }
                    return o10Var.d.o(cameraDevice, xt3Var, o10Var.h);
                } catch (CameraAccessException e) {
                    return new zy1(1, e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.sentry.d4
    public void b(z6 z6Var) {
        ConcurrentHashMap concurrentHashMap;
        x8 x8Var = (x8) this.f;
        f5 f5Var = (f5) this.z;
        l0 l0Var = (l0) this.A;
        if (z6Var == null) {
            ((SentryAndroidOptions) x8Var.b).getLogger().h(p5.INFO, "Session is null on scope.withSession", new Object[0]);
            return;
        }
        String strE = null;
        y6 y6Var = f5Var.f() != null ? y6.Crashed : null;
        boolean z = y6.Crashed == y6Var || f5Var.g();
        r rVar = f5Var.A;
        String str = (rVar == null || (concurrentHashMap = rVar.Y) == null || !concurrentHashMap.containsKey("user-agent")) ? null : (String) f5Var.A.Y.get("user-agent");
        Object objB = l0Var.b("sentry:typeCheckHint");
        if (objB instanceof a) {
            strE = ((a) objB).e();
            y6Var = y6.Abnormal;
        }
        if (!z6Var.c(y6Var, str, z, strE) || z6Var.Z == y6.Ok) {
            return;
        }
        z6Var.b(new Date());
    }

    @Override // defpackage.kd0
    public void c(int i, ud0 ud0Var, bv0 bv0Var) {
        jr2 jr2Var = (jr2) this.f;
        c03 c03Var = (c03) this.z;
        ln2 ln2Var = (ln2) this.A;
        char[] cArr = ud0Var.b;
        int iCeil = (int) Math.ceil(jr2Var.b(new o30(cArr, cArr.length), 0, ud0Var.f, c03Var));
        if (iCeil > ln2Var.a) {
            ln2Var.a = iCeil;
        }
    }

    @Override // io.sentry.c7
    public void d(a7 a7Var) {
        c cVarB;
        x6 x6Var = (x6) this.f;
        c7 c7Var = (c7) this.z;
        AtomicReference atomicReference = (AtomicReference) this.A;
        if (c7Var != null) {
            c7Var.d(a7Var);
        }
        e eVar = x6Var.r.i;
        if (eVar != null) {
            ActivityLifecycleIntegration activityLifecycleIntegration = (ActivityLifecycleIntegration) eVar.b;
            WeakReference weakReference = (WeakReference) eVar.f;
            String str = (String) eVar.z;
            Activity activity = (Activity) weakReference.get();
            int i = 1;
            if (activity != null) {
                d dVar = activityLifecycleIntegration.I0;
                w wVarN = x6Var.n();
                io.sentry.util.a aVar = (io.sentry.util.a) dVar.g;
                aVar.g();
                try {
                    if (dVar.e()) {
                        b bVar = new b(dVar, activity, i);
                        c cVar = null;
                        dVar.g(bVar, null);
                        c cVar2 = (c) ((WeakHashMap) dVar.e).remove(activity);
                        if (cVar2 != null && (cVarB = dVar.b()) != null) {
                            cVar = new c(cVarB.a - cVar2.a, cVarB.b - cVar2.b, cVarB.c - cVar2.c);
                        }
                        if (cVar != null) {
                            int i2 = cVar.c;
                            int i3 = cVar.b;
                            int i4 = cVar.a;
                            if (i4 != 0 || i3 != 0 || i2 != 0) {
                                n nVar = new n(Integer.valueOf(i4), "none");
                                n nVar2 = new n(Integer.valueOf(i3), "none");
                                n nVar3 = new n(Integer.valueOf(i2), "none");
                                HashMap map = new HashMap();
                                map.put("frames_total", nVar);
                                map.put("frames_slow", nVar2);
                                map.put("frames_frozen", nVar3);
                                ((ConcurrentHashMap) dVar.d).put(wVarN, map);
                            }
                        }
                    }
                    aVar.close();
                } catch (Throwable th) {
                    try {
                        aVar.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                SentryAndroidOptions sentryAndroidOptions = activityLifecycleIntegration.A;
                if (sentryAndroidOptions != null) {
                    sentryAndroidOptions.getLogger().h(p5.WARNING, "Unable to track activity frames as the Activity %s has been destroyed.", str);
                }
            }
        }
        io.sentry.n nVar4 = x6Var.q;
        if (nVar4 != null) {
            atomicReference.set(nVar4.f(x6Var));
        }
    }

    public void e() {
        oj1 oj1Var = (oj1) this.f;
        n43 n43Var = (n43) this.z;
        mz mzVar = (mz) this.A;
        AtomicReference atomicReference = ((PreviewView) oj1Var.f).A0;
        while (true) {
            if (atomicReference.compareAndSet(n43Var, null)) {
                n43Var.b(s43.b);
                break;
            } else if (atomicReference.get() != n43Var) {
                break;
            }
        }
        pm1 pm1Var = n43Var.e;
        if (pm1Var != null) {
            pm1Var.cancel(false);
            n43Var.e = null;
        }
        mzVar.a().f(n43Var);
    }

    @Override // defpackage.i74
    public void f(oh ohVar) {
        t43 t43Var;
        oj1 oj1Var = (oj1) this.f;
        mz mzVar = (mz) this.z;
        j74 j74Var = (j74) this.A;
        PreviewView previewView = (PreviewView) oj1Var.f;
        ez4.o("PreviewView", "Preview transformation info updated. " + ohVar);
        boolean z = mzVar.r().i() == 0;
        o43 o43Var = previewView.A;
        Size size = j74Var.b;
        o43Var.getClass();
        ez4.o("PreviewTransform", "Transformation info set: " + ohVar + " " + size + " " + z);
        o43Var.b = ohVar.a;
        o43Var.c = ohVar.b;
        int i = ohVar.c;
        o43Var.e = i;
        o43Var.a = size;
        o43Var.f = z;
        o43Var.g = ohVar.d;
        o43Var.d = ohVar.e;
        if (i == -1 || ((t43Var = previewView.f) != null && (t43Var instanceof o74))) {
            previewView.y0 = true;
        } else {
            previewView.y0 = false;
        }
        previewView.a();
    }

    @Override // io.sentry.e4
    public void h(p1 p1Var) {
        g gVar = (g) this.f;
        d1 d1Var = (d1) this.z;
        p1 p1Var2 = (p1) this.A;
        if (p1Var == null) {
            d1Var.F(p1Var2);
        } else {
            gVar.c.getLogger().h(p5.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", p1Var2.getName());
        }
    }

    @Override // defpackage.wv
    public Object n(vv vvVar) {
        int i = this.b;
        Object obj = this.A;
        Object obj2 = this.z;
        Object obj3 = this.f;
        switch (i) {
            case 1:
                yv yvVar = (yv) obj3;
                at3 at3Var = (at3) obj2;
                vvVar.a(new d4(21, yvVar), at3Var);
                yvVar.a(new um1(0, yvVar, new en0(vvVar, 0)), at3Var);
                return "surfaceList[" + ((Collection) obj) + "]";
            default:
                cf0 cf0Var = (cf0) obj3;
                vvVar.a(new ga1(10, (v32) cf0Var.Z(pr1.X)), xu0.b);
                return ji0.B(p95.a(cf0Var), null, (of0) obj2, new uf((Function2) obj, vvVar, null, 11), 1);
        }
    }
}
