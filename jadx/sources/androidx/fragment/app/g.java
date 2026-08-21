package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import defpackage.b0;
import defpackage.b10;
import defpackage.bh3;
import defpackage.cq4;
import defpackage.d4;
import defpackage.d70;
import defpackage.e03;
import defpackage.f70;
import defpackage.ie;
import defpackage.mf;
import defpackage.ok1;
import defpackage.pl1;
import defpackage.pv2;
import defpackage.qm0;
import defpackage.rm0;
import defpackage.s7;
import defpackage.sm0;
import defpackage.tk1;
import defpackage.tm0;
import defpackage.uk1;
import defpackage.vz3;
import defpackage.wp4;
import defpackage.yh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g extends vz3 {
    public final ArrayList c;
    public final a0 d;
    public final a0 e;
    public final uk1 f;
    public final Object g;
    public final ArrayList h;
    public final ArrayList i;
    public final ie j;
    public final ArrayList k;
    public final ArrayList l;
    public final ie m;
    public final ie n;
    public final boolean o;
    public final b10 p = new b10();
    public Object q;
    public boolean r;

    public g(ArrayList arrayList, a0 a0Var, a0 a0Var2, uk1 uk1Var, Object obj, ArrayList arrayList2, ArrayList arrayList3, ie ieVar, ArrayList arrayList4, ArrayList arrayList5, ie ieVar2, ie ieVar3, boolean z) {
        this.c = arrayList;
        this.d = a0Var;
        this.e = a0Var2;
        this.f = uk1Var;
        this.g = obj;
        this.h = arrayList2;
        this.i = arrayList3;
        this.j = ieVar;
        this.k = arrayList4;
        this.l = arrayList5;
        this.m = ieVar2;
        this.n = ieVar3;
        this.o = z;
    }

    public static void f(View view, ArrayList arrayList) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = cq4.a;
        if (viewGroup.isTransitionGroup()) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                f(childAt, arrayList);
            }
        }
    }

    @Override // defpackage.vz3
    public final boolean a() {
        Object obj;
        uk1 uk1Var = this.f;
        if (!uk1Var.l()) {
            return false;
        }
        ArrayList<tm0> arrayList = this.c;
        if (!arrayList.isEmpty()) {
            for (tm0 tm0Var : arrayList) {
                if (Build.VERSION.SDK_INT < 34 || (obj = tm0Var.b) == null || !uk1Var.m(obj)) {
                    return false;
                }
            }
        }
        Object obj2 = this.g;
        return obj2 == null || uk1Var.m(obj2);
    }

    @Override // defpackage.vz3
    public final void b(ViewGroup viewGroup) {
        viewGroup.getClass();
        this.p.a();
    }

    @Override // defpackage.vz3
    public final void c(ViewGroup viewGroup) {
        viewGroup.getClass();
        boolean zIsLaidOut = viewGroup.isLaidOut();
        ArrayList<tm0> arrayList = this.c;
        if (!zIsLaidOut || this.r) {
            for (tm0 tm0Var : arrayList) {
                a0 a0Var = tm0Var.a;
                if (u.M(2)) {
                    if (this.r) {
                        Log.v("FragmentManager", "SpecialEffectsController: TransitionSeekController was not created. Completing operation " + a0Var);
                    } else {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Completing operation " + a0Var);
                    }
                }
                tm0Var.a.c(this);
            }
            this.r = false;
            return;
        }
        Object obj = this.q;
        uk1 uk1Var = this.f;
        a0 a0Var2 = this.e;
        a0 a0Var3 = this.d;
        if (obj != null) {
            uk1Var.c(obj);
            if (u.M(2)) {
                Log.v("FragmentManager", "Ending execution of operations from " + a0Var3 + " to " + a0Var2);
                return;
            }
            return;
        }
        e03 e03VarG = g(viewGroup, a0Var2, a0Var3);
        ArrayList arrayList2 = (ArrayList) e03VarG.b;
        Object obj2 = e03VarG.f;
        ArrayList<a0> arrayList3 = new ArrayList(f70.Q(10, arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(((tm0) it.next()).a);
        }
        for (a0 a0Var4 : arrayList3) {
            uk1Var.u(a0Var4.c, obj2, this.p, new qm0(a0Var4, this, 1));
        }
        i(arrayList2, viewGroup, new rm0(this, viewGroup, obj2));
        if (u.M(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + a0Var3 + " to " + a0Var2);
        }
    }

    @Override // defpackage.vz3
    public final void d(yh yhVar, ViewGroup viewGroup) {
        viewGroup.getClass();
        Object obj = this.q;
        if (obj != null) {
            this.f.r(obj, yhVar.c);
        }
    }

    @Override // defpackage.vz3
    public final void e(ViewGroup viewGroup) {
        Object obj;
        viewGroup.getClass();
        boolean zIsLaidOut = viewGroup.isLaidOut();
        ArrayList arrayList = this.c;
        if (!zIsLaidOut) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a0 a0Var = ((tm0) it.next()).a;
                if (u.M(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Skipping onStart for operation " + a0Var);
                }
            }
            return;
        }
        boolean zH = h();
        a0 a0Var2 = this.e;
        a0 a0Var3 = this.d;
        if (zH && (obj = this.g) != null && !a()) {
            Log.i("FragmentManager", "Ignoring shared elements transition " + obj + " between " + a0Var3 + " and " + a0Var2 + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
        }
        if (a() && h()) {
            bh3 bh3Var = new bh3();
            e03 e03VarG = g(viewGroup, a0Var2, a0Var3);
            ArrayList arrayList2 = (ArrayList) e03VarG.b;
            Object obj2 = e03VarG.f;
            ArrayList<a0> arrayList3 = new ArrayList(f70.Q(10, arrayList));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((tm0) it2.next()).a);
            }
            for (a0 a0Var4 : arrayList3) {
                d4 d4Var = new d4(16, bh3Var);
                o oVar = a0Var4.c;
                this.f.v(obj2, this.p, d4Var, new qm0(a0Var4, this, 0));
            }
            i(arrayList2, viewGroup, new sm0(this, viewGroup, obj2, bh3Var));
        }
    }

    public final e03 g(ViewGroup viewGroup, a0 a0Var, a0 a0Var2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Object obj;
        uk1 uk1Var;
        Object obj2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        a0 a0Var3 = a0Var;
        View view = new View(viewGroup.getContext());
        Rect rect = new Rect();
        ArrayList arrayList5 = this.c;
        Iterator it = arrayList5.iterator();
        View view2 = null;
        boolean z = false;
        while (true) {
            boolean zHasNext = it.hasNext();
            arrayList = this.i;
            arrayList2 = this.h;
            obj = this.g;
            uk1Var = this.f;
            if (!zHasNext) {
                break;
            }
            if (((tm0) it.next()).d == null || a0Var2 == null || a0Var3 == null || this.j.isEmpty() || obj == null) {
                arrayList4 = arrayList5;
            } else {
                o oVar = a0Var3.c;
                o oVar2 = a0Var2.c;
                tk1 tk1Var = ok1.a;
                arrayList4 = arrayList5;
                if (this.o) {
                    oVar2.getEnterTransitionCallback();
                } else {
                    oVar.getEnterTransitionCallback();
                }
                pv2.a(viewGroup, new b0(6, a0Var3, a0Var2, this));
                ie ieVar = this.m;
                arrayList2.addAll(ieVar.values());
                ArrayList arrayList6 = this.l;
                if (!arrayList6.isEmpty()) {
                    Object obj3 = arrayList6.get(0);
                    obj3.getClass();
                    View view3 = (View) ieVar.get((String) obj3);
                    uk1Var.s(view3, obj);
                    view2 = view3;
                }
                ie ieVar2 = this.n;
                arrayList.addAll(ieVar2.values());
                ArrayList arrayList7 = this.k;
                if (!arrayList7.isEmpty()) {
                    Object obj4 = arrayList7.get(0);
                    obj4.getClass();
                    View view4 = (View) ieVar2.get((String) obj4);
                    if (view4 != null) {
                        pv2.a(viewGroup, new s7(uk1Var, view4, rect));
                        z = true;
                    }
                }
                uk1Var.w(obj, view, arrayList2);
                Object obj5 = this.g;
                uk1Var.q(obj5, null, null, obj5, arrayList);
            }
            arrayList5 = arrayList4;
        }
        ArrayList arrayList8 = arrayList5;
        ArrayList arrayList9 = arrayList;
        ArrayList arrayList10 = new ArrayList();
        Iterator it2 = arrayList8.iterator();
        Object objO = null;
        Object objO2 = null;
        while (true) {
            ArrayList arrayList11 = arrayList9;
            if (!it2.hasNext()) {
                break;
            }
            tm0 tm0Var = (tm0) it2.next();
            Iterator it3 = it2;
            a0 a0Var4 = tm0Var.a;
            boolean z2 = z;
            Object objH = uk1Var.h(tm0Var.b);
            if (objH != null) {
                ArrayList arrayList12 = arrayList2;
                ArrayList arrayList13 = new ArrayList();
                Object obj6 = obj;
                o oVar3 = a0Var4.c;
                Object obj7 = objO2;
                View view5 = oVar3.mView;
                view5.getClass();
                f(view5, arrayList13);
                if (obj6 != null && (a0Var4 == a0Var2 || a0Var4 == a0Var3)) {
                    if (a0Var4 == a0Var2) {
                        arrayList13.removeAll(d70.C0(arrayList12));
                    } else {
                        arrayList13.removeAll(d70.C0(arrayList11));
                    }
                }
                if (arrayList13.isEmpty()) {
                    uk1Var.a(view, objH);
                    obj2 = objH;
                    arrayList3 = arrayList13;
                } else {
                    uk1Var.b(objH, arrayList13);
                    uk1Var.q(objH, objH, arrayList13, null, null);
                    obj2 = objH;
                    arrayList3 = arrayList13;
                    if (a0Var4.a == 3) {
                        a0Var4.i = false;
                        ArrayList arrayList14 = new ArrayList(arrayList3);
                        arrayList14.remove(oVar3.mView);
                        uk1Var.p(obj2, oVar3.mView, arrayList14);
                        pv2.a(viewGroup, new d4(17, arrayList3));
                    }
                }
                if (a0Var4.a == 2) {
                    arrayList10.addAll(arrayList3);
                    if (z2) {
                        uk1Var.t(obj2, rect);
                    }
                    if (u.M(2)) {
                        Log.v("FragmentManager", "Entering Transition: " + obj2);
                        Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                        for (Object obj8 : arrayList3) {
                            obj8.getClass();
                            Log.v("FragmentManager", "View: " + ((View) obj8));
                        }
                    }
                } else {
                    uk1Var.s(view2, obj2);
                    if (u.M(2)) {
                        Log.v("FragmentManager", "Exiting Transition: " + obj2);
                        Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                        for (Object obj9 : arrayList3) {
                            obj9.getClass();
                            Log.v("FragmentManager", "View: " + ((View) obj9));
                        }
                    }
                }
                if (tm0Var.c) {
                    objO = uk1Var.o(objO, obj2);
                    a0Var3 = a0Var;
                    arrayList9 = arrayList11;
                    it2 = it3;
                    z = z2;
                    arrayList2 = arrayList12;
                    obj = obj6;
                    objO2 = obj7;
                } else {
                    objO2 = uk1Var.o(obj7, obj2);
                    a0Var3 = a0Var;
                    arrayList9 = arrayList11;
                    it2 = it3;
                    z = z2;
                    arrayList2 = arrayList12;
                    obj = obj6;
                }
            } else {
                arrayList9 = arrayList11;
                it2 = it3;
                z = z2;
                a0Var3 = a0Var;
            }
        }
        Object objN = uk1Var.n(objO, objO2, obj);
        if (u.M(2)) {
            Log.v("FragmentManager", "Final merged transition: " + objN + " for container " + viewGroup);
        }
        return new e03(arrayList10, objN);
    }

    public final boolean h() {
        ArrayList arrayList = this.c;
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((tm0) it.next()).a.c.mTransitioning) {
                return false;
            }
        }
        return true;
    }

    public final void i(ArrayList arrayList, ViewGroup viewGroup, pl1 pl1Var) {
        ok1.a(arrayList, 4);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = this.i;
        int size = arrayList3.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList3.get(i);
            WeakHashMap weakHashMap = wp4.a;
            arrayList2.add(view.getTransitionName());
            view.setTransitionName(null);
        }
        boolean zM = u.M(2);
        ArrayList arrayList4 = this.h;
        if (zM) {
            Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
            Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
            for (Object obj : arrayList4) {
                obj.getClass();
                View view2 = (View) obj;
                StringBuilder sb = new StringBuilder("View: ");
                sb.append(view2);
                sb.append(" Name: ");
                WeakHashMap weakHashMap2 = wp4.a;
                sb.append(view2.getTransitionName());
                Log.v("FragmentManager", sb.toString());
            }
            Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
            for (Object obj2 : arrayList3) {
                obj2.getClass();
                View view3 = (View) obj2;
                StringBuilder sb2 = new StringBuilder("View: ");
                sb2.append(view3);
                sb2.append(" Name: ");
                WeakHashMap weakHashMap3 = wp4.a;
                sb2.append(view3.getTransitionName());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        pl1Var.a();
        int size2 = arrayList3.size();
        ArrayList arrayList5 = new ArrayList();
        for (int i2 = 0; i2 < size2; i2++) {
            View view4 = (View) arrayList4.get(i2);
            WeakHashMap weakHashMap4 = wp4.a;
            String transitionName = view4.getTransitionName();
            arrayList5.add(transitionName);
            if (transitionName != null) {
                view4.setTransitionName(null);
                String str = (String) this.j.get(transitionName);
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        break;
                    }
                    if (str.equals(arrayList2.get(i3))) {
                        ((View) arrayList3.get(i3)).setTransitionName(transitionName);
                        break;
                    }
                    i3++;
                }
            }
        }
        pv2.a(viewGroup, new mf(size2, arrayList3, arrayList2, arrayList4, arrayList5));
        ok1.a(arrayList, 0);
        this.f.x(this.g, arrayList4, arrayList3);
    }
}
