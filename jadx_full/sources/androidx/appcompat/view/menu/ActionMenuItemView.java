package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.cd3;
import defpackage.hl2;
import defpackage.j3;
import defpackage.k3;
import defpackage.mk2;
import defpackage.nk2;
import defpackage.r3;
import defpackage.sk2;
import defpackage.ye;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements hl2, View.OnClickListener, r3 {
    public sk2 B0;
    public CharSequence C0;
    public Drawable D0;
    public mk2 E0;
    public j3 F0;
    public k3 G0;
    public boolean H0;
    public boolean I0;
    public final int J0;
    public int K0;
    public final int L0;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.H0 = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cd3.c, 0, 0);
        this.J0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.L0 = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.K0 = -1;
        setSaveEnabled(false);
    }

    @Override // defpackage.r3
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // defpackage.r3
    public final boolean b() {
        return !TextUtils.isEmpty(getText()) && this.B0.getIcon() == null;
    }

    @Override // defpackage.hl2
    public final void c(sk2 sk2Var) {
        this.B0 = sk2Var;
        setIcon(sk2Var.getIcon());
        setTitle(sk2Var.getTitleCondensed());
        setId(sk2Var.a);
        setVisibility(sk2Var.isVisible() ? 0 : 8);
        setEnabled(sk2Var.isEnabled());
        if (sk2Var.hasSubMenu() && this.F0 == null) {
            this.F0 = new j3(this);
        }
    }

    public final boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480) {
            return (i >= 640 && i2 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // defpackage.hl2
    public sk2 getItemData() {
        return this.B0;
    }

    public final void h() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.C0);
        if (this.D0 != null && ((this.B0.y & 4) != 4 || (!this.H0 && !this.I0))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.C0 : null);
        CharSequence charSequence = this.B0.q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z3 ? null : this.B0.e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.B0.r;
        if (TextUtils.isEmpty(charSequence2)) {
            ye.H(this, z3 ? null : this.B0.e);
        } else {
            ye.H(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        mk2 mk2Var = this.E0;
        if (mk2Var != null) {
            mk2Var.a(this.B0);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.H0 = g();
        h();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i3 = this.K0) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i4 = this.J0;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i4) : i4;
        if (mode != 1073741824 && i4 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, Pow2.MAX_POW2), i2);
        }
        if (!zIsEmpty || this.D0 == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.D0.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        j3 j3Var;
        if (this.B0.hasSubMenu() && (j3Var = this.F0) != null && j3Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z) {
        if (this.I0 != z) {
            this.I0 = z;
            sk2 sk2Var = this.B0;
            if (sk2Var != null) {
                nk2 nk2Var = sk2Var.n;
                nk2Var.k = true;
                nk2Var.r(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.D0 = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.L0;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(mk2 mk2Var) {
        this.E0 = mk2Var;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        this.K0 = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(k3 k3Var) {
        this.G0 = k3Var;
    }

    public void setTitle(CharSequence charSequence) {
        this.C0 = charSequence;
        h();
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }
}
