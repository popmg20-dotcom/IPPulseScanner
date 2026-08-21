package defpackage;

import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fp2 extends FrameLayout implements lp2 {
    public boolean b;
    public boolean f;
    public boolean z;

    public final void a() {
        setVisibility((!this.z || (!this.b && this.f)) ? 8 : 0);
    }

    @Override // defpackage.hl2
    public final void c(sk2 sk2Var) {
        a();
    }

    @Override // defpackage.hl2
    public sk2 getItemData() {
        return null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setDividersEnabled(boolean z) {
        this.z = z;
        a();
    }

    @Override // defpackage.lp2
    public void setExpanded(boolean z) {
        this.b = z;
        a();
    }

    @Override // defpackage.lp2
    public void setOnlyShowWhenExpanded(boolean z) {
        this.f = z;
        a();
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
    }

    public void setIcon(Drawable drawable) {
    }

    public void setTitle(CharSequence charSequence) {
    }
}
