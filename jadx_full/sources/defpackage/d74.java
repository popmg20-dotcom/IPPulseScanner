package defpackage;

import android.graphics.RectF;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d74 implements Closeable {
    public final Size A;
    public final yv B0;
    public final vv C0;
    public final float[] X;
    public final float[] Y;
    public dd0 Z;
    public final Surface f;
    public Executor y0;
    public final int z;
    public final Object b = new Object();
    public boolean z0 = false;
    public boolean A0 = false;

    public d74(Surface surface, int i, Size size, lh lhVar, lh lhVar2) {
        float[] fArr = new float[16];
        this.X = fArr;
        float[] fArr2 = new float[16];
        this.Y = fArr2;
        this.f = surface;
        this.z = i;
        this.A = size;
        g(fArr, new float[16], lhVar);
        g(fArr2, new float[16], lhVar2);
        vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        try {
            this.C0 = vvVar;
            vvVar.a = "SurfaceOutputImpl close future complete";
        } catch (Exception e) {
            yvVar.b(e);
        }
        this.B0 = yvVar;
    }

    public static void g(float[] fArr, float[] fArr2, lh lhVar) {
        Matrix.setIdentityM(fArr, 0);
        if (lhVar == null) {
            return;
        }
        Size size = lhVar.a;
        boolean z = lhVar.e;
        int i = lhVar.d;
        co4.M(fArr);
        co4.L(fArr, i);
        if (z) {
            Matrix.translateM(fArr, 0, 1.0f, 0.0f, 0.0f);
            Matrix.scaleM(fArr, 0, -1.0f, 1.0f, 1.0f);
        }
        android.graphics.Matrix matrixA = kg4.a(kg4.h(size), kg4.h(kg4.g(size, i)), i, z);
        RectF rectF = new RectF(lhVar.b);
        matrixA.mapRect(rectF);
        float width = rectF.left / r7.getWidth();
        float height = ((r7.getHeight() - rectF.height()) - rectF.top) / r7.getHeight();
        float fWidth = rectF.width() / r7.getWidth();
        float fHeight = rectF.height() / r7.getHeight();
        Matrix.translateM(fArr, 0, width, height, 0.0f);
        Matrix.scaleM(fArr, 0, fWidth, fHeight, 1.0f);
        mz mzVar = lhVar.c;
        Matrix.setIdentityM(fArr2, 0);
        co4.M(fArr2);
        if (mzVar != null) {
            r25.j("Camera has no transform.", mzVar.p());
            co4.L(fArr2, mzVar.b().c());
            if (mzVar.f()) {
                Matrix.translateM(fArr2, 0, 1.0f, 0.0f, 0.0f);
                Matrix.scaleM(fArr2, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        Matrix.invertM(fArr2, 0, fArr2, 0);
        Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.b) {
            try {
                if (!this.A0) {
                    this.A0 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.C0.b(null);
    }

    public final Surface n(xq1 xq1Var, dd0 dd0Var) {
        boolean z;
        synchronized (this.b) {
            this.y0 = xq1Var;
            this.Z = dd0Var;
            z = this.z0;
        }
        if (z) {
            s();
        }
        return this.f;
    }

    public final void s() {
        Executor executor;
        dd0 dd0Var;
        AtomicReference atomicReference = new AtomicReference();
        synchronized (this.b) {
            try {
                if (this.y0 == null || (dd0Var = this.Z) == null) {
                    this.z0 = true;
                } else if (!this.A0) {
                    atomicReference.set(dd0Var);
                    executor = this.y0;
                    this.z0 = false;
                }
                executor = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (executor != null) {
            try {
                executor.execute(new xy0(this, atomicReference));
            } catch (RejectedExecutionException e) {
                ez4.p("SurfaceOutputImpl", "Processor executor closed. Close request not posted.", e);
            }
        }
    }
}
