package androidx.fragment.app;

import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import defpackage.a71;
import defpackage.fw;
import defpackage.me2;
import defpackage.mk1;
import defpackage.nk1;
import defpackage.p33;
import defpackage.pj1;
import defpackage.q92;
import defpackage.st4;
import defpackage.vp1;
import defpackage.xe;
import defpackage.yj1;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a implements yj1 {
    public final ArrayList a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public String i;
    public int j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList n;
    public ArrayList o;
    public boolean p;
    public ArrayList q;
    public final u r;
    public boolean s;
    public int t;

    public a(u uVar) {
        uVar.J();
        pj1 pj1Var = uVar.x;
        if (pj1Var != null) {
            pj1Var.f.getClassLoader();
        }
        this.a = new ArrayList();
        this.h = true;
        this.p = false;
        this.t = -1;
        this.r = uVar;
    }

    @Override // defpackage.yj1
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (u.M(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        this.r.d.add(this);
        return true;
    }

    public final void b(nk1 nk1Var) {
        this.a.add(nk1Var);
        nk1Var.d = this.b;
        nk1Var.e = this.c;
        nk1Var.f = this.d;
        nk1Var.g = this.e;
    }

    public final void c(int i) {
        if (this.g) {
            if (u.M(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                nk1 nk1Var = (nk1) arrayList.get(i2);
                o oVar = nk1Var.b;
                if (oVar != null) {
                    oVar.mBackStackNesting += i;
                    if (u.M(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + nk1Var.b + " to " + nk1Var.b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final void d() {
        ArrayList arrayList = this.a;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            nk1 nk1Var = (nk1) arrayList.get(size);
            if (nk1Var.c) {
                if (nk1Var.a == 8) {
                    nk1Var.c = false;
                    arrayList.remove(size - 1);
                    size--;
                } else {
                    int i = nk1Var.b.mContainerId;
                    nk1Var.a = 2;
                    nk1Var.c = false;
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        nk1 nk1Var2 = (nk1) arrayList.get(i2);
                        if (nk1Var2.c && nk1Var2.b.mContainerId == i) {
                            arrayList.remove(i2);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    public final void e() {
        f(false, true);
    }

    public final int f(boolean z, boolean z2) {
        if (this.s) {
            xe.q("commit already called");
            return 0;
        }
        if (u.M(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new me2());
            h("  ", printWriter, true);
            printWriter.close();
        }
        this.s = true;
        boolean z3 = this.g;
        u uVar = this.r;
        if (z3) {
            this.t = uVar.k.getAndIncrement();
        } else {
            this.t = -1;
        }
        if (z2) {
            uVar.x(this, z);
        }
        return this.t;
    }

    public final void g(int i, o oVar, String str, int i2) {
        String str2 = oVar.mPreviousWho;
        if (str2 != null) {
            mk1.c(oVar, str2);
        }
        Class<?> cls = oVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            xe.l("Fragment ", cls.getCanonicalName(), " must be a public static class to be  properly recreated from instance state.");
            return;
        }
        if (str != null) {
            String str3 = oVar.mTag;
            if (str3 != null && !str.equals(str3)) {
                StringBuilder sb = new StringBuilder("Can't change tag of fragment ");
                sb.append(oVar);
                sb.append(": was ");
                xe.q(fw.z(sb, oVar.mTag, " now ", str));
                return;
            }
            oVar.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                a71.h("Can't add fragment ", oVar, " with tag ", str, " to container view with no id");
                return;
            }
            int i3 = oVar.mFragmentId;
            if (i3 != 0 && i3 != i) {
                StringBuilder sb2 = new StringBuilder("Can't change container ID of fragment ");
                sb2.append(oVar);
                int i4 = oVar.mFragmentId;
                sb2.append(": was ");
                sb2.append(i4);
                sb2.append(" now ");
                sb2.append(i);
                throw new IllegalStateException(sb2.toString());
            }
            oVar.mFragmentId = i;
            oVar.mContainerId = i;
        }
        b(new nk1(oVar, i2));
        oVar.mFragmentManager = this.r;
    }

    public final void h(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.s);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (this.b != 0 || this.c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.j != 0 || this.k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.k);
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        ArrayList arrayList = this.a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            nk1 nk1Var = (nk1) arrayList.get(i);
            switch (nk1Var.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + nk1Var.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(nk1Var.b);
            if (z) {
                if (nk1Var.d != 0 || nk1Var.e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(nk1Var.d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(nk1Var.e));
                }
                if (nk1Var.f != 0 || nk1Var.g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(nk1Var.f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(nk1Var.g));
                }
            }
        }
    }

    public final void i(o oVar) {
        u uVar = oVar.mFragmentManager;
        if (uVar == null || uVar == this.r) {
            b(new nk1(oVar, 4));
        } else {
            xe.g(oVar, "Cannot hide Fragment attached to a different FragmentManager. Fragment ");
        }
    }

    public final void j(o oVar) {
        u uVar = oVar.mFragmentManager;
        if (uVar == null || uVar == this.r) {
            b(new nk1(oVar, 3));
        } else {
            xe.g(oVar, "Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        }
    }

    public final void k(o oVar, int i) {
        if (i != 0) {
            g(i, oVar, null, 2);
        } else {
            xe.k("Must use non-zero containerViewId");
        }
    }

    public final void l(boolean z, Runnable runnable) {
        if (!z) {
            if (this.g) {
                xe.q("This transaction is already being added to the back stack");
                return;
            }
            this.h = false;
        }
        ArrayList arrayList = this.q;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.q = arrayList;
        }
        arrayList.add(runnable);
    }

    public final void m(o oVar, q92 q92Var) {
        u uVar = oVar.mFragmentManager;
        u uVar2 = this.r;
        if (uVar != uVar2) {
            vp1.h(uVar2, "Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
            return;
        }
        if (q92Var == q92.f && oVar.mState > -1) {
            st4.p("Cannot set maximum Lifecycle to ", q92Var, " after the Fragment has been created");
            return;
        }
        if (q92Var == q92.b) {
            st4.p("Cannot set maximum Lifecycle to ", q92Var, ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
            return;
        }
        nk1 nk1Var = new nk1();
        nk1Var.a = 10;
        nk1Var.b = oVar;
        nk1Var.c = false;
        nk1Var.h = oVar.mMaxState;
        nk1Var.i = q92Var;
        b(nk1Var);
    }

    public final void n(p33 p33Var) {
        u uVar = p33Var.mFragmentManager;
        if (uVar == null || uVar == this.r) {
            b(new nk1(p33Var, 8));
        } else {
            xe.g(p33Var, "Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
        }
    }

    public final void o(o oVar) {
        u uVar = oVar.mFragmentManager;
        if (uVar == null || uVar == this.r) {
            b(new nk1(oVar, 5));
        } else {
            xe.g(oVar, "Cannot show Fragment attached to a different FragmentManager. Fragment ");
        }
    }

    public final String toString() {
        StringBuilder sbB = fw.B(128, "BackStackEntry{");
        sbB.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.t >= 0) {
            sbB.append(" #");
            sbB.append(this.t);
        }
        if (this.i != null) {
            sbB.append(" ");
            sbB.append(this.i);
        }
        sbB.append("}");
        return sbB.toString();
    }
}
