package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ga4 extends LinearLayout {
    public static final /* synthetic */ int F0 = 0;
    public View A;
    public TextView A0;
    public ImageView B0;
    public Drawable C0;
    public int D0;
    public final /* synthetic */ TabLayout E0;
    public fa4 b;
    public TextView f;
    public pj y0;
    public ImageView z;
    public View z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga4(TabLayout tabLayout, Context context) {
        super(context);
        this.E0 = tabLayout;
        this.D0 = 2;
        e(context);
        setPaddingRelative(tabLayout.y0, tabLayout.z0, tabLayout.A0, tabLayout.B0);
        setGravity(17);
        setOrientation(!tabLayout.X0 ? 1 : 0);
        setClickable(true);
        int i = 18;
        wp4.p(this, Build.VERSION.SDK_INT >= 24 ? new oj1(i, ga5.m(getContext())) : new oj1(i, (Object) null));
    }

    private pj getBadge() {
        return this.y0;
    }

    private pj getOrCreateBadge() {
        if (this.y0 == null) {
            this.y0 = new pj(getContext(), null);
        }
        b();
        pj pjVar = this.y0;
        if (pjVar != null) {
            return pjVar;
        }
        xe.q("Unable to create badge");
        return null;
    }

    public final void a() {
        if (this.y0 != null) {
            setClipChildren(true);
            setClipToPadding(true);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
                viewGroup.setClipToPadding(true);
            }
            View view = this.A;
            if (view != null) {
                pj pjVar = this.y0;
                if (pjVar != null) {
                    if (pjVar.e() != null) {
                        pjVar.e().setForeground(null);
                    } else {
                        view.getOverlay().remove(pjVar);
                    }
                }
                this.A = null;
            }
        }
    }

    public final void b() {
        if (this.y0 != null) {
            if (this.z0 != null) {
                a();
                return;
            }
            TextView textView = this.f;
            if (textView == null || this.b == null) {
                a();
                return;
            }
            if (this.A == textView) {
                c(textView);
                return;
            }
            a();
            TextView textView2 = this.f;
            if (this.y0 == null || textView2 == null) {
                return;
            }
            setClipChildren(false);
            setClipToPadding(false);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(false);
                viewGroup.setClipToPadding(false);
            }
            pj pjVar = this.y0;
            Rect rect = new Rect();
            textView2.getDrawingRect(rect);
            pjVar.setBounds(rect);
            pjVar.j(textView2, null);
            if (pjVar.e() != null) {
                pjVar.e().setForeground(pjVar);
            } else {
                textView2.getOverlay().add(pjVar);
            }
            this.A = textView2;
        }
    }

    public final void c(View view) {
        pj pjVar = this.y0;
        if (pjVar == null || view != this.A) {
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        pjVar.setBounds(rect);
        pjVar.j(view, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d() {
        boolean z;
        f();
        fa4 fa4Var = this.b;
        if (fa4Var == null) {
            z = false;
        } else {
            TabLayout tabLayout = fa4Var.d;
            if (tabLayout == null) {
                xe.k("Tab not attached to a TabLayout");
                return;
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            if (selectedTabPosition != -1 && selectedTabPosition == fa4Var.b) {
                z = true;
            }
        }
        setSelected(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.C0;
        if ((drawable == null || !drawable.isStateful()) ? false : this.C0.setState(drawableState)) {
            invalidate();
            this.E0.invalidate();
        }
    }

    public final void e(Context context) {
        TabLayout tabLayout = this.E0;
        int i = tabLayout.N0;
        if (i != 0) {
            Drawable drawableR = vo.r(context, i);
            this.C0 = drawableR;
            if (drawableR != null && drawableR.isStateful()) {
                this.C0.setState(getDrawableState());
            }
        } else {
            this.C0 = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        Drawable rippleDrawable = gradientDrawable;
        if (tabLayout.H0 != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(1.0E-5f);
            gradientDrawable2.setColor(-1);
            ColorStateList colorStateListA = jl3.a(tabLayout.H0);
            boolean z = tabLayout.b1;
            GradientDrawable gradientDrawable3 = gradientDrawable;
            if (z) {
                gradientDrawable3 = null;
            }
            rippleDrawable = new RippleDrawable(colorStateListA, gradientDrawable3, z ? null : gradientDrawable2);
        }
        setBackground(rippleDrawable);
        tabLayout.invalidate();
    }

    public final void f() {
        int i;
        ViewParent parent;
        fa4 fa4Var = this.b;
        View view = fa4Var != null ? fa4Var.c : null;
        if (view != null) {
            ViewParent parent2 = view.getParent();
            if (parent2 != this) {
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeView(view);
                }
                View view2 = this.z0;
                if (view2 != null && (parent = view2.getParent()) != null) {
                    ((ViewGroup) parent).removeView(this.z0);
                }
                addView(view);
            }
            this.z0 = view;
            TextView textView = this.f;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.z;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.z.setImageDrawable(null);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.text1);
            this.A0 = textView2;
            if (textView2 != null) {
                this.D0 = textView2.getMaxLines();
            }
            this.B0 = (ImageView) view.findViewById(R.id.icon);
        } else {
            View view3 = this.z0;
            if (view3 != null) {
                removeView(view3);
                this.z0 = null;
            }
            this.A0 = null;
            this.B0 = null;
        }
        if (this.z0 == null) {
            if (this.z == null) {
                ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(com.getsurfboard.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                this.z = imageView2;
                addView(imageView2, 0);
            }
            if (this.f == null) {
                TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(com.getsurfboard.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                this.f = textView3;
                addView(textView3);
                this.D0 = this.f.getMaxLines();
            }
            TextView textView4 = this.f;
            TabLayout tabLayout = this.E0;
            textView4.setTextAppearance(tabLayout.C0);
            if (!isSelected() || (i = tabLayout.E0) == -1) {
                this.f.setTextAppearance(tabLayout.D0);
            } else {
                this.f.setTextAppearance(i);
            }
            ColorStateList colorStateList = tabLayout.F0;
            if (colorStateList != null) {
                this.f.setTextColor(colorStateList);
            }
            g(this.f, this.z, true);
            b();
            ImageView imageView3 = this.z;
            if (imageView3 != null) {
                imageView3.addOnLayoutChangeListener(new wh0(this, imageView3));
            }
            TextView textView5 = this.f;
            if (textView5 != null) {
                textView5.addOnLayoutChangeListener(new wh0(this, textView5));
            }
        } else {
            TextView textView6 = this.A0;
            if (textView6 != null || this.B0 != null) {
                g(textView6, this.B0, false);
            }
        }
        if (fa4Var == null || TextUtils.isEmpty(null)) {
            return;
        }
        setContentDescription(null);
    }

    public final void g(TextView textView, ImageView imageView, boolean z) {
        boolean z2;
        fa4 fa4Var = this.b;
        CharSequence charSequence = fa4Var != null ? fa4Var.a : null;
        if (imageView != null) {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        }
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        if (textView != null) {
            if (zIsEmpty) {
                z2 = false;
            } else {
                this.b.getClass();
                z2 = true;
            }
            textView.setText(!zIsEmpty ? charSequence : null);
            textView.setVisibility(z2 ? 0 : 8);
            if (!zIsEmpty) {
                setVisibility(0);
            }
        } else {
            z2 = false;
        }
        if (z && imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            int iY = (z2 && imageView.getVisibility() == 0) ? (int) tj4.y(getContext(), 8) : 0;
            if (this.E0.X0) {
                if (iY != marginLayoutParams.getMarginEnd()) {
                    marginLayoutParams.setMarginEnd(iY);
                    marginLayoutParams.bottomMargin = 0;
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            } else if (iY != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = iY;
                marginLayoutParams.setMarginEnd(0);
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
        }
        if (Build.VERSION.SDK_INT > 23) {
            ye.H(this, zIsEmpty ? null : charSequence);
        }
    }

    public int getContentHeight() {
        View[] viewArr = {this.f, this.z, this.z0};
        int iMax = 0;
        int iMin = 0;
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z ? Math.min(iMin, view.getTop()) : view.getTop();
                iMax = z ? Math.max(iMax, view.getBottom()) : view.getBottom();
                z = true;
            }
        }
        return iMax - iMin;
    }

    public int getContentWidth() {
        View[] viewArr = {this.f, this.z, this.z0};
        int iMax = 0;
        int iMin = 0;
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                z = true;
            }
        }
        return iMax - iMin;
    }

    public fa4 getTab() {
        return this.b;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        pj pjVar = this.y0;
        if (pjVar != null && pjVar.isVisible()) {
            accessibilityNodeInfo.setContentDescription(this.y0.d());
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) o2.a(0, 1, this.b.b, false, 1, isSelected()).a);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) i2.e.a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(com.getsurfboard.R.string.item_view_role_description));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        TabLayout tabLayout = this.E0;
        int tabMaxWidth = tabLayout.getTabMaxWidth();
        if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
            i = View.MeasureSpec.makeMeasureSpec(tabLayout.O0, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f != null) {
            float f = tabLayout.K0;
            if (isSelected() && tabLayout.E0 != -1) {
                f = tabLayout.L0;
            }
            int i3 = this.D0;
            ImageView imageView = this.z;
            if (imageView == null || imageView.getVisibility() != 0) {
                TextView textView = this.f;
                if (textView != null && textView.getLineCount() > 1) {
                    f = tabLayout.M0;
                }
            } else {
                i3 = 1;
            }
            float textSize = this.f.getTextSize();
            int lineCount = this.f.getLineCount();
            int maxLines = this.f.getMaxLines();
            if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                if (tabLayout.W0 == 1 && f > textSize && lineCount == 1) {
                    Layout layout = this.f.getLayout();
                    if (layout == null) {
                        return;
                    }
                    if ((f / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                        return;
                    }
                }
                this.f.setTextSize(0, f);
                this.f.setMaxLines(i3);
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (this.b == null) {
            return zPerformClick;
        }
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        fa4 fa4Var = this.b;
        TabLayout tabLayout = fa4Var.d;
        if (tabLayout != null) {
            tabLayout.g(fa4Var, true);
            return true;
        }
        xe.k("Tab not attached to a TabLayout");
        return false;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        isSelected();
        super.setSelected(z);
        TextView textView = this.f;
        if (textView != null) {
            textView.setSelected(z);
        }
        ImageView imageView = this.z;
        if (imageView != null) {
            imageView.setSelected(z);
        }
        View view = this.z0;
        if (view != null) {
            view.setSelected(z);
        }
    }

    public void setTab(fa4 fa4Var) {
        if (fa4Var != this.b) {
            this.b = fa4Var;
            d();
        }
    }
}
