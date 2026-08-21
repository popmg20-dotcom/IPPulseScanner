package com.getsurfboard.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import defpackage.bv4;
import defpackage.wp4;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
    }

    @Override // defpackage.kr1, defpackage.qe0
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        Object next;
        bv4 lastWindowInsets;
        int i4 = view.getLayoutParams().height;
        if (i4 != -2 && i4 != -1) {
            return false;
        }
        ArrayList arrayListK = coordinatorLayout.k(view);
        arrayListK.getClass();
        Iterator it = arrayListK.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((View) next) instanceof AppBarLayout) {
                break;
            }
        }
        View view2 = (View) next;
        if (view2 == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size > 0) {
            WeakHashMap weakHashMap = wp4.a;
            if (view2.getFitsSystemWindows() && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.a() + lastWindowInsets.d();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        int totalScrollRange = ((view2 instanceof AppBarLayout ? ((AppBarLayout) view2).getTotalScrollRange() : view2.getMeasuredHeight()) + size) - view2.getMeasuredHeight();
        if (totalScrollRange >= 0) {
            size = totalScrollRange;
        }
        coordinatorLayout.r(view, i, i2, View.MeasureSpec.makeMeasureSpec(size, i4 == -1 ? Pow2.MAX_POW2 : Integer.MIN_VALUE));
        return true;
    }
}
