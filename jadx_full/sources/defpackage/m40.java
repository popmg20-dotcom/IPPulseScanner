package defpackage;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m40 extends ViewOutlineProvider {
    public final /* synthetic */ Chip a;

    public m40(Chip chip) {
        this.a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        p40 p40Var = this.a.y0;
        if (p40Var != null) {
            p40Var.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
