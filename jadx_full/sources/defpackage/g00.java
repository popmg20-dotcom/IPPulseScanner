package defpackage;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g00 implements dd0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ g00(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // defpackage.dd0
    public final void accept(Object obj) {
        int i = this.a;
        Object obj2 = this.c;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                ((Surface) obj3).release();
                ((SurfaceTexture) obj2).release();
                break;
            case 1:
                xm0 xm0Var = (xm0) obj3;
                d74 d74Var = (d74) obj2;
                d74Var.close();
                Surface surface = (Surface) xm0Var.h.remove(d74Var);
                if (surface != null) {
                    bw2 bw2Var = xm0Var.a;
                    gn1.d(bw2Var.a, true);
                    gn1.c(bw2Var.c);
                    bw2Var.i(surface, true);
                }
                break;
            case 2:
                yy0 yy0Var = (yy0) obj3;
                d74 d74Var2 = (d74) obj2;
                d74Var2.close();
                Surface surface2 = (Surface) yy0Var.h.remove(d74Var2);
                if (surface2 != null) {
                    vy0 vy0Var = yy0Var.a;
                    gn1.d(vy0Var.a, true);
                    gn1.c(vy0Var.c);
                    vy0Var.i(surface2, true);
                }
                break;
            default:
                hw3 hw3Var = (hw3) obj3;
                Activity activity = (Activity) obj2;
                n02 n02Var = hw3Var.e;
                if (n02Var != null) {
                    n02Var.B(activity, hw3Var.a(activity));
                }
                break;
        }
    }
}
