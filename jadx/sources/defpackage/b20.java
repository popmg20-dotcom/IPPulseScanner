package defpackage;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class b20 extends wx0 {
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b20(Drawable drawable, int i) {
        super(drawable);
        this.f = i;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        int i = this.f;
        rect.getClass();
        switch (i) {
            case 0:
                rect.set(0, 0, 0, 0);
                break;
            default:
                super.getPadding(rect);
                break;
        }
        return true;
    }
}
