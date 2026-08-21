package defpackage;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ou2 implements OnBackAnimationCallback {
    public final /* synthetic */ pu2 a;

    public ou2(pu2 pu2Var) {
        this.a = pu2Var;
    }

    public final void onBackCancelled() {
        pu2 pu2Var = this.a;
        iv1 iv1Var = pu2Var.a;
        if (iv1Var == null) {
            xe.q("This input is not added to any dispatcher.");
            return;
        }
        if (!pu2Var.b) {
            iv1Var.i(pu2Var, null);
        }
        yp2 yp2Var = (yp2) iv1Var.z;
        if (pu2Var.equals(yp2Var.h) && -1 == yp2Var.g) {
            qu2 qu2VarC = yp2Var.f;
            if (qu2VarC == null) {
                qu2VarC = yp2Var.c(-1);
            }
            yp2Var.f = null;
            yp2Var.g = 0;
            yp2Var.h = null;
            if (qu2VarC != null) {
                qu2VarC.d.a();
            }
            yp2Var.a.j(null, zp2.Z);
        }
        pu2Var.b = false;
    }

    public final void onBackInvoked() {
        this.a.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        backEvent.getClass();
        vp2 vp2VarA = m2.a(backEvent);
        pu2 pu2Var = this.a;
        iv1 iv1Var = pu2Var.a;
        if (iv1Var == null) {
            xe.q("This input is not added to any dispatcher.");
            return;
        }
        if (pu2Var.b) {
            yp2 yp2Var = (yp2) iv1Var.z;
            if (pu2Var.equals(yp2Var.h) && -1 == yp2Var.g) {
                qu2 qu2VarC = yp2Var.f;
                if (qu2VarC == null) {
                    qu2VarC = yp2Var.c(-1);
                }
                if (qu2VarC != null) {
                    qu2VarC.d.c(new yh(vp2VarA));
                }
                yp2Var.a.j(null, new aq2(vp2VarA));
            }
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        backEvent.getClass();
        vp2 vp2VarA = m2.a(backEvent);
        pu2 pu2Var = this.a;
        iv1 iv1Var = pu2Var.a;
        if (iv1Var == null) {
            xe.q("This input is not added to any dispatcher.");
        } else {
            if (pu2Var.b) {
                return;
            }
            iv1Var.i(pu2Var, vp2VarA);
            pu2Var.b = true;
        }
    }
}
