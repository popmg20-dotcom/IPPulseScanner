package defpackage;

import android.app.ApplicationExitInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.textview.MaterialTextView;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a81 extends o {
    public v92 b;
    public em1 f;
    public final c81 z = new c81(new Function2() { // from class: y71
        @Override // kotlin.jvm.functions.Function2
        public final Object k(Object obj, Object obj2) {
            ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo) obj;
            View view = (View) obj2;
            applicationExitInfo.getClass();
            view.getClass();
            em1 em1Var = this.b.f;
            if (em1Var != null) {
                em1Var.e(view, Long.valueOf(applicationExitInfo.getTimestamp()), Integer.valueOf(applicationExitInfo.getPid()));
            }
            return xl4.a;
        }
    });

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_exit_history, viewGroup, false);
        int i = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i = R.id.empty_view;
            MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.empty_view);
            if (materialTextView != null) {
                i = R.id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) vf2.l(viewInflate, R.id.recycler_view);
                if (recyclerView != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                    if (toolbar != null) {
                        i = R.id.toolbar_divider;
                        MaterialDivider materialDivider = (MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider);
                        if (materialDivider != null) {
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                            this.b = new v92(coordinatorLayout, materialTextView, recyclerView, toolbar, materialDivider);
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
    public final void onDestroyView() {
        super.onDestroyView();
        v92 v92Var = this.b;
        v92Var.getClass();
        ((RecyclerView) v92Var.z).setAdapter(null);
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onResume() {
        super.onResume();
        v92 v92Var = this.b;
        v92Var.getClass();
        if (((RecyclerView) v92Var.z).computeVerticalScrollOffset() > 0) {
            v92 v92Var2 = this.b;
            v92Var2.getClass();
            ((MaterialDivider) v92Var2.X).animate().alpha(1.0f).setDuration(100L).start();
        }
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        v92 v92Var = this.b;
        v92Var.getClass();
        ((Toolbar) v92Var.A).setNavigationOnClickListener(new mk(7, this));
        v92 v92Var2 = this.b;
        v92Var2.getClass();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) v92Var2.b;
        jd jdVar = new jd(11, this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(coordinatorLayout, jdVar);
        v92 v92Var3 = this.b;
        v92Var3.getClass();
        ((RecyclerView) v92Var3.z).setLayoutManager(new LinearLayoutManager(requireContext()));
        v92 v92Var4 = this.b;
        v92Var4.getClass();
        ((RecyclerView) v92Var4.z).i(new lw0(requireContext()));
        v92 v92Var5 = this.b;
        v92Var5.getClass();
        ((RecyclerView) v92Var5.z).setAdapter(this.z);
        v92 v92Var6 = this.b;
        v92Var6.getClass();
        ((RecyclerView) v92Var6.z).j(new z71(0, this));
        da2 viewLifecycleOwner = getViewLifecycleOwner();
        viewLifecycleOwner.getClass();
        ji0.B(uf2.t(viewLifecycleOwner), null, null, new mt(this, null, 2), 3);
    }
}
