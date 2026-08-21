package com.getsurfboard.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.fragment.AddHostFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import defpackage.ah4;
import defpackage.bt1;
import defpackage.ca;
import defpackage.cd;
import defpackage.dh3;
import defpackage.dt1;
import defpackage.et1;
import defpackage.ft1;
import defpackage.gt1;
import defpackage.ht1;
import defpackage.it1;
import defpackage.j80;
import defpackage.jd;
import defpackage.jt1;
import defpackage.k22;
import defpackage.l72;
import defpackage.lw0;
import defpackage.mp4;
import defpackage.n12;
import defpackage.ti2;
import defpackage.ub1;
import defpackage.v9;
import defpackage.v92;
import defpackage.vf2;
import defpackage.wp4;
import defpackage.ws4;
import defpackage.yh0;
import defpackage.yh2;
import defpackage.z71;
import defpackage.zo2;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class HostsListActivity extends ca {
    public static final /* synthetic */ int a1 = 0;
    public j80 S0;
    public final k22 T0;
    public boolean U0;
    public View V0;
    public final bt1 W0;
    public final v92 X0;
    public final gt1 Y0;
    public boolean Z0;

    public HostsListActivity() {
        k22 k22Var = new k22(new ft1(this));
        this.T0 = k22Var;
        int i = 0;
        this.W0 = new bt1(k22Var, new cd(2, this), new dt1(this, i));
        this.X0 = new v92(dh3.a(jt1.class), new ht1(this, 1), new ht1(this, 0), new ht1(this, 2));
        this.Y0 = new gt1(i, this);
    }

    public static final void start(View view) {
        view.getClass();
        view.getContext().startActivity(new Intent(view.getContext(), (Class<?>) HostsListActivity.class), l72.z(view));
    }

    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        int i = 0;
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_hosts_list, (ViewGroup) null, false);
        int i2 = R.id.add;
        FloatingActionButton floatingActionButton = (FloatingActionButton) vf2.l(viewInflate, R.id.add);
        if (floatingActionButton != null) {
            i2 = R.id.add_host_container;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) vf2.l(viewInflate, R.id.add_host_container);
            if (fragmentContainerView != null) {
                i2 = R.id.appbar;
                if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
                    i2 = R.id.empty_hint;
                    MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.empty_hint);
                    if (materialTextView != null) {
                        i2 = R.id.mask;
                        View viewL = vf2.l(viewInflate, R.id.mask);
                        if (viewL != null) {
                            i2 = R.id.recycler_view;
                            RecyclerView recyclerView = (RecyclerView) vf2.l(viewInflate, R.id.recycler_view);
                            if (recyclerView != null) {
                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                                i2 = R.id.toolbar;
                                MaterialToolbar materialToolbar = (MaterialToolbar) vf2.l(viewInflate, R.id.toolbar);
                                if (materialToolbar != null) {
                                    i2 = R.id.toolbar_divider;
                                    MaterialDivider materialDivider = (MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider);
                                    if (materialDivider != null) {
                                        this.S0 = new j80(floatingActionButton, fragmentContainerView, materialTextView, viewL, recyclerView, coordinatorLayout, materialToolbar, materialDivider);
                                        setContentView(coordinatorLayout);
                                        j80 j80Var = this.S0;
                                        if (j80Var == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) j80Var.f;
                                        jd jdVar = new jd(15, this);
                                        WeakHashMap weakHashMap = wp4.a;
                                        mp4.c(coordinatorLayout2, jdVar);
                                        j80 j80Var2 = this.S0;
                                        if (j80Var2 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        ((MaterialToolbar) j80Var2.g).setNavigationOnClickListener(new et1(this, i));
                                        j80 j80Var3 = this.S0;
                                        if (j80Var3 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        int i3 = 1;
                                        ((View) j80Var3.d).setOnClickListener(new et1(this, i3));
                                        b().b(this.Y0);
                                        j80 j80Var4 = this.S0;
                                        if (j80Var4 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        int i4 = 2;
                                        ((FloatingActionButton) j80Var4.a).setOnClickListener(new et1(this, i4));
                                        j80 j80Var5 = this.S0;
                                        if (j80Var5 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        ((RecyclerView) j80Var5.e).i(new lw0(this));
                                        j80 j80Var6 = this.S0;
                                        if (j80Var6 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        this.T0.i((RecyclerView) j80Var6.e);
                                        j80 j80Var7 = this.S0;
                                        if (j80Var7 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        ((RecyclerView) j80Var7.e).setAdapter(this.W0);
                                        j80 j80Var8 = this.S0;
                                        if (j80Var8 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        ((RecyclerView) j80Var8.e).j(new z71(i3, this));
                                        ((jt1) this.X0.getValue()).b.e(this, new yh0(1, new dt1(this, i3)));
                                        ws4.a.e(this, new yh0(1, new dt1(this, i4)));
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    public final void x(View view, boolean z) {
        View view2;
        if (!z) {
            j80 j80Var = this.S0;
            if (j80Var == null) {
                n12.T("binding");
                throw null;
            }
            AddHostFragment addHostFragment = (AddHostFragment) ((FragmentContainerView) j80Var.b).getFragment();
            ContextUtilsKt.m().hideSoftInputFromWindow((((TextInputLayout) addHostFragment.l().g).getVisibility() == 0 ? (MaterialAutoCompleteTextView) addHostFragment.l().h : (TextInputEditText) addHostFragment.l().i).getWindowToken(), 0);
            ((TextInputLayout) addHostFragment.l().f).setError(null);
            ((TextInputLayout) addHostFragment.l().g).setError(null);
            ((TextInputLayout) addHostFragment.l().d).setError(null);
        }
        if (!z) {
            j80 j80Var2 = this.S0;
            if (j80Var2 == null) {
                n12.T("binding");
                throw null;
            }
            view = (FragmentContainerView) j80Var2.b;
        } else if (view == null) {
            j80 j80Var3 = this.S0;
            if (j80Var3 == null) {
                n12.T("binding");
                throw null;
            }
            view = (FloatingActionButton) j80Var3.a;
        }
        if (z) {
            j80 j80Var4 = this.S0;
            if (j80Var4 == null) {
                n12.T("binding");
                throw null;
            }
            view2 = (FragmentContainerView) j80Var4.b;
        } else {
            view2 = this.V0;
            if (view2 == null) {
                j80 j80Var5 = this.S0;
                if (j80Var5 == null) {
                    n12.T("binding");
                    throw null;
                }
                view2 = (FloatingActionButton) j80Var5.a;
            }
        }
        ti2 ti2Var = new ti2(this, z);
        ti2Var.c1 = 0;
        j80 j80Var6 = this.S0;
        if (j80Var6 == null) {
            n12.T("binding");
            throw null;
        }
        ti2Var.Z0 = ((CoordinatorLayout) j80Var6.f).getId();
        ti2Var.z = ContextUtilsKt.getContext().getResources().getInteger(android.R.integer.config_mediumAnimTime);
        ti2Var.A = new ub1();
        ti2Var.P(new yh2());
        ti2Var.d1 = view;
        ti2Var.e1 = view2;
        ti2Var.b(view2);
        if (z) {
            ti2Var.g1 = 0.0f;
            ti2Var.h1 = ContextUtilsKt.c(8.0f);
        } else {
            ti2Var.g1 = ContextUtilsKt.c(8.0f);
            ti2Var.h1 = 0.0f;
        }
        ti2Var.a(new it1(i, this, z));
        j80 j80Var7 = this.S0;
        if (j80Var7 == null) {
            n12.T("binding");
            throw null;
        }
        ah4.a((CoordinatorLayout) j80Var7.f, ti2Var);
        view.setVisibility(4);
        view2.setVisibility(0);
        j80 j80Var8 = this.S0;
        if (j80Var8 == null) {
            n12.T("binding");
            throw null;
        }
        ((View) j80Var8.d).setVisibility(z ? 0 : 8);
        this.Y0.f(z);
    }
}
