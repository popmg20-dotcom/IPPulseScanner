package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ib extends ImageView {
    public final k5 b;
    public final qt f;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ib(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        je4.a(context);
        this.z = false;
        id4.a(getContext(), this);
        k5 k5Var = new k5(this);
        this.b = k5Var;
        k5Var.m(attributeSet, i);
        qt qtVar = new qt(this);
        this.f = qtVar;
        qtVar.n(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        k5 k5Var = this.b;
        if (k5Var != null) {
            k5Var.a();
        }
        qt qtVar = this.f;
        if (qtVar != null) {
            qtVar.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        k5 k5Var = this.b;
        if (k5Var != null) {
            return k5Var.i();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        k5 k5Var = this.b;
        if (k5Var != null) {
            return k5Var.j();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        cb0 cb0Var;
        qt qtVar = this.f;
        if (qtVar == null || (cb0Var = (cb0) qtVar.d) == null) {
            return null;
        }
        return (ColorStateList) cb0Var.c;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        cb0 cb0Var;
        qt qtVar = this.f;
        if (qtVar == null || (cb0Var = (cb0) qtVar.d) == null) {
            return null;
        }
        return (PorterDuff.Mode) cb0Var.d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.f.c).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        k5 k5Var = this.b;
        if (k5Var != null) {
            k5Var.o();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        k5 k5Var = this.b;
        if (k5Var != null) {
            k5Var.p(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        qt qtVar = this.f;
        if (qtVar != null) {
            qtVar.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        qt qtVar = this.f;
        if (qtVar != null && drawable != null && !this.z) {
            qtVar.b = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (qtVar != null) {
            qtVar.c();
            if (this.z) {
                return;
            }
            ImageView imageView = (ImageView) qtVar.c;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(qtVar.b);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.z = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        qt qtVar = this.f;
        if (qtVar != null) {
            qtVar.t(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        qt qtVar = this.f;
        if (qtVar != null) {
            qtVar.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        k5 k5Var = this.b;
        if (k5Var != null) {
            k5Var.u(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        k5 k5Var = this.b;
        if (k5Var != null) {
            k5Var.v(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        qt qtVar = this.f;
        if (qtVar != null) {
            cb0 cb0Var = (cb0) qtVar.d;
            if (cb0Var == null) {
                cb0Var = new cb0();
                qtVar.d = cb0Var;
            }
            cb0Var.c = colorStateList;
            cb0Var.b = true;
            qtVar.c();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        qt qtVar = this.f;
        if (qtVar != null) {
            cb0 cb0Var = (cb0) qtVar.d;
            if (cb0Var == null) {
                cb0Var = new cb0();
                qtVar.d = cb0Var;
            }
            cb0Var.d = mode;
            cb0Var.a = true;
            qtVar.c();
        }
    }
}
