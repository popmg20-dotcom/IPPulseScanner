package defpackage;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import j$.util.Objects;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vy0 extends bw2 {
    public int n = -1;
    public int o = -1;
    public final lb p;
    public final lb q;

    public vy0(lb lbVar, lb lbVar2) {
        this.p = lbVar;
        this.q = lbVar2;
    }

    @Override // defpackage.bw2
    public final tg e(oz0 oz0Var) throws Throwable {
        Map map = Collections.EMPTY_MAP;
        tg tgVarE = super.e(oz0Var);
        this.n = gn1.h();
        this.o = gn1.h();
        return tgVarE;
    }

    public final void l(long j, Surface surface, d74 d74Var, SurfaceTexture surfaceTexture, SurfaceTexture surfaceTexture2) {
        gn1.d(this.a, true);
        gn1.c(this.c);
        HashMap map = this.b;
        r25.j("The surface is not registered.", map.containsKey(surface));
        ch chVarB = (ch) map.get(surface);
        Objects.requireNonNull(chVarB);
        if (chVarB == gn1.j) {
            chVarB = b(surface);
            if (chVarB == null) {
                return;
            } else {
                map.put(surface, chVarB);
            }
        }
        ch chVar = chVarB;
        EGLSurface eGLSurface = chVar.a;
        if (surface != this.i) {
            f(eGLSurface);
            this.i = surface;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        m(chVar, d74Var, surfaceTexture, this.p, this.n, true);
        m(chVar, d74Var, surfaceTexture2, this.q, this.o, false);
        EGLExt.eglPresentationTimeANDROID(this.d, eGLSurface, j);
        if (EGL14.eglSwapBuffers(this.d, eGLSurface)) {
            return;
        }
        ez4.a0("DualOpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        i(surface, false);
    }

    public final void m(ch chVar, d74 d74Var, SurfaceTexture surfaceTexture, lb lbVar, int i, boolean z) {
        k(i);
        int i2 = chVar.b;
        int i3 = chVar.c;
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glScissor(0, 0, i2, i3);
        float[] fArr = new float[16];
        surfaceTexture.getTransformMatrix(fArr);
        float[] fArr2 = new float[16];
        Matrix.multiplyMM(fArr2, 0, fArr, 0, z ? d74Var.X : d74Var.Y, 0);
        en1 en1Var = this.k;
        en1Var.getClass();
        if (en1Var instanceof fn1) {
            GLES20.glUniformMatrix4fv(((fn1) en1Var).f, 1, false, fArr2, 0);
            gn1.b("glUniformMatrix4fv");
        }
        f03 f03Var = (f03) lbVar.z;
        Object obj = f03Var.a;
        Object obj2 = f03Var.b;
        Size size = new Size((int) (((Float) f03Var.a).floatValue() * i2), (int) (((Float) obj2).floatValue() * i3));
        Size size2 = new Size(i2, i3);
        float[] fArr3 = new float[16];
        Matrix.setIdentityM(fArr3, 0);
        float[] fArr4 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        float[] fArr5 = new float[16];
        Matrix.setIdentityM(fArr5, 0);
        Matrix.scaleM(fArr3, 0, size.getWidth() / size2.getWidth(), size.getHeight() / size2.getHeight(), 1.0f);
        f03 f03Var2 = (f03) lbVar.f;
        if (((Float) obj).floatValue() != 0.0f || ((Float) obj2).floatValue() != 0.0f) {
            Matrix.translateM(fArr4, 0, ((Float) f03Var2.a).floatValue() / ((Float) obj).floatValue(), ((Float) f03Var2.b).floatValue() / ((Float) obj2).floatValue(), 0.0f);
        }
        Matrix.multiplyMM(fArr5, 0, fArr3, 0, fArr4, 0);
        GLES20.glUniformMatrix4fv(en1Var.b, 1, false, fArr5, 0);
        gn1.b("glUniformMatrix4fv");
        GLES20.glUniform1f(en1Var.c, 1.0f);
        gn1.b("glUniform1f");
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GLES20.glDrawArrays(5, 0, 4);
        gn1.b("glDrawArrays");
        GLES20.glDisable(3042);
    }
}
