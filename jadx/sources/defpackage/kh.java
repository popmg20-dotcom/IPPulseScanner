package defpackage;

import android.util.Range;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kh {
    public final int a;
    public final boolean b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final Range i;
    public final boolean j;

    public kh(int i, boolean z, int i2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Range range, boolean z7) {
        this.a = i;
        this.b = z;
        this.c = i2;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = z6;
        if (range == null) {
            zo2.n("Null getTargetFpsRange");
            throw null;
        }
        this.i = range;
        this.j = z7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kh)) {
            return false;
        }
        kh khVar = (kh) obj;
        return this.a == khVar.a && this.b == khVar.b && this.c == khVar.c && this.d == khVar.d && this.e == khVar.e && this.f == khVar.f && this.g == khVar.g && this.h == khVar.h && this.i.equals(khVar.i) && this.j == khVar.j;
    }

    public final int hashCode() {
        return ((((((((((((((((((this.a ^ 1000003) * 1000003) ^ (this.b ? 1231 : 1237)) * 1000003) ^ this.c) * 1000003) ^ (this.d ? 1231 : 1237)) * 1000003) ^ (this.e ? 1231 : 1237)) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ (this.g ? 1231 : 1237)) * 1000003) ^ (this.h ? 1231 : 1237)) * 1000003) ^ this.i.hashCode()) * 1000003) ^ (this.j ? 1231 : 1237);
    }

    public final String toString() {
        return "FeatureSettings{getCameraMode=" + this.a + ", hasVideoCapture=" + this.b + ", getRequiredMaxBitDepth=" + this.c + ", isPreviewStabilizationOn=" + this.d + ", isUltraHdrOn=" + this.e + ", isHighSpeedOn=" + this.f + ", isFeatureComboInvocation=" + this.g + ", requiresFeatureComboQuery=" + this.h + ", getTargetFpsRange=" + this.i + ", isStrictFpsRequired=" + this.j + "}";
    }
}
