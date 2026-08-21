package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class vg4 implements Cloneable {
    public static final Animator[] T0 = new Animator[0];
    public static final int[] U0 = {2, 1, 3, 4};
    public static final ng4 V0 = new ng4();
    public static final ThreadLocal W0 = new ThreadLocal();
    public ArrayList D0;
    public ArrayList E0;
    public tg4[] F0;
    public ek0 O0;
    public long Q0;
    public sg4 R0;
    public long S0;
    public final String b = getClass().getName();
    public long f = -1;
    public long z = -1;
    public TimeInterpolator A = null;
    public final ArrayList X = new ArrayList();
    public final ArrayList Y = new ArrayList();
    public ArrayList Z = null;
    public ArrayList y0 = null;
    public ih4 z0 = new ih4(0);
    public ih4 A0 = new ih4(0);
    public ch4 B0 = null;
    public final int[] C0 = U0;
    public final ArrayList G0 = new ArrayList();
    public Animator[] H0 = T0;
    public int I0 = 0;
    public boolean J0 = false;
    public boolean K0 = false;
    public vg4 L0 = null;
    public ArrayList M0 = null;
    public ArrayList N0 = new ArrayList();
    public ek0 P0 = V0;

    public static boolean A(hh4 hh4Var, hh4 hh4Var2, String str) {
        Object obj = hh4Var.a.get(str);
        Object obj2 = hh4Var2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public static void c(ih4 ih4Var, View view, hh4 hh4Var) {
        ie ieVar = (ie) ih4Var.a;
        ie ieVar2 = (ie) ih4Var.b;
        SparseArray sparseArray = (SparseArray) ih4Var.c;
        ff2 ff2Var = (ff2) ih4Var.d;
        ieVar.put(view, hh4Var);
        int id = view.getId();
        if (id >= 0) {
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = wp4.a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            if (ieVar2.containsKey(transitionName)) {
                ieVar2.put(transitionName, null);
            } else {
                ieVar2.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (ff2Var.f(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    ff2Var.h(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) ff2Var.d(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    ff2Var.h(itemIdAtPosition, null);
                }
            }
        }
    }

    public static ie t() {
        ThreadLocal threadLocal = W0;
        ie ieVar = (ie) threadLocal.get();
        if (ieVar != null) {
            return ieVar;
        }
        ie ieVar2 = new ie(0);
        threadLocal.set(ieVar2);
        return ieVar2;
    }

    public final void B(vg4 vg4Var, e04 e04Var, boolean z) {
        vg4 vg4Var2 = this.L0;
        if (vg4Var2 != null) {
            vg4Var2.B(vg4Var, e04Var, z);
        }
        ArrayList arrayList = this.M0;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.M0.size();
        tg4[] tg4VarArr = this.F0;
        if (tg4VarArr == null) {
            tg4VarArr = new tg4[size];
        }
        this.F0 = null;
        tg4[] tg4VarArr2 = (tg4[]) this.M0.toArray(tg4VarArr);
        for (int i = 0; i < size; i++) {
            tg4 tg4Var = tg4VarArr2[i];
            switch (e04Var.b) {
                case 11:
                    tg4Var.d(vg4Var);
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    tg4Var.e(vg4Var);
                    break;
                case 13:
                    tg4Var.g(vg4Var);
                    break;
                case 14:
                    tg4Var.f(vg4Var);
                    break;
                default:
                    tg4Var.b(vg4Var);
                    break;
            }
            tg4VarArr2[i] = null;
        }
        this.F0 = tg4VarArr2;
    }

    public void C(View view) {
        if (this.K0) {
            return;
        }
        ArrayList arrayList = this.G0;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.H0);
        this.H0 = T0;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.pause();
        }
        this.H0 = animatorArr;
        B(this, e04.X, false);
        this.J0 = true;
    }

    public void D() {
        ie ieVarT = t();
        this.Q0 = 0L;
        int i = 0;
        while (true) {
            int size = this.N0.size();
            ArrayList arrayList = this.N0;
            if (i >= size) {
                arrayList.clear();
                return;
            }
            Animator animator = (Animator) arrayList.get(i);
            pg4 pg4Var = (pg4) ieVarT.get(animator);
            if (animator != null && pg4Var != null) {
                Animator animator2 = pg4Var.f;
                long j = this.z;
                if (j >= 0) {
                    animator2.setDuration(j);
                }
                long j2 = this.f;
                if (j2 >= 0) {
                    animator2.setStartDelay(animator2.getStartDelay() + j2);
                }
                TimeInterpolator timeInterpolator = this.A;
                if (timeInterpolator != null) {
                    animator2.setInterpolator(timeInterpolator);
                }
                this.G0.add(animator);
                this.Q0 = Math.max(this.Q0, rg4.a(animator));
            }
            i++;
        }
    }

    public vg4 E(tg4 tg4Var) {
        vg4 vg4Var;
        ArrayList arrayList = this.M0;
        if (arrayList != null) {
            if (!arrayList.remove(tg4Var) && (vg4Var = this.L0) != null) {
                vg4Var.E(tg4Var);
            }
            if (this.M0.size() == 0) {
                this.M0 = null;
            }
        }
        return this;
    }

    public void G(View view) {
        this.Y.remove(view);
    }

    public void H(View view) {
        if (this.J0) {
            if (!this.K0) {
                ArrayList arrayList = this.G0;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.H0);
                this.H0 = T0;
                for (int i = size - 1; i >= 0; i--) {
                    Animator animator = animatorArr[i];
                    animatorArr[i] = null;
                    animator.resume();
                }
                this.H0 = animatorArr;
                B(this, e04.Y, false);
            }
            this.J0 = false;
        }
    }

    public void J() {
        S();
        ie ieVarT = t();
        for (Animator animator : this.N0) {
            if (ieVarT.containsKey(animator)) {
                S();
                if (animator != null) {
                    animator.addListener(new og4(this, ieVarT));
                    long j = this.z;
                    if (j >= 0) {
                        animator.setDuration(j);
                    }
                    long j2 = this.f;
                    if (j2 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j2);
                    }
                    TimeInterpolator timeInterpolator = this.A;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new d3(13, this));
                    animator.start();
                }
            }
        }
        this.N0.clear();
        n();
    }

    public void K(long j, long j2) {
        long j3 = this.Q0;
        int i = 0;
        boolean z = j < j2;
        if ((j2 < 0 && j >= 0) || (j2 > j3 && j <= j3)) {
            this.K0 = false;
            B(this, e04.f, z);
        }
        ArrayList arrayList = this.G0;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.H0);
        this.H0 = T0;
        while (i < size) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            rg4.b(animator, Math.min(Math.max(0L, j), rg4.a(animator)));
            i++;
            j3 = j3;
        }
        long j4 = j3;
        this.H0 = animatorArr;
        if ((j <= j4 || j2 > j4) && (j >= 0 || j2 < 0)) {
            return;
        }
        if (j > j4) {
            this.K0 = true;
        }
        B(this, e04.z, z);
    }

    public void L(long j) {
        this.z = j;
    }

    public void N(ek0 ek0Var) {
        this.O0 = ek0Var;
    }

    public void O(TimeInterpolator timeInterpolator) {
        this.A = timeInterpolator;
    }

    public void P(ek0 ek0Var) {
        if (ek0Var == null) {
            this.P0 = V0;
        } else {
            this.P0 = ek0Var;
        }
    }

    public void R(long j) {
        this.f = j;
    }

    public final void S() {
        if (this.I0 == 0) {
            B(this, e04.f, false);
            this.K0 = false;
        }
        this.I0++;
    }

    public String T(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.z != -1) {
            sb.append("dur(");
            sb.append(this.z);
            sb.append(") ");
        }
        if (this.f != -1) {
            sb.append("dly(");
            sb.append(this.f);
            sb.append(") ");
        }
        if (this.A != null) {
            sb.append("interp(");
            sb.append(this.A);
            sb.append(") ");
        }
        ArrayList arrayList = this.X;
        int size = arrayList.size();
        ArrayList arrayList2 = this.Y;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i2));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public void a(tg4 tg4Var) {
        ArrayList arrayList = this.M0;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.M0 = arrayList;
        }
        arrayList.add(tg4Var);
    }

    public void b(View view) {
        this.Y.add(view);
    }

    public void d() {
        ArrayList arrayList = this.G0;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.H0);
        this.H0 = T0;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.cancel();
        }
        this.H0 = animatorArr;
        B(this, e04.A, false);
    }

    public abstract void e(hh4 hh4Var);

    public final void f(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.getId();
        ArrayList arrayList = this.Z;
        if (arrayList == null || !arrayList.contains(view)) {
            ArrayList arrayList2 = this.y0;
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    if (((Class) this.y0.get(i)).isInstance(view)) {
                        return;
                    }
                }
            }
            if (view.getParent() instanceof ViewGroup) {
                hh4 hh4Var = new hh4(view);
                if (z) {
                    h(hh4Var);
                } else {
                    e(hh4Var);
                }
                hh4Var.c.add(this);
                g(hh4Var);
                if (z) {
                    c(this.z0, view, hh4Var);
                } else {
                    c(this.A0, view, hh4Var);
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    f(viewGroup.getChildAt(i2), z);
                }
            }
        }
    }

    public abstract void h(hh4 hh4Var);

    public final void i(ViewGroup viewGroup, boolean z) {
        j(z);
        ArrayList arrayList = this.X;
        int size = arrayList.size();
        ArrayList arrayList2 = this.Y;
        if (size <= 0 && arrayList2.size() <= 0) {
            f(viewGroup, z);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i)).intValue());
            if (viewFindViewById != null) {
                hh4 hh4Var = new hh4(viewFindViewById);
                if (z) {
                    h(hh4Var);
                } else {
                    e(hh4Var);
                }
                hh4Var.c.add(this);
                g(hh4Var);
                if (z) {
                    c(this.z0, viewFindViewById, hh4Var);
                } else {
                    c(this.A0, viewFindViewById, hh4Var);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            View view = (View) arrayList2.get(i2);
            hh4 hh4Var2 = new hh4(view);
            if (z) {
                h(hh4Var2);
            } else {
                e(hh4Var2);
            }
            hh4Var2.c.add(this);
            g(hh4Var2);
            if (z) {
                c(this.z0, view, hh4Var2);
            } else {
                c(this.A0, view, hh4Var2);
            }
        }
    }

    public final void j(boolean z) {
        if (z) {
            ((ie) this.z0.a).clear();
            ((SparseArray) this.z0.c).clear();
            ((ff2) this.z0.d).b();
        } else {
            ((ie) this.A0.a).clear();
            ((SparseArray) this.A0.c).clear();
            ((ff2) this.A0.d).b();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: k */
    public vg4 clone() {
        try {
            vg4 vg4Var = (vg4) super.clone();
            vg4Var.N0 = new ArrayList();
            vg4Var.z0 = new ih4(0);
            vg4Var.A0 = new ih4(0);
            vg4Var.D0 = null;
            vg4Var.E0 = null;
            vg4Var.R0 = null;
            vg4Var.L0 = this;
            vg4Var.M0 = null;
            return vg4Var;
        } catch (CloneNotSupportedException e) {
            vp1.p(e);
            return null;
        }
    }

    public Animator l(ViewGroup viewGroup, hh4 hh4Var, hh4 hh4Var2) {
        return null;
    }

    public void m(ViewGroup viewGroup, ih4 ih4Var, ih4 ih4Var2, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        boolean z;
        View view;
        hh4 hh4Var;
        Animator animator;
        Animator animator2;
        hh4 hh4Var2;
        ie ieVarT = t();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        boolean z2 = r().R0 != null;
        int i2 = 0;
        while (i2 < size) {
            hh4 hh4Var3 = (hh4) arrayList.get(i2);
            hh4 hh4Var4 = (hh4) arrayList2.get(i2);
            if (hh4Var3 != null && !hh4Var3.c.contains(this)) {
                hh4Var3 = null;
            }
            if (hh4Var4 != null && !hh4Var4.c.contains(this)) {
                hh4Var4 = null;
            }
            if ((hh4Var3 != null || hh4Var4 != null) && (hh4Var3 == null || hh4Var4 == null || y(hh4Var3, hh4Var4))) {
                Animator animatorL = l(viewGroup, hh4Var3, hh4Var4);
                if (animatorL != null) {
                    String str = this.b;
                    if (hh4Var4 != null) {
                        view = hh4Var4.b;
                        String[] strArrU = u();
                        if (strArrU != null && strArrU.length > 0) {
                            hh4Var2 = new hh4(view);
                            hh4 hh4Var5 = (hh4) ((ie) ih4Var2.a).get(view);
                            i = size;
                            z = z2;
                            if (hh4Var5 != null) {
                                for (String str2 : strArrU) {
                                    hh4Var2.a.put(str2, hh4Var5.a.get(str2));
                                }
                            }
                            int i3 = ieVarT.z;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= i3) {
                                    animator2 = animatorL;
                                    break;
                                }
                                pg4 pg4Var = (pg4) ieVarT.get((Animator) ieVarT.f(i4));
                                if (pg4Var.c != null && pg4Var.a == view && pg4Var.b.equals(str) && pg4Var.c.equals(hh4Var2)) {
                                    animator2 = null;
                                    break;
                                }
                                i4++;
                            }
                        } else {
                            i = size;
                            z = z2;
                            animator2 = animatorL;
                            hh4Var2 = null;
                        }
                        animator = animator2;
                        hh4Var = hh4Var2;
                    } else {
                        i = size;
                        z = z2;
                        view = hh4Var3.b;
                        hh4Var = null;
                        animator = animatorL;
                    }
                    if (animator != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        pg4 pg4Var2 = new pg4();
                        pg4Var2.a = view;
                        pg4Var2.b = str;
                        pg4Var2.c = hh4Var;
                        pg4Var2.d = windowId;
                        pg4Var2.e = this;
                        pg4Var2.f = animator;
                        Object obj = animator;
                        if (z) {
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(animator);
                            obj = animatorSet;
                        }
                        ieVarT.put(obj, pg4Var2);
                        this.N0.add(obj);
                    }
                }
                i2++;
                size = i;
                z2 = z;
            }
            i = size;
            z = z2;
            i2++;
            size = i;
            z2 = z;
        }
        if (sparseIntArray.size() != 0) {
            for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                pg4 pg4Var3 = (pg4) ieVarT.get((Animator) this.N0.get(sparseIntArray.keyAt(i5)));
                pg4Var3.f.setStartDelay(pg4Var3.f.getStartDelay() + (((long) sparseIntArray.valueAt(i5)) - Long.MAX_VALUE));
            }
        }
    }

    public final void n() {
        int i = this.I0 - 1;
        this.I0 = i;
        if (i == 0) {
            B(this, e04.z, false);
            for (int i2 = 0; i2 < ((ff2) this.z0.d).j(); i2++) {
                View view = (View) ((ff2) this.z0.d).k(i2);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i3 = 0; i3 < ((ff2) this.A0.d).j(); i3++) {
                View view2 = (View) ((ff2) this.A0.d).k(i3);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.K0 = true;
        }
    }

    public vg4 o(View view) {
        ArrayList arrayList = this.Z;
        if (view != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.contains(view)) {
                arrayList.add(view);
            }
        }
        this.Z = arrayList;
        return this;
    }

    public void p() {
        ArrayList arrayList = this.y0;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (!arrayList.contains(TextView.class)) {
            arrayList.add(TextView.class);
        }
        this.y0 = arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r2 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        if (r6 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        r4 = r4.E0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r4 = r4.D0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        return (defpackage.hh4) r4.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final hh4 q(View view, boolean z) {
        ch4 ch4Var = this.B0;
        if (ch4Var != null) {
            return ch4Var.q(view, z);
        }
        ArrayList arrayList = z ? this.D0 : this.E0;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            hh4 hh4Var = (hh4) arrayList.get(i);
            if (hh4Var == null) {
                return null;
            }
            if (hh4Var.b == view) {
                break;
            }
            i++;
        }
    }

    public final vg4 r() {
        ch4 ch4Var = this.B0;
        return ch4Var != null ? ch4Var.r() : this;
    }

    public final String toString() {
        return T("");
    }

    public String[] u() {
        return null;
    }

    public final hh4 v(View view, boolean z) {
        ch4 ch4Var = this.B0;
        if (ch4Var != null) {
            return ch4Var.v(view, z);
        }
        return (hh4) ((ie) (z ? this.z0 : this.A0).a).get(view);
    }

    public boolean w() {
        return !this.G0.isEmpty();
    }

    public boolean x() {
        return this instanceof w20;
    }

    public boolean y(hh4 hh4Var, hh4 hh4Var2) {
        if (hh4Var != null && hh4Var2 != null) {
            String[] strArrU = u();
            if (strArrU != null) {
                for (String str : strArrU) {
                    if (A(hh4Var, hh4Var2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = hh4Var.a.keySet().iterator();
                while (it.hasNext()) {
                    if (A(hh4Var, hh4Var2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean z(View view) {
        int id = view.getId();
        ArrayList arrayList = this.Z;
        if (arrayList != null && arrayList.contains(view)) {
            return false;
        }
        ArrayList arrayList2 = this.y0;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                if (((Class) this.y0.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        ArrayList arrayList3 = this.X;
        int size2 = arrayList3.size();
        ArrayList arrayList4 = this.Y;
        return (size2 == 0 && arrayList4.size() == 0) || arrayList3.contains(Integer.valueOf(id)) || arrayList4.contains(view);
    }

    public void Q() {
    }

    public void g(hh4 hh4Var) {
    }
}
