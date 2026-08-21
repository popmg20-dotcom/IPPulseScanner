package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.o;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.fragment.ProxyGroupTabFragment$onViewCreated$1;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.loadingindicator.LoadingIndicator;
import defpackage.cb3;
import defpackage.ed4;
import defpackage.pa3;
import defpackage.rg3;
import defpackage.uf4;
import defpackage.ya3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ya3 extends o implements jv2, hf4 {
    public ql3 A;
    public final v92 A0;
    public rj2 X;
    public Map Y = h41.b;
    public String Z;
    public ed4 b;
    public ProxyGroupTabFragment$onViewCreated$1 f;
    public na3 y0;
    public pa3 z;
    public final String z0;

    public ya3() {
        String string = UUID.randomUUID().toString();
        string.getClass();
        this.z0 = string;
        this.A0 = new v92(dh3.a(db3.class), new xa3(this, 0), new xa3(this, 2), new xa3(this, 1));
    }

    @Override // defpackage.hf4
    public final boolean a(sk2 sk2Var) {
        int i = sk2Var.a;
        int i2 = 0;
        if (i == R.id.scroll_to_selected) {
            pa3 pa3Var = this.z;
            if (pa3Var != null) {
                List list = pa3Var.d.f;
                list.getClass();
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (n12.c(((f82) it.next()).z, pa3Var.g)) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    ed4 ed4Var = this.b;
                    ed4Var.getClass();
                    ((RecyclerView) ed4Var.A).o0(i2);
                    return true;
                }
            }
        } else {
            if (i != R.id.change_column_size) {
                return false;
            }
            int iOrdinal = t23.m().ordinal();
            if (iOrdinal == 0) {
                l(v70.f);
            } else if (iOrdinal == 1) {
                l(v70.z);
            } else {
                if (iOrdinal != 2) {
                    g.d();
                    return false;
                }
                l(v70.b);
            }
            if (!t23.d("proxy_list_zoom_hint_displayed", false)) {
                p95.C(R.string.proxy_list_zoom_gesture_hint, new Object[0]);
                SharedPreferences.Editor editorEdit = t23.l().edit();
                editorEdit.putBoolean("proxy_list_zoom_hint_displayed", true);
                editorEdit.apply();
            }
        }
        return true;
    }

    @Override // defpackage.jv2
    public final void c() {
        ed4 ed4Var = this.b;
        if (ed4Var == null) {
            return;
        }
        ((RecyclerView) ed4Var.A).o0(0);
    }

    public final void j(mb3 mb3Var) {
        pa3 pa3Var = this.z;
        if (pa3Var != null) {
            wa3 wa3Var = new wa3(this, 0);
            pa3Var.j = mb3Var;
            List list = pa3Var.d.f;
            list.getClass();
            pa3Var.s(new ArrayList(list), wa3Var);
        }
    }

    public final void k() {
        int iE;
        ed4 ed4Var = this.b;
        ed4Var.getClass();
        if (((RecyclerView) ed4Var.A).getWidth() == 0) {
            return;
        }
        ed4 ed4Var2 = this.b;
        ed4Var2.getClass();
        int width = ((RecyclerView) ed4Var2.A).getWidth();
        int iOrdinal = t23.m().ordinal();
        if (iOrdinal == 0) {
            iE = ContextUtilsKt.e(R.dimen.proxy_grid_width_small);
        } else if (iOrdinal == 1) {
            iE = ContextUtilsKt.e(R.dimen.proxy_grid_width_medium);
        } else {
            if (iOrdinal != 2) {
                g.d();
                return;
            }
            iE = ContextUtilsKt.e(R.dimen.proxy_grid_width_large);
        }
        int i = width / iE;
        int i2 = i >= 1 ? i : 1;
        ed4 ed4Var3 = this.b;
        ed4Var3.getClass();
        ah4.a((RecyclerView) ed4Var3.A, null);
        ProxyGroupTabFragment$onViewCreated$1 proxyGroupTabFragment$onViewCreated$1 = this.f;
        if (proxyGroupTabFragment$onViewCreated$1 != null) {
            proxyGroupTabFragment$onViewCreated$1.y1(i2);
        } else {
            n12.T("layoutManager");
            throw null;
        }
    }

    public final void l(v70 v70Var) {
        SharedPreferences.Editor editorEdit = t23.l().edit();
        editorEdit.putInt("proxy_column_size", v70Var.ordinal());
        editorEdit.apply();
        ((on2) ((db3) this.A0.getValue()).b.getValue()).l(v70Var);
    }

    @Override // androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("profile_name") : null;
        if (string == null) {
            xe.k("Profile name not found");
            return;
        }
        this.Z = string;
        Bundle arguments2 = getArguments();
        na3 na3Var = arguments2 != null ? (na3) ek0.o(arguments2, "group", na3.class) : null;
        if (na3Var != null) {
            this.y0 = na3Var;
        } else {
            xe.k("ProxyGroup not found");
        }
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_proxygroup_tab, viewGroup, false);
        int i = R.id.loading;
        LoadingIndicator loadingIndicator = (LoadingIndicator) vf2.l(viewInflate, R.id.loading);
        if (loadingIndicator != null) {
            i = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) vf2.l(viewInflate, R.id.recycler_view);
            if (recyclerView != null) {
                FrameLayout frameLayout = (FrameLayout) viewInflate;
                this.b = new ed4(21, frameLayout, loadingIndicator, recyclerView);
                frameLayout.getClass();
                return frameLayout;
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        b04.b.remove(this);
        this.b = null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.getsurfboard.ui.fragment.ProxyGroupTabFragment$onViewCreated$1] */
    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        final o parentFragment = getParentFragment();
        final Context context = view.getContext();
        this.f = new GridLayoutManager(context) { // from class: com.getsurfboard.ui.fragment.ProxyGroupTabFragment$onViewCreated$1
            @Override // defpackage.ag3
            public final View c0(View view2, int i) {
                view2.getClass();
                ya3 ya3Var = this.R;
                ed4 ed4Var = ya3Var.b;
                ed4Var.getClass();
                if (((RecyclerView) ed4Var.A).indexOfChild(view2) == -1) {
                    return null;
                }
                boolean z = view2.getLayoutDirection() == 1;
                ya3Var.b.getClass();
                Object parent = view2.getParent();
                parent.getClass();
                rg3 rg3VarO = RecyclerView.O((View) parent);
                int iB = rg3VarO != null ? rg3VarO.b() : -1;
                pa3 pa3Var = ya3Var.z;
                if (pa3Var == null || iB == -1 || iB != pa3Var.b() - 1) {
                    return null;
                }
                if (i != 130 && ((!z || i != 17) && (z || i != 66))) {
                    return null;
                }
                o oVar = parentFragment;
                if (!(oVar instanceof cb3)) {
                    return null;
                }
                uf4 uf4Var = ((cb3) oVar).b;
                uf4Var.getClass();
                return (FloatingActionButton) uf4Var.e;
            }
        };
        ed4 ed4Var = this.b;
        ed4Var.getClass();
        RecyclerView recyclerView = (RecyclerView) ed4Var.A;
        ProxyGroupTabFragment$onViewCreated$1 proxyGroupTabFragment$onViewCreated$1 = this.f;
        if (proxyGroupTabFragment$onViewCreated$1 == null) {
            n12.T("layoutManager");
            throw null;
        }
        recyclerView.setLayoutManager(proxyGroupTabFragment$onViewCreated$1);
        ed4 ed4Var2 = this.b;
        ed4Var2.getClass();
        ((RecyclerView) ed4Var2.A).addOnLayoutChangeListener(new r10(4, this));
        ed4 ed4Var3 = this.b;
        ed4Var3.getClass();
        RecyclerView recyclerView2 = (RecyclerView) ed4Var3.A;
        ed4 ed4Var4 = this.b;
        ed4Var4.getClass();
        recyclerView2.K0.add(new nv2((RecyclerView) ed4Var4.A, new va3(this, 0)));
        ((on2) ((db3) this.A0.getValue()).b.getValue()).e(getViewLifecycleOwner(), new yh0(4, new va3(this, 1)));
        d73.c.e(getViewLifecycleOwner(), new yh0(4, new va3(this, 2)));
        b04.b.add(this);
        ed4 ed4Var5 = this.b;
        ed4Var5.getClass();
        FrameLayout frameLayout = (FrameLayout) ed4Var5.f;
        o73 o73Var = new o73(3, this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(frameLayout, o73Var);
    }
}
