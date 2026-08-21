package defpackage;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f22 implements eg3 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f22(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.eg3
    public final void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                k22 k22Var = (k22) obj;
                f33 f33Var = k22Var.s;
                k22Var.x.onTouchEvent(motionEvent);
                VelocityTracker velocityTracker = k22Var.t;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                }
                if (k22Var.l != -1) {
                    int actionMasked = motionEvent.getActionMasked();
                    int iFindPointerIndex = motionEvent.findPointerIndex(k22Var.l);
                    if (iFindPointerIndex >= 0) {
                        k22Var.k(actionMasked, iFindPointerIndex, motionEvent);
                    }
                    rg3 rg3Var = k22Var.c;
                    if (rg3Var != null) {
                        if (actionMasked != 1) {
                            if (actionMasked == 2) {
                                if (iFindPointerIndex >= 0) {
                                    k22Var.s(k22Var.o, iFindPointerIndex, motionEvent);
                                    k22Var.q(rg3Var);
                                    k22Var.r.removeCallbacks(f33Var);
                                    f33Var.run();
                                    k22Var.r.invalidate();
                                }
                                break;
                            } else if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = k22Var.t;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                if (motionEvent.getPointerId(actionIndex) == k22Var.l) {
                                    k22Var.l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                                    k22Var.s(k22Var.o, actionIndex, motionEvent);
                                }
                                break;
                            }
                        }
                        k22Var.r(null, 0);
                        k22Var.l = -1;
                        break;
                    }
                }
                break;
            default:
                ((jd) obj).c(motionEvent);
                break;
        }
    }

    @Override // defpackage.eg3
    public final boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        int iFindPointerIndex;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                k22 k22Var = (k22) obj;
                k22Var.x.onTouchEvent(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                g22 g22Var = null;
                if (actionMasked == 0) {
                    k22Var.l = motionEvent.getPointerId(0);
                    k22Var.d = motionEvent.getX();
                    k22Var.e = motionEvent.getY();
                    VelocityTracker velocityTracker = k22Var.t;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                    }
                    k22Var.t = VelocityTracker.obtain();
                    if (k22Var.c == null) {
                        ArrayList arrayList = k22Var.p;
                        if (!arrayList.isEmpty()) {
                            View viewN = k22Var.n(motionEvent);
                            int size = arrayList.size() - 1;
                            while (true) {
                                if (size >= 0) {
                                    g22 g22Var2 = (g22) arrayList.get(size);
                                    if (g22Var2.e.a == viewN) {
                                        g22Var = g22Var2;
                                    } else {
                                        size--;
                                    }
                                }
                            }
                        }
                        if (g22Var != null) {
                            rg3 rg3Var = g22Var.e;
                            k22Var.d -= g22Var.i;
                            k22Var.e -= g22Var.j;
                            k22Var.m(rg3Var, true);
                            if (k22Var.a.remove(rg3Var.a)) {
                                i22.a(rg3Var);
                            }
                            k22Var.r(rg3Var, g22Var.f);
                            k22Var.s(k22Var.o, 0, motionEvent);
                        }
                    }
                } else if (actionMasked == 3 || actionMasked == 1) {
                    k22Var.l = -1;
                    k22Var.r(null, 0);
                } else {
                    int i2 = k22Var.l;
                    if (i2 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i2)) >= 0) {
                        k22Var.k(actionMasked, iFindPointerIndex, motionEvent);
                    }
                }
                VelocityTracker velocityTracker2 = k22Var.t;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
                return k22Var.c != null;
            default:
                return ((jd) obj).c(motionEvent);
        }
    }

    @Override // defpackage.eg3
    public final void e(boolean z) {
        switch (this.a) {
            case 0:
                if (z) {
                    ((k22) this.b).r(null, 0);
                    break;
                }
                break;
        }
    }

    private final void b(boolean z) {
    }
}
