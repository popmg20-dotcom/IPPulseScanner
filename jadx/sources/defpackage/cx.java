package defpackage;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cx implements Runnable {
    public final Object A;
    public final /* synthetic */ int b;
    public boolean f;
    public final Object z;

    public cx(fa2 fa2Var, p92 p92Var) {
        this.b = 1;
        p92Var.getClass();
        this.z = fa2Var;
        this.A = p92Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zf2 zf2Var;
        int i = this.b;
        Object obj = this.A;
        Object obj2 = this.z;
        switch (i) {
            case 0:
                ((at3) obj2).execute(new d4(4, this));
                break;
            case 1:
                if (!this.f) {
                    ((fa2) obj2).f((p92) obj);
                    this.f = true;
                }
                break;
            default:
                View view = (View) obj2;
                SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) obj;
                zp4 zp4Var = swipeDismissBehavior.b;
                if (zp4Var != null && zp4Var.h()) {
                    view.postOnAnimation(this);
                    break;
                } else if (this.f && (zf2Var = swipeDismissBehavior.f) != null) {
                    zf2Var.o0(view);
                    break;
                }
                break;
        }
    }

    public cx(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.b = 2;
        this.A = swipeDismissBehavior;
        this.z = view;
        this.f = z;
    }

    public cx(dx dxVar, at3 at3Var) {
        this.b = 0;
        this.A = dxVar;
        this.f = false;
        this.z = at3Var;
    }
}
