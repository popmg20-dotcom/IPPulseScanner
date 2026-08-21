package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.h;
import androidx.fragment.app.i;
import androidx.fragment.app.u;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.ui.fragment.MemoryUsageFragment;
import com.getsurfboard.ui.fragment.card.NetworkSpeedFragment;
import com.getsurfboard.ui.widget.SparklineView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f33 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ f33(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    private final void a() {
        try {
            c();
        } catch (Error e) {
            synchronized (((at3) this.f).b) {
                ((at3) this.f).A = 1;
                throw e;
            }
        }
    }

    private final void b() {
        ua4 ua4VarB;
        long jNanoTime;
        ua4 ua4VarB2;
        ab4 ab4Var = (ab4) this.f;
        synchronized (ab4Var) {
            ab4Var.g++;
            ua4VarB = ab4Var.b();
        }
        if (ua4VarB == null) {
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        while (true) {
            try {
                threadCurrentThread.setName(ua4VarB.a);
                Logger logger = ((ab4) this.f).b;
                za4 za4Var = ua4VarB.c;
                za4Var.getClass();
                boolean zIsLoggable = logger.isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jNanoTime = System.nanoTime();
                    ye.D(logger, ua4VarB, za4Var, "starting");
                } else {
                    jNanoTime = -1;
                }
                try {
                    long jA = ua4VarB.a();
                    if (zIsLoggable) {
                        ye.D(logger, ua4VarB, za4Var, "finished run in " + ye.s(System.nanoTime() - jNanoTime));
                    }
                    ab4 ab4Var2 = (ab4) this.f;
                    synchronized (ab4Var2) {
                        ab4Var2.a(ua4VarB, jA, true);
                        ua4VarB2 = ab4Var2.b();
                    }
                    if (ua4VarB2 == null) {
                        return;
                    } else {
                        ua4VarB = ua4VarB2;
                    }
                } catch (Throwable th) {
                    if (zIsLoggable) {
                        ye.D(logger, ua4VarB, za4Var, "failed a run in " + ye.s(System.nanoTime() - jNanoTime));
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    ab4 ab4Var3 = (ab4) this.f;
                    synchronized (ab4Var3) {
                        ab4Var3.a(ua4VarB, -1L, false);
                        if (!(th2 instanceof InterruptedException)) {
                            throw th2;
                        }
                        Thread.currentThread().interrupt();
                        return;
                    }
                } finally {
                    threadCurrentThread.setName(name);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r1 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
    
        r4.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        defpackage.ez4.r("SequentialExecutor", "Exception while executing runnable " + r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x003a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        Runnable runnable;
        boolean z = false;
        boolean zInterrupted = false;
        while (true) {
            try {
                synchronized (((at3) this.f).b) {
                    if (z) {
                        runnable = (Runnable) ((at3) this.f).b.poll();
                        if (runnable != null) {
                        }
                    } else {
                        at3 at3Var = (at3) this.f;
                        if (at3Var.A != 4) {
                            at3Var.X++;
                            at3Var.A = 4;
                            z = true;
                            runnable = (Runnable) ((at3) this.f).b.poll();
                            if (runnable != null) {
                                ((at3) this.f).A = 1;
                            }
                        }
                    }
                }
                if (!zInterrupted) {
                    return;
                }
            } finally {
                if (zInterrupted) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010e A[PHI: r12
      0x010e: PHI (r12v8 long) = (r12v6 long), (r12v11 long) binds: [B:70:0x011c, B:63:0x0109] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int iJ;
        Object obj;
        long j;
        long j2;
        int iJ2 = 0;
        switch (this.b) {
            case 0:
                RecyclerView recyclerView = ((j33) this.f).mList;
                recyclerView.focusableViewAvailable(recyclerView);
                return;
            case 1:
                mc2 mc2Var = (mc2) this.f;
                jy0 jy0Var = mc2Var.z;
                hg hgVar = mc2Var.b;
                if (mc2Var.E0) {
                    if (mc2Var.C0) {
                        mc2Var.C0 = false;
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        hgVar.e = jCurrentAnimationTimeMillis;
                        hgVar.g = -1L;
                        hgVar.f = jCurrentAnimationTimeMillis;
                        hgVar.h = 0.5f;
                    }
                    if ((hgVar.g > 0 && AnimationUtils.currentAnimationTimeMillis() > hgVar.g + ((long) hgVar.i)) || !mc2Var.e()) {
                        mc2Var.E0 = false;
                        return;
                    }
                    if (mc2Var.D0) {
                        mc2Var.D0 = false;
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                        jy0Var.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (hgVar.f == 0) {
                        zo2.w("Cannot compute scroll delta before calling start()");
                        return;
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fA = hgVar.a(jCurrentAnimationTimeMillis2);
                    long j3 = jCurrentAnimationTimeMillis2 - hgVar.f;
                    hgVar.f = jCurrentAnimationTimeMillis2;
                    mc2Var.G0.scrollListBy((int) (j3 * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * hgVar.d));
                    WeakHashMap weakHashMap = wp4.a;
                    jy0Var.postOnAnimation(this);
                    return;
                }
                return;
            case 2:
                mo moVar = (mo) this.f;
                moVar.c = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) moVar.e;
                zp4 zp4Var = bottomSheetBehavior.g1;
                if (zp4Var != null && zp4Var.h()) {
                    moVar.a(moVar.b);
                    return;
                } else {
                    if (bottomSheetBehavior.f1 == 2) {
                        bottomSheetBehavior.O(moVar.b);
                        return;
                    }
                    return;
                }
            case 3:
                y3 y3Var = ((BypassConfigActivity) this.f).S0;
                if (y3Var == null) {
                    n12.T("binding");
                    throw null;
                }
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                coordinatorLayout.getClass();
                r25.R(coordinatorLayout, R.string.bypass_config_imported, new Object[0]);
                return;
            case 4:
                xh0 xh0Var = (xh0) this.f;
                if (xh0Var.b == null) {
                    return;
                }
                if (!t23.c(R.string.setting_accessibility_mode_key, false)) {
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - zw1.g) / 1000;
                    long j4 = jElapsedRealtime / 3600;
                    if (j4 > 99) {
                        j4 = 99;
                    }
                    long j5 = jElapsedRealtime % 3600;
                    j80 j80Var = xh0Var.b;
                    j80Var.getClass();
                    ((ExtendedFloatingActionButton) j80Var.b).setText(String.format(Locale.getDefault(), "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j4), Long.valueOf(j5 / 60), Long.valueOf(j5 % 60)}, 3)));
                }
                j80 j80Var2 = xh0Var.b;
                j80Var2.getClass();
                ((ExtendedFloatingActionButton) j80Var2.b).setContentDescription(xh0Var.getString(R.string.stop_vpn));
                j80 j80Var3 = xh0Var.b;
                j80Var3.getClass();
                ((ExtendedFloatingActionButton) j80Var3.b).postDelayed(this, 1000L);
                return;
            case 5:
                i iVar = (i) this.f;
                iVar.A.onDismiss(iVar.C0);
                return;
            case 6:
                k8 k8Var = (k8) this.f;
                k8Var.a(true);
                k8Var.invalidateSelf();
                return;
            case 7:
                jy0 jy0Var2 = (jy0) this.f;
                jy0Var2.F0 = null;
                jy0Var2.drawableStateChanged();
                return;
            case 8:
                ((n01) this.f).r();
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                cc1 cc1Var = (cc1) this.f;
                ValueAnimator valueAnimator = cc1Var.z;
                int i = cc1Var.A;
                if (i == 1) {
                    valueAnimator.cancel();
                } else if (i != 2) {
                    return;
                }
                cc1Var.A = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500L);
                valueAnimator.start();
                return;
            case 10:
                h hVar = (h) this.f;
                if (hVar.b.isEmpty()) {
                    return;
                }
                hVar.e();
                return;
            case 11:
                ((u) this.f).z(true);
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                kk1 kk1Var = (kk1) this.f;
                kk1Var.k = false;
                kk1Var.t();
                return;
            case 13:
                ((nc2) this.f).cancel(true);
                return;
            case 14:
                ed4 ed4Var = (ed4) this.f;
                wq1 wq1Var = (wq1) ed4Var.A;
                if (wq1Var.b.getAndSet(null) != null) {
                    ((Handler) ed4Var.f).removeCallbacks(wq1Var);
                    return;
                }
                return;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                k22 k22Var = (k22) this.f;
                i22 i22Var = k22Var.m;
                if (k22Var.c != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j6 = k22Var.B;
                    long j7 = j6 == Long.MIN_VALUE ? 0L : jCurrentTimeMillis - j6;
                    ag3 layoutManager = k22Var.r.getLayoutManager();
                    Rect rect = k22Var.A;
                    if (rect == null) {
                        rect = new Rect();
                        k22Var.A = rect;
                    }
                    View view = k22Var.c.a;
                    RecyclerView recyclerView2 = layoutManager.b;
                    if (recyclerView2 == null) {
                        rect.set(0, 0, 0, 0);
                    } else {
                        rect.set(recyclerView2.Q(view));
                    }
                    if (layoutManager.d()) {
                        int i2 = (int) (k22Var.j + k22Var.h);
                        iJ = (i2 - k22Var.A.left) - k22Var.r.getPaddingLeft();
                        float f = k22Var.h;
                        if ((f >= 0.0f || iJ >= 0) && (f <= 0.0f || (iJ = ((k22Var.c.a.getWidth() + i2) + k22Var.A.right) - (k22Var.r.getWidth() - k22Var.r.getPaddingRight())) <= 0)) {
                            iJ = 0;
                        }
                    }
                    if (layoutManager.e()) {
                        int i3 = (int) (k22Var.k + k22Var.i);
                        int paddingTop = (i3 - k22Var.A.top) - k22Var.r.getPaddingTop();
                        float f2 = k22Var.i;
                        if ((f2 < 0.0f && paddingTop < 0) || (f2 > 0.0f && (paddingTop = ((k22Var.c.a.getHeight() + i3) + k22Var.A.bottom) - (k22Var.r.getHeight() - k22Var.r.getPaddingBottom())) > 0)) {
                            iJ2 = paddingTop;
                        }
                    }
                    if (iJ != 0) {
                        RecyclerView recyclerView3 = k22Var.r;
                        int width = k22Var.c.a.getWidth();
                        k22Var.r.getWidth();
                        iJ = i22Var.j(recyclerView3, width, iJ, j7);
                    }
                    int i4 = iJ;
                    if (iJ2 != 0) {
                        RecyclerView recyclerView4 = k22Var.r;
                        int height = k22Var.c.a.getHeight();
                        k22Var.r.getHeight();
                        iJ2 = i22Var.j(recyclerView4, height, iJ2, j7);
                    }
                    if (i4 == 0 && iJ2 == 0) {
                        k22Var.B = Long.MIN_VALUE;
                        return;
                    }
                    if (k22Var.B == Long.MIN_VALUE) {
                        k22Var.B = jCurrentTimeMillis;
                    }
                    k22Var.r.scrollBy(i4, iJ2);
                    rg3 rg3Var = k22Var.c;
                    if (rg3Var != null) {
                        k22Var.q(rg3Var);
                    }
                    k22Var.r.removeCallbacks(k22Var.s);
                    RecyclerView recyclerView5 = k22Var.r;
                    WeakHashMap weakHashMap2 = wp4.a;
                    recyclerView5.postOnAnimation(this);
                    return;
                }
                return;
            case 16:
                yb2 yb2Var = (yb2) this.f;
                yb2Var.f = null;
                yb2Var.b = null;
                return;
            case 17:
                synchronized (((yc2) this.f).a) {
                    obj = ((yc2) this.f).f;
                    ((yc2) this.f).f = yc2.k;
                    break;
                }
                ((yc2) this.f).l(obj);
                return;
            case 18:
                MemoryUsageFragment memoryUsageFragment = (MemoryUsageFragment) this.f;
                ArrayList arrayList = memoryUsageFragment.A;
                Debug.MemoryInfo memoryInfo = memoryUsageFragment.f;
                if (memoryUsageFragment.b == null) {
                    return;
                }
                SystemClock.elapsedRealtime();
                Debug.getMemoryInfo(memoryInfo);
                dk1 dk1Var = memoryUsageFragment.b;
                dk1Var.getClass();
                dk1Var.d.setText(MemoryUsageFragment.j("summary.java-heap", memoryInfo));
                dk1 dk1Var2 = memoryUsageFragment.b;
                dk1Var2.getClass();
                dk1Var2.e.setText(MemoryUsageFragment.j("summary.native-heap", memoryInfo));
                dk1 dk1Var3 = memoryUsageFragment.b;
                dk1Var3.getClass();
                dk1Var3.a.setText(MemoryUsageFragment.j("summary.code", memoryInfo));
                dk1 dk1Var4 = memoryUsageFragment.b;
                dk1Var4.getClass();
                dk1Var4.i.setText(MemoryUsageFragment.j("summary.stack", memoryInfo));
                dk1 dk1Var5 = memoryUsageFragment.b;
                dk1Var5.getClass();
                dk1Var5.c.setText(MemoryUsageFragment.j("summary.graphics", memoryInfo));
                dk1 dk1Var6 = memoryUsageFragment.b;
                dk1Var6.getClass();
                ((TextView) dk1Var6.h).setText(MemoryUsageFragment.j("summary.private-other", memoryInfo));
                dk1 dk1Var7 = memoryUsageFragment.b;
                dk1Var7.getClass();
                ((TextView) dk1Var7.j).setText(MemoryUsageFragment.j("summary.system", memoryInfo));
                dk1 dk1Var8 = memoryUsageFragment.b;
                dk1Var8.getClass();
                ((TextView) dk1Var8.k).setText(MemoryUsageFragment.j("summary.total-pss", memoryInfo));
                dk1 dk1Var9 = memoryUsageFragment.b;
                dk1Var9.getClass();
                ((TextView) dk1Var9.l).setText(MemoryUsageFragment.j("summary.total-swap", memoryInfo));
                try {
                    String memoryStat = memoryInfo.getMemoryStat("summary.total-pss");
                    memoryStat.getClass();
                    arrayList.add(Float.valueOf(Float.parseFloat(memoryStat)));
                    if (arrayList.size() > 90) {
                        arrayList.remove(0);
                    }
                    dk1 dk1Var10 = memoryUsageFragment.b;
                    dk1Var10.getClass();
                    ((SparklineView) dk1Var10.m).setValues(arrayList);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                View view2 = memoryUsageFragment.getView();
                if (view2 != null) {
                    view2.postDelayed(this, 1000L);
                    return;
                }
                return;
            case 19:
                NetworkSpeedFragment networkSpeedFragment = (NetworkSpeedFragment) this.f;
                ArrayList arrayList2 = networkSpeedFragment.A;
                if (networkSpeedFragment.z == null) {
                    return;
                }
                eg4 eg4Var = (eg4) dg4.p.d();
                boolean zE = t23.E();
                if (zE) {
                    j = eg4Var != null ? eg4Var.a : 0L;
                    j2 = eg4Var != null ? eg4Var.b : 0L;
                } else {
                    j = eg4Var != null ? eg4Var.e : 0L;
                    if (eg4Var != null) {
                        j2 = eg4Var.f;
                    }
                }
                float f3 = (zE != networkSpeedFragment.Z || j - networkSpeedFragment.X < 0 || j2 - networkSpeedFragment.Y < 0) ? 0.0f : r5 + r7;
                networkSpeedFragment.Z = zE;
                networkSpeedFragment.X = j;
                networkSpeedFragment.Y = j2;
                arrayList2.add(Float.valueOf(f3));
                if (arrayList2.size() > networkSpeedFragment.f) {
                    arrayList2.remove(0);
                }
                cm2 cm2Var = networkSpeedFragment.z;
                cm2Var.getClass();
                ((SparklineView) cm2Var.X).setValues(arrayList2);
                View view3 = networkSpeedFragment.getView();
                if (view3 != null) {
                    view3.postDelayed(this, 1000L);
                    return;
                }
                return;
            case 20:
                ((m33) this.f).v();
                return;
            case 21:
                a();
                return;
            case 22:
                ((StaggeredGridLayoutManager) this.f).J0();
                return;
            case 23:
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "SurfboardApp", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "update profile due to vpn started");
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("SurfboardApp", "update profile due to vpn started", null);
                }
                ((xw4) this.f).a();
                List list = (List) d73.b.d();
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        tj4.z((zk) it.next(), (xw4) this.f, true);
                    }
                    return;
                }
                return;
            case 24:
                b();
                return;
            case 25:
                CheckableImageButton checkableImageButton = ((TextInputLayout) this.f).z.A0;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            case 26:
                ((Toolbar) this.f).x();
                return;
            case 27:
                kf4 kf4Var = (kf4) this.f;
                Window.Callback callback = kf4Var.m;
                Menu menuP0 = kf4Var.p0();
                nk2 nk2Var = menuP0 instanceof nk2 ? (nk2) menuP0 : null;
                if (nk2Var != null) {
                    nk2Var.y();
                }
                try {
                    menuP0.clear();
                    if (!callback.onCreatePanelMenu(0, menuP0) || !callback.onPreparePanel(0, null, menuP0)) {
                        menuP0.clear();
                        break;
                    }
                    if (nk2Var != null) {
                        nk2Var.x();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (nk2Var != null) {
                        nk2Var.x();
                    }
                    throw th;
                }
            case 28:
                ((zp4) this.f).q(0);
                return;
            default:
                ((sz4) this.f).h();
                return;
        }
    }
}
