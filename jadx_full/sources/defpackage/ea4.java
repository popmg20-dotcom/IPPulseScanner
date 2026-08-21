package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ea4 extends LinearLayout {
    public static final /* synthetic */ int z = 0;
    public ValueAnimator b;
    public final /* synthetic */ TabLayout f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ea4(TabLayout tabLayout, Context context) {
        super(context);
        this.f = tabLayout;
        setWillNotDraw(false);
    }

    public final void a(int i) {
        TabLayout tabLayout = this.f;
        if (tabLayout.h1 == 0 || (tabLayout.getTabSelectedIndicator().getBounds().left == -1 && tabLayout.getTabSelectedIndicator().getBounds().right == -1)) {
            View childAt = getChildAt(i);
            p84 p84Var = tabLayout.c1;
            Drawable drawable = tabLayout.I0;
            p84Var.getClass();
            RectF rectFD = p84.d(tabLayout, childAt);
            drawable.setBounds((int) rectFD.left, drawable.getBounds().top, (int) rectFD.right, drawable.getBounds().bottom);
            tabLayout.b = i;
        }
    }

    public final void b(int i) {
        TabLayout tabLayout = this.f;
        Rect bounds = tabLayout.I0.getBounds();
        tabLayout.I0.setBounds(bounds.left, 0, bounds.right, i);
        requestLayout();
    }

    public final void c(View view, View view2, float f) {
        TabLayout tabLayout = this.f;
        if (view == null || view.getWidth() <= 0) {
            Drawable drawable = tabLayout.I0;
            drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.I0.getBounds().bottom);
        } else {
            tabLayout.c1.f(tabLayout, view, view2, f, tabLayout.I0);
        }
        postInvalidateOnAnimation();
    }

    public final void d(int i, int i2, boolean z2) {
        TabLayout tabLayout = this.f;
        if (tabLayout.b == i) {
            return;
        }
        View childAt = getChildAt(tabLayout.getSelectedTabPosition());
        View childAt2 = getChildAt(i);
        if (childAt2 == null) {
            a(tabLayout.getSelectedTabPosition());
            return;
        }
        tabLayout.b = i;
        da4 da4Var = new da4(this, childAt, childAt2);
        if (!z2) {
            this.b.removeAllUpdateListeners();
            this.b.addUpdateListener(da4Var);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.b = valueAnimator;
        valueAnimator.setInterpolator(tabLayout.d1);
        valueAnimator.setDuration(i2);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(da4Var);
        valueAnimator.start();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int height;
        TabLayout tabLayout = this.f;
        int iHeight = tabLayout.I0.getBounds().height();
        if (iHeight < 0) {
            iHeight = tabLayout.I0.getIntrinsicHeight();
        }
        int i = tabLayout.V0;
        if (i == 0) {
            height = getHeight() - iHeight;
            iHeight = getHeight();
        } else if (i != 1) {
            height = 0;
            if (i != 2) {
                iHeight = i != 3 ? 0 : getHeight();
            }
        } else {
            height = (getHeight() - iHeight) / 2;
            iHeight = (getHeight() + iHeight) / 2;
        }
        if (tabLayout.I0.getBounds().width() > 0) {
            Rect bounds = tabLayout.I0.getBounds();
            tabLayout.I0.setBounds(bounds.left, height, bounds.right, iHeight);
            tabLayout.I0.draw(canvas);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        ValueAnimator valueAnimator = this.b;
        TabLayout tabLayout = this.f;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            d(tabLayout.getSelectedTabPosition(), -1, false);
            return;
        }
        int selectedTabPosition = tabLayout.b;
        if (selectedTabPosition == -1) {
            selectedTabPosition = tabLayout.getSelectedTabPosition();
            tabLayout.b = selectedTabPosition;
        }
        a(selectedTabPosition);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.f;
        boolean z2 = true;
        if (tabLayout.T0 == 1 || tabLayout.W0 == 2) {
            int childCount = getChildCount();
            int iMax = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    iMax = Math.max(iMax, childAt.getMeasuredWidth());
                }
            }
            if (iMax <= 0) {
                return;
            }
            if (iMax * childCount <= getMeasuredWidth() - (((int) tj4.y(getContext(), 16)) * 2)) {
                boolean z3 = false;
                for (int i4 = 0; i4 < childCount; i4++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                    if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                        layoutParams.width = iMax;
                        layoutParams.weight = 0.0f;
                        z3 = true;
                    }
                }
                z2 = z3;
            } else {
                tabLayout.T0 = 0;
                tabLayout.i(false);
            }
            if (z2) {
                super.onMeasure(i, i2);
            }
        }
    }
}
