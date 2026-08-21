package defpackage;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import j$.util.DesugarCollections;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pf3 {
    public final /* synthetic */ RecyclerView a;

    public /* synthetic */ pf3(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void a(j5 j5Var) {
        int i = j5Var.a;
        RecyclerView recyclerView = this.a;
        if (i == 1) {
            recyclerView.H0.d0(j5Var.b, j5Var.d);
            return;
        }
        if (i == 2) {
            recyclerView.H0.g0(j5Var.b, j5Var.d);
        } else if (i == 4) {
            recyclerView.H0.h0(j5Var.b, j5Var.d);
        } else {
            if (i != 8) {
                return;
            }
            recyclerView.H0.f0(j5Var.b, j5Var.d);
        }
    }

    public rg3 b(int i) {
        RecyclerView recyclerView = this.a;
        int iH = recyclerView.z0.h();
        int i2 = 0;
        rg3 rg3Var = null;
        while (true) {
            if (i2 >= iH) {
                break;
            }
            rg3 rg3VarO = RecyclerView.O(recyclerView.z0.g(i2));
            if (rg3VarO != null && !rg3VarO.j() && rg3VarO.c == i) {
                if (!((ArrayList) recyclerView.z0.e).contains(rg3VarO.a)) {
                    rg3Var = rg3VarO;
                    break;
                }
                rg3Var = rg3VarO;
            }
            i2++;
        }
        if (rg3Var != null) {
            if (!((ArrayList) recyclerView.z0.e).contains(rg3Var.a)) {
                return rg3Var;
            }
            if (RecyclerView.U1) {
                Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
            }
        }
        return null;
    }

    public void c(int i, int i2, Object obj) {
        int i3;
        int i4;
        RecyclerView recyclerView = this.a;
        int iH = recyclerView.z0.h();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < iH; i6++) {
            View viewG = recyclerView.z0.g(i6);
            rg3 rg3VarO = RecyclerView.O(viewG);
            if (rg3VarO != null && !rg3VarO.q() && (i4 = rg3VarO.c) >= i && i4 < i5) {
                rg3VarO.a(2);
                if (obj == null) {
                    rg3VarO.a(1024);
                } else if ((1024 & rg3VarO.j) == 0) {
                    if (rg3VarO.k == null) {
                        ArrayList arrayList = new ArrayList();
                        rg3VarO.k = arrayList;
                        rg3VarO.l = DesugarCollections.unmodifiableList(arrayList);
                    }
                    rg3VarO.k.add(obj);
                }
                ((bg3) viewG.getLayoutParams()).c = true;
            }
        }
        ig3 ig3Var = recyclerView.z;
        ArrayList arrayList2 = ig3Var.c;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            rg3 rg3Var = (rg3) arrayList2.get(size);
            if (rg3Var != null && (i3 = rg3Var.c) >= i && i3 < i5) {
                rg3Var.a(2);
                ig3Var.h(size);
            }
        }
        recyclerView.C1 = true;
    }

    public void d(int i, int i2) {
        RecyclerView recyclerView = this.a;
        int iH = recyclerView.z0.h();
        for (int i3 = 0; i3 < iH; i3++) {
            rg3 rg3VarO = RecyclerView.O(recyclerView.z0.g(i3));
            if (rg3VarO != null && !rg3VarO.q() && rg3VarO.c >= i) {
                if (RecyclerView.U1) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i3 + " holder " + rg3VarO + " now at position " + (rg3VarO.c + i2));
                }
                rg3VarO.n(i2, false);
                recyclerView.y1.f = true;
            }
        }
        ArrayList arrayList = recyclerView.z.c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            rg3 rg3Var = (rg3) arrayList.get(i4);
            if (rg3Var != null && rg3Var.c >= i) {
                if (RecyclerView.U1) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i4 + " holder " + rg3Var + " now at position " + (rg3Var.c + i2));
                }
                rg3Var.n(i2, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.B1 = true;
    }

    public void e(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        RecyclerView recyclerView = this.a;
        int iH = recyclerView.z0.h();
        int i10 = -1;
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i11 = 0; i11 < iH; i11++) {
            rg3 rg3VarO = RecyclerView.O(recyclerView.z0.g(i11));
            if (rg3VarO != null && (i9 = rg3VarO.c) >= i4 && i9 <= i3) {
                if (RecyclerView.U1) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i11 + " holder " + rg3VarO);
                }
                if (rg3VarO.c == i) {
                    rg3VarO.n(i2 - i, false);
                } else {
                    rg3VarO.n(i5, false);
                }
                recyclerView.y1.f = true;
            }
        }
        ArrayList arrayList = recyclerView.z.c;
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i10 = 1;
        }
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            rg3 rg3Var = (rg3) arrayList.get(i12);
            if (rg3Var != null && (i8 = rg3Var.c) >= i7 && i8 <= i6) {
                if (i8 == i) {
                    rg3Var.n(i2 - i, false);
                } else {
                    rg3Var.n(i10, false);
                }
                if (RecyclerView.U1) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i12 + " holder " + rg3Var);
                }
            }
        }
        recyclerView.requestLayout();
        recyclerView.B1 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(defpackage.rg3 r8, defpackage.hm2 r9, defpackage.hm2 r10) {
        /*
            r7 = this;
            r0 = 0
            r8.p(r0)
            androidx.recyclerview.widget.RecyclerView r7 = r7.a
            xf3 r0 = r7.g1
            r1 = r0
            yl0 r1 = (defpackage.yl0) r1
            if (r9 == 0) goto L1d
            r1.getClass()
            int r3 = r9.b
            int r5 = r10.b
            if (r3 != r5) goto L1f
            int r0 = r9.c
            int r2 = r10.c
            if (r0 == r2) goto L1d
            goto L1f
        L1d:
            r2 = r8
            goto L29
        L1f:
            int r4 = r9.c
            int r6 = r10.c
            r2 = r8
            boolean r8 = r1.g(r2, r3, r4, r5, r6)
            goto L38
        L29:
            r1.l(r2)
            android.view.View r8 = r2.a
            r9 = 0
            r8.setAlpha(r9)
            java.util.ArrayList r8 = r1.h
            r8.add(r2)
            r8 = 1
        L38:
            if (r8 == 0) goto L3d
            r7.a0()
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pf3.f(rg3, hm2, hm2):void");
    }

    public void g(rg3 rg3Var, hm2 hm2Var, hm2 hm2Var2) {
        boolean zG;
        RecyclerView recyclerView = this.a;
        recyclerView.z.m(rg3Var);
        recyclerView.h(rg3Var);
        rg3Var.p(false);
        yl0 yl0Var = (yl0) recyclerView.g1;
        yl0Var.getClass();
        int i = hm2Var.b;
        int i2 = hm2Var.c;
        View view = rg3Var.a;
        int left = hm2Var2 == null ? view.getLeft() : hm2Var2.b;
        int top = hm2Var2 == null ? view.getTop() : hm2Var2.c;
        if (rg3Var.j() || (i == left && i2 == top)) {
            yl0Var.l(rg3Var);
            yl0Var.g.add(rg3Var);
            zG = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zG = yl0Var.g(rg3Var, i, i2, left, top);
        }
        if (zG) {
            recyclerView.a0();
        }
    }
}
