package defpackage;

import android.content.Intent;
import android.os.Bundle;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class x4 {
    public final LinkedHashMap a = new LinkedHashMap();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();
    public final ArrayList d = new ArrayList();
    public final transient LinkedHashMap e = new LinkedHashMap();
    public final LinkedHashMap f = new LinkedHashMap();
    public final Bundle g = new Bundle();

    public final boolean a(int i, int i2, Intent intent) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        u4 u4Var = (u4) this.e.get(str);
        if ((u4Var != null ? u4Var.a : null) != null) {
            ArrayList arrayList = this.d;
            if (arrayList.contains(str)) {
                u4Var.a.h(u4Var.b.c(intent, i2));
                arrayList.remove(str);
                return true;
            }
        }
        this.f.remove(str);
        this.g.putParcelable(str, new k4(intent, i2));
        return true;
    }

    public abstract void b(int i, m4 m4Var, Object obj);

    public final w4 c(String str, m4 m4Var, l4 l4Var) {
        e(str);
        this.e.put(str, new u4(m4Var, l4Var));
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            Object obj = linkedHashMap.get(str);
            linkedHashMap.remove(str);
            l4Var.h(obj);
        }
        Bundle bundle = this.g;
        k4 k4Var = (k4) ek0.o(bundle, str, k4.class);
        if (k4Var != null) {
            bundle.remove(str);
            l4Var.h(m4Var.c(k4Var.f, k4Var.b));
        }
        return new w4(this, str, m4Var, 1);
    }

    public final w4 d(final String str, da2 da2Var, final m4 m4Var, final l4 l4Var) {
        str.getClass();
        m4Var.getClass();
        l4Var.getClass();
        r92 lifecycle = da2Var.getLifecycle();
        if (lifecycle.b().compareTo(q92.A) >= 0) {
            StringBuilder sb = new StringBuilder("LifecycleOwner ");
            sb.append(da2Var);
            q92 q92VarB = lifecycle.b();
            sb.append(" is attempting to register while current state is ");
            sb.append(q92VarB);
            sb.append(". LifecycleOwners must call register before they are STARTED.");
            throw new IllegalStateException(sb.toString().toString());
        }
        e(str);
        LinkedHashMap linkedHashMap = this.c;
        v4 v4Var = (v4) linkedHashMap.get(str);
        if (v4Var == null) {
            v4Var = new v4(lifecycle);
        }
        aa2 aa2Var = new aa2() { // from class: s4
            @Override // defpackage.aa2
            public final void n(da2 da2Var2, p92 p92Var) {
                x4 x4Var = this.b;
                LinkedHashMap linkedHashMap2 = x4Var.e;
                p92 p92Var2 = p92.ON_START;
                String str2 = str;
                if (p92Var2 != p92Var) {
                    if (p92.ON_STOP == p92Var) {
                        linkedHashMap2.remove(str2);
                        return;
                    } else {
                        if (p92.ON_DESTROY == p92Var) {
                            x4Var.f(str2);
                            return;
                        }
                        return;
                    }
                }
                Bundle bundle = x4Var.g;
                LinkedHashMap linkedHashMap3 = x4Var.f;
                m4 m4Var2 = m4Var;
                l4 l4Var2 = l4Var;
                linkedHashMap2.put(str2, new u4(m4Var2, l4Var2));
                if (linkedHashMap3.containsKey(str2)) {
                    Object obj = linkedHashMap3.get(str2);
                    linkedHashMap3.remove(str2);
                    l4Var2.h(obj);
                }
                k4 k4Var = (k4) ek0.o(bundle, str2, k4.class);
                if (k4Var != null) {
                    bundle.remove(str2);
                    l4Var2.h(m4Var2.c(k4Var.f, k4Var.b));
                }
            }
        };
        v4Var.a.a(aa2Var);
        v4Var.b.add(aa2Var);
        linkedHashMap.put(str, v4Var);
        return new w4(this, str, m4Var, 0);
    }

    public final void e(String str) {
        LinkedHashMap linkedHashMap = this.b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        t4 t4Var = new t4(0);
        for (Number number : new kb0(new go1(t4Var, new f0(26, t4Var), 0))) {
            Integer numValueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.a;
            if (!linkedHashMap2.containsKey(numValueOf)) {
                int iIntValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue));
                return;
            }
        }
        e04.h("Sequence contains no element matching the predicate.");
    }

    public final void f(String str) {
        Integer num;
        str.getClass();
        if (!this.d.contains(str) && (num = (Integer) this.b.remove(str)) != null) {
            this.a.remove(num);
        }
        this.e.remove(str);
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            StringBuilder sbD = fw.D("Dropping pending result for request ", str, ": ");
            sbD.append(linkedHashMap.get(str));
            a1.n("ActivityResultRegistry", sbD.toString());
            linkedHashMap.remove(str);
        }
        Bundle bundle = this.g;
        if (bundle.containsKey(str)) {
            a1.n("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((k4) ek0.o(bundle, str, k4.class)));
            bundle.remove(str);
        }
        LinkedHashMap linkedHashMap2 = this.c;
        v4 v4Var = (v4) linkedHashMap2.get(str);
        if (v4Var != null) {
            ArrayList arrayList = v4Var.b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                v4Var.a.c((aa2) it.next());
            }
            arrayList.clear();
            linkedHashMap2.remove(str);
        }
    }
}
