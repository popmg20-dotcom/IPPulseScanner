package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.getsurfboard.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c91 extends yk {
    public final f91 g;
    public final boolean h;
    public final /* synthetic */ ExtendedFloatingActionButton i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c91(ExtendedFloatingActionButton extendedFloatingActionButton, zf2 zf2Var, f91 f91Var, boolean z) {
        super(extendedFloatingActionButton, zf2Var);
        this.i = extendedFloatingActionButton;
        this.g = f91Var;
        this.h = z;
    }

    @Override // defpackage.yk
    public final AnimatorSet a() {
        rm2 rm2VarB = this.f;
        if (rm2VarB == null) {
            rm2VarB = this.e;
            if (rm2VarB == null) {
                rm2VarB = rm2.b(this.a, c());
                this.e = rm2VarB;
            }
            rm2VarB.getClass();
        }
        boolean zG = rm2VarB.g("width");
        f91 f91Var = this.g;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.i;
        if (zG) {
            PropertyValuesHolder[] propertyValuesHolderArrE = rm2VarB.e("width");
            propertyValuesHolderArrE[0].setFloatValues(extendedFloatingActionButton.getWidth(), f91Var.f());
            rm2VarB.h("width", propertyValuesHolderArrE);
        }
        if (rm2VarB.g("height")) {
            PropertyValuesHolder[] propertyValuesHolderArrE2 = rm2VarB.e("height");
            propertyValuesHolderArrE2[0].setFloatValues(extendedFloatingActionButton.getHeight(), f91Var.c());
            rm2VarB.h("height", propertyValuesHolderArrE2);
        }
        if (rm2VarB.g("paddingStart")) {
            PropertyValuesHolder[] propertyValuesHolderArrE3 = rm2VarB.e("paddingStart");
            propertyValuesHolderArrE3[0].setFloatValues(extendedFloatingActionButton.getPaddingStart(), f91Var.U());
            rm2VarB.h("paddingStart", propertyValuesHolderArrE3);
        }
        if (rm2VarB.g("paddingEnd")) {
            PropertyValuesHolder[] propertyValuesHolderArrE4 = rm2VarB.e("paddingEnd");
            propertyValuesHolderArrE4[0].setFloatValues(extendedFloatingActionButton.getPaddingEnd(), f91Var.i());
            rm2VarB.h("paddingEnd", propertyValuesHolderArrE4);
        }
        if (rm2VarB.g("labelOpacity")) {
            PropertyValuesHolder[] propertyValuesHolderArrE5 = rm2VarB.e("labelOpacity");
            int iAlpha = Color.alpha(extendedFloatingActionButton.getCurrentOriginalTextColor());
            propertyValuesHolderArrE5[0].setFloatValues(iAlpha != 0 ? Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / iAlpha : 0.0f, this.h ? 1.0f : 0.0f);
            rm2VarB.h("labelOpacity", propertyValuesHolderArrE5);
        }
        return b(rm2VarB);
    }

    @Override // defpackage.yk
    public final int c() {
        return this.h ? R.animator.mtrl_extended_fab_change_size_expand_motion_spec : R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
    }

    @Override // defpackage.yk
    public final void e() {
        this.d.f = null;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.i;
        extendedFloatingActionButton.p1 = false;
        extendedFloatingActionButton.setHorizontallyScrolling(false);
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        f91 f91Var = this.g;
        layoutParams.width = f91Var.I().width;
        layoutParams.height = f91Var.I().height;
    }

    @Override // defpackage.yk
    public final void f(Animator animator) {
        zf2 zf2Var = this.d;
        Animator animator2 = (Animator) zf2Var.f;
        if (animator2 != null) {
            animator2.cancel();
        }
        zf2Var.f = animator;
        boolean z = this.h;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.i;
        extendedFloatingActionButton.o1 = z;
        extendedFloatingActionButton.p1 = true;
        extendedFloatingActionButton.setHorizontallyScrolling(true);
        extendedFloatingActionButton.x();
    }

    @Override // defpackage.yk
    public final void g() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.i;
        boolean z = this.h;
        extendedFloatingActionButton.o1 = z;
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (!z) {
            extendedFloatingActionButton.s1 = layoutParams.width;
            extendedFloatingActionButton.t1 = layoutParams.height;
        }
        f91 f91Var = this.g;
        layoutParams.width = f91Var.I().width;
        layoutParams.height = f91Var.I().height;
        if (z) {
            extendedFloatingActionButton.w(extendedFloatingActionButton.r1);
        } else if (extendedFloatingActionButton.getText() != null && extendedFloatingActionButton.getText() != "") {
            extendedFloatingActionButton.w(ColorStateList.valueOf(0));
        }
        extendedFloatingActionButton.setPaddingRelative(f91Var.U(), extendedFloatingActionButton.getPaddingTop(), f91Var.i(), extendedFloatingActionButton.getPaddingBottom());
        extendedFloatingActionButton.requestLayout();
        extendedFloatingActionButton.x();
    }

    @Override // defpackage.yk
    public final boolean h() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.i;
        return this.h == extendedFloatingActionButton.o1 || extendedFloatingActionButton.getIcon() == null || TextUtils.isEmpty(extendedFloatingActionButton.getText());
    }
}
