package io.sentry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r6 extends t4 implements k2 {
    public File G0;
    public int K0;
    public Date M0;
    public HashMap R0;
    public io.sentry.protocol.w J0 = new io.sentry.protocol.w();
    public String H0 = "replay_event";
    public q6 I0 = q6.SESSION;
    public List O0 = new ArrayList();
    public List P0 = new ArrayList();
    public List Q0 = new ArrayList();
    public List N0 = new ArrayList();
    public Date L0 = new Date();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r6.class != obj.getClass()) {
            return false;
        }
        r6 r6Var = (r6) obj;
        return this.K0 == r6Var.K0 && io.sentry.util.b.i(this.H0, r6Var.H0) && this.I0 == r6Var.I0 && io.sentry.util.b.i(this.J0, r6Var.J0) && io.sentry.util.b.i(this.N0, r6Var.N0) && io.sentry.util.b.i(this.O0, r6Var.O0) && io.sentry.util.b.i(this.P0, r6Var.P0) && io.sentry.util.b.i(this.Q0, r6Var.Q0);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.H0, this.I0, this.J0, Integer.valueOf(this.K0), this.N0, this.O0, this.P0, this.Q0});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("type");
        cVar.y(this.H0);
        cVar.p("replay_type");
        cVar.v(iLogger, this.I0);
        cVar.p("segment_id");
        cVar.u(this.K0);
        cVar.p("timestamp");
        cVar.v(iLogger, this.L0);
        if (this.J0 != null) {
            cVar.p("replay_id");
            cVar.v(iLogger, this.J0);
        }
        if (this.M0 != null) {
            cVar.p("replay_start_timestamp");
            cVar.v(iLogger, this.M0);
        }
        if (this.N0 != null) {
            cVar.p("urls");
            cVar.v(iLogger, this.N0);
        }
        if (this.O0 != null) {
            cVar.p("error_ids");
            cVar.v(iLogger, this.O0);
        }
        if (this.P0 != null) {
            cVar.p("trace_ids");
            cVar.v(iLogger, this.P0);
        }
        if (this.Q0 != null) {
            cVar.p("segment_names");
            cVar.v(iLogger, this.Q0);
        }
        io.sentry.config.a.p(this, cVar, iLogger);
        HashMap map = this.R0;
        if (map != null) {
            for (String str : map.keySet()) {
                e.c(this.R0, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
