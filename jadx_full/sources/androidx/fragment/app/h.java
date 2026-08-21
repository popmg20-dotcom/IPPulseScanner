package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;
import defpackage.d70;
import defpackage.dw2;
import defpackage.e03;
import defpackage.eg0;
import defpackage.gj1;
import defpackage.ie;
import defpackage.lm0;
import defpackage.ok1;
import defpackage.st4;
import defpackage.tk1;
import defpackage.tm0;
import defpackage.uk1;
import defpackage.vz3;
import defpackage.wp4;
import defpackage.xe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public final ViewGroup a;
    public final ArrayList b;
    public final ArrayList c;
    public boolean d;
    public boolean e;
    public boolean f;

    public h(ViewGroup viewGroup) {
        viewGroup.getClass();
        this.a = viewGroup;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public static void f(ie ieVar, View view) {
        WeakHashMap weakHashMap = wp4.a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            ieVar.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    f(ieVar, childAt);
                }
            }
        }
    }

    public static final h j(ViewGroup viewGroup, u uVar) {
        viewGroup.getClass();
        uVar.getClass();
        uVar.K().getClass();
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof h) {
            return (h) tag;
        }
        h hVar = new h(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, hVar);
        return hVar;
    }

    public static boolean k(ArrayList arrayList) {
        boolean z;
        Iterator it = arrayList.iterator();
        loop0: while (true) {
            z = true;
            while (it.hasNext()) {
                a0 a0Var = (a0) it.next();
                if (!a0Var.k.isEmpty()) {
                    ArrayList arrayList2 = a0Var.k;
                    if (arrayList2.isEmpty()) {
                        break;
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (!((vz3) it2.next()).a()) {
                            break;
                        }
                    }
                }
                z = false;
            }
            break loop0;
        }
        if (z) {
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                d70.U(((a0) it3.next()).k, arrayList3);
            }
            if (!arrayList3.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final void a(a0 a0Var) {
        a0Var.getClass();
        if (a0Var.i) {
            int i = a0Var.a;
            View viewRequireView = a0Var.c.requireView();
            viewRequireView.getClass();
            dw2.s(i, viewRequireView, this.a);
            a0Var.i = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x0471 A[LOOP:7: B:168:0x046b->B:170:0x0471, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(ArrayList arrayList, boolean z) {
        Object next;
        Object objPrevious;
        ArrayList<d> arrayList2;
        int i;
        String str;
        ArrayList arrayList3;
        uk1 uk1Var;
        ArrayList arrayList4;
        ArrayList arrayList5;
        int i2;
        e03 e03Var;
        Iterator it;
        int i3 = 2;
        if (u.M(2)) {
            Log.v("FragmentManager", "Collecting Effects");
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            a0 a0Var = (a0) next;
            View view = a0Var.c.mView;
            view.getClass();
            if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                int visibility = view.getVisibility();
                if (visibility == 0) {
                    if (a0Var.a != 2) {
                        break;
                    }
                } else {
                    if (visibility != 4 && visibility != 8) {
                        xe.k(dw2.A(visibility, "Unknown visibility "));
                        return;
                    }
                }
            }
        }
        a0 a0Var2 = (a0) next;
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            a0 a0Var3 = (a0) objPrevious;
            View view2 = a0Var3.c.mView;
            view2.getClass();
            if (view2.getAlpha() != 0.0f || view2.getVisibility() != 0) {
                int visibility2 = view2.getVisibility();
                if (visibility2 == 0) {
                    continue;
                } else if (visibility2 != 4 && visibility2 != 8) {
                    xe.k(dw2.A(visibility2, "Unknown visibility "));
                    return;
                }
            }
            if (a0Var3.a == 2) {
                break;
            }
        }
        a0 a0Var4 = (a0) objPrevious;
        if (u.M(2)) {
            Log.v("FragmentManager", "Executing operations from " + a0Var2 + " to " + a0Var4);
        }
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        o oVar = ((a0) d70.k0(arrayList)).c;
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            gj1 gj1Var = ((a0) it3.next()).c.mAnimationInfo;
            gj1 gj1Var2 = oVar.mAnimationInfo;
            gj1Var.b = gj1Var2.b;
            gj1Var.c = gj1Var2.c;
            gj1Var.d = gj1Var2.d;
            gj1Var.e = gj1Var2.e;
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            a0 a0Var5 = (a0) it4.next();
            arrayList6.add(new d(a0Var5, z));
            arrayList7.add(new tm0(a0Var5, z, !z ? a0Var5 != a0Var4 : a0Var5 != a0Var2));
            a0Var5.d.add(new lm0(this, a0Var5, 0));
        }
        ArrayList arrayList8 = new ArrayList();
        for (Object obj : arrayList7) {
            if (!((tm0) obj).a()) {
                arrayList8.add(obj);
            }
        }
        ArrayList<tm0> arrayList9 = new ArrayList();
        for (Object obj2 : arrayList8) {
            if (((tm0) obj2).b() != null) {
                arrayList9.add(obj2);
            }
        }
        uk1 uk1Var2 = null;
        for (tm0 tm0Var : arrayList9) {
            uk1 uk1VarB = tm0Var.b();
            if (uk1Var2 != null && uk1VarB != uk1Var2) {
                StringBuilder sb = new StringBuilder("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                sb.append(tm0Var.a.c);
                Object obj3 = tm0Var.b;
                sb.append(" returned Transition ");
                sb.append(obj3);
                sb.append(" which uses a different Transition type than other Fragments.");
                throw new IllegalArgumentException(sb.toString().toString());
            }
            uk1Var2 = uk1VarB;
        }
        if (uk1Var2 != null) {
            ArrayList arrayList10 = new ArrayList();
            ArrayList arrayList11 = new ArrayList();
            ie ieVar = new ie(0);
            ArrayList<String> arrayList12 = new ArrayList<>();
            ArrayList<String> arrayList13 = new ArrayList<>();
            ArrayList<String> arrayList14 = arrayList12;
            ie ieVar2 = new ie(0);
            ArrayList<String> arrayList15 = arrayList13;
            ie ieVar3 = new ie(0);
            Iterator it5 = arrayList9.iterator();
            Object obj4 = null;
            while (it5.hasNext()) {
                Object obj5 = ((tm0) it5.next()).d;
                if (obj5 == null || a0Var2 == null) {
                    arrayList3 = arrayList6;
                    uk1Var = uk1Var2;
                    arrayList4 = arrayList10;
                    arrayList5 = arrayList11;
                    i2 = i3;
                } else {
                    i2 = i3;
                    o oVar2 = a0Var2.c;
                    if (a0Var4 != null) {
                        o oVar3 = a0Var4.c;
                        Object objY = uk1Var2.y(uk1Var2.h(obj5));
                        ArrayList<String> sharedElementSourceNames = oVar3.getSharedElementSourceNames();
                        sharedElementSourceNames.getClass();
                        arrayList3 = arrayList6;
                        ArrayList<String> sharedElementSourceNames2 = oVar2.getSharedElementSourceNames();
                        sharedElementSourceNames2.getClass();
                        uk1Var = uk1Var2;
                        ArrayList<String> sharedElementTargetNames = oVar2.getSharedElementTargetNames();
                        sharedElementTargetNames.getClass();
                        arrayList4 = arrayList10;
                        int size = sharedElementTargetNames.size();
                        arrayList5 = arrayList11;
                        int i4 = 0;
                        while (i4 < size) {
                            int i5 = size;
                            int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i4));
                            if (iIndexOf != -1) {
                                sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i4));
                            }
                            i4++;
                            size = i5;
                        }
                        ArrayList<String> sharedElementTargetNames2 = oVar3.getSharedElementTargetNames();
                        sharedElementTargetNames2.getClass();
                        if (z) {
                            oVar2.getEnterTransitionCallback();
                            oVar3.getExitTransitionCallback();
                            e03Var = new e03(null, null);
                        } else {
                            oVar2.getExitTransitionCallback();
                            oVar3.getEnterTransitionCallback();
                            e03Var = new e03(null, null);
                        }
                        if (e03Var.b != null) {
                            st4.n();
                            return;
                        }
                        if (e03Var.f != null) {
                            st4.n();
                            return;
                        }
                        int size2 = sharedElementSourceNames.size();
                        for (int i6 = 0; i6 < size2; i6++) {
                            String str2 = sharedElementSourceNames.get(i6);
                            str2.getClass();
                            String str3 = str2;
                            String str4 = sharedElementTargetNames2.get(i6);
                            str4.getClass();
                            ieVar.put(str3, str4);
                        }
                        if (u.M(i2)) {
                            Log.v("FragmentManager", ">>> entering view names <<<");
                            Iterator<String> it6 = sharedElementTargetNames2.iterator();
                            while (it6.hasNext()) {
                                Log.v("FragmentManager", "Name: " + it6.next());
                            }
                            Log.v("FragmentManager", ">>> exiting view names <<<");
                            Iterator<String> it7 = sharedElementSourceNames.iterator();
                            while (it7.hasNext()) {
                                Log.v("FragmentManager", "Name: " + it7.next());
                            }
                        }
                        View view3 = oVar2.mView;
                        view3.getClass();
                        f(ieVar2, view3);
                        ieVar2.l(sharedElementSourceNames);
                        ieVar.l(ieVar2.keySet());
                        View view4 = oVar3.mView;
                        view4.getClass();
                        f(ieVar3, view4);
                        ieVar3.l(sharedElementTargetNames2);
                        ieVar3.l(ieVar.values());
                        tk1 tk1Var = ok1.a;
                        for (int i7 = ieVar.z - 1; -1 < i7; i7--) {
                            if (!ieVar3.containsKey((String) ieVar.i(i7))) {
                                ieVar.g(i7);
                            }
                        }
                        Set setKeySet = ieVar.keySet();
                        Iterator it8 = ieVar2.entrySet().iterator();
                        while (it8.hasNext()) {
                            it8.next();
                            View view5 = (View) ((Map.Entry) it8).getValue();
                            WeakHashMap weakHashMap = wp4.a;
                            if (!d70.W(view5.getTransitionName(), setKeySet)) {
                                it8.remove();
                            }
                        }
                        Collection collectionValues = ieVar.values();
                        Iterator it9 = ieVar3.entrySet().iterator();
                        while (it9.hasNext()) {
                            it9.next();
                            View view6 = (View) ((Map.Entry) it9).getValue();
                            WeakHashMap weakHashMap2 = wp4.a;
                            if (!d70.W(view6.getTransitionName(), collectionValues)) {
                                it9.remove();
                            }
                        }
                        if (ieVar.isEmpty()) {
                            Log.i("FragmentManager", "Ignoring shared elements transition " + objY + " between " + a0Var2 + " and " + a0Var4 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
                            arrayList4.clear();
                            arrayList5.clear();
                            arrayList14 = sharedElementTargetNames2;
                            arrayList15 = sharedElementSourceNames;
                            i3 = i2;
                            arrayList6 = arrayList3;
                            uk1Var2 = uk1Var;
                            arrayList10 = arrayList4;
                            arrayList11 = arrayList5;
                            obj4 = null;
                        } else {
                            arrayList14 = sharedElementTargetNames2;
                            arrayList15 = sharedElementSourceNames;
                            obj4 = objY;
                            i3 = i2;
                            arrayList6 = arrayList3;
                            uk1Var2 = uk1Var;
                            arrayList10 = arrayList4;
                            arrayList11 = arrayList5;
                        }
                    } else {
                        arrayList3 = arrayList6;
                        uk1Var = uk1Var2;
                        arrayList4 = arrayList10;
                        arrayList5 = arrayList11;
                    }
                }
                i3 = i2;
                arrayList6 = arrayList3;
                uk1Var2 = uk1Var;
                arrayList10 = arrayList4;
                arrayList11 = arrayList5;
            }
            arrayList2 = arrayList6;
            uk1 uk1Var3 = uk1Var2;
            ArrayList arrayList16 = arrayList10;
            ArrayList arrayList17 = arrayList11;
            i = i3;
            if (obj4 == null) {
                if (!arrayList9.isEmpty()) {
                    Iterator it10 = arrayList9.iterator();
                    while (it10.hasNext()) {
                        if (((tm0) it10.next()).b == null) {
                        }
                    }
                }
            }
            str = "FragmentManager";
            g gVar = new g(arrayList9, a0Var2, a0Var4, uk1Var3, obj4, arrayList16, arrayList17, ieVar, arrayList14, arrayList15, ieVar2, ieVar3, z);
            Iterator it11 = arrayList9.iterator();
            while (it11.hasNext()) {
                ((tm0) it11.next()).a.j.add(gVar);
            }
            ArrayList<d> arrayList18 = new ArrayList();
            ArrayList arrayList19 = new ArrayList();
            it = arrayList2.iterator();
            while (it.hasNext()) {
                d70.U(((d) it.next()).a.k, arrayList19);
            }
            boolean zIsEmpty = arrayList19.isEmpty();
            boolean z2 = false;
            for (d dVar : arrayList2) {
                Context context = this.a.getContext();
                a0 a0Var6 = dVar.a;
                context.getClass();
                eg0 eg0VarB = dVar.b(context);
                if (eg0VarB != null) {
                    if (((AnimatorSet) eg0VarB.z) == null) {
                        arrayList18.add(dVar);
                    } else {
                        o oVar4 = a0Var6.c;
                        if (a0Var6.k.isEmpty()) {
                            if (a0Var6.a == 3) {
                                a0Var6.i = false;
                            }
                            a0Var6.j.add(new e(dVar));
                            z2 = true;
                        } else if (u.M(i)) {
                            Log.v(str, "Ignoring Animator set on " + oVar4 + " as this Fragment was involved in a Transition.");
                        }
                    }
                }
            }
            for (d dVar2 : arrayList18) {
                a0 a0Var7 = dVar2.a;
                o oVar5 = a0Var7.c;
                if (zIsEmpty) {
                    if (!z2) {
                        a0Var7.j.add(new c(dVar2));
                    } else if (u.M(i)) {
                        Log.v(str, "Ignoring Animation set on " + oVar5 + " as Animations cannot run alongside Animators.");
                    }
                } else if (u.M(i)) {
                    Log.v(str, "Ignoring Animation set on " + oVar5 + " as Animations cannot run alongside Transitions.");
                }
            }
        }
        arrayList2 = arrayList6;
        i = 2;
        str = "FragmentManager";
        ArrayList<d> arrayList182 = new ArrayList();
        ArrayList arrayList192 = new ArrayList();
        it = arrayList2.iterator();
        while (it.hasNext()) {
        }
        boolean zIsEmpty2 = arrayList192.isEmpty();
        boolean z22 = false;
        while (r3.hasNext()) {
        }
        while (r0.hasNext()) {
        }
    }

    public final void c(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d70.U(((a0) it.next()).k, arrayList2);
        }
        List listY0 = d70.y0(d70.C0(arrayList2));
        int size = listY0.size();
        for (int i = 0; i < size; i++) {
            ((vz3) listY0.get(i)).c(this.a);
        }
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            a((a0) arrayList.get(i2));
        }
        List listY02 = d70.y0(arrayList);
        int size3 = listY02.size();
        for (int i3 = 0; i3 < size3; i3++) {
            a0 a0Var = (a0) listY02.get(i3);
            if (a0Var.k.isEmpty()) {
                a0Var.b();
            }
        }
    }

    public final void d(int i, int i2, x xVar) {
        synchronized (this.b) {
            try {
                a0 a0VarG = g(xVar.c);
                if (a0VarG == null) {
                    o oVar = xVar.c;
                    a0VarG = (oVar.mTransitioning || oVar.mRemoving) ? h(oVar) : null;
                }
                if (a0VarG != null) {
                    a0VarG.d(i, i2);
                    return;
                }
                final a0 a0Var = new a0(i, i2, xVar);
                this.b.add(a0Var);
                a0Var.d.add(new Runnable() { // from class: androidx.fragment.app.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        h hVar = this.b;
                        ArrayList arrayList = hVar.b;
                        a0 a0Var2 = a0Var;
                        if (arrayList.contains(a0Var2)) {
                            int i3 = a0Var2.a;
                            View view = a0Var2.c.mView;
                            view.getClass();
                            dw2.s(i3, view, hVar.a);
                        }
                    }
                });
                a0Var.d.add(new lm0(this, a0Var, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        boolean z;
        if (this.f) {
            return;
        }
        if (!this.a.isAttachedToWindow()) {
            i();
            this.e = false;
            return;
        }
        synchronized (this.b) {
            try {
                ArrayList<a0> arrayList = new ArrayList(this.c);
                this.c.clear();
                Iterator it = arrayList.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    a0 a0Var = (a0) it.next();
                    if (this.b.isEmpty() || !a0Var.c.mTransitioning) {
                        z = false;
                    }
                    a0Var.g = z;
                }
                for (a0 a0Var2 : arrayList) {
                    if (this.d) {
                        if (u.M(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Completing non-seekable operation " + a0Var2);
                        }
                        a0Var2.b();
                    } else {
                        if (u.M(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + a0Var2);
                        }
                        a0Var2.a(this.a);
                    }
                    this.d = false;
                    if (!a0Var2.f) {
                        this.c.add(a0Var2);
                    }
                }
                if (!this.b.isEmpty()) {
                    n();
                    ArrayList arrayList2 = new ArrayList(this.b);
                    if (arrayList2.isEmpty()) {
                        return;
                    }
                    this.b.clear();
                    this.c.addAll(arrayList2);
                    if (u.M(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    b(arrayList2, this.e);
                    boolean zK = k(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    boolean z2 = true;
                    while (it2.hasNext()) {
                        if (!((a0) it2.next()).c.mTransitioning) {
                            z2 = false;
                        }
                    }
                    if (!z2 || zK) {
                        z = false;
                    }
                    this.d = z;
                    if (u.M(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Operation seekable = " + zK + " \ntransition = " + z2);
                    }
                    if (!z2) {
                        m(arrayList2);
                        c(arrayList2);
                    } else if (zK) {
                        m(arrayList2);
                        int size = arrayList2.size();
                        for (int i = 0; i < size; i++) {
                            a((a0) arrayList2.get(i));
                        }
                    }
                    this.e = false;
                    if (u.M(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final a0 g(o oVar) {
        Object next;
        Iterator it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            a0 a0Var = (a0) next;
            if (a0Var.c.equals(oVar) && !a0Var.e) {
                break;
            }
        }
        return (a0) next;
    }

    public final a0 h(o oVar) {
        Object next;
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            a0 a0Var = (a0) next;
            if (a0Var.c.equals(oVar) && !a0Var.e) {
                break;
            }
        }
        return (a0) next;
    }

    public final void i() {
        if (u.M(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.a.isAttachedToWindow();
        synchronized (this.b) {
            try {
                n();
                m(this.b);
                ArrayList<a0> arrayList = new ArrayList(this.c);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((a0) it.next()).g = false;
                }
                for (a0 a0Var : arrayList) {
                    if (u.M(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.a + " is not attached to window. ") + "Cancelling running operation " + a0Var);
                    }
                    a0Var.a(this.a);
                }
                ArrayList<a0> arrayList2 = new ArrayList(this.b);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((a0) it2.next()).g = false;
                }
                for (a0 a0Var2 : arrayList2) {
                    if (u.M(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.a + " is not attached to window. ") + "Cancelling pending operation " + a0Var2);
                    }
                    a0Var2.a(this.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l() {
        Object objPrevious;
        synchronized (this.b) {
            try {
                n();
                ArrayList arrayList = this.b;
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    a0 a0Var = (a0) objPrevious;
                    View view = a0Var.c.mView;
                    view.getClass();
                    char c = 4;
                    if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                        int visibility = view.getVisibility();
                        if (visibility == 0) {
                            c = 2;
                        } else if (visibility != 4) {
                            if (visibility != 8) {
                                throw new IllegalArgumentException("Unknown visibility " + visibility);
                            }
                            c = 3;
                        }
                    }
                    if (a0Var.a == 2 && c != 2) {
                        break;
                    }
                }
                a0 a0Var2 = (a0) objPrevious;
                o oVar = a0Var2 != null ? a0Var2.c : null;
                this.f = oVar != null ? oVar.isPostponed() : false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a0 a0Var = (a0) arrayList.get(i);
            x xVar = a0Var.l;
            o oVar = xVar.c;
            if (!a0Var.h) {
                a0Var.h = true;
                int i2 = a0Var.b;
                if (i2 == 2) {
                    View viewFindFocus = oVar.mView.findFocus();
                    if (viewFindFocus != null) {
                        oVar.setFocusedView(viewFindFocus);
                        if (u.M(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + oVar);
                        }
                    }
                    View viewRequireView = a0Var.c.requireView();
                    viewRequireView.getClass();
                    if (viewRequireView.getParent() == null) {
                        if (u.M(2)) {
                            Log.v("FragmentManager", "Adding fragment " + oVar + " view " + viewRequireView + " to container in onStart");
                        }
                        xVar.b();
                        viewRequireView.setAlpha(0.0f);
                    }
                    if (viewRequireView.getAlpha() == 0.0f && viewRequireView.getVisibility() == 0) {
                        if (u.M(2)) {
                            Log.v("FragmentManager", "Making view " + viewRequireView + " INVISIBLE in onStart");
                        }
                        viewRequireView.setVisibility(4);
                    }
                    viewRequireView.setAlpha(oVar.getPostOnViewCreatedAlpha());
                    if (u.M(2)) {
                        Log.v("FragmentManager", "Setting view alpha to " + oVar.getPostOnViewCreatedAlpha() + " in onStart");
                    }
                } else if (i2 == 3) {
                    View viewRequireView2 = oVar.requireView();
                    viewRequireView2.getClass();
                    if (u.M(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView2.findFocus() + " on view " + viewRequireView2 + " for Fragment " + oVar);
                    }
                    viewRequireView2.clearFocus();
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d70.U(((a0) it.next()).k, arrayList2);
        }
        List listY0 = d70.y0(d70.C0(arrayList2));
        int size2 = listY0.size();
        for (int i3 = 0; i3 < size2; i3++) {
            vz3 vz3Var = (vz3) listY0.get(i3);
            vz3Var.getClass();
            ViewGroup viewGroup = this.a;
            viewGroup.getClass();
            if (!vz3Var.a) {
                vz3Var.e(viewGroup);
            }
            vz3Var.a = true;
        }
    }

    public final void n() {
        for (a0 a0Var : this.b) {
            int i = 2;
            if (a0Var.b == 2) {
                View viewRequireView = a0Var.c.requireView();
                viewRequireView.getClass();
                int visibility = viewRequireView.getVisibility();
                if (visibility != 0) {
                    i = 4;
                    if (visibility != 4) {
                        if (visibility != 8) {
                            xe.k(dw2.A(visibility, "Unknown visibility "));
                            return;
                        }
                        i = 3;
                    }
                }
                a0Var.d(i, 1);
            }
        }
    }
}
