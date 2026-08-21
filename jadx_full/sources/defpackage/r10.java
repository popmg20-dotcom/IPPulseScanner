package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.camera.view.PreviewView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.carousel.CarouselLayoutManager;
import io.sentry.android.replay.c0;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r10 implements View.OnLayoutChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ r10(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        pj pjVar;
        int i9 = this.a;
        boolean z = false;
        Object obj = this.b;
        switch (i9) {
            case 0:
                CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) obj;
                if (i3 - i == i7 - i5 && i4 - i2 == i8 - i6) {
                    return;
                }
                view.post(new d4(11, carouselLayoutManager));
                return;
            case 1:
                l11 l11Var = (l11) obj;
                if (l11Var.b.isShowing()) {
                    l11Var.a(false);
                    return;
                }
                return;
            case 2:
                ip2 ip2Var = (ip2) obj;
                View view2 = ip2Var.L0;
                ImageView imageView = ip2Var.N0;
                if (imageView.getVisibility() == 0 && (pjVar = ip2Var.r1) != null) {
                    Rect rect = new Rect();
                    imageView.getDrawingRect(rect);
                    pjVar.setBounds(rect);
                    pjVar.j(imageView, null);
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ip2Var.K0.getLayoutParams();
                int i10 = (i3 - i) + layoutParams.rightMargin + layoutParams.leftMargin;
                int i11 = (i4 - i2) + layoutParams.topMargin + layoutParams.bottomMargin;
                boolean z2 = true;
                if (ip2Var.s1 == 1 && ip2Var.m1 == -2) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view2.getLayoutParams();
                    if (ip2Var.m1 == -2 && view2.getMeasuredWidth() != i10) {
                        layoutParams2.width = Math.max(i10, Math.min(ip2Var.k1, ip2Var.getMeasuredWidth() - (ip2Var.p1 * 2)));
                        z = true;
                    }
                    if (view2.getMeasuredHeight() < i11) {
                        layoutParams2.height = i11;
                    } else {
                        z2 = z;
                    }
                    if (z2) {
                        view2.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                PreviewView previewView = (PreviewView) obj;
                int i12 = PreviewView.G0;
                if (i3 - i == i7 - i5 && i4 - i2 == i8 - i6) {
                    return;
                }
                previewView.a();
                co4.h();
                previewView.getViewPort();
                return;
            case 4:
                ((ya3) obj).k();
                return;
            case 5:
                es3 es3Var = (es3) obj;
                gk1 gk1Var = es3Var.H0;
                gk1Var.getClass();
                if (gk1Var.a.getWidth() == 0) {
                    return;
                }
                gk1 gk1Var2 = es3Var.H0;
                gk1Var2.getClass();
                int width = gk1Var2.a.getWidth() / ContextUtilsKt.e(R.dimen.proxy_grid_width_small);
                gk1 gk1Var3 = es3Var.H0;
                gk1Var3.getClass();
                gk1Var3.a.S();
                gk1 gk1Var4 = es3Var.H0;
                gk1Var4.getClass();
                ah4.a(gk1Var4.a, null);
                StaggeredGridLayoutManager staggeredGridLayoutManager = es3Var.K0;
                if (staggeredGridLayoutManager != null) {
                    staggeredGridLayoutManager.h1(width);
                    return;
                } else {
                    n12.T("layoutManager");
                    throw null;
                }
            default:
                c0 c0Var = (c0) obj;
                int i13 = i4 - i2;
                int i14 = i8 - i6;
                if (i3 - i == i7 - i5 && i13 == i14) {
                    return;
                }
                WeakReference weakReference = (WeakReference) d70.l0(c0Var.Z);
                if (n12.c(view, weakReference != null ? (View) weakReference.get() : null)) {
                    view.getClass();
                    c0Var.n(view);
                    return;
                }
                return;
        }
    }
}
