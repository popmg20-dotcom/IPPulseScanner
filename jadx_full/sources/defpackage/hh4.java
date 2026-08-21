package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hh4 {
    public View b;
    public final HashMap a = new HashMap();
    public final ArrayList c = new ArrayList();

    public hh4(View view) {
        this.b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof hh4)) {
            return false;
        }
        hh4 hh4Var = (hh4) obj;
        return this.b == hh4Var.b && this.a.equals(hh4Var.a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sbQ = ha0.q("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbQ.append(this.b);
        sbQ.append("\n");
        String strConcat = sbQ.toString().concat("    values:");
        HashMap map = this.a;
        for (String str : map.keySet()) {
            strConcat = strConcat + "    " + str + ": " + map.get(str) + "\n";
        }
        return strConcat;
    }
}
