package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j40 {
    public final /* synthetic */ int a;
    public int b;
    public final Object c;
    public final Object d;
    public final Object e;
    public Object f;

    public j40(List list, HashSet hashSet, int i) {
        this.a = 1;
        byte[] bArr = new byte[64];
        this.d = bArr;
        this.b = i;
        bArr[0] = 64;
        this.f = new hm2[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((hm2[]) this.f)[i2] = new hm2(i2, ((n70) list.get(i2)).e, 1);
        }
        this.e = new int[i];
        int i3 = 0;
        for (short s = 0; s < i; s = (short) (s + 1)) {
            boolean zContains = hashSet.contains(Short.valueOf(s));
            int[] iArr = (int[]) this.e;
            if (zContains) {
                iArr[s] = i3;
                i3 += 16;
            } else {
                iArr[s] = -1;
            }
        }
        this.c = new q70((short) 513, (short) 84, (((hm2[]) this.f).length * 16) + (((int[]) this.e).length * 4) + 84);
    }

    public void a(View view, int i, boolean z) {
        RecyclerView recyclerView = ((gk1) this.c).a;
        int childCount = i < 0 ? recyclerView.getChildCount() : f(i);
        ((i40) this.d).f(childCount, z);
        if (z) {
            i(view);
        }
        recyclerView.addView(view, childCount);
        rg3 rg3VarO = RecyclerView.O(view);
        rf3 rf3Var = recyclerView.G0;
        if (rf3Var != null && rg3VarO != null) {
            rf3Var.l(rg3VarO);
        }
        ArrayList arrayList = recyclerView.W0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((cg3) recyclerView.W0.get(size)).d(view);
            }
        }
    }

    public void b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView recyclerView = ((gk1) this.c).a;
        int childCount = i < 0 ? recyclerView.getChildCount() : f(i);
        ((i40) this.d).f(childCount, z);
        if (z) {
            i(view);
        }
        rg3 rg3VarO = RecyclerView.O(view);
        if (rg3VarO != null) {
            if (!rg3VarO.l() && !rg3VarO.q()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(rg3VarO);
                xe.n(sb, recyclerView.C());
                return;
            } else {
                if (RecyclerView.U1) {
                    Log.d("RecyclerView", "reAttach " + rg3VarO);
                }
                rg3VarO.j &= -257;
            }
        } else if (RecyclerView.T1) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            String strC = recyclerView.C();
            sb2.append(", index: ");
            sb2.append(childCount);
            sb2.append(strC);
            throw new IllegalArgumentException(sb2.toString());
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public void c(int i) {
        int iF = f(i);
        ((i40) this.d).h(iF);
        RecyclerView recyclerView = ((gk1) this.c).a;
        View childAt = recyclerView.getChildAt(iF);
        if (childAt != null) {
            rg3 rg3VarO = RecyclerView.O(childAt);
            if (rg3VarO != null) {
                if (rg3VarO.l() && !rg3VarO.q()) {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(rg3VarO);
                    xe.n(sb, recyclerView.C());
                    return;
                } else {
                    if (RecyclerView.U1) {
                        Log.d("RecyclerView", "tmpDetach " + rg3VarO);
                    }
                    rg3VarO.a(256);
                }
            }
        } else if (RecyclerView.T1) {
            throw new IllegalArgumentException("No view at offset " + iF + recyclerView.C());
        }
        recyclerView.detachViewFromParent(iF);
    }

    public View d(int i) {
        return ((gk1) this.c).a.getChildAt(f(i));
    }

    public int e() {
        return ((gk1) this.c).a.getChildCount() - ((ArrayList) this.e).size();
    }

    public int f(int i) {
        i40 i40Var = (i40) this.d;
        if (i < 0) {
            return -1;
        }
        int childCount = ((gk1) this.c).a.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int iB = i - (i2 - i40Var.b(i2));
            if (iB == 0) {
                while (i40Var.e(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iB;
        }
        return -1;
    }

    public View g(int i) {
        return ((gk1) this.c).a.getChildAt(i);
    }

    public int h() {
        return ((gk1) this.c).a.getChildCount();
    }

    public void i(View view) {
        ((ArrayList) this.e).add(view);
        gk1 gk1Var = (gk1) this.c;
        rg3 rg3VarO = RecyclerView.O(view);
        if (rg3VarO != null) {
            View view2 = rg3VarO.a;
            RecyclerView recyclerView = gk1Var.a;
            int i = rg3VarO.q;
            if (i != -1) {
                rg3VarO.p = i;
            } else {
                rg3VarO.p = view2.getImportantForAccessibility();
            }
            if (!recyclerView.T()) {
                view2.setImportantForAccessibility(4);
            } else {
                rg3VarO.q = 4;
                recyclerView.L1.add(rg3VarO);
            }
        }
    }

    public void j(View view) {
        if (((ArrayList) this.e).remove(view)) {
            gk1 gk1Var = (gk1) this.c;
            rg3 rg3VarO = RecyclerView.O(view);
            if (rg3VarO != null) {
                RecyclerView recyclerView = gk1Var.a;
                int i = rg3VarO.p;
                if (recyclerView.T()) {
                    rg3VarO.q = i;
                    recyclerView.L1.add(rg3VarO);
                } else {
                    rg3VarO.a.setImportantForAccessibility(i);
                }
                rg3VarO.p = 0;
            }
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return ((i40) this.d).toString() + ", hidden list:" + ((ArrayList) this.e).size();
            default:
                return super.toString();
        }
    }

    public j40(gk1 gk1Var) {
        this.a = 0;
        this.b = 0;
        this.c = gk1Var;
        this.d = new i40();
        this.e = new ArrayList();
    }
}
