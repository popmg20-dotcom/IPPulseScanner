package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import com.tencent.mars.xlog.Xlog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d3 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public d3(er4 er4Var, View view) {
        this.a = 14;
        this.b = er4Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                actionBarOverlayLayout.Q0 = null;
                actionBarOverlayLayout.D0 = false;
                break;
            case 6:
                ((yk) obj).d();
                break;
            case 14:
                ((er4) obj).a();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                actionBarOverlayLayout.Q0 = null;
                actionBarOverlayLayout.D0 = false;
                break;
            case 1:
                animator.getClass();
                ((pl1) obj).a();
                break;
            case 2:
                o8 o8Var = (o8) obj;
                ArrayList arrayList = new ArrayList(o8Var.X);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((cl) arrayList.get(i2)).a(o8Var);
                }
                break;
            case 3:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) obj;
                bottomSheetBehavior.O(5);
                WeakReference weakReference = bottomSheetBehavior.o1;
                if (weakReference != null && weakReference.get() != null) {
                    ((View) bottomSheetBehavior.o1.get()).requestLayout();
                    break;
                }
                break;
            case 4:
                uy0 uy0Var = (uy0) obj;
                uy0Var.p();
                uy0Var.r.start();
                break;
            case 5:
                ((ExpandableTransformationBehavior) obj).f = null;
                break;
            case 6:
                ((yk) obj).e();
                break;
            case 7:
                ((HideBottomViewOnScrollBehavior) obj).B0 = null;
                break;
            case 8:
                ((HideViewOnScrollBehavior) obj).B0 = null;
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
            case 10:
            default:
                super.onAnimationEnd(animator);
                break;
            case 11:
                ei2 ei2Var = (ei2) obj;
                ((View) ei2Var.f).setTranslationY(0.0f);
                ei2Var.b(0.0f);
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                sideSheetBehavior.x(5);
                WeakReference weakReference2 = sideSheetBehavior.G0;
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((View) sideSheetBehavior.G0.get()).requestLayout();
                    break;
                }
                break;
            case 13:
                ((vg4) obj).n();
                animator.removeListener(this);
                break;
            case 14:
                ((er4) obj).c();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                super.onAnimationRepeat(animator);
                wa2 wa2Var = (wa2) obj;
                wa2Var.f = (wa2Var.f + 1) % wa2Var.e.e.length;
                wa2Var.g = true;
                break;
            case 10:
                super.onAnimationRepeat(animator);
                ld2 ld2Var = (ld2) obj;
                w04 w04Var = ld2Var.e;
                int i2 = ld2Var.a + 1;
                ld2Var.a = i2;
                w04Var.a(i2);
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 2:
                o8 o8Var = (o8) obj;
                ArrayList arrayList = new ArrayList(o8Var.X);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((cl) arrayList.get(i2)).b(o8Var);
                }
                break;
            case 6:
                ((yk) obj).f(animator);
                break;
            case 14:
                ((er4) obj).b();
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public /* synthetic */ d3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
