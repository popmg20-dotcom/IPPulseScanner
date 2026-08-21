package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.o;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class np1 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ o f;

    public /* synthetic */ np1(o oVar, int i) {
        this.b = i;
        this.f = oVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        int i = this.b;
        o oVar = this.f;
        switch (i) {
            case 0:
                ((qp1) oVar).j();
                break;
            case 1:
                ((qp1) oVar).j();
                break;
            default:
                xh0 xh0Var = (xh0) oVar;
                if (n12.c(ws4.a.d(), Boolean.TRUE)) {
                    Context contextRequireContext = xh0Var.requireContext();
                    contextRequireContext.getClass();
                    zw1.d(contextRequireContext);
                }
                break;
        }
    }
}
