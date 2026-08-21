package com.getsurfboard.ui.activity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.textview.MaterialTextView;
import defpackage.bt;
import defpackage.ca;
import defpackage.cd;
import defpackage.cm2;
import defpackage.co4;
import defpackage.cr3;
import defpackage.d70;
import defpackage.dt;
import defpackage.e1;
import defpackage.e70;
import defpackage.et;
import defpackage.f33;
import defpackage.f70;
import defpackage.ft;
import defpackage.g;
import defpackage.ge0;
import defpackage.gt1;
import defpackage.hd;
import defpackage.hf4;
import defpackage.ji0;
import defpackage.jt;
import defpackage.l72;
import defpackage.lw0;
import defpackage.mp4;
import defpackage.mt;
import defpackage.n12;
import defpackage.nk2;
import defpackage.ot;
import defpackage.oy3;
import defpackage.p95;
import defpackage.qe;
import defpackage.r25;
import defpackage.s7;
import defpackage.sk2;
import defpackage.t23;
import defpackage.u9;
import defpackage.uf2;
import defpackage.v9;
import defpackage.vf2;
import defpackage.vs4;
import defpackage.w7;
import defpackage.wp4;
import defpackage.ws4;
import defpackage.wu2;
import defpackage.x3;
import defpackage.xs;
import defpackage.y3;
import defpackage.zo2;
import defpackage.zs;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class BypassConfigActivity extends ca implements cr3, hf4 {
    public static final /* synthetic */ int Y0 = 0;
    public y3 S0;
    public SearchView T0;
    public String U0;
    public boolean V0;
    public boolean W0;
    public final zs X0;

    public BypassConfigActivity() {
        w7 w7Var = new w7(13, this);
        String[] strArr = t23.a;
        this.X0 = new zs((ot) ot.Y.get(t23.l().getInt("bypass_list_sort_mode", 0)), w7Var);
    }

    public final void A() {
        x();
        boolean zQ = t23.q();
        y3 y3Var = this.S0;
        if (zQ) {
            if (y3Var == null) {
                n12.T("binding");
                throw null;
            }
            ((LinearLayoutCompat) y3Var.b).setVisibility(8);
            y3 y3Var2 = this.S0;
            if (y3Var2 == null) {
                n12.T("binding");
                throw null;
            }
            ((ConstraintLayout) y3Var2.i).setVisibility(0);
            y3 y3Var3 = this.S0;
            if (y3Var3 == null) {
                n12.T("binding");
                throw null;
            }
            ((ExtendedFloatingActionButton) y3Var3.k).setVisibility(0);
            C(null);
            return;
        }
        if (y3Var == null) {
            n12.T("binding");
            throw null;
        }
        ((LinearLayoutCompat) y3Var.b).setVisibility(0);
        y3 y3Var4 = this.S0;
        if (y3Var4 == null) {
            n12.T("binding");
            throw null;
        }
        ((ConstraintLayout) y3Var4.i).setVisibility(8);
        y3 y3Var5 = this.S0;
        if (y3Var5 == null) {
            n12.T("binding");
            throw null;
        }
        ((ExtendedFloatingActionButton) y3Var5.k).setVisibility(8);
        y3 y3Var6 = this.S0;
        if (y3Var6 != null) {
            ((Toolbar) y3Var6.c).setSubtitle((CharSequence) null);
        } else {
            n12.T("binding");
            throw null;
        }
    }

    public final List B(ArrayList arrayList) {
        List listU0;
        int iOrdinal = this.X0.e.ordinal();
        final int i = 0;
        final int i2 = 1;
        if (iOrdinal == 0) {
            final cd cdVar = new cd(i2, this);
            listU0 = d70.u0(arrayList, new Comparator() { // from class: ct
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int i3 = i;
                    Function2 function2 = cdVar;
                    switch (i3) {
                        case 0:
                            int i4 = BypassConfigActivity.Y0;
                            return ((Number) ((cd) function2).k(obj, obj2)).intValue();
                        default:
                            int i5 = BypassConfigActivity.Y0;
                            return ((Number) ((dt) function2).k(obj, obj2)).intValue();
                    }
                }
            });
        } else if (iOrdinal == 1) {
            listU0 = d70.u0(arrayList, new e1(3));
        } else if (iOrdinal == 2) {
            listU0 = d70.u0(arrayList, new e1(4));
        } else {
            if (iOrdinal != 3) {
                g.d();
                return null;
            }
            listU0 = d70.u0(arrayList, new e1(5));
        }
        if (this.W0) {
            listU0 = d70.s0(listU0);
        }
        final dt dtVar = new dt(0);
        return d70.u0(listU0, new Comparator() { // from class: ct
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i3 = i2;
                Function2 function2 = dtVar;
                switch (i3) {
                    case 0:
                        int i4 = BypassConfigActivity.Y0;
                        return ((Number) ((cd) function2).k(obj, obj2)).intValue();
                    default:
                        int i5 = BypassConfigActivity.Y0;
                        return ((Number) ((dt) function2).k(obj, obj2)).intValue();
                }
            }
        });
    }

    public final void C(f33 f33Var) {
        boolean zH = t23.H();
        y3 y3Var = this.S0;
        ge0 ge0Var = null;
        if (zH) {
            if (y3Var == null) {
                n12.T("binding");
                throw null;
            }
            ((MaterialTextView) y3Var.d).setText(R.string.white_list_mode_desc);
        } else {
            if (y3Var == null) {
                n12.T("binding");
                throw null;
            }
            ((MaterialTextView) y3Var.d).setText(R.string.black_list_mode_desc);
        }
        ji0.B(uf2.t(this), null, null, new hd(this, f33Var, ge0Var, 2), 3);
    }

    public final void D() {
        List list = this.X0.d.f;
        list.getClass();
        boolean z = true;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!((xs) it.next()).c) {
                    z = false;
                    break;
                }
            }
        }
        boolean zH = co4.H();
        y3 y3Var = this.S0;
        int i = R.drawable.ic_round_select_all_24;
        int i2 = R.string.select_all;
        if (zH) {
            if (y3Var == null) {
                n12.T("binding");
                throw null;
            }
            MenuItem menuItemFindItem = ((Toolbar) y3Var.c).getMenu().findItem(R.id.select_toggle);
            if (z) {
                i2 = R.string.deselect_all;
            }
            menuItemFindItem.setTitle(i2);
            y3 y3Var2 = this.S0;
            if (y3Var2 == null) {
                n12.T("binding");
                throw null;
            }
            MenuItem menuItemFindItem2 = ((Toolbar) y3Var2.c).getMenu().findItem(R.id.select_toggle);
            if (z) {
                i = R.drawable.ic_round_deselect_24;
            }
            menuItemFindItem2.setIcon(i).getClass();
            return;
        }
        if (y3Var == null) {
            n12.T("binding");
            throw null;
        }
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) y3Var.k;
        if (z) {
            i2 = R.string.deselect_all;
        }
        extendedFloatingActionButton.setText(i2);
        y3 y3Var3 = this.S0;
        if (y3Var3 == null) {
            n12.T("binding");
            throw null;
        }
        ExtendedFloatingActionButton extendedFloatingActionButton2 = (ExtendedFloatingActionButton) y3Var3.k;
        if (z) {
            i = R.drawable.ic_round_deselect_24;
        }
        extendedFloatingActionButton2.setIconResource(i);
    }

    public final void E(List list) {
        y3 y3Var = this.S0;
        if (y3Var == null) {
            n12.T("binding");
            throw null;
        }
        Toolbar toolbar = (Toolbar) y3Var.c;
        int i = 0;
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((xs) it.next()).c && (i = i + 1) < 0) {
                    e70.O();
                    throw null;
                }
            }
        }
        toolbar.setSubtitle(ContextUtilsKt.i(R.plurals.item_selected, i));
    }

    @Override // defpackage.hf4
    public final boolean a(sk2 sk2Var) throws JSONException {
        int i = sk2Var.a;
        int i2 = 0;
        if (i == R.id.disable) {
            SharedPreferences.Editor editorEdit = t23.l().edit();
            editorEdit.putBoolean("bypass_list_enabled", false);
            editorEdit.apply();
            A();
            z();
            return true;
        }
        if (i == R.id.select_toggle) {
            y();
            return true;
        }
        ge0 ge0Var = null;
        if (i != R.id.black_list_mode) {
            if (i != R.id.white_list_mode) {
                if (i == R.id.hide_system_apps) {
                    sk2Var.setChecked(!sk2Var.isChecked());
                    boolean zIsChecked = sk2Var.isChecked();
                    SharedPreferences.Editor editorEdit2 = t23.l().edit();
                    editorEdit2.putBoolean("hide_system_apps", zIsChecked);
                    editorEdit2.apply();
                    C(null);
                    return true;
                }
                if (i == R.id.hide_offline_apps) {
                    sk2Var.setChecked(!sk2Var.isChecked());
                    boolean zIsChecked2 = sk2Var.isChecked();
                    SharedPreferences.Editor editorEdit3 = t23.l().edit();
                    editorEdit3.putBoolean("hide_offline_apps", zIsChecked2);
                    editorEdit3.apply();
                    C(null);
                    return true;
                }
                if (i == R.id.hide_disabled_apps) {
                    sk2Var.setChecked(!sk2Var.isChecked());
                    boolean zIsChecked3 = sk2Var.isChecked();
                    SharedPreferences.Editor editorEdit4 = t23.l().edit();
                    editorEdit4.putBoolean("hide_disabled_apps", zIsChecked3);
                    editorEdit4.apply();
                    C(null);
                    return true;
                }
                if (i == R.id.compatible_mode) {
                    sk2Var.setChecked(!sk2Var.isChecked());
                    boolean zIsChecked4 = sk2Var.isChecked();
                    SharedPreferences.Editor editorEdit5 = t23.l().edit();
                    editorEdit5.putBoolean("bypass_list_compatible_mode", zIsChecked4);
                    editorEdit5.apply();
                    C(null);
                    return true;
                }
                zs zsVar = this.X0;
                if (i == R.id.sort_by_name) {
                    sk2Var.setChecked(!sk2Var.isChecked());
                    zsVar.getClass();
                    ot otVar = ot.b;
                    zsVar.e = otVar;
                    t23.y(otVar);
                    C(null);
                    return true;
                }
                if (i == R.id.sort_by_package_name) {
                    sk2Var.setChecked(!sk2Var.isChecked());
                    zsVar.getClass();
                    ot otVar2 = ot.f;
                    zsVar.e = otVar2;
                    t23.y(otVar2);
                    C(null);
                    return true;
                }
                if (i == R.id.sort_by_install_time) {
                    sk2Var.setChecked(!sk2Var.isChecked());
                    zsVar.getClass();
                    ot otVar3 = ot.z;
                    zsVar.e = otVar3;
                    t23.y(otVar3);
                    C(null);
                    return true;
                }
                if (i == R.id.sort_by_update_time) {
                    sk2Var.setChecked(!sk2Var.isChecked());
                    zsVar.getClass();
                    ot otVar4 = ot.A;
                    zsVar.e = otVar4;
                    t23.y(otVar4);
                    C(null);
                    return true;
                }
                if (i == R.id.reverse) {
                    sk2Var.setChecked(!sk2Var.isChecked());
                    this.W0 = sk2Var.isChecked();
                    C(null);
                    return true;
                }
                if (i != R.id.export_to_clipboard) {
                    if (i != R.id.import_from_clipboard) {
                        return false;
                    }
                    ji0.B(uf2.t(this), null, null, new mt(this, ge0Var, i2), 3);
                    return true;
                }
                String str = t23.H() ? "allowed" : "disallowed";
                List list = zsVar.d.f;
                list.getClass();
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((xs) obj).c) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(f70.Q(10, arrayList));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((xs) it.next()).a.packageName);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(RtspHeaders.Values.MODE, str);
                jSONObject.put("package_name", new JSONArray((Collection) arrayList2));
                String string = jSONObject.toString();
                string.getClass();
                co4.k(string);
                y3 y3Var = this.S0;
                if (y3Var == null) {
                    n12.T("binding");
                    throw null;
                }
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                coordinatorLayout.getClass();
                r25.R(coordinatorLayout, R.string.bypass_config_exported, new Object[0]);
                return true;
            }
            if (!sk2Var.isChecked()) {
                sk2Var.setChecked(true);
                t23.D(true);
                C(null);
            }
        } else if (!sk2Var.isChecked()) {
            sk2Var.setChecked(true);
            t23.D(false);
            C(null);
            return true;
        }
        return true;
    }

    @Override // defpackage.cr3
    public final boolean e(String str) {
        this.U0 = str;
        C(null);
        return false;
    }

    @Override // defpackage.cr3
    public final boolean i(String str) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        int i = 0;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_bypass_config, (ViewGroup) null, false);
        int i2 = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i2 = R.id.desc;
            MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.desc);
            if (materialTextView != null) {
                i2 = R.id.disable_layout;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) vf2.l(viewInflate, R.id.disable_layout);
                if (linearLayoutCompat != null) {
                    i2 = R.id.enable_compatible_mode;
                    MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.enable_compatible_mode);
                    if (materialButton != null) {
                        i2 = R.id.enable_compatible_mode_hint;
                        TextView textView = (TextView) vf2.l(viewInflate, R.id.enable_compatible_mode_hint);
                        if (textView != null) {
                            i2 = R.id.list;
                            RecyclerView recyclerView = (RecyclerView) vf2.l(viewInflate, R.id.list);
                            if (recyclerView != null) {
                                i2 = R.id.loading;
                                LoadingIndicator loadingIndicator = (LoadingIndicator) vf2.l(viewInflate, R.id.loading);
                                if (loadingIndicator != null) {
                                    i2 = R.id.main_container;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) vf2.l(viewInflate, R.id.main_container);
                                    if (constraintLayout != null) {
                                        i2 = R.id.re_enable;
                                        Button button = (Button) vf2.l(viewInflate, R.id.re_enable);
                                        if (button != null) {
                                            i2 = R.id.select_toggle;
                                            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) vf2.l(viewInflate, R.id.select_toggle);
                                            if (extendedFloatingActionButton != null) {
                                                i2 = R.id.toolbar;
                                                Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                                                if (toolbar != null) {
                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                                                    y3 y3Var = new y3(coordinatorLayout, materialTextView, linearLayoutCompat, materialButton, textView, recyclerView, loadingIndicator, constraintLayout, button, extendedFloatingActionButton, toolbar);
                                                    setContentView(coordinatorLayout);
                                                    this.S0 = y3Var;
                                                    bt btVar = new bt(this);
                                                    WeakHashMap weakHashMap = wp4.a;
                                                    mp4.c(coordinatorLayout, btVar);
                                                    y3 y3Var2 = this.S0;
                                                    if (y3Var2 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    ((Toolbar) y3Var2.c).setNavigationOnClickListener(new et(this, i));
                                                    wu2 wu2VarB = b();
                                                    wu2VarB.getClass();
                                                    int i3 = 2;
                                                    wu2VarB.b(new gt1(i3, new ft(this, objArr3 == true ? 1 : 0), objArr2 == true ? 1 : 0));
                                                    y3 y3Var3 = this.S0;
                                                    if (y3Var3 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    ((RecyclerView) y3Var3.g).i(new lw0(this));
                                                    y3 y3Var4 = this.S0;
                                                    if (y3Var4 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    ((RecyclerView) y3Var4.g).setAdapter(this.X0);
                                                    int i4 = 1;
                                                    if (!co4.H()) {
                                                        y3 y3Var5 = this.S0;
                                                        if (y3Var5 == null) {
                                                            n12.T("binding");
                                                            throw null;
                                                        }
                                                        ((RecyclerView) y3Var5.g).j(new jt(objArr == true ? 1 : 0, this));
                                                        y3 y3Var6 = this.S0;
                                                        if (y3Var6 == null) {
                                                            n12.T("binding");
                                                            throw null;
                                                        }
                                                        ((ExtendedFloatingActionButton) y3Var6.k).setOnClickListener(new et(this, i4));
                                                    }
                                                    y3 y3Var7 = this.S0;
                                                    if (y3Var7 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    ((MaterialButton) y3Var7.e).setOnClickListener(new et(this, i3));
                                                    y3 y3Var8 = this.S0;
                                                    if (y3Var8 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    cm2 cm2Var = new cm2((RecyclerView) y3Var8.g);
                                                    cm2Var.C();
                                                    cm2Var.d();
                                                    ws4.a.e(this, new x3(i3, new ft(this, i4)));
                                                    y3 y3Var9 = this.S0;
                                                    if (y3Var9 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    ((Button) y3Var9.j).setOnClickListener(new et(this, 3));
                                                    A();
                                                    return;
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
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    public final void x() {
        y3 y3Var = this.S0;
        if (y3Var == null) {
            n12.T("binding");
            throw null;
        }
        Menu menu = ((Toolbar) y3Var.c).getMenu();
        menu.clear();
        if (t23.q()) {
            y3 y3Var2 = this.S0;
            if (y3Var2 == null) {
                n12.T("binding");
                throw null;
            }
            ((Toolbar) y3Var2.c).o(R.menu.bypass_apps);
            if (menu instanceof nk2) {
                ((nk2) menu).setGroupDividerEnabled(true);
            } else if (Build.VERSION.SDK_INT >= 28) {
                u9.D(menu);
            }
            if (t23.H()) {
                menu.findItem(R.id.white_list_mode).setChecked(true);
            } else {
                menu.findItem(R.id.black_list_mode).setChecked(true);
            }
            int iOrdinal = this.X0.e.ordinal();
            if (iOrdinal == 0) {
                menu.findItem(R.id.sort_by_name).setChecked(true);
            } else if (iOrdinal == 1) {
                menu.findItem(R.id.sort_by_package_name).setChecked(true);
            } else if (iOrdinal == 2) {
                menu.findItem(R.id.sort_by_install_time).setChecked(true);
            } else {
                if (iOrdinal != 3) {
                    g.d();
                    return;
                }
                menu.findItem(R.id.sort_by_update_time).setChecked(true);
            }
            menu.findItem(R.id.reverse).setChecked(this.W0);
            menu.findItem(R.id.hide_system_apps).setChecked(t23.d("hide_system_apps", false));
            menu.findItem(R.id.hide_offline_apps).setChecked(t23.d("hide_offline_apps", true));
            menu.findItem(R.id.hide_disabled_apps).setChecked(t23.d("hide_disabled_apps", true));
            menu.findItem(R.id.compatible_mode).setChecked(t23.d("bypass_list_compatible_mode", false));
            View actionView = menu.findItem(R.id.search).getActionView();
            actionView.getClass();
            SearchView searchView = (SearchView) actionView;
            this.T0 = searchView;
            searchView.setOnCloseListener(new bt(this));
            SearchView searchView2 = this.T0;
            if (searchView2 != null) {
                searchView2.setOnQueryTextListener(this);
            }
            y3 y3Var3 = this.S0;
            if (y3Var3 != null) {
                ((Toolbar) y3Var3.c).setOnMenuItemClickListener(this);
            } else {
                n12.T("binding");
                throw null;
            }
        }
    }

    public final void y() {
        zs zsVar = this.X0;
        List list = zsVar.d.f;
        list.getClass();
        boolean z = true;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((xs) it.next()).c) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        List<xs> list2 = zsVar.d.f;
        list2.getClass();
        for (xs xsVar : list2) {
            xsVar.getClass();
            arrayList.add(new xs(xsVar.a, xsVar.b, !z));
        }
        if (z) {
            boolean zH = t23.H();
            ArrayList arrayList2 = new ArrayList(f70.Q(10, arrayList));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((xs) it2.next()).a.packageName);
            }
            String[] strArr = (String[]) arrayList2.toArray(new String[0]);
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            HashSet hashSetE = t23.e(zH);
            hashSetE.removeAll(qe.t0(strArr2));
            t23.w(zH, hashSetE);
        } else {
            boolean zH2 = t23.H();
            ArrayList arrayList3 = new ArrayList(f70.Q(10, arrayList));
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                arrayList3.add(((xs) it3.next()).a.packageName);
            }
            String[] strArr3 = (String[]) arrayList3.toArray(new String[0]);
            String[] strArr4 = (String[]) Arrays.copyOf(strArr3, strArr3.length);
            HashSet hashSetE2 = t23.e(zH2);
            d70.V(hashSetE2, strArr4);
            t23.w(zH2, hashSetE2);
        }
        zsVar.s(arrayList, new s7(3, this, arrayList));
    }

    public final void z() {
        vs4 vs4Var = (vs4) ws4.c.d();
        if (vs4Var == null || !vs4Var.b) {
            return;
        }
        if (co4.H()) {
            p95.C(R.string.restart_vpn_to_make_changes_take_effect, new Object[0]);
            return;
        }
        y3 y3Var = this.S0;
        if (y3Var == null) {
            n12.T("binding");
            throw null;
        }
        oy3 oy3VarG = oy3.g((CoordinatorLayout) y3Var.a, R.string.restart_vpn_to_make_changes_take_effect, 0);
        oy3VarG.i(R.string.restart, new et(this, 4));
        oy3VarG.j();
    }
}
