package defpackage;

import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.tencent.mars.xlog.Xlog;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d20 implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public d20(ib5 ib5Var, AtomicReference atomicReference, String str, String str2) {
        this.b = 5;
        this.f = atomicReference;
        this.z = str;
        this.A = str2;
        Objects.requireNonNull(ib5Var);
        this.X = ib5Var;
    }

    private final void a() {
        v55 v55Var;
        dd5 dd5Var = (dd5) this.f;
        AtomicReference atomicReference = (AtomicReference) this.z;
        tg5 tg5Var = (tg5) this.A;
        le5 le5Var = (le5) this.X;
        synchronized (atomicReference) {
            try {
                v55Var = dd5Var.Z;
            } catch (RemoteException e) {
                t65 t65Var = ((k85) dd5Var.f).Y;
                k85.h(t65Var);
                t65Var.z0.b(e, "[sgtm] Failed to get upload batches; remote exception");
                atomicReference.notifyAll();
            }
            if (v55Var != null) {
                v55Var.u(tg5Var, le5Var, new cc5(dd5Var, atomicReference));
                dd5Var.i1();
            } else {
                t65 t65Var2 = ((k85) dd5Var.f).Y;
                k85.h(t65Var2);
                t65Var2.z0.a("[sgtm] Failed to get upload batches; not connected to service");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0368  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        v55 v55Var;
        v55 v55Var2;
        byte[] bArrI = null;
        switch (this.b) {
            case 0:
                f20 f20Var = (f20) ((cp1) this.X).f;
                sk2 sk2Var = (sk2) this.z;
                e20 e20Var = (e20) this.f;
                if (e20Var != null) {
                    f20Var.Q0 = true;
                    e20Var.b.c(false);
                    f20Var.Q0 = false;
                }
                if (sk2Var.isEnabled() && sk2Var.hasSubMenu()) {
                    ((nk2) this.A).s(sk2Var, null, 4);
                    return;
                }
                return;
            case 1:
                bu4.i((View) this.f, (fu4) this.z, (e24) this.A);
                ((ValueAnimator) this.X).start();
                return;
            case 2:
                i95 i95Var = (i95) this.f;
                String str = (String) this.z;
                le5 le5Var = (le5) this.A;
                b65 b65Var = (b65) this.X;
                ff5 ff5Var = i95Var.c;
                ff5Var.x();
                ff5Var.C().V0();
                ff5Var.j0();
                m25 m25Var = ff5Var.z;
                ff5.R(m25Var);
                List<if5> listA1 = m25Var.a1(str, le5Var, ((Integer) r55.B.a(null)).intValue());
                ArrayList arrayList = new ArrayList();
                for (if5 if5Var : listA1) {
                    String str2 = if5Var.c;
                    long j = if5Var.h;
                    long j2 = if5Var.a;
                    if (ff5Var.o(str, str2)) {
                        int i = if5Var.i;
                        if (i > 0) {
                            if (i <= ((Integer) r55.z.a(bArrI)).intValue()) {
                                long jMin = Math.min(((Long) r55.x.a(bArrI)).longValue() * (1 << (i - 1)), ((Long) r55.y.a(bArrI)).longValue());
                                ff5Var.z0().getClass();
                                if (System.currentTimeMillis() >= jMin + j) {
                                    Bundle bundle = new Bundle();
                                    for (Map.Entry entry : if5Var.d.entrySet()) {
                                        bundle.putString((String) entry.getKey(), (String) entry.getValue());
                                    }
                                    long j3 = if5Var.a;
                                    j85 j85Var = if5Var.b;
                                    ie5 ie5Var = new ie5(j3, j85Var.a(), if5Var.c, bundle, if5Var.e.b, if5Var.g, "");
                                    try {
                                        g85 g85Var = (g85) z65.I1(j85.u(), ie5Var.f);
                                        for (int i2 = 0; i2 < ((j85) g85Var.f).o(); i2++) {
                                            l85 l85Var = (l85) ((j85) g85Var.f).p(i2).g();
                                            ff5Var.z0().getClass();
                                            long jCurrentTimeMillis = System.currentTimeMillis();
                                            l85Var.c();
                                            ((n85) l85Var.f).d0(jCurrentTimeMillis);
                                            g85Var.c();
                                            ((j85) g85Var.f).w(i2, (n85) l85Var.e());
                                            break;
                                        }
                                        ie5Var.f = ((j85) g85Var.e()).a();
                                        if (Log.isLoggable(ff5Var.n().b1(), 2)) {
                                            z65 z65Var = ff5Var.Z;
                                            ff5.R(z65Var);
                                            ie5Var.Z = z65Var.y1((j85) g85Var.e());
                                        }
                                        arrayList.add(ie5Var);
                                    } catch (pc5 unused) {
                                        ff5Var.n().C0.b(str, "Failed to parse queued batch. appId");
                                    }
                                }
                                bArrI = null;
                            }
                            ff5Var.n().H0.d("[sgtm] batch skipped waiting for next retry. appId, rowId, lastUploadMillis", str, Long.valueOf(j2), Long.valueOf(j));
                            bArrI = null;
                        }
                    } else {
                        ff5Var.n().H0.d("[sgtm] batch skipped due to destination in backoff. appId, rowId, url", str, Long.valueOf(j2), if5Var.c);
                    }
                }
                try {
                    b65Var.v(new ne5(arrayList));
                    ff5Var.n().H0.c("[sgtm] Sending queued upload batches to client. appId, count", str, Integer.valueOf(arrayList.size()));
                    return;
                } catch (RemoteException e) {
                    ff5Var.n().z0.c("[sgtm] Failed to return upload batches for app", str, e);
                    return;
                }
            case 3:
                dd5 dd5VarJ = ((AppMeasurementDynamiteService) this.X).c.j();
                v35 v35Var = (v35) this.f;
                z25 z25Var = (z25) this.z;
                String str3 = (String) this.A;
                dd5VarJ.V0();
                dd5VarJ.W0();
                k85 k85Var = (k85) dd5VarJ.f;
                qf5 qf5Var = k85Var.z0;
                k85.f(qf5Var);
                if (mp1.b.b(((k85) qf5Var.f).b, 12451000) == 0) {
                    dd5VarJ.j1(new d20(dd5VarJ, z25Var, str3, v35Var, 7));
                    return;
                }
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.C0.a("Not bundling data. Service unavailable or out of date");
                qf5 qf5Var2 = k85Var.z0;
                k85.f(qf5Var2);
                qf5Var2.I1(v35Var, new byte[0]);
                return;
            case 4:
                i95 i95Var2 = (i95) this.f;
                Bundle bundle2 = (Bundle) this.z;
                String str4 = (String) this.A;
                tg5 tg5Var = (tg5) this.X;
                ff5 ff5Var2 = i95Var2.c;
                boolean zF1 = ff5Var2.c0().f1(null, r55.W0);
                if (bundle2.isEmpty() && zF1) {
                    m25 m25Var2 = ff5Var2.z;
                    ff5.R(m25Var2);
                    m25Var2.V0();
                    m25Var2.W0();
                    try {
                        m25Var2.K1().execSQL("delete from default_event_params where app_id=?", new String[]{str4});
                        return;
                    } catch (SQLiteException e2) {
                        t65 t65Var2 = ((k85) m25Var2.f).Y;
                        k85.h(t65Var2);
                        t65Var2.z0.b(e2, "Error clearing default event params");
                        return;
                    }
                }
                m25 m25Var3 = ff5Var2.z;
                ff5.R(m25Var3);
                k85 k85Var2 = (k85) m25Var3.f;
                m25Var3.V0();
                m25Var3.W0();
                v25 v25Var = new v25((k85) m25Var3.f, "", str4, "dep", 0L, 0L, bundle2);
                z65 z65Var2 = m25Var3.X.Z;
                ff5.R(z65Var2);
                byte[] bArrA = z65Var2.x1(v25Var).a();
                t65 t65Var3 = k85Var2.Y;
                k85.h(t65Var3);
                t65Var3.H0.c("Saving default event parameters, appId, data size", str4, Integer.valueOf(bArrA.length));
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str4);
                contentValues.put("parameters", bArrA);
                try {
                    if (m25Var3.K1().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                        k85.h(t65Var3);
                        t65Var3.z0.b(t65.Z0(str4), "Failed to insert default event parameters (got -1). appId");
                    }
                } catch (SQLiteException e3) {
                    k85.h(t65Var3);
                    t65Var3.z0.c("Error storing default event parameters. appId", t65.Z0(str4), e3);
                }
                m25 m25Var4 = ff5Var2.z;
                ff5.R(m25Var4);
                long j4 = tg5Var.U0;
                try {
                    if (m25Var4.G1("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str4, String.valueOf(j4)}, 0L) > 0) {
                        return;
                    }
                    if (m25Var4.G1("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str4, String.valueOf(j4)}, 0L) > 0) {
                        m25 m25Var5 = ff5Var2.z;
                        ff5.R(m25Var5);
                        m25Var5.n1(str4, Long.valueOf(j4), null, bundle2);
                        return;
                    }
                    return;
                } catch (SQLiteException e4) {
                    t65 t65Var4 = ((k85) m25Var4.f).Y;
                    k85.h(t65Var4);
                    t65Var4.z0.b(e4, "Error checking backfill conditions");
                    return;
                }
            case 5:
                String str5 = (String) this.z;
                String str6 = (String) this.A;
                dd5 dd5VarJ2 = ((k85) ((ib5) this.X).f).j();
                AtomicReference atomicReference = (AtomicReference) this.f;
                dd5VarJ2.V0();
                dd5VarJ2.W0();
                dd5VarJ2.j1(new w11(dd5VarJ2, atomicReference, str5, str6, dd5VarJ2.l1(false)));
                return;
            case 6:
                dd5 dd5VarJ3 = ((AppMeasurementDynamiteService) this.X).c.j();
                v35 v35Var2 = (v35) this.f;
                String str7 = (String) this.z;
                String str8 = (String) this.A;
                dd5VarJ3.V0();
                dd5VarJ3.W0();
                dd5VarJ3.j1(new w11(dd5VarJ3, str7, str8, dd5VarJ3.l1(false), v35Var2));
                return;
            case 7:
                v35 v35Var3 = (v35) this.A;
                dd5 dd5Var = (dd5) this.X;
                k85 k85Var3 = (k85) dd5Var.f;
                try {
                    try {
                        v55Var = dd5Var.Z;
                    } finally {
                        qf5 qf5Var3 = k85Var3.z0;
                        k85.f(qf5Var3);
                        qf5Var3.I1(v35Var3, null);
                    }
                } catch (RemoteException e5) {
                    t65 t65Var5 = k85Var3.Y;
                    k85.h(t65Var5);
                    t65Var5.z0.b(e5, "Failed to send event to the service to bundle");
                }
                if (v55Var != null) {
                    bArrI = v55Var.i((String) this.z, (z25) this.f);
                    dd5Var.i1();
                    return;
                } else {
                    t65 t65Var6 = k85Var3.Y;
                    k85.h(t65Var6);
                    t65Var6.z0.a("Discarding data. Failed to send event to service to bundle");
                    return;
                }
            case 8:
                dd5 dd5Var2 = (dd5) this.f;
                AtomicReference atomicReference2 = (AtomicReference) this.z;
                tg5 tg5Var2 = (tg5) this.A;
                Bundle bundle3 = (Bundle) this.X;
                synchronized (atomicReference2) {
                    try {
                        v55Var2 = dd5Var2.Z;
                    } catch (RemoteException e6) {
                        t65 t65Var7 = ((k85) dd5Var2.f).Y;
                        k85.h(t65Var7);
                        t65Var7.z0.b(e6, "Failed to request trigger URIs; remote exception");
                        atomicReference2.notifyAll();
                    }
                    if (v55Var2 != null) {
                        v55Var2.m(tg5Var2, bundle3, new bc5(dd5Var2, atomicReference2));
                        dd5Var2.i1();
                        return;
                    } else {
                        t65 t65Var8 = ((k85) dd5Var2.f).Y;
                        k85.h(t65Var8);
                        t65Var8.z0.a("Failed to request trigger URIs; not connected to service");
                        return;
                    }
                }
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                a();
                return;
            default:
                ff5 ff5Var3 = (ff5) ((jf4) this.X).f;
                qf5 qf5VarI0 = ff5Var3.i0();
                ff5Var3.z0().getClass();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                String str9 = (String) this.f;
                z25 z25VarZ1 = qf5VarI0.z1((String) this.z, (Bundle) this.A, "auto", jCurrentTimeMillis2, false);
                tj4.i(z25VarZ1);
                ff5Var3.c(str9, z25VarZ1);
                return;
        }
    }

    public /* synthetic */ d20(Object obj, Object obj2, Object obj3, Object obj4, int i, boolean z) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
        this.X = obj4;
    }

    public /* synthetic */ d20(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.b = i;
        this.X = obj;
        this.f = obj2;
        this.z = obj3;
        this.A = obj4;
    }
}
