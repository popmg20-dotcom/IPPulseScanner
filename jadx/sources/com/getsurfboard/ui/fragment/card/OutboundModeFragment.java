package com.getsurfboard.ui.fragment.card;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.getsurfboard.R;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textview.MaterialTextView;
import defpackage.ek;
import defpackage.ha1;
import defpackage.mk;
import defpackage.p10;
import defpackage.t23;
import defpackage.vf2;
import defpackage.xw2;
import defpackage.zo2;
import defpackage.zw2;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class OutboundModeFragment extends ek {
    public ha1 f;

    public OutboundModeFragment() {
        super(p10.f);
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_outbound_mode, viewGroup, false);
        int i = R.id.direct;
        if (((MaterialRadioButton) vf2.l(viewInflate, R.id.direct)) != null) {
            i = R.id.global;
            if (((MaterialRadioButton) vf2.l(viewInflate, R.id.global)) != null) {
                i = R.id.group;
                RadioGroup radioGroup = (RadioGroup) vf2.l(viewInflate, R.id.group);
                if (radioGroup != null) {
                    i = R.id.rule_based;
                    if (((MaterialRadioButton) vf2.l(viewInflate, R.id.rule_based)) != null) {
                        i = R.id.title;
                        if (((MaterialTextView) vf2.l(viewInflate, R.id.title)) != null) {
                            MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                            this.f = new ha1(materialCardView, radioGroup, 5);
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
    public final void onViewCreated(final View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        xw2 xw2Var = (xw2) t23.d.d();
        int i = xw2Var == null ? -1 : zw2.a[xw2Var.ordinal()];
        if (i == 1) {
            ha1 ha1Var = this.f;
            ha1Var.getClass();
            ((RadioGroup) ha1Var.f).check(R.id.rule_based);
        } else if (i == 2) {
            ha1 ha1Var2 = this.f;
            ha1Var2.getClass();
            ((RadioGroup) ha1Var2.f).check(R.id.direct);
        } else if (i == 3) {
            ha1 ha1Var3 = this.f;
            ha1Var3.getClass();
            ((RadioGroup) ha1Var3.f).check(R.id.global);
        }
        ha1 ha1Var4 = this.f;
        ha1Var4.getClass();
        ((RadioGroup) ha1Var4.f).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: yw2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                xw2 xw2Var2;
                radioGroup.getClass();
                if (i2 == R.id.rule_based) {
                    xw2Var2 = xw2.b;
                } else if (i2 == R.id.direct) {
                    xw2Var2 = xw2.f;
                } else if (i2 != R.id.global) {
                    return;
                } else {
                    xw2Var2 = xw2.z;
                }
                xb5.c("outbound mode clicked: " + xw2Var2.name());
                SharedPreferences.Editor editorEdit = t23.l().edit();
                t23.d.i(xw2Var2);
                editorEdit.putInt("proxy_outbound_mode", xw2Var2.ordinal());
                editorEdit.apply();
                if (n12.c(ws4.a.d(), Boolean.TRUE)) {
                    Context context = view.getContext();
                    context.getClass();
                    Map map = zw1.a;
                    Intent intentPutExtra = new Intent(context, (Class<?>) SurfboardVpn.class).putExtra("change_outbound_mode", true).putExtra("outbound_mode", xw2Var2.ordinal());
                    intentPutExtra.getClass();
                    if (yw1.G0) {
                        v9.z(context, intentPutExtra);
                    } else {
                        context.startService(intentPutExtra);
                    }
                }
            }
        });
        view.setOnClickListener(new mk(14, this));
    }
}
