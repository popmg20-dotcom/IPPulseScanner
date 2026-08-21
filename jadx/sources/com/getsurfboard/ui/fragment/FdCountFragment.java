package com.getsurfboard.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.o;
import com.getsurfboard.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import defpackage.ga1;
import defpackage.oj1;
import defpackage.vf2;
import defpackage.w3;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class FdCountFragment extends o {
    public oj1 b;
    public final ga1 f = new ga1(1, this);

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_fd_count, viewGroup, false);
        int i = R.id.count;
        MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.count);
        if (materialTextView != null) {
            i = R.id.title;
            if (((MaterialTextView) vf2.l(viewInflate, R.id.title)) != null) {
                MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                this.b = new oj1(materialCardView, materialTextView, 0);
                materialCardView.getClass();
                return materialCardView;
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        View view = getView();
        if (view != null) {
            view.removeCallbacks(this.f);
        }
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        view.setOnClickListener(new w3(2));
        view.post(this.f);
    }
}
