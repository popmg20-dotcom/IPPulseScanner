package defpackage;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s10 extends fb2 {
    public final /* synthetic */ int q = 1;

    public /* synthetic */ s10(Context context) {
        super(context);
    }

    @Override // defpackage.fb2
    public int b(View view, int i) {
        switch (this.q) {
            case 0:
                return 0;
            default:
                return super.b(view, i);
        }
    }

    @Override // defpackage.fb2
    public int c(View view, int i) {
        switch (this.q) {
            case 0:
                return 0;
            default:
                return super.c(view, i);
        }
    }

    @Override // defpackage.fb2
    public float d(DisplayMetrics displayMetrics) {
        switch (this.q) {
            case 1:
                displayMetrics.getClass();
                return 80.0f / displayMetrics.densityDpi;
            default:
                return super.d(displayMetrics);
        }
    }

    @Override // defpackage.fb2
    public PointF f(int i) {
        switch (this.q) {
            case 0:
                return null;
            default:
                return super.f(i);
        }
    }

    public s10(CarouselLayoutManager carouselLayoutManager, Context context) {
        super(context);
    }
}
