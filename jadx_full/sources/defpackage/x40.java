package defpackage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x40 extends Drawable {
    public final Paint a;
    public final Paint b;
    public final u80 c;

    public x40(u80 u80Var) {
        this.c = u80Var;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor((int) u80Var.f);
        this.a = paint;
        Paint paint2 = new Paint();
        paint2.setColor(-1);
        paint2.setAntiAlias(true);
        paint2.setTextSize(Resources.getSystem().getDisplayMetrics().density * 14.0f);
        paint2.setTextAlign(Paint.Align.CENTER);
        this.b = paint2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.getClass();
        float f = getBounds().right;
        float f2 = getBounds().bottom;
        float f3 = f / 2.0f;
        canvas.drawCircle(f3, f2 / 2.0f, f3, this.a);
        canvas.save();
        canvas.translate(f / 2.0f, f2 / 2.0f);
        Paint paint = this.b;
        canvas.drawText(this.c.z, 0.0f, (-(paint.ascent() + paint.descent())) / 2.0f, paint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.a.setAlpha(i);
        this.b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
}
