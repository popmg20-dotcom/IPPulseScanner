package defpackage;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.SparseArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ca5 {
    public Object a;
    public final Object b;

    public ca5() {
        this.a = new TreeMap();
        this.b = new TreeMap();
    }

    public void a(Throwable th) {
        ee5 ee5Var = (ee5) this.a;
        ib5 ib5Var = (ib5) this.b;
        ib5Var.V0();
        boolean z = false;
        ib5Var.C0 = false;
        k85 k85Var = (k85) ib5Var.f;
        x15 x15Var = k85Var.A;
        t65 t65Var = k85Var.Y;
        int i = 2;
        int i2 = 1;
        if (x15Var.f1(null, r55.U0)) {
            String message = th.getMessage();
            ib5Var.H0 = false;
            if (message != null) {
                if ((th instanceof IllegalStateException) || message.contains("garbage collected") || th.getClass().getSimpleName().equals("ra0")) {
                    if (message.contains("Background")) {
                        ib5Var.H0 = true;
                    }
                    i = 1;
                } else if ((th instanceof SecurityException) && !message.endsWith("READ_DEVICE_CONFIG")) {
                    i = 3;
                }
            }
        }
        int i3 = i - 1;
        if (i3 == 0) {
            k85.h(t65Var);
            t65Var.C0.c("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", t65.Z0(k85Var.l().b1()), t65.Z0(th.toString()));
            ib5Var.D0 = 1;
            ib5Var.t1().add(ee5Var);
            return;
        }
        if (i3 != 1) {
            k85.h(t65Var);
            t65Var.z0.c("registerTriggerAsync failed. Dropping URI. App ID, Throwable", t65.Z0(k85Var.l().b1()), th);
            c();
            ib5Var.D0 = 1;
            ib5Var.u1();
            return;
        }
        ib5Var.t1().add(ee5Var);
        if (ib5Var.D0 > ((Integer) r55.x0.a(null)).intValue()) {
            ib5Var.D0 = 1;
            k85.h(t65Var);
            t65Var.C0.c("registerTriggerAsync failed. May try later. App ID, throwable", t65.Z0(k85Var.l().b1()), t65.Z0(th.toString()));
            return;
        }
        k85.h(t65Var);
        t65Var.C0.d("registerTriggerAsync failed. App ID, delay in seconds, throwable", t65.Z0(k85Var.l().b1()), t65.Z0(String.valueOf(ib5Var.D0)), t65.Z0(th.toString()));
        int i4 = ib5Var.D0;
        ba5 ba5Var = ib5Var.E0;
        if (ba5Var == null) {
            ba5Var = new ba5(ib5Var, k85Var, i2, z);
            ib5Var.E0 = ba5Var;
        }
        ba5Var.b(((long) i4) * 1000);
        int i5 = ib5Var.D0;
        ib5Var.D0 = i5 + i5;
    }

    public Object b() {
        Uri uri;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        String string;
        fa5 fa5Var = (fa5) this.a;
        String str = (String) this.b;
        Context context = (Context) fa5Var.f;
        context.getClass();
        ContentResolver contentResolver = context.getContentResolver();
        r90 r90Var = l95.a;
        String str2 = null;
        if (contentResolver == null) {
            r90Var.getClass();
            xe.q("ContentResolver needed with GservicesDelegateSupplier.init()");
            return null;
        }
        synchronized (r90Var) {
            try {
                HashMap map = (HashMap) r90Var.a;
                AtomicBoolean atomicBoolean = (AtomicBoolean) r90Var.d;
                if (map == null) {
                    atomicBoolean.set(false);
                    r90Var.a = new HashMap(16, 1.0f);
                    r90Var.g = new Object();
                    contentResolver.registerContentObserver(n95.a, true, new mg0(r90Var));
                } else if (atomicBoolean.getAndSet(false)) {
                    ((HashMap) r90Var.a).clear();
                    ((HashMap) r90Var.b).clear();
                    ((HashMap) r90Var.c).clear();
                    ((HashMap) r90Var.e).clear();
                    ((HashMap) r90Var.f).clear();
                    r90Var.g = new Object();
                }
                Object obj = r90Var.g;
                if (((HashMap) r90Var.a).containsKey(str)) {
                    String str3 = (String) ((HashMap) r90Var.a).get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                    return str2;
                }
                try {
                    uri = n95.a;
                    contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                } catch (s95 unused) {
                }
                try {
                    if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                        throw new s95("Unable to acquire ContentProviderClient");
                    }
                    try {
                        Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, new String[]{str}, null);
                        try {
                            if (cursorQuery == null) {
                                throw new s95("ContentProvider query returned null cursor");
                            }
                            if (cursorQuery.moveToFirst()) {
                                string = cursorQuery.getString(1);
                                cursorQuery.close();
                                contentProviderClientAcquireUnstableContentProviderClient.release();
                            } else {
                                cursorQuery.close();
                                contentProviderClientAcquireUnstableContentProviderClient.release();
                                string = null;
                            }
                            if (string != null && string.equals(null)) {
                                string = null;
                            }
                            synchronized (r90Var) {
                                try {
                                    if (obj == r90Var.g) {
                                        ((HashMap) r90Var.a).put(str, string);
                                    }
                                } finally {
                                }
                            }
                            if (string != null) {
                                return string;
                            }
                            return null;
                        } finally {
                        }
                    } catch (RemoteException e) {
                        throw new s95("ContentProvider query failed", e);
                    }
                } catch (Throwable th) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    throw th;
                }
            } finally {
            }
        }
    }

    public void c() {
        k85 k85Var = (k85) ((ib5) this.b).f;
        l75 l75Var = k85Var.X;
        k85.f(l75Var);
        SparseArray sparseArrayB1 = l75Var.b1();
        ee5 ee5Var = (ee5) this.a;
        sparseArrayB1.put(ee5Var.z, Long.valueOf(ee5Var.f));
        l75 l75Var2 = k85Var.X;
        k85.f(l75Var2);
        int[] iArr = new int[sparseArrayB1.size()];
        long[] jArr = new long[sparseArrayB1.size()];
        for (int i = 0; i < sparseArrayB1.size(); i++) {
            iArr[i] = sparseArrayB1.keyAt(i);
            jArr[i] = ((Long) sparseArrayB1.valueAt(i)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        l75Var2.H0.j(bundle);
    }

    public void d(ih4 ih4Var, n02 n02Var) {
        bb5 bb5Var = new bb5(n02Var);
        TreeMap treeMap = (TreeMap) this.a;
        for (Integer num : treeMap.keySet()) {
            y05 y05VarClone = ((y05) n02Var.z).clone();
            d25 d25VarJ = ((b25) treeMap.get(num)).j(ih4Var, Collections.singletonList(bb5Var));
            int iR0 = d25VarJ instanceof p15 ? je.r0(((p15) d25VarJ).b.doubleValue()) : -1;
            if (iR0 == 2 || iR0 == -1) {
                n02Var.z = y05VarClone;
            }
        }
        TreeMap treeMap2 = (TreeMap) this.b;
        Iterator it = treeMap2.keySet().iterator();
        while (it.hasNext()) {
            d25 d25VarJ2 = ((b25) treeMap2.get((Integer) it.next())).j(ih4Var, Collections.singletonList(bb5Var));
            if (d25VarJ2 instanceof p15) {
                je.r0(((p15) d25VarJ2).b.doubleValue());
            }
        }
    }

    public /* synthetic */ ca5(Object obj, Object obj2, boolean z) {
        this.a = obj;
        this.b = obj2;
    }

    public /* synthetic */ ca5(Object obj, Object obj2) {
        this.a = obj2;
        this.b = obj;
    }

    public ca5(zd5 zd5Var) {
        this.b = zd5Var;
    }
}
