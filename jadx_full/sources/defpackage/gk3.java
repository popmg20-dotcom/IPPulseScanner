package defpackage;

import android.content.res.Resources;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gk3 {
    public final Resources a;
    public final Resources.Theme b;

    public gk3(Resources resources, Resources.Theme theme) {
        this.a = resources;
        this.b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && gk3.class == obj.getClass()) {
            gk3 gk3Var = (gk3) obj;
            if (this.a.equals(gk3Var.a) && Objects.equals(this.b, gk3Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b);
    }
}
