package io.sentry.util;

import defpackage.dw2;
import defpackage.ha0;
import defpackage.vp1;
import defpackage.xe;
import io.sentry.ILogger;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.v0;
import io.sentry.f5;
import io.sentry.l0;
import io.sentry.l3;
import io.sentry.n2;
import io.sentry.n5;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.c0;
import io.sentry.protocol.e0;
import io.sentry.protocol.v;
import io.sentry.w2;
import io.sentry.x3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final String[] a = new String[0];

    public static void a(String str) {
        n5.d().a(str);
    }

    public static x3 b(x3 x3Var) {
        if (((Double) x3Var.c) != null) {
            return x3Var;
        }
        return new x3((Boolean) x3Var.a, (Double) x3Var.b, c((Boolean) x3Var.a, null, (Double) x3Var.b), (Boolean) x3Var.d, (Double) x3Var.e);
    }

    public static Double c(Boolean bool, Double d, Double d2) {
        if (d != null) {
            return d;
        }
        double dC = n.a().c();
        if (d2 == null || bool == null) {
            return Double.valueOf(dC);
        }
        if (bool.booleanValue()) {
            return Double.valueOf(d2.doubleValue() * dC);
        }
        return Double.valueOf(((1.0d - d2.doubleValue()) * dC) + d2.doubleValue());
    }

    public static ClassLoader d(ClassLoader classLoader) {
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader != null ? contextClassLoader : ClassLoader.getSystemClassLoader();
    }

    public static boolean e(File file) {
        return file.isDirectory() || file.mkdirs() || file.isDirectory();
    }

    public static l0 f(Object obj) {
        l0 l0Var = new l0();
        l0Var.d(obj, "sentry:typeCheckHint");
        return l0Var;
    }

    public static boolean g(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return true;
        }
        for (File file2 : fileArrListFiles) {
            if (!g(file2)) {
                return false;
            }
        }
        return file.delete();
    }

    public static io.sentry.c h(io.sentry.c cVar, Boolean bool, Double d, Double d2) {
        if (cVar == null) {
            cVar = new io.sentry.c(w2.b);
        }
        if (cVar.d == null) {
            Double d3 = cVar.c;
            if (d3 != null) {
                d = d3;
            }
            Double dC = c(bool, d2, d);
            if (cVar.f) {
                cVar.d = dC;
            }
        }
        if (cVar.f && cVar.g) {
            cVar.f = false;
        }
        return cVar;
    }

    public static boolean i(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean j(l0 l0Var, Class cls) {
        return cls.isInstance(l0Var.b("sentry:typeCheckHint"));
    }

    public static boolean k(l0 l0Var) {
        return Boolean.TRUE.equals(l0Var.c(Boolean.class, "sentry:isFromHybridSdk"));
    }

    public static boolean l(f5 f5Var, SentryAndroidOptions sentryAndroidOptions) {
        return d.a(sentryAndroidOptions.getSerializer(), sentryAndroidOptions.getLogger(), f5Var) <= p6.MAX_EVENT_SIZE_BYTES;
    }

    public static boolean m(Double d, boolean z) {
        return d == null ? z : !d.isNaN() && d.doubleValue() >= 0.0d && d.doubleValue() <= 1.0d;
    }

    public static void n(Class cls, Object obj, ILogger iLogger) {
        iLogger.h(p5.DEBUG, "%s is not %s", obj != null ? obj.getClass().getCanonicalName() : "Hint", cls.getCanonicalName());
    }

    public static ConcurrentHashMap o(Map map) {
        if (map == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                concurrentHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return concurrentHashMap;
    }

    public static byte[] p(long j, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        File file = new File(str);
        if (!file.exists()) {
            vp1.i(ha0.o("File '", file.getName(), "' doesn't exists"));
            return null;
        }
        if (!file.isFile()) {
            vp1.i(ha0.o("Reading path ", str, " failed, because it's not a file."));
            return null;
        }
        if (!file.canRead()) {
            vp1.i(ha0.o("Reading the item ", str, " failed, because can't read the file."));
            return null;
        }
        if (file.length() > j) {
            throw new IOException(String.format("Reading file failed, because size located at '%s' with %d bytes is bigger than the maximum allowed size of %d bytes.", str, Long.valueOf(file.length()), Long.valueOf(j)));
        }
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bArr = new byte[1024];
                } finally {
                }
            } finally {
            }
            while (true) {
                int i = bufferedInputStream.read(bArr);
                if (i == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    bufferedInputStream.close();
                    fileInputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String q(File file) throws IOException {
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
            }
            while (true) {
                String line2 = bufferedReader.readLine();
                if (line2 == null) {
                    bufferedReader.close();
                    return sb.toString();
                }
                sb.append("\n");
                sb.append(line2);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void r(Object obj, String str) {
        if (obj != null) {
            return;
        }
        xe.k(str);
    }

    public static boolean s(l0 l0Var) {
        return !(io.sentry.hints.d.class.isInstance(l0Var.b("sentry:typeCheckHint")) || io.sentry.hints.b.class.isInstance(l0Var.b("sentry:typeCheckHint"))) || v0.class.isInstance(l0Var.b("sentry:typeCheckHint"));
    }

    public static boolean t(p6 p6Var, SentryAndroidOptions sentryAndroidOptions, boolean z) {
        boolean z2 = j.a;
        int i = 0;
        if (!z2 && (sentryAndroidOptions.getVersionDetector() instanceof l3)) {
            sentryAndroidOptions.setVersionDetector(new n2(i, sentryAndroidOptions));
        }
        if (!sentryAndroidOptions.getVersionDetector().a()) {
            return !z || p6Var == null || sentryAndroidOptions.isForceInit() || p6Var.getInitPriority().ordinal() <= sentryAndroidOptions.getInitPriority().ordinal();
        }
        sentryAndroidOptions.getLogger().h(p5.ERROR, "Not initializing Sentry because mixed SDK versions have been detected.", new Object[0]);
        xe.q(ha0.o("Sentry SDK has detected a mix of versions. This is not supported and likely leads to crashes. Please always use the same version of all SDK modules (dependencies). See ", z2 ? "https://docs.sentry.io/platforms/android/troubleshooting/mixed-versions" : "https://docs.sentry.io/platforms/java/troubleshooting/mixed-versions", " for more details."));
        return false;
    }

    public static void u(f5 f5Var, SentryAndroidOptions sentryAndroidOptions) {
        ArrayList arrayListD = f5Var.d();
        if (arrayListD != null) {
            Iterator it = arrayListD.iterator();
            while (it.hasNext()) {
                c0 c0Var = ((v) it.next()).X;
                if (c0Var != null) {
                    v(c0Var, f5Var, sentryAndroidOptions, "Truncated exception stack frames of event %s");
                }
            }
        }
        ArrayList arrayListE = f5Var.e();
        if (arrayListE != null) {
            Iterator it2 = arrayListE.iterator();
            while (it2.hasNext()) {
                c0 c0Var2 = ((e0) it2.next()).z0;
                if (c0Var2 != null) {
                    v(c0Var2, f5Var, sentryAndroidOptions, "Truncated thread stack frames for event %s");
                }
            }
        }
    }

    public static void v(c0 c0Var, f5 f5Var, p6 p6Var, String str) {
        List list = c0Var.b;
        if (list == null || list.size() <= 500) {
            return;
        }
        ArrayList arrayList = new ArrayList(500);
        arrayList.addAll(list.subList(0, 250));
        arrayList.addAll(list.subList(list.size() - 250, list.size()));
        c0Var.b = arrayList;
        p6Var.getLogger().h(p5.DEBUG, str, f5Var.b);
    }

    public static CopyOnWriteArrayList w(CopyOnWriteArrayList copyOnWriteArrayList) {
        ArrayList arrayList = new ArrayList();
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            if (it.hasNext()) {
                throw dw2.z(it);
            }
        }
        return new CopyOnWriteArrayList(arrayList);
    }
}
