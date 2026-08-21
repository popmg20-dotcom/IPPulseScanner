package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class es3 extends qo {
    public gk1 H0;
    public ArrayList I0;
    public final cs3 J0 = new cs3(new f0(25, this));
    public StaggeredGridLayoutManager K0;

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        ArrayList<String> stringArrayList;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (stringArrayList = arguments.getStringArrayList("list")) == null) {
            xe.k("init proxy group list failed");
            return;
        }
        this.I0 = stringArrayList;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            this.J0.f = arguments2.getInt("index");
        } else {
            xe.k("init proxy group index failed");
        }
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_select_proxy_group_dialog, viewGroup, false);
        int i = R.id.drag_handle;
        if (((BottomSheetDragHandleView) vf2.l(viewInflate, R.id.drag_handle)) != null) {
            i = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) vf2.l(viewInflate, R.id.recycler_view);
            if (recyclerView != null) {
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate;
                this.H0 = new gk1(linearLayoutCompat, recyclerView);
                linearLayoutCompat.getClass();
                return linearLayoutCompat;
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.H0 = null;
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onStart() {
        super.onStart();
        View view = getView();
        Object parent = view != null ? view.getParent() : null;
        parent.getClass();
        BottomSheetBehavior bottomSheetBehaviorD = BottomSheetBehavior.D((View) parent);
        if ((bottomSheetBehaviorD.Z ? -1 : bottomSheetBehaviorD.Y) == -1 && ContextUtilsKt.getContext().getResources().getConfiguration().orientation == 2) {
            bottomSheetBehaviorD.M(getResources().getDimensionPixelOffset(R.dimen.bottom_sheet_landscape_peek_height));
        }
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        gk1 gk1Var = this.H0;
        gk1Var.getClass();
        ag3 layoutManager = gk1Var.a.getLayoutManager();
        layoutManager.getClass();
        this.K0 = (StaggeredGridLayoutManager) layoutManager;
        gk1 gk1Var2 = this.H0;
        gk1Var2.getClass();
        gk1Var2.a.addOnLayoutChangeListener(new r10(5, this));
        gk1 gk1Var3 = this.H0;
        gk1Var3.getClass();
        RecyclerView recyclerView = gk1Var3.a;
        cs3 cs3Var = this.J0;
        recyclerView.setAdapter(cs3Var);
        ArrayList arrayList = this.I0;
        if (arrayList != null) {
            cs3Var.r(arrayList);
        } else {
            n12.T("list");
            throw null;
        }
    }
}
