package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class da extends AutoCompleteTextView implements me4 {
    public static final int[] A = {R.attr.popupBackground};
    public final k5 b;
    public final jc f;
    public final lb z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public da(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.getsurfboard.R.attr.autoCompleteTextViewStyle);
        je4.a(context);
        id4.a(getContext(), this);
        n02 n02VarY = n02.y(getContext(), attributeSet, A, com.getsurfboard.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) n02VarY.z).hasValue(0)) {
            setDropDownBackgroundDrawable(n02VarY.o(0));
        }
        n02VarY.K();
        k5 k5Var = new k5(this);
        this.b = k5Var;
        k5Var.m(attributeSet, com.getsurfboard.R.attr.autoCompleteTextViewStyle);
        jc jcVar = new jc(this);
        this.f = jcVar;
        jcVar.f(attributeSet, com.getsurfboard.R.attr.autoCompleteTextViewStyle);
        jcVar.b();
        lb lbVar = new lb(this);
        this.z = lbVar;
        lbVar.A(attributeSet, com.getsurfboard.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerY = lbVar.y(keyListener);
        if (keyListenerY == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerY);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }

    @Override // android.widget.TextView, android.view.View
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

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return fx3.P(super.getCustomSelectionActionModeCallback());
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

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        ye.F(editorInfo, inputConnectionOnCreateInputConnection, this);
        return this.z.B(inputConnectionOnCreateInputConnection, editorInfo);
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(fx3.Q(callback, this));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(vo.r(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.z.K(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.z.y(keyListener));
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

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.g(context, i);
        }
    }
}
