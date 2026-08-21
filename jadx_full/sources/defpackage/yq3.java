package defpackage;

import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yq3 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ SearchView f;

    public /* synthetic */ yq3(SearchView searchView, int i) {
        this.b = i;
        this.f = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        SearchView searchView = this.f;
        switch (i) {
            case 0:
                searchView.t();
                break;
            default:
                og0 og0Var = searchView.k1;
                if (og0Var instanceof p54) {
                    og0Var.b(null);
                }
                break;
        }
    }
}
