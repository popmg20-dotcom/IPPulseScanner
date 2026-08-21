package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fh {
    public final dn0 a;
    public final List b;
    public final int c;
    public final int d;
    public final oz0 e;

    public fh(dn0 dn0Var, List list, int i, int i2, oz0 oz0Var) {
        this.a = dn0Var;
        this.b = list;
        this.c = i;
        this.d = i2;
        this.e = oz0Var;
    }

    public static v92 a(dn0 dn0Var) {
        v92 v92Var = new v92();
        if (dn0Var == null) {
            zo2.n("Null surface");
            return null;
        }
        v92Var.b = dn0Var;
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            zo2.n("Null sharedSurfaces");
            return null;
        }
        v92Var.f = list;
        v92Var.z = -1;
        v92Var.A = -1;
        v92Var.X = oz0.d;
        return v92Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fh)) {
            return false;
        }
        fh fhVar = (fh) obj;
        return this.a.equals(fhVar.a) && this.b.equals(fhVar.b) && this.c == fhVar.c && this.d == fhVar.d && this.e.equals(fhVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() ^ ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * (-721379959)) ^ this.c) * 1000003) ^ this.d) * 1000003);
    }

    public final String toString() {
        return "OutputConfig{surface=" + this.a + ", sharedSurfaces=" + this.b + ", physicalCameraId=null, mirrorMode=" + this.c + ", surfaceGroupId=" + this.d + ", dynamicRange=" + this.e + "}";
    }
}
