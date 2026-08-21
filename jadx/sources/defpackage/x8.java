package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.MainActivity;
import io.netty.handler.codec.http.HttpHeaders;
import io.sentry.ILogger;
import io.sentry.a;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.m0;
import io.sentry.b4;
import io.sentry.b5;
import io.sentry.b7;
import io.sentry.c0;
import io.sentry.clientreport.d;
import io.sentry.clientreport.f;
import io.sentry.d1;
import io.sentry.d5;
import io.sentry.e5;
import io.sentry.f0;
import io.sentry.f5;
import io.sentry.h7;
import io.sentry.hints.b;
import io.sentry.i1;
import io.sentry.internal.debugmeta.c;
import io.sentry.j0;
import io.sentry.j7;
import io.sentry.k3;
import io.sentry.l0;
import io.sentry.l1;
import io.sentry.logger.e;
import io.sentry.n1;
import io.sentry.n5;
import io.sentry.o;
import io.sentry.o5;
import io.sentry.p1;
import io.sentry.p5;
import io.sentry.protocol.k;
import io.sentry.protocol.r;
import io.sentry.protocol.u;
import io.sentry.protocol.w;
import io.sentry.q2;
import io.sentry.r1;
import io.sentry.r5;
import io.sentry.r6;
import io.sentry.s3;
import io.sentry.s5;
import io.sentry.t4;
import io.sentry.transport.g;
import io.sentry.u4;
import io.sentry.util.m;
import io.sentry.v3;
import io.sentry.w5;
import io.sentry.y4;
import io.sentry.z4;
import io.sentry.z6;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class x8 implements i1, sk {
    public Object A;
    public Object X;
    public Object Y;
    public final Object b;
    public boolean f;
    public Object z;

    public x8(SentryAndroidOptions sentryAndroidOptions) {
        this.A = new u4();
        this.b = sentryAndroidOptions;
        this.f = true;
        r1 transportFactory = sentryAndroidOptions.getTransportFactory();
        if (transportFactory instanceof k3) {
            transportFactory = new q2();
            sentryAndroidOptions.setTransportFactory(transportFactory);
        }
        c0 c0VarRetrieveParsedDsn = sentryAndroidOptions.retrieveParsedDsn();
        String sentryClientName = sentryAndroidOptions.getSentryClientName();
        URI uri = c0VarRetrieveParsedDsn.c;
        String string = uri.resolve(uri.getPath() + "/envelope/").toString();
        String str = c0VarRetrieveParsedDsn.b;
        String str2 = c0VarRetrieveParsedDsn.a;
        StringBuilder sb = new StringBuilder("Sentry sentry_version=7,sentry_client=");
        sb.append(sentryClientName);
        sb.append(",sentry_key=");
        sb.append(str);
        sb.append((str2 == null || str2.length() <= 0) ? "" : ",sentry_secret=".concat(str2));
        String string2 = sb.toString();
        HashMap map = new HashMap();
        map.put("User-Agent", sentryClientName);
        map.put("X-Sentry-Auth", string2);
        this.z = transportFactory.f(sentryAndroidOptions, new c(string, map));
        if (sentryAndroidOptions.getLogs().a) {
            this.X = sentryAndroidOptions.getLogs().b.c(sentryAndroidOptions, this);
        } else {
            this.X = e.f;
        }
        if (sentryAndroidOptions.getMetrics().a) {
            this.Y = sentryAndroidOptions.getMetrics().b.mo2c(sentryAndroidOptions, this);
        } else {
            this.Y = io.sentry.metrics.c.b;
        }
    }

    public static w8 F(yg2 yg2Var, nj4 nj4Var, yg2 yg2Var2) {
        nj4Var.getClass();
        Class cls = nj4Var.L0;
        if (nj4Var instanceof ne) {
            return new w8(cls);
        }
        x8 x8Var = new x8(yg2Var, nj4Var, yg2Var2);
        ArrayList arrayList = new ArrayList(8);
        if (!nj4Var.g0(Object.class)) {
            if (cls.isInterface()) {
                p(nj4Var, arrayList, false);
            } else {
                q(nj4Var, arrayList, false);
            }
        }
        return new w8(nj4Var, (Class) x8Var.X, arrayList, null, x8Var.G(arrayList), (qj4) x8Var.A, (cu2) x8Var.b, yg2Var2, yg2Var.f.b, x8Var.f);
    }

    public static w8 H(yg2 yg2Var, Class cls, yg2 yg2Var2) {
        if (cls.isArray()) {
            return new w8(cls);
        }
        x8 x8Var = new x8(yg2Var, cls, yg2Var2);
        List list = Collections.EMPTY_LIST;
        return new w8(null, cls, list, (Class) x8Var.Y, x8Var.G(list), (qj4) x8Var.A, (cu2) x8Var.b, yg2Var2, yg2Var.f.b, x8Var.f);
    }

    public static void p(nj4 nj4Var, ArrayList arrayList, boolean z) {
        int length;
        Class cls = nj4Var.L0;
        if (z) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((nj4) arrayList.get(i)).L0 == cls) {
                    return;
                }
            }
            arrayList.add(nj4Var);
            if (cls == List.class || cls == Map.class) {
                return;
            }
        }
        nj4[] nj4VarArr = nj4Var.R0;
        List listAsList = (nj4VarArr == null || (length = nj4VarArr.length) == 0) ? Collections.EMPTY_LIST : length != 1 ? Arrays.asList(nj4VarArr) : Collections.singletonList(nj4VarArr[0]);
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            p((nj4) it.next(), arrayList, true);
        }
    }

    public static void q(nj4 nj4Var, ArrayList arrayList, boolean z) {
        int length;
        Class cls = nj4Var.L0;
        if (cls == Object.class || cls == Enum.class) {
            return;
        }
        if (z) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((nj4) arrayList.get(i)).L0 == cls) {
                    return;
                }
            }
            arrayList.add(nj4Var);
        }
        nj4[] nj4VarArr = nj4Var.R0;
        List listAsList = (nj4VarArr == null || (length = nj4VarArr.length) == 0) ? Collections.EMPTY_LIST : length != 1 ? Arrays.asList(nj4VarArr) : Collections.singletonList(nj4VarArr[0]);
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            p((nj4) it.next(), arrayList, true);
        }
        nj4 nj4VarD0 = nj4Var.d0();
        if (nj4VarD0 != null) {
            q(nj4VarD0, arrayList, true);
        }
    }

    public static ArrayList x(l0 l0Var) {
        ArrayList arrayList = new ArrayList(l0Var.b);
        a aVar = l0Var.d;
        if (aVar != null) {
            arrayList.add(aVar);
        }
        a aVar2 = l0Var.e;
        if (aVar2 != null) {
            arrayList.add(aVar2);
        }
        a aVar3 = l0Var.f;
        if (aVar3 != null) {
            arrayList.add(aVar3);
        }
        a aVar4 = l0Var.g;
        if (aVar4 != null) {
            arrayList.add(aVar4);
        }
        return arrayList;
    }

    public f5 A(f5 f5Var, l0 l0Var, List list) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            f0 f0Var = (f0) it.next();
            try {
                boolean z = f0Var instanceof m0;
                boolean zIsInstance = b.class.isInstance(l0Var.b("sentry:typeCheckHint"));
                if (zIsInstance && z) {
                    ((m0) f0Var).n(f5Var, l0Var);
                } else if (!zIsInstance && !z) {
                    f5Var = f0Var.n(f5Var, l0Var);
                }
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(p5.ERROR, th, "An exception occurred while processing event by processor: %s", f0Var.getClass().getName());
            }
            if (f5Var == null) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Event was dropped by a processor: %s", f0Var.getClass().getName());
                sentryAndroidOptions.getClientReportRecorder().a(d.EVENT_PROCESSOR, o.Error);
                break;
            }
        }
        return f5Var;
    }

    public f5 B(f5 f5Var, l0 l0Var, List list) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            f0 f0Var = (f0) it.next();
            try {
                f5Var = f0Var.n(f5Var, l0Var);
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(p5.ERROR, th, "An exception occurred while processing feedback event by processor: %s", f0Var.getClass().getName());
            }
            if (f5Var == null) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Feedback event was dropped by a processor: %s", f0Var.getClass().getName());
                sentryAndroidOptions.getClientReportRecorder().a(d.EVENT_PROCESSOR, o.Feedback);
                break;
            }
        }
        return f5Var;
    }

    public r5 C(r5 r5Var, List list) {
        r5 r5VarX;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f0 f0Var = (f0) it.next();
            try {
                r5VarX = f0Var.x(r5Var);
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(p5.ERROR, th, "An exception occurred while processing log event by processor: %s", f0Var.getClass().getName());
                r5VarX = r5Var;
            }
            if (r5VarX == null) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Log event was dropped by a processor: %s", f0Var.getClass().getName());
                f clientReportRecorder = sentryAndroidOptions.getClientReportRecorder();
                d dVar = d.EVENT_PROCESSOR;
                clientReportRecorder.a(dVar, o.LogItem);
                sentryAndroidOptions.getClientReportRecorder().e(dVar, o.LogByte, io.sentry.util.d.a(sentryAndroidOptions.getSerializer(), sentryAndroidOptions.getLogger(), r5Var));
                return r5VarX;
            }
            r5Var = r5VarX;
        }
        return r5Var;
    }

    @Override // defpackage.sk
    public void D(ab0 ab0Var) {
        ((tp1) this.Y).m.post(new tm1(15, this, ab0Var, false));
    }

    public io.sentry.protocol.f0 E(io.sentry.protocol.f0 f0Var, l0 l0Var, List list) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            f0 f0Var2 = (f0) it.next();
            int size = f0Var.J0.size();
            try {
                f0Var = f0Var2.s(f0Var, l0Var);
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(p5.ERROR, th, "An exception occurred while processing transaction by processor: %s", f0Var2.getClass().getName());
            }
            int size2 = f0Var == null ? 0 : f0Var.J0.size();
            if (f0Var == null) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Transaction was dropped by a processor: %s", f0Var2.getClass().getName());
                f clientReportRecorder = sentryAndroidOptions.getClientReportRecorder();
                d dVar = d.EVENT_PROCESSOR;
                clientReportRecorder.a(dVar, o.Transaction);
                sentryAndroidOptions.getClientReportRecorder().e(dVar, o.Span, size + 1);
                break;
            }
            if (size2 < size) {
                int i = size - size2;
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "%d spans were dropped by a processor: %s", Integer.valueOf(i), f0Var2.getClass().getName());
                sentryAndroidOptions.getClientReportRecorder().e(d.EVENT_PROCESSOR, o.Span, i);
            }
        }
        return f0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.o9 G(java.util.List r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.X
            java.lang.Class r0 = (java.lang.Class) r0
            qv r1 = defpackage.ke0.a
            boolean r2 = r7.f
            java.lang.Object r3 = r7.z
            g50 r3 = (defpackage.g50) r3
            java.lang.Object r4 = r7.b
            cu2 r4 = (defpackage.cu2) r4
            if (r4 != 0) goto L13
            goto L24
        L13:
            if (r3 == 0) goto L1f
            boolean r4 = r3 instanceof defpackage.dx3
            if (r4 == 0) goto L1d
            r4 = r3
            dx3 r4 = (defpackage.dx3) r4
            goto L1f
        L1d:
            r4 = 1
            goto L20
        L1f:
            r4 = 0
        L20:
            if (r4 != 0) goto L25
            if (r2 != 0) goto L25
        L24:
            return r1
        L25:
            j9 r1 = defpackage.j9.e
            java.lang.Object r5 = r7.Y
            java.lang.Class r5 = (java.lang.Class) r5
            if (r5 == 0) goto L31
            ke0 r1 = r7.n(r1, r0, r5)
        L31:
            if (r2 == 0) goto L3b
            java.lang.annotation.Annotation[] r0 = defpackage.n50.h(r0)
            ke0 r1 = r7.m(r1, r0)
        L3b:
            java.util.Iterator r8 = r8.iterator()
        L3f:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L65
            java.lang.Object r0 = r8.next()
            nj4 r0 = (defpackage.nj4) r0
            if (r4 == 0) goto L57
            java.lang.Class r5 = r0.L0
            java.lang.Class r6 = r3.a(r5)
            ke0 r1 = r7.n(r1, r5, r6)
        L57:
            if (r2 == 0) goto L3f
            java.lang.Class r0 = r0.L0
            java.lang.annotation.Annotation[] r0 = defpackage.n50.h(r0)
            ke0 r0 = r7.m(r1, r0)
            r1 = r0
            goto L3f
        L65:
            if (r4 == 0) goto L71
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
            java.lang.Class r0 = r3.a(r8)
            ke0 r1 = r7.n(r1, r8, r0)
        L71:
            o9 r7 = r1.d()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x8.G(java.util.List):o9");
    }

    public w I(c cVar, l0 l0Var) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        if (m.a()) {
            return w.f;
        }
        sentryAndroidOptions.getBeforeEnvelopeCallback();
        n5.d().c(sentryAndroidOptions.getLogger());
        g gVar = (g) this.z;
        if (l0Var == null) {
            gVar.o(cVar);
        } else {
            gVar.k0(cVar, l0Var);
        }
        w wVar = ((y4) cVar.f).b;
        return wVar != null ? wVar : w.f;
    }

    public void J(of2 of2Var) {
        float dimension;
        this.Y = of2Var;
        MainActivity mainActivity = (MainActivity) this.b;
        wn1 wn1Var = new wn1(mainActivity);
        Integer num = (Integer) this.z;
        Integer num2 = (Integer) this.A;
        ViewGroup viewGroupC = ((v62) wn1Var.f).C();
        if (num != null && num.intValue() != 0) {
            viewGroupC.setBackgroundResource(num.intValue());
        } else if (num2 != null) {
            viewGroupC.setBackgroundColor(num2.intValue());
        } else {
            viewGroupC.setBackground(mainActivity.getWindow().getDecorView().getBackground());
        }
        Drawable drawable = (Drawable) this.X;
        if (drawable != null) {
            ImageView imageView = (ImageView) viewGroupC.findViewById(R.id.splashscreen_icon_view);
            if (this.f) {
                Drawable drawable2 = imageView.getContext().getDrawable(R.drawable.icon_background);
                dimension = imageView.getResources().getDimension(R.dimen.splashscreen_icon_size_with_background) * 0.6666667f;
                if (drawable2 != null) {
                    imageView.setBackground(new jh2(drawable2, dimension));
                }
            } else {
                dimension = imageView.getResources().getDimension(R.dimen.splashscreen_icon_size_no_background) * 0.6666667f;
            }
            imageView.setImageDrawable(new jh2(drawable, dimension));
        }
        viewGroupC.addOnLayoutChangeListener(new wh0(2, this, wn1Var));
    }

    public boolean K(t4 t4Var, l0 l0Var) {
        if (io.sentry.util.b.s(l0Var)) {
            return true;
        }
        ((SentryAndroidOptions) this.b).getLogger().h(p5.DEBUG, "Event was cached so not applying scope: %s", t4Var.b);
        return false;
    }

    public void L(ab0 ab0Var) {
        sz4 sz4Var = (sz4) ((tp1) this.Y).j.get((x9) this.z);
        if (sz4Var != null) {
            sz4Var.p(ab0Var);
        }
    }

    @Override // io.sentry.i1
    public void a(boolean z) {
        long shutdownTimeoutMillis;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        sentryAndroidOptions.getLogger().h(p5.INFO, "Closing SentryClient.", new Object[0]);
        if (z) {
            shutdownTimeoutMillis = 0;
        } else {
            try {
                shutdownTimeoutMillis = sentryAndroidOptions.getShutdownTimeoutMillis();
            } catch (IOException e) {
                sentryAndroidOptions.getLogger().d(p5.WARNING, "Failed to close the connection to the Sentry Server.", e);
            }
        }
        b(shutdownTimeoutMillis);
        ((io.sentry.logger.b) this.X).a(z);
        ((io.sentry.metrics.a) this.Y).a(z);
        ((g) this.z).a(z);
        for (f0 f0Var : sentryAndroidOptions.getEventProcessors()) {
            if (f0Var instanceof Closeable) {
                try {
                    ((Closeable) f0Var).close();
                } catch (IOException e2) {
                    sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to close the event processor {}.", f0Var, e2);
                }
            }
        }
        this.f = false;
    }

    @Override // io.sentry.i1
    public void b(long j) {
        ((io.sentry.logger.b) this.X).b(j);
        ((io.sentry.metrics.a) this.Y).b(j);
        ((g) this.z).b(j);
    }

    @Override // io.sentry.i1
    public void c(z6 z6Var, l0 l0Var) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        io.sentry.util.b.r(z6Var, "Session is required.");
        String str = z6Var.D0;
        if (str == null || str.isEmpty()) {
            sentryAndroidOptions.getLogger().h(p5.WARNING, "Sessions can't be captured without setting a release.", new Object[0]);
            return;
        }
        try {
            l1 serializer = sentryAndroidOptions.getSerializer();
            u sdkVersion = sentryAndroidOptions.getSdkVersion();
            io.sentry.util.b.r(serializer, "Serializer is required.");
            f(new c((w) null, sdkVersion, d5.e(serializer, z6Var)), l0Var);
        } catch (IOException e) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to capture session.", e);
        }
    }

    @Override // io.sentry.i1
    public io.sentry.android.core.internal.tombstone.c d() {
        return ((g) this.z).d();
    }

    @Override // io.sentry.i1
    public boolean e() {
        return ((g) this.z).e();
    }

    @Override // io.sentry.i1
    public w f(c cVar, l0 l0Var) {
        try {
            l0Var.a();
            return I(cVar, l0Var);
        } catch (IOException e) {
            ((SentryAndroidOptions) this.b).getLogger().d(p5.ERROR, "Failed to capture envelope.", e);
            return w.f;
        }
    }

    @Override // io.sentry.i1
    public w g(r6 r6Var, d1 d1Var, l0 l0Var) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        if (m.a()) {
            return w.f;
        }
        if (K(r6Var, l0Var)) {
            r rVar = r6Var.A;
            io.sentry.protocol.e eVar = r6Var.f;
            if (rVar == null) {
                r6Var.A = d1Var.I();
            }
            if (r6Var.z0 == null) {
                r6Var.z0 = d1Var.H();
            }
            if (r6Var.X == null) {
                r6Var.c(d1Var.w());
            } else {
                for (Map.Entry entry : d1Var.w().entrySet()) {
                    if (!r6Var.X.containsKey(entry.getKey())) {
                        r6Var.X.put((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
            for (Map.Entry entry2 : new io.sentry.protocol.e(d1Var.A()).b.entrySet()) {
                if (!eVar.a(entry2.getKey())) {
                    eVar.k(entry2.getValue(), (String) entry2.getKey());
                }
            }
            n1 n1VarO = d1Var.o();
            if (eVar.i() == null) {
                if (n1VarO == null) {
                    eVar.v(j7.b(d1Var.s()));
                } else {
                    eVar.v(n1VarO.r());
                }
            }
        }
        sentryAndroidOptions.getLogger().h(p5.DEBUG, "Capturing session replay: %s", r6Var.b);
        w wVar = w.f;
        w wVar2 = r6Var.b;
        if (wVar2 != null) {
            wVar = wVar2;
        }
        Iterator<f0> it = sentryAndroidOptions.getEventProcessors().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            f0 next = it.next();
            try {
                r6Var = next.g(r6Var, l0Var);
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(p5.ERROR, th, "An exception occurred while processing replay event by processor: %s", next.getClass().getName());
            }
            if (r6Var == null) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Replay event was dropped by a processor: %s", next.getClass().getName());
                sentryAndroidOptions.getClientReportRecorder().a(d.EVENT_PROCESSOR, o.Replay);
                break;
            }
        }
        if (r6Var != null) {
            sentryAndroidOptions.getBeforeSendReplay();
        }
        if (r6Var == null) {
            return w.f;
        }
        try {
            c cVarV = v(r6Var, l0Var.h, y(d1Var, l0Var, r6Var, null), b.class.isInstance(l0Var.b("sentry:typeCheckHint")));
            l0Var.a();
            ((g) this.z).k0(cVarV, l0Var);
            return wVar;
        } catch (IOException e) {
            sentryAndroidOptions.getLogger().b(p5.WARNING, e, "Capturing event %s failed.", wVar);
            return w.f;
        }
    }

    @Override // io.sentry.i1
    public w h(s3 s3Var) {
        io.sentry.util.b.r(s3Var, "profileChunk is required.");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        sentryAndroidOptions.getLogger().h(p5.DEBUG, "Capturing profile chunk: %s", s3Var.z);
        w wVar = s3Var.z;
        io.sentry.protocol.f fVarA = io.sentry.protocol.f.a(s3Var.b, sentryAndroidOptions);
        if (fVarA != null) {
            s3Var.b = fVarA;
        }
        try {
            return I(new c(new y4(wVar, sentryAndroidOptions.getSdkVersion(), null), Collections.singletonList("application/x-perfetto-trace".equals(s3Var.B0) ? d5.c(s3Var, sentryAndroidOptions.getSerializer()) : d5.d(s3Var, sentryAndroidOptions.getSerializer(), sentryAndroidOptions.getProfilerConverter()))), null);
        } catch (io.sentry.exception.c e) {
            e = e;
            sentryAndroidOptions.getLogger().b(p5.WARNING, e, "Capturing profile chunk %s failed.", wVar);
            return w.f;
        } catch (IOException e2) {
            e = e2;
            sentryAndroidOptions.getLogger().b(p5.WARNING, e, "Capturing profile chunk %s failed.", wVar);
            return w.f;
        }
    }

    @Override // io.sentry.i1
    public void i(r5 r5Var, d1 d1Var) {
        r5 r5VarC;
        r5 r5VarC2;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        if (m.a() || (r5VarC = C(r5Var, d1Var.J())) == null || (r5VarC2 = C(r5VarC, sentryAndroidOptions.getEventProcessors())) == null) {
            return;
        }
        sentryAndroidOptions.getLogs().getClass();
        ((io.sentry.logger.b) this.X).d(r5VarC2);
    }

    @Override // io.sentry.i1
    public boolean isEnabled() {
        return this.f;
    }

    @Override // io.sentry.i1
    public w j(io.sentry.protocol.f0 f0Var, h7 h7Var, d1 d1Var, l0 l0Var, v3 v3Var) {
        Pattern pattern;
        List listY;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        if (m.a()) {
            return w.f;
        }
        l0 l0Var2 = l0Var == null ? new l0() : l0Var;
        if (K(f0Var, l0Var2) && (listY = d1Var.y()) != null) {
            l0Var2.b.addAll(listY);
        }
        sentryAndroidOptions.getLogger().h(p5.DEBUG, "Capturing transaction: %s", f0Var.b);
        List<j0> ignoredTransactions = sentryAndroidOptions.getIgnoredTransactions();
        String str = f0Var.G0;
        if (str != null && ignoredTransactions != null && !ignoredTransactions.isEmpty()) {
            Iterator<j0> it = ignoredTransactions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    Iterator<j0> it2 = ignoredTransactions.iterator();
                    while (it2.hasNext()) {
                        try {
                            pattern = it2.next().b;
                        } catch (Throwable unused) {
                        }
                        if (pattern == null ? false : pattern.matcher(str).matches()) {
                        }
                    }
                } else if (it.next().a.equalsIgnoreCase(str)) {
                    break;
                }
            }
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Transaction was dropped as transaction name %s is ignored", f0Var.G0);
            f clientReportRecorder = sentryAndroidOptions.getClientReportRecorder();
            d dVar = d.EVENT_PROCESSOR;
            clientReportRecorder.a(dVar, o.Transaction);
            sentryAndroidOptions.getClientReportRecorder().e(dVar, o.Span, f0Var.J0.size() + 1);
            return w.f;
        }
        w wVar = w.f;
        w wVarI = f0Var.b;
        if (wVarI == null) {
            wVarI = wVar;
        }
        if (K(f0Var, l0Var2)) {
            r(f0Var, d1Var, io.sentry.hints.d.class.isInstance(l0Var2.b("sentry:typeCheckHint")));
            f0Var = E(f0Var, l0Var2, d1Var.J());
            if (f0Var == null) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Transaction was dropped by applyScope", new Object[0]);
            }
        }
        if (f0Var != null) {
            f0Var = E(f0Var, l0Var2, sentryAndroidOptions.getEventProcessors());
        }
        io.sentry.protocol.f0 f0Var2 = f0Var;
        if (f0Var2 == null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Transaction was dropped by Event processors.", new Object[0]);
            return wVar;
        }
        ArrayList arrayList = f0Var2.J0;
        int size = arrayList.size();
        sentryAndroidOptions.getBeforeSendTransaction();
        int size2 = arrayList.size();
        if (size2 < size) {
            int i = size - size2;
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "%d spans were dropped by beforeSendTransaction.", Integer.valueOf(i));
            sentryAndroidOptions.getClientReportRecorder().e(d.BEFORE_SEND, o.Span, i);
        }
        try {
            ArrayList arrayListX = x(l0Var2);
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = arrayListX.iterator();
            while (it3.hasNext()) {
                ((a) it3.next()).getClass();
            }
            c cVarS = s(f0Var2, arrayList2, null, h7Var, v3Var);
            l0Var2.a();
            if (cVarS != null) {
                wVarI = I(cVarS, l0Var2);
            }
        } catch (io.sentry.exception.c | IOException e) {
            sentryAndroidOptions.getLogger().b(p5.WARNING, e, "Capturing transaction %s failed.", wVarI);
            wVar = w.f;
            wVarI = wVar;
        }
        if (!wVarI.equals(wVar)) {
            b7 b7VarI = f0Var2.f.i();
            if (b7VarI != null) {
                sentryAndroidOptions.getReplayController().C(b7VarI.b);
            }
            String str2 = f0Var2.G0;
            if (str2 != null && !str2.isEmpty()) {
                sentryAndroidOptions.getReplayController().U(str2);
            }
        }
        return wVarI;
    }

    @Override // io.sentry.i1
    public w k(k kVar, d1 d1Var) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        if (m.a()) {
            return w.f;
        }
        f5 f5Var = new f5();
        io.sentry.protocol.e eVar = f5Var.f;
        eVar.k(kVar, "feedback");
        l0 l0Var = new l0();
        if (kVar.Y == null) {
            kVar.Y = d1Var.C();
        }
        sentryAndroidOptions.getLogger().h(p5.DEBUG, "Capturing feedback: %s", f5Var.b);
        if (K(f5Var, l0Var)) {
            if (f5Var.z0 == null) {
                f5Var.z0 = d1Var.H();
            }
            if (f5Var.X == null) {
                f5Var.c(d1Var.w());
            } else {
                for (Map.Entry entry : d1Var.w().entrySet()) {
                    if (!f5Var.X.containsKey(entry.getKey())) {
                        f5Var.X.put((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
            for (Map.Entry entry2 : new io.sentry.protocol.e(d1Var.A()).b.entrySet()) {
                if (!eVar.a(entry2.getKey())) {
                    eVar.k(entry2.getValue(), (String) entry2.getKey());
                }
            }
            n1 n1VarO = d1Var.o();
            if (eVar.i() == null) {
                if (n1VarO == null) {
                    eVar.v(j7.b(d1Var.s()));
                } else {
                    eVar.v(n1VarO.r());
                }
            }
            f5Var = B(f5Var, l0Var, d1Var.J());
            if (f5Var == null) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Feedback was dropped by applyScope", new Object[0]);
                return w.f;
            }
        }
        f5 f5VarB = B(f5Var, l0Var, sentryAndroidOptions.getEventProcessors());
        if (f5VarB != null) {
            sentryAndroidOptions.getBeforeSendFeedback();
        }
        if (f5VarB == null) {
            return w.f;
        }
        w wVar = w.f;
        w wVar2 = f5VarB.b;
        w wVar3 = wVar2 != null ? wVar2 : wVar;
        if (kVar.X == null) {
            sentryAndroidOptions.getReplayController().n(Boolean.FALSE);
            w wVarG = d1Var.g();
            if (!wVarG.equals(wVar)) {
                kVar.X = wVarG;
            }
        }
        try {
            c cVarS = s(f5VarB, x(l0Var), null, y(d1Var, l0Var, f5VarB, f5VarB.M0), null);
            l0Var.a();
            return cVarS != null ? I(cVarS, l0Var) : wVar3;
        } catch (io.sentry.exception.c | IOException e) {
            sentryAndroidOptions.getLogger().b(p5.WARNING, e, "Capturing feedback %s failed.", wVar3);
            return w.f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02a8  */
    /* JADX WARN: Type inference failed for: r0v18, types: [io.sentry.protocol.w, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [io.sentry.protocol.w] */
    /* JADX WARN: Type inference failed for: r1v7, types: [io.sentry.ILogger] */
    /* JADX WARN: Type inference failed for: r3v11, types: [io.sentry.protocol.w, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.sentry.i1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.sentry.protocol.w l(io.sentry.f5 r17, io.sentry.d1 r18, io.sentry.l0 r19) {
        /*
            Method dump skipped, instruction units count: 974
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x8.l(io.sentry.f5, io.sentry.d1, io.sentry.l0):io.sentry.protocol.w");
    }

    public ke0 m(ke0 ke0Var, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!ke0Var.k(annotation)) {
                    ke0Var = ke0Var.a(annotation);
                    if (((cu2) this.b).W(annotation)) {
                        ke0Var = o(ke0Var, annotation);
                    }
                }
            }
        }
        return ke0Var;
    }

    public ke0 n(ke0 ke0Var, Class cls, Class cls2) {
        if (cls2 != null) {
            ke0Var = m(ke0Var, n50.h(cls2));
            Iterator it = n50.i(cls2, cls, false).iterator();
            while (it.hasNext()) {
                ke0Var = m(ke0Var, n50.h((Class) it.next()));
            }
        }
        return ke0Var;
    }

    public ke0 o(ke0 ke0Var, Annotation annotation) {
        for (Annotation annotation2 : n50.h(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !ke0Var.k(annotation2)) {
                ke0Var = ke0Var.a(annotation2);
                if (((cu2) this.b).W(annotation2)) {
                    ke0Var = o(ke0Var, annotation2);
                }
            }
        }
        return ke0Var;
    }

    public void r(t4 t4Var, d1 d1Var, boolean z) {
        if (d1Var != null) {
            if (t4Var.A == null) {
                t4Var.A = d1Var.I();
            }
            if (t4Var.z0 == null) {
                t4Var.z0 = d1Var.H();
            }
            if (t4Var.X == null) {
                t4Var.c(d1Var.w());
            } else {
                for (Map.Entry entry : d1Var.w().entrySet()) {
                    if (!t4Var.X.containsKey(entry.getKey())) {
                        t4Var.X.put((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
            if (t4Var.D0 == null) {
                t4Var.D0 = new ArrayList(new ArrayList(d1Var.q()));
            } else if (!z) {
                Queue queueQ = d1Var.q();
                List list = t4Var.D0;
                if (list != null && !queueQ.isEmpty()) {
                    list.addAll(queueQ);
                    Collections.sort(list, (u4) this.A);
                }
            }
            if (t4Var.F0 == null) {
                Map extras = d1Var.getExtras();
                t4Var.F0 = extras != null ? new HashMap(extras) : null;
            } else {
                for (Map.Entry entry2 : d1Var.getExtras().entrySet()) {
                    if (!t4Var.F0.containsKey(entry2.getKey())) {
                        t4Var.F0.put((String) entry2.getKey(), entry2.getValue());
                    }
                }
            }
            io.sentry.protocol.e eVar = t4Var.f;
            for (Map.Entry entry3 : new io.sentry.protocol.e(d1Var.A()).b.entrySet()) {
                if (!eVar.a(entry3.getKey())) {
                    eVar.k(entry3.getValue(), (String) entry3.getKey());
                }
            }
        }
    }

    public c s(t4 t4Var, ArrayList arrayList, z6 z6Var, h7 h7Var, v3 v3Var) {
        w wVar;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        ArrayList arrayList2 = new ArrayList();
        if (t4Var != null) {
            l1 serializer = sentryAndroidOptions.getSerializer();
            Charset charset = d5.d;
            io.sentry.util.b.r(serializer, "ISerializer is required.");
            c cVar = new c(new ft4(4, serializer, t4Var));
            arrayList2.add(new d5(new e5(o5.resolve(t4Var), new z4(cVar, 9), HttpHeaders.Values.APPLICATION_JSON, null, null), new z4(cVar, 10)));
            wVar = t4Var.b;
        } else {
            wVar = null;
        }
        if (z6Var != null) {
            arrayList2.add(d5.e(sentryAndroidOptions.getSerializer(), z6Var));
        }
        if (v3Var != null) {
            long maxTraceFileSize = sentryAndroidOptions.getMaxTraceFileSize();
            l1 serializer2 = sentryAndroidOptions.getSerializer();
            Charset charset2 = d5.d;
            File file = v3Var.b;
            c cVar2 = new c(new b5(file, maxTraceFileSize, v3Var, serializer2));
            arrayList2.add(new d5(new e5(o5.Profile, new z4(cVar2, 7), "application-json", file.getName(), null), new z4(cVar2, 8)));
            if (wVar == null) {
                wVar = new w(v3Var.N0);
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                l1 serializer3 = sentryAndroidOptions.getSerializer();
                ILogger logger = sentryAndroidOptions.getLogger();
                long maxAttachmentSize = sentryAndroidOptions.getMaxAttachmentSize();
                Charset charset3 = d5.d;
                c cVar3 = new c(new b5(aVar, maxAttachmentSize, serializer3, logger));
                arrayList2.add(new d5(new e5(o5.Attachment, new z4(cVar3, 0), aVar.f, aVar.e, aVar.g), new z4(cVar3, 1)));
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return new c(new y4(wVar, sentryAndroidOptions.getSdkVersion(), h7Var), arrayList2);
    }

    public c t(s5 s5Var) {
        ArrayList arrayList = new ArrayList();
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        l1 serializer = sentryAndroidOptions.getSerializer();
        Charset charset = d5.d;
        io.sentry.util.b.r(serializer, "ISerializer is required.");
        c cVar = new c(new ft4(7, serializer, s5Var));
        arrayList.add(new d5(new e5(o5.Log, new z4(cVar, 18), "application/vnd.sentry.items.log+json", null, null, null, Integer.valueOf(s5Var.b.size())), new z4(cVar, 19)));
        return new c(new y4(null, sentryAndroidOptions.getSdkVersion(), null), arrayList);
    }

    public c u(w5 w5Var) {
        ArrayList arrayList = new ArrayList();
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        l1 serializer = sentryAndroidOptions.getSerializer();
        Charset charset = d5.d;
        io.sentry.util.b.r(serializer, "ISerializer is required.");
        c cVar = new c(new ft4(3, serializer, w5Var));
        arrayList.add(new d5(new e5(o5.TraceMetric, new z4(cVar, 6), "application/vnd.sentry.items.trace-metric+json", null, null, null, Integer.valueOf(w5Var.b.size())), new z4(cVar, 14)));
        return new c(new y4(null, sentryAndroidOptions.getSdkVersion(), null), arrayList);
    }

    public c v(final r6 r6Var, final b4 b4Var, h7 h7Var, final boolean z) {
        ArrayList arrayList = new ArrayList();
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        final l1 serializer = sentryAndroidOptions.getSerializer();
        final ILogger logger = sentryAndroidOptions.getLogger();
        Charset charset = d5.d;
        final File file = r6Var.G0;
        c cVar = new c(new Callable() { // from class: io.sentry.c5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                l1 l1Var = serializer;
                r6 r6Var2 = r6Var;
                File file2 = file;
                ILogger iLogger = logger;
                boolean z2 = z;
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, d5.d), 512);
                        try {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            l1Var.a(r6Var2, bufferedWriter);
                            linkedHashMap.put(o5.ReplayEvent.getItemType(), byteArrayOutputStream.toByteArray());
                            byteArrayOutputStream.reset();
                            b4 b4Var2 = b4Var;
                            if (b4Var2 != null) {
                                l1Var.a(b4Var2, bufferedWriter);
                                linkedHashMap.put(o5.ReplayRecording.getItemType(), byteArrayOutputStream.toByteArray());
                                byteArrayOutputStream.reset();
                            }
                            if (file2 != null && file2.exists()) {
                                byte[] bArrP = io.sentry.util.b.p(10485760L, file2.getPath());
                                if (bArrP.length > 0) {
                                    linkedHashMap.put(o5.ReplayVideo.getItemType(), bArrP);
                                }
                            }
                            byte[] bArrK = d5.k(linkedHashMap);
                            bufferedWriter.close();
                            byteArrayOutputStream.close();
                            if (file2 != null) {
                                if (z2) {
                                    return bArrK;
                                }
                            }
                            return bArrK;
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        iLogger.d(p5.ERROR, "Could not serialize replay recording", th);
                        if (file2 == null) {
                            return null;
                        }
                        if (z2) {
                            io.sentry.util.b.g(file2.getParentFile());
                            return null;
                        }
                        file2.delete();
                        return null;
                    } finally {
                        if (file2 != null) {
                            if (z2) {
                                io.sentry.util.b.g(file2.getParentFile());
                            } else {
                                file2.delete();
                            }
                        }
                    }
                }
            }
        });
        arrayList.add(new d5(new e5(o5.ReplayVideo, new z4(cVar, 13), null, null, null), new z4(cVar, 15)));
        return new c(new y4(r6Var.b, sentryAndroidOptions.getSessionReplay().l, h7Var), arrayList);
    }

    public nj4 w(c9 c9Var, boolean z, nj4 nj4Var) {
        cu2 cu2Var = (cu2) this.b;
        nj4 nj4VarA0 = cu2Var.a0((bt3) this.z, c9Var, nj4Var);
        if (nj4VarA0 != nj4Var) {
            Class<?> cls = nj4VarA0.L0;
            Class<?> cls2 = nj4Var.L0;
            if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                a71.i("Illegal concrete-type annotation for method '", c9Var.q(), "': class ", cls.getName(), " not a super-type of (declared) class ", cls2.getName());
                return null;
            }
            nj4Var = nj4VarA0;
            z = true;
        }
        y62 y62VarH = cu2Var.H(c9Var);
        if (y62VarH != null && y62VarH != y62.z) {
            z = y62VarH == y62.f;
        }
        if (z) {
            return nj4Var.q0();
        }
        return null;
    }

    public h7 y(d1 d1Var, l0 l0Var, t4 t4Var, String str) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        if (b.class.isInstance(l0Var.b("sentry:typeCheckHint"))) {
            if (t4Var != null) {
                io.sentry.c cVar = new io.sentry.c(sentryAndroidOptions.getLogger());
                io.sentry.protocol.e eVar = t4Var.f;
                b7 b7VarI = eVar.i();
                cVar.d("sentry-trace_id", b7VarI != null ? b7VarI.b.a() : null);
                cVar.d("sentry-public_key", sentryAndroidOptions.retrieveParsedDsn().b);
                cVar.d("sentry-release", t4Var.Y);
                cVar.d("sentry-environment", t4Var.Z);
                cVar.d("sentry-org_id", sentryAndroidOptions.getEffectiveOrgId());
                cVar.d("sentry-transaction", str);
                if (cVar.f) {
                    cVar.c = null;
                }
                cVar.d("sentry-sampled", null);
                if (cVar.f) {
                    cVar.d = null;
                }
                Object objC = eVar.c("replay_id");
                if (objC != null && !objC.toString().equals(w.f.a())) {
                    cVar.d("sentry-replay_id", objC.toString());
                    eVar.b.remove("replay_id");
                }
                cVar.f = false;
                return cVar.f();
            }
        } else if (d1Var != null) {
            p1 p1VarI = d1Var.i();
            return p1VarI != null ? p1VarI.a() : ((io.sentry.c) d1Var.B(new ed(29, d1Var, sentryAndroidOptions)).e).f();
        }
        return null;
    }

    public void z() {
        int i;
        TypedValue typedValue = new TypedValue();
        MainActivity mainActivity = (MainActivity) this.b;
        Resources.Theme theme = mainActivity.getTheme();
        if (theme.resolveAttribute(R.attr.windowSplashScreenBackground, typedValue, true)) {
            this.z = Integer.valueOf(typedValue.resourceId);
            this.A = Integer.valueOf(typedValue.data);
        }
        if (theme.resolveAttribute(R.attr.windowSplashScreenAnimatedIcon, typedValue, true)) {
            this.X = theme.getDrawable(typedValue.resourceId);
        }
        if (theme.resolveAttribute(R.attr.splashScreenIconSize, typedValue, true)) {
            this.f = typedValue.resourceId == R.dimen.splashscreen_icon_size_with_background;
        }
        if (!theme.resolveAttribute(R.attr.postSplashScreenTheme, typedValue, true) || (i = typedValue.resourceId) == 0) {
            return;
        }
        mainActivity.setTheme(i);
    }

    public x8(yg2 yg2Var, nj4 nj4Var, yg2 yg2Var2) {
        Class cls = nj4Var.L0;
        this.X = cls;
        this.z = yg2Var2;
        this.A = nj4Var.X();
        cu2 cu2VarD = yg2Var.f(ah2.USE_ANNOTATIONS) ? yg2Var.d() : null;
        this.b = cu2VarD;
        this.Y = null;
        this.f = (cu2VarD == null || n50.p(cls)) ? false : true;
    }

    public x8(tp1 tp1Var, t9 t9Var, x9 x9Var) {
        this.Y = tp1Var;
        this.A = null;
        this.X = null;
        this.f = false;
        this.b = t9Var;
        this.z = x9Var;
    }

    public x8(bt3 bt3Var, ul ulVar) {
        this.z = bt3Var;
        this.A = ulVar;
        t52 t52Var = t52.X;
        cu2 cu2Var = (cu2) ulVar.e;
        t52 t52VarA = cu2Var != null ? t52Var.a(cu2Var.x((w8) ulVar.f)) : t52Var;
        Class cls = ((nj4) ulVar.b).L0;
        bt3Var.getClass();
        t52 t52VarA2 = t52VarA.a(t52Var);
        this.Y = ((t52) bt3Var.Z.f).a(t52VarA2);
        this.f = t52VarA2.b == s52.A;
        this.b = bt3Var.d();
    }

    public x8(yg2 yg2Var, Class cls, g50 g50Var) {
        this.X = cls;
        this.z = g50Var;
        this.A = qj4.Z;
        if (yg2Var == null) {
            this.b = null;
            this.Y = null;
        } else {
            cu2 cu2VarD = yg2Var.f(ah2.USE_ANNOTATIONS) ? yg2Var.d() : null;
            this.b = cu2VarD;
            this.Y = g50Var != null ? g50Var.a(cls) : null;
            obj = cu2VarD;
        }
        this.f = (obj == null || n50.p(cls)) ? false : true;
    }

    public x8(MainActivity mainActivity) {
        this.b = mainActivity;
    }
}
