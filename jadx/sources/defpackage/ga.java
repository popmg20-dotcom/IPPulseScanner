package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ga extends CheckedTextView implements me4 {
    public gb A;
    public final ha b;
    public final k5 f;
    public final jc z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        je4.a(context);
        id4.a(getContext(), this);
        jc jcVar = new jc(this);
        this.z = jcVar;
        jcVar.f(attributeSet, R.attr.checkedTextViewStyle);
        jcVar.b();
        k5 k5Var = new k5(this);
        this.f = k5Var;
        k5Var.m(attributeSet, R.attr.checkedTextViewStyle);
        this.b = new ha(this, 0);
        Context context2 = getContext();
        int[] iArr = cd3.l;
        n02 n02VarY = n02.y(context2, attributeSet, iArr, R.attr.checkedTextViewStyle);
        TypedArray typedArray = (TypedArray) n02VarY.z;
        wp4.m(this, getContext(), iArr, attributeSet, (TypedArray) n02VarY.z, R.attr.checkedTextViewStyle);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(vo.r(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        setCheckMarkDrawable(vo.r(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(vo.r(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(n02VarY.n(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(tx0.c(typedArray.getInt(3, -1), null));
            }
            n02VarY.K();
            getEmojiTextViewHelper().b(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            n02VarY.K();
            throw th;
        }
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

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        jc jcVar = this.z;
        if (jcVar != null) {
            jcVar.b();
        }
        k5 k5Var = this.f;
        if (k5Var != null) {
            k5Var.a();
        }
        ha haVar = this.b;
        if (haVar != null) {
            haVar.c();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return fx3.P(super.getCustomSelectionActionModeCallback());
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

    public ColorStateList getSupportCheckMarkTintList() {
        ha haVar = this.b;
        if (haVar != null) {
            return (ColorStateList) haVar.b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
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

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        ye.F(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
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

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        ha haVar = this.b;
        if (haVar != null) {
            if (haVar.f) {
                haVar.f = false;
            } else {
                haVar.f = true;
                haVar.c();
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(fx3.Q(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
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

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        ha haVar = this.b;
        if (haVar != null) {
            haVar.b = colorStateList;
            haVar.d = true;
            haVar.c();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        ha haVar = this.b;
        if (haVar != null) {
            haVar.c = mode;
            haVar.e = true;
            haVar.c();
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

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        jc jcVar = this.z;
        if (jcVar != null) {
            jcVar.g(context, i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(vo.r(getContext(), i));
    }
}
