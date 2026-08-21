package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import defpackage.cc;
import defpackage.dk4;
import defpackage.fx3;
import defpackage.gb;
import defpackage.id4;
import defpackage.jc;
import defpackage.je4;
import defpackage.k5;
import defpackage.kc;
import defpackage.l2;
import defpackage.lb;
import defpackage.lc;
import defpackage.mc;
import defpackage.me4;
import defpackage.n23;
import defpackage.o23;
import defpackage.pr4;
import defpackage.rc;
import defpackage.uf2;
import defpackage.vo;
import defpackage.w7;
import defpackage.xe;
import defpackage.ye;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView implements me4 {
    public gb A;
    public Future A0;
    public final k5 b;
    public final jc f;
    public boolean y0;
    public final lb z;
    public w7 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        je4.a(context);
        this.y0 = false;
        this.z0 = null;
        id4.a(getContext(), this);
        k5 k5Var = new k5(this);
        this.b = k5Var;
        k5Var.m(attributeSet, i);
        jc jcVar = new jc(this);
        this.f = jcVar;
        jcVar.f(attributeSet, i);
        jcVar.b();
        lb lbVar = new lb(9, false);
        lbVar.f = this;
        this.z = lbVar;
        getEmojiTextViewHelper().b(attributeSet, i);
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

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public kc getSuperCaller() {
        w7 w7Var = this.z0;
        if (w7Var != null) {
            return w7Var;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            mc mcVar = new mc(this);
            this.z0 = mcVar;
            return mcVar;
        }
        if (i >= 28) {
            lc lcVar = new lc(this);
            this.z0 = lcVar;
            return lcVar;
        }
        if (i < 26) {
            return w7Var;
        }
        w7 w7Var2 = new w7(8, this);
        this.z0 = w7Var2;
        return w7Var2;
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
    public CharSequence getText() {
        Future future = this.A0;
        if (future != null) {
            try {
                this.A0 = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                fx3.q(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
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

    public n23 getTextMetricsParamsCompat() {
        return fx3.q(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f.getClass();
        jc.h(editorInfo, inputConnectionOnCreateInputConnection, this);
        ye.F(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        jc jcVar = this.f;
        if (jcVar == null || pr4.c) {
            return;
        }
        jcVar.i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Future future = this.A0;
        if (future != null) {
            try {
                this.A0 = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                fx3.q(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
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
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? vo.r(context, i) : null, i2 != 0 ? vo.r(context, i2) : null, i3 != 0 ? vo.r(context, i3) : null, i4 != 0 ? vo.r(context, i4) : null);
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? vo.r(context, i) : null, i2 != 0 ? vo.r(context, i2) : null, i3 != 0 ? vo.r(context, i3) : null, i4 != 0 ? vo.r(context, i4) : null);
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
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().g(i);
        } else {
            fx3.F(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().e(i);
        } else {
            fx3.G(this, i);
        }
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i, float f) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            getSuperCaller().k(i, f);
        } else if (i2 >= 34) {
            l2.m(this, i, f);
        } else {
            fx3.H(this, Math.round(TypedValue.applyDimension(i, f, getResources().getDisplayMetrics())));
        }
    }

    public void setPrecomputedText(o23 o23Var) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        fx3.q(this);
        throw null;
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
    public void setTextClassifier(TextClassifier textClassifier) {
        lb lbVar;
        if (Build.VERSION.SDK_INT >= 28 || (lbVar = this.z) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            lbVar.z = textClassifier;
        }
    }

    public void setTextFuture(Future<o23> future) {
        this.A0 = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(n23 n23Var) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = n23Var.b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i = 7;
            }
        }
        setTextDirection(i);
        getPaint().set(n23Var.a);
        setBreakStrategy(n23Var.c);
        setHyphenationFrequency(n23Var.d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
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

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i) {
        Typeface typefaceCreate;
        if (this.y0) {
            return;
        }
        if (typeface == null || i <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            uf2 uf2Var = dk4.a;
            if (context == null) {
                xe.k("Context cannot be null");
                return;
            }
            typefaceCreate = Typeface.create(typeface, i);
        }
        this.y0 = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.y0 = false;
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        fx3.H(this, i);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        jc jcVar = this.f;
        if (jcVar != null) {
            jcVar.b();
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AppCompatTextView(Context context) {
        this(context, null);
    }
}
