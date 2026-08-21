package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.os.Trace;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.p;
import androidx.fragment.app.u;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.ui.activity.MainActivity;
import com.getsurfboard.ui.activity.NATDetectActivity;
import com.getsurfboard.ui.activity.TrafficListActivity;
import com.getsurfboard.ui.fragment.FdCountFragment;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a;
import io.sentry.android.core.d;
import io.sentry.p4;
import io.sentry.util.b;
import io.sentry.util.f;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ga1 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ ga1(a aVar, st4 st4Var) {
        this.b = 28;
        this.f = aVar;
    }

    private final void a() {
        sx1 sx1Var = (sx1) this.f;
        synchronized (sx1Var.N0) {
            try {
                sx1Var.P0 = null;
                my1 my1Var = sx1Var.O0;
                if (my1Var != null) {
                    sx1Var.O0 = null;
                    sx1Var.e(my1Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        j80 j80Var = (j80) this.f;
        j80Var.g();
        v92 v92Var = (v92) j80Var.d;
        Set<ah> setKeySet = (HashSet) j80Var.h;
        synchronized (v92Var.b) {
            if (setKeySet == null) {
                try {
                    setKeySet = ((HashMap) v92Var.f).keySet();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (ah ahVar : setKeySet) {
                if (((HashMap) v92Var.f).containsKey(ahVar)) {
                    v92Var.t((s92) ((HashMap) v92Var.f).get(ahVar));
                }
            }
        }
    }

    private final void c() {
        se2 se2Var = (se2) this.f;
        if (se2Var.isAdded() && se2Var.A) {
            synchronized (se2Var.y0) {
                if (se2Var.y0.isEmpty()) {
                    if (se2Var.A) {
                        se2Var.z0.postDelayed(se2Var.A0, 50L);
                    }
                    return;
                }
                int iMin = Math.min(se2Var.y0.size(), 100);
                ArrayList arrayList = new ArrayList(se2Var.y0.subList(0, iMin));
                se2Var.y0.subList(0, iMin).clear();
                se2Var.z.t(arrayList);
                if (se2Var.A) {
                    se2Var.z0.postDelayed(se2Var.A0, 50L);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ge0 ge0Var = null;
        int i = 0;
        switch (this.b) {
            case 0:
                p activity = ((ma1) this.f).getActivity();
                if (activity != null) {
                    activity.invalidateOptionsMenu();
                    return;
                }
                return;
            case 1:
                FdCountFragment fdCountFragment = (FdCountFragment) this.f;
                ji0.B(uf2.t(fdCountFragment), null, null, new mt(fdCountFragment, ge0Var, 4), 3);
                return;
            case 2:
                bi1 bi1Var = (bi1) this.f;
                synchronized (bi1Var.c) {
                    try {
                        if (bi1Var.g == null) {
                            return;
                        }
                        try {
                            ki1 ki1VarD = bi1Var.d();
                            int i2 = ki1VarD.f;
                            if (i2 == 2) {
                                synchronized (bi1Var.c) {
                                }
                            }
                            if (i2 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i2 + ")");
                            }
                            try {
                                Method method = zf4.b;
                                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                Context context = bi1Var.a;
                                ki1[] ki1VarArr = {ki1VarD};
                                uf2 uf2Var = dk4.a;
                                Trace.beginSection(vo.O("TypefaceCompat.createFromFontInfo"));
                                try {
                                    Typeface typefaceM = dk4.a.m(context, ki1VarArr, 0);
                                    Trace.endSection();
                                    MappedByteBuffer mappedByteBufferY = vf2.y(bi1Var.a, ki1VarD.a);
                                    if (mappedByteBufferY == null || typefaceM == null) {
                                        throw new RuntimeException("Unable to open file.");
                                    }
                                    try {
                                        Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                        iv1 iv1Var = new iv1(typefaceM, ke0.u(mappedByteBufferY));
                                        Trace.endSection();
                                        synchronized (bi1Var.c) {
                                            try {
                                                fx3 fx3Var = bi1Var.g;
                                                if (fx3Var != null) {
                                                    fx3Var.y(iv1Var);
                                                }
                                            } finally {
                                            }
                                            break;
                                        }
                                        bi1Var.b();
                                        return;
                                    } finally {
                                        Method method2 = zf4.b;
                                    }
                                } finally {
                                    Trace.endSection();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        } catch (Throwable th2) {
                            synchronized (bi1Var.c) {
                                try {
                                    fx3 fx3Var2 = bi1Var.g;
                                    if (fx3Var2 != null) {
                                        fx3Var2.x(th2);
                                    }
                                    bi1Var.b();
                                    return;
                                } finally {
                                }
                            }
                        }
                    } finally {
                    }
                }
            case 3:
                Iterator it = ((u) this.f).o.iterator();
                while (it.hasNext()) {
                    ((n33) it.next()).getClass();
                }
                return;
            case 4:
                ((ScheduledFuture) this.f).cancel(true);
                return;
            case 5:
                ((vv) this.f).b(null);
                return;
            case 6:
                ((t4) this.f).a();
                return;
            case 7:
                String message = ((Exception) this.f).getMessage();
                if (message != null) {
                    p95.D(message);
                    return;
                }
                return;
            case 8:
                a();
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                b();
                return;
            case 10:
                v32 v32Var = (v32) this.f;
                if (v32Var != null) {
                    v32Var.g(null);
                    return;
                }
                return;
            case 11:
                c();
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                MainActivity mainActivity = (MainActivity) this.f;
                int i3 = MainActivity.T0;
                mainActivity.x(mainActivity.getIntent());
                return;
            case 13:
                MaterialButton materialButton = (MaterialButton) this.f;
                int[] iArr = MaterialButton.c1;
                materialButton.p();
                return;
            case 14:
                h4 h4Var = ((NATDetectActivity) this.f).S0;
                if (h4Var == null) {
                    n12.T("binding");
                    throw null;
                }
                NestedScrollView nestedScrollView = (NestedScrollView) h4Var.g;
                nestedScrollView.scrollTo(0, nestedScrollView.getBottom());
                return;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                ((j43) this.f).p();
                return;
            case 16:
                ProcessLifecycleOwner processLifecycleOwner = (ProcessLifecycleOwner) this.f;
                fa2 fa2Var = processLifecycleOwner.Y;
                if (processLifecycleOwner.f == 0) {
                    processLifecycleOwner.z = true;
                    fa2Var.f(p92.ON_PAUSE);
                }
                if (processLifecycleOwner.b == 0 && processLifecycleOwner.z) {
                    fa2Var.f(p92.ON_STOP);
                    processLifecycleOwner.A = true;
                    return;
                }
                return;
            case 17:
                d83 d83Var = (d83) this.f;
                bx0 bx0Var = d83Var.A;
                String str = (String) bx0Var.g;
                if (str != null) {
                    List list = bx0Var.d.f;
                    list.getClass();
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            i = -1;
                        } else if (!n12.c(((zk) it2.next()).getName(), str)) {
                            i++;
                        }
                    }
                    y3 y3Var = d83Var.b;
                    y3Var.getClass();
                    ((RecyclerView) y3Var.j).l0(i);
                    return;
                }
                return;
            case 18:
                ql3 ql3Var = (ql3) this.f;
                boolean z = ql3Var.c > 0;
                if (ql3Var.o.compareAndSet(false, true) && z) {
                    ji0.B(ql3Var.l.f(), ql3Var.r, null, new tl3(ql3Var, ge0Var, i), 2);
                    return;
                }
                return;
            case 19:
                mo moVar = (mo) this.f;
                moVar.c = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) moVar.e;
                zp4 zp4Var = sideSheetBehavior.z0;
                if (zp4Var != null && zp4Var.h()) {
                    moVar.a(moVar.b);
                    return;
                } else {
                    if (sideSheetBehavior.y0 == 2) {
                        sideSheetBehavior.x(moVar.b);
                        return;
                    }
                    return;
                }
            case 20:
                zy0 zy0Var = (zy0) ((n02) this.f).A;
                if (zy0Var != null) {
                    Iterator it3 = zy0Var.values().iterator();
                    while (it3.hasNext()) {
                        ((c74) it3.next()).b();
                    }
                    return;
                }
                return;
            case 21:
                ((m10) this.f).e();
                return;
            case 22:
                zi3 zi3Var = (zi3) this.f;
                int i4 = SurfboardVpn.I0;
                ij3 ij3VarU = oj0.a.u();
                ij3VarU.getClass();
                ke0.r(ij3VarU.a, false, true, new gj(18, ij3VarU, zi3Var));
                return;
            case 23:
                u84 u84Var = ((w84) this.f).a;
                ViewParent parent = u84Var.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(u84Var);
                    return;
                }
                return;
            case 24:
                ((sa4) this.f).c();
                return;
            case 25:
                TextInputLayout textInputLayout = (TextInputLayout) this.f;
                int[][] iArr2 = TextInputLayout.U1;
                textInputLayout.y0.requestLayout();
                return;
            case 26:
                v92 v92Var = ((TrafficListActivity) this.f).S0;
                if (v92Var != null) {
                    ((RecyclerView) v92Var.z).l0(0);
                    return;
                } else {
                    n12.T("binding");
                    throw null;
                }
            case 27:
                File[] fileArrListFiles = ((File) this.f).listFiles();
                if (fileArrListFiles == null) {
                    return;
                }
                int length = fileArrListFiles.length;
                while (i < length) {
                    File file = fileArrListFiles[i];
                    if (file.lastModified() < p4.f - 300000) {
                        b.g(file);
                    }
                    i++;
                }
                return;
            case 28:
                a aVar = (a) this.f;
                aVar.y0 = SystemClock.uptimeMillis();
                aVar.z0.set(false);
                return;
            default:
                ((FrameMetricsAggregator) ((f) ((d) this.f).a).a()).a.w();
                return;
        }
    }

    public /* synthetic */ ga1(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }
}
