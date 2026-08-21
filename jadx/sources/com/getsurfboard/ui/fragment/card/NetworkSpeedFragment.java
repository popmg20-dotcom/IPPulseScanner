package com.getsurfboard.ui.fragment.card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.getsurfboard.R;
import com.getsurfboard.ui.widget.SparklineView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import defpackage.cm2;
import defpackage.d70;
import defpackage.dg4;
import defpackage.eg4;
import defpackage.ek;
import defpackage.f33;
import defpackage.gb4;
import defpackage.gj;
import defpackage.p10;
import defpackage.t23;
import defpackage.vf2;
import defpackage.w3;
import defpackage.ws4;
import defpackage.x3;
import defpackage.zn;
import defpackage.zo2;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkSpeedFragment extends ek {
    public final ArrayList A;
    public long X;
    public long Y;
    public boolean Z;
    public final int f;
    public final f33 y0;
    public cm2 z;
    public final zn z0;

    public NetworkSpeedFragment() {
        super(p10.b);
        this.f = 30;
        this.A = new ArrayList();
        this.Z = t23.E();
        this.y0 = new f33(19, this);
        this.z0 = new zn(5, this);
    }

    public final void j() {
        ArrayList arrayList = this.A;
        arrayList.clear();
        int iX = d70.X(gb4.d0(0, this.f));
        for (int i = 0; i < iX; i++) {
            arrayList.add(Float.valueOf(0.0f));
        }
        boolean zE = t23.E();
        this.Z = zE;
        eg4 eg4Var = (eg4) dg4.p.d();
        if (zE) {
            this.X = eg4Var != null ? eg4Var.a : 0L;
            this.Y = eg4Var != null ? eg4Var.b : 0L;
        } else {
            this.X = eg4Var != null ? eg4Var.e : 0L;
            this.Y = eg4Var != null ? eg4Var.f : 0L;
        }
    }

    @Override // androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j();
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_network_speed, viewGroup, false);
        int i = R.id.download_container;
        if (((LinearLayoutCompat) vf2.l(viewInflate, R.id.download_container)) != null) {
            i = R.id.download_title;
            if (((MaterialTextView) vf2.l(viewInflate, R.id.download_title)) != null) {
                i = R.id.download_unit;
                TextView textView = (TextView) vf2.l(viewInflate, R.id.download_unit);
                if (textView != null) {
                    i = R.id.download_value;
                    MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.download_value);
                    if (materialTextView != null) {
                        i = R.id.spark;
                        SparklineView sparklineView = (SparklineView) vf2.l(viewInflate, R.id.spark);
                        if (sparklineView != null) {
                            i = R.id.title;
                            if (((MaterialTextView) vf2.l(viewInflate, R.id.title)) != null) {
                                i = R.id.upload_container;
                                if (((LinearLayoutCompat) vf2.l(viewInflate, R.id.upload_container)) != null) {
                                    i = R.id.upload_title;
                                    if (((MaterialTextView) vf2.l(viewInflate, R.id.upload_title)) != null) {
                                        i = R.id.upload_unit;
                                        TextView textView2 = (TextView) vf2.l(viewInflate, R.id.upload_unit);
                                        if (textView2 != null) {
                                            i = R.id.upload_value;
                                            MaterialTextView materialTextView2 = (MaterialTextView) vf2.l(viewInflate, R.id.upload_value);
                                            if (materialTextView2 != null) {
                                                MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                                                this.z = new cm2(materialCardView, textView, materialTextView, sparklineView, textView2, materialTextView2, 7);
                                                materialCardView.getClass();
                                                return materialCardView;
                                            }
                                        }
                                    }
                                }
                            }
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
        requireView().removeCallbacks(this.y0);
        super.onDestroyView();
        this.z = null;
    }

    @Override // defpackage.ek, androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        cm2 cm2Var = this.z;
        cm2Var.getClass();
        ((SparklineView) cm2Var.X).setValues(this.A);
        ws4.c.e(getViewLifecycleOwner(), new x3(6, new gj(10, this, view)));
        cm2 cm2Var2 = this.z;
        cm2Var2.getClass();
        ((MaterialCardView) cm2Var2.f).setOnClickListener(new w3(5));
    }
}
