package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.view.Window;
import androidx.fragment.app.i;
import com.getsurfboard.R;
import com.getsurfboard.ui.service.ExplorerService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q81 extends i {
    public final n81 H0 = new n81(this);
    public final wa I0 = new wa(2, this);

    @Override // androidx.fragment.app.i
    public final Dialog k() {
        wh2 wh2Var = new wh2(requireContext());
        wh2Var.x(R.string.explorer_service_title);
        wh2Var.t(R.string.starting);
        ((p6) wh2Var.z).n = false;
        wh2Var.u(R.string.stop, null);
        u6 u6VarH = wh2Var.h();
        u6VarH.setCanceledOnTouchOutside(false);
        return u6VarH;
    }

    @Override // androidx.fragment.app.i, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        try {
            int i = ExplorerService.y0;
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            n81 n81Var = this.H0;
            n81Var.getClass();
            contextRequireContext.unbindService(n81Var);
        } catch (IllegalArgumentException unused) {
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = this.C0;
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.addFlags(128);
        }
        String strA = l72.A();
        if (strA == null) {
            p95.C(R.string.unknown_error, new Object[0]);
        } else {
            ji0.B(uf2.t(this), null, null, new o81(strA, this, null), 3);
        }
        v9.r(requireContext(), this.I0, new IntentFilter("com.getsurfboard.action.STOP_EXPLORER"), 2);
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onStop() {
        requireContext().unregisterReceiver(this.I0);
        super.onStop();
    }
}
