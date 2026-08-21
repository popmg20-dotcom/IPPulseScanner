package defpackage;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class nq3 extends FrameLayout {
    public boolean A;
    public boolean A0;
    public Drawable b;
    public Rect f;
    public boolean y0;
    public Rect z;
    public boolean z0;

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Rect rect = this.z;
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f == null || this.b == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.A) {
            rect.set(0, 0, width, this.f.top);
            this.b.setBounds(rect);
            this.b.draw(canvas);
        }
        if (this.y0) {
            rect.set(0, height - this.f.bottom, width, height);
            this.b.setBounds(rect);
            this.b.draw(canvas);
        }
        if (this.z0) {
            Rect rect2 = this.f;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.b.setBounds(rect);
            this.b.draw(canvas);
        }
        if (this.A0) {
            Rect rect3 = this.f;
            rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
            this.b.setBounds(rect);
            this.b.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.y0 = z;
    }

    public void setDrawLeftInsetForeground(boolean z) {
        this.z0 = z;
    }

    public void setDrawRightInsetForeground(boolean z) {
        this.A0 = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.A = z;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.b = drawable;
    }
}
