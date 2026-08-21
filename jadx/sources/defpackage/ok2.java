package defpackage;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ok2 implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, fl2 {
    public nk2 b;
    public u6 f;
    public ac2 z;

    @Override // defpackage.fl2
    public final void a(nk2 nk2Var, boolean z) {
        u6 u6Var;
        if ((z || nk2Var == this.b) && (u6Var = this.f) != null) {
            u6Var.dismiss();
        }
    }

    @Override // defpackage.fl2
    public final boolean i0(nk2 nk2Var) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        nk2 nk2Var = this.b;
        ac2 ac2Var = this.z;
        zb2 zb2Var = ac2Var.Y;
        if (zb2Var == null) {
            zb2Var = new zb2(ac2Var);
            ac2Var.Y = zb2Var;
        }
        nk2Var.s(zb2Var.getItem(i), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.z.a(this.b, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        nk2 nk2Var = this.b;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                nk2Var.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return nk2Var.performShortcut(i, keyEvent, 0);
    }
}
