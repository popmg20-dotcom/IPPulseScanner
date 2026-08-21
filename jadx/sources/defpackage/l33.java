package defpackage;

import android.text.TextUtils;
import androidx.preference.Preference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l33 {
    public final int a;
    public final int b;
    public final String c;

    public l33(Preference preference) {
        this.c = preference.getClass().getName();
        this.a = preference.V0;
        this.b = preference.W0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l33)) {
            return false;
        }
        l33 l33Var = (l33) obj;
        return this.a == l33Var.a && this.b == l33Var.b && TextUtils.equals(this.c, l33Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((((527 + this.a) * 31) + this.b) * 31);
    }
}
