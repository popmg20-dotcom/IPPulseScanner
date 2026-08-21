package com.getsurfboard.ui.activity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.loadingindicator.LoadingIndicator;
import defpackage.ca;
import defpackage.cm2;
import defpackage.cr3;
import defpackage.dh3;
import defpackage.f0;
import defpackage.ff3;
import defpackage.g10;
import defpackage.g23;
import defpackage.ge0;
import defpackage.gt1;
import defpackage.if3;
import defpackage.j80;
import defpackage.ji0;
import defpackage.l72;
import defpackage.lw0;
import defpackage.m24;
import defpackage.mf3;
import defpackage.mp4;
import defpackage.mt;
import defpackage.n12;
import defpackage.oj3;
import defpackage.pj3;
import defpackage.qi;
import defpackage.rf;
import defpackage.uf2;
import defpackage.uk0;
import defpackage.v62;
import defpackage.v9;
import defpackage.v92;
import defpackage.vf;
import defpackage.vf2;
import defpackage.wp4;
import defpackage.wu2;
import defpackage.z71;
import defpackage.zo2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class RecentRequestsActivity extends ca implements cr3 {
    public static final /* synthetic */ int X0 = 0;
    public j80 S0;
    public SearchView T0;
    public final v92 U0 = new v92(dh3.a(pj3.class), new if3(this, 1), new if3(this, 0), new if3(this, 2));
    public final mf3 V0;
    public boolean W0;

    public RecentRequestsActivity() {
        mf3 mf3Var = new mf3(this);
        qi qiVar = new qi(7, this, mf3Var);
        vf vfVar = mf3Var.e;
        vfVar.getClass();
        rf rfVar = vfVar.f;
        rfVar.getClass();
        ((CopyOnWriteArrayList) rfVar.f.f).add(qiVar);
        this.V0 = mf3Var;
    }

    @Override // defpackage.cr3
    public final boolean e(String str) {
        str.getClass();
        if (str.length() > 0) {
            j80 j80Var = this.S0;
            if (j80Var == null) {
                n12.T("binding");
                throw null;
            }
            ((LoadingIndicator) j80Var.d).setVisibility(0);
        }
        m24 m24Var = y().b;
        oj3 oj3VarA = oj3.a((oj3) y().b.i(), str, null, null, null, 14);
        m24Var.getClass();
        m24Var.j(null, oj3VarA);
        return false;
    }

    @Override // defpackage.cr3
    public final boolean i(String str) {
        str.getClass();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        MenuItem menuItemFindItem;
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        ge0 ge0Var = null;
        final int i = 0;
        Object[] objArr = 0;
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_recent_requests, (ViewGroup) null, false);
        int i2 = R.id.app_info;
        Chip chip = (Chip) vf2.l(viewInflate, R.id.app_info);
        if (chip != null) {
            i2 = R.id.appbar;
            if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
                i2 = R.id.group;
                if (((HorizontalScrollView) vf2.l(viewInflate, R.id.group)) != null) {
                    i2 = R.id.list;
                    RecyclerView recyclerView = (RecyclerView) vf2.l(viewInflate, R.id.list);
                    if (recyclerView != null) {
                        i2 = R.id.loading;
                        LoadingIndicator loadingIndicator = (LoadingIndicator) vf2.l(viewInflate, R.id.loading);
                        if (loadingIndicator != null) {
                            i2 = R.id.proxy;
                            Chip chip2 = (Chip) vf2.l(viewInflate, R.id.proxy);
                            if (chip2 != null) {
                                i2 = R.id.rule;
                                Chip chip3 = (Chip) vf2.l(viewInflate, R.id.rule);
                                if (chip3 != null) {
                                    i2 = R.id.toolbar;
                                    Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                                    if (toolbar != null) {
                                        i2 = R.id.toolbar_divider;
                                        MaterialDivider materialDivider = (MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider);
                                        if (materialDivider != null) {
                                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                                            this.S0 = new j80(coordinatorLayout, chip, recyclerView, loadingIndicator, chip2, chip3, toolbar, materialDivider);
                                            setContentView(coordinatorLayout);
                                            j80 j80Var = this.S0;
                                            if (j80Var == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) j80Var.a;
                                            ff3 ff3Var = new ff3(this);
                                            WeakHashMap weakHashMap = wp4.a;
                                            mp4.c(coordinatorLayout2, ff3Var);
                                            j80 j80Var2 = this.S0;
                                            if (j80Var2 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            ((Toolbar) j80Var2.g).setNavigationOnClickListener(new View.OnClickListener(this) { // from class: gf3
                                                public final /* synthetic */ RecentRequestsActivity f;

                                                {
                                                    this.f = this;
                                                }

                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    int i3 = i;
                                                    RecentRequestsActivity recentRequestsActivity = this.f;
                                                    switch (i3) {
                                                        case 0:
                                                            int i4 = RecentRequestsActivity.X0;
                                                            recentRequestsActivity.b().d();
                                                            return;
                                                        case 1:
                                                            int i5 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var3 = recentRequestsActivity.S0;
                                                            if (j80Var3 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var3.d).setVisibility(0);
                                                            m24 m24Var = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 13);
                                                            m24Var.getClass();
                                                            m24Var.j(null, oj3VarA);
                                                            return;
                                                        case 2:
                                                            int i6 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var4 = recentRequestsActivity.S0;
                                                            if (j80Var4 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var4.d).setVisibility(0);
                                                            m24 m24Var2 = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA2 = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 11);
                                                            m24Var2.getClass();
                                                            m24Var2.j(null, oj3VarA2);
                                                            return;
                                                        default:
                                                            int i7 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var5 = recentRequestsActivity.S0;
                                                            if (j80Var5 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var5.d).setVisibility(0);
                                                            m24 m24Var3 = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA3 = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 7);
                                                            m24Var3.getClass();
                                                            m24Var3.j(null, oj3VarA3);
                                                            return;
                                                    }
                                                }
                                            });
                                            j80 j80Var3 = this.S0;
                                            if (j80Var3 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            ((Toolbar) j80Var3.g).getMenu().clear();
                                            j80 j80Var4 = this.S0;
                                            if (j80Var4 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            ((Toolbar) j80Var4.g).o(R.menu.recent_requests);
                                            j80 j80Var5 = this.S0;
                                            if (j80Var5 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            Menu menu = ((Toolbar) j80Var5.g).getMenu();
                                            if (menu != null && (menuItemFindItem = menu.findItem(R.id.search)) != null) {
                                                View actionView = menuItemFindItem.getActionView();
                                                actionView.getClass();
                                                SearchView searchView = (SearchView) actionView;
                                                this.T0 = searchView;
                                                searchView.setOnCloseListener(new ff3(this));
                                                SearchView searchView2 = this.T0;
                                                if (searchView2 != null) {
                                                    searchView2.setOnQueryTextListener(this);
                                                }
                                            }
                                            wu2 wu2VarB = b();
                                            wu2VarB.getClass();
                                            final int i3 = 2;
                                            wu2VarB.b(new gt1(i3, new f0(20, this), objArr == true ? 1 : 0));
                                            j80 j80Var6 = this.S0;
                                            if (j80Var6 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            ((RecyclerView) j80Var6.c).i(new lw0(this));
                                            j80 j80Var7 = this.S0;
                                            if (j80Var7 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            cm2 cm2Var = new cm2((RecyclerView) j80Var7.c);
                                            cm2Var.C();
                                            cm2Var.z = new g23() { // from class: hf3
                                                @Override // defpackage.g23
                                                public final String a(View view, int i4) {
                                                    int i5 = RecentRequestsActivity.X0;
                                                    RecentRequestsActivity recentRequestsActivity = this.a;
                                                    vf vfVar = recentRequestsActivity.V0.e;
                                                    ez2 ez2Var = (ez2) vfVar.e.get();
                                                    zi3 zi3Var = (zi3) (ez2Var != null ? l72.n(ez2Var, i4) : vfVar.f.d.b(i4));
                                                    return zi3Var == null ? recentRequestsActivity.getString(R.string.loading) : new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()).format(new Date(zi3Var.b));
                                                }
                                            };
                                            cm2Var.Y = new g10(8);
                                            j80 j80Var8 = this.S0;
                                            if (j80Var8 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            cm2Var.Z = new v62(20, new uk0((RecyclerView) j80Var8.c), this, false);
                                            cm2Var.d();
                                            j80 j80Var9 = this.S0;
                                            if (j80Var9 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            ((RecyclerView) j80Var9.c).setAdapter(this.V0);
                                            String stringExtra = getIntent().getStringExtra("package_name");
                                            if (stringExtra != null) {
                                                x(stringExtra);
                                            }
                                            j80 j80Var10 = this.S0;
                                            if (j80Var10 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            final int i4 = 1;
                                            ((Chip) j80Var10.b).setOnClickListener(new View.OnClickListener(this) { // from class: gf3
                                                public final /* synthetic */ RecentRequestsActivity f;

                                                {
                                                    this.f = this;
                                                }

                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    int i32 = i4;
                                                    RecentRequestsActivity recentRequestsActivity = this.f;
                                                    switch (i32) {
                                                        case 0:
                                                            int i42 = RecentRequestsActivity.X0;
                                                            recentRequestsActivity.b().d();
                                                            return;
                                                        case 1:
                                                            int i5 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var32 = recentRequestsActivity.S0;
                                                            if (j80Var32 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var32.d).setVisibility(0);
                                                            m24 m24Var = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 13);
                                                            m24Var.getClass();
                                                            m24Var.j(null, oj3VarA);
                                                            return;
                                                        case 2:
                                                            int i6 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var42 = recentRequestsActivity.S0;
                                                            if (j80Var42 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var42.d).setVisibility(0);
                                                            m24 m24Var2 = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA2 = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 11);
                                                            m24Var2.getClass();
                                                            m24Var2.j(null, oj3VarA2);
                                                            return;
                                                        default:
                                                            int i7 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var52 = recentRequestsActivity.S0;
                                                            if (j80Var52 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var52.d).setVisibility(0);
                                                            m24 m24Var3 = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA3 = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 7);
                                                            m24Var3.getClass();
                                                            m24Var3.j(null, oj3VarA3);
                                                            return;
                                                    }
                                                }
                                            });
                                            j80 j80Var11 = this.S0;
                                            if (j80Var11 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            ((Chip) j80Var11.e).setOnClickListener(new View.OnClickListener(this) { // from class: gf3
                                                public final /* synthetic */ RecentRequestsActivity f;

                                                {
                                                    this.f = this;
                                                }

                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    int i32 = i3;
                                                    RecentRequestsActivity recentRequestsActivity = this.f;
                                                    switch (i32) {
                                                        case 0:
                                                            int i42 = RecentRequestsActivity.X0;
                                                            recentRequestsActivity.b().d();
                                                            return;
                                                        case 1:
                                                            int i5 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var32 = recentRequestsActivity.S0;
                                                            if (j80Var32 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var32.d).setVisibility(0);
                                                            m24 m24Var = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 13);
                                                            m24Var.getClass();
                                                            m24Var.j(null, oj3VarA);
                                                            return;
                                                        case 2:
                                                            int i6 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var42 = recentRequestsActivity.S0;
                                                            if (j80Var42 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var42.d).setVisibility(0);
                                                            m24 m24Var2 = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA2 = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 11);
                                                            m24Var2.getClass();
                                                            m24Var2.j(null, oj3VarA2);
                                                            return;
                                                        default:
                                                            int i7 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var52 = recentRequestsActivity.S0;
                                                            if (j80Var52 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var52.d).setVisibility(0);
                                                            m24 m24Var3 = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA3 = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 7);
                                                            m24Var3.getClass();
                                                            m24Var3.j(null, oj3VarA3);
                                                            return;
                                                    }
                                                }
                                            });
                                            j80 j80Var12 = this.S0;
                                            if (j80Var12 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            final int i5 = 3;
                                            ((Chip) j80Var12.f).setOnClickListener(new View.OnClickListener(this) { // from class: gf3
                                                public final /* synthetic */ RecentRequestsActivity f;

                                                {
                                                    this.f = this;
                                                }

                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    int i32 = i5;
                                                    RecentRequestsActivity recentRequestsActivity = this.f;
                                                    switch (i32) {
                                                        case 0:
                                                            int i42 = RecentRequestsActivity.X0;
                                                            recentRequestsActivity.b().d();
                                                            return;
                                                        case 1:
                                                            int i52 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var32 = recentRequestsActivity.S0;
                                                            if (j80Var32 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var32.d).setVisibility(0);
                                                            m24 m24Var = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 13);
                                                            m24Var.getClass();
                                                            m24Var.j(null, oj3VarA);
                                                            return;
                                                        case 2:
                                                            int i6 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var42 = recentRequestsActivity.S0;
                                                            if (j80Var42 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var42.d).setVisibility(0);
                                                            m24 m24Var2 = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA2 = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 11);
                                                            m24Var2.getClass();
                                                            m24Var2.j(null, oj3VarA2);
                                                            return;
                                                        default:
                                                            int i7 = RecentRequestsActivity.X0;
                                                            view.getClass();
                                                            view.setVisibility(8);
                                                            j80 j80Var52 = recentRequestsActivity.S0;
                                                            if (j80Var52 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((LoadingIndicator) j80Var52.d).setVisibility(0);
                                                            m24 m24Var3 = recentRequestsActivity.y().b;
                                                            oj3 oj3VarA3 = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, null, null, 7);
                                                            m24Var3.getClass();
                                                            m24Var3.j(null, oj3VarA3);
                                                            return;
                                                    }
                                                }
                                            });
                                            ji0.B(uf2.t(this), null, null, new mt(this, ge0Var, 15), 3);
                                            j80 j80Var13 = this.S0;
                                            if (j80Var13 != null) {
                                                ((RecyclerView) j80Var13.c).j(new z71(i5, this));
                                                return;
                                            } else {
                                                n12.T("binding");
                                                throw null;
                                            }
                                        }
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

    public final void x(String str) {
        str.getClass();
        j80 j80Var = this.S0;
        if (j80Var == null) {
            n12.T("binding");
            throw null;
        }
        if (((Chip) j80Var.b).getVisibility() == 0) {
            return;
        }
        j80 j80Var2 = this.S0;
        if (j80Var2 == null) {
            n12.T("binding");
            throw null;
        }
        ((Chip) j80Var2.b).setVisibility(0);
        PackageInfo packageInfoG = ContextUtilsKt.g(str);
        if (packageInfoG != null) {
            ApplicationInfo applicationInfo = packageInfoG.applicationInfo;
            j80 j80Var3 = this.S0;
            if (applicationInfo != null) {
                if (j80Var3 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((Chip) j80Var3.b).setText(getPackageManager().getApplicationLabel(applicationInfo));
            } else {
                if (j80Var3 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((Chip) j80Var3.b).setText(str);
            }
        } else {
            j80 j80Var4 = this.S0;
            if (j80Var4 == null) {
                n12.T("binding");
                throw null;
            }
            ((Chip) j80Var4.b).setText(str);
        }
        j80 j80Var5 = this.S0;
        if (j80Var5 == null) {
            n12.T("binding");
            throw null;
        }
        ((LoadingIndicator) j80Var5.d).setVisibility(0);
        m24 m24Var = y().b;
        oj3 oj3VarA = oj3.a((oj3) y().b.i(), null, str, null, null, 13);
        m24Var.getClass();
        m24Var.j(null, oj3VarA);
    }

    public final pj3 y() {
        return (pj3) this.U0.getValue();
    }
}
