package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;
import defpackage.d70;
import defpackage.dw2;
import defpackage.ie;
import defpackage.lm0;
import defpackage.vz3;
import defpackage.wp4;
import defpackage.xe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.ArrayList r27, boolean r28) {
        /*
            Method dump skipped, instruction units count: 1354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.h.b(java.util.ArrayList, boolean):void");
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
