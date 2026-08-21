package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xt3 {
    public final wt3 a;

    public xt3(int i, ArrayList arrayList, at3 at3Var, py pyVar) {
        if (Build.VERSION.SDK_INT < 28) {
            this.a = new vt3(i, arrayList, at3Var, pyVar);
        } else {
            this.a = new ut3(i, arrayList, at3Var, pyVar);
        }
    }

    public static ArrayList a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((OutputConfiguration) ((ax2) it.next()).a.c());
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof xt3)) {
            return false;
        }
        return this.a.equals(((xt3) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
