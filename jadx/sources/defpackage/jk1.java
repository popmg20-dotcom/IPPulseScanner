package defpackage;

import android.view.ViewParent;
import androidx.fragment.app.a;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jk1 {
    public x90 a;
    public ik1 b;
    public nf3 c;
    public ViewPager2 d;
    public long e = -1;
    public final /* synthetic */ kk1 f;

    public jk1(kk1 kk1Var) {
        this.f = kk1Var;
    }

    public static ViewPager2 a(RecyclerView recyclerView) {
        ViewParent parent = recyclerView.getParent();
        if (parent instanceof ViewPager2) {
            return (ViewPager2) parent;
        }
        s53.j(parent, "Expected ViewPager2 instance. Got: ");
        return null;
    }

    public final void b(boolean z) {
        int currentItem;
        o oVar;
        kk1 kk1Var = this.f;
        ha1 ha1Var = kk1Var.j;
        ff2 ff2Var = kk1Var.f;
        u uVar = kk1Var.e;
        if (uVar.Q() || this.d.getScrollState() != 0 || ff2Var.j() == 0 || kk1Var.b() == 0 || (currentItem = this.d.getCurrentItem()) >= kk1Var.b()) {
            return;
        }
        long j = currentItem;
        if ((j != this.e || z) && (oVar = (o) ff2Var.d(j)) != null && oVar.isAdded()) {
            this.e = j;
            uVar.getClass();
            a aVar = new a(uVar);
            ArrayList<List> arrayList = new ArrayList();
            o oVar2 = null;
            for (int i = 0; i < ff2Var.j(); i++) {
                long jG = ff2Var.g(i);
                o oVar3 = (o) ff2Var.k(i);
                if (oVar3.isAdded()) {
                    if (jG != this.e) {
                        aVar.m(oVar3, q92.A);
                        ha1Var.getClass();
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = ((CopyOnWriteArrayList) ha1Var.f).iterator();
                        if (it.hasNext()) {
                            throw dw2.z(it);
                        }
                        arrayList.add(arrayList2);
                    } else {
                        oVar2 = oVar3;
                    }
                    oVar3.setMenuVisibility(jG == this.e);
                }
            }
            if (oVar2 != null) {
                aVar.m(oVar2, q92.X);
                ha1Var.getClass();
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = ((CopyOnWriteArrayList) ha1Var.f).iterator();
                if (it2.hasNext()) {
                    throw dw2.z(it2);
                }
                arrayList.add(arrayList3);
            }
            if (aVar.a.isEmpty()) {
                return;
            }
            if (aVar.g) {
                xe.q("This transaction is already being added to the back stack");
            } else {
                aVar.h = false;
            }
            aVar.r.A(aVar, false);
            Collections.reverse(arrayList);
            for (List list : arrayList) {
                ha1Var.getClass();
                ha1.x(list);
            }
        }
    }
}
