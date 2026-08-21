package defpackage;

import android.app.Dialog;
import androidx.fragment.app.i;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class cb extends i {
    @Override // androidx.fragment.app.i
    public Dialog k() {
        return new bb(getContext(), this.Y);
    }

    @Override // androidx.fragment.app.i
    public final void l(Dialog dialog, int i) {
        if (!(dialog instanceof bb)) {
            super.l(dialog, i);
            return;
        }
        bb bbVar = (bb) dialog;
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        bbVar.d().i(1);
    }
}
