package defpackage;

import android.content.pm.PackageInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xs {
    public final PackageInfo a;
    public final CharSequence b;
    public boolean c;

    public xs(PackageInfo packageInfo, CharSequence charSequence, boolean z) {
        this.a = packageInfo;
        this.b = charSequence;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xs)) {
            return false;
        }
        xs xsVar = (xs) obj;
        return this.a.equals(xsVar.a) && this.b.equals(xsVar.b) && this.c == xsVar.c;
    }

    public final int hashCode() {
        return ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31) + (this.c ? 1231 : 1237);
    }

    public final String toString() {
        return "BypassApp(info=" + this.a + ", label=" + ((Object) this.b) + ", checked=" + this.c + ")";
    }
}
