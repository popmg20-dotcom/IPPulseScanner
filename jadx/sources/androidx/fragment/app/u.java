package androidx.fragment.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.u;
import com.getsurfboard.R;
import defpackage.ad0;
import defpackage.ai;
import defpackage.bk1;
import defpackage.c90;
import defpackage.cg0;
import defpackage.d7;
import defpackage.da2;
import defpackage.dd0;
import defpackage.dh3;
import defpackage.dw2;
import defpackage.eg0;
import defpackage.ek1;
import defpackage.f33;
import defpackage.fv2;
import defpackage.fw;
import defpackage.gv2;
import defpackage.ha0;
import defpackage.ha1;
import defpackage.hp3;
import defpackage.ih4;
import defpackage.ij1;
import defpackage.j50;
import defpackage.kj1;
import defpackage.kp3;
import defpackage.me2;
import defpackage.mj1;
import defpackage.mk1;
import defpackage.mv2;
import defpackage.n4;
import defpackage.nk1;
import defpackage.oj1;
import defpackage.oq4;
import defpackage.pj1;
import defpackage.pq4;
import defpackage.q92;
import defpackage.qk2;
import defpackage.rj1;
import defpackage.sj1;
import defpackage.tj1;
import defpackage.vj1;
import defpackage.w4;
import defpackage.wu2;
import defpackage.x4;
import defpackage.xe;
import defpackage.xu2;
import defpackage.y4;
import defpackage.yj1;
import defpackage.yu2;
import defpackage.zf2;
import defpackage.zj1;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public o A;
    public w4 D;
    public w4 E;
    public w4 F;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public ArrayList M;
    public ArrayList N;
    public ArrayList O;
    public v P;
    public boolean b;
    public ArrayList e;
    public wu2 g;
    public final rj1 r;
    public final rj1 s;
    public final rj1 t;
    public final rj1 u;
    public pj1 x;
    public mj1 y;
    public o z;
    public final ArrayList a = new ArrayList();
    public final y c = new y();
    public ArrayList d = new ArrayList();
    public final r f = new r(this);
    public a h = null;
    public boolean i = false;
    public final s j = new s(this);
    public final AtomicInteger k = new AtomicInteger();
    public final Map l = DesugarCollections.synchronizedMap(new HashMap());
    public final Map m = DesugarCollections.synchronizedMap(new HashMap());
    public final Map n = DesugarCollections.synchronizedMap(new HashMap());
    public final ArrayList o = new ArrayList();
    public final eg0 p = new eg0(this);
    public final CopyOnWriteArrayList q = new CopyOnWriteArrayList();
    public final sj1 v = new sj1(this);
    public int w = -1;
    public final tj1 B = new tj1(this);
    public final d7 C = new d7(20);
    public ArrayDeque G = new ArrayDeque();
    public final f33 Q = new f33(11, this);

    /* JADX WARN: Type inference failed for: r0v17, types: [rj1] */
    /* JADX WARN: Type inference failed for: r0v18, types: [rj1] */
    /* JADX WARN: Type inference failed for: r0v19, types: [rj1] */
    /* JADX WARN: Type inference failed for: r0v20, types: [rj1] */
    public u() {
        final int i = 0;
        this.r = new dd0(this) { // from class: rj1
            public final /* synthetic */ u b;

            {
                this.b = this;
            }

            @Override // defpackage.dd0
            public final void accept(Object obj) {
                int i2 = i;
                u uVar = this.b;
                switch (i2) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (uVar.O()) {
                            uVar.i(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (uVar.O() && num.intValue() == 80) {
                            uVar.m(false);
                            break;
                        }
                        break;
                    case 2:
                        dn2 dn2Var = (dn2) obj;
                        if (uVar.O()) {
                            uVar.n(dn2Var.a, false);
                        }
                        break;
                    default:
                        f13 f13Var = (f13) obj;
                        if (uVar.O()) {
                            uVar.s(f13Var.a, false);
                        }
                        break;
                }
            }
        };
        final int i2 = 1;
        this.s = new dd0(this) { // from class: rj1
            public final /* synthetic */ u b;

            {
                this.b = this;
            }

            @Override // defpackage.dd0
            public final void accept(Object obj) {
                int i22 = i2;
                u uVar = this.b;
                switch (i22) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (uVar.O()) {
                            uVar.i(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (uVar.O() && num.intValue() == 80) {
                            uVar.m(false);
                            break;
                        }
                        break;
                    case 2:
                        dn2 dn2Var = (dn2) obj;
                        if (uVar.O()) {
                            uVar.n(dn2Var.a, false);
                        }
                        break;
                    default:
                        f13 f13Var = (f13) obj;
                        if (uVar.O()) {
                            uVar.s(f13Var.a, false);
                        }
                        break;
                }
            }
        };
        final int i3 = 2;
        this.t = new dd0(this) { // from class: rj1
            public final /* synthetic */ u b;

            {
                this.b = this;
            }

            @Override // defpackage.dd0
            public final void accept(Object obj) {
                int i22 = i3;
                u uVar = this.b;
                switch (i22) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (uVar.O()) {
                            uVar.i(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (uVar.O() && num.intValue() == 80) {
                            uVar.m(false);
                            break;
                        }
                        break;
                    case 2:
                        dn2 dn2Var = (dn2) obj;
                        if (uVar.O()) {
                            uVar.n(dn2Var.a, false);
                        }
                        break;
                    default:
                        f13 f13Var = (f13) obj;
                        if (uVar.O()) {
                            uVar.s(f13Var.a, false);
                        }
                        break;
                }
            }
        };
        final int i4 = 3;
        this.u = new dd0(this) { // from class: rj1
            public final /* synthetic */ u b;

            {
                this.b = this;
            }

            @Override // defpackage.dd0
            public final void accept(Object obj) {
                int i22 = i4;
                u uVar = this.b;
                switch (i22) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (uVar.O()) {
                            uVar.i(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (uVar.O() && num.intValue() == 80) {
                            uVar.m(false);
                            break;
                        }
                        break;
                    case 2:
                        dn2 dn2Var = (dn2) obj;
                        if (uVar.O()) {
                            uVar.n(dn2Var.a, false);
                        }
                        break;
                    default:
                        f13 f13Var = (f13) obj;
                        if (uVar.O()) {
                            uVar.s(f13Var.a, false);
                        }
                        break;
                }
            }
        };
    }

    public static HashSet F(a aVar) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < aVar.a.size(); i++) {
            o oVar = ((nk1) aVar.a.get(i)).b;
            if (oVar != null && aVar.g) {
                hashSet.add(oVar);
            }
        }
        return hashSet;
    }

    public static boolean M(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean N(o oVar) {
        if (oVar.mHasMenu && oVar.mMenuVisible) {
            return true;
        }
        boolean zN = false;
        for (o oVar2 : oVar.mChildFragmentManager.c.e()) {
            if (oVar2 != null) {
                zN = N(oVar2);
            }
            if (zN) {
                return true;
            }
        }
        return false;
    }

    public static boolean P(o oVar) {
        if (oVar == null) {
            return true;
        }
        u uVar = oVar.mFragmentManager;
        return oVar.equals(uVar.A) && P(uVar.z);
    }

    public static void i0(o oVar) {
        if (M(2)) {
            Log.v("FragmentManager", "show: " + oVar);
        }
        if (oVar.mHidden) {
            oVar.mHidden = false;
            oVar.mHiddenChanged = !oVar.mHiddenChanged;
        }
    }

    public final void A(a aVar, boolean z) {
        if (z && (this.x == null || this.K)) {
            return;
        }
        y(z);
        a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.s = false;
            aVar2.d();
            if (M(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.h + " as part of execSingleAction for action " + aVar);
            }
            this.h.f(false, false);
            this.h.a(this.M, this.N);
            Iterator it = this.h.a.iterator();
            while (it.hasNext()) {
                o oVar = ((nk1) it.next()).b;
                if (oVar != null) {
                    oVar.mTransitioning = false;
                }
            }
            this.h = null;
        }
        aVar.a(this.M, this.N);
        this.b = true;
        try {
            Z(this.M, this.N);
            d();
            k0();
            boolean z2 = this.L;
            y yVar = this.c;
            if (z2) {
                this.L = false;
                for (x xVar : yVar.d()) {
                    o oVar2 = xVar.c;
                    if (oVar2.mDeferStart) {
                        if (this.b) {
                            this.L = true;
                        } else {
                            oVar2.mDeferStart = false;
                            xVar.k();
                        }
                    }
                }
            }
            yVar.b.values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x021b A[PHI: r15
      0x021b: PHI (r15v14 int) = (r15v13 int), (r15v16 int) binds: [B:101:0x0208, B:105:0x0212] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(java.util.ArrayList r26, java.util.ArrayList r27, int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 1302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.u.B(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final o C(int i) {
        y yVar = this.c;
        ArrayList arrayList = yVar.a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            o oVar = (o) arrayList.get(size);
            if (oVar != null && oVar.mFragmentId == i) {
                return oVar;
            }
        }
        for (x xVar : yVar.b.values()) {
            if (xVar != null) {
                o oVar2 = xVar.c;
                if (oVar2.mFragmentId == i) {
                    return oVar2;
                }
            }
        }
        return null;
    }

    public final o D(String str) {
        y yVar = this.c;
        ArrayList arrayList = yVar.a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            o oVar = (o) arrayList.get(size);
            if (oVar != null && str.equals(oVar.mTag)) {
                return oVar;
            }
        }
        for (x xVar : yVar.b.values()) {
            if (xVar != null) {
                o oVar2 = xVar.c;
                if (str.equals(oVar2.mTag)) {
                    return oVar2;
                }
            }
        }
        return null;
    }

    public final void E() {
        for (h hVar : e()) {
            if (hVar.f) {
                if (M(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                hVar.f = false;
                hVar.e();
            }
        }
    }

    public final a G() {
        if (this.d.size() != 0) {
            return (a) this.d.get(0);
        }
        a aVar = this.h;
        if (aVar != null) {
            return aVar;
        }
        throw new IndexOutOfBoundsException();
    }

    public final int H() {
        return this.d.size() + (this.h != null ? 1 : 0);
    }

    public final ViewGroup I(o oVar) {
        ViewGroup viewGroup = oVar.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (oVar.mContainerId <= 0 || !this.y.i()) {
            return null;
        }
        View viewE = this.y.e(oVar.mContainerId);
        if (viewE instanceof ViewGroup) {
            return (ViewGroup) viewE;
        }
        return null;
    }

    public final tj1 J() {
        o oVar = this.z;
        return oVar != null ? oVar.mFragmentManager.J() : this.B;
    }

    public final d7 K() {
        o oVar = this.z;
        return oVar != null ? oVar.mFragmentManager.K() : this.C;
    }

    public final void L(o oVar) {
        if (M(2)) {
            Log.v("FragmentManager", "hide: " + oVar);
        }
        if (oVar.mHidden) {
            return;
        }
        oVar.mHidden = true;
        oVar.mHiddenChanged = true ^ oVar.mHiddenChanged;
        h0(oVar);
    }

    public final boolean O() {
        o oVar = this.z;
        if (oVar == null) {
            return true;
        }
        return oVar.isAdded() && this.z.getParentFragmentManager().O();
    }

    public final boolean Q() {
        return this.I || this.J;
    }

    public final void R(int i, boolean z) {
        pj1 pj1Var;
        if (this.x == null && i != -1) {
            xe.q("No activity");
            return;
        }
        if (z || i != this.w) {
            this.w = i;
            y yVar = this.c;
            HashMap map = yVar.b;
            Iterator it = yVar.a.iterator();
            while (it.hasNext()) {
                x xVar = (x) map.get(((o) it.next()).mWho);
                if (xVar != null) {
                    xVar.k();
                }
            }
            for (x xVar2 : map.values()) {
                if (xVar2 != null) {
                    xVar2.k();
                    o oVar = xVar2.c;
                    if (oVar.mRemoving && !oVar.isInBackStack()) {
                        if (oVar.mBeingSaved && !yVar.c.containsKey(oVar.mWho)) {
                            yVar.i(xVar2.n(), oVar.mWho);
                        }
                        yVar.h(xVar2);
                    }
                }
            }
            for (x xVar3 : yVar.d()) {
                o oVar2 = xVar3.c;
                if (oVar2.mDeferStart) {
                    if (this.b) {
                        this.L = true;
                    } else {
                        oVar2.mDeferStart = false;
                        xVar3.k();
                    }
                }
            }
            if (this.H && (pj1Var = this.x) != null && this.w == 7) {
                ((kj1) pj1Var).X.invalidateOptionsMenu();
                this.H = false;
            }
        }
    }

    public final void S() {
        if (this.x == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.g = false;
        for (o oVar : this.c.f()) {
            if (oVar != null) {
                oVar.noteStateNotSaved();
            }
        }
    }

    public final void T(int i, boolean z) {
        if (i >= 0) {
            x(new zj1(this, i, 1), z);
        } else {
            xe.k(dw2.A(i, "Bad id: "));
        }
    }

    public final boolean U() {
        return V(-1, 0);
    }

    public final boolean V(int i, int i2) {
        z(false);
        y(true);
        o oVar = this.A;
        if (oVar != null && i < 0 && oVar.getChildFragmentManager().U()) {
            return true;
        }
        boolean zW = W(this.M, this.N, i, i2);
        if (zW) {
            this.b = true;
            try {
                Z(this.M, this.N);
            } finally {
                d();
            }
        }
        k0();
        boolean z = this.L;
        y yVar = this.c;
        if (z) {
            this.L = false;
            for (x xVar : yVar.d()) {
                o oVar2 = xVar.c;
                if (oVar2.mDeferStart) {
                    if (this.b) {
                        this.L = true;
                    } else {
                        oVar2.mDeferStart = false;
                        xVar.k();
                    }
                }
            }
        }
        yVar.b.values().removeAll(Collections.singleton(null));
        return zW;
    }

    public final boolean W(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        boolean z = (i2 & 1) != 0;
        int size = -1;
        if (!this.d.isEmpty()) {
            if (i < 0) {
                size = z ? 0 : this.d.size() - 1;
            } else {
                int size2 = this.d.size() - 1;
                while (size2 >= 0) {
                    a aVar = (a) this.d.get(size2);
                    if (i >= 0 && i == aVar.t) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    size = size2;
                } else if (z) {
                    size = size2;
                    while (size > 0) {
                        a aVar2 = (a) this.d.get(size - 1);
                        if (i < 0 || i != aVar2.t) {
                            break;
                        }
                        size--;
                    }
                } else if (size2 != this.d.size() - 1) {
                    size = size2 + 1;
                }
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.d.size() - 1; size3 >= size; size3--) {
            arrayList.add((a) this.d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void X(Bundle bundle, String str, o oVar) {
        if (oVar.mFragmentManager == this) {
            bundle.putString(str, oVar.mWho);
        } else {
            j0(new IllegalStateException(ha0.l("Fragment ", oVar, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public final void Y(o oVar) {
        if (M(2)) {
            Log.v("FragmentManager", "remove: " + oVar + " nesting=" + oVar.mBackStackNesting);
        }
        boolean zIsInBackStack = oVar.isInBackStack();
        if (oVar.mDetached && zIsInBackStack) {
            return;
        }
        y yVar = this.c;
        synchronized (yVar.a) {
            yVar.a.remove(oVar);
        }
        oVar.mAdded = false;
        if (N(oVar)) {
            this.H = true;
        }
        oVar.mRemoving = true;
        h0(oVar);
    }

    public final void Z(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            xe.q("Internal error with the back stack records");
            return;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((a) arrayList.get(i)).p) {
                if (i2 != i) {
                    B(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((a) arrayList.get(i2)).p) {
                        i2++;
                    }
                }
                B(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            B(arrayList, arrayList2, i2, size);
        }
    }

    public final x a(o oVar) {
        String str = oVar.mPreviousWho;
        if (str != null) {
            mk1.c(oVar, str);
        }
        if (M(2)) {
            Log.v("FragmentManager", "add: " + oVar);
        }
        x xVarG = g(oVar);
        oVar.mFragmentManager = this;
        y yVar = this.c;
        yVar.g(xVarG);
        if (!oVar.mDetached) {
            yVar.a(oVar);
            oVar.mRemoving = false;
            if (oVar.mView == null) {
                oVar.mHiddenChanged = false;
            }
            if (N(oVar)) {
                this.H = true;
            }
        }
        return xVarG;
    }

    public final void a0(Bundle bundle) {
        eg0 eg0Var;
        int i;
        boolean z;
        int i2;
        x xVar;
        Bundle bundle2;
        Bundle bundle3;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle3 = bundle.getBundle(str)) != null) {
                bundle3.setClassLoader(this.x.f.getClassLoader());
                this.m.put(str.substring(7), bundle3);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle2 = bundle.getBundle(str2)) != null) {
                bundle2.setClassLoader(this.x.f.getClassLoader());
                map.put(str2.substring(9), bundle2);
            }
        }
        y yVar = this.c;
        HashMap map2 = yVar.c;
        HashMap map3 = yVar.b;
        map2.clear();
        map2.putAll(map);
        bk1 bk1Var = (bk1) bundle.getParcelable("state");
        if (bk1Var == null) {
            return;
        }
        map3.clear();
        Iterator it = bk1Var.b.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            eg0Var = this.p;
            i = 2;
            if (!zHasNext) {
                break;
            }
            Bundle bundleI = yVar.i(null, (String) it.next());
            if (bundleI != null) {
                o oVar = (o) this.P.b.get(((w) bundleI.getParcelable("state")).f);
                if (oVar != null) {
                    if (M(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + oVar);
                    }
                    xVar = new x(eg0Var, yVar, oVar, bundleI);
                } else {
                    xVar = new x(this.p, this.c, this.x.f.getClassLoader(), J(), bundleI);
                }
                o oVar2 = xVar.c;
                oVar2.mSavedFragmentState = bundleI;
                oVar2.mFragmentManager = this;
                if (M(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + oVar2.mWho + "): " + oVar2);
                }
                xVar.l(this.x.f.getClassLoader());
                yVar.g(xVar);
                xVar.e = this.w;
            }
        }
        v vVar = this.P;
        vVar.getClass();
        Iterator it2 = new ArrayList(vVar.b.values()).iterator();
        while (true) {
            z = true;
            if (!it2.hasNext()) {
                break;
            }
            o oVar3 = (o) it2.next();
            if (map3.get(oVar3.mWho) == null) {
                if (M(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + oVar3 + " that was not found in the set of active Fragments " + bk1Var.b);
                }
                this.P.i(oVar3);
                oVar3.mFragmentManager = this;
                x xVar2 = new x(eg0Var, yVar, oVar3);
                xVar2.e = 1;
                xVar2.k();
                oVar3.mRemoving = true;
                xVar2.k();
            }
        }
        ArrayList<String> arrayList = bk1Var.f;
        yVar.a.clear();
        if (arrayList != null) {
            for (String str3 : arrayList) {
                o oVarB = yVar.b(str3);
                if (oVarB == null) {
                    xe.q(ha0.o("No instantiated fragment for (", str3, ")"));
                    return;
                }
                if (M(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + oVarB);
                }
                yVar.a(oVarB);
            }
        }
        if (bk1Var.z != null) {
            this.d = new ArrayList(bk1Var.z.length);
            int i3 = 0;
            while (true) {
                b[] bVarArr = bk1Var.z;
                if (i3 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i3];
                ArrayList arrayList2 = bVar.f;
                a aVar = new a(this);
                int[] iArr = bVar.b;
                int i4 = 0;
                int i5 = 0;
                while (i4 < iArr.length) {
                    nk1 nk1Var = new nk1();
                    int i6 = i4 + 1;
                    int i7 = i;
                    nk1Var.a = iArr[i4];
                    if (M(i7)) {
                        Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i5 + " base fragment #" + iArr[i6]);
                    }
                    nk1Var.h = q92.values()[bVar.z[i5]];
                    nk1Var.i = q92.values()[bVar.A[i5]];
                    int i8 = i4 + 2;
                    nk1Var.c = iArr[i6] != 0 ? z : false;
                    int i9 = iArr[i8];
                    nk1Var.d = i9;
                    int i10 = iArr[i4 + 3];
                    nk1Var.e = i10;
                    int i11 = i4 + 5;
                    int i12 = iArr[i4 + 4];
                    nk1Var.f = i12;
                    i4 += 6;
                    int[] iArr2 = iArr;
                    int i13 = iArr2[i11];
                    nk1Var.g = i13;
                    aVar.b = i9;
                    aVar.c = i10;
                    aVar.d = i12;
                    aVar.e = i13;
                    aVar.b(nk1Var);
                    i5++;
                    i = i7;
                    iArr = iArr2;
                    z = true;
                }
                int i14 = i;
                aVar.f = bVar.X;
                aVar.i = bVar.Y;
                aVar.g = true;
                aVar.j = bVar.y0;
                aVar.k = bVar.z0;
                aVar.l = bVar.A0;
                aVar.m = bVar.B0;
                aVar.n = bVar.C0;
                aVar.o = bVar.D0;
                aVar.p = bVar.E0;
                aVar.t = bVar.Z;
                for (int i15 = 0; i15 < arrayList2.size(); i15++) {
                    String str4 = (String) arrayList2.get(i15);
                    if (str4 != null) {
                        ((nk1) aVar.a.get(i15)).b = yVar.b(str4);
                    }
                }
                aVar.c(1);
                if (M(i14)) {
                    StringBuilder sbD = dw2.D("restoreAllState: back stack #", i3, " (index ");
                    sbD.append(aVar.t);
                    sbD.append("): ");
                    sbD.append(aVar);
                    Log.v("FragmentManager", sbD.toString());
                    PrintWriter printWriter = new PrintWriter(new me2());
                    aVar.h("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(aVar);
                i3++;
                i = i14;
                z = true;
            }
            i2 = 0;
        } else {
            i2 = 0;
            this.d = new ArrayList();
        }
        this.k.set(bk1Var.A);
        String str5 = bk1Var.X;
        if (str5 != null) {
            o oVarB2 = yVar.b(str5);
            this.A = oVarB2;
            r(oVarB2);
        }
        ArrayList arrayList3 = bk1Var.Y;
        if (arrayList3 != null) {
            for (int i16 = i2; i16 < arrayList3.size(); i16++) {
                this.l.put((String) arrayList3.get(i16), (ai) bk1Var.Z.get(i16));
            }
        }
        this.G = new ArrayDeque(bk1Var.y0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(pj1 pj1Var, mj1 mj1Var, o oVar) {
        v vVar;
        if (this.x != null) {
            xe.q("Already attached");
            return;
        }
        this.x = pj1Var;
        this.y = mj1Var;
        this.z = oVar;
        CopyOnWriteArrayList copyOnWriteArrayList = this.q;
        if (oVar != null) {
            copyOnWriteArrayList.add(new vj1(oVar));
        } else if (pj1Var instanceof ek1) {
            copyOnWriteArrayList.add((ek1) pj1Var);
        }
        if (this.z != null) {
            k0();
        }
        if (pj1Var instanceof xu2) {
            xu2 xu2Var = (xu2) pj1Var;
            wu2 wu2VarB = xu2Var.b();
            this.g = wu2VarB;
            da2 da2Var = xu2Var;
            if (oVar != null) {
                da2Var = oVar;
            }
            wu2VarB.a(da2Var, this.j);
        }
        if (oVar != null) {
            v vVar2 = oVar.mFragmentManager.P;
            HashMap map = vVar2.c;
            vVar = (v) map.get(oVar.mWho);
            if (vVar == null) {
                vVar = new v(vVar2.e);
                map.put(oVar.mWho, vVar);
            }
            this.P = vVar;
        } else if (pj1Var instanceof pq4) {
            oq4 viewModelStore = ((pq4) pj1Var).getViewModelStore();
            viewModelStore.getClass();
            cg0 cg0Var = cg0.b;
            cg0Var.getClass();
            ih4 ih4Var = new ih4(viewModelStore, v.h, cg0Var);
            j50 j50VarA = dh3.a(v.class);
            String strB = j50VarA.b();
            if (strB == null) {
                xe.k("Local and anonymous classes can not be ViewModels");
                return;
            } else {
                vVar = (v) ih4Var.a(j50VarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strB));
                this.P = vVar;
            }
        } else {
            vVar = new v(false);
            this.P = vVar;
        }
        vVar.g = Q();
        this.c.d = this.P;
        Object obj = this.x;
        if ((obj instanceof kp3) && oVar == null) {
            hp3 savedStateRegistry = ((kp3) obj).getSavedStateRegistry();
            savedStateRegistry.c("android:support:fragments", new c90(2, this));
            Bundle bundleA = savedStateRegistry.a("android:support:fragments");
            if (bundleA != null) {
                a0(bundleA);
            }
        }
        Object obj2 = this.x;
        if (obj2 instanceof y4) {
            x4 x4VarG = ((y4) obj2).g();
            String strConcat = "FragmentManager:".concat(oVar != null ? fw.y(new StringBuilder(), oVar.mWho, ":") : "");
            this.D = x4VarG.c(strConcat.concat("StartActivityForResult"), new n4(6), new zf2(28, this));
            this.E = x4VarG.c(strConcat.concat("StartIntentSenderForResult"), new n4(7), new oj1(1, this));
            int i = 4;
            this.F = x4VarG.c(strConcat.concat("RequestPermissions"), new n4(i), new ha1(i, this));
        }
        Object obj3 = this.x;
        if (obj3 instanceof yu2) {
            ((yu2) obj3).l(this.r);
        }
        Object obj4 = this.x;
        if (obj4 instanceof mv2) {
            ((mv2) obj4).f(this.s);
        }
        Object obj5 = this.x;
        if (obj5 instanceof fv2) {
            ((fv2) obj5).d(this.t);
        }
        Object obj6 = this.x;
        if (obj6 instanceof gv2) {
            ((gv2) obj6).c(this.u);
        }
        Object obj7 = this.x;
        if ((obj7 instanceof qk2) && oVar == null) {
            ((qk2) obj7).n(this.v);
        }
    }

    public final Bundle b0() {
        ArrayList arrayList;
        b[] bVarArr;
        Bundle bundle = new Bundle();
        E();
        w();
        z(true);
        this.I = true;
        this.P.g = true;
        y yVar = this.c;
        yVar.getClass();
        HashMap map = yVar.b;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (x xVar : map.values()) {
            if (xVar != null) {
                o oVar = xVar.c;
                yVar.i(xVar.n(), oVar.mWho);
                arrayList2.add(oVar.mWho);
                if (M(2)) {
                    Log.v("FragmentManager", "Saved state of " + oVar + ": " + oVar.mSavedFragmentState);
                }
            }
        }
        HashMap map2 = this.c.c;
        if (!map2.isEmpty()) {
            y yVar2 = this.c;
            synchronized (yVar2.a) {
                try {
                    if (yVar2.a.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(yVar2.a.size());
                        for (o oVar2 : yVar2.a) {
                            arrayList.add(oVar2.mWho);
                            if (M(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + oVar2.mWho + "): " + oVar2);
                            }
                        }
                    }
                } finally {
                }
            }
            int size = this.d.size();
            if (size > 0) {
                bVarArr = new b[size];
                for (int i = 0; i < size; i++) {
                    bVarArr[i] = new b((a) this.d.get(i));
                    if (M(2)) {
                        StringBuilder sbD = dw2.D("saveAllState: adding back stack #", i, ": ");
                        sbD.append(this.d.get(i));
                        Log.v("FragmentManager", sbD.toString());
                    }
                }
            } else {
                bVarArr = null;
            }
            bk1 bk1Var = new bk1();
            bk1Var.X = null;
            ArrayList arrayList3 = new ArrayList();
            bk1Var.Y = arrayList3;
            ArrayList arrayList4 = new ArrayList();
            bk1Var.Z = arrayList4;
            bk1Var.b = arrayList2;
            bk1Var.f = arrayList;
            bk1Var.z = bVarArr;
            bk1Var.A = this.k.get();
            o oVar3 = this.A;
            if (oVar3 != null) {
                bk1Var.X = oVar3.mWho;
            }
            arrayList3.addAll(this.l.keySet());
            arrayList4.addAll(this.l.values());
            bk1Var.y0 = new ArrayList(this.G);
            bundle.putParcelable("state", bk1Var);
            for (String str : this.m.keySet()) {
                bundle.putBundle(ha0.n("result_", str), (Bundle) this.m.get(str));
            }
            for (String str2 : map2.keySet()) {
                bundle.putBundle(ha0.n("fragment_", str2), (Bundle) map2.get(str2));
            }
        } else if (M(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final void c(o oVar) {
        if (M(2)) {
            Log.v("FragmentManager", "attach: " + oVar);
        }
        if (oVar.mDetached) {
            oVar.mDetached = false;
            if (oVar.mAdded) {
                return;
            }
            this.c.a(oVar);
            if (M(2)) {
                Log.v("FragmentManager", "add from attach: " + oVar);
            }
            if (N(oVar)) {
                this.H = true;
            }
        }
    }

    public final ij1 c0(o oVar) {
        x xVar = (x) this.c.b.get(oVar.mWho);
        if (xVar != null) {
            o oVar2 = xVar.c;
            if (oVar2.equals(oVar)) {
                if (oVar2.mState > -1) {
                    return new ij1(xVar.n());
                }
                return null;
            }
        }
        j0(new IllegalStateException(ha0.l("Fragment ", oVar, " is not currently in the FragmentManager")));
        throw null;
    }

    public final void d() {
        this.b = false;
        this.N.clear();
        this.M.clear();
    }

    public final void d0() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.x.z.removeCallbacks(this.Q);
                    this.x.z.post(this.Q);
                    k0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final HashSet e() {
        h hVar;
        HashSet hashSet = new HashSet();
        Iterator it = this.c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((x) it.next()).c.mContainer;
            if (viewGroup != null) {
                K().getClass();
                Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
                if (tag instanceof h) {
                    hVar = (h) tag;
                } else {
                    hVar = new h(viewGroup);
                    viewGroup.setTag(R.id.special_effects_controller_view_tag, hVar);
                }
                hashSet.add(hVar);
            }
        }
        return hashSet;
    }

    public final void e0(o oVar, boolean z) {
        ViewGroup viewGroupI = I(oVar);
        if (viewGroupI == null || !(viewGroupI instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupI).setDrawDisappearingViewsLast(!z);
    }

    public final HashSet f(ArrayList arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator it = ((a) arrayList.get(i)).a.iterator();
            while (it.hasNext()) {
                o oVar = ((nk1) it.next()).b;
                if (oVar != null && (viewGroup = oVar.mContainer) != null) {
                    hashSet.add(h.j(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    public final void f0(o oVar, q92 q92Var) {
        if (oVar.equals(this.c.b(oVar.mWho)) && (oVar.mHost == null || oVar.mFragmentManager == this)) {
            oVar.mMaxState = q92Var;
        } else {
            ad0.k("Fragment ", oVar, " is not an active fragment of FragmentManager ", this);
        }
    }

    public final x g(o oVar) {
        String str = oVar.mWho;
        y yVar = this.c;
        x xVar = (x) yVar.b.get(str);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(this.p, yVar, oVar);
        xVar2.l(this.x.f.getClassLoader());
        xVar2.e = this.w;
        return xVar2;
    }

    public final void g0(o oVar) {
        if (oVar != null) {
            if (!oVar.equals(this.c.b(oVar.mWho)) || (oVar.mHost != null && oVar.mFragmentManager != this)) {
                ad0.k("Fragment ", oVar, " is not an active fragment of FragmentManager ", this);
                return;
            }
        }
        o oVar2 = this.A;
        this.A = oVar;
        r(oVar2);
        r(this.A);
    }

    public final void h(o oVar) {
        if (M(2)) {
            Log.v("FragmentManager", "detach: " + oVar);
        }
        if (oVar.mDetached) {
            return;
        }
        oVar.mDetached = true;
        if (oVar.mAdded) {
            if (M(2)) {
                Log.v("FragmentManager", "remove from detach: " + oVar);
            }
            y yVar = this.c;
            synchronized (yVar.a) {
                yVar.a.remove(oVar);
            }
            oVar.mAdded = false;
            if (N(oVar)) {
                this.H = true;
            }
            h0(oVar);
        }
    }

    public final void h0(o oVar) {
        ViewGroup viewGroupI = I(oVar);
        if (viewGroupI != null) {
            if (oVar.getPopExitAnim() + oVar.getPopEnterAnim() + oVar.getExitAnim() + oVar.getEnterAnim() > 0) {
                if (viewGroupI.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    viewGroupI.setTag(R.id.visible_removing_fragment_view_tag, oVar);
                }
                ((o) viewGroupI.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(oVar.getPopDirection());
            }
        }
    }

    public final void i(boolean z, Configuration configuration) {
        if (z && (this.x instanceof yu2)) {
            j0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (o oVar : this.c.f()) {
            if (oVar != null) {
                oVar.performConfigurationChanged(configuration);
                if (z) {
                    oVar.mChildFragmentManager.i(true, configuration);
                }
            }
        }
    }

    public final boolean j(MenuItem menuItem) {
        if (this.w < 1) {
            return false;
        }
        for (o oVar : this.c.f()) {
            if (oVar != null && oVar.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void j0(IllegalStateException illegalStateException) {
        a1.d("FragmentManager", illegalStateException.getMessage());
        a1.d("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new me2());
        pj1 pj1Var = this.x;
        if (pj1Var == null) {
            try {
                v("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e) {
                a1.e("FragmentManager", "Failed dumping state", e);
                throw illegalStateException;
            }
        }
        try {
            ((kj1) pj1Var).X.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e2) {
            a1.e("FragmentManager", "Failed dumping state", e2);
            throw illegalStateException;
        }
    }

    public final boolean k(Menu menu, MenuInflater menuInflater) {
        if (this.w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (o oVar : this.c.f()) {
            if (oVar != null && oVar.isMenuVisible() && oVar.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(oVar);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i = 0; i < this.e.size(); i++) {
                o oVar2 = (o) this.e.get(i);
                if (arrayList == null || !arrayList.contains(oVar2)) {
                    oVar2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public final void k0() {
        synchronized (this.a) {
            try {
                if (!this.a.isEmpty()) {
                    this.j.f(true);
                    if (M(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z = H() > 0 && P(this.z);
                if (M(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z);
                }
                this.j.f(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l() {
        this.K = true;
        z(true);
        w();
        pj1 pj1Var = this.x;
        boolean z = pj1Var instanceof pq4;
        y yVar = this.c;
        if (z ? yVar.d.f : true ^ pj1Var.f.isChangingConfigurations()) {
            Iterator it = this.l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ai) it.next()).b.iterator();
                while (it2.hasNext()) {
                    yVar.d.g((String) it2.next(), false);
                }
            }
        }
        u(-1);
        Object obj = this.x;
        if (obj instanceof mv2) {
            ((mv2) obj).h(this.s);
        }
        Object obj2 = this.x;
        if (obj2 instanceof yu2) {
            ((yu2) obj2).m(this.r);
        }
        Object obj3 = this.x;
        if (obj3 instanceof fv2) {
            ((fv2) obj3).p(this.t);
        }
        Object obj4 = this.x;
        if (obj4 instanceof gv2) {
            ((gv2) obj4).o(this.u);
        }
        Object obj5 = this.x;
        if ((obj5 instanceof qk2) && this.z == null) {
            ((qk2) obj5).j(this.v);
        }
        this.x = null;
        this.y = null;
        this.z = null;
        if (this.g != null) {
            this.j.e();
            this.g = null;
        }
        w4 w4Var = this.D;
        if (w4Var != null) {
            w4Var.b();
            this.E.b();
            this.F.b();
        }
    }

    public final void m(boolean z) {
        if (z && (this.x instanceof mv2)) {
            j0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (o oVar : this.c.f()) {
            if (oVar != null) {
                oVar.performLowMemory();
                if (z) {
                    oVar.mChildFragmentManager.m(true);
                }
            }
        }
    }

    public final void n(boolean z, boolean z2) {
        if (z2 && (this.x instanceof fv2)) {
            j0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (o oVar : this.c.f()) {
            if (oVar != null) {
                oVar.performMultiWindowModeChanged(z);
                if (z2) {
                    oVar.mChildFragmentManager.n(z, true);
                }
            }
        }
    }

    public final void o() {
        for (o oVar : this.c.e()) {
            if (oVar != null) {
                oVar.onHiddenChanged(oVar.isHidden());
                oVar.mChildFragmentManager.o();
            }
        }
    }

    public final boolean p(MenuItem menuItem) {
        if (this.w < 1) {
            return false;
        }
        for (o oVar : this.c.f()) {
            if (oVar != null && oVar.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void q(Menu menu) {
        if (this.w < 1) {
            return;
        }
        for (o oVar : this.c.f()) {
            if (oVar != null) {
                oVar.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void r(o oVar) {
        if (oVar != null) {
            if (oVar.equals(this.c.b(oVar.mWho))) {
                oVar.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void s(boolean z, boolean z2) {
        if (z2 && (this.x instanceof gv2)) {
            j0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (o oVar : this.c.f()) {
            if (oVar != null) {
                oVar.performPictureInPictureModeChanged(z);
                if (z2) {
                    oVar.mChildFragmentManager.s(z, true);
                }
            }
        }
    }

    public final boolean t(Menu menu) {
        boolean z = false;
        if (this.w < 1) {
            return false;
        }
        for (o oVar : this.c.f()) {
            if (oVar != null && oVar.isMenuVisible() && oVar.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final String toString() {
        StringBuilder sbB = fw.B(128, "FragmentManager{");
        sbB.append(Integer.toHexString(System.identityHashCode(this)));
        sbB.append(" in ");
        o oVar = this.z;
        if (oVar != null) {
            sbB.append(oVar.getClass().getSimpleName());
            sbB.append("{");
            sbB.append(Integer.toHexString(System.identityHashCode(this.z)));
            sbB.append("}");
        } else {
            pj1 pj1Var = this.x;
            if (pj1Var != null) {
                sbB.append(pj1Var.getClass().getSimpleName());
                sbB.append("{");
                sbB.append(Integer.toHexString(System.identityHashCode(this.x)));
                sbB.append("}");
            } else {
                sbB.append("null");
            }
        }
        sbB.append("}}");
        return sbB.toString();
    }

    public final void u(int i) {
        try {
            this.b = true;
            for (x xVar : this.c.b.values()) {
                if (xVar != null) {
                    xVar.e = i;
                }
            }
            R(i, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((h) it.next()).i();
            }
            this.b = false;
            z(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final void v(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String strX = ha0.x(str, "    ");
        y yVar = this.c;
        ArrayList arrayList = yVar.a;
        String strX2 = ha0.x(str, "    ");
        HashMap map = yVar.b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (x xVar : map.values()) {
                printWriter.print(str);
                if (xVar != null) {
                    o oVar = xVar.c;
                    printWriter.println(oVar);
                    oVar.dump(strX2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size2 = arrayList.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size2; i++) {
                o oVar2 = (o) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(oVar2.toString());
            }
        }
        ArrayList arrayList2 = this.e;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size; i2++) {
                o oVar3 = (o) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(oVar3.toString());
            }
        }
        int size3 = this.d.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                a aVar = (a) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.h(strX, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.k.get());
        synchronized (this.a) {
            try {
                int size4 = this.a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        Object obj = (yj1) this.a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.y);
        if (this.z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    public final void w() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((h) it.next()).i();
        }
    }

    public final void x(yj1 yj1Var, boolean z) {
        if (!z) {
            if (this.x == null) {
                if (this.K) {
                    xe.q("FragmentManager has been destroyed");
                    return;
                } else {
                    xe.q("FragmentManager has not been attached to a host.");
                    return;
                }
            }
            if (Q()) {
                xe.q("Can not perform this action after onSaveInstanceState");
                return;
            }
        }
        synchronized (this.a) {
            try {
                if (this.x == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(yj1Var);
                    d0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y(boolean z) {
        if (this.b) {
            xe.q("FragmentManager is already executing transactions");
            return;
        }
        if (this.x == null) {
            if (this.K) {
                xe.q("FragmentManager has been destroyed");
                return;
            } else {
                xe.q("FragmentManager has not been attached to a host.");
                return;
            }
        }
        if (Looper.myLooper() != this.x.z.getLooper()) {
            xe.q("Must be called from main thread of fragment host");
            return;
        }
        if (!z && Q()) {
            xe.q("Can not perform this action after onSaveInstanceState");
        } else if (this.M == null) {
            this.M = new ArrayList();
            this.N = new ArrayList();
        }
    }

    public final boolean z(boolean z) {
        boolean zA;
        ArrayList arrayList;
        a aVar;
        y(z);
        if (!this.i && (aVar = this.h) != null) {
            aVar.s = false;
            aVar.d();
            if (M(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.h + " as part of execPendingActions for actions " + this.a);
            }
            this.h.f(false, false);
            this.a.add(0, this.h);
            Iterator it = this.h.a.iterator();
            while (it.hasNext()) {
                o oVar = ((nk1) it.next()).b;
                if (oVar != null) {
                    oVar.mTransitioning = false;
                }
            }
            this.h = null;
        }
        boolean z2 = false;
        while (true) {
            ArrayList arrayList2 = this.M;
            ArrayList arrayList3 = this.N;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    zA = false;
                } else {
                    try {
                        int size = this.a.size();
                        int i = 0;
                        zA = false;
                        while (true) {
                            arrayList = this.a;
                            if (i >= size) {
                                break;
                            }
                            zA |= ((yj1) arrayList.get(i)).a(arrayList2, arrayList3);
                            i++;
                        }
                        arrayList.clear();
                        this.x.z.removeCallbacks(this.Q);
                    } finally {
                    }
                }
            }
            if (!zA) {
                break;
            }
            this.b = true;
            try {
                Z(this.M, this.N);
                d();
                z2 = true;
            } catch (Throwable th) {
                d();
                throw th;
            }
        }
        k0();
        if (this.L) {
            this.L = false;
            for (x xVar : this.c.d()) {
                o oVar2 = xVar.c;
                if (oVar2.mDeferStart) {
                    if (this.b) {
                        this.L = true;
                    } else {
                        oVar2.mDeferStart = false;
                        xVar.k();
                    }
                }
            }
        }
        this.c.b.values().removeAll(Collections.singleton(null));
        return z2;
    }
}
