package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n3 extends ib implements r3 {
    public final /* synthetic */ q3 A;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n3(q3 q3Var, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.A = q3Var;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        ye.H(this, getContentDescription());
        setOnTouchListener(new j3(this, this));
    }

    @Override // defpackage.r3
    public final boolean a() {
        return false;
    }

    @Override // defpackage.r3
    public final boolean b() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.A.n();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}
