package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class fb extends EditText implements iv2, me4 {
    public final yc4 A;
    public final k5 b;
    public final jc f;
    public final lb y0;
    public final lb z;
    public eb z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fb(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.editTextStyle);
        je4.a(context);
        id4.a(getContext(), this);
        k5 k5Var = new k5(this);
        this.b = k5Var;
        k5Var.m(attributeSet, R.attr.editTextStyle);
        jc jcVar = new jc(this);
        this.f = jcVar;
        jcVar.f(attributeSet, R.attr.editTextStyle);
        jcVar.b();
        lb lbVar = new lb(9, false);
        lbVar.f = this;
        this.z = lbVar;
        this.A = new yc4();
        lb lbVar2 = new lb(this);
        this.y0 = lbVar2;
        lbVar2.A(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerY = lbVar2.y(keyListener);
        if (keyListenerY == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerY);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }

    private eb getSuperCaller() {
        eb ebVar = this.z0;
        if (ebVar != null) {
            return ebVar;
        }
        eb ebVar2 = new eb(this);
        this.z0 = ebVar2;
        return ebVar2;
    }

    @Override // defpackage.iv2
    public final td0 a(td0 td0Var) {
        return this.A.d(this, td0Var);
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

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        lb lbVar;
        if (Build.VERSION.SDK_INT >= 28 || (lbVar = this.z) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) lbVar.z;
        return textClassifier == null ? cc.a((TextView) lbVar.f) : textClassifier;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        int i;
        String[] strArrH;
        InputConnection l02Var;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f.getClass();
        jc.h(editorInfo, inputConnectionOnCreateInputConnection, this);
        ye.F(editorInfo, inputConnectionOnCreateInputConnection, this);
        if (inputConnectionOnCreateInputConnection != null && (i = Build.VERSION.SDK_INT) <= 30 && (strArrH = wp4.h(this)) != null) {
            e11.b(editorInfo, strArrH);
            jd jdVar = new jd(17, this);
            if (i >= 25) {
                l02Var = new k02(inputConnectionOnCreateInputConnection, jdVar);
            } else if (e11.a(editorInfo).length != 0) {
                l02Var = new l02(inputConnectionOnCreateInputConnection, jdVar);
            }
            inputConnectionOnCreateInputConnection = l02Var;
        }
        return this.y0.B(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        int i = Build.VERSION.SDK_INT;
        boolean zA = false;
        if (i < 31 && i >= 24 && dragEvent.getLocalState() == null && wp4.h(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                zA = ob.a(dragEvent, this, activity);
            }
        }
        if (zA) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        qd0 pd0Var;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31 || wp4.h(this) == null || !(i == 16908322 || i == 16908337)) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i2 >= 31) {
                pd0Var = new pd0(primaryClip, 1);
            } else {
                rd0 rd0Var = new rd0();
                rd0Var.b = primaryClip;
                rd0Var.c = 1;
                pd0Var = rd0Var;
            }
            pd0Var.e(i == 16908322 ? 0 : 1);
            wp4.j(this, pd0Var.build());
        }
        return true;
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

    public void setEmojiCompatEnabled(boolean z) {
        this.y0.K(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.y0.y(keyListener));
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

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        lb lbVar;
        if (Build.VERSION.SDK_INT >= 28 || (lbVar = this.z) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            lbVar.z = textClassifier;
        }
    }
}
