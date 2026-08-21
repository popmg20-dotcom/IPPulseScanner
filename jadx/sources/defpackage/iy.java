package defpackage;

import android.app.Activity;
import android.graphics.Canvas;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import androidx.work.impl.WorkDatabase;
import com.tencent.mars.xlog.Xlog;
import io.sentry.ILogger;
import io.sentry.android.core.ScreenshotEventProcessor;
import io.sentry.android.core.internal.util.i;
import io.sentry.android.core.k1;
import io.sentry.android.core.q0;
import io.sentry.f1;
import io.sentry.p6;
import io.sentry.r3;
import io.sentry.s3;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class iy implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ iy(xm0 xm0Var, oz0 oz0Var, vv vvVar) {
        this.b = 3;
        Map map = Collections.EMPTY_MAP;
        this.f = xm0Var;
        this.z = oz0Var;
        this.A = map;
        this.X = vvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        int i = this.b;
        Object obj = this.A;
        Object obj2 = this.X;
        Object obj3 = this.z;
        Object obj4 = this.f;
        switch (i) {
            case 0:
                ((CameraCaptureSession.CaptureCallback) ((lw) obj4).b).onCaptureCompleted((CameraCaptureSession) obj3, (CaptureRequest) obj, (TotalCaptureResult) obj2);
                return;
            case 1:
                ((CameraCaptureSession.CaptureCallback) ((lw) obj4).b).onCaptureProgressed((CameraCaptureSession) obj3, (CaptureRequest) obj, (CaptureResult) obj2);
                return;
            case 2:
                ((CameraCaptureSession.CaptureCallback) ((lw) obj4).b).onCaptureFailed((CameraCaptureSession) obj3, (CaptureRequest) obj, (CaptureFailure) obj2);
                return;
            case 3:
                xm0 xm0Var = (xm0) obj4;
                oz0 oz0Var = (oz0) obj3;
                Map map = Collections.EMPTY_MAP;
                vv vvVar = (vv) obj2;
                try {
                    xm0Var.a.e(oz0Var);
                    vvVar.b(null);
                    return;
                } catch (RuntimeException e) {
                    vvVar.d(e);
                    return;
                }
            case 4:
                yy0 yy0Var = (yy0) obj4;
                oz0 oz0Var2 = (oz0) obj3;
                Map map2 = Collections.EMPTY_MAP;
                vv vvVar2 = (vv) obj2;
                try {
                    yy0Var.a.e(oz0Var2);
                    vvVar2.b(null);
                    return;
                } catch (RuntimeException e2) {
                    vvVar2.d(e2);
                    return;
                }
            case 5:
                List list = (List) obj4;
                vw4 vw4Var = (vw4) obj3;
                na0 na0Var = (na0) obj;
                WorkDatabase workDatabase = (WorkDatabase) obj2;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((dq3) it.next()).d(vw4Var.a);
                }
                fq3.b(na0Var, workDatabase, list);
                return;
            case 6:
                ad4 ad4Var = (ad4) obj4;
                Surface surface = (Surface) obj3;
                yv yvVar = (yv) obj;
                j74 j74Var = (j74) obj2;
                ez4.o("TextureViewImpl", "Safe to release surface.");
                m10 m10Var = ad4Var.l;
                if (m10Var != null) {
                    m10Var.e();
                    ad4Var.l = null;
                }
                surface.release();
                if (ad4Var.g == yvVar) {
                    ad4Var.g = null;
                }
                if (ad4Var.h == j74Var) {
                    ad4Var.h = null;
                    return;
                }
                return;
            case 7:
                f1 f1Var = (f1) obj3;
                r3 r3Var = (r3) obj;
                p6 p6Var = (p6) obj2;
                if (((k1) obj4).C0.get()) {
                    return;
                }
                s3 s3Var = new s3(r3Var.a, r3Var.b, r3Var.d, r3Var.c, Double.valueOf(r3Var.e), p6Var);
                s3Var.B0 = r3Var.f;
                f1Var.h(s3Var);
                return;
            case 8:
                countDownLatch = (CountDownLatch) obj2;
                try {
                    ((AtomicReference) obj3).set(((ScreenshotEventProcessor) obj4).a((Activity) obj));
                    return;
                } finally {
                }
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                Window window = (Window) obj4;
                Window.Callback callback = (Window.Callback) obj3;
                Runnable runnable = (Runnable) obj;
                q0 q0Var = (q0) obj2;
                View viewPeekDecorView = window.peekDecorView();
                if (viewPeekDecorView != null) {
                    window.setCallback(callback);
                    i.b(viewPeekDecorView, runnable, q0Var);
                    return;
                }
                return;
            default:
                ILogger iLogger = (ILogger) obj;
                countDownLatch = (CountDownLatch) obj2;
                try {
                    ((View) obj4).draw((Canvas) obj3);
                    break;
                } finally {
                    try {
                    } finally {
                    }
                    break;
                }
                return;
        }
    }

    public /* synthetic */ iy(yy0 yy0Var, oz0 oz0Var, vv vvVar) {
        this.b = 4;
        Map map = Collections.EMPTY_MAP;
        this.f = yy0Var;
        this.z = oz0Var;
        this.A = map;
        this.X = vvVar;
    }

    public /* synthetic */ iy(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
        this.X = obj4;
    }
}
