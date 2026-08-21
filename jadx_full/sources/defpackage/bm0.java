package defpackage;

import android.os.Handler;
import android.widget.FrameLayout;
import androidx.lifecycle.DefaultLifecycleObserver;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bm0 implements aa2 {
    public final /* synthetic */ int b;
    public final Object f;
    public final Object z;

    public bm0(ca2 ca2Var) {
        this.b = 5;
        this.f = ca2Var;
        q50 q50Var = q50.c;
        Class<?> cls = ca2Var.getClass();
        o50 o50Var = (o50) q50Var.a.get(cls);
        this.z = o50Var == null ? q50Var.a(cls, null) : o50Var;
    }

    @Override // defpackage.aa2
    public final void n(da2 da2Var, p92 p92Var) {
        int i = this.b;
        Object obj = this.f;
        Object obj2 = this.z;
        switch (i) {
            case 0:
                DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) obj;
                switch (am0.a[p92Var.ordinal()]) {
                    case 1:
                        defaultLifecycleObserver.onCreate(da2Var);
                        break;
                    case 2:
                        defaultLifecycleObserver.onStart(da2Var);
                        break;
                    case 3:
                        defaultLifecycleObserver.onResume(da2Var);
                        break;
                    case 4:
                        defaultLifecycleObserver.onPause(da2Var);
                        break;
                    case 5:
                        defaultLifecycleObserver.onStop(da2Var);
                        break;
                    case 6:
                        defaultLifecycleObserver.onDestroy(da2Var);
                        break;
                    case 7:
                        xe.k("ON_ANY must not been send by anybody");
                        break;
                    default:
                        g.d();
                        break;
                }
                aa2 aa2Var = (aa2) obj2;
                if (aa2Var != null) {
                    aa2Var.n(da2Var, p92Var);
                }
                break;
            case 1:
                al1 al1Var = (al1) obj;
                kk1 kk1Var = (kk1) obj2;
                if (!kk1Var.e.Q()) {
                    da2Var.getLifecycle().c(this);
                    FrameLayout frameLayout = (FrameLayout) al1Var.a;
                    WeakHashMap weakHashMap = wp4.a;
                    if (frameLayout.isAttachedToWindow()) {
                        kk1Var.v(al1Var);
                    }
                    break;
                }
                break;
            case 2:
                if (p92Var == p92.ON_DESTROY) {
                    ((Handler) obj).removeCallbacks((f33) obj2);
                    da2Var.getLifecycle().c(this);
                }
                break;
            case 3:
                if (p92Var == p92.ON_START) {
                    ((r92) obj).c(this);
                    ((hp3) obj2).d();
                }
                break;
            case 4:
                qu2 qu2Var = (qu2) obj;
                int i2 = vu2.a[p92Var.ordinal()];
                if (i2 == 1) {
                    qu2Var.c(true);
                    break;
                } else if (i2 == 2) {
                    qu2Var.c(false);
                    break;
                } else if (i2 == 3) {
                    qu2Var.a();
                    ((r92) obj2).c(this);
                    break;
                }
                break;
            default:
                ca2 ca2Var = (ca2) obj;
                HashMap map = ((o50) obj2).a;
                o50.a((List) map.get(p92Var), da2Var, p92Var, ca2Var);
                o50.a((List) map.get(p92.ON_ANY), da2Var, p92Var, ca2Var);
                break;
        }
    }

    public /* synthetic */ bm0(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    public bm0(qu2 qu2Var, wu2 wu2Var, r92 r92Var) {
        this.b = 4;
        this.f = qu2Var;
        this.z = r92Var;
    }

    public bm0(kk1 kk1Var, al1 al1Var) {
        this.b = 1;
        this.z = kk1Var;
        this.f = al1Var;
    }
}
