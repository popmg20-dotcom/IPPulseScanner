package defpackage;

import android.util.Size;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ph {
    public final Size a;
    public final HashMap b;
    public final Size c;
    public final HashMap d;
    public final Size e;
    public final HashMap f;
    public final HashMap g;
    public final HashMap h;
    public final HashMap i;

    public ph(Size size, HashMap map, Size size2, HashMap map2, Size size3, HashMap map3, HashMap map4, HashMap map5, HashMap map6) {
        if (size == null) {
            zo2.n("Null analysisSize");
            throw null;
        }
        this.a = size;
        this.b = map;
        if (size2 == null) {
            zo2.n("Null previewSize");
            throw null;
        }
        this.c = size2;
        this.d = map2;
        if (size3 == null) {
            zo2.n("Null recordSize");
            throw null;
        }
        this.e = size3;
        this.f = map3;
        this.g = map4;
        this.h = map5;
        this.i = map6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ph)) {
            return false;
        }
        ph phVar = (ph) obj;
        return this.a.equals(phVar.a) && this.b.equals(phVar.b) && this.c.equals(phVar.c) && this.d.equals(phVar.d) && this.e.equals(phVar.e) && this.f.equals(phVar.f) && this.g.equals(phVar.g) && this.h.equals(phVar.h) && this.i.equals(phVar.i);
    }

    public final int hashCode() {
        return this.i.hashCode() ^ ((((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003);
    }

    public final String toString() {
        return "SurfaceSizeDefinition{analysisSize=" + this.a + ", s720pSizeMap=" + this.b + ", previewSize=" + this.c + ", s1440pSizeMap=" + this.d + ", recordSize=" + this.e + ", maximumSizeMap=" + this.f + ", maximum4x3SizeMap=" + this.g + ", maximum16x9SizeMap=" + this.h + ", ultraMaximumSizeMap=" + this.i + "}";
    }
}
