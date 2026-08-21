package defpackage;

import androidx.fragment.app.o;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ej1 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ o f;

    public /* synthetic */ ej1(o oVar, int i) {
        this.b = i;
        this.f = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        o oVar = this.f;
        switch (i) {
            case 0:
                oVar.startPostponedEnterTransition();
                break;
            default:
                oVar.callStartTransitionListener(false);
                break;
        }
    }
}
