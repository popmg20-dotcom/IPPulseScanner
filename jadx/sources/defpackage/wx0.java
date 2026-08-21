package defpackage;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class wx0 extends ScaleDrawable {
    public final Drawable b;

    public wx0(Drawable drawable) {
        super(drawable, 17, -1.0f, -1.0f);
        this.b = drawable;
    }

    @Override // android.graphics.drawable.ScaleDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.getClass();
        this.b.draw(canvas);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.getClass();
        this.b.getOutline(outline);
    }
}
