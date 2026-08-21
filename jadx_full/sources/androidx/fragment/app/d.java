package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.getsurfboard.R;
import defpackage.eg0;
import defpackage.ek0;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d extends f {
    public final boolean b;
    public boolean c;
    public eg0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a0 a0Var, boolean z) {
        super(a0Var);
        a0Var.getClass();
        this.b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00f4 A[Catch: RuntimeException -> 0x00fa, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x00fa, blocks: (B:72:0x00ee, B:74:0x00f4), top: B:85:0x00ee }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final eg0 b(Context context) {
        Animation animationLoadAnimation;
        eg0 eg0Var;
        Animator animatorLoadAnimator;
        if (this.c) {
            return this.d;
        }
        a0 a0Var = this.a;
        o oVar = a0Var.c;
        boolean z = a0Var.a == 2;
        int nextTransition = oVar.getNextTransition();
        int popEnterAnim = this.b ? z ? oVar.getPopEnterAnim() : oVar.getPopExitAnim() : z ? oVar.getEnterAnim() : oVar.getExitAnim();
        oVar.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = oVar.mContainer;
        eg0 eg0Var2 = null;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            oVar.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = oVar.mContainer;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation animationOnCreateAnimation = oVar.onCreateAnimation(nextTransition, z, popEnterAnim);
            if (animationOnCreateAnimation != null) {
                eg0Var2 = new eg0(animationOnCreateAnimation);
            } else {
                Animator animatorOnCreateAnimator = oVar.onCreateAnimator(nextTransition, z, popEnterAnim);
                if (animatorOnCreateAnimator != null) {
                    eg0Var2 = new eg0(animatorOnCreateAnimator);
                } else {
                    if (popEnterAnim == 0 && nextTransition != 0) {
                        popEnterAnim = nextTransition != 4097 ? nextTransition != 8194 ? nextTransition != 8197 ? nextTransition != 4099 ? nextTransition != 4100 ? -1 : z ? ek0.E(context, android.R.attr.activityOpenEnterAnimation) : ek0.E(context, android.R.attr.activityOpenExitAnimation) : z ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit : z ? ek0.E(context, android.R.attr.activityCloseEnterAnimation) : ek0.E(context, android.R.attr.activityCloseExitAnimation) : z ? R.animator.fragment_close_enter : R.animator.fragment_close_exit : z ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                    }
                    if (popEnterAnim != 0) {
                        boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(popEnterAnim));
                        if (zEquals) {
                            try {
                                animationLoadAnimation = AnimationUtils.loadAnimation(context, popEnterAnim);
                            } catch (Resources.NotFoundException e) {
                                throw e;
                            } catch (RuntimeException unused) {
                                try {
                                    animatorLoadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                                    if (animatorLoadAnimator != null) {
                                    }
                                } catch (RuntimeException e2) {
                                    if (zEquals) {
                                        throw e2;
                                    }
                                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                                    if (animationLoadAnimation2 != null) {
                                        eg0Var2 = new eg0(animationLoadAnimation2);
                                    }
                                }
                            }
                            if (animationLoadAnimation != null) {
                                eg0Var = new eg0(animationLoadAnimation);
                                eg0Var2 = eg0Var;
                            }
                        } else {
                            animatorLoadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                            if (animatorLoadAnimator != null) {
                                eg0Var = new eg0(animatorLoadAnimator);
                                eg0Var2 = eg0Var;
                            }
                        }
                    }
                }
            }
        }
        this.d = eg0Var2;
        this.c = true;
        return eg0Var2;
    }
}
