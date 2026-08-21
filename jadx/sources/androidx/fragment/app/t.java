package androidx.fragment.app;

import android.util.Log;
import defpackage.fw;
import defpackage.n33;
import defpackage.nk1;
import defpackage.yj1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t implements yj1 {
    public final /* synthetic */ u a;

    public t(u uVar) {
        this.a = uVar;
    }

    @Override // defpackage.yj1
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        u uVar = this.a;
        ArrayList<n33> arrayList3 = uVar.o;
        if (u.M(2)) {
            Log.v("FragmentManager", "FragmentManager has the following pending actions inside of prepareBackStackState: " + uVar.a);
        }
        boolean zW = false;
        if (uVar.d.isEmpty()) {
            Log.i("FragmentManager", "Ignoring call to start back stack pop because the back stack is empty.");
        } else {
            a aVar = (a) fw.r(uVar.d, 1);
            uVar.h = aVar;
            Iterator it = aVar.a.iterator();
            while (it.hasNext()) {
                o oVar = ((nk1) it.next()).b;
                if (oVar != null) {
                    oVar.mTransitioning = true;
                }
            }
            zW = uVar.W(arrayList, arrayList2, -1, 0);
        }
        if (!arrayList3.isEmpty() && arrayList.size() > 0) {
            ((Boolean) arrayList2.get(arrayList.size() - 1)).getClass();
            LinkedHashSet<o> linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(u.F((a) it2.next()));
            }
            for (n33 n33Var : arrayList3) {
                for (o oVar2 : linkedHashSet) {
                    n33Var.getClass();
                }
            }
        }
        return zW;
    }
}
