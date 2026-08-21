package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gw0 extends hw0 {
    public final float b;
    public final float c;

    public gw0(float f, float f2) {
        this.b = f;
        this.c = f2;
        if (f <= 0.0d || f >= 1.0d) {
            xe.k("minRatio must be in the interval (0.0, 1.0)");
            throw null;
        }
        if (f2 <= 0.0d || f2 >= 1.0d) {
            xe.k("maxRatio must be in the interval (0.0, 1.0)");
            throw null;
        }
        if (f <= f2) {
            return;
        }
        xe.k("minRatio must be less than or equal to maxRatio");
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gw0)) {
            return false;
        }
        gw0 gw0Var = (gw0) obj;
        return this.b == gw0Var.b && this.c == gw0Var.c;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.c) + (Float.floatToIntBits(this.b) * 31);
    }

    public final String toString() {
        return "SplitRatioDragRange[" + this.b + ", " + this.c + ']';
    }
}
