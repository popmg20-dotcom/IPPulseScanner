package com.getsurfboard.ui.fragment.card;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import defpackage.eg0;
import defpackage.ek;
import defpackage.gj;
import defpackage.p10;
import defpackage.v9;
import defpackage.vf2;
import defpackage.wa;
import defpackage.ws4;
import defpackage.x3;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class LocalProxyFragment extends ek {
    public eg0 f;
    public final wa z;

    public LocalProxyFragment() {
        super(p10.X);
        this.z = new wa(4, this);
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_local_proxy, viewGroup, false);
        int i = R.id.http_title;
        if (((MaterialTextView) vf2.l(viewInflate, R.id.http_title)) != null) {
            i = R.id.http_value;
            MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.http_value);
            if (materialTextView != null) {
                i = R.id.socks5_title;
                if (((MaterialTextView) vf2.l(viewInflate, R.id.socks5_title)) != null) {
                    i = R.id.socks5_value;
                    MaterialTextView materialTextView2 = (MaterialTextView) vf2.l(viewInflate, R.id.socks5_value);
                    if (materialTextView2 != null) {
                        i = R.id.title;
                        if (((MaterialTextView) vf2.l(viewInflate, R.id.title)) != null) {
                            MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                            this.f = new eg0(materialCardView, materialTextView, materialTextView2, 20);
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
        requireContext().unregisterReceiver(this.z);
        super.onDestroyView();
        this.f = null;
    }

    @Override // defpackage.ek, androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        v9.r(view.getContext(), this.z, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
        ws4.f.e(getViewLifecycleOwner(), new x3(5, new gj(8, view, this)));
    }
}
