package defpackage;

import android.os.Build;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ax2 {
    public final jx2 a;

    public ax2(int i, Surface surface) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            this.a = new hx2(i, surface);
            return;
        }
        if (i2 >= 28) {
            this.a = new gx2(i, surface);
            return;
        }
        if (i2 >= 26) {
            this.a = new ex2(i, surface);
        } else if (i2 >= 24) {
            this.a = new cx2(i, surface);
        } else {
            this.a = new jx2(surface);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ax2)) {
            return false;
        }
        return this.a.equals(((ax2) obj).a);
    }

    public final int hashCode() {
        return this.a.a.hashCode();
    }

    public ax2(cx2 cx2Var) {
        this.a = cx2Var;
    }
}
