package com.getsurfboard.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.o;
import com.getsurfboard.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import defpackage.da2;
import defpackage.eg0;
import defpackage.ji0;
import defpackage.uf2;
import defpackage.v82;
import defpackage.vf2;
import defpackage.w3;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class LastExitReasonFragment extends o {
    public eg0 b;

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_last_exit_reason, viewGroup, false);
        int i = R.id.reason;
        MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.reason);
        if (materialTextView != null) {
            i = R.id.title;
            if (((MaterialTextView) vf2.l(viewInflate, R.id.title)) != null) {
                MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                this.b = new eg0(18, materialCardView, materialTextView);
                materialCardView.getClass();
                return materialCardView;
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        if (Build.VERSION.SDK_INT >= 30) {
            eg0 eg0Var = this.b;
            eg0Var.getClass();
            ((MaterialCardView) eg0Var.f).setOnClickListener(new w3(3));
            da2 viewLifecycleOwner = getViewLifecycleOwner();
            viewLifecycleOwner.getClass();
            ji0.B(uf2.t(viewLifecycleOwner), null, null, new v82(this, null), 3);
        }
    }
}
