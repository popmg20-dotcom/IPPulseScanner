package defpackage;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import j$.util.Objects;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class bw2 {
    public Thread c;
    public EGLConfig g;
    public Surface i;
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final HashMap b = new HashMap();
    public EGLDisplay d = EGL14.EGL_NO_DISPLAY;
    public EGLContext e = EGL14.EGL_NO_CONTEXT;
    public int[] f = gn1.a;
    public EGLSurface h = EGL14.EGL_NO_SURFACE;
    public Map j = Collections.EMPTY_MAP;
    public en1 k = null;
    public dn1 l = dn1.b;
    public int m = -1;

    public final void a(oz0 oz0Var, iv1 iv1Var) {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.d = eGLDisplayEglGetDisplay;
        if (Objects.equals(eGLDisplayEglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            xe.q("Unable to get EGL14 display");
            return;
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.d, iArr, 0, iArr, 1)) {
            this.d = EGL14.EGL_NO_DISPLAY;
            xe.q("Unable to initialize EGL14");
            return;
        }
        if (iv1Var != null) {
            iv1Var.z = iArr[0] + "." + iArr[1];
        }
        int i = oz0Var.a() ? 10 : 8;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.d, new int[]{12324, i, 12323, i, 12322, i, 12321, oz0Var.a() ? 2 : 8, 12325, 0, 12326, 0, 12352, oz0Var.a() ? 64 : 4, 12610, oz0Var.a() ? -1 : 1, 12339, 5, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            xe.q("Unable to find a suitable EGLConfig");
            return;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.d, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, oz0Var.a() ? 3 : 2, 12344}, 0);
        gn1.a("eglCreateContext");
        this.g = eGLConfig;
        this.e = eGLContextEglCreateContext;
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.d, eGLContextEglCreateContext, 12440, iArr2, 0);
        Log.d("OpenGlRenderer", "EGLContext created, client version " + iArr2[0]);
    }

    public final ch b(Surface surface) {
        try {
            EGLDisplay eGLDisplay = this.d;
            EGLConfig eGLConfig = this.g;
            Objects.requireNonNull(eGLConfig);
            EGLSurface eGLSurfaceI = gn1.i(eGLDisplay, eGLConfig, surface, this.f);
            EGLDisplay eGLDisplay2 = this.d;
            int[] iArr = new int[1];
            EGL14.eglQuerySurface(eGLDisplay2, eGLSurfaceI, 12375, iArr, 0);
            int i = iArr[0];
            int[] iArr2 = new int[1];
            EGL14.eglQuerySurface(eGLDisplay2, eGLSurfaceI, 12374, iArr2, 0);
            Size size = new Size(i, iArr2[0]);
            return new ch(eGLSurfaceI, size.getWidth(), size.getHeight());
        } catch (IllegalArgumentException | IllegalStateException e) {
            ez4.b0("OpenGlRenderer", "Failed to create EGL surface: " + e.getMessage(), e);
            return null;
        }
    }

    public final void c() {
        EGLDisplay eGLDisplay = this.d;
        EGLConfig eGLConfig = this.g;
        Objects.requireNonNull(eGLConfig);
        int[] iArr = gn1.a;
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, 1, 12374, 1, 12344}, 0);
        gn1.a("eglCreatePbufferSurface");
        if (eGLSurfaceEglCreatePbufferSurface != null) {
            this.h = eGLSurfaceEglCreatePbufferSurface;
        } else {
            xe.q("surface was null");
        }
    }

    public final f03 d(oz0 oz0Var) {
        gn1.d(this.a, false);
        try {
            a(oz0Var, null);
            c();
            f(this.h);
            String strGlGetString = GLES20.glGetString(7939);
            String strEglQueryString = EGL14.eglQueryString(this.d, 12373);
            if (strGlGetString == null) {
                strGlGetString = "";
            }
            if (strEglQueryString == null) {
                strEglQueryString = "";
            }
            return new f03(strGlGetString, strEglQueryString);
        } catch (IllegalStateException e) {
            ez4.b0("OpenGlRenderer", "Failed to get GL or EGL extensions: " + e.getMessage(), e);
            return new f03("", "");
        } finally {
            h();
        }
    }

    public tg e(oz0 oz0Var) throws Throwable {
        Map map = Collections.EMPTY_MAP;
        AtomicBoolean atomicBoolean = this.a;
        gn1.d(atomicBoolean, false);
        iv1 iv1Var = new iv1(2, false);
        iv1Var.f = "0.0";
        iv1Var.z = "0.0";
        iv1Var.A = "";
        iv1Var.X = "";
        try {
            if (oz0Var.a()) {
                f03 f03VarD = d(oz0Var);
                String str = (String) f03VarD.a;
                String str2 = (String) f03VarD.b;
                if (!str.contains("GL_EXT_YUV_target")) {
                    ez4.a0("OpenGlRenderer", "Device does not support GL_EXT_YUV_target. Fallback to SDR.");
                    oz0Var = oz0.d;
                }
                this.f = gn1.f(str2, oz0Var);
                iv1Var.A = str;
                iv1Var.X = str2;
            }
            a(oz0Var, iv1Var);
            c();
            f(this.h);
            iv1Var.f = gn1.j();
            this.j = gn1.g(oz0Var);
            int iH = gn1.h();
            this.m = iH;
            k(iH);
            this.c = Thread.currentThread();
            atomicBoolean.set(true);
            if ("".isEmpty()) {
                return new tg((String) iv1Var.f, (String) iv1Var.z, (String) iv1Var.A, (String) iv1Var.X);
            }
            xe.q("Missing required properties:".concat(""));
            return null;
        } catch (IllegalArgumentException e) {
            e = e;
            h();
            throw e;
        } catch (IllegalStateException e2) {
            e = e2;
            h();
            throw e;
        }
    }

    public final void f(EGLSurface eGLSurface) {
        this.d.getClass();
        this.e.getClass();
        if (EGL14.eglMakeCurrent(this.d, eGLSurface, eGLSurface, this.e)) {
            return;
        }
        xe.q("eglMakeCurrent failed");
    }

    public final void g(Surface surface) {
        gn1.d(this.a, true);
        gn1.c(this.c);
        HashMap map = this.b;
        if (map.containsKey(surface)) {
            return;
        }
        map.put(surface, gn1.j);
    }

    public final void h() {
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            GLES20.glDeleteProgram(((en1) it.next()).a);
        }
        this.j = Collections.EMPTY_MAP;
        this.k = null;
        if (!Objects.equals(this.d, EGL14.EGL_NO_DISPLAY)) {
            EGLDisplay eGLDisplay = this.d;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            HashMap map = this.b;
            for (ch chVar : map.values()) {
                if (!Objects.equals(chVar.a, EGL14.EGL_NO_SURFACE) && !EGL14.eglDestroySurface(this.d, chVar.a)) {
                    try {
                        gn1.a("eglDestroySurface");
                    } catch (IllegalStateException e) {
                        ez4.r("GLUtils", e.toString(), e);
                    }
                }
            }
            map.clear();
            if (!Objects.equals(this.h, EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.d, this.h);
                this.h = EGL14.EGL_NO_SURFACE;
            }
            if (!Objects.equals(this.e, EGL14.EGL_NO_CONTEXT)) {
                EGL14.eglDestroyContext(this.d, this.e);
                this.e = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.d);
            this.d = EGL14.EGL_NO_DISPLAY;
        }
        this.g = null;
        this.m = -1;
        this.l = dn1.b;
        this.i = null;
        this.c = null;
    }

    public final void i(Surface surface, boolean z) {
        if (this.i == surface) {
            this.i = null;
            f(this.h);
        }
        HashMap map = this.b;
        ch chVar = z ? (ch) map.remove(surface) : (ch) map.put(surface, gn1.j);
        if (chVar == null || chVar == gn1.j) {
            return;
        }
        try {
            EGL14.eglDestroySurface(this.d, chVar.a);
        } catch (RuntimeException e) {
            ez4.b0("OpenGlRenderer", "Failed to destroy EGL surface: " + e.getMessage(), e);
        }
    }

    public final void j(long j, float[] fArr, Surface surface) {
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
        int i = chVarB.c;
        int i2 = chVarB.b;
        EGLSurface eGLSurface = chVarB.a;
        if (surface != this.i) {
            f(eGLSurface);
            this.i = surface;
            GLES20.glViewport(0, 0, i2, i);
            GLES20.glScissor(0, 0, i2, i);
        }
        en1 en1Var = this.k;
        en1Var.getClass();
        if (en1Var instanceof fn1) {
            GLES20.glUniformMatrix4fv(((fn1) en1Var).f, 1, false, fArr, 0);
            gn1.b("glUniformMatrix4fv");
        }
        GLES20.glDrawArrays(5, 0, 4);
        gn1.b("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID(this.d, eGLSurface, j);
        if (EGL14.eglSwapBuffers(this.d, eGLSurface)) {
            return;
        }
        ez4.a0("OpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        i(surface, false);
    }

    public final void k(int i) {
        en1 en1Var = (en1) this.j.get(this.l);
        if (en1Var == null) {
            zo2.v(this.l, "Unable to configure program for input format: ");
            return;
        }
        if (this.k != en1Var) {
            this.k = en1Var;
            en1Var.b();
            Log.d("OpenGlRenderer", "Using program for input format " + this.l + ": " + this.k);
        }
        GLES20.glActiveTexture(33984);
        gn1.b("glActiveTexture");
        GLES20.glBindTexture(36197, i);
        gn1.b("glBindTexture");
    }
}
