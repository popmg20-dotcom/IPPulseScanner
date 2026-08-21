package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class mb extends RadioButton implements le4, me4 {
    public gb A;
    public final ha b;
    public final k5 f;
    public final jc z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mb(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.radioButtonStyle);
        je4.a(context);
        id4.a(getContext(), this);
        ha haVar = new ha(this, 1);
        this.b = haVar;
        haVar.d(attributeSet, R.attr.radioButtonStyle);
        k5 k5Var = new k5(this);
        this.f = k5Var;
        k5Var.m(attributeSet, R.attr.radioButtonStyle);
        jc jcVar = new jc(this);
        this.z = jcVar;
        jcVar.f(attributeSet, R.attr.radioButtonStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.radioButtonStyle);
    }

    private gb getEmojiTextViewHelper() {
        gb gbVar = this.A;
        if (gbVar != null) {
            return gbVar;
        }
        gb gbVar2 = new gb(this);
        this.A = gbVar2;
        return gbVar2;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        k5 k5Var = this.f;
        if (k5Var != null) {
            k5Var.a();
        }
        jc jcVar = this.z;
        if (jcVar != null) {
            jcVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        k5 k5Var = this.f;
        if (k5Var != null) {
            return k5Var.i();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        k5 k5Var = this.f;
        if (k5Var != null) {
            return k5Var.j();
        }
        return null;
    }

    @Override // defpackage.le4
    public ColorStateList getSupportButtonTintList() {
        ha haVar = this.b;
        if (haVar != null) {
            return (ColorStateList) haVar.b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        ha haVar = this.b;
        if (haVar != null) {
            return (PorterDuff.Mode) haVar.c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.z.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.z.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        k5 k5Var = this.f;
        if (k5Var != null) {
            k5Var.o();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        k5 k5Var = this.f;
        if (k5Var != null) {
            k5Var.p(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        ha haVar = this.b;
        if (haVar != null) {
            if (haVar.f) {
                haVar.f = false;
            } else {
                haVar.f = true;
                haVar.b();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        jc jcVar = this.z;
        if (jcVar != null) {
            jcVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        jc jcVar = this.z;
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
        k5 k5Var = this.f;
        if (k5Var != null) {
            k5Var.u(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        k5 k5Var = this.f;
        if (k5Var != null) {
            k5Var.v(mode);
        }
    }

    @Override // defpackage.le4
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        ha haVar = this.b;
        if (haVar != null) {
            haVar.b = colorStateList;
            haVar.d = true;
            haVar.b();
        }
    }

    @Override // defpackage.le4
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        ha haVar = this.b;
        if (haVar != null) {
            haVar.c = mode;
            haVar.e = true;
            haVar.b();
        }
    }

    @Override // defpackage.me4
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        jc jcVar = this.z;
        jcVar.l(colorStateList);
        jcVar.b();
    }

    @Override // defpackage.me4
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        jc jcVar = this.z;
        jcVar.m(mode);
        jcVar.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(vo.r(getContext(), i));
    }
}
