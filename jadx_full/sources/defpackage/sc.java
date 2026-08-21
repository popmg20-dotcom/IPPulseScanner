package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sc extends ToggleButton implements me4 {
    public final k5 b;
    public final jc f;
    public gb z;

    public sc(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        id4.a(getContext(), this);
        k5 k5Var = new k5(this);
        this.b = k5Var;
        k5Var.m(attributeSet, R.attr.buttonStyleToggle);
        jc jcVar = new jc(this);
        this.f = jcVar;
        jcVar.f(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.buttonStyleToggle);
    }

    private gb getEmojiTextViewHelper() {
        gb gbVar = this.z;
        if (gbVar != null) {
            return gbVar;
        }
        gb gbVar2 = new gb(this);
        this.z = gbVar2;
        return gbVar2;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        k5 k5Var = this.b;
        if (k5Var != null) {
            k5Var.a();
        }
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.b();
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

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.ToggleButton, android.view.View
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

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
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

    @Override // defpackage.me4
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        jc jcVar = this.f;
        jcVar.l(colorStateList);
        jcVar.b();
    }

    @Override // defpackage.me4
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        jc jcVar = this.f;
        jcVar.m(mode);
        jcVar.b();
    }
}
