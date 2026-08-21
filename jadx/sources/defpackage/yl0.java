package defpackage;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yl0 extends xf3 {
    public static TimeInterpolator r;
    public final ArrayList g;
    public final ArrayList h;
    public final ArrayList i;
    public final ArrayList j;
    public final ArrayList k;
    public final ArrayList l;
    public final ArrayList m;
    public final ArrayList n;
    public final ArrayList o;
    public final ArrayList p;
    public final ArrayList q;

    public yl0() {
        this.a = null;
        this.b = new ArrayList();
        this.c = 120L;
        this.d = 120L;
        this.e = 250L;
        this.f = 250L;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = new ArrayList();
    }

    public static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((rg3) arrayList.get(size)).a.animate().cancel();
        }
    }

    @Override // defpackage.xf3
    public final boolean a(rg3 rg3Var, rg3 rg3Var2, hm2 hm2Var, hm2 hm2Var2) {
        int i;
        int i2;
        int i3 = hm2Var.b;
        int i4 = hm2Var.c;
        if (rg3Var2.q()) {
            int i5 = hm2Var.b;
            i2 = hm2Var.c;
            i = i5;
        } else {
            i = hm2Var2.b;
            i2 = hm2Var2.c;
        }
        if (rg3Var == rg3Var2) {
            return g(rg3Var, i3, i4, i, i2);
        }
        View view = rg3Var.a;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        l(rg3Var);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        View view2 = rg3Var2.a;
        l(rg3Var2);
        view2.setTranslationX(-((int) ((i - i3) - translationX)));
        view2.setTranslationY(-((int) ((i2 - i4) - translationY)));
        view2.setAlpha(0.0f);
        wl0 wl0Var = new wl0();
        wl0Var.a = rg3Var;
        wl0Var.b = rg3Var2;
        wl0Var.c = i3;
        wl0Var.d = i4;
        wl0Var.e = i;
        wl0Var.f = i2;
        this.j.add(wl0Var);
        return true;
    }

    @Override // defpackage.xf3
    public final void d(rg3 rg3Var) {
        View view = rg3Var.a;
        view.animate().cancel();
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((xl0) arrayList.get(size)).a == rg3Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(rg3Var);
                arrayList.remove(size);
            }
        }
        j(this.j, rg3Var);
        if (this.g.remove(rg3Var)) {
            view.setAlpha(1.0f);
            c(rg3Var);
        }
        if (this.h.remove(rg3Var)) {
            view.setAlpha(1.0f);
            c(rg3Var);
        }
        ArrayList arrayList2 = this.m;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            j(arrayList3, rg3Var);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.l;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((xl0) arrayList5.get(size4)).a == rg3Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(rg3Var);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.k;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(rg3Var)) {
                view.setAlpha(1.0f);
                c(rg3Var);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.p.remove(rg3Var);
        this.n.remove(rg3Var);
        this.q.remove(rg3Var);
        this.o.remove(rg3Var);
        i();
    }

    @Override // defpackage.xf3
    public final void e() {
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            xl0 xl0Var = (xl0) arrayList.get(size);
            View view = xl0Var.a.a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(xl0Var.a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.g;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c((rg3) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.h;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            rg3 rg3Var = (rg3) arrayList3.get(size3);
            rg3Var.a.setAlpha(1.0f);
            c(rg3Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.j;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            wl0 wl0Var = (wl0) arrayList4.get(size4);
            rg3 rg3Var2 = wl0Var.a;
            if (rg3Var2 != null) {
                k(wl0Var, rg3Var2);
            }
            rg3 rg3Var3 = wl0Var.b;
            if (rg3Var3 != null) {
                k(wl0Var, rg3Var3);
            }
        }
        arrayList4.clear();
        if (f()) {
            ArrayList arrayList5 = this.l;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    xl0 xl0Var2 = (xl0) arrayList6.get(size6);
                    View view2 = xl0Var2.a.a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(xl0Var2.a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.k;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    rg3 rg3Var4 = (rg3) arrayList8.get(size8);
                    rg3Var4.a.setAlpha(1.0f);
                    c(rg3Var4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.m;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    wl0 wl0Var2 = (wl0) arrayList10.get(size10);
                    rg3 rg3Var5 = wl0Var2.a;
                    if (rg3Var5 != null) {
                        k(wl0Var2, rg3Var5);
                    }
                    rg3 rg3Var6 = wl0Var2.b;
                    if (rg3Var6 != null) {
                        k(wl0Var2, rg3Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            h(this.p);
            h(this.o);
            h(this.n);
            h(this.q);
            ArrayList arrayList11 = this.b;
            if (arrayList11.size() > 0) {
                throw qe4.r(arrayList11, 0);
            }
            arrayList11.clear();
        }
    }

    @Override // defpackage.xf3
    public final boolean f() {
        return (this.h.isEmpty() && this.j.isEmpty() && this.i.isEmpty() && this.g.isEmpty() && this.o.isEmpty() && this.p.isEmpty() && this.n.isEmpty() && this.q.isEmpty() && this.l.isEmpty() && this.k.isEmpty() && this.m.isEmpty()) ? false : true;
    }

    public final boolean g(rg3 rg3Var, int i, int i2, int i3, int i4) {
        View view = rg3Var.a;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) rg3Var.a.getTranslationY());
        l(rg3Var);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            c(rg3Var);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        xl0 xl0Var = new xl0();
        xl0Var.a = rg3Var;
        xl0Var.b = translationX;
        xl0Var.c = translationY;
        xl0Var.d = i3;
        xl0Var.e = i4;
        this.i.add(xl0Var);
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList arrayList = this.b;
        if (arrayList.size() > 0) {
            throw qe4.r(arrayList, 0);
        }
        arrayList.clear();
    }

    public final void j(ArrayList arrayList, rg3 rg3Var) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            wl0 wl0Var = (wl0) arrayList.get(size);
            if (k(wl0Var, rg3Var) && wl0Var.a == null && wl0Var.b == null) {
                arrayList.remove(wl0Var);
            }
        }
    }

    public final boolean k(wl0 wl0Var, rg3 rg3Var) {
        if (wl0Var.b == rg3Var) {
            wl0Var.b = null;
        } else {
            if (wl0Var.a != rg3Var) {
                return false;
            }
            wl0Var.a = null;
        }
        View view = rg3Var.a;
        View view2 = rg3Var.a;
        view.setAlpha(1.0f);
        view2.setTranslationX(0.0f);
        view2.setTranslationY(0.0f);
        c(rg3Var);
        return true;
    }

    public final void l(rg3 rg3Var) {
        if (r == null) {
            r = new ValueAnimator().getInterpolator();
        }
        rg3Var.a.animate().setInterpolator(r);
        d(rg3Var);
    }
}
