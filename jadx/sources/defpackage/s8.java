package defpackage;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s8 {
    public static final ThreadLocal i = new ThreadLocal();
    public final lb e;
    public q8 h;
    public final xw3 a = new xw3(0);
    public final ArrayList b = new ArrayList();
    public final w7 c = new w7(5, this);
    public final d4 d = new d4(1, this);
    public boolean f = false;
    public float g = 1.0f;

    public s8(lb lbVar) {
        this.e = lbVar;
    }

    public static s8 b() {
        ThreadLocal threadLocal = i;
        if (threadLocal.get() == null) {
            threadLocal.set(new s8(new lb(4)));
        }
        return (s8) threadLocal.get();
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [android.animation.ValueAnimator$DurationScaleChangeListener, p8] */
    public final void a(w04 w04Var) {
        ArrayList arrayList = this.b;
        if (arrayList.size() == 0) {
            ((Choreographer) this.e.f).postFrameCallback(new r8(0, this.d));
            if (Build.VERSION.SDK_INT >= 33) {
                this.g = ValueAnimator.getDurationScale();
                final q8 q8Var = this.h;
                if (q8Var == null) {
                    q8Var = new q8(this);
                    this.h = q8Var;
                }
                if (q8Var.a == null) {
                    ?? r5 = new ValueAnimator.DurationScaleChangeListener() { // from class: p8
                        @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                        public final void onChanged(float f) {
                            q8Var.b.g = f;
                        }
                    };
                    q8Var.a = r5;
                    ValueAnimator.registerDurationScaleChangeListener(r5);
                }
            }
        }
        if (arrayList.contains(w04Var)) {
            return;
        }
        arrayList.add(w04Var);
    }
}
