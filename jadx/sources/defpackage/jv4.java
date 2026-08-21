package defpackage;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jv4 {
    public final yo a;
    public final float b;

    public jv4(Rect rect, float f) {
        this.a = new yo(rect);
        this.b = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!jv4.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        jv4 jv4Var = (jv4) obj;
        return n12.c(this.a, jv4Var.a) && this.b == jv4Var.b;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "WindowMetrics(_bounds=" + this.a + ", density=" + this.b + ')';
    }

    public jv4(yo yoVar, float f) {
        this.a = yoVar;
        this.b = f;
    }
}
