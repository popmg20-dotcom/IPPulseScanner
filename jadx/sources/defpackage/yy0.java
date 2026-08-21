package defpackage;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yy0 implements SurfaceTexture.OnFrameAvailableListener {
    public final vy0 a;
    public final HandlerThread b;
    public final xq1 c;
    public final Handler d;
    public int e;
    public boolean f;
    public final AtomicBoolean g;
    public final LinkedHashMap h;
    public SurfaceTexture i;
    public SurfaceTexture j;

    public yy0(oz0 oz0Var, lb lbVar, lb lbVar2) {
        Map map = Collections.EMPTY_MAP;
        this.e = 0;
        this.f = false;
        this.g = new AtomicBoolean(false);
        this.h = new LinkedHashMap();
        HandlerThread handlerThread = new HandlerThread("CameraX-GL Thread");
        this.b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.d = handler;
        this.c = new xq1(handler);
        this.a = new vy0(lbVar, lbVar2);
        try {
            vv vvVar = new vv();
            vvVar.c = new wj3();
            yv yvVar = new yv(vvVar);
            vvVar.b = yvVar;
            vvVar.a = fw.class;
            try {
                b(new iy(this, oz0Var, vvVar), new hw(0));
                vvVar.a = "Init GlRenderer";
            } catch (Exception e) {
                yvVar.b(e);
            }
            try {
                yvVar.get();
            } catch (InterruptedException | ExecutionException e2) {
                e = e2;
                e = e instanceof ExecutionException ? e.getCause() : e;
                if (!(e instanceof RuntimeException)) {
                    throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
                }
                throw ((RuntimeException) e);
            }
        } catch (RuntimeException e3) {
            d();
            throw e3;
        }
    }

    public final void a() {
        if (this.f && this.e == 0) {
            LinkedHashMap linkedHashMap = this.h;
            Iterator it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((d74) it.next()).close();
            }
            linkedHashMap.clear();
            vy0 vy0Var = this.a;
            if (vy0Var.a.getAndSet(false)) {
                gn1.c(vy0Var.c);
                vy0Var.h();
            }
            vy0Var.n = -1;
            vy0Var.o = -1;
            this.b.quit();
        }
    }

    public final void b(Runnable runnable, Runnable runnable2) {
        try {
            this.c.execute(new b0(8, this, runnable2, runnable));
        } catch (RejectedExecutionException e) {
            ez4.b0("DualSurfaceProcessor", "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    public final void c(j74 j74Var) {
        if (this.g.get()) {
            j74Var.c();
        } else {
            b(new s7(29, this, j74Var), new wm0(j74Var, 0));
        }
    }

    public final void d() {
        if (this.g.getAndSet(true)) {
            return;
        }
        b(new d4(23, this), new hw(0));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2;
        if (this.g.get() || (surfaceTexture2 = this.i) == null || this.j == null) {
            return;
        }
        surfaceTexture2.updateTexImage();
        this.j.updateTexImage();
        for (Map.Entry entry : this.h.entrySet()) {
            Surface surface = (Surface) entry.getValue();
            d74 d74Var = (d74) entry.getKey();
            if (d74Var.z == 34) {
                try {
                    this.a.l(surfaceTexture.getTimestamp(), surface, d74Var, this.i, this.j);
                } catch (RuntimeException e) {
                    ez4.r("DualSurfaceProcessor", "Failed to render with OpenGL.", e);
                }
            }
        }
    }
}
