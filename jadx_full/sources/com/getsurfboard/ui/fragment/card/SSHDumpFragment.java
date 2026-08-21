package com.getsurfboard.ui.fragment.card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.o;
import com.getsurfboard.R;
import com.google.android.material.card.MaterialCardView;
import defpackage.cr2;
import defpackage.f0;
import defpackage.gj;
import defpackage.mk;
import defpackage.oj1;
import defpackage.vf2;
import defpackage.ws4;
import defpackage.yh0;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SSHDumpFragment extends o {
    public oj1 b;

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_sshdump, viewGroup, false);
        TextView textView = (TextView) vf2.l(viewInflate, R.id.text);
        if (textView == null) {
            zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.text)));
            return null;
        }
        MaterialCardView materialCardView = (MaterialCardView) viewInflate;
        this.b = new oj1(materialCardView, textView, 2);
        materialCardView.getClass();
        return materialCardView;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        ws4.g.e(getViewLifecycleOwner(), new yh0(7, new gj(19, view, this)));
        cr2.b.e(getViewLifecycleOwner(), new yh0(7, new f0(24, this)));
        view.setOnClickListener(new mk(23, this));
    }
}
