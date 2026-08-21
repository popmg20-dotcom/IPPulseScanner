package defpackage;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ma1 extends o {
    public fi4 A;
    public boolean X;
    public cm2 b;
    public final ha1 f;
    public final ca1 z;

    public ma1() {
        ha1 ha1Var = new ha1(0, this);
        this.f = ha1Var;
        this.z = new ca1(ha1Var);
    }

    public static boolean j(aa1 aa1Var, t53 t53Var) {
        ea1 ea1Var = aa1Var.e;
        if (ea1Var instanceof gx3) {
            String str = ((gx3) ea1Var).a;
            Collection<na3> collectionValues = t53Var.H0.values();
            collectionValues.getClass();
            if (!collectionValues.isEmpty()) {
                for (na3 na3Var : collectionValues) {
                    if (na3Var instanceof ka3 ? ((ka3) na3Var).z.contains(str) : na3Var instanceof ma3 ? ((ma3) na3Var).z.contains(str) : na3Var instanceof ia3 ? ((ia3) na3Var).z.contains(str) : na3Var instanceof ja3 ? ((ja3) na3Var).z.contains(str) : na3Var instanceof la3 ? ((la3) na3Var).X.contains(str) : false) {
                        return true;
                    }
                }
            }
        } else if (ea1Var instanceof ix3) {
            String str2 = ((ix3) ea1Var).a;
            ArrayList<tn3> arrayList = t53Var.J0;
            if (arrayList == null || !arrayList.isEmpty()) {
                for (tn3 tn3Var : arrayList) {
                    if (tn3Var.getType().equals("RULE-SET")) {
                        sm3 sm3Var = tn3Var instanceof sm3 ? (sm3) tn3Var : null;
                        if (n12.c(sm3Var != null ? sm3Var.a() : null, str2)) {
                            return true;
                        }
                    }
                }
            }
            Set<ss1> setKeySet = t53Var.F0.keySet();
            setKeySet.getClass();
            if (!setKeySet.isEmpty()) {
                for (ss1 ss1Var : setKeySet) {
                    if ((ss1Var instanceof rs1) && n12.c(((rs1) ss1Var).f, str2)) {
                        return true;
                    }
                }
            }
        } else {
            if (!(ea1Var instanceof bx3)) {
                g.d();
                return false;
            }
            String str3 = ((bx3) ea1Var).a;
            ArrayList<tn3> arrayList2 = t53Var.J0;
            if (arrayList2 == null || !arrayList2.isEmpty()) {
                for (tn3 tn3Var2 : arrayList2) {
                    if (tn3Var2.getType().equals("DOMAIN-SET")) {
                        sm3 sm3Var2 = tn3Var2 instanceof sm3 ? (sm3) tn3Var2 : null;
                        if (n12.c(sm3Var2 != null ? sm3Var2.a() : null, str3)) {
                            return true;
                        }
                    }
                }
            }
            Set<ss1> setKeySet2 = t53Var.F0.keySet();
            setKeySet2.getClass();
            if (!setKeySet2.isEmpty()) {
                for (ss1 ss1Var2 : setKeySet2) {
                    if ((ss1Var2 instanceof ps1) && n12.c(((ps1) ss1Var2).b.b, str3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void k(String str, String str2, aa1 aa1Var, boolean z) {
        boolean z2 = nj3.a;
        y3 y3Var = t23.c(R.string.setting_bypass_tls_verify_key, false) ? nj3.f : nj3.e;
        ue1 ue1Var = new ue1();
        ue1Var.b = this;
        ue1Var.z = aa1Var;
        ue1Var.f = z;
        ue1Var.A = str;
        bd1 bd1Var = new bd1(str2, ue1Var);
        bd1Var.C0 = bd1Var;
        y3Var.a(bd1Var);
    }

    @Override // androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fi4[] fi4VarArrValues = fi4.values();
        Bundle arguments = getArguments();
        this.A = fi4VarArrValues[arguments != null ? arguments.getInt("type") : -1];
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_external_resources_manager_tab, viewGroup, false);
        int i = R.id.empty;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) vf2.l(viewInflate, R.id.empty);
        if (linearLayoutCompat != null) {
            i = R.id.empty_text;
            TextView textView = (TextView) vf2.l(viewInflate, R.id.empty_text);
            if (textView != null) {
                i = R.id.loading;
                LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) vf2.l(viewInflate, R.id.loading);
                if (linearProgressIndicator != null) {
                    i = R.id.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) vf2.l(viewInflate, R.id.recycler_view);
                    if (recyclerView != null) {
                        i = R.id.view_doc;
                        Button button = (Button) vf2.l(viewInflate, R.id.view_doc);
                        if (button != null) {
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                            this.b = new cm2(coordinatorLayout, linearLayoutCompat, textView, linearProgressIndicator, recyclerView, button, 6);
                            coordinatorLayout.getClass();
                            return coordinatorLayout;
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroy() {
        boolean z = nj3.a;
        nj3.e.d(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onResume() {
        super.onResume();
        cm2 cm2Var = this.b;
        cm2Var.getClass();
        RecyclerView recyclerView = (RecyclerView) cm2Var.Y;
        int i = 0;
        while (true) {
            if (!(i < recyclerView.getChildCount())) {
                return;
            }
            int i2 = i + 1;
            View childAt = recyclerView.getChildAt(i);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            cm2 cm2Var2 = this.b;
            cm2Var2.getClass();
            rg3 rg3VarN = ((RecyclerView) cm2Var2.Y).N(childAt);
            if (rg3VarN instanceof ba1) {
                ba1 ba1Var = (ba1) rg3VarN;
                ba1Var.u.d.setText(ContextUtilsKt.l(R.string.last_modified_template, DateUtils.getRelativeTimeSpanString(ba1Var.v)));
            }
            i = i2;
        }
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        int i;
        view.getClass();
        cm2 cm2Var = this.b;
        cm2Var.getClass();
        TextView textView = (TextView) cm2Var.A;
        fi4 fi4Var = this.A;
        if (fi4Var == null) {
            n12.T("type");
            throw null;
        }
        int iOrdinal = fi4Var.ordinal();
        int i2 = 1;
        if (iOrdinal == 0) {
            i = R.string.no_policy_path_available;
        } else if (iOrdinal == 1) {
            i = R.string.no_rule_set_available;
        } else {
            if (iOrdinal != 2) {
                g.d();
                return;
            }
            i = R.string.no_domain_set_available;
        }
        textView.setText(i);
        cm2 cm2Var2 = this.b;
        cm2Var2.getClass();
        ((Button) cm2Var2.Z).setOnClickListener(new mk(9, this));
        cm2 cm2Var3 = this.b;
        cm2Var3.getClass();
        ((LinearProgressIndicator) cm2Var3.X).e();
        cm2 cm2Var4 = this.b;
        cm2Var4.getClass();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) cm2Var4.f;
        jd jdVar = new jd(12, this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(coordinatorLayout, jdVar);
        cm2 cm2Var5 = this.b;
        cm2Var5.getClass();
        ((RecyclerView) cm2Var5.Y).setAdapter(this.z);
        ji0.B(uf2.t(this), null, null, new ia1(this, new fa1(this, 0), null), 3);
        ws4.a.e(getViewLifecycleOwner(), new x3(4, new fa1(this, i2)));
    }
}
