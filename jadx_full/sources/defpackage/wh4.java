package defpackage;

import android.util.Size;
import android.view.Surface;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wh4 implements Serializable {
    public final Object b;
    public final Object f;
    public final float[] z;

    public wh4(Surface surface, Size size, Object obj) {
        this.b = surface;
        this.f = size;
        this.z = (float[]) obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wh4)) {
            return false;
        }
        wh4 wh4Var = (wh4) obj;
        return n12.c(this.b, wh4Var.b) && n12.c(this.f, wh4Var.f) && this.z.equals(wh4Var.z);
    }

    public final int hashCode() {
        Object obj = this.b;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f;
        return this.z.hashCode() + ((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "(" + this.b + ", " + this.f + ", " + this.z + ')';
    }
}
