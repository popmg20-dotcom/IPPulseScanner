package defpackage;

import android.content.ComponentName;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f4 {
    public final String a;
    public final String b;

    public f4(ComponentName componentName) {
        String packageName = componentName.getPackageName();
        packageName.getClass();
        String className = componentName.getClassName();
        className.getClass();
        this.a = packageName;
        this.b = className;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!f4.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        f4 f4Var = (f4) obj;
        return this.a.equals(f4Var.a) && this.b.equals(f4Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ClassInfo { packageName: ");
        sb.append(this.a);
        sb.append(", className: ");
        return fw.y(sb, this.b, " }");
    }
}
