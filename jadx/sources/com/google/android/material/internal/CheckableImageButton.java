package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import defpackage.b40;
import defpackage.c40;
import defpackage.hb;
import defpackage.ol;
import defpackage.wp4;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends hb implements Checkable {
    public static final int[] B0 = {R.attr.state_checked};
    public boolean A;
    public b40 A0;
    public boolean y0;
    public boolean z0;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.getsurfboard.R.attr.imageButtonStyle);
        this.y0 = true;
        this.z0 = true;
        wp4.n(this, new ol(3, this));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.A;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        return this.A ? View.mergeDrawableStates(super.onCreateDrawableState(i + 1), B0) : super.onCreateDrawableState(i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        this.A0 = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c40)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c40 c40Var = (c40) parcelable;
        super.onRestoreInstanceState(c40Var.b);
        setChecked(c40Var.z);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        c40 c40Var = new c40(super.onSaveInstanceState());
        c40Var.z = this.A;
        return c40Var;
    }

    public void setCheckable(boolean z) {
        if (this.y0 != z) {
            this.y0 = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.y0 || this.A == z) {
            return;
        }
        this.A = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        b40 b40Var;
        boolean zIsFocusable = isFocusable();
        super.setFocusable(z);
        if (zIsFocusable == z || (b40Var = this.A0) == null) {
            return;
        }
        b40Var.g();
    }

    public void setOnFocusableChangedListener(b40 b40Var) {
        this.A0 = b40Var;
    }

    public void setPressable(boolean z) {
        this.z0 = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.z0) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.A);
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }
}
