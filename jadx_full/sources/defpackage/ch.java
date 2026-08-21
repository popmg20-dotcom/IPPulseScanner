package defpackage;

import android.opengl.EGLSurface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ch {
    public final EGLSurface a;
    public final int b;
    public final int c;

    public ch(EGLSurface eGLSurface, int i, int i2) {
        if (eGLSurface == null) {
            zo2.n("Null eglSurface");
            throw null;
        }
        this.a = eGLSurface;
        this.b = i;
        this.c = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ch) {
            ch chVar = (ch) obj;
            if (this.a.equals(chVar.a) && this.b == chVar.b && this.c == chVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c ^ ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OutputSurface{eglSurface=");
        sb.append(this.a);
        sb.append(", width=");
        sb.append(this.b);
        sb.append(", height=");
        return fw.w("}", sb, this.c);
    }
}
