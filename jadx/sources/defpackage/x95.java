package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x95 {
    public static final ConcurrentHashMap i = new ConcurrentHashMap();
    public static final String[] j = {"key", "value"};
    public final ContentResolver a;
    public final Uri b;
    public final Runnable c;
    public volatile Map g;
    public mg0 d = null;
    public volatile boolean e = true;
    public final Object f = new Object();
    public final ArrayList h = new ArrayList();

    public x95(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        contentResolver.getClass();
        uri.getClass();
        this.a = contentResolver;
        this.b = uri;
        this.c = runnable;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002b A[PHI: r1
      0x002b: PHI (r1v3 x95) = (r1v2 x95), (r1v4 x95) binds: [B:6:0x001c, B:8:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.x95 a(final android.content.ContentResolver r2, final android.net.Uri r3, final java.lang.Runnable r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L14
            j$.util.concurrent.ConcurrentHashMap r0 = defpackage.x95.i
            w95 r1 = new w95
            r1.<init>()
            java.lang.Object r2 = j$.util.concurrent.ConcurrentMap.EL.computeIfAbsent(r0, r3, r1)
            x95 r2 = (defpackage.x95) r2
            goto L2c
        L14:
            j$.util.concurrent.ConcurrentHashMap r0 = defpackage.x95.i
            java.lang.Object r1 = r0.get(r3)
            x95 r1 = (defpackage.x95) r1
            if (r1 != 0) goto L2b
            x95 r1 = new x95
            r1.<init>(r2, r3, r4)
            java.lang.Object r2 = r0.putIfAbsent(r3, r1)
            x95 r2 = (defpackage.x95) r2
            if (r2 != 0) goto L2c
        L2b:
            r2 = r1
        L2c:
            boolean r3 = r2.e     // Catch: java.lang.SecurityException -> L4e
            if (r3 == 0) goto L4d
            monitor-enter(r2)     // Catch: java.lang.SecurityException -> L4e
            boolean r3 = r2.e     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto L49
            mg0 r3 = new mg0     // Catch: java.lang.Throwable -> L47
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L47
            android.content.ContentResolver r4 = r2.a     // Catch: java.lang.Throwable -> L47
            android.net.Uri r0 = r2.b     // Catch: java.lang.Throwable -> L47
            r1 = 0
            r4.registerContentObserver(r0, r1, r3)     // Catch: java.lang.Throwable -> L47
            r2.d = r3     // Catch: java.lang.Throwable -> L47
            r2.e = r1     // Catch: java.lang.Throwable -> L47
            goto L49
        L47:
            r3 = move-exception
            goto L4b
        L49:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L47
            return r2
        L4b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L47
            throw r3     // Catch: java.lang.SecurityException -> L4e
        L4d:
            return r2
        L4e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x95.a(android.content.ContentResolver, android.net.Uri, java.lang.Runnable):x95");
    }

    public static void c() {
        Iterator it = i.values().iterator();
        while (it.hasNext()) {
            x95 x95Var = (x95) it.next();
            synchronized (x95Var) {
                try {
                    if (x95Var.e) {
                        x95Var.e = false;
                    } else {
                        mg0 mg0Var = x95Var.d;
                        if (mg0Var != null) {
                            x95Var.a.unregisterContentObserver(mg0Var);
                            x95Var.d = null;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            it.remove();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0053  */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.os.StrictMode$ThreadPolicy, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map b() {
        /*
            r5 = this;
            java.util.Map r0 = r5.g
            if (r0 != 0) goto L50
            java.lang.Object r1 = r5.f
            monitor-enter(r1)
            java.util.Map r0 = r5.g     // Catch: java.lang.Throwable -> L2b
            if (r0 != 0) goto L4c
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskReads()     // Catch: java.lang.Throwable -> L2b
            rz4 r2 = new rz4     // Catch: java.lang.Throwable -> L2d java.lang.IllegalStateException -> L2f android.database.sqlite.SQLiteException -> L31 java.lang.SecurityException -> L33
            r3 = 4
            r2.<init>(r3, r5)     // Catch: java.lang.Throwable -> L2d java.lang.IllegalStateException -> L2f android.database.sqlite.SQLiteException -> L31 java.lang.SecurityException -> L33
            java.lang.Object r2 = r2.c()     // Catch: java.lang.SecurityException -> L1a java.lang.Throwable -> L2d java.lang.IllegalStateException -> L2f android.database.sqlite.SQLiteException -> L31
            goto L25
        L1a:
            long r3 = android.os.Binder.clearCallingIdentity()     // Catch: java.lang.Throwable -> L2d java.lang.IllegalStateException -> L2f android.database.sqlite.SQLiteException -> L31 java.lang.SecurityException -> L33
            java.lang.Object r2 = r2.c()     // Catch: java.lang.Throwable -> L35
            android.os.Binder.restoreCallingIdentity(r3)     // Catch: java.lang.Throwable -> L2d java.lang.IllegalStateException -> L2f android.database.sqlite.SQLiteException -> L31 java.lang.SecurityException -> L33
        L25:
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Throwable -> L2d java.lang.IllegalStateException -> L2f android.database.sqlite.SQLiteException -> L31 java.lang.SecurityException -> L33
        L27:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch: java.lang.Throwable -> L2b
            goto L44
        L2b:
            r5 = move-exception
            goto L4e
        L2d:
            r5 = move-exception
            goto L48
        L2f:
            r2 = move-exception
            goto L3a
        L31:
            r2 = move-exception
            goto L3a
        L33:
            r2 = move-exception
            goto L3a
        L35:
            r2 = move-exception
            android.os.Binder.restoreCallingIdentity(r3)     // Catch: java.lang.Throwable -> L2d java.lang.IllegalStateException -> L2f android.database.sqlite.SQLiteException -> L31 java.lang.SecurityException -> L33
            throw r2     // Catch: java.lang.Throwable -> L2d java.lang.IllegalStateException -> L2f android.database.sqlite.SQLiteException -> L31 java.lang.SecurityException -> L33
        L3a:
            java.lang.String r3 = "ConfigurationContentLdr"
            java.lang.String r4 = "Unable to query ContentProvider, using default values"
            io.sentry.android.core.a1.o(r3, r4, r2)     // Catch: java.lang.Throwable -> L2d
            java.util.Map r2 = java.util.Collections.EMPTY_MAP     // Catch: java.lang.Throwable -> L2d
            goto L27
        L44:
            r5.g = r2     // Catch: java.lang.Throwable -> L2b
            r0 = r2
            goto L4c
        L48:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch: java.lang.Throwable -> L2b
            throw r5     // Catch: java.lang.Throwable -> L2b
        L4c:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2b
            goto L50
        L4e:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2b
            throw r5
        L50:
            if (r0 == 0) goto L53
            return r0
        L53:
            java.util.Map r5 = java.util.Collections.EMPTY_MAP
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x95.b():java.util.Map");
    }
}
