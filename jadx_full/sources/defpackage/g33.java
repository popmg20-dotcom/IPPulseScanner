package defpackage;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.OverScroller;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.tencent.mars.xlog.Xlog;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g33 implements Runnable {
    public Object A;
    public final /* synthetic */ int b;
    public Object f;
    public Object z;

    public g33(dd5 dd5Var, AtomicReference atomicReference, tg5 tg5Var) {
        this.b = 10;
        this.f = atomicReference;
        this.z = tg5Var;
        Objects.requireNonNull(dd5Var);
        this.A = dd5Var;
    }

    private final void a() {
        AtomicReference atomicReference;
        dd5 dd5Var;
        k85 k85Var;
        l75 l75Var;
        AtomicReference atomicReference2 = (AtomicReference) this.f;
        synchronized (atomicReference2) {
            try {
                try {
                    dd5Var = (dd5) this.A;
                    k85Var = (k85) dd5Var.f;
                    l75Var = k85Var.X;
                    k85.f(l75Var);
                } catch (RemoteException e) {
                    t65 t65Var = ((k85) ((dd5) this.A).f).Y;
                    k85.h(t65Var);
                    t65Var.z0.b(e, "Failed to get app instance id");
                    atomicReference = (AtomicReference) this.f;
                }
                if (l75Var.c1().i(r95.ANALYTICS_STORAGE)) {
                    v55 v55Var = dd5Var.Z;
                    if (v55Var != null) {
                        atomicReference2.set(v55Var.C((tg5) this.z));
                        String str = (String) atomicReference2.get();
                        if (str != null) {
                            ib5 ib5Var = ((k85) dd5Var.f).D0;
                            k85.g(ib5Var);
                            ib5Var.A0.set(str);
                            l75 l75Var2 = k85Var.X;
                            k85.f(l75Var2);
                            l75Var2.A0.C(str);
                        }
                        dd5Var.i1();
                        atomicReference = (AtomicReference) this.f;
                        atomicReference.notify();
                        return;
                    }
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.z0.a("Failed to get app instance id");
                } else {
                    t65 t65Var3 = k85Var.Y;
                    k85.h(t65Var3);
                    t65Var3.E0.a("Analytics storage consent denied; will not get app instance id");
                    ib5 ib5Var2 = ((k85) dd5Var.f).D0;
                    k85.g(ib5Var2);
                    ib5Var2.A0.set(null);
                    l75 l75Var3 = k85Var.X;
                    k85.f(l75Var3);
                    l75Var3.A0.C(null);
                    atomicReference2.set(null);
                }
                atomicReference2.notify();
            } catch (Throwable th) {
                ((AtomicReference) this.f).notify();
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x023d  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        pk3 pk3Var;
        OverScroller overScroller;
        Object objCall;
        y25 y25Var;
        Cursor cursor;
        if5 if5Var;
        int i;
        long j;
        int i2;
        Cursor cursorQuery;
        if5 if5VarW1;
        Cursor cursor2;
        qf5 qf5Var;
        l75 l75Var;
        t65 t65Var;
        String strC = null;
        switch (this.b) {
            case 0:
                String str = (String) this.z;
                Preference preference = (Preference) this.f;
                j33 j33Var = (j33) this.A;
                rf3 adapter = j33Var.mList.getAdapter();
                if (!(adapter instanceof m33)) {
                    if (adapter == null) {
                        return;
                    }
                    xe.q("Adapter must implement PreferencePositionCallback");
                    return;
                } else {
                    int iT = preference != null ? ((m33) adapter).t(preference) : ((m33) adapter).u(str);
                    RecyclerView recyclerView = j33Var.mList;
                    if (iT != -1) {
                        recyclerView.l0(iT);
                        return;
                    } else {
                        adapter.n(new i33((m33) adapter, recyclerView, preference, str));
                        return;
                    }
                }
            case 1:
                bh3 bh3Var = (bh3) this.z;
                BypassConfigActivity bypassConfigActivity = (BypassConfigActivity) this.f;
                y3 y3Var = bypassConfigActivity.S0;
                if (y3Var == null) {
                    n12.T("binding");
                    throw null;
                }
                ((RecyclerView) y3Var.g).l0(0);
                y3 y3Var2 = bypassConfigActivity.S0;
                if (y3Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((LoadingIndicator) y3Var2.h).setVisibility(8);
                bypassConfigActivity.D();
                if (co4.H()) {
                    y3 y3Var3 = bypassConfigActivity.S0;
                    if (y3Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((Toolbar) y3Var3.c).getMenu().findItem(R.id.select_toggle).setVisible(!((Collection) bh3Var.b).isEmpty());
                } else {
                    boolean zIsEmpty = ((Collection) bh3Var.b).isEmpty();
                    y3 y3Var4 = bypassConfigActivity.S0;
                    if (zIsEmpty) {
                        if (y3Var4 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((ExtendedFloatingActionButton) y3Var4.k).v(1);
                    } else {
                        if (y3Var4 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((ExtendedFloatingActionButton) y3Var4.k).v(0);
                    }
                }
                Runnable runnable = (Runnable) this.A;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            case 2:
                if (((aj3) this.f).g()) {
                    ((aj3) this.f).d("canceled-at-delivery");
                    return;
                }
                ue1 ue1Var = (ue1) this.z;
                ns4 ns4Var = (ns4) ue1Var.A;
                boolean z = ns4Var == null;
                aj3 aj3Var = (aj3) this.f;
                if (z) {
                    aj3Var.c(ue1Var.b);
                } else {
                    synchronized (aj3Var.A) {
                        pk3Var = aj3Var.X;
                        break;
                    }
                    if (pk3Var != null) {
                        pk3Var.f(ns4Var);
                    }
                }
                boolean z2 = ((ue1) this.z).f;
                aj3 aj3Var2 = (aj3) this.f;
                if (z2) {
                    aj3Var2.a("intermediate-response");
                } else {
                    aj3Var2.d("done");
                }
                Runnable runnable2 = (Runnable) this.A;
                if (runnable2 != null) {
                    runnable2.run();
                    return;
                }
                return;
            case 3:
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f;
                jr1 jr1Var = (jr1) this.A;
                View view = (View) this.z;
                if (view == null || (overScroller = jr1Var.A) == null) {
                    return;
                }
                if (overScroller.computeScrollOffset()) {
                    jr1Var.A(coordinatorLayout, view, jr1Var.A.getCurrY());
                    view.postOnAnimation(this);
                    return;
                }
                AppBarLayout appBarLayout = (AppBarLayout) view;
                ((AppBarLayout.BaseBehavior) jr1Var).F(coordinatorLayout, appBarLayout);
                if (appBarLayout.E0) {
                    appBarLayout.e(appBarLayout.f(AppBarLayout.BaseBehavior.C(coordinatorLayout)));
                    return;
                }
                return;
            case 4:
                try {
                    objCall = ((di1) this.f).call();
                    break;
                } catch (Exception unused) {
                    objCall = null;
                }
                ((Handler) this.A).post(new tm1(10, (i01) this.z, objCall));
                return;
            case 5:
                ff5 ff5Var = ((i95) this.A).c;
                ff5Var.x();
                q15 q15Var = (q15) this.f;
                Object objA = q15Var.z.a();
                tg5 tg5Var = (tg5) this.z;
                if (objA == null) {
                    ff5Var.Y(q15Var, tg5Var);
                    return;
                } else {
                    ff5Var.X(q15Var, tg5Var);
                    return;
                }
            case 6:
                z25 z25Var = (z25) this.f;
                tg5 tg5Var2 = (tg5) this.z;
                ff5 ff5Var2 = ((i95) this.A).c;
                if ("_cmp".equals(z25Var.b) && (y25Var = z25Var.f) != null) {
                    Bundle bundle = y25Var.b;
                    if (bundle.size() != 0) {
                        String string = bundle.getString("_cis");
                        if ("referrer broadcast".equals(string) || "referrer API".equals(string)) {
                            ff5Var2.n().F0.b(z25Var.toString(), "Event has been filtered ");
                            z25Var = new z25("_cmpx", y25Var, z25Var.z, z25Var.A);
                        }
                    }
                }
                String str2 = z25Var.b;
                x75 x75Var = ff5Var2.b;
                z65 z65Var = ff5Var2.Z;
                ff5.R(x75Var);
                String str3 = tg5Var2.b;
                l35 l35Var = TextUtils.isEmpty(str3) ? null : (l35) x75Var.D0.h(str3);
                if (l35Var == null) {
                    ff5Var2.n().H0.b(tg5Var2.b, "EES not loaded for");
                    ff5Var2.x();
                    ff5Var2.e(z25Var, tg5Var2);
                    return;
                }
                try {
                    n02 n02Var = l35Var.c;
                    ff5.R(z65Var);
                    HashMap mapL1 = z65.L1(z25Var.f.l(), true);
                    String strZ = n12.Z(str2, xb5.z0, xb5.Z);
                    if (strZ == null) {
                        strZ = str2;
                    }
                    if (l35Var.a(new y05(strZ, z25Var.A, mapL1))) {
                        if (((y05) n02Var.z).equals((y05) n02Var.f)) {
                            ff5Var2.x();
                            ff5Var2.e(z25Var, tg5Var2);
                        } else {
                            ff5Var2.n().H0.b(str2, "EES edited event");
                            ff5.R(z65Var);
                            z25 z25VarZ0 = z65.Z0((y05) n02Var.z);
                            ff5Var2.x();
                            ff5Var2.e(z25VarZ0, tg5Var2);
                        }
                        if (((ArrayList) n02Var.A).isEmpty()) {
                            return;
                        }
                        for (y05 y05Var : (ArrayList) n02Var.A) {
                            ff5Var2.n().H0.b(y05Var.a, "EES logging created event");
                            ff5.R(z65Var);
                            z25 z25VarZ02 = z65.Z0(y05Var);
                            ff5Var2.x();
                            ff5Var2.e(z25VarZ02, tg5Var2);
                        }
                        return;
                    }
                } catch (c45 unused2) {
                    ff5Var2.n().z0.c("EES error. appId, eventName", tg5Var2.f, str2);
                }
                ff5Var2.n().H0.b(str2, "EES was not applied to event");
                ff5Var2.x();
                ff5Var2.e(z25Var, tg5Var2);
                return;
            case 7:
                ff5 ff5Var3 = ((i95) this.A).c;
                ff5Var3.x();
                ff5Var3.c((String) this.z, (z25) this.f);
                return;
            case 8:
                ff5 ff5Var4 = ((i95) this.A).c;
                ff5Var4.x();
                kf5 kf5Var = (kf5) this.f;
                Object objA2 = kf5Var.a();
                tg5 tg5Var3 = (tg5) this.z;
                if (objA2 == null) {
                    ff5Var4.V(kf5Var.f, tg5Var3);
                    return;
                } else {
                    ff5Var4.T(kf5Var, tg5Var3);
                    return;
                }
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                i95 i95Var = (i95) this.f;
                tg5 tg5Var4 = (tg5) this.z;
                k15 k15Var = (k15) this.A;
                ff5 ff5Var5 = i95Var.c;
                ff5Var5.x();
                String str4 = tg5Var4.b;
                tj4.i(str4);
                HashMap map = ff5Var5.V0;
                ff5Var5.C().V0();
                ff5Var5.j0();
                m25 m25Var = ff5Var5.z;
                ff5.R(m25Var);
                long j2 = k15Var.b;
                long j3 = k15Var.z;
                m25Var.V0();
                m25Var.W0();
                try {
                    cursorQuery = m25Var.K1().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id", "last_upload_timestamp"}, "rowId=?", new String[]{String.valueOf(j2)}, null, null, null, "1");
                    try {
                        try {
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursorQuery;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        if5Var = null;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    if5Var = null;
                    i = 4;
                    j = j3;
                    i2 = 3;
                    cursorQuery = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
                if (!cursorQuery.moveToFirst()) {
                    if5Var = null;
                    i = 4;
                    j = j3;
                    i2 = 3;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if5VarW1 = if5Var;
                    if (if5VarW1 == null) {
                        ff5Var5.n().C0.c("[sgtm] Queued batch doesn't exist. appId, rowId", str4, Long.valueOf(j2));
                        return;
                    }
                    String str5 = if5VarW1.c;
                    int i3 = k15Var.f;
                    if (i3 != 1) {
                        if (i3 == i2) {
                            cf5 cf5Var = (cf5) map.get(str5);
                            if (cf5Var == null) {
                                cf5Var = new cf5(ff5Var5);
                                map.put(str5, cf5Var);
                            } else {
                                cf5Var.b++;
                                cf5Var.c = cf5Var.a();
                            }
                            ff5Var5.z0().getClass();
                            ff5Var5.n().H0.d("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str4, str5, Long.valueOf((cf5Var.c - System.currentTimeMillis()) / 1000));
                        }
                        m25 m25Var2 = ff5Var5.z;
                        ff5.R(m25Var2);
                        Long lValueOf = Long.valueOf(k15Var.b);
                        m25Var2.h1(lValueOf);
                        ff5Var5.n().H0.c("[sgtm] increased batch retry count after failed client upload. appId, rowId", str4, lValueOf);
                        return;
                    }
                    if (map.containsKey(str5)) {
                        map.remove(str5);
                    }
                    m25 m25Var3 = ff5Var5.z;
                    ff5.R(m25Var3);
                    Long lValueOf2 = Long.valueOf(j2);
                    m25Var3.c1(lValueOf2);
                    ff5Var5.n().H0.c("[sgtm] queued batch deleted after successful client upload. appId, rowId", str4, lValueOf2);
                    if (j > 0) {
                        m25 m25Var4 = ff5Var5.z;
                        ff5.R(m25Var4);
                        k85 k85Var = (k85) m25Var4.f;
                        m25Var4.V0();
                        m25Var4.W0();
                        Long lValueOf3 = Long.valueOf(j);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("upload_type", (Integer) 1);
                        wl3 wl3Var = k85Var.B0;
                        t65 t65Var2 = k85Var.Y;
                        wl3Var.getClass();
                        contentValues.put("creation_timestamp", Long.valueOf(System.currentTimeMillis()));
                        try {
                            if (m25Var4.K1().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j), str4, String.valueOf(i)}) != 1) {
                                k85.h(t65Var2);
                                t65Var2.C0.c("Google Signal pending batch not updated. appId, rowId", str4, lValueOf3);
                                break;
                            }
                            ff5Var5.n().H0.c("[sgtm] queued Google Signal batch updated. appId, signalRowId", str4, Long.valueOf(j));
                            ff5Var5.p(str4);
                            return;
                        } catch (SQLiteException e3) {
                            k85.h(t65Var2);
                            t65Var2.z0.d("Failed to update google Signal pending batch. appid, rowId", str4, Long.valueOf(j), e3);
                            throw e3;
                        }
                    }
                    return;
                }
                String string2 = cursorQuery.getString(1);
                tj4.i(string2);
                if5Var = null;
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        i2 = 3;
                                        cursor2 = cursorQuery;
                                        j = j3;
                                        i = 4;
                                    } catch (SQLiteException e4) {
                                        e = e4;
                                        i2 = 3;
                                        cursor2 = cursorQuery;
                                        j = j3;
                                        i = 4;
                                        cursorQuery = cursor2;
                                        try {
                                            t65 t65Var3 = ((k85) m25Var.f).Y;
                                            k85.h(t65Var3);
                                            t65Var3.z0.c("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j2), e);
                                            if (cursorQuery != null) {
                                            }
                                            if5VarW1 = if5Var;
                                            if (if5VarW1 == null) {
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            cursor = cursorQuery;
                                        }
                                    }
                                } catch (SQLiteException e5) {
                                    e = e5;
                                    cursor2 = cursorQuery;
                                    j = j3;
                                    i2 = 3;
                                }
                            } catch (SQLiteException e6) {
                                e = e6;
                                i2 = 3;
                                cursor2 = cursorQuery;
                                j = j3;
                            }
                        } catch (SQLiteException e7) {
                            e = e7;
                            i = 4;
                            i2 = 3;
                            cursor2 = cursorQuery;
                            j = j3;
                            cursorQuery = cursor2;
                            t65 t65Var32 = ((k85) m25Var.f).Y;
                            k85.h(t65Var32);
                            t65Var32.z0.c("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j2), e);
                            if (cursorQuery != null) {
                            }
                            if5VarW1 = if5Var;
                            if (if5VarW1 == null) {
                            }
                        }
                    } catch (SQLiteException e8) {
                        e = e8;
                        i = 4;
                        i2 = 3;
                    }
                } catch (SQLiteException e9) {
                    e = e9;
                    i = 4;
                    j = j3;
                    i2 = 3;
                    cursor2 = cursorQuery;
                    cursorQuery = cursor2;
                    t65 t65Var322 = ((k85) m25Var.f).Y;
                    k85.h(t65Var322);
                    t65Var322.z0.c("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j2), e);
                    if (cursorQuery != null) {
                    }
                    if5VarW1 = if5Var;
                    if (if5VarW1 == null) {
                    }
                }
                try {
                    if5VarW1 = m25Var.w1(string2, j2, cursorQuery.getBlob(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getInt(5), cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8), cursorQuery.getLong(9));
                    cursor2.close();
                } catch (SQLiteException e10) {
                    e = e10;
                    cursorQuery = cursor2;
                    t65 t65Var3222 = ((k85) m25Var.f).Y;
                    k85.h(t65Var3222);
                    t65Var3222.z0.c("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j2), e);
                    if (cursorQuery != null) {
                    }
                    if5VarW1 = if5Var;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (if5VarW1 == null) {
                }
                cursor = cursor2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            case 10:
                a();
                return;
            case 11:
                v35 v35Var = (v35) this.z;
                dd5 dd5Var = (dd5) this.A;
                k85 k85Var2 = (k85) dd5Var.f;
                try {
                    try {
                        l75Var = k85Var2.X;
                        t65Var = k85Var2.Y;
                        k85.f(l75Var);
                    } catch (Throwable th5) {
                        qf5 qf5Var2 = k85Var2.z0;
                        k85.f(qf5Var2);
                        qf5Var2.F1(null, v35Var);
                        throw th5;
                    }
                } catch (RemoteException e11) {
                    t65 t65Var4 = k85Var2.Y;
                    k85.h(t65Var4);
                    t65Var4.z0.b(e11, "Failed to get app instance id");
                }
                if (l75Var.c1().i(r95.ANALYTICS_STORAGE)) {
                    v55 v55Var = dd5Var.Z;
                    if (v55Var != null) {
                        strC = v55Var.C((tg5) this.f);
                        if (strC != null) {
                            ib5 ib5Var = k85Var2.D0;
                            k85.g(ib5Var);
                            ib5Var.A0.set(strC);
                            k85.f(l75Var);
                            l75Var.A0.C(strC);
                        }
                        dd5Var.i1();
                        qf5Var = k85Var2.z0;
                        k85.f(qf5Var);
                        qf5Var.F1(strC, v35Var);
                        return;
                    }
                    k85.h(t65Var);
                    t65Var.z0.a("Failed to get app instance id");
                } else {
                    k85.h(t65Var);
                    t65Var.E0.a("Analytics storage consent denied; will not get app instance id");
                    ib5 ib5Var2 = k85Var2.D0;
                    k85.g(ib5Var2);
                    ib5Var2.A0.set(null);
                    k85.f(l75Var);
                    l75Var.A0.C(null);
                }
                qf5Var = k85Var2.z0;
                k85.f(qf5Var);
                qf5Var.F1(strC, v35Var);
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                dd5 dd5Var2 = (dd5) this.f;
                tg5 tg5Var5 = (tg5) this.z;
                k15 k15Var2 = (k15) this.A;
                k85 k85Var3 = (k85) dd5Var2.f;
                v55 v55Var2 = dd5Var2.Z;
                if (v55Var2 == null) {
                    t65 t65Var5 = k85Var3.Y;
                    k85.h(t65Var5);
                    t65Var5.z0.a("[sgtm] Discarding data. Failed to update batch upload status.");
                    return;
                }
                try {
                    v55Var2.o(tg5Var5, k15Var2);
                    dd5Var2.i1();
                    return;
                } catch (RemoteException e12) {
                    t65 t65Var6 = k85Var3.Y;
                    k85.h(t65Var6);
                    t65Var6.z0.c("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(k15Var2.b), e12);
                    return;
                }
            default:
                rz4 rz4Var = (rz4) this.f;
                t65 t65Var7 = (t65) this.z;
                JobParameters jobParameters = (JobParameters) this.A;
                t65Var7.H0.a("AppMeasurementJobService processed last upload request.");
                ((hd5) ((Service) rz4Var.f)).c(jobParameters);
                return;
        }
    }

    public /* synthetic */ g33(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.A = obj;
        this.f = obj2;
        this.z = obj3;
    }

    public /* synthetic */ g33(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
    }

    public /* synthetic */ g33() {
        this.b = 4;
    }
}
