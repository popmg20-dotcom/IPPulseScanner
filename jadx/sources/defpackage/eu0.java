package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import androidx.fragment.app.i;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class eu0 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ i b;

    public eu0(i iVar) {
        this.b = iVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        i iVar = this.b;
        Dialog dialog = iVar.C0;
        if (dialog != null) {
            iVar.onDismiss(dialog);
        }
    }
}
