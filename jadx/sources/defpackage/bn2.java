package defpackage;

import android.content.DialogInterface;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bn2 implements DialogInterface.OnMultiChoiceClickListener {
    public final /* synthetic */ cn2 a;

    public bn2(cn2 cn2Var) {
        this.a = cn2Var;
    }

    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
    public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
        cn2 cn2Var = this.a;
        HashSet hashSet = cn2Var.P0;
        boolean z2 = cn2Var.Q0;
        if (z) {
            cn2Var.Q0 = hashSet.add(cn2Var.S0[i].toString()) | z2;
        } else {
            cn2Var.Q0 = hashSet.remove(cn2Var.S0[i].toString()) | z2;
        }
    }
}
