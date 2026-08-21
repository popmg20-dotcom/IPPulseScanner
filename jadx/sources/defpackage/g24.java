package defpackage;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.getsurfboard.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g24 extends LinearLayout {
    public final CheckableImageButton A;
    public int A0;
    public ImageView.ScaleType B0;
    public View.OnLongClickListener C0;
    public boolean D0;
    public final TextInputLayout b;
    public final AppCompatTextView f;
    public ColorStateList y0;
    public CharSequence z;
    public PorterDuff.Mode z0;

    public g24(TextInputLayout textInputLayout, n02 n02Var) {
        super(textInputLayout.getContext());
        this.b = textInputLayout;
        int i = 8;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.A = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f = appCompatTextView;
        if (l72.K(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.C0;
        checkableImageButton.setOnClickListener(null);
        v02.G(checkableImageButton, onLongClickListener);
        this.C0 = null;
        checkableImageButton.setOnLongClickListener(null);
        v02.G(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) n02Var.z;
        if (typedArray.hasValue(70)) {
            this.y0 = l72.q(getContext(), n02Var, 70);
        }
        if (typedArray.hasValue(71)) {
            this.z0 = tj4.V(typedArray.getInt(71, -1), null);
        }
        if (typedArray.hasValue(67)) {
            c(n02Var.o(67));
            if (typedArray.hasValue(66)) {
                b(typedArray.getText(66));
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(65, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(68, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            xe.k("startIconSize cannot be less than 0");
            throw null;
        }
        if (dimensionPixelSize != this.A0) {
            this.A0 = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(69)) {
            ImageView.ScaleType scaleTypeB = v02.b(typedArray.getInt(69, -1));
            this.B0 = scaleTypeB;
            checkableImageButton.setScaleType(scaleTypeB);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        appCompatTextView.setAccessibilityLiveRegion(1);
        appCompatTextView.setTextAppearance(typedArray.getResourceId(61, 0));
        if (typedArray.hasValue(62)) {
            appCompatTextView.setTextColor(n02Var.n(62));
        }
        CharSequence text = typedArray.getText(60);
        this.z = TextUtils.isEmpty(text) ? null : text;
        appCompatTextView.setText(text);
        f();
        addView(checkableImageButton);
        addView(appCompatTextView);
        checkableImageButton.setOnFocusableChangedListener(new o73(i, this));
    }

    public final int a() {
        int marginEnd;
        CheckableImageButton checkableImageButton = this.A;
        if (checkableImageButton.getVisibility() == 0) {
            marginEnd = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            marginEnd = 0;
        }
        return this.f.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void b(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.A;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
            v02.P(checkableImageButton, this.C0, charSequence);
        }
    }

    public final void c(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.A;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.y0;
            PorterDuff.Mode mode = this.z0;
            TextInputLayout textInputLayout = this.b;
            v02.a(textInputLayout, checkableImageButton, colorStateList, mode);
            d(true);
            v02.x(textInputLayout, checkableImageButton, this.y0);
            return;
        }
        d(false);
        View.OnLongClickListener onLongClickListener = this.C0;
        checkableImageButton.setOnClickListener(null);
        v02.G(checkableImageButton, onLongClickListener);
        this.C0 = null;
        checkableImageButton.setOnLongClickListener(null);
        v02.G(checkableImageButton, null);
        b(null);
    }

    public final void d(boolean z) {
        CheckableImageButton checkableImageButton = this.A;
        if ((checkableImageButton.getVisibility() == 0) != z) {
            checkableImageButton.setVisibility(z ? 0 : 8);
            e();
            f();
        }
    }

    public final void e() {
        EditText editText = this.b.y0;
        if (editText == null) {
            return;
        }
        this.f.setPaddingRelative(this.A.getVisibility() == 0 ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void f() {
        int i = (this.z == null || this.D0) ? 8 : 0;
        setVisibility((this.A.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.f.setVisibility(i);
        this.b.s();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        e();
    }
}
