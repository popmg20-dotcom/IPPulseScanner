package defpackage;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class t43 {
    public Size a;
    public final FrameLayout b;
    public final o43 c;
    public boolean d = false;

    public t43(FrameLayout frameLayout, o43 o43Var) {
        this.b = frameLayout;
        this.c = o43Var;
    }

    public abstract View a();

    public abstract Bitmap b();

    public abstract void c();

    public abstract void d();

    public abstract void e(j74 j74Var, m10 m10Var);

    public final void f() {
        View viewA = a();
        if (viewA == null || !this.d) {
            return;
        }
        FrameLayout frameLayout = this.b;
        Size size = new Size(frameLayout.getWidth(), frameLayout.getHeight());
        int layoutDirection = frameLayout.getLayoutDirection();
        o43 o43Var = this.c;
        o43Var.getClass();
        if (size.getHeight() == 0 || size.getWidth() == 0) {
            ez4.a0("PreviewTransform", "Transform not applied due to PreviewView size: " + size);
            return;
        }
        if (o43Var.f()) {
            if (viewA instanceof TextureView) {
                ((TextureView) viewA).setTransform(o43Var.d());
            } else {
                Display display = viewA.getDisplay();
                boolean z = false;
                boolean z2 = (!o43Var.g || display == null || display.getRotation() == o43Var.e) ? false : true;
                boolean z3 = o43Var.g;
                if (!z3) {
                    if ((!z3 ? o43Var.c : -r25.T(o43Var.e)) != 0) {
                        z = true;
                    }
                }
                if (z2 || z) {
                    ez4.q("PreviewTransform", "Custom rotation not supported with SurfaceView/PERFORMANCE mode.");
                }
            }
            RectF rectFE = o43Var.e(size, layoutDirection);
            viewA.setPivotX(0.0f);
            viewA.setPivotY(0.0f);
            viewA.setScaleX(rectFE.width() / o43Var.a.getWidth());
            viewA.setScaleY(rectFE.height() / o43Var.a.getHeight());
            viewA.setTranslationX(rectFE.left - viewA.getLeft());
            viewA.setTranslationY(rectFE.top - viewA.getTop());
        }
    }

    public abstract nc2 g();
}
