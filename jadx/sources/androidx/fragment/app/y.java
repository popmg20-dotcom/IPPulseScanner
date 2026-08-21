package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import defpackage.s53;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    public final ArrayList a = new ArrayList();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public v d;

    public final void a(o oVar) {
        if (this.a.contains(oVar)) {
            s53.j(oVar, "Fragment already added: ");
            return;
        }
        synchronized (this.a) {
            this.a.add(oVar);
        }
        oVar.mAdded = true;
    }

    public final o b(String str) {
        x xVar = (x) this.b.get(str);
        if (xVar != null) {
            return xVar.c;
        }
        return null;
    }

    public final o c(String str) {
        o oVarFindFragmentByWho;
        for (x xVar : this.b.values()) {
            if (xVar != null && (oVarFindFragmentByWho = xVar.c.findFragmentByWho(str)) != null) {
                return oVarFindFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (x xVar : this.b.values()) {
            if (xVar != null) {
                arrayList.add(xVar);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (x xVar : this.b.values()) {
            if (xVar != null) {
                arrayList.add(xVar.c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public final void g(x xVar) {
        o oVar = xVar.c;
        String str = oVar.mWho;
        HashMap map = this.b;
        if (map.get(str) != null) {
            return;
        }
        map.put(oVar.mWho, xVar);
        if (oVar.mRetainInstanceChangedWhileDetached) {
            boolean z = oVar.mRetainInstance;
            v vVar = this.d;
            if (z) {
                vVar.e(oVar);
            } else {
                vVar.i(oVar);
            }
            oVar.mRetainInstanceChangedWhileDetached = false;
        }
        if (u.M(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + oVar);
        }
    }

    public final void h(x xVar) {
        o oVar = xVar.c;
        if (oVar.mRetainInstance) {
            this.d.i(oVar);
        }
        String str = oVar.mWho;
        HashMap map = this.b;
        if (map.get(str) == xVar && ((x) map.put(oVar.mWho, null)) != null && u.M(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + oVar);
        }
    }

    public final Bundle i(Bundle bundle, String str) {
        HashMap map = this.c;
        return bundle != null ? (Bundle) map.put(str, bundle) : (Bundle) map.remove(str);
    }
}
