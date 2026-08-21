package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lw0 extends yf3 {
    public static final int[] d = {R.attr.listDivider};
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public lw0(Context context) {
        this.a = 0;
        this.c = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(d);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.b = drawable;
        if (drawable == null) {
            a1.n("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // defpackage.yf3
    public void f(Rect rect, View view, RecyclerView recyclerView) {
        switch (this.a) {
            case 0:
                Drawable drawable = (Drawable) this.b;
                if (drawable != null) {
                    rect.set(0, 0, 0, drawable.getIntrinsicHeight());
                } else {
                    rect.set(0, 0, 0, 0);
                }
                break;
            default:
                super.f(rect, view, recyclerView);
                break;
        }
    }

    @Override // defpackage.yf3
    public void g(Canvas canvas, RecyclerView recyclerView) {
        Drawable drawable;
        int width;
        int paddingLeft;
        switch (this.a) {
            case 0:
                if (recyclerView.getLayoutManager() != null && (drawable = (Drawable) this.b) != null) {
                    Rect rect = (Rect) this.c;
                    canvas.save();
                    if (recyclerView.getClipToPadding()) {
                        paddingLeft = recyclerView.getPaddingLeft();
                        width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                        canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                    } else {
                        width = recyclerView.getWidth();
                        paddingLeft = 0;
                    }
                    int childCount = recyclerView.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = recyclerView.getChildAt(i);
                        RecyclerView.P(childAt, rect);
                        int iRound = Math.round(childAt.getTranslationY()) + rect.bottom;
                        drawable.setBounds(paddingLeft, iRound - drawable.getIntrinsicHeight(), width, iRound);
                        drawable.draw(canvas);
                    }
                    canvas.restore();
                    break;
                }
                break;
        }
    }

    @Override // defpackage.yf3
    public void h(Canvas canvas, RecyclerView recyclerView) {
        Canvas canvas2;
        switch (this.a) {
            case 1:
                Paint paint = (Paint) this.b;
                paint.setStrokeWidth(recyclerView.getResources().getDimension(com.getsurfboard.R.dimen.m3_carousel_debug_keyline_width));
                Iterator it = ((List) this.c).iterator();
                while (it.hasNext()) {
                    ((l82) it.next()).getClass();
                    paint.setColor(u70.b(-65281, 0.0f, -16776961));
                    if (((CarouselLayoutManager) recyclerView.getLayoutManager()).K0()) {
                        canvas2 = canvas;
                        canvas2.drawLine(0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).q.i(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).q.e(), paint);
                    } else {
                        canvas2 = canvas;
                        canvas2.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).q.f(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).q.g(), 0.0f, paint);
                    }
                    canvas = canvas2;
                }
                break;
        }
    }

    public lw0() {
        this.a = 1;
        Paint paint = new Paint();
        this.b = paint;
        this.c = DesugarCollections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }
}
