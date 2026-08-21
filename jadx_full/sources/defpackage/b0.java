package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.a0;
import androidx.fragment.app.c;
import androidx.fragment.app.g;
import androidx.fragment.app.o;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.work.impl.WorkDatabase;
import com.getsurfboard.ui.fragment.settings.VpnSettingsFragment;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.b7;
import io.sentry.cache.e;
import io.sentry.d7;
import io.sentry.f4;
import io.sentry.protocol.w;
import io.sentry.x3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ b0(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
    }

    private final void a() {
        boolean zBooleanValue;
        n53 n53Var = (n53) this.f;
        yv yvVar = (yv) this.z;
        yx4 yx4Var = (yx4) this.A;
        n53Var.getClass();
        try {
            zBooleanValue = ((Boolean) yvVar.f.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            zBooleanValue = true;
        }
        synchronized (n53Var.k) {
            try {
                vw4 vw4VarM = l72.m(yx4Var.a);
                String str = vw4VarM.a;
                if (n53Var.d(str) == yx4Var) {
                    n53Var.b(str);
                }
                ue2.g().a(n53.l, n53.class.getSimpleName() + " " + str + " executed; reschedule = " + zBooleanValue);
                Iterator it = n53Var.j.iterator();
                while (it.hasNext()) {
                    ((w61) it.next()).b(vw4VarM, zBooleanValue);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        e24 e24Var = (e24) this.f;
        h24 h24Var = (h24) this.z;
        n53 n53Var = (n53) e24Var.f;
        n53Var.getClass();
        vw4 vw4Var = h24Var.a;
        String str = vw4Var.a;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        gx4 gx4Var = (gx4) n53Var.e.p(new fn(18, new xn0(i, n53Var, arrayList, str)));
        int i2 = 15;
        if (gx4Var == null) {
            ue2.g().j(n53.l, "Didn't find WorkSpec for id " + vw4Var);
            ((fs1) n53Var.d.d).execute(new xy0(i2, n53Var, vw4Var));
            return;
        }
        synchronized (n53Var.k) {
            try {
                if (n53Var.f(str)) {
                    Set set = (Set) n53Var.h.get(str);
                    if (((h24) set.iterator().next()).a.b == vw4Var.b) {
                        set.add(h24Var);
                        ue2.g().a(n53.l, "Work " + vw4Var + " is already enqueued for processing");
                    } else {
                        ((fs1) n53Var.d.d).execute(new xy0(i2, n53Var, vw4Var));
                    }
                    return;
                }
                if (gx4Var.t != vw4Var.b) {
                    ((fs1) n53Var.d.d).execute(new xy0(i2, n53Var, vw4Var));
                    return;
                }
                yx4 yx4Var = new yx4(new uf4(n53Var.b, n53Var.c, n53Var.d, n53Var, n53Var.e, gx4Var, arrayList));
                ef0 ef0Var = (ef0) yx4Var.d.b;
                x32 x32VarB = je.b();
                ef0Var.getClass();
                yv yvVarR = fx3.r(tj4.W(ef0Var, x32VarB), new vx4(yx4Var, null, i));
                yvVarR.f.a(new b0(12, n53Var, yvVarR, yx4Var), (fs1) n53Var.d.d);
                n53Var.g.put(str, yx4Var);
                HashSet hashSet = new HashSet();
                hashSet.add(h24Var);
                n53Var.h.put(str, hashSet);
                ue2.g().a(n53.l, n53.class.getSimpleName() + ": processing " + vw4Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        yc2 yc2VarA;
        ti3 ti3Var;
        int i = 0;
        Object obj = null;
        switch (this.b) {
            case 0:
                Throwable th = (Throwable) this.f;
                c0 c0Var = (c0) this.z;
                List list = (List) this.A;
                if (th != null) {
                    c0Var.b.onError(th);
                    return;
                } else {
                    c0Var.b.a(list);
                    return;
                }
            case 1:
                nw nwVar = (nw) this.f;
                Executor executor = (Executor) this.z;
                yx yxVar = (yx) this.A;
                kw kwVar = nwVar.O0;
                ((HashSet) kwVar.b).add(yxVar);
                ((ArrayMap) kwVar.c).put(yxVar, executor);
                return;
            case 2:
                ((my) this.f).a.onSurfacePrepared((CameraCaptureSession) this.z, (Surface) this.A);
                return;
            case 3:
                ArrayList arrayList = (ArrayList) this.f;
                hu2 hu2Var = (hu2) this.z;
                String str = (String) this.A;
                try {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (n12.c(((kz) next).d(), str)) {
                                obj = next;
                            }
                        }
                    }
                    kz kzVar = (kz) obj;
                    if (kzVar == null || (yc2VarA = kzVar.a()) == null) {
                        return;
                    }
                    yc2VarA.j(hu2Var);
                    return;
                } catch (IllegalArgumentException unused) {
                    return;
                }
            case 4:
                WorkDatabase workDatabase = (WorkDatabase) this.f;
                String str2 = (String) this.z;
                xw4 xw4Var = (xw4) this.A;
                jx4 jx4VarX = workDatabase.x();
                jx4VarX.getClass();
                str2.getClass();
                Iterator it2 = ((List) ke0.r(jx4VarX.a, true, false, new ko0(str2, 16))).iterator();
                while (it2.hasNext()) {
                    ye.d(xw4Var, (String) it2.next());
                }
                return;
            case 5:
                ViewGroup viewGroup = (ViewGroup) this.f;
                View view = (View) this.z;
                c cVar = (c) this.A;
                viewGroup.getClass();
                viewGroup.endViewTransition(view);
                cVar.c.a.c(cVar);
                return;
            case 6:
                a0 a0Var = (a0) this.f;
                a0 a0Var2 = (a0) this.z;
                g gVar = (g) this.A;
                o oVar = a0Var.c;
                o oVar2 = a0Var2.c;
                boolean z = gVar.o;
                tk1 tk1Var = ok1.a;
                if (z) {
                    oVar2.getEnterTransitionCallback();
                    return;
                } else {
                    oVar.getEnterTransitionCallback();
                    return;
                }
            case 7:
                xm0 xm0Var = (xm0) this.f;
                Runnable runnable = (Runnable) this.z;
                Runnable runnable2 = (Runnable) this.A;
                if (xm0Var.j) {
                    runnable.run();
                    return;
                } else {
                    runnable2.run();
                    return;
                }
            case 8:
                yy0 yy0Var = (yy0) this.f;
                Runnable runnable3 = (Runnable) this.z;
                Runnable runnable4 = (Runnable) this.A;
                if (yy0Var.f) {
                    runnable3.run();
                    return;
                } else {
                    runnable4.run();
                    return;
                }
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                CodeEditor codeEditor = (CodeEditor) this.f;
                a54 a54Var = (a54) this.z;
                hm2 hm2Var = (hm2) this.A;
                if (codeEditor.g2 != a54Var) {
                    codeEditor.setStyles(a54Var);
                    return;
                }
                if (codeEditor.n1) {
                    codeEditor.F0 = codeEditor.x();
                }
                ri3 ri3Var = codeEditor.h2;
                ri3Var.getClass();
                if (Build.VERSION.SDK_INT >= 29 && (ti3Var = ri3Var.b) != null) {
                    ti3Var.c(hm2Var);
                }
                codeEditor.i2.G();
                codeEditor.invalidate();
                return;
            case 10:
                m31 m31Var = (m31) this.f;
                fx3 fx3Var = (fx3) this.z;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.A;
                try {
                    ci1 ci1VarI = vf2.i(m31Var.a);
                    if (ci1VarI == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    bi1 bi1Var = (bi1) ((j31) ci1VarI.b);
                    synchronized (bi1Var.c) {
                        bi1Var.e = threadPoolExecutor;
                        break;
                    }
                    ((j31) ci1VarI.b).a(new l31(fx3Var, threadPoolExecutor));
                    return;
                } catch (Throwable th2) {
                    fx3Var.x(th2);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 11:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f;
                vv vvVar = (vv) this.z;
                tw4 tw4Var = (tw4) this.A;
                if (atomicBoolean.get()) {
                    return;
                }
                try {
                    tw4Var.a();
                    vvVar.b(null);
                    return;
                } catch (Throwable th3) {
                    vvVar.d(th3);
                    return;
                }
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                a();
                return;
            case 13:
                sn snVar = (sn) this.f;
                lw lwVar = (lw) this.z;
                nc2 nc2Var = (nc2) this.A;
                Log.d("RequestMonitor", "RequestListener " + lwVar + " done " + snVar);
                ((List) snVar.f).remove(nc2Var);
                return;
            case 14:
                ya3 ya3Var = (ya3) this.f;
                f82 f82Var = (f82) this.z;
                pn0 pn0Var = (pn0) this.A;
                ya3Var.getClass();
                f82Var.getClass();
                pn0Var.getClass();
                pa3 pa3Var = ya3Var.z;
                if (pa3Var == null) {
                    return;
                }
                List list2 = pa3Var.d.f;
                list2.getClass();
                for (Object obj2 : list2) {
                    int i2 = i + 1;
                    if (i < 0) {
                        e70.P();
                        throw null;
                    }
                    if (n12.c((f82) obj2, f82Var)) {
                        pa3Var.e(i);
                    }
                    i = i2;
                }
                return;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                ((n02) this.f).h((c74) this.z, (Map.Entry) this.A);
                return;
            case 16:
                o74 o74Var = (o74) this.f;
                j74 j74Var = (j74) this.z;
                m10 m10Var = (m10) this.A;
                n74 n74Var = o74Var.f;
                n74Var.a();
                if (n74Var.g) {
                    n74Var.g = false;
                    j74Var.c();
                    j74Var.i.b(null);
                    return;
                }
                n74Var.b = j74Var;
                n74Var.d = m10Var;
                Size size = j74Var.b;
                n74Var.a = size;
                n74Var.f = false;
                if (n74Var.b()) {
                    return;
                }
                ez4.o("SurfaceViewImpl", "Wait for new Surface creation.");
                n74Var.h.e.getHolder().setFixedSize(size.getWidth(), size.getHeight());
                return;
            case 17:
                VpnSettingsFragment.attemptScrollAndFlick$lambda$1((VpnSettingsFragment) this.f, (Integer) this.z, (LinearLayoutManager) this.A);
                return;
            case 18:
                lw4 lw4Var = (lw4) this.f;
                CodeEditor codeEditor2 = (CodeEditor) this.z;
                ArrayList arrayList2 = (ArrayList) this.A;
                if (lw4Var.b != codeEditor2) {
                    return;
                }
                List list3 = lw4Var.Z;
                if (list3 != null) {
                    list3.clear();
                } else {
                    lw4Var.Z = new ArrayList();
                }
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    lw4Var.Z.addAll(((kw4) it3.next()).f);
                }
                codeEditor2.setLayoutBusy(false);
                codeEditor2.getEventHandler().k(0.0f, 0.0f, false);
                return;
            case 19:
                b();
                return;
            case 20:
                AtomicBoolean atomicBoolean2 = (AtomicBoolean) this.f;
                vv vvVar2 = (vv) this.z;
                pl1 pl1Var = (pl1) this.A;
                if (atomicBoolean2.get()) {
                    return;
                }
                try {
                    vvVar2.b(pl1Var.a());
                    return;
                } catch (Throwable th4) {
                    vvVar2.d(th4);
                    return;
                }
            default:
                e eVar = (e) this.f;
                b7 b7Var = (b7) this.z;
                f4 f4Var = (f4) this.A;
                if (b7Var != null) {
                    eVar.d(b7Var, "trace.json");
                    return;
                }
                x3 x3Var = f4Var.s;
                b7 b7Var2 = new b7((w) x3Var.b, (d7) x3Var.c, "default", null);
                b7Var2.z0 = "auto";
                eVar.d(b7Var2, "trace.json");
                return;
        }
    }
}
