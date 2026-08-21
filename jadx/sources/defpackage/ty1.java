package defpackage;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.DefaultLifecycleObserver;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ty1 implements DefaultLifecycleObserver {
    public boolean b;
    public final ImageView f;

    public ty1(ImageView imageView) {
        this.f = imageView;
    }

    public final void a() {
        Object drawable = this.f.getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable == null) {
            return;
        }
        if (this.b) {
            animatable.start();
        } else {
            animatable.stop();
        }
    }

    public final void b(Drawable drawable) {
        ImageView imageView = this.f;
        Object drawable2 = imageView.getDrawable();
        Animatable animatable = drawable2 instanceof Animatable ? (Animatable) drawable2 : null;
        if (animatable != null) {
            animatable.stop();
        }
        imageView.setImageDrawable(drawable);
        a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ty1) {
            return n12.c(this.f, ((ty1) obj).f);
        }
        return false;
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(da2 da2Var) {
        this.b = true;
        a();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(da2 da2Var) {
        this.b = false;
        a();
    }
}
