package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.getsurfboard.R;
import defpackage.ad0;
import defpackage.bv4;
import defpackage.ha0;
import defpackage.tj1;
import defpackage.wp4;
import defpackage.xe;
import defpackage.zc3;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    public boolean A;
    public final ArrayList b;
    public final ArrayList f;
    public View.OnApplyWindowInsetsListener z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, u uVar) {
        View view;
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
        this.b = new ArrayList();
        this.f = new ArrayList();
        this.A = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zc3.b, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(0) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        o oVarC = uVar.C(id);
        if (classAttribute != null && oVarC == null) {
            if (id == -1) {
                xe.q(ha0.o("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
                throw null;
            }
            tj1 tj1VarJ = uVar.J();
            context.getClassLoader();
            o oVarA = tj1VarJ.a(classAttribute);
            oVarA.getClass();
            oVarA.mFragmentId = id;
            oVarA.mContainerId = id;
            oVarA.mTag = string;
            oVarA.mFragmentManager = uVar;
            oVarA.mHost = uVar.x;
            oVarA.onInflate(context, attributeSet, (Bundle) null);
            a aVar = new a(uVar);
            aVar.p = true;
            oVarA.mContainer = this;
            oVarA.mInDynamicContainer = true;
            aVar.g(getId(), oVarA, string, 1);
            if (aVar.g) {
                xe.q("This transaction is already being added to the back stack");
                throw null;
            }
            aVar.h = false;
            aVar.r.A(aVar, true);
        }
        for (x xVar : uVar.c.d()) {
            o oVar = xVar.c;
            if (oVar.mContainerId == getId() && (view = oVar.mView) != null && view.getParent() == null) {
                oVar.mContainer = this;
                xVar.b();
                xVar.k();
            }
        }
    }

    public final void a(View view) {
        if (this.f.contains(view)) {
            this.b.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof o ? (o) tag : null) != null) {
            super.addView(view, i, layoutParams);
        } else {
            ad0.j("Views added to a FragmentContainerView must be associated with a Fragment. View ", view, " is not associated with a Fragment.");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        bv4 bv4VarG;
        windowInsets.getClass();
        bv4 bv4VarG2 = bv4.g(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.z;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            windowInsetsOnApplyWindowInsets.getClass();
            bv4VarG = bv4.g(windowInsetsOnApplyWindowInsets, null);
        } else {
            WeakHashMap weakHashMap = wp4.a;
            WindowInsets windowInsetsF = bv4VarG2.f();
            if (windowInsetsF != null && !windowInsetsF.equals(windowInsetsF)) {
                bv4VarG2 = bv4.g(windowInsetsF, this);
            }
            bv4VarG = bv4VarG2;
        }
        if (!bv4VarG.a.r()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                wp4.b(getChildAt(i), bv4VarG);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        canvas.getClass();
        if (this.A) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        canvas.getClass();
        view.getClass();
        if (this.A) {
            ArrayList arrayList = this.b;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        view.getClass();
        this.f.remove(view);
        if (this.b.remove(view)) {
            this.A = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends o> F getFragment() {
        p pVar;
        o oVar;
        u uVarU;
        View view = this;
        while (true) {
            pVar = null;
            if (view == null) {
                oVar = null;
                break;
            }
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            oVar = tag instanceof o ? (o) tag : null;
            if (oVar != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (oVar == null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                if (context instanceof p) {
                    pVar = (p) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (pVar == null) {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
            uVarU = pVar.u();
        } else {
            if (!oVar.isAdded()) {
                throw new IllegalStateException("The Fragment " + oVar + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            uVarU = oVar.getChildFragmentManager();
        }
        return (F) uVarU.C(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        windowInsets.getClass();
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                childAt.getClass();
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        view.getClass();
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        View childAt = getChildAt(i);
        childAt.getClass();
        a(childAt);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        view.getClass();
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            childAt.getClass();
            a(childAt);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            childAt.getClass();
            a(childAt);
        }
        super.removeViewsInLayout(i, i2);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.A = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.z = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        view.getClass();
        if (view.getParent() == this) {
            this.f.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        String str;
        super(context, attributeSet, 0);
        context.getClass();
        this.b = new ArrayList();
        this.f = new ArrayList();
        this.A = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zc3.b, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + StringUtil.DOUBLE_QUOTE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context) {
        super(context);
        context.getClass();
        this.b = new ArrayList();
        this.f = new ArrayList();
        this.A = true;
    }
}
