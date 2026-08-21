package com.getsurfboard.ui.fragment.card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.DeveloperOptionsActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import defpackage.ek;
import defpackage.f0;
import defpackage.ha1;
import defpackage.p10;
import defpackage.vf2;
import defpackage.w3;
import defpackage.ws4;
import defpackage.x3;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ActiveConnectionsFragment extends ek {
    public ha1 f;

    public ActiveConnectionsFragment() {
        super(p10.Y);
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_active_connections, viewGroup, false);
        int i = R.id.count;
        MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.count);
        if (materialTextView != null) {
            i = R.id.title;
            if (((MaterialTextView) vf2.l(viewInflate, R.id.title)) != null) {
                MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                this.f = new ha1(materialCardView, materialTextView, 3);
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
        this.f = null;
    }

    @Override // defpackage.ek, androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        ws4.e.e(getViewLifecycleOwner(), new x3(0, new f0(1, this)));
        if (getActivity() instanceof DeveloperOptionsActivity) {
            view.setOnClickListener(new w3(0));
        }
    }
}
