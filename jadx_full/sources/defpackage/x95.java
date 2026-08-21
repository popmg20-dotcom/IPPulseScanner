package defpackage;

import android.content.ContentResolver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.StrictMode;
import io.sentry.android.core.a1;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.Function$CC;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

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
    */
    public static x95 a(final ContentResolver contentResolver, final Uri uri, final Runnable runnable) {
        x95 x95Var;
        if (Build.VERSION.SDK_INT >= 24) {
            x95Var = (x95) ConcurrentMap.EL.computeIfAbsent(i, uri, new Function() { // from class: w95
                public /* synthetic */ Function andThen(Function function) {
                    return Function$CC.$default$andThen(this, function);
                }

                @Override // java.util.function.Function
                public final /* synthetic */ Object apply(Object obj) {
                    return new x95(contentResolver, uri, runnable);
                }

                public /* synthetic */ Function compose(Function function) {
                    return Function$CC.$default$compose(this, function);
                }
            });
        } else {
            ConcurrentHashMap concurrentHashMap = i;
            x95 x95Var2 = (x95) concurrentHashMap.get(uri);
            if (x95Var2 == null) {
                x95Var2 = new x95(contentResolver, uri, runnable);
                x95Var = (x95) concurrentHashMap.putIfAbsent(uri, x95Var2);
                if (x95Var == null) {
                    x95Var = x95Var2;
                }
            }
        }
        try {
            if (!x95Var.e) {
                return x95Var;
            }
            synchronized (x95Var) {
                try {
                    if (x95Var.e) {
                        mg0 mg0Var = new mg0(x95Var);
                        x95Var.a.registerContentObserver(x95Var.b, false, mg0Var);
                        x95Var.d = mg0Var;
                        x95Var.e = false;
                    }
                } finally {
                }
            }
            return x95Var;
        } catch (SecurityException unused) {
            return null;
        }
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
    */
    public final Map b() {
        Map map;
        ?? r0;
        Object objC;
        Map map2 = this.g;
        ?? r02 = map2;
        if (map2 == null) {
            synchronized (this.f) {
                ?? r03 = this.g;
                r0 = r03;
                if (r03 == 0) {
                    try {
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            try {
                                rz4 rz4Var = new rz4(4, this);
                                try {
                                    objC = rz4Var.c();
                                } catch (SecurityException unused) {
                                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                                    try {
                                        objC = rz4Var.c();
                                    } finally {
                                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                                    }
                                }
                                map = (Map) objC;
                            } catch (SecurityException e) {
                                e = e;
                                a1.o("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e);
                                map = Collections.EMPTY_MAP;
                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                                this.g = map;
                                r0 = map;
                                r02 = r0;
                                if (r02 == 0) {
                                }
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            a1.o("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e);
                            map = Collections.EMPTY_MAP;
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            this.g = map;
                            r0 = map;
                            r02 = r0;
                            if (r02 == 0) {
                            }
                        } catch (IllegalStateException e3) {
                            e = e3;
                            a1.o("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e);
                            map = Collections.EMPTY_MAP;
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            this.g = map;
                            r0 = map;
                            r02 = r0;
                            if (r02 == 0) {
                            }
                        }
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        this.g = map;
                        r0 = map;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(r03);
                        throw th;
                    }
                }
            }
            r02 = r0;
        }
        return r02 == 0 ? r02 : Collections.EMPTY_MAP;
    }
}
