package androidx.fragment.app;

import android.util.Log;
import defpackage.d70;
import defpackage.ga1;
import defpackage.n33;
import defpackage.nk1;
import defpackage.ru2;
import defpackage.vz3;
import defpackage.yh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s extends ru2 {
    public final /* synthetic */ u d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(u uVar) {
        super(false);
        this.d = uVar;
    }

    @Override // defpackage.ru2
    public final void a() {
        int i = 3;
        boolean zM = u.M(3);
        u uVar = this.d;
        if (zM) {
            Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = true fragment manager " + uVar);
        }
        if (u.M(3)) {
            Log.d("FragmentManager", "cancelBackStackTransition for transition " + uVar.h);
        }
        a aVar = uVar.h;
        if (aVar != null) {
            aVar.s = false;
            aVar.d();
            uVar.h.l(true, new ga1(i, uVar));
            uVar.h.e();
            uVar.i = true;
            uVar.z(true);
            uVar.E();
            uVar.i = false;
            uVar.h = null;
        }
    }

    @Override // defpackage.ru2
    public final void b() {
        boolean zM = u.M(3);
        u uVar = this.d;
        if (zM) {
            Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = true fragment manager " + uVar);
        }
        s sVar = uVar.j;
        ArrayList<n33> arrayList = uVar.o;
        uVar.i = true;
        uVar.z(true);
        uVar.i = false;
        if (uVar.h == null) {
            if (sVar.b) {
                if (u.M(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                uVar.U();
                return;
            } else {
                if (u.M(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                uVar.g.d();
                return;
            }
        }
        if (!arrayList.isEmpty()) {
            LinkedHashSet<o> linkedHashSet = new LinkedHashSet(u.F(uVar.h));
            for (n33 n33Var : arrayList) {
                for (o oVar : linkedHashSet) {
                    n33Var.getClass();
                }
            }
        }
        Iterator it = uVar.h.a.iterator();
        while (it.hasNext()) {
            o oVar2 = ((nk1) it.next()).b;
            if (oVar2 != null) {
                oVar2.mTransitioning = false;
            }
        }
        for (h hVar : uVar.f(new ArrayList(Collections.singletonList(uVar.h)), 0, 1)) {
            ArrayList arrayList2 = hVar.c;
            if (u.M(3)) {
                Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
            }
            hVar.m(arrayList2);
            hVar.c(arrayList2);
        }
        Iterator it2 = uVar.h.a.iterator();
        while (it2.hasNext()) {
            o oVar3 = ((nk1) it2.next()).b;
            if (oVar3 != null && oVar3.mContainer == null) {
                uVar.g(oVar3).k();
            }
        }
        uVar.h = null;
        uVar.k0();
        if (u.M(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + sVar.b + " for  FragmentManager " + uVar);
        }
    }

    @Override // defpackage.ru2
    public final void c(yh yhVar) {
        boolean zM = u.M(2);
        u uVar = this.d;
        if (zM) {
            Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = true fragment manager " + uVar);
        }
        if (uVar.h != null) {
            for (h hVar : uVar.f(new ArrayList(Collections.singletonList(uVar.h)), 0, 1)) {
                hVar.getClass();
                if (u.M(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + yhVar.c);
                }
                ArrayList arrayList = hVar.c;
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d70.U(((a0) it.next()).k, arrayList2);
                }
                List listY0 = d70.y0(d70.C0(arrayList2));
                int size = listY0.size();
                for (int i = 0; i < size; i++) {
                    ((vz3) listY0.get(i)).d(yhVar, hVar.a);
                }
            }
            Iterator it2 = uVar.o.iterator();
            while (it2.hasNext()) {
                ((n33) it2.next()).getClass();
            }
        }
    }

    @Override // defpackage.ru2
    public final void d(yh yhVar) {
        boolean zM = u.M(3);
        u uVar = this.d;
        if (zM) {
            Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = true fragment manager " + uVar);
        }
        uVar.w();
        uVar.x(new t(uVar), false);
    }
}
