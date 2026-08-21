package defpackage;

import android.os.Process;
import android.util.Log;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.getsurfboard.ui.activity.MainActivity;
import com.getsurfboard.ui.activity.SettingsActivity;
import com.tencent.mars.xlog.Xlog;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xu implements ag1 {
    public final /* synthetic */ int b;
    public final Object f;

    public xu(qs3 qs3Var) {
        this.b = 1;
        qs3Var.getClass();
        this.f = qs3Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r6.r(r7, r1) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(tz1 tz1Var, ge0 ge0Var) {
        wu wuVar;
        v92 v92Var = (v92) this.f;
        if (ge0Var instanceof wu) {
            wuVar = (wu) ge0Var;
            int i = wuVar.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                wuVar.Z = i - Integer.MIN_VALUE;
            } else {
                wuVar = new wu(this, ge0Var);
            }
        }
        Object obj = wuVar.X;
        int i2 = wuVar.Z;
        mf0 mf0Var = mf0.b;
        if (i2 == 0) {
            n12.S(obj);
            hv3 hv3Var = (hv3) v92Var.f;
            wuVar.A = tz1Var;
            wuVar.Z = 1;
            if (hv3Var.h(tz1Var, wuVar) != mf0Var) {
            }
            return mf0Var;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                n12.S(obj);
                return xl4.a;
            }
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        tz1Var = wuVar.A;
        n12.S(obj);
        qt qtVar = (qt) v92Var.b;
        wuVar.A = null;
        wuVar.Z = 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(jy2 jy2Var, ge0 ge0Var) {
        wy2 wy2Var;
        if (ge0Var instanceof wy2) {
            wy2Var = (wy2) ge0Var;
            int i = wy2Var.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                wy2Var.Y = i - Integer.MIN_VALUE;
            } else {
                wy2Var = new wy2(this, ge0Var);
            }
        }
        Object obj = wy2Var.A;
        int i2 = wy2Var.Y;
        try {
            if (i2 == 0) {
                n12.S(obj);
                hx3 hx3Var = (hx3) this.f;
                wy2Var.Y = 1;
                Object objA = hx3Var.f.a(wy2Var, jy2Var);
                mf0 mf0Var = mf0.b;
                if (objA == mf0Var) {
                    return mf0Var;
                }
            } else {
                if (i2 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
            }
        } catch (c60 unused) {
        }
        return xl4.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00eb  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) {
        Object objG;
        jg1 jg1Var;
        Object obj2 = obj;
        int i = 1;
        xl4 xl4Var = null;
        switch (this.b) {
            case 0:
                return a((tz1) obj2, ge0Var);
            case 1:
                Object objA = ((qs3) this.f).a(ge0Var, obj2);
                return objA == mf0.b ? objA : xl4.a;
            case 2:
                hj3 hj3Var = (hj3) ((j80) this.f).b;
                if (hj3Var.a.f) {
                    throw new CancellationException("PagingSource is invalid");
                }
                hj3Var.a();
                return xl4.a;
            case 3:
                xh0 xh0Var = (xh0) this.f;
                j80 j80Var = xh0Var.b;
                j80Var.getClass();
                ((LinearLayout) j80Var.f).post(new qh0(xh0Var, i));
                return xl4.a;
            case 4:
                xl4 xl4Var2 = xl4.a;
                lj0 lj0Var = (lj0) this.f;
                return ((lj0Var.y0.s() instanceof qe1) || (objG = lj0Var.g(true, ge0Var)) != mf0.b) ? xl4Var2 : objG;
            case 5:
                if (ge0Var instanceof jg1) {
                    jg1Var = (jg1) ge0Var;
                    int i2 = jg1Var.Y;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        jg1Var.Y = i2 - Integer.MIN_VALUE;
                    } else {
                        jg1Var = new jg1(this, ge0Var);
                    }
                }
                Object obj3 = jg1Var.A;
                mf0 mf0Var = mf0.b;
                int i3 = jg1Var.Y;
                if (i3 == 0) {
                    n12.S(obj3);
                    q53 q53Var = (q53) this.f;
                    if (obj2 == null) {
                        obj2 = at2.a;
                    }
                    jg1Var.Y = 1;
                    if (q53Var.A.a(jg1Var, obj2) == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i3 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj3);
                }
                return xl4.a;
            case 6:
                xl4 xl4Var3 = xl4.a;
                cr1 cr1Var = (cr1) obj2;
                ha1 ha1Var = ((vh1) this.f).d;
                if (ha1Var != null) {
                    SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) ha1Var.f;
                    slidingPaneLayout.P0 = cr1Var;
                    w20 w20Var = new w20();
                    w20Var.z = 300L;
                    w20Var.A = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
                    ah4.a(slidingPaneLayout, w20Var);
                    slidingPaneLayout.requestLayout();
                    xl4Var = xl4Var3;
                }
                return xl4Var == mf0.b ? xl4Var : xl4Var3;
            case 7:
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "MainActivity", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "Color palette changed, recreating MainActivity");
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("MainActivity", "Color palette changed, recreating MainActivity", null);
                }
                e4.A((MainActivity) this.f);
                return xl4.a;
            case 8:
                return b((jy2) obj2, ge0Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ((xp) this.f).e((xl4) obj2);
                return xl4.a;
            default:
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "SettingsActivity", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "Color palette changed, recreating SettingsActivity");
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("SettingsActivity", "Color palette changed, recreating SettingsActivity", null);
                }
                e4.A((SettingsActivity) this.f);
                return xl4.a;
        }
    }

    public /* synthetic */ xu(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }
}
