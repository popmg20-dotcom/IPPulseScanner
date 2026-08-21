package defpackage;

import android.app.Activity;
import android.app.Application;
import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.widget.ProgressBar;
import androidx.fragment.app.g;
import androidx.fragment.app.u;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d4 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ d4(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0335  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Object obj;
        int i;
        long j;
        float f;
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        int i2 = this.b;
        int i3 = 2;
        Object obj2 = this.f;
        switch (i2) {
            case 0:
                Activity activity = (Activity) obj2;
                if (activity.isFinishing()) {
                    return;
                }
                Handler handler = j4.g;
                Method method = j4.f;
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 28) {
                    activity.recreate();
                    return;
                }
                if (((i4 != 26 && i4 != 27) || method != null) && (j4.e != null || j4.d != null)) {
                    try {
                        Object obj3 = j4.c.get(activity);
                        if (obj3 != null && (obj = j4.b.get(activity)) != null) {
                            Application application = activity.getApplication();
                            i4 i4Var = new i4(activity);
                            application.registerActivityLifecycleCallbacks(i4Var);
                            handler.post(new um1(1, i4Var, obj3));
                            try {
                                if (i4 == 26 || i4 == 27) {
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj, obj3, null, null, 0, bool, null, null, bool, bool);
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new tm1(i3, application, i4Var));
                                return;
                            } catch (Throwable th) {
                                handler.post(new tm1(i3, application, i4Var));
                                throw th;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 1:
                s8 s8Var = (s8) ((s8) obj2).c.f;
                long jUptimeMillis = SystemClock.uptimeMillis();
                ArrayList arrayList = s8Var.b;
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                int i5 = 0;
                while (i5 < arrayList.size()) {
                    w04 w04Var = (w04) arrayList.get(i5);
                    if (w04Var == null) {
                        j2 = jUptimeMillis;
                        j3 = jUptimeMillis2;
                    } else {
                        xw3 xw3Var = s8Var.a;
                        Long l = (Long) xw3Var.get(w04Var);
                        if (l != null) {
                            if (l.longValue() < jUptimeMillis2) {
                                xw3Var.remove(w04Var);
                                j = w04Var.i;
                                if (j != 0) {
                                    w04Var.i = jUptimeMillis;
                                    w04Var.c(w04Var.b);
                                } else {
                                    long j6 = jUptimeMillis - j;
                                    w04Var.i = jUptimeMillis;
                                    float f2 = s8.b().g;
                                    long j7 = f2 == 0.0f ? 2147483647L : (long) (j6 / f2);
                                    boolean z2 = w04Var.o;
                                    float f3 = w04Var.n;
                                    if (z2) {
                                        if (f3 != Float.MAX_VALUE) {
                                            w04Var.m.i = f3;
                                            w04Var.n = Float.MAX_VALUE;
                                        }
                                        w04Var.b = (float) w04Var.m.i;
                                        w04Var.a = 0.0f;
                                        w04Var.o = z;
                                    } else {
                                        x04 x04Var = w04Var.m;
                                        float f4 = w04Var.b;
                                        float f5 = w04Var.a;
                                        if (f3 != Float.MAX_VALUE) {
                                            long j8 = j7 / 2;
                                            d8 d8VarC = x04Var.c(f4, f5, j8);
                                            x04 x04Var2 = w04Var.m;
                                            x04Var2.i = w04Var.n;
                                            w04Var.n = Float.MAX_VALUE;
                                            d8 d8VarC2 = x04Var2.c(d8VarC.a, d8VarC.b, j8);
                                            f = d8VarC2.a;
                                            w04Var.b = f;
                                            w04Var.a = d8VarC2.b;
                                        } else {
                                            d8 d8VarC3 = x04Var.c(f4, f5, j7);
                                            f = d8VarC3.a;
                                            w04Var.b = f;
                                            w04Var.a = d8VarC3.b;
                                        }
                                        float fMax = Math.max(f, w04Var.h);
                                        w04Var.b = fMax;
                                        w04Var.b = Math.min(fMax, w04Var.g);
                                        float f6 = w04Var.a;
                                        x04 x04Var3 = w04Var.m;
                                        x04Var3.getClass();
                                        if (Math.abs(f6) >= x04Var3.e || Math.abs(r7 - ((float) x04Var3.i)) >= x04Var3.d) {
                                            z = false;
                                            float fMin = Math.min(w04Var.b, w04Var.g);
                                            w04Var.b = fMin;
                                            float fMax2 = Math.max(fMin, w04Var.h);
                                            w04Var.b = fMax2;
                                            w04Var.c(fMax2);
                                            if (!z) {
                                                ArrayList arrayList2 = w04Var.k;
                                                w04Var.f = false;
                                                s8 s8VarB = s8.b();
                                                s8VarB.a.remove(w04Var);
                                                ArrayList arrayList3 = s8VarB.b;
                                                int iIndexOf = arrayList3.indexOf(w04Var);
                                                if (iIndexOf >= 0) {
                                                    arrayList3.set(iIndexOf, null);
                                                    s8VarB.f = true;
                                                }
                                                w04Var.i = 0L;
                                                w04Var.c = false;
                                                int i6 = 0;
                                                while (i6 < arrayList2.size()) {
                                                    if (arrayList2.get(i6) != null) {
                                                        al alVar = (al) arrayList2.get(i6);
                                                        float f7 = w04Var.b;
                                                        switch (alVar.a) {
                                                            case 0:
                                                                j4 = jUptimeMillis;
                                                                j5 = jUptimeMillis2;
                                                                dl dlVar = (dl) alVar.b;
                                                                if (dlVar.getProgressDrawable() != null && dlVar.getProgressDrawable().getLevel() == 10000) {
                                                                    dlVar.b();
                                                                }
                                                                break;
                                                            default:
                                                                sg4 sg4Var = (sg4) alVar.b;
                                                                e04 e04Var = e04.z;
                                                                ch4 ch4Var = sg4Var.g;
                                                                if (f7 < 1.0f) {
                                                                    j4 = jUptimeMillis;
                                                                    long j9 = ch4Var.Q0;
                                                                    vg4 vg4VarV = ch4Var.V(0);
                                                                    vg4 vg4Var = vg4VarV.L0;
                                                                    vg4VarV.L0 = null;
                                                                    j5 = jUptimeMillis2;
                                                                    ch4Var.K(-1L, sg4Var.a);
                                                                    ch4Var.K(j9, -1L);
                                                                    sg4Var.a = j9;
                                                                    s7 s7Var = sg4Var.f;
                                                                    if (s7Var != null) {
                                                                        s7Var.run();
                                                                    }
                                                                    ch4Var.N0.clear();
                                                                    if (vg4Var != null) {
                                                                        vg4Var.B(vg4Var, e04Var, true);
                                                                    }
                                                                } else {
                                                                    j4 = jUptimeMillis;
                                                                    j5 = jUptimeMillis2;
                                                                    ch4Var.B(ch4Var, e04Var, false);
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        j4 = jUptimeMillis;
                                                        j5 = jUptimeMillis2;
                                                    }
                                                    i6++;
                                                    jUptimeMillis = j4;
                                                    jUptimeMillis2 = j5;
                                                }
                                                j2 = jUptimeMillis;
                                                j3 = jUptimeMillis2;
                                                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                                                    if (arrayList2.get(size) == null) {
                                                        arrayList2.remove(size);
                                                    }
                                                }
                                            }
                                        } else {
                                            w04Var.b = (float) w04Var.m.i;
                                            w04Var.a = 0.0f;
                                        }
                                    }
                                    z = true;
                                    float fMin2 = Math.min(w04Var.b, w04Var.g);
                                    w04Var.b = fMin2;
                                    float fMax22 = Math.max(fMin2, w04Var.h);
                                    w04Var.b = fMax22;
                                    w04Var.c(fMax22);
                                    if (!z) {
                                    }
                                }
                            }
                            j2 = jUptimeMillis;
                            j3 = jUptimeMillis2;
                        } else {
                            j = w04Var.i;
                            if (j != 0) {
                            }
                            j2 = jUptimeMillis;
                            j3 = jUptimeMillis2;
                        }
                    }
                    i5++;
                    jUptimeMillis = j2;
                    jUptimeMillis2 = j3;
                    z = false;
                }
                if (s8Var.f) {
                    for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                        if (arrayList.get(size2) == null) {
                            arrayList.remove(size2);
                        }
                    }
                    if (arrayList.size() == 0 && Build.VERSION.SDK_INT >= 33) {
                        s8Var.h.a();
                    }
                    i = 0;
                    s8Var.f = false;
                } else {
                    i = 0;
                }
                if (arrayList.size() > 0) {
                    ((Choreographer) s8Var.e.f).postFrameCallback(new r8(i, s8Var.d));
                    return;
                }
                return;
            case 2:
                ew ewVar = (ew) obj2;
                vv vvVar = (vv) ewVar.g;
                if (vvVar != null) {
                    vvVar.b(null);
                    ewVar.g = null;
                    return;
                }
                return;
            case 3:
                ((CameraDevice) obj2).close();
                return;
            case 4:
                cx cxVar = (cx) obj2;
                if (cxVar.f) {
                    return;
                }
                r25.j(null, ((dx) cxVar.A).f.c1 == 8 || ((dx) cxVar.A).f.c1 == 7);
                boolean zC = ((dx) cxVar.A).c();
                ex exVar = ((dx) cxVar.A).f;
                if (zC) {
                    exVar.K(true);
                    return;
                } else {
                    exVar.L(true);
                    return;
                }
            case 5:
                Process.setThreadPriority(-3);
                ((Runnable) obj2).run();
                return;
            case 6:
                v9.o(((oz) obj2).b);
                return;
            case 7:
                zw zwVar = (zw) obj2;
                if (zwVar.c.c1 == 4 || zwVar.c.c1 == 5) {
                    zwVar.c.L(false);
                    return;
                }
                return;
            case 8:
                zf2 zf2Var = (zf2) obj2;
                if (((ex) zf2Var.f).c1 == 10) {
                    ((ex) zf2Var.f).E();
                    return;
                }
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                o10 o10Var = (o10) obj2;
                synchronized (o10Var.a) {
                    if (o10Var.b.isEmpty()) {
                        return;
                    }
                    try {
                        o10Var.k(o10Var.b);
                        return;
                    } finally {
                        o10Var.b.clear();
                    }
                }
            case 10:
                for (m84 m84Var : (LinkedHashSet) obj2) {
                    m84Var.getClass();
                    m84Var.c(m84Var);
                }
                return;
            case 11:
                ((CarouselLayoutManager) obj2).u0();
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                ((v50) obj2).s(true);
                return;
            case 13:
                ((nf2) obj2).c();
                return;
            case 14:
                f90 f90Var = (f90) obj2;
                Runnable runnable = f90Var.f;
                if (runnable != null) {
                    runnable.run();
                    f90Var.f = null;
                    return;
                }
                return;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                l90.c((l90) obj2);
                return;
            case 16:
                pl1 pl1Var = (pl1) ((bh3) obj2).b;
                if (pl1Var != null) {
                    pl1Var.a();
                    return;
                }
                return;
            case 17:
                ok1.a((ArrayList) obj2, 4);
                return;
            case 18:
                g gVar = (g) obj2;
                if (u.M(2)) {
                    Log.v("FragmentManager", "Transition for all operations has completed");
                }
                Iterator it = gVar.c.iterator();
                while (it.hasNext()) {
                    ((tm0) it.next()).a.c(gVar);
                }
                return;
            case 19:
                ((d74) obj2).close();
                return;
            case 20:
                xm0 xm0Var = (xm0) obj2;
                xm0Var.j = true;
                xm0Var.a();
                return;
            case 21:
                ((yv) obj2).cancel(true);
                return;
            case 22:
                uy0 uy0Var = (uy0) obj2;
                boolean zIsPopupShowing = uy0Var.h.isPopupShowing();
                uy0Var.s(zIsPopupShowing);
                uy0Var.m = zIsPopupShowing;
                return;
            case 23:
                yy0 yy0Var = (yy0) obj2;
                yy0Var.f = true;
                yy0Var.a();
                return;
            case 24:
                zy0 zy0Var = (zy0) ((v92) obj2).A;
                if (zy0Var != null) {
                    Iterator it2 = zy0Var.values().iterator();
                    while (it2.hasNext()) {
                        ((c74) it2.next()).b();
                    }
                    return;
                }
                return;
            case 25:
                t01 t01Var = ((s01) obj2).Z;
                t01Var.U0 = false;
                ((ProgressBar) t01Var.O0.z).setVisibility(8);
                return;
            case 26:
                a11 a11Var = (a11) obj2;
                CodeEditor codeEditor = a11Var.f;
                q30 q30Var = a11Var.J0;
                if (!a11Var.b.isShowing()) {
                    if (q30Var != null) {
                        codeEditor.getDiagnostics();
                        a11Var.g();
                        return;
                    }
                    return;
                }
                if (a11Var.H0.a || q30Var == null) {
                    return;
                }
                codeEditor.getDiagnostics();
                a11Var.g();
                return;
            case 27:
                ((CodeEditor) obj2).d0();
                return;
            case 28:
                ed4 ed4Var = (ed4) obj2;
                ha1 ha1Var = (ha1) ed4Var.A;
                CodeEditor codeEditor2 = (CodeEditor) ((WeakReference) ed4Var.f).get();
                if (ha1Var == null || codeEditor2 == null || codeEditor2.getCursor().a() || !codeEditor2.x1) {
                    return;
                }
                ld0 text = codeEditor2.getText();
                int i7 = codeEditor2.getCursor().c.a;
                hm2 hm2VarD = i7 > 0 ? ha1Var.D(text, i7 - 1) : null;
                if (hm2VarD == null && i7 < text.A) {
                    hm2VarD = ha1Var.D(text, i7);
                }
                ed4Var.z = hm2VarD;
                codeEditor2.invalidate();
                return;
            default:
                ((a21) obj2).f();
                return;
        }
    }
}
