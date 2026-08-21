package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xg {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public xg(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof xg) {
            xg xgVar = (xg) obj;
            if (Float.floatToIntBits(this.a) == Float.floatToIntBits(xgVar.a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(xgVar.b) && Float.floatToIntBits(this.c) == Float.floatToIntBits(xgVar.c) && Float.floatToIntBits(this.d) == Float.floatToIntBits(xgVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.d) ^ ((((((Float.floatToIntBits(this.a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.b)) * 1000003) ^ Float.floatToIntBits(this.c)) * 1000003);
    }

    public final String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.a + ", maxZoomRatio=" + this.b + ", minZoomRatio=" + this.c + ", linearZoom=" + this.d + "}";
    }
}
