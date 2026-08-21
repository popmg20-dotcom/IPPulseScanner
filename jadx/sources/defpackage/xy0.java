package defpackage;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.ImageWriter;
import android.os.Parcel;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.Surface;
import android.widget.TextView;
import androidx.camera.view.PreviewView;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.NATDetectActivity;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.ShutdownHookIntegration;
import io.sentry.android.core.ActivityLifecycleIntegration;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.j1;
import io.sentry.k4;
import io.sentry.n1;
import io.sentry.p5;
import io.sentry.util.b;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xy0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ xy0(d74 d74Var, AtomicReference atomicReference) {
        this.b = 21;
        this.z = d74Var;
        this.f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        pa3 pa3Var;
        switch (this.b) {
            case 0:
                yy0 yy0Var = (yy0) this.f;
                d74 d74Var = (d74) this.z;
                Surface surfaceN = d74Var.n(yy0Var.c, new g00(2, yy0Var, d74Var));
                yy0Var.a.g(surfaceN);
                yy0Var.h.put(d74Var, surfaceN);
                return;
            case 1:
                w11 w11Var = (w11) this.f;
                t6 t6Var = (t6) this.z;
                x11 x11Var = (x11) w11Var.Y;
                Thread thread = x11Var.d;
                CodeEditor codeEditor = x11Var.a;
                if (thread == ((Thread) w11Var.X)) {
                    x11Var.e = t6Var;
                    codeEditor.invalidate();
                    codeEditor.C0.a(new ub3(codeEditor));
                    x11Var.d = null;
                    return;
                }
                return;
            case 2:
                ((CodeEditor) this.f).setStyles((a54) this.z);
                return;
            case 3:
                ((z00) this.f).F((tq1) this.z);
                return;
            case 4:
                e10 e10Var = (e10) this.f;
                e10 e10Var2 = (e10) this.z;
                e10Var.m();
                if (e10Var2 != null) {
                    e10Var2.m();
                    return;
                }
                return;
            case 5:
                cp1 cp1Var = (cp1) this.f;
                r90 r90Var = (r90) this.z;
                HashSet hashSet = new HashSet();
                if (cp1Var != null) {
                    hashSet.addAll((LinkedHashSet) cp1Var.f);
                }
                ((g10) r90Var.f).getClass();
                return;
            case 6:
                Map.Entry entry = (Map.Entry) this.f;
                ad2 ad2Var = (ad2) this.z;
                du2 du2Var = (du2) entry.getKey();
                ad2Var.getClass();
                du2Var.a(ad2Var.a);
                return;
            case 7:
                n02 n02Var = (n02) this.f;
                n43 n43Var = (n43) this.z;
                ad2 ad2Var2 = (ad2) ((on2) n02Var.f).d();
                if (ad2Var2 == null) {
                    return;
                }
                n43Var.a(ad2Var2.a);
                return;
            case 8:
                ((tf2) this.f).f = ((MenuItem) this.z).getItemId();
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                vg3.o((vg3) this.f, (yc2) this.z);
                return;
            case 10:
                ((ny1) this.z).o((wl2) this.f);
                return;
            case 11:
                NATDetectActivity nATDetectActivity = (NATDetectActivity) this.f;
                String str = (String) this.z;
                h4 h4Var = nATDetectActivity.S0;
                if (h4Var == null) {
                    n12.T("binding");
                    throw null;
                }
                TextView textView = (TextView) h4Var.f;
                textView.setText(((Object) textView.getText()) + str + "\n");
                h4 h4Var2 = nATDetectActivity.S0;
                if (h4Var2 != null) {
                    ((TextView) h4Var2.f).post(new ga1(14, nATDetectActivity));
                    return;
                } else {
                    n12.T("binding");
                    throw null;
                }
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                ((xr3) this.f).g((lv2) this.z, xl4.a);
                return;
            case 13:
                ((i43) this.f).e((j74) this.z);
                return;
            case 14:
                ((PreviewView) ((oj1) this.f).f).F0.e((j74) this.z);
                return;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                n53 n53Var = (n53) this.f;
                vw4 vw4Var = (vw4) this.z;
                synchronized (n53Var.k) {
                    try {
                        Iterator it = n53Var.j.iterator();
                        while (it.hasNext()) {
                            ((w61) it.next()).b(vw4Var, false);
                        }
                    } finally {
                    }
                    break;
                }
                return;
            case 16:
                t53 t53Var = (t53) this.f;
                FileOutputStream fileOutputStream = (FileOutputStream) this.z;
                SystemClock.elapsedRealtime();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.getClass();
                try {
                    try {
                        parcelObtain.writeParcelable(t53Var, 0);
                        try {
                            fileOutputStream.write(parcelObtain.marshall());
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                ez4.l(fileOutputStream, th);
                                throw th2;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                    return;
                } finally {
                    parcelObtain.recycle();
                }
            case 17:
                QRCodeScannerActivity qRCodeScannerActivity = (QRCodeScannerActivity) this.f;
                String str2 = (String) this.z;
                int i = QRCodeScannerActivity.Y0;
                qRCodeScannerActivity.setResult(-1, new Intent().putExtra("result", str2));
                qRCodeScannerActivity.finish();
                return;
            case 18:
                ((ji0) this.f).F((Typeface) this.z);
                return;
            case 19:
                ya3 ya3Var = (ya3) this.f;
                ve1 ve1Var = (ve1) this.z;
                ya3Var.getClass();
                if (n12.c(ve1Var.c, ya3Var.z0)) {
                    p95.C(R.string.test_finished, new Object[0]);
                }
                if (t23.n() == mb3.f) {
                    String str3 = ve1Var.a;
                    String str4 = ya3Var.Z;
                    if (str4 == null) {
                        n12.T("profileName");
                        throw null;
                    }
                    if (str3.equals(str4)) {
                        String str5 = ve1Var.b;
                        na3 na3Var = ya3Var.y0;
                        if (na3Var == null) {
                            n12.T("proxyGroup");
                            throw null;
                        }
                        if (!str5.equals(na3Var.getName()) || (pa3Var = ya3Var.z) == null) {
                            return;
                        }
                        List list = pa3Var.d.f;
                        list.getClass();
                        pa3Var.s(new ArrayList(list), new wa3(ya3Var, 1));
                        return;
                    }
                    return;
                }
                return;
            case 20:
                wn1 wn1Var = (wn1) this.f;
                of2 of2Var = (of2) this.z;
                of2Var.getClass();
                ((v62) wn1Var.f).C().bringToFront();
                of2Var.a(wn1Var);
                return;
            case 21:
                ((dd0) ((AtomicReference) this.f).get()).accept(new mh((d74) this.z));
                return;
            case 22:
                ad4 ad4Var = (ad4) this.f;
                j74 j74Var = (j74) this.z;
                j74 j74Var2 = ad4Var.h;
                if (j74Var2 != null && j74Var2 == j74Var) {
                    ad4Var.h = null;
                    ad4Var.g = null;
                }
                m10 m10Var = ad4Var.l;
                if (m10Var != null) {
                    m10Var.e();
                    ad4Var.l = null;
                    return;
                }
                return;
            case 23:
                ga1 ga1Var = (ga1) this.f;
                CountDownLatch countDownLatch = (CountDownLatch) this.z;
                try {
                    ga1Var.run();
                    return;
                } finally {
                    countDownLatch.countDown();
                }
            case 24:
                ((e24) ((iv1) this.f).z).F((h24) this.z, 3);
                return;
            case 25:
                Runnable runnable = (Runnable) this.f;
                la laVar = (la) this.z;
                try {
                    runnable.run();
                    return;
                } finally {
                    laVar.c();
                }
            case 26:
                e10 e10Var3 = (e10) this.f;
                e24 e24Var = (e24) this.z;
                e10Var3.m();
                ((AtomicBoolean) e24Var.z).set(false);
                ImageWriter imageWriter = (ImageWriter) e24Var.f;
                if (imageWriter != null) {
                    imageWriter.close();
                    return;
                }
                return;
            case 27:
                ((j1) this.z).a(((k4) this.f).getOptions().getShutdownTimeoutMillis());
                return;
            case 28:
                ShutdownHookIntegration shutdownHookIntegration = (ShutdownHookIntegration) this.f;
                SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.z;
                shutdownHookIntegration.b.addShutdownHook(shutdownHookIntegration.f);
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "ShutdownHookIntegration installed.", new Object[0]);
                b.a("ShutdownHook");
                return;
            default:
                ActivityLifecycleIntegration.n((n1) this.f, (n1) this.z);
                return;
        }
    }

    public /* synthetic */ xy0(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    public /* synthetic */ xy0(ActivityLifecycleIntegration activityLifecycleIntegration, n1 n1Var, n1 n1Var2) {
        this.b = 29;
        this.f = n1Var;
        this.z = n1Var2;
    }
}
