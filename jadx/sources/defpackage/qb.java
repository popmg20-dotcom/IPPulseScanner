package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qb extends lb {
    public PorterDuff.Mode A0;
    public boolean B0;
    public boolean C0;
    public final pb Z;
    public Drawable y0;
    public ColorStateList z0;

    public qb(pb pbVar) {
        super(0, pbVar);
        this.z0 = null;
        this.A0 = null;
        this.B0 = false;
        this.C0 = false;
        this.Z = pbVar;
    }

    @Override // defpackage.lb
    public final void A(AttributeSet attributeSet, int i) {
        super.A(attributeSet, R.attr.seekBarStyle);
        pb pbVar = this.Z;
        Context context = pbVar.getContext();
        int[] iArr = cd3.g;
        n02 n02VarY = n02.y(context, attributeSet, iArr, R.attr.seekBarStyle);
        TypedArray typedArray = (TypedArray) n02VarY.z;
        wp4.m(pbVar, pbVar.getContext(), iArr, attributeSet, (TypedArray) n02VarY.z, R.attr.seekBarStyle);
        Drawable drawableP = n02VarY.p(0);
        if (drawableP != null) {
            pbVar.setThumb(drawableP);
        }
        Drawable drawableO = n02VarY.o(1);
        Drawable drawable = this.y0;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.y0 = drawableO;
        if (drawableO != null) {
            drawableO.setCallback(pbVar);
            drawableO.setLayoutDirection(pbVar.getLayoutDirection());
            if (drawableO.isStateful()) {
                drawableO.setState(pbVar.getDrawableState());
            }
            T();
        }
        pbVar.invalidate();
        if (typedArray.hasValue(3)) {
            this.A0 = tx0.c(typedArray.getInt(3, -1), this.A0);
            this.C0 = true;
        }
        if (typedArray.hasValue(2)) {
            this.z0 = n02VarY.n(2);
            this.B0 = true;
        }
        n02VarY.K();
        T();
    }

    public final void T() {
        Drawable drawable = this.y0;
        if (drawable != null) {
            if (this.B0 || this.C0) {
                Drawable drawableMutate = drawable.mutate();
                this.y0 = drawableMutate;
                if (this.B0) {
                    drawableMutate.setTintList(this.z0);
                }
                if (this.C0) {
                    this.y0.setTintMode(this.A0);
                }
                if (this.y0.isStateful()) {
                    this.y0.setState(this.Z.getDrawableState());
                }
            }
        }
    }

    public final void U(Canvas canvas) {
        if (this.y0 != null) {
            int max = this.Z.getMax();
            if (max > 1) {
                int intrinsicWidth = this.y0.getIntrinsicWidth();
                int intrinsicHeight = this.y0.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.y0.setBounds(-i, -i2, i, i2);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.y0.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
