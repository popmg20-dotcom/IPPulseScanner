package defpackage;

import android.os.Trace;
import android.view.View;
import io.sentry.ILogger;
import io.sentry.android.core.ViewHierarchyEventProcessor;
import io.sentry.p5;
import io.sentry.protocol.k0;
import io.sentry.protocol.l0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class iw2 implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ iw2(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
        this.X = obj4;
        this.Y = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Object obj = this.Y;
        Object obj2 = this.X;
        Object obj3 = this.A;
        Object obj4 = this.z;
        Object obj5 = this.f;
        switch (i) {
            case 0:
                String str = (String) obj4;
                pl1 pl1Var = (pl1) obj3;
                on2 on2Var = (on2) obj2;
                vv vvVar = (vv) obj;
                ((t60) obj5).getClass();
                boolean zA = vo.A();
                if (zA) {
                    try {
                        Trace.beginSection(vo.O(str));
                    } finally {
                        if (zA) {
                            Trace.endSection();
                        }
                    }
                }
                try {
                    pl1Var.a();
                    hw2 hw2Var = k01.Y;
                    on2Var.i(hw2Var);
                    vvVar.b(hw2Var);
                } catch (Throwable th) {
                    on2Var.i(new gw2(th));
                    vvVar.d(th);
                }
                if (zA) {
                    return;
                } else {
                    return;
                }
            default:
                AtomicReference atomicReference = (AtomicReference) obj5;
                View view = (View) obj4;
                List list = (List) obj3;
                CountDownLatch countDownLatch = (CountDownLatch) obj2;
                ILogger iLogger = (ILogger) obj;
                try {
                    ArrayList arrayList = new ArrayList(1);
                    k0 k0Var = new k0("android_view_system", arrayList);
                    l0 l0VarB = ViewHierarchyEventProcessor.b(view);
                    arrayList.add(l0VarB);
                    ViewHierarchyEventProcessor.a(view, l0VarB, list);
                    atomicReference.set(k0Var);
                    countDownLatch.countDown();
                    return;
                } catch (Throwable th2) {
                    iLogger.d(p5.ERROR, "Failed to process view hierarchy.", th2);
                    return;
                }
        }
    }
}
