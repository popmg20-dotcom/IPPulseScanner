package defpackage;

import android.content.DialogInterface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vh0 implements DialogInterface.OnShowListener {
    public final /* synthetic */ xh0 a;

    public vh0(xh0 xh0Var) {
        this.a = xh0Var;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        this.a.Z = true;
    }
}
