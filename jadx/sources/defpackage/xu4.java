package defpackage;

import android.graphics.Rect;
import android.view.WindowInsets;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xu4 extends wu4 {
    public xu4(bv4 bv4Var, WindowInsets windowInsets) {
        super(bv4Var, windowInsets);
    }

    @Override // defpackage.qu4, defpackage.yu4
    public List<Rect> e(int i) {
        return this.c.getBoundingRects(av4.a(i));
    }

    @Override // defpackage.qu4, defpackage.yu4
    public List<Rect> f(int i) {
        return this.c.getBoundingRectsIgnoringVisibility(av4.a(i));
    }

    @Override // defpackage.qu4, defpackage.yu4
    public void p() {
    }
}
