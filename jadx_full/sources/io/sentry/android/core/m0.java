package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.bx;
import defpackage.h6;
import defpackage.ha0;
import defpackage.i60;
import defpackage.sn;
import io.sentry.ILogger;
import io.sentry.b7;
import io.sentry.f5;
import io.sentry.g5;
import io.sentry.p4;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.DebugImage;
import io.sentry.r5;
import io.sentry.r6;
import io.sentry.s3;
import io.sentry.t3;
import io.sentry.t4;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements io.sentry.f0 {
    public final g5 A;
    public final io.sentry.cache.e X;
    public final List Y = Collections.singletonList(new k0(this));
    public final Context b;
    public final SentryAndroidOptions f;
    public final q0 z;

    public m0(SurfboardApp surfboardApp, q0 q0Var, SentryAndroidOptions sentryAndroidOptions) {
        Context applicationContext = surfboardApp.getApplicationContext();
        this.b = applicationContext != null ? applicationContext : surfboardApp;
        this.f = sentryAndroidOptions;
        this.z = q0Var;
        this.X = sentryAndroidOptions.findPersistingScopeObserver();
        this.A = new g5(new io.sentry.w(sentryAndroidOptions));
    }

    public final Object a(String str, Class cls, Object obj, l0 l0Var) {
        if (l0Var == l0.CURRENT || l0Var == l0.PERSISTED_WITH_CURRENT_FALLBACK) {
            return obj;
        }
        if (l0Var == l0.NONE) {
            return null;
        }
        return io.sentry.cache.a.c(this.f, ".options-cache", str, cls);
    }

    public final Object b(String str, Class cls, Object obj, l0 l0Var) {
        if (l0Var != l0.CURRENT) {
            if (l0Var == l0.NONE) {
                return null;
            }
            Object objC = io.sentry.cache.a.c(this.f, ".options-cache", str, cls);
            if (objC != null || l0Var == l0.PERSISTED) {
                return objC;
            }
        }
        return obj;
    }

    public final Object c(p6 p6Var, String str, Class cls) {
        io.sentry.cache.e eVar = this.X;
        if (eVar == null) {
            return null;
        }
        return eVar.b(p6Var, str, cls);
    }

    public final void d(t4 t4Var) {
        String str = t4Var.Y;
        io.sentry.protocol.e eVar = t4Var.f;
        if (str != null) {
            try {
                io.sentry.protocol.a aVarD = eVar.d();
                if (aVarD == null) {
                    aVarD = new io.sentry.protocol.a();
                }
                String strSubstring = str.substring(str.indexOf(64) + 1, str.indexOf(43));
                String strSubstring2 = str.substring(str.indexOf(43) + 1);
                aVarD.Y = strSubstring;
                aVarD.Z = strSubstring2;
                eVar.m(aVarD);
            } catch (Throwable unused) {
                this.f.getLogger().h(p5.WARNING, "Failed to parse release from scope cache: %s", str);
            }
        }
    }

    public final void e(t4 t4Var, l0 l0Var) {
        String str;
        String str2 = t4Var.C0;
        SentryAndroidOptions sentryAndroidOptions = this.f;
        if (str2 == null) {
            str2 = (String) b("dist.json", String.class, sentryAndroidOptions.getDist(), l0Var);
            t4Var.C0 = str2;
        }
        if (str2 != null || (str = t4Var.Y) == null) {
            return;
        }
        try {
            t4Var.C0 = str.substring(str.indexOf(43) + 1);
        } catch (Throwable unused) {
            sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to parse release from scope cache: %s", str);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:333|(1:335)(11:336|(1:338)|467|468|469|(0)|471|518|(0)|521|(0))|542|339|536|340|525|(10:342|343|344|345|346|544|347|540|348|349)(2:366|367)|368|(1:370)|(1:378)(9:380|(2:384|461)(4:385|(1:387)(6:389|(4:392|(1:602)(6:600|395|(5:397|(2:398|(2:400|(1:607)(1:403))(2:608|404))|405|(2:407|606)(2:408|605)|409)|604|410|603)|601|390)|599|411|(0)(1:414)|(9:417|(2:418|(9:420|(3:422|(6:424|(1:426)(1:427)|428|(1:430)|431|595)(2:432|594)|433)|593|434|(4:437|(2:439|597)(1:598)|440|435)|596|441|(2:443|591)(1:592)|444)(1:590))|445|(1:447)(1:448)|449|(1:451)(1:453)|452|454|(2:456|(1:458)(1:459))(1:460)))|388|(0))|469|(0)|471|518|(0)|521|(0))|379|468|469|(0)|471|518|(0)|521|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0761, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0762, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x0765, code lost:
    
        r20 = r8;
        r19 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x076a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x076b, code lost:
    
        r35 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0795, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x0796, code lost:
    
        r35 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x07aa, code lost:
    
        r3.getLogger().h(r10, "Could not delete ANR profile file", new java.lang.Object[0]);
        r19 = r19;
        r20 = r20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x07b6  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x08cb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0b3d  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0b4b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0bd5  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0be2  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x0be8  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x0bf5  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x0c01  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0209  */
    /* JADX WARN: Type inference failed for: r0v93, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v96 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v10 */
    /* JADX WARN: Type inference failed for: r19v11 */
    /* JADX WARN: Type inference failed for: r19v12 */
    /* JADX WARN: Type inference failed for: r19v13 */
    /* JADX WARN: Type inference failed for: r19v16 */
    /* JADX WARN: Type inference failed for: r19v17 */
    /* JADX WARN: Type inference failed for: r19v18 */
    /* JADX WARN: Type inference failed for: r19v19 */
    /* JADX WARN: Type inference failed for: r19v2, types: [io.sentry.hints.b] */
    /* JADX WARN: Type inference failed for: r19v20 */
    /* JADX WARN: Type inference failed for: r19v21 */
    /* JADX WARN: Type inference failed for: r19v22 */
    /* JADX WARN: Type inference failed for: r19v23 */
    /* JADX WARN: Type inference failed for: r19v24 */
    /* JADX WARN: Type inference failed for: r19v25 */
    /* JADX WARN: Type inference failed for: r19v26 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r19v8 */
    /* JADX WARN: Type inference failed for: r19v9 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v13 */
    /* JADX WARN: Type inference failed for: r20v14 */
    /* JADX WARN: Type inference failed for: r20v15 */
    /* JADX WARN: Type inference failed for: r20v16 */
    /* JADX WARN: Type inference failed for: r20v17 */
    /* JADX WARN: Type inference failed for: r20v18 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r20v9 */
    /* JADX WARN: Type inference failed for: r35v0, types: [io.sentry.android.core.m0] */
    /* JADX WARN: Type inference failed for: r35v1 */
    /* JADX WARN: Type inference failed for: r35v12 */
    /* JADX WARN: Type inference failed for: r35v13 */
    /* JADX WARN: Type inference failed for: r35v14 */
    /* JADX WARN: Type inference failed for: r35v15, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r35v16 */
    /* JADX WARN: Type inference failed for: r35v17 */
    /* JADX WARN: Type inference failed for: r35v2 */
    /* JADX WARN: Type inference failed for: r35v3 */
    /* JADX WARN: Type inference failed for: r35v4, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16, types: [io.sentry.protocol.e] */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [io.sentry.protocol.e] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // io.sentry.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final f5 n(f5 f5Var, io.sentry.l0 l0Var) {
        k0 k0Var;
        Context context;
        Long l;
        Long lValueOf;
        String str;
        io.sentry.hints.b bVar;
        boolean z;
        String str2;
        Long l2;
        Long lValueOf2;
        ?? r19;
        ?? r20;
        Context context2;
        PackageInfo packageInfoD;
        long j;
        long j2;
        k0 k0Var2;
        String str3;
        Class cls;
        String str4;
        File[] fileArr;
        String strA;
        SentryAndroidOptions sentryAndroidOptions;
        ?? r4;
        ?? r192;
        ?? r193;
        ?? r42;
        ArrayList arrayList;
        ArrayList arrayListD;
        List<io.sentry.protocol.a0> list;
        io.sentry.protocol.a aVarD;
        String cacheDirPath;
        long time;
        bx bxVar;
        ?? r202;
        ?? r194;
        ArrayList arrayList2;
        io.sentry.android.core.anr.a aVar;
        SentryAndroidOptions sentryAndroidOptions2;
        Iterator it;
        int i;
        HashMap map;
        StackTraceElement[] stackTraceElementArr;
        io.sentry.protocol.f fVar;
        String str5;
        ?? r35;
        ?? r203;
        ?? r195;
        int i2;
        String str6;
        DisplayMetrics displayMetrics;
        String strA2;
        io.sentry.protocol.c0 c0Var;
        ArrayList arrayList3;
        f5 f5Var2 = f5Var;
        Object objB = l0Var.b("sentry:typeCheckHint");
        boolean z2 = objB instanceof io.sentry.hints.b;
        SentryAndroidOptions sentryAndroidOptions3 = this.f;
        if (!z2) {
            sentryAndroidOptions3.getLogger().h(p5.WARNING, "The event is not Backfillable, but has been passed to BackfillingEventProcessor, skipping.", new Object[0]);
            return f5Var2;
        }
        io.sentry.hints.b bVar2 = (io.sentry.hints.b) objB;
        Iterator it2 = this.Y.iterator();
        while (true) {
            if (!it2.hasNext()) {
                k0Var = null;
                break;
            }
            k0Var = (k0) it2.next();
            k0Var.getClass();
            if (objB instanceof io.sentry.hints.a) {
                break;
            }
        }
        if (k0Var != null) {
            boolean zEquals = bVar2 instanceof io.sentry.hints.a ? "anr_background".equals(((io.sentry.hints.a) bVar2).e()) : false;
            m0 m0Var = k0Var.a;
            if (f5Var2.y0 == null) {
                f5Var2.y0 = "java";
            }
            if (f5Var2.d() == null) {
                io.sentry.protocol.o oVar = new io.sentry.protocol.o();
                if (bVar2.a()) {
                    oVar.b = "AppExitInfo";
                } else {
                    oVar.b = "HistoricalAppExitInfo";
                }
                ApplicationNotResponding applicationNotResponding = new ApplicationNotResponding(zEquals ? "Background ANR" : "ANR", Thread.currentThread());
                ArrayList<io.sentry.protocol.e0> arrayListE = f5Var2.e();
                if (arrayListE != null) {
                    for (io.sentry.protocol.e0 e0Var : arrayListE) {
                        String str7 = e0Var.z;
                        if (str7 != null && str7.equals("main")) {
                            break;
                        }
                    }
                    e0Var = null;
                    if (e0Var == null) {
                        e0Var = new io.sentry.protocol.e0();
                        e0Var.z0 = new io.sentry.protocol.c0();
                    }
                    m0Var.A.getClass();
                    c0Var = e0Var.z0;
                    if (c0Var != null) {
                        arrayList3 = new ArrayList(0);
                    } else {
                        ArrayList arrayList4 = new ArrayList(1);
                        arrayList4.add(g5.c(applicationNotResponding, oVar, e0Var.b, c0Var.b, true));
                        arrayList3 = arrayList4;
                    }
                    f5Var2.h(arrayList3);
                } else {
                    e0Var = null;
                    if (e0Var == null) {
                    }
                    m0Var.A.getClass();
                    c0Var = e0Var.z0;
                    if (c0Var != null) {
                    }
                    f5Var2.h(arrayList3);
                }
            }
        }
        io.sentry.protocol.e eVar = f5Var2.f;
        io.sentry.protocol.q qVarG = eVar.g();
        Context context3 = this.b;
        eVar.r(u0.c(context3, sentryAndroidOptions3).g);
        if (qVarG != null) {
            String str8 = qVarG.b;
            eVar.k(qVarG, (str8 == null || str8.isEmpty()) ? "os_1" : "os_" + str8.trim().toLowerCase(Locale.ROOT));
        }
        io.sentry.protocol.h hVarE = eVar.e();
        String str9 = "Error getting installationId.";
        q0 q0Var = this.z;
        if (hVarE == null) {
            io.sentry.protocol.h hVar = new io.sentry.protocol.h();
            hVar.f = Build.MANUFACTURER;
            hVar.z = Build.BRAND;
            hVar.A = p0.a(sentryAndroidOptions3.getLogger());
            hVar.X = Build.MODEL;
            hVar.Y = Build.ID;
            hVar.Z = Build.SUPPORTED_ABIS;
            ActivityManager.MemoryInfo memoryInfoB = p0.b(context3, sentryAndroidOptions3.getLogger());
            context = context3;
            if (memoryInfoB != null) {
                hVar.D0 = Long.valueOf(memoryInfoB.totalMem);
            }
            hVar.C0 = q0Var.a();
            ILogger logger = sentryAndroidOptions3.getLogger();
            try {
                displayMetrics = context.getResources().getDisplayMetrics();
            } catch (Throwable th) {
                logger.d(p5.ERROR, "Error getting DisplayMetrics.", th);
                displayMetrics = null;
            }
            if (displayMetrics != null) {
                hVar.L0 = Integer.valueOf(displayMetrics.widthPixels);
                hVar.M0 = Integer.valueOf(displayMetrics.heightPixels);
                hVar.N0 = Float.valueOf(displayMetrics.density);
                hVar.O0 = Integer.valueOf(displayMetrics.densityDpi);
            }
            if (hVar.R0 == null) {
                try {
                    strA2 = y0.a(context);
                } catch (Throwable th2) {
                    sentryAndroidOptions3.getLogger().d(p5.ERROR, "Error getting installationId.", th2);
                    strA2 = null;
                }
                hVar.R0 = strA2;
            }
            ArrayList arrayListA = io.sentry.android.core.internal.util.e.c.a();
            if (!arrayListA.isEmpty()) {
                hVar.W0 = Double.valueOf(((Integer) Collections.max(arrayListA)).doubleValue());
                hVar.V0 = Integer.valueOf(arrayListA.size());
            }
            eVar.o(hVar);
        } else {
            context = context3;
        }
        boolean z3 = bVar2 instanceof io.sentry.hints.a;
        if (z3) {
            lValueOf = ((io.sentry.hints.a) bVar2).b();
        } else if (bVar2 instanceof io.sentry.hints.g) {
            lValueOf = Long.valueOf(((f2) ((io.sentry.hints.g) bVar2)).A);
        } else {
            l = null;
            str = (String) io.sentry.cache.a.c(sentryAndroidOptions3, ".options-cache", "app-last-update-time.json", String.class);
            if (str == null) {
                try {
                    lValueOf2 = Long.valueOf(str);
                    r19 = bVar2;
                    r20 = z3;
                    str2 = "ANR";
                    l2 = l;
                    context2 = context;
                } catch (NumberFormatException e) {
                    bVar = bVar2;
                    z = z3;
                    str2 = "ANR";
                    l2 = l;
                    sentryAndroidOptions3.getLogger().b(p5.ERROR, e, "Failed to read options cache generation.", new Object[0]);
                    context2 = context;
                    lValueOf2 = null;
                    r19 = bVar;
                    r20 = z;
                }
                packageInfoD = p0.d(context2, q0Var);
                if (packageInfoD == null) {
                    j2 = 0;
                    j = 0;
                } else {
                    j = 0;
                    j2 = packageInfoD.lastUpdateTime;
                }
                l0 l0Var2 = (l2 == null || j2 <= j || j2 > l2.longValue()) ? lValueOf2 != null ? l0.PERSISTED : (l2 == null || lValueOf2.longValue() <= j || lValueOf2.longValue() > l2.longValue()) ? l0.NONE : l0.PERSISTED : (lValueOf2 == null || lValueOf2.longValue() != j2) ? l0.CURRENT : l0.PERSISTED_WITH_CURRENT_FALLBACK;
                if (!r19.a()) {
                    if (f5Var2.Y == null) {
                        f5Var2.Y = (String) b("release.json", String.class, sentryAndroidOptions3.getRelease(), l0Var2);
                    }
                    if (f5Var2.Z == null) {
                        f5Var2.Z = (String) b("environment.json", String.class, sentryAndroidOptions3.getEnvironment(), l0Var2);
                    }
                    e(f5Var2, l0Var2);
                    d(f5Var);
                    sentryAndroidOptions3.getLogger().h(p5.DEBUG, "The event is Backfillable, but should not be enriched, skipping.", new Object[0]);
                    return f5Var2;
                }
                if (f5Var2.A == null) {
                    f5Var2.A = (io.sentry.protocol.r) c(sentryAndroidOptions3, "request.json", io.sentry.protocol.r.class);
                }
                if (f5Var2.z0 == null) {
                    f5Var2.z0 = (io.sentry.protocol.j0) c(sentryAndroidOptions3, "user.json", io.sentry.protocol.j0.class);
                }
                Map map2 = (Map) c(sentryAndroidOptions3, "tags.json", Map.class);
                if (map2 == null) {
                    k0Var2 = k0Var;
                } else {
                    k0Var2 = k0Var;
                    if (f5Var2.X == null) {
                        f5Var2.c(new HashMap(map2));
                    } else {
                        Iterator it3 = map2.entrySet().iterator();
                        while (it3.hasNext()) {
                            Map.Entry entry = (Map.Entry) it3.next();
                            Iterator it4 = it3;
                            if (!f5Var2.X.containsKey(entry.getKey())) {
                                f5Var2.b((String) entry.getKey(), (String) entry.getValue());
                            }
                            it3 = it4;
                        }
                    }
                }
                List list2 = (List) c(sentryAndroidOptions3, "breadcrumbs.json", List.class);
                if (list2 == null) {
                    str3 = "anr_background";
                } else {
                    str3 = "anr_background";
                    List list3 = f5Var2.D0;
                    if (list3 == null) {
                        f5Var2.D0 = new ArrayList(list2);
                    } else {
                        list3.addAll(list2);
                    }
                }
                Map map3 = (Map) c(sentryAndroidOptions3, "extras.json", Map.class);
                if (map3 != null) {
                    if (f5Var2.F0 == null) {
                        f5Var2.F0 = new HashMap(new HashMap(map3));
                    } else {
                        Iterator it5 = map3.entrySet().iterator();
                        while (it5.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it5.next();
                            Iterator it6 = it5;
                            if (f5Var2.F0.containsKey(entry2.getKey())) {
                                str6 = str9;
                            } else {
                                str6 = str9;
                                f5Var2.F0.put((String) entry2.getKey(), entry2.getValue());
                            }
                            it5 = it6;
                            str9 = str6;
                        }
                    }
                }
                String str10 = str9;
                io.sentry.protocol.e eVar2 = (io.sentry.protocol.e) c(sentryAndroidOptions3, "contexts.json", io.sentry.protocol.e.class);
                if (eVar2 != null) {
                    Iterator it7 = new io.sentry.protocol.e(eVar2).b.entrySet().iterator();
                    while (it7.hasNext()) {
                        Map.Entry entry3 = (Map.Entry) it7.next();
                        Object value = entry3.getValue();
                        Iterator it8 = it7;
                        if ((!"trace".equals(entry3.getKey()) || !(value instanceof b7)) && !eVar.a(entry3.getKey())) {
                            eVar.k(value, (String) entry3.getKey());
                        }
                        it7 = it8;
                    }
                }
                String str11 = (String) c(sentryAndroidOptions3, "transaction.json", String.class);
                if (f5Var2.M0 == null) {
                    f5Var2.M0 = str11;
                }
                List list4 = (List) c(sentryAndroidOptions3, "fingerprint.json", List.class);
                if (f5Var2.N0 == null) {
                    f5Var2.N0 = list4 != null ? new ArrayList(list4) : null;
                }
                p5 p5Var = (p5) c(sentryAndroidOptions3, "level.json", p5.class);
                if (f5Var2.L0 == null) {
                    f5Var2.L0 = p5Var;
                }
                b7 b7Var = (b7) c(sentryAndroidOptions3, "trace.json", b7.class);
                if (eVar.i() == null && b7Var != null) {
                    eVar.v(b7Var);
                }
                String str12 = (String) c(sentryAndroidOptions3, "replay.json", String.class);
                String cacheDirPath2 = sentryAndroidOptions3.getCacheDirPath();
                if (cacheDirPath2 == null) {
                    cls = Map.class;
                    str4 = "tags.json";
                } else {
                    cls = Map.class;
                    str4 = "tags.json";
                    if (!new File(cacheDirPath2, ha0.n("replay_", str12)).exists()) {
                        Double d = sentryAndroidOptions3.getSessionReplay().e;
                        String str13 = (String) b("replay-error-sample-rate.json", String.class, d == null ? null : d.toString(), l0Var2);
                        if (str13 != null) {
                            try {
                                if (Double.parseDouble(str13) < io.sentry.util.n.a().c()) {
                                    sentryAndroidOptions3.getLogger().h(p5.DEBUG, "Not capturing replay for ANR %s due to not being sampled.", f5Var2.b);
                                } else {
                                    File[] fileArrListFiles = new File(cacheDirPath2).listFiles();
                                    if (fileArrListFiles != null) {
                                        int length = fileArrListFiles.length;
                                        long jLastModified = Long.MIN_VALUE;
                                        String strSubstring = null;
                                        int i3 = 0;
                                        while (i3 < length) {
                                            File file = fileArrListFiles[i3];
                                            if (file.isDirectory()) {
                                                fileArr = fileArrListFiles;
                                                if (file.getName().startsWith("replay_") && file.lastModified() > jLastModified && file.lastModified() <= f5Var2.G0.getTime()) {
                                                    jLastModified = file.lastModified();
                                                    strSubstring = file.getName().substring(7);
                                                }
                                            } else {
                                                fileArr = fileArrListFiles;
                                            }
                                            i3++;
                                            fileArrListFiles = fileArr;
                                        }
                                        str12 = strSubstring;
                                    } else {
                                        str12 = null;
                                    }
                                    if (str12 != null) {
                                    }
                                }
                            } catch (Throwable th3) {
                                sentryAndroidOptions3.getLogger().d(p5.ERROR, "Error parsing replay sample rate.", th3);
                            }
                        }
                    } else if (str12 != null) {
                        Charset charset = io.sentry.cache.e.c;
                        io.sentry.cache.a.d(sentryAndroidOptions3, str12, ".scope-cache", "replay.json");
                        eVar.k(str12, "replay_id");
                    }
                }
                if (f5Var2.Y == null) {
                    f5Var2.Y = (String) b("release.json", String.class, sentryAndroidOptions3.getRelease(), l0Var2);
                }
                if (f5Var2.Z == null) {
                    f5Var2.Z = (String) b("environment.json", String.class, sentryAndroidOptions3.getEnvironment(), l0Var2);
                }
                e(f5Var2, l0Var2);
                io.sentry.protocol.f fVar2 = f5Var2.E0;
                if (fVar2 == null) {
                    fVar2 = new io.sentry.protocol.f();
                }
                if (fVar2.f == null) {
                    fVar2.b(new ArrayList());
                }
                List list5 = fVar2.f;
                String str14 = DebugImage.PROGUARD;
                String str15 = "proguard-uuid.json";
                if (list5 != null) {
                    String str16 = (String) a("proguard-uuid.json", String.class, sentryAndroidOptions3.getProguardUuid(), l0Var2);
                    if (str16 != null) {
                        DebugImage debugImage = new DebugImage();
                        debugImage.setType(DebugImage.PROGUARD);
                        debugImage.setUuid(str16);
                        list5.add(debugImage);
                    }
                    f5Var2.E0 = fVar2;
                }
                if (f5Var2.z == null) {
                    f5Var2.z = (io.sentry.protocol.u) a("sdk-version.json", io.sentry.protocol.u.class, sentryAndroidOptions3.getSdkVersion(), l0Var2);
                }
                io.sentry.protocol.a aVarD2 = eVar.d();
                if (aVarD2 == null) {
                    aVarD2 = new io.sentry.protocol.a();
                }
                io.sentry.protocol.a aVar2 = aVarD2;
                aVar2.X = (String) p0.c.a(context2);
                PackageInfo packageInfoD2 = p0.d(context2, q0Var);
                if (packageInfoD2 != null) {
                    aVar2.b = packageInfoD2.packageName;
                }
                try {
                    sn snVar = u0.c(context2, sentryAndroidOptions3).f;
                    if (snVar != null) {
                        aVar2.C0 = Boolean.valueOf(snVar.b);
                        String[] strArr = (String[]) snVar.f;
                        if (strArr != null) {
                            aVar2.D0 = Arrays.asList(strArr);
                        }
                    }
                } catch (Throwable th4) {
                    sentryAndroidOptions3.getLogger().d(p5.ERROR, "Error getting split apks info.", th4);
                }
                eVar.m(aVar2);
                d(f5Var);
                Map map4 = (Map) b(str4, cls, sentryAndroidOptions3.getTags(), l0Var2);
                if (map4 != null) {
                    if (f5Var2.X == null) {
                        f5Var2.c(new HashMap(map4));
                    } else {
                        for (Map.Entry entry4 : map4.entrySet()) {
                            if (!f5Var2.X.containsKey(entry4.getKey())) {
                                f5Var2.b((String) entry4.getKey(), (String) entry4.getValue());
                            }
                        }
                    }
                }
                io.sentry.protocol.j0 j0Var = f5Var2.z0;
                if (j0Var == null) {
                    j0Var = new io.sentry.protocol.j0();
                    f5Var2.z0 = j0Var;
                }
                io.sentry.protocol.j0 j0Var2 = j0Var;
                if (j0Var2.f == null) {
                    try {
                        strA = y0.a(context2);
                    } catch (Throwable th5) {
                        sentryAndroidOptions3.getLogger().d(p5.ERROR, str10, th5);
                        strA = null;
                    }
                    j0Var2.f = strA;
                }
                if (j0Var2.A == null && sentryAndroidOptions3.isSendDefaultPii()) {
                    j0Var2.A = "{{auto}}";
                }
                try {
                    h6 h6Var = u0.c(context2, sentryAndroidOptions3).e;
                    if (h6Var != null) {
                        HashMap map5 = new HashMap();
                        map5.put("isSideLoaded", String.valueOf(h6Var.b));
                        String str17 = h6Var.c;
                        if (str17 != null) {
                            map5.put("installerStore", str17);
                        }
                        for (Map.Entry entry5 : map5.entrySet()) {
                            f5Var2.b((String) entry5.getKey(), (String) entry5.getValue());
                        }
                    }
                } catch (Throwable th6) {
                    sentryAndroidOptions3.getLogger().d(p5.ERROR, "Error getting side loaded info.", th6);
                }
                if (k0Var2 != null) {
                    boolean zEquals2 = r20 != 0 ? str3.equals(((io.sentry.hints.a) r19).e()) : false;
                    m0 m0Var2 = k0Var2.a;
                    SentryAndroidOptions sentryAndroidOptions4 = m0Var2.f;
                    if (!sentryAndroidOptions4.isAnrProfilingEnabled() || zEquals2 || (cacheDirPath = sentryAndroidOptions4.getCacheDirPath()) == null) {
                        sentryAndroidOptions = sentryAndroidOptions4;
                        r4 = eVar;
                        r192 = zEquals2;
                        arrayList = null;
                        r42 = r4;
                        r193 = r192;
                        if (f5Var2.N0 == null) {
                            if (!sentryAndroidOptions.isEnableAnrFingerprinting() || (arrayListD = f5Var2.d()) == null || arrayListD.isEmpty()) {
                                List listAsList = Arrays.asList("{{ default }}", r193 != 0 ? "background-anr" : "foreground-anr");
                                f5Var2.N0 = listAsList == null ? new ArrayList(listAsList) : arrayList;
                            } else {
                                Iterator it9 = arrayListD.iterator();
                                while (it9.hasNext()) {
                                    io.sentry.protocol.c0 c0Var2 = ((io.sentry.protocol.v) it9.next()).X;
                                    if (c0Var2 != null && (list = c0Var2.b) != null && !list.isEmpty()) {
                                        for (io.sentry.protocol.a0 a0Var : list) {
                                            Boolean bool = a0Var.B0;
                                            if (bool == null || !bool.booleanValue()) {
                                                String str18 = a0Var.Y;
                                                if (str18 != null) {
                                                    Iterator it10 = io.sentry.android.core.anr.c.a.iterator();
                                                    while (it10.hasNext()) {
                                                        if (str18.startsWith((String) it10.next())) {
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            List listAsList2 = Arrays.asList("{{ default }}", r193 != 0 ? "background-anr" : "foreground-anr");
                                            f5Var2.N0 = listAsList2 == null ? new ArrayList(listAsList2) : arrayList;
                                        }
                                    }
                                }
                                List listAsList3 = Arrays.asList("system-frames-only-anr", r193 != 0 ? "background-anr" : "foreground-anr");
                                f5Var2.N0 = listAsList3 != null ? new ArrayList(listAsList3) : arrayList;
                            }
                        }
                        ?? r0 = r193 ^ 1;
                        aVarD = r42.d();
                        if (aVarD == null) {
                            aVarD = new io.sentry.protocol.a();
                            r42.m(aVarD);
                        }
                        if (aVarD.B0 == null) {
                            aVarD.B0 = Boolean.valueOf((boolean) r0);
                        }
                    } else {
                        File file2 = new File(cacheDirPath);
                        if (r20 != 0) {
                            Long lB = ((io.sentry.hints.a) r19).b();
                            if (lB != null) {
                                time = lB.longValue();
                            } else {
                                Date date = f5Var2.G0;
                                if (date != null) {
                                    time = date.getTime();
                                }
                                sentryAndroidOptions = sentryAndroidOptions4;
                                r4 = eVar;
                                r192 = zEquals2;
                                arrayList = null;
                                r42 = r4;
                                r193 = r192;
                                if (f5Var2.N0 == null) {
                                }
                                ?? r02 = r193 ^ 1;
                                aVarD = r42.d();
                                if (aVarD == null) {
                                }
                                if (aVarD.B0 == null) {
                                }
                            }
                            io.sentry.android.core.anr.e.b(file2);
                            File file3 = new File(file2, "anr_profile_old");
                            if (file3.exists()) {
                                this = file2;
                                r20 = eVar;
                                r19 = zEquals2;
                                sentryAndroidOptions4.getLogger().h(p5.DEBUG, "Reading ANR profile", new Object[0]);
                                io.sentry.android.core.anr.d dVar = new io.sentry.android.core.anr.d(sentryAndroidOptions4, file3);
                                try {
                                    bxVar = new bx(dVar.b.s());
                                    try {
                                        dVar.close();
                                        i2 = 0;
                                        r195 = r19;
                                        r203 = r20;
                                        r35 = this;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        try {
                                            ILogger logger2 = sentryAndroidOptions4.getLogger();
                                            p5 p5Var2 = p5.INFO;
                                            logger2.d(p5Var2, "Could not retrieve ANR profile", th);
                                            r194 = r19;
                                            r202 = r20;
                                            if (!io.sentry.android.core.anr.e.a(this)) {
                                            }
                                        } catch (Throwable th8) {
                                            if (!io.sentry.android.core.anr.e.a(this)) {
                                                sentryAndroidOptions4.getLogger().h(p5.INFO, "Could not delete ANR profile file", new Object[0]);
                                            }
                                            throw th8;
                                        }
                                    }
                                } finally {
                                }
                            } else {
                                r35 = file2;
                                r203 = eVar;
                                r195 = zEquals2;
                                i2 = 0;
                                sentryAndroidOptions4.getLogger().h(p5.DEBUG, "No ANR profile file found", new Object[0]);
                                bxVar = null;
                            }
                            r194 = r195;
                            r202 = r203;
                            if (!io.sentry.android.core.anr.e.a(r35)) {
                                sentryAndroidOptions4.getLogger().h(p5.INFO, "Could not delete ANR profile file", new Object[i2]);
                                r194 = r195;
                                r202 = r203;
                            }
                            if (bxVar == null) {
                                sentryAndroidOptions = sentryAndroidOptions4;
                            } else {
                                ArrayList arrayList5 = (ArrayList) bxVar.c;
                                sentryAndroidOptions4.getLogger().h(p5.INFO, "ANR profile found", new Object[0]);
                                if (time < bxVar.a || time > bxVar.b) {
                                    sentryAndroidOptions = sentryAndroidOptions4;
                                    r42 = r202;
                                    arrayList = null;
                                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "ANR profile found, but doesn't match", new Object[0]);
                                    r193 = r194;
                                } else {
                                    ArrayList arrayList6 = io.sentry.android.core.anr.c.a;
                                    if (arrayList5.isEmpty()) {
                                        arrayList2 = arrayList5;
                                        sentryAndroidOptions = sentryAndroidOptions4;
                                    } else {
                                        HashMap map6 = new HashMap();
                                        Iterator it11 = arrayList5.iterator();
                                        while (it11.hasNext()) {
                                            io.sentry.android.core.anr.f fVar3 = (io.sentry.android.core.anr.f) it11.next();
                                            StackTraceElement[] stackTraceElementArr2 = fVar3.b;
                                            if (stackTraceElementArr2.length >= 2) {
                                                int length2 = stackTraceElementArr2.length - 1;
                                                int i4 = 0;
                                                while (length2 >= 0) {
                                                    ArrayList arrayList7 = arrayList5;
                                                    String className = stackTraceElementArr2[length2].getClassName();
                                                    Iterator it12 = io.sentry.android.core.anr.c.a.iterator();
                                                    while (true) {
                                                        if (!it12.hasNext()) {
                                                            sentryAndroidOptions2 = sentryAndroidOptions4;
                                                            i4++;
                                                            break;
                                                        }
                                                        sentryAndroidOptions2 = sentryAndroidOptions4;
                                                        if (className.startsWith((String) it12.next())) {
                                                            break;
                                                        }
                                                        sentryAndroidOptions4 = sentryAndroidOptions2;
                                                    }
                                                    float length3 = i4 / (stackTraceElementArr2.length - length2);
                                                    io.sentry.android.core.anr.b bVar3 = new io.sentry.android.core.anr.b(stackTraceElementArr2, length2, stackTraceElementArr2.length - 1);
                                                    io.sentry.android.core.anr.a aVar3 = (io.sentry.android.core.anr.a) map6.get(bVar3);
                                                    if (aVar3 == null) {
                                                        it = it11;
                                                        i = length2;
                                                        map6.put(bVar3, new io.sentry.android.core.anr.a(fVar3.b, i, r3.length - 1, fVar3.f, length3));
                                                        map = map6;
                                                        stackTraceElementArr = stackTraceElementArr2;
                                                    } else {
                                                        it = it11;
                                                        StackTraceElement[] stackTraceElementArr3 = stackTraceElementArr2;
                                                        i = length2;
                                                        long j3 = fVar3.f;
                                                        map = map6;
                                                        stackTraceElementArr = stackTraceElementArr3;
                                                        aVar3.g = Math.min(aVar3.g, j3);
                                                        aVar3.h = Math.max(aVar3.h, j3);
                                                        aVar3.f++;
                                                    }
                                                    length2 = i - 1;
                                                    map6 = map;
                                                    it11 = it;
                                                    stackTraceElementArr2 = stackTraceElementArr;
                                                    sentryAndroidOptions4 = sentryAndroidOptions2;
                                                    arrayList5 = arrayList7;
                                                }
                                            }
                                        }
                                        arrayList2 = arrayList5;
                                        sentryAndroidOptions = sentryAndroidOptions4;
                                        HashMap map7 = map6;
                                        if (!map7.isEmpty()) {
                                            aVar = (io.sentry.android.core.anr.a) Collections.max(map7.values(), new i60(15));
                                        }
                                        if (aVar != null) {
                                            io.sentry.protocol.profiling.a aVar4 = new io.sentry.protocol.profiling.a();
                                            ArrayList arrayList8 = new ArrayList();
                                            HashMap map8 = new HashMap();
                                            ArrayList arrayList9 = new ArrayList();
                                            HashMap map9 = new HashMap();
                                            Iterator it13 = arrayList2.iterator();
                                            while (true) {
                                                Iterator it14 = it13;
                                                if (!it13.hasNext()) {
                                                    break;
                                                }
                                                StackTraceElement[] stackTraceElementArr4 = ((io.sentry.android.core.anr.f) it14.next()).b;
                                                io.sentry.android.core.anr.a aVar5 = aVar;
                                                ArrayList<Integer> arrayList10 = new ArrayList();
                                                String str19 = str14;
                                                int length4 = stackTraceElementArr4.length;
                                                int i5 = 0;
                                                while (i5 < length4) {
                                                    StackTraceElement stackTraceElement = stackTraceElementArr4[i5];
                                                    int i6 = i5;
                                                    StringBuilder sb = new StringBuilder();
                                                    int i7 = length4;
                                                    sb.append(stackTraceElement.getClassName());
                                                    sb.append("#");
                                                    l0 l0Var3 = l0Var2;
                                                    sb.append(stackTraceElement.getMethodName());
                                                    sb.append("#");
                                                    sb.append(stackTraceElement.getFileName());
                                                    sb.append("#");
                                                    sb.append(stackTraceElement.getLineNumber());
                                                    String string = sb.toString();
                                                    Integer numValueOf = (Integer) map8.get(string);
                                                    if (numValueOf == null) {
                                                        numValueOf = Integer.valueOf(arrayList8.size());
                                                        io.sentry.protocol.a0 a0Var2 = new io.sentry.protocol.a0();
                                                        str5 = str15;
                                                        a0Var2.A = stackTraceElement.getFileName();
                                                        a0Var2.X = stackTraceElement.getMethodName();
                                                        a0Var2.Y = stackTraceElement.getClassName();
                                                        a0Var2.Z = stackTraceElement.getLineNumber() > 0 ? Integer.valueOf(stackTraceElement.getLineNumber()) : null;
                                                        if (stackTraceElement.isNativeMethod()) {
                                                            a0Var2.D0 = Boolean.TRUE;
                                                        }
                                                        arrayList8.add(a0Var2);
                                                        map8.put(string, numValueOf);
                                                    } else {
                                                        str5 = str15;
                                                    }
                                                    arrayList10.add(numValueOf);
                                                    i5 = i6 + 1;
                                                    length4 = i7;
                                                    l0Var2 = l0Var3;
                                                    str15 = str5;
                                                }
                                                l0 l0Var4 = l0Var2;
                                                String str20 = str15;
                                                StringBuilder sb2 = new StringBuilder();
                                                for (Integer num : arrayList10) {
                                                    if (sb2.length() > 0) {
                                                        sb2.append(",");
                                                    }
                                                    sb2.append(num);
                                                }
                                                String string2 = sb2.toString();
                                                Integer numValueOf2 = (Integer) map9.get(string2);
                                                if (numValueOf2 == null) {
                                                    numValueOf2 = Integer.valueOf(arrayList9.size());
                                                    arrayList9.add(new ArrayList(arrayList10));
                                                    map9.put(string2, numValueOf2);
                                                }
                                                io.sentry.protocol.profiling.b bVar4 = new io.sentry.protocol.profiling.b();
                                                bVar4.b = r14.f / 1000.0d;
                                                bVar4.f = numValueOf2.intValue();
                                                bVar4.z = "0";
                                                aVar4.b.add(bVar4);
                                                it13 = it14;
                                                map8 = map8;
                                                aVar = aVar5;
                                                str14 = str19;
                                                l0Var2 = l0Var4;
                                                str15 = str20;
                                            }
                                            io.sentry.android.core.anr.a aVar6 = aVar;
                                            l0 l0Var5 = l0Var2;
                                            String str21 = str14;
                                            aVar4.z = arrayList8;
                                            aVar4.f = arrayList9;
                                            io.sentry.protocol.profiling.c cVar = new io.sentry.protocol.profiling.c();
                                            cVar.b = "main";
                                            cVar.f = 5;
                                            aVar4.A = Collections.singletonMap("0", cVar);
                                            s3 s3Var = new s3(new io.sentry.protocol.w(), new io.sentry.protocol.w(), null, new HashMap(0), Double.valueOf(time / 1000.0d), m0Var2.f);
                                            s3Var.E0 = aVar4;
                                            String str22 = (String) m0Var2.a(str15, String.class, sentryAndroidOptions.getProguardUuid(), l0Var5);
                                            if (str22 == null) {
                                                fVar = null;
                                            } else {
                                                fVar = new io.sentry.protocol.f();
                                                DebugImage debugImage2 = new DebugImage();
                                                debugImage2.setType(str21);
                                                debugImage2.setUuid(str22);
                                                fVar.b(Collections.singletonList(debugImage2));
                                            }
                                            s3Var.b = fVar;
                                            io.sentry.protocol.w wVar = io.sentry.protocol.w.f.equals(p4.c().h(s3Var)) ? null : s3Var.f;
                                            StackTraceElement[] stackTraceElementArr5 = (StackTraceElement[]) Arrays.copyOfRange(aVar6.c, aVar6.d, aVar6.e + 1);
                                            if (stackTraceElementArr5.length > 0) {
                                                StackTraceElement stackTraceElement2 = stackTraceElementArr5[0];
                                                ApplicationNotResponding applicationNotResponding2 = new ApplicationNotResponding(stackTraceElement2.getClassName() + "." + stackTraceElement2.getMethodName());
                                                applicationNotResponding2.setStackTrace(stackTraceElementArr5);
                                                io.sentry.protocol.o oVar2 = new io.sentry.protocol.o();
                                                oVar2.b = str2;
                                                arrayList = null;
                                                io.sentry.exception.a aVar7 = new io.sentry.exception.a(oVar2, applicationNotResponding2, null, false);
                                                g5 g5Var = m0Var2.A;
                                                g5Var.getClass();
                                                AtomicInteger atomicInteger = new AtomicInteger(-1);
                                                HashSet hashSet = new HashSet();
                                                ArrayDeque arrayDeque = new ArrayDeque();
                                                g5Var.a(aVar7, atomicInteger, hashSet, arrayDeque, null);
                                                f5Var2 = f5Var;
                                                f5Var2.h(new ArrayList(arrayDeque));
                                                if (wVar != null) {
                                                    ?? r43 = r202;
                                                    r43.k(new t3(wVar), "profile");
                                                    r42 = r43;
                                                    r193 = r194;
                                                } else {
                                                    r42 = r202;
                                                    r193 = r194;
                                                }
                                            } else {
                                                f5Var2 = f5Var;
                                            }
                                        }
                                    }
                                    aVar = null;
                                    if (aVar != null) {
                                    }
                                }
                                if (f5Var2.N0 == null) {
                                }
                                ?? r022 = r193 ^ 1;
                                aVarD = r42.d();
                                if (aVarD == null) {
                                }
                                if (aVarD.B0 == null) {
                                }
                            }
                            r4 = r202;
                            r192 = r194;
                            arrayList = null;
                            r42 = r4;
                            r193 = r192;
                            if (f5Var2.N0 == null) {
                            }
                            ?? r0222 = r193 ^ 1;
                            aVarD = r42.d();
                            if (aVarD == null) {
                            }
                            if (aVarD.B0 == null) {
                            }
                        }
                    }
                }
                return f5Var2;
            }
            bVar = bVar2;
            z = z3;
            str2 = "ANR";
            l2 = l;
            context2 = context;
            lValueOf2 = null;
            r19 = bVar;
            r20 = z;
            packageInfoD = p0.d(context2, q0Var);
            if (packageInfoD == null) {
            }
            l0 l0Var22 = (l2 == null || j2 <= j || j2 > l2.longValue()) ? lValueOf2 != null ? l0.PERSISTED : (l2 == null || lValueOf2.longValue() <= j || lValueOf2.longValue() > l2.longValue()) ? l0.NONE : l0.PERSISTED : (lValueOf2 == null || lValueOf2.longValue() != j2) ? l0.CURRENT : l0.PERSISTED_WITH_CURRENT_FALLBACK;
            if (!r19.a()) {
            }
        }
        l = lValueOf;
        str = (String) io.sentry.cache.a.c(sentryAndroidOptions3, ".options-cache", "app-last-update-time.json", String.class);
        if (str == null) {
        }
        context2 = context;
        lValueOf2 = null;
        r19 = bVar;
        r20 = z;
        packageInfoD = p0.d(context2, q0Var);
        if (packageInfoD == null) {
        }
        l0 l0Var222 = (l2 == null || j2 <= j || j2 > l2.longValue()) ? lValueOf2 != null ? l0.PERSISTED : (l2 == null || lValueOf2.longValue() <= j || lValueOf2.longValue() > l2.longValue()) ? l0.NONE : l0.PERSISTED : (lValueOf2 == null || lValueOf2.longValue() != j2) ? l0.CURRENT : l0.PERSISTED_WITH_CURRENT_FALLBACK;
        if (!r19.a()) {
        }
    }

    @Override // io.sentry.f0
    public final r5 x(r5 r5Var) {
        return r5Var;
    }

    @Override // io.sentry.f0
    public final r6 g(r6 r6Var, io.sentry.l0 l0Var) {
        return r6Var;
    }

    @Override // io.sentry.f0
    public final io.sentry.protocol.f0 s(io.sentry.protocol.f0 f0Var, io.sentry.l0 l0Var) {
        return f0Var;
    }
}
