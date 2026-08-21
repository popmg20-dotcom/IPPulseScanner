package defpackage;

import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wt2 {
    public Object a;
    public final Object b;
    public boolean c;
    public final Object d;
    public Object e;

    public wt2() {
        this.b = new Object();
        this.d = new fa5(9);
    }

    public static wt2 b(nj4 nj4Var, p83 p83Var, m83 m83Var, boolean z) {
        String str = p83Var == null ? null : p83Var.b;
        return new wt2(nj4Var, str != null ? new ft3(str) : null, m83Var, null, z);
    }

    public void a() {
        TabLayout tabLayout = (TabLayout) this.b;
        ViewPager2 viewPager2 = (ViewPager2) this.d;
        if (this.c) {
            xe.q("TabLayoutMediator is already attached");
            return;
        }
        rf3 adapter = viewPager2.getAdapter();
        this.a = adapter;
        if (adapter == null) {
            xe.q("TabLayoutMediator attached before ViewPager2 has an adapter");
            return;
        }
        this.c = true;
        ((ArrayList) viewPager2.z.b).add(new ia4(tabLayout));
        ja4 ja4Var = new ja4(viewPager2);
        ArrayList arrayList = tabLayout.f1;
        if (!arrayList.contains(ja4Var)) {
            arrayList.add(ja4Var);
        }
        ((rf3) this.a).n(new ik1(4, this));
        f();
        tabLayout.h(viewPager2.getCurrentItem(), 0.0f, true, true, true);
    }

    public Exception c() {
        Exception exc;
        synchronized (this.b) {
            exc = (Exception) this.a;
        }
        return exc;
    }

    public Object d() {
        Object obj;
        synchronized (this.b) {
            try {
                tj4.k("Task is not yet complete", this.c);
                Exception exc = (Exception) this.a;
                if (exc != null) {
                    throw new t80(exc);
                }
                obj = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public boolean e() {
        boolean z;
        synchronized (this.b) {
            z = false;
            if (this.c && ((Exception) this.a) == null) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void f() {
        TabLayout tabLayout = (TabLayout) this.b;
        ArrayList arrayList = tabLayout.f;
        tabLayout.f();
        rf3 rf3Var = (rf3) this.a;
        if (rf3Var != null) {
            int iB = rf3Var.b();
            for (int i = 0; i < iB; i++) {
                fa4 fa4VarE = tabLayout.e();
                ((ha4) this.e).a(fa4VarE, i);
                int size = arrayList.size();
                if (fa4VarE.d != tabLayout) {
                    xe.k("Tab belongs to a different TabLayout.");
                    return;
                }
                fa4VarE.b = size;
                arrayList.add(size, fa4VarE);
                int size2 = arrayList.size();
                int i2 = -1;
                for (int i3 = size + 1; i3 < size2; i3++) {
                    if (((fa4) arrayList.get(i3)).b == tabLayout.b) {
                        i2 = i3;
                    }
                    ((fa4) arrayList.get(i3)).b = i3;
                }
                tabLayout.b = i2;
                ga4 ga4Var = fa4VarE.e;
                ga4Var.setSelected(false);
                ga4Var.setActivated(false);
                ea4 ea4Var = tabLayout.A;
                int i4 = fa4VarE.b;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                if (tabLayout.W0 == 1 && tabLayout.T0 == 0) {
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                } else {
                    layoutParams.width = -2;
                    layoutParams.weight = 0.0f;
                }
                ea4Var.addView(ga4Var, i4, layoutParams);
            }
            if (iB > 0) {
                int iMin = Math.min(((ViewPager2) this.d).getCurrentItem(), tabLayout.getTabCount() - 1);
                if (iMin != tabLayout.getSelectedTabPosition()) {
                    tabLayout.g((iMin < 0 || iMin >= tabLayout.getTabCount()) ? null : (fa4) arrayList.get(iMin), true);
                }
            }
        }
    }

    public void g(Object obj) {
        synchronized (this.b) {
            i();
            this.c = true;
            this.e = obj;
        }
        ((fa5) this.d).y(this);
    }

    public void h(Exception exc) {
        synchronized (this.b) {
            i();
            this.c = true;
            this.a = exc;
        }
        ((fa5) this.d).y(this);
    }

    public void i() {
        boolean z;
        if (this.c) {
            synchronized (this.b) {
                z = this.c;
            }
            if (!z) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excC = c();
        }
    }

    public void j() {
        synchronized (this.b) {
            try {
                if (this.c) {
                    ((fa5) this.d).y(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public wt2(nj4 nj4Var, ft3 ft3Var, m83 m83Var, b72 b72Var, boolean z) {
        this.b = nj4Var;
        this.d = ft3Var;
        this.e = m83Var;
        this.a = b72Var;
        this.c = z;
    }

    public wt2(TabLayout tabLayout, ViewPager2 viewPager2, ha4 ha4Var) {
        this.b = tabLayout;
        this.d = viewPager2;
        this.e = ha4Var;
    }

    public wt2(wt2 wt2Var, uj4 uj4Var, b72 b72Var) {
        this.d = wt2Var;
        this.a = b72Var;
        this.c = uj4Var.d;
        this.e = uj4Var.b;
        this.b = uj4Var.c;
    }
}
