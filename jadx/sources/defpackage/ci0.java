package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.i;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ci0 extends i {
    @Override // androidx.fragment.app.i
    public final Dialog k() {
        boolean zF;
        wh2 wh2Var = new wh2(requireContext());
        wh2Var.x(R.string.toggle_cards);
        boolean[] zArr = new boolean[8];
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    zF = t23.f(p10.b);
                    break;
                case 1:
                    zF = t23.f(p10.f);
                    break;
                case 2:
                    zF = t23.f(p10.z);
                    break;
                case 3:
                    zF = t23.f(p10.A);
                    break;
                case 4:
                    zF = t23.f(p10.X);
                    break;
                case 5:
                    zF = t23.f(p10.Y);
                    break;
                case 6:
                    zF = t23.f(p10.Z);
                    break;
                case 7:
                    zF = t23.f(p10.y0);
                    break;
                default:
                    xe.k(dw2.A(i, "unknown index "));
                    return null;
            }
            zArr[i] = zF;
        }
        DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener = new DialogInterface.OnMultiChoiceClickListener() { // from class: zh0
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                p10 p10Var;
                switch (i2) {
                    case 0:
                        p10Var = p10.b;
                        break;
                    case 1:
                        p10Var = p10.f;
                        break;
                    case 2:
                        p10Var = p10.z;
                        break;
                    case 3:
                        p10Var = p10.A;
                        break;
                    case 4:
                        p10Var = p10.X;
                        break;
                    case 5:
                        p10Var = p10.Y;
                        break;
                    case 6:
                        p10Var = p10.Z;
                        break;
                    case 7:
                        p10Var = p10.y0;
                        break;
                    default:
                        xe.k(dw2.A(i2, "unknown index "));
                        return;
                }
                t23.z(p10Var, z);
                Bundle bundle = new Bundle();
                bundle.putString("type", p10Var.name());
                bundle.putBoolean("isChecked", z);
                e7.a(bundle, "dashboard_card_toggle");
                ji0.B(uf2.t(this.a), null, null, new bi0(p10Var, z, (ge0) null), 3);
            }
        };
        p6 p6Var = (p6) wh2Var.z;
        p6Var.r = p6Var.a.getResources().getTextArray(R.array.dashboard_toggle_cards);
        p6Var.A = onMultiChoiceClickListener;
        p6Var.w = zArr;
        p6Var.x = true;
        wh2Var.w(android.R.string.ok, null);
        u6 u6VarH = wh2Var.h();
        u6VarH.setOnShowListener(new ai0(0));
        return u6VarH;
    }

    @Override // androidx.fragment.app.i, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("action", "cancel");
        e7.a(bundle, "dashboard_toggle_cards_dialog");
    }

    @Override // androidx.fragment.app.i, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        super.onDismiss(dialogInterface);
        ha0.u("action", "dismiss", "dashboard_toggle_cards_dialog");
    }
}
