package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import com.getsurfboard.R;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fo extends mp2 {
    public final int s1;
    public final int t1;
    public final int u1;
    public final int v1;
    public boolean w1;
    public final ArrayList x1;

    public fo(Context context) {
        super(context);
        this.x1 = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.s1 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.t1 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.u1 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.v1 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // defpackage.mp2
    public final ip2 f(Context context) {
        return new eo(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (getLayoutDirection() == 1) {
                    int i8 = i5 - measuredWidth;
                    childAt.layout(i8 - childAt.getMeasuredWidth(), 0, i8, i6);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i6);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int iMax;
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        int childCount = getChildCount();
        ArrayList arrayList = this.x1;
        arrayList.clear();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE);
        int i6 = 0;
        if (getItemIconGravity() == 0) {
            boolean zG = mp2.g(getLabelVisibilityMode(), currentVisibleContentItemCount);
            int i7 = this.u1;
            if (zG && this.w1) {
                View childAt = getChildAt(getSelectedItemPosition());
                int visibility = childAt.getVisibility();
                int iMax2 = this.v1;
                if (visibility != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE), iMakeMeasureSpec);
                    iMax2 = Math.max(iMax2, childAt.getMeasuredWidth());
                }
                int i8 = currentVisibleContentItemCount - (childAt.getVisibility() != 8 ? 1 : 0);
                int iMin = Math.min(size - (this.t1 * i8), Math.min(iMax2, i7));
                int i9 = size - iMin;
                int iMin2 = Math.min(i9 / (i8 != 0 ? i8 : 1), this.s1);
                int i10 = i9 - (i8 * iMin2);
                int i11 = 0;
                while (i11 < childCount) {
                    if (getChildAt(i11).getVisibility() != 8) {
                        i5 = i11 == getSelectedItemPosition() ? iMin : iMin2;
                        if (i10 > 0) {
                            i5++;
                            i10--;
                        }
                    } else {
                        i5 = 0;
                    }
                    arrayList.add(Integer.valueOf(i5));
                    i11++;
                }
            } else {
                int iMin3 = Math.min(size / (currentVisibleContentItemCount != 0 ? currentVisibleContentItemCount : 1), i7);
                int i12 = size - (currentVisibleContentItemCount * iMin3);
                for (int i13 = 0; i13 < childCount; i13++) {
                    if (getChildAt(i13).getVisibility() == 8) {
                        i4 = 0;
                    } else if (i12 > 0) {
                        i4 = iMin3 + 1;
                        i12--;
                    } else {
                        i4 = iMin3;
                    }
                    arrayList.add(Integer.valueOf(i4));
                }
            }
            i3 = 0;
            iMax = 0;
            while (i6 < childCount) {
                View childAt2 = getChildAt(i6);
                if (childAt2.getVisibility() != 8) {
                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(((Integer) arrayList.get(i6)).intValue(), Pow2.MAX_POW2), iMakeMeasureSpec);
                    childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                    int measuredWidth = childAt2.getMeasuredWidth() + i3;
                    iMax = Math.max(iMax, childAt2.getMeasuredHeight());
                    i3 = measuredWidth;
                }
                i6++;
            }
        } else {
            if (currentVisibleContentItemCount == 0) {
                currentVisibleContentItemCount = 1;
            }
            float f = size;
            float fMin = Math.min((currentVisibleContentItemCount + 3) / 10.0f, 0.9f) * f;
            float f2 = currentVisibleContentItemCount;
            int iRound = Math.round(fMin / f2);
            int iRound2 = Math.round(f / f2);
            int i14 = 0;
            int iMax3 = 0;
            while (i6 < childCount) {
                View childAt3 = getChildAt(i6);
                if (childAt3.getVisibility() != 8) {
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(iRound2, Integer.MIN_VALUE), iMakeMeasureSpec);
                    if (childAt3.getMeasuredWidth() < iRound) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(iRound, Pow2.MAX_POW2), iMakeMeasureSpec);
                    }
                    int measuredWidth2 = childAt3.getMeasuredWidth() + i14;
                    iMax3 = Math.max(iMax3, childAt3.getMeasuredHeight());
                    i14 = measuredWidth2;
                }
                i6++;
            }
            i3 = i14;
            iMax = iMax3;
        }
        setMeasuredDimension(i3, Math.max(iMax, getSuggestedMinimumHeight()));
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.w1 = z;
    }
}
