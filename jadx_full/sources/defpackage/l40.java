package defpackage;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l40 extends ke0 {
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    public /* synthetic */ l40(int i, Object obj) {
        this.e = i;
        this.f = obj;
    }

    @Override // defpackage.ke0
    public final void o(int i) {
        switch (this.e) {
            case 0:
                break;
            default:
                ob4 ob4Var = (ob4) this.f;
                ob4Var.e = true;
                nb4 nb4Var = (nb4) ob4Var.f.get();
                if (nb4Var != null) {
                    nb4Var.a();
                }
                break;
        }
    }

    @Override // defpackage.ke0
    public final void p(Typeface typeface, boolean z) {
        int i = this.e;
        Object obj = this.f;
        switch (i) {
            case 0:
                Chip chip = (Chip) obj;
                p40 p40Var = chip.y0;
                chip.setText(p40Var.d2 ? p40Var.f1 : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z) {
                    ob4 ob4Var = (ob4) obj;
                    ob4Var.e = true;
                    nb4 nb4Var = (nb4) ob4Var.f.get();
                    if (nb4Var != null) {
                        nb4Var.a();
                    }
                    break;
                }
                break;
        }
    }

    private final void M(int i) {
    }
}
