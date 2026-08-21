package com.getsurfboard.ui.fragment.card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.textview.MaterialTextView;
import defpackage.cr2;
import defpackage.ek;
import defpackage.f0;
import defpackage.nj1;
import defpackage.nj3;
import defpackage.p10;
import defpackage.vf2;
import defpackage.w3;
import defpackage.x3;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class DnsFragment extends ek {
    public nj1 f;
    public boolean z;

    public DnsFragment() {
        super(p10.A);
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dns, viewGroup, false);
        int i = R.id.ip;
        MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.ip);
        if (materialTextView != null) {
            i = R.id.loading;
            LoadingIndicator loadingIndicator = (LoadingIndicator) vf2.l(viewInflate, R.id.loading);
            if (loadingIndicator != null) {
                i = R.id.retry;
                MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.retry);
                if (materialButton != null) {
                    i = R.id.title;
                    if (((MaterialTextView) vf2.l(viewInflate, R.id.title)) != null) {
                        MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                        this.f = new nj1(materialCardView, materialTextView, loadingIndicator, materialButton);
                        materialCardView.getClass();
                        return materialCardView;
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        boolean z = nj3.a;
        nj3.e.d(this);
        super.onDestroyView();
        this.f = null;
    }

    @Override // androidx.fragment.app.o
    public final void onResume() {
        super.onResume();
        cr2.b();
    }

    @Override // defpackage.ek, androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        nj1 nj1Var = this.f;
        nj1Var.getClass();
        nj1Var.c.setOnClickListener(new w3(1));
        cr2.c.e(getViewLifecycleOwner(), new x3(3, new f0(7, this)));
    }
}
