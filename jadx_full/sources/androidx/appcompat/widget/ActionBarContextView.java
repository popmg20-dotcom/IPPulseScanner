package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.getsurfboard.R;
import defpackage.c3;
import defpackage.cd3;
import defpackage.cr4;
import defpackage.il2;
import defpackage.l3;
import defpackage.nk2;
import defpackage.pr4;
import defpackage.q3;
import defpackage.u3;
import defpackage.v;
import defpackage.vo;
import defpackage.wp4;
import defpackage.xe;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {
    public q3 A;
    public boolean A0;
    public boolean B0;
    public CharSequence C0;
    public CharSequence D0;
    public View E0;
    public View F0;
    public View G0;
    public LinearLayout H0;
    public TextView I0;
    public TextView J0;
    public final int K0;
    public final int L0;
    public boolean M0;
    public final int N0;
    public final v b;
    public final Context f;
    public int y0;
    public ActionMenuView z;
    public cr4 z0;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, R.attr.actionModeStyle);
        this.b = new v(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f = context;
        } else {
            this.f = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cd3.d, R.attr.actionModeStyle, 0);
        setBackground((!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : vo.r(context, resourceId));
        this.K0 = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.L0 = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.y0 = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.N0 = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int f(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    public static int g(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public final void c(u3 u3Var) {
        View view = this.E0;
        int i = 0;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.N0, (ViewGroup) this, false);
            this.E0 = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.E0);
        }
        View viewFindViewById = this.E0.findViewById(R.id.action_mode_close_button);
        this.F0 = viewFindViewById;
        viewFindViewById.setOnClickListener(new c3(i, u3Var));
        nk2 nk2VarC = u3Var.c();
        q3 q3Var = this.A;
        if (q3Var != null) {
            q3Var.g();
            l3 l3Var = q3Var.L0;
            if (l3Var != null && l3Var.b()) {
                l3Var.i.dismiss();
            }
        }
        q3 q3Var2 = new q3(getContext());
        this.A = q3Var2;
        q3Var2.D0 = true;
        q3Var2.E0 = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        nk2VarC.b(this.A, this.f);
        q3 q3Var3 = this.A;
        il2 il2Var = q3Var3.y0;
        if (il2Var == null) {
            il2 il2Var2 = (il2) q3Var3.A.inflate(q3Var3.Y, (ViewGroup) this, false);
            q3Var3.y0 = il2Var2;
            il2Var2.b(q3Var3.z);
            q3Var3.c(true);
        }
        il2 il2Var3 = q3Var3.y0;
        if (il2Var != il2Var3) {
            ((ActionMenuView) il2Var3).setPresenter(q3Var3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) il2Var3;
        this.z = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.z, layoutParams);
    }

    public final void d() {
        if (this.H0 == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.H0 = linearLayout;
            this.I0 = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.J0 = (TextView) this.H0.findViewById(R.id.action_bar_subtitle);
            int i = this.K0;
            if (i != 0) {
                this.I0.setTextAppearance(getContext(), i);
            }
            int i2 = this.L0;
            if (i2 != 0) {
                this.J0.setTextAppearance(getContext(), i2);
            }
        }
        this.I0.setText(this.C0);
        this.J0.setText(this.D0);
        boolean zIsEmpty = TextUtils.isEmpty(this.C0);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.D0);
        this.J0.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.H0.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.H0.getParent() == null) {
            addView(this.H0);
        }
    }

    public final void e() {
        removeAllViews();
        this.G0 = null;
        this.z = null;
        this.A = null;
        View view = this.F0;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.z0 != null ? this.b.b : getVisibility();
    }

    public int getContentHeight() {
        return this.y0;
    }

    public CharSequence getSubtitle() {
        return this.D0;
    }

    public CharSequence getTitle() {
        return this.C0;
    }

    @Override // android.view.View
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i) {
        if (i != getVisibility()) {
            cr4 cr4Var = this.z0;
            if (cr4Var != null) {
                cr4Var.b();
            }
            super.setVisibility(i);
        }
    }

    public final cr4 i(int i, long j) {
        cr4 cr4Var = this.z0;
        if (cr4Var != null) {
            cr4Var.b();
        }
        v vVar = this.b;
        if (i != 0) {
            cr4 cr4VarA = wp4.a(this);
            cr4VarA.a(0.0f);
            cr4VarA.c(j);
            ((ActionBarContextView) vVar.c).z0 = cr4VarA;
            vVar.b = i;
            cr4VarA.d(vVar);
            return cr4VarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        cr4 cr4VarA2 = wp4.a(this);
        cr4VarA2.a(1.0f);
        cr4VarA2.c(j);
        ((ActionBarContextView) vVar.c).z0 = cr4VarA2;
        vVar.b = i;
        cr4VarA2.d(vVar);
        return cr4VarA2;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, cd3.a, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
        q3 q3Var = this.A;
        if (q3Var != null) {
            Configuration configuration2 = q3Var.f.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i2 = configuration2.screenHeightDp;
            q3Var.H0 = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i2 > 720) || (i > 720 && i2 > 960)) ? 5 : (i >= 500 || (i > 640 && i2 > 480) || (i > 480 && i2 > 640)) ? 4 : i >= 360 ? 3 : 2;
            nk2 nk2Var = q3Var.z;
            if (nk2Var != null) {
                nk2Var.r(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q3 q3Var = this.A;
        if (q3Var != null) {
            q3Var.g();
            l3 l3Var = this.A.L0;
            if (l3Var == null || !l3Var.b()) {
                return;
            }
            l3Var.i.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.B0 = false;
        }
        if (!this.B0) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.B0 = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.B0 = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = pr4.a;
        boolean z3 = getLayoutDirection() == 1;
        int paddingRight = z3 ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.E0;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.E0.getLayoutParams();
            int i5 = z3 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = z3 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i7 = z3 ? paddingRight - i5 : paddingRight + i5;
            int iG = g(this.E0, i7, paddingTop, paddingTop2, z3) + i7;
            paddingRight = z3 ? iG - i6 : iG + i6;
        }
        LinearLayout linearLayout = this.H0;
        if (linearLayout != null && this.G0 == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(this.H0, paddingRight, paddingTop, paddingTop2, z3);
        }
        View view2 = this.G0;
        if (view2 != null) {
            g(view2, paddingRight, paddingTop, paddingTop2, z3);
        }
        int paddingLeft = z3 ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.z;
        if (actionMenuView != null) {
            g(actionMenuView, paddingLeft, paddingTop, paddingTop2, !z3);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int i3 = Pow2.MAX_POW2;
        if (mode != 1073741824) {
            xe.q(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
            return;
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            xe.q(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.y0;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i2);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.E0;
        if (view != null) {
            int iF = f(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.E0.getLayoutParams();
            paddingLeft = iF - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.z;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.z, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.H0;
        if (linearLayout != null && this.G0 == null) {
            if (this.M0) {
                this.H0.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.H0.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.H0.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.G0;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i4 = layoutParams.width;
            int i5 = i4 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i4 >= 0) {
                paddingLeft = Math.min(i4, paddingLeft);
            }
            int i6 = layoutParams.height;
            if (i6 == -2) {
                i3 = Integer.MIN_VALUE;
            }
            if (i6 >= 0) {
                iMin = Math.min(i6, iMin);
            }
            this.G0.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(iMin, i3));
        }
        if (this.y0 > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i7) {
                i7 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i7);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.A0 = false;
        }
        if (!this.A0) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.A0 = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.A0 = false;
        return true;
    }

    public void setContentHeight(int i) {
        this.y0 = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.G0;
        if (view2 != null) {
            removeView(view2);
        }
        this.G0 = view;
        if (view != null && (linearLayout = this.H0) != null) {
            removeView(linearLayout);
            this.H0 = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.D0 = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.C0 = charSequence;
        d();
        wp4.o(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.M0) {
            requestLayout();
        }
        this.M0 = z;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }
}
