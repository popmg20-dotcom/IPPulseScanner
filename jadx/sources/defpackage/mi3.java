package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mi3 implements ye0 {
    public final float a;

    public mi3(float f) {
        this.a = f;
    }

    public static mi3 b(RectF rectF, ye0 ye0Var) {
        return ye0Var instanceof mi3 ? (mi3) ye0Var : new mi3(ye0Var.a(rectF) / Math.min(rectF.width(), rectF.height()));
    }

    @Override // defpackage.ye0
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof mi3) && this.a == ((mi3) obj).a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }

    public final String toString() {
        return fw.w("%", new StringBuilder(), (int) (this.a * 100.0f));
    }
}
