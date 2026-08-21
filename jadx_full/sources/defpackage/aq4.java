package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class aq4 extends r82 implements pl1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ View z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ aq4(View view, int i) {
        super(0);
        this.f = i;
        this.z = view;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.f;
        xl4 xl4Var = xl4.a;
        View view = this.z;
        switch (i) {
            case 0:
                view.setVisibility(0);
                break;
            case 1:
                view.setVisibility(8);
                break;
            default:
                view.setVisibility(0);
                break;
        }
        return xl4Var;
    }
}
