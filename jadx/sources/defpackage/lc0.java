package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lc0 {
    public final Uri a;
    public final boolean b;

    public lc0(Uri uri, boolean z) {
        this.a = uri;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!lc0.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        lc0 lc0Var = (lc0) obj;
        return this.a.equals(lc0Var.a) && this.b == lc0Var.b;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + (this.b ? 1231 : 1237);
    }
}
