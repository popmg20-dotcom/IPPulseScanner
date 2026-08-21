package io.sentry;

import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import defpackage.n12;
import io.sentry.android.core.SentryAndroidOptions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n2 implements s1, a6, io.sentry.android.replay.util.n, io.sentry.cache.tape.e, io.sentry.featureflags.b {
    public final /* synthetic */ int b;
    public Object f;

    public n2(int i) {
        this.b = i;
        switch (i) {
            case 4:
                Looper mainLooper = Looper.getMainLooper();
                mainLooper.getClass();
                this.f = new Handler(mainLooper);
                break;
            case 6:
                this.f = new io.sentry.util.f(new io.sentry.android.core.cache.a(4));
                break;
            case 7:
                this.f = new io.sentry.util.a();
                break;
            case 8:
                this.f = new io.sentry.transport.p();
                break;
        }
    }

    public static Long m(String str) {
        String strTrim = str.trim();
        try {
            if (strTrim.endsWith("GB")) {
                return Long.valueOf(Long.parseLong(strTrim.substring(0, strTrim.length() - 2)) * 1073741824);
            }
            if (strTrim.endsWith("MB")) {
                return Long.valueOf(Long.parseLong(strTrim.substring(0, strTrim.length() - 2)) * p6.MAX_EVENT_SIZE_BYTES);
            }
            if (strTrim.endsWith("KB")) {
                return Long.valueOf(Long.parseLong(strTrim.substring(0, strTrim.length() - 2)) * 1024);
            }
            if (strTrim.endsWith("B")) {
                return Long.valueOf(Long.parseLong(strTrim.substring(0, strTrim.length() - 1)));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Double n(String str) {
        String strTrim = str.trim();
        try {
            if (strTrim.equals("0")) {
                return Double.valueOf(0.0d);
            }
            if (strTrim.endsWith("ms")) {
                return Double.valueOf(Double.parseDouble(strTrim.substring(0, strTrim.length() - 2)));
            }
            if (strTrim.endsWith("ns")) {
                return Double.valueOf(Double.parseDouble(strTrim.substring(0, strTrim.length() - 2)) / 1000000.0d);
            }
            if (strTrim.endsWith("us")) {
                return Double.valueOf(Double.parseDouble(strTrim.substring(0, strTrim.length() - 2)) / 1000.0d);
            }
            if (strTrim.endsWith("s")) {
                return Double.valueOf(Double.parseDouble(strTrim.substring(0, strTrim.length() - 1)) * 1000.0d);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Override // io.sentry.s1
    public boolean a() {
        if (io.sentry.internal.a.c == null) {
            io.sentry.util.a aVar = io.sentry.internal.a.d;
            aVar.g();
            try {
                if (io.sentry.internal.a.c == null) {
                    io.sentry.internal.a.c = new io.sentry.internal.a();
                }
                aVar.close();
            } catch (Throwable th) {
                try {
                    aVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        io.sentry.internal.a aVar2 = io.sentry.internal.a.c;
        if (!aVar2.a) {
            try {
                io.sentry.util.a aVar3 = aVar2.b;
                aVar3.g();
                try {
                    if (!aVar2.a) {
                        Enumeration<URL> resources = ClassLoader.getSystemClassLoader().getResources("META-INF/MANIFEST.MF");
                        while (resources.hasMoreElements()) {
                            try {
                                Attributes mainAttributes = new Manifest(resources.nextElement().openStream()).getMainAttributes();
                                if (mainAttributes != null) {
                                    String value = mainAttributes.getValue("Sentry-Opentelemetry-SDK-Name");
                                    String value2 = mainAttributes.getValue("Implementation-Version");
                                    String value3 = mainAttributes.getValue("Sentry-SDK-Name");
                                    String value4 = mainAttributes.getValue("Sentry-SDK-Package-Name");
                                    if (value != null && value2 != null) {
                                        String value5 = mainAttributes.getValue("Sentry-Opentelemetry-Version-Name");
                                        if (value5 != null) {
                                            n5.d().b("maven:io.opentelemetry:opentelemetry-sdk", value5);
                                            n5.d().a("OpenTelemetry");
                                        }
                                        String value6 = mainAttributes.getValue("Sentry-Opentelemetry-Javaagent-Version-Name");
                                        if (value6 != null) {
                                            n5.d().b("maven:io.opentelemetry.javaagent:opentelemetry-javaagent", value6);
                                            n5.d().a("OpenTelemetry-Agent");
                                        }
                                        if (value.equals("sentry.java.opentelemetry.agentless")) {
                                            n5.d().a("OpenTelemetry-Agentless");
                                        }
                                        if (value.equals("sentry.java.opentelemetry.agentless-spring")) {
                                            n5.d().a("OpenTelemetry-Agentless-Spring");
                                        }
                                    }
                                    if (value3 != null && value2 != null && value4 != null && value3.startsWith("sentry.java")) {
                                        n5.d().b(value4, value2);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    aVar3.close();
                } finally {
                }
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                aVar2.a = true;
                throw th3;
            }
            aVar2.a = true;
        }
        return n5.d().c(((SentryAndroidOptions) this.f).getFatalLogger());
    }

    @Override // io.sentry.android.replay.util.n
    public int b(int i) {
        return ((Layout) this.f).getLineTop(i);
    }

    @Override // io.sentry.cache.tape.e
    public void c(Object obj, OutputStream outputStream) throws IOException {
        g gVar = (g) obj;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, io.sentry.cache.e.c));
        try {
            ((io.sentry.cache.e) this.f).a.getSerializer().a(gVar, bufferedWriter);
            bufferedWriter.close();
        } catch (Throwable th) {
            try {
                bufferedWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.featureflags.b
    public void clear() {
        io.sentry.util.a aVar = (io.sentry.util.a) this.f;
        aVar.g();
        aVar.close();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public Object m9clone() {
        switch (this.b) {
            case 7:
                return new n2(7);
            default:
                return super.clone();
        }
    }

    @Override // io.sentry.featureflags.b
    public io.sentry.protocol.j d() {
        io.sentry.util.a aVar = (io.sentry.util.a) this.f;
        aVar.g();
        aVar.close();
        return null;
    }

    @Override // io.sentry.android.replay.util.n
    public int e(int i) {
        return ((Layout) this.f).getLineBottom(i);
    }

    @Override // io.sentry.cache.tape.e
    public Object f(byte[] bArr) {
        p6 p6Var = ((io.sentry.cache.e) this.f).a;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), io.sentry.cache.e.c));
            try {
                g gVar = (g) p6Var.getSerializer().b(bufferedReader, g.class);
                bufferedReader.close();
                return gVar;
            } finally {
            }
        } catch (Throwable th) {
            p6Var.getLogger().b(p5.ERROR, th, "Error reading entity from scope cache", new Object[0]);
            return null;
        }
    }

    @Override // io.sentry.android.replay.util.n
    public int g() {
        return ((Layout) this.f).getLineCount();
    }

    @Override // io.sentry.android.replay.util.n
    public float h(int i) {
        Layout layout = (Layout) this.f;
        return (layout.getEllipsizedWidth() <= 0 || layout.getEllipsizedWidth() >= layout.getWidth()) ? layout.getLineRight(i) : layout.getEllipsizedWidth();
    }

    @Override // io.sentry.android.replay.util.n
    public Integer i() {
        int i;
        Layout layout = (Layout) this.f;
        if (layout.getText() instanceof Spanned) {
            CharSequence text = layout.getText();
            text.getClass();
            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) ((Spanned) text).getSpans(0, layout.getText().length(), ForegroundColorSpan.class);
            foregroundColorSpanArr.getClass();
            int i2 = Integer.MIN_VALUE;
            Integer numValueOf = null;
            for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
                CharSequence text2 = layout.getText();
                text2.getClass();
                int spanStart = ((Spanned) text2).getSpanStart(foregroundColorSpan);
                CharSequence text3 = layout.getText();
                text3.getClass();
                int spanEnd = ((Spanned) text3).getSpanEnd(foregroundColorSpan);
                if (spanStart != -1 && spanEnd != -1 && (i = spanEnd - spanStart) > i2) {
                    numValueOf = Integer.valueOf(foregroundColorSpan.getForegroundColor());
                    i2 = i;
                }
            }
            if (numValueOf != null) {
                return Integer.valueOf(numValueOf.intValue() | (-16777216));
            }
        }
        return null;
    }

    @Override // io.sentry.android.replay.util.n
    public float j(int i) {
        Layout layout = (Layout) this.f;
        if (layout.getEllipsizedWidth() <= 0 || layout.getEllipsizedWidth() >= layout.getWidth()) {
            return layout.getLineLeft(i);
        }
        return 0.0f;
    }

    public g k(g gVar, l0 l0Var) {
        gVar.getClass();
        a6 a6Var = (a6) this.f;
        if (a6Var != null) {
            gVar = ((n2) a6Var).k(gVar, l0Var);
        }
        if (gVar == null || !(n12.c(gVar.X, "http") || n12.c(gVar.Z, "http"))) {
            return gVar;
        }
        l0Var.b("sentry:replayNetworkDetails");
        return gVar;
    }

    public io.sentry.protocol.c l() {
        io.sentry.protocol.c cVar = (io.sentry.protocol.c) this.f;
        if (cVar != null) {
            return cVar;
        }
        io.sentry.protocol.c cVar2 = new io.sentry.protocol.c();
        this.f = cVar2;
        return cVar2;
    }

    @Override // io.sentry.featureflags.b
    public io.sentry.featureflags.b clone() {
        return new n2(7);
    }

    public n2(String str) {
        this.b = 9;
        this.f = new File(str);
    }

    public n2(io.sentry.android.replay.b bVar, a6 a6Var) {
        this.b = 2;
        this.f = a6Var;
    }

    public /* synthetic */ n2(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }
}
