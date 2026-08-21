package io.sentry.internal.debugmeta;

import android.content.Context;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.st4;
import defpackage.vp1;
import defpackage.xe;
import defpackage.zo2;
import io.sentry.ILogger;
import io.sentry.clientreport.d;
import io.sentry.clientreport.e;
import io.sentry.clientreport.f;
import io.sentry.d5;
import io.sentry.j2;
import io.sentry.n2;
import io.sentry.n3;
import io.sentry.o;
import io.sentry.o5;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.f0;
import io.sentry.protocol.u;
import io.sentry.protocol.w;
import io.sentry.y4;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c implements a, ILogger, n3, f {
    public final /* synthetic */ int b;
    public Object f;
    public final Object z;

    public c(String str, HashMap map) {
        this.b = 3;
        io.sentry.util.b.r(str, "url is required");
        try {
            this.f = URI.create(str).toURL();
            this.z = map;
        } catch (MalformedURLException e) {
            st4.l("Failed to compose the Sentry's server URL.", e);
            throw null;
        }
    }

    public static o l(o5 o5Var) {
        return o5.Event.equals(o5Var) ? o.Error : o5.Session.equals(o5Var) ? o.Session : o5.Transaction.equals(o5Var) ? o.Transaction : o5.UserFeedback.equals(o5Var) ? o.UserReport : o5.Feedback.equals(o5Var) ? o.Feedback : o5.Profile.equals(o5Var) ? o.Profile : o5.ProfileChunk.equals(o5Var) ? o.ProfileChunkUi : o5.Attachment.equals(o5Var) ? o.Attachment : o5.CheckIn.equals(o5Var) ? o.Monitor : o5.ReplayVideo.equals(o5Var) ? o.Replay : o5.Log.equals(o5Var) ? o.LogItem : o5.Span.equals(o5Var) ? o.Span : o5.TraceMetric.equals(o5Var) ? o.TraceMetric : o.Default;
    }

    @Override // io.sentry.clientreport.f
    public void a(d dVar, o oVar) {
        e(dVar, oVar, 1L);
    }

    @Override // io.sentry.ILogger
    public void b(p5 p5Var, Throwable th, String str, Object... objArr) {
        ILogger iLogger = (ILogger) this.f;
        if (i(p5Var)) {
            iLogger.b(p5Var, th, str, objArr);
        }
    }

    @Override // io.sentry.clientreport.f
    public void c(d dVar, c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            Iterator it = ((Iterable) cVar.z).iterator();
            while (it.hasNext()) {
                g(dVar, (d5) it.next());
            }
        } catch (Throwable th) {
            ((p6) this.z).getLogger().b(p5.ERROR, th, "Unable to record lost envelope.", new Object[0]);
        }
    }

    @Override // io.sentry.ILogger
    public void d(p5 p5Var, String str, Throwable th) {
        ILogger iLogger = (ILogger) this.f;
        if (i(p5Var)) {
            iLogger.d(p5Var, str, th);
        }
    }

    @Override // io.sentry.clientreport.f
    public void e(d dVar, o oVar, long j) {
        try {
            q(dVar.getReason(), oVar.getCategory(), Long.valueOf(j));
            n();
        } catch (Throwable th) {
            ((p6) this.z).getLogger().b(p5.ERROR, th, "Unable to record lost event.", new Object[0]);
        }
    }

    @Override // io.sentry.internal.debugmeta.a
    public List f() {
        int i = this.b;
        Object obj = this.z;
        switch (i) {
            case 0:
                ILogger iLogger = (ILogger) this.f;
                ArrayList arrayList = new ArrayList();
                try {
                    Enumeration<URL> resources = ((ClassLoader) obj).getResources("sentry-debug-meta.properties");
                    while (resources.hasMoreElements()) {
                        URL urlNextElement = resources.nextElement();
                        try {
                            InputStream inputStreamOpenStream = urlNextElement.openStream();
                            try {
                                Properties properties = new Properties();
                                properties.load(inputStreamOpenStream);
                                arrayList.add(properties);
                                iLogger.h(p5.INFO, "Debug Meta Data Properties loaded from %s", urlNextElement);
                                if (inputStreamOpenStream != null) {
                                    inputStreamOpenStream.close();
                                }
                            } catch (Throwable th) {
                                if (inputStreamOpenStream != null) {
                                    try {
                                        inputStreamOpenStream.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                    break;
                                }
                                throw th;
                            }
                        } catch (RuntimeException e) {
                            iLogger.b(p5.ERROR, e, "%s file is malformed.", urlNextElement);
                        }
                    }
                } catch (IOException e2) {
                    iLogger.b(p5.ERROR, e2, "Failed to load %s", "sentry-debug-meta.properties");
                }
                if (!arrayList.isEmpty()) {
                    return arrayList;
                }
                iLogger.h(p5.INFO, "No %s file was found.", "sentry-debug-meta.properties");
                return null;
            default:
                ILogger iLogger2 = (ILogger) this.f;
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(((Context) obj).getAssets().open("sentry-debug-meta.properties"));
                    try {
                        Properties properties2 = new Properties();
                        properties2.load(bufferedInputStream);
                        List listSingletonList = Collections.singletonList(properties2);
                        bufferedInputStream.close();
                        return listSingletonList;
                    } catch (Throwable th3) {
                        try {
                            bufferedInputStream.close();
                            break;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (FileNotFoundException unused) {
                    iLogger2.h(p5.INFO, "%s file was not found.", "sentry-debug-meta.properties");
                    return null;
                } catch (IOException e3) {
                    iLogger2.d(p5.ERROR, "Error getting Proguard UUIDs.", e3);
                    return null;
                } catch (RuntimeException e4) {
                    iLogger2.b(p5.ERROR, e4, "%s file is malformed.", "sentry-debug-meta.properties");
                    return null;
                }
        }
    }

    @Override // io.sentry.clientreport.f
    public void g(d dVar, d5 d5Var) {
        p6 p6Var = (p6) this.z;
        if (d5Var == null) {
            return;
        }
        try {
            o5 o5Var = d5Var.a.X;
            if (o5.ClientReport.equals(o5Var)) {
                try {
                    r(d5Var.f(p6Var.getSerializer()));
                    return;
                } catch (Exception unused) {
                    p6Var.getLogger().h(p5.ERROR, "Unable to restore counts from previous client report.", new Object[0]);
                    return;
                }
            }
            o oVarL = l(o5Var);
            if (oVarL.equals(o.Transaction)) {
                f0 f0VarJ = d5Var.j(p6Var.getSerializer());
                if (f0VarJ != null) {
                    ArrayList arrayList = f0VarJ.J0;
                    q(dVar.getReason(), o.Span.getCategory(), Long.valueOf(((long) arrayList.size()) + 1));
                    arrayList.size();
                    n();
                }
                q(dVar.getReason(), oVarL.getCategory(), 1L);
                n();
                return;
            }
            if (oVarL.equals(o.LogItem)) {
                if (d5Var.h(p6Var.getSerializer()) == null) {
                    p6Var.getLogger().h(p5.ERROR, "Unable to parse lost logs envelope item.", new Object[0]);
                    return;
                }
                q(dVar.getReason(), oVarL.getCategory(), Long.valueOf(r0.b.size()));
                q(dVar.getReason(), o.LogByte.getCategory(), Long.valueOf(d5Var.g().length));
                n();
                return;
            }
            if (!oVarL.equals(o.TraceMetric)) {
                q(dVar.getReason(), oVarL.getCategory(), 1L);
                n();
                return;
            }
            if (d5Var.i(p6Var.getSerializer()) == null) {
                p6Var.getLogger().h(p5.ERROR, "Unable to parse lost metrics envelope item.", new Object[0]);
                return;
            }
            q(dVar.getReason(), oVarL.getCategory(), Long.valueOf(r0.b.size()));
            q(dVar.getReason(), o.TraceMetricByte.getCategory(), Long.valueOf(d5Var.g().length));
            n();
        } catch (Throwable th) {
            p6Var.getLogger().b(p5.ERROR, th, "Unable to record lost envelope item.", new Object[0]);
        }
    }

    @Override // io.sentry.ILogger
    public void h(p5 p5Var, String str, Object... objArr) {
        ILogger iLogger = (ILogger) this.f;
        if (i(p5Var)) {
            iLogger.h(p5Var, str, objArr);
        }
    }

    @Override // io.sentry.ILogger
    public boolean i(p5 p5Var) {
        p6 p6Var = (p6) this.z;
        return p5Var != null && p6Var.isDebug() && p5Var.ordinal() >= p6Var.getDiagnosticLevel().ordinal();
    }

    @Override // io.sentry.clientreport.f
    public c j(c cVar) {
        p6 p6Var = (p6) this.z;
        Date date = new Date();
        n2 n2Var = (n2) this.f;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((Map) ((io.sentry.util.f) n2Var.f).a()).entrySet()) {
            long andSet = ((AtomicLong) entry.getValue()).getAndSet(0L);
            Long lValueOf = Long.valueOf(andSet);
            if (andSet > 0) {
                arrayList.add(new e(((io.sentry.clientreport.c) entry.getKey()).a, ((io.sentry.clientreport.c) entry.getKey()).b, lValueOf));
            }
        }
        io.sentry.clientreport.b bVar = arrayList.isEmpty() ? null : new io.sentry.clientreport.b(date, arrayList);
        if (bVar == null) {
            return cVar;
        }
        try {
            p6Var.getLogger().h(p5.DEBUG, "Attaching client report to envelope.", new Object[0]);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = ((Iterable) cVar.z).iterator();
            while (it.hasNext()) {
                arrayList2.add((d5) it.next());
            }
            arrayList2.add(d5.b(p6Var.getSerializer(), bVar));
            return new c((y4) cVar.f, arrayList2);
        } catch (Throwable th) {
            p6Var.getLogger().b(p5.ERROR, th, "Unable to attach client report to envelope.", new Object[0]);
            return cVar;
        }
    }

    public c k() throws IOException {
        io.sentry.vendor.gson.stream.c cVar = (io.sentry.vendor.gson.stream.c) this.f;
        cVar.I();
        cVar.g();
        int i = cVar.z;
        int[] iArrCopyOf = cVar.f;
        if (i == iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i * 2);
            cVar.f = iArrCopyOf;
        }
        int i2 = cVar.z;
        cVar.z = i2 + 1;
        iArrCopyOf[i2] = 3;
        cVar.b.write(123);
        return this;
    }

    public c m() {
        ((io.sentry.vendor.gson.stream.c) this.f).n(3, 5, '}');
        return this;
    }

    public void n() {
        ((p6) this.z).getOnDiscard();
    }

    public byte[] o() {
        byte[] bArr = (byte[]) this.f;
        if (bArr == null) {
            bArr = (byte[]) ((Callable) this.z).call();
            this.f = bArr;
        }
        return bArr != null ? bArr : new byte[0];
    }

    public c p(String str) {
        io.sentry.vendor.gson.stream.c cVar = (io.sentry.vendor.gson.stream.c) this.f;
        if (str == null) {
            zo2.n("name == null");
            return null;
        }
        if (cVar.Z != null) {
            st4.g();
            return null;
        }
        if (cVar.z != 0) {
            cVar.Z = str;
            return this;
        }
        xe.q("JsonWriter is closed.");
        return null;
    }

    public void q(String str, String str2, Long l) {
        AtomicLong atomicLong = (AtomicLong) ((Map) ((io.sentry.util.f) ((n2) this.f).f).a()).get(new io.sentry.clientreport.c(str, str2));
        if (atomicLong != null) {
            atomicLong.addAndGet(l.longValue());
        }
    }

    public void r(io.sentry.clientreport.b bVar) {
        if (bVar == null) {
            return;
        }
        for (e eVar : bVar.f) {
            q(eVar.b, eVar.f, eVar.z);
        }
    }

    public void s(String str) {
        io.sentry.vendor.gson.stream.c cVar = (io.sentry.vendor.gson.stream.c) this.f;
        if (str == null || str.length() == 0) {
            cVar.A = null;
            cVar.X = ":";
        } else {
            cVar.A = str;
            cVar.X = ": ";
        }
    }

    public c t(double d) throws IOException {
        io.sentry.vendor.gson.stream.c cVar = (io.sentry.vendor.gson.stream.c) this.f;
        cVar.I();
        if (cVar.Y || !(Double.isNaN(d) || Double.isInfinite(d))) {
            cVar.g();
            cVar.b.append((CharSequence) Double.toString(d));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
    }

    public c u(long j) throws IOException {
        io.sentry.vendor.gson.stream.c cVar = (io.sentry.vendor.gson.stream.c) this.f;
        cVar.I();
        cVar.g();
        cVar.b.write(Long.toString(j));
        return this;
    }

    public c v(ILogger iLogger, Object obj) {
        ((j2) this.z).c(this, iLogger, obj);
        return this;
    }

    public c w(Boolean bool) throws IOException {
        io.sentry.vendor.gson.stream.c cVar = (io.sentry.vendor.gson.stream.c) this.f;
        if (bool == null) {
            cVar.x();
            return this;
        }
        cVar.I();
        cVar.g();
        cVar.b.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c x(Number number) throws IOException {
        io.sentry.vendor.gson.stream.c cVar = (io.sentry.vendor.gson.stream.c) this.f;
        if (number == null) {
            cVar.x();
            return this;
        }
        cVar.I();
        String string = number.toString();
        if (!cVar.Y && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            vp1.h(number, "Numeric values must be finite, but was ");
            return null;
        }
        cVar.g();
        cVar.b.append((CharSequence) string);
        return this;
    }

    public c y(String str) {
        io.sentry.vendor.gson.stream.c cVar = (io.sentry.vendor.gson.stream.c) this.f;
        if (str == null) {
            cVar.x();
            return this;
        }
        cVar.I();
        cVar.g();
        cVar.F(str);
        return this;
    }

    public c z(boolean z) throws IOException {
        io.sentry.vendor.gson.stream.c cVar = (io.sentry.vendor.gson.stream.c) this.f;
        cVar.I();
        cVar.g();
        cVar.b.write(z ? "true" : "false");
        return this;
    }

    public c(Writer writer, int i) {
        this.b = 2;
        this.f = new io.sentry.vendor.gson.stream.c(writer);
        this.z = new j2(i);
    }

    public /* synthetic */ c(int i, Object obj, Object obj2) {
        this.b = i;
        this.z = obj;
        this.f = obj2;
    }

    public c(ILogger iLogger) {
        this.b = 0;
        ClassLoader classLoader = c.class.getClassLoader();
        this.f = iLogger;
        this.z = io.sentry.util.b.d(classLoader);
    }

    public c(SurfboardApp surfboardApp, ILogger iLogger) {
        this.b = 7;
        Context applicationContext = surfboardApp.getApplicationContext();
        this.z = applicationContext != null ? applicationContext : surfboardApp;
        this.f = iLogger;
    }

    public c(Method method, Method method2) {
        this.b = 8;
        this.f = method;
        this.z = method2;
    }

    public c(p6 p6Var) {
        this.b = 9;
        this.z = p6Var;
        this.f = new n2(6);
    }

    public c(y4 y4Var, List list) {
        this.b = 5;
        this.f = y4Var;
        io.sentry.util.b.r(list, "SentryEnvelope items are required.");
        this.z = list;
    }

    public c(w wVar, u uVar, d5 d5Var) {
        this.b = 5;
        this.f = new y4(wVar, uVar, null);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(d5Var);
        this.z = arrayList;
    }

    public c(Callable callable) {
        this.b = 6;
        this.z = callable;
    }
}
