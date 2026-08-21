package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import defpackage.cr4;
import defpackage.l3;
import defpackage.mf4;
import defpackage.nk2;
import defpackage.od0;
import defpackage.q3;
import defpackage.w7;
import defpackage.za;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    public TypedValue A;
    public final Rect A0;
    public od0 B0;
    public TypedValue b;
    public TypedValue f;
    public TypedValue y0;
    public TypedValue z;
    public TypedValue z0;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.A0 = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        TypedValue typedValue = this.y0;
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        this.y0 = typedValue2;
        return typedValue2;
    }

    public TypedValue getFixedHeightMinor() {
        TypedValue typedValue = this.z0;
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        this.z0 = typedValue2;
        return typedValue2;
    }

    public TypedValue getFixedWidthMajor() {
        TypedValue typedValue = this.z;
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        this.z = typedValue2;
        return typedValue2;
    }

    public TypedValue getFixedWidthMinor() {
        TypedValue typedValue = this.A;
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        this.A = typedValue2;
        return typedValue2;
    }

    public TypedValue getMinWidthMajor() {
        TypedValue typedValue = this.b;
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        this.b = typedValue2;
        return typedValue2;
    }

    public TypedValue getMinWidthMinor() {
        TypedValue typedValue = this.f;
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        this.f = typedValue2;
        return typedValue2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        od0 od0Var = this.B0;
        if (od0Var != null) {
            od0Var.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        q3 q3Var;
        super.onDetachedFromWindow();
        od0 od0Var = this.B0;
        if (od0Var != null) {
            za zaVar = (za) ((w7) od0Var).f;
            ActionBarOverlayLayout actionBarOverlayLayout = zaVar.H0;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.k();
                ActionMenuView actionMenuView = ((mf4) actionBarOverlayLayout.y0).a.b;
                if (actionMenuView != null && (q3Var = actionMenuView.N0) != null) {
                    q3Var.g();
                    l3 l3Var = q3Var.L0;
                    if (l3Var != null && l3Var.b()) {
                        l3Var.i.dismiss();
                    }
                }
            }
            if (zaVar.M0 != null) {
                zaVar.C0.getDecorView().removeCallbacks(zaVar.N0);
                if (zaVar.M0.isShowing()) {
                    try {
                        zaVar.M0.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                zaVar.M0 = null;
            }
            cr4 cr4Var = zaVar.O0;
            if (cr4Var != null) {
                cr4Var.b();
            }
            nk2 nk2Var = zaVar.D(0).h;
            if (nk2Var != null) {
                nk2Var.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(od0 od0Var) {
        this.B0 = od0Var;
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }
}
