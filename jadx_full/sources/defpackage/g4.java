package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g4 {
    public final f4 a;
    public final String b;

    public g4(ComponentName componentName, String str) {
        f4 f4Var = new f4(componentName);
        this.a = f4Var;
        this.b = str;
        ji0.Y(f4Var.a, f4Var.b);
    }

    public final boolean a(Activity activity) {
        if (!ji0.y(activity, this.a)) {
            return false;
        }
        String str = this.b;
        if (str == null) {
            return true;
        }
        Intent intent = activity.getIntent();
        return str.equals(intent != null ? intent.getAction() : null);
    }

    public final boolean b(Intent intent) {
        if (!ji0.z(intent, this.a)) {
            return false;
        }
        String str = this.b;
        return str == null || str.equals(intent.getAction());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g4)) {
            return false;
        }
        g4 g4Var = (g4) obj;
        return this.a.equals(g4Var.a) && n12.c(this.b, g4Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ActivityFilter(componentName=");
        sb.append(this.a);
        sb.append(", intentAction=");
        return fw.x(sb, this.b, ')');
    }
}
