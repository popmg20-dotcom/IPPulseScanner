package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dd5 extends u55 {
    public ScheduledExecutorService A0;
    public final de5 B0;
    public final ArrayList C0;
    public final jc5 D0;
    public final yc5 Y;
    public v55 Z;
    public volatile Boolean y0;
    public final jc5 z0;

    public dd5(k85 k85Var) {
        super(k85Var);
        this.C0 = new ArrayList();
        this.B0 = new de5(k85Var.B0);
        this.Y = new yc5(this);
        this.z0 = new jc5(this, k85Var, 0);
        this.D0 = new jc5(this, k85Var, 1);
    }

    @Override // defpackage.u55
    public final boolean Y0() {
        return false;
    }

    public final void Z0(AtomicReference atomicReference) {
        V0();
        W0();
        j1(new g33(this, atomicReference, l1(false)));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a1(Bundle bundle) {
        boolean z;
        boolean zC1;
        V0();
        W0();
        y25 y25Var = new y25(bundle);
        h1();
        k85 k85Var = (k85) this.f;
        if (k85Var.A.f1(null, r55.c1)) {
            i65 i65VarI = k85Var.i();
            k85 k85Var2 = (k85) i65VarI.f;
            qf5 qf5Var = k85Var2.z0;
            t65 t65Var = k85Var2.Y;
            k85.f(qf5Var);
            byte[] bArrB1 = qf5.B1(y25Var);
            if (bArrB1 == null) {
                k85.h(t65Var);
                t65Var.A0.a("Null default event parameters; not writing to database");
            } else if (bArrB1.length > 131072) {
                k85.h(t65Var);
                t65Var.A0.a("Default event parameters too long for local database. Sending directly to service");
            } else {
                zC1 = i65VarI.c1(4, bArrB1);
                z = !zC1;
            }
            zC1 = false;
            if (!zC1) {
            }
        }
        j1(new ia5(this, l1(false), z, y25Var, bundle));
    }

    public final void b1() {
        V0();
        W0();
        if (m1()) {
            return;
        }
        if (c1()) {
            this.Y.d();
            return;
        }
        k85 k85Var = (k85) this.f;
        if (k85Var.A.Y0()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = k85Var.b.getPackageManager().queryIntentServices(new Intent().setClassName(k85Var.b, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(k85Var.b, "com.google.android.gms.measurement.AppMeasurementService"));
        yc5 yc5Var = this.Y;
        dd5 dd5Var = yc5Var.z;
        dd5Var.V0();
        Context context = ((k85) dd5Var.f).b;
        fb0 fb0VarA = fb0.a();
        synchronized (yc5Var) {
            try {
                boolean z = yc5Var.b;
                dd5 dd5Var2 = yc5Var.z;
                k85 k85Var2 = (k85) dd5Var2.f;
                if (z) {
                    t65 t65Var2 = k85Var2.Y;
                    k85.h(t65Var2);
                    t65Var2.H0.a("Connection attempt already in progress");
                } else {
                    t65 t65Var3 = k85Var2.Y;
                    k85.h(t65Var3);
                    t65Var3.H0.a("Using local app measurement service");
                    yc5Var.b = true;
                    fb0VarA.c(context, context.getClass().getName(), intent, dd5Var2.Y, 129, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c1() {
        V0();
        W0();
        if (this.y0 == null) {
            V0();
            W0();
            k85 k85Var = (k85) this.f;
            l75 l75Var = k85Var.X;
            k85.f(l75Var);
            l75Var.V0();
            boolean z = false;
            Boolean boolValueOf = !l75Var.Z0().contains("use_service") ? null : Boolean.valueOf(l75Var.Z0().getBoolean("use_service", false));
            if (boolValueOf == null || !boolValueOf.booleanValue()) {
                d65 d65VarL = ((k85) this.f).l();
                d65VarL.W0();
                if (d65VarL.G0 == 1) {
                    z = true;
                    if (!z && k85Var.A.Y0()) {
                        t65 t65Var = k85Var.Y;
                        k85.h(t65Var);
                        t65Var.z0.a("No way to upload. Consider using the full version of Analytics");
                    } else if (z) {
                        l75 l75Var2 = k85Var.X;
                        k85.f(l75Var2);
                        l75Var2.V0();
                        SharedPreferences.Editor editorEdit = l75Var2.Z0().edit();
                        editorEdit.putBoolean("use_service", z);
                        editorEdit.apply();
                    }
                    z = z;
                } else {
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.H0.a("Checking service availability");
                    qf5 qf5Var = k85Var.z0;
                    k85.f(qf5Var);
                    int iB = mp1.b.b(((k85) qf5Var.f).b, 12451000);
                    if (iB != 0) {
                        if (iB == 1) {
                            t65 t65Var3 = k85Var.Y;
                            k85.h(t65Var3);
                            t65Var3.H0.a("Service missing");
                        } else if (iB != 2) {
                            if (iB != 3) {
                                t65 t65Var4 = k85Var.Y;
                                if (iB == 9) {
                                    k85.h(t65Var4);
                                    t65Var4.C0.a("Service invalid");
                                } else if (iB != 18) {
                                    k85.h(t65Var4);
                                    t65Var4.C0.b(Integer.valueOf(iB), "Unexpected service status");
                                } else {
                                    k85.h(t65Var4);
                                    t65Var4.C0.a("Service updating");
                                }
                            } else {
                                t65 t65Var5 = k85Var.Y;
                                k85.h(t65Var5);
                                t65Var5.C0.a("Service disabled");
                            }
                            z = false;
                        } else {
                            t65 t65Var6 = k85Var.Y;
                            k85.h(t65Var6);
                            t65Var6.G0.a("Service container out of date");
                            qf5 qf5Var2 = k85Var.z0;
                            k85.f(qf5Var2);
                            if (qf5Var2.D1() >= 17443) {
                                z = boolValueOf == null;
                                z = false;
                            }
                        }
                        if (!z) {
                            if (z) {
                            }
                            z = z;
                        }
                    } else {
                        t65 t65Var7 = k85Var.Y;
                        k85.h(t65Var7);
                        t65Var7.H0.a("Service available");
                    }
                    z = true;
                    if (!z) {
                    }
                }
            }
            this.y0 = Boolean.valueOf(z);
        }
        return this.y0.booleanValue();
    }

    public final void d1() {
        V0();
        W0();
        yc5 yc5Var = this.Y;
        if (yc5Var.f != null && (yc5Var.f.isConnected() || yc5Var.f.c())) {
            yc5Var.f.n();
        }
        yc5Var.f = null;
        try {
            fb0.a().b(((k85) this.f).b, yc5Var);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.Z = null;
    }

    public final boolean e1() {
        V0();
        W0();
        if (!c1()) {
            return true;
        }
        qf5 qf5Var = ((k85) this.f).z0;
        k85.f(qf5Var);
        return qf5Var.D1() >= ((Integer) r55.K0.a(null)).intValue();
    }

    public final boolean f1() {
        V0();
        W0();
        if (!c1()) {
            return true;
        }
        qf5 qf5Var = ((k85) this.f).z0;
        k85.f(qf5Var);
        return qf5Var.D1() >= 241200;
    }

    public final void g1(ComponentName componentName) {
        V0();
        if (this.Z != null) {
            this.Z = null;
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.H0.b(componentName, "Disconnected from device MeasurementService");
            V0();
            b1();
        }
    }

    public final void h1() {
        ((k85) this.f).getClass();
    }

    public final void i1() {
        V0();
        de5 de5Var = this.B0;
        de5Var.getClass();
        de5Var.a = SystemClock.elapsedRealtime();
        x15 x15Var = ((k85) this.f).A;
        this.z0.b(((Long) r55.Z.a(null)).longValue());
    }

    public final void j1(Runnable runnable) {
        V0();
        if (m1()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.C0;
        long size = arrayList.size();
        k85 k85Var = (k85) this.f;
        x15 x15Var = k85Var.A;
        if (size >= 1000) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.a("Discarding data. Max runnable queue size reached");
        } else {
            arrayList.add(runnable);
            this.D0.b(60000L);
            b1();
        }
    }

    public final void k1() {
        V0();
        k85 k85Var = (k85) this.f;
        t65 t65Var = k85Var.Y;
        k85.h(t65Var);
        q65 q65Var = t65Var.H0;
        ArrayList arrayList = this.C0;
        q65Var.b(Integer.valueOf(arrayList.size()), "Processing queued up service tasks");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                t65Var2.z0.b(e, "Task exception while flushing queue");
            }
        }
        arrayList.clear();
        this.D0.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final tg5 l1(boolean z) {
        long jAbs;
        Pair pair;
        k85 k85Var = (k85) this.f;
        k85Var.getClass();
        d65 d65VarL = k85Var.l();
        String strZ = null;
        if (z) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            k85 k85Var2 = (k85) t65Var.f;
            l75 l75Var = k85Var2.X;
            k85.f(l75Var);
            if (l75Var.y0 != null) {
                l75 l75Var2 = k85Var2.X;
                k85.f(l75Var2);
                i40 i40Var = l75Var2.y0;
                l75 l75Var3 = (l75) i40Var.z;
                l75Var3.V0();
                l75Var3.V0();
                long j = ((l75) i40Var.z).Z0().getLong("health_monitor:start", 0L);
                if (j == 0) {
                    i40Var.k();
                    jAbs = 0;
                } else {
                    ((k85) l75Var3.f).B0.getClass();
                    jAbs = Math.abs(j - System.currentTimeMillis());
                }
                long j2 = i40Var.f;
                if (jAbs < j2) {
                    pair = null;
                    if (pair != null) {
                    }
                } else if (jAbs > j2 + j2) {
                    i40Var.k();
                    pair = null;
                    if (pair != null && pair != l75.T0) {
                        String strValueOf = String.valueOf(pair.second);
                        String str = (String) pair.first;
                        strZ = fw.z(new StringBuilder(strValueOf.length() + 1 + String.valueOf(str).length()), strValueOf, ":", str);
                    }
                } else {
                    String string = l75Var3.Z0().getString("health_monitor:value", null);
                    long j3 = l75Var3.Z0().getLong("health_monitor:count", 0L);
                    i40Var.k();
                    pair = (string == null || j3 <= 0) ? l75.T0 : new Pair(string, Long.valueOf(j3));
                    if (pair != null) {
                        String strValueOf2 = String.valueOf(pair.second);
                        String str2 = (String) pair.first;
                        strZ = fw.z(new StringBuilder(strValueOf2.length() + 1 + String.valueOf(str2).length()), strValueOf2, ":", str2);
                    }
                }
            }
        }
        return d65VarL.Z0(strZ);
    }

    public final boolean m1() {
        V0();
        W0();
        return this.Z != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:274:0x04a7 A[Catch: all -> 0x04e5, TRY_ENTER, TryCatch #42 {all -> 0x04e5, blocks: (B:284:0x04d5, B:274:0x04a7, B:276:0x04ad, B:277:0x04b0, B:294:0x04f8, B:220:0x03c4, B:222:0x03ce, B:227:0x03df), top: B:412:0x04d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04e1 A[PHI: r5 r6 r23 r24 r26 r27 r36 r37
      0x04e1: PHI (r5v15 android.database.sqlite.SQLiteDatabase) = 
      (r5v12 android.database.sqlite.SQLiteDatabase)
      (r5v13 android.database.sqlite.SQLiteDatabase)
      (r5v16 android.database.sqlite.SQLiteDatabase)
     binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r6v5 int) = (r6v3 int), (r6v3 int), (r6v6 int) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r23v9 int) = (r23v6 int), (r23v7 int), (r23v10 int) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r24v9 java.lang.String) = (r24v6 java.lang.String), (r24v7 java.lang.String), (r24v10 java.lang.String) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r26v9 java.lang.String) = (r26v6 java.lang.String), (r26v7 java.lang.String), (r26v10 java.lang.String) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r27v11 x15) = (r27v8 x15), (r27v9 x15), (r27v12 x15) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r36v9 int) = (r36v6 int), (r36v7 int), (r36v10 int) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x04e1: PHI (r37v9 java.lang.String) = (r37v6 java.lang.String), (r37v7 java.lang.String), (r37v10 java.lang.String) binds: [B:280:0x04c2, B:297:0x050a, B:288:0x04df] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x050d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:480:0x050d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:482:0x050d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n1(v55 v55Var, y1 y1Var, tg5 tg5Var) throws Throwable {
        ArrayList arrayList;
        k85 k85Var;
        x15 x15Var;
        Context context;
        t65 t65Var;
        int i;
        SQLiteDatabase sQLiteDatabase;
        int i2;
        String str;
        String str2;
        String str3;
        int i3;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursorQuery;
        long j;
        String str4;
        String[] strArr;
        int i4;
        int i5;
        int i6;
        Cursor cursor3;
        long j2;
        String string;
        q55 q55Var;
        Parcel parcelObtain;
        y25 y25VarCreateFromParcel;
        int i7;
        q15 q15VarCreateFromParcel;
        kf5 kf5VarCreateFromParcel;
        int size;
        int size2;
        int i8;
        int i9;
        x15 x15Var2;
        k85 k85Var2;
        Context context2;
        t65 t65Var2;
        String str5;
        long jElapsedRealtime;
        long j3;
        long j4;
        n02 n02Var;
        y1 y1Var2 = y1Var;
        V0();
        W0();
        h1();
        k85 k85Var3 = (k85) this.f;
        x15 x15Var3 = k85Var3.A;
        Context context3 = k85Var3.b;
        t65 t65Var3 = k85Var3.Y;
        wl3 wl3Var = k85Var3.B0;
        int i10 = 100;
        tg5 tg5Var2 = tg5Var;
        int i11 = 100;
        int i12 = 0;
        while (i12 < 1001 && i11 == i10) {
            ArrayList arrayList2 = new ArrayList();
            i65 i65VarI = k85Var3.i();
            String str6 = "entry";
            int i13 = i10;
            String str7 = "type";
            String str8 = "rowid";
            wl3 wl3Var2 = wl3Var;
            k85 k85Var4 = (k85) i65VarI.f;
            i65VarI.V0();
            int i14 = i12;
            if (i65VarI.Z) {
                k85Var = k85Var3;
                x15Var = x15Var3;
                context = context3;
                t65Var = t65Var3;
            } else {
                arrayList = new ArrayList();
                k85Var = k85Var3;
                if (((k85) i65VarI.f).b.getDatabasePath("google_app_measurement_local.db").exists()) {
                    int i15 = 5;
                    context = context3;
                    t65Var = t65Var3;
                    int i16 = 0;
                    int i17 = 5;
                    while (i16 < i15) {
                        try {
                            SQLiteDatabase sQLiteDatabaseB1 = i65VarI.b1();
                            if (sQLiteDatabaseB1 == null) {
                                try {
                                    try {
                                        i65VarI.Z = true;
                                        x15Var = x15Var3;
                                    } catch (Throwable th) {
                                        th = th;
                                        sQLiteDatabase = sQLiteDatabaseB1;
                                        cursor = null;
                                        if (cursor != null) {
                                        }
                                        if (sQLiteDatabase != null) {
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteDatabaseLockedException unused) {
                                    x15Var = x15Var3;
                                    i2 = i16;
                                    str = str8;
                                    str3 = str6;
                                    sQLiteDatabase = sQLiteDatabaseB1;
                                    i3 = 5;
                                    str2 = str7;
                                    cursor2 = null;
                                    try {
                                        SystemClock.sleep(i17);
                                        i17 += 20;
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase == null) {
                                        }
                                        i16 = i2 + 1;
                                        i15 = i3;
                                        str7 = str2;
                                        str6 = str3;
                                        x15Var3 = x15Var;
                                        str8 = str;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteFullException e) {
                                    e = e;
                                    x15Var = x15Var3;
                                    i2 = i16;
                                    str = str8;
                                    str3 = str6;
                                    sQLiteDatabase = sQLiteDatabaseB1;
                                    i3 = 5;
                                    str2 = str7;
                                    cursor2 = null;
                                    t65 t65Var4 = k85Var4.Y;
                                    k85.h(t65Var4);
                                    t65Var4.z0.b(e, "Error reading entries from local database");
                                    i65VarI.Z = true;
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    i16 = i2 + 1;
                                    i15 = i3;
                                    str7 = str2;
                                    str6 = str3;
                                    x15Var3 = x15Var;
                                    str8 = str;
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    x15Var = x15Var3;
                                    i2 = i16;
                                    str = str8;
                                    str3 = str6;
                                    sQLiteDatabase = sQLiteDatabaseB1;
                                    i3 = 5;
                                    str2 = str7;
                                    cursor2 = null;
                                    if (sQLiteDatabase != null) {
                                    }
                                    t65 t65Var5 = k85Var4.Y;
                                    k85.h(t65Var5);
                                    t65Var5.z0.b(e, "Error reading entries from local database");
                                    i65VarI.Z = true;
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    i16 = i2 + 1;
                                    i15 = i3;
                                    str7 = str2;
                                    str6 = str3;
                                    x15Var3 = x15Var;
                                    str8 = str;
                                }
                            } else {
                                sQLiteDatabaseB1.beginTransaction();
                                try {
                                    cursorQuery = sQLiteDatabaseB1.query("messages", new String[]{str8}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
                                    try {
                                        long j5 = -1;
                                        if (cursorQuery.moveToFirst()) {
                                            i2 = i16;
                                            try {
                                                j = cursorQuery.getLong(0);
                                                try {
                                                    cursorQuery.close();
                                                } catch (SQLiteDatabaseLockedException unused2) {
                                                    x15Var = x15Var3;
                                                    str = str8;
                                                    str3 = str6;
                                                    sQLiteDatabase = sQLiteDatabaseB1;
                                                    i3 = 5;
                                                    str2 = str7;
                                                    cursor2 = null;
                                                    SystemClock.sleep(i17);
                                                    i17 += 20;
                                                    if (cursor2 != null) {
                                                    }
                                                    if (sQLiteDatabase == null) {
                                                    }
                                                    i16 = i2 + 1;
                                                    i15 = i3;
                                                    str7 = str2;
                                                    str6 = str3;
                                                    x15Var3 = x15Var;
                                                    str8 = str;
                                                } catch (SQLiteFullException e3) {
                                                    e = e3;
                                                    x15Var = x15Var3;
                                                    str = str8;
                                                    str3 = str6;
                                                    sQLiteDatabase = sQLiteDatabaseB1;
                                                    i3 = 5;
                                                    str2 = str7;
                                                    cursor2 = null;
                                                    t65 t65Var42 = k85Var4.Y;
                                                    k85.h(t65Var42);
                                                    t65Var42.z0.b(e, "Error reading entries from local database");
                                                    i65VarI.Z = true;
                                                    if (cursor2 != null) {
                                                    }
                                                    if (sQLiteDatabase != null) {
                                                    }
                                                    i16 = i2 + 1;
                                                    i15 = i3;
                                                    str7 = str2;
                                                    str6 = str3;
                                                    x15Var3 = x15Var;
                                                    str8 = str;
                                                } catch (SQLiteException e4) {
                                                    e = e4;
                                                    x15Var = x15Var3;
                                                    str = str8;
                                                    str3 = str6;
                                                    sQLiteDatabase = sQLiteDatabaseB1;
                                                    i3 = 5;
                                                    str2 = str7;
                                                    cursor2 = null;
                                                    if (sQLiteDatabase != null) {
                                                    }
                                                    t65 t65Var52 = k85Var4.Y;
                                                    k85.h(t65Var52);
                                                    t65Var52.z0.b(e, "Error reading entries from local database");
                                                    i65VarI.Z = true;
                                                    if (cursor2 != null) {
                                                    }
                                                    if (sQLiteDatabase != null) {
                                                    }
                                                    i16 = i2 + 1;
                                                    i15 = i3;
                                                    str7 = str2;
                                                    str6 = str3;
                                                    x15Var3 = x15Var;
                                                    str8 = str;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                x15Var = x15Var3;
                                                str = str8;
                                                str3 = str6;
                                                sQLiteDatabase = sQLiteDatabaseB1;
                                                i3 = 5;
                                                str2 = str7;
                                                if (cursorQuery != null) {
                                                    try {
                                                        cursorQuery.close();
                                                    } catch (SQLiteDatabaseLockedException unused3) {
                                                        cursor2 = null;
                                                        SystemClock.sleep(i17);
                                                        i17 += 20;
                                                        if (cursor2 != null) {
                                                        }
                                                        if (sQLiteDatabase == null) {
                                                        }
                                                        i16 = i2 + 1;
                                                        i15 = i3;
                                                        str7 = str2;
                                                        str6 = str3;
                                                        x15Var3 = x15Var;
                                                        str8 = str;
                                                    } catch (SQLiteFullException e5) {
                                                        e = e5;
                                                        cursor2 = null;
                                                        t65 t65Var422 = k85Var4.Y;
                                                        k85.h(t65Var422);
                                                        t65Var422.z0.b(e, "Error reading entries from local database");
                                                        i65VarI.Z = true;
                                                        if (cursor2 != null) {
                                                        }
                                                        if (sQLiteDatabase != null) {
                                                        }
                                                        i16 = i2 + 1;
                                                        i15 = i3;
                                                        str7 = str2;
                                                        str6 = str3;
                                                        x15Var3 = x15Var;
                                                        str8 = str;
                                                    } catch (SQLiteException e6) {
                                                        e = e6;
                                                        cursor2 = null;
                                                        if (sQLiteDatabase != null) {
                                                        }
                                                        t65 t65Var522 = k85Var4.Y;
                                                        k85.h(t65Var522);
                                                        t65Var522.z0.b(e, "Error reading entries from local database");
                                                        i65VarI.Z = true;
                                                        if (cursor2 != null) {
                                                        }
                                                        if (sQLiteDatabase != null) {
                                                        }
                                                        i16 = i2 + 1;
                                                        i15 = i3;
                                                        str7 = str2;
                                                        str6 = str3;
                                                        x15Var3 = x15Var;
                                                        str8 = str;
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        cursor = null;
                                                        if (cursor != null) {
                                                        }
                                                        if (sQLiteDatabase != null) {
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                throw th;
                                            }
                                        } else {
                                            i2 = i16;
                                            cursorQuery.close();
                                            j = -1;
                                        }
                                        if (j != -1) {
                                            str4 = "rowid<?";
                                            strArr = new String[]{String.valueOf(j)};
                                        } else {
                                            str4 = null;
                                            strArr = null;
                                        }
                                        try {
                                            String[] strArr2 = {str8, str7, str6};
                                            x15 x15Var4 = k85Var4.A;
                                            q55 q55Var2 = r55.c1;
                                            str = str8;
                                            try {
                                                try {
                                                    i4 = 4;
                                                    i5 = 3;
                                                    if (x15Var4.f1(null, q55Var2)) {
                                                        i6 = 5;
                                                        try {
                                                            strArr2 = new String[]{str, str7, str6, "app_version", "app_version_int"};
                                                        } catch (SQLiteDatabaseLockedException unused4) {
                                                            i3 = 5;
                                                            x15Var = x15Var3;
                                                            str3 = str6;
                                                            sQLiteDatabase = sQLiteDatabaseB1;
                                                            str2 = str7;
                                                            cursor2 = null;
                                                            SystemClock.sleep(i17);
                                                            i17 += 20;
                                                            if (cursor2 != null) {
                                                            }
                                                            if (sQLiteDatabase == null) {
                                                            }
                                                            i16 = i2 + 1;
                                                            i15 = i3;
                                                            str7 = str2;
                                                            str6 = str3;
                                                            x15Var3 = x15Var;
                                                            str8 = str;
                                                        } catch (SQLiteFullException e7) {
                                                            e = e7;
                                                            i3 = 5;
                                                            x15Var = x15Var3;
                                                            str3 = str6;
                                                            sQLiteDatabase = sQLiteDatabaseB1;
                                                            str2 = str7;
                                                            cursor2 = null;
                                                            t65 t65Var4222 = k85Var4.Y;
                                                            k85.h(t65Var4222);
                                                            t65Var4222.z0.b(e, "Error reading entries from local database");
                                                            i65VarI.Z = true;
                                                            if (cursor2 != null) {
                                                            }
                                                            if (sQLiteDatabase != null) {
                                                            }
                                                            i16 = i2 + 1;
                                                            i15 = i3;
                                                            str7 = str2;
                                                            str6 = str3;
                                                            x15Var3 = x15Var;
                                                            str8 = str;
                                                        } catch (SQLiteException e8) {
                                                            e = e8;
                                                            i3 = 5;
                                                            x15Var = x15Var3;
                                                            str3 = str6;
                                                            sQLiteDatabase = sQLiteDatabaseB1;
                                                            str2 = str7;
                                                            cursor2 = null;
                                                            if (sQLiteDatabase != null) {
                                                            }
                                                            t65 t65Var5222 = k85Var4.Y;
                                                            k85.h(t65Var5222);
                                                            t65Var5222.z0.b(e, "Error reading entries from local database");
                                                            i65VarI.Z = true;
                                                            if (cursor2 != null) {
                                                            }
                                                            if (sQLiteDatabase != null) {
                                                            }
                                                            i16 = i2 + 1;
                                                            i15 = i3;
                                                            str7 = str2;
                                                            str6 = str3;
                                                            x15Var3 = x15Var;
                                                            str8 = str;
                                                        }
                                                    } else {
                                                        i6 = 5;
                                                    }
                                                } catch (SQLiteDatabaseLockedException unused5) {
                                                    x15Var = x15Var3;
                                                    str3 = str6;
                                                    sQLiteDatabase = sQLiteDatabaseB1;
                                                    str2 = str7;
                                                    i3 = 5;
                                                    cursor2 = null;
                                                    SystemClock.sleep(i17);
                                                    i17 += 20;
                                                    if (cursor2 != null) {
                                                        cursor2.close();
                                                    }
                                                    if (sQLiteDatabase == null) {
                                                        sQLiteDatabase.close();
                                                    }
                                                    i16 = i2 + 1;
                                                    i15 = i3;
                                                    str7 = str2;
                                                    str6 = str3;
                                                    x15Var3 = x15Var;
                                                    str8 = str;
                                                }
                                                try {
                                                    Cursor cursorQuery2 = sQLiteDatabaseB1.query("messages", strArr2, str4, strArr, null, null, "rowid asc", Integer.toString(i13));
                                                    while (cursorQuery2.moveToNext()) {
                                                        try {
                                                            try {
                                                                try {
                                                                    j5 = cursorQuery2.getLong(0);
                                                                    try {
                                                                        int i18 = cursorQuery2.getInt(1);
                                                                        str2 = str7;
                                                                        try {
                                                                            byte[] blob = cursorQuery2.getBlob(2);
                                                                            str3 = str6;
                                                                            try {
                                                                                if (k85Var4.A.f1(null, q55Var2)) {
                                                                                    try {
                                                                                        string = cursorQuery2.getString(i5);
                                                                                        cursor3 = cursorQuery2;
                                                                                        x15Var = x15Var3;
                                                                                        j2 = cursorQuery2.getLong(i4);
                                                                                    } catch (SQLiteDatabaseLockedException unused6) {
                                                                                        cursor2 = cursorQuery2;
                                                                                        x15Var = x15Var3;
                                                                                        sQLiteDatabase = sQLiteDatabaseB1;
                                                                                        i3 = 5;
                                                                                        SystemClock.sleep(i17);
                                                                                        i17 += 20;
                                                                                        if (cursor2 != null) {
                                                                                        }
                                                                                        if (sQLiteDatabase == null) {
                                                                                        }
                                                                                        i16 = i2 + 1;
                                                                                        i15 = i3;
                                                                                        str7 = str2;
                                                                                        str6 = str3;
                                                                                        x15Var3 = x15Var;
                                                                                        str8 = str;
                                                                                    } catch (SQLiteFullException e9) {
                                                                                        e = e9;
                                                                                        cursor2 = cursorQuery2;
                                                                                        x15Var = x15Var3;
                                                                                        sQLiteDatabase = sQLiteDatabaseB1;
                                                                                        i3 = 5;
                                                                                        t65 t65Var42222 = k85Var4.Y;
                                                                                        k85.h(t65Var42222);
                                                                                        t65Var42222.z0.b(e, "Error reading entries from local database");
                                                                                        i65VarI.Z = true;
                                                                                        if (cursor2 != null) {
                                                                                        }
                                                                                        if (sQLiteDatabase != null) {
                                                                                        }
                                                                                        i16 = i2 + 1;
                                                                                        i15 = i3;
                                                                                        str7 = str2;
                                                                                        str6 = str3;
                                                                                        x15Var3 = x15Var;
                                                                                        str8 = str;
                                                                                    } catch (SQLiteException e10) {
                                                                                        e = e10;
                                                                                        cursor2 = cursorQuery2;
                                                                                        x15Var = x15Var3;
                                                                                        sQLiteDatabase = sQLiteDatabaseB1;
                                                                                        i3 = 5;
                                                                                        if (sQLiteDatabase != null) {
                                                                                        }
                                                                                        t65 t65Var52222 = k85Var4.Y;
                                                                                        k85.h(t65Var52222);
                                                                                        t65Var52222.z0.b(e, "Error reading entries from local database");
                                                                                        i65VarI.Z = true;
                                                                                        if (cursor2 != null) {
                                                                                        }
                                                                                        if (sQLiteDatabase != null) {
                                                                                        }
                                                                                        i16 = i2 + 1;
                                                                                        i15 = i3;
                                                                                        str7 = str2;
                                                                                        str6 = str3;
                                                                                        x15Var3 = x15Var;
                                                                                        str8 = str;
                                                                                    }
                                                                                } else {
                                                                                    cursor3 = cursorQuery2;
                                                                                    x15Var = x15Var3;
                                                                                    j2 = 0;
                                                                                    string = null;
                                                                                }
                                                                                if (i18 == 0) {
                                                                                    q55Var = q55Var2;
                                                                                    try {
                                                                                        parcelObtain = Parcel.obtain();
                                                                                        try {
                                                                                            cursor2 = cursor3;
                                                                                            try {
                                                                                                try {
                                                                                                    parcelObtain.unmarshall(blob, 0, blob.length);
                                                                                                    parcelObtain.setDataPosition(0);
                                                                                                    z25 z25VarCreateFromParcel = z25.CREATOR.createFromParcel(parcelObtain);
                                                                                                    try {
                                                                                                        try {
                                                                                                            if (z25VarCreateFromParcel != null) {
                                                                                                                arrayList.add(new g65(z25VarCreateFromParcel, string, j2));
                                                                                                            }
                                                                                                        } catch (Throwable th5) {
                                                                                                            th = th5;
                                                                                                            sQLiteDatabase = sQLiteDatabaseB1;
                                                                                                            cursor = cursor2;
                                                                                                            if (cursor != null) {
                                                                                                            }
                                                                                                            if (sQLiteDatabase != null) {
                                                                                                            }
                                                                                                            throw th;
                                                                                                        }
                                                                                                    } catch (SQLiteDatabaseLockedException unused7) {
                                                                                                        sQLiteDatabase = sQLiteDatabaseB1;
                                                                                                        i3 = 5;
                                                                                                        SystemClock.sleep(i17);
                                                                                                        i17 += 20;
                                                                                                        if (cursor2 != null) {
                                                                                                        }
                                                                                                        if (sQLiteDatabase == null) {
                                                                                                        }
                                                                                                        i16 = i2 + 1;
                                                                                                        i15 = i3;
                                                                                                        str7 = str2;
                                                                                                        str6 = str3;
                                                                                                        x15Var3 = x15Var;
                                                                                                        str8 = str;
                                                                                                    } catch (SQLiteFullException e11) {
                                                                                                        e = e11;
                                                                                                        sQLiteDatabase = sQLiteDatabaseB1;
                                                                                                        i3 = 5;
                                                                                                        t65 t65Var422222 = k85Var4.Y;
                                                                                                        k85.h(t65Var422222);
                                                                                                        t65Var422222.z0.b(e, "Error reading entries from local database");
                                                                                                        i65VarI.Z = true;
                                                                                                        if (cursor2 != null) {
                                                                                                        }
                                                                                                        if (sQLiteDatabase != null) {
                                                                                                        }
                                                                                                        i16 = i2 + 1;
                                                                                                        i15 = i3;
                                                                                                        str7 = str2;
                                                                                                        str6 = str3;
                                                                                                        x15Var3 = x15Var;
                                                                                                        str8 = str;
                                                                                                    } catch (SQLiteException e12) {
                                                                                                        e = e12;
                                                                                                        sQLiteDatabase = sQLiteDatabaseB1;
                                                                                                        i3 = 5;
                                                                                                        if (sQLiteDatabase != null) {
                                                                                                        }
                                                                                                        t65 t65Var522222 = k85Var4.Y;
                                                                                                        k85.h(t65Var522222);
                                                                                                        t65Var522222.z0.b(e, "Error reading entries from local database");
                                                                                                        i65VarI.Z = true;
                                                                                                        if (cursor2 != null) {
                                                                                                        }
                                                                                                        if (sQLiteDatabase != null) {
                                                                                                        }
                                                                                                        i16 = i2 + 1;
                                                                                                        i15 = i3;
                                                                                                        str7 = str2;
                                                                                                        str6 = str3;
                                                                                                        x15Var3 = x15Var;
                                                                                                        str8 = str;
                                                                                                    }
                                                                                                } catch (Throwable th6) {
                                                                                                    th = th6;
                                                                                                    throw th;
                                                                                                }
                                                                                            } catch (uo3 unused8) {
                                                                                                t65 t65Var6 = k85Var4.Y;
                                                                                                k85.h(t65Var6);
                                                                                                t65Var6.z0.a("Failed to load event from local database");
                                                                                                parcelObtain.recycle();
                                                                                            }
                                                                                        } catch (uo3 unused9) {
                                                                                            cursor2 = cursor3;
                                                                                        } catch (Throwable th7) {
                                                                                            th = th7;
                                                                                        }
                                                                                    } catch (SQLiteDatabaseLockedException unused10) {
                                                                                        cursor2 = cursor3;
                                                                                    } catch (SQLiteFullException e13) {
                                                                                        e = e13;
                                                                                        cursor2 = cursor3;
                                                                                    } catch (SQLiteException e14) {
                                                                                        e = e14;
                                                                                        cursor2 = cursor3;
                                                                                    } catch (Throwable th8) {
                                                                                        th = th8;
                                                                                        cursor2 = cursor3;
                                                                                    }
                                                                                } else {
                                                                                    q55Var = q55Var2;
                                                                                    cursor2 = cursor3;
                                                                                    if (i18 == 1) {
                                                                                        parcelObtain = Parcel.obtain();
                                                                                        try {
                                                                                            try {
                                                                                                parcelObtain.unmarshall(blob, 0, blob.length);
                                                                                                parcelObtain.setDataPosition(0);
                                                                                                kf5VarCreateFromParcel = kf5.CREATOR.createFromParcel(parcelObtain);
                                                                                            } catch (uo3 unused11) {
                                                                                                t65 t65Var7 = k85Var4.Y;
                                                                                                k85.h(t65Var7);
                                                                                                t65Var7.z0.a("Failed to load user property from local database");
                                                                                                parcelObtain.recycle();
                                                                                                kf5VarCreateFromParcel = null;
                                                                                            }
                                                                                            if (kf5VarCreateFromParcel != null) {
                                                                                                arrayList.add(new g65(kf5VarCreateFromParcel, string, j2));
                                                                                            }
                                                                                        } finally {
                                                                                        }
                                                                                    } else if (i18 == 2) {
                                                                                        parcelObtain = Parcel.obtain();
                                                                                        try {
                                                                                            try {
                                                                                                parcelObtain.unmarshall(blob, 0, blob.length);
                                                                                                parcelObtain.setDataPosition(0);
                                                                                                q15VarCreateFromParcel = q15.CREATOR.createFromParcel(parcelObtain);
                                                                                            } finally {
                                                                                            }
                                                                                        } catch (uo3 unused12) {
                                                                                            t65 t65Var8 = k85Var4.Y;
                                                                                            k85.h(t65Var8);
                                                                                            t65Var8.z0.a("Failed to load conditional user property from local database");
                                                                                            parcelObtain.recycle();
                                                                                            q15VarCreateFromParcel = null;
                                                                                        }
                                                                                        if (q15VarCreateFromParcel != null) {
                                                                                            arrayList.add(new g65(q15VarCreateFromParcel, string, j2));
                                                                                        }
                                                                                    } else {
                                                                                        if (i18 == 4) {
                                                                                            try {
                                                                                                parcelObtain = Parcel.obtain();
                                                                                                try {
                                                                                                    try {
                                                                                                        try {
                                                                                                            parcelObtain.unmarshall(blob, 0, blob.length);
                                                                                                            parcelObtain.setDataPosition(0);
                                                                                                            y25VarCreateFromParcel = y25.CREATOR.createFromParcel(parcelObtain);
                                                                                                            try {
                                                                                                            } catch (SQLiteDatabaseLockedException unused13) {
                                                                                                                sQLiteDatabase = sQLiteDatabaseB1;
                                                                                                                i3 = 5;
                                                                                                                SystemClock.sleep(i17);
                                                                                                                i17 += 20;
                                                                                                                if (cursor2 != null) {
                                                                                                                }
                                                                                                                if (sQLiteDatabase == null) {
                                                                                                                }
                                                                                                                i16 = i2 + 1;
                                                                                                                i15 = i3;
                                                                                                                str7 = str2;
                                                                                                                str6 = str3;
                                                                                                                x15Var3 = x15Var;
                                                                                                                str8 = str;
                                                                                                            } catch (SQLiteFullException e15) {
                                                                                                                e = e15;
                                                                                                                sQLiteDatabase = sQLiteDatabaseB1;
                                                                                                                i3 = 5;
                                                                                                                t65 t65Var4222222 = k85Var4.Y;
                                                                                                                k85.h(t65Var4222222);
                                                                                                                t65Var4222222.z0.b(e, "Error reading entries from local database");
                                                                                                                i65VarI.Z = true;
                                                                                                                if (cursor2 != null) {
                                                                                                                    cursor2.close();
                                                                                                                }
                                                                                                                if (sQLiteDatabase != null) {
                                                                                                                }
                                                                                                                i16 = i2 + 1;
                                                                                                                i15 = i3;
                                                                                                                str7 = str2;
                                                                                                                str6 = str3;
                                                                                                                x15Var3 = x15Var;
                                                                                                                str8 = str;
                                                                                                            } catch (SQLiteException e16) {
                                                                                                                e = e16;
                                                                                                                sQLiteDatabase = sQLiteDatabaseB1;
                                                                                                                i3 = 5;
                                                                                                                if (sQLiteDatabase != null && sQLiteDatabase.inTransaction()) {
                                                                                                                    sQLiteDatabase.endTransaction();
                                                                                                                }
                                                                                                                t65 t65Var5222222 = k85Var4.Y;
                                                                                                                k85.h(t65Var5222222);
                                                                                                                t65Var5222222.z0.b(e, "Error reading entries from local database");
                                                                                                                i65VarI.Z = true;
                                                                                                                if (cursor2 != null) {
                                                                                                                    cursor2.close();
                                                                                                                }
                                                                                                                if (sQLiteDatabase != null) {
                                                                                                                }
                                                                                                                i16 = i2 + 1;
                                                                                                                i15 = i3;
                                                                                                                str7 = str2;
                                                                                                                str6 = str3;
                                                                                                                x15Var3 = x15Var;
                                                                                                                str8 = str;
                                                                                                            }
                                                                                                        } catch (Throwable th9) {
                                                                                                            th = th9;
                                                                                                            throw th;
                                                                                                        }
                                                                                                    } catch (uo3 unused14) {
                                                                                                        t65 t65Var9 = k85Var4.Y;
                                                                                                        k85.h(t65Var9);
                                                                                                        t65Var9.z0.a("Failed to load default event parameters from local database");
                                                                                                        parcelObtain.recycle();
                                                                                                        y25VarCreateFromParcel = null;
                                                                                                    }
                                                                                                } catch (uo3 unused15) {
                                                                                                } catch (Throwable th10) {
                                                                                                    th = th10;
                                                                                                }
                                                                                                if (y25VarCreateFromParcel != null) {
                                                                                                    arrayList.add(new g65(y25VarCreateFromParcel, string, j2));
                                                                                                }
                                                                                                i7 = 3;
                                                                                            } catch (SQLiteDatabaseLockedException unused16) {
                                                                                                sQLiteDatabase = sQLiteDatabaseB1;
                                                                                                i3 = 5;
                                                                                                SystemClock.sleep(i17);
                                                                                                i17 += 20;
                                                                                                if (cursor2 != null) {
                                                                                                }
                                                                                                if (sQLiteDatabase == null) {
                                                                                                }
                                                                                                i16 = i2 + 1;
                                                                                                i15 = i3;
                                                                                                str7 = str2;
                                                                                                str6 = str3;
                                                                                                x15Var3 = x15Var;
                                                                                                str8 = str;
                                                                                            } catch (SQLiteFullException e17) {
                                                                                                e = e17;
                                                                                                sQLiteDatabase = sQLiteDatabaseB1;
                                                                                                i3 = 5;
                                                                                                t65 t65Var42222222 = k85Var4.Y;
                                                                                                k85.h(t65Var42222222);
                                                                                                t65Var42222222.z0.b(e, "Error reading entries from local database");
                                                                                                i65VarI.Z = true;
                                                                                                if (cursor2 != null) {
                                                                                                }
                                                                                                if (sQLiteDatabase != null) {
                                                                                                }
                                                                                                i16 = i2 + 1;
                                                                                                i15 = i3;
                                                                                                str7 = str2;
                                                                                                str6 = str3;
                                                                                                x15Var3 = x15Var;
                                                                                                str8 = str;
                                                                                            } catch (SQLiteException e18) {
                                                                                                e = e18;
                                                                                                sQLiteDatabase = sQLiteDatabaseB1;
                                                                                                i3 = 5;
                                                                                                if (sQLiteDatabase != null) {
                                                                                                    sQLiteDatabase.endTransaction();
                                                                                                }
                                                                                                t65 t65Var52222222 = k85Var4.Y;
                                                                                                k85.h(t65Var52222222);
                                                                                                t65Var52222222.z0.b(e, "Error reading entries from local database");
                                                                                                i65VarI.Z = true;
                                                                                                if (cursor2 != null) {
                                                                                                }
                                                                                                if (sQLiteDatabase != null) {
                                                                                                }
                                                                                                i16 = i2 + 1;
                                                                                                i15 = i3;
                                                                                                str7 = str2;
                                                                                                str6 = str3;
                                                                                                x15Var3 = x15Var;
                                                                                                str8 = str;
                                                                                            }
                                                                                        } else {
                                                                                            t65 t65Var10 = k85Var4.Y;
                                                                                            i7 = 3;
                                                                                            if (i18 == 3) {
                                                                                                k85.h(t65Var10);
                                                                                                t65Var10.H0.a("Skipping app launch break");
                                                                                            } else {
                                                                                                k85.h(t65Var10);
                                                                                                t65Var10.z0.a("Unknown record type in local database");
                                                                                            }
                                                                                        }
                                                                                        i5 = i7;
                                                                                        str7 = str2;
                                                                                        str6 = str3;
                                                                                        x15Var3 = x15Var;
                                                                                        q55Var2 = q55Var;
                                                                                        cursorQuery2 = cursor2;
                                                                                        i4 = 4;
                                                                                    }
                                                                                }
                                                                                i7 = 3;
                                                                                i5 = i7;
                                                                                str7 = str2;
                                                                                str6 = str3;
                                                                                x15Var3 = x15Var;
                                                                                q55Var2 = q55Var;
                                                                                cursorQuery2 = cursor2;
                                                                                i4 = 4;
                                                                            } catch (SQLiteDatabaseLockedException unused17) {
                                                                                cursor2 = cursorQuery2;
                                                                                x15Var = x15Var3;
                                                                            } catch (SQLiteFullException e19) {
                                                                                e = e19;
                                                                                cursor2 = cursorQuery2;
                                                                                x15Var = x15Var3;
                                                                            } catch (SQLiteException e20) {
                                                                                e = e20;
                                                                                cursor2 = cursorQuery2;
                                                                                x15Var = x15Var3;
                                                                            }
                                                                        } catch (SQLiteDatabaseLockedException unused18) {
                                                                            cursor2 = cursorQuery2;
                                                                            x15Var = x15Var3;
                                                                            str3 = str6;
                                                                            sQLiteDatabase = sQLiteDatabaseB1;
                                                                            i3 = 5;
                                                                            SystemClock.sleep(i17);
                                                                            i17 += 20;
                                                                            if (cursor2 != null) {
                                                                            }
                                                                            if (sQLiteDatabase == null) {
                                                                            }
                                                                            i16 = i2 + 1;
                                                                            i15 = i3;
                                                                            str7 = str2;
                                                                            str6 = str3;
                                                                            x15Var3 = x15Var;
                                                                            str8 = str;
                                                                        } catch (SQLiteFullException e21) {
                                                                            e = e21;
                                                                            cursor2 = cursorQuery2;
                                                                            x15Var = x15Var3;
                                                                            str3 = str6;
                                                                            sQLiteDatabase = sQLiteDatabaseB1;
                                                                            i3 = 5;
                                                                            t65 t65Var422222222 = k85Var4.Y;
                                                                            k85.h(t65Var422222222);
                                                                            t65Var422222222.z0.b(e, "Error reading entries from local database");
                                                                            i65VarI.Z = true;
                                                                            if (cursor2 != null) {
                                                                            }
                                                                            if (sQLiteDatabase != null) {
                                                                            }
                                                                            i16 = i2 + 1;
                                                                            i15 = i3;
                                                                            str7 = str2;
                                                                            str6 = str3;
                                                                            x15Var3 = x15Var;
                                                                            str8 = str;
                                                                        } catch (SQLiteException e22) {
                                                                            e = e22;
                                                                            cursor2 = cursorQuery2;
                                                                            x15Var = x15Var3;
                                                                            str3 = str6;
                                                                            sQLiteDatabase = sQLiteDatabaseB1;
                                                                            i3 = 5;
                                                                            if (sQLiteDatabase != null) {
                                                                            }
                                                                            t65 t65Var522222222 = k85Var4.Y;
                                                                            k85.h(t65Var522222222);
                                                                            t65Var522222222.z0.b(e, "Error reading entries from local database");
                                                                            i65VarI.Z = true;
                                                                            if (cursor2 != null) {
                                                                            }
                                                                            if (sQLiteDatabase != null) {
                                                                            }
                                                                            i16 = i2 + 1;
                                                                            i15 = i3;
                                                                            str7 = str2;
                                                                            str6 = str3;
                                                                            x15Var3 = x15Var;
                                                                            str8 = str;
                                                                        }
                                                                    } catch (SQLiteDatabaseLockedException unused19) {
                                                                        cursor2 = cursorQuery2;
                                                                        x15Var = x15Var3;
                                                                        str2 = str7;
                                                                    } catch (SQLiteFullException e23) {
                                                                        e = e23;
                                                                        cursor2 = cursorQuery2;
                                                                        x15Var = x15Var3;
                                                                        str2 = str7;
                                                                    } catch (SQLiteException e24) {
                                                                        e = e24;
                                                                        cursor2 = cursorQuery2;
                                                                        x15Var = x15Var3;
                                                                        str2 = str7;
                                                                    }
                                                                } catch (SQLiteDatabaseLockedException unused20) {
                                                                    cursor2 = cursorQuery2;
                                                                    x15Var = x15Var3;
                                                                    str2 = str7;
                                                                    str3 = str6;
                                                                } catch (SQLiteFullException e25) {
                                                                    e = e25;
                                                                    cursor2 = cursorQuery2;
                                                                    x15Var = x15Var3;
                                                                    str2 = str7;
                                                                    str3 = str6;
                                                                } catch (SQLiteException e26) {
                                                                    e = e26;
                                                                    cursor2 = cursorQuery2;
                                                                    x15Var = x15Var3;
                                                                    str2 = str7;
                                                                    str3 = str6;
                                                                }
                                                            } catch (Throwable th11) {
                                                                th = th11;
                                                                cursor2 = cursorQuery2;
                                                            }
                                                        } catch (SQLiteDatabaseLockedException unused21) {
                                                            cursor2 = cursorQuery2;
                                                            x15Var = x15Var3;
                                                            str2 = str7;
                                                            str3 = str6;
                                                        } catch (SQLiteFullException e27) {
                                                            e = e27;
                                                            cursor2 = cursorQuery2;
                                                            x15Var = x15Var3;
                                                            str2 = str7;
                                                            str3 = str6;
                                                        } catch (SQLiteException e28) {
                                                            e = e28;
                                                            cursor2 = cursorQuery2;
                                                            x15Var = x15Var3;
                                                            str2 = str7;
                                                            str3 = str6;
                                                        }
                                                    }
                                                    cursor2 = cursorQuery2;
                                                    x15Var = x15Var3;
                                                    str2 = str7;
                                                    str3 = str6;
                                                    i = 0;
                                                    sQLiteDatabase = sQLiteDatabaseB1;
                                                } catch (SQLiteDatabaseLockedException unused22) {
                                                    x15Var = x15Var3;
                                                    str3 = str6;
                                                    sQLiteDatabase = sQLiteDatabaseB1;
                                                    str2 = str7;
                                                    i3 = i6;
                                                    cursor2 = null;
                                                    SystemClock.sleep(i17);
                                                    i17 += 20;
                                                    if (cursor2 != null) {
                                                    }
                                                    if (sQLiteDatabase == null) {
                                                    }
                                                    i16 = i2 + 1;
                                                    i15 = i3;
                                                    str7 = str2;
                                                    str6 = str3;
                                                    x15Var3 = x15Var;
                                                    str8 = str;
                                                }
                                            } catch (SQLiteFullException e29) {
                                                e = e29;
                                                x15Var = x15Var3;
                                                str3 = str6;
                                                sQLiteDatabase = sQLiteDatabaseB1;
                                                str2 = str7;
                                                i3 = 5;
                                                cursor2 = null;
                                                t65 t65Var4222222222 = k85Var4.Y;
                                                k85.h(t65Var4222222222);
                                                t65Var4222222222.z0.b(e, "Error reading entries from local database");
                                                i65VarI.Z = true;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase != null) {
                                                }
                                                i16 = i2 + 1;
                                                i15 = i3;
                                                str7 = str2;
                                                str6 = str3;
                                                x15Var3 = x15Var;
                                                str8 = str;
                                            } catch (SQLiteException e30) {
                                                e = e30;
                                                x15Var = x15Var3;
                                                str3 = str6;
                                                sQLiteDatabase = sQLiteDatabaseB1;
                                                str2 = str7;
                                                i3 = 5;
                                                cursor2 = null;
                                                if (sQLiteDatabase != null) {
                                                }
                                                t65 t65Var5222222222 = k85Var4.Y;
                                                k85.h(t65Var5222222222);
                                                t65Var5222222222.z0.b(e, "Error reading entries from local database");
                                                i65VarI.Z = true;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase != null) {
                                                }
                                                i16 = i2 + 1;
                                                i15 = i3;
                                                str7 = str2;
                                                str6 = str3;
                                                x15Var3 = x15Var;
                                                str8 = str;
                                            }
                                            try {
                                                if (sQLiteDatabase.delete("messages", "rowid <= ?", new String[]{Long.toString(j5)}) < arrayList.size()) {
                                                    t65 t65Var11 = k85Var4.Y;
                                                    k85.h(t65Var11);
                                                    t65Var11.z0.a("Fewer entries removed from local database than expected");
                                                }
                                                sQLiteDatabase.setTransactionSuccessful();
                                                sQLiteDatabase.endTransaction();
                                                cursor2.close();
                                                sQLiteDatabase.close();
                                            } catch (SQLiteDatabaseLockedException unused23) {
                                                i3 = 5;
                                                SystemClock.sleep(i17);
                                                i17 += 20;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase == null) {
                                                }
                                                i16 = i2 + 1;
                                                i15 = i3;
                                                str7 = str2;
                                                str6 = str3;
                                                x15Var3 = x15Var;
                                                str8 = str;
                                            } catch (SQLiteFullException e31) {
                                                e = e31;
                                                i3 = 5;
                                                t65 t65Var42222222222 = k85Var4.Y;
                                                k85.h(t65Var42222222222);
                                                t65Var42222222222.z0.b(e, "Error reading entries from local database");
                                                i65VarI.Z = true;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase != null) {
                                                }
                                                i16 = i2 + 1;
                                                i15 = i3;
                                                str7 = str2;
                                                str6 = str3;
                                                x15Var3 = x15Var;
                                                str8 = str;
                                            } catch (SQLiteException e32) {
                                                e = e32;
                                                i3 = 5;
                                                if (sQLiteDatabase != null) {
                                                }
                                                t65 t65Var52222222222 = k85Var4.Y;
                                                k85.h(t65Var52222222222);
                                                t65Var52222222222.z0.b(e, "Error reading entries from local database");
                                                i65VarI.Z = true;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase != null) {
                                                }
                                                i16 = i2 + 1;
                                                i15 = i3;
                                                str7 = str2;
                                                str6 = str3;
                                                x15Var3 = x15Var;
                                                str8 = str;
                                            }
                                        } catch (SQLiteDatabaseLockedException unused24) {
                                            x15Var = x15Var3;
                                            str = str8;
                                        } catch (SQLiteFullException e33) {
                                            e = e33;
                                            x15Var = x15Var3;
                                            str = str8;
                                        } catch (SQLiteException e34) {
                                            e = e34;
                                            x15Var = x15Var3;
                                            str = str8;
                                        }
                                    } catch (Throwable th12) {
                                        th = th12;
                                        i2 = i16;
                                    }
                                } catch (Throwable th13) {
                                    th = th13;
                                    x15Var = x15Var3;
                                    i2 = i16;
                                    str = str8;
                                    str3 = str6;
                                    sQLiteDatabase = sQLiteDatabaseB1;
                                    i3 = 5;
                                    str2 = str7;
                                    cursorQuery = null;
                                }
                            }
                        } catch (SQLiteDatabaseLockedException unused25) {
                            x15Var = x15Var3;
                            i2 = i16;
                            str = str8;
                            str2 = str7;
                            str3 = str6;
                            i3 = 5;
                            sQLiteDatabase = null;
                        } catch (SQLiteFullException e35) {
                            e = e35;
                            x15Var = x15Var3;
                            i2 = i16;
                            str = str8;
                            str2 = str7;
                            str3 = str6;
                            i3 = 5;
                            sQLiteDatabase = null;
                        } catch (SQLiteException e36) {
                            e = e36;
                            x15Var = x15Var3;
                            i2 = i16;
                            str = str8;
                            str2 = str7;
                            str3 = str6;
                            i3 = 5;
                            sQLiteDatabase = null;
                        } catch (Throwable th14) {
                            th = th14;
                            sQLiteDatabase = null;
                        }
                    }
                    x15Var = x15Var3;
                    i = 0;
                    t65 t65Var12 = k85Var4.Y;
                    k85.h(t65Var12);
                    t65Var12.C0.a("Failed to read events from database in reasonable time");
                    arrayList = null;
                } else {
                    x15Var = x15Var3;
                    context = context3;
                    t65Var = t65Var3;
                    i = 0;
                }
                if (arrayList == null) {
                    arrayList2.addAll(arrayList);
                    size = arrayList.size();
                } else {
                    size = i;
                }
                if (y1Var2 != null && size < i13) {
                    arrayList2.add(new g65(y1Var2, tg5Var2.z, tg5Var2.A0));
                }
                x15 x15Var5 = x15Var;
                String str9 = null;
                boolean zF1 = x15Var5.f1(null, r55.P0);
                size2 = arrayList2.size();
                i8 = i;
                while (i8 < size2) {
                    g65 g65Var = (g65) arrayList2.get(i8);
                    y1 y1Var3 = g65Var.a;
                    q55 q55Var3 = r55.c1;
                    if (x15Var5.f1(str9, q55Var3)) {
                        String str10 = g65Var.b;
                        if (TextUtils.isEmpty(str10)) {
                            i9 = size;
                            x15Var2 = x15Var5;
                        } else {
                            x15Var2 = x15Var5;
                            i9 = size;
                            tg5Var2 = new tg5(tg5Var2.b, tg5Var2.f, str10, g65Var.c, tg5Var2.A, tg5Var2.X, tg5Var2.Y, tg5Var2.Z, tg5Var2.y0, tg5Var2.z0, tg5Var2.B0, tg5Var2.C0, tg5Var2.D0, tg5Var2.E0, tg5Var2.F0, tg5Var2.G0, tg5Var2.H0, tg5Var2.I0, tg5Var2.J0, tg5Var2.K0, tg5Var2.L0, tg5Var2.M0, tg5Var2.N0, tg5Var2.O0, tg5Var2.P0, tg5Var2.Q0, tg5Var2.R0, tg5Var2.S0, tg5Var2.T0, tg5Var2.U0, tg5Var2.V0);
                        }
                    }
                    if (y1Var3 instanceof z25) {
                        if (zF1) {
                            try {
                                wl3Var2.getClass();
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                try {
                                    wl3Var2.getClass();
                                    jElapsedRealtime = SystemClock.elapsedRealtime();
                                    j4 = jCurrentTimeMillis;
                                } catch (RemoteException e37) {
                                    e = e37;
                                    j3 = jCurrentTimeMillis;
                                    jElapsedRealtime = 0;
                                    k85Var2 = k85Var;
                                    context2 = context;
                                    t65Var2 = t65Var;
                                    k85.h(t65Var2);
                                    t65Var2.z0.b(e, "Failed to send event to the service");
                                    if (zF1 && j3 != 0) {
                                        n02Var = n02.Y;
                                        if (n02Var == null) {
                                            n02Var = new n02(context2, k85Var2);
                                            n02.Y = n02Var;
                                        }
                                        wl3Var2.getClass();
                                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                                        wl3Var2.getClass();
                                        n02Var.W(13, (int) (SystemClock.elapsedRealtime() - jElapsedRealtime), j3, jCurrentTimeMillis2);
                                    }
                                    str5 = null;
                                    i8++;
                                    t65Var = t65Var2;
                                    k85Var = k85Var2;
                                    context = context2;
                                    x15Var5 = x15Var2;
                                    size = i9;
                                    str9 = str5;
                                }
                            } catch (RemoteException e38) {
                                e = e38;
                                jElapsedRealtime = 0;
                                j3 = 0;
                            }
                        } else {
                            jElapsedRealtime = 0;
                            j4 = 0;
                        }
                        try {
                            v55Var.f((z25) y1Var3, tg5Var2);
                            if (zF1) {
                                k85.h(t65Var);
                                t65Var2 = t65Var;
                                try {
                                    t65Var2.H0.a("Logging telemetry for logEvent from database");
                                    n02 n02Var2 = n02.Y;
                                    if (n02Var2 == null) {
                                        k85Var2 = k85Var;
                                        context2 = context;
                                        try {
                                            n02Var2 = new n02(context2, k85Var2);
                                            n02.Y = n02Var2;
                                        } catch (RemoteException e39) {
                                            e = e39;
                                            j3 = j4;
                                            k85.h(t65Var2);
                                            t65Var2.z0.b(e, "Failed to send event to the service");
                                            if (zF1) {
                                                n02Var = n02.Y;
                                                if (n02Var == null) {
                                                }
                                                wl3Var2.getClass();
                                                long jCurrentTimeMillis22 = System.currentTimeMillis();
                                                wl3Var2.getClass();
                                                n02Var.W(13, (int) (SystemClock.elapsedRealtime() - jElapsedRealtime), j3, jCurrentTimeMillis22);
                                            }
                                        }
                                    } else {
                                        k85Var2 = k85Var;
                                        context2 = context;
                                    }
                                    n02 n02Var3 = n02Var2;
                                    wl3Var2.getClass();
                                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                                    wl3Var2.getClass();
                                    n02Var3.W(0, (int) (SystemClock.elapsedRealtime() - jElapsedRealtime), j4, jCurrentTimeMillis3);
                                } catch (RemoteException e40) {
                                    e = e40;
                                    k85Var2 = k85Var;
                                    context2 = context;
                                }
                            } else {
                                k85Var2 = k85Var;
                                context2 = context;
                                t65Var2 = t65Var;
                            }
                        } catch (RemoteException e41) {
                            e = e41;
                            k85Var2 = k85Var;
                            context2 = context;
                            t65Var2 = t65Var;
                        }
                    } else {
                        k85Var2 = k85Var;
                        context2 = context;
                        t65Var2 = t65Var;
                        if (y1Var3 instanceof kf5) {
                            try {
                                v55Var.B((kf5) y1Var3, tg5Var2);
                            } catch (RemoteException e42) {
                                k85.h(t65Var2);
                                t65Var2.z0.b(e42, "Failed to send user property to the service");
                            }
                        } else if (y1Var3 instanceof q15) {
                            try {
                                v55Var.r((q15) y1Var3, tg5Var2);
                            } catch (RemoteException e43) {
                                k85.h(t65Var2);
                                t65Var2.z0.b(e43, "Failed to send conditional user property to the service");
                            }
                        } else {
                            str5 = null;
                            if (k85Var2.A.f1(null, q55Var3) && (y1Var3 instanceof y25)) {
                                try {
                                    v55Var.q(((y25) y1Var3).l(), tg5Var2);
                                } catch (RemoteException e44) {
                                    k85.h(t65Var2);
                                    t65Var2.z0.b(e44, "Failed to send default event parameters to the service");
                                }
                            } else {
                                k85.h(t65Var2);
                                t65Var2.z0.a("Discarding data. Unrecognized parcel type.");
                            }
                            i8++;
                            t65Var = t65Var2;
                            k85Var = k85Var2;
                            context = context2;
                            x15Var5 = x15Var2;
                            size = i9;
                            str9 = str5;
                        }
                    }
                    str5 = null;
                    i8++;
                    t65Var = t65Var2;
                    k85Var = k85Var2;
                    context = context2;
                    x15Var5 = x15Var2;
                    size = i9;
                    str9 = str5;
                }
                int i19 = size;
                x15 x15Var6 = x15Var5;
                k85Var3 = k85Var;
                i12 = i14 + 1;
                t65Var3 = t65Var;
                context3 = context;
                x15Var3 = x15Var6;
                wl3Var = wl3Var2;
                i11 = i19;
                i10 = 100;
                y1Var2 = y1Var;
            }
            i = 0;
            arrayList = null;
            if (arrayList == null) {
            }
            if (y1Var2 != null) {
                arrayList2.add(new g65(y1Var2, tg5Var2.z, tg5Var2.A0));
            }
            x15 x15Var52 = x15Var;
            String str92 = null;
            boolean zF12 = x15Var52.f1(null, r55.P0);
            size2 = arrayList2.size();
            i8 = i;
            while (i8 < size2) {
            }
            int i192 = size;
            x15 x15Var62 = x15Var52;
            k85Var3 = k85Var;
            i12 = i14 + 1;
            t65Var3 = t65Var;
            context3 = context;
            x15Var3 = x15Var62;
            wl3Var = wl3Var2;
            i11 = i192;
            i10 = 100;
            y1Var2 = y1Var;
        }
    }

    public final void o1(q15 q15Var) {
        boolean zC1;
        V0();
        W0();
        k85 k85Var = (k85) this.f;
        k85Var.getClass();
        i65 i65VarI = k85Var.i();
        k85 k85Var2 = (k85) i65VarI.f;
        k85.f(k85Var2.z0);
        byte[] bArrB1 = qf5.B1(q15Var);
        if (bArrB1.length > 131072) {
            t65 t65Var = k85Var2.Y;
            k85.h(t65Var);
            t65Var.A0.a("Conditional user property too long for local database. Sending directly to service");
            zC1 = false;
        } else {
            zC1 = i65VarI.c1(2, bArrB1);
        }
        j1(new ec5(this, l1(true), zC1, new q15(q15Var)));
    }
}
