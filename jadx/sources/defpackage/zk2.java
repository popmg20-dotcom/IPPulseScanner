package defpackage;

import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zk2 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ al2 b;

    public zk2(al2 al2Var) {
        this.b = al2Var;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.b.c();
    }
}
