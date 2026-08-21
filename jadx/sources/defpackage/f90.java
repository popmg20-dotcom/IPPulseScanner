package defpackage;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.p;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f90 implements ViewTreeObserver.OnDrawListener, Runnable, Executor {
    public final /* synthetic */ p A;
    public final long b = SystemClock.uptimeMillis() + 10000;
    public Runnable f;
    public boolean z;

    public f90(p pVar) {
        this.A = pVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        this.f = runnable;
        View decorView = this.A.getWindow().getDecorView();
        decorView.getClass();
        if (!this.z) {
            decorView.postOnAnimation(new d4(14, this));
        } else if (n12.c(Looper.myLooper(), Looper.getMainLooper())) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z;
        Runnable runnable = this.f;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.b) {
                this.z = false;
                this.A.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.f = null;
        ol1 ol1Var = (ol1) this.A.Z.getValue();
        synchronized (ol1Var.b) {
            z = ol1Var.c;
        }
        if (z) {
            this.z = false;
            this.A.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.A.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
