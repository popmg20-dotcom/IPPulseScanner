package defpackage;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class of3 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ RecyclerView f;

    public /* synthetic */ of3(RecyclerView recyclerView, int i) {
        this.b = i;
        this.f = recyclerView;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0115  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        int i = this.b;
        RecyclerView recyclerView = this.f;
        switch (i) {
            case 0:
                if (recyclerView.O0 && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.M0) {
                        recyclerView.requestLayout();
                    } else if (recyclerView.R0) {
                        recyclerView.Q0 = true;
                    } else {
                        recyclerView.p();
                    }
                    break;
                }
                break;
            default:
                xf3 xf3Var = recyclerView.g1;
                if (xf3Var != null) {
                    yl0 yl0Var = (yl0) xf3Var;
                    long j = yl0Var.d;
                    ArrayList<rg3> arrayList = yl0Var.g;
                    boolean zIsEmpty = arrayList.isEmpty();
                    ArrayList arrayList2 = yl0Var.i;
                    boolean zIsEmpty2 = arrayList2.isEmpty();
                    ArrayList arrayList3 = yl0Var.j;
                    boolean zIsEmpty3 = arrayList3.isEmpty();
                    ArrayList arrayList4 = yl0Var.h;
                    boolean zIsEmpty4 = arrayList4.isEmpty();
                    if (!zIsEmpty || !zIsEmpty2 || !zIsEmpty4 || !zIsEmpty3) {
                        for (rg3 rg3Var : arrayList) {
                            View view = rg3Var.a;
                            ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                            yl0Var.p.add(rg3Var);
                            viewPropertyAnimatorAnimate.setDuration(j).alpha(0.0f).setListener(new tl0(yl0Var, rg3Var, viewPropertyAnimatorAnimate, view)).start();
                            arrayList = arrayList;
                            zIsEmpty = zIsEmpty;
                        }
                        boolean z2 = zIsEmpty;
                        arrayList.clear();
                        if (!zIsEmpty2) {
                            ArrayList arrayList5 = new ArrayList();
                            arrayList5.addAll(arrayList2);
                            yl0Var.l.add(arrayList5);
                            arrayList2.clear();
                            sl0 sl0Var = new sl0(yl0Var, arrayList5, 0);
                            if (z2) {
                                sl0Var.run();
                            } else {
                                View view2 = ((xl0) arrayList5.get(0)).a.a;
                                WeakHashMap weakHashMap = wp4.a;
                                view2.postOnAnimationDelayed(sl0Var, j);
                            }
                        }
                        if (!zIsEmpty3) {
                            ArrayList arrayList6 = new ArrayList();
                            arrayList6.addAll(arrayList3);
                            yl0Var.m.add(arrayList6);
                            arrayList3.clear();
                            tm1 tm1Var = new tm1(6, yl0Var, arrayList6, false);
                            if (z2) {
                                tm1Var.run();
                            } else {
                                View view3 = ((wl0) arrayList6.get(0)).a.a;
                                WeakHashMap weakHashMap2 = wp4.a;
                                view3.postOnAnimationDelayed(tm1Var, j);
                            }
                        }
                        if (zIsEmpty4) {
                            z = false;
                        } else {
                            ArrayList arrayList7 = new ArrayList();
                            arrayList7.addAll(arrayList4);
                            yl0Var.k.add(arrayList7);
                            arrayList4.clear();
                            sl0 sl0Var2 = new sl0(yl0Var, arrayList7, 1);
                            if (z2 && zIsEmpty2 && zIsEmpty3) {
                                sl0Var2.run();
                                z = false;
                            } else {
                                if (z2) {
                                    j = 0;
                                }
                                long jMax = Math.max(!zIsEmpty2 ? yl0Var.e : 0L, zIsEmpty3 ? 0L : yl0Var.f) + j;
                                z = false;
                                View view4 = ((rg3) arrayList7.get(0)).a;
                                WeakHashMap weakHashMap3 = wp4.a;
                                view4.postOnAnimationDelayed(sl0Var2, jMax);
                            }
                        }
                    }
                }
                recyclerView.E1 = z;
                break;
        }
    }
}
