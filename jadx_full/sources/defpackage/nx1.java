package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import androidx.camera.core.ImageProcessingUtil;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class nx1 implements ny1 {
    public ByteBuffer E0;
    public ByteBuffer F0;
    public ByteBuffer G0;
    public ByteBuffer H0;
    public ByteBuffer I0;
    public ByteBuffer J0;
    public volatile boolean X;
    public volatile boolean Y;
    public Executor Z;
    public hx1 b;
    public volatile int f;
    public e10 y0;
    public volatile int z;
    public ImageWriter z0;
    public volatile int A = 1;
    public Rect A0 = new Rect();
    public Rect B0 = new Rect();
    public Matrix C0 = new Matrix();
    public Matrix D0 = new Matrix();
    public final Object K0 = new Object();
    public boolean L0 = true;

    public abstract my1 a(oy1 oy1Var);

    public final nc2 b(final my1 my1Var) throws Throwable {
        Object obj;
        Executor executor;
        final hx1 hx1Var;
        boolean z;
        e10 e10Var;
        ImageWriter imageWriter;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        ByteBuffer byteBuffer4;
        ByteBuffer byteBuffer5;
        ByteBuffer byteBuffer6;
        rx1 rx1VarG;
        rx1 rx1Var;
        int i = this.X ? this.f : 0;
        Object obj2 = this.K0;
        synchronized (obj2) {
            try {
                try {
                    executor = this.Z;
                    hx1Var = this.b;
                    z = this.X && i != this.z;
                    if (z) {
                        g(my1Var, i);
                    }
                    if (this.X || this.A == 3) {
                        d(my1Var);
                    }
                    try {
                        e10Var = this.y0;
                    } catch (Throwable th) {
                        th = th;
                        obj = obj2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    imageWriter = this.z0;
                    byteBuffer = this.E0;
                    byteBuffer2 = this.F0;
                    byteBuffer3 = this.G0;
                    byteBuffer4 = this.H0;
                    byteBuffer5 = this.I0;
                    byteBuffer6 = this.J0;
                } catch (Throwable th3) {
                    th = th3;
                    obj = obj2;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
            }
        }
        if (hx1Var == null || executor == null || !this.L0) {
            return new zy1(1, new t80("No analyzer or executor currently set."));
        }
        int i2 = this.A;
        if (e10Var != null) {
            if (i2 == 2) {
                rx1VarG = ImageProcessingUtil.b(my1Var, e10Var, byteBuffer, i, this.Y);
            } else {
                if (this.A == 1) {
                    if (this.Y) {
                        ImageProcessingUtil.a(my1Var);
                    }
                    if (imageWriter != null && byteBuffer2 != null && byteBuffer3 != null && byteBuffer4 != null) {
                        rx1VarG = ImageProcessingUtil.f(my1Var, e10Var, imageWriter, byteBuffer2, byteBuffer3, byteBuffer4, i);
                    }
                }
                rx1Var = null;
            }
            rx1Var = rx1VarG;
        } else {
            if (i2 == 3) {
                if (this.Y) {
                    ImageProcessingUtil.a(my1Var);
                }
                if (byteBuffer2 != null && byteBuffer3 != null && byteBuffer4 != null && byteBuffer5 != null && byteBuffer6 != null) {
                    rx1VarG = ImageProcessingUtil.g(my1Var, byteBuffer2, byteBuffer3, byteBuffer4, byteBuffer5, byteBuffer6, i);
                    rx1Var = rx1VarG;
                }
            }
            rx1Var = null;
        }
        boolean z2 = rx1Var == null;
        final my1 my1Var2 = z2 ? my1Var : rx1Var;
        final Rect rect = new Rect();
        final Matrix matrix = new Matrix();
        synchronized (this.K0) {
            if (z && !z2) {
                try {
                    f(my1Var.f(), my1Var.c(), my1Var2.f(), my1Var2.c());
                } finally {
                }
            }
            this.z = i;
            rect.set(this.B0);
            matrix.set(this.D0);
        }
        final vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        vvVar.a = fw.class;
        try {
            executor.execute(new Runnable() { // from class: mx1
                @Override // java.lang.Runnable
                public final void run() {
                    nx1 nx1Var = this.b;
                    my1 my1Var3 = my1Var;
                    Matrix matrix2 = matrix;
                    my1 my1Var4 = my1Var2;
                    Rect rect2 = rect;
                    hx1 hx1Var2 = hx1Var;
                    vv vvVar2 = vvVar;
                    if (!nx1Var.L0) {
                        vvVar2.d(new t80("ImageAnalysis is detached"));
                        return;
                    }
                    du3 du3Var = new du3(my1Var4, null, new wg(my1Var3.g0().a(), my1Var3.g0().c(), nx1Var.X ? 0 : nx1Var.f, matrix2, my1Var3.g0().b()));
                    if (!rect2.isEmpty()) {
                        Rect rect3 = new Rect(rect2);
                        if (!rect3.intersect(0, 0, du3Var.Y, du3Var.Z)) {
                            rect3.setEmpty();
                        }
                        synchronized (du3Var.A) {
                        }
                    }
                    hx1Var2.l(du3Var);
                    vvVar2.b(null);
                }
            });
            vvVar.a = "analyzeImage";
            return yvVar;
        } catch (Exception e) {
            yvVar.b(e);
            return yvVar;
        }
    }

    public abstract void c();

    public final void d(my1 my1Var) {
        if (this.A != 1 && this.A != 3) {
            if (this.A == 2 && this.E0 == null) {
                this.E0 = ByteBuffer.allocateDirect(my1Var.c() * my1Var.f() * 4);
                return;
            }
            return;
        }
        ByteBuffer byteBufferAllocateDirect = this.F0;
        if (byteBufferAllocateDirect == null) {
            byteBufferAllocateDirect = ByteBuffer.allocateDirect(my1Var.c() * my1Var.f());
            this.F0 = byteBufferAllocateDirect;
        }
        byteBufferAllocateDirect.position(0);
        ByteBuffer byteBufferAllocateDirect2 = this.G0;
        if (byteBufferAllocateDirect2 == null) {
            byteBufferAllocateDirect2 = ByteBuffer.allocateDirect((my1Var.c() * my1Var.f()) / 4);
            this.G0 = byteBufferAllocateDirect2;
        }
        byteBufferAllocateDirect2.position(0);
        ByteBuffer byteBufferAllocateDirect3 = this.H0;
        if (byteBufferAllocateDirect3 == null) {
            byteBufferAllocateDirect3 = ByteBuffer.allocateDirect((my1Var.c() * my1Var.f()) / 4);
            this.H0 = byteBufferAllocateDirect3;
        }
        byteBufferAllocateDirect3.position(0);
        if (this.A == 3) {
            ByteBuffer byteBufferAllocateDirect4 = this.I0;
            if (byteBufferAllocateDirect4 == null) {
                byteBufferAllocateDirect4 = ByteBuffer.allocateDirect(my1Var.c() * my1Var.f());
                this.I0 = byteBufferAllocateDirect4;
            }
            byteBufferAllocateDirect4.position(0);
            ByteBuffer byteBufferAllocateDirect5 = this.J0;
            if (byteBufferAllocateDirect5 == null) {
                byteBufferAllocateDirect5 = ByteBuffer.allocateDirect((my1Var.c() * my1Var.f()) / 2);
                this.J0 = byteBufferAllocateDirect5;
            }
            byteBufferAllocateDirect5.position(0);
        }
    }

    public abstract void e(my1 my1Var);

    public final void f(int i, int i2, int i3, int i4) {
        int i5 = this.f;
        Matrix matrix = new Matrix();
        if (i5 > 0) {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            RectF rectF2 = kg4.a;
            Matrix.ScaleToFit scaleToFit = Matrix.ScaleToFit.FILL;
            matrix.setRectToRect(rectF, rectF2, scaleToFit);
            matrix.postRotate(i5);
            RectF rectF3 = new RectF(0.0f, 0.0f, i3, i4);
            Matrix matrix2 = new Matrix();
            matrix2.setRectToRect(rectF2, rectF3, scaleToFit);
            matrix.postConcat(matrix2);
        }
        RectF rectF4 = new RectF(this.A0);
        matrix.mapRect(rectF4);
        Rect rect = new Rect();
        rectF4.round(rect);
        this.B0 = rect;
        this.D0.setConcat(this.C0, matrix);
    }

    public final void g(my1 my1Var, int i) {
        e10 e10Var = this.y0;
        if (e10Var == null) {
            return;
        }
        e10Var.m();
        int iF = my1Var.f();
        int iC = my1Var.c();
        int iJ = this.y0.j();
        int iS = this.y0.s();
        boolean z = i == 90 || i == 270;
        int i2 = z ? iC : iF;
        if (!z) {
            iF = iC;
        }
        this.y0 = new e10(yr2.p(i2, iF, iJ, iS));
        if (this.A == 1) {
            ImageWriter imageWriter = this.z0;
            if (imageWriter != null) {
                imageWriter.close();
            }
            this.z0 = ImageWriter.newInstance(this.y0.getSurface(), this.y0.s());
        }
    }

    public final void h(Executor executor, hx1 hx1Var) {
        if (hx1Var == null) {
            c();
        }
        synchronized (this.K0) {
            this.b = hx1Var;
            this.Z = executor;
        }
    }

    public final void i(e10 e10Var) {
        synchronized (this.K0) {
            this.y0 = e10Var;
        }
    }

    public final void j(Matrix matrix) {
        synchronized (this.K0) {
            this.C0 = matrix;
            this.D0 = new Matrix(this.C0);
        }
    }

    public final void k(Rect rect) {
        synchronized (this.K0) {
            this.A0 = rect;
            this.B0 = new Rect(this.A0);
        }
    }

    @Override // defpackage.ny1
    public final void o(oy1 oy1Var) {
        try {
            my1 my1VarA = a(oy1Var);
            if (my1VarA != null) {
                e(my1VarA);
            }
        } catch (IllegalStateException e) {
            ez4.r("ImageAnalysisAnalyzer", "Failed to acquire image.", e);
        }
    }
}
