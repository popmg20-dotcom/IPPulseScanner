package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g6 implements ye0 {
    public final ye0 a;
    public final float b;

    public g6(float f, ye0 ye0Var) {
        while (ye0Var instanceof g6) {
            ye0Var = ((g6) ye0Var).a;
            f += ((g6) ye0Var).b;
        }
        this.a = ye0Var;
        this.b = f;
    }

    @Override // defpackage.ye0
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g6)) {
            return false;
        }
        g6 g6Var = (g6) obj;
        return this.a.equals(g6Var.a) && this.b == g6Var.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }
}
