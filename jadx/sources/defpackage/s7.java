package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Process;
import android.os.StrictMode;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.a0;
import androidx.fragment.app.g;
import androidx.fragment.app.p;
import androidx.work.impl.WorkDatabase;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s7 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ s7(uk1 uk1Var, View view, Rect rect) {
        this.b = 23;
        this.f = view;
        this.z = rect;
    }

    private final void a() {
        n00 n00Var = (n00) this.f;
        vv vvVar = (vv) this.z;
        rw rwVar = n00Var.g;
        ow owVar = rwVar.b;
        synchronized (owVar.a) {
            owVar.c.clear();
            owVar.d.clear();
            owVar.f.clear();
            owVar.e.clear();
            owVar.g = 0;
        }
        rwVar.j.g();
        if (n00Var.f != null) {
            Executor executor = n00Var.d;
            if (executor instanceof iz) {
                ((iz) executor).a();
            }
            n00Var.f.quit();
        }
        vvVar.b(null);
    }

    private final void b() {
        zo2 zo2Var;
        pw2 pw2Var = (pw2) this.f;
        da3 da3Var = (da3) this.z;
        if (pw2Var.b != pw2.d) {
            xe.q("provide() can be called only once.");
            return;
        }
        synchronized (pw2Var) {
            zo2Var = pw2Var.a;
            pw2Var.a = null;
            pw2Var.b = da3Var;
        }
        zo2Var.getClass();
    }

    private final void c() {
        e92 e92Var = (e92) this.f;
        da3 da3Var = (da3) this.z;
        synchronized (e92Var) {
            try {
                if (e92Var.b == null) {
                    e92Var.a.add(da3Var);
                } else {
                    e92Var.b.add(da3Var.get());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void d() {
        dn0 dn0Var = (dn0) this.f;
        String str = (String) this.z;
        try {
            dn0Var.e.get();
            dn0Var.e(dn0.n.decrementAndGet(), dn0.m.get(), "Surface terminated");
        } catch (Exception e) {
            ez4.q("DeferrableSurface", "Unexpected surface termination for " + dn0Var + "\nStack Trace:\n" + str);
            synchronized (dn0Var.a) {
                throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", dn0Var, Boolean.valueOf(dn0Var.c), Integer.valueOf(dn0Var.b)), e);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 1;
        switch (this.b) {
            case 0:
                ((ny1) this.z).o((fa5) this.f);
                return;
            case 1:
                la laVar = (la) this.f;
                try {
                    ((Runnable) this.z).run();
                    return;
                } finally {
                    laVar.c();
                }
            case 2:
                eg0 eg0Var = (eg0) this.f;
                zf2 zf2Var = (zf2) this.z;
                TextInputEditText textInputEditText = (TextInputEditText) eg0Var.f;
                textInputEditText.requestFocus();
                Object systemService = ((Context) zf2Var.f).getSystemService("input_method");
                systemService.getClass();
                ((InputMethodManager) systemService).showSoftInput(textInputEditText, 1);
                return;
            case 3:
                BypassConfigActivity bypassConfigActivity = (BypassConfigActivity) this.f;
                ArrayList arrayList = (ArrayList) this.z;
                int i2 = BypassConfigActivity.Y0;
                bypassConfigActivity.D();
                bypassConfigActivity.z();
                bypassConfigActivity.E(arrayList);
                return;
            case 4:
                nw nwVar = (nw) this.f;
                vv vvVar = (vv) this.z;
                final long jK = nwVar.k();
                final vv vvVar2 = new vv();
                vvVar2.c = new wj3();
                yv yvVar = new yv(vvVar2);
                vvVar2.b = yvVar;
                vvVar2.a = fw.class;
                try {
                    nwVar.a(new mw() { // from class: gw
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
                        @Override // defpackage.mw
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final boolean d(android.hardware.camera2.TotalCaptureResult r8) {
                            /*
                                r7 = this;
                                android.hardware.camera2.CaptureRequest r0 = r8.getRequest()
                                r1 = 1
                                r2 = 0
                                if (r0 != 0) goto L9
                                goto L30
                            L9:
                                android.hardware.camera2.CaptureRequest r8 = r8.getRequest()
                                java.lang.Object r8 = r8.getTag()
                                boolean r0 = r8 instanceof defpackage.pa4
                                if (r0 == 0) goto L30
                                pa4 r8 = (defpackage.pa4) r8
                                java.lang.String r0 = "CameraControlSessionUpdateId"
                                android.util.ArrayMap r8 = r8.a
                                java.lang.Object r8 = r8.get(r0)
                                java.lang.Long r8 = (java.lang.Long) r8
                                if (r8 != 0) goto L24
                                goto L30
                            L24:
                                long r3 = r8.longValue()
                                long r5 = r1
                                int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                                if (r8 < 0) goto L30
                                r8 = r1
                                goto L31
                            L30:
                                r8 = r2
                            L31:
                                if (r8 == 0) goto L3a
                                r8 = 0
                                vv r7 = r3
                                r7.b(r8)
                                return r1
                            L3a:
                                return r2
                            */
                            throw new UnsupportedOperationException("Method not decompiled: defpackage.gw.d(android.hardware.camera2.TotalCaptureResult):boolean");
                        }
                    });
                    vvVar2.a = "waitForSessionUpdateId:" + jK;
                    break;
                } catch (Exception e) {
                    yvVar.b(e);
                }
                n12.N(yvVar, vvVar);
                return;
            case 5:
                nw nwVar2 = (nw) this.f;
                yx yxVar = (yx) this.z;
                kw kwVar = nwVar2.O0;
                ((HashSet) kwVar.b).remove(yxVar);
                ((ArrayMap) kwVar.c).remove(yxVar);
                return;
            case 6:
                lw lwVar = (lw) this.f;
                TotalCaptureResult totalCaptureResult = (TotalCaptureResult) this.z;
                HashSet hashSet = new HashSet();
                HashSet<mw> hashSet2 = (HashSet) lwVar.b;
                for (mw mwVar : hashSet2) {
                    if (mwVar.d(totalCaptureResult)) {
                        hashSet.add(mwVar);
                    }
                }
                if (hashSet.isEmpty()) {
                    return;
                }
                hashSet2.removeAll(hashSet);
                return;
            case 7:
                ((rt3) this.f).a((tt3) this.z);
                return;
            case 8:
                Surface surface = (Surface) this.f;
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.z;
                surface.release();
                surfaceTexture.release();
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ex exVar = (ex) this.f;
                String str = (String) this.z;
                exVar.w("Use case " + str + " INACTIVE", null);
                LinkedHashMap linkedHashMap = (LinkedHashMap) exVar.b.z;
                if (linkedHashMap.containsKey(str)) {
                    jn4 jn4Var = (jn4) linkedHashMap.get(str);
                    jn4Var.f = false;
                    if (!jn4Var.e) {
                        linkedHashMap.remove(str);
                    }
                }
                exVar.M();
                return;
            case 10:
                tx txVar = (tx) this.f;
                vv vvVar3 = (vv) this.z;
                try {
                    String[] strArrC = ((pz) txVar.Z).c();
                    strArrC.getClass();
                    ArrayList arrayList2 = new ArrayList(strArrC.length);
                    for (String str2 : strArrC) {
                        str2.getClass();
                        arrayList2.add(new jz(e70.L(str2), null));
                    }
                    Log.d("Camera2PresenceSrc", "[FetchData] Refreshed camera list: " + d70.j0(arrayList2, null, null, null, null, 63));
                    txVar.h(arrayList2, null);
                    vvVar3.b(arrayList2);
                    return;
                } catch (xx e2) {
                    a1.e("Camera2PresenceSrc", "[FetchData] Failed to get camera list for refresh.", e2);
                    e00 e00Var = new e00(e2);
                    txVar.h(null, e00Var);
                    vvVar3.d(e00Var);
                    return;
                }
            case 11:
                ((mz) this.f).r().a().j((hu2) this.z);
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                ((kz) this.f).a().f((uz) this.z);
                return;
            case 13:
                a00 a00Var = (a00) this.f;
                mz mzVar = (mz) this.z;
                synchronized (a00Var.a) {
                    try {
                        a00Var.c.remove(mzVar);
                        if (a00Var.c.isEmpty()) {
                            a00Var.e.getClass();
                            a00Var.e.b(null);
                            a00Var.e = null;
                            a00Var.d = null;
                        }
                    } finally {
                    }
                    break;
                }
                return;
            case 14:
                a();
                return;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                xw4 xw4Var = (xw4) this.f;
                String string = ((UUID) this.z).toString();
                string.getClass();
                ye.d(xw4Var, string);
                return;
            case 16:
                WorkDatabase workDatabase = (WorkDatabase) this.f;
                xw4 xw4Var2 = (xw4) this.z;
                jx4 jx4VarX = workDatabase.x();
                jx4VarX.getClass();
                Iterator it = ((List) ke0.r(jx4VarX.a, true, false, new q74(12))).iterator();
                while (it.hasNext()) {
                    ye.d(xw4Var2, (String) it.next());
                }
                return;
            case 17:
                v80 v80Var = (v80) this.f;
                i60 i60Var = (i60) this.z;
                if (v80Var.g) {
                    return;
                }
                Collections.sort(v80Var.a, i60Var);
                v80Var.e.run();
                return;
            case 18:
                p pVar = (p) this.f;
                pVar.b.a(new a90((wu2) this.z, pVar));
                return;
            case 19:
                b();
                return;
            case 20:
                c();
                return;
            case 21:
                List<gk> list = (List) this.f;
                bc0 bc0Var = (bc0) this.z;
                for (gk gkVar : list) {
                    Object obj = bc0Var.e;
                    hk hkVar = gkVar.a;
                    Object pc0Var = hkVar.e(obj) ? new pc0(hkVar.d()) : oc0.a;
                    q53 q53Var = gkVar.b;
                    q53Var.getClass();
                    q53Var.e(pc0Var);
                }
                return;
            case 22:
                tg0 tg0Var = (tg0) this.f;
                Runnable runnable = (Runnable) this.z;
                Process.setThreadPriority(tg0Var.z);
                StrictMode.ThreadPolicy threadPolicy = tg0Var.A;
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                runnable.run();
                return;
            case 23:
                uk1.j((View) this.f, (Rect) this.z);
                return;
            case 24:
                g gVar = (g) this.f;
                ViewGroup viewGroup = (ViewGroup) this.z;
                viewGroup.getClass();
                Iterator it2 = gVar.c.iterator();
                while (it2.hasNext()) {
                    a0 a0Var = ((tm0) it2.next()).a;
                    View view = a0Var.c.getView();
                    if (view != null) {
                        dw2.s(a0Var.a, view, viewGroup);
                    }
                }
                return;
            case 25:
                xm0 xm0Var = (xm0) this.f;
                d74 d74Var = (d74) this.z;
                Surface surfaceN = d74Var.n(xm0Var.c, new g00(i, xm0Var, d74Var));
                xm0Var.a.g(surfaceN);
                xm0Var.h.put(d74Var, surfaceN);
                return;
            case 26:
                final xm0 xm0Var2 = (xm0) this.f;
                final j74 j74Var = (j74) this.z;
                xm0Var2.i++;
                bw2 bw2Var = xm0Var2.a;
                gn1.d(bw2Var.a, true);
                gn1.c(bw2Var.c);
                final SurfaceTexture surfaceTexture2 = new SurfaceTexture(bw2Var.m);
                Size size = j74Var.b;
                surfaceTexture2.setDefaultBufferSize(size.getWidth(), size.getHeight());
                final Surface surface2 = new Surface(surfaceTexture2);
                xq1 xq1Var = xm0Var2.c;
                j74Var.b(xq1Var, new ed(5, xm0Var2, j74Var));
                j74Var.a(surface2, xq1Var, new dd0() { // from class: vm0
                    @Override // defpackage.dd0
                    public final void accept(Object obj2) {
                        xm0 xm0Var3 = xm0Var2;
                        j74 j74Var2 = j74Var;
                        SurfaceTexture surfaceTexture3 = surfaceTexture2;
                        Surface surface3 = surface2;
                        synchronized (j74Var2.a) {
                            j74Var2.m = null;
                            j74Var2.n = null;
                        }
                        surfaceTexture3.setOnFrameAvailableListener(null);
                        surfaceTexture3.release();
                        surface3.release();
                        xm0Var3.i--;
                        xm0Var3.a();
                    }
                });
                surfaceTexture2.setOnFrameAvailableListener(xm0Var2, xm0Var2.d);
                return;
            case 27:
                d();
                return;
            case 28:
                Callable callable = (Callable) this.f;
                ao0 ao0Var = (ao0) ((cp1) this.z).f;
                try {
                    ao0Var.j(callable.call());
                    return;
                } catch (Exception e3) {
                    ao0Var.k(e3);
                    return;
                }
            default:
                final yy0 yy0Var = (yy0) this.f;
                j74 j74Var2 = (j74) this.z;
                yy0Var.e++;
                vy0 vy0Var = yy0Var.a;
                boolean z = j74Var2.e;
                Size size2 = j74Var2.b;
                gn1.d(vy0Var.a, true);
                gn1.c(vy0Var.c);
                final SurfaceTexture surfaceTexture3 = new SurfaceTexture(z ? vy0Var.n : vy0Var.o);
                surfaceTexture3.setDefaultBufferSize(size2.getWidth(), size2.getHeight());
                final Surface surface3 = new Surface(surfaceTexture3);
                j74Var2.a(surface3, yy0Var.c, new dd0() { // from class: wy0
                    @Override // defpackage.dd0
                    public final void accept(Object obj2) {
                        SurfaceTexture surfaceTexture4 = surfaceTexture3;
                        surfaceTexture4.setOnFrameAvailableListener(null);
                        surfaceTexture4.release();
                        surface3.release();
                        r1.e--;
                        yy0Var.a();
                    }
                });
                if (z) {
                    yy0Var.i = surfaceTexture3;
                    return;
                } else {
                    yy0Var.j = surfaceTexture3;
                    surfaceTexture3.setOnFrameAvailableListener(yy0Var, yy0Var.d);
                    return;
                }
        }
    }

    public /* synthetic */ s7(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }
}
