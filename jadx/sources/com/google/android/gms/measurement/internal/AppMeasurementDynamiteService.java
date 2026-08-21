package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import defpackage.a55;
import defpackage.ab5;
import defpackage.bu2;
import defpackage.ca5;
import defpackage.d20;
import defpackage.d45;
import defpackage.d65;
import defpackage.d84;
import defpackage.ea5;
import defpackage.f85;
import defpackage.g45;
import defpackage.h85;
import defpackage.i45;
import defpackage.ia5;
import defpackage.ib5;
import defpackage.ie;
import defpackage.ie5;
import defpackage.j45;
import defpackage.k45;
import defpackage.k85;
import defpackage.ka5;
import defpackage.mb5;
import defpackage.ne5;
import defpackage.ob5;
import defpackage.pa5;
import defpackage.q65;
import defpackage.qa5;
import defpackage.qf5;
import defpackage.rb5;
import defpackage.s35;
import defpackage.sa5;
import defpackage.t65;
import defpackage.tj4;
import defpackage.tm1;
import defpackage.um1;
import defpackage.v35;
import defpackage.wv1;
import defpackage.x15;
import defpackage.x35;
import defpackage.x65;
import defpackage.xe;
import defpackage.y25;
import defpackage.y35;
import defpackage.yb5;
import defpackage.z25;
import defpackage.zf5;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class AppMeasurementDynamiteService extends s35 {
    public k85 c;
    public final ie d;

    public AppMeasurementDynamiteService() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        this.c = null;
        this.d = new ie(0);
    }

    public final void b() {
        if (this.c != null) {
            return;
        }
        xe.q("Attempting to perform action before initialize.");
    }

    @Override // defpackage.t35
    public void beginAdUnitExposure(String str, long j) {
        b();
        d45 d45Var = this.c.E0;
        k85.e(d45Var);
        d45Var.W0(j, str);
    }

    public final void c(String str, v35 v35Var) {
        b();
        qf5 qf5Var = this.c.z0;
        k85.f(qf5Var);
        qf5Var.F1(str, v35Var);
    }

    @Override // defpackage.t35
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        ib5Var.j1(str, str2, bundle);
    }

    @Override // defpackage.t35
    public void clearMeasurementEnabled(long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        ib5Var.W0();
        f85 f85Var = ((k85) ib5Var.f).Z;
        k85.h(f85Var);
        f85Var.e1(new tm1(18, ib5Var, null, false));
    }

    @Override // defpackage.t35
    public void endAdUnitExposure(String str, long j) {
        b();
        d45 d45Var = this.c.E0;
        k85.e(d45Var);
        d45Var.X0(j, str);
    }

    @Override // defpackage.t35
    public void generateEventId(v35 v35Var) {
        b();
        qf5 qf5Var = this.c.z0;
        k85.f(qf5Var);
        long jT1 = qf5Var.T1();
        b();
        qf5 qf5Var2 = this.c.z0;
        k85.f(qf5Var2);
        qf5Var2.G1(v35Var, jT1);
    }

    @Override // defpackage.t35
    public void getAppInstanceId(v35 v35Var) {
        b();
        f85 f85Var = this.c.Z;
        k85.h(f85Var);
        f85Var.e1(new h85(this, v35Var, 0));
    }

    @Override // defpackage.t35
    public void getCachedAppInstanceId(v35 v35Var) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        c((String) ib5Var.A0.get(), v35Var);
    }

    @Override // defpackage.t35
    public void getConditionalUserProperties(String str, String str2, v35 v35Var) {
        b();
        f85 f85Var = this.c.Z;
        k85.h(f85Var);
        f85Var.e1(new d20(this, v35Var, str, str2, 6));
    }

    @Override // defpackage.t35
    public void getCurrentScreenClass(v35 v35Var) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        yb5 yb5Var = ((k85) ib5Var.f).C0;
        k85.g(yb5Var);
        rb5 rb5Var = yb5Var.Y;
        c(rb5Var != null ? rb5Var.b : null, v35Var);
    }

    @Override // defpackage.t35
    public void getCurrentScreenName(v35 v35Var) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        yb5 yb5Var = ((k85) ib5Var.f).C0;
        k85.g(yb5Var);
        rb5 rb5Var = yb5Var.Y;
        c(rb5Var != null ? rb5Var.a : null, v35Var);
    }

    @Override // defpackage.t35
    public void getGmpAppId(v35 v35Var) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        c(ib5Var.k1(), v35Var);
    }

    @Override // defpackage.t35
    public void getMaxUserProperties(String str, v35 v35Var) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        tj4.f(str);
        x15 x15Var = ((k85) ib5Var.f).A;
        b();
        qf5 qf5Var = this.c.z0;
        k85.f(qf5Var);
        qf5Var.H1(v35Var, 25);
    }

    @Override // defpackage.t35
    public void getSessionId(v35 v35Var) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        f85 f85Var = ((k85) ib5Var.f).Z;
        k85.h(f85Var);
        f85Var.e1(new um1(ib5Var, v35Var));
    }

    @Override // defpackage.t35
    public void getTestFlag(v35 v35Var, int i) {
        b();
        if (i == 0) {
            qf5 qf5Var = this.c.z0;
            k85.f(qf5Var);
            ib5 ib5Var = this.c.D0;
            k85.g(ib5Var);
            AtomicReference atomicReference = new AtomicReference();
            f85 f85Var = ((k85) ib5Var.f).Z;
            k85.h(f85Var);
            qf5Var.F1((String) f85Var.f1(atomicReference, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME, "String test flag value", new pa5(ib5Var, atomicReference, 1)), v35Var);
            return;
        }
        if (i == 1) {
            qf5 qf5Var2 = this.c.z0;
            k85.f(qf5Var2);
            ib5 ib5Var2 = this.c.D0;
            k85.g(ib5Var2);
            AtomicReference atomicReference2 = new AtomicReference();
            f85 f85Var2 = ((k85) ib5Var2.f).Z;
            k85.h(f85Var2);
            qf5Var2.G1(v35Var, ((Long) f85Var2.f1(atomicReference2, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME, "long test flag value", new sa5(ib5Var2, atomicReference2, 0))).longValue());
            return;
        }
        if (i == 2) {
            qf5 qf5Var3 = this.c.z0;
            k85.f(qf5Var3);
            ib5 ib5Var3 = this.c.D0;
            k85.g(ib5Var3);
            AtomicReference atomicReference3 = new AtomicReference();
            f85 f85Var3 = ((k85) ib5Var3.f).Z;
            k85.h(f85Var3);
            double dDoubleValue = ((Double) f85Var3.f1(atomicReference3, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME, "double test flag value", new sa5(ib5Var3, atomicReference3, 1))).doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", dDoubleValue);
            try {
                v35Var.t(bundle);
                return;
            } catch (RemoteException e) {
                t65 t65Var = ((k85) qf5Var3.f).Y;
                k85.h(t65Var);
                t65Var.C0.b(e, "Error returning double value to wrapper");
                return;
            }
        }
        if (i == 3) {
            qf5 qf5Var4 = this.c.z0;
            k85.f(qf5Var4);
            ib5 ib5Var4 = this.c.D0;
            k85.g(ib5Var4);
            AtomicReference atomicReference4 = new AtomicReference();
            f85 f85Var4 = ((k85) ib5Var4.f).Z;
            k85.h(f85Var4);
            qf5Var4.H1(v35Var, ((Integer) f85Var4.f1(atomicReference4, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME, "int test flag value", new pa5(ib5Var4, atomicReference4, 2))).intValue());
            return;
        }
        if (i != 4) {
            return;
        }
        qf5 qf5Var5 = this.c.z0;
        k85.f(qf5Var5);
        ib5 ib5Var5 = this.c.D0;
        k85.g(ib5Var5);
        AtomicReference atomicReference5 = new AtomicReference();
        f85 f85Var5 = ((k85) ib5Var5.f).Z;
        k85.h(f85Var5);
        qf5Var5.J1(v35Var, ((Boolean) f85Var5.f1(atomicReference5, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME, "boolean test flag value", new pa5(ib5Var5, atomicReference5, 0))).booleanValue());
    }

    @Override // defpackage.t35
    public void getUserProperties(String str, String str2, boolean z, v35 v35Var) {
        b();
        f85 f85Var = this.c.Z;
        k85.h(f85Var);
        f85Var.e1(new ia5(this, v35Var, str, str2, z));
    }

    @Override // defpackage.t35
    public void initForTests(Map map) {
        b();
    }

    @Override // defpackage.t35
    public void initialize(wv1 wv1Var, j45 j45Var, long j) {
        k85 k85Var = this.c;
        if (k85Var == null) {
            Context context = (Context) bu2.G(wv1Var);
            tj4.i(context);
            this.c = k85.m(context, j45Var, Long.valueOf(j));
        } else {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.C0.a("Attempting to initialize multiple times");
        }
    }

    @Override // defpackage.t35
    public void isDataCollectionEnabled(v35 v35Var) {
        b();
        f85 f85Var = this.c.Z;
        k85.h(f85Var);
        f85Var.e1(new h85(this, v35Var, 1));
    }

    @Override // defpackage.t35
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        ib5Var.a1(str, str2, bundle, z, z2, j);
    }

    @Override // defpackage.t35
    public void logEventAndBundle(String str, String str2, Bundle bundle, v35 v35Var, long j) {
        b();
        tj4.f(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        z25 z25Var = new z25(str2, new y25(bundle), "app", j);
        f85 f85Var = this.c.Z;
        k85.h(f85Var);
        f85Var.e1(new d20(this, v35Var, z25Var, str, 3));
    }

    @Override // defpackage.t35
    public void logHealthData(int i, String str, wv1 wv1Var, wv1 wv1Var2, wv1 wv1Var3) {
        b();
        Object objG = wv1Var == null ? null : bu2.G(wv1Var);
        Object objG2 = wv1Var2 == null ? null : bu2.G(wv1Var2);
        Object objG3 = wv1Var3 != null ? bu2.G(wv1Var3) : null;
        t65 t65Var = this.c.Y;
        k85.h(t65Var);
        t65Var.a1(i, true, false, str, objG, objG2, objG3);
    }

    @Override // defpackage.t35
    public void onActivityCreated(wv1 wv1Var, Bundle bundle, long j) {
        b();
        Activity activity = (Activity) bu2.G(wv1Var);
        tj4.i(activity);
        onActivityCreatedByScionActivityInfo(k45.a(activity), bundle, j);
    }

    @Override // defpackage.t35
    public void onActivityCreatedByScionActivityInfo(k45 k45Var, Bundle bundle, long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        a55 a55Var = ib5Var.Y;
        if (a55Var != null) {
            ib5 ib5Var2 = this.c.D0;
            k85.g(ib5Var2);
            ib5Var2.o1();
            a55Var.c(k45Var, bundle);
        }
    }

    @Override // defpackage.t35
    public void onActivityDestroyed(wv1 wv1Var, long j) {
        b();
        Activity activity = (Activity) bu2.G(wv1Var);
        tj4.i(activity);
        onActivityDestroyedByScionActivityInfo(k45.a(activity), j);
    }

    @Override // defpackage.t35
    public void onActivityDestroyedByScionActivityInfo(k45 k45Var, long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        a55 a55Var = ib5Var.Y;
        if (a55Var != null) {
            ib5 ib5Var2 = this.c.D0;
            k85.g(ib5Var2);
            ib5Var2.o1();
            a55Var.d(k45Var);
        }
    }

    @Override // defpackage.t35
    public void onActivityPaused(wv1 wv1Var, long j) {
        b();
        Activity activity = (Activity) bu2.G(wv1Var);
        tj4.i(activity);
        onActivityPausedByScionActivityInfo(k45.a(activity), j);
    }

    @Override // defpackage.t35
    public void onActivityPausedByScionActivityInfo(k45 k45Var, long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        a55 a55Var = ib5Var.Y;
        if (a55Var != null) {
            ib5 ib5Var2 = this.c.D0;
            k85.g(ib5Var2);
            ib5Var2.o1();
            a55Var.e(k45Var);
        }
    }

    @Override // defpackage.t35
    public void onActivityResumed(wv1 wv1Var, long j) {
        b();
        Activity activity = (Activity) bu2.G(wv1Var);
        tj4.i(activity);
        onActivityResumedByScionActivityInfo(k45.a(activity), j);
    }

    @Override // defpackage.t35
    public void onActivityResumedByScionActivityInfo(k45 k45Var, long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        a55 a55Var = ib5Var.Y;
        if (a55Var != null) {
            ib5 ib5Var2 = this.c.D0;
            k85.g(ib5Var2);
            ib5Var2.o1();
            a55Var.f(k45Var);
        }
    }

    @Override // defpackage.t35
    public void onActivitySaveInstanceState(wv1 wv1Var, v35 v35Var, long j) {
        b();
        Activity activity = (Activity) bu2.G(wv1Var);
        tj4.i(activity);
        onActivitySaveInstanceStateByScionActivityInfo(k45.a(activity), v35Var, j);
    }

    @Override // defpackage.t35
    public void onActivitySaveInstanceStateByScionActivityInfo(k45 k45Var, v35 v35Var, long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        a55 a55Var = ib5Var.Y;
        Bundle bundle = new Bundle();
        if (a55Var != null) {
            ib5 ib5Var2 = this.c.D0;
            k85.g(ib5Var2);
            ib5Var2.o1();
            a55Var.g(k45Var, bundle);
        }
        try {
            v35Var.t(bundle);
        } catch (RemoteException e) {
            t65 t65Var = this.c.Y;
            k85.h(t65Var);
            t65Var.C0.b(e, "Error returning bundle value to wrapper");
        }
    }

    @Override // defpackage.t35
    public void onActivityStarted(wv1 wv1Var, long j) {
        b();
        Activity activity = (Activity) bu2.G(wv1Var);
        tj4.i(activity);
        onActivityStartedByScionActivityInfo(k45.a(activity), j);
    }

    @Override // defpackage.t35
    public void onActivityStartedByScionActivityInfo(k45 k45Var, long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        if (ib5Var.Y != null) {
            ib5 ib5Var2 = this.c.D0;
            k85.g(ib5Var2);
            ib5Var2.o1();
        }
    }

    @Override // defpackage.t35
    public void onActivityStopped(wv1 wv1Var, long j) {
        b();
        Activity activity = (Activity) bu2.G(wv1Var);
        tj4.i(activity);
        onActivityStoppedByScionActivityInfo(k45.a(activity), j);
    }

    @Override // defpackage.t35
    public void onActivityStoppedByScionActivityInfo(k45 k45Var, long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        if (ib5Var.Y != null) {
            ib5 ib5Var2 = this.c.D0;
            k85.g(ib5Var2);
            ib5Var2.o1();
        }
    }

    @Override // defpackage.t35
    public void performAction(Bundle bundle, v35 v35Var, long j) {
        b();
        v35Var.t(null);
    }

    @Override // defpackage.t35
    public void registerOnMeasurementEventListener(g45 g45Var) {
        zf5 zf5Var;
        b();
        ie ieVar = this.d;
        synchronized (ieVar) {
            try {
                y35 y35Var = (y35) g45Var;
                Parcel parcelB = y35Var.b(y35Var.c(), 2);
                int i = parcelB.readInt();
                parcelB.recycle();
                zf5Var = (zf5) ieVar.get(Integer.valueOf(i));
                if (zf5Var == null) {
                    zf5Var = new zf5(this, y35Var);
                    Parcel parcelB2 = y35Var.b(y35Var.c(), 2);
                    int i2 = parcelB2.readInt();
                    parcelB2.recycle();
                    ieVar.put(Integer.valueOf(i2), zf5Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        ib5Var.W0();
        if (ib5Var.y0.add(zf5Var)) {
            return;
        }
        t65 t65Var = ((k85) ib5Var.f).Y;
        k85.h(t65Var);
        t65Var.C0.a("OnEventListener already registered");
    }

    @Override // defpackage.t35
    public void resetAnalyticsData(long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        ib5Var.A0.set(null);
        f85 f85Var = ((k85) ib5Var.f).Z;
        k85.h(f85Var);
        f85Var.e1(new ka5(ib5Var, j, 1));
    }

    @Override // defpackage.t35
    public void retrieveAndUploadBatches(x35 x35Var) {
        ob5 ob5Var;
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        ib5Var.W0();
        k85 k85Var = (k85) ib5Var.f;
        f85 f85Var = k85Var.Z;
        k85.h(f85Var);
        if (f85Var.b1()) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.a("Cannot retrieve and upload batches from analytics worker thread");
            return;
        }
        f85 f85Var2 = k85Var.Z;
        k85.h(f85Var2);
        if (Thread.currentThread() == f85Var2.Z) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.z0.a("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        boolean zJ = d84.j();
        t65 t65Var3 = k85Var.Y;
        if (zJ) {
            k85.h(t65Var3);
            t65Var3.z0.a("Cannot retrieve and upload batches from main thread");
            return;
        }
        k85.h(t65Var3);
        t65Var3.H0.a("[sgtm] Started client-side batch upload work.");
        boolean z = false;
        int size = 0;
        int i = 0;
        while (!z) {
            t65 t65Var4 = k85Var.Y;
            k85.h(t65Var4);
            t65Var4.H0.a("[sgtm] Getting upload batches from service (FE)");
            AtomicReference atomicReference = new AtomicReference();
            f85 f85Var3 = k85Var.Z;
            k85.h(f85Var3);
            f85Var3.f1(atomicReference, 10000L, "[sgtm] Getting upload batches", new pa5(ib5Var, atomicReference, 3));
            ne5 ne5Var = (ne5) atomicReference.get();
            if (ne5Var == null) {
                break;
            }
            List list = ne5Var.b;
            if (list.isEmpty()) {
                break;
            }
            t65 t65Var5 = k85Var.Y;
            k85.h(t65Var5);
            t65Var5.H0.b(Integer.valueOf(list.size()), "[sgtm] Retrieved upload batches. count");
            size += list.size();
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ie5 ie5Var = (ie5) it.next();
                try {
                    URL url = new URI(ie5Var.z).toURL();
                    AtomicReference atomicReference2 = new AtomicReference();
                    d65 d65VarL = ((k85) ib5Var.f).l();
                    d65VarL.W0();
                    tj4.i(d65VarL.A0);
                    String str = d65VarL.A0;
                    k85 k85Var2 = (k85) ib5Var.f;
                    t65 t65Var6 = k85Var2.Y;
                    k85.h(t65Var6);
                    q65 q65Var = t65Var6.H0;
                    Long lValueOf = Long.valueOf(ie5Var.b);
                    q65Var.d("[sgtm] Uploading data from app. row_id, url, uncompressed size", lValueOf, ie5Var.z, Integer.valueOf(ie5Var.f.length));
                    if (!TextUtils.isEmpty(ie5Var.Z)) {
                        t65 t65Var7 = k85Var2.Y;
                        k85.h(t65Var7);
                        t65Var7.H0.c("[sgtm] Uploading data from app. row_id", lValueOf, ie5Var.Z);
                    }
                    HashMap map = new HashMap();
                    Bundle bundle = ie5Var.A;
                    for (String str2 : bundle.keySet()) {
                        String string = bundle.getString(str2);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(str2, string);
                        }
                    }
                    mb5 mb5Var = k85Var2.F0;
                    k85.h(mb5Var);
                    byte[] bArr = ie5Var.f;
                    ab5 ab5Var = new ab5(ib5Var, atomicReference2, ie5Var);
                    mb5Var.X0();
                    tj4.i(url);
                    tj4.i(bArr);
                    f85 f85Var4 = ((k85) mb5Var.f).Z;
                    k85.h(f85Var4);
                    f85Var4.h1(new x65(mb5Var, str, url, bArr, map, ab5Var));
                    try {
                        qf5 qf5Var = k85Var2.z0;
                        k85.f(qf5Var);
                        k85 k85Var3 = (k85) qf5Var.f;
                        k85Var3.B0.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis() + 60000;
                        synchronized (atomicReference2) {
                            for (long jCurrentTimeMillis2 = 60000; atomicReference2.get() == null && jCurrentTimeMillis2 > 0; jCurrentTimeMillis2 = jCurrentTimeMillis - System.currentTimeMillis()) {
                                try {
                                    atomicReference2.wait(jCurrentTimeMillis2);
                                    k85Var3.B0.getClass();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    } catch (InterruptedException unused) {
                        t65 t65Var8 = ((k85) ib5Var.f).Y;
                        k85.h(t65Var8);
                        t65Var8.C0.a("[sgtm] Interrupted waiting for uploading batch");
                    }
                    ob5Var = atomicReference2.get() == null ? ob5.UNKNOWN : (ob5) atomicReference2.get();
                } catch (MalformedURLException | URISyntaxException e) {
                    t65 t65Var9 = ((k85) ib5Var.f).Y;
                    k85.h(t65Var9);
                    t65Var9.z0.d("[sgtm] Bad upload url for row_id", ie5Var.z, Long.valueOf(ie5Var.b), e);
                    ob5Var = ob5.FAILURE;
                }
                if (ob5Var != ob5.SUCCESS) {
                    if (ob5Var == ob5.BACKOFF) {
                        z = true;
                        break;
                    }
                } else {
                    i++;
                }
            }
        }
        t65 t65Var10 = k85Var.Y;
        k85.h(t65Var10);
        t65Var10.H0.c("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(size), Integer.valueOf(i));
        try {
            x35Var.d();
        } catch (RemoteException e2) {
            k85 k85Var4 = this.c;
            tj4.i(k85Var4);
            t65 t65Var11 = k85Var4.Y;
            k85.h(t65Var11);
            t65Var11.C0.b(e2, "Failed to call IDynamiteUploadBatchesCallback");
        }
    }

    @Override // defpackage.t35
    public void setConditionalUserProperty(Bundle bundle, long j) {
        b();
        k85 k85Var = this.c;
        if (bundle == null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.a("Conditional user property must not be null");
        } else {
            ib5 ib5Var = k85Var.D0;
            k85.g(ib5Var);
            ib5Var.i1(bundle, j);
        }
    }

    @Override // defpackage.t35
    public void setConsentThirdParty(Bundle bundle, long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        ib5Var.p1(bundle, -20, j);
    }

    @Override // defpackage.t35
    public void setCurrentScreen(wv1 wv1Var, String str, String str2, long j) {
        b();
        Activity activity = (Activity) bu2.G(wv1Var);
        tj4.i(activity);
        setCurrentScreenByScionActivityInfo(k45.a(activity), str, str2, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r2 <= 500) goto L31;
     */
    @Override // defpackage.t35
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCurrentScreenByScionActivityInfo(defpackage.k45 r5, java.lang.String r6, java.lang.String r7, long r8) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.setCurrentScreenByScionActivityInfo(k45, java.lang.String, java.lang.String, long):void");
    }

    @Override // defpackage.t35
    public void setDataCollectionEnabled(boolean z) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        ib5Var.W0();
        f85 f85Var = ((k85) ib5Var.f).Z;
        k85.h(f85Var);
        f85Var.e1(new ea5(ib5Var, z));
    }

    @Override // defpackage.t35
    public void setDefaultEventParameters(Bundle bundle) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        f85 f85Var = ((k85) ib5Var.f).Z;
        k85.h(f85Var);
        f85Var.e1(new qa5(ib5Var, bundle2, 1));
    }

    @Override // defpackage.t35
    public void setEventInterceptor(g45 g45Var) {
        b();
        ca5 ca5Var = new ca5(this, g45Var);
        f85 f85Var = this.c.Z;
        k85.h(f85Var);
        boolean zB1 = f85Var.b1();
        k85 k85Var = this.c;
        if (!zB1) {
            f85 f85Var2 = k85Var.Z;
            k85.h(f85Var2);
            f85Var2.e1(new tm1(19, this, ca5Var, z));
            return;
        }
        ib5 ib5Var = k85Var.D0;
        k85.g(ib5Var);
        ib5Var.V0();
        ib5Var.W0();
        ca5 ca5Var2 = ib5Var.Z;
        if (ca5Var != ca5Var2) {
            tj4.k("EventInterceptor already set.", ca5Var2 == null);
        }
        ib5Var.Z = ca5Var;
    }

    @Override // defpackage.t35
    public void setInstanceIdProvider(i45 i45Var) {
        b();
    }

    @Override // defpackage.t35
    public void setMeasurementEnabled(boolean z, long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        Boolean boolValueOf = Boolean.valueOf(z);
        ib5Var.W0();
        f85 f85Var = ((k85) ib5Var.f).Z;
        k85.h(f85Var);
        f85Var.e1(new tm1(18, ib5Var, boolValueOf, false));
    }

    @Override // defpackage.t35
    public void setMinimumSessionDuration(long j) {
        b();
    }

    @Override // defpackage.t35
    public void setSessionTimeoutDuration(long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        f85 f85Var = ((k85) ib5Var.f).Z;
        k85.h(f85Var);
        f85Var.e1(new ka5(ib5Var, j, 0));
    }

    @Override // defpackage.t35
    public void setSgtmDebugInfo(Intent intent) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        k85 k85Var = (k85) ib5Var.f;
        Uri data = intent.getData();
        if (data == null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.F0.a("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals("1")) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.F0.a("[sgtm] Preview Mode was not enabled.");
            k85Var.A.Y = null;
            return;
        }
        String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        t65 t65Var3 = k85Var.Y;
        k85.h(t65Var3);
        t65Var3.F0.b(queryParameter2, "[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ");
        k85Var.A.Y = queryParameter2;
    }

    @Override // defpackage.t35
    public void setUserId(String str, long j) {
        b();
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        k85 k85Var = (k85) ib5Var.f;
        if (str != null && TextUtils.isEmpty(str)) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.C0.a("User ID must be non-empty or null");
        } else {
            f85 f85Var = k85Var.Z;
            k85.h(f85Var);
            f85Var.e1(new um1(21, ib5Var, str));
            ib5Var.f1(null, "_id", str, true, j);
        }
    }

    @Override // defpackage.t35
    public void setUserProperty(String str, String str2, wv1 wv1Var, boolean z, long j) {
        b();
        Object objG = bu2.G(wv1Var);
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        ib5Var.f1(str, str2, objG, z, j);
    }

    @Override // defpackage.t35
    public void unregisterOnMeasurementEventListener(g45 g45Var) {
        y35 y35Var;
        zf5 zf5Var;
        b();
        ie ieVar = this.d;
        synchronized (ieVar) {
            y35Var = (y35) g45Var;
            Parcel parcelB = y35Var.b(y35Var.c(), 2);
            int i = parcelB.readInt();
            parcelB.recycle();
            zf5Var = (zf5) ieVar.remove(Integer.valueOf(i));
        }
        if (zf5Var == null) {
            zf5Var = new zf5(this, y35Var);
        }
        ib5 ib5Var = this.c.D0;
        k85.g(ib5Var);
        ib5Var.W0();
        if (ib5Var.y0.remove(zf5Var)) {
            return;
        }
        t65 t65Var = ((k85) ib5Var.f).Y;
        k85.h(t65Var);
        t65Var.C0.a("OnEventListener had not been registered");
    }

    @Override // defpackage.t35
    public void setConsent(Bundle bundle, long j) {
    }
}
