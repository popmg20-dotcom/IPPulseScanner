package com.getsurfboard.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ViewFinderOverlay extends View {
    public final float A;
    public final Paint b;
    public final Paint f;
    public RectF y0;
    public final Paint z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
        Paint paint = new Paint();
        paint.setColor(context.getColor(R.color.white));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(context.getResources().getDimensionPixelOffset(R.dimen.qrcode_reticle_stroke_width));
        this.b = paint;
        Paint paint2 = new Paint();
        paint2.setColor(context.getColor(R.color.qrcode_reticle_background));
        this.f = paint2;
        Paint paint3 = new Paint();
        paint3.setStrokeWidth(paint.getStrokeWidth());
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.z = paint3;
        this.A = ContextUtilsKt.getContext().getResources().getDimension(R.dimen.qrcode_reticle_corner_radius);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        canvas.getClass();
        super.draw(canvas);
        RectF rectF = this.y0;
        if (rectF != null) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f);
            Paint.Style style = Paint.Style.FILL;
            Paint paint = this.z;
            paint.setStyle(style);
            float f = this.A;
            canvas.drawRoundRect(rectF, f, f, paint);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRoundRect(rectF, f, f, paint);
            canvas.drawRoundRect(rectF, f, f, this.b);
        }
    }
}
