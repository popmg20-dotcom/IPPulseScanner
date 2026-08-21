package io.sentry.android.core;

import android.content.Context;
import com.getsurfboard.ui.SurfboardApp;
import io.sentry.g5;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.r5;
import io.sentry.r6;
import io.sentry.t4;
import java.util.Collections;
import java.util.List;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.sentry.f5 n(io.sentry.f5 r36, io.sentry.l0 r37) {
        /*
            Method dump skipped, instruction units count: 3080
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.m0.n(io.sentry.f5, io.sentry.l0):io.sentry.f5");
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
