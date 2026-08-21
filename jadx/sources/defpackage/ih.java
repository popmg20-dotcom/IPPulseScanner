package defpackage;

import android.util.Range;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ih {
    public static final Range h = new Range(0, 0);
    public final Size a;
    public final Size b;
    public final oz0 c;
    public final int d;
    public final Range e;
    public final ka0 f;
    public final boolean g;

    public ih(Size size, Size size2, oz0 oz0Var, int i, Range range, ka0 ka0Var, boolean z) {
        this.a = size;
        this.b = size2;
        this.c = oz0Var;
        this.d = i;
        this.e = range;
        this.f = ka0Var;
        this.g = z;
    }

    public static r90 a(Size size) {
        r90 r90Var = new r90();
        if (size == null) {
            zo2.n("Null resolution");
            return null;
        }
        r90Var.a = size;
        r90Var.b = size;
        r90Var.d = 0;
        Range range = h;
        if (range == null) {
            zo2.n("Null expectedFrameRateRange");
            return null;
        }
        r90Var.e = range;
        r90Var.c = oz0.d;
        r90Var.g = Boolean.FALSE;
        return r90Var;
    }

    public final r90 b() {
        r90 r90Var = new r90();
        r90Var.a = this.a;
        r90Var.b = this.b;
        r90Var.c = this.c;
        r90Var.d = Integer.valueOf(this.d);
        r90Var.e = this.e;
        r90Var.f = this.f;
        r90Var.g = Boolean.valueOf(this.g);
        return r90Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ih) {
            ih ihVar = (ih) obj;
            if (this.a.equals(ihVar.a) && this.b.equals(ihVar.b) && this.c.equals(ihVar.c) && this.d == ihVar.d && this.e.equals(ihVar.e)) {
                ka0 ka0Var = ihVar.f;
                ka0 ka0Var2 = this.f;
                if (ka0Var2 != null ? ka0Var2.equals(ka0Var) : ka0Var == null) {
                    if (this.g == ihVar.g) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode()) * 1000003;
        ka0 ka0Var = this.f;
        return (this.g ? 1231 : 1237) ^ ((iHashCode ^ (ka0Var == null ? 0 : ka0Var.hashCode())) * 1000003);
    }

    public final String toString() {
        return "StreamSpec{resolution=" + this.a + ", originalConfiguredResolution=" + this.b + ", dynamicRange=" + this.c + ", sessionType=" + this.d + ", expectedFrameRateRange=" + this.e + ", implementationOptions=" + this.f + ", zslDisabled=" + this.g + "}";
    }
}
