package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class q10 extends FrameLayout {
    public static final int[] z0 = {R.attr.colorBackground};
    public final Rect A;
    public boolean b;
    public boolean f;
    public final lb y0;
    public final Rect z;

    public q10(Context context, AttributeSet attributeSet) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, com.getsurfboard.R.attr.materialCardViewStyle);
        Rect rect = new Rect();
        this.z = rect;
        this.A = new Rect();
        lb lbVar = new lb(25, (Object) this, false);
        this.y0 = lbVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vc3.a, com.getsurfboard.R.attr.materialCardViewStyle, com.getsurfboard.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(z0);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(com.getsurfboard.R.color.cardview_light_background) : getResources().getColor(com.getsurfboard.R.color.cardview_dark_background));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.b = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.f = typedArrayObtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        yl3 yl3Var = new yl3(colorStateListValueOf, dimension);
        lbVar.f = yl3Var;
        setBackgroundDrawable(yl3Var);
        setClipToOutline(true);
        setElevation(dimension2);
        ji0.U(lbVar, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((yl3) this.y0.f).h;
    }

    public float getCardElevation() {
        return ((q10) this.y0.z).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.z.bottom;
    }

    public int getContentPaddingLeft() {
        return this.z.left;
    }

    public int getContentPaddingRight() {
        return this.z.right;
    }

    public int getContentPaddingTop() {
        return this.z.top;
    }

    public float getMaxCardElevation() {
        return ((yl3) this.y0.f).e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f;
    }

    public float getRadius() {
        return ((yl3) this.y0.f).a;
    }

    public boolean getUseCompatPadding() {
        return this.b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        yl3 yl3Var = (yl3) this.y0.f;
        if (colorStateListValueOf == null) {
            yl3Var.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        yl3Var.h = colorStateListValueOf;
        yl3Var.b.setColor(colorStateListValueOf.getColorForState(yl3Var.getState(), yl3Var.h.getDefaultColor()));
        yl3Var.invalidateSelf();
    }

    public void setCardElevation(float f) {
        ((q10) this.y0.z).setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        ji0.U(this.y0, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f) {
            this.f = z;
            lb lbVar = this.y0;
            ji0.U(lbVar, ((yl3) lbVar.f).e);
        }
    }

    public void setRadius(float f) {
        yl3 yl3Var = (yl3) this.y0.f;
        if (f == yl3Var.a) {
            return;
        }
        yl3Var.a = f;
        yl3Var.b(null);
        yl3Var.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.b != z) {
            this.b = z;
            lb lbVar = this.y0;
            ji0.U(lbVar, ((yl3) lbVar.f).e);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        yl3 yl3Var = (yl3) this.y0.f;
        if (colorStateList == null) {
            yl3Var.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        yl3Var.h = colorStateList;
        yl3Var.b.setColor(colorStateList.getColorForState(yl3Var.getState(), yl3Var.h.getDefaultColor()));
        yl3Var.invalidateSelf();
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
    }
}
