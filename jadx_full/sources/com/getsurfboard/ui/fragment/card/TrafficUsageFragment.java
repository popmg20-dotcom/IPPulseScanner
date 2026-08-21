package com.getsurfboard.ui.fragment.card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import defpackage.ek;
import defpackage.f0;
import defpackage.p10;
import defpackage.v92;
import defpackage.vf2;
import defpackage.w3;
import defpackage.ws4;
import defpackage.x3;
import defpackage.zn;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class TrafficUsageFragment extends ek {
    public v92 f;
    public final zn z;

    public TrafficUsageFragment() {
        super(p10.Z);
        this.z = new zn(8, this);
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_traffic_usage, viewGroup, false);
        int i = R.id.download_unit;
        MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.download_unit);
        if (materialTextView != null) {
            i = R.id.download_value;
            MaterialTextView materialTextView2 = (MaterialTextView) vf2.l(viewInflate, R.id.download_value);
            if (materialTextView2 != null) {
                i = R.id.title;
                if (((MaterialTextView) vf2.l(viewInflate, R.id.title)) != null) {
                    i = R.id.upload_unit;
                    MaterialTextView materialTextView3 = (MaterialTextView) vf2.l(viewInflate, R.id.upload_unit);
                    if (materialTextView3 != null) {
                        i = R.id.upload_value;
                        MaterialTextView materialTextView4 = (MaterialTextView) vf2.l(viewInflate, R.id.upload_value);
                        if (materialTextView4 != null) {
                            MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                            this.f = new v92(materialCardView, materialTextView, materialTextView2, materialTextView3, materialTextView4);
                            materialCardView.getClass();
                            return materialCardView;
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
        this.f = null;
    }

    @Override // defpackage.ek, androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        ws4.c.e(getViewLifecycleOwner(), new x3(12, new f0(29, this)));
        v92 v92Var = this.f;
        v92Var.getClass();
        ((MaterialCardView) v92Var.b).setOnClickListener(new w3(10));
    }
}
