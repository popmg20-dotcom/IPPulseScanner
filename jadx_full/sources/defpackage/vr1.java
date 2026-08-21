package defpackage;

import android.animation.Animator;
import android.widget.FrameLayout;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vr1 implements Animator.AnimatorListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ vr1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.a) {
            case 0:
            case 1:
                break;
            default:
                animator.getClass();
                ((FrameLayout) ((fb3) this.b).u.f).setHasTransientState(false);
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) throws XmlPullParserException, IOException {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((ig0) obj).a();
                break;
            case 1:
                ((yr1) obj).a();
                break;
            default:
                animator.getClass();
                ((FrameLayout) ((fb3) obj).u.f).setHasTransientState(false);
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        switch (this.a) {
            case 0:
            case 1:
                break;
            default:
                animator.getClass();
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 0:
            case 1:
                break;
            default:
                animator.getClass();
                ((FrameLayout) ((fb3) this.b).u.f).setHasTransientState(true);
                break;
        }
    }

    private final void a(Animator animator) {
    }

    private final void b(Animator animator) {
    }

    private final void c(Animator animator) {
    }

    private final void d(Animator animator) {
    }

    private final void e(Animator animator) {
    }

    private final void f(Animator animator) {
    }
}
