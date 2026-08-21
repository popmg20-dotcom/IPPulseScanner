package defpackage;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
import com.getsurfboard.ui.activity.TrafficListActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.CheckableImageButton;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.sentry.ILogger;
import io.sentry.a7;
import io.sentry.android.core.FeedbackShakeIntegration;
import io.sentry.android.core.j0;
import io.sentry.android.core.u1;
import io.sentry.android.core.z;
import io.sentry.android.core.z0;
import io.sentry.android.replay.capture.c;
import io.sentry.android.replay.capture.o;
import io.sentry.android.replay.util.j;
import io.sentry.c7;
import io.sentry.cache.a;
import io.sentry.cache.b;
import io.sentry.cache.tape.d;
import io.sentry.cache.tape.i;
import io.sentry.d1;
import io.sentry.h4;
import io.sentry.k7;
import io.sentry.n;
import io.sentry.n2;
import io.sentry.p1;
import io.sentry.p2;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.util.e;
import io.sentry.util.g;
import io.sentry.w6;
import io.sentry.x6;
import io.sentry.z6;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o73 implements mu2, ji2, yd3, ha4, l4, b40, ChannelFactory, zm2, t0, e64, ny1, c7, h4, u1, e {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ o73(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                d83 d83Var = (d83) obj;
                view.getClass();
                yu4 yu4Var = bv4Var.a;
                y3 y3Var = d83Var.b;
                y3Var.getClass();
                FloatingActionButton floatingActionButton = (FloatingActionButton) y3Var.d;
                ViewGroup.LayoutParams layoutParams = floatingActionButton.getLayoutParams();
                if (layoutParams != null) {
                    te0 te0Var = (te0) layoutParams;
                    if (d83Var.getResources().getBoolean(R.bool.bottom_bar_displayed)) {
                        te0Var.setMargins(((ViewGroup.MarginLayoutParams) te0Var).leftMargin, ((ViewGroup.MarginLayoutParams) te0Var).topMargin, ((ViewGroup.MarginLayoutParams) te0Var).rightMargin, ContextUtilsKt.e(R.dimen.fab_margin));
                    } else {
                        te0Var.setMargins(((ViewGroup.MarginLayoutParams) te0Var).leftMargin, ((ViewGroup.MarginLayoutParams) te0Var).topMargin, ((ViewGroup.MarginLayoutParams) te0Var).rightMargin, ContextUtilsKt.e(R.dimen.fab_margin) + yu4Var.h(519).d);
                    }
                    floatingActionButton.setLayoutParams(te0Var);
                    y3 y3Var2 = d83Var.b;
                    y3Var2.getClass();
                    FragmentContainerView fragmentContainerView = (FragmentContainerView) y3Var2.e;
                    ViewGroup.LayoutParams layoutParams2 = fragmentContainerView.getLayoutParams();
                    if (layoutParams2 != null) {
                        te0 te0Var2 = (te0) layoutParams2;
                        if (d83Var.getResources().getBoolean(R.bool.bottom_bar_displayed)) {
                            te0Var2.setMargins(((ViewGroup.MarginLayoutParams) te0Var2).leftMargin, ((ViewGroup.MarginLayoutParams) te0Var2).topMargin, ((ViewGroup.MarginLayoutParams) te0Var2).rightMargin, ContextUtilsKt.e(R.dimen.fab_margin));
                        } else {
                            te0Var2.setMargins(((ViewGroup.MarginLayoutParams) te0Var2).leftMargin, ((ViewGroup.MarginLayoutParams) te0Var2).topMargin, ((ViewGroup.MarginLayoutParams) te0Var2).rightMargin, ContextUtilsKt.e(R.dimen.fab_margin) + yu4Var.h(519).d);
                        }
                        fragmentContainerView.setLayoutParams(te0Var2);
                        return bv4Var;
                    }
                    zo2.n("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                } else {
                    zo2.n("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                }
                return null;
            case 3:
                view.getClass();
                ed4 ed4Var = ((ya3) obj).b;
                ed4Var.getClass();
                RecyclerView recyclerView = (RecyclerView) ed4Var.A;
                recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), ContextUtilsKt.c(16.0f) + bv4Var.a.h(519).d);
                return bv4Var;
            case 7:
                view.getClass();
                RecyclerView listView = ((hu3) obj).getListView();
                listView.getClass();
                listView.setPadding(listView.getPaddingLeft(), listView.getPaddingTop(), listView.getPaddingRight(), bv4Var.a.h(519).d);
                return bv4Var;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                w84 w84Var = (w84) obj;
                ArrayList arrayList = w84Var.b;
                yu4 yu4Var2 = bv4Var.a;
                t02 t02VarB = t02.b(yu4Var2.h(519), yu4Var2.h(64));
                t02 t02VarB2 = t02.b(yu4Var2.i(519), yu4Var2.i(64));
                if (!t02VarB.equals(w84Var.c) || !t02VarB2.equals(w84Var.d)) {
                    w84Var.c = t02VarB;
                    w84Var.d = t02VarB2;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = ((h93) arrayList.get(size)).a;
                        int size2 = arrayList2.size() - 1;
                        if (size2 >= 0) {
                            throw qe4.r(arrayList2, size2);
                        }
                    }
                }
                return bv4Var;
            default:
                TrafficListActivity trafficListActivity = (TrafficListActivity) obj;
                int i2 = TrafficListActivity.V0;
                view.getClass();
                yu4 yu4Var3 = bv4Var.a;
                v92 v92Var = trafficListActivity.S0;
                if (v92Var == null) {
                    n12.T("binding");
                    throw null;
                }
                RecyclerView recyclerView2 = (RecyclerView) v92Var.z;
                recyclerView2.setPadding(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), recyclerView2.getPaddingRight(), yu4Var3.h(519).d);
                v92 v92Var2 = trafficListActivity.S0;
                if (v92Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) v92Var2.b;
                coordinatorLayout.getClass();
                coordinatorLayout.setPadding(yu4Var3.h(519).a, coordinatorLayout.getPaddingTop(), yu4Var3.h(519).c, coordinatorLayout.getPaddingBottom());
                return bv4Var;
        }
    }

    @Override // defpackage.ha4
    public void a(fa4 fa4Var, int i) {
        int i2 = this.b;
        Object obj = this.f;
        switch (i2) {
            case 4:
                fa4Var.a(((ka3) ((List) obj).get(i)).b);
                break;
            default:
                fa4Var.a(((na3) ((ArrayList) obj).get(i)).getName());
                break;
        }
    }

    @Override // defpackage.e64
    public f64 b(a40 a40Var) {
        Context context = (Context) this.f;
        String str = (String) a40Var.A;
        t6 t6Var = (t6) a40Var.X;
        t6Var.getClass();
        if (str != null && str.length() != 0) {
            return new ll1(context, str, t6Var, true, true);
        }
        xe.k("Must set a non-null database name to a configuration that uses the no backup directory.");
        return null;
    }

    @Override // io.sentry.android.core.u1
    public void c() {
        FeedbackShakeIntegration feedbackShakeIntegration = (FeedbackShakeIntegration) this.f;
        WeakReference weakReference = feedbackShakeIntegration.A;
        Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
        Boolean bool = j0.X.A;
        if (activity == null || feedbackShakeIntegration.z == null || feedbackShakeIntegration.X || Boolean.TRUE.equals(bool)) {
            return;
        }
        activity.runOnUiThread(new z(3, feedbackShakeIntegration, activity));
    }

    @Override // io.sentry.c7
    public void d(a7 a7Var) {
        x6 x6Var = (x6) this.f;
        n nVar = x6Var.q;
        if (nVar != null) {
            nVar.b(a7Var);
        }
        w6 w6Var = x6Var.f;
        k7 k7Var = x6Var.r;
        if (k7Var.g == null) {
            if (w6Var.a) {
                x6Var.t(w6Var.b, null);
                return;
            }
            return;
        }
        if (k7Var.f) {
            ListIterator listIterator = x6Var.c.listIterator();
            while (listIterator.hasNext()) {
                a7 a7Var2 = (a7) listIterator.next();
                if (!a7Var2.f && a7Var2.b == null) {
                    return;
                }
            }
        }
        x6Var.p();
    }

    @Override // io.sentry.util.e
    public Object e() {
        i iVar;
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 27:
                return ((b) obj).b.getSerializer();
            case 28:
                io.sentry.cache.e eVar = (io.sentry.cache.e) obj;
                p6 p6Var = eVar.a;
                File fileB = a.b(p6Var, ".scope-cache");
                if (fileB == null) {
                    p6Var.getLogger().h(p5.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
                    return new io.sentry.cache.tape.b();
                }
                File file = new File(fileB, "breadcrumbs.json");
                try {
                    int maxBreadcrumbs = p6Var.getMaxBreadcrumbs();
                    RandomAccessFile randomAccessFileG = i.g(file);
                    try {
                        try {
                            iVar = new i(file, randomAccessFileG, maxBreadcrumbs);
                        } catch (Throwable th) {
                            randomAccessFileG.close();
                            throw th;
                        }
                    } catch (IOException e) {
                        p6Var.getLogger().d(p5.ERROR, "Failed to create breadcrumbs queue", e);
                        return new io.sentry.cache.tape.b();
                    }
                    break;
                } catch (IOException unused) {
                    file.delete();
                    int maxBreadcrumbs2 = p6Var.getMaxBreadcrumbs();
                    RandomAccessFile randomAccessFileG2 = i.g(file);
                    try {
                        iVar = new i(file, randomAccessFileG2, maxBreadcrumbs2);
                    } catch (Throwable th2) {
                        randomAccessFileG2.close();
                        throw th2;
                    }
                    break;
                }
                return new d(iVar, new n2(5, eVar));
            default:
                return Boolean.valueOf(g.d("androidx.core.app.FrameMetricsAggregator", (ILogger) obj));
        }
    }

    @Override // defpackage.t0
    public void f(int i, Object[] objArr) {
        lw4 lw4Var = (lw4) this.f;
        CodeEditor codeEditor = lw4Var.b;
        if (codeEditor != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : objArr) {
                arrayList.add((kw4) obj);
            }
            Collections.sort(arrayList);
            codeEditor.b0(new b0(18, lw4Var, codeEditor, arrayList));
        }
    }

    @Override // defpackage.b40
    public void g() {
        g24 g24Var = (g24) this.f;
        CheckableImageButton checkableImageButton = g24Var.A;
        v02.P(checkableImageButton, g24Var.C0, checkableImageButton.getContentDescription());
    }

    @Override // defpackage.l4
    public void h(Object obj) {
        QRCodeScannerActivity qRCodeScannerActivity = (QRCodeScannerActivity) this.f;
        Uri uri = (Uri) obj;
        int i = QRCodeScannerActivity.Y0;
        if (uri != null) {
            ji0.B(uf2.t(qRCodeScannerActivity), null, null, new cc3(qRCodeScannerActivity, uri, null, 1), 3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    @Override // defpackage.zm2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(lk3 lk3Var, int i) {
        List listV0;
        String str;
        cd cdVar = (cd) this.f;
        ev1 ev1Var = lk3Var.b;
        Object obj = null;
        if (i == 0) {
            throw null;
        }
        if (i != 2) {
            return;
        }
        Iterator it = ((List) lk3Var.g.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((l83) next) instanceof tv0) {
                obj = next;
                break;
            }
        }
        tv0 tv0Var = (tv0) obj;
        if (tv0Var == null || (str = tv0Var.a) == null) {
            int i2 = fv1.a;
            ArrayList arrayList = ev1Var.f;
            if (arrayList.isEmpty()) {
                listV0 = g41.b;
                str = (String) d70.l0(listV0);
                if (str == null) {
                }
            } else {
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                while (listIterator.hasPrevious()) {
                    if (!n12.c((String) listIterator.previous(), "")) {
                        listV0 = d70.v0(listIterator.nextIndex() + 1, arrayList);
                        break;
                    }
                }
                listV0 = g41.b;
                str = (String) d70.l0(listV0);
                if (str == null) {
                    str = "";
                }
            }
        }
        cdVar.k(str, ev1Var.i);
    }

    @Override // io.sentry.h4
    public void m(d1 d1Var) {
        z6 z6VarP;
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 19:
                d1Var.D(new ed(23, (p1) obj, d1Var));
                break;
            case 20:
            default:
                o oVar = (o) obj;
                d1Var.getClass();
                d1Var.h(oVar.d());
                String strC = d1Var.C();
                String strP0 = strC != null ? p44.P0(strC, '.', strC) : null;
                io.sentry.android.replay.capture.b bVar = oVar.l;
                int i2 = 2;
                d82 d82Var = io.sentry.android.replay.capture.d.u[2];
                bVar.getClass();
                d82Var.getClass();
                Object andSet = bVar.b.getAndSet(strP0);
                if (!n12.c(andSet, strP0)) {
                    c cVar = new c(andSet, strP0, bVar.d, i2);
                    io.sentry.android.replay.capture.d dVar = bVar.c;
                    p6 p6Var = dVar.a;
                    if (p6Var.getThreadChecker().c()) {
                        dVar.e.submit(new j(new p2(8, cVar), "CaptureStrategy.runInBackground"));
                    } else {
                        try {
                            cVar.a();
                        } catch (Throwable th) {
                            p6Var.getLogger().d(p5.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
                        }
                    }
                }
                break;
            case 21:
                AtomicLong atomicLong = ((z0) obj).b;
                if (atomicLong.get() == 0 && (z6VarP = d1Var.p()) != null) {
                    atomicLong.set(z6VarP.b.getTime());
                    break;
                }
                break;
            case 22:
                AtomicBoolean atomicBoolean = (AtomicBoolean) obj;
                if (d1Var.p() != null) {
                    atomicBoolean.set(true);
                }
                break;
            case 23:
                d1Var.D(new ed(28, (io.sentry.android.core.internal.gestures.g) obj, d1Var));
                break;
            case 24:
                ((p1[]) obj)[0] = d1Var.i();
                break;
            case 25:
                d1Var.getClass();
                d1Var.h(((io.sentry.android.replay.capture.g) obj).d());
                break;
        }
    }

    @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
    public Channel newChannel() {
        return new g93(((i94) this.f).g);
    }

    @Override // defpackage.ny1
    public void o(oy1 oy1Var) throws Exception {
        dz4 dz4Var = (dz4) this.f;
        dz4Var.getClass();
        try {
            my1 my1VarI = oy1Var.i();
            if (my1VarI != null) {
                dz4Var.c.j(my1VarI);
            }
        } catch (IllegalStateException e) {
            ez4.q("ZslControlImpl", "Failed to acquire latest image IllegalStateException = " + e.getMessage());
        }
    }

    @Override // defpackage.yd3
    public ByteArrayInputStream read() {
        return (ByteArrayInputStream) this.f;
    }

    public /* synthetic */ o73(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj2;
    }
}
