package defpackage;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.BaselineLayout;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ip2 extends FrameLayout implements lp2 {
    public static final int[] A1 = {R.attr.state_checked};
    public static final t60 B1 = new t60();
    public static final hp2 C1 = new hp2();
    public int A;
    public int A0;
    public float B0;
    public float C0;
    public float D0;
    public float E0;
    public float F0;
    public float G0;
    public int H0;
    public boolean I0;
    public final LinearLayout J0;
    public final LinearLayout K0;
    public final View L0;
    public final FrameLayout M0;
    public final ImageView N0;
    public final BaselineLayout O0;
    public final TextView P0;
    public final TextView Q0;
    public final BaselineLayout R0;
    public final TextView S0;
    public final TextView T0;
    public BaselineLayout U0;
    public int V0;
    public int W0;
    public int X0;
    public int Y0;
    public int Z0;
    public ColorStateList a1;
    public boolean b;
    public boolean b1;
    public sk2 c1;
    public ColorStateList d1;
    public Drawable e1;
    public ColorStateList f;
    public Drawable f1;
    public ValueAnimator g1;
    public t60 h1;
    public float i1;
    public boolean j1;
    public int k1;
    public int l1;
    public int m1;
    public int n1;
    public boolean o1;
    public int p1;
    public int q1;
    public pj r1;
    public int s1;
    public int t1;
    public int u1;
    public boolean v1;
    public boolean w1;
    public boolean x1;
    public int y0;
    public boolean y1;
    public Drawable z;
    public int z0;
    public Rect z1;

    public ip2(Context context) {
        super(context);
        this.b = false;
        this.V0 = -1;
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = 0;
        this.Z0 = 0;
        this.b1 = false;
        this.h1 = B1;
        this.i1 = 0.0f;
        this.j1 = false;
        this.k1 = 0;
        this.l1 = 0;
        this.m1 = -2;
        this.n1 = 0;
        this.o1 = false;
        this.p1 = 0;
        this.q1 = 0;
        this.t1 = 0;
        this.u1 = 49;
        this.v1 = false;
        this.w1 = false;
        this.x1 = false;
        this.y1 = false;
        this.z1 = new Rect();
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.J0 = (LinearLayout) findViewById(com.getsurfboard.R.id.navigation_bar_item_content_container);
        LinearLayout linearLayout = (LinearLayout) findViewById(com.getsurfboard.R.id.navigation_bar_item_inner_content_container);
        this.K0 = linearLayout;
        this.L0 = findViewById(com.getsurfboard.R.id.navigation_bar_item_active_indicator_view);
        this.M0 = (FrameLayout) findViewById(com.getsurfboard.R.id.navigation_bar_item_icon_container);
        this.N0 = (ImageView) findViewById(com.getsurfboard.R.id.navigation_bar_item_icon_view);
        BaselineLayout baselineLayout = (BaselineLayout) findViewById(com.getsurfboard.R.id.navigation_bar_item_labels_group);
        this.O0 = baselineLayout;
        TextView textView = (TextView) findViewById(com.getsurfboard.R.id.navigation_bar_item_small_label_view);
        this.P0 = textView;
        TextView textView2 = (TextView) findViewById(com.getsurfboard.R.id.navigation_bar_item_large_label_view);
        this.Q0 = textView2;
        float dimension = getResources().getDimension(com.getsurfboard.R.dimen.default_navigation_text_size);
        float dimension2 = getResources().getDimension(com.getsurfboard.R.dimen.default_navigation_active_text_size);
        BaselineLayout baselineLayout2 = new BaselineLayout(getContext());
        this.R0 = baselineLayout2;
        baselineLayout2.setVisibility(8);
        this.R0.setDuplicateParentStateEnabled(true);
        this.R0.setMeasurePaddingFromBaseline(this.x1);
        TextView textView3 = new TextView(getContext());
        this.S0 = textView3;
        textView3.setMaxLines(1);
        TextView textView4 = this.S0;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);
        this.S0.setDuplicateParentStateEnabled(true);
        this.S0.setIncludeFontPadding(false);
        this.S0.setGravity(16);
        this.S0.setTextSize(dimension);
        TextView textView5 = new TextView(getContext());
        this.T0 = textView5;
        textView5.setMaxLines(1);
        this.T0.setEllipsize(truncateAt);
        this.T0.setDuplicateParentStateEnabled(true);
        this.T0.setVisibility(4);
        this.T0.setIncludeFontPadding(false);
        this.T0.setGravity(16);
        this.T0.setTextSize(dimension2);
        this.R0.addView(this.S0);
        this.R0.addView(this.T0);
        this.U0 = baselineLayout;
        setBackgroundResource(getItemBackgroundResId());
        this.A = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.y0 = baselineLayout.getPaddingBottom();
        this.z0 = 0;
        this.A0 = 0;
        textView.setImportantForAccessibility(2);
        textView2.setImportantForAccessibility(2);
        this.S0.setImportantForAccessibility(2);
        this.T0.setImportantForAccessibility(2);
        setFocusable(true);
        a();
        this.n1 = getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.m3_navigation_item_expanded_active_indicator_height_default);
        linearLayout.addOnLayoutChangeListener(new r10(2, this));
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i2 = 0; i2 < iIndexOfChild; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof ip2) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    private int getSuggestedIconWidth() {
        pj pjVar = this.r1;
        int minimumWidth = pjVar == null ? 0 : pjVar.getMinimumWidth() - this.r1.X.b.N0.intValue();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.M0.getLayoutParams();
        return Math.max(minimumWidth, layoutParams.rightMargin) + this.N0.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.leftMargin);
    }

    public static void i(View view, int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private void setLabelPivots(TextView textView) {
        textView.setPivotX(textView.getWidth() / 2);
        textView.setPivotY(textView.getBaseline());
    }

    public final void a() {
        float textSize = this.P0.getTextSize();
        float textSize2 = this.Q0.getTextSize();
        this.B0 = textSize - textSize2;
        this.C0 = (textSize2 * 1.0f) / textSize;
        this.D0 = (textSize * 1.0f) / textSize2;
        float textSize3 = this.S0.getTextSize();
        float textSize4 = this.T0.getTextSize();
        this.E0 = textSize3 - textSize4;
        this.F0 = (textSize4 * 1.0f) / textSize3;
        this.G0 = (textSize3 * 1.0f) / textSize4;
    }

    public final void b() {
        Drawable rippleDrawable = this.z;
        RippleDrawable rippleDrawable2 = null;
        boolean z = true;
        if (this.f != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.j1 && getActiveIndicatorDrawable() != null && activeIndicatorDrawable != null) {
                rippleDrawable2 = new RippleDrawable(jl3.c(this.f), null, activeIndicatorDrawable);
                z = false;
            } else if (rippleDrawable == null) {
                rippleDrawable = new RippleDrawable(jl3.a(this.f), null, null);
            }
        }
        FrameLayout frameLayout = this.M0;
        frameLayout.setPadding(0, 0, 0, 0);
        frameLayout.setForeground(rippleDrawable2);
        setBackground(rippleDrawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z);
        }
    }

    @Override // defpackage.hl2
    public final void c(sk2 sk2Var) {
        this.c1 = sk2Var;
        setCheckable(sk2Var.isCheckable());
        setChecked(sk2Var.isChecked());
        setEnabled(sk2Var.isEnabled());
        setIcon(sk2Var.getIcon());
        setTitle(sk2Var.e);
        setId(sk2Var.a);
        if (!TextUtils.isEmpty(sk2Var.q)) {
            setContentDescription(sk2Var.q);
        }
        CharSequence charSequence = !TextUtils.isEmpty(sk2Var.r) ? sk2Var.r : sk2Var.e;
        if (Build.VERSION.SDK_INT > 23) {
            ye.H(this, charSequence);
        }
        l();
        this.b = true;
    }

    public final void d(float f, float f2) {
        t60 t60Var = this.h1;
        t60Var.getClass();
        float fA = t8.a(0.4f, 1.0f, f);
        View view = this.L0;
        view.setScaleX(fA);
        view.setScaleY(t60Var.i(f));
        view.setAlpha(t8.b(0.0f, 1.0f, f2 == 0.0f ? 0.8f : 0.0f, f2 == 0.0f ? 1.0f : 0.2f, f));
        this.i1 = f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.j1) {
            this.M0.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e() {
        int i = this.N0.getLayoutParams().width > 0 ? this.A0 : 0;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.R0.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.rightMargin = getLayoutDirection() == 1 ? i : 0;
            layoutParams.leftMargin = getLayoutDirection() != 1 ? i : 0;
        }
    }

    public final void f(TextView textView, TextView textView2, float f, float f2) {
        i(this.J0, this.s1 == 0 ? (int) (this.A + f2) : 0, 0, this.u1);
        int i = this.s1;
        i(this.K0, i == 0 ? 0 : this.z1.top, i == 0 ? 0 : this.z1.bottom, i == 0 ? 17 : 8388627);
        int i2 = this.y0;
        BaselineLayout baselineLayout = this.O0;
        baselineLayout.setPadding(baselineLayout.getPaddingLeft(), baselineLayout.getPaddingTop(), baselineLayout.getPaddingRight(), i2);
        this.U0.setVisibility(0);
        textView.setScaleX(1.0f);
        textView.setScaleY(1.0f);
        textView.setVisibility(0);
        textView2.setScaleX(f);
        textView2.setScaleY(f);
        textView2.setVisibility(4);
    }

    public final void g() {
        int i = this.A;
        i(this.J0, i, i, this.s1 == 0 ? 17 : this.u1);
        i(this.K0, 0, 0, 17);
        BaselineLayout baselineLayout = this.O0;
        baselineLayout.setPadding(baselineLayout.getPaddingLeft(), baselineLayout.getPaddingTop(), baselineLayout.getPaddingRight(), 0);
        this.U0.setVisibility(8);
    }

    public Drawable getActiveIndicatorDrawable() {
        return this.L0.getBackground();
    }

    public pj getBadge() {
        return this.r1;
    }

    public BaselineLayout getExpandedLabelGroup() {
        return this.R0;
    }

    public int getItemBackgroundResId() {
        return com.getsurfboard.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // defpackage.hl2
    public sk2 getItemData() {
        return this.c1;
    }

    public int getItemDefaultMarginResId() {
        return com.getsurfboard.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.V0;
    }

    public BaselineLayout getLabelGroup() {
        return this.O0;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        LinearLayout linearLayout = this.J0;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        return linearLayout.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        if (this.s1 == 1) {
            LinearLayout linearLayout = this.K0;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            return linearLayout.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
        }
        BaselineLayout baselineLayout = this.O0;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) baselineLayout.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), baselineLayout.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(TextView textView, int i) {
        int iRound;
        if (this.y1) {
            textView.setTextAppearance(i);
            return;
        }
        textView.setTextAppearance(i);
        Context context = textView.getContext();
        if (i == 0) {
            iRound = 0;
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, cd3.x);
            TypedValue typedValue = new TypedValue();
            boolean value = typedArrayObtainStyledAttributes.getValue(0, typedValue);
            typedArrayObtainStyledAttributes.recycle();
            if (value) {
                int complexUnit = typedValue.getComplexUnit();
                int i2 = typedValue.data;
                iRound = complexUnit == 2 ? Math.round(TypedValue.complexToFloat(i2) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(i2, context.getResources().getDisplayMetrics());
            }
        }
        if (iRound != 0) {
            textView.setTextSize(0, iRound);
        }
    }

    public final void j(int i) {
        if (i > 0 || getVisibility() != 0) {
            int iMin = Math.min(this.k1, i - (this.p1 * 2));
            int iMax = this.l1;
            if (this.s1 == 1) {
                int measuredWidth = i - (this.q1 * 2);
                int i2 = this.m1;
                if (i2 != -1) {
                    measuredWidth = i2 == -2 ? this.J0.getMeasuredWidth() : Math.min(i2, measuredWidth);
                }
                iMin = measuredWidth;
                iMax = Math.max(this.n1, this.K0.getMeasuredHeight());
            }
            View view = this.L0;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (this.o1 && this.H0 == 2) {
                iMax = iMin;
            }
            layoutParams.height = iMax;
            layoutParams.width = Math.max(0, iMin);
            view.setLayoutParams(layoutParams);
        }
    }

    public final void k(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        h(textView, i);
        a();
        textView.setMinimumHeight(l72.F(textView.getContext(), i));
        ColorStateList colorStateList = this.a1;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.Q0;
        textView2.setTypeface(textView2.getTypeface(), this.b1 ? 1 : 0);
        TextView textView3 = this.T0;
        textView3.setTypeface(textView3.getTypeface(), this.b1 ? 1 : 0);
    }

    public final void l() {
        sk2 sk2Var = this.c1;
        if (sk2Var != null) {
            setVisibility((!sk2Var.isVisible() || (!this.v1 && this.w1)) ? 8 : 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        sk2 sk2Var = this.c1;
        if (sk2Var != null && sk2Var.isCheckable() && this.c1.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, A1);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        pj pjVar = this.r1;
        if (pjVar != null && pjVar.isVisible()) {
            sk2 sk2Var = this.c1;
            CharSequence charSequence = sk2Var.e;
            if (!TextUtils.isEmpty(sk2Var.q)) {
                charSequence = this.c1.q;
            }
            accessibilityNodeInfo.setContentDescription(((Object) charSequence) + ", " + ((Object) this.r1.d()));
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) o2.a(0, 1, getItemVisiblePosition(), false, 1, isSelected()).a);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) i2.e.a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(com.getsurfboard.R.string.item_view_role_description));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new zv(i, 2, this));
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        this.L0.setBackground(drawable);
        b();
    }

    public void setActiveIndicatorEnabled(boolean z) {
        this.j1 = z;
        b();
        this.L0.setVisibility(z ? 0 : 8);
        requestLayout();
    }

    public void setActiveIndicatorExpandedHeight(int i) {
        this.n1 = i;
        j(getWidth());
    }

    public void setActiveIndicatorExpandedMarginHorizontal(int i) {
        this.q1 = i;
        if (this.s1 == 1) {
            setPadding(i, 0, i, 0);
        }
        j(getWidth());
    }

    public void setActiveIndicatorExpandedPadding(Rect rect) {
        this.z1 = rect;
    }

    public void setActiveIndicatorExpandedWidth(int i) {
        this.m1 = i;
        j(getWidth());
    }

    public void setActiveIndicatorHeight(int i) {
        this.l1 = i;
        j(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i) {
        if (this.z0 != i) {
            this.z0 = i;
            ((LinearLayout.LayoutParams) this.O0.getLayoutParams()).topMargin = i;
            BaselineLayout baselineLayout = this.R0;
            if (baselineLayout.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baselineLayout.getLayoutParams();
                layoutParams.rightMargin = getLayoutDirection() == 1 ? i : 0;
                if (getLayoutDirection() == 1) {
                    i = 0;
                }
                layoutParams.leftMargin = i;
                requestLayout();
            }
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i) {
        this.p1 = i;
        j(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z) {
        this.o1 = z;
    }

    public void setActiveIndicatorWidth(int i) {
        this.k1 = i;
        j(getWidth());
    }

    public void setBadge(pj pjVar) {
        pj pjVar2 = this.r1;
        if (pjVar2 == pjVar) {
            return;
        }
        ImageView imageView = this.N0;
        if (pjVar2 != null && imageView != null) {
            a1.n("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            if (this.r1 != null) {
                setClipChildren(true);
                setClipToPadding(true);
                pj pjVar3 = this.r1;
                if (pjVar3 != null) {
                    if (pjVar3.e() != null) {
                        pjVar3.e().setForeground(null);
                    } else {
                        imageView.getOverlay().remove(pjVar3);
                    }
                }
                this.r1 = null;
            }
        }
        this.r1 = pjVar;
        int i = this.t1;
        rj rjVar = pjVar.X;
        if (rjVar.l != i) {
            rjVar.l = i;
            pjVar.k();
        }
        if (imageView == null || this.r1 == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        pj pjVar4 = this.r1;
        Rect rect = new Rect();
        imageView.getDrawingRect(rect);
        pjVar4.setBounds(rect);
        pjVar4.j(imageView, null);
        if (pjVar4.e() != null) {
            pjVar4.e().setForeground(pjVar4);
        } else {
            imageView.getOverlay().add(pjVar4);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView = this.Q0;
        setLabelPivots(textView);
        TextView textView2 = this.P0;
        setLabelPivots(textView2);
        TextView textView3 = this.T0;
        setLabelPivots(textView3);
        TextView textView4 = this.S0;
        setLabelPivots(textView4);
        float f = z ? 1.0f : 0.0f;
        if (this.j1 && this.b && isAttachedToWindow()) {
            ValueAnimator valueAnimator = this.g1;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.g1 = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.i1, f);
            this.g1 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new gp2(this, f));
            this.g1.setInterpolator(l72.W(getContext(), com.getsurfboard.R.attr.motionEasingEmphasizedInterpolator, t8.b));
            this.g1.setDuration(ek0.C(getContext(), com.getsurfboard.R.attr.motionDurationLong2, getResources().getInteger(com.getsurfboard.R.integer.material_motion_duration_long_1)));
            this.g1.start();
        } else {
            d(f, f);
        }
        float f2 = this.B0;
        float f3 = this.C0;
        float f4 = this.D0;
        if (this.s1 == 1) {
            f2 = this.E0;
            f3 = this.F0;
            f4 = this.G0;
            textView = textView3;
            textView2 = textView4;
        }
        int i = this.H0;
        if (i != -1) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        g();
                    }
                } else if (z) {
                    f(textView, textView2, f3, f2);
                } else {
                    f(textView2, textView, f4, 0.0f);
                }
            } else if (z) {
                f(textView, textView2, f3, 0.0f);
            } else {
                g();
            }
        } else if (this.I0) {
            if (z) {
                f(textView, textView2, f3, 0.0f);
            } else {
                g();
            }
        } else if (z) {
            f(textView, textView2, f3, f2);
        } else {
            f(textView2, textView, f4, 0.0f);
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.P0.setEnabled(z);
        this.Q0.setEnabled(z);
        this.S0.setEnabled(z);
        this.T0.setEnabled(z);
        this.N0.setEnabled(z);
    }

    @Override // defpackage.lp2
    public void setExpanded(boolean z) {
        this.v1 = z;
        l();
    }

    public void setHorizontalTextAppearanceActive(int i) {
        this.Y0 = i;
        if (i == 0) {
            i = this.W0;
        }
        k(this.T0, i);
    }

    public void setHorizontalTextAppearanceInactive(int i) {
        this.Z0 = i;
        if (i == 0) {
            i = this.X0;
        }
        TextView textView = this.S0;
        if (textView == null) {
            return;
        }
        h(textView, i);
        a();
        textView.setMinimumHeight(l72.F(textView.getContext(), i));
        ColorStateList colorStateList = this.a1;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.e1) {
            return;
        }
        this.e1 = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = drawable.mutate();
            this.f1 = drawable;
            ColorStateList colorStateList = this.d1;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }
        this.N0.setImageDrawable(drawable);
    }

    public void setIconLabelHorizontalSpacing(int i) {
        if (this.A0 != i) {
            this.A0 = i;
            e();
            requestLayout();
        }
    }

    public void setIconSize(int i) {
        ImageView imageView = this.N0;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        imageView.setLayoutParams(layoutParams);
        e();
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.d1 = colorStateList;
        if (this.c1 == null || (drawable = this.f1) == null) {
            return;
        }
        drawable.setTintList(colorStateList);
        this.f1.invalidateSelf();
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.z = drawable;
        b();
    }

    public void setItemGravity(int i) {
        this.u1 = i;
        requestLayout();
    }

    public void setItemIconGravity(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.s1 != i) {
            this.s1 = i;
            this.t1 = 0;
            BaselineLayout baselineLayout = this.O0;
            this.U0 = baselineLayout;
            BaselineLayout baselineLayout2 = this.R0;
            LinearLayout linearLayout = this.K0;
            int i8 = 8;
            if (i == 1) {
                if (baselineLayout2.getParent() == null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    linearLayout.addView(baselineLayout2, layoutParams);
                    e();
                }
                Rect rect = this.z1;
                int i9 = rect.left;
                int i10 = rect.right;
                int i11 = rect.top;
                i2 = rect.bottom;
                this.t1 = 1;
                int i12 = this.q1;
                this.U0 = baselineLayout2;
                i6 = i11;
                i5 = i10;
                i4 = i9;
                i3 = i12;
                i7 = 0;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 8;
                i8 = 0;
            }
            baselineLayout.setVisibility(i8);
            baselineLayout2.setVisibility(i7);
            ((FrameLayout.LayoutParams) this.J0.getLayoutParams()).gravity = this.u1;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.leftMargin = i4;
            layoutParams2.rightMargin = i5;
            layoutParams2.topMargin = i6;
            layoutParams2.bottomMargin = i2;
            setPadding(i3, 0, i3, 0);
            j(getWidth());
            b();
        }
    }

    public void setItemPaddingBottom(int i) {
        if (this.y0 != i) {
            this.y0 = i;
            sk2 sk2Var = this.c1;
            if (sk2Var != null) {
                setChecked(sk2Var.isChecked());
            }
        }
    }

    public void setItemPaddingTop(int i) {
        if (this.A != i) {
            this.A = i;
            sk2 sk2Var = this.c1;
            if (sk2Var != null) {
                setChecked(sk2Var.isChecked());
            }
        }
    }

    public void setItemPosition(int i) {
        this.V0 = i;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f = colorStateList;
        b();
    }

    public void setLabelFontScalingEnabled(boolean z) {
        this.y1 = z;
        setTextAppearanceActive(this.W0);
        setTextAppearanceInactive(this.X0);
        setHorizontalTextAppearanceActive(this.Y0);
        setHorizontalTextAppearanceInactive(this.Z0);
    }

    public void setLabelMaxLines(int i) {
        TextView textView = this.P0;
        textView.setMaxLines(i);
        TextView textView2 = this.Q0;
        textView2.setMaxLines(i);
        this.S0.setMaxLines(i);
        this.T0.setMaxLines(i);
        if (Build.VERSION.SDK_INT > 34) {
            textView.setGravity(17);
            textView2.setGravity(17);
        } else if (i > 1) {
            textView.setEllipsize(null);
            textView2.setEllipsize(null);
            textView.setGravity(17);
            textView2.setGravity(17);
        } else {
            textView.setGravity(16);
            textView2.setGravity(16);
        }
        requestLayout();
    }

    public void setLabelVisibilityMode(int i) {
        if (this.H0 != i) {
            this.H0 = i;
            if (this.o1 && i == 2) {
                this.h1 = C1;
            } else {
                this.h1 = B1;
            }
            j(getWidth());
            sk2 sk2Var = this.c1;
            if (sk2Var != null) {
                setChecked(sk2Var.isChecked());
            }
        }
    }

    public void setMeasureBottomPaddingFromLabelBaseline(boolean z) {
        this.x1 = z;
        this.O0.setMeasurePaddingFromBaseline(z);
        this.P0.setIncludeFontPadding(z);
        this.Q0.setIncludeFontPadding(z);
        this.R0.setMeasurePaddingFromBaseline(z);
        this.S0.setIncludeFontPadding(z);
        this.T0.setIncludeFontPadding(z);
        requestLayout();
    }

    @Override // defpackage.lp2
    public void setOnlyShowWhenExpanded(boolean z) {
        this.w1 = z;
        l();
    }

    public void setShifting(boolean z) {
        if (this.I0 != z) {
            this.I0 = z;
            sk2 sk2Var = this.c1;
            if (sk2Var != null) {
                setChecked(sk2Var.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i) {
        this.W0 = i;
        k(this.Q0, i);
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z) {
        this.b1 = z;
        setTextAppearanceActive(this.W0);
        setHorizontalTextAppearanceActive(this.Y0);
        TextView textView = this.Q0;
        textView.setTypeface(textView.getTypeface(), this.b1 ? 1 : 0);
        TextView textView2 = this.T0;
        textView2.setTypeface(textView2.getTypeface(), this.b1 ? 1 : 0);
    }

    public void setTextAppearanceInactive(int i) {
        this.X0 = i;
        TextView textView = this.P0;
        if (textView == null) {
            return;
        }
        h(textView, i);
        a();
        textView.setMinimumHeight(l72.F(textView.getContext(), i));
        ColorStateList colorStateList = this.a1;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.a1 = colorStateList;
        if (colorStateList != null) {
            this.P0.setTextColor(colorStateList);
            this.Q0.setTextColor(colorStateList);
            this.S0.setTextColor(colorStateList);
            this.T0.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.P0.setText(charSequence);
        this.Q0.setText(charSequence);
        this.S0.setText(charSequence);
        this.T0.setText(charSequence);
        sk2 sk2Var = this.c1;
        if (sk2Var == null || TextUtils.isEmpty(sk2Var.q)) {
            setContentDescription(charSequence);
        }
        sk2 sk2Var2 = this.c1;
        if (sk2Var2 != null && !TextUtils.isEmpty(sk2Var2.r)) {
            charSequence = this.c1.r;
        }
        if (Build.VERSION.SDK_INT > 23) {
            ye.H(this, charSequence);
        }
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : getContext().getDrawable(i));
    }
}
