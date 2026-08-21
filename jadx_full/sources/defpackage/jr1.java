package defpackage;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import io.netty.channel.internal.ChannelUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class jr1 extends qq4 {
    public OverScroller A;
    public boolean X;
    public int Y;
    public int Z;
    public int y0;
    public g33 z;
    public VelocityTracker z0;

    public final void A(CoordinatorLayout coordinatorLayout, View view, int i) {
        z(coordinatorLayout, view, i, Integer.MIN_VALUE, ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a5  */
    @Override // defpackage.qe0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        View view2;
        int iFindPointerIndex;
        if (this.y0 < 0) {
            this.y0 = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.X) {
            int i = this.Y;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                int y = (int) motionEvent.getY(iFindPointerIndex);
                if (Math.abs(y - this.Z) > this.y0) {
                    this.Z = y;
                    return true;
                }
                if (motionEvent.getActionMasked() == 0) {
                }
                velocityTracker = this.z0;
                if (velocityTracker != null) {
                }
            }
        } else {
            if (motionEvent.getActionMasked() == 0) {
                this.Y = -1;
                int x = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                WeakReference weakReference = ((AppBarLayout.BaseBehavior) this).E0;
                boolean z = (weakReference == null || !((view2 = (View) weakReference.get()) == null || !view2.isShown() || view2.canScrollVertically(-1))) && coordinatorLayout.o(view, x, y2);
                this.X = z;
                if (z) {
                    this.Z = y2;
                    this.Y = motionEvent.getPointerId(0);
                    if (this.z0 == null) {
                        this.z0 = VelocityTracker.obtain();
                    }
                    OverScroller overScroller = this.A;
                    if (overScroller != null && !overScroller.isFinished()) {
                        this.A.abortAnimation();
                        return true;
                    }
                }
            }
            velocityTracker = this.z0;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f8 A[ADDED_TO_REGION] */
    @Override // defpackage.qe0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        int i = 3;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.Y);
                if (iFindPointerIndex != -1) {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i2 = this.Z - y;
                    this.Z = y;
                    AppBarLayout appBarLayout = (AppBarLayout) view;
                    z(coordinatorLayout, view, y() - i2, appBarLayout.getTopInset() + (-appBarLayout.getDownNestedScrollRange()), 0);
                }
            }
            if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i3 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.Y = motionEvent.getPointerId(i3);
                    this.Z = (int) (motionEvent.getY(i3) + 0.5f);
                }
            }
            z = false;
            velocityTracker2 = this.z0;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return !this.X || z;
        }
        VelocityTracker velocityTracker3 = this.z0;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.z0.computeCurrentVelocity(1000);
            float yVelocity = this.z0.getYVelocity(this.Y);
            AppBarLayout appBarLayout2 = (AppBarLayout) view;
            int i4 = -appBarLayout2.getTotalScrollRange();
            Runnable runnable = this.z;
            if (runnable != null) {
                view.removeCallbacks(runnable);
                this.z = null;
            }
            OverScroller overScroller = this.A;
            if (overScroller == null) {
                overScroller = new OverScroller(view.getContext());
                this.A = overScroller;
            }
            overScroller.fling(0, w(), 0, Math.round(yVelocity), 0, 0, i4, 0);
            if (this.A.computeScrollOffset()) {
                g33 g33Var = new g33(i, this, coordinatorLayout, view);
                this.z = g33Var;
                view.postOnAnimation(g33Var);
            } else {
                ((AppBarLayout.BaseBehavior) this).F(coordinatorLayout, appBarLayout2);
                if (appBarLayout2.E0) {
                    appBarLayout2.e(appBarLayout2.f(AppBarLayout.BaseBehavior.C(coordinatorLayout)));
                }
            }
            z = true;
        }
        this.X = false;
        this.Y = -1;
        velocityTracker = this.z0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.z0 = null;
        }
        velocityTracker2 = this.z0;
        if (velocityTracker2 != null) {
        }
        if (this.X) {
        }
        z = false;
        this.X = false;
        this.Y = -1;
        velocityTracker = this.z0;
        if (velocityTracker != null) {
        }
        velocityTracker2 = this.z0;
        if (velocityTracker2 != null) {
        }
        if (this.X) {
        }
    }

    public abstract int y();

    public abstract int z(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3);
}
