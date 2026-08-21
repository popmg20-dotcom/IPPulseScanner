package defpackage;

import android.window.OnBackInvokedCallback;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sa implements OnBackInvokedCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ sa(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final void onBackInvoked() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((za) obj).H();
                break;
            case 1:
                ((ai2) obj).a();
                break;
            case 2:
                ((pu2) obj).a();
                break;
            case 3:
                kb3 kb3Var = (kb3) obj;
                kb3Var.I0.a(kb3Var.getActivity(), kb3Var.getView(), new jb3(kb3Var, 1));
                break;
            default:
                ((Runnable) obj).run();
                break;
        }
    }
}
