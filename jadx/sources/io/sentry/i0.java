package io.sentry;

import defpackage.dw2;
import defpackage.ed;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements x0, io.sentry.logger.a {
    public final k4 b;

    public /* synthetic */ i0(k4 k4Var) {
        this.b = k4Var;
    }

    @Override // io.sentry.x0
    public io.sentry.protocol.w a(io.sentry.protocol.k kVar) {
        k4 k4Var = this.b;
        d1 d1Var = k4Var.e;
        io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
        if (!k4Var.isEnabled()) {
            k4Var.getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'captureFeedback' call is a no-op.", new Object[0]);
            return wVar;
        }
        if (kVar.b.isEmpty()) {
            k4Var.getOptions().getLogger().h(p5.WARNING, "captureFeedback called with empty message.", new Object[0]);
            return wVar;
        }
        try {
            return d1Var.v().k(kVar, d1Var);
        } catch (Throwable th) {
            k4Var.getOptions().getLogger().d(p5.ERROR, "Error while capturing feedback: " + kVar.b, th);
            return wVar;
        }
    }

    public HashMap b(d dVar, String str, Object... objArr) {
        HashMap map = new HashMap();
        k4 k4Var = this.b;
        Iterator it = k4Var.e.getAttributes().values().iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        String str2 = dVar.a;
        if (!"manual".equalsIgnoreCase(str2)) {
            map.put("sentry.origin", new io.sentry.protocol.n(r4.STRING, str2));
        }
        int i = 0;
        for (Object obj : objArr) {
            map.put(dw2.A(i, "sentry.message.parameter."), new io.sentry.protocol.n(r4.inferFrom(obj), obj));
            i++;
        }
        if (i > 0 && map.get("sentry.message.template") == null) {
            map.put("sentry.message.template", new io.sentry.protocol.n(r4.STRING, str));
        }
        io.sentry.protocol.u sdkVersion = k4Var.getOptions().getSdkVersion();
        if (sdkVersion != null) {
            r4 r4Var = r4.STRING;
            map.put("sentry.sdk.name", new io.sentry.protocol.n(r4Var, sdkVersion.b));
            map.put("sentry.sdk.version", new io.sentry.protocol.n(r4Var.apiName(), sdkVersion.f));
        }
        String environment = k4Var.getOptions().getEnvironment();
        if (environment != null) {
            map.put("sentry.environment", new io.sentry.protocol.n(r4.STRING, environment));
        }
        io.sentry.protocol.w wVarG = k4Var.e.g();
        io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
        if (wVar.equals(wVarG)) {
            io.sentry.protocol.w wVarG2 = k4Var.getOptions().getReplayController().g();
            if (!wVar.equals(wVarG2)) {
                map.put("sentry.replay_id", new io.sentry.protocol.n(r4.STRING, wVarG2.a()));
                map.put("sentry._internal.replay_is_buffering", new io.sentry.protocol.n(r4.BOOLEAN, Boolean.TRUE));
            }
        } else {
            map.put("sentry.replay_id", new io.sentry.protocol.n(r4.STRING, wVarG.a()));
        }
        String release = k4Var.getOptions().getRelease();
        if (release != null) {
            map.put("sentry.release", new io.sentry.protocol.n(r4.STRING, release));
        }
        if (!io.sentry.util.j.a) {
            p6 options = k4Var.getOptions();
            String serverName = options.getServerName();
            if (serverName != null) {
                map.put("server.address", new io.sentry.protocol.n(r4.STRING, serverName));
            } else if (options.isAttachServerName()) {
                o0 o0VarA = o0.a();
                if (o0VarA.c < System.currentTimeMillis() && o0VarA.d.compareAndSet(false, true)) {
                    o0VarA.b();
                }
                String str3 = o0VarA.b;
                if (str3 != null) {
                    map.put("server.address", new io.sentry.protocol.n(r4.STRING, str3));
                }
            }
        }
        io.sentry.protocol.j0 j0VarH = k4Var.e.H();
        if (j0VarH == null) {
            String distinctId = k4Var.getOptions().getDistinctId();
            if (distinctId != null) {
                map.put("user.id", new io.sentry.protocol.n(r4.STRING, distinctId));
                return map;
            }
        } else {
            String str4 = j0VarH.f;
            if (str4 != null) {
                map.put("user.id", new io.sentry.protocol.n(r4.STRING, str4));
            }
            String str5 = j0VarH.z;
            if (str5 != null) {
                map.put("user.name", new io.sentry.protocol.n(r4.STRING, str5));
            }
            String str6 = j0VarH.b;
            if (str6 != null) {
                map.put("user.email", new io.sentry.protocol.n(r4.STRING, str6));
            }
        }
        return map;
    }

    @Override // io.sentry.logger.a
    public void e(t5 t5Var, d dVar, String str, Object... objArr) {
        String str2;
        k4 k4Var = this.b;
        p6 options = k4Var.getOptions();
        d1 d1Var = k4Var.e;
        try {
            if (!k4Var.isEnabled()) {
                options.getLogger().h(p5.WARNING, "Instance is disabled and this 'logger' call is a no-op.", new Object[0]);
                return;
            }
            if (!options.getLogs().a) {
                options.getLogger().h(p5.WARNING, "Sentry Log is disabled and this 'logger' call is a no-op.", new Object[0]);
                return;
            }
            if (str == null) {
                return;
            }
            w4 w4VarA = options.getDateProvider().a();
            if (objArr.length == 0) {
                str2 = str;
            } else {
                try {
                    str2 = String.format(str, objArr);
                } catch (Throwable th) {
                    k4Var.getOptions().getLogger().d(p5.ERROR, "Error while running log through String.format", th);
                    str2 = str;
                }
            }
            x3 x3VarS = d1Var.s();
            n1 n1VarO = d1Var.o();
            if (n1VarO == null) {
                d1Var.B(new ed(29, d1Var, options));
            }
            io.sentry.protocol.w wVar = n1VarO == null ? (io.sentry.protocol.w) x3VarS.b : n1VarO.r().b;
            d7 d7Var = n1VarO == null ? (d7) x3VarS.c : n1VarO.r().f;
            r5 r5Var = new r5(wVar, Double.valueOf(w4VarA.d() / 1.0E9d), str2, t5Var);
            r5Var.f = d7Var;
            r5Var.Z = b(dVar, str, objArr);
            r5Var.Y = Integer.valueOf(t5Var.getSeverityNumber());
            d1Var.v().i(r5Var, d1Var);
        } catch (Throwable th2) {
            options.getLogger().d(p5.ERROR, "Error while capturing log event", th2);
        }
    }
}
