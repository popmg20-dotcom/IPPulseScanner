package defpackage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.i;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class x54 extends i {
    public Dialog H0;
    public DialogInterface.OnCancelListener I0;
    public AlertDialog J0;

    @Override // androidx.fragment.app.i
    public final Dialog k() {
        Dialog dialog = this.H0;
        if (dialog != null) {
            return dialog;
        }
        this.y0 = false;
        AlertDialog alertDialog = this.J0;
        if (alertDialog != null) {
            return alertDialog;
        }
        Context context = getContext();
        tj4.i(context);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).create();
        this.J0 = alertDialogCreate;
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.i, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.I0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
