package defpackage;

import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.recyclerview.widget.RecyclerView;
import j$.util.DesugarCollections;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ig3 {
    public final ArrayList a;
    public ArrayList b;
    public final ArrayList c;
    public final List d;
    public int e;
    public int f;
    public hg3 g;
    public final /* synthetic */ RecyclerView h;

    public ig3(RecyclerView recyclerView) {
        this.h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = null;
        this.c = new ArrayList();
        this.d = DesugarCollections.unmodifiableList(arrayList);
        this.e = 2;
        this.f = 2;
    }

    public final void a(rg3 rg3Var, boolean z) {
        RecyclerView.l(rg3Var);
        View view = rg3Var.a;
        RecyclerView recyclerView = this.h;
        tg3 tg3Var = recyclerView.F1;
        if (tg3Var != null) {
            h2 h2VarJ = tg3Var.j();
            wp4.n(view, h2VarJ instanceof sg3 ? (h2) ((sg3) h2VarJ).e.remove(view) : null);
        }
        if (z) {
            ArrayList arrayList = recyclerView.I0;
            if (arrayList.size() > 0) {
                throw qe4.r(arrayList, 0);
            }
            rf3 rf3Var = recyclerView.G0;
            if (rf3Var != null) {
                rf3Var.m(rg3Var);
            }
            if (recyclerView.y1 != null) {
                recyclerView.A0.D(rg3Var);
            }
            if (RecyclerView.U1) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + rg3Var);
            }
        }
        rg3Var.s = null;
        rg3Var.r = null;
        hg3 hg3VarC = c();
        hg3VarC.getClass();
        int i = rg3Var.f;
        ArrayList arrayList2 = hg3VarC.a(i).a;
        ((gg3) hg3VarC.a.get(i)).getClass();
        if (5 <= arrayList2.size()) {
            gb4.p(view);
        } else if (RecyclerView.T1 && arrayList2.contains(rg3Var)) {
            xe.k("this scrap item already exists");
        } else {
            rg3Var.o();
            arrayList2.add(rg3Var);
        }
    }

    public final int b(int i) {
        RecyclerView recyclerView = this.h;
        ng3 ng3Var = recyclerView.y1;
        if (i >= 0 && i < ng3Var.b()) {
            return !ng3Var.g ? i : recyclerView.y0.h(i, 0);
        }
        StringBuilder sbD = dw2.D("invalid position ", i, ". State item count is ");
        sbD.append(ng3Var.b());
        sbD.append(recyclerView.C());
        throw new IndexOutOfBoundsException(sbD.toString());
    }

    public final hg3 c() {
        if (this.g == null) {
            this.g = new hg3();
            e();
        }
        return this.g;
    }

    public final View d(int i) {
        return l(i, Long.MAX_VALUE).a;
    }

    public final void e() {
        RecyclerView recyclerView;
        rf3 rf3Var;
        hg3 hg3Var = this.g;
        if (hg3Var == null || (rf3Var = (recyclerView = this.h).G0) == null || !recyclerView.M0) {
            return;
        }
        hg3Var.c.add(rf3Var);
    }

    public final void f(rf3 rf3Var, boolean z) {
        hg3 hg3Var = this.g;
        if (hg3Var != null) {
            SparseArray sparseArray = hg3Var.a;
            Set set = hg3Var.c;
            set.remove(rf3Var);
            if (set.size() != 0 || z) {
                return;
            }
            for (int i = 0; i < sparseArray.size(); i++) {
                ArrayList arrayList = ((gg3) sparseArray.get(sparseArray.keyAt(i))).a;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    gb4.p(((rg3) arrayList.get(i2)).a);
                }
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            h(size);
        }
        arrayList.clear();
        if (RecyclerView.Y1) {
            r02 r02Var = this.h.x1;
            int[] iArr = (int[]) r02Var.d;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            r02Var.c = 0;
        }
    }

    public final void h(int i) {
        if (RecyclerView.U1) {
            Log.d("RecyclerView", "Recycling cached view at index " + i);
        }
        ArrayList arrayList = this.c;
        rg3 rg3Var = (rg3) arrayList.get(i);
        if (RecyclerView.U1) {
            Log.d("RecyclerView", "CachedViewHolder to be recycled: " + rg3Var);
        }
        a(rg3Var, true);
        arrayList.remove(i);
    }

    public final void i(View view) {
        rg3 rg3VarO = RecyclerView.O(view);
        boolean zL = rg3VarO.l();
        RecyclerView recyclerView = this.h;
        if (zL) {
            recyclerView.removeDetachedView(view, false);
        }
        if (rg3VarO.k()) {
            rg3VarO.n.m(rg3VarO);
        } else if (rg3VarO.r()) {
            rg3VarO.j &= -33;
        }
        j(rg3VarO);
        if (recyclerView.g1 == null || rg3VarO.i()) {
            return;
        }
        recyclerView.g1.d(rg3VarO);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00dc, code lost:
    
        r6 = r6 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(rg3 rg3Var) {
        boolean z;
        boolean z2;
        int i;
        RecyclerView recyclerView = this.h;
        r02 r02Var = recyclerView.x1;
        boolean zK = rg3Var.k();
        View view = rg3Var.a;
        boolean z3 = true;
        if (zK || view.getParent() != null) {
            StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(rg3Var.k());
            sb.append(" isAttached:");
            sb.append(view.getParent() != null);
            sb.append(recyclerView.C());
            throw new IllegalArgumentException(sb.toString());
        }
        if (rg3Var.l()) {
            StringBuilder sb2 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
            sb2.append(rg3Var);
            xe.n(sb2, recyclerView.C());
            return;
        }
        if (rg3Var.q()) {
            xe.k("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.".concat(recyclerView.C()));
            return;
        }
        if ((rg3Var.j & 16) == 0) {
            WeakHashMap weakHashMap = wp4.a;
            z = view.hasTransientState();
        }
        rf3 rf3Var = recyclerView.G0;
        boolean z4 = rf3Var != null && z && rf3Var.k(rg3Var);
        boolean z5 = RecyclerView.T1;
        ArrayList arrayList = this.c;
        if (z5 && arrayList.contains(rg3Var)) {
            StringBuilder sb3 = new StringBuilder("cached view received recycle internal? ");
            sb3.append(rg3Var);
            xe.n(sb3, recyclerView.C());
            return;
        }
        if (z4 || rg3Var.i()) {
            if (this.f <= 0 || (rg3Var.j & 526) != 0) {
                z2 = false;
            } else {
                int size = arrayList.size();
                if (size >= this.f && size > 0) {
                    h(0);
                    size--;
                }
                if (RecyclerView.Y1 && size > 0) {
                    int i2 = rg3Var.c;
                    if (((int[]) r02Var.d) != null) {
                        int i3 = r02Var.c * 2;
                        for (int i4 = 0; i4 < i3; i4 += 2) {
                            if (((int[]) r02Var.d)[i4] == i2) {
                                break;
                            }
                        }
                        i = size - 1;
                        loop1: while (i >= 0) {
                            int i5 = ((rg3) arrayList.get(i)).c;
                            if (((int[]) r02Var.d) == null) {
                                break;
                            }
                            int i6 = r02Var.c * 2;
                            for (int i7 = 0; i7 < i6; i7 += 2) {
                                if (((int[]) r02Var.d)[i7] == i5) {
                                    break;
                                }
                            }
                            break loop1;
                        }
                        size = i + 1;
                    } else {
                        i = size - 1;
                        loop1: while (i >= 0) {
                        }
                        size = i + 1;
                    }
                }
                arrayList.add(size, rg3Var);
                z2 = true;
            }
            if (z2) {
                z3 = false;
            } else {
                a(rg3Var, true);
            }
            z = z2;
        } else {
            if (RecyclerView.U1) {
                Log.d("RecyclerView", "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists".concat(recyclerView.C()));
            }
            z3 = false;
        }
        recyclerView.A0.D(rg3Var);
        if (z || z3 || !z) {
            return;
        }
        gb4.p(view);
        rg3Var.s = null;
        rg3Var.r = null;
    }

    public final void k(View view) {
        rg3 rg3VarO = RecyclerView.O(view);
        int i = rg3VarO.j & 12;
        RecyclerView recyclerView = this.h;
        if (i == 0 && rg3VarO.m() && recyclerView.g1 != null && rg3VarO.e().isEmpty() && !rg3VarO.h()) {
            ArrayList arrayList = this.b;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.b = arrayList;
            }
            rg3VarO.n = this;
            rg3VarO.o = true;
            arrayList.add(rg3VarO);
            return;
        }
        if (rg3VarO.h() && !rg3VarO.j() && !recyclerView.G0.b) {
            xe.k("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.".concat(recyclerView.C()));
            return;
        }
        rg3VarO.n = this;
        rg3VarO.o = false;
        this.a.add(rg3VarO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0631 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008b  */
    /* JADX WARN: Type inference failed for: r7v54 */
    /* JADX WARN: Type inference failed for: r7v56 */
    /* JADX WARN: Type inference failed for: r7v59 */
    /* JADX WARN: Type inference failed for: r7v70 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final rg3 l(int i, long j) {
        rg3 rg3VarI;
        int i2;
        int i3;
        long j2;
        long j3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ViewGroup.LayoutParams layoutParams;
        bg3 bg3Var;
        int i4;
        RecyclerView recyclerViewI;
        rg3 rg3Var;
        rg3 rg3Var2;
        ArrayList arrayList;
        View view;
        ?? r7;
        int size;
        int iH;
        RecyclerView recyclerView = this.h;
        ng3 ng3Var = recyclerView.y1;
        if (i < 0 || i >= ng3Var.b()) {
            StringBuilder sbA = fw.A(i, i, "Invalid item position ", "(", "). Item count:");
            sbA.append(ng3Var.b());
            sbA.append(recyclerView.C());
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        if (ng3Var.g) {
            ArrayList arrayList2 = this.b;
            if (arrayList2 == null || (size = arrayList2.size()) == 0) {
                rg3VarI = null;
                i2 = rg3VarI == null ? 1 : 0;
            } else {
                int i5 = 0;
                while (true) {
                    if (i5 < size) {
                        rg3VarI = (rg3) this.b.get(i5);
                        if (!rg3VarI.r() && rg3VarI.d() == i) {
                            rg3VarI.a(32);
                            break;
                        }
                        i5++;
                    } else if (recyclerView.G0.b && (iH = recyclerView.y0.h(i, 0)) > 0 && iH < recyclerView.G0.b()) {
                        long jC = recyclerView.G0.c(iH);
                        for (int i6 = 0; i6 < size; i6++) {
                            rg3 rg3Var3 = (rg3) this.b.get(i6);
                            if (!rg3Var3.r() && rg3Var3.e == jC) {
                                rg3Var3.a(32);
                                rg3VarI = rg3Var3;
                                break;
                            }
                        }
                    }
                }
                rg3VarI = null;
                if (rg3VarI == null) {
                }
            }
            ArrayList arrayList3 = this.a;
            ArrayList arrayList4 = this.c;
            if (rg3VarI != null) {
                int size2 = arrayList3.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    rg3 rg3Var4 = (rg3) arrayList3.get(i7);
                    if (!rg3Var4.r() && rg3Var4.d() == i && !rg3Var4.h() && (ng3Var.g || !rg3Var4.j())) {
                        rg3Var4.a(32);
                        rg3VarI = rg3Var4;
                        i3 = 1;
                        break;
                    }
                }
                ArrayList arrayList5 = (ArrayList) recyclerView.z0.e;
                int size3 = arrayList5.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size3) {
                        i3 = 1;
                        view = null;
                        break;
                    }
                    view = (View) arrayList5.get(i8);
                    rg3 rg3VarO = RecyclerView.O(view);
                    i3 = 1;
                    if (rg3VarO.d() == i && !rg3VarO.h() && !rg3VarO.j()) {
                        break;
                    }
                    i8++;
                }
                if (view == null) {
                    int size4 = arrayList4.size();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= size4) {
                            rg3VarI = null;
                            break;
                        }
                        rg3 rg3Var5 = (rg3) arrayList4.get(i9);
                        if (rg3Var5.h() || rg3Var5.d() != i || rg3Var5.f()) {
                            i9++;
                        } else {
                            arrayList4.remove(i9);
                            if (RecyclerView.U1) {
                                Log.d("RecyclerView", "getScrapOrHiddenOrCachedHolderForPosition(" + i + ") found match in cache: " + rg3Var5);
                            }
                            rg3VarI = rg3Var5;
                        }
                    }
                } else {
                    rg3 rg3VarO2 = RecyclerView.O(view);
                    j40 j40Var = recyclerView.z0;
                    i40 i40Var = (i40) j40Var.d;
                    int iIndexOfChild = ((gk1) j40Var.c).a.indexOfChild(view);
                    if (iIndexOfChild < 0) {
                        vp1.h(view, "view is not a child, cannot hide ");
                        return null;
                    }
                    if (!i40Var.e(iIndexOfChild)) {
                        throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                    }
                    i40Var.a(iIndexOfChild);
                    j40Var.j(view);
                    j40 j40Var2 = recyclerView.z0;
                    i40 i40Var2 = (i40) j40Var2.d;
                    int iIndexOfChild2 = ((gk1) j40Var2.c).a.indexOfChild(view);
                    int iB = (iIndexOfChild2 == -1 || i40Var2.e(iIndexOfChild2)) ? -1 : iIndexOfChild2 - i40Var2.b(iIndexOfChild2);
                    if (iB == -1) {
                        StringBuilder sb = new StringBuilder("layout index should not be -1 after unhiding a view:");
                        sb.append(rg3VarO2);
                        st4.m(sb, recyclerView.C());
                        return null;
                    }
                    recyclerView.z0.c(iB);
                    k(view);
                    rg3VarO2.a(8224);
                    rg3VarI = rg3VarO2;
                }
                if (rg3VarI != null) {
                    if (!rg3VarI.j()) {
                        int i10 = rg3VarI.c;
                        if (i10 < 0 || i10 >= recyclerView.G0.b()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + rg3VarI + recyclerView.C());
                        }
                        if (ng3Var.g || recyclerView.G0.d(rg3VarI.c) == rg3VarI.f) {
                            rf3 rf3Var = recyclerView.G0;
                            r7 = (!rf3Var.b || rg3VarI.e == rf3Var.c(rg3VarI.c)) ? i3 : 0;
                        }
                    } else {
                        if (RecyclerView.T1 && !ng3Var.g) {
                            xe.q("should not receive a removed view unless it is pre layout".concat(recyclerView.C()));
                            return null;
                        }
                        r7 = ng3Var.g;
                    }
                    if (r7 == 0) {
                        rg3VarI.a(4);
                        if (rg3VarI.k()) {
                            recyclerView.removeDetachedView(rg3VarI.a, false);
                            rg3VarI.n.m(rg3VarI);
                        } else if (rg3VarI.r()) {
                            rg3VarI.j &= -33;
                        }
                        j(rg3VarI);
                        rg3VarI = null;
                    } else {
                        i2 = i3;
                    }
                }
            } else {
                i3 = 1;
            }
            if (rg3VarI != null) {
                int iH2 = recyclerView.y0.h(i, 0);
                if (iH2 >= 0) {
                    j2 = 3;
                    if (iH2 < recyclerView.G0.b()) {
                        int iD = recyclerView.G0.d(iH2);
                        rf3 rf3Var2 = recyclerView.G0;
                        j3 = 4;
                        if (rf3Var2.b) {
                            long jC2 = rf3Var2.c(iH2);
                            int size5 = arrayList3.size() - 1;
                            while (true) {
                                if (size5 >= 0) {
                                    rg3Var2 = (rg3) arrayList3.get(size5);
                                    ArrayList arrayList6 = arrayList3;
                                    long j4 = rg3Var2.e;
                                    View view2 = rg3Var2.a;
                                    if (j4 != jC2 || rg3Var2.r()) {
                                        arrayList = arrayList6;
                                    } else if (iD == rg3Var2.f) {
                                        rg3Var2.a(32);
                                        if (rg3Var2.j() && !ng3Var.g) {
                                            rg3Var2.j = (rg3Var2.j & (-15)) | 2;
                                        }
                                    } else {
                                        arrayList = arrayList6;
                                        arrayList.remove(size5);
                                        recyclerView.removeDetachedView(view2, false);
                                        rg3 rg3VarO3 = RecyclerView.O(view2);
                                        rg3VarO3.n = null;
                                        rg3VarO3.o = false;
                                        rg3VarO3.j &= -33;
                                        j(rg3VarO3);
                                    }
                                    size5--;
                                    arrayList3 = arrayList;
                                } else {
                                    int size6 = arrayList4.size() - 1;
                                    while (true) {
                                        if (size6 < 0) {
                                            break;
                                        }
                                        rg3Var2 = (rg3) arrayList4.get(size6);
                                        if (rg3Var2.e != jC2 || rg3Var2.f()) {
                                            size6--;
                                        } else if (iD == rg3Var2.f) {
                                            arrayList4.remove(size6);
                                        } else {
                                            h(size6);
                                        }
                                    }
                                    rg3VarI = null;
                                }
                            }
                            rg3VarI = rg3Var2;
                            if (rg3VarI != null) {
                                rg3VarI.c = iH2;
                                i2 = i3;
                            }
                        }
                        if (rg3VarI == null) {
                            if (RecyclerView.U1) {
                                Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline(" + i + ") fetching from shared pool");
                            }
                            gg3 gg3Var = (gg3) c().a.get(iD);
                            if (gg3Var != null) {
                                ArrayList arrayList7 = gg3Var.a;
                                if (arrayList7.isEmpty()) {
                                    rg3Var = null;
                                    if (rg3Var != null) {
                                    }
                                    rg3VarI = rg3Var;
                                } else {
                                    for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                                        if (!((rg3) arrayList7.get(size7)).f()) {
                                            rg3Var = (rg3) arrayList7.remove(size7);
                                            break;
                                        }
                                    }
                                    rg3Var = null;
                                    if (rg3Var != null) {
                                        rg3Var.o();
                                        boolean z6 = RecyclerView.T1;
                                    }
                                    rg3VarI = rg3Var;
                                }
                            }
                        }
                        if (rg3VarI == null) {
                            long nanoTime = recyclerView.getNanoTime();
                            if (j != Long.MAX_VALUE) {
                                long j5 = this.g.a(iD).b;
                                if (j5 != 0 && j5 + nanoTime >= j) {
                                    return null;
                                }
                            }
                            rf3 rf3Var3 = recyclerView.G0;
                            rf3Var3.getClass();
                            try {
                                if (zf4.a()) {
                                    Object[] objArr = new Object[i3];
                                    objArr[0] = Integer.valueOf(iD);
                                    Trace.beginSection(String.format("RV onCreateViewHolder type=0x%X", objArr));
                                }
                                rg3VarI = rf3Var3.i(recyclerView, iD);
                                if (rg3VarI.a.getParent() != null) {
                                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                                }
                                rg3VarI.f = iD;
                                Trace.endSection();
                                if (RecyclerView.Y1 && (recyclerViewI = RecyclerView.I(rg3VarI.a)) != null) {
                                    rg3VarI.b = new WeakReference(recyclerViewI);
                                }
                                long nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                                gg3 gg3VarA = this.g.a(iD);
                                long j6 = gg3VarA.b;
                                if (j6 != 0) {
                                    nanoTime2 = (nanoTime2 / 4) + ((j6 / 4) * 3);
                                }
                                gg3VarA.b = nanoTime2;
                                if (RecyclerView.U1) {
                                    Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline created new ViewHolder");
                                }
                            } finally {
                                Trace.endSection();
                            }
                        }
                    }
                }
                StringBuilder sbA2 = fw.A(i, iH2, "Inconsistency detected. Invalid item position ", "(offset:", ").state:");
                sbA2.append(ng3Var.b());
                sbA2.append(recyclerView.C());
                throw new IndexOutOfBoundsException(sbA2.toString());
            }
            j2 = 3;
            j3 = 4;
            View view3 = rg3VarI.a;
            if (i2 != 0 && !ng3Var.g) {
                i4 = rg3VarI.j;
                if ((i4 & 8192) != 0) {
                    rg3VarI.j = i4 & (-8193);
                    if (ng3Var.j) {
                        xf3.b(rg3VarI);
                        xf3 xf3Var = recyclerView.g1;
                        rg3VarI.e();
                        xf3Var.getClass();
                        hm2 hm2Var = new hm2(7);
                        hm2Var.g(rg3VarI);
                        recyclerView.d0(rg3VarI, hm2Var);
                    }
                }
            }
            if (ng3Var.g || !rg3VarI.g()) {
                if (rg3VarI.g() || (rg3VarI.j & 2) != 0 || rg3VarI.h()) {
                    if (!RecyclerView.T1 && rg3VarI.j()) {
                        StringBuilder sb2 = new StringBuilder("Removed holder should be bound and it should come here only in pre-layout. Holder: ");
                        sb2.append(rg3VarI);
                        st4.m(sb2, recyclerView.C());
                        return null;
                    }
                    int iH3 = recyclerView.y0.h(i, 0);
                    rg3VarI.s = null;
                    rg3VarI.r = recyclerView;
                    int i11 = rg3VarI.f;
                    long nanoTime3 = recyclerView.getNanoTime();
                    if (j != Long.MAX_VALUE) {
                        long j7 = this.g.a(i11).c;
                        if (j7 == 0 || j7 + nanoTime3 < j) {
                        }
                    }
                    if (rg3VarI.l()) {
                        z = false;
                    } else {
                        recyclerView.attachViewToParent(view3, recyclerView.getChildCount(), view3.getLayoutParams());
                        z = true;
                    }
                    rf3 rf3Var4 = recyclerView.G0;
                    rf3Var4.getClass();
                    z2 = rg3VarI.s != null;
                    if (!z2) {
                        rg3VarI.c = iH3;
                        if (rf3Var4.b) {
                            rg3VarI.e = rf3Var4.c(iH3);
                        }
                        rg3VarI.j = (rg3VarI.j & (-520)) | 1;
                        if (zf4.a()) {
                            z3 = false;
                            Trace.beginSection(String.format("RV onBindViewHolder type=0x%X", Integer.valueOf(rg3VarI.f)));
                        } else {
                            z3 = false;
                        }
                        rg3VarI.s = rf3Var4;
                        if (RecyclerView.T1) {
                            if (view3.getParent() == null && view3.isAttachedToWindow() != rg3VarI.l()) {
                                throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + rg3VarI.l() + ", attached to window: " + view3.isAttachedToWindow() + ", holder: " + rg3VarI);
                            }
                            if (view3.getParent() == null && view3.isAttachedToWindow()) {
                                s53.j(rg3VarI, "Attempting to bind attached holder with no parent (AKA temp detached): ");
                                return null;
                            }
                        }
                        rf3Var4.h(rg3VarI, iH3, rg3VarI.e());
                        if (z2) {
                            ArrayList arrayList8 = rg3VarI.k;
                            if (arrayList8 != null) {
                                arrayList8.clear();
                            }
                            rg3VarI.j &= -1025;
                            ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                            if (layoutParams2 instanceof bg3) {
                                ((bg3) layoutParams2).c = true;
                            }
                        }
                        if (z) {
                            recyclerView.detachViewFromParent(view3);
                        }
                        long nanoTime4 = recyclerView.getNanoTime() - nanoTime3;
                        gg3 gg3VarA2 = this.g.a(rg3VarI.f);
                        long j8 = gg3VarA2.c;
                        if (j8 != 0) {
                            nanoTime4 = (nanoTime4 / j3) + ((j8 / j3) * j2);
                        }
                        gg3VarA2.c = nanoTime4;
                        AccessibilityManager accessibilityManager = recyclerView.V0;
                        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                            z4 = true;
                        } else {
                            z4 = true;
                            if (view3.getImportantForAccessibility() == 0) {
                                view3.setImportantForAccessibility(1);
                            }
                            tg3 tg3Var = recyclerView.F1;
                            if (tg3Var != null) {
                                h2 h2VarJ = tg3Var.j();
                                if (h2VarJ instanceof sg3) {
                                    sg3 sg3Var = (sg3) h2VarJ;
                                    View.AccessibilityDelegate accessibilityDelegateE = wp4.e(view3);
                                    h2 h2Var = accessibilityDelegateE == null ? null : accessibilityDelegateE instanceof g2 ? ((g2) accessibilityDelegateE).a : new h2(accessibilityDelegateE);
                                    if (h2Var != null && h2Var != sg3Var) {
                                        sg3Var.e.put(view3, h2Var);
                                    }
                                }
                                wp4.n(view3, h2VarJ);
                            }
                        }
                        if (ng3Var.g) {
                            rg3VarI.g = i;
                        }
                        z5 = z4;
                    }
                }
                layoutParams = view3.getLayoutParams();
                if (layoutParams == null) {
                    bg3Var = (bg3) recyclerView.generateDefaultLayoutParams();
                    view3.setLayoutParams(bg3Var);
                } else if (recyclerView.checkLayoutParams(layoutParams)) {
                    bg3Var = (bg3) layoutParams;
                } else {
                    bg3Var = (bg3) recyclerView.generateLayoutParams(layoutParams);
                    view3.setLayoutParams(bg3Var);
                }
                bg3Var.a = rg3VarI;
                bg3Var.d = (i2 == 0 || !z5) ? z3 : z4;
                return rg3VarI;
            }
            rg3VarI.g = i;
            z5 = false;
            z4 = true;
            z3 = false;
            layoutParams = view3.getLayoutParams();
            if (layoutParams == null) {
            }
            bg3Var.a = rg3VarI;
            bg3Var.d = (i2 == 0 || !z5) ? z3 : z4;
            return rg3VarI;
        }
        rg3VarI = null;
        ArrayList arrayList32 = this.a;
        ArrayList arrayList42 = this.c;
        if (rg3VarI != null) {
        }
        if (rg3VarI != null) {
        }
        View view32 = rg3VarI.a;
        if (i2 != 0) {
            i4 = rg3VarI.j;
            if ((i4 & 8192) != 0) {
            }
        }
        if (ng3Var.g) {
            if (rg3VarI.g()) {
                if (!RecyclerView.T1) {
                }
                int iH32 = recyclerView.y0.h(i, 0);
                rg3VarI.s = null;
                rg3VarI.r = recyclerView;
                int i112 = rg3VarI.f;
                long nanoTime32 = recyclerView.getNanoTime();
                if (j != Long.MAX_VALUE) {
                }
                if (rg3VarI.l()) {
                }
                rf3 rf3Var42 = recyclerView.G0;
                rf3Var42.getClass();
                if (rg3VarI.s != null) {
                }
                if (!z2) {
                }
            }
        }
        layoutParams = view32.getLayoutParams();
        if (layoutParams == null) {
        }
        bg3Var.a = rg3VarI;
        bg3Var.d = (i2 == 0 || !z5) ? z3 : z4;
        return rg3VarI;
    }

    public final void m(rg3 rg3Var) {
        if (rg3Var.o) {
            this.b.remove(rg3Var);
        } else {
            this.a.remove(rg3Var);
        }
        rg3Var.n = null;
        rg3Var.o = false;
        rg3Var.j &= -33;
    }

    public final void n() {
        ag3 ag3Var = this.h.H0;
        this.f = this.e + (ag3Var != null ? ag3Var.j : 0);
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f; size--) {
            h(size);
        }
    }
}
