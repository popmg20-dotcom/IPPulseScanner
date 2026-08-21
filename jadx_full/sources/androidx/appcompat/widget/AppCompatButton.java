package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.getsurfboard.R;
import defpackage.fx3;
import defpackage.gb;
import defpackage.id4;
import defpackage.jc;
import defpackage.je4;
import defpackage.k5;
import defpackage.me4;
import defpackage.pr4;
import defpackage.rc;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements me4 {
    public final k5 b;
    public final jc f;
    public gb z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        je4.a(context);
        id4.a(getContext(), this);
        k5 k5Var = new k5(this);
        this.b = k5Var;
        k5Var.m(attributeSet, i);
        jc jcVar = new jc(this);
        this.f = jcVar;
        jcVar.f(attributeSet, i);
        jcVar.b();
        getEmojiTextViewHelper().b(attributeSet, i);
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
    public int getAutoSizeMaxTextSize() {
        if (pr4.c) {
            return super.getAutoSizeMaxTextSize();
        }
        jc jcVar = this.f;
        if (jcVar != null) {
            return Math.round(jcVar.i.e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (pr4.c) {
            return super.getAutoSizeMinTextSize();
        }
        jc jcVar = this.f;
        if (jcVar != null) {
            return Math.round(jcVar.i.d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (pr4.c) {
            return super.getAutoSizeStepGranularity();
        }
        jc jcVar = this.f;
        if (jcVar != null) {
            return Math.round(jcVar.i.c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (pr4.c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        jc jcVar = this.f;
        return jcVar != null ? jcVar.i.f : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (pr4.c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        jc jcVar = this.f;
        if (jcVar != null) {
            return jcVar.i.a;
        }
        return 0;
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

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        jc jcVar = this.f;
        if (jcVar == null || pr4.c) {
            return;
        }
        jcVar.i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        jc jcVar = this.f;
        if (jcVar != null) {
            rc rcVar = jcVar.i;
            if (pr4.c || !rcVar.f()) {
                return;
            }
            rcVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (pr4.c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.i(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (pr4.c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.j(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (pr4.c) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.k(i);
        }
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
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(fx3.Q(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z) {
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.a.setAllCaps(z);
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
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.g(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        boolean z = pr4.c;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        jc jcVar = this.f;
        if (jcVar != null) {
            rc rcVar = jcVar.i;
            if (z || rcVar.f()) {
                return;
            }
            rcVar.g(i, f);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AppCompatButton(Context context) {
        this(context, null);
    }
}
