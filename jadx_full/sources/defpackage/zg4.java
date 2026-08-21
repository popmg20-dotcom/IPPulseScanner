package defpackage;

import android.animation.Animator;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowId;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zg4 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public vg4 b;
    public ViewGroup f;

    /* JADX WARN: Removed duplicated region for block: B:100:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e3 A[EDGE_INSN: B:153:0x01e3->B:90:0x01e3 BREAK  A[LOOP:1: B:19:0x0087->B:89:0x01dc], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ea  */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onPreDraw() {
        ArrayList arrayList;
        int i;
        ie ieVar;
        ie ieVar2;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        pg4 pg4Var;
        boolean z;
        hh4 hh4Var;
        View view;
        View view2;
        boolean z2;
        vg4 vg4Var = this.b;
        ViewGroup viewGroup = this.f;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        boolean z3 = true;
        if (!ah4.c.remove(viewGroup)) {
            return true;
        }
        ie ieVarB = ah4.b();
        ArrayList arrayList2 = (ArrayList) ieVarB.get(viewGroup);
        if (arrayList2 != null) {
            arrayList = arrayList2.size() > 0 ? new ArrayList(arrayList2) : null;
            arrayList2.add(vg4Var);
            vg4Var.a(new yg4(this, ieVarB));
            i = 0;
            vg4Var.i(viewGroup, false);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((vg4) it.next()).H(viewGroup);
                }
            }
            vg4Var.D0 = new ArrayList();
            vg4Var.E0 = new ArrayList();
            ih4 ih4Var = vg4Var.z0;
            ih4 ih4Var2 = vg4Var.A0;
            ieVar = new ie((ie) ih4Var.a);
            ieVar2 = new ie((ie) ih4Var2.a);
            i2 = 0;
            while (true) {
                iArr = vg4Var.C0;
                if (i2 < iArr.length) {
                    break;
                }
                int i6 = iArr[i2];
                if (i6 == z3) {
                    z = z3;
                    for (int i7 = ieVar.z - 1; i7 >= 0; i7--) {
                        View view3 = (View) ieVar.f(i7);
                        if (view3 != null && vg4Var.z(view3) && (hh4Var = (hh4) ieVar2.remove(view3)) != null && vg4Var.z(hh4Var.b)) {
                            vg4Var.D0.add((hh4) ieVar.g(i7));
                            vg4Var.E0.add(hh4Var);
                        }
                    }
                } else if (i6 == 2) {
                    z = z3;
                    ie ieVar3 = (ie) ih4Var.b;
                    ie ieVar4 = (ie) ih4Var2.b;
                    int i8 = ieVar3.z;
                    for (int i9 = 0; i9 < i8; i9++) {
                        View view4 = (View) ieVar3.i(i9);
                        if (view4 != null && vg4Var.z(view4) && (view = (View) ieVar4.get(ieVar3.f(i9))) != null && vg4Var.z(view)) {
                            hh4 hh4Var2 = (hh4) ieVar.get(view4);
                            hh4 hh4Var3 = (hh4) ieVar2.get(view);
                            if (hh4Var2 != null && hh4Var3 != null) {
                                vg4Var.D0.add(hh4Var2);
                                vg4Var.E0.add(hh4Var3);
                                ieVar.remove(view4);
                                ieVar2.remove(view);
                            }
                        }
                    }
                } else if (i6 != 3) {
                    if (i6 == 4) {
                        ff2 ff2Var = (ff2) ih4Var.d;
                        ff2 ff2Var2 = (ff2) ih4Var2.d;
                        int iJ = ff2Var.j();
                        int i10 = i;
                        while (i10 < iJ) {
                            View view5 = (View) ff2Var.k(i10);
                            if (view5 == null || !vg4Var.z(view5)) {
                                z2 = z3;
                            } else {
                                boolean z4 = z3;
                                View view6 = (View) ff2Var2.d(ff2Var.g(i10));
                                if (view6 == null || !vg4Var.z(view6)) {
                                    z2 = z4;
                                } else {
                                    hh4 hh4Var4 = (hh4) ieVar.get(view5);
                                    z2 = z4;
                                    hh4 hh4Var5 = (hh4) ieVar2.get(view6);
                                    if (hh4Var4 != null && hh4Var5 != null) {
                                        vg4Var.D0.add(hh4Var4);
                                        vg4Var.E0.add(hh4Var5);
                                        ieVar.remove(view5);
                                        ieVar2.remove(view6);
                                    }
                                }
                            }
                            i10++;
                            z3 = z2;
                        }
                    }
                    z = z3;
                } else {
                    z = z3;
                    SparseArray sparseArray = (SparseArray) ih4Var.c;
                    SparseArray sparseArray2 = (SparseArray) ih4Var2.c;
                    int size = sparseArray.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        View view7 = (View) sparseArray.valueAt(i11);
                        if (view7 != null && vg4Var.z(view7) && (view2 = (View) sparseArray2.get(sparseArray.keyAt(i11))) != null && vg4Var.z(view2)) {
                            hh4 hh4Var6 = (hh4) ieVar.get(view7);
                            hh4 hh4Var7 = (hh4) ieVar2.get(view2);
                            if (hh4Var6 != null && hh4Var7 != null) {
                                vg4Var.D0.add(hh4Var6);
                                vg4Var.E0.add(hh4Var7);
                                ieVar.remove(view7);
                                ieVar2.remove(view2);
                            }
                        }
                    }
                }
                i2++;
                i = 0;
                z3 = z;
            }
            boolean z5 = z3;
            for (i3 = 0; i3 < ieVar.z; i3++) {
                hh4 hh4Var8 = (hh4) ieVar.i(i3);
                if (vg4Var.z(hh4Var8.b)) {
                    vg4Var.D0.add(hh4Var8);
                    vg4Var.E0.add(null);
                }
            }
            for (i4 = 0; i4 < ieVar2.z; i4++) {
                hh4 hh4Var9 = (hh4) ieVar2.i(i4);
                if (vg4Var.z(hh4Var9.b)) {
                    vg4Var.E0.add(hh4Var9);
                    vg4Var.D0.add(null);
                }
            }
            ie ieVarT = vg4.t();
            int i12 = ieVarT.z;
            WindowId windowId = viewGroup.getWindowId();
            i5 = i12 - 1;
            while (i5 >= 0) {
                Animator animator = (Animator) ieVarT.f(i5);
                if (animator != null && (pg4Var = (pg4) ieVarT.get(animator)) != null) {
                    vg4 vg4Var2 = pg4Var.e;
                    View view8 = pg4Var.a;
                    if (view8 != null && windowId.equals(pg4Var.d)) {
                        hh4 hh4Var10 = pg4Var.c;
                        boolean z6 = z5;
                        hh4 hh4VarV = vg4Var.v(view8, z6);
                        hh4 hh4VarQ = vg4Var.q(view8, z6);
                        if (hh4VarV == null && hh4VarQ == null) {
                            hh4VarQ = (hh4) ((ie) vg4Var.A0.a).get(view8);
                        }
                        if ((hh4VarV != null || hh4VarQ != null) && vg4Var2.y(hh4Var10, hh4VarQ)) {
                            vg4 vg4VarR = vg4Var2.r();
                            ArrayList arrayList3 = vg4Var2.G0;
                            if (vg4VarR.R0 != null) {
                                animator.cancel();
                                arrayList3.remove(animator);
                                ieVarT.remove(animator);
                                if (arrayList3.size() == 0) {
                                    vg4Var2.B(vg4Var2, e04.A, false);
                                    if (!vg4Var2.K0) {
                                        vg4Var2.K0 = true;
                                        vg4Var2.B(vg4Var2, e04.z, false);
                                    }
                                }
                            } else if (animator.isRunning() || animator.isStarted()) {
                                animator.cancel();
                            } else {
                                ieVarT.remove(animator);
                            }
                        }
                    }
                }
                i5--;
                z5 = true;
            }
            vg4Var.m(viewGroup, vg4Var.z0, vg4Var.A0, vg4Var.D0, vg4Var.E0);
            if (vg4Var.R0 != null) {
                vg4Var.J();
                return true;
            }
            if (Build.VERSION.SDK_INT < 34) {
                return true;
            }
            vg4Var.D();
            sg4 sg4Var = vg4Var.R0;
            ch4 ch4Var = sg4Var.g;
            long j = ch4Var.Q0 == 0 ? 1L : 0L;
            ch4Var.K(j, sg4Var.a);
            sg4Var.a = j;
            vg4Var.R0.b = true;
            return true;
        }
        arrayList2 = new ArrayList();
        ieVarB.put(viewGroup, arrayList2);
        arrayList2.add(vg4Var);
        vg4Var.a(new yg4(this, ieVarB));
        i = 0;
        vg4Var.i(viewGroup, false);
        if (arrayList != null) {
        }
        vg4Var.D0 = new ArrayList();
        vg4Var.E0 = new ArrayList();
        ih4 ih4Var3 = vg4Var.z0;
        ih4 ih4Var22 = vg4Var.A0;
        ieVar = new ie((ie) ih4Var3.a);
        ieVar2 = new ie((ie) ih4Var22.a);
        i2 = 0;
        while (true) {
            iArr = vg4Var.C0;
            if (i2 < iArr.length) {
            }
            i2++;
            i = 0;
            z3 = z;
        }
        boolean z52 = z3;
        while (i3 < ieVar.z) {
        }
        while (i4 < ieVar2.z) {
        }
        ie ieVarT2 = vg4.t();
        int i122 = ieVarT2.z;
        WindowId windowId2 = viewGroup.getWindowId();
        i5 = i122 - 1;
        while (i5 >= 0) {
        }
        vg4Var.m(viewGroup, vg4Var.z0, vg4Var.A0, vg4Var.D0, vg4Var.E0);
        if (vg4Var.R0 != null) {
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewGroup viewGroup = this.f;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        ah4.c.remove(viewGroup);
        ArrayList arrayList = (ArrayList) ah4.b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((vg4) it.next()).H(viewGroup);
            }
        }
        this.b.j(true);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
