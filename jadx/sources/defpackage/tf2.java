package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.a;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import com.getsurfboard.R;
import com.google.android.material.navigation.NavigationView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tf2 extends o implements sp2, rp2, qq2 {
    public d83 A;
    public cb3 X;
    public nf4 Y;
    public ed4 b;
    public int f = R.id.navigation_dashboard;
    public xh0 z;

    public static boolean k(xw2 xw2Var, t53 t53Var) {
        if (t53Var == null) {
            return false;
        }
        int i = xw2Var == null ? -1 : sf2.a[xw2Var.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            if (i != 3) {
                return false;
            }
            LinkedHashMap linkedHashMap = t53Var.H0;
            if (linkedHashMap.isEmpty()) {
                return false;
            }
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                if (!((na3) ((Map.Entry) it.next()).getValue()).T()) {
                }
            }
            return false;
        }
        if (t53Var.I0.f.isEmpty()) {
            return false;
        }
        return true;
    }

    public final boolean j(MenuItem menuItem) {
        xb5.c("main bottom navigation selected: " + ((Object) menuItem.getTitle()));
        int itemId = menuItem.getItemId();
        String str = itemId == R.id.navigation_dashboard ? "dashboard" : itemId == R.id.navigation_proxygroups ? "proxies" : itemId == R.id.navigation_profiles ? "profiles" : itemId == R.id.navigation_tools ? "tools" : "unknown";
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        e7.a(bundle, "switch_tab");
        if (getChildFragmentManager().Q()) {
            return false;
        }
        o[] oVarArr = {this.z, this.X, this.A, this.Y};
        LinkedHashSet<o> linkedHashSet = new LinkedHashSet(fh2.U(4));
        qe.r0(oVarArr, linkedHashSet);
        int itemId2 = menuItem.getItemId();
        o oVar = itemId2 == R.id.navigation_dashboard ? this.z : itemId2 == R.id.navigation_proxygroups ? this.X : itemId2 == R.id.navigation_profiles ? this.A : itemId2 == R.id.navigation_tools ? this.Y : null;
        if (oVar == null) {
            zo2.m(menuItem.getTitle(), "can not find fragment for ");
            return false;
        }
        linkedHashSet.remove(oVar);
        u childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        a aVar = new a(childFragmentManager);
        for (o oVar2 : linkedHashSet) {
            if (oVar2 != null) {
                aVar.i(oVar2);
            }
        }
        aVar.o(oVar);
        aVar.f = 4099;
        aVar.l(false, new xy0(8, this, menuItem));
        aVar.e();
        return true;
    }

    public final void l(int i) {
        Menu menu;
        MenuItem menuItemFindItem;
        MenuItem checkedItem;
        ed4 ed4Var = this.b;
        if (ed4Var == null) {
            return;
        }
        up2 up2Var = (up2) ed4Var.z;
        NavigationView navigationView = (NavigationView) ed4Var.A;
        if ((up2Var == null || up2Var.getSelectedItemId() != i) && up2Var != null) {
            up2Var.setSelectedItemId(i);
        }
        if (navigationView == null || (checkedItem = navigationView.getCheckedItem()) == null || checkedItem.getItemId() != i) {
            if (navigationView != null) {
                navigationView.setCheckedItem(i);
            }
            if (navigationView == null || (menu = navigationView.getMenu()) == null || (menuItemFindItem = menu.findItem(i)) == null) {
                return;
            }
            j(menuItemFindItem);
        }
    }

    public final void m() {
        Menu menu;
        MenuItem menuItemFindItem;
        Menu menu2;
        MenuItem menuItemFindItem2;
        xw2 xw2Var = (xw2) t23.d.d();
        t53 t53Var = (t53) d73.c.d();
        ed4 ed4Var = this.b;
        ed4Var.getClass();
        up2 up2Var = (up2) ed4Var.z;
        if (up2Var != null && (menu2 = up2Var.getMenu()) != null && (menuItemFindItem2 = menu2.findItem(R.id.navigation_proxygroups)) != null) {
            menuItemFindItem2.setVisible(k(xw2Var, t53Var));
        }
        ed4 ed4Var2 = this.b;
        ed4Var2.getClass();
        NavigationView navigationView = (NavigationView) ed4Var2.A;
        if (navigationView == null || (menu = navigationView.getMenu()) == null || (menuItemFindItem = menu.findItem(R.id.navigation_proxygroups)) == null) {
            return;
        }
        menuItemFindItem.setVisible(k(xw2Var, t53Var));
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = getLayoutInflater().inflate(R.layout.fragment_main, (ViewGroup) null, false);
        if (((FragmentContainerView) vf2.l(viewInflate, R.id.container)) == null) {
            zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.container)));
            return null;
        }
        up2 up2Var = (up2) vf2.l(viewInflate, R.id.navigation);
        NavigationView navigationView = (NavigationView) vf2.l(viewInflate, R.id.slide_navigation);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
        this.b = new ed4(20, constraintLayout, up2Var, navigationView);
        constraintLayout.getClass();
        return constraintLayout;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        bundle.putInt("active_fragment_id", this.f);
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        if (bundle != null) {
            this.z = (xh0) getChildFragmentManager().D("dashboard");
            this.A = (d83) getChildFragmentManager().D("profiles");
            this.X = (cb3) getChildFragmentManager().D("proxy_groups");
            this.Y = (nf4) getChildFragmentManager().D("tools");
        }
        if (this.z == null) {
            this.z = new xh0();
        }
        if (this.A == null) {
            this.A = new d83();
        }
        if (this.X == null) {
            this.X = new cb3();
        }
        if (this.Y == null) {
            this.Y = new nf4();
        }
        final int i = 0;
        final int i2 = 1;
        if (bundle != null) {
            this.f = bundle.getInt("active_fragment_id");
        } else {
            u childFragmentManager = getChildFragmentManager();
            childFragmentManager.getClass();
            a aVar = new a(childFragmentManager);
            cb3 cb3Var = this.X;
            cb3Var.getClass();
            aVar.g(R.id.container, cb3Var, "proxy_groups", 1);
            cb3 cb3Var2 = this.X;
            cb3Var2.getClass();
            aVar.i(cb3Var2);
            d83 d83Var = this.A;
            d83Var.getClass();
            aVar.g(R.id.container, d83Var, "profiles", 1);
            d83 d83Var2 = this.A;
            d83Var2.getClass();
            aVar.i(d83Var2);
            nf4 nf4Var = this.Y;
            nf4Var.getClass();
            aVar.g(R.id.container, nf4Var, "tools", 1);
            nf4 nf4Var2 = this.Y;
            nf4Var2.getClass();
            aVar.i(nf4Var2);
            xh0 xh0Var = this.z;
            xh0Var.getClass();
            aVar.g(R.id.container, xh0Var, "dashboard", 1);
            if (aVar.g) {
                xe.q("This transaction is already being added to the back stack");
                return;
            } else {
                aVar.h = false;
                aVar.r.A(aVar, false);
                this.f = R.id.navigation_dashboard;
            }
        }
        ed4 ed4Var = this.b;
        ed4Var.getClass();
        up2 up2Var = (up2) ed4Var.z;
        if (up2Var != null) {
            up2Var.setOnItemSelectedListener(this);
        }
        ed4 ed4Var2 = this.b;
        ed4Var2.getClass();
        up2 up2Var2 = (up2) ed4Var2.z;
        if (up2Var2 != null) {
            up2Var2.setOnItemReselectedListener(this);
        }
        ed4 ed4Var3 = this.b;
        ed4Var3.getClass();
        NavigationView navigationView = (NavigationView) ed4Var3.A;
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
        ed4 ed4Var4 = this.b;
        ed4Var4.getClass();
        up2 up2Var3 = (up2) ed4Var4.z;
        if (up2Var3 != null) {
            up2Var3.setSelectedItemId(this.f);
        }
        ed4 ed4Var5 = this.b;
        ed4Var5.getClass();
        NavigationView navigationView2 = (NavigationView) ed4Var5.A;
        if (navigationView2 != null) {
            navigationView2.setCheckedItem(this.f);
        }
        t23.d.e(getViewLifecycleOwner(), new yh0(2, new am1(this) { // from class: rf2
            public final /* synthetic */ tf2 f;

            {
                this.f = this;
            }

            @Override // defpackage.am1
            public final Object g(Object obj) {
                int i3 = i;
                xl4 xl4Var = xl4.a;
                tf2 tf2Var = this.f;
                switch (i3) {
                    case 0:
                        tf2Var.m();
                        break;
                    default:
                        tf2Var.m();
                        break;
                }
                return xl4Var;
            }
        }));
        d73.c.e(getViewLifecycleOwner(), new yh0(2, new am1(this) { // from class: rf2
            public final /* synthetic */ tf2 f;

            {
                this.f = this;
            }

            @Override // defpackage.am1
            public final Object g(Object obj) {
                int i3 = i2;
                xl4 xl4Var = xl4.a;
                tf2 tf2Var = this.f;
                switch (i3) {
                    case 0:
                        tf2Var.m();
                        break;
                    default:
                        tf2Var.m();
                        break;
                }
                return xl4Var;
            }
        }));
        ed4 ed4Var6 = this.b;
        ed4Var6.getClass();
        ConstraintLayout constraintLayout = (ConstraintLayout) ed4Var6.f;
        jd jdVar = new jd(21, this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(constraintLayout, jdVar);
    }
}
