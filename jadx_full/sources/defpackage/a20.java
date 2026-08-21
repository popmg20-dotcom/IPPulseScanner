package defpackage;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a20 extends PopupWindow {
    public final ue2 a;
    public final Rect b;

    public a20(Context context) {
        super(context, (AttributeSet) null, 0, R.style.Widget.Material.PopupMenu);
        int[] iArr = {R.attr.popupBackground, R.attr.popupElevation, R.attr.listChoiceBackgroundIndicator};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, iArr, R.attr.popupMenuStyle, R.style.Widget.Material.PopupMenu);
        typedArrayObtainStyledAttributes.getClass();
        int iN0 = qe.n0(iArr, R.attr.popupElevation);
        if (!typedArrayObtainStyledAttributes.hasValue(iN0)) {
            xe.k("Attribute not defined in set.");
            throw null;
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(iN0, 0.0f);
        int iN02 = qe.n0(iArr, R.attr.popupBackground);
        if (!typedArrayObtainStyledAttributes.hasValue(iN02)) {
            xe.k("Attribute not defined in set.");
            throw null;
        }
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(iN02);
        drawable.getClass();
        b20 b20Var = new b20(drawable, 0);
        int iN03 = qe.n0(iArr, R.attr.listChoiceBackgroundIndicator);
        if (!typedArrayObtainStyledAttributes.hasValue(iN03)) {
            xe.k("Attribute not defined in set.");
            throw null;
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(iN03, 0);
        ue2 ue2Var = new ue2();
        ue2Var.b = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        this.a = ue2Var;
        this.b = new Rect();
        setFocusable(true);
        setOutsideTouchable(true);
        setInputMethodMode(2);
        setBackgroundDrawable(null);
        setOverlapAnchor(true);
        setElevation(dimension);
        zr1 zr1Var = new zr1(context);
        zr1Var.b = 350L;
        zr1Var.f = new ub1();
        zr1Var.A = new ObjectAnimator();
        zr1Var.setBackground(b20Var);
        zr1Var.setClipToOutline(true);
        setContentView(zr1Var);
    }

    @Override // android.widget.PopupWindow
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zr1 getContentView() {
        View contentView = super.getContentView();
        contentView.getClass();
        return (zr1) contentView;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i, int i2, int i3) {
        view.getClass();
        int width = getWidth();
        Rect rect = this.b;
        setWidth(rect.left + rect.right + width);
        super.showAsDropDown(view, i, i2, i3);
        Object parent = getContentView().getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view2.setPaddingRelative(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View view, int i, int i2, int i3) {
        view.getClass();
        int width = getWidth();
        Rect rect = this.b;
        setWidth(rect.left + rect.right + width);
        super.showAtLocation(view, i, i2, i3);
        Object parent = getContentView().getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view2.setPaddingRelative(rect.left, rect.top, rect.right, rect.bottom);
        }
    }
}
