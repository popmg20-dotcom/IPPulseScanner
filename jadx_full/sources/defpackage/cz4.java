package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cz4 {
    public float a;
    public final float b;
    public final float c;
    public float d;

    public cz4(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    public final float a() {
        return this.d;
    }

    public final float b() {
        return this.b;
    }

    public final float c() {
        return this.c;
    }

    public final float d() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() {
        float f = 1.0f;
        float f2 = this.b;
        float f3 = this.c;
        if (1.0f > f2 || 1.0f < f3) {
            throw new IllegalArgumentException("Requested zoomRatio 1.0 is not within valid range [" + f3 + " , " + f2 + "]");
        }
        this.a = 1.0f;
        if (f2 != f3) {
            if (1.0f != f2) {
                if (1.0f == f3) {
                    f = 0.0f;
                } else {
                    float f4 = 1.0f / f3;
                    f = (1.0f - f4) / ((1.0f / f2) - f4);
                }
            }
        }
        this.d = f;
    }
}
