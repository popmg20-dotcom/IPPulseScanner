package com.getsurfboard.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.TrafficListActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.divider.MaterialDivider;
import defpackage.bx0;
import defpackage.ca;
import defpackage.cd;
import defpackage.cg4;
import defpackage.d70;
import defpackage.dg4;
import defpackage.e1;
import defpackage.f0;
import defpackage.g;
import defpackage.g41;
import defpackage.ga1;
import defpackage.hf4;
import defpackage.l72;
import defpackage.lw0;
import defpackage.mk;
import defpackage.mp4;
import defpackage.n12;
import defpackage.o73;
import defpackage.sk2;
import defpackage.v9;
import defpackage.v92;
import defpackage.vf2;
import defpackage.wp4;
import defpackage.x3;
import defpackage.z71;
import defpackage.zo2;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class TrafficListActivity extends ca implements hf4 {
    public static final /* synthetic */ int V0 = 0;
    public v92 S0;
    public cg4 T0 = cg4.b;
    public final bx0 U0 = new bx0(new cd(9, this));

    @Override // defpackage.hf4
    public final boolean a(sk2 sk2Var) {
        ga1 ga1Var = new ga1(26, this);
        Integer numValueOf = Integer.valueOf(sk2Var.a);
        if (numValueOf.intValue() == R.id.sort_by_speed) {
            this.T0 = cg4.b;
        } else if (numValueOf.intValue() == R.id.sort_by_traffic) {
            this.T0 = cg4.f;
        }
        sk2Var.setChecked(true);
        List list = (List) dg4.q.d();
        if (list == null) {
            list = g41.b;
        }
        x(list, ga1Var);
        return true;
    }

    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        Intent intent = getIntent();
        intent.getClass();
        String stringExtra = intent.getStringExtra("sort_mode");
        if (stringExtra != null) {
            this.T0 = cg4.valueOf(stringExtra);
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_traffic_list, (ViewGroup) null, false);
        int i = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i = R.id.empty;
            TextView textView = (TextView) vf2.l(viewInflate, R.id.empty);
            if (textView != null) {
                i = R.id.list;
                RecyclerView recyclerView = (RecyclerView) vf2.l(viewInflate, R.id.list);
                if (recyclerView != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                    if (toolbar != null) {
                        i = R.id.toolbar_divider;
                        MaterialDivider materialDivider = (MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider);
                        if (materialDivider != null) {
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                            this.S0 = new v92(coordinatorLayout, textView, recyclerView, toolbar, materialDivider);
                            setContentView(coordinatorLayout);
                            v92 v92Var = this.S0;
                            if (v92Var == null) {
                                n12.T("binding");
                                throw null;
                            }
                            CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) v92Var.b;
                            o73 o73Var = new o73(12, this);
                            WeakHashMap weakHashMap = wp4.a;
                            mp4.c(coordinatorLayout2, o73Var);
                            v92 v92Var2 = this.S0;
                            if (v92Var2 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((RecyclerView) v92Var2.z).j(new z71(5, this));
                            v92 v92Var3 = this.S0;
                            if (v92Var3 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((Toolbar) v92Var3.A).setNavigationOnClickListener(new mk(25, this));
                            v92 v92Var4 = this.S0;
                            if (v92Var4 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((Toolbar) v92Var4.A).o(R.menu.traffic_list);
                            int iOrdinal = this.T0.ordinal();
                            if (iOrdinal == 0) {
                                v92 v92Var5 = this.S0;
                                if (v92Var5 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                MenuItem menuItemFindItem = ((Toolbar) v92Var5.A).getMenu().findItem(R.id.sort_by_speed);
                                if (menuItemFindItem != null) {
                                    menuItemFindItem.setChecked(true);
                                }
                            } else {
                                if (iOrdinal != 1) {
                                    g.d();
                                    return;
                                }
                                v92 v92Var6 = this.S0;
                                if (v92Var6 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                MenuItem menuItemFindItem2 = ((Toolbar) v92Var6.A).getMenu().findItem(R.id.sort_by_traffic);
                                if (menuItemFindItem2 != null) {
                                    menuItemFindItem2.setChecked(true);
                                }
                            }
                            v92 v92Var7 = this.S0;
                            if (v92Var7 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((Toolbar) v92Var7.A).setOnMenuItemClickListener(this);
                            v92 v92Var8 = this.S0;
                            if (v92Var8 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((RecyclerView) v92Var8.z).i(new lw0(this));
                            v92 v92Var9 = this.S0;
                            if (v92Var9 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((RecyclerView) v92Var9.z).setItemAnimator(null);
                            v92 v92Var10 = this.S0;
                            if (v92Var10 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((RecyclerView) v92Var10.z).setAdapter(this.U0);
                            dg4.q.e(this, new x3(11, new f0(28, this)));
                            return;
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.i90, android.app.Activity
    public final void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("sort_mode");
        if (stringExtra != null) {
            this.T0 = cg4.valueOf(stringExtra);
        }
    }

    public final void x(List list, final ga1 ga1Var) {
        List listU0;
        v92 v92Var = this.S0;
        if (v92Var == null) {
            n12.T("binding");
            throw null;
        }
        ((TextView) v92Var.f).setVisibility(list.isEmpty() ? 0 : 8);
        v92 v92Var2 = this.S0;
        if (v92Var2 == null) {
            n12.T("binding");
            throw null;
        }
        final boolean z = ((RecyclerView) v92Var2.z).computeVerticalScrollOffset() == 0;
        int iOrdinal = this.T0.ordinal();
        if (iOrdinal == 0) {
            listU0 = d70.u0(list, new e1(25));
        } else {
            if (iOrdinal != 1) {
                g.d();
                return;
            }
            listU0 = d70.u0(list, new e1(26));
        }
        this.U0.s(listU0, new Runnable() { // from class: ag4
            @Override // java.lang.Runnable
            public final void run() {
                if (z) {
                    v92 v92Var3 = this.S0;
                    if (v92Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((RecyclerView) v92Var3.z).l0(0);
                } else {
                    int i = TrafficListActivity.V0;
                }
                Runnable runnable = ga1Var;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }
}
