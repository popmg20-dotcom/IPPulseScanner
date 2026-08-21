package androidx.fragment.app;

import android.util.Log;
import defpackage.ck1;
import defpackage.iq4;
import defpackage.oq4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v extends iq4 {
    public static final ck1 h = new ck1(0);
    public final boolean e;
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public boolean f = false;
    public boolean g = false;

    public v(boolean z) {
        this.e = z;
    }

    @Override // defpackage.iq4
    public final void d() {
        if (u.M(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    public final void e(o oVar) {
        if (this.g) {
            if (u.M(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        String str = oVar.mWho;
        HashMap map = this.b;
        if (map.containsKey(str)) {
            return;
        }
        map.put(oVar.mWho, oVar);
        if (u.M(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + oVar);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        return this.b.equals(vVar.b) && this.c.equals(vVar.c) && this.d.equals(vVar.d);
    }

    public final void f(o oVar, boolean z) {
        if (u.M(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + oVar);
        }
        h(oVar.mWho, z);
    }

    public final void g(String str, boolean z) {
        if (u.M(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        h(str, z);
    }

    public final void h(String str, boolean z) {
        HashMap map = this.c;
        v vVar = (v) map.get(str);
        if (vVar != null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(vVar.c.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    vVar.g((String) it.next(), true);
                }
            }
            vVar.d();
            map.remove(str);
        }
        HashMap map2 = this.d;
        oq4 oq4Var = (oq4) map2.get(str);
        if (oq4Var != null) {
            oq4Var.a();
            map2.remove(str);
        }
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + (this.b.hashCode() * 31)) * 31);
    }

    public final void i(o oVar) {
        if (this.g) {
            if (u.M(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.b.remove(oVar.mWho) == null || !u.M(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + oVar);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
