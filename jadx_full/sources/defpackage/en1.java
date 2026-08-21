package defpackage;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class en1 {
    public final int a;
    public int b = -1;
    public int c = -1;
    public int d = -1;

    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public en1(String str, String str2) throws Throwable {
        int iK;
        int iK2;
        int iGlCreateProgram;
        try {
            iK = gn1.k(35633, str);
        } catch (IllegalArgumentException | IllegalStateException e) {
            e = e;
            iK = -1;
            iK2 = -1;
        }
        try {
            iK2 = gn1.k(35632, str2);
            try {
                iGlCreateProgram = GLES20.glCreateProgram();
            } catch (IllegalArgumentException | IllegalStateException e2) {
                e = e2;
                iGlCreateProgram = -1;
            }
            try {
                gn1.b("glCreateProgram");
                GLES20.glAttachShader(iGlCreateProgram, iK);
                gn1.b("glAttachShader");
                GLES20.glAttachShader(iGlCreateProgram, iK2);
                gn1.b("glAttachShader");
                GLES20.glLinkProgram(iGlCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
                if (iArr[0] == 1) {
                    this.a = iGlCreateProgram;
                    a();
                } else {
                    throw new IllegalStateException("Could not link program: " + GLES20.glGetProgramInfoLog(iGlCreateProgram));
                }
            } catch (IllegalArgumentException e3) {
                e = e3;
                if (iK != -1) {
                    GLES20.glDeleteShader(iK);
                }
                if (iK2 != -1) {
                    GLES20.glDeleteShader(iK2);
                }
                if (iGlCreateProgram != -1) {
                    GLES20.glDeleteProgram(iGlCreateProgram);
                }
                throw e;
            } catch (IllegalStateException e4) {
                e = e4;
                if (iK != -1) {
                }
                if (iK2 != -1) {
                }
                if (iGlCreateProgram != -1) {
                }
                throw e;
            }
        } catch (IllegalArgumentException | IllegalStateException e5) {
            e = e5;
            iK2 = -1;
            iGlCreateProgram = iK2;
            if (iK != -1) {
            }
            if (iK2 != -1) {
            }
            if (iGlCreateProgram != -1) {
            }
            throw e;
        }
    }

    public final void a() {
        int i = this.a;
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(i, "aPosition");
        this.d = iGlGetAttribLocation;
        gn1.e(iGlGetAttribLocation, "aPosition");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(i, "uTransMatrix");
        this.b = iGlGetUniformLocation;
        gn1.e(iGlGetUniformLocation, "uTransMatrix");
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(i, "uAlphaScale");
        this.c = iGlGetUniformLocation2;
        gn1.e(iGlGetUniformLocation2, "uAlphaScale");
    }

    public void b() {
        GLES20.glUseProgram(this.a);
        gn1.b("glUseProgram");
        GLES20.glEnableVertexAttribArray(this.d);
        gn1.b("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, (Buffer) gn1.h);
        gn1.b("glVertexAttribPointer");
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        GLES20.glUniformMatrix4fv(this.b, 1, false, fArr, 0);
        gn1.b("glUniformMatrix4fv");
        GLES20.glUniform1f(this.c, 1.0f);
        gn1.b("glUniform1f");
    }
}
