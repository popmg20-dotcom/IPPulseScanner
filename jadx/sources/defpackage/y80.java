package defpackage;

import androidx.fragment.app.p;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y80 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ p f;

    public /* synthetic */ y80(p pVar, int i) {
        this.b = i;
        this.f = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        p pVar = this.f;
        switch (i) {
            case 0:
                pVar.invalidateOptionsMenu();
                break;
            default:
                i90.t(pVar);
                break;
        }
    }
}
