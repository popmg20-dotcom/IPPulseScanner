package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class yk {
    public final Context a;
    public final ExtendedFloatingActionButton b;
    public final ArrayList c = new ArrayList();
    public final zf2 d;
    public rm2 e;
    public rm2 f;

    public yk(ExtendedFloatingActionButton extendedFloatingActionButton, zf2 zf2Var) {
        this.b = extendedFloatingActionButton;
        this.a = extendedFloatingActionButton.getContext();
        this.d = zf2Var;
    }

    public AnimatorSet a() {
        rm2 rm2VarB = this.f;
        if (rm2VarB == null) {
            rm2VarB = this.e;
            if (rm2VarB == null) {
                rm2VarB = rm2.b(this.a, c());
                this.e = rm2VarB;
            }
            rm2VarB.getClass();
        }
        return b(rm2VarB);
    }

    public final AnimatorSet b(rm2 rm2Var) {
        ArrayList arrayList = new ArrayList();
        boolean zG = rm2Var.g("opacity");
        ExtendedFloatingActionButton extendedFloatingActionButton = this.b;
        if (zG) {
            arrayList.add(rm2Var.d("opacity", extendedFloatingActionButton, View.ALPHA));
        }
        if (rm2Var.g("scale")) {
            arrayList.add(rm2Var.d("scale", extendedFloatingActionButton, View.SCALE_Y));
            arrayList.add(rm2Var.d("scale", extendedFloatingActionButton, View.SCALE_X));
        }
        if (rm2Var.g("width")) {
            arrayList.add(rm2Var.d("width", extendedFloatingActionButton, ExtendedFloatingActionButton.u1));
        }
        if (rm2Var.g("height")) {
            arrayList.add(rm2Var.d("height", extendedFloatingActionButton, ExtendedFloatingActionButton.v1));
        }
        if (rm2Var.g("paddingStart")) {
            arrayList.add(rm2Var.d("paddingStart", extendedFloatingActionButton, ExtendedFloatingActionButton.w1));
        }
        if (rm2Var.g("paddingEnd")) {
            arrayList.add(rm2Var.d("paddingEnd", extendedFloatingActionButton, ExtendedFloatingActionButton.x1));
        }
        if (rm2Var.g("labelOpacity")) {
            arrayList.add(rm2Var.d("labelOpacity", extendedFloatingActionButton, new xk(0, Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        p95.z(animatorSet, arrayList);
        return animatorSet;
    }

    public abstract int c();

    public void d() {
        this.d.f = null;
    }

    public abstract void e();

    public abstract void f(Animator animator);

    public abstract void g();

    public abstract boolean h();
}
