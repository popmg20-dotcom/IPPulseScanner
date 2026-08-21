package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import defpackage.d70;
import defpackage.dw2;
import defpackage.fw;
import defpackage.vz3;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {
    public int a;
    public int b;
    public final o c;
    public final ArrayList d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final ArrayList j;
    public final ArrayList k;
    public final x l;

    public a0(int i, int i2, x xVar) {
        if (i == 0 || i2 == 0) {
            throw null;
        }
        o oVar = xVar.c;
        if (i == 0 || i2 == 0) {
            throw null;
        }
        this.a = i;
        this.b = i2;
        this.c = oVar;
        this.d = new ArrayList();
        this.i = true;
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        this.k = arrayList;
        this.l = xVar;
    }

    public final void a(ViewGroup viewGroup) {
        viewGroup.getClass();
        this.h = false;
        if (this.e) {
            return;
        }
        this.e = true;
        if (this.j.isEmpty()) {
            b();
            return;
        }
        for (vz3 vz3Var : d70.y0(this.k)) {
            vz3Var.getClass();
            if (!vz3Var.b) {
                vz3Var.b(viewGroup);
            }
            vz3Var.b = true;
        }
    }

    public final void b() {
        this.h = false;
        if (!this.f) {
            if (u.M(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f = true;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.c.mTransitioning = false;
        this.l.k();
    }

    public final void c(vz3 vz3Var) {
        vz3Var.getClass();
        ArrayList arrayList = this.j;
        if (arrayList.remove(vz3Var) && arrayList.isEmpty()) {
            b();
        }
    }

    public final void d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            throw null;
        }
        int iG = fw.G(i2);
        o oVar = this.c;
        if (iG == 0) {
            if (this.a != 1) {
                if (u.M(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + oVar + " mFinalState = " + dw2.K(this.a) + " -> " + dw2.K(i) + '.');
                }
                this.a = i;
                return;
            }
            return;
        }
        if (iG == 1) {
            if (this.a == 1) {
                if (u.M(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + oVar + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + dw2.J(this.b) + " to ADDING.");
                }
                this.a = 2;
                this.b = 2;
                this.i = true;
                return;
            }
            return;
        }
        if (iG != 2) {
            return;
        }
        if (u.M(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + oVar + " mFinalState = " + dw2.K(this.a) + " -> REMOVED. mLifecycleImpact  = " + dw2.J(this.b) + " to REMOVING.");
        }
        this.a = 1;
        this.b = 3;
        this.i = true;
    }

    public final String toString() {
        StringBuilder sbD = fw.D("Operation {", Integer.toHexString(System.identityHashCode(this)), "} {finalState = ");
        sbD.append(dw2.K(this.a));
        sbD.append(" lifecycleImpact = ");
        sbD.append(dw2.J(this.b));
        sbD.append(" fragment = ");
        sbD.append(this.c);
        sbD.append('}');
        return sbD.toString();
    }
}
