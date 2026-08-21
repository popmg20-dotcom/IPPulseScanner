package defpackage;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import j$.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o74 extends t43 {
    public SurfaceView e;
    public final n74 f;

    public o74(FrameLayout frameLayout, o43 o43Var) {
        super(frameLayout, o43Var);
        this.f = new n74(this);
    }

    @Override // defpackage.t43
    public final View a() {
        return this.e;
    }

    @Override // defpackage.t43
    public final Bitmap b() {
        SurfaceView surfaceView = this.e;
        if (surfaceView == null || surfaceView.getHolder().getSurface() == null || !this.e.getHolder().getSurface().isValid()) {
            return null;
        }
        Semaphore semaphore = new Semaphore(0);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.e.getWidth(), this.e.getHeight(), Bitmap.Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread("pixelCopyRequest Thread");
        handlerThread.start();
        ga5.y(this.e, bitmapCreateBitmap, new m74(0, semaphore), new Handler(handlerThread.getLooper()));
        try {
            if (!semaphore.tryAcquire(1, 100L, TimeUnit.MILLISECONDS)) {
                ez4.q("SurfaceViewImpl", "Timed out while trying to acquire screenshot.");
            }
            return bitmapCreateBitmap;
        } catch (InterruptedException e) {
            ez4.r("SurfaceViewImpl", "Interrupted while trying to acquire screenshot.", e);
            return bitmapCreateBitmap;
        } finally {
            handlerThread.quitSafely();
        }
    }

    @Override // defpackage.t43
    public final void e(j74 j74Var, m10 m10Var) {
        SurfaceView surfaceView = this.e;
        boolean zEquals = Objects.equals(this.a, j74Var.b);
        if (surfaceView == null || !zEquals) {
            Size size = j74Var.b;
            this.a = size;
            size.getClass();
            FrameLayout frameLayout = this.b;
            SurfaceView surfaceView2 = new SurfaceView(frameLayout.getContext());
            this.e = surfaceView2;
            surfaceView2.setLayoutParams(new FrameLayout.LayoutParams(this.a.getWidth(), this.a.getHeight()));
            frameLayout.removeAllViews();
            frameLayout.addView(this.e);
            this.e.getHolder().addCallback(this.f);
        }
        Executor executorI = v9.i(this.e.getContext());
        j74Var.j.a(new ga1(21, m10Var), executorI);
        this.e.post(new b0(16, this, j74Var, m10Var));
    }

    @Override // defpackage.t43
    public final nc2 g() {
        return zy1.z;
    }

    @Override // defpackage.t43
    public final void c() {
    }

    @Override // defpackage.t43
    public final void d() {
    }
}
