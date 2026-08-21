package defpackage;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sl0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ yl0 z;

    public /* synthetic */ sl0(yl0 yl0Var, ArrayList arrayList, int i) {
        this.b = i;
        this.z = yl0Var;
        this.f = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        ArrayList arrayList = this.f;
        switch (i) {
            case 0:
                Iterator it = arrayList.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    yl0 yl0Var = this.z;
                    if (!zHasNext) {
                        arrayList.clear();
                        yl0Var.l.remove(arrayList);
                    } else {
                        xl0 xl0Var = (xl0) it.next();
                        rg3 rg3Var = xl0Var.a;
                        int i2 = xl0Var.b;
                        int i3 = xl0Var.c;
                        int i4 = xl0Var.d;
                        int i5 = xl0Var.e;
                        yl0Var.getClass();
                        View view = rg3Var.a;
                        int i6 = i4 - i2;
                        int i7 = i5 - i3;
                        if (i6 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i7 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        yl0Var.o.add(rg3Var);
                        viewPropertyAnimatorAnimate.setDuration(yl0Var.e).setListener(new ul0(yl0Var, rg3Var, i6, view, i7, viewPropertyAnimatorAnimate)).start();
                    }
                    break;
                }
                break;
            default:
                Iterator it2 = arrayList.iterator();
                while (true) {
                    boolean zHasNext2 = it2.hasNext();
                    yl0 yl0Var2 = this.z;
                    if (!zHasNext2) {
                        arrayList.clear();
                        yl0Var2.k.remove(arrayList);
                    } else {
                        rg3 rg3Var2 = (rg3) it2.next();
                        yl0Var2.getClass();
                        View view2 = rg3Var2.a;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view2.animate();
                        yl0Var2.n.add(rg3Var2);
                        viewPropertyAnimatorAnimate2.alpha(1.0f).setDuration(yl0Var2.c).setListener(new tl0(yl0Var2, rg3Var2, view2, viewPropertyAnimatorAnimate2)).start();
                    }
                    break;
                }
                break;
        }
    }
}
