package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tq4 implements cg3 {
    @Override // defpackage.cg3
    public final void d(View view) {
        bg3 bg3Var = (bg3) view.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) bg3Var).width == -1 && ((ViewGroup.MarginLayoutParams) bg3Var).height == -1) {
            return;
        }
        xe.q("Pages must fill the whole ViewPager2 (use match_parent)");
    }

    @Override // defpackage.cg3
    public final void b(View view) {
    }
}
