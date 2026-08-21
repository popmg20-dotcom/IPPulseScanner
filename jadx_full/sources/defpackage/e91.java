package defpackage;

import android.animation.Animator;
import com.getsurfboard.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e91 extends yk {
    public final /* synthetic */ ExtendedFloatingActionButton g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e91(ExtendedFloatingActionButton extendedFloatingActionButton, zf2 zf2Var) {
        super(extendedFloatingActionButton, zf2Var);
        this.g = extendedFloatingActionButton;
    }

    @Override // defpackage.yk
    public final int c() {
        return R.animator.mtrl_extended_fab_show_motion_spec;
    }

    @Override // defpackage.yk
    public final void e() {
        this.d.f = null;
        this.g.e1 = 0;
    }

    @Override // defpackage.yk
    public final void f(Animator animator) {
        zf2 zf2Var = this.d;
        Animator animator2 = (Animator) zf2Var.f;
        if (animator2 != null) {
            animator2.cancel();
        }
        zf2Var.f = animator;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.g;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.e1 = 2;
    }

    @Override // defpackage.yk
    public final void g() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.g;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.setAlpha(1.0f);
        extendedFloatingActionButton.setScaleY(1.0f);
        extendedFloatingActionButton.setScaleX(1.0f);
    }

    @Override // defpackage.yk
    public final boolean h() {
        xk xkVar = ExtendedFloatingActionButton.u1;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.g;
        int visibility = extendedFloatingActionButton.getVisibility();
        int i = extendedFloatingActionButton.e1;
        if (visibility != 0) {
            if (i != 2) {
                return false;
            }
        } else if (i == 1) {
            return false;
        }
        return true;
    }
}
