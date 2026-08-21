package com.getsurfboard.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.OverrideDoHActivity;
import com.getsurfboard.ui.fragment.AddDoHFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textview.MaterialTextView;
import defpackage.ah4;
import defpackage.bx0;
import defpackage.ca;
import defpackage.d70;
import defpackage.el1;
import defpackage.gt1;
import defpackage.it1;
import defpackage.iv1;
import defpackage.jd;
import defpackage.k22;
import defpackage.kf4;
import defpackage.l72;
import defpackage.lw0;
import defpackage.mp4;
import defpackage.n12;
import defpackage.op;
import defpackage.oy3;
import defpackage.ru2;
import defpackage.t23;
import defpackage.ti2;
import defpackage.tj4;
import defpackage.tx2;
import defpackage.ub1;
import defpackage.uf4;
import defpackage.v9;
import defpackage.vf2;
import defpackage.vt4;
import defpackage.wp4;
import defpackage.wu2;
import defpackage.xe;
import defpackage.yh2;
import defpackage.yw0;
import defpackage.za;
import defpackage.zo2;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class OverrideDoHActivity extends ca {
    public static final /* synthetic */ int X0 = 0;
    public uf4 S0;
    public View U0;
    public final ArrayList T0 = new ArrayList();
    public final bx0 V0 = new bx0(new op(3, this), new el1(2, this));
    public final gt1 W0 = new gt1(3, this);

    public static final void start(View view) {
        view.getClass();
        view.getContext().startActivity(new Intent(view.getContext(), (Class<?>) OverrideDoHActivity.class), l72.z(view));
    }

    public final void A() {
        boolean zIsEmpty = this.T0.isEmpty();
        uf4 uf4Var = this.S0;
        if (uf4Var == null) {
            n12.T("binding");
            throw null;
        }
        ((RecyclerView) uf4Var.e).setVisibility(!zIsEmpty ? 0 : 8);
        uf4 uf4Var2 = this.S0;
        if (uf4Var2 != null) {
            ((MaterialTextView) uf4Var2.d).setVisibility(zIsEmpty ? 0 : 8);
        } else {
            n12.T("binding");
            throw null;
        }
    }

    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        final int i = 0;
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_override_doh, (ViewGroup) null, false);
        int i2 = R.id.add_doh_container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) vf2.l(viewInflate, R.id.add_doh_container);
        if (fragmentContainerView != null) {
            i2 = R.id.appbar;
            if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
                i2 = R.id.btn_add;
                FloatingActionButton floatingActionButton = (FloatingActionButton) vf2.l(viewInflate, R.id.btn_add);
                if (floatingActionButton != null) {
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
                                    this.S0 = new uf4(fragmentContainerView, floatingActionButton, materialTextView, viewL, recyclerView, coordinatorLayout, materialToolbar);
                                    setContentView(coordinatorLayout);
                                    uf4 uf4Var = this.S0;
                                    if (uf4Var == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) uf4Var.f;
                                    jd jdVar = new jd(28, this);
                                    WeakHashMap weakHashMap = wp4.a;
                                    mp4.c(coordinatorLayout2, jdVar);
                                    uf4 uf4Var2 = this.S0;
                                    if (uf4Var2 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    MaterialToolbar materialToolbar2 = (MaterialToolbar) uf4Var2.g;
                                    za zaVar = (za) w();
                                    Object obj = zaVar.A0;
                                    final int i3 = 1;
                                    if (obj instanceof Activity) {
                                        zaVar.E();
                                        tj4 tj4Var = zaVar.E0;
                                        if (tj4Var instanceof vt4) {
                                            xe.q("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
                                            return;
                                        }
                                        zaVar.F0 = null;
                                        if (tj4Var != null) {
                                            tj4Var.R();
                                        }
                                        zaVar.E0 = null;
                                        kf4 kf4Var = new kf4(materialToolbar2, obj instanceof Activity ? ((Activity) obj).getTitle() : zaVar.G0, zaVar.D0);
                                        zaVar.E0 = kf4Var;
                                        zaVar.D0.f = kf4Var.n;
                                        materialToolbar2.setBackInvokedCallbackEnabled(true);
                                        zaVar.d();
                                    }
                                    uf4 uf4Var3 = this.S0;
                                    if (uf4Var3 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    ((MaterialToolbar) uf4Var3.g).setNavigationOnClickListener(new View.OnClickListener(this) { // from class: rx2
                                        public final /* synthetic */ OverrideDoHActivity f;

                                        {
                                            this.f = this;
                                        }

                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            int i4 = i;
                                            OverrideDoHActivity overrideDoHActivity = this.f;
                                            switch (i4) {
                                                case 0:
                                                    int i5 = OverrideDoHActivity.X0;
                                                    overrideDoHActivity.b().d();
                                                    break;
                                                case 1:
                                                    int i6 = OverrideDoHActivity.X0;
                                                    overrideDoHActivity.z(null, false);
                                                    break;
                                                default:
                                                    int i7 = OverrideDoHActivity.X0;
                                                    overrideDoHActivity.y(-1, null);
                                                    break;
                                            }
                                        }
                                    });
                                    uf4 uf4Var4 = this.S0;
                                    if (uf4Var4 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    ((View) uf4Var4.a).setOnClickListener(new View.OnClickListener(this) { // from class: rx2
                                        public final /* synthetic */ OverrideDoHActivity f;

                                        {
                                            this.f = this;
                                        }

                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            int i4 = i3;
                                            OverrideDoHActivity overrideDoHActivity = this.f;
                                            switch (i4) {
                                                case 0:
                                                    int i5 = OverrideDoHActivity.X0;
                                                    overrideDoHActivity.b().d();
                                                    break;
                                                case 1:
                                                    int i6 = OverrideDoHActivity.X0;
                                                    overrideDoHActivity.z(null, false);
                                                    break;
                                                default:
                                                    int i7 = OverrideDoHActivity.X0;
                                                    overrideDoHActivity.y(-1, null);
                                                    break;
                                            }
                                        }
                                    });
                                    wu2 wu2VarB = b();
                                    ru2 ru2Var = this.W0;
                                    wu2VarB.b(ru2Var);
                                    List listR = t23.r();
                                    ArrayList arrayList = this.T0;
                                    if (listR != null) {
                                        arrayList.addAll(listR);
                                    }
                                    uf4 uf4Var5 = this.S0;
                                    if (uf4Var5 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    ((RecyclerView) uf4Var5.e).i(new lw0(this));
                                    uf4 uf4Var6 = this.S0;
                                    if (uf4Var6 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    RecyclerView recyclerView2 = (RecyclerView) uf4Var6.e;
                                    bx0 bx0Var = this.V0;
                                    recyclerView2.setAdapter(bx0Var);
                                    bx0Var.r(d70.y0(arrayList));
                                    A();
                                    k22 k22Var = new k22(new tx2(this));
                                    uf4 uf4Var7 = this.S0;
                                    if (uf4Var7 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    k22Var.i((RecyclerView) uf4Var7.e);
                                    uf4 uf4Var8 = this.S0;
                                    if (uf4Var8 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    final int i4 = 2;
                                    ((FloatingActionButton) uf4Var8.c).setOnClickListener(new View.OnClickListener(this) { // from class: rx2
                                        public final /* synthetic */ OverrideDoHActivity f;

                                        {
                                            this.f = this;
                                        }

                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            int i42 = i4;
                                            OverrideDoHActivity overrideDoHActivity = this.f;
                                            switch (i42) {
                                                case 0:
                                                    int i5 = OverrideDoHActivity.X0;
                                                    overrideDoHActivity.b().d();
                                                    break;
                                                case 1:
                                                    int i6 = OverrideDoHActivity.X0;
                                                    overrideDoHActivity.z(null, false);
                                                    break;
                                                default:
                                                    int i7 = OverrideDoHActivity.X0;
                                                    overrideDoHActivity.y(-1, null);
                                                    break;
                                            }
                                        }
                                    });
                                    uf4 uf4Var9 = this.S0;
                                    if (uf4Var9 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    if (((FragmentContainerView) uf4Var9.b).getVisibility() == 0) {
                                        uf4 uf4Var10 = this.S0;
                                        if (uf4Var10 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        ((View) uf4Var10.a).setVisibility(0);
                                        ru2Var.f(true);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    public final void x(int i) {
        if (i >= 0) {
            ArrayList arrayList = this.T0;
            if (i >= arrayList.size()) {
                return;
            }
            String str = (String) arrayList.remove(i);
            this.V0.r(d70.y0(arrayList));
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            t23.x(arrayList);
            uf4 uf4Var = this.S0;
            if (uf4Var == null) {
                n12.T("binding");
                throw null;
            }
            oy3 oy3VarG = oy3.g((CoordinatorLayout) uf4Var.f, R.string.override_doh_server_deleted, 0);
            oy3VarG.i(R.string.undo, new yw0(i, 1, this, str));
            oy3VarG.j();
            A();
        }
    }

    public final void y(int i, String str) {
        View view;
        uf4 uf4Var = this.S0;
        if (uf4Var == null) {
            n12.T("binding");
            throw null;
        }
        ((AddDoHFragment) ((FragmentContainerView) uf4Var.b).getFragment()).j(i, str);
        if (str == null) {
            this.U0 = null;
        }
        if (str != null) {
            view = this.U0;
        } else {
            uf4 uf4Var2 = this.S0;
            if (uf4Var2 == null) {
                n12.T("binding");
                throw null;
            }
            view = (FloatingActionButton) uf4Var2.c;
        }
        z(view, true);
    }

    public final void z(View view, boolean z) {
        View view2;
        if (!z) {
            uf4 uf4Var = this.S0;
            if (uf4Var == null) {
                n12.T("binding");
                throw null;
            }
            iv1 iv1Var = ((AddDoHFragment) ((FragmentContainerView) uf4Var.b).getFragment()).b;
            iv1Var.getClass();
            ContextUtilsKt.m().hideSoftInputFromWindow(((MaterialAutoCompleteTextView) iv1Var.A).getWindowToken(), 0);
        }
        if (!z) {
            uf4 uf4Var2 = this.S0;
            if (uf4Var2 == null) {
                n12.T("binding");
                throw null;
            }
            view = (FragmentContainerView) uf4Var2.b;
        } else if (view == null) {
            uf4 uf4Var3 = this.S0;
            if (uf4Var3 == null) {
                n12.T("binding");
                throw null;
            }
            view = (FloatingActionButton) uf4Var3.c;
        }
        if (z) {
            uf4 uf4Var4 = this.S0;
            if (uf4Var4 == null) {
                n12.T("binding");
                throw null;
            }
            view2 = (FragmentContainerView) uf4Var4.b;
        } else {
            view2 = this.U0;
            if (view2 == null) {
                uf4 uf4Var5 = this.S0;
                if (uf4Var5 == null) {
                    n12.T("binding");
                    throw null;
                }
                view2 = (FloatingActionButton) uf4Var5.c;
            }
        }
        ti2 ti2Var = new ti2(this, z);
        ti2Var.c1 = 0;
        uf4 uf4Var6 = this.S0;
        if (uf4Var6 == null) {
            n12.T("binding");
            throw null;
        }
        ti2Var.Z0 = ((CoordinatorLayout) uf4Var6.f).getId();
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
        ti2Var.a(new it1(1, this, z));
        uf4 uf4Var7 = this.S0;
        if (uf4Var7 == null) {
            n12.T("binding");
            throw null;
        }
        ah4.a((CoordinatorLayout) uf4Var7.f, ti2Var);
        view.setVisibility(4);
        view2.setVisibility(0);
        uf4 uf4Var8 = this.S0;
        if (uf4Var8 == null) {
            n12.T("binding");
            throw null;
        }
        ((View) uf4Var8.a).setVisibility(z ? 0 : 8);
        this.W0.f(z);
    }
}
