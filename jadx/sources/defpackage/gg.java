package defpackage;

import android.graphics.Canvas;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gg extends xx0 {
    @Override // defpackage.xx0, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (getLayoutDirection() != 1) {
            super.draw(canvas);
            return;
        }
        float fExactCenterX = getBounds().exactCenterX();
        canvas.scale(-1.0f, 1.0f, fExactCenterX, 0.0f);
        super.draw(canvas);
        canvas.scale(-1.0f, 1.0f, fExactCenterX, 0.0f);
    }

    @Override // defpackage.xx0, android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        boolean padding = this.b.getPadding(rect);
        if (getLayoutDirection() == 1) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    @Override // defpackage.xx0, android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        super.onLayoutDirectionChanged(i);
        return true;
    }
}
