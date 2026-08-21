package defpackage;

import android.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s21 extends u21 {
    public final int b;

    public s21(int i) {
        this.b = i;
        if (Color.alpha(i) == 255) {
            return;
        }
        xe.k("Background color must be opaque");
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s21) {
            return this.b == ((s21) obj).b;
        }
        return false;
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        return "ColorBackground{color:" + Integer.toHexString(this.b) + '}';
    }
}
