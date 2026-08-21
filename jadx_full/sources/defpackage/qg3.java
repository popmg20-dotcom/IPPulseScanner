package defpackage;

import android.os.Build;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import io.netty.channel.internal.ChannelUtils;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qg3 implements Runnable {
    public Interpolator A;
    public boolean X;
    public boolean Y;
    public final /* synthetic */ RecyclerView Z;
    public int b;
    public int f;
    public OverScroller z;

    public qg3(RecyclerView recyclerView) {
        this.Z = recyclerView;
        h22 h22Var = RecyclerView.a2;
        this.A = h22Var;
        this.X = false;
        this.Y = false;
        this.z = new OverScroller(recyclerView.getContext(), h22Var);
    }

    public final void a(int i, int i2) {
        RecyclerView recyclerView = this.Z;
        recyclerView.setScrollState(2);
        this.f = 0;
        this.b = 0;
        Interpolator interpolator = this.A;
        h22 h22Var = RecyclerView.a2;
        if (interpolator != h22Var) {
            this.A = h22Var;
            this.z = new OverScroller(recyclerView.getContext(), h22Var);
        }
        this.z.fling(0, 0, i, i2, Integer.MIN_VALUE, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, Integer.MIN_VALUE, ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
        b();
    }

    public final void b() {
        if (this.X) {
            this.Y = true;
            return;
        }
        RecyclerView recyclerView = this.Z;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = wp4.a;
        recyclerView.postOnAnimation(this);
    }

    public final void c(int i, int i2, int i3, BaseInterpolator baseInterpolator) {
        RecyclerView recyclerView = this.Z;
        if (i3 == Integer.MIN_VALUE) {
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z) {
                iAbs = iAbs2;
            }
            i3 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }
        int i4 = i3;
        Interpolator interpolator = baseInterpolator;
        if (baseInterpolator == null) {
            interpolator = RecyclerView.a2;
        }
        if (this.A != interpolator) {
            this.A = interpolator;
            this.z = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f = 0;
        this.b = 0;
        recyclerView.setScrollState(2);
        this.z.startScroll(0, 0, i, i2, i4);
        b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        RecyclerView recyclerView = this.Z;
        int[] iArr = recyclerView.K1;
        if (recyclerView.H0 == null) {
            recyclerView.removeCallbacks(this);
            this.z.abortAnimation();
            return;
        }
        this.Y = false;
        this.X = true;
        recyclerView.p();
        OverScroller overScroller = this.z;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i4 = currX - this.b;
            int i5 = currY - this.f;
            this.b = currX;
            this.f = currY;
            int iO = RecyclerView.o(i4, recyclerView.c1, recyclerView.e1, recyclerView.getWidth());
            int iO2 = RecyclerView.o(i5, recyclerView.d1, recyclerView.f1, recyclerView.getHeight());
            int[] iArr2 = recyclerView.K1;
            iArr2[0] = 0;
            iArr2[1] = 0;
            if (recyclerView.v(iArr2, iO, null, iO2, 1)) {
                iO -= iArr[0];
                iO2 -= iArr[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.n(iO, iO2);
            }
            if (recyclerView.G0 != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                recyclerView.k0(iO, iO2, iArr);
                i2 = iArr[0];
                int i6 = iArr[1];
                int i7 = iO - i2;
                iO2 -= i6;
                fb2 fb2Var = recyclerView.H0.e;
                if (fb2Var != null && !fb2Var.d && fb2Var.e) {
                    int iB = recyclerView.y1.b();
                    if (iB == 0) {
                        fb2Var.i();
                    } else if (fb2Var.a >= iB) {
                        fb2Var.a = iB - 1;
                        fb2Var.g(i2, i6);
                    } else {
                        fb2Var.g(i2, i6);
                    }
                }
                i = i7;
                i3 = i6;
            } else {
                i = iO;
                i2 = 0;
                i3 = 0;
            }
            if (!recyclerView.J0.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.K1;
            iArr3[0] = 0;
            iArr3[1] = 0;
            recyclerView.w(i2, i3, i, iO2, null, 1, iArr3);
            int i8 = i - iArr[0];
            int i9 = iO2 - iArr[1];
            if (i2 != 0 || i3 != 0) {
                recyclerView.x(i2, i3);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i8 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i9 != 0));
            fb2 fb2Var2 = recyclerView.H0.e;
            if ((fb2Var2 == null || !fb2Var2.d) && z) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i10 = i8 < 0 ? -currVelocity : i8 > 0 ? currVelocity : 0;
                    if (i9 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i9 <= 0) {
                        currVelocity = 0;
                    }
                    if (i10 < 0) {
                        recyclerView.z();
                        if (recyclerView.c1.isFinished()) {
                            recyclerView.c1.onAbsorb(-i10);
                        }
                    } else if (i10 > 0) {
                        recyclerView.A();
                        if (recyclerView.e1.isFinished()) {
                            recyclerView.e1.onAbsorb(i10);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.B();
                        if (recyclerView.d1.isFinished()) {
                            recyclerView.d1.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.y();
                        if (recyclerView.f1.isFinished()) {
                            recyclerView.f1.onAbsorb(currVelocity);
                        }
                    }
                    if (i10 != 0 || currVelocity != 0) {
                        recyclerView.postInvalidateOnAnimation();
                    }
                }
                if (RecyclerView.Y1) {
                    r02 r02Var = recyclerView.x1;
                    int[] iArr4 = (int[]) r02Var.d;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    r02Var.c = 0;
                }
            } else {
                b();
                in1 in1Var = recyclerView.w1;
                if (in1Var != null) {
                    in1Var.a(recyclerView, i2, i3);
                }
            }
            if (Build.VERSION.SDK_INT >= 35) {
                uf3.a(recyclerView, Math.abs(overScroller.getCurrVelocity()));
            }
        }
        fb2 fb2Var3 = recyclerView.H0.e;
        if (fb2Var3 != null && fb2Var3.d) {
            fb2Var3.g(0, 0);
        }
        this.X = false;
        if (!this.Y) {
            recyclerView.setScrollState(0);
            recyclerView.s0(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = wp4.a;
            recyclerView.postOnAnimation(this);
        }
    }
}
