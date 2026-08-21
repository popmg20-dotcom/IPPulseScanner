package defpackage;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.getsurfboard.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x41 extends LinearLayout {
    public ColorStateList A;
    public final CheckableImageButton A0;
    public final w41 B0;
    public int C0;
    public final LinkedHashSet D0;
    public ColorStateList E0;
    public PorterDuff.Mode F0;
    public int G0;
    public ImageView.ScaleType H0;
    public View.OnLongClickListener I0;
    public CharSequence J0;
    public final AppCompatTextView K0;
    public boolean L0;
    public EditText M0;
    public final AccessibilityManager N0;
    public AccessibilityManager.TouchExplorationStateChangeListener O0;
    public final u41 P0;
    public final TextInputLayout b;
    public final FrameLayout f;
    public PorterDuff.Mode y0;
    public final CheckableImageButton z;
    public View.OnLongClickListener z0;

    public x41(TextInputLayout textInputLayout, n02 n02Var) {
        super(textInputLayout.getContext());
        final int i = 0;
        this.C0 = 0;
        this.D0 = new LinkedHashSet();
        this.P0 = new u41(i, this);
        v41 v41Var = new v41(this);
        this.N0 = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.b = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflaterFrom.inflate(R.layout.design_text_input_end_icon, (ViewGroup) this, false);
        checkableImageButton.setId(R.id.text_input_error_icon);
        if (l72.K(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        this.z = checkableImageButton;
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) layoutInflaterFrom.inflate(R.layout.design_text_input_end_icon, (ViewGroup) frameLayout, false);
        checkableImageButton2.setId(R.id.text_input_end_icon);
        if (l72.K(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams()).setMarginStart(0);
        }
        this.A0 = checkableImageButton2;
        this.B0 = new w41(this, n02Var);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.K0 = appCompatTextView;
        TypedArray typedArray = (TypedArray) n02Var.z;
        if (typedArray.hasValue(38)) {
            this.A = l72.q(getContext(), n02Var, 38);
        }
        if (typedArray.hasValue(39)) {
            this.y0 = tj4.V(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            i(n02Var.o(37));
        }
        checkableImageButton.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        checkableImageButton.setImportantForAccessibility(2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setCheckable(false);
        checkableImageButton.setFocusable(false);
        if (!typedArray.hasValue(54)) {
            if (typedArray.hasValue(32)) {
                this.E0 = l72.q(getContext(), n02Var, 32);
            }
            if (typedArray.hasValue(33)) {
                this.F0 = tj4.V(typedArray.getInt(33, -1), null);
            }
        }
        final int i2 = 1;
        if (typedArray.hasValue(30)) {
            g(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27)) {
                f(typedArray.getText(27));
            }
            checkableImageButton2.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(54)) {
            if (typedArray.hasValue(55)) {
                this.E0 = l72.q(getContext(), n02Var, 55);
            }
            if (typedArray.hasValue(56)) {
                this.F0 = tj4.V(typedArray.getInt(56, -1), null);
            }
            g(typedArray.getBoolean(54, false) ? 1 : 0);
            f(typedArray.getText(52));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            xe.k("endIconSize cannot be less than 0");
            throw null;
        }
        if (dimensionPixelSize != this.G0) {
            this.G0 = dimensionPixelSize;
            checkableImageButton2.setMinimumWidth(dimensionPixelSize);
            checkableImageButton2.setMinimumHeight(dimensionPixelSize);
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(31)) {
            ImageView.ScaleType scaleTypeB = v02.b(typedArray.getInt(31, -1));
            this.H0 = scaleTypeB;
            checkableImageButton2.setScaleType(scaleTypeB);
            checkableImageButton.setScaleType(scaleTypeB);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        appCompatTextView.setAccessibilityLiveRegion(1);
        appCompatTextView.setTextAppearance(typedArray.getResourceId(73, 0));
        if (typedArray.hasValue(74)) {
            appCompatTextView.setTextColor(n02Var.n(74));
        }
        CharSequence text = typedArray.getText(72);
        this.J0 = TextUtils.isEmpty(text) ? null : text;
        appCompatTextView.setText(text);
        n();
        frameLayout.addView(checkableImageButton2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButton);
        checkableImageButton.setOnFocusableChangedListener(new b40(this) { // from class: t41
            public final /* synthetic */ x41 f;

            {
                this.f = this;
            }

            @Override // defpackage.b40
            public final void g() {
                int i3 = i;
                x41 x41Var = this.f;
                switch (i3) {
                    case 0:
                        CheckableImageButton checkableImageButton3 = x41Var.z;
                        v02.P(checkableImageButton3, x41Var.z0, checkableImageButton3.getContentDescription());
                        break;
                    default:
                        CheckableImageButton checkableImageButton4 = x41Var.A0;
                        v02.P(checkableImageButton4, x41Var.I0, checkableImageButton4.getContentDescription());
                        break;
                }
            }
        });
        checkableImageButton2.setOnFocusableChangedListener(new b40(this) { // from class: t41
            public final /* synthetic */ x41 f;

            {
                this.f = this;
            }

            @Override // defpackage.b40
            public final void g() {
                int i3 = i2;
                x41 x41Var = this.f;
                switch (i3) {
                    case 0:
                        CheckableImageButton checkableImageButton3 = x41Var.z;
                        v02.P(checkableImageButton3, x41Var.z0, checkableImageButton3.getContentDescription());
                        break;
                    default:
                        CheckableImageButton checkableImageButton4 = x41Var.A0;
                        v02.P(checkableImageButton4, x41Var.I0, checkableImageButton4.getContentDescription());
                        break;
                }
            }
        });
        textInputLayout.w1.add(v41Var);
        if (textInputLayout.y0 != null) {
            v41Var.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new c20(i2, this));
    }

    public final y41 a() {
        y41 sg0Var;
        int i = this.C0;
        w41 w41Var = this.B0;
        SparseArray sparseArray = (SparseArray) w41Var.c;
        y41 y41Var = (y41) sparseArray.get(i);
        if (y41Var != null) {
            return y41Var;
        }
        x41 x41Var = (x41) w41Var.d;
        if (i != -1) {
            int i2 = 1;
            if (i == 0) {
                sg0Var = new sg0(x41Var, i2);
            } else if (i == 1) {
                sg0Var = new t03(x41Var, w41Var.b);
            } else if (i == 2) {
                sg0Var = new v50(x41Var);
            } else {
                if (i != 3) {
                    xe.k(dw2.A(i, "Invalid end icon mode: "));
                    return null;
                }
                sg0Var = new uy0(x41Var);
            }
        } else {
            sg0Var = new sg0(x41Var, 0);
        }
        sparseArray.append(i, sg0Var);
        return sg0Var;
    }

    public final int b() {
        int marginStart;
        if (c() || d()) {
            CheckableImageButton checkableImageButton = this.A0;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        return this.K0.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean c() {
        return this.f.getVisibility() == 0 && this.A0.getVisibility() == 0;
    }

    public final boolean d() {
        return this.z.getVisibility() == 0;
    }

    public final void e(boolean z) {
        boolean z2;
        boolean zIsActivated;
        boolean z3;
        y41 y41VarA = a();
        boolean zJ = y41VarA.j();
        CheckableImageButton checkableImageButton = this.A0;
        boolean z4 = true;
        if (!zJ || (z3 = checkableImageButton.A) == y41VarA.k()) {
            z2 = false;
        } else {
            checkableImageButton.setChecked(!z3);
            z2 = true;
        }
        if (!(y41VarA instanceof uy0) || (zIsActivated = checkableImageButton.isActivated()) == ((uy0) y41VarA).l) {
            z4 = z2;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z || z4) {
            v02.x(this.b, checkableImageButton, this.E0);
        }
    }

    public final void f(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.A0;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
            v02.P(checkableImageButton, this.I0, charSequence);
        }
    }

    public final void g(int i) {
        if (this.C0 == i) {
            return;
        }
        y41 y41VarA = a();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.O0;
        AccessibilityManager accessibilityManager = this.N0;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        this.O0 = null;
        y41VarA.r();
        this.C0 = i;
        Iterator it = this.D0.iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        h(i != 0);
        y41 y41VarA2 = a();
        int iD = this.B0.a;
        if (iD == 0) {
            iD = y41VarA2.d();
        }
        Drawable drawableR = iD != 0 ? vo.r(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.A0;
        checkableImageButton.setImageDrawable(drawableR);
        TextInputLayout textInputLayout = this.b;
        if (drawableR != null) {
            v02.a(textInputLayout, checkableImageButton, this.E0, this.F0);
            v02.x(textInputLayout, checkableImageButton, this.E0);
        }
        checkableImageButton.setCheckable(y41VarA2.j());
        if (!y41VarA2.i(textInputLayout.getBoxBackgroundMode())) {
            s53.e(textInputLayout.getBoxBackgroundMode(), i, " is not supported by the end icon mode ", "The current box background mode ");
            return;
        }
        y41VarA2.q();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListenerH = y41VarA2.h();
        this.O0 = touchExplorationStateChangeListenerH;
        if (touchExplorationStateChangeListenerH != null && accessibilityManager != null && isAttachedToWindow()) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.O0);
        }
        View.OnClickListener onClickListenerF = y41VarA2.f();
        View.OnLongClickListener onLongClickListener = this.I0;
        checkableImageButton.setOnClickListener(onClickListenerF);
        v02.G(checkableImageButton, onLongClickListener);
        int iC = y41VarA2.c();
        f(iC != 0 ? getResources().getText(iC) : null);
        EditText editText = this.M0;
        if (editText != null) {
            y41VarA2.l(editText);
            j(y41VarA2);
        }
        v02.a(textInputLayout, checkableImageButton, this.E0, this.F0);
        e(true);
    }

    public final void h(boolean z) {
        if (c() != z) {
            this.A0.setVisibility(z ? 0 : 8);
            k();
            m();
            this.b.s();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.z;
        checkableImageButton.setImageDrawable(drawable);
        l();
        v02.a(this.b, checkableImageButton, this.A, this.y0);
    }

    public final void j(y41 y41Var) {
        if (this.M0 == null) {
            return;
        }
        if (y41Var.e() != null) {
            this.M0.setOnFocusChangeListener(y41Var.e());
        }
        if (y41Var.g() != null) {
            this.A0.setOnFocusChangeListener(y41Var.g());
        }
    }

    public final void k() {
        this.f.setVisibility((this.A0.getVisibility() != 0 || d()) ? 8 : 0);
        setVisibility((c() || d() || ((this.J0 == null || this.L0) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.z;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.b;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.E0.q && textInputLayout.o()) ? 0 : 8);
        k();
        m();
        if (this.C0 != 0) {
            return;
        }
        textInputLayout.s();
    }

    public final void m() {
        TextInputLayout textInputLayout = this.b;
        if (textInputLayout.y0 == null) {
            return;
        }
        this.K0.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.y0.getPaddingTop(), (c() || d()) ? 0 : textInputLayout.y0.getPaddingEnd(), textInputLayout.y0.getPaddingBottom());
    }

    public final void n() {
        AppCompatTextView appCompatTextView = this.K0;
        int visibility = appCompatTextView.getVisibility();
        int i = (this.J0 == null || this.L0) ? 8 : 0;
        if (visibility != i) {
            a().o(i == 0);
        }
        k();
        appCompatTextView.setVisibility(i);
        this.b.s();
    }
}
