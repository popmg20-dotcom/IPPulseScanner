package defpackage;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e21 extends p84 {
    public final /* synthetic */ int M0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e21(int i) {
        super(1);
        this.M0 = i;
    }

    @Override // defpackage.p84
    public final void f(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float fSin;
        float fCos;
        switch (this.M0) {
            case 0:
                RectF rectFD = p84.d(tabLayout, view);
                RectF rectFD2 = p84.d(tabLayout, view2);
                if (rectFD.left < rectFD2.left) {
                    double d = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) (1.0d - Math.cos(d));
                    fCos = (float) Math.sin(d);
                } else {
                    double d2 = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) Math.sin(d2);
                    fCos = (float) (1.0d - Math.cos(d2));
                }
                drawable.setBounds(t8.c((int) rectFD.left, fSin, (int) rectFD2.left), drawable.getBounds().top, t8.c((int) rectFD.right, fCos, (int) rectFD2.right), drawable.getBounds().bottom);
                break;
            default:
                if (f >= 0.5f) {
                    view = view2;
                }
                RectF rectFD3 = p84.d(tabLayout, view);
                float fB = f < 0.5f ? t8.b(1.0f, 0.0f, 0.0f, 0.5f, f) : t8.b(0.0f, 1.0f, 0.5f, 1.0f, f);
                drawable.setBounds((int) rectFD3.left, drawable.getBounds().top, (int) rectFD3.right, drawable.getBounds().bottom);
                drawable.setAlpha((int) (fB * 255.0f));
                break;
        }
    }
}
