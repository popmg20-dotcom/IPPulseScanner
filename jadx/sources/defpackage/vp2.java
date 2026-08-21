package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vp2 {
    public final int a;
    public final float b;
    public final float c;
    public final float d;
    public final long e;

    public vp2(float f, float f2, float f3, int i, long j) {
        this.a = i;
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && vp2.class == obj.getClass()) {
            vp2 vp2Var = (vp2) obj;
            return this.c == vp2Var.c && this.d == vp2Var.d && this.b == vp2Var.b && this.a == vp2Var.a && this.e == vp2Var.e;
        }
        return false;
    }

    public final int hashCode() {
        int iFloatToIntBits = (((Float.floatToIntBits(this.b) + ((Float.floatToIntBits(this.d) + (Float.floatToIntBits(this.c) * 31)) * 31)) * 31) + this.a) * 31;
        long j = this.e;
        return iFloatToIntBits + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "NavigationEvent(touchX=" + this.c + ", touchY=" + this.d + ", progress=" + this.b + ", swipeEdge=" + this.a + ", frameTimeMillis=" + this.e + ')';
    }
}
