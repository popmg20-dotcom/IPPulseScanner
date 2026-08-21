package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.a;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import androidx.preference.Preference;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.getsurfboard.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class p33 extends o {
    public o33 b;

    public abstract hu3 j();

    public final boolean k(j33 j33Var, Preference preference) {
        String str = preference.E0;
        if (j33Var.getId() != R.id.preferences_header) {
            if (j33Var.getId() == R.id.preferences_detail) {
                tj1 tj1VarJ = getChildFragmentManager().J();
                requireContext().getClassLoader();
                str.getClass();
                o oVarA = tj1VarJ.a(str);
                oVarA.getClass();
                oVarA.setArguments(preference.d());
                u childFragmentManager = getChildFragmentManager();
                childFragmentManager.getClass();
                a aVar = new a(childFragmentManager);
                aVar.p = true;
                aVar.k(oVarA, R.id.preferences_detail);
                aVar.f = 4099;
                if (aVar.h) {
                    aVar.g = true;
                    aVar.i = null;
                    aVar.e();
                    return true;
                }
                xe.q("This FragmentTransaction is not allowed to be added to the back stack.");
            }
            return false;
        }
        if (str == null) {
            Intent intent = preference.D0;
            if (intent == null) {
                return true;
            }
            startActivity(intent);
            return true;
        }
        tj1 tj1VarJ2 = getChildFragmentManager().J();
        requireContext().getClassLoader();
        o oVarA2 = tj1VarJ2.a(str);
        if (oVarA2 != null) {
            oVarA2.setArguments(preference.d());
        }
        if (getChildFragmentManager().H() > 0) {
            a aVarG = getChildFragmentManager().G();
            aVarG.getClass();
            getChildFragmentManager().T(aVarG.t, false);
        }
        u childFragmentManager2 = getChildFragmentManager();
        childFragmentManager2.getClass();
        a aVar2 = new a(childFragmentManager2);
        aVar2.p = true;
        oVarA2.getClass();
        aVar2.k(oVarA2, R.id.preferences_detail);
        if (((SlidingPaneLayout) requireView()).d()) {
            aVar2.f = 4099;
        }
        ((SlidingPaneLayout) requireView()).e();
        aVar2.e();
        return true;
    }

    @Override // androidx.fragment.app.o
    public final void onAttach(Context context) {
        context.getClass();
        super.onAttach(context);
        u parentFragmentManager = getParentFragmentManager();
        parentFragmentManager.getClass();
        a aVar = new a(parentFragmentManager);
        aVar.n(this);
        aVar.e();
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(layoutInflater.getContext());
        slidingPaneLayout.setId(R.id.preferences_sliding_pane_layout);
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(R.id.preferences_header);
        ey3 ey3Var = new ey3(getResources().getDimensionPixelSize(R.dimen.preferences_header_width));
        ey3Var.a = getResources().getInteger(R.integer.preferences_header_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView, ey3Var);
        FragmentContainerView fragmentContainerView2 = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView2.setId(R.id.preferences_detail);
        ey3 ey3Var2 = new ey3(getResources().getDimensionPixelSize(R.dimen.preferences_detail_width));
        ey3Var2.a = getResources().getInteger(R.integer.preferences_detail_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView2, ey3Var2);
        if (getChildFragmentManager().C(R.id.preferences_header) == null) {
            hu3 hu3VarJ = j();
            u childFragmentManager = getChildFragmentManager();
            childFragmentManager.getClass();
            a aVar = new a(childFragmentManager);
            aVar.p = true;
            aVar.g(R.id.preferences_header, hu3VarJ, null, 1);
            aVar.e();
        }
        slidingPaneLayout.setLockMode(3);
        return slidingPaneLayout;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        xu2 xu2Var;
        wu2 wu2VarB;
        view.getClass();
        this.b = new o33(this);
        SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) requireView();
        WeakHashMap weakHashMap = wp4.a;
        boolean z = true;
        if (!slidingPaneLayout.isLaidOut() || slidingPaneLayout.isLayoutRequested()) {
            slidingPaneLayout.addOnLayoutChangeListener(new co(z ? 1 : 0, this));
        } else {
            o33 o33Var = this.b;
            o33Var.getClass();
            o33Var.f(((SlidingPaneLayout) requireView()).y0 && ((SlidingPaneLayout) requireView()).d());
        }
        getChildFragmentManager().o.add(new n33(this));
        while (true) {
            xu2Var = null;
            if (view == null) {
                break;
            }
            Object tag = view.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
            xu2 xu2Var2 = tag instanceof xu2 ? (xu2) tag : null;
            if (xu2Var2 != null) {
                xu2Var = xu2Var2;
                break;
            }
            ViewParent parent = view.getParent();
            Object obj = parent;
            if (parent == null) {
                Object tag2 = view.getTag(R.id.view_tree_disjoint_parent);
                obj = tag2 instanceof ViewParent ? (ViewParent) tag2 : null;
            }
            view = obj instanceof View ? (View) obj : null;
        }
        if (xu2Var == null || (wu2VarB = xu2Var.b()) == null) {
            return;
        }
        da2 viewLifecycleOwner = getViewLifecycleOwner();
        o33 o33Var2 = this.b;
        o33Var2.getClass();
        wu2VarB.a(viewLifecycleOwner, o33Var2);
    }

    @Override // androidx.fragment.app.o
    public final void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle == null) {
            o oVarC = getChildFragmentManager().C(R.id.preferences_header);
            if (oVarC == null) {
                zo2.n("null cannot be cast to non-null type androidx.preference.PreferenceFragmentCompat");
                return;
            }
            j33 j33Var = (j33) oVarC;
            o oVarA = null;
            if (j33Var.getPreferenceScreen().f1.size() > 0) {
                int size = j33Var.getPreferenceScreen().f1.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    int i2 = i + 1;
                    Preference preferenceB = j33Var.getPreferenceScreen().B(i);
                    preferenceB.getClass();
                    String str = preferenceB.E0;
                    if (str == null) {
                        i = i2;
                    } else {
                        tj1 tj1VarJ = getChildFragmentManager().J();
                        requireContext().getClassLoader();
                        oVarA = tj1VarJ.a(str);
                        if (oVarA != null) {
                            oVarA.setArguments(preferenceB.d());
                        }
                    }
                }
            }
            if (oVarA == null) {
                return;
            }
            u childFragmentManager = getChildFragmentManager();
            childFragmentManager.getClass();
            a aVar = new a(childFragmentManager);
            aVar.p = true;
            aVar.k(oVarA, R.id.preferences_detail);
            aVar.e();
        }
    }
}
