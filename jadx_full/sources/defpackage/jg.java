package defpackage;

import android.util.Range;
import android.util.Size;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jg {
    public final w64 a;
    public final int b;
    public final Size c;
    public final oz0 d;
    public final List e;
    public final ka0 f;
    public final int g;
    public final Range h;
    public final boolean i;

    public jg(w64 w64Var, int i, Size size, oz0 oz0Var, List list, ka0 ka0Var, int i2, Range range, boolean z) {
        this.a = w64Var;
        this.b = i;
        if (size == null) {
            zo2.n("Null size");
            throw null;
        }
        this.c = size;
        if (oz0Var == null) {
            zo2.n("Null dynamicRange");
            throw null;
        }
        this.d = oz0Var;
        if (list == null) {
            zo2.n("Null captureTypes");
            throw null;
        }
        this.e = list;
        this.f = ka0Var;
        this.g = i2;
        if (range == null) {
            zo2.n("Null targetFrameRate");
            throw null;
        }
        this.h = range;
        this.i = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof jg)) {
            return false;
        }
        jg jgVar = (jg) obj;
        if (!this.a.equals(jgVar.a) || this.b != jgVar.b || !this.c.equals(jgVar.c) || !this.d.equals(jgVar.d) || !this.e.equals(jgVar.e)) {
            return false;
        }
        ka0 ka0Var = jgVar.f;
        ka0 ka0Var2 = this.f;
        if (ka0Var2 == null) {
            if (ka0Var != null) {
                return false;
            }
        } else if (!ka0Var2.equals(ka0Var)) {
            return false;
        }
        return this.g == jgVar.g && this.h.equals(jgVar.h) && this.i == jgVar.i;
    }

    public final int hashCode() {
        int iHashCode = (((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003;
        ka0 ka0Var = this.f;
        return (this.i ? 1231 : 1237) ^ ((((((iHashCode ^ (ka0Var == null ? 0 : ka0Var.hashCode())) * 1000003) ^ this.g) * 1000003) ^ this.h.hashCode()) * 1000003);
    }

    public final String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.a + ", imageFormat=" + this.b + ", size=" + this.c + ", dynamicRange=" + this.d + ", captureTypes=" + this.e + ", implementationOptions=" + this.f + ", sessionType=" + this.g + ", targetFrameRate=" + this.h + ", strictFrameRateRequired=" + this.i + "}";
    }
}
