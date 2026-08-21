package defpackage;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import j$.util.Objects;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xm0 implements SurfaceTexture.OnFrameAvailableListener {
    public final bw2 a;
    public final HandlerThread b;
    public final xq1 c;
    public final Handler d;
    public final AtomicBoolean e;
    public final float[] f;
    public final float[] g;
    public final LinkedHashMap h;
    public int i;
    public boolean j;
    public final ArrayList k;

    public xm0(oz0 oz0Var) {
        Map map = Collections.EMPTY_MAP;
        this.e = new AtomicBoolean(false);
        this.f = new float[16];
        this.g = new float[16];
        this.h = new LinkedHashMap();
        this.i = 0;
        this.j = false;
        this.k = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("CameraX-GL Thread");
        this.b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.d = handler;
        this.c = new xq1(handler);
        this.a = new bw2();
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
            e();
            throw e3;
        }
    }

    public final void a() {
        if (this.j && this.i == 0) {
            LinkedHashMap linkedHashMap = this.h;
            Iterator it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((d74) it.next()).close();
            }
            Iterator it2 = this.k.iterator();
            if (it2.hasNext()) {
                ((qg) it2.next()).getClass();
                new Exception("Failed to snapshot: DefaultSurfaceProcessor is released.");
                throw null;
            }
            linkedHashMap.clear();
            bw2 bw2Var = this.a;
            if (bw2Var.a.getAndSet(false)) {
                gn1.c(bw2Var.c);
                bw2Var.h();
            }
            this.b.quit();
        }
    }

    public final void b(Runnable runnable, Runnable runnable2) {
        try {
            this.c.execute(new b0(7, this, runnable2, runnable));
        } catch (RejectedExecutionException e) {
            ez4.b0("DefaultSurfaceProcessor", "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    public final void c(Exception exc) {
        ArrayList arrayList = this.k;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            ((qg) it.next()).getClass();
            throw null;
        }
        arrayList.clear();
    }

    public final Bitmap d(Size size, float[] fArr, int i) {
        float[] fArr2 = (float[]) fArr.clone();
        co4.L(fArr2, i);
        co4.M(fArr2);
        Size sizeG = kg4.g(size, i);
        bw2 bw2Var = this.a;
        bw2Var.getClass();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(sizeG.getHeight() * sizeG.getWidth() * 4);
        r25.f(byteBufferAllocateDirect.capacity() == (sizeG.getHeight() * sizeG.getWidth()) * 4, "ByteBuffer capacity is not equal to width * height * 4.");
        r25.f(byteBufferAllocateDirect.isDirect(), "ByteBuffer is not direct.");
        int[] iArr = gn1.a;
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        gn1.b("glGenTextures");
        int i2 = iArr2[0];
        GLES20.glActiveTexture(33985);
        gn1.b("glActiveTexture");
        GLES20.glBindTexture(3553, i2);
        gn1.b("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, sizeG.getWidth(), sizeG.getHeight(), 0, 6407, 5121, null);
        gn1.b("glTexImage2D");
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int[] iArr3 = new int[1];
        GLES20.glGenFramebuffers(1, iArr3, 0);
        gn1.b("glGenFramebuffers");
        int i3 = iArr3[0];
        GLES20.glBindFramebuffer(36160, i3);
        gn1.b("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        gn1.b("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        gn1.b("glActiveTexture");
        GLES20.glBindTexture(36197, bw2Var.m);
        gn1.b("glBindTexture");
        bw2Var.i = null;
        GLES20.glViewport(0, 0, sizeG.getWidth(), sizeG.getHeight());
        GLES20.glScissor(0, 0, sizeG.getWidth(), sizeG.getHeight());
        en1 en1Var = bw2Var.k;
        en1Var.getClass();
        if (en1Var instanceof fn1) {
            GLES20.glUniformMatrix4fv(((fn1) en1Var).f, 1, false, fArr2, 0);
            gn1.b("glUniformMatrix4fv");
        }
        GLES20.glDrawArrays(5, 0, 4);
        gn1.b("glDrawArrays");
        GLES20.glReadPixels(0, 0, sizeG.getWidth(), sizeG.getHeight(), 6408, 5121, byteBufferAllocateDirect);
        gn1.b("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteTextures(1, new int[]{i2}, 0);
        gn1.b("glDeleteTextures");
        GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
        gn1.b("glDeleteFramebuffers");
        int i4 = bw2Var.m;
        GLES20.glActiveTexture(33984);
        gn1.b("glActiveTexture");
        GLES20.glBindTexture(36197, i4);
        gn1.b("glBindTexture");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(sizeG.getWidth(), sizeG.getHeight(), Bitmap.Config.ARGB_8888);
        byteBufferAllocateDirect.rewind();
        ImageProcessingUtil.c(bitmapCreateBitmap, byteBufferAllocateDirect, sizeG.getWidth() * 4);
        return bitmapCreateBitmap;
    }

    public final void e() {
        if (this.e.getAndSet(true)) {
            return;
        }
        b(new d4(20, this), new hw(0));
    }

    public final void f(wh4 wh4Var) {
        ArrayList arrayList = this.k;
        if (arrayList.isEmpty()) {
            return;
        }
        if (wh4Var == null) {
            c(new Exception("Failed to snapshot: no JPEG Surface."));
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Iterator it = arrayList.iterator();
                if (!it.hasNext()) {
                    byteArrayOutputStream.close();
                    return;
                }
                ((qg) it.next()).getClass();
                Bitmap bitmapD = d((Size) wh4Var.f, wh4Var.z, 0);
                byteArrayOutputStream.reset();
                bitmapD.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Surface surface = (Surface) wh4Var.b;
                Objects.requireNonNull(byteArray);
                ImageProcessingUtil.h(byteArray, surface);
                throw null;
            } finally {
            }
        } catch (IOException e) {
            c(e);
        }
        c(e);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.e.get()) {
            return;
        }
        surfaceTexture.updateTexImage();
        float[] fArr = this.f;
        surfaceTexture.getTransformMatrix(fArr);
        wh4 wh4Var = null;
        for (Map.Entry entry : this.h.entrySet()) {
            Surface surface = (Surface) entry.getValue();
            d74 d74Var = (d74) entry.getKey();
            float[] fArr2 = d74Var.X;
            float[] fArr3 = this.g;
            Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
            int i = d74Var.z;
            if (i == 34) {
                try {
                    this.a.j(surfaceTexture.getTimestamp(), fArr3, surface);
                } catch (RuntimeException e) {
                    ez4.r("DefaultSurfaceProcessor", "Failed to render with OpenGL.", e);
                }
            } else {
                r25.j("Unsupported format: " + i, i == 256);
                r25.j("Only one JPEG output is supported.", wh4Var == null);
                wh4Var = new wh4(surface, d74Var.A, (float[]) fArr3.clone());
            }
        }
        try {
            f(wh4Var);
        } catch (RuntimeException e2) {
            c(e2);
        }
    }
}
