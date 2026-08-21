package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import androidx.viewpager2.widget.ViewPager2;
import com.getsurfboard.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cb3 extends o implements jv2, hf4 {
    public final zn A = new zn(6, this);
    public uf4 b;
    public ra3 f;
    public t53 z;

    @Override // defpackage.hf4
    public final boolean a(sk2 sk2Var) {
        Iterable iterable;
        if (getContext() != null) {
            uf4 uf4Var = this.b;
            uf4Var.getClass();
            ViewPager2 viewPager2 = (ViewPager2) uf4Var.a;
            u childFragmentManager = getChildFragmentManager();
            childFragmentManager.getClass();
            rf3 adapter = viewPager2.getAdapter();
            if (adapter == null) {
                iterable = g41.b;
            } else {
                ArrayList arrayList = new ArrayList();
                int iB = adapter.b();
                for (int i = 0; i < iB; i++) {
                    long jC = adapter.c(i);
                    if (jC == -1) {
                        jC = i;
                    }
                    o oVarD = childFragmentManager.D("f" + jC);
                    if (oVarD instanceof ya3) {
                        arrayList.add(oVarD);
                    }
                }
                iterable = arrayList;
            }
            int i2 = sk2Var.a;
            if (i2 == R.id.sort_by_default) {
                mb3 mb3Var = mb3.b;
                t23.B(mb3Var);
                sk2Var.setChecked(true);
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    ((ya3) it.next()).j(mb3Var);
                }
            } else if (i2 == R.id.sort_by_delay) {
                mb3 mb3Var2 = mb3.f;
                t23.B(mb3Var2);
                sk2Var.setChecked(true);
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((ya3) it2.next()).j(mb3Var2);
                }
            } else if (i2 == R.id.sort_by_name) {
                mb3 mb3Var3 = mb3.z;
                t23.B(mb3Var3);
                sk2Var.setChecked(true);
                Iterator it3 = iterable.iterator();
                while (it3.hasNext()) {
                    ((ya3) it3.next()).j(mb3Var3);
                }
            } else {
                ya3 ya3Var = null;
                ya3Var = null;
                if (i2 == R.id.settings) {
                    Context contextRequireContext = requireContext();
                    contextRequireContext.getClass();
                    fx3.I(contextRequireContext, null, false);
                    return true;
                }
                uf4 uf4Var2 = this.b;
                uf4Var2.getClass();
                ViewPager2 viewPager22 = (ViewPager2) uf4Var2.a;
                u childFragmentManager2 = getChildFragmentManager();
                childFragmentManager2.getClass();
                int currentItem = viewPager22.getCurrentItem();
                rf3 adapter2 = viewPager22.getAdapter();
                if (adapter2 != null && adapter2.b() != 0) {
                    long jC2 = adapter2.c(currentItem);
                    if (jC2 == -1) {
                        jC2 = currentItem;
                    }
                    o oVarD2 = childFragmentManager2.D("f" + jC2);
                    ya3Var = (ya3) (oVarD2 instanceof ya3 ? oVarD2 : null);
                }
                if (ya3Var != null) {
                    return ya3Var.a(sk2Var);
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.jv2
    public final void c() {
        Object objD;
        uf4 uf4Var = this.b;
        if (uf4Var == null) {
            return;
        }
        ViewPager2 viewPager2 = (ViewPager2) uf4Var.a;
        u childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        int currentItem = viewPager2.getCurrentItem();
        rf3 adapter = viewPager2.getAdapter();
        if (adapter == null || adapter.b() == 0) {
            objD = null;
        } else {
            long jC = adapter.c(currentItem);
            if (jC == -1) {
                jC = currentItem;
            }
            objD = childFragmentManager.D("f" + jC);
        }
        if (objD instanceof jv2) {
            ((jv2) objD).c();
            return;
        }
        String str = objD + " not implement " + jv2.class;
        if (fy4.b) {
            Xlog.logWrite2(0L, 3, "ProxyGroupsFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return;
        }
        a1.o("ProxyGroupsFragment", str, null);
    }

    public final void j(List list) {
        View childAt;
        uf4 uf4Var = this.b;
        uf4Var.getClass();
        TabLayout tabLayout = (TabLayout) uf4Var.d;
        if (!tabLayout.isLaidOut() || tabLayout.isLayoutRequested()) {
            tabLayout.addOnLayoutChangeListener(new wh0(i, this, list));
            return;
        }
        uf4 uf4Var2 = this.b;
        uf4Var2.getClass();
        TabLayout tabLayout2 = (TabLayout) uf4Var2.d;
        if (tabLayout2.getChildCount() > 0) {
            childAt = tabLayout2.getChildAt(0);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
        } else {
            childAt = null;
        }
        if (childAt != null) {
            int width = childAt.getWidth();
            uf4 uf4Var3 = this.b;
            uf4Var3.getClass();
            int paddingStart = ((TabLayout) uf4Var3.d).getPaddingStart() + width;
            uf4 uf4Var4 = this.b;
            uf4Var4.getClass();
            int paddingEnd = ((TabLayout) uf4Var4.d).getPaddingEnd() + paddingStart;
            uf4 uf4Var5 = this.b;
            uf4Var5.getClass();
            i = paddingEnd <= ((TabLayout) uf4Var5.d).getWidth() ? 0 : 1;
            uf4 uf4Var6 = this.b;
            uf4Var6.getClass();
            ((ImageButton) uf4Var6.g).setVisibility(i == 0 ? 8 : 0);
            uf4 uf4Var7 = this.b;
            uf4Var7.getClass();
            ((ImageButton) uf4Var7.g).setOnClickListener(new bb3(this, list));
        }
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_proxygroups, viewGroup, false);
        int i = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i = R.id.empty;
            TextView textView = (TextView) vf2.l(viewInflate, R.id.empty);
            if (textView != null) {
                i = R.id.pager;
                ViewPager2 viewPager2 = (ViewPager2) vf2.l(viewInflate, R.id.pager);
                if (viewPager2 != null) {
                    i = R.id.tabs;
                    TabLayout tabLayout = (TabLayout) vf2.l(viewInflate, R.id.tabs);
                    if (tabLayout != null) {
                        i = R.id.test;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) vf2.l(viewInflate, R.id.test);
                        if (floatingActionButton != null) {
                            i = R.id.toolbar;
                            Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                            if (toolbar != null) {
                                i = R.id.toolbar_divider;
                                if (((MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider)) != null) {
                                    i = R.id.view_all;
                                    ImageButton imageButton = (ImageButton) vf2.l(viewInflate, R.id.view_all);
                                    if (imageButton != null) {
                                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                                        this.b = new uf4(coordinatorLayout, textView, viewPager2, tabLayout, floatingActionButton, toolbar, imageButton);
                                        coordinatorLayout.getClass();
                                        return coordinatorLayout;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        uf4 uf4Var = this.b;
        uf4Var.getClass();
        Menu menu = ((Toolbar) uf4Var.f).getMenu();
        final int i = 1;
        if (menu instanceof nk2) {
            ((nk2) menu).setGroupDividerEnabled(true);
        } else if (Build.VERSION.SDK_INT >= 28) {
            u9.D(menu);
        }
        if (menu instanceof nk2) {
            ((nk2) menu).s = true;
        }
        int iOrdinal = t23.n().ordinal();
        final int i2 = 2;
        if (iOrdinal == 0) {
            uf4 uf4Var2 = this.b;
            uf4Var2.getClass();
            MenuItem menuItemFindItem = ((Toolbar) uf4Var2.f).getMenu().findItem(R.id.sort_by_default);
            if (menuItemFindItem != null) {
                menuItemFindItem.setChecked(true);
            }
        } else if (iOrdinal == 1) {
            uf4 uf4Var3 = this.b;
            uf4Var3.getClass();
            MenuItem menuItemFindItem2 = ((Toolbar) uf4Var3.f).getMenu().findItem(R.id.sort_by_delay);
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setChecked(true);
            }
        } else {
            if (iOrdinal != 2) {
                g.d();
                return;
            }
            uf4 uf4Var4 = this.b;
            uf4Var4.getClass();
            MenuItem menuItemFindItem3 = ((Toolbar) uf4Var4.f).getMenu().findItem(R.id.sort_by_name);
            if (menuItemFindItem3 != null) {
                menuItemFindItem3.setChecked(true);
            }
        }
        uf4 uf4Var5 = this.b;
        uf4Var5.getClass();
        ((Toolbar) uf4Var5.f).setOnMenuItemClickListener(this);
        final int i3 = 0;
        d73.c.e(getViewLifecycleOwner(), new yh0(5, new am1(this) { // from class: za3
            public final /* synthetic */ cb3 f;

            {
                this.f = this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
            @Override // defpackage.am1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object g(java.lang.Object r5) {
                /*
                    r4 = this;
                    int r0 = r2
                    xl4 r1 = defpackage.xl4.a
                    r2 = 1
                    cb3 r4 = r4.f
                    switch(r0) {
                        case 0: goto L66;
                        case 1: goto L20;
                        default: goto La;
                    }
                La:
                    java.lang.Boolean r5 = (java.lang.Boolean) r5
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    java.lang.Boolean r0 = java.lang.Boolean.TRUE
                    boolean r5 = defpackage.n12.c(r5, r0)
                    r5 = r5 ^ r2
                    r4.setEnabled(r5)
                    return r1
                L20:
                    vs4 r5 = (defpackage.vs4) r5
                    boolean r0 = r5.b
                    if (r0 == 0) goto L59
                    java.lang.String r5 = r5.a
                    on2 r0 = defpackage.d73.c
                    java.lang.Object r0 = r0.d()
                    t53 r0 = (defpackage.t53) r0
                    if (r0 == 0) goto L35
                    java.lang.String r0 = r0.b
                    goto L36
                L35:
                    r0 = 0
                L36:
                    boolean r5 = defpackage.n12.c(r5, r0)
                    if (r5 == 0) goto L59
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.c
                    android.widget.TextView r5 = (android.widget.TextView) r5
                    int r5 = r5.getVisibility()
                    if (r5 != 0) goto L4c
                    goto L59
                L4c:
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    r4.f(r2)
                    goto L65
                L59:
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    r4.d(r2)
                L65:
                    return r1
                L66:
                    t53 r5 = (defpackage.t53) r5
                    t53 r0 = r4.z
                    zn r3 = r4.A
                    boolean r0 = defpackage.n12.c(r5, r0)
                    if (r0 == 0) goto L73
                    goto Lb6
                L73:
                    r4.z = r5
                    on2 r0 = defpackage.t23.d
                    r0.j(r3)
                    if (r5 != 0) goto Laf
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.c
                    android.widget.TextView r5 = (android.widget.TextView) r5
                    r0 = 0
                    r5.setVisibility(r0)
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.d
                    com.google.android.material.tabs.TabLayout r5 = (com.google.android.material.tabs.TabLayout) r5
                    r0 = 4
                    r5.setVisibility(r0)
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.a
                    androidx.viewpager2.widget.ViewPager2 r5 = (androidx.viewpager2.widget.ViewPager2) r5
                    r5.setVisibility(r0)
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    r4.d(r2)
                    goto Lb6
                Laf:
                    da2 r4 = r4.getViewLifecycleOwner()
                    r0.e(r4, r3)
                Lb6:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.za3.g(java.lang.Object):java.lang.Object");
            }
        }));
        ws4.c.e(getViewLifecycleOwner(), new yh0(5, new am1(this) { // from class: za3
            public final /* synthetic */ cb3 f;

            {
                this.f = this;
            }

            @Override // defpackage.am1
            public final Object g(Object v) {
                /*
                    this = this;
                    int r0 = r2
                    xl4 r1 = defpackage.xl4.a
                    r2 = 1
                    cb3 r4 = r4.f
                    switch(r0) {
                        case 0: goto L66;
                        case 1: goto L20;
                        default: goto La;
                    }
                La:
                    java.lang.Boolean r5 = (java.lang.Boolean) r5
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    java.lang.Boolean r0 = java.lang.Boolean.TRUE
                    boolean r5 = defpackage.n12.c(r5, r0)
                    r5 = r5 ^ r2
                    r4.setEnabled(r5)
                    return r1
                L20:
                    vs4 r5 = (defpackage.vs4) r5
                    boolean r0 = r5.b
                    if (r0 == 0) goto L59
                    java.lang.String r5 = r5.a
                    on2 r0 = defpackage.d73.c
                    java.lang.Object r0 = r0.d()
                    t53 r0 = (defpackage.t53) r0
                    if (r0 == 0) goto L35
                    java.lang.String r0 = r0.b
                    goto L36
                L35:
                    r0 = 0
                L36:
                    boolean r5 = defpackage.n12.c(r5, r0)
                    if (r5 == 0) goto L59
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.c
                    android.widget.TextView r5 = (android.widget.TextView) r5
                    int r5 = r5.getVisibility()
                    if (r5 != 0) goto L4c
                    goto L59
                L4c:
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    r4.f(r2)
                    goto L65
                L59:
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    r4.d(r2)
                L65:
                    return r1
                L66:
                    t53 r5 = (defpackage.t53) r5
                    t53 r0 = r4.z
                    zn r3 = r4.A
                    boolean r0 = defpackage.n12.c(r5, r0)
                    if (r0 == 0) goto L73
                    goto Lb6
                L73:
                    r4.z = r5
                    on2 r0 = defpackage.t23.d
                    r0.j(r3)
                    if (r5 != 0) goto Laf
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.c
                    android.widget.TextView r5 = (android.widget.TextView) r5
                    r0 = 0
                    r5.setVisibility(r0)
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.d
                    com.google.android.material.tabs.TabLayout r5 = (com.google.android.material.tabs.TabLayout) r5
                    r0 = 4
                    r5.setVisibility(r0)
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.a
                    androidx.viewpager2.widget.ViewPager2 r5 = (androidx.viewpager2.widget.ViewPager2) r5
                    r5.setVisibility(r0)
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    r4.d(r2)
                    goto Lb6
                Laf:
                    da2 r4 = r4.getViewLifecycleOwner()
                    r0.e(r4, r3)
                Lb6:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.za3.g(java.lang.Object):java.lang.Object");
            }
        }));
        ws4.b.e(getViewLifecycleOwner(), new yh0(5, new am1(this) { // from class: za3
            public final /* synthetic */ cb3 f;

            {
                this.f = this;
            }

            @Override // defpackage.am1
            public final Object g(Object v) {
                /*
                    this = this;
                    int r0 = r2
                    xl4 r1 = defpackage.xl4.a
                    r2 = 1
                    cb3 r4 = r4.f
                    switch(r0) {
                        case 0: goto L66;
                        case 1: goto L20;
                        default: goto La;
                    }
                La:
                    java.lang.Boolean r5 = (java.lang.Boolean) r5
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    java.lang.Boolean r0 = java.lang.Boolean.TRUE
                    boolean r5 = defpackage.n12.c(r5, r0)
                    r5 = r5 ^ r2
                    r4.setEnabled(r5)
                    return r1
                L20:
                    vs4 r5 = (defpackage.vs4) r5
                    boolean r0 = r5.b
                    if (r0 == 0) goto L59
                    java.lang.String r5 = r5.a
                    on2 r0 = defpackage.d73.c
                    java.lang.Object r0 = r0.d()
                    t53 r0 = (defpackage.t53) r0
                    if (r0 == 0) goto L35
                    java.lang.String r0 = r0.b
                    goto L36
                L35:
                    r0 = 0
                L36:
                    boolean r5 = defpackage.n12.c(r5, r0)
                    if (r5 == 0) goto L59
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.c
                    android.widget.TextView r5 = (android.widget.TextView) r5
                    int r5 = r5.getVisibility()
                    if (r5 != 0) goto L4c
                    goto L59
                L4c:
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    r4.f(r2)
                    goto L65
                L59:
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    r4.d(r2)
                L65:
                    return r1
                L66:
                    t53 r5 = (defpackage.t53) r5
                    t53 r0 = r4.z
                    zn r3 = r4.A
                    boolean r0 = defpackage.n12.c(r5, r0)
                    if (r0 == 0) goto L73
                    goto Lb6
                L73:
                    r4.z = r5
                    on2 r0 = defpackage.t23.d
                    r0.j(r3)
                    if (r5 != 0) goto Laf
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.c
                    android.widget.TextView r5 = (android.widget.TextView) r5
                    r0 = 0
                    r5.setVisibility(r0)
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.d
                    com.google.android.material.tabs.TabLayout r5 = (com.google.android.material.tabs.TabLayout) r5
                    r0 = 4
                    r5.setVisibility(r0)
                    uf4 r5 = r4.b
                    r5.getClass()
                    java.lang.Object r5 = r5.a
                    androidx.viewpager2.widget.ViewPager2 r5 = (androidx.viewpager2.widget.ViewPager2) r5
                    r5.setVisibility(r0)
                    uf4 r4 = r4.b
                    r4.getClass()
                    java.lang.Object r4 = r4.e
                    com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
                    r4.d(r2)
                    goto Lb6
                Laf:
                    da2 r4 = r4.getViewLifecycleOwner()
                    r0.e(r4, r3)
                Lb6:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.za3.g(java.lang.Object):java.lang.Object");
            }
        }));
        uf4 uf4Var6 = this.b;
        uf4Var6.getClass();
        ((FloatingActionButton) uf4Var6.e).setOnClickListener(new mk(20, this));
        u childFragmentManager = getChildFragmentManager();
        da2 viewLifecycleOwner = getViewLifecycleOwner();
        ab3 ab3Var = new ab3(this);
        childFragmentManager.getClass();
        r92 lifecycle = viewLifecycleOwner.getLifecycle();
        if (lifecycle.b() != q92.b) {
            uj1 uj1Var = new uj1(childFragmentManager, ab3Var, lifecycle);
            xj1 xj1Var = (xj1) childFragmentManager.n.put("proxy_group_selection", new xj1(lifecycle, ab3Var, uj1Var));
            if (xj1Var != null) {
                xj1Var.a.c(xj1Var.c);
            }
            if (u.M(2)) {
                Log.v("FragmentManager", "Setting FragmentResultListener with key proxy_group_selection lifecycleOwner " + lifecycle + " and listener " + ab3Var);
            }
            lifecycle.a(uj1Var);
        }
        uf4 uf4Var7 = this.b;
        uf4Var7.getClass();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) uf4Var7.b;
        ab3 ab3Var2 = new ab3(this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(coordinatorLayout, ab3Var2);
    }
}
