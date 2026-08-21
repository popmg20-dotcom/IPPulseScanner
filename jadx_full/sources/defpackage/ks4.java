package defpackage;

import android.widget.ImageButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ks4 extends ImageButton {
    public int b;

    public final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.b = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.b;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        a(i, true);
    }
}
