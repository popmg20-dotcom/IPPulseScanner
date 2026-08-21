package defpackage;

import android.animation.Animator;
import com.getsurfboard.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d91 extends yk {
    public boolean g;
    public final /* synthetic */ ExtendedFloatingActionButton h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d91(ExtendedFloatingActionButton extendedFloatingActionButton, zf2 zf2Var) {
        super(extendedFloatingActionButton, zf2Var);
        this.h = extendedFloatingActionButton;
    }

    @Override // defpackage.yk
    public final int c() {
        return R.animator.mtrl_extended_fab_hide_motion_spec;
    }

    @Override // defpackage.yk
    public final void d() {
        super.d();
        this.g = true;
    }

    @Override // defpackage.yk
    public final void e() {
        this.d.f = null;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.h;
        extendedFloatingActionButton.e1 = 0;
        if (this.g) {
            return;
        }
        extendedFloatingActionButton.setVisibility(8);
    }

    @Override // defpackage.yk
    public final void f(Animator animator) {
        zf2 zf2Var = this.d;
        Animator animator2 = (Animator) zf2Var.f;
        if (animator2 != null) {
            animator2.cancel();
        }
        zf2Var.f = animator;
        this.g = false;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.h;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.e1 = 1;
    }

    @Override // defpackage.yk
    public final void g() {
        this.h.setVisibility(8);
    }

    @Override // defpackage.yk
    public final boolean h() {
        xk xkVar = ExtendedFloatingActionButton.u1;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.h;
        int visibility = extendedFloatingActionButton.getVisibility();
        int i = extendedFloatingActionButton.e1;
        if (visibility == 0) {
            if (i != 1) {
                return false;
            }
        } else if (i == 2) {
            return false;
        }
        return true;
    }
}
