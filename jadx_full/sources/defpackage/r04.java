package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r04 {
    public final f4 a;
    public final f4 b;
    public final String c;

    public r04(ComponentName componentName, ComponentName componentName2, String str) {
        f4 f4Var = new f4(componentName);
        f4 f4Var2 = new f4(componentName2);
        this.a = f4Var;
        this.b = f4Var2;
        this.c = str;
        ji0.Y(f4Var.a, f4Var.b);
        ji0.Y(f4Var2.a, f4Var2.b);
    }

    public final boolean a(Activity activity, Intent intent) {
        if (!ji0.y(activity, this.a) || !ji0.z(intent, this.b)) {
            return false;
        }
        String str = this.c;
        return str == null || str.equals(intent.getAction());
    }

    public final boolean b(Activity activity, Activity activity2) {
        if (!ji0.y(activity, this.a) || !ji0.y(activity2, this.b)) {
            return false;
        }
        String str = this.c;
        if (str == null) {
            return true;
        }
        Intent intent = activity2.getIntent();
        return str.equals(intent != null ? intent.getAction() : null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!r04.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        r04 r04Var = (r04) obj;
        return this.a.equals(r04Var.a) && this.b.equals(r04Var.b) && n12.c(this.c, r04Var.c);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        String str = this.c;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SplitPairFilter{primaryActivityName=");
        f4 f4Var = this.a;
        sb.append(new ComponentName(f4Var.a, f4Var.b));
        sb.append(", secondaryActivityName=");
        f4 f4Var2 = this.b;
        sb.append(new ComponentName(f4Var2.a, f4Var2.b));
        sb.append(", secondaryActivityAction=");
        return fw.x(sb, this.c, '}');
    }
}
