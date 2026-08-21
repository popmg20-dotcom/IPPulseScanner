package defpackage;

import android.view.View;
import com.getsurfboard.ui.fragment.FdCountFragment;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fc1 implements pl1 {
    public final /* synthetic */ FdCountFragment b;
    public final /* synthetic */ int f;

    public fc1(FdCountFragment fdCountFragment, int i) {
        this.b = fdCountFragment;
        this.f = i;
    }

    @Override // defpackage.pl1
    public final Object a() {
        FdCountFragment fdCountFragment = this.b;
        oj1 oj1Var = fdCountFragment.b;
        oj1Var.getClass();
        ((MaterialTextView) oj1Var.f).setText(String.valueOf(this.f));
        View view = fdCountFragment.getView();
        if (view != null) {
            view.postDelayed(fdCountFragment.f, 3000L);
        }
        return xl4.a;
    }
}
