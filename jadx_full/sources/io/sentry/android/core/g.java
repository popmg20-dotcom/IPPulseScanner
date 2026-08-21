package io.sentry.android.core;

import android.os.SystemClock;
import android.util.Log;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.tencent.mars.xlog.Xlog;
import defpackage.cm2;
import defpackage.d70;
import defpackage.ez4;
import defpackage.g41;
import defpackage.h70;
import defpackage.j70;
import defpackage.kb0;
import defpackage.kw2;
import defpackage.n12;
import defpackage.p44;
import defpackage.vf2;
import defpackage.w44;
import defpackage.y30;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.ILogger;
import io.sentry.android.core.anr.AnrProfilingIntegration;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.b4;
import io.sentry.b7;
import io.sentry.j5;
import io.sentry.ndk.NativeScope;
import io.sentry.p4;
import io.sentry.p5;
import io.sentry.q6;
import io.sentry.r6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ g(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x033f  */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v2, types: [java.util.Date] */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r29v0, types: [io.sentry.q6] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v38, types: [io.sentry.android.replay.d] */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r32v6, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v42 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        File file;
        Throwable th;
        Object objH;
        Object objValueOf;
        String str;
        int i;
        ?? linkedList;
        Field field;
        Throwable th2 = null;
        ?? dVar = 0;
        int i2 = 0;
        switch (this.b) {
            case 0:
                ((i) this.f).h(true);
                return;
            case 1:
                ((v) this.f).a(null, true);
                return;
            case 2:
                i0 i0Var = (i0) this.f;
                if (i0Var != null) {
                    ProcessLifecycleOwner.z0.Y.c(i0Var);
                    return;
                }
                return;
            case 3:
                if (((z0) this.f).X) {
                    p4.c().k();
                }
                p4.c().getOptions().getReplayController().stop();
                p4.c().getOptions().getContinuousProfiler().a(false);
                return;
            case 4:
                k1 k1Var = (k1) this.f;
                io.sentry.util.a aVar = k1Var.I0;
                aVar.g();
                try {
                    k1Var.i(true);
                    aVar.close();
                    return;
                } finally {
                }
            case 5:
                m1 m1Var = (m1) this.f;
                synchronized (m1Var.e) {
                    try {
                        if (m1Var.g != null) {
                            m1Var.a.h(p5.WARNING, "Timed out waiting for Perfetto profiling result.", new Object[0]);
                            m1Var.g.n(null);
                            m1Var.g = new l1(m1Var, 1);
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                    break;
                }
                return;
            case 6:
                kw2 kw2Var = ((w1) this.f).h;
                while (true) {
                    v1 v1Var = (v1) kw2Var.d;
                    if (v1Var == null) {
                        kw2Var.e = null;
                        kw2Var.a = 0;
                        kw2Var.b = 0;
                        return;
                    } else {
                        kw2Var.d = v1Var.c;
                        q0 q0Var = (q0) kw2Var.c;
                        v1Var.c = (v1) q0Var.b;
                        q0Var.b = v1Var;
                    }
                }
                break;
            case 7:
                SystemEventsBreadcrumbsIntegration systemEventsBreadcrumbsIntegration = (SystemEventsBreadcrumbsIntegration) this.f;
                systemEventsBreadcrumbsIntegration.x(systemEventsBreadcrumbsIntegration.z);
                return;
            case 8:
                ((AnrProfilingIntegration) this.f).X = SystemClock.uptimeMillis();
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ((io.sentry.internal.modules.f) this.f).a();
                return;
            case 10:
                NativeScope.nativeRemoveTag((String) this.f);
                return;
            case 11:
                b7 b7Var = (b7) this.f;
                NativeScope.nativeSetTrace(b7Var.b.a(), b7Var.f.a());
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                ReplayIntegration replayIntegration = (ReplayIntegration) this.f;
                g41 g41Var = g41.b;
                SentryAndroidOptions sentryAndroidOptions = replayIntegration.A;
                if (sentryAndroidOptions == null) {
                    n12.T("options");
                    throw null;
                }
                io.sentry.cache.e eVarFindPersistingScopeObserver = sentryAndroidOptions.findPersistingScopeObserver();
                if (eVarFindPersistingScopeObserver != null) {
                    SentryAndroidOptions sentryAndroidOptions2 = replayIntegration.A;
                    if (sentryAndroidOptions2 == null) {
                        n12.T("options");
                        throw null;
                    }
                    String str2 = (String) eVarFindPersistingScopeObserver.b(sentryAndroidOptions2, "replay.json", String.class);
                    if (str2 != null) {
                        io.sentry.protocol.w wVar = new io.sentry.protocol.w(str2);
                        if (wVar.equals(io.sentry.protocol.w.f)) {
                            replayIntegration.c0("");
                            return;
                        }
                        SentryAndroidOptions sentryAndroidOptions3 = replayIntegration.A;
                        if (sentryAndroidOptions3 == null) {
                            n12.T("options");
                            throw null;
                        }
                        String cacheDirPath = sentryAndroidOptions3.getCacheDirPath();
                        if (cacheDirPath == null || cacheDirPath.length() == 0) {
                            sentryAndroidOptions3.getLogger().h(p5.WARNING, "SentryOptions.cacheDirPath is not set, session replay is no-op", new Object[0]);
                            file = null;
                        } else {
                            String cacheDirPath2 = sentryAndroidOptions3.getCacheDirPath();
                            cacheDirPath2.getClass();
                            file = new File(cacheDirPath2, "replay_" + wVar);
                            file.mkdirs();
                        }
                        File file2 = new File(file, ".ongoing_segment");
                        if (file2.exists()) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2), y30.a), 8192);
                            try {
                                Iterator it = new kb0(new j70(1, bufferedReader)).iterator();
                                while (it.hasNext()) {
                                    Throwable th4 = th2;
                                    List listL0 = p44.L0((String) it.next(), new String[]{"="}, 2);
                                    linkedHashMap.put((String) listL0.get(0), (String) listL0.get(1));
                                    th2 = th4;
                                    break;
                                }
                                th = th2;
                                bufferedReader.close();
                                String str3 = (String) linkedHashMap.get("config.height");
                                Object objM0 = str3 != null ? w44.m0(str3) : th;
                                String str4 = (String) linkedHashMap.get("config.width");
                                ?? M0 = str4 != null ? w44.m0(str4) : th;
                                String str5 = (String) linkedHashMap.get("config.frame-rate");
                                ?? M02 = str5 != null ? w44.m0(str5) : th;
                                String str6 = (String) linkedHashMap.get("config.bit-rate");
                                ?? M03 = str6 != null ? w44.m0(str6) : th;
                                String str7 = (String) linkedHashMap.get("segment.id");
                                ?? M04 = str7 != null ? w44.m0(str7) : th;
                                try {
                                    String str8 = (String) linkedHashMap.get("segment.timestamp");
                                    if (str8 == null) {
                                        str8 = "";
                                    }
                                    objH = io.sentry.config.a.h(str8);
                                } catch (Throwable unused) {
                                    objH = th;
                                }
                                try {
                                    String str9 = (String) linkedHashMap.get("replay.type");
                                    if (str9 == null) {
                                        str9 = "";
                                    }
                                    objValueOf = q6.valueOf(str9);
                                } catch (Throwable unused2) {
                                    objValueOf = th;
                                }
                                if (objM0 == null || M0 == 0 || M02 == 0 || M03 == 0 || M04 == 0) {
                                    str = "options";
                                    sentryAndroidOptions3.getLogger().h(p5.DEBUG, "Incorrect segment values found for replay: %s, deleting the replay", wVar);
                                    io.sentry.util.b.g(file);
                                    dVar = th;
                                } else {
                                    ?? r32 = objM0;
                                    Object obj = objH;
                                    if (M04.intValue() != -1 && obj != null && objValueOf != null) {
                                        io.sentry.android.replay.v vVar = new io.sentry.android.replay.v(M0.intValue(), r32.intValue(), 1.0f, 1.0f, M02.intValue(), M03.intValue());
                                        io.sentry.android.replay.j jVar = new io.sentry.android.replay.j(sentryAndroidOptions3, wVar);
                                        ArrayList arrayList = jVar.z0;
                                        File fileS = jVar.s();
                                        if (fileS != null) {
                                            str = "options";
                                            i = 1;
                                            fileS.listFiles(new io.sentry.x(i, jVar));
                                        } else {
                                            str = "options";
                                            i = 1;
                                        }
                                        if (arrayList.isEmpty()) {
                                            ILogger logger = sentryAndroidOptions3.getLogger();
                                            p5 p5Var = p5.DEBUG;
                                            Object[] objArr = new Object[i];
                                            objArr[0] = wVar;
                                            logger.h(p5Var, "No frames found for replay: %s, deleting the replay", objArr);
                                            io.sentry.util.b.g(file);
                                        } else {
                                            if (arrayList.size() > i) {
                                                h70.T(arrayList, new io.sentry.android.replay.f(i2));
                                            }
                                            String str10 = (String) linkedHashMap.get("replay.flushed");
                                            boolean zC = str10 != null ? n12.c(str10.equals("true") ? Boolean.TRUE : str10.equals("false") ? Boolean.FALSE : th, Boolean.TRUE) : false;
                                            q6 q6Var = q6.SESSION;
                                            int iIntValue = (objValueOf == q6Var || zC) ? M04.intValue() : 0;
                                            ?? date = objValueOf == q6Var ? obj : new Date(((io.sentry.android.replay.k) d70.d0(arrayList)).b);
                                            long time = (((io.sentry.android.replay.k) d70.k0(arrayList)).b - date.getTime()) + ((long) (1000 / M02.intValue()));
                                            String str11 = (String) linkedHashMap.get("replay.recording");
                                            if (str11 == null) {
                                                linkedList = g41Var;
                                                dVar = new io.sentry.android.replay.d(vVar, jVar, date, iIntValue, time, objValueOf, (String) linkedHashMap.get("replay.screen-at-start"), d70.u0(linkedList, new io.sentry.android.replay.f(1)));
                                            } else {
                                                b4 b4Var = (b4) sentryAndroidOptions3.getSerializer().b(new StringReader(str11), b4.class);
                                                if ((b4Var != null ? b4Var.f : th) != null) {
                                                    List list = b4Var.f;
                                                    list.getClass();
                                                    linkedList = new LinkedList(list);
                                                } else {
                                                    linkedList = th;
                                                }
                                                if (linkedList == 0) {
                                                }
                                                dVar = new io.sentry.android.replay.d(vVar, jVar, date, iIntValue, time, objValueOf, (String) linkedHashMap.get("replay.screen-at-start"), d70.u0(linkedList, new io.sentry.android.replay.f(1)));
                                            }
                                        }
                                    }
                                    dVar = th;
                                }
                                break;
                            } catch (Throwable th5) {
                                try {
                                    throw th5;
                                } catch (Throwable th6) {
                                    ez4.l(bufferedReader, th5);
                                    throw th6;
                                }
                            }
                        } else {
                            sentryAndroidOptions3.getLogger().h(p5.DEBUG, "No ongoing segment found for replay: %s", wVar);
                            io.sentry.util.b.g(file);
                            th = null;
                            str = "options";
                        }
                        if (dVar == 0) {
                            replayIntegration.c0("");
                            return;
                        }
                        SentryAndroidOptions sentryAndroidOptions4 = replayIntegration.A;
                        if (sentryAndroidOptions4 == null) {
                            n12.T(str);
                            throw th;
                        }
                        Object objB = eVarFindPersistingScopeObserver.b(sentryAndroidOptions4, "breadcrumbs.json", List.class);
                        ?? r19 = objB instanceof List ? (List) objB : th;
                        io.sentry.f1 f1Var = replayIntegration.X;
                        SentryAndroidOptions sentryAndroidOptions5 = replayIntegration.A;
                        if (sentryAndroidOptions5 == null) {
                            n12.T(str);
                            throw th;
                        }
                        long j = dVar.e;
                        Date date2 = dVar.c;
                        int i3 = dVar.d;
                        io.sentry.android.replay.v vVar2 = dVar.a;
                        io.sentry.android.replay.capture.l lVarA = io.sentry.android.replay.capture.i.a(f1Var, sentryAndroidOptions5, j, date2, wVar, i3, vVar2.b, vVar2.a, dVar.f, dVar.b, vVar2.e, vVar2.f, dVar.g, r19, new LinkedList(dVar.h), g41Var, g41Var);
                        if (lVarA instanceof io.sentry.android.replay.capture.j) {
                            io.sentry.l0 l0VarF = io.sentry.util.b.f(new io.sentry.android.replay.l());
                            io.sentry.android.replay.capture.j jVar2 = (io.sentry.android.replay.capture.j) lVarA;
                            io.sentry.f1 f1Var2 = replayIntegration.X;
                            if (f1Var2 != null) {
                                r6 r6Var = jVar2.a;
                                l0VarF.h = jVar2.b;
                                f1Var2.r(r6Var, l0VarF);
                            }
                        }
                        replayIntegration.c0(str2);
                        return;
                    }
                }
                replayIntegration.c0("");
                return;
            case 13:
                io.sentry.android.replay.s sVar = (io.sentry.android.replay.s) this.f;
                if (sVar.b.get()) {
                    return;
                }
                try {
                    Object value = io.sentry.android.replay.y.b.getValue();
                    if (value == null || (field = (Field) io.sentry.android.replay.y.c.getValue()) == null) {
                        return;
                    }
                    Object obj2 = field.get(value);
                    obj2.getClass();
                    ArrayList arrayList2 = (ArrayList) obj2;
                    io.sentry.util.a aVar2 = sVar.f;
                    aVar2.g();
                    try {
                        io.sentry.android.replay.r rVar = sVar.A;
                        rVar.addAll(arrayList2);
                        vf2.e(aVar2, null);
                        field.set(value, rVar);
                        return;
                    } finally {
                    }
                } catch (Throwable th7) {
                    Log.w("WindowManagerSpy", th7);
                    return;
                }
            case 14:
                io.sentry.cache.e eVar = (io.sentry.cache.e) this.f;
                try {
                    ((io.sentry.cache.tape.f) eVar.b.a()).clear();
                    return;
                } catch (IOException e) {
                    eVar.a.getLogger().d(p5.ERROR, "Failed to clear breadcrumbs from file queue", e);
                    return;
                }
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                io.sentry.logger.d dVar2 = (io.sentry.logger.d) this.f;
                dVar2.A.a(dVar2.b.getShutdownTimeoutMillis());
                return;
            case 16:
                cm2 cm2Var = (cm2) this.f;
                ((j5) cm2Var.X).a(((SentryAndroidOptions) cm2Var.f).getShutdownTimeoutMillis());
                return;
            default:
                io.sentry.android.core.internal.tombstone.c cVar = (io.sentry.android.core.internal.tombstone.c) this.f;
                Iterator it2 = ((CopyOnWriteArrayList) cVar.A).iterator();
                while (it2.hasNext()) {
                    ((io.sentry.transport.o) it2.next()).N(cVar);
                }
                return;
        }
    }

    public /* synthetic */ g(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj2;
    }
}
