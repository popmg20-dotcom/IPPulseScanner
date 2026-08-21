package defpackage;

import android.graphics.Outline;
import android.graphics.Path;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bv3 extends ViewOutlineProvider {
    public final /* synthetic */ cv3 a;

    public bv3(cv3 cv3Var) {
        this.a = cv3Var;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        Path path = this.a.c;
        if (path.isEmpty()) {
            return;
        }
        outline.setPath(path);
    }
}
